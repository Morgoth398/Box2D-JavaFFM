/*
 * MACHINE GENERATED FILE, DO NOT EDIT.
 */
package volucris.bindings.box2d.collision;

import java.lang.foreign.MemorySegment;
import java.lang.foreign.SegmentAllocator;
import java.lang.invoke.MethodHandle;
import org.jspecify.annotations.Nullable;
import volucris.bindings.box2d.distance.SimplexCache;
import volucris.bindings.box2d.geometry.Capsule;
import volucris.bindings.box2d.geometry.ChainSegment;
import volucris.bindings.box2d.geometry.Circle;
import volucris.bindings.box2d.geometry.Polygon;
import volucris.bindings.box2d.geometry.Segment;
import volucris.bindings.box2d.math.Transform;

import static volucris.bindings.core.FFMUtils.*;

public final class Collision {

	private static final LazyConstant<MethodHandle> B2_COLLIDE_CIRCLES;
	private static final LazyConstant<MethodHandle> B2_COLLIDE_CAPSULE_AND_CIRCLE;
	private static final LazyConstant<MethodHandle> B2_COLLIDE_SEGMENT_AND_CIRCLE;
	private static final LazyConstant<MethodHandle> B2_COLLIDE_POLYGON_AND_CIRCLE;
	private static final LazyConstant<MethodHandle> B2_COLLIDE_CAPSULES;
	private static final LazyConstant<MethodHandle> B2_COLLIDE_SEGMENT_AND_CAPSULE;
	private static final LazyConstant<MethodHandle> B2_COLLIDE_POLYGON_AND_CAPSULE;
	private static final LazyConstant<MethodHandle> B2_COLLIDE_POLYGONS;
	private static final LazyConstant<MethodHandle> B2_COLLIDE_SEGMENT_AND_POLYGON;
	private static final LazyConstant<MethodHandle> B2_COLLIDE_CHAIN_SEGMENT_AND_CIRCLE;
	private static final LazyConstant<MethodHandle> B2_COLLIDE_CHAIN_SEGMENT_AND_CAPSULE;
	private static final LazyConstant<MethodHandle> B2_COLLIDE_CHAIN_SEGMENT_AND_POLYGON;

	static {
		//@formatter:off
		B2_COLLIDE_CIRCLES = downcallHandle("b2CollideCircles", LocalManifold.LAYOUT, UNBOUNDED_ADDRESS, UNBOUNDED_ADDRESS, Transform.LAYOUT);
		B2_COLLIDE_CAPSULE_AND_CIRCLE = downcallHandle("b2CollideCapsuleAndCircle", LocalManifold.LAYOUT, UNBOUNDED_ADDRESS, UNBOUNDED_ADDRESS, Transform.LAYOUT);
		B2_COLLIDE_SEGMENT_AND_CIRCLE = downcallHandle("b2CollideSegmentAndCircle", LocalManifold.LAYOUT, UNBOUNDED_ADDRESS, UNBOUNDED_ADDRESS, Transform.LAYOUT);
		B2_COLLIDE_POLYGON_AND_CIRCLE = downcallHandle("b2CollidePolygonAndCircle", LocalManifold.LAYOUT, UNBOUNDED_ADDRESS, UNBOUNDED_ADDRESS, Transform.LAYOUT);
		B2_COLLIDE_CAPSULES = downcallHandle("b2CollideCapsules", LocalManifold.LAYOUT, UNBOUNDED_ADDRESS, UNBOUNDED_ADDRESS, Transform.LAYOUT);
		B2_COLLIDE_SEGMENT_AND_CAPSULE = downcallHandle("b2CollideSegmentAndCapsule", LocalManifold.LAYOUT, UNBOUNDED_ADDRESS, UNBOUNDED_ADDRESS, Transform.LAYOUT);
		B2_COLLIDE_POLYGON_AND_CAPSULE = downcallHandle("b2CollidePolygonAndCapsule", LocalManifold.LAYOUT, UNBOUNDED_ADDRESS, UNBOUNDED_ADDRESS, Transform.LAYOUT);
		B2_COLLIDE_POLYGONS = downcallHandle("b2CollidePolygons", LocalManifold.LAYOUT, UNBOUNDED_ADDRESS, UNBOUNDED_ADDRESS, Transform.LAYOUT);
		B2_COLLIDE_SEGMENT_AND_POLYGON = downcallHandle("b2CollideSegmentAndPolygon", LocalManifold.LAYOUT, UNBOUNDED_ADDRESS, UNBOUNDED_ADDRESS, Transform.LAYOUT);
		B2_COLLIDE_CHAIN_SEGMENT_AND_CIRCLE = downcallHandle("b2CollideChainSegmentAndCircle", LocalManifold.LAYOUT, UNBOUNDED_ADDRESS, UNBOUNDED_ADDRESS, Transform.LAYOUT);
		B2_COLLIDE_CHAIN_SEGMENT_AND_CAPSULE = downcallHandle("b2CollideChainSegmentAndCapsule", LocalManifold.LAYOUT, UNBOUNDED_ADDRESS, UNBOUNDED_ADDRESS, Transform.LAYOUT, UNBOUNDED_ADDRESS);
		B2_COLLIDE_CHAIN_SEGMENT_AND_POLYGON = downcallHandle("b2CollideChainSegmentAndPolygon", LocalManifold.LAYOUT, UNBOUNDED_ADDRESS, UNBOUNDED_ADDRESS, Transform.LAYOUT, UNBOUNDED_ADDRESS);
		//@formatter:on
	}

	private Collision() {
	}

    /// ```
    /// Compute the contact manifold between two circles
    /// ```
    public static MemorySegment collideCircles(
    	SegmentAllocator allocator,
    	MemorySegment circleA,
    	MemorySegment circleB,
    	MemorySegment xf
    ) {
    	MethodHandle method = B2_COLLIDE_CIRCLES.get();
    	try {
    		return (MemorySegment) method.invokeExact(
    			allocator,
    			circleA,
    			circleB,
    			xf
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#collideCircles].
    public static @Nullable LocalManifold collideCircles(
    	SegmentAllocator allocator,
    	Circle circleA,
    	Circle circleB,
    	Transform xf
    ) {
    	MemorySegment segment = collideCircles(
    		allocator,
    		circleA.memorySegment(),
    		circleB.memorySegment(),
    		xf.memorySegment()
    	);
    
    	if (segment.equals(MemorySegment.NULL))
    		return null;
    	
    	return new LocalManifold(segment);
    }
    
    /// ```
    /// Compute the contact manifold between a capsule and circle
    /// ```
    public static MemorySegment collideCapsuleAndCircle(
    	SegmentAllocator allocator,
    	MemorySegment capsuleA,
    	MemorySegment circleB,
    	MemorySegment xf
    ) {
    	MethodHandle method = B2_COLLIDE_CAPSULE_AND_CIRCLE.get();
    	try {
    		return (MemorySegment) method.invokeExact(
    			allocator,
    			capsuleA,
    			circleB,
    			xf
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#collideCapsuleAndCircle].
    public static @Nullable LocalManifold collideCapsuleAndCircle(
    	SegmentAllocator allocator,
    	Capsule capsuleA,
    	Circle circleB,
    	Transform xf
    ) {
    	MemorySegment segment = collideCapsuleAndCircle(
    		allocator,
    		capsuleA.memorySegment(),
    		circleB.memorySegment(),
    		xf.memorySegment()
    	);
    
    	if (segment.equals(MemorySegment.NULL))
    		return null;
    	
    	return new LocalManifold(segment);
    }
    
    /// ```
    /// Compute the contact manifold between a segment and a circle
    /// ```
    public static MemorySegment collideSegmentAndCircle(
    	SegmentAllocator allocator,
    	MemorySegment segmentA,
    	MemorySegment circleB,
    	MemorySegment xf
    ) {
    	MethodHandle method = B2_COLLIDE_SEGMENT_AND_CIRCLE.get();
    	try {
    		return (MemorySegment) method.invokeExact(
    			allocator,
    			segmentA,
    			circleB,
    			xf
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#collideSegmentAndCircle].
    public static @Nullable LocalManifold collideSegmentAndCircle(
    	SegmentAllocator allocator,
    	Segment segmentA,
    	Circle circleB,
    	Transform xf
    ) {
    	MemorySegment segment = collideSegmentAndCircle(
    		allocator,
    		segmentA.memorySegment(),
    		circleB.memorySegment(),
    		xf.memorySegment()
    	);
    
    	if (segment.equals(MemorySegment.NULL))
    		return null;
    	
    	return new LocalManifold(segment);
    }
    
    /// ```
    /// Compute the contact manifold between a polygon and a circle
    /// ```
    public static MemorySegment collidePolygonAndCircle(
    	SegmentAllocator allocator,
    	MemorySegment polygonA,
    	MemorySegment circleB,
    	MemorySegment xf
    ) {
    	MethodHandle method = B2_COLLIDE_POLYGON_AND_CIRCLE.get();
    	try {
    		return (MemorySegment) method.invokeExact(
    			allocator,
    			polygonA,
    			circleB,
    			xf
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#collidePolygonAndCircle].
    public static @Nullable LocalManifold collidePolygonAndCircle(
    	SegmentAllocator allocator,
    	Polygon polygonA,
    	Circle circleB,
    	Transform xf
    ) {
    	MemorySegment segment = collidePolygonAndCircle(
    		allocator,
    		polygonA.memorySegment(),
    		circleB.memorySegment(),
    		xf.memorySegment()
    	);
    
    	if (segment.equals(MemorySegment.NULL))
    		return null;
    	
    	return new LocalManifold(segment);
    }
    
    /// ```
    /// Compute the contact manifold between two capsules
    /// ```
    public static MemorySegment collideCapsules(
    	SegmentAllocator allocator,
    	MemorySegment capsuleA,
    	MemorySegment capsuleB,
    	MemorySegment xf
    ) {
    	MethodHandle method = B2_COLLIDE_CAPSULES.get();
    	try {
    		return (MemorySegment) method.invokeExact(
    			allocator,
    			capsuleA,
    			capsuleB,
    			xf
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#collideCapsules].
    public static @Nullable LocalManifold collideCapsules(
    	SegmentAllocator allocator,
    	Capsule capsuleA,
    	Capsule capsuleB,
    	Transform xf
    ) {
    	MemorySegment segment = collideCapsules(
    		allocator,
    		capsuleA.memorySegment(),
    		capsuleB.memorySegment(),
    		xf.memorySegment()
    	);
    
    	if (segment.equals(MemorySegment.NULL))
    		return null;
    	
    	return new LocalManifold(segment);
    }
    
    /// ```
    /// Compute the contact manifold between a segment and a capsule
    /// ```
    public static MemorySegment collideSegmentAndCapsule(
    	SegmentAllocator allocator,
    	MemorySegment segmentA,
    	MemorySegment capsuleB,
    	MemorySegment xf
    ) {
    	MethodHandle method = B2_COLLIDE_SEGMENT_AND_CAPSULE.get();
    	try {
    		return (MemorySegment) method.invokeExact(
    			allocator,
    			segmentA,
    			capsuleB,
    			xf
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#collideSegmentAndCapsule].
    public static @Nullable LocalManifold collideSegmentAndCapsule(
    	SegmentAllocator allocator,
    	Segment segmentA,
    	Capsule capsuleB,
    	Transform xf
    ) {
    	MemorySegment segment = collideSegmentAndCapsule(
    		allocator,
    		segmentA.memorySegment(),
    		capsuleB.memorySegment(),
    		xf.memorySegment()
    	);
    
    	if (segment.equals(MemorySegment.NULL))
    		return null;
    	
    	return new LocalManifold(segment);
    }
    
    /// ```
    /// Compute the contact manifold between a polygon and capsule
    /// ```
    public static MemorySegment collidePolygonAndCapsule(
    	SegmentAllocator allocator,
    	MemorySegment polygonA,
    	MemorySegment capsuleB,
    	MemorySegment xf
    ) {
    	MethodHandle method = B2_COLLIDE_POLYGON_AND_CAPSULE.get();
    	try {
    		return (MemorySegment) method.invokeExact(
    			allocator,
    			polygonA,
    			capsuleB,
    			xf
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#collidePolygonAndCapsule].
    public static @Nullable LocalManifold collidePolygonAndCapsule(
    	SegmentAllocator allocator,
    	Polygon polygonA,
    	Capsule capsuleB,
    	Transform xf
    ) {
    	MemorySegment segment = collidePolygonAndCapsule(
    		allocator,
    		polygonA.memorySegment(),
    		capsuleB.memorySegment(),
    		xf.memorySegment()
    	);
    
    	if (segment.equals(MemorySegment.NULL))
    		return null;
    	
    	return new LocalManifold(segment);
    }
    
    /// ```
    /// Compute the contact manifold between two polygons
    /// ```
    public static MemorySegment collidePolygons(
    	SegmentAllocator allocator,
    	MemorySegment polygonA,
    	MemorySegment polygonB,
    	MemorySegment xf
    ) {
    	MethodHandle method = B2_COLLIDE_POLYGONS.get();
    	try {
    		return (MemorySegment) method.invokeExact(
    			allocator,
    			polygonA,
    			polygonB,
    			xf
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#collidePolygons].
    public static @Nullable LocalManifold collidePolygons(
    	SegmentAllocator allocator,
    	Polygon polygonA,
    	Polygon polygonB,
    	Transform xf
    ) {
    	MemorySegment segment = collidePolygons(
    		allocator,
    		polygonA.memorySegment(),
    		polygonB.memorySegment(),
    		xf.memorySegment()
    	);
    
    	if (segment.equals(MemorySegment.NULL))
    		return null;
    	
    	return new LocalManifold(segment);
    }
    
    /// ```
    /// Compute the contact manifold between a segment and a polygon
    /// ```
    public static MemorySegment collideSegmentAndPolygon(
    	SegmentAllocator allocator,
    	MemorySegment segmentA,
    	MemorySegment polygonB,
    	MemorySegment xf
    ) {
    	MethodHandle method = B2_COLLIDE_SEGMENT_AND_POLYGON.get();
    	try {
    		return (MemorySegment) method.invokeExact(
    			allocator,
    			segmentA,
    			polygonB,
    			xf
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#collideSegmentAndPolygon].
    public static @Nullable LocalManifold collideSegmentAndPolygon(
    	SegmentAllocator allocator,
    	Segment segmentA,
    	Polygon polygonB,
    	Transform xf
    ) {
    	MemorySegment segment = collideSegmentAndPolygon(
    		allocator,
    		segmentA.memorySegment(),
    		polygonB.memorySegment(),
    		xf.memorySegment()
    	);
    
    	if (segment.equals(MemorySegment.NULL))
    		return null;
    	
    	return new LocalManifold(segment);
    }
    
    /// ```
    /// Compute the contact manifold between a chain segment and a circle
    /// ```
    public static MemorySegment collideChainSegmentAndCircle(
    	SegmentAllocator allocator,
    	MemorySegment segmentA,
    	MemorySegment circleB,
    	MemorySegment xf
    ) {
    	MethodHandle method = B2_COLLIDE_CHAIN_SEGMENT_AND_CIRCLE.get();
    	try {
    		return (MemorySegment) method.invokeExact(
    			allocator,
    			segmentA,
    			circleB,
    			xf
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#collideChainSegmentAndCircle].
    public static @Nullable LocalManifold collideChainSegmentAndCircle(
    	SegmentAllocator allocator,
    	ChainSegment segmentA,
    	Circle circleB,
    	Transform xf
    ) {
    	MemorySegment segment = collideChainSegmentAndCircle(
    		allocator,
    		segmentA.memorySegment(),
    		circleB.memorySegment(),
    		xf.memorySegment()
    	);
    
    	if (segment.equals(MemorySegment.NULL))
    		return null;
    	
    	return new LocalManifold(segment);
    }
    
    /// ```
    /// Compute the contact manifold between a chain segment and a capsule
    /// ```
    public static MemorySegment collideChainSegmentAndCapsule(
    	SegmentAllocator allocator,
    	MemorySegment segmentA,
    	MemorySegment capsuleB,
    	MemorySegment xf,
    	MemorySegment cache
    ) {
    	MethodHandle method = B2_COLLIDE_CHAIN_SEGMENT_AND_CAPSULE.get();
    	try {
    		return (MemorySegment) method.invokeExact(
    			allocator,
    			segmentA,
    			capsuleB,
    			xf,
    			cache
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#collideChainSegmentAndCapsule].
    public static @Nullable LocalManifold collideChainSegmentAndCapsule(
    	SegmentAllocator allocator,
    	ChainSegment segmentA,
    	Capsule capsuleB,
    	Transform xf,
    	SimplexCache cache
    ) {
    	MemorySegment segment = collideChainSegmentAndCapsule(
    		allocator,
    		segmentA.memorySegment(),
    		capsuleB.memorySegment(),
    		xf.memorySegment(),
    		cache.memorySegment()
    	);
    
    	if (segment.equals(MemorySegment.NULL))
    		return null;
    	
    	return new LocalManifold(segment);
    }
    
    /// ```
    /// Compute the contact manifold between a chain segment and a rounded polygon
    /// ```
    public static MemorySegment collideChainSegmentAndPolygon(
    	SegmentAllocator allocator,
    	MemorySegment segmentA,
    	MemorySegment polygonB,
    	MemorySegment xf,
    	MemorySegment cache
    ) {
    	MethodHandle method = B2_COLLIDE_CHAIN_SEGMENT_AND_POLYGON.get();
    	try {
    		return (MemorySegment) method.invokeExact(
    			allocator,
    			segmentA,
    			polygonB,
    			xf,
    			cache
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#collideChainSegmentAndPolygon].
    public static @Nullable LocalManifold collideChainSegmentAndPolygon(
    	SegmentAllocator allocator,
    	ChainSegment segmentA,
    	Polygon polygonB,
    	Transform xf,
    	SimplexCache cache
    ) {
    	MemorySegment segment = collideChainSegmentAndPolygon(
    		allocator,
    		segmentA.memorySegment(),
    		polygonB.memorySegment(),
    		xf.memorySegment(),
    		cache.memorySegment()
    	);
    
    	if (segment.equals(MemorySegment.NULL))
    		return null;
    	
    	return new LocalManifold(segment);
    }

}