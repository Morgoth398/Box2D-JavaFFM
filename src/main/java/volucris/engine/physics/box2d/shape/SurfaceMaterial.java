package volucris.engine.physics.box2d.shape;

import java.lang.foreign.Arena;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.SegmentAllocator;
import java.lang.foreign.StructLayout;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;

import volucris.engine.physics.box2d.HexColor;
import volucris.engine.physics.box2d.utils.Box2DRuntimeException;

import static java.lang.foreign.ValueLayout.*;
import static volucris.engine.physics.box2d.utils.FFMUtils.*;

/**
 * Surface materials allow chain shapes to have per segment surface properties.
 */
public final class SurfaceMaterial {

	private static final StructLayout LAYOUT;

	private static final VarHandle FRICTION;
	private static final VarHandle RESTITUTION;
	private static final VarHandle ROLLING_RESISTANCE;
	private static final VarHandle TANGENT_SPEED;
	private static final VarHandle USER_MATERIAL_ID;
	private static final VarHandle CUSTOM_COLOR;

	private static final MethodHandle B2_DEFAULT_SURFACE_MATERIAL;

	private final MemorySegment b2SurfaceMaterial;

	static {
		//@formatter:off
		LAYOUT = MemoryLayout.structLayout(
				JAVA_FLOAT.withName("friction"),
				JAVA_FLOAT.withName("restitution"),
				JAVA_FLOAT.withName("rollingResistance"),
				JAVA_FLOAT.withName("tangentSpeed"),
				JAVA_INT.withName("userMaterialId"),
				JAVA_INT.withName("customColor")
			).withName("b2SurfaceMaterial");
		//@formatter:on

		FRICTION = varHandle(LAYOUT, "friction");
		RESTITUTION = varHandle(LAYOUT, "restitution");
		ROLLING_RESISTANCE = varHandle(LAYOUT, "rollingResistance");
		TANGENT_SPEED = varHandle(LAYOUT, "tangentSpeed");
		USER_MATERIAL_ID = varHandle(LAYOUT, "userMaterialId");
		CUSTOM_COLOR = varHandle(LAYOUT, "customColor");

		B2_DEFAULT_SURFACE_MATERIAL = downcallHandle("b2DefaultSurfaceMaterial", LAYOUT);
	}

	public SurfaceMaterial() {
		try {
			SegmentAllocator allocator = Arena.ofAuto();
			b2SurfaceMaterial = (MemorySegment) B2_DEFAULT_SURFACE_MATERIAL.invokeExact(allocator);
		} catch (Throwable e) {
			String className = e.getClass().getSimpleName();
			throw new Box2DRuntimeException("Cannot create surface material: " + className);
		}
	}

	public SurfaceMaterial(MemorySegment memorySegment) {
		b2SurfaceMaterial = memorySegment;
	}

	public void set(MemorySegment memorySegment) {
		MemorySegment.copy(memorySegment, 0, b2SurfaceMaterial, 0, LAYOUT.byteSize());
	}

	/**
	 * The Coulomb (dry) friction coefficient, usually in the range [0,1].
	 */
	public float getFriction() {
		return (float) FRICTION.get(b2SurfaceMaterial);
	}

	/**
	 * The Coulomb (dry) friction coefficient, usually in the range [0,1].
	 */
	public void setFriction(float friction) {
		FRICTION.set(b2SurfaceMaterial, friction);
	}

	/**
	 * The coefficient of restitution (bounce) usually in the range [0,1].
	 * <p>
	 * https://en.wikipedia.org/wiki/Coefficient_of_restitution
	 */
	public float getRestitution() {
		return (float) RESTITUTION.get(b2SurfaceMaterial);
	}

	/**
	 * The coefficient of restitution (bounce) usually in the range [0,1].
	 * <p>
	 * https://en.wikipedia.org/wiki/Coefficient_of_restitution
	 */
	public void setRestitution(float restitution) {
		RESTITUTION.set(b2SurfaceMaterial, restitution);
	}

	/**
	 * The rolling resistance usually in the range [0,1].
	 */
	public float getRollingResitance() {
		return (float) ROLLING_RESISTANCE.get(b2SurfaceMaterial);
	}

	/**
	 * The rolling resistance usually in the range [0,1].
	 */
	public void setRollingResistance(float rollingResistance) {
		ROLLING_RESISTANCE.set(b2SurfaceMaterial, rollingResistance);
	}

	/**
	 * The tangent speed for conveyor belts.
	 */
	public float getTangentSpeed() {
		return (float) TANGENT_SPEED.get(b2SurfaceMaterial);
	}

	/**
	 * The tangent speed for conveyor belts.
	 */
	public void setTangentSpeed(float tangentSpeed) {
		TANGENT_SPEED.set(b2SurfaceMaterial, tangentSpeed);
	}

	/**
	 * User material identifier.
	 * <p>
	 * This is passed with query results and to friction and restitution combining
	 * functions. It is not used internally.
	 */
	public void setUserMaterialId(int userMaterialId) {
		USER_MATERIAL_ID.set(b2SurfaceMaterial, userMaterialId);
	}

	/**
	 * User material identifier.
	 * <p>
	 * This is passed with query results and to friction and restitution combining
	 * functions. It is not used internally.
	 */
	public int getUserMaterialId() {
		return (int) USER_MATERIAL_ID.get(b2SurfaceMaterial);
	}

	/**
	 * Custom debug draw color.
	 */
	public void setCustomColor(HexColor color) {
		CUSTOM_COLOR.set(b2SurfaceMaterial, color.getHexColor());
	}

	/**
	 * Custom debug draw color.
	 */
	public int getCustomColor() {
		return (int) CUSTOM_COLOR.get(b2SurfaceMaterial);
	}

	public MemorySegment memorySegment() {
		return b2SurfaceMaterial;
	}

	public static StructLayout LAYOUT() {
		return LAYOUT;
	}
}
