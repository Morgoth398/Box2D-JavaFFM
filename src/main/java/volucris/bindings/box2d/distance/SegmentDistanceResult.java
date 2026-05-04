/*
 * MACHINE GENERATED FILE, DO NOT EDIT.
 */
package volucris.bindings.box2d.distance;

import java.lang.foreign.Arena;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.StructLayout;
import java.lang.invoke.VarHandle;
import java.util.function.Consumer;
import volucris.bindings.box2d.math.Vec2;
import volucris.bindings.core.NativeStructArray;
import volucris.bindings.core.Struct;

import static java.lang.foreign.ValueLayout.*;

/**
 * Result of computing the distance between two line segments
 */
public final class SegmentDistanceResult
		implements Struct<SegmentDistanceResult> {

    public static final StructLayout LAYOUT;

    public static final VarHandle FRACTION1;
    public static final VarHandle FRACTION2;
    public static final VarHandle DISTANCE_SQUARED;

    public static final long CLOSEST1_OFFSET;
    public static final long CLOSEST2_OFFSET;
    public static final long FRACTION1_OFFSET;
    public static final long FRACTION2_OFFSET;
    public static final long DISTANCE_SQUARED_OFFSET;

    private final MemorySegment segment;

    private final Vec2 closest1;
    private final Vec2 closest2;

    static {
        //@formatter:off
        LAYOUT = MemoryLayout.structLayout(
            Vec2.LAYOUT.withName("closest1"),
            Vec2.LAYOUT.withName("closest2"),
            JAVA_FLOAT.withName("fraction1"),
            JAVA_FLOAT.withName("fraction2"),
            JAVA_FLOAT.withName("distanceSquared")
        ).withName("b2SegmentDistanceResult").withByteAlignment(4);
        
        FRACTION1 = LAYOUT.varHandle(PathElement.groupElement("fraction1"));
        FRACTION2 = LAYOUT.varHandle(PathElement.groupElement("fraction2"));
        DISTANCE_SQUARED = LAYOUT.varHandle(PathElement.groupElement("distanceSquared"));
        
        CLOSEST1_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("closest1"));
        CLOSEST2_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("closest2"));
        FRACTION1_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("fraction1"));
        FRACTION2_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("fraction2"));
        DISTANCE_SQUARED_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("distanceSquared"));
        //@formatter:on
    }

    public SegmentDistanceResult() {
        this(Arena.ofAuto());
    }
    
    public SegmentDistanceResult(Arena arena) {
        this(arena.allocate(LAYOUT));
    }
    
    public SegmentDistanceResult(MemorySegment segment) {
        this.segment = segment;
    
        closest1 = new Vec2(segment.asSlice(CLOSEST1_OFFSET, Vec2.LAYOUT));
        closest2 = new Vec2(segment.asSlice(CLOSEST2_OFFSET, Vec2.LAYOUT));
    }

    public SegmentDistanceResult fraction1(float fraction1) {
        FRACTION1.set(segment, 0L, fraction1);
        return this;
    }
    
    public float fraction1() {
        return (float) FRACTION1.get(segment, 0L);
    }
    
    public SegmentDistanceResult fraction2(float fraction2) {
        FRACTION2.set(segment, 0L, fraction2);
        return this;
    }
    
    public float fraction2() {
        return (float) FRACTION2.get(segment, 0L);
    }
    
    public SegmentDistanceResult distanceSquared(float distanceSquared) {
        DISTANCE_SQUARED.set(segment, 0L, distanceSquared);
        return this;
    }
    
    public float distanceSquared() {
        return (float) DISTANCE_SQUARED.get(segment, 0L);
    }
    
    public SegmentDistanceResult closest1(Consumer<Vec2> consumer) {
        consumer.accept(closest1);
        return this;
    }
    
    public SegmentDistanceResult closest1(Vec2 other) {
        closest1.set(other);
        return this;
    }
    
    public Vec2 closest1() {
        return closest1;
    }
    
    public SegmentDistanceResult closest2(Consumer<Vec2> consumer) {
        consumer.accept(closest2);
        return this;
    }
    
    public SegmentDistanceResult closest2(Vec2 other) {
        closest2.set(other);
        return this;
    }
    
    public Vec2 closest2() {
        return closest2;
    }
    
    @Override
    public SegmentDistanceResult set(SegmentDistanceResult other) {
        return set(other.segment);
    }
    
    @Override
    public SegmentDistanceResult set(MemorySegment src) {
        MemorySegment.copy(src, 0L, segment, 0L, LAYOUT.byteSize());
        return this;
    }
    
    @Override
    public MemorySegment memorySegment() {
        return segment;
    }
    
    public NativeStructArray<SegmentDistanceResult> asArray() {
        return new NativeStructArray<>(this);
    }
    
    public static NativeStructArray<SegmentDistanceResult> array(Arena arena, int count) {
        return new NativeStructArray<>(
            arena,
            LAYOUT,
            segment -> new SegmentDistanceResult(segment),
            count
        );
    }
    
    public static NativeStructArray<SegmentDistanceResult> array(Arena arena, SegmentDistanceResult... structs) {
        NativeStructArray<SegmentDistanceResult> array = new NativeStructArray<>(
            arena,
            LAYOUT,
            segment -> new SegmentDistanceResult(segment),
            structs.length
        );
    
        for (int i = 0; i < structs.length; i++) {
            array.set(i, structs[i]);
        }
    
        return array;
    }
    
    public static NativeStructArray<SegmentDistanceResult> array(MemorySegment array) {
        return new NativeStructArray<>(
            array,
            LAYOUT,
            segment -> new SegmentDistanceResult(segment)
        );
    }
    
}