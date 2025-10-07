package volucris.engine.physics.box2d.geometry;

import java.lang.foreign.Arena;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.StructLayout;
import java.lang.invoke.VarHandle;

import org.joml.Vector2f;

import volucris.engine.physics.box2d.math.Vec2;

import static java.lang.foreign.ValueLayout.*;
import static volucris.engine.utils.FFMUtils.*;

/**
 * This holds the mass data computed for a shape.
 */
public final class MassData {

	private static final StructLayout LAYOUT;

	private static final VarHandle MASS;
	private static final VarHandle ROTATIONAL_INERTIA;

	private static final long CENTER_OFFSET;

	private final MemorySegment b2MassData;

	private final Vec2 center;

	static {
		//@formatter:off
		LAYOUT = MemoryLayout.structLayout(
				JAVA_FLOAT.withName("mass"),
				Vec2.LAYOUT().withName("center"),
				JAVA_FLOAT.withName("rotationalInertia")
			).withName("b2MassData");
		//@formatter:on

		MASS = varHandle(LAYOUT, "mass");
		ROTATIONAL_INERTIA = varHandle(LAYOUT, "rotationalInertia");

		CENTER_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("center"));
	}

	public MassData() {
		b2MassData = Arena.ofAuto().allocate(LAYOUT);

		center = new Vec2(b2MassData.asSlice(CENTER_OFFSET, Vec2.LAYOUT()));
	}

	public MassData(MemorySegment memorySegment) {
		b2MassData = memorySegment;

		center = new Vec2(b2MassData.asSlice(CENTER_OFFSET, Vec2.LAYOUT()));
	}

	public void set(MemorySegment memorySegment) {
		float mass = (float) MASS.get(memorySegment);
		float rotationalInertia = (float) ROTATIONAL_INERTIA.get(memorySegment);

		setMass(mass);
		setRotationalInertia(rotationalInertia);

		center.set(memorySegment.asSlice(CENTER_OFFSET, Vec2.LAYOUT()));
	}

	/**
	 * The mass of the shape, usually in kilograms.
	 */
	public void setMass(float mass) {
		MASS.set(b2MassData, mass);
	}

	/**
	 * The mass of the shape, usually in kilograms.
	 */
	public float getMass() {
		return (float) MASS.get(b2MassData);
	}

	/**
	 * The rotational inertia of the shape about the local origin.
	 */
	public void setRotationalInertia(float rotationalInertia) {
		ROTATIONAL_INERTIA.set(b2MassData, rotationalInertia);
	}

	/**
	 * The rotational inertia of the shape about the local origin.
	 */
	public float getRotationalInertia() {
		return (float) ROTATIONAL_INERTIA.get(b2MassData);
	}

	/**
	 * The position of the shape's centroid relative to the shape's origin.
	 */
	public void setCenter(float x, float y) {
		this.center.set(x, y);
	}

	/**
	 * The position of the shape's centroid relative to the shape's origin.
	 */
	public void setCenter(Vector2f center) {
		this.center.set(center);
	}

	/**
	 * The position of the shape's centroid relative to the shape's origin.
	 */
	public Vector2f getCenter(Vector2f target) {
		return center.get(target);
	}

	/**
	 * The position of the shape's centroid relative to the shape's origin.
	 */
	public Vector2f getCenter() {
		return getCenter(new Vector2f());
	}

	public MemorySegment memorySegment() {
		return b2MassData.asReadOnly();
	}

	public static StructLayout LAYOUT() {
		return LAYOUT;
	}

}
