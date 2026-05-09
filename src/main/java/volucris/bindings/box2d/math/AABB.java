/*
 * MACHINE GENERATED FILE, DO NOT EDIT.
 */
package volucris.bindings.box2d.math;

import java.lang.foreign.Arena;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.StructLayout;
import java.util.function.Consumer;
import volucris.bindings.core.NativeStructArray;
import volucris.bindings.core.Struct;

import static java.lang.foreign.ValueLayout.*;

/**
 * Axis-aligned bounding box
 */
public final class AABB
		implements Struct<AABB> {

    public static final StructLayout LAYOUT;

    public static final long LOWER_BOUND_BYTE_OFFSET;
    public static final long UPPER_BOUND_BYTE_OFFSET;

    private final MemorySegment segment;

    private final Vec2 lowerBound;
    private final Vec2 upperBound;

    static {
        //@formatter:off
        LAYOUT = MemoryLayout.structLayout(
            Vec2.LAYOUT.withName("lowerBound"),
            Vec2.LAYOUT.withName("upperBound")
        ).withName("b2AABB").withByteAlignment(4);
        
        LOWER_BOUND_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("lowerBound"));
        UPPER_BOUND_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("upperBound"));
        //@formatter:on
    }

    public AABB() {
        this(Arena.ofAuto());
    }
    
    public AABB(Arena arena) {
        this(arena.allocate(LAYOUT));
    }
    
    public AABB(MemorySegment segment) {
        this.segment = segment;
    
        lowerBound = new Vec2(segment.asSlice(LOWER_BOUND_BYTE_OFFSET, Vec2.LAYOUT));
        upperBound = new Vec2(segment.asSlice(UPPER_BOUND_BYTE_OFFSET, Vec2.LAYOUT));
    }

    public AABB lowerBound(Consumer<Vec2> consumer) {
        consumer.accept(lowerBound);
        return this;
    }
    
    public AABB lowerBound(Vec2 other) {
        lowerBound.set(other);
        return this;
    }
    
    public Vec2 lowerBound() {
        return lowerBound;
    }
    
    public AABB upperBound(Consumer<Vec2> consumer) {
        consumer.accept(upperBound);
        return this;
    }
    
    public AABB upperBound(Vec2 other) {
        upperBound.set(other);
        return this;
    }
    
    public Vec2 upperBound() {
        return upperBound;
    }
    
    @Override
    public AABB set(AABB other) {
        return set(other.segment);
    }
    
    @Override
    public AABB set(MemorySegment src) {
        MemorySegment.copy(src, 0L, segment, 0L, LAYOUT.byteSize());
        return this;
    }
    
    @Override
    public MemorySegment memorySegment() {
        return segment;
    }
    
    public NativeStructArray<AABB> asArray() {
        return new NativeStructArray<>(this);
    }
    
    public static NativeStructArray<AABB> array(Arena arena, int count) {
        return new NativeStructArray<>(
            arena,
            LAYOUT,
            segment -> new AABB(segment),
            count
        );
    }
    
    public static NativeStructArray<AABB> array(Arena arena, AABB... structs) {
        NativeStructArray<AABB> array = new NativeStructArray<>(
            arena,
            LAYOUT,
            segment -> new AABB(segment),
            structs.length
        );
    
        for (int i = 0; i < structs.length; i++) {
            array.set(i, structs[i]);
        }
    
        return array;
    }
    
    public static NativeStructArray<AABB> array(MemorySegment array) {
        return new NativeStructArray<>(
            array,
            LAYOUT,
            segment -> new AABB(segment)
        );
    }
    
}