package volucris.engine.physics.box2d.joint;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.SegmentAllocator;
import java.lang.invoke.MethodHandle;

import volucris.engine.physics.box2d.world.World;
import volucris.engine.utils.MathUtils;
import volucris.engine.utils.VolucrisRuntimeException;

import static java.lang.foreign.ValueLayout.*;
import static volucris.engine.utils.FFMUtils.*;

public final class RevoluteJoint extends Joint {

	private static final MethodHandle B2_CREATE_REVOLUTE_JOINT;
	private static final MethodHandle B2_REVOLUTE_JOINT_ENABLE_SPRING;
	private static final MethodHandle B2_REVOLUTE_JOINT_IS_SPRING_ENABLED;
	private static final MethodHandle B2_REVOLUTE_JOINT_SET_SPRING_HERTZ;
	private static final MethodHandle B2_REVOLUTE_JOINT_GET_SPRING_HERTZ;
	private static final MethodHandle B2_REVOLUTE_JOINT_SET_SPRING_DAMPING_RATIO;
	private static final MethodHandle B2_REVOLUTE_JOINT_GET_SPRING_DAMPING_RATIO;
	private static final MethodHandle B2_REVOLUTE_JOINT_GET_ANGLE;
	private static final MethodHandle B2_REVOLUTE_JOINT_ENABLE_LIMIT;
	private static final MethodHandle B2_REVOLUTE_JOINT_IS_LIMIT_ENABLED;
	private static final MethodHandle B2_REVOLUTE_JOINT_GET_LOWER_LIMIT;
	private static final MethodHandle B2_REVOLUTE_JOINT_GET_UPPER_LIMIT;
	private static final MethodHandle B2_REVOLUTE_JOINT_SET_LIMITS;
	private static final MethodHandle B2_REVOLUTE_JOINT_ENABLE_MOTOR;
	private static final MethodHandle B2_REVOLUTE_JOINT_IS_MOTOR_ENABLED;
	private static final MethodHandle B2_REVOLUTE_JOINT_SET_MOTOR_SPEED;
	private static final MethodHandle B2_REVOLUTE_JOINT_GET_MOTOR_SPEED;
	private static final MethodHandle B2_REVOLUTE_JOINT_GET_MOTOR_TORQUE;
	private static final MethodHandle B2_REVOLUTE_JOINT_SET_MAX_MOTOR_TORQUE;
	private static final MethodHandle B2_REVOLUTE_JOINT_GET_MAX_MOTOR_TORQUE;

	static {
		//@formatter:off
		B2_CREATE_REVOLUTE_JOINT = downcallHandle("b2CreateRevoluteJoint", JOINT_ID_LAYOUT, World.LAYOUT(), ADDRESS);
		B2_REVOLUTE_JOINT_ENABLE_SPRING = downcallHandleVoid("b2RevoluteJoint_EnableSpring", JOINT_ID_LAYOUT, JAVA_BOOLEAN);
		B2_REVOLUTE_JOINT_IS_SPRING_ENABLED = downcallHandle("b2RevoluteJoint_IsSpringEnabled", JAVA_BOOLEAN, JOINT_ID_LAYOUT);
		B2_REVOLUTE_JOINT_SET_SPRING_HERTZ = downcallHandleVoid("b2RevoluteJoint_SetSpringHertz", JOINT_ID_LAYOUT, JAVA_FLOAT);
		B2_REVOLUTE_JOINT_SET_SPRING_DAMPING_RATIO = downcallHandleVoid("b2RevoluteJoint_SetSpringDampingRatio", JOINT_ID_LAYOUT, JAVA_FLOAT);
		B2_REVOLUTE_JOINT_GET_SPRING_HERTZ = downcallHandle("b2RevoluteJoint_GetSpringHertz", JAVA_FLOAT, JOINT_ID_LAYOUT);
		B2_REVOLUTE_JOINT_GET_SPRING_DAMPING_RATIO = downcallHandle("b2RevoluteJoint_GetSpringDampingRatio", JAVA_FLOAT, JOINT_ID_LAYOUT);
		B2_REVOLUTE_JOINT_GET_ANGLE = downcallHandle("b2RevoluteJoint_GetAngle", JAVA_FLOAT, JOINT_ID_LAYOUT);
		B2_REVOLUTE_JOINT_ENABLE_LIMIT =  downcallHandleVoid("b2RevoluteJoint_EnableLimit", JOINT_ID_LAYOUT, JAVA_BOOLEAN);
		B2_REVOLUTE_JOINT_IS_LIMIT_ENABLED = downcallHandle("b2RevoluteJoint_IsLimitEnabled", JAVA_BOOLEAN, JOINT_ID_LAYOUT);
		B2_REVOLUTE_JOINT_GET_LOWER_LIMIT = downcallHandle("b2RevoluteJoint_GetLowerLimit", JAVA_FLOAT, JOINT_ID_LAYOUT);
		B2_REVOLUTE_JOINT_GET_UPPER_LIMIT = downcallHandle("b2RevoluteJoint_GetUpperLimit", JAVA_FLOAT, JOINT_ID_LAYOUT);
		B2_REVOLUTE_JOINT_SET_LIMITS = downcallHandleVoid("b2RevoluteJoint_SetLimits", JOINT_ID_LAYOUT, JAVA_FLOAT, JAVA_FLOAT);
		B2_REVOLUTE_JOINT_ENABLE_MOTOR = downcallHandleVoid("b2RevoluteJoint_EnableMotor", JOINT_ID_LAYOUT, JAVA_BOOLEAN);
		B2_REVOLUTE_JOINT_IS_MOTOR_ENABLED = downcallHandle("b2RevoluteJoint_IsMotorEnabled", JAVA_BOOLEAN, JOINT_ID_LAYOUT);
		B2_REVOLUTE_JOINT_SET_MOTOR_SPEED = downcallHandleVoid("b2RevoluteJoint_SetMotorSpeed", JOINT_ID_LAYOUT, JAVA_FLOAT);
		B2_REVOLUTE_JOINT_GET_MOTOR_SPEED = downcallHandle("b2RevoluteJoint_GetMotorSpeed", JAVA_FLOAT, JOINT_ID_LAYOUT);
		B2_REVOLUTE_JOINT_GET_MOTOR_TORQUE = downcallHandle("b2RevoluteJoint_GetMotorTorque", JAVA_FLOAT, JOINT_ID_LAYOUT);
		B2_REVOLUTE_JOINT_SET_MAX_MOTOR_TORQUE = downcallHandleVoid("b2RevoluteJoint_SetMaxMotorTorque", JOINT_ID_LAYOUT, JAVA_FLOAT);
		B2_REVOLUTE_JOINT_GET_MAX_MOTOR_TORQUE = downcallHandle("b2RevoluteJoint_GetMaxMotorTorque", JAVA_FLOAT, JOINT_ID_LAYOUT);
		//@formatter:on
	}

	/**
	 * Create the revolute joint.
	 */
	public RevoluteJoint(World world, RevoluteJointDef revoluteJointDef) {
		MemorySegment b2RevoluteJoint;
		try {
			SegmentAllocator allocator = Arena.ofAuto();

			MemorySegment worldAddr = world.memorySegment();
			MemorySegment defAddr = revoluteJointDef.memorySegment();

			b2RevoluteJoint = (MemorySegment) B2_CREATE_REVOLUTE_JOINT.invokeExact(allocator, worldAddr, defAddr);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot create revolute joint.");
		}
		super(b2RevoluteJoint, world);
	}

	/**
	 * Enable/disable the revolute joint spring.
	 */
	public void enableSpring(boolean enableSpring) {
		try {
			B2_REVOLUTE_JOINT_ENABLE_SPRING.invokeExact(b2JointId, enableSpring);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot enable/ disable spring.");
		}
	}

	/**
	 * Is the revolute angular spring enabled?
	 */
	public boolean isSpringEnabled() {
		try {
			return (boolean) B2_REVOLUTE_JOINT_IS_SPRING_ENABLED.invokeExact(b2JointId);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot check if spring is enabled.");
		}
	}

	/**
	 * Set the revolute joint spring stiffness in Hertz.
	 */
	public void setSpringHertz(float springHertz) {
		try {
			B2_REVOLUTE_JOINT_SET_SPRING_HERTZ.invokeExact(b2JointId, springHertz);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot set spring hertz.");
		}
	}

	/**
	 * Set the revolute joint spring damping ratio, non-dimensional.
	 */
	public void setSpringDampingRatio(float springDampingRatio) {
		try {
			B2_REVOLUTE_JOINT_SET_SPRING_DAMPING_RATIO.invokeExact(b2JointId, springDampingRatio);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot set spring damping ratio.");
		}
	}

	/**
	 * Get the revolute joint spring stiffness in Hertz.
	 */
	public float getSpringHertz() {
		try {
			return (float) B2_REVOLUTE_JOINT_GET_SPRING_HERTZ.invokeExact(b2JointId);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot get spring hertz.");
		}
	}

	/**
	 * Get the revolute joint spring damping ratio, non-dimensional.
	 */
	public float getSpringDampingRatio() {
		try {
			return (float) B2_REVOLUTE_JOINT_GET_SPRING_DAMPING_RATIO.invokeExact(b2JointId);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot get spring damping ratio.");
		}
	}

	/**
	 * Get the revolute joint current angle in radians relative to the reference
	 * angle.
	 */
	public float getAngleRadians() {
		try {
			return (float) B2_REVOLUTE_JOINT_GET_ANGLE.invokeExact(b2JointId);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot get angle.");
		}
	}

	/**
	 * Get the revolute joint current angle in degrees relative to the reference
	 * angle.
	 */
	public float getAngle() {
		return MathUtils.toDegrees(getAngleRadians());
	}

	/**
	 * Enable/disable the revolute joint limit.
	 */
	public void enableLimit(boolean enableLimit) {
		try {
			B2_REVOLUTE_JOINT_ENABLE_LIMIT.invokeExact(b2JointId, enableLimit);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot enable/ disable limit.");
		}
	}

	/**
	 * Is the revolute joint limit enabled?
	 */
	public boolean isLimitEnabled() {
		try {
			return (boolean) B2_REVOLUTE_JOINT_IS_LIMIT_ENABLED.invokeExact(b2JointId);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot check if limit is enabled.");
		}
	}

	/**
	 * Get the revolute joint lower limit in radians.
	 */
	public float getLowerLimit() {
		try {
			return (float) B2_REVOLUTE_JOINT_GET_LOWER_LIMIT.invokeExact(b2JointId);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot get lower limit.");
		}
	}

	/**
	 * Get the revolute joint upper limit in radians.
	 */
	public float getUpperLimit() {
		try {
			return (float) B2_REVOLUTE_JOINT_GET_UPPER_LIMIT.invokeExact(b2JointId);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot get upper limit.");
		}
	}

	/**
	 * Set the revolute joint limits in radians.
	 */
	public void setLimits(float lower, float upper) {
		try {
			B2_REVOLUTE_JOINT_SET_LIMITS.invokeExact(b2JointId, lower, upper);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot set limits.");
		}
	}

	/**
	 * Enable/disable the revolute joint motor.
	 */
	public void enableMotor(boolean enableMotor) {
		try {
			B2_REVOLUTE_JOINT_ENABLE_MOTOR.invokeExact(b2JointId, enableMotor);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot enable/ disable motor.");
		}
	}

	/**
	 * Is the revolute joint motor enabled?
	 */
	public boolean isMotorEnabled() {
		try {
			return (boolean) B2_REVOLUTE_JOINT_IS_MOTOR_ENABLED.invokeExact(b2JointId);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot check if motor is enabled.");
		}
	}

	/**
	 * Set the revolute joint motor speed in radians per second.
	 */
	public void setMotorSpeed(float motorSpeed) {
		try {
			B2_REVOLUTE_JOINT_SET_MOTOR_SPEED.invokeExact(b2JointId, motorSpeed);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot set motor speed.");
		}
	}

	/**
	 * Get the revolute joint motor speed in radians per second.
	 */
	public float getMotorSpeed() {
		try {
			return (float) B2_REVOLUTE_JOINT_GET_MOTOR_SPEED.invokeExact(b2JointId);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot get motor speed.");
		}
	}

	/**
	 * Get the revolute joint current motor torque, usually in newton-meters.
	 */
	public float getMotorTorque() {
		try {
			return (float) B2_REVOLUTE_JOINT_GET_MOTOR_TORQUE.invokeExact(b2JointId);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot get motor torque.");
		}
	}

	/**
	 * Set the revolute joint maximum motor torque, usually in newton-meters.
	 */
	public void setMaxMotorTorque(float maxMotorTorque) {
		try {
			B2_REVOLUTE_JOINT_SET_MAX_MOTOR_TORQUE.invokeExact(b2JointId, maxMotorTorque);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot set max motor torque.");
		}
	}

	/**
	 * Get the revolute joint maximum motor torque, usually in newton-meters.
	 */
	public float getMaxMotorTorque() {
		try {
			return (float) B2_REVOLUTE_JOINT_GET_MAX_MOTOR_TORQUE.invokeExact(b2JointId);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot get max motor torque.");
		}
	}

}
