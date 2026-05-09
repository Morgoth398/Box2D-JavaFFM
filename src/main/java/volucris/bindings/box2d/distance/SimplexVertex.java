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
 * Simplex vertex for debugging the GJK algorithm
 */
public final class SimplexVertex
		implements Struct<SimplexVertex> {

    public static final StructLayout LAYOUT;

    public static final VarHandle A_HANDLE;
    public static final VarHandle INDEX_A_HANDLE;
    public static final VarHandle INDEX_B_HANDLE;

    public static final long W_A_BYTE_OFFSET;
    public static final long W_B_BYTE_OFFSET;
    public static final long W_BYTE_OFFSET;
    public static final long A_BYTE_OFFSET;
    public static final long INDEX_A_BYTE_OFFSET;
    public static final long INDEX_B_BYTE_OFFSET;

    private final MemorySegment segment;

    private final Vec2 wA;
    private final Vec2 wB;
    private final Vec2 w;

    static {
        //@formatter:off
        LAYOUT = MemoryLayout.structLayout(
            Vec2.LAYOUT.withName("wA"),
            Vec2.LAYOUT.withName("wB"),
            Vec2.LAYOUT.withName("w"),
            JAVA_FLOAT.withName("a"),
            JAVA_INT.withName("indexA"),
            JAVA_INT.withName("indexB")
        ).withName("b2SimplexVertex").withByteAlignment(4);
        
        A_HANDLE = LAYOUT.varHandle(PathElement.groupElement("a"));
        INDEX_A_HANDLE = LAYOUT.varHandle(PathElement.groupElement("indexA"));
        INDEX_B_HANDLE = LAYOUT.varHandle(PathElement.groupElement("indexB"));
        
        W_A_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("wA"));
        W_B_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("wB"));
        W_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("w"));
        A_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("a"));
        INDEX_A_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("indexA"));
        INDEX_B_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("indexB"));
        //@formatter:on
    }

    public SimplexVertex() {
        this(Arena.ofAuto());
    }
    
    public SimplexVertex(Arena arena) {
        this(arena.allocate(LAYOUT));
    }
    
    public SimplexVertex(MemorySegment segment) {
        this.segment = segment;
    
        wA = new Vec2(segment.asSlice(W_A_BYTE_OFFSET, Vec2.LAYOUT));
        wB = new Vec2(segment.asSlice(W_B_BYTE_OFFSET, Vec2.LAYOUT));
        w = new Vec2(segment.asSlice(W_BYTE_OFFSET, Vec2.LAYOUT));
    }

    public SimplexVertex a(float a) {
        A_HANDLE.set(segment, 0L, a);
        return this;
    }
    
    public float a() {
        return (float) A_HANDLE.get(segment, 0L);
    }
    
    public SimplexVertex indexA(int indexA) {
        INDEX_A_HANDLE.set(segment, 0L, indexA);
        return this;
    }
    
    public int indexA() {
        return (int) INDEX_A_HANDLE.get(segment, 0L);
    }
    
    public SimplexVertex indexB(int indexB) {
        INDEX_B_HANDLE.set(segment, 0L, indexB);
        return this;
    }
    
    public int indexB() {
        return (int) INDEX_B_HANDLE.get(segment, 0L);
    }
    
    public SimplexVertex wA(Consumer<Vec2> consumer) {
        consumer.accept(wA);
        return this;
    }
    
    public SimplexVertex wA(Vec2 other) {
        wA.set(other);
        return this;
    }
    
    public Vec2 wA() {
        return wA;
    }
    
    public SimplexVertex wB(Consumer<Vec2> consumer) {
        consumer.accept(wB);
        return this;
    }
    
    public SimplexVertex wB(Vec2 other) {
        wB.set(other);
        return this;
    }
    
    public Vec2 wB() {
        return wB;
    }
    
    public SimplexVertex w(Consumer<Vec2> consumer) {
        consumer.accept(w);
        return this;
    }
    
    public SimplexVertex w(Vec2 other) {
        w.set(other);
        return this;
    }
    
    public Vec2 w() {
        return w;
    }
    
    @Override
    public SimplexVertex set(SimplexVertex other) {
        return set(other.segment);
    }
    
    @Override
    public SimplexVertex set(MemorySegment src) {
        MemorySegment.copy(src, 0L, segment, 0L, LAYOUT.byteSize());
        return this;
    }
    
    @Override
    public MemorySegment memorySegment() {
        return segment;
    }
    
    public NativeStructArray<SimplexVertex> asArray() {
        return new NativeStructArray<>(this);
    }
    
    public static NativeStructArray<SimplexVertex> array(Arena arena, int count) {
        return new NativeStructArray<>(
            arena,
            LAYOUT,
            segment -> new SimplexVertex(segment),
            count
        );
    }
    
    public static NativeStructArray<SimplexVertex> array(Arena arena, SimplexVertex... structs) {
        NativeStructArray<SimplexVertex> array = new NativeStructArray<>(
            arena,
            LAYOUT,
            segment -> new SimplexVertex(segment),
            structs.length
        );
    
        for (int i = 0; i < structs.length; i++) {
            array.set(i, structs[i]);
        }
    
        return array;
    }
    
    public static NativeStructArray<SimplexVertex> array(MemorySegment array) {
        return new NativeStructArray<>(
            array,
            LAYOUT,
            segment -> new SimplexVertex(segment)
        );
    }
    
}