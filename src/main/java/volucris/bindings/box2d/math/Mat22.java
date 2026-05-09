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
 * A 2-by-2 Matrix
 */
public final class Mat22
		implements Struct<Mat22> {

    public static final StructLayout LAYOUT;

    public static final long CX_BYTE_OFFSET;
    public static final long CY_BYTE_OFFSET;

    private final MemorySegment segment;

    private final Vec2 cx;
    private final Vec2 cy;

    static {
        //@formatter:off
        LAYOUT = MemoryLayout.structLayout(
            Vec2.LAYOUT.withName("cx"),
            Vec2.LAYOUT.withName("cy")
        ).withName("b2Mat22").withByteAlignment(4);
        
        CX_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("cx"));
        CY_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("cy"));
        //@formatter:on
    }

    public Mat22() {
        this(Arena.ofAuto());
    }
    
    public Mat22(Arena arena) {
        this(arena.allocate(LAYOUT));
    }
    
    public Mat22(MemorySegment segment) {
        this.segment = segment;
    
        cx = new Vec2(segment.asSlice(CX_BYTE_OFFSET, Vec2.LAYOUT));
        cy = new Vec2(segment.asSlice(CY_BYTE_OFFSET, Vec2.LAYOUT));
    }

    public Mat22 cx(Consumer<Vec2> consumer) {
        consumer.accept(cx);
        return this;
    }
    
    public Mat22 cx(Vec2 other) {
        cx.set(other);
        return this;
    }
    
    public Vec2 cx() {
        return cx;
    }
    
    public Mat22 cy(Consumer<Vec2> consumer) {
        consumer.accept(cy);
        return this;
    }
    
    public Mat22 cy(Vec2 other) {
        cy.set(other);
        return this;
    }
    
    public Vec2 cy() {
        return cy;
    }
    
    @Override
    public Mat22 set(Mat22 other) {
        return set(other.segment);
    }
    
    @Override
    public Mat22 set(MemorySegment src) {
        MemorySegment.copy(src, 0L, segment, 0L, LAYOUT.byteSize());
        return this;
    }
    
    @Override
    public MemorySegment memorySegment() {
        return segment;
    }
    
    public NativeStructArray<Mat22> asArray() {
        return new NativeStructArray<>(this);
    }
    
    public static NativeStructArray<Mat22> array(Arena arena, int count) {
        return new NativeStructArray<>(
            arena,
            LAYOUT,
            segment -> new Mat22(segment),
            count
        );
    }
    
    public static NativeStructArray<Mat22> array(Arena arena, Mat22... structs) {
        NativeStructArray<Mat22> array = new NativeStructArray<>(
            arena,
            LAYOUT,
            segment -> new Mat22(segment),
            structs.length
        );
    
        for (int i = 0; i < structs.length; i++) {
            array.set(i, structs[i]);
        }
    
        return array;
    }
    
    public static NativeStructArray<Mat22> array(MemorySegment array) {
        return new NativeStructArray<>(
            array,
            LAYOUT,
            segment -> new Mat22(segment)
        );
    }
    
}