/*
 * MACHINE GENERATED FILE, DO NOT EDIT.
 */
package volucris.bindings.box2d.geometry;

import edu.umd.cs.findbugs.annotations.Nullable;
import java.lang.foreign.Arena;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.SegmentAllocator;
import java.lang.foreign.StructLayout;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.util.function.Consumer;
import volucris.bindings.box2d.math.AABB;
import volucris.bindings.box2d.math.Transform;
import volucris.bindings.box2d.math.Vec2;
import volucris.bindings.core.NativeStructArray;
import volucris.bindings.core.Struct;

import static java.lang.foreign.ValueLayout.*;
import static volucris.bindings.core.FFMUtils.*;

/**
 * A solid circle
 */
public final class Circle
		implements Struct<Circle> {

    private static final LazyConstant<MethodHandle> B2_COMPUTE_CIRCLE_AABB;
    private static final LazyConstant<MethodHandle> B2_POINT_IN_CIRCLE;
    private static final LazyConstant<MethodHandle> B2_RAY_CAST_CIRCLE;
    private static final LazyConstant<MethodHandle> B2_SHAPE_CAST_CIRCLE;

    public static final StructLayout LAYOUT;

    public static final VarHandle RADIUS;

    public static final long CENTER_OFFSET;
    public static final long RADIUS_OFFSET;

    private final MemorySegment segment;

    private final Vec2 center;

    static {
        //@formatter:off
        LAYOUT = MemoryLayout.structLayout(
            Vec2.LAYOUT.withName("center"),
            JAVA_FLOAT.withName("radius")
        ).withName("b2Circle").withByteAlignment(4);
        
        B2_COMPUTE_CIRCLE_AABB = downcallHandle("b2ComputeCircleAABB", AABB.LAYOUT, UNBOUNDED_ADDRESS, Transform.LAYOUT);
        B2_POINT_IN_CIRCLE = downcallHandle("b2PointInCircle", JAVA_BOOLEAN, Vec2.LAYOUT, UNBOUNDED_ADDRESS);
        B2_RAY_CAST_CIRCLE = downcallHandle("b2RayCastCircle", CastOutput.LAYOUT, UNBOUNDED_ADDRESS, UNBOUNDED_ADDRESS);
        B2_SHAPE_CAST_CIRCLE = downcallHandle("b2ShapeCastCircle", CastOutput.LAYOUT, UNBOUNDED_ADDRESS, UNBOUNDED_ADDRESS);
        
        RADIUS = LAYOUT.varHandle(PathElement.groupElement("radius"));
        
        CENTER_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("center"));
        RADIUS_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("radius"));
        //@formatter:on
    }

    public Circle() {
        this(Arena.ofAuto());
    }
    
    public Circle(Arena arena) {
        this(arena.allocate(LAYOUT));
    }
    
    public Circle(MemorySegment segment) {
        this.segment = segment;
    
        center = new Vec2(segment.asSlice(CENTER_OFFSET, Vec2.LAYOUT));
    }

    /**
     * Compute the bounding box of a transformed circle
     */
    public static MemorySegment computeCircleAABB(
        SegmentAllocator allocator,
        MemorySegment shape, 
        MemorySegment transform
    ) {
        MethodHandle method = B2_COMPUTE_CIRCLE_AABB.get();
        try {
            return (MemorySegment) method.invokeExact(
                allocator,
                shape, 
                transform
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #computeCircleAABB}.
     */
    public final @Nullable AABB computeCircleAABB(
        SegmentAllocator allocator,
        Transform transform
    ) {
        MemorySegment segment = computeCircleAABB(
            allocator,
            this.segment, 
            transform.memorySegment()
        );
    
        if (segment.equals(MemorySegment.NULL))
            return null;
    
        return new AABB(segment);
    }
    
    /**
     * Test a point for overlap with a circle in local space
     */
    public static boolean pointInCircle(
        MemorySegment point, 
        MemorySegment shape
    ) {
        MethodHandle method = B2_POINT_IN_CIRCLE.get();
        try {
            return (boolean) method.invokeExact(
                point, 
                shape
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #pointInCircle}.
     */
    public final boolean pointInCircle(
        Vec2 point
    ) {
        return (boolean) pointInCircle(
            point.memorySegment(), 
            this.segment
        );
    }
    
    /**
     * Ray cast versus circle shape in local space. Initial overlap is treated as a miss.
     */
    public static MemorySegment rayCastCircle(
        SegmentAllocator allocator,
        MemorySegment input, 
        MemorySegment shape
    ) {
        MethodHandle method = B2_RAY_CAST_CIRCLE.get();
        try {
            return (MemorySegment) method.invokeExact(
                allocator,
                input, 
                shape
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #rayCastCircle}.
     */
    public final @Nullable CastOutput rayCastCircle(
        SegmentAllocator allocator,
        RayCastInput input
    ) {
        MemorySegment segment = rayCastCircle(
            allocator,
            input.memorySegment(), 
            this.segment
        );
    
        if (segment.equals(MemorySegment.NULL))
            return null;
    
        return new CastOutput(segment);
    }
    
    /**
     * Shape cast versus a circle. Initial overlap is treated as a miss.
     */
    public static MemorySegment shapeCastCircle(
        SegmentAllocator allocator,
        MemorySegment input, 
        MemorySegment shape
    ) {
        MethodHandle method = B2_SHAPE_CAST_CIRCLE.get();
        try {
            return (MemorySegment) method.invokeExact(
                allocator,
                input, 
                shape
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #shapeCastCircle}.
     */
    public final @Nullable CastOutput shapeCastCircle(
        SegmentAllocator allocator,
        ShapeCastInput input
    ) {
        MemorySegment segment = shapeCastCircle(
            allocator,
            input.memorySegment(), 
            this.segment
        );
    
        if (segment.equals(MemorySegment.NULL))
            return null;
    
        return new CastOutput(segment);
    }
    
    public Circle radius(float radius) {
        RADIUS.set(segment, 0L, radius);
        return this;
    }
    
    public float radius() {
        return (float) RADIUS.get(segment, 0L);
    }
    
    public Circle center(Consumer<Vec2> consumer) {
        consumer.accept(center);
        return this;
    }
    
    public Circle center(Vec2 other) {
        center.set(other);
        return this;
    }
    
    public Vec2 center() {
        return center;
    }
    
    @Override
    public Circle set(Circle other) {
        return set(other.segment);
    }
    
    @Override
    public Circle set(MemorySegment src) {
        MemorySegment.copy(src, 0L, segment, 0L, LAYOUT.byteSize());
        return this;
    }
    
    @Override
    public MemorySegment memorySegment() {
        return segment;
    }
    
    public NativeStructArray<Circle> asArray() {
        return new NativeStructArray<>(this);
    }
    
    public static NativeStructArray<Circle> array(Arena arena, int count) {
        return new NativeStructArray<>(
            arena,
            LAYOUT,
            segment -> new Circle(segment),
            count
        );
    }
    
    public static NativeStructArray<Circle> array(Arena arena, Circle... structs) {
        NativeStructArray<Circle> array = new NativeStructArray<>(
            arena,
            LAYOUT,
            segment -> new Circle(segment),
            structs.length
        );
    
        for (int i = 0; i < structs.length; i++) {
            array.set(i, structs[i]);
        }
    
        return array;
    }
    
    public static NativeStructArray<Circle> array(MemorySegment array) {
        return new NativeStructArray<>(
            array,
            LAYOUT,
            segment -> new Circle(segment)
        );
    }
    
}