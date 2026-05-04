package volucris.engine.physics.box2d.joint;

import java.lang.foreign.Arena;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.SegmentAllocator;
import java.lang.foreign.StructLayout;
import java.lang.foreign.MemoryLayout.PathElement;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;

import org.joml.Vector2f;

import volucris.engine.physics.box2d.body.Body;
import volucris.engine.physics.box2d.math.Vec2;
import volucris.engine.utils.VolucrisRuntimeException;

import static java.lang.foreign.ValueLayout.*;
import static volucris.engine.utils.FFMUtils.*;

/**
 * A motor joint is used to control the relative motion between two bodies.
 * <p>
 * A typical usage is to control the movement of a dynamic body with respect to
 * the ground.
 */
public final class MotorJointDef {

	private static final StructLayout LAYOUT;

	private static final VarHandle ANGULAR_OFFSET;
	private static final VarHandle MAX_FORCE;
	private static final VarHandle MAX_TORQUE;
	private static final VarHandle CORRECTION_FACTOR;
	private static final VarHandle COLLIDE_CONNECTED;

	private static final MethodHandle B2_DEFAULT_MOTOR_JOINT_DEF;

	private static final long BODY_ID_A_OFFSET;
	private static final long BODY_ID_B_OFFSET;
	private static final long LINEAR_OFFSET_OFFSET;

	private final MemorySegment b2MotorJointDef;

	private final Vec2 linearOffset;

	static {
		//@formatter:off
		LAYOUT = MemoryLayout.structLayout(
		        Body.LAYOUT().withName("bodyIdA"),
		        Body.LAYOUT().withName("bodyIdB"),
		        Vec2.LAYOUT().withName("linearOffset"),
		        JAVA_FLOAT.withName("angularOffset"),
		        JAVA_FLOAT.withName("maxForce"),
		        JAVA_FLOAT.withName("maxTorque"),
		        JAVA_FLOAT.withName("correctionFactor"),
		        JAVA_BOOLEAN.withName("collideConnected"),
		        MemoryLayout.paddingLayout(7),
		        ADDRESS.withName("userData"),
		        JAVA_INT.withName("internalValue"),
		        MemoryLayout.paddingLayout(4)
			).withName("b2MotorJointDef");
		//@formatter:on

		ANGULAR_OFFSET = varHandle(LAYOUT, "angularOffset");
		MAX_FORCE = varHandle(LAYOUT, "maxForce");
		MAX_TORQUE = varHandle(LAYOUT, "maxTorque");
		CORRECTION_FACTOR = varHandle(LAYOUT, "correctionFactor");
		COLLIDE_CONNECTED = varHandle(LAYOUT, "collideConnected");

		B2_DEFAULT_MOTOR_JOINT_DEF = downcallHandle("b2DefaultMotorJointDef", LAYOUT);

		BODY_ID_A_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("bodyIdA"));
		BODY_ID_B_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("bodyIdB"));
		LINEAR_OFFSET_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("linearOffset"));
	}

	public MotorJointDef() {
		try {
			SegmentAllocator allocator = Arena.ofAuto();
			b2MotorJointDef = (MemorySegment) B2_DEFAULT_MOTOR_JOINT_DEF.invokeExact(allocator);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot create motor joint def.");
		}

		linearOffset = new Vec2(b2MotorJointDef.asSlice(LINEAR_OFFSET_OFFSET, Vec2.LAYOUT()));
	}

	/**
	 * Position of bodyB minus the position of bodyA, in bodyA's frame.
	 */
	public void setLinearOffset(float x, float y) {
		linearOffset.set(x, y);
	}

	/**
	 * Position of bodyB minus the position of bodyA, in bodyA's frame.
	 */
	public void setLinearOffset(Vector2f linearOffset) {
		this.linearOffset.set(linearOffset);
	}

	/**
	 * The first attached body.
	 */
	public void setBodyA(Body body) {
		MemorySegment.copy(body.memorySegment(), 0L, b2MotorJointDef, BODY_ID_A_OFFSET, Body.LAYOUT().byteSize());
	}

	/**
	 * The second attached body.
	 */
	public void setBodyB(Body body) {
		MemorySegment.copy(body.memorySegment(), 0L, b2MotorJointDef, BODY_ID_B_OFFSET, Body.LAYOUT().byteSize());
	}

	/**
	 * The bodyB angle minus bodyA angle in radians.
	 */
	public void setAngularOffset(float angularOffset) {
		ANGULAR_OFFSET.set(b2MotorJointDef, angularOffset);
	}

	/**
	 * The maximum motor force in newtons.
	 */
	public void setMaxForce(float maxForce) {
		MAX_FORCE.set(b2MotorJointDef, maxForce);
	}

	/**
	 * The maximum motor torque in newton-meters.
	 */
	public void setMaxTorque(float maxTorque) {
		MAX_TORQUE.set(b2MotorJointDef, maxTorque);
	}

	/**
	 * Position correction factor in the range [0,1].
	 */
	public void setCorrectionFactor(float correctionFactor) {
		CORRECTION_FACTOR.set(b2MotorJointDef, correctionFactor);
	}

	/**
	 * Set this flag to true if the attached bodies should collide.
	 */
	public void collideConnected(boolean collideConnected) {
		COLLIDE_CONNECTED.set(b2MotorJointDef, collideConnected);
	}

	public MemorySegment memorySegment() {
		return b2MotorJointDef;
	}

	public static StructLayout LAYOUT() {
		return LAYOUT;
	}

}
