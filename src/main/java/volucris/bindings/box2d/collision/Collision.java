/*
 * MACHINE GENERATED FILE, DO NOT EDIT.
 */
package volucris.bindings.box2d.collision;

import edu.umd.cs.findbugs.annotations.Nullable;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.SegmentAllocator;
import java.lang.invoke.MethodHandle;
import volucris.bindings.box2d.distance.SimplexCache;
import volucris.bindings.box2d.geometry.Capsule;
import volucris.bindings.box2d.geometry.ChainSegment;
import volucris.bindings.box2d.geometry.Circle;
import volucris.bindings.box2d.geometry.Polygon;
import volucris.bindings.box2d.geometry.Segment;
import volucris.bindings.box2d.math.Transform;

import static volucris.bindings.core.FFMUtils.*;

/**
 * 
 */
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
        B2_COLLIDE_CIRCLES = downcallHandle("b2CollideCircles", Manifold.LAYOUT, UNBOUNDED_ADDRESS, Transform.LAYOUT, UNBOUNDED_ADDRESS, Transform.LAYOUT);
        B2_COLLIDE_CAPSULE_AND_CIRCLE = downcallHandle("b2CollideCapsuleAndCircle", Manifold.LAYOUT, UNBOUNDED_ADDRESS, Transform.LAYOUT, UNBOUNDED_ADDRESS, Transform.LAYOUT);
        B2_COLLIDE_SEGMENT_AND_CIRCLE = downcallHandle("b2CollideSegmentAndCircle", Manifold.LAYOUT, UNBOUNDED_ADDRESS, Transform.LAYOUT, UNBOUNDED_ADDRESS, Transform.LAYOUT);
        B2_COLLIDE_POLYGON_AND_CIRCLE = downcallHandle("b2CollidePolygonAndCircle", Manifold.LAYOUT, UNBOUNDED_ADDRESS, Transform.LAYOUT, UNBOUNDED_ADDRESS, Transform.LAYOUT);
        B2_COLLIDE_CAPSULES = downcallHandle("b2CollideCapsules", Manifold.LAYOUT, UNBOUNDED_ADDRESS, Transform.LAYOUT, UNBOUNDED_ADDRESS, Transform.LAYOUT);
        B2_COLLIDE_SEGMENT_AND_CAPSULE = downcallHandle("b2CollideSegmentAndCapsule", Manifold.LAYOUT, UNBOUNDED_ADDRESS, Transform.LAYOUT, UNBOUNDED_ADDRESS, Transform.LAYOUT);
        B2_COLLIDE_POLYGON_AND_CAPSULE = downcallHandle("b2CollidePolygonAndCapsule", Manifold.LAYOUT, UNBOUNDED_ADDRESS, Transform.LAYOUT, UNBOUNDED_ADDRESS, Transform.LAYOUT);
        B2_COLLIDE_POLYGONS = downcallHandle("b2CollidePolygons", Manifold.LAYOUT, UNBOUNDED_ADDRESS, Transform.LAYOUT, UNBOUNDED_ADDRESS, Transform.LAYOUT);
        B2_COLLIDE_SEGMENT_AND_POLYGON = downcallHandle("b2CollideSegmentAndPolygon", Manifold.LAYOUT, UNBOUNDED_ADDRESS, Transform.LAYOUT, UNBOUNDED_ADDRESS, Transform.LAYOUT);
        B2_COLLIDE_CHAIN_SEGMENT_AND_CIRCLE = downcallHandle("b2CollideChainSegmentAndCircle", Manifold.LAYOUT, UNBOUNDED_ADDRESS, Transform.LAYOUT, UNBOUNDED_ADDRESS, Transform.LAYOUT);
        B2_COLLIDE_CHAIN_SEGMENT_AND_CAPSULE = downcallHandle("b2CollideChainSegmentAndCapsule", Manifold.LAYOUT, UNBOUNDED_ADDRESS, Transform.LAYOUT, UNBOUNDED_ADDRESS, Transform.LAYOUT, UNBOUNDED_ADDRESS);
        B2_COLLIDE_CHAIN_SEGMENT_AND_POLYGON = downcallHandle("b2CollideChainSegmentAndPolygon", Manifold.LAYOUT, UNBOUNDED_ADDRESS, Transform.LAYOUT, UNBOUNDED_ADDRESS, Transform.LAYOUT, UNBOUNDED_ADDRESS);
        //@formatter:on
    }

    private Collision() {
    }

    /**
     * Compute the contact manifold between two circles
     */
    public static MemorySegment collideCircles(
        SegmentAllocator allocator,
        MemorySegment circleA, 
        MemorySegment xfA, 
        MemorySegment circleB, 
        MemorySegment xfB
    ) {
        MethodHandle method = B2_COLLIDE_CIRCLES.get();
        try {
            return (MemorySegment) method.invokeExact(
                allocator,
                circleA, 
                xfA, 
                circleB, 
                xfB
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #collideCircles}.
     */
    public static @Nullable Manifold collideCircles(
        SegmentAllocator allocator,
        Circle circleA, 
        Transform xfA, 
        Circle circleB, 
        Transform xfB
    ) {
        MemorySegment segment = collideCircles(
            allocator,
            circleA.memorySegment(), 
            xfA.memorySegment(), 
            circleB.memorySegment(), 
            xfB.memorySegment()
        );
    
        if (segment.equals(MemorySegment.NULL))
            return null;
    
        return new Manifold(segment);
    }
    
    /**
     * Compute the contact manifold between a capsule and circle
     */
    public static MemorySegment collideCapsuleAndCircle(
        SegmentAllocator allocator,
        MemorySegment capsuleA, 
        MemorySegment xfA, 
        MemorySegment circleB, 
        MemorySegment xfB
    ) {
        MethodHandle method = B2_COLLIDE_CAPSULE_AND_CIRCLE.get();
        try {
            return (MemorySegment) method.invokeExact(
                allocator,
                capsuleA, 
                xfA, 
                circleB, 
                xfB
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #collideCapsuleAndCircle}.
     */
    public static @Nullable Manifold collideCapsuleAndCircle(
        SegmentAllocator allocator,
        Capsule capsuleA, 
        Transform xfA, 
        Circle circleB, 
        Transform xfB
    ) {
        MemorySegment segment = collideCapsuleAndCircle(
            allocator,
            capsuleA.memorySegment(), 
            xfA.memorySegment(), 
            circleB.memorySegment(), 
            xfB.memorySegment()
        );
    
        if (segment.equals(MemorySegment.NULL))
            return null;
    
        return new Manifold(segment);
    }
    
    /**
     * Compute the contact manifold between an segment and a circle
     */
    public static MemorySegment collideSegmentAndCircle(
        SegmentAllocator allocator,
        MemorySegment segmentA, 
        MemorySegment xfA, 
        MemorySegment circleB, 
        MemorySegment xfB
    ) {
        MethodHandle method = B2_COLLIDE_SEGMENT_AND_CIRCLE.get();
        try {
            return (MemorySegment) method.invokeExact(
                allocator,
                segmentA, 
                xfA, 
                circleB, 
                xfB
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #collideSegmentAndCircle}.
     */
    public static @Nullable Manifold collideSegmentAndCircle(
        SegmentAllocator allocator,
        Segment segmentA, 
        Transform xfA, 
        Circle circleB, 
        Transform xfB
    ) {
        MemorySegment segment = collideSegmentAndCircle(
            allocator,
            segmentA.memorySegment(), 
            xfA.memorySegment(), 
            circleB.memorySegment(), 
            xfB.memorySegment()
        );
    
        if (segment.equals(MemorySegment.NULL))
            return null;
    
        return new Manifold(segment);
    }
    
    /**
     * Compute the contact manifold between a polygon and a circle
     */
    public static MemorySegment collidePolygonAndCircle(
        SegmentAllocator allocator,
        MemorySegment polygonA, 
        MemorySegment xfA, 
        MemorySegment circleB, 
        MemorySegment xfB
    ) {
        MethodHandle method = B2_COLLIDE_POLYGON_AND_CIRCLE.get();
        try {
            return (MemorySegment) method.invokeExact(
                allocator,
                polygonA, 
                xfA, 
                circleB, 
                xfB
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #collidePolygonAndCircle}.
     */
    public static @Nullable Manifold collidePolygonAndCircle(
        SegmentAllocator allocator,
        Polygon polygonA, 
        Transform xfA, 
        Circle circleB, 
        Transform xfB
    ) {
        MemorySegment segment = collidePolygonAndCircle(
            allocator,
            polygonA.memorySegment(), 
            xfA.memorySegment(), 
            circleB.memorySegment(), 
            xfB.memorySegment()
        );
    
        if (segment.equals(MemorySegment.NULL))
            return null;
    
        return new Manifold(segment);
    }
    
    /**
     * Compute the contact manifold between a capsule and circle
     */
    public static MemorySegment collideCapsules(
        SegmentAllocator allocator,
        MemorySegment capsuleA, 
        MemorySegment xfA, 
        MemorySegment capsuleB, 
        MemorySegment xfB
    ) {
        MethodHandle method = B2_COLLIDE_CAPSULES.get();
        try {
            return (MemorySegment) method.invokeExact(
                allocator,
                capsuleA, 
                xfA, 
                capsuleB, 
                xfB
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #collideCapsules}.
     */
    public static @Nullable Manifold collideCapsules(
        SegmentAllocator allocator,
        Capsule capsuleA, 
        Transform xfA, 
        Capsule capsuleB, 
        Transform xfB
    ) {
        MemorySegment segment = collideCapsules(
            allocator,
            capsuleA.memorySegment(), 
            xfA.memorySegment(), 
            capsuleB.memorySegment(), 
            xfB.memorySegment()
        );
    
        if (segment.equals(MemorySegment.NULL))
            return null;
    
        return new Manifold(segment);
    }
    
    /**
     * Compute the contact manifold between an segment and a capsule
     */
    public static MemorySegment collideSegmentAndCapsule(
        SegmentAllocator allocator,
        MemorySegment segmentA, 
        MemorySegment xfA, 
        MemorySegment capsuleB, 
        MemorySegment xfB
    ) {
        MethodHandle method = B2_COLLIDE_SEGMENT_AND_CAPSULE.get();
        try {
            return (MemorySegment) method.invokeExact(
                allocator,
                segmentA, 
                xfA, 
                capsuleB, 
                xfB
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #collideSegmentAndCapsule}.
     */
    public static @Nullable Manifold collideSegmentAndCapsule(
        SegmentAllocator allocator,
        Segment segmentA, 
        Transform xfA, 
        Capsule capsuleB, 
        Transform xfB
    ) {
        MemorySegment segment = collideSegmentAndCapsule(
            allocator,
            segmentA.memorySegment(), 
            xfA.memorySegment(), 
            capsuleB.memorySegment(), 
            xfB.memorySegment()
        );
    
        if (segment.equals(MemorySegment.NULL))
            return null;
    
        return new Manifold(segment);
    }
    
    /**
     * Compute the contact manifold between a polygon and capsule
     */
    public static MemorySegment collidePolygonAndCapsule(
        SegmentAllocator allocator,
        MemorySegment polygonA, 
        MemorySegment xfA, 
        MemorySegment capsuleB, 
        MemorySegment xfB
    ) {
        MethodHandle method = B2_COLLIDE_POLYGON_AND_CAPSULE.get();
        try {
            return (MemorySegment) method.invokeExact(
                allocator,
                polygonA, 
                xfA, 
                capsuleB, 
                xfB
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #collidePolygonAndCapsule}.
     */
    public static @Nullable Manifold collidePolygonAndCapsule(
        SegmentAllocator allocator,
        Polygon polygonA, 
        Transform xfA, 
        Capsule capsuleB, 
        Transform xfB
    ) {
        MemorySegment segment = collidePolygonAndCapsule(
            allocator,
            polygonA.memorySegment(), 
            xfA.memorySegment(), 
            capsuleB.memorySegment(), 
            xfB.memorySegment()
        );
    
        if (segment.equals(MemorySegment.NULL))
            return null;
    
        return new Manifold(segment);
    }
    
    /**
     * Compute the contact manifold between two polygons
     */
    public static MemorySegment collidePolygons(
        SegmentAllocator allocator,
        MemorySegment polygonA, 
        MemorySegment xfA, 
        MemorySegment polygonB, 
        MemorySegment xfB
    ) {
        MethodHandle method = B2_COLLIDE_POLYGONS.get();
        try {
            return (MemorySegment) method.invokeExact(
                allocator,
                polygonA, 
                xfA, 
                polygonB, 
                xfB
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #collidePolygons}.
     */
    public static @Nullable Manifold collidePolygons(
        SegmentAllocator allocator,
        Polygon polygonA, 
        Transform xfA, 
        Polygon polygonB, 
        Transform xfB
    ) {
        MemorySegment segment = collidePolygons(
            allocator,
            polygonA.memorySegment(), 
            xfA.memorySegment(), 
            polygonB.memorySegment(), 
            xfB.memorySegment()
        );
    
        if (segment.equals(MemorySegment.NULL))
            return null;
    
        return new Manifold(segment);
    }
    
    /**
     * Compute the contact manifold between an segment and a polygon
     */
    public static MemorySegment collideSegmentAndPolygon(
        SegmentAllocator allocator,
        MemorySegment segmentA, 
        MemorySegment xfA, 
        MemorySegment polygonB, 
        MemorySegment xfB
    ) {
        MethodHandle method = B2_COLLIDE_SEGMENT_AND_POLYGON.get();
        try {
            return (MemorySegment) method.invokeExact(
                allocator,
                segmentA, 
                xfA, 
                polygonB, 
                xfB
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #collideSegmentAndPolygon}.
     */
    public static @Nullable Manifold collideSegmentAndPolygon(
        SegmentAllocator allocator,
        Segment segmentA, 
        Transform xfA, 
        Polygon polygonB, 
        Transform xfB
    ) {
        MemorySegment segment = collideSegmentAndPolygon(
            allocator,
            segmentA.memorySegment(), 
            xfA.memorySegment(), 
            polygonB.memorySegment(), 
            xfB.memorySegment()
        );
    
        if (segment.equals(MemorySegment.NULL))
            return null;
    
        return new Manifold(segment);
    }
    
    /**
     * Compute the contact manifold between a chain segment and a circle
     */
    public static MemorySegment collideChainSegmentAndCircle(
        SegmentAllocator allocator,
        MemorySegment segmentA, 
        MemorySegment xfA, 
        MemorySegment circleB, 
        MemorySegment xfB
    ) {
        MethodHandle method = B2_COLLIDE_CHAIN_SEGMENT_AND_CIRCLE.get();
        try {
            return (MemorySegment) method.invokeExact(
                allocator,
                segmentA, 
                xfA, 
                circleB, 
                xfB
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #collideChainSegmentAndCircle}.
     */
    public static @Nullable Manifold collideChainSegmentAndCircle(
        SegmentAllocator allocator,
        ChainSegment segmentA, 
        Transform xfA, 
        Circle circleB, 
        Transform xfB
    ) {
        MemorySegment segment = collideChainSegmentAndCircle(
            allocator,
            segmentA.memorySegment(), 
            xfA.memorySegment(), 
            circleB.memorySegment(), 
            xfB.memorySegment()
        );
    
        if (segment.equals(MemorySegment.NULL))
            return null;
    
        return new Manifold(segment);
    }
    
    /**
     * Compute the contact manifold between a chain segment and a capsule
     */
    public static MemorySegment collideChainSegmentAndCapsule(
        SegmentAllocator allocator,
        MemorySegment segmentA, 
        MemorySegment xfA, 
        MemorySegment capsuleB, 
        MemorySegment xfB, 
        MemorySegment cache
    ) {
        MethodHandle method = B2_COLLIDE_CHAIN_SEGMENT_AND_CAPSULE.get();
        try {
            return (MemorySegment) method.invokeExact(
                allocator,
                segmentA, 
                xfA, 
                capsuleB, 
                xfB, 
                cache
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #collideChainSegmentAndCapsule}.
     */
    public static @Nullable Manifold collideChainSegmentAndCapsule(
        SegmentAllocator allocator,
        ChainSegment segmentA, 
        Transform xfA, 
        Capsule capsuleB, 
        Transform xfB, 
        SimplexCache cache
    ) {
        MemorySegment segment = collideChainSegmentAndCapsule(
            allocator,
            segmentA.memorySegment(), 
            xfA.memorySegment(), 
            capsuleB.memorySegment(), 
            xfB.memorySegment(), 
            cache.memorySegment()
        );
    
        if (segment.equals(MemorySegment.NULL))
            return null;
    
        return new Manifold(segment);
    }
    
    /**
     * Compute the contact manifold between a chain segment and a rounded polygon
     */
    public static MemorySegment collideChainSegmentAndPolygon(
        SegmentAllocator allocator,
        MemorySegment segmentA, 
        MemorySegment xfA, 
        MemorySegment polygonB, 
        MemorySegment xfB, 
        MemorySegment cache
    ) {
        MethodHandle method = B2_COLLIDE_CHAIN_SEGMENT_AND_POLYGON.get();
        try {
            return (MemorySegment) method.invokeExact(
                allocator,
                segmentA, 
                xfA, 
                polygonB, 
                xfB, 
                cache
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #collideChainSegmentAndPolygon}.
     */
    public static @Nullable Manifold collideChainSegmentAndPolygon(
        SegmentAllocator allocator,
        ChainSegment segmentA, 
        Transform xfA, 
        Polygon polygonB, 
        Transform xfB, 
        SimplexCache cache
    ) {
        MemorySegment segment = collideChainSegmentAndPolygon(
            allocator,
            segmentA.memorySegment(), 
            xfA.memorySegment(), 
            polygonB.memorySegment(), 
            xfB.memorySegment(), 
            cache.memorySegment()
        );
    
        if (segment.equals(MemorySegment.NULL))
            return null;
    
        return new Manifold(segment);
    }
    
}