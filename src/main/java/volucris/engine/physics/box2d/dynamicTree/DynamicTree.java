package volucris.engine.physics.box2d.dynamicTree;

import java.lang.foreign.Arena;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.StructLayout;
import java.lang.invoke.MethodHandle;

import volucris.engine.physics.box2d.geometry.RayCastInput;
import volucris.engine.physics.box2d.geometry.ShapeCastInput;
import volucris.engine.physics.box2d.math.AABB;
import volucris.engine.utils.VolucrisRuntimeException;

import static java.lang.foreign.ValueLayout.*;
import static volucris.engine.utils.FFMUtils.*;

/**
 * The dynamic tree is a binary AABB tree to organize and query large numbers of
 * geometric objects.
 * <p>
 * Box2D uses the dynamic tree internally to sort collision shapes into a binary
 * bounding volume hierarchy. This data structure may have uses in games for
 * organizing other geometry data and may be used independently of Box2D rigid
 * body simulation.
 * <p>
 * A dynamic AABB tree broad-phase, inspired by Nathanael Presson's btDbvt. A
 * dynamic tree arranges data in a binary tree to accelerate queries such as
 * AABB queries and ray casts. Leaf nodes are proxies with an AABB. These are
 * used to hold a user collision object. Nodes are pooled and relocatable, so I
 * use node indices rather than pointers. The dynamic tree is made available for
 * advanced users that would like to use it to organize spatial game data
 * besides rigid bodies.
 */
public final class DynamicTree {

	private static final StructLayout LAYOUT;

	private static final MethodHandle B2_DYNAMIC_TREE_CREATE;
	private static final MethodHandle B2_DYNAMIC_TREE_DESTROY;
	private static final MethodHandle B2_DYNAMIC_TREE_CREATE_PROXY;
	private static final MethodHandle B2_DYNAMIC_TREE_DESTROY_PROXY;
	private static final MethodHandle B2_DYNAMIC_TREE_MOVE_PROXY;
	private static final MethodHandle B2_DYNAMIC_TREE_ENLARGE_PROXY;
	private static final MethodHandle B2_DYNAMIC_TREE_SET_CATEGORY_BITS;
	private static final MethodHandle B2_DYNAMIC_TREE_GET_CATEGORY_BITS;
	private static final MethodHandle B2_DYNAMIC_TREE_QUERY;
	private static final MethodHandle B2_DYNAMIC_TREE_RAY_CAST;
	private static final MethodHandle B2_DYNAMIC_TREE_SHAPE_CAST;
	private static final MethodHandle B2_DYNAMIC_TREE_GET_HEIGHT;
	private static final MethodHandle B2_DYNAMIC_TREE_GET_AREA_RATIO;
	private static final MethodHandle B2_DYNAMIC_TREE_GET_ROOT_BOUNDS;
	private static final MethodHandle B2_DYNAMIC_TREE_GET_PROXY_COUNT;
	private static final MethodHandle B2_DYNAMIC_TREE_REBUILD;
	private static final MethodHandle B2_DYNAMIC_TREE_GET_BYTE_COUNT;
	private static final MethodHandle B2_DYNAMIC_TREE_GET_USER_DATA;
	private static final MethodHandle B2_DYNAMIC_TREE_GET_AABB;
	private static final MethodHandle B2_DYNAMIC_TREE_VALIDATE;
	private static final MethodHandle B2_DYNAMIC_TREE_VALIDATE_NO_ENLARGED;

	private final MemorySegment b2DynamicTree;

	static {
		//@formatter:off
		LAYOUT = MemoryLayout.structLayout(
		        ADDRESS.withName("nodes"),
		        JAVA_INT.withName("root"),
		        JAVA_INT.withName("nodeCount"),
		        JAVA_INT.withName("nodeCapacity"),
		        JAVA_INT.withName("freeList"),
		        JAVA_INT.withName("proxyCount"),
		        MemoryLayout.paddingLayout(4),
		        ADDRESS.withName("leafIndices"),
		        ADDRESS.withName("leafBoxes"),
		        ADDRESS.withName("leafCenters"),
		        ADDRESS.withName("binIndices"),
		        JAVA_INT.withName("rebuildCapacity"),
		        MemoryLayout.paddingLayout(4)
			).withName("b2DynamicTree");
		
		B2_DYNAMIC_TREE_CREATE = downcallHandle("b2DynamicTree_Create", LAYOUT);
		B2_DYNAMIC_TREE_DESTROY = downcallHandleVoid("b2DynamicTree_Destroy", ADDRESS);
		B2_DYNAMIC_TREE_CREATE_PROXY = downcallHandle("b2DynamicTree_CreateProxy", JAVA_INT, ADDRESS, AABB.LAYOUT(), JAVA_LONG, JAVA_LONG);
		B2_DYNAMIC_TREE_DESTROY_PROXY = downcallHandleVoid("b2DynamicTree_DestroyProxy", ADDRESS, JAVA_INT);
		B2_DYNAMIC_TREE_MOVE_PROXY = downcallHandleVoid("b2DynamicTree_MoveProxy", ADDRESS, JAVA_INT, AABB.LAYOUT());
		B2_DYNAMIC_TREE_ENLARGE_PROXY = downcallHandleVoid("b2DynamicTree_EnlargeProxy", ADDRESS, JAVA_INT, AABB.LAYOUT());
		B2_DYNAMIC_TREE_SET_CATEGORY_BITS = downcallHandleVoid("b2DynamicTree_SetCategoryBits", ADDRESS, JAVA_INT, JAVA_LONG);
		B2_DYNAMIC_TREE_GET_CATEGORY_BITS = downcallHandle("b2DynamicTree_GetCategoryBits", JAVA_LONG, ADDRESS, JAVA_INT);
		B2_DYNAMIC_TREE_QUERY = downcallHandle("b2DynamicTree_Query", TreeStats.LAYOUT(), ADDRESS, AABB.LAYOUT(), JAVA_LONG, ADDRESS, ADDRESS);
		B2_DYNAMIC_TREE_RAY_CAST = downcallHandle("b2DynamicTree_RayCast", TreeStats.LAYOUT(), ADDRESS, ADDRESS, JAVA_LONG, ADDRESS, ADDRESS);
		B2_DYNAMIC_TREE_SHAPE_CAST = downcallHandle("b2DynamicTree_ShapeCast", TreeStats.LAYOUT(), ADDRESS, ADDRESS, JAVA_LONG, ADDRESS, ADDRESS);
		B2_DYNAMIC_TREE_GET_HEIGHT = downcallHandle("b2DynamicTree_GetHeight", JAVA_INT, ADDRESS);
		B2_DYNAMIC_TREE_GET_AREA_RATIO = downcallHandle("b2DynamicTree_GetAreaRatio", JAVA_FLOAT, ADDRESS);
		B2_DYNAMIC_TREE_GET_ROOT_BOUNDS = downcallHandle("b2DynamicTree_GetRootBounds", AABB.LAYOUT(), ADDRESS);
		B2_DYNAMIC_TREE_GET_PROXY_COUNT = downcallHandle("b2DynamicTree_GetProxyCount", JAVA_INT, ADDRESS);
		B2_DYNAMIC_TREE_REBUILD = downcallHandle("b2DynamicTree_Rebuild", JAVA_INT, ADDRESS, JAVA_BOOLEAN);
		B2_DYNAMIC_TREE_GET_BYTE_COUNT = downcallHandle("b2DynamicTree_GetByteCount", JAVA_INT, ADDRESS);
		B2_DYNAMIC_TREE_GET_USER_DATA = downcallHandle("b2DynamicTree_GetUserData", JAVA_LONG, ADDRESS, JAVA_INT);
		B2_DYNAMIC_TREE_GET_AABB = downcallHandle("b2DynamicTree_GetAABB", AABB.LAYOUT(), ADDRESS, JAVA_INT);
		B2_DYNAMIC_TREE_VALIDATE = downcallHandleVoid("b2DynamicTree_Validate", ADDRESS);
		B2_DYNAMIC_TREE_VALIDATE_NO_ENLARGED = downcallHandleVoid("b2DynamicTree_ValidateNoEnlarged", ADDRESS);
		//@formatter:on
	}

	/**
	 * Constructing the tree initializes the node pool.
	 */
	public DynamicTree() {
		this(Arena.ofAuto());
	}

	/**
	 * Constructing the tree initializes the node pool.
	 */
	public DynamicTree(Arena arena) {
		try {
			MemorySegment segment = (MemorySegment) B2_DYNAMIC_TREE_CREATE.invoke(arena);
			b2DynamicTree = segment.reinterpret(arena, s -> destroy(s));
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot create dynamic tree.");
		}
	}

	/**
	 * 
	 */
	public void set(MemorySegment memorySegment) {
		MemorySegment.copy(memorySegment, 0L, b2DynamicTree, 0, LAYOUT.byteSize());
	}

	/**
	 * Destroy the tree, freeing the node pool.
	 */
	private static void destroy(MemorySegment segment) {
		try {
			B2_DYNAMIC_TREE_DESTROY.invokeExact(segment);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot destroy dynamic tree.");
		}
	}

	/**
	 * Create a proxy. Provide an AABB and a userData value.
	 */
	public int createProxy(AABB aabb, long categoryBits, long userData) {
		try {
			MemorySegment treeAddr = b2DynamicTree;
			MemorySegment aabbAddr = aabb.memorySegment();
			return (int) B2_DYNAMIC_TREE_CREATE_PROXY.invokeExact(treeAddr, aabbAddr, categoryBits, userData);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot create proxy.");
		}
	}

	/**
	 * Destroy a proxy. This asserts if the id is invalid.
	 */
	public void destroyProxy(int proxyId) {
		try {
			B2_DYNAMIC_TREE_DESTROY_PROXY.invokeExact(b2DynamicTree, proxyId);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot destroy proxy.");
		}
	}

	/**
	 * Move a proxy to a new AABB by removing and reinserting into the tree.
	 */
	public void moveProxy(int proxyId, AABB aabb) {
		try {
			B2_DYNAMIC_TREE_MOVE_PROXY.invokeExact(b2DynamicTree, proxyId, aabb.memorySegment());
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot move proxy.");
		}
	}

	/**
	 * Enlarge a proxy and enlarge ancestors as necessary.
	 */
	public void enlargeProxy(int proxyId, AABB aabb) {
		try {
			B2_DYNAMIC_TREE_ENLARGE_PROXY.invokeExact(b2DynamicTree, proxyId, aabb.memorySegment());
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot enlarge proxy.");
		}
	}

	/**
	 * Modify the category bits on a proxy. This is an expensive operation.
	 */
	public void setCategoryBits(int proxyId, long categoryBits) {
		try {
			B2_DYNAMIC_TREE_SET_CATEGORY_BITS.invokeExact(b2DynamicTree, proxyId, categoryBits);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot set category bits.");
		}
	}

	/**
	 * Get the category bits on a proxy.
	 */
	public long getCategoryBits(int proxyId) {
		try {
			return (long) B2_DYNAMIC_TREE_GET_CATEGORY_BITS.invokeExact(b2DynamicTree, proxyId);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot get proxy id.");
		}
	}

	/**
	 * Query an AABB for overlapping proxies. The callback class is called for each
	 * proxy that overlaps the supplied AABB.
	 */
	public TreeStats query(TreeStats target, AABB aabb, long maskBits, TreeQueryCallback callback,
			MemorySegment context) {
		try (Arena arena = Arena.ofConfined()) {
			MemorySegment aabbAddr = aabb.memorySegment();
			MemorySegment callbackAddr = callback.memorySegment();

			MethodHandle method = B2_DYNAMIC_TREE_QUERY;
			MemorySegment segment = (MemorySegment) method.invoke(arena, b2DynamicTree, aabbAddr, maskBits,
					callbackAddr, context);

			target.set(segment);
			return target;
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot query dynamic tree.");
		}
	}

	/**
	 * Query an AABB for overlapping proxies. The callback class is called for each
	 * proxy that overlaps the supplied AABB.
	 */
	public TreeStats query(AABB aabb, long maskBits, TreeQueryCallback callback, MemorySegment context) {
		return query(new TreeStats(), aabb, maskBits, callback, context);
	}

	/**
	 * Ray cast against the proxies in the tree. This relies on the callback to
	 * perform a exact ray cast in the case were the proxy contains a shape. The
	 * callback also performs the any collision filtering. This has performance
	 * roughly equal to k * log(n), where k is the number of collisions and n is the
	 * number of proxies in the tree. Bit-wise filtering using mask bits can greatly
	 * improve performance in some scenarios. However, this filtering may be
	 * approximate, so the user should still apply filtering to results.
	 */
	public TreeStats rayCast(TreeStats target, RayCastInput input, long maskBits, TreeRayCastCallback callback,
			MemorySegment context) {
		try (Arena arena = Arena.ofConfined()) {
			MemorySegment inputAddr = input.memorySegment();
			MemorySegment callbackAddr = callback.memorySegment();

			MethodHandle method = B2_DYNAMIC_TREE_RAY_CAST;
			MemorySegment segment = (MemorySegment) method.invoke(arena, b2DynamicTree, inputAddr, maskBits,
					callbackAddr, context);

			target.set(segment);
			return target;
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot ray cast dynamic tree.");
		}
	}

	/**
	 * Ray cast against the proxies in the tree. This relies on the callback to
	 * perform a exact ray cast in the case were the proxy contains a shape. The
	 * callback also performs the any collision filtering. This has performance
	 * roughly equal to k * log(n), where k is the number of collisions and n is the
	 * number of proxies in the tree. Bit-wise filtering using mask bits can greatly
	 * improve performance in some scenarios. However, this filtering may be
	 * approximate, so the user should still apply filtering to results.
	 */
	public TreeStats rayCast(RayCastInput input, long maskBits, TreeRayCastCallback callback, MemorySegment context) {
		return rayCast(new TreeStats(), input, maskBits, callback, context);
	}

	/**
	 * Ray cast against the proxies in the tree. This relies on the callback to
	 * perform a exact ray cast in the case were the proxy contains a shape. The
	 * callback also performs the any collision filtering. This has performance
	 * roughly equal to k * log(n), where k is the number of collisions and n is the
	 * number of proxies in the tree.
	 */
	public TreeStats shapeCast(TreeStats target, ShapeCastInput input, long maskBits, TreeShapeCastCallback callback,
			MemorySegment context) {
		try (Arena arena = Arena.ofConfined()) {
			MemorySegment inputAddr = input.memorySegment();
			MemorySegment callbackAddr = callback.memorySegment();

			MethodHandle method = B2_DYNAMIC_TREE_SHAPE_CAST;
			MemorySegment segment = (MemorySegment) method.invoke(arena, b2DynamicTree, inputAddr, maskBits,
					callbackAddr, context);

			target.set(segment);
			return target;
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot shape cast dynamic tree.");
		}
	}

	/**
	 * Ray cast against the proxies in the tree. This relies on the callback to
	 * perform a exact ray cast in the case were the proxy contains a shape. The
	 * callback also performs the any collision filtering. This has performance
	 * roughly equal to k * log(n), where k is the number of collisions and n is the
	 * number of proxies in the tree.
	 */
	public TreeStats shapeCast(ShapeCastInput input, long maskBits, TreeShapeCastCallback callback,
			MemorySegment context) {
		return shapeCast(new TreeStats(), input, maskBits, callback, context);
	}

	/**
	 * Get the height of the binary tree.
	 */
	public int getHeight() {
		try {
			return (int) B2_DYNAMIC_TREE_GET_HEIGHT.invokeExact(b2DynamicTree);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot get dynamic tree height.");
		}
	}

	/**
	 * Get the ratio of the sum of the node areas to the root area.
	 */
	public float getAreaRatio() {
		try {
			return (float) B2_DYNAMIC_TREE_GET_AREA_RATIO.invokeExact(b2DynamicTree);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot get dynamic tree area ratio.");
		}
	}

	/**
	 * Get the bounding box that contains the entire tree.
	 */
	public AABB getRootBounds(AABB target) {
		try (Arena arena = Arena.ofConfined()) {
			MethodHandle method = B2_DYNAMIC_TREE_GET_ROOT_BOUNDS;
			MemorySegment segment = (MemorySegment) method.invoke(arena, b2DynamicTree);
			target.set(segment);
			return target;
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot get root bounds.");
		}
	}

	/**
	 * Get the bounding box that contains the entire tree.
	 */
	public AABB getRootBounds() {
		return getRootBounds(new AABB());
	}

	/**
	 * Get the number of proxies created.
	 */
	public int getProxyCount() {
		try {
			return (int) B2_DYNAMIC_TREE_GET_PROXY_COUNT.invokeExact(b2DynamicTree);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Canot get proxy count.");
		}
	}

	/**
	 * Rebuild the tree while retaining subtrees that haven't changed. Returns the
	 * number of boxes sorted.
	 */
	public int rebuild(boolean fullBuild) {
		try {
			return (int) B2_DYNAMIC_TREE_REBUILD.invokeExact(b2DynamicTree, fullBuild);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot rebuild dynamic tree.");
		}
	}

	/**
	 * Get the number of bytes used by this tree.
	 */
	public int getByteCount() {
		try {
			return (int) B2_DYNAMIC_TREE_GET_BYTE_COUNT.invokeExact(b2DynamicTree);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot get byte count.");
		}
	}

	/**
	 * Get proxy user data.
	 */
	public long getUserData(int proxyId) {
		try {
			return (long) B2_DYNAMIC_TREE_GET_USER_DATA.invokeExact(b2DynamicTree, proxyId);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot get user data.");
		}
	}

	/**
	 * Get the AABB of a proxy.
	 */
	public AABB getAABB(AABB target, int proxyId) {
		try (Arena arena = Arena.ofConfined()) {
			MethodHandle method = B2_DYNAMIC_TREE_GET_AABB;
			MemorySegment segment = (MemorySegment) method.invoke(arena, b2DynamicTree, proxyId);
			target.set(segment);
			return target;
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot get aabb.");
		}
	}

	/**
	 * Get the AABB of a proxy.
	 */
	public AABB getAABB(int proxyId) {
		return getAABB(new AABB(), proxyId);
	}

	/**
	 * Validate this tree. For testing.
	 */
	public void validate() {
		try {
			B2_DYNAMIC_TREE_VALIDATE.invokeExact(b2DynamicTree);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot validate dynamic tree.");
		}
	}

	/**
	 * Validate this tree has no enlarged AABBs. For testing.
	 */
	public void validateNoEnlarged() {
		try {
			B2_DYNAMIC_TREE_VALIDATE_NO_ENLARGED.invokeExact(b2DynamicTree);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot validate no enlarged.");
		}
	}

	public MemorySegment memorySegment() {
		return b2DynamicTree;
	}

	public static StructLayout LAYOUT() {
		return LAYOUT;
	}

}
