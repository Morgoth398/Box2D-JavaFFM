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
import java.util.function.Consumer;
import volucris.bindings.box2d.math.AABB;
import volucris.bindings.box2d.math.Transform;
import volucris.bindings.box2d.math.Vec2;
import volucris.bindings.core.NativeStructArray;
import volucris.bindings.core.Struct;

import static java.lang.foreign.ValueLayout.*;
import static volucris.bindings.core.FFMUtils.*;

/**
 * A line segment with two-sided collision.
 */
public final class Segment
		implements Struct<Segment> {

    private static final LazyConstant<MethodHandle> B2_COMPUTE_SEGMENT_AABB;
    private static final LazyConstant<MethodHandle> B2_RAY_CAST_SEGMENT;
    private static final LazyConstant<MethodHandle> B2_SHAPE_CAST_SEGMENT;

    public static final StructLayout LAYOUT;

    public static final long POINT1_BYTE_OFFSET;
    public static final long POINT2_BYTE_OFFSET;

    private final MemorySegment segment;

    private final Vec2 point1;
    private final Vec2 point2;

    static {
        //@formatter:off
        LAYOUT = MemoryLayout.structLayout(
            Vec2.LAYOUT.withName("point1"),
            Vec2.LAYOUT.withName("point2")
        ).withName("b2Segment").withByteAlignment(4);
        
        B2_COMPUTE_SEGMENT_AABB = downcallHandle("b2ComputeSegmentAABB", AABB.LAYOUT, UNBOUNDED_ADDRESS, Transform.LAYOUT);
        B2_RAY_CAST_SEGMENT = downcallHandle("b2RayCastSegment", CastOutput.LAYOUT, UNBOUNDED_ADDRESS, UNBOUNDED_ADDRESS, JAVA_BOOLEAN);
        B2_SHAPE_CAST_SEGMENT = downcallHandle("b2ShapeCastSegment", CastOutput.LAYOUT, UNBOUNDED_ADDRESS, UNBOUNDED_ADDRESS);
        
        POINT1_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("point1"));
        POINT2_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("point2"));
        //@formatter:on
    }

    public Segment() {
        this(Arena.ofAuto());
    }
    
    public Segment(Arena arena) {
        this(arena.allocate(LAYOUT));
    }
    
    public Segment(MemorySegment segment) {
        this.segment = segment;
    
        point1 = new Vec2(segment.asSlice(POINT1_BYTE_OFFSET, Vec2.LAYOUT));
        point2 = new Vec2(segment.asSlice(POINT2_BYTE_OFFSET, Vec2.LAYOUT));
    }

    /**
     * Compute the bounding box of a transformed line segment
     */
    public static MemorySegment computeSegmentAABB(
        SegmentAllocator allocator,
        MemorySegment shape, 
        MemorySegment transform
    ) {
        MethodHandle method = B2_COMPUTE_SEGMENT_AABB.get();
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
     * Typed method of {@link #computeSegmentAABB}.
     */
    public final @Nullable AABB computeSegmentAABB(
        SegmentAllocator allocator,
        Transform transform
    ) {
        MemorySegment segment = computeSegmentAABB(
            allocator,
            this.segment, 
            transform.memorySegment()
        );
    
        if (segment.equals(MemorySegment.NULL))
            return null;
    
        return new AABB(segment);
    }
    
    /**
     * Ray cast versus segment shape in local space. Optionally treat the segment as one-sided with hits from the left side being treated as a miss.
     */
    public static MemorySegment rayCastSegment(
        SegmentAllocator allocator,
        MemorySegment input, 
        MemorySegment shape, 
        boolean oneSided
    ) {
        MethodHandle method = B2_RAY_CAST_SEGMENT.get();
        try {
            return (MemorySegment) method.invokeExact(
                allocator,
                input, 
                shape, 
                oneSided
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #rayCastSegment}.
     */
    public final @Nullable CastOutput rayCastSegment(
        SegmentAllocator allocator,
        RayCastInput input, 
        boolean oneSided
    ) {
        MemorySegment segment = rayCastSegment(
            allocator,
            input.memorySegment(), 
            this.segment, 
            oneSided
        );
    
        if (segment.equals(MemorySegment.NULL))
            return null;
    
        return new CastOutput(segment);
    }
    
    /**
     * Shape cast versus a line segment. Initial overlap is treated as a miss.
     */
    public static MemorySegment shapeCastSegment(
        SegmentAllocator allocator,
        MemorySegment input, 
        MemorySegment shape
    ) {
        MethodHandle method = B2_SHAPE_CAST_SEGMENT.get();
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
     * Typed method of {@link #shapeCastSegment}.
     */
    public final @Nullable CastOutput shapeCastSegment(
        SegmentAllocator allocator,
        ShapeCastInput input
    ) {
        MemorySegment segment = shapeCastSegment(
            allocator,
            input.memorySegment(), 
            this.segment
        );
    
        if (segment.equals(MemorySegment.NULL))
            return null;
    
        return new CastOutput(segment);
    }
    
    public Segment point1(Consumer<Vec2> consumer) {
        consumer.accept(point1);
        return this;
    }
    
    public Segment point1(Vec2 other) {
        point1.set(other);
        return this;
    }
    
    public Vec2 point1() {
        return point1;
    }
    
    public Segment point2(Consumer<Vec2> consumer) {
        consumer.accept(point2);
        return this;
    }
    
    public Segment point2(Vec2 other) {
        point2.set(other);
        return this;
    }
    
    public Vec2 point2() {
        return point2;
    }
    
    @Override
    public Segment set(Segment other) {
        return set(other.segment);
    }
    
    @Override
    public Segment set(MemorySegment src) {
        MemorySegment.copy(src, 0L, segment, 0L, LAYOUT.byteSize());
        return this;
    }
    
    @Override
    public MemorySegment memorySegment() {
        return segment;
    }
    
    public NativeStructArray<Segment> asArray() {
        return new NativeStructArray<>(this);
    }
    
    public static NativeStructArray<Segment> array(Arena arena, int count) {
        return new NativeStructArray<>(
            arena,
            LAYOUT,
            segment -> new Segment(segment),
            count
        );
    }
    
    public static NativeStructArray<Segment> array(Arena arena, Segment... structs) {
        NativeStructArray<Segment> array = new NativeStructArray<>(
            arena,
            LAYOUT,
            segment -> new Segment(segment),
            structs.length
        );
    
        for (int i = 0; i < structs.length; i++) {
            array.set(i, structs[i]);
        }
    
        return array;
    }
    
    public static NativeStructArray<Segment> array(MemorySegment array) {
        return new NativeStructArray<>(
            array,
            LAYOUT,
            segment -> new Segment(segment)
        );
    }
    
}