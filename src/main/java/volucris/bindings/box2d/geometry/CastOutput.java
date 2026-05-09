/*
 * MACHINE GENERATED FILE, DO NOT EDIT.
 */
package volucris.bindings.box2d.geometry;

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
 * Low level ray cast or shape-cast output data. Returns a zero fraction and normal in the case of initial overlap.
 */
public final class CastOutput
		implements Struct<CastOutput> {

    public static final StructLayout LAYOUT;

    public static final VarHandle FRACTION_HANDLE;
    public static final VarHandle ITERATIONS_HANDLE;
    public static final VarHandle HIT_HANDLE;

    public static final long NORMAL_BYTE_OFFSET;
    public static final long POINT_BYTE_OFFSET;
    public static final long FRACTION_BYTE_OFFSET;
    public static final long ITERATIONS_BYTE_OFFSET;
    public static final long HIT_BYTE_OFFSET;

    private final MemorySegment segment;

    private final Vec2 normal;
    private final Vec2 point;

    static {
        //@formatter:off
        LAYOUT = MemoryLayout.structLayout(
            Vec2.LAYOUT.withName("normal"),
            Vec2.LAYOUT.withName("point"),
            JAVA_FLOAT.withName("fraction"),
            JAVA_INT.withName("iterations"),
            JAVA_BOOLEAN.withName("hit"),
            MemoryLayout.paddingLayout(3)
        ).withName("b2CastOutput").withByteAlignment(4);
        
        FRACTION_HANDLE = LAYOUT.varHandle(PathElement.groupElement("fraction"));
        ITERATIONS_HANDLE = LAYOUT.varHandle(PathElement.groupElement("iterations"));
        HIT_HANDLE = LAYOUT.varHandle(PathElement.groupElement("hit"));
        
        NORMAL_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("normal"));
        POINT_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("point"));
        FRACTION_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("fraction"));
        ITERATIONS_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("iterations"));
        HIT_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("hit"));
        //@formatter:on
    }

    public CastOutput() {
        this(Arena.ofAuto());
    }
    
    public CastOutput(Arena arena) {
        this(arena.allocate(LAYOUT));
    }
    
    public CastOutput(MemorySegment segment) {
        this.segment = segment;
    
        normal = new Vec2(segment.asSlice(NORMAL_BYTE_OFFSET, Vec2.LAYOUT));
        point = new Vec2(segment.asSlice(POINT_BYTE_OFFSET, Vec2.LAYOUT));
    }

    public CastOutput fraction(float fraction) {
        FRACTION_HANDLE.set(segment, 0L, fraction);
        return this;
    }
    
    public float fraction() {
        return (float) FRACTION_HANDLE.get(segment, 0L);
    }
    
    public CastOutput iterations(int iterations) {
        ITERATIONS_HANDLE.set(segment, 0L, iterations);
        return this;
    }
    
    public int iterations() {
        return (int) ITERATIONS_HANDLE.get(segment, 0L);
    }
    
    public CastOutput hit(boolean hit) {
        HIT_HANDLE.set(segment, 0L, hit);
        return this;
    }
    
    public boolean hit() {
        return (boolean) HIT_HANDLE.get(segment, 0L);
    }
    
    public CastOutput normal(Consumer<Vec2> consumer) {
        consumer.accept(normal);
        return this;
    }
    
    public CastOutput normal(Vec2 other) {
        normal.set(other);
        return this;
    }
    
    public Vec2 normal() {
        return normal;
    }
    
    public CastOutput point(Consumer<Vec2> consumer) {
        consumer.accept(point);
        return this;
    }
    
    public CastOutput point(Vec2 other) {
        point.set(other);
        return this;
    }
    
    public Vec2 point() {
        return point;
    }
    
    @Override
    public CastOutput set(CastOutput other) {
        return set(other.segment);
    }
    
    @Override
    public CastOutput set(MemorySegment src) {
        MemorySegment.copy(src, 0L, segment, 0L, LAYOUT.byteSize());
        return this;
    }
    
    @Override
    public MemorySegment memorySegment() {
        return segment;
    }
    
    public NativeStructArray<CastOutput> asArray() {
        return new NativeStructArray<>(this);
    }
    
    public static NativeStructArray<CastOutput> array(Arena arena, int count) {
        return new NativeStructArray<>(
            arena,
            LAYOUT,
            segment -> new CastOutput(segment),
            count
        );
    }
    
    public static NativeStructArray<CastOutput> array(Arena arena, CastOutput... structs) {
        NativeStructArray<CastOutput> array = new NativeStructArray<>(
            arena,
            LAYOUT,
            segment -> new CastOutput(segment),
            structs.length
        );
    
        for (int i = 0; i < structs.length; i++) {
            array.set(i, structs[i]);
        }
    
        return array;
    }
    
    public static NativeStructArray<CastOutput> array(MemorySegment array) {
        return new NativeStructArray<>(
            array,
            LAYOUT,
            segment -> new CastOutput(segment)
        );
    }
    
}