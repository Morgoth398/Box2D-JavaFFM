/*
 * MACHINE GENERATED FILE, DO NOT EDIT.
 */
package volucris.bindings.box2d.math;

import java.lang.foreign.Arena;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.StructLayout;
import java.lang.invoke.VarHandle;
import volucris.bindings.core.NativeStructArray;
import volucris.bindings.core.Struct;

import static java.lang.foreign.ValueLayout.*;

/**
 * 2D rotation This is similar to using a complex number for rotation
 */
public final class Rot
		implements Struct<Rot> {

    public static final StructLayout LAYOUT;

    public static final VarHandle C;
    public static final VarHandle S;

    public static final long C_OFFSET;
    public static final long S_OFFSET;

    private final MemorySegment segment;

    static {
        //@formatter:off
        LAYOUT = MemoryLayout.structLayout(
            JAVA_FLOAT.withName("c"),
            JAVA_FLOAT.withName("s")
        ).withName("b2Rot").withByteAlignment(4);
        
        C = LAYOUT.varHandle(PathElement.groupElement("c"));
        S = LAYOUT.varHandle(PathElement.groupElement("s"));
        
        C_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("c"));
        S_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("s"));
        //@formatter:on
    }

    public Rot() {
        this(Arena.ofAuto());
    }
    
    public Rot(Arena arena) {
        this(arena.allocate(LAYOUT));
    }
    
    public Rot(MemorySegment segment) {
        this.segment = segment;
    
    }

    public Rot c(float c) {
        C.set(segment, 0L, c);
        return this;
    }
    
    public float c() {
        return (float) C.get(segment, 0L);
    }
    
    public Rot s(float s) {
        S.set(segment, 0L, s);
        return this;
    }
    
    public float s() {
        return (float) S.get(segment, 0L);
    }
    
    @Override
    public Rot set(Rot other) {
        return set(other.segment);
    }
    
    @Override
    public Rot set(MemorySegment src) {
        MemorySegment.copy(src, 0L, segment, 0L, LAYOUT.byteSize());
        return this;
    }
    
    @Override
    public MemorySegment memorySegment() {
        return segment;
    }
    
    public NativeStructArray<Rot> asArray() {
        return new NativeStructArray<>(this);
    }
    
    public static NativeStructArray<Rot> array(Arena arena, int count) {
        return new NativeStructArray<>(
            arena,
            LAYOUT,
            segment -> new Rot(segment),
            count
        );
    }
    
    public static NativeStructArray<Rot> array(Arena arena, Rot... structs) {
        NativeStructArray<Rot> array = new NativeStructArray<>(
            arena,
            LAYOUT,
            segment -> new Rot(segment),
            structs.length
        );
    
        for (int i = 0; i < structs.length; i++) {
            array.set(i, structs[i]);
        }
    
        return array;
    }
    
    public static NativeStructArray<Rot> array(MemorySegment array) {
        return new NativeStructArray<>(
            array,
            LAYOUT,
            segment -> new Rot(segment)
        );
    }
    
}