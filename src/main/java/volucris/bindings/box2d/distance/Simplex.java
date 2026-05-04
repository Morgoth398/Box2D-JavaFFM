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
import volucris.bindings.core.NativeStructArray;
import volucris.bindings.core.Struct;

import static java.lang.foreign.ValueLayout.*;

/**
 * Simplex from the GJK algorithm
 */
public final class Simplex
		implements Struct<Simplex> {

    public static final StructLayout LAYOUT;

    public static final VarHandle COUNT;

    public static final long V1_OFFSET;
    public static final long V2_OFFSET;
    public static final long V3_OFFSET;
    public static final long COUNT_OFFSET;

    private final MemorySegment segment;

    private final SimplexVertex v1;
    private final SimplexVertex v2;
    private final SimplexVertex v3;

    static {
        //@formatter:off
        LAYOUT = MemoryLayout.structLayout(
            SimplexVertex.LAYOUT.withName("v1"),
            SimplexVertex.LAYOUT.withName("v2"),
            SimplexVertex.LAYOUT.withName("v3"),
            JAVA_INT.withName("count")
        ).withName("b2Simplex").withByteAlignment(4);
        
        COUNT = LAYOUT.varHandle(PathElement.groupElement("count"));
        
        V1_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("v1"));
        V2_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("v2"));
        V3_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("v3"));
        COUNT_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("count"));
        //@formatter:on
    }

    public Simplex() {
        this(Arena.ofAuto());
    }
    
    public Simplex(Arena arena) {
        this(arena.allocate(LAYOUT));
    }
    
    public Simplex(MemorySegment segment) {
        this.segment = segment;
    
        v1 = new SimplexVertex(segment.asSlice(V1_OFFSET, SimplexVertex.LAYOUT));
        v2 = new SimplexVertex(segment.asSlice(V2_OFFSET, SimplexVertex.LAYOUT));
        v3 = new SimplexVertex(segment.asSlice(V3_OFFSET, SimplexVertex.LAYOUT));
    }

    public Simplex count(int count) {
        COUNT.set(segment, 0L, count);
        return this;
    }
    
    public int count() {
        return (int) COUNT.get(segment, 0L);
    }
    
    public Simplex v1(Consumer<SimplexVertex> consumer) {
        consumer.accept(v1);
        return this;
    }
    
    public Simplex v1(SimplexVertex other) {
        v1.set(other);
        return this;
    }
    
    public SimplexVertex v1() {
        return v1;
    }
    
    public Simplex v2(Consumer<SimplexVertex> consumer) {
        consumer.accept(v2);
        return this;
    }
    
    public Simplex v2(SimplexVertex other) {
        v2.set(other);
        return this;
    }
    
    public SimplexVertex v2() {
        return v2;
    }
    
    public Simplex v3(Consumer<SimplexVertex> consumer) {
        consumer.accept(v3);
        return this;
    }
    
    public Simplex v3(SimplexVertex other) {
        v3.set(other);
        return this;
    }
    
    public SimplexVertex v3() {
        return v3;
    }
    
    @Override
    public Simplex set(Simplex other) {
        return set(other.segment);
    }
    
    @Override
    public Simplex set(MemorySegment src) {
        MemorySegment.copy(src, 0L, segment, 0L, LAYOUT.byteSize());
        return this;
    }
    
    @Override
    public MemorySegment memorySegment() {
        return segment;
    }
    
    public NativeStructArray<Simplex> asArray() {
        return new NativeStructArray<>(this);
    }
    
    public static NativeStructArray<Simplex> array(Arena arena, int count) {
        return new NativeStructArray<>(
            arena,
            LAYOUT,
            segment -> new Simplex(segment),
            count
        );
    }
    
    public static NativeStructArray<Simplex> array(Arena arena, Simplex... structs) {
        NativeStructArray<Simplex> array = new NativeStructArray<>(
            arena,
            LAYOUT,
            segment -> new Simplex(segment),
            structs.length
        );
    
        for (int i = 0; i < structs.length; i++) {
            array.set(i, structs[i]);
        }
    
        return array;
    }
    
    public static NativeStructArray<Simplex> array(MemorySegment array) {
        return new NativeStructArray<>(
            array,
            LAYOUT,
            segment -> new Simplex(segment)
        );
    }
    
}