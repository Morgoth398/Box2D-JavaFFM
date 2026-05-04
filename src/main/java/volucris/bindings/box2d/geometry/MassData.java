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
 * This holds the mass data computed for a shape.
 */
public final class MassData
		implements Struct<MassData> {

    public static final StructLayout LAYOUT;

    public static final VarHandle MASS;
    public static final VarHandle ROTATIONAL_INERTIA;

    public static final long MASS_OFFSET;
    public static final long CENTER_OFFSET;
    public static final long ROTATIONAL_INERTIA_OFFSET;

    private final MemorySegment segment;

    private final Vec2 center;

    static {
        //@formatter:off
        LAYOUT = MemoryLayout.structLayout(
            JAVA_FLOAT.withName("mass"),
            Vec2.LAYOUT.withName("center"),
            JAVA_FLOAT.withName("rotationalInertia")
        ).withName("b2MassData").withByteAlignment(4);
        
        MASS = LAYOUT.varHandle(PathElement.groupElement("mass"));
        ROTATIONAL_INERTIA = LAYOUT.varHandle(PathElement.groupElement("rotationalInertia"));
        
        MASS_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("mass"));
        CENTER_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("center"));
        ROTATIONAL_INERTIA_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("rotationalInertia"));
        //@formatter:on
    }

    public MassData() {
        this(Arena.ofAuto());
    }
    
    public MassData(Arena arena) {
        this(arena.allocate(LAYOUT));
    }
    
    public MassData(MemorySegment segment) {
        this.segment = segment;
    
        center = new Vec2(segment.asSlice(CENTER_OFFSET, Vec2.LAYOUT));
    }

    public MassData mass(float mass) {
        MASS.set(segment, 0L, mass);
        return this;
    }
    
    public float mass() {
        return (float) MASS.get(segment, 0L);
    }
    
    public MassData rotationalInertia(float rotationalInertia) {
        ROTATIONAL_INERTIA.set(segment, 0L, rotationalInertia);
        return this;
    }
    
    public float rotationalInertia() {
        return (float) ROTATIONAL_INERTIA.get(segment, 0L);
    }
    
    public MassData center(Consumer<Vec2> consumer) {
        consumer.accept(center);
        return this;
    }
    
    public MassData center(Vec2 other) {
        center.set(other);
        return this;
    }
    
    public Vec2 center() {
        return center;
    }
    
    @Override
    public MassData set(MassData other) {
        return set(other.segment);
    }
    
    @Override
    public MassData set(MemorySegment src) {
        MemorySegment.copy(src, 0L, segment, 0L, LAYOUT.byteSize());
        return this;
    }
    
    @Override
    public MemorySegment memorySegment() {
        return segment;
    }
    
    public NativeStructArray<MassData> asArray() {
        return new NativeStructArray<>(this);
    }
    
    public static NativeStructArray<MassData> array(Arena arena, int count) {
        return new NativeStructArray<>(
            arena,
            LAYOUT,
            segment -> new MassData(segment),
            count
        );
    }
    
    public static NativeStructArray<MassData> array(Arena arena, MassData... structs) {
        NativeStructArray<MassData> array = new NativeStructArray<>(
            arena,
            LAYOUT,
            segment -> new MassData(segment),
            structs.length
        );
    
        for (int i = 0; i < structs.length; i++) {
            array.set(i, structs[i]);
        }
    
        return array;
    }
    
    public static NativeStructArray<MassData> array(MemorySegment array) {
        return new NativeStructArray<>(
            array,
            LAYOUT,
            segment -> new MassData(segment)
        );
    }
    
}