package volucris.engine.physics.box2d.joint;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.lang.invoke.MethodHandle;

import volucris.engine.physics.box2d.world.World;
import volucris.engine.utils.MathUtils;
import volucris.engine.utils.Box2DRuntimeException;

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

	public RevoluteJoint(World world, RevoluteJointDef revoluteJointDef) {
		this(world, revoluteJointDef, Arena.ofAuto());
	}

	/**
	 * Create the revolute joint.
	 */
	public RevoluteJoint(World world, RevoluteJointDef revoluteJointDef, Arena arena) {
		MemorySegment b2RevoluteJoint;
		try {
			MemorySegment worldAddr = world.memorySegment();
			MemorySegment defAddr = revoluteJointDef.memorySegment();

			b2RevoluteJoint = (MemorySegment) B2_CREATE_REVOLUTE_JOINT.invoke(arena, worldAddr, defAddr);
		} catch (Throwable e) {
			String className = e.getClass().getSimpleName();
			throw new Box2DRuntimeException("Cannot create revolute joint: " + className);
		}
		super(b2RevoluteJoint, world, arena);
	}

	/**
	 * Enable/disable the revolute joint spring.
	 */
	public void enableSpring(boolean enableSpring) {
		try {
			B2_REVOLUTE_JOINT_ENABLE_SPRING.invokeExact(b2JointId, enableSpring);
		} catch (Throwable e) {
			String className = e.getClass().getSimpleName();
			throw new Box2DRuntimeException("Cannot enable/ disable spring: " + className);
		}
	}

	/**
	 * Is the revolute angular spring enabled?
	 */
	public boolean isSpringEnabled() {
		try {
			return (boolean) B2_REVOLUTE_JOINT_IS_SPRING_ENABLED.invokeExact(b2JointId);
		} catch (Throwable e) {
			String className = e.getClass().getSimpleName();
			throw new Box2DRuntimeException("Cannot check if spring is enabled: " + className);
		}
	}

	/**
	 * Set the revolute joint spring stiffness in Hertz.
	 */
	public void setSpringHertz(float springHertz) {
		try {
			B2_REVOLUTE_JOINT_SET_SPRING_HERTZ.invokeExact(b2JointId, springHertz);
		} catch (Throwable e) {
			String className = e.getClass().getSimpleName();
			throw new Box2DRuntimeException("Cannot set spring hertz: " + className);
		}
	}

	/**
	 * Set the revolute joint spring damping ratio, non-dimensional.
	 */
	public void setSpringDampingRatio(float springDampingRatio) {
		try {
			B2_REVOLUTE_JOINT_SET_SPRING_DAMPING_RATIO.invokeExact(b2JointId, springDampingRatio);
		} catch (Throwable e) {
			String className = e.getClass().getSimpleName();
			throw new Box2DRuntimeException("Cannot set spring damping ratio: " + className);
		}
	}

	/**
	 * Get the revolute joint spring stiffness in Hertz.
	 */
	public float getSpringHertz() {
		try {
			return (float) B2_REVOLUTE_JOINT_GET_SPRING_HERTZ.invokeExact(b2JointId);
		} catch (Throwable e) {
			String className = e.getClass().getSimpleName();
			throw new Box2DRuntimeException("Cannot get spring hertz: " + className);
		}
	}

	/**
	 * Get the revolute joint spring damping ratio, non-dimensional.
	 */
	public float getSpringDampingRatio() {
		try {
			return (float) B2_REVOLUTE_JOINT_GET_SPRING_DAMPING_RATIO.invokeExact(b2JointId);
		} catch (Throwable e) {
			String className = e.getClass().getSimpleName();
			throw new Box2DRuntimeException("Cannot get spring damping ratio: " + className);
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
			String className = e.getClass().getSimpleName();
			throw new Box2DRuntimeException("Cannot get angle: " + className);
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
			String className = e.getClass().getSimpleName();
			throw new Box2DRuntimeException("Cannot enable/ disable limit: " + className);
		}
	}

	/**
	 * Is the revolute joint limit enabled?
	 */
	public boolean isLimitEnabled() {
		try {
			return (boolean) B2_REVOLUTE_JOINT_IS_LIMIT_ENABLED.invokeExact(b2JointId);
		} catch (Throwable e) {
			String className = e.getClass().getSimpleName();
			throw new Box2DRuntimeException("Cannot check if limit is enabled: " + className);
		}
	}

	/**
	 * Get the revolute joint lower limit in radians.
	 */
	public float getLowerLimit() {
		try {
			return (float) B2_REVOLUTE_JOINT_GET_LOWER_LIMIT.invokeExact(b2JointId);
		} catch (Throwable e) {
			String className = e.getClass().getSimpleName();
			throw new Box2DRuntimeException("Cannot get lower limit: " + className);
		}
	}

	/**
	 * Get the revolute joint upper limit in radians.
	 */
	public float getUpperLimit() {
		try {
			return (float) B2_REVOLUTE_JOINT_GET_UPPER_LIMIT.invokeExact(b2JointId);
		} catch (Throwable e) {
			String className = e.getClass().getSimpleName();
			throw new Box2DRuntimeException("Cannot get upper limit: " + className);
		}
	}

	/**
	 * Set the revolute joint limits in radians.
	 */
	public void setLimits(float lower, float upper) {
		try {
			B2_REVOLUTE_JOINT_SET_LIMITS.invokeExact(b2JointId, lower, upper);
		} catch (Throwable e) {
			String className = e.getClass().getSimpleName();
			throw new Box2DRuntimeException("Cannot set limits: " + className);
		}
	}

	/**
	 * Enable/disable the revolute joint motor.
	 */
	public void enableMotor(boolean enableMotor) {
		try {
			B2_REVOLUTE_JOINT_ENABLE_MOTOR.invokeExact(b2JointId, enableMotor);
		} catch (Throwable e) {
			String className = e.getClass().getSimpleName();
			throw new Box2DRuntimeException("Cannot enable/ disable motor: " + className);
		}
	}

	/**
	 * Is the revolute joint motor enabled?
	 */
	public boolean isMotorEnabled() {
		try {
			return (boolean) B2_REVOLUTE_JOINT_IS_MOTOR_ENABLED.invokeExact(b2JointId);
		} catch (Throwable e) {
			String className = e.getClass().getSimpleName();
			throw new Box2DRuntimeException("Cannot check if motor is enabled: " + className);
		}
	}

	/**
	 * Set the revolute joint motor speed in radians per second.
	 */
	public void setMotorSpeed(float motorSpeed) {
		try {
			B2_REVOLUTE_JOINT_SET_MOTOR_SPEED.invokeExact(b2JointId, motorSpeed);
		} catch (Throwable e) {
			String className = e.getClass().getSimpleName();
			throw new Box2DRuntimeException("Cannot set motor speed: " + className);
		}
	}

	/**
	 * Get the revolute joint motor speed in radians per second.
	 */
	public float getMotorSpeed() {
		try {
			return (float) B2_REVOLUTE_JOINT_GET_MOTOR_SPEED.invokeExact(b2JointId);
		} catch (Throwable e) {
			String className = e.getClass().getSimpleName();
			throw new Box2DRuntimeException("Cannot get motor speed: " + className);
		}
	}

	/**
	 * Get the revolute joint current motor torque, usually in newton-meters.
	 */
	public float getMotorTorque() {
		try {
			return (float) B2_REVOLUTE_JOINT_GET_MOTOR_TORQUE.invokeExact(b2JointId);
		} catch (Throwable e) {
			String className = e.getClass().getSimpleName();
			throw new Box2DRuntimeException("Cannot get motor torque: " + className);
		}
	}

	/**
	 * Set the revolute joint maximum motor torque, usually in newton-meters.
	 */
	public void setMaxMotorTorque(float maxMotorTorque) {
		try {
			B2_REVOLUTE_JOINT_SET_MAX_MOTOR_TORQUE.invokeExact(b2JointId, maxMotorTorque);
		} catch (Throwable e) {
			String className = e.getClass().getSimpleName();
			throw new Box2DRuntimeException("Cannot set max motor torque: " + className);
		}
	}

	/**
	 * Get the revolute joint maximum motor torque, usually in newton-meters.
	 */
	public float getMaxMotorTorque() {
		try {
			return (float) B2_REVOLUTE_JOINT_GET_MAX_MOTOR_TORQUE.invokeExact(b2JointId);
		} catch (Throwable e) {
			String className = e.getClass().getSimpleName();
			throw new Box2DRuntimeException("Cannot get max motor torque: " + className);
		}
	}

}
