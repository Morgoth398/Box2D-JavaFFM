/*
 * MACHINE GENERATED FILE, DO NOT EDIT.
 */
package volucris.bindings.box2d.events;

import java.lang.foreign.Arena;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.StructLayout;
import java.util.function.Consumer;
import volucris.bindings.box2d.collision.Manifold;
import volucris.bindings.box2d.shape.ShapeId;
import volucris.bindings.core.NativeStructArray;
import volucris.bindings.core.Struct;

import static java.lang.foreign.ValueLayout.*;

/**
 * The contact data for two shapes. By convention the manifold normal points from shape A to shape B.
 */
public final class ContactData
		implements Struct<ContactData> {

    public static final StructLayout LAYOUT;

    public static final long SHAPE_ID_A_BYTE_OFFSET;
    public static final long SHAPE_ID_B_BYTE_OFFSET;
    public static final long MANIFOLD_BYTE_OFFSET;

    private final MemorySegment segment;

    private final ShapeId shapeIdA;
    private final ShapeId shapeIdB;
    private final Manifold manifold;

    static {
        //@formatter:off
        LAYOUT = MemoryLayout.structLayout(
            ShapeId.LAYOUT.withName("shapeIdA"),
            ShapeId.LAYOUT.withName("shapeIdB"),
            Manifold.LAYOUT.withName("manifold")
        ).withName("b2ContactData").withByteAlignment(4);
        
        SHAPE_ID_A_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("shapeIdA"));
        SHAPE_ID_B_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("shapeIdB"));
        MANIFOLD_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("manifold"));
        //@formatter:on
    }

    public ContactData() {
        this(Arena.ofAuto());
    }
    
    public ContactData(Arena arena) {
        this(arena.allocate(LAYOUT));
    }
    
    public ContactData(MemorySegment segment) {
        this.segment = segment;
    
        shapeIdA = new ShapeId(segment.asSlice(SHAPE_ID_A_BYTE_OFFSET, ShapeId.LAYOUT));
        shapeIdB = new ShapeId(segment.asSlice(SHAPE_ID_B_BYTE_OFFSET, ShapeId.LAYOUT));
        manifold = new Manifold(segment.asSlice(MANIFOLD_BYTE_OFFSET, Manifold.LAYOUT));
    }

    public ContactData shapeIdA(Consumer<ShapeId> consumer) {
        consumer.accept(shapeIdA);
        return this;
    }
    
    public ContactData shapeIdA(ShapeId other) {
        shapeIdA.set(other);
        return this;
    }
    
    public ShapeId shapeIdA() {
        return shapeIdA;
    }
    
    public ContactData shapeIdB(Consumer<ShapeId> consumer) {
        consumer.accept(shapeIdB);
        return this;
    }
    
    public ContactData shapeIdB(ShapeId other) {
        shapeIdB.set(other);
        return this;
    }
    
    public ShapeId shapeIdB() {
        return shapeIdB;
    }
    
    public ContactData manifold(Consumer<Manifold> consumer) {
        consumer.accept(manifold);
        return this;
    }
    
    public ContactData manifold(Manifold other) {
        manifold.set(other);
        return this;
    }
    
    public Manifold manifold() {
        return manifold;
    }
    
    @Override
    public ContactData set(ContactData other) {
        return set(other.segment);
    }
    
    @Override
    public ContactData set(MemorySegment src) {
        MemorySegment.copy(src, 0L, segment, 0L, LAYOUT.byteSize());
        return this;
    }
    
    @Override
    public MemorySegment memorySegment() {
        return segment;
    }
    
    public NativeStructArray<ContactData> asArray() {
        return new NativeStructArray<>(this);
    }
    
    public static NativeStructArray<ContactData> array(Arena arena, int count) {
        return new NativeStructArray<>(
            arena,
            LAYOUT,
            segment -> new ContactData(segment),
            count
        );
    }
    
    public static NativeStructArray<ContactData> array(Arena arena, ContactData... structs) {
        NativeStructArray<ContactData> array = new NativeStructArray<>(
            arena,
            LAYOUT,
            segment -> new ContactData(segment),
            structs.length
        );
    
        for (int i = 0; i < structs.length; i++) {
            array.set(i, structs[i]);
        }
    
        return array;
    }
    
    public static NativeStructArray<ContactData> array(MemorySegment array) {
        return new NativeStructArray<>(
            array,
            LAYOUT,
            segment -> new ContactData(segment)
        );
    }
    
}