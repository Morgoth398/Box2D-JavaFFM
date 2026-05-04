package volucris.engine.physics.box2d.shape;

import java.lang.foreign.Arena;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.SegmentAllocator;
import java.lang.foreign.StructLayout;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;

import volucris.engine.utils.VolucrisRuntimeException;

import static java.lang.foreign.ValueLayout.*;
import static volucris.engine.utils.FFMUtils.*;

/**
 * Used to create a shape.
 * <p>
 * This is a temporary object used to bundle shape creation parameters. You may
 * use the same shape definition to create multiple shapes.
 */
public final class ShapeDef {

	private static final StructLayout LAYOUT;

	private static final VarHandle DENSITY;
	private static final VarHandle IS_SENSOR;
	private static final VarHandle ENABLE_SENSOR_EVENTS;
	private static final VarHandle ENABLE_CONTACT_EVENTS;
	private static final VarHandle ENABLE_HIT_EVENTS;
	private static final VarHandle ENABLE_PRE_SOLVE_EVENTS;
	private static final VarHandle INVOKE_CONTACT_CREATION;
	private static final VarHandle UPDATE_BODY_MASS;

	private static final MethodHandle B2_DEFAULT_SHAPE_DEF;

	private static final long SURFACE_MATERIAL_OFFSET;
	private static final long FILTER_OFFSET;

	private final MemorySegment b2ShapeDef;

	private final SurfaceMaterial surfaceMaterial;
	private final Filter filter;

	static {
		//@formatter:off
		LAYOUT = MemoryLayout.structLayout(
		        ADDRESS.withName("userData"),
		        SurfaceMaterial.LAYOUT().withName("material"),
		        JAVA_FLOAT.withName("density"),
		        MemoryLayout.paddingLayout(4),
		        Filter.LAYOUT().withName("filter"),
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
			).withName("b2ShapeDef");
		//@formatter:on

		DENSITY = varHandle(LAYOUT, "density");
		IS_SENSOR = varHandle(LAYOUT, "isSensor");
		ENABLE_SENSOR_EVENTS = varHandle(LAYOUT, "enableSensorEvents");
		ENABLE_CONTACT_EVENTS = varHandle(LAYOUT, "enableContactEvents");
		ENABLE_HIT_EVENTS = varHandle(LAYOUT, "enableHitEvents");
		ENABLE_PRE_SOLVE_EVENTS = varHandle(LAYOUT, "enablePreSolveEvents");
		INVOKE_CONTACT_CREATION = varHandle(LAYOUT, "invokeContactCreation");
		UPDATE_BODY_MASS = varHandle(LAYOUT, "updateBodyMass");

		B2_DEFAULT_SHAPE_DEF = downcallHandle("b2DefaultShapeDef", LAYOUT);

		SURFACE_MATERIAL_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("material"));
		FILTER_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("filter"));
	}

	public ShapeDef() {
		try {
			SegmentAllocator allocator = Arena.ofAuto();
			b2ShapeDef = (MemorySegment) B2_DEFAULT_SHAPE_DEF.invokeExact(allocator);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot create shape def.");
		}

		surfaceMaterial = new SurfaceMaterial(b2ShapeDef.asSlice(SURFACE_MATERIAL_OFFSET, SurfaceMaterial.LAYOUT()));
		filter = new Filter(b2ShapeDef.asSlice(FILTER_OFFSET, Filter.LAYOUT()));
	}

	/**
	 * The surface material for this shape.
	 */
	public SurfaceMaterial getSurfaceMaterial() {
		return surfaceMaterial;
	}

	/**
	 * Collision filtering data.
	 */
	public Filter getFilter() {
		return filter;
	}

	/**
	 * The density, usually in kg/m^2.
	 * <p>
	 * This is not part of the surface material because this is for the interior,
	 * which may have other considerations, such as being hollow. For example a wood
	 * barrel may be hollow or full of water.
	 */
	public void setDensity(float density) {
		DENSITY.set(b2ShapeDef, density);
	}

	/**
	 * A sensor shape generates overlap events but never generates a collision
	 * response.
	 * <p>
	 * Sensors do not have continuous collision. Instead, use a ray or shape cast
	 * for those scenarios. Sensors still contribute to the body mass if they have
	 * non-zero density.
	 * <p>
	 * Note: Sensor events are disabled by default.
	 */
	public void isSensor(boolean isSensor) {
		IS_SENSOR.set(b2ShapeDef, isSensor);
	}

	/**
	 * Enable sensor events for this shape. This applies to sensors and non-sensors.
	 * False by default, even for sensors.
	 */
	public void enableSensorEvents(boolean enableSensorEvents) {
		ENABLE_SENSOR_EVENTS.set(b2ShapeDef, enableSensorEvents);
	}

	/**
	 * Enable contact events for this shape. Only applies to kinematic and dynamic
	 * bodies. Ignored for sensors. False by default.
	 */
	public void enableContactEvents(boolean enableContactEvents) {
		ENABLE_CONTACT_EVENTS.set(b2ShapeDef, enableContactEvents);
	}

	/**
	 * Enable hit events for this shape. Only applies to kinematic and dynamic
	 * bodies. Ignored for sensors. False by default.
	 */
	public void enableHitEvents(boolean enableHitEvents) {
		ENABLE_HIT_EVENTS.set(b2ShapeDef, enableHitEvents);
	}

	/**
	 * Enable pre-solve contact events for this shape.
	 * <p>
	 * Only applies to dynamic bodies. These are expensive and must be carefully
	 * handled due to threading. Ignored for sensors.
	 */
	public void enablePreSolveEvents(boolean enablePreSolveEvents) {
		ENABLE_PRE_SOLVE_EVENTS.set(b2ShapeDef, enablePreSolveEvents);
	}

	/**
	 * When shapes are created they will scan the environment for collision the next
	 * time step.
	 * <p>
	 * This can significantly slow down static body creation when there are many
	 * static shapes. This is flag is ignored for dynamic and kinematic shapes which
	 * always invoke contact creation.
	 */
	public void invokeContactCreation(boolean invokeContactCreation) {
		INVOKE_CONTACT_CREATION.set(b2ShapeDef, invokeContactCreation);
	}

	/**
	 * Should the body update the mass properties when this shape is created.
	 * Default is true.
	 */
	public void updateBodyMass(boolean updateBodyMass) {
		UPDATE_BODY_MASS.set(b2ShapeDef, updateBodyMass);
	}

	public MemorySegment memorySegment() {
		return b2ShapeDef;
	}

	public static StructLayout LAYOUT() {
		return LAYOUT;
	}

}
