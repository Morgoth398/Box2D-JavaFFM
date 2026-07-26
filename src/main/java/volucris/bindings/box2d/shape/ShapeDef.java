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

/// ```
/// Used to create a shape.
/// This is a temporary object used to bundle shape creation parameters. You may use
/// the same shape definition to create multiple shapes.
/// Must be initialized using b2DefaultShapeDef().
/// @ingroup shape
/// ```
public final class ShapeDef
		implements Struct<ShapeDef> {

    private static final LazyConstant<MethodHandle> B2_DEFAULT_SHAPE_DEF;

    public static final StructLayout LAYOUT;

    public static final VarHandle USER_DATA_HANDLE;
    public static final VarHandle DENSITY_HANDLE;
    public static final VarHandle IS_SENSOR_HANDLE;
    public static final VarHandle ENABLE_SENSOR_EVENTS_HANDLE;
    public static final VarHandle ENABLE_CONTACT_EVENTS_HANDLE;
    public static final VarHandle ENABLE_HIT_EVENTS_HANDLE;
    public static final VarHandle ENABLE_PRE_SOLVE_EVENTS_HANDLE;
    public static final VarHandle INVOKE_CONTACT_CREATION_HANDLE;
    public static final VarHandle UPDATE_BODY_MASS_HANDLE;
    public static final VarHandle INTERNAL_VALUE_HANDLE;

    public static final long USER_DATA_BYTE_OFFSET;
    public static final long MATERIAL_BYTE_OFFSET;
    public static final long DENSITY_BYTE_OFFSET;
    public static final long FILTER_BYTE_OFFSET;
    public static final long IS_SENSOR_BYTE_OFFSET;
    public static final long ENABLE_SENSOR_EVENTS_BYTE_OFFSET;
    public static final long ENABLE_CONTACT_EVENTS_BYTE_OFFSET;
    public static final long ENABLE_HIT_EVENTS_BYTE_OFFSET;
    public static final long ENABLE_PRE_SOLVE_EVENTS_BYTE_OFFSET;
    public static final long INVOKE_CONTACT_CREATION_BYTE_OFFSET;
    public static final long UPDATE_BODY_MASS_BYTE_OFFSET;
    public static final long INTERNAL_VALUE_BYTE_OFFSET;

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
        
        USER_DATA_HANDLE = LAYOUT.varHandle(PathElement.groupElement("userData"));
        DENSITY_HANDLE = LAYOUT.varHandle(PathElement.groupElement("density"));
        IS_SENSOR_HANDLE = LAYOUT.varHandle(PathElement.groupElement("isSensor"));
        ENABLE_SENSOR_EVENTS_HANDLE = LAYOUT.varHandle(PathElement.groupElement("enableSensorEvents"));
        ENABLE_CONTACT_EVENTS_HANDLE = LAYOUT.varHandle(PathElement.groupElement("enableContactEvents"));
        ENABLE_HIT_EVENTS_HANDLE = LAYOUT.varHandle(PathElement.groupElement("enableHitEvents"));
        ENABLE_PRE_SOLVE_EVENTS_HANDLE = LAYOUT.varHandle(PathElement.groupElement("enablePreSolveEvents"));
        INVOKE_CONTACT_CREATION_HANDLE = LAYOUT.varHandle(PathElement.groupElement("invokeContactCreation"));
        UPDATE_BODY_MASS_HANDLE = LAYOUT.varHandle(PathElement.groupElement("updateBodyMass"));
        INTERNAL_VALUE_HANDLE = LAYOUT.varHandle(PathElement.groupElement("internalValue"));
        
        USER_DATA_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("userData"));
        MATERIAL_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("material"));
        DENSITY_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("density"));
        FILTER_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("filter"));
        IS_SENSOR_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("isSensor"));
        ENABLE_SENSOR_EVENTS_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("enableSensorEvents"));
        ENABLE_CONTACT_EVENTS_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("enableContactEvents"));
        ENABLE_HIT_EVENTS_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("enableHitEvents"));
        ENABLE_PRE_SOLVE_EVENTS_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("enablePreSolveEvents"));
        INVOKE_CONTACT_CREATION_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("invokeContactCreation"));
        UPDATE_BODY_MASS_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("updateBodyMass"));
        INTERNAL_VALUE_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("internalValue"));
        //@formatter:on
    }

    public ShapeDef(MemorySegment segment) {
        this.segment = segment;
    
        material = new SurfaceMaterial(segment.asSlice(MATERIAL_BYTE_OFFSET, SurfaceMaterial.LAYOUT));
        filter = new Filter(segment.asSlice(FILTER_BYTE_OFFSET, Filter.LAYOUT));
    }

    /// ```
    /// Use this to initialize your shape definition
    /// @ingroup shape
    /// ```
    public static MemorySegment ndefaultShapeDef(
    	SegmentAllocator allocator
    ) {
    	MethodHandle method = B2_DEFAULT_SHAPE_DEF.get();
    	try {
    		return (MemorySegment)  method.invokeExact(
    			allocator
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#ndefaultShapeDef].
    public static @Nullable ShapeDef defaultShapeDef(
    	SegmentAllocator allocator
    ) {
    	MemorySegment segment = ndefaultShapeDef(
    		allocator
    	);
    
    	if (segment.equals(MemorySegment.NULL))
    		return null;
    	
    	return new ShapeDef(segment);
    }
    
    /// @see #userData()
    public ShapeDef userData(MemorySegment userData) {
    	USER_DATA_HANDLE.set(segment, 0L, userData);
    	return this;
    }
    
    /// ```
    /// Use this to store application specific shape data.
    /// ```
    public @Nullable MemorySegment userData() {
    	MemorySegment segment = (MemorySegment) USER_DATA_HANDLE.get(this.segment, 0L);
    
    	if (segment.equals(MemorySegment.NULL))
    		return null;
    	
    	return segment;
    }
    
    /// @see #density()
    public ShapeDef density(float density) {
    	DENSITY_HANDLE.set(segment, 0L, density);
    	return this;
    }
    
    /// ```
    /// The density, usually in kg/m^2.
    /// This is not part of the surface material because this is for the interior, which may have
    /// other considerations, such as being hollow. For example a wood barrel may be hollow or full of water.
    /// ```
    public float density() {
    	return (float) DENSITY_HANDLE.get(segment, 0L);
    }
    
    /// @see #isSensor()
    public ShapeDef isSensor(boolean isSensor) {
    	IS_SENSOR_HANDLE.set(segment, 0L, isSensor);
    	return this;
    }
    
    /// ```
    /// A sensor shape generates overlap events but never generates a collision response.
    /// Sensors do not have continuous collision. Instead, use a ray or shape cast for those scenarios.
    /// Sensors still contribute to the body mass if they have non-zero density.
    /// @note Sensor events are disabled by default.
    /// @see enableSensorEvents
    /// ```
    public boolean isSensor() {
    	return (boolean) IS_SENSOR_HANDLE.get(segment, 0L);
    }
    
    /// @see #enableSensorEvents()
    public ShapeDef enableSensorEvents(boolean enableSensorEvents) {
    	ENABLE_SENSOR_EVENTS_HANDLE.set(segment, 0L, enableSensorEvents);
    	return this;
    }
    
    /// ```
    /// Enable sensor events for this shape. This applies to sensors and non-sensors. False by default, even for sensors.
    /// ```
    public boolean enableSensorEvents() {
    	return (boolean) ENABLE_SENSOR_EVENTS_HANDLE.get(segment, 0L);
    }
    
    /// @see #enableContactEvents()
    public ShapeDef enableContactEvents(boolean enableContactEvents) {
    	ENABLE_CONTACT_EVENTS_HANDLE.set(segment, 0L, enableContactEvents);
    	return this;
    }
    
    /// ```
    /// Enable contact events for this shape. Only applies to kinematic and dynamic bodies. Ignored for sensors. False by default.
    /// ```
    public boolean enableContactEvents() {
    	return (boolean) ENABLE_CONTACT_EVENTS_HANDLE.get(segment, 0L);
    }
    
    /// @see #enableHitEvents()
    public ShapeDef enableHitEvents(boolean enableHitEvents) {
    	ENABLE_HIT_EVENTS_HANDLE.set(segment, 0L, enableHitEvents);
    	return this;
    }
    
    /// ```
    /// Enable hit events for this shape. Only applies to kinematic and dynamic bodies. Ignored for sensors. False by default.
    /// ```
    public boolean enableHitEvents() {
    	return (boolean) ENABLE_HIT_EVENTS_HANDLE.get(segment, 0L);
    }
    
    /// @see #enablePreSolveEvents()
    public ShapeDef enablePreSolveEvents(boolean enablePreSolveEvents) {
    	ENABLE_PRE_SOLVE_EVENTS_HANDLE.set(segment, 0L, enablePreSolveEvents);
    	return this;
    }
    
    /// ```
    /// Enable pre-solve contact events for this shape. Only applies to dynamic bodies. These are expensive
    /// and must be carefully handled due to threading. Ignored for sensors.
    /// ```
    public boolean enablePreSolveEvents() {
    	return (boolean) ENABLE_PRE_SOLVE_EVENTS_HANDLE.get(segment, 0L);
    }
    
    /// @see #invokeContactCreation()
    public ShapeDef invokeContactCreation(boolean invokeContactCreation) {
    	INVOKE_CONTACT_CREATION_HANDLE.set(segment, 0L, invokeContactCreation);
    	return this;
    }
    
    /// ```
    /// When shapes are created they will scan the environment for collision the next time step. This can significantly slow down
    /// static body creation when there are many static shapes.
    /// This is flag is ignored for dynamic and kinematic shapes which always invoke contact creation.
    /// ```
    public boolean invokeContactCreation() {
    	return (boolean) INVOKE_CONTACT_CREATION_HANDLE.get(segment, 0L);
    }
    
    /// @see #updateBodyMass()
    public ShapeDef updateBodyMass(boolean updateBodyMass) {
    	UPDATE_BODY_MASS_HANDLE.set(segment, 0L, updateBodyMass);
    	return this;
    }
    
    /// ```
    /// Should the body update the mass properties when this shape is created. Default is true.
    /// ```
    public boolean updateBodyMass() {
    	return (boolean) UPDATE_BODY_MASS_HANDLE.get(segment, 0L);
    }
    
    /// @see #internalValue()
    public ShapeDef internalValue(int internalValue) {
    	INTERNAL_VALUE_HANDLE.set(segment, 0L, internalValue);
    	return this;
    }
    
    /// ```
    /// Used internally to detect a valid definition. DO NOT SET.
    /// ```
    public int internalValue() {
    	return (int) INTERNAL_VALUE_HANDLE.get(segment, 0L);
    }
    
    /// @see #material()
    public ShapeDef material(Consumer<SurfaceMaterial> consumer) {
    	consumer.accept(material);
    	return this;
    }
    
    /// @see #material()
    public ShapeDef material(SurfaceMaterial other) {
    	material.set(other);
    	return this;
    }
    
    /// ```
    /// The surface material for this shape.
    /// ```
    public SurfaceMaterial material() {
    	return material;
    }
    
    /// @see #filter()
    public ShapeDef filter(Consumer<Filter> consumer) {
    	consumer.accept(filter);
    	return this;
    }
    
    /// @see #filter()
    public ShapeDef filter(Filter other) {
    	filter.set(other);
    	return this;
    }
    
    /// ```
    /// Collision filtering data.
    /// ```
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