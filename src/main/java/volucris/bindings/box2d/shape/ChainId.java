/*
 * MACHINE GENERATED FILE, DO NOT EDIT.
 */
package volucris.bindings.box2d.shape;

import java.lang.foreign.Arena;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.StructLayout;
import java.lang.invoke.VarHandle;
import volucris.bindings.core.NativeStructArray;
import volucris.bindings.core.Struct;

import static java.lang.foreign.ValueLayout.*;

/**
 * Chain id references a chain instances. This should be treated as an opaque handle.
 */
public final class ChainId
		implements Struct<ChainId> {

    public static final StructLayout LAYOUT;

    public static final VarHandle INDEX1_HANDLE;
    public static final VarHandle WORLD0_HANDLE;
    public static final VarHandle GENERATION_HANDLE;

    public static final long INDEX1_BYTE_OFFSET;
    public static final long WORLD0_BYTE_OFFSET;
    public static final long GENERATION_BYTE_OFFSET;

    private final MemorySegment segment;

    static {
        //@formatter:off
        LAYOUT = MemoryLayout.structLayout(
            JAVA_INT.withName("index1"),
            JAVA_SHORT.withName("world0"),
            JAVA_SHORT.withName("generation")
        ).withName("b2ChainId").withByteAlignment(4);
        
        INDEX1_HANDLE = LAYOUT.varHandle(PathElement.groupElement("index1"));
        WORLD0_HANDLE = LAYOUT.varHandle(PathElement.groupElement("world0"));
        GENERATION_HANDLE = LAYOUT.varHandle(PathElement.groupElement("generation"));
        
        INDEX1_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("index1"));
        WORLD0_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("world0"));
        GENERATION_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("generation"));
        //@formatter:on
    }

    public ChainId() {
        this(Arena.ofAuto());
    }
    
    public ChainId(Arena arena) {
        this(arena.allocate(LAYOUT));
    }
    
    public ChainId(MemorySegment segment) {
        this.segment = segment;
    
    }

    public ChainId index1(int index1) {
        INDEX1_HANDLE.set(segment, 0L, index1);
        return this;
    }
    
    public int index1() {
        return (int) INDEX1_HANDLE.get(segment, 0L);
    }
    
    public ChainId world0(short world0) {
        WORLD0_HANDLE.set(segment, 0L, world0);
        return this;
    }
    
    public short world0() {
        return (short) WORLD0_HANDLE.get(segment, 0L);
    }
    
    public ChainId generation(short generation) {
        GENERATION_HANDLE.set(segment, 0L, generation);
        return this;
    }
    
    public short generation() {
        return (short) GENERATION_HANDLE.get(segment, 0L);
    }
    
    @Override
    public ChainId set(ChainId other) {
        return set(other.segment);
    }
    
    @Override
    public ChainId set(MemorySegment src) {
        MemorySegment.copy(src, 0L, segment, 0L, LAYOUT.byteSize());
        return this;
    }
    
    @Override
    public MemorySegment memorySegment() {
        return segment;
    }
    
    public NativeStructArray<ChainId> asArray() {
        return new NativeStructArray<>(this);
    }
    
    public static NativeStructArray<ChainId> array(Arena arena, int count) {
        return new NativeStructArray<>(
            arena,
            LAYOUT,
            segment -> new ChainId(segment),
            count
        );
    }
    
    public static NativeStructArray<ChainId> array(Arena arena, ChainId... structs) {
        NativeStructArray<ChainId> array = new NativeStructArray<>(
            arena,
            LAYOUT,
            segment -> new ChainId(segment),
            structs.length
        );
    
        for (int i = 0; i < structs.length; i++) {
            array.set(i, structs[i]);
        }
    
        return array;
    }
    
    public static NativeStructArray<ChainId> array(MemorySegment array) {
        return new NativeStructArray<>(
            array,
            LAYOUT,
            segment -> new ChainId(segment)
        );
    }
    
}