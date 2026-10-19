/*
 * MACHINE GENERATED FILE, DO NOT EDIT.
 */
package volucris.bindings.box2d.chain;

import java.lang.foreign.MemorySegment;
import java.lang.foreign.SegmentAllocator;
import java.lang.invoke.MethodHandle;
import org.jspecify.annotations.Nullable;
import volucris.bindings.box2d.body.BodyId;
import volucris.bindings.box2d.shape.ShapeId;
import volucris.bindings.box2d.shape.SurfaceMaterial;
import volucris.bindings.box2d.world.WorldId;

import static java.lang.foreign.ValueLayout.*;
import static volucris.bindings.core.FFMUtils.*;

public final class Chain {

	private static final LazyConstant<MethodHandle> B2_CREATE_CHAIN;
	private static final LazyConstant<MethodHandle> B2_DESTROY_CHAIN;
	private static final LazyConstant<MethodHandle> B2_CHAIN_GET_WORLD;
	private static final LazyConstant<MethodHandle> B2_CHAIN_GET_SEGMENT_COUNT;
	private static final LazyConstant<MethodHandle> B2_CHAIN_GET_SEGMENTS;
	private static final LazyConstant<MethodHandle> B2_CHAIN_SET_ALL_SURFACE_MATERIALS;
	private static final LazyConstant<MethodHandle> B2_CHAIN_SET_SURFACE_MATERIAL;
	private static final LazyConstant<MethodHandle> B2_CHAIN_GET_SURFACE_MATERIAL;
	private static final LazyConstant<MethodHandle> B2_CHAIN_IS_VALID;

	static {
		//@formatter:off
		B2_CREATE_CHAIN = downcallHandle("b2CreateChain", ChainId.LAYOUT, BodyId.LAYOUT, UNBOUNDED_ADDRESS);
		B2_DESTROY_CHAIN = downcallHandleVoid("b2DestroyChain", ChainId.LAYOUT);
		B2_CHAIN_GET_WORLD = downcallHandle("b2Chain_GetWorld", WorldId.LAYOUT, ChainId.LAYOUT);
		B2_CHAIN_GET_SEGMENT_COUNT = downcallHandle("b2Chain_GetSegmentCount", JAVA_INT, ChainId.LAYOUT);
		B2_CHAIN_GET_SEGMENTS = downcallHandle("b2Chain_GetSegments", JAVA_INT, ChainId.LAYOUT, UNBOUNDED_ADDRESS, JAVA_INT);
		B2_CHAIN_SET_ALL_SURFACE_MATERIALS = downcallHandleVoid("b2Chain_SetAllSurfaceMaterials", ChainId.LAYOUT, UNBOUNDED_ADDRESS);
		B2_CHAIN_SET_SURFACE_MATERIAL = downcallHandleVoid("b2Chain_SetSurfaceMaterial", ChainId.LAYOUT, UNBOUNDED_ADDRESS, JAVA_INT);
		B2_CHAIN_GET_SURFACE_MATERIAL = downcallHandle("b2Chain_GetSurfaceMaterial", SurfaceMaterial.LAYOUT, ChainId.LAYOUT, JAVA_INT);
		B2_CHAIN_IS_VALID = downcallHandle("b2Chain_IsValid", JAVA_BOOLEAN, ChainId.LAYOUT);
		//@formatter:on
	}

	private Chain() {
	}

    /// ```
    /// Create a chain shape
    /// @see b2ChainDef for details
    /// ```
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
    
    /// Typed method of [#createChain].
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
    
    /// ```
    /// Destroy a chain shape
    /// ```
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
    
    /// Typed method of [#destroyChain].
    public static void destroyChain(
    	ChainId chainId
    ) {
    	destroyChain(
    		chainId.memorySegment()
    	);
    }
    
    /// ```
    /// Get the world that owns this chain shape
    /// ```
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
    
    /// Typed method of [#chain_GetWorld].
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
    
    /// ```
    /// Get the number of segments on this chain
    /// ```
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
    
    /// Typed method of [#chain_GetSegmentCount].
    public static int chain_GetSegmentCount(
    	ChainId chainId
    ) {
    	return chain_GetSegmentCount(
    		chainId.memorySegment()
    	);
    }
    
    /// ```
    /// Fill a user array with chain segment shape ids up to the specified capacity. Returns the actual
    /// number of segments returned.
    /// ```
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
    
    /// Typed method of [#chain_GetSegments].
    public static int chain_GetSegments(
    	ChainId chainId,
    	ShapeId segmentArray,
    	int capacity
    ) {
    	return chain_GetSegments(
    		chainId.memorySegment(),
    		segmentArray.memorySegment(),
    		capacity
    	);
    }
    
    /// ```
    /// Set the chain material on all segments.
    /// ```
    public static void chain_SetAllSurfaceMaterials(
    	MemorySegment chainId,
    	MemorySegment material
    ) {
    	MethodHandle method = B2_CHAIN_SET_ALL_SURFACE_MATERIALS.get();
    	try {
    		 method.invokeExact(
    			chainId,
    			material
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#chain_SetAllSurfaceMaterials].
    public static void chain_SetAllSurfaceMaterials(
    	ChainId chainId,
    	SurfaceMaterial material
    ) {
    	chain_SetAllSurfaceMaterials(
    		chainId.memorySegment(),
    		material.memorySegment()
    	);
    }
    
    /// ```
    /// Set a chain material by segment index.
    /// ```
    public static void chain_SetSurfaceMaterial(
    	MemorySegment chainId,
    	MemorySegment material,
    	int segmentIndex
    ) {
    	MethodHandle method = B2_CHAIN_SET_SURFACE_MATERIAL.get();
    	try {
    		 method.invokeExact(
    			chainId,
    			material,
    			segmentIndex
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#chain_SetSurfaceMaterial].
    public static void chain_SetSurfaceMaterial(
    	ChainId chainId,
    	SurfaceMaterial material,
    	int segmentIndex
    ) {
    	chain_SetSurfaceMaterial(
    		chainId.memorySegment(),
    		material.memorySegment(),
    		segmentIndex
    	);
    }
    
    /// ```
    /// Get a chain material by segment index.
    /// ```
    public static MemorySegment chain_GetSurfaceMaterial(
    	SegmentAllocator allocator,
    	MemorySegment chainId,
    	int segmentIndex
    ) {
    	MethodHandle method = B2_CHAIN_GET_SURFACE_MATERIAL.get();
    	try {
    		return (MemorySegment) method.invokeExact(
    			allocator,
    			chainId,
    			segmentIndex
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#chain_GetSurfaceMaterial].
    public static @Nullable SurfaceMaterial chain_GetSurfaceMaterial(
    	SegmentAllocator allocator,
    	ChainId chainId,
    	int segmentIndex
    ) {
    	MemorySegment segment = chain_GetSurfaceMaterial(
    		allocator,
    		chainId.memorySegment(),
    		segmentIndex
    	);
    
    	if (segment.equals(MemorySegment.NULL))
    		return null;
    	
    	return new SurfaceMaterial(segment);
    }
    
    /// ```
    /// Chain identifier validation. Provides validation for up to 64K allocations.
    /// ```
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
    
    /// Typed method of [#chain_IsValid].
    public static boolean chain_IsValid(
    	ChainId id
    ) {
    	return chain_IsValid(
    		id.memorySegment()
    	);
    }

}