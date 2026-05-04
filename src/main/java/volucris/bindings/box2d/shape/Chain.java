/*
 * MACHINE GENERATED FILE, DO NOT EDIT.
 */
package volucris.bindings.box2d.shape;

import edu.umd.cs.findbugs.annotations.Nullable;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.SegmentAllocator;
import java.lang.invoke.MethodHandle;
import volucris.bindings.box2d.body.BodyId;
import volucris.bindings.box2d.world.WorldId;

import static java.lang.foreign.ValueLayout.*;
import static volucris.bindings.core.FFMUtils.*;

/**
 * 
 */
public final class Chain {

    private static final LazyConstant<MethodHandle> B2_CREATE_CHAIN;
    private static final LazyConstant<MethodHandle> B2_DESTROY_CHAIN;
    private static final LazyConstant<MethodHandle> B2_CHAIN_GET_WORLD;
    private static final LazyConstant<MethodHandle> B2_CHAIN_GET_SEGMENT_COUNT;
    private static final LazyConstant<MethodHandle> B2_CHAIN_GET_SEGMENTS;
    private static final LazyConstant<MethodHandle> B2_CHAIN_SET_FRICTION;
    private static final LazyConstant<MethodHandle> B2_CHAIN_GET_FRICTION;
    private static final LazyConstant<MethodHandle> B2_CHAIN_SET_RESTITUTION;
    private static final LazyConstant<MethodHandle> B2_CHAIN_GET_RESTITUTION;
    private static final LazyConstant<MethodHandle> B2_CHAIN_SET_MATERIAL;
    private static final LazyConstant<MethodHandle> B2_CHAIN_GET_MATERIAL;
    private static final LazyConstant<MethodHandle> B2_CHAIN_IS_VALID;

    static {
        //@formatter:off
        B2_CREATE_CHAIN = downcallHandle("b2CreateChain", ChainId.LAYOUT, BodyId.LAYOUT, UNBOUNDED_ADDRESS);
        B2_DESTROY_CHAIN = downcallHandleVoid("b2DestroyChain", ChainId.LAYOUT);
        B2_CHAIN_GET_WORLD = downcallHandle("b2Chain_GetWorld", WorldId.LAYOUT, ChainId.LAYOUT);
        B2_CHAIN_GET_SEGMENT_COUNT = downcallHandle("b2Chain_GetSegmentCount", JAVA_INT, ChainId.LAYOUT);
        B2_CHAIN_GET_SEGMENTS = downcallHandle("b2Chain_GetSegments", JAVA_INT, ChainId.LAYOUT, UNBOUNDED_ADDRESS, JAVA_INT);
        B2_CHAIN_SET_FRICTION = downcallHandleVoid("b2Chain_SetFriction", ChainId.LAYOUT, JAVA_FLOAT);
        B2_CHAIN_GET_FRICTION = downcallHandle("b2Chain_GetFriction", JAVA_FLOAT, ChainId.LAYOUT);
        B2_CHAIN_SET_RESTITUTION = downcallHandleVoid("b2Chain_SetRestitution", ChainId.LAYOUT, JAVA_FLOAT);
        B2_CHAIN_GET_RESTITUTION = downcallHandle("b2Chain_GetRestitution", JAVA_FLOAT, ChainId.LAYOUT);
        B2_CHAIN_SET_MATERIAL = downcallHandleVoid("b2Chain_SetMaterial", ChainId.LAYOUT, JAVA_INT);
        B2_CHAIN_GET_MATERIAL = downcallHandle("b2Chain_GetMaterial", JAVA_INT, ChainId.LAYOUT);
        B2_CHAIN_IS_VALID = downcallHandle("b2Chain_IsValid", JAVA_BOOLEAN, ChainId.LAYOUT);
        //@formatter:on
    }

    private Chain() {
    }

    /**
     * Create a chain shape
     */
    public static MemorySegment createChain(
        SegmentAllocator allocator,
        MemorySegment bodyId, 
        MemorySegment def
    ) {
        MethodHandle method = B2_CREATE_CHAIN.get();
        try {
            return (MemorySegment) method.invokeExact(
                allocator,
                bodyId, 
                def
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #createChain}.
     */
    public static @Nullable ChainId createChain(
        SegmentAllocator allocator,
        BodyId bodyId, 
        ChainDef def
    ) {
        MemorySegment segment = createChain(
            allocator,
            bodyId.memorySegment(), 
            def.memorySegment()
        );
    
        if (segment.equals(MemorySegment.NULL))
            return null;
    
        return new ChainId(segment);
    }
    
    /**
     * Destroy a chain shape
     */
    public static void destroyChain(
        MemorySegment chainId
    ) {
        MethodHandle method = B2_DESTROY_CHAIN.get();
        try {
            method.invokeExact(
                chainId
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #destroyChain}.
     */
    public static void destroyChain(
        ChainId chainId
    ) {
        destroyChain(
            chainId.memorySegment()
        );
    }
    
    /**
     * Get the world that owns this chain shape
     */
    public static MemorySegment chain_GetWorld(
        SegmentAllocator allocator,
        MemorySegment chainId
    ) {
        MethodHandle method = B2_CHAIN_GET_WORLD.get();
        try {
            return (MemorySegment) method.invokeExact(
                allocator,
                chainId
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #chain_GetWorld}.
     */
    public static @Nullable WorldId chain_GetWorld(
        SegmentAllocator allocator,
        ChainId chainId
    ) {
        MemorySegment segment = chain_GetWorld(
            allocator,
            chainId.memorySegment()
        );
    
        if (segment.equals(MemorySegment.NULL))
            return null;
    
        return new WorldId(segment);
    }
    
    /**
     * Get the number of segments on this chain
     */
    public static int chain_GetSegmentCount(
        MemorySegment chainId
    ) {
        MethodHandle method = B2_CHAIN_GET_SEGMENT_COUNT.get();
        try {
            return (int) method.invokeExact(
                chainId
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #chain_GetSegmentCount}.
     */
    public static int chain_GetSegmentCount(
        ChainId chainId
    ) {
        return (int) chain_GetSegmentCount(
            chainId.memorySegment()
        );
    }
    
    /**
     * Fill a user array with chain segment shape ids up to the specified capacity. Returns the actual number of segments returned.
     */
    public static int chain_GetSegments(
        MemorySegment chainId, 
        MemorySegment segmentArray, 
        int capacity
    ) {
        MethodHandle method = B2_CHAIN_GET_SEGMENTS.get();
        try {
            return (int) method.invokeExact(
                chainId, 
                segmentArray, 
                capacity
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #chain_GetSegments}.
     */
    public static int chain_GetSegments(
        ChainId chainId, 
        ShapeId segmentArray, 
        int capacity
    ) {
        return (int) chain_GetSegments(
            chainId.memorySegment(), 
            segmentArray.memorySegment(), 
            capacity
        );
    }
    
    /**
     * Set the chain friction
     */
    public static void chain_SetFriction(
        MemorySegment chainId, 
        float friction
    ) {
        MethodHandle method = B2_CHAIN_SET_FRICTION.get();
        try {
            method.invokeExact(
                chainId, 
                friction
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #chain_SetFriction}.
     */
    public static void chain_SetFriction(
        ChainId chainId, 
        float friction
    ) {
        chain_SetFriction(
            chainId.memorySegment(), 
            friction
        );
    }
    
    /**
     * Get the chain friction
     */
    public static float chain_GetFriction(
        MemorySegment chainId
    ) {
        MethodHandle method = B2_CHAIN_GET_FRICTION.get();
        try {
            return (float) method.invokeExact(
                chainId
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #chain_GetFriction}.
     */
    public static float chain_GetFriction(
        ChainId chainId
    ) {
        return (float) chain_GetFriction(
            chainId.memorySegment()
        );
    }
    
    /**
     * Set the chain restitution (bounciness)
     */
    public static void chain_SetRestitution(
        MemorySegment chainId, 
        float restitution
    ) {
        MethodHandle method = B2_CHAIN_SET_RESTITUTION.get();
        try {
            method.invokeExact(
                chainId, 
                restitution
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #chain_SetRestitution}.
     */
    public static void chain_SetRestitution(
        ChainId chainId, 
        float restitution
    ) {
        chain_SetRestitution(
            chainId.memorySegment(), 
            restitution
        );
    }
    
    /**
     * Get the chain restitution
     */
    public static float chain_GetRestitution(
        MemorySegment chainId
    ) {
        MethodHandle method = B2_CHAIN_GET_RESTITUTION.get();
        try {
            return (float) method.invokeExact(
                chainId
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #chain_GetRestitution}.
     */
    public static float chain_GetRestitution(
        ChainId chainId
    ) {
        return (float) chain_GetRestitution(
            chainId.memorySegment()
        );
    }
    
    /**
     * Set the chain material
     */
    public static void chain_SetMaterial(
        MemorySegment chainId, 
        int material
    ) {
        MethodHandle method = B2_CHAIN_SET_MATERIAL.get();
        try {
            method.invokeExact(
                chainId, 
                material
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #chain_SetMaterial}.
     */
    public static void chain_SetMaterial(
        ChainId chainId, 
        int material
    ) {
        chain_SetMaterial(
            chainId.memorySegment(), 
            material
        );
    }
    
    /**
     * Get the chain material
     */
    public static int chain_GetMaterial(
        MemorySegment chainId
    ) {
        MethodHandle method = B2_CHAIN_GET_MATERIAL.get();
        try {
            return (int) method.invokeExact(
                chainId
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #chain_GetMaterial}.
     */
    public static int chain_GetMaterial(
        ChainId chainId
    ) {
        return (int) chain_GetMaterial(
            chainId.memorySegment()
        );
    }
    
    /**
     * Chain identifier validation. Provides validation for up to 64K allocations.
     */
    public static boolean chain_IsValid(
        MemorySegment id
    ) {
        MethodHandle method = B2_CHAIN_IS_VALID.get();
        try {
            return (boolean) method.invokeExact(
                id
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #chain_IsValid}.
     */
    public static boolean chain_IsValid(
        ChainId id
    ) {
        return (boolean) chain_IsValid(
            id.memorySegment()
        );
    }
    
}