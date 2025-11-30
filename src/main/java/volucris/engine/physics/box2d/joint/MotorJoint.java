package volucris.engine.physics.box2d.joint;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.SegmentAllocator;
import java.lang.invoke.MethodHandle;

import org.joml.Vector2f;

import volucris.engine.physics.box2d.math.Vec2;
import volucris.engine.physics.box2d.world.World;
import volucris.engine.utils.MathUtils;
import volucris.engine.utils.VolucrisRuntimeException;

import static java.lang.foreign.ValueLayout.*;
import static volucris.engine.utils.FFMUtils.*;

public final class MotorJoint extends Joint {

	private static final MethodHandle B2_CREATE_MOTOR_JOINT;
	private static final MethodHandle B2_MOTOR_JOINT_SET_LINEAR_OFFSET;
	private static final MethodHandle B2_MOTOR_JOINT_GET_LINEAR_OFFSET;
	private static final MethodHandle B2_MOTOR_JOINT_SET_ANGULAR_OFFSET;
	private static final MethodHandle B2_MOTOR_JOINT_GET_ANGULAR_OFFSET;
	private static final MethodHandle B2_MOTOR_JOINT_SET_MAX_FORCE;
	private static final MethodHandle B2_MOTOR_JOINT_GET_MAX_FORCE;
	private static final MethodHandle B2_MOTOR_JOINT_SET_MAX_TORQUE;
	private static final MethodHandle B2_MOTOR_JOINT_GET_MAX_TORQUE;
	private static final MethodHandle B2_MOTOR_JOINT_SET_CORRECTION_FACTOR;
	private static final MethodHandle B2_MOTOR_JOINT_GET_CORRECTION_FACTOR;

	static {
		//@formatter:off
		B2_CREATE_MOTOR_JOINT = downcallHandle("b2CreateMotorJoint", JOINT_ID_LAYOUT, World.LAYOUT(), ADDRESS);
		B2_MOTOR_JOINT_SET_LINEAR_OFFSET = downcallHandleVoid("b2MotorJoint_SetLinearOffset", JOINT_ID_LAYOUT, Vec2.LAYOUT());
		B2_MOTOR_JOINT_GET_LINEAR_OFFSET = downcallHandle("b2MotorJoint_GetLinearOffset", Vec2.LAYOUT(), JOINT_ID_LAYOUT);
		B2_MOTOR_JOINT_SET_ANGULAR_OFFSET = downcallHandleVoid("b2MotorJoint_SetAngularOffset", JOINT_ID_LAYOUT, JAVA_FLOAT);
		B2_MOTOR_JOINT_GET_ANGULAR_OFFSET = downcallHandle("b2MotorJoint_GetAngularOffset", JAVA_FLOAT, JOINT_ID_LAYOUT);
		B2_MOTOR_JOINT_SET_MAX_FORCE = downcallHandleVoid("b2MotorJoint_SetMaxForce", JOINT_ID_LAYOUT, JAVA_FLOAT);
		B2_MOTOR_JOINT_GET_MAX_FORCE = downcallHandle("b2MotorJoint_GetMaxForce", JAVA_FLOAT, JOINT_ID_LAYOUT);
		B2_MOTOR_JOINT_SET_MAX_TORQUE = downcallHandleVoid("b2MotorJoint_SetMaxTorque", JOINT_ID_LAYOUT, JAVA_FLOAT);
		B2_MOTOR_JOINT_GET_MAX_TORQUE = downcallHandle("b2MotorJoint_GetMaxTorque", JAVA_FLOAT, JOINT_ID_LAYOUT);
		B2_MOTOR_JOINT_SET_CORRECTION_FACTOR = downcallHandleVoid("b2MotorJoint_SetCorrectionFactor", JOINT_ID_LAYOUT, JAVA_FLOAT);
		B2_MOTOR_JOINT_GET_CORRECTION_FACTOR = downcallHandle("b2MotorJoint_GetCorrectionFactor", JAVA_FLOAT, JOINT_ID_LAYOUT);
		//@formatter:on
	}

	/**
	 * Create the motor joint.
	 */
	public MotorJoint(World world, MotorJointDef motorJointDef) {
		MemorySegment b2MotorJoint;
		try {
			SegmentAllocator allocator = Arena.ofAuto();

			MemorySegment worldAddr = world.memorySegment();
			MemorySegment defAddr = motorJointDef.memorySegment();

			b2MotorJoint = (MemorySegment) B2_CREATE_MOTOR_JOINT.invokeExact(allocator, worldAddr, defAddr);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot create motor joint.");
		}
		super(b2MotorJoint, world);
	}

	/**
	 * Set the motor joint linear offset target.
	 */
	public void setLinearOffset(Vector2f linearOffset) {
		try {
			vecTmp.set(linearOffset);
			B2_MOTOR_JOINT_SET_LINEAR_OFFSET.invokeExact(b2JointId, vecTmp.memorySegment());
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot set linear offset.");
		}
	}

	/**
	 * Get the motor joint linear offset target.
	 */
	public Vector2f getLinearOffset(Vector2f target) {
		try (Arena arena = Arena.ofConfined()) {
			SegmentAllocator allocator = arena;
			MemorySegment segment = (MemorySegment) B2_MOTOR_JOINT_GET_LINEAR_OFFSET.invokeExact(allocator, b2JointId);
			vecTmp.set(segment);
			return vecTmp.get(target);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot get linear offset.");
		}
	}

	/**
	 * Get the motor joint linear offset target.
	 */
	public Vector2f getLinearOffset() {
		return getLinearOffset(new Vector2f());
	}

	/**
	 * Set the motor joint angular offset target in radians.
	 */
	public void setAngularOffsetRadians(float angularOffset) {
		try {
			B2_MOTOR_JOINT_SET_ANGULAR_OFFSET.invokeExact(b2JointId, angularOffset);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot set angular offset.");
		}
	}

	/**
	 * Set the motor joint angular offset target in degrees.
	 */
	public void setAngularOffset(float angularOffset) {
		setAngularOffsetRadians(MathUtils.toRadians(angularOffset));
	}

	/**
	 * Get the motor joint angular offset target in radians.
	 */
	public float getAngularOffsetRadians() {
		try {
			return (float) B2_MOTOR_JOINT_GET_ANGULAR_OFFSET.invoke(b2JointId);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot get angular offset.");
		}
	}

	/**
	 * Get the motor joint angular offset target in degrees.
	 */
	public float getAngularOffset() {
		return MathUtils.toDegrees(getAngularOffsetRadians());
	}

	/**
	 * Set the motor joint maximum force, usually in newtons.
	 */
	public void setMaxForce(float maxForce) {
		try {
			B2_MOTOR_JOINT_SET_MAX_FORCE.invokeExact(b2JointId, maxForce);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot set max force.");
		}
	}

	/**
	 * Get the motor joint maximum force, usually in newtons.
	 */
	public float getMaxForce() {
		try {
			return (float) B2_MOTOR_JOINT_GET_MAX_FORCE.invokeExact(b2JointId);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot get max force.");
		}
	}

	/**
	 * Set the motor joint maximum torque, usually in newton-meters.
	 */
	public void setMaxTorque(float maxTorque) {
		try {
			B2_MOTOR_JOINT_SET_MAX_TORQUE.invokeExact(b2JointId, maxTorque);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot set max torque.");
		}
	}

	/**
	 * Get the motor joint maximum torque, usually in newton-meters.
	 */
	public float getMaxTorque() {
		try {
			return (float) B2_MOTOR_JOINT_GET_MAX_TORQUE.invokeExact(b2JointId);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot get max torque.");
		}
	}

	/**
	 * Set the motor joint correction factor, usually in [0, 1].
	 */
	public void setCorrectionFactor(float correctionFactor) {
		try {
			B2_MOTOR_JOINT_SET_CORRECTION_FACTOR.invokeExact(b2JointId, correctionFactor);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot set correction factor.");
		}
	}

	/**
	 * Get the motor joint correction factor, usually in [0, 1].
	 */
	public float getCorrectionFactor() {
		try {
			return (float) B2_MOTOR_JOINT_GET_CORRECTION_FACTOR.invokeExact(b2JointId);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot get correction factor.");
		}
	}

}
