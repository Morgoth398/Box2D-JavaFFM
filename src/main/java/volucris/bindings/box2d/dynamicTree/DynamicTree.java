/*
 * MACHINE GENERATED FILE, DO NOT EDIT.
 */
package volucris.bindings.box2d.dynamicTree;

import edu.umd.cs.findbugs.annotations.Nullable;
import java.lang.foreign.Arena;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.SegmentAllocator;
import java.lang.foreign.StructLayout;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import volucris.bindings.box2d.geometry.RayCastInput;
import volucris.bindings.box2d.geometry.ShapeCastInput;
import volucris.bindings.box2d.math.AABB;
import volucris.bindings.box2d.math.Vec2;
import volucris.bindings.core.NativeIntArray;
import volucris.bindings.core.NativeStructArray;
import volucris.bindings.core.Struct;

import static java.lang.foreign.ValueLayout.*;
import static volucris.bindings.core.FFMUtils.*;

/**
 * The dynamic tree structure. This should be considered private data. It is placed here for performance reasons.
 */
public final class DynamicTree
		implements Struct<DynamicTree> {

    private static final LazyConstant<MethodHandle> B2_DYNAMIC_TREE_CREATE;
    private static final LazyConstant<MethodHandle> B2_DYNAMIC_TREE_DESTROY;
    private static final LazyConstant<MethodHandle> B2_DYNAMIC_TREE_CREATE_PROXY;
    private static final LazyConstant<MethodHandle> B2_DYNAMIC_TREE_DESTROY_PROXY;
    private static final LazyConstant<MethodHandle> B2_DYNAMIC_TREE_MOVE_PROXY;
    private static final LazyConstant<MethodHandle> B2_DYNAMIC_TREE_ENLARGE_PROXY;
    private static final LazyConstant<MethodHandle> B2_DYNAMIC_TREE_SET_CATEGORY_BITS;
    private static final LazyConstant<MethodHandle> B2_DYNAMIC_TREE_GET_CATEGORY_BITS;
    private static final LazyConstant<MethodHandle> B2_DYNAMIC_TREE_QUERY;
    private static final LazyConstant<MethodHandle> B2_DYNAMIC_TREE_RAY_CAST;
    private static final LazyConstant<MethodHandle> B2_DYNAMIC_TREE_SHAPE_CAST;
    private static final LazyConstant<MethodHandle> B2_DYNAMIC_TREE_GET_HEIGHT;
    private static final LazyConstant<MethodHandle> B2_DYNAMIC_TREE_GET_AREA_RATIO;
    private static final LazyConstant<MethodHandle> B2_DYNAMIC_TREE_GET_ROOT_BOUNDS;
    private static final LazyConstant<MethodHandle> B2_DYNAMIC_TREE_GET_PROXY_COUNT;
    private static final LazyConstant<MethodHandle> B2_DYNAMIC_TREE_REBUILD;
    private static final LazyConstant<MethodHandle> B2_DYNAMIC_TREE_GET_BYTE_COUNT;
    private static final LazyConstant<MethodHandle> B2_DYNAMIC_TREE_GET_USER_DATA;
    private static final LazyConstant<MethodHandle> B2_DYNAMIC_TREE_GET_AABB;
    private static final LazyConstant<MethodHandle> B2_DYNAMIC_TREE_VALIDATE;
    private static final LazyConstant<MethodHandle> B2_DYNAMIC_TREE_VALIDATE_NO_ENLARGED;

    public static final StructLayout LAYOUT;

    public static final VarHandle ROOT_HANDLE;
    public static final VarHandle NODE_COUNT_HANDLE;
    public static final VarHandle NODE_CAPACITY_HANDLE;
    public static final VarHandle FREE_LIST_HANDLE;
    public static final VarHandle PROXY_COUNT_HANDLE;
    public static final VarHandle LEAF_INDICES_HANDLE;
    public static final VarHandle LEAF_BOXES_HANDLE;
    public static final VarHandle LEAF_CENTERS_HANDLE;
    public static final VarHandle BIN_INDICES_HANDLE;
    public static final VarHandle REBUILD_CAPACITY_HANDLE;

    public static final long NODES_BYTE_OFFSET;
    public static final long ROOT_BYTE_OFFSET;
    public static final long NODE_COUNT_BYTE_OFFSET;
    public static final long NODE_CAPACITY_BYTE_OFFSET;
    public static final long FREE_LIST_BYTE_OFFSET;
    public static final long PROXY_COUNT_BYTE_OFFSET;
    public static final long LEAF_INDICES_BYTE_OFFSET;
    public static final long LEAF_BOXES_BYTE_OFFSET;
    public static final long LEAF_CENTERS_BYTE_OFFSET;
    public static final long BIN_INDICES_BYTE_OFFSET;
    public static final long REBUILD_CAPACITY_BYTE_OFFSET;

    private final MemorySegment segment;

    static {
        //@formatter:off
        LAYOUT = MemoryLayout.structLayout(
            UNBOUNDED_ADDRESS.withName("nodes"),
            JAVA_INT.withName("root"),
            JAVA_INT.withName("nodeCount"),
            JAVA_INT.withName("nodeCapacity"),
            JAVA_INT.withName("freeList"),
            JAVA_INT.withName("proxyCount"),
            MemoryLayout.paddingLayout(4),
            UNBOUNDED_ADDRESS.withName("leafIndices"),
            UNBOUNDED_ADDRESS.withName("leafBoxes"),
            UNBOUNDED_ADDRESS.withName("leafCenters"),
            UNBOUNDED_ADDRESS.withName("binIndices"),
            JAVA_INT.withName("rebuildCapacity"),
            MemoryLayout.paddingLayout(4)
        ).withName("b2DynamicTree").withByteAlignment(8);
        
        B2_DYNAMIC_TREE_CREATE = downcallHandle("b2DynamicTree_Create", DynamicTree.LAYOUT);
        B2_DYNAMIC_TREE_DESTROY = downcallHandleVoid("b2DynamicTree_Destroy", UNBOUNDED_ADDRESS);
        B2_DYNAMIC_TREE_CREATE_PROXY = downcallHandle("b2DynamicTree_CreateProxy", JAVA_INT, UNBOUNDED_ADDRESS, AABB.LAYOUT, JAVA_LONG, JAVA_LONG);
        B2_DYNAMIC_TREE_DESTROY_PROXY = downcallHandleVoid("b2DynamicTree_DestroyProxy", UNBOUNDED_ADDRESS, JAVA_INT);
        B2_DYNAMIC_TREE_MOVE_PROXY = downcallHandleVoid("b2DynamicTree_MoveProxy", UNBOUNDED_ADDRESS, JAVA_INT, AABB.LAYOUT);
        B2_DYNAMIC_TREE_ENLARGE_PROXY = downcallHandleVoid("b2DynamicTree_EnlargeProxy", UNBOUNDED_ADDRESS, JAVA_INT, AABB.LAYOUT);
        B2_DYNAMIC_TREE_SET_CATEGORY_BITS = downcallHandleVoid("b2DynamicTree_SetCategoryBits", UNBOUNDED_ADDRESS, JAVA_INT, JAVA_LONG);
        B2_DYNAMIC_TREE_GET_CATEGORY_BITS = downcallHandle("b2DynamicTree_GetCategoryBits", JAVA_LONG, UNBOUNDED_ADDRESS, JAVA_INT);
        B2_DYNAMIC_TREE_QUERY = downcallHandle("b2DynamicTree_Query", TreeStats.LAYOUT, UNBOUNDED_ADDRESS, AABB.LAYOUT, JAVA_LONG, UNBOUNDED_ADDRESS, UNBOUNDED_ADDRESS);
        B2_DYNAMIC_TREE_RAY_CAST = downcallHandle("b2DynamicTree_RayCast", TreeStats.LAYOUT, UNBOUNDED_ADDRESS, UNBOUNDED_ADDRESS, JAVA_LONG, UNBOUNDED_ADDRESS, UNBOUNDED_ADDRESS);
        B2_DYNAMIC_TREE_SHAPE_CAST = downcallHandle("b2DynamicTree_ShapeCast", TreeStats.LAYOUT, UNBOUNDED_ADDRESS, UNBOUNDED_ADDRESS, JAVA_LONG, UNBOUNDED_ADDRESS, UNBOUNDED_ADDRESS);
        B2_DYNAMIC_TREE_GET_HEIGHT = downcallHandle("b2DynamicTree_GetHeight", JAVA_INT, UNBOUNDED_ADDRESS);
        B2_DYNAMIC_TREE_GET_AREA_RATIO = downcallHandle("b2DynamicTree_GetAreaRatio", JAVA_FLOAT, UNBOUNDED_ADDRESS);
        B2_DYNAMIC_TREE_GET_ROOT_BOUNDS = downcallHandle("b2DynamicTree_GetRootBounds", AABB.LAYOUT, UNBOUNDED_ADDRESS);
        B2_DYNAMIC_TREE_GET_PROXY_COUNT = downcallHandle("b2DynamicTree_GetProxyCount", JAVA_INT, UNBOUNDED_ADDRESS);
        B2_DYNAMIC_TREE_REBUILD = downcallHandle("b2DynamicTree_Rebuild", JAVA_INT, UNBOUNDED_ADDRESS, JAVA_BOOLEAN);
        B2_DYNAMIC_TREE_GET_BYTE_COUNT = downcallHandle("b2DynamicTree_GetByteCount", JAVA_INT, UNBOUNDED_ADDRESS);
        B2_DYNAMIC_TREE_GET_USER_DATA = downcallHandle("b2DynamicTree_GetUserData", JAVA_LONG, UNBOUNDED_ADDRESS, JAVA_INT);
        B2_DYNAMIC_TREE_GET_AABB = downcallHandle("b2DynamicTree_GetAABB", AABB.LAYOUT, UNBOUNDED_ADDRESS, JAVA_INT);
        B2_DYNAMIC_TREE_VALIDATE = downcallHandleVoid("b2DynamicTree_Validate", UNBOUNDED_ADDRESS);
        B2_DYNAMIC_TREE_VALIDATE_NO_ENLARGED = downcallHandleVoid("b2DynamicTree_ValidateNoEnlarged", UNBOUNDED_ADDRESS);
        
        ROOT_HANDLE = LAYOUT.varHandle(PathElement.groupElement("root"));
        NODE_COUNT_HANDLE = LAYOUT.varHandle(PathElement.groupElement("nodeCount"));
        NODE_CAPACITY_HANDLE = LAYOUT.varHandle(PathElement.groupElement("nodeCapacity"));
        FREE_LIST_HANDLE = LAYOUT.varHandle(PathElement.groupElement("freeList"));
        PROXY_COUNT_HANDLE = LAYOUT.varHandle(PathElement.groupElement("proxyCount"));
        LEAF_INDICES_HANDLE = LAYOUT.varHandle(PathElement.groupElement("leafIndices"));
        LEAF_BOXES_HANDLE = LAYOUT.varHandle(PathElement.groupElement("leafBoxes"));
        LEAF_CENTERS_HANDLE = LAYOUT.varHandle(PathElement.groupElement("leafCenters"));
        BIN_INDICES_HANDLE = LAYOUT.varHandle(PathElement.groupElement("binIndices"));
        REBUILD_CAPACITY_HANDLE = LAYOUT.varHandle(PathElement.groupElement("rebuildCapacity"));
        
        NODES_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("nodes"));
        ROOT_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("root"));
        NODE_COUNT_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("nodeCount"));
        NODE_CAPACITY_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("nodeCapacity"));
        FREE_LIST_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("freeList"));
        PROXY_COUNT_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("proxyCount"));
        LEAF_INDICES_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("leafIndices"));
        LEAF_BOXES_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("leafBoxes"));
        LEAF_CENTERS_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("leafCenters"));
        BIN_INDICES_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("binIndices"));
        REBUILD_CAPACITY_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("rebuildCapacity"));
        //@formatter:on
    }

    public DynamicTree() {
        this(Arena.ofAuto());
    }
    
    public DynamicTree(Arena arena) {
        this(arena.allocate(LAYOUT));
    }
    
    public DynamicTree(MemorySegment segment) {
        this.segment = segment;
    
    }

    /**
     * Constructing the tree initializes the node pool.
     */
    public static MemorySegment ncreate(
        SegmentAllocator allocator
    ) {
        MethodHandle method = B2_DYNAMIC_TREE_CREATE.get();
        try {
            return (MemorySegment) method.invokeExact(
                allocator
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #ncreate}.
     */
    public static @Nullable DynamicTree create(
        SegmentAllocator allocator
    ) {
        MemorySegment segment = ncreate(allocator);
    
        if (segment.equals(MemorySegment.NULL))
            return null;
    
        return new DynamicTree(segment);
    }
    
    /**
     * Destroy the tree, freeing the node pool.
     */
    public static void destroy(
        MemorySegment tree
    ) {
        MethodHandle method = B2_DYNAMIC_TREE_DESTROY.get();
        try {
            method.invokeExact(
                tree
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #destroy}.
     */
    public static void destroy(
        DynamicTree tree
    ) {
        destroy(
            tree.memorySegment()
        );
    }
    
    /**
     * Create a proxy. Provide an AABB and a userData value.
     */
    public static int createProxy(
        MemorySegment tree, 
        MemorySegment aabb, 
        long categoryBits, 
        long userData
    ) {
        MethodHandle method = B2_DYNAMIC_TREE_CREATE_PROXY.get();
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
    
    /**
     * Typed method of {@link #createProxy}.
     */
    public static int createProxy(
        DynamicTree tree, 
        AABB aabb, 
        long categoryBits, 
        long userData
    ) {
        return (int) createProxy(
            tree.memorySegment(), 
            aabb.memorySegment(), 
            categoryBits, 
            userData
        );
    }
    
    /**
     * Destroy a proxy. This asserts if the id is invalid.
     */
    public static void destroyProxy(
        MemorySegment tree, 
        int proxyId
    ) {
        MethodHandle method = B2_DYNAMIC_TREE_DESTROY_PROXY.get();
        try {
            method.invokeExact(
                tree, 
                proxyId
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #destroyProxy}.
     */
    public static void destroyProxy(
        DynamicTree tree, 
        int proxyId
    ) {
        destroyProxy(
            tree.memorySegment(), 
            proxyId
        );
    }
    
    /**
     * Move a proxy to a new AABB by removing and reinserting into the tree.
     */
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
    
    /**
     * Typed method of {@link #moveProxy}.
     */
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
    
    /**
     * Enlarge a proxy and enlarge ancestors as necessary.
     */
    public static void enlargeProxy(
        MemorySegment tree, 
        int proxyId, 
        MemorySegment aabb
    ) {
        MethodHandle method = B2_DYNAMIC_TREE_ENLARGE_PROXY.get();
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
    
    /**
     * Typed method of {@link #enlargeProxy}.
     */
    public static void enlargeProxy(
        DynamicTree tree, 
        int proxyId, 
        AABB aabb
    ) {
        enlargeProxy(
            tree.memorySegment(), 
            proxyId, 
            aabb.memorySegment()
        );
    }
    
    /**
     * Modify the category bits on a proxy. This is an expensive operation.
     */
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
    
    /**
     * Typed method of {@link #setCategoryBits}.
     */
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
    
    /**
     * Get the category bits on a proxy.
     */
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
    
    /**
     * Typed method of {@link #getCategoryBits}.
     */
    public static long getCategoryBits(
        DynamicTree tree, 
        int proxyId
    ) {
        return (long) getCategoryBits(
            tree.memorySegment(), 
            proxyId
        );
    }
    
    /**
     * Query an AABB for overlapping proxies. The callback class is called for each proxy that overlaps the supplied AABB.
     */
    public static MemorySegment query(
        SegmentAllocator allocator,
        MemorySegment tree, 
        MemorySegment aabb, 
        long maskBits, 
        MemorySegment callback, 
        MemorySegment context
    ) {
        MethodHandle method = B2_DYNAMIC_TREE_QUERY.get();
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
    
    /**
     * Typed method of {@link #query}.
     */
    public static @Nullable TreeStats query(
        SegmentAllocator allocator,
        DynamicTree tree, 
        AABB aabb, 
        long maskBits, 
        TreeQueryCallbackFcn callback, 
        MemorySegment context
    ) {
        MemorySegment segment = query(
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
    
    /**
     * Ray cast against the proxies in the tree. This relies on the callback to perform a exact ray cast in the case were the proxy contains a shape. The callback also performs the any collision filtering. This has performance roughly equal to k * log(n), where k is the number of collisions and n is the number of proxies in the tree. Bit-wise filtering using mask bits can greatly improve performance in some scenarios. However, this filtering may be approximate, so the user should still apply filtering to results.
     */
    public static MemorySegment rayCast(
        SegmentAllocator allocator,
        MemorySegment tree, 
        MemorySegment input, 
        long maskBits, 
        MemorySegment callback, 
        MemorySegment context
    ) {
        MethodHandle method = B2_DYNAMIC_TREE_RAY_CAST.get();
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
    
    /**
     * Typed method of {@link #rayCast}.
     */
    public static @Nullable TreeStats rayCast(
        SegmentAllocator allocator,
        DynamicTree tree, 
        RayCastInput input, 
        long maskBits, 
        TreeRayCastCallbackFcn callback, 
        MemorySegment context
    ) {
        MemorySegment segment = rayCast(
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
    
    /**
     * Ray cast against the proxies in the tree. This relies on the callback to perform a exact ray cast in the case were the proxy contains a shape. The callback also performs the any collision filtering. This has performance roughly equal to k * log(n), where k is the number of collisions and n is the number of proxies in the tree.
     */
    public static MemorySegment shapeCast(
        SegmentAllocator allocator,
        MemorySegment tree, 
        MemorySegment input, 
        long maskBits, 
        MemorySegment callback, 
        MemorySegment context
    ) {
        MethodHandle method = B2_DYNAMIC_TREE_SHAPE_CAST.get();
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
    
    /**
     * Typed method of {@link #shapeCast}.
     */
    public static @Nullable TreeStats shapeCast(
        SegmentAllocator allocator,
        DynamicTree tree, 
        ShapeCastInput input, 
        long maskBits, 
        TreeShapeCastCallbackFcn callback, 
        MemorySegment context
    ) {
        MemorySegment segment = shapeCast(
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
    
    /**
     * Get the height of the binary tree.
     */
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
    
    /**
     * Typed method of {@link #getHeight}.
     */
    public static int getHeight(
        DynamicTree tree
    ) {
        return (int) getHeight(
            tree.memorySegment()
        );
    }
    
    /**
     * Get the ratio of the sum of the node areas to the root area.
     */
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
    
    /**
     * Typed method of {@link #getAreaRatio}.
     */
    public static float getAreaRatio(
        DynamicTree tree
    ) {
        return (float) getAreaRatio(
            tree.memorySegment()
        );
    }
    
    /**
     * Get the bounding box that contains the entire tree
     */
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
    
    /**
     * Typed method of {@link #getRootBounds}.
     */
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
    
    /**
     * Get the number of proxies created
     */
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
    
    /**
     * Typed method of {@link #getProxyCount}.
     */
    public static int getProxyCount(
        DynamicTree tree
    ) {
        return (int) getProxyCount(
            tree.memorySegment()
        );
    }
    
    /**
     * Rebuild the tree while retaining subtrees that haven't changed. Returns the number of boxes sorted.
     */
    public static int rebuild(
        MemorySegment tree, 
        boolean fullBuild
    ) {
        MethodHandle method = B2_DYNAMIC_TREE_REBUILD.get();
        try {
            return (int) method.invokeExact(
                tree, 
                fullBuild
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #rebuild}.
     */
    public static int rebuild(
        DynamicTree tree, 
        boolean fullBuild
    ) {
        return (int) rebuild(
            tree.memorySegment(), 
            fullBuild
        );
    }
    
    /**
     * Get the number of bytes used by this tree
     */
    public static int getByteCount(
        MemorySegment tree
    ) {
        MethodHandle method = B2_DYNAMIC_TREE_GET_BYTE_COUNT.get();
        try {
            return (int) method.invokeExact(
                tree
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #getByteCount}.
     */
    public static int getByteCount(
        DynamicTree tree
    ) {
        return (int) getByteCount(
            tree.memorySegment()
        );
    }
    
    /**
     * Get proxy user data
     */
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
    
    /**
     * Typed method of {@link #getUserData}.
     */
    public static long getUserData(
        DynamicTree tree, 
        int proxyId
    ) {
        return (long) getUserData(
            tree.memorySegment(), 
            proxyId
        );
    }
    
    /**
     * Get the AABB of a proxy
     */
    public static MemorySegment getAABB(
        SegmentAllocator allocator,
        MemorySegment tree, 
        int proxyId
    ) {
        MethodHandle method = B2_DYNAMIC_TREE_GET_AABB.get();
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
    
    /**
     * Typed method of {@link #getAABB}.
     */
    public static @Nullable AABB getAABB(
        SegmentAllocator allocator,
        DynamicTree tree, 
        int proxyId
    ) {
        MemorySegment segment = getAABB(
            allocator,
            tree.memorySegment(), 
            proxyId
        );
    
        if (segment.equals(MemorySegment.NULL))
            return null;
    
        return new AABB(segment);
    }
    
    /**
     * Validate this tree. For testing.
     */
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
    
    /**
     * Typed method of {@link #validate}.
     */
    public static void validate(
        DynamicTree tree
    ) {
        validate(
            tree.memorySegment()
        );
    }
    
    /**
     * Validate this tree has no enlarged AABBs. For testing.
     */
    public static void validateNoEnlarged(
        MemorySegment tree
    ) {
        MethodHandle method = B2_DYNAMIC_TREE_VALIDATE_NO_ENLARGED.get();
        try {
            method.invokeExact(
                tree
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #validateNoEnlarged}.
     */
    public static void validateNoEnlarged(
        DynamicTree tree
    ) {
        validateNoEnlarged(
            tree.memorySegment()
        );
    }
    
    public DynamicTree root(int root) {
        ROOT_HANDLE.set(segment, 0L, root);
        return this;
    }
    
    public int root() {
        return (int) ROOT_HANDLE.get(segment, 0L);
    }
    
    public DynamicTree nodeCount(int nodeCount) {
        NODE_COUNT_HANDLE.set(segment, 0L, nodeCount);
        return this;
    }
    
    public int nodeCount() {
        return (int) NODE_COUNT_HANDLE.get(segment, 0L);
    }
    
    public DynamicTree nodeCapacity(int nodeCapacity) {
        NODE_CAPACITY_HANDLE.set(segment, 0L, nodeCapacity);
        return this;
    }
    
    public int nodeCapacity() {
        return (int) NODE_CAPACITY_HANDLE.get(segment, 0L);
    }
    
    public DynamicTree freeList(int freeList) {
        FREE_LIST_HANDLE.set(segment, 0L, freeList);
        return this;
    }
    
    public int freeList() {
        return (int) FREE_LIST_HANDLE.get(segment, 0L);
    }
    
    public DynamicTree proxyCount(int proxyCount) {
        PROXY_COUNT_HANDLE.set(segment, 0L, proxyCount);
        return this;
    }
    
    public int proxyCount() {
        return (int) PROXY_COUNT_HANDLE.get(segment, 0L);
    }
    
    public DynamicTree leafIndices(NativeIntArray leafIndices) {
        LEAF_INDICES_HANDLE.set(segment, 0L, leafIndices.memorySegment());
        return this;
    }
    
    public @Nullable NativeIntArray leafIndices() {
        MemorySegment segment = (MemorySegment) LEAF_INDICES_HANDLE.get(this.segment, 0L);
    
        if (segment.equals(MemorySegment.NULL))
            return null;
    
        return new NativeIntArray(segment);
    }
    
    public DynamicTree leafBoxes(AABB leafBoxes) {
        LEAF_BOXES_HANDLE.set(segment, 0L, leafBoxes.memorySegment());
        return this;
    }
    
    public @Nullable AABB leafBoxes() {
        MemorySegment segment = (MemorySegment) LEAF_BOXES_HANDLE.get(this.segment, 0L);
    
        if (segment.equals(MemorySegment.NULL))
            return null;
    
        return new AABB(segment);
    }
    
    public DynamicTree leafCenters(Vec2 leafCenters) {
        LEAF_CENTERS_HANDLE.set(segment, 0L, leafCenters.memorySegment());
        return this;
    }
    
    public @Nullable Vec2 leafCenters() {
        MemorySegment segment = (MemorySegment) LEAF_CENTERS_HANDLE.get(this.segment, 0L);
    
        if (segment.equals(MemorySegment.NULL))
            return null;
    
        return new Vec2(segment);
    }
    
    public DynamicTree binIndices(NativeIntArray binIndices) {
        BIN_INDICES_HANDLE.set(segment, 0L, binIndices.memorySegment());
        return this;
    }
    
    public @Nullable NativeIntArray binIndices() {
        MemorySegment segment = (MemorySegment) BIN_INDICES_HANDLE.get(this.segment, 0L);
    
        if (segment.equals(MemorySegment.NULL))
            return null;
    
        return new NativeIntArray(segment);
    }
    
    public DynamicTree rebuildCapacity(int rebuildCapacity) {
        REBUILD_CAPACITY_HANDLE.set(segment, 0L, rebuildCapacity);
        return this;
    }
    
    public int rebuildCapacity() {
        return (int) REBUILD_CAPACITY_HANDLE.get(segment, 0L);
    }
    
    @Override
    public DynamicTree set(DynamicTree other) {
        return set(other.segment);
    }
    
    @Override
    public DynamicTree set(MemorySegment src) {
        MemorySegment.copy(src, 0L, segment, 0L, LAYOUT.byteSize());
        return this;
    }
    
    @Override
    public MemorySegment memorySegment() {
        return segment;
    }
    
    public NativeStructArray<DynamicTree> asArray() {
        return new NativeStructArray<>(this);
    }
    
    public static NativeStructArray<DynamicTree> array(Arena arena, int count) {
        return new NativeStructArray<>(
            arena,
            LAYOUT,
            segment -> new DynamicTree(segment),
            count
        );
    }
    
    public static NativeStructArray<DynamicTree> array(Arena arena, DynamicTree... structs) {
        NativeStructArray<DynamicTree> array = new NativeStructArray<>(
            arena,
            LAYOUT,
            segment -> new DynamicTree(segment),
            structs.length
        );
    
        for (int i = 0; i < structs.length; i++) {
            array.set(i, structs[i]);
        }
    
        return array;
    }
    
    public static NativeStructArray<DynamicTree> array(MemorySegment array) {
        return new NativeStructArray<>(
            array,
            LAYOUT,
            segment -> new DynamicTree(segment)
        );
    }
    
}