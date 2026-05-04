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
 * A 2D rigid transform
 */
public final class Transform
		implements Struct<Transform> {

    public static final StructLayout LAYOUT;

    public static final long P_OFFSET;
    public static final long Q_OFFSET;

    private final MemorySegment segment;

    private final Vec2 p;
    private final Rot q;

    static {
        //@formatter:off
        LAYOUT = MemoryLayout.structLayout(
            Vec2.LAYOUT.withName("p"),
            Rot.LAYOUT.withName("q")
        ).withName("b2Transform").withByteAlignment(4);
        
        P_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("p"));
        Q_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("q"));
        //@formatter:on
    }

    public Transform() {
        this(Arena.ofAuto());
    }
    
    public Transform(Arena arena) {
        this(arena.allocate(LAYOUT));
    }
    
    public Transform(MemorySegment segment) {
        this.segment = segment;
    
        p = new Vec2(segment.asSlice(P_OFFSET, Vec2.LAYOUT));
        q = new Rot(segment.asSlice(Q_OFFSET, Rot.LAYOUT));
    }

    public Transform p(Consumer<Vec2> consumer) {
        consumer.accept(p);
        return this;
    }
    
    public Transform p(Vec2 other) {
        p.set(other);
        return this;
    }
    
    public Vec2 p() {
        return p;
    }
    
    public Transform q(Consumer<Rot> consumer) {
        consumer.accept(q);
        return this;
    }
    
    public Transform q(Rot other) {
        q.set(other);
        return this;
    }
    
    public Rot q() {
        return q;
    }
    
    @Override
    public Transform set(Transform other) {
        return set(other.segment);
    }
    
    @Override
    public Transform set(MemorySegment src) {
        MemorySegment.copy(src, 0L, segment, 0L, LAYOUT.byteSize());
        return this;
    }
    
    @Override
    public MemorySegment memorySegment() {
        return segment;
    }
    
    public NativeStructArray<Transform> asArray() {
        return new NativeStructArray<>(this);
    }
    
    public static NativeStructArray<Transform> array(Arena arena, int count) {
        return new NativeStructArray<>(
            arena,
            LAYOUT,
            segment -> new Transform(segment),
            count
        );
    }
    
    public static NativeStructArray<Transform> array(Arena arena, Transform... structs) {
        NativeStructArray<Transform> array = new NativeStructArray<>(
            arena,
            LAYOUT,
            segment -> new Transform(segment),
            structs.length
        );
    
        for (int i = 0; i < structs.length; i++) {
            array.set(i, structs[i]);
        }
    
        return array;
    }
    
    public static NativeStructArray<Transform> array(MemorySegment array) {
        return new NativeStructArray<>(
            array,
            LAYOUT,
            segment -> new Transform(segment)
        );
    }
    
}