package volucris.engine.physics.box2d.joint;

import java.lang.foreign.Arena;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.SegmentAllocator;
import java.lang.foreign.StructLayout;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;

import org.joml.Vector2f;

import volucris.engine.physics.box2d.body.Body;
import volucris.engine.physics.box2d.math.Vec2;
import volucris.engine.utils.MathUtils;
import volucris.engine.utils.VolucrisRuntimeException;

import java.lang.foreign.MemoryLayout.PathElement;

import static java.lang.foreign.ValueLayout.*;
import static volucris.engine.utils.FFMUtils.*;

/**
 * Weld joint definition.
 * <p>
 * A weld joint connect to bodies together rigidly. This constraint provides
 * springs to mimic soft-body simulation.
 */
public final class WeldJointDef {

	private static final StructLayout LAYOUT;

	private static final MethodHandle B2_DEFAULT_WELD_JOINT_DEF;

	private static final VarHandle REFERENCE_ANGLE;
	private static final VarHandle LINEAR_HERTZ;
	private static final VarHandle ANGULAR_HERTZ;
	private static final VarHandle LINEAR_DAMPING_RATIO;
	private static final VarHandle ANGULAR_DAMPING_RATIO;
	private static final VarHandle COLLIDE_CONNECTED;

	private static final long BODY_ID_A_OFFSET;
	private static final long BODY_ID_B_OFFSET;
	private static final long LOCAL_ANCHOR_A_OFFSET;
	private static final long LOCAL_ANCHOR_B_OFFSET;

	private final MemorySegment b2WeldJointDef;

	private final Vec2 localAnchorA;
	private final Vec2 localAnchorB;

	static {
		//@formatter:off
		LAYOUT = MemoryLayout.structLayout(
		        Body.LAYOUT().withName("bodyIdA"),
		        Body.LAYOUT().withName("bodyIdB"),
		        Vec2.LAYOUT().withName("localAnchorA"),
		        Vec2.LAYOUT().withName("localAnchorB"),
		        JAVA_FLOAT.withName("referenceAngle"),
		        JAVA_FLOAT.withName("linearHertz"),
		        JAVA_FLOAT.withName("angularHertz"),
		        JAVA_FLOAT.withName("linearDampingRatio"),
		        JAVA_FLOAT.withName("angularDampingRatio"),
		        JAVA_BOOLEAN.withName("collideConnected"),
		        MemoryLayout.paddingLayout(3),
		        ADDRESS.withName("userData"),
		        JAVA_INT.withName("internalValue"),
		        MemoryLayout.paddingLayout(4)
			).withName("b2WeldJointDef");
		//@formatter:on

		REFERENCE_ANGLE = varHandle(LAYOUT, "referenceAngle");
		LINEAR_HERTZ = varHandle(LAYOUT, "linearHertz");
		ANGULAR_HERTZ = varHandle(LAYOUT, "angularHertz");
		LINEAR_DAMPING_RATIO = varHandle(LAYOUT, "linearDampingRatio");
		ANGULAR_DAMPING_RATIO = varHandle(LAYOUT, "angularDampingRatio");
		COLLIDE_CONNECTED = varHandle(LAYOUT, "collideConnected");

		B2_DEFAULT_WELD_JOINT_DEF = downcallHandle("b2DefaultWeldJointDef", LAYOUT);

		BODY_ID_A_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("bodyIdA"));
		BODY_ID_B_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("bodyIdB"));
		LOCAL_ANCHOR_A_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("localAnchorA"));
		LOCAL_ANCHOR_B_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("localAnchorB"));
	}

	public WeldJointDef() {
		try {
			SegmentAllocator allocator = Arena.ofAuto();
			b2WeldJointDef = (MemorySegment) B2_DEFAULT_WELD_JOINT_DEF.invokeExact(allocator);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot create distance joint def.");
		}

		localAnchorA = new Vec2(b2WeldJointDef.asSlice(LOCAL_ANCHOR_A_OFFSET, Vec2.LAYOUT()));
		localAnchorB = new Vec2(b2WeldJointDef.asSlice(LOCAL_ANCHOR_B_OFFSET, Vec2.LAYOUT()));
	}

	/**
	 * The local anchor point relative to bodyA's origin.
	 */
	public void setLocalAnchorA(float x, float y) {
		localAnchorA.set(x, y);
	}

	/**
	 * The local anchor point relative to bodyA's origin.
	 */
	public void setLocalAnchorA(Vector2f localAnchor) {
		localAnchorA.set(localAnchor);
	}

	/**
	 * The local anchor point relative to bodyB's origin.
	 */
	public void setLocalAnchorB(float x, float y) {
		localAnchorB.set(x, y);
	}

	/**
	 * The local anchor point relative to bodyB's origin.
	 */
	public void setLocalAnchorB(Vector2f localAnchor) {
		localAnchorB.set(localAnchor);
	}

	/**
	 * The first attached body.
	 */
	public void setBodyA(Body body) {
		MemorySegment.copy(body.memorySegment(), 0L, b2WeldJointDef, BODY_ID_A_OFFSET, Body.LAYOUT().byteSize());
	}

	/**
	 * The second attached body.
	 */
	public void setBodyB(Body body) {
		MemorySegment.copy(body.memorySegment(), 0L, b2WeldJointDef, BODY_ID_B_OFFSET, Body.LAYOUT().byteSize());
	}

	/**
	 * The bodyB angle minus bodyA angle in the reference state (radians).
	 */
	public void setReferenceAngleRadians(float angle) {
		REFERENCE_ANGLE.set(b2WeldJointDef, angle);
	}

	/**
	 * The bodyB angle minus bodyA angle in the reference state (degrees).
	 */
	public void setReferenceAngle(float angle) {
		REFERENCE_ANGLE.set(b2WeldJointDef, MathUtils.toRadians(angle));
	}

	/**
	 * Linear stiffness expressed as Hertz (cycles per second). Use zero for maximum
	 * stiffness.
	 */
	public void setLinearHertz(float linearHertz) {
		LINEAR_HERTZ.set(b2WeldJointDef, linearHertz);
	}

	/**
	 * Angular stiffness as Hertz (cycles per second). Use zero for maximum
	 * stiffness.
	 */
	public void setAngularHertz(float angularHertz) {
		ANGULAR_HERTZ.set(b2WeldJointDef, angularHertz);
	}

	/**
	 * Linear damping ratio, non-dimensional. Use 1 for critical damping.
	 */
	public void setLinearDampingRatio(float linearDampingRatio) {
		LINEAR_DAMPING_RATIO.set(b2WeldJointDef, linearDampingRatio);
	}

	/**
	 * Angular damping ratio, non-dimensional. Use 1 for critical damping.
	 */
	public void setAngularDampingRatio(float angularDampingRatio) {
		ANGULAR_DAMPING_RATIO.set(b2WeldJointDef, angularDampingRatio);
	}

	/**
	 * Set this flag to true if the attached bodies should collide.
	 */
	public void collideConnected(boolean collideConnected) {
		COLLIDE_CONNECTED.set(b2WeldJointDef, collideConnected);
	}

	public MemorySegment memorySegment() {
		return b2WeldJointDef;
	}

	public static StructLayout LAYOUT() {
		return LAYOUT;
	}

}
