/*
 * MACHINE GENERATED FILE, DO NOT EDIT.
 */
package volucris.bindings.box2d.distance;

import java.lang.foreign.MemorySegment;
import java.lang.foreign.SegmentAllocator;
import java.lang.invoke.MethodHandle;
import org.jspecify.annotations.Nullable;
import volucris.bindings.box2d.geometry.CastOutput;
import volucris.bindings.box2d.geometry.ShapeProxy;
import volucris.bindings.box2d.math.Rot;
import volucris.bindings.box2d.math.Transform;
import volucris.bindings.box2d.math.Vec2;

import static java.lang.foreign.ValueLayout.*;
import static volucris.bindings.core.FFMUtils.*;

public final class Distance {

	private static final LazyConstant<MethodHandle> B2_COMPUTE_SEGMENT_DISTANCE;
	private static final LazyConstant<MethodHandle> B2_COMPUTE_SHAPE_DISTANCE;
	private static final LazyConstant<MethodHandle> B2_CAST_SHAPE;
	private static final LazyConstant<MethodHandle> B2_MAKE_PROXY;
	private static final LazyConstant<MethodHandle> B2_MAKE_OFFSET_PROXY;
	private static final LazyConstant<MethodHandle> B2_GET_SWEEP_TRANSFORM;
	private static final LazyConstant<MethodHandle> B2_COMPUTE_TIME_OF_IMPACT;

	static {
		//@formatter:off
		B2_COMPUTE_SEGMENT_DISTANCE = downcallHandle("b2ComputeSegmentDistance", SegmentDistanceResult.LAYOUT, Vec2.LAYOUT, Vec2.LAYOUT, Vec2.LAYOUT, Vec2.LAYOUT);
		B2_COMPUTE_SHAPE_DISTANCE = downcallHandle("b2ComputeShapeDistance", DistanceOutput.LAYOUT, UNBOUNDED_ADDRESS, UNBOUNDED_ADDRESS, UNBOUNDED_ADDRESS, JAVA_INT);
		B2_CAST_SHAPE = downcallHandle("b2CastShape", CastOutput.LAYOUT, UNBOUNDED_ADDRESS);
		B2_MAKE_PROXY = downcallHandle("b2MakeProxy", ShapeProxy.LAYOUT, UNBOUNDED_ADDRESS, JAVA_INT, JAVA_FLOAT);
		B2_MAKE_OFFSET_PROXY = downcallHandle("b2MakeOffsetProxy", ShapeProxy.LAYOUT, UNBOUNDED_ADDRESS, JAVA_INT, JAVA_FLOAT, Vec2.LAYOUT, Rot.LAYOUT);
		B2_GET_SWEEP_TRANSFORM = downcallHandle("b2GetSweepTransform", Transform.LAYOUT, UNBOUNDED_ADDRESS, JAVA_FLOAT);
		B2_COMPUTE_TIME_OF_IMPACT = downcallHandle("b2ComputeTimeOfImpact", TOIOutput.LAYOUT, UNBOUNDED_ADDRESS);
		//@formatter:on
	}

	private Distance() {
	}

    /// ```
    /// Compute the distance between two line segments, clamping at the end points if needed.
    /// ```
    public static MemorySegment computeSegmentDistance(
    	SegmentAllocator allocator,
    	MemorySegment p1,
    	MemorySegment q1,
    	MemorySegment p2,
    	MemorySegment q2
    ) {
    	MethodHandle method = B2_COMPUTE_SEGMENT_DISTANCE.get();
    	try {
    		return (MemorySegment) method.invokeExact(
    			allocator,
    			p1,
    			q1,
    			p2,
    			q2
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#computeSegmentDistance].
    public static @Nullable SegmentDistanceResult computeSegmentDistance(
    	SegmentAllocator allocator,
    	Vec2 p1,
    	Vec2 q1,
    	Vec2 p2,
    	Vec2 q2
    ) {
    	MemorySegment segment = computeSegmentDistance(
    		allocator,
    		p1.memorySegment(),
    		q1.memorySegment(),
    		p2.memorySegment(),
    		q2.memorySegment()
    	);
    
    	if (segment.equals(MemorySegment.NULL))
    		return null;
    	
    	return new SegmentDistanceResult(segment);
    }
    
    /// ```
    /// Compute the closest points between two shapes represented as point clouds. b2SimplexCache cache
    /// is input/output. On the first call set b2SimplexCache.count to zero. The underlying GJK
    /// algorithm may be debugged by passing in debug simplexes and capacity. You may pass in NULL and 0
    /// for these.
    /// ```
    public static MemorySegment computeShapeDistance(
    	SegmentAllocator allocator,
    	MemorySegment input,
    	MemorySegment cache,
    	MemorySegment simplexes,
    	int simplexCapacity
    ) {
    	MethodHandle method = B2_COMPUTE_SHAPE_DISTANCE.get();
    	try {
    		return (MemorySegment) method.invokeExact(
    			allocator,
    			input,
    			cache,
    			simplexes,
    			simplexCapacity
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#computeShapeDistance].
    public static @Nullable DistanceOutput computeShapeDistance(
    	SegmentAllocator allocator,
    	DistanceInput input,
    	SimplexCache cache,
    	Simplex simplexes,
    	int simplexCapacity
    ) {
    	MemorySegment segment = computeShapeDistance(
    		allocator,
    		input.memorySegment(),
    		cache.memorySegment(),
    		simplexes.memorySegment(),
    		simplexCapacity
    	);
    
    	if (segment.equals(MemorySegment.NULL))
    		return null;
    	
    	return new DistanceOutput(segment);
    }
    
    /// ```
    /// Perform a linear shape cast of shape B moving and shape A fixed. Determines the hit point,
    /// normal, and translation fraction. The query runs in frame A, so the hit point and normal are
    /// returned in frame A. Initially touching shapes return a zero fraction in the output.
    /// ```
    public static MemorySegment castShape(
    	SegmentAllocator allocator,
    	MemorySegment input
    ) {
    	MethodHandle method = B2_CAST_SHAPE.get();
    	try {
    		return (MemorySegment) method.invokeExact(
    			allocator,
    			input
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#castShape].
    public static @Nullable CastOutput castShape(
    	SegmentAllocator allocator,
    	ShapeCastPairInput input
    ) {
    	MemorySegment segment = castShape(
    		allocator,
    		input.memorySegment()
    	);
    
    	if (segment.equals(MemorySegment.NULL))
    		return null;
    	
    	return new CastOutput(segment);
    }
    
    /// ```
    /// Make a proxy for use in overlap, shape cast, and related functions. This is a deep copy of the
    /// points.
    /// ```
    public static MemorySegment makeProxy(
    	SegmentAllocator allocator,
    	MemorySegment points,
    	int count,
    	float radius
    ) {
    	MethodHandle method = B2_MAKE_PROXY.get();
    	try {
    		return (MemorySegment) method.invokeExact(
    			allocator,
    			points,
    			count,
    			radius
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#makeProxy].
    public static @Nullable ShapeProxy makeProxy(
    	SegmentAllocator allocator,
    	Vec2 points,
    	int count,
    	float radius
    ) {
    	MemorySegment segment = makeProxy(
    		allocator,
    		points.memorySegment(),
    		count,
    		radius
    	);
    
    	if (segment.equals(MemorySegment.NULL))
    		return null;
    	
    	return new ShapeProxy(segment);
    }
    
    /// ```
    /// Make a proxy with a transform. This is a deep copy of the points.
    /// ```
    public static MemorySegment makeOffsetProxy(
    	SegmentAllocator allocator,
    	MemorySegment points,
    	int count,
    	float radius,
    	MemorySegment position,
    	MemorySegment rotation
    ) {
    	MethodHandle method = B2_MAKE_OFFSET_PROXY.get();
    	try {
    		return (MemorySegment) method.invokeExact(
    			allocator,
    			points,
    			count,
    			radius,
    			position,
    			rotation
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#makeOffsetProxy].
    public static @Nullable ShapeProxy makeOffsetProxy(
    	SegmentAllocator allocator,
    	Vec2 points,
    	int count,
    	float radius,
    	Vec2 position,
    	Rot rotation
    ) {
    	MemorySegment segment = makeOffsetProxy(
    		allocator,
    		points.memorySegment(),
    		count,
    		radius,
    		position.memorySegment(),
    		rotation.memorySegment()
    	);
    
    	if (segment.equals(MemorySegment.NULL))
    		return null;
    	
    	return new ShapeProxy(segment);
    }
    
    /// ```
    /// Evaluate the transform sweep at a specific time.
    /// ```
    public static MemorySegment getSweepTransform(
    	SegmentAllocator allocator,
    	MemorySegment sweep,
    	float time
    ) {
    	MethodHandle method = B2_GET_SWEEP_TRANSFORM.get();
    	try {
    		return (MemorySegment) method.invokeExact(
    			allocator,
    			sweep,
    			time
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#getSweepTransform].
    public static @Nullable Transform getSweepTransform(
    	SegmentAllocator allocator,
    	Sweep sweep,
    	float time
    ) {
    	MemorySegment segment = getSweepTransform(
    		allocator,
    		sweep.memorySegment(),
    		time
    	);
    
    	if (segment.equals(MemorySegment.NULL))
    		return null;
    	
    	return new Transform(segment);
    }
    
    /// ```
    /// Compute the upper bound on time before two shapes penetrate. Time is represented as a fraction
    /// between [0,maxFraction]. This uses a swept separating axis and may miss some intermediate,
    /// non-tunneling collisions. If you change the time interval, you should call this function again.
    /// ```
    public static MemorySegment computeTimeOfImpact(
    	SegmentAllocator allocator,
    	MemorySegment input
    ) {
    	MethodHandle method = B2_COMPUTE_TIME_OF_IMPACT.get();
    	try {
    		return (MemorySegment) method.invokeExact(
    			allocator,
    			input
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#computeTimeOfImpact].
    public static @Nullable TOIOutput computeTimeOfImpact(
    	SegmentAllocator allocator,
    	TOIInput input
    ) {
    	MemorySegment segment = computeTimeOfImpact(
    		allocator,
    		input.memorySegment()
    	);
    
    	if (segment.equals(MemorySegment.NULL))
    		return null;
    	
    	return new TOIOutput(segment);
    }

}