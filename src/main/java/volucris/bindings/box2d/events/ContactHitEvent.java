/*
 * MACHINE GENERATED FILE, DO NOT EDIT.
 */
package volucris.bindings.box2d.events;

import java.lang.foreign.Arena;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.StructLayout;
import java.lang.invoke.VarHandle;
import java.util.function.Consumer;
import volucris.bindings.box2d.math.Vec2;
import volucris.bindings.box2d.shape.ShapeId;
import volucris.bindings.core.NativeStructArray;
import volucris.bindings.core.Struct;

import static java.lang.foreign.ValueLayout.*;

/**
 * A hit touch event is generated when two shapes collide with a speed faster than the hit speed threshold. This may be reported for speculative contacts that have a confirmed impulse.
 */
public final class ContactHitEvent
		implements Struct<ContactHitEvent> {

    public static final StructLayout LAYOUT;

    public static final VarHandle APPROACH_SPEED;

    public static final long SHAPE_ID_A_OFFSET;
    public static final long SHAPE_ID_B_OFFSET;
    public static final long POINT_OFFSET;
    public static final long NORMAL_OFFSET;
    public static final long APPROACH_SPEED_OFFSET;

    private final MemorySegment segment;

    private final ShapeId shapeIdA;
    private final ShapeId shapeIdB;
    private final Vec2 point;
    private final Vec2 normal;

    static {
        //@formatter:off
        LAYOUT = MemoryLayout.structLayout(
            ShapeId.LAYOUT.withName("shapeIdA"),
            ShapeId.LAYOUT.withName("shapeIdB"),
            Vec2.LAYOUT.withName("point"),
            Vec2.LAYOUT.withName("normal"),
            JAVA_FLOAT.withName("approachSpeed")
        ).withName("b2ContactHitEvent").withByteAlignment(4);
        
        APPROACH_SPEED = LAYOUT.varHandle(PathElement.groupElement("approachSpeed"));
        
        SHAPE_ID_A_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("shapeIdA"));
        SHAPE_ID_B_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("shapeIdB"));
        POINT_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("point"));
        NORMAL_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("normal"));
        APPROACH_SPEED_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("approachSpeed"));
        //@formatter:on
    }

    public ContactHitEvent() {
        this(Arena.ofAuto());
    }
    
    public ContactHitEvent(Arena arena) {
        this(arena.allocate(LAYOUT));
    }
    
    public ContactHitEvent(MemorySegment segment) {
        this.segment = segment;
    
        shapeIdA = new ShapeId(segment.asSlice(SHAPE_ID_A_OFFSET, ShapeId.LAYOUT));
        shapeIdB = new ShapeId(segment.asSlice(SHAPE_ID_B_OFFSET, ShapeId.LAYOUT));
        point = new Vec2(segment.asSlice(POINT_OFFSET, Vec2.LAYOUT));
        normal = new Vec2(segment.asSlice(NORMAL_OFFSET, Vec2.LAYOUT));
    }

    public ContactHitEvent approachSpeed(float approachSpeed) {
        APPROACH_SPEED.set(segment, 0L, approachSpeed);
        return this;
    }
    
    public float approachSpeed() {
        return (float) APPROACH_SPEED.get(segment, 0L);
    }
    
    public ContactHitEvent shapeIdA(Consumer<ShapeId> consumer) {
        consumer.accept(shapeIdA);
        return this;
    }
    
    public ContactHitEvent shapeIdA(ShapeId other) {
        shapeIdA.set(other);
        return this;
    }
    
    public ShapeId shapeIdA() {
        return shapeIdA;
    }
    
    public ContactHitEvent shapeIdB(Consumer<ShapeId> consumer) {
        consumer.accept(shapeIdB);
        return this;
    }
    
    public ContactHitEvent shapeIdB(ShapeId other) {
        shapeIdB.set(other);
        return this;
    }
    
    public ShapeId shapeIdB() {
        return shapeIdB;
    }
    
    public ContactHitEvent point(Consumer<Vec2> consumer) {
        consumer.accept(point);
        return this;
    }
    
    public ContactHitEvent point(Vec2 other) {
        point.set(other);
        return this;
    }
    
    public Vec2 point() {
        return point;
    }
    
    public ContactHitEvent normal(Consumer<Vec2> consumer) {
        consumer.accept(normal);
        return this;
    }
    
    public ContactHitEvent normal(Vec2 other) {
        normal.set(other);
        return this;
    }
    
    public Vec2 normal() {
        return normal;
    }
    
    @Override
    public ContactHitEvent set(ContactHitEvent other) {
        return set(other.segment);
    }
    
    @Override
    public ContactHitEvent set(MemorySegment src) {
        MemorySegment.copy(src, 0L, segment, 0L, LAYOUT.byteSize());
        return this;
    }
    
    @Override
    public MemorySegment memorySegment() {
        return segment;
    }
    
    public NativeStructArray<ContactHitEvent> asArray() {
        return new NativeStructArray<>(this);
    }
    
    public static NativeStructArray<ContactHitEvent> array(Arena arena, int count) {
        return new NativeStructArray<>(
            arena,
            LAYOUT,
            segment -> new ContactHitEvent(segment),
            count
        );
    }
    
    public static NativeStructArray<ContactHitEvent> array(Arena arena, ContactHitEvent... structs) {
        NativeStructArray<ContactHitEvent> array = new NativeStructArray<>(
            arena,
            LAYOUT,
            segment -> new ContactHitEvent(segment),
            structs.length
        );
    
        for (int i = 0; i < structs.length; i++) {
            array.set(i, structs[i]);
        }
    
        return array;
    }
    
    public static NativeStructArray<ContactHitEvent> array(MemorySegment array) {
        return new NativeStructArray<>(
            array,
            LAYOUT,
            segment -> new ContactHitEvent(segment)
        );
    }
    
}