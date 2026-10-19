/*
 * MACHINE GENERATED FILE, DO NOT EDIT.
 */
package volucris.bindings.box2d.dynamicTree;

import java.lang.foreign.MemorySegment;
import java.lang.foreign.SegmentAllocator;
import java.lang.invoke.MethodHandle;
import org.jspecify.annotations.Nullable;
import volucris.bindings.box2d.geometry.RayCastInput;
import volucris.bindings.box2d.math.AABB;

import static java.lang.foreign.ValueLayout.*;
import static volucris.bindings.core.FFMUtils.*;

public final class DynamicTreeFunctions {

	private static final LazyConstant<MethodHandle> B2_CREATE_DYNAMIC_TREE;
	private static final LazyConstant<MethodHandle> B2_DESTROY_DYNAMIC_TREE;
	private static final LazyConstant<MethodHandle> B2_CREATE_TREE_PROXY;
	private static final LazyConstant<MethodHandle> B2_DESTROY_TREE_PROXY;
	private static final LazyConstant<MethodHandle> B2_DYNAMIC_TREE_MOVE_PROXY;
	private static final LazyConstant<MethodHandle> B2_DYNAMIC_TREE_SET_CATEGORY_BITS;
	private static final LazyConstant<MethodHandle> B2_DYNAMIC_TREE_GET_CATEGORY_BITS;
	private static final LazyConstant<MethodHandle> B2_DYNAMIC_TREE_OVERLAP_AABB;
	private static final LazyConstant<MethodHandle> B2_DYNAMIC_TREE_OVERLAP_AABBALL;
	private static final LazyConstant<MethodHandle> B2_DYNAMIC_TREE_CAST_RAY;
	private static final LazyConstant<MethodHandle> B2_DYNAMIC_TREE_CAST_BOX;
	private static final LazyConstant<MethodHandle> B2_DYNAMIC_TREE_GET_HEIGHT;
	private static final LazyConstant<MethodHandle> B2_DYNAMIC_TREE_GET_AREA_RATIO;
	private static final LazyConstant<MethodHandle> B2_DYNAMIC_TREE_GET_ROOT_BOUNDS;
	private static final LazyConstant<MethodHandle> B2_DYNAMIC_TREE_GET_PROXY_COUNT;
	private static final LazyConstant<MethodHandle> B2_DYNAMIC_TREE_GET_BYTE_COUNT;
	private static final LazyConstant<MethodHandle> B2_DYNAMIC_TREE_GET_USER_DATA;
	private static final LazyConstant<MethodHandle> B2_DYNAMIC_TREE_GET_PROXY_BOUNDS;
	private static final LazyConstant<MethodHandle> B2_DYNAMIC_TREE_VALIDATE;

	static {
		//@formatter:off
		B2_CREATE_DYNAMIC_TREE = downcallHandle("b2CreateDynamicTree", UNBOUNDED_ADDRESS, JAVA_INT);
		B2_DESTROY_DYNAMIC_TREE = downcallHandleVoid("b2DestroyDynamicTree", UNBOUNDED_ADDRESS);
		B2_CREATE_TREE_PROXY = downcallHandle("b2CreateTreeProxy", JAVA_INT, UNBOUNDED_ADDRESS, AABB.LAYOUT, JAVA_LONG, JAVA_LONG);
		B2_DESTROY_TREE_PROXY = downcallHandleVoid("b2DestroyTreeProxy", UNBOUNDED_ADDRESS, JAVA_INT);
		B2_DYNAMIC_TREE_MOVE_PROXY = downcallHandleVoid("b2DynamicTree_MoveProxy", UNBOUNDED_ADDRESS, JAVA_INT, AABB.LAYOUT);
		B2_DYNAMIC_TREE_SET_CATEGORY_BITS = downcallHandleVoid("b2DynamicTree_SetCategoryBits", UNBOUNDED_ADDRESS, JAVA_INT, JAVA_LONG);
		B2_DYNAMIC_TREE_GET_CATEGORY_BITS = downcallHandle("b2DynamicTree_GetCategoryBits", JAVA_LONG, UNBOUNDED_ADDRESS, JAVA_INT);
		B2_DYNAMIC_TREE_OVERLAP_AABB = downcallHandle("b2DynamicTree_OverlapAABB", TreeStats.LAYOUT, UNBOUNDED_ADDRESS, AABB.LAYOUT, JAVA_LONG, UNBOUNDED_ADDRESS, UNBOUNDED_ADDRESS);
		B2_DYNAMIC_TREE_OVERLAP_AABBALL = downcallHandle("b2DynamicTree_OverlapAABBAll", TreeStats.LAYOUT, UNBOUNDED_ADDRESS, AABB.LAYOUT, UNBOUNDED_ADDRESS, UNBOUNDED_ADDRESS);
		B2_DYNAMIC_TREE_CAST_RAY = downcallHandle("b2DynamicTree_CastRay", TreeStats.LAYOUT, UNBOUNDED_ADDRESS, UNBOUNDED_ADDRESS, JAVA_LONG, UNBOUNDED_ADDRESS, UNBOUNDED_ADDRESS);
		B2_DYNAMIC_TREE_CAST_BOX = downcallHandle("b2DynamicTree_CastBox", TreeStats.LAYOUT, UNBOUNDED_ADDRESS, UNBOUNDED_ADDRESS, JAVA_LONG, UNBOUNDED_ADDRESS, UNBOUNDED_ADDRESS);
		B2_DYNAMIC_TREE_GET_HEIGHT = downcallHandle("b2DynamicTree_GetHeight", JAVA_INT, UNBOUNDED_ADDRESS);
		B2_DYNAMIC_TREE_GET_AREA_RATIO = downcallHandle("b2DynamicTree_GetAreaRatio", JAVA_FLOAT, UNBOUNDED_ADDRESS);
		B2_DYNAMIC_TREE_GET_ROOT_BOUNDS = downcallHandle("b2DynamicTree_GetRootBounds", AABB.LAYOUT, UNBOUNDED_ADDRESS);
		B2_DYNAMIC_TREE_GET_PROXY_COUNT = downcallHandle("b2DynamicTree_GetProxyCount", JAVA_INT, UNBOUNDED_ADDRESS);
		B2_DYNAMIC_TREE_GET_BYTE_COUNT = downcallHandle("b2DynamicTree_GetByteCount", JAVA_LONG, UNBOUNDED_ADDRESS);
		B2_DYNAMIC_TREE_GET_USER_DATA = downcallHandle("b2DynamicTree_GetUserData", JAVA_LONG, UNBOUNDED_ADDRESS, JAVA_INT);
		B2_DYNAMIC_TREE_GET_PROXY_BOUNDS = downcallHandle("b2DynamicTree_GetProxyBounds", AABB.LAYOUT, UNBOUNDED_ADDRESS, JAVA_INT);
		B2_DYNAMIC_TREE_VALIDATE = downcallHandleVoid("b2DynamicTree_Validate", UNBOUNDED_ADDRESS);
		//@formatter:on
	}

	private DynamicTreeFunctions() {
	}

    /// ```
    /// Constructing the tree initializes the node pool.
    /// ```
    public static MemorySegment ncreateDynamicTree(
    	int proxyCapacity
    ) {
    	MethodHandle method = B2_CREATE_DYNAMIC_TREE.get();
    	try {
    		return (MemorySegment) method.invokeExact(
    			proxyCapacity
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#ncreateDynamicTree].
    public static @Nullable DynamicTree createDynamicTree(
    	int proxyCapacity
    ) {
    	MemorySegment segment = ncreateDynamicTree(
    		proxyCapacity
    	);
    
    	if (segment.equals(MemorySegment.NULL))
    		return null;
    	
    	return new DynamicTree(segment);
    }
    
    /// ```
    /// Destroy the tree, freeing the node pool.
    /// ```
    public static void destroyDynamicTree(
    	MemorySegment tree
    ) {
    	MethodHandle method = B2_DESTROY_DYNAMIC_TREE.get();
    	try {
    		 method.invokeExact(
    			tree
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#destroyDynamicTree].
    public static void destroyDynamicTree(
    	DynamicTree tree
    ) {
    	destroyDynamicTree(
    		tree.memorySegment()
    	);
    }
    
    /// ```
    /// Create a proxy. Provide an AABB and a userData value.
    /// ```
    public static int createTreeProxy(
    	MemorySegment tree,
    	MemorySegment aabb,
    	long categoryBits,
    	long userData
    ) {
    	MethodHandle method = B2_CREATE_TREE_PROXY.get();
    	try {
    		return (int) method.invokeExact(
    			tree,
    			aabb,
    			categoryBits,
    			userData
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#createTreeProxy].
    public static int createTreeProxy(
    	DynamicTree tree,
    	AABB aabb,
    	long categoryBits,
    	long userData
    ) {
    	return createTreeProxy(
    		tree.memorySegment(),
    		aabb.memorySegment(),
    		categoryBits,
    		userData
    	);
    }
    
    /// ```
    /// Destroy a proxy. This asserts if the id is invalid.
    /// ```
    public static void destroyTreeProxy(
    	MemorySegment tree,
    	int proxyId
    ) {
    	MethodHandle method = B2_DESTROY_TREE_PROXY.get();
    	try {
    		 method.invokeExact(
    			tree,
    			proxyId
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#destroyTreeProxy].
    public static void destroyTreeProxy(
    	DynamicTree tree,
    	int proxyId
    ) {
    	destroyTreeProxy(
    		tree.memorySegment(),
    		proxyId
    	);
    }
    
    /// ```
    /// Move a proxy to a new AABB by removing and reinserting into the tree.
    /// ```
    public static void moveProxy(
    	MemorySegment tree,
    	int proxyId,
    	MemorySegment aabb
    ) {
    	MethodHandle method = B2_DYNAMIC_TREE_MOVE_PROXY.get();
    	try {
    		 method.invokeExact(
    			tree,
    			proxyId,
    			aabb
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#moveProxy].
    public static void moveProxy(
    	DynamicTree tree,
    	int proxyId,
    	AABB aabb
    ) {
    	moveProxy(
    		tree.memorySegment(),
    		proxyId,
    		aabb.memorySegment()
    	);
    }
    
    /// ```
    /// Modify the category bits on a proxy.
    /// ```
    public static void setCategoryBits(
    	MemorySegment tree,
    	int proxyId,
    	long categoryBits
    ) {
    	MethodHandle method = B2_DYNAMIC_TREE_SET_CATEGORY_BITS.get();
    	try {
    		 method.invokeExact(
    			tree,
    			proxyId,
    			categoryBits
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#setCategoryBits].
    public static void setCategoryBits(
    	DynamicTree tree,
    	int proxyId,
    	long categoryBits
    ) {
    	setCategoryBits(
    		tree.memorySegment(),
    		proxyId,
    		categoryBits
    	);
    }
    
    /// ```
    /// Get the category bits on a proxy.
    /// ```
    public static long getCategoryBits(
    	MemorySegment tree,
    	int proxyId
    ) {
    	MethodHandle method = B2_DYNAMIC_TREE_GET_CATEGORY_BITS.get();
    	try {
    		return (long) method.invokeExact(
    			tree,
    			proxyId
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#getCategoryBits].
    public static long getCategoryBits(
    	DynamicTree tree,
    	int proxyId
    ) {
    	return getCategoryBits(
    		tree.memorySegment(),
    		proxyId
    	);
    }
    
    /// ```
    /// Query an AABB for overlapping proxies. The callback is called for each proxy that overlaps the
    /// supplied AABB.
    /// @return performance data
    /// ```
    public static MemorySegment overlapAABB(
    	SegmentAllocator allocator,
    	MemorySegment tree,
    	MemorySegment aabb,
    	long maskBits,
    	MemorySegment callback,
    	MemorySegment context
    ) {
    	MethodHandle method = B2_DYNAMIC_TREE_OVERLAP_AABB.get();
    	try {
    		return (MemorySegment) method.invokeExact(
    			allocator,
    			tree,
    			aabb,
    			maskBits,
    			callback,
    			context
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#overlapAABB].
    public static @Nullable TreeStats overlapAABB(
    	SegmentAllocator allocator,
    	DynamicTree tree,
    	AABB aabb,
    	long maskBits,
    	TreeQueryCallbackFcn callback,
    	MemorySegment context
    ) {
    	MemorySegment segment = overlapAABB(
    		allocator,
    		tree.memorySegment(),
    		aabb.memorySegment(),
    		maskBits,
    		callback.memorySegment(),
    		context
    	);
    
    	if (segment.equals(MemorySegment.NULL))
    		return null;
    	
    	return new TreeStats(segment);
    }
    
    /// ```
    /// Query an AABB for overlapping proxies. The callback is called for each proxy that overlaps the
    /// supplied AABB. No filtering is performed.
    /// @return performance data
    /// ```
    public static MemorySegment overlapAABBAll(
    	SegmentAllocator allocator,
    	MemorySegment tree,
    	MemorySegment aabb,
    	MemorySegment callback,
    	MemorySegment context
    ) {
    	MethodHandle method = B2_DYNAMIC_TREE_OVERLAP_AABBALL.get();
    	try {
    		return (MemorySegment) method.invokeExact(
    			allocator,
    			tree,
    			aabb,
    			callback,
    			context
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#overlapAABBAll].
    public static @Nullable TreeStats overlapAABBAll(
    	SegmentAllocator allocator,
    	DynamicTree tree,
    	AABB aabb,
    	TreeQueryCallbackFcn callback,
    	MemorySegment context
    ) {
    	MemorySegment segment = overlapAABBAll(
    		allocator,
    		tree.memorySegment(),
    		aabb.memorySegment(),
    		callback.memorySegment(),
    		context
    	);
    
    	if (segment.equals(MemorySegment.NULL))
    		return null;
    	
    	return new TreeStats(segment);
    }
    
    /// ```
    /// Ray cast against the proxies in the tree. This relies on the callback to perform an exact ray
    /// cast in the case where the proxy contains a shape. The callback also performs any collision
    /// filtering. This has performance roughly equal to k * log(n), where k is the number of collisions
    /// and n is the number of proxies in the tree. Bit-wise filtering using mask bits can improve
    /// performance in some scenarios. However, this filtering may be approximate, so the user should
    /// still apply filtering to results.
    /// @param tree the dynamic tree to ray cast
    /// @param input the ray cast input data.
    /// @param maskBits mask bits used to filter proxies.
    /// @param callback a callback that is called for each proxy that is hit by the ray
    /// @param context user context that is passed to the callback
    /// @return performance data
    /// ```
    public static MemorySegment castRay(
    	SegmentAllocator allocator,
    	MemorySegment tree,
    	MemorySegment input,
    	long maskBits,
    	MemorySegment callback,
    	MemorySegment context
    ) {
    	MethodHandle method = B2_DYNAMIC_TREE_CAST_RAY.get();
    	try {
    		return (MemorySegment) method.invokeExact(
    			allocator,
    			tree,
    			input,
    			maskBits,
    			callback,
    			context
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#castRay].
    public static @Nullable TreeStats castRay(
    	SegmentAllocator allocator,
    	DynamicTree tree,
    	RayCastInput input,
    	long maskBits,
    	TreeRayCastCallbackFcn callback,
    	MemorySegment context
    ) {
    	MemorySegment segment = castRay(
    		allocator,
    		tree.memorySegment(),
    		input.memorySegment(),
    		maskBits,
    		callback.memorySegment(),
    		context
    	);
    
    	if (segment.equals(MemorySegment.NULL))
    		return null;
    	
    	return new TreeStats(segment);
    }
    
    /// ```
    /// Cast a swept AABB through the tree. This has performance roughly equal to k * log(n), where k is
    /// the number of collisions and n is the number of proxies in the tree.
    /// @param tree the dynamic tree to cast through
    /// @param input the AABB cast input. The box sweeps from its origin to origin + maxFraction *
    /// translation.
    /// @param maskBits filter bits: `bool accept = (maskBits & proxy->categoryBits) != 0;`
    /// @param callback a callback that is called for each proxy the swept box may hit
    /// @param context user context that is passed to the callback
    /// @return performance data
    /// ```
    public static MemorySegment castBox(
    	SegmentAllocator allocator,
    	MemorySegment tree,
    	MemorySegment input,
    	long maskBits,
    	MemorySegment callback,
    	MemorySegment context
    ) {
    	MethodHandle method = B2_DYNAMIC_TREE_CAST_BOX.get();
    	try {
    		return (MemorySegment) method.invokeExact(
    			allocator,
    			tree,
    			input,
    			maskBits,
    			callback,
    			context
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#castBox].
    public static @Nullable TreeStats castBox(
    	SegmentAllocator allocator,
    	DynamicTree tree,
    	BoxCastInput input,
    	long maskBits,
    	TreeBoxCastCallbackFcn callback,
    	MemorySegment context
    ) {
    	MemorySegment segment = castBox(
    		allocator,
    		tree.memorySegment(),
    		input.memorySegment(),
    		maskBits,
    		callback.memorySegment(),
    		context
    	);
    
    	if (segment.equals(MemorySegment.NULL))
    		return null;
    	
    	return new TreeStats(segment);
    }
    
    /// ```
    /// Get the height of the binary tree.
    /// ```
    public static int getHeight(
    	MemorySegment tree
    ) {
    	MethodHandle method = B2_DYNAMIC_TREE_GET_HEIGHT.get();
    	try {
    		return (int) method.invokeExact(
    			tree
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#getHeight].
    public static int getHeight(
    	DynamicTree tree
    ) {
    	return getHeight(
    		tree.memorySegment()
    	);
    }
    
    /// ```
    /// Get the ratio of the sum of the internal node areas to the root area.
    /// ```
    public static float getAreaRatio(
    	MemorySegment tree
    ) {
    	MethodHandle method = B2_DYNAMIC_TREE_GET_AREA_RATIO.get();
    	try {
    		return (float) method.invokeExact(
    			tree
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#getAreaRatio].
    public static float getAreaRatio(
    	DynamicTree tree
    ) {
    	return getAreaRatio(
    		tree.memorySegment()
    	);
    }
    
    /// ```
    /// Get the bounding box that contains the entire tree
    /// ```
    public static MemorySegment getRootBounds(
    	SegmentAllocator allocator,
    	MemorySegment tree
    ) {
    	MethodHandle method = B2_DYNAMIC_TREE_GET_ROOT_BOUNDS.get();
    	try {
    		return (MemorySegment) method.invokeExact(
    			allocator,
    			tree
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#getRootBounds].
    public static @Nullable AABB getRootBounds(
    	SegmentAllocator allocator,
    	DynamicTree tree
    ) {
    	MemorySegment segment = getRootBounds(
    		allocator,
    		tree.memorySegment()
    	);
    
    	if (segment.equals(MemorySegment.NULL))
    		return null;
    	
    	return new AABB(segment);
    }
    
    /// ```
    /// Get the number of proxies created
    /// ```
    public static int getProxyCount(
    	MemorySegment tree
    ) {
    	MethodHandle method = B2_DYNAMIC_TREE_GET_PROXY_COUNT.get();
    	try {
    		return (int) method.invokeExact(
    			tree
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#getProxyCount].
    public static int getProxyCount(
    	DynamicTree tree
    ) {
    	return getProxyCount(
    		tree.memorySegment()
    	);
    }
    
    /// ```
    /// Get the number of bytes used by this tree
    /// ```
    public static long getByteCount(
    	MemorySegment tree
    ) {
    	MethodHandle method = B2_DYNAMIC_TREE_GET_BYTE_COUNT.get();
    	try {
    		return (long) method.invokeExact(
    			tree
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#getByteCount].
    public static long getByteCount(
    	DynamicTree tree
    ) {
    	return getByteCount(
    		tree.memorySegment()
    	);
    }
    
    /// ```
    /// Get proxy user data
    /// ```
    public static long getUserData(
    	MemorySegment tree,
    	int proxyId
    ) {
    	MethodHandle method = B2_DYNAMIC_TREE_GET_USER_DATA.get();
    	try {
    		return (long) method.invokeExact(
    			tree,
    			proxyId
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#getUserData].
    public static long getUserData(
    	DynamicTree tree,
    	int proxyId
    ) {
    	return getUserData(
    		tree.memorySegment(),
    		proxyId
    	);
    }
    
    /// ```
    /// Get the AABB of a proxy
    /// ```
    public static MemorySegment getProxyBounds(
    	SegmentAllocator allocator,
    	MemorySegment tree,
    	int proxyId
    ) {
    	MethodHandle method = B2_DYNAMIC_TREE_GET_PROXY_BOUNDS.get();
    	try {
    		return (MemorySegment) method.invokeExact(
    			allocator,
    			tree,
    			proxyId
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#getProxyBounds].
    public static @Nullable AABB getProxyBounds(
    	SegmentAllocator allocator,
    	DynamicTree tree,
    	int proxyId
    ) {
    	MemorySegment segment = getProxyBounds(
    		allocator,
    		tree.memorySegment(),
    		proxyId
    	);
    
    	if (segment.equals(MemorySegment.NULL))
    		return null;
    	
    	return new AABB(segment);
    }
    
    /// ```
    /// Validate the tree.
    /// ```
    public static void validate(
    	MemorySegment tree
    ) {
    	MethodHandle method = B2_DYNAMIC_TREE_VALIDATE.get();
    	try {
    		 method.invokeExact(
    			tree
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#validate].
    public static void validate(
    	DynamicTree tree
    ) {
    	validate(
    		tree.memorySegment()
    	);
    }

}