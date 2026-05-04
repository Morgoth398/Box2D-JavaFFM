/*
 * MACHINE GENERATED FILE, DO NOT EDIT.
 */
package volucris.bindings.box2d.shape;

import edu.umd.cs.findbugs.annotations.Nullable;
import java.lang.foreign.Arena;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.SegmentAllocator;
import java.lang.foreign.StructLayout;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.util.function.Consumer;
import volucris.bindings.core.NativeStructArray;
import volucris.bindings.core.Struct;

import static java.lang.foreign.ValueLayout.*;
import static volucris.bindings.core.FFMUtils.*;

/**
 * Used to create a shape. This is a temporary object used to bundle shape creation parameters. You may use the same shape definition to create multiple shapes. Must be initialized using b2DefaultShapeDef().
 */
public final class ShapeDef
		implements Struct<ShapeDef> {

    private static final LazyConstant<MethodHandle> B2_DEFAULT_SHAPE_DEF;

    public static final StructLayout LAYOUT;

    public static final VarHandle USER_DATA;
    public static final VarHandle DENSITY;
    public static final VarHandle IS_SENSOR;
    public static final VarHandle ENABLE_SENSOR_EVENTS;
    public static final VarHandle ENABLE_CONTACT_EVENTS;
    public static final VarHandle ENABLE_HIT_EVENTS;
    public static final VarHandle ENABLE_PRE_SOLVE_EVENTS;
    public static final VarHandle INVOKE_CONTACT_CREATION;
    public static final VarHandle UPDATE_BODY_MASS;
    public static final VarHandle INTERNAL_VALUE;

    public static final long USER_DATA_OFFSET;
    public static final long MATERIAL_OFFSET;
    public static final long DENSITY_OFFSET;
    public static final long FILTER_OFFSET;
    public static final long IS_SENSOR_OFFSET;
    public static final long ENABLE_SENSOR_EVENTS_OFFSET;
    public static final long ENABLE_CONTACT_EVENTS_OFFSET;
    public static final long ENABLE_HIT_EVENTS_OFFSET;
    public static final long ENABLE_PRE_SOLVE_EVENTS_OFFSET;
    public static final long INVOKE_CONTACT_CREATION_OFFSET;
    public static final long UPDATE_BODY_MASS_OFFSET;
    public static final long INTERNAL_VALUE_OFFSET;

    private final MemorySegment segment;

    private final SurfaceMaterial material;
    private final Filter filter;

    static {
        //@formatter:off
        LAYOUT = MemoryLayout.structLayout(
            UNBOUNDED_ADDRESS.withName("userData"),
            SurfaceMaterial.LAYOUT.withName("material"),
            JAVA_FLOAT.withName("density"),
            MemoryLayout.paddingLayout(4),
            Filter.LAYOUT.withName("filter"),
            JAVA_BOOLEAN.withName("isSensor"),
            JAVA_BOOLEAN.withName("enableSensorEvents"),
            JAVA_BOOLEAN.withName("enableContactEvents"),
            JAVA_BOOLEAN.withName("enableHitEvents"),
            JAVA_BOOLEAN.withName("enablePreSolveEvents"),
            JAVA_BOOLEAN.withName("invokeContactCreation"),
            JAVA_BOOLEAN.withName("updateBodyMass"),
            MemoryLayout.paddingLayout(1),
            JAVA_INT.withName("internalValue"),
            MemoryLayout.paddingLayout(4)
        ).withName("b2ShapeDef").withByteAlignment(8);
        
        B2_DEFAULT_SHAPE_DEF = downcallHandle("b2DefaultShapeDef", ShapeDef.LAYOUT);
        
        USER_DATA = LAYOUT.varHandle(PathElement.groupElement("userData"));
        DENSITY = LAYOUT.varHandle(PathElement.groupElement("density"));
        IS_SENSOR = LAYOUT.varHandle(PathElement.groupElement("isSensor"));
        ENABLE_SENSOR_EVENTS = LAYOUT.varHandle(PathElement.groupElement("enableSensorEvents"));
        ENABLE_CONTACT_EVENTS = LAYOUT.varHandle(PathElement.groupElement("enableContactEvents"));
        ENABLE_HIT_EVENTS = LAYOUT.varHandle(PathElement.groupElement("enableHitEvents"));
        ENABLE_PRE_SOLVE_EVENTS = LAYOUT.varHandle(PathElement.groupElement("enablePreSolveEvents"));
        INVOKE_CONTACT_CREATION = LAYOUT.varHandle(PathElement.groupElement("invokeContactCreation"));
        UPDATE_BODY_MASS = LAYOUT.varHandle(PathElement.groupElement("updateBodyMass"));
        INTERNAL_VALUE = LAYOUT.varHandle(PathElement.groupElement("internalValue"));
        
        USER_DATA_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("userData"));
        MATERIAL_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("material"));
        DENSITY_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("density"));
        FILTER_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("filter"));
        IS_SENSOR_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("isSensor"));
        ENABLE_SENSOR_EVENTS_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("enableSensorEvents"));
        ENABLE_CONTACT_EVENTS_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("enableContactEvents"));
        ENABLE_HIT_EVENTS_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("enableHitEvents"));
        ENABLE_PRE_SOLVE_EVENTS_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("enablePreSolveEvents"));
        INVOKE_CONTACT_CREATION_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("invokeContactCreation"));
        UPDATE_BODY_MASS_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("updateBodyMass"));
        INTERNAL_VALUE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("internalValue"));
        //@formatter:on
    }

    public ShapeDef(MemorySegment segment) {
        this.segment = segment;
    
        material = new SurfaceMaterial(segment.asSlice(MATERIAL_OFFSET, SurfaceMaterial.LAYOUT));
        filter = new Filter(segment.asSlice(FILTER_OFFSET, Filter.LAYOUT));
    }

    /**
     * Use this to initialize your shape definition
     */
    public static MemorySegment ndefaultShapeDef(
        SegmentAllocator allocator
    ) {
        MethodHandle method = B2_DEFAULT_SHAPE_DEF.get();
        try {
            return (MemorySegment) method.invokeExact(
                allocator
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #ndefaultShapeDef}.
     */
    public static @Nullable ShapeDef defaultShapeDef(
        SegmentAllocator allocator
    ) {
        MemorySegment segment = ndefaultShapeDef(allocator);
    
        if (segment.equals(MemorySegment.NULL))
            return null;
    
        return new ShapeDef(segment);
    }
    
    public ShapeDef userData(MemorySegment userData) {
        USER_DATA.set(segment, 0L, userData);
        return this;
    }
    
    public @Nullable MemorySegment userData() {
        MemorySegment segment = (MemorySegment) USER_DATA.get(this.segment, 0L);
    
        if (segment.equals(MemorySegment.NULL))
            return null;
    
        return segment;
    }
    
    public ShapeDef density(float density) {
        DENSITY.set(segment, 0L, density);
        return this;
    }
    
    public float density() {
        return (float) DENSITY.get(segment, 0L);
    }
    
    public ShapeDef isSensor(boolean isSensor) {
        IS_SENSOR.set(segment, 0L, isSensor);
        return this;
    }
    
    public boolean isSensor() {
        return (boolean) IS_SENSOR.get(segment, 0L);
    }
    
    public ShapeDef enableSensorEvents(boolean enableSensorEvents) {
        ENABLE_SENSOR_EVENTS.set(segment, 0L, enableSensorEvents);
        return this;
    }
    
    public boolean enableSensorEvents() {
        return (boolean) ENABLE_SENSOR_EVENTS.get(segment, 0L);
    }
    
    public ShapeDef enableContactEvents(boolean enableContactEvents) {
        ENABLE_CONTACT_EVENTS.set(segment, 0L, enableContactEvents);
        return this;
    }
    
    public boolean enableContactEvents() {
        return (boolean) ENABLE_CONTACT_EVENTS.get(segment, 0L);
    }
    
    public ShapeDef enableHitEvents(boolean enableHitEvents) {
        ENABLE_HIT_EVENTS.set(segment, 0L, enableHitEvents);
        return this;
    }
    
    public boolean enableHitEvents() {
        return (boolean) ENABLE_HIT_EVENTS.get(segment, 0L);
    }
    
    public ShapeDef enablePreSolveEvents(boolean enablePreSolveEvents) {
        ENABLE_PRE_SOLVE_EVENTS.set(segment, 0L, enablePreSolveEvents);
        return this;
    }
    
    public boolean enablePreSolveEvents() {
        return (boolean) ENABLE_PRE_SOLVE_EVENTS.get(segment, 0L);
    }
    
    public ShapeDef invokeContactCreation(boolean invokeContactCreation) {
        INVOKE_CONTACT_CREATION.set(segment, 0L, invokeContactCreation);
        return this;
    }
    
    public boolean invokeContactCreation() {
        return (boolean) INVOKE_CONTACT_CREATION.get(segment, 0L);
    }
    
    public ShapeDef updateBodyMass(boolean updateBodyMass) {
        UPDATE_BODY_MASS.set(segment, 0L, updateBodyMass);
        return this;
    }
    
    public boolean updateBodyMass() {
        return (boolean) UPDATE_BODY_MASS.get(segment, 0L);
    }
    
    public ShapeDef internalValue(int internalValue) {
        INTERNAL_VALUE.set(segment, 0L, internalValue);
        return this;
    }
    
    public int internalValue() {
        return (int) INTERNAL_VALUE.get(segment, 0L);
    }
    
    public ShapeDef material(Consumer<SurfaceMaterial> consumer) {
        consumer.accept(material);
        return this;
    }
    
    public ShapeDef material(SurfaceMaterial other) {
        material.set(other);
        return this;
    }
    
    public SurfaceMaterial material() {
        return material;
    }
    
    public ShapeDef filter(Consumer<Filter> consumer) {
        consumer.accept(filter);
        return this;
    }
    
    public ShapeDef filter(Filter other) {
        filter.set(other);
        return this;
    }
    
    public Filter filter() {
        return filter;
    }
    
    @Override
    public ShapeDef set(ShapeDef other) {
        return set(other.segment);
    }
    
    @Override
    public ShapeDef set(MemorySegment src) {
        MemorySegment.copy(src, 0L, segment, 0L, LAYOUT.byteSize());
        return this;
    }
    
    @Override
    public MemorySegment memorySegment() {
        return segment;
    }
    
    public NativeStructArray<ShapeDef> asArray() {
        return new NativeStructArray<>(this);
    }
    
    public static NativeStructArray<ShapeDef> array(Arena arena, int count) {
        return new NativeStructArray<>(
            arena,
            LAYOUT,
            segment -> new ShapeDef(segment),
            count
        );
    }
    
    public static NativeStructArray<ShapeDef> array(Arena arena, ShapeDef... structs) {
        NativeStructArray<ShapeDef> array = new NativeStructArray<>(
            arena,
            LAYOUT,
            segment -> new ShapeDef(segment),
            structs.length
        );
    
        for (int i = 0; i < structs.length; i++) {
            array.set(i, structs[i]);
        }
    
        return array;
    }
    
    public static NativeStructArray<ShapeDef> array(MemorySegment array) {
        return new NativeStructArray<>(
            array,
            LAYOUT,
            segment -> new ShapeDef(segment)
        );
    }
    
}