/*
 * MACHINE GENERATED FILE, DO NOT EDIT.
 */
package volucris.bindings.box2d.distance;

import java.lang.foreign.Arena;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.StructLayout;
import java.lang.invoke.VarHandle;
import volucris.bindings.core.NativeStructArray;
import volucris.bindings.core.Struct;

import static java.lang.foreign.ValueLayout.*;

/**
 * Used to warm start the GJK simplex. If you call this function multiple times with nearby transforms this might improve performance. Otherwise you can zero initialize this. The distance cache must be initialized to zero on the first call. Users should generally just zero initialize this structure for each call.
 */
public final class SimplexCache
		implements Struct<SimplexCache> {

    public static final StructLayout LAYOUT;

    public static final VarHandle COUNT;
    public static final VarHandle INDEX_A;
    public static final VarHandle INDEX_B;

    public static final long COUNT_OFFSET;
    public static final long INDEX_A_OFFSET;
    public static final long INDEX_B_OFFSET;

    private final MemorySegment segment;

    static {
        //@formatter:off
        LAYOUT = MemoryLayout.structLayout(
            JAVA_SHORT.withName("count"),
            MemoryLayout.sequenceLayout(3, JAVA_BYTE).withName("indexA"),
            MemoryLayout.sequenceLayout(3, JAVA_BYTE).withName("indexB")
        ).withName("b2SimplexCache").withByteAlignment(2);
        
        COUNT = LAYOUT.varHandle(PathElement.groupElement("count"));
        INDEX_A = LAYOUT.varHandle(PathElement.groupElement("indexA"), PathElement.sequenceElement());
        INDEX_B = LAYOUT.varHandle(PathElement.groupElement("indexB"), PathElement.sequenceElement());
        
        COUNT_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("count"));
        INDEX_A_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("indexA"));
        INDEX_B_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("indexB"));
        //@formatter:on
    }

    public SimplexCache() {
        this(Arena.ofAuto());
    }
    
    public SimplexCache(Arena arena) {
        this(arena.allocate(LAYOUT));
    }
    
    public SimplexCache(MemorySegment segment) {
        this.segment = segment;
    
    }

    public SimplexCache count(short count) {
        COUNT.set(segment, 0L, count);
        return this;
    }
    
    public short count() {
        return (short) COUNT.get(segment, 0L);
    }
    
    public SimplexCache indexA(byte indexA, long index) {
        INDEX_A.set(segment, 0L, index, indexA);
        return this;
    }
    
    public byte indexA(long index) {
        return (byte) INDEX_A.get(segment, 0L, index);
    }
    
    public SimplexCache indexB(byte indexB, long index) {
        INDEX_B.set(segment, 0L, index, indexB);
        return this;
    }
    
    public byte indexB(long index) {
        return (byte) INDEX_B.get(segment, 0L, index);
    }
    
    @Override
    public SimplexCache set(SimplexCache other) {
        return set(other.segment);
    }
    
    @Override
    public SimplexCache set(MemorySegment src) {
        MemorySegment.copy(src, 0L, segment, 0L, LAYOUT.byteSize());
        return this;
    }
    
    @Override
    public MemorySegment memorySegment() {
        return segment;
    }
    
    public NativeStructArray<SimplexCache> asArray() {
        return new NativeStructArray<>(this);
    }
    
    public static NativeStructArray<SimplexCache> array(Arena arena, int count) {
        return new NativeStructArray<>(
            arena,
            LAYOUT,
            segment -> new SimplexCache(segment),
            count
        );
    }
    
    public static NativeStructArray<SimplexCache> array(Arena arena, SimplexCache... structs) {
        NativeStructArray<SimplexCache> array = new NativeStructArray<>(
            arena,
            LAYOUT,
            segment -> new SimplexCache(segment),
            structs.length
        );
    
        for (int i = 0; i < structs.length; i++) {
            array.set(i, structs[i]);
        }
    
        return array;
    }
    
    public static NativeStructArray<SimplexCache> array(MemorySegment array) {
        return new NativeStructArray<>(
            array,
            LAYOUT,
            segment -> new SimplexCache(segment)
        );
    }
    
}