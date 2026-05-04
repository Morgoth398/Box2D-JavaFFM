/*
 * MACHINE GENERATED FILE, DO NOT EDIT.
 */
package volucris.bindings.box2d.characterMover;

import java.lang.foreign.Arena;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.StructLayout;
import java.lang.invoke.VarHandle;
import java.util.function.Consumer;
import volucris.bindings.box2d.math.Plane;
import volucris.bindings.box2d.math.Vec2;
import volucris.bindings.core.NativeStructArray;
import volucris.bindings.core.Struct;

import static java.lang.foreign.ValueLayout.*;

/**
 * These are the collision planes returned from b2World_CollideMover
 */
public final class PlaneResult
		implements Struct<PlaneResult> {

    public static final StructLayout LAYOUT;

    public static final VarHandle HIT;

    public static final long PLANE_OFFSET;
    public static final long POINT_OFFSET;
    public static final long HIT_OFFSET;

    private final MemorySegment segment;

    private final Plane plane;
    private final Vec2 point;

    static {
        //@formatter:off
        LAYOUT = MemoryLayout.structLayout(
            Plane.LAYOUT.withName("plane"),
            Vec2.LAYOUT.withName("point"),
            JAVA_BOOLEAN.withName("hit"),
            MemoryLayout.paddingLayout(3)
        ).withName("b2PlaneResult").withByteAlignment(4);
        
        HIT = LAYOUT.varHandle(PathElement.groupElement("hit"));
        
        PLANE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("plane"));
        POINT_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("point"));
        HIT_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("hit"));
        //@formatter:on
    }

    public PlaneResult() {
        this(Arena.ofAuto());
    }
    
    public PlaneResult(Arena arena) {
        this(arena.allocate(LAYOUT));
    }
    
    public PlaneResult(MemorySegment segment) {
        this.segment = segment;
    
        plane = new Plane(segment.asSlice(PLANE_OFFSET, Plane.LAYOUT));
        point = new Vec2(segment.asSlice(POINT_OFFSET, Vec2.LAYOUT));
    }

    public PlaneResult hit(boolean hit) {
        HIT.set(segment, 0L, hit);
        return this;
    }
    
    public boolean hit() {
        return (boolean) HIT.get(segment, 0L);
    }
    
    public PlaneResult plane(Consumer<Plane> consumer) {
        consumer.accept(plane);
        return this;
    }
    
    public PlaneResult plane(Plane other) {
        plane.set(other);
        return this;
    }
    
    public Plane plane() {
        return plane;
    }
    
    public PlaneResult point(Consumer<Vec2> consumer) {
        consumer.accept(point);
        return this;
    }
    
    public PlaneResult point(Vec2 other) {
        point.set(other);
        return this;
    }
    
    public Vec2 point() {
        return point;
    }
    
    @Override
    public PlaneResult set(PlaneResult other) {
        return set(other.segment);
    }
    
    @Override
    public PlaneResult set(MemorySegment src) {
        MemorySegment.copy(src, 0L, segment, 0L, LAYOUT.byteSize());
        return this;
    }
    
    @Override
    public MemorySegment memorySegment() {
        return segment;
    }
    
    public NativeStructArray<PlaneResult> asArray() {
        return new NativeStructArray<>(this);
    }
    
    public static NativeStructArray<PlaneResult> array(Arena arena, int count) {
        return new NativeStructArray<>(
            arena,
            LAYOUT,
            segment -> new PlaneResult(segment),
            count
        );
    }
    
    public static NativeStructArray<PlaneResult> array(Arena arena, PlaneResult... structs) {
        NativeStructArray<PlaneResult> array = new NativeStructArray<>(
            arena,
            LAYOUT,
            segment -> new PlaneResult(segment),
            structs.length
        );
    
        for (int i = 0; i < structs.length; i++) {
            array.set(i, structs[i]);
        }
    
        return array;
    }
    
    public static NativeStructArray<PlaneResult> array(MemorySegment array) {
        return new NativeStructArray<>(
            array,
            LAYOUT,
            segment -> new PlaneResult(segment)
        );
    }
    
}