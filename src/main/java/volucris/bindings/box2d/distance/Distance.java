/*
 * MACHINE GENERATED FILE, DO NOT EDIT.
 */
package volucris.bindings.box2d.distance;

import edu.umd.cs.findbugs.annotations.Nullable;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.SegmentAllocator;
import java.lang.invoke.MethodHandle;
import volucris.bindings.box2d.geometry.CastOutput;
import volucris.bindings.box2d.geometry.ShapeProxy;
import volucris.bindings.box2d.math.Rot;
import volucris.bindings.box2d.math.Transform;
import volucris.bindings.box2d.math.Vec2;

import static java.lang.foreign.ValueLayout.*;
import static volucris.bindings.core.FFMUtils.*;

/**
 * 
 */
public final class Distance {

    private static final LazyConstant<MethodHandle> B2_SEGMENT_DISTANCE;
    private static final LazyConstant<MethodHandle> B2_SHAPE_DISTANCE;
    private static final LazyConstant<MethodHandle> B2_SHAPE_CAST;
    private static final LazyConstant<MethodHandle> B2_MAKE_PROXY;
    private static final LazyConstant<MethodHandle> B2_MAKE_OFFSET_PROXY;
    private static final LazyConstant<MethodHandle> B2_GET_SWEEP_TRANSFORM;
    private static final LazyConstant<MethodHandle> B2_TIME_OF_IMPACT;

    static {
        //@formatter:off
        B2_SEGMENT_DISTANCE = downcallHandle("b2SegmentDistance", SegmentDistanceResult.LAYOUT, Vec2.LAYOUT, Vec2.LAYOUT, Vec2.LAYOUT, Vec2.LAYOUT);
        B2_SHAPE_DISTANCE = downcallHandle("b2ShapeDistance", DistanceOutput.LAYOUT, UNBOUNDED_ADDRESS, UNBOUNDED_ADDRESS, UNBOUNDED_ADDRESS, JAVA_INT);
        B2_SHAPE_CAST = downcallHandle("b2ShapeCast", CastOutput.LAYOUT, UNBOUNDED_ADDRESS);
        B2_MAKE_PROXY = downcallHandle("b2MakeProxy", ShapeProxy.LAYOUT, UNBOUNDED_ADDRESS, JAVA_INT, JAVA_FLOAT);
        B2_MAKE_OFFSET_PROXY = downcallHandle("b2MakeOffsetProxy", ShapeProxy.LAYOUT, UNBOUNDED_ADDRESS, JAVA_INT, JAVA_FLOAT, Vec2.LAYOUT, Rot.LAYOUT);
        B2_GET_SWEEP_TRANSFORM = downcallHandle("b2GetSweepTransform", Transform.LAYOUT, UNBOUNDED_ADDRESS, JAVA_FLOAT);
        B2_TIME_OF_IMPACT = downcallHandle("b2TimeOfImpact", TOIOutput.LAYOUT, UNBOUNDED_ADDRESS);
        //@formatter:on
    }

    private Distance() {
    }

    /**
     * Compute the distance between two line segments, clamping at the end points if needed.
     */
    public static MemorySegment segmentDistance(
        SegmentAllocator allocator,
        MemorySegment p1, 
        MemorySegment q1, 
        MemorySegment p2, 
        MemorySegment q2
    ) {
        MethodHandle method = B2_SEGMENT_DISTANCE.get();
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
    
    /**
     * Typed method of {@link #segmentDistance}.
     */
    public static @Nullable SegmentDistanceResult segmentDistance(
        SegmentAllocator allocator,
        Vec2 p1, 
        Vec2 q1, 
        Vec2 p2, 
        Vec2 q2
    ) {
        MemorySegment segment = segmentDistance(
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
    
    /**
     * Compute the closest points between two shapes represented as point clouds. b2SimplexCache cache is input/output. On the first call set b2SimplexCache.count to zero. The underlying GJK algorithm may be debugged by passing in debug simplexes and capacity. You may pass in NULL and 0 for these.
     */
    public static MemorySegment shapeDistance(
        SegmentAllocator allocator,
        MemorySegment input, 
        MemorySegment cache, 
        MemorySegment simplexes, 
        int simplexCapacity
    ) {
        MethodHandle method = B2_SHAPE_DISTANCE.get();
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
    
    /**
     * Typed method of {@link #shapeDistance}.
     */
    public static @Nullable DistanceOutput shapeDistance(
        SegmentAllocator allocator,
        DistanceInput input, 
        SimplexCache cache, 
        Simplex simplexes, 
        int simplexCapacity
    ) {
        MemorySegment segment = shapeDistance(
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
    
    /**
     * Perform a linear shape cast of shape B moving and shape A fixed. Determines the hit point, normal, and translation fraction. Initially touching shapes are treated as a miss.
     */
    public static MemorySegment shapeCast(
        SegmentAllocator allocator,
        MemorySegment input
    ) {
        MethodHandle method = B2_SHAPE_CAST.get();
        try {
            return (MemorySegment) method.invokeExact(
                allocator,
                input
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #shapeCast}.
     */
    public static @Nullable CastOutput shapeCast(
        SegmentAllocator allocator,
        ShapeCastPairInput input
    ) {
        MemorySegment segment = shapeCast(
            allocator,
            input.memorySegment()
        );
    
        if (segment.equals(MemorySegment.NULL))
            return null;
    
        return new CastOutput(segment);
    }
    
    /**
     * Make a proxy for use in overlap, shape cast, and related functions. This is a deep copy of the points.
     */
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
    
    /**
     * Typed method of {@link #makeProxy}.
     */
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
    
    /**
     * Make a proxy with a transform. This is a deep copy of the points.
     */
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
    
    /**
     * Typed method of {@link #makeOffsetProxy}.
     */
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
    
    /**
     * Evaluate the transform sweep at a specific time.
     */
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
    
    /**
     * Typed method of {@link #getSweepTransform}.
     */
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
    
    /**
     * Compute the upper bound on time before two shapes penetrate. Time is represented as a fraction between [0,tMax]. This uses a swept separating axis and may miss some intermediate, non-tunneling collisions. If you change the time interval, you should call this function again.
     */
    public static MemorySegment timeOfImpact(
        SegmentAllocator allocator,
        MemorySegment input
    ) {
        MethodHandle method = B2_TIME_OF_IMPACT.get();
        try {
            return (MemorySegment) method.invokeExact(
                allocator,
                input
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #timeOfImpact}.
     */
    public static @Nullable TOIOutput timeOfImpact(
        SegmentAllocator allocator,
        TOIInput input
    ) {
        MemorySegment segment = timeOfImpact(
            allocator,
            input.memorySegment()
        );
    
        if (segment.equals(MemorySegment.NULL))
            return null;
    
        return new TOIOutput(segment);
    }
    
}