package volucris.engine.physics.box2d.joint;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.lang.invoke.MethodHandle;

import volucris.engine.physics.box2d.world.World;
import volucris.engine.utils.Box2DRuntimeException;

import static java.lang.foreign.ValueLayout.*;
import static volucris.engine.utils.FFMUtils.*;

public final class WheelJoint extends Joint {

	private static final MethodHandle B2_CREATE_WHEEL_JOINT;
	private static final MethodHandle B2_WHEEL_JOINT_ENABLE_SPRING;
	private static final MethodHandle B2_WHEEL_JOINT_IS_SPRING_ENABLED;
	private static final MethodHandle B2_WHEEL_JOINT_SET_SPRING_HERTZ;
	private static final MethodHandle B2_WHEEL_JOINT_GET_SPRING_HERTZ;
	private static final MethodHandle B2_WHEEL_JOINT_SET_SPRING_DAMPING_RATIO;
	private static final MethodHandle B2_WHEEL_JOINT_GET_SPRING_DAMPING_RATIO;
	private static final MethodHandle B2_WHEEL_JOINT_ENABLE_LIMIT;
	private static final MethodHandle B2_WHEEL_JOINT_IS_LIMIT_ENABLED;
	private static final MethodHandle B2_WHEEL_JOINT_GET_LOWER_LIMIT;
	private static final MethodHandle B2_WHEEL_JOINT_GET_UPPER_LIMIT;
	private static final MethodHandle B2_WHEEL_JOINT_SET_LIMITS;
	private static final MethodHandle B2_WHEEL_JOINT_ENABLE_MOTOR;
	private static final MethodHandle B2_WHEEL_JOINT_IS_MOTOR_ENABLED;
	private static final MethodHandle B2_WHEEL_JOINT_SET_MOTOR_SPEED;
	private static final MethodHandle B2_WHEEL_JOINT_GET_MOTOR_SPEED;
	private static final MethodHandle B2_WHEEL_JOINT_SET_MAX_MOTOR_TORQUE;
	private static final MethodHandle B2_WHEEL_JOINT_GET_MAX_MOTOR_TORQUE;
	private static final MethodHandle B2_WHEEL_JOINT_GET_MOTOR_TORQUE;

	static {
		//@formatter:off
		B2_CREATE_WHEEL_JOINT = downcallHandle("b2CreateWheelJoint", JOINT_ID_LAYOUT, World.LAYOUT(), ADDRESS);
		B2_WHEEL_JOINT_ENABLE_SPRING = downcallHandleVoid("b2WheelJoint_EnableSpring", JOINT_ID_LAYOUT, JAVA_BOOLEAN);
		B2_WHEEL_JOINT_IS_SPRING_ENABLED = downcallHandle("b2WheelJoint_IsSpringEnabled", JAVA_BOOLEAN, JOINT_ID_LAYOUT);
		B2_WHEEL_JOINT_SET_SPRING_HERTZ = downcallHandleVoid("b2WheelJoint_SetSpringHertz", JOINT_ID_LAYOUT, JAVA_FLOAT);
		B2_WHEEL_JOINT_GET_SPRING_HERTZ = downcallHandle("b2WheelJoint_GetSpringHertz", JAVA_FLOAT, JOINT_ID_LAYOUT);
		B2_WHEEL_JOINT_SET_SPRING_DAMPING_RATIO = downcallHandleVoid("b2WheelJoint_SetSpringDampingRatio", JOINT_ID_LAYOUT, JAVA_FLOAT);
		B2_WHEEL_JOINT_GET_SPRING_DAMPING_RATIO = downcallHandle("b2WheelJoint_GetSpringDampingRatio", JAVA_FLOAT, JOINT_ID_LAYOUT);
		B2_WHEEL_JOINT_ENABLE_LIMIT =  downcallHandleVoid("b2WheelJoint_EnableLimit", JOINT_ID_LAYOUT, JAVA_BOOLEAN);
		B2_WHEEL_JOINT_IS_LIMIT_ENABLED = downcallHandle("b2WheelJoint_IsLimitEnabled", JAVA_BOOLEAN, JOINT_ID_LAYOUT);
		B2_WHEEL_JOINT_GET_LOWER_LIMIT = downcallHandle("b2WheelJoint_GetLowerLimit", JAVA_FLOAT, JOINT_ID_LAYOUT);
		B2_WHEEL_JOINT_GET_UPPER_LIMIT = downcallHandle("b2WheelJoint_GetUpperLimit", JAVA_FLOAT, JOINT_ID_LAYOUT);
		B2_WHEEL_JOINT_SET_LIMITS = downcallHandleVoid("b2WheelJoint_SetLimits", JOINT_ID_LAYOUT, JAVA_FLOAT, JAVA_FLOAT);
		B2_WHEEL_JOINT_ENABLE_MOTOR = downcallHandleVoid("b2WheelJoint_EnableMotor", JOINT_ID_LAYOUT, JAVA_BOOLEAN);
		B2_WHEEL_JOINT_IS_MOTOR_ENABLED = downcallHandle("b2WheelJoint_IsMotorEnabled", JAVA_BOOLEAN, JOINT_ID_LAYOUT);
		B2_WHEEL_JOINT_SET_MOTOR_SPEED = downcallHandleVoid("b2WheelJoint_SetMotorSpeed", JOINT_ID_LAYOUT, JAVA_FLOAT);
		B2_WHEEL_JOINT_GET_MOTOR_SPEED = downcallHandle("b2WheelJoint_GetMotorSpeed", JAVA_FLOAT, JOINT_ID_LAYOUT);
		B2_WHEEL_JOINT_SET_MAX_MOTOR_TORQUE = downcallHandleVoid("b2WheelJoint_SetMaxMotorTorque", JOINT_ID_LAYOUT, JAVA_FLOAT);
		B2_WHEEL_JOINT_GET_MAX_MOTOR_TORQUE = downcallHandle("b2WheelJoint_GetMaxMotorTorque", JAVA_FLOAT, JOINT_ID_LAYOUT);
		B2_WHEEL_JOINT_GET_MOTOR_TORQUE = downcallHandle("b2WheelJoint_GetMotorTorque", JAVA_FLOAT, JOINT_ID_LAYOUT);
		//@formatter:on
	}

	public WheelJoint(World world, WheelJointDef wheelJointDef) {
		this(world, wheelJointDef, Arena.ofAuto());
	}

	/**
	 * Create a wheel joint.
	 */
	public WheelJoint(World world, WheelJointDef wheelJointDef, Arena arena) {
		MemorySegment b2WheelJoint;
		try {
			MemorySegment worldAddr = world.memorySegment();
			MemorySegment defAddr = wheelJointDef.memorySegment();

			b2WheelJoint = (MemorySegment) B2_CREATE_WHEEL_JOINT.invoke(arena, worldAddr, defAddr);
		} catch (Throwable e) {
			String className = e.getClass().getSimpleName();
			throw new Box2DRuntimeException("Box2D: Cannot create wheel joint: " + className);
		}
		super(b2WheelJoint, world, arena);
	}

	/**
	 * Enable/disable the wheel joint spring.
	 */
	public void enableSpring(boolean enableSpring) {
		try {
			B2_WHEEL_JOINT_ENABLE_SPRING.invokeExact(b2JointId, enableSpring);
		} catch (Throwable e) {
			String className = e.getClass().getSimpleName();
			throw new Box2DRuntimeException("Box2D: Cannot enable/ disable spring: " + className);
		}
	}

	/**
	 * Is the wheel joint spring enabled?
	 */
	public boolean isSpringEnabled() {
		try {
			return (boolean) B2_WHEEL_JOINT_IS_SPRING_ENABLED.invokeExact(b2JointId);
		} catch (Throwable e) {
			String className = e.getClass().getSimpleName();
			throw new Box2DRuntimeException("Box2D: Cannot check if spring is enabled: " + className);
		}
	}

	/**
	 * Set the wheel joint stiffness in Hertz.
	 */
	public void setSpringHertz(float springHertz) {
		try {
			B2_WHEEL_JOINT_SET_SPRING_HERTZ.invokeExact(b2JointId, springHertz);
		} catch (Throwable e) {
			String className = e.getClass().getSimpleName();
			throw new Box2DRuntimeException("Box2D: Cannot set spring hertz: " + className);
		}
	}

	/**
	 * Set the wheel joint damping ratio, non-dimensional.
	 */
	public void setSpringDampingRatio(float springDampingRatio) {
		try {
			B2_WHEEL_JOINT_SET_SPRING_DAMPING_RATIO.invokeExact(b2JointId, springDampingRatio);
		} catch (Throwable e) {
			String className = e.getClass().getSimpleName();
			throw new Box2DRuntimeException("Box2D: Cannot set spring damping ratio: " + className);
		}
	}

	/**
	 * Get the wheel joint stiffness in Hertz.
	 */
	public float getSpringHertz() {
		try {
			return (float) B2_WHEEL_JOINT_GET_SPRING_HERTZ.invokeExact(b2JointId);
		} catch (Throwable e) {
			String className = e.getClass().getSimpleName();
			throw new Box2DRuntimeException("Box2D: Cannot get spring hertz: " + className);
		}
	}

	/**
	 * Get the wheel joint damping ratio, non-dimensional.
	 */
	public float getSpringDampingRatio() {
		try {
			return (float) B2_WHEEL_JOINT_GET_SPRING_DAMPING_RATIO.invokeExact(b2JointId);
		} catch (Throwable e) {
			String className = e.getClass().getSimpleName();
			throw new Box2DRuntimeException("Box2D: Cannot get spring damping ratio: " + className);
		}
	}

	/**
	 * Enable/disable the wheel joint limit.
	 */
	public void enableLimit(boolean enableLimit) {
		try {
			B2_WHEEL_JOINT_ENABLE_LIMIT.invokeExact(b2JointId, enableLimit);
		} catch (Throwable e) {
			String className = e.getClass().getSimpleName();
			throw new Box2DRuntimeException("Box2D: Cannot enable/ disable limit: " + className);
		}
	}

	/**
	 * Is the wheel joint limit enabled?
	 */
	public boolean isLimitEnabled() {
		try {
			return (boolean) B2_WHEEL_JOINT_IS_LIMIT_ENABLED.invokeExact(b2JointId);
		} catch (Throwable e) {
			String className = e.getClass().getSimpleName();
			throw new Box2DRuntimeException("Box2D: Cannot check if limit is enabled: " + className);
		}
	}

	/**
	 * Get the wheel joint lower limit.
	 */
	public float getLowerLimit() {
		try {
			return (float) B2_WHEEL_JOINT_GET_LOWER_LIMIT.invokeExact(b2JointId);
		} catch (Throwable e) {
			String className = e.getClass().getSimpleName();
			throw new Box2DRuntimeException("Box2D: Cannot get lower limit: " + className);
		}
	}

	/**
	 * Get the wheel joint upper limit.
	 */
	public float getUpperLimit() {
		try {
			return (float) B2_WHEEL_JOINT_GET_UPPER_LIMIT.invokeExact(b2JointId);
		} catch (Throwable e) {
			String className = e.getClass().getSimpleName();
			throw new Box2DRuntimeException("Box2D: Cannot get upper limit: " + className);
		}
	}

	/**
	 * Set the wheel joint limits.
	 */
	public void setLimits(float lower, float upper) {
		try {
			B2_WHEEL_JOINT_SET_LIMITS.invokeExact(b2JointId, lower, upper);
		} catch (Throwable e) {
			String className = e.getClass().getSimpleName();
			throw new Box2DRuntimeException("Box2D: Cannot set limits: " + className);
		}
	}

	/**
	 * Enable/disable the wheel joint motor.
	 */
	public void enableMotor(boolean enableMotor) {
		try {
			B2_WHEEL_JOINT_ENABLE_MOTOR.invokeExact(b2JointId, enableMotor);
		} catch (Throwable e) {
			String className = e.getClass().getSimpleName();
			throw new Box2DRuntimeException("Box2D: Cannot enable/ disable motor: " + className);
		}
	}

	/**
	 * Is the wheel joint motor enabled?
	 */
	public boolean isMotorEnabled() {
		try {
			return (boolean) B2_WHEEL_JOINT_IS_MOTOR_ENABLED.invokeExact(b2JointId);
		} catch (Throwable e) {
			String className = e.getClass().getSimpleName();
			throw new Box2DRuntimeException("Box2D: Cannot check if motor is enabled: " + className);
		}
	}

	/**
	 * Set the wheel joint motor speed in radians per second.
	 */
	public void setMotorSpeed(float motorSpeed) {
		try {
			B2_WHEEL_JOINT_SET_MOTOR_SPEED.invokeExact(b2JointId, motorSpeed);
		} catch (Throwable e) {
			String className = e.getClass().getSimpleName();
			throw new Box2DRuntimeException("Box2D: Cannot set motor speed: " + className);
		}
	}

	/**
	 * Get the wheel joint motor speed in radians per second.
	 */
	public float getMotorSpeed() {
		try {
			return (float) B2_WHEEL_JOINT_GET_MOTOR_SPEED.invokeExact(b2JointId);
		} catch (Throwable e) {
			String className = e.getClass().getSimpleName();
			throw new Box2DRuntimeException("Box2D: Cannot get motor speed: " + className);
		}
	}

	/**
	 * Set the wheel joint maximum motor torque, usually in newton-meters.
	 */
	public void setMaxMotorTorque(float torque) {
		try {
			B2_WHEEL_JOINT_SET_MAX_MOTOR_TORQUE.invokeExact(b2JointId, torque);
		} catch (Throwable e) {
			String className = e.getClass().getSimpleName();
			throw new Box2DRuntimeException("Box2D: Cannot set max motor torque: " + className);
		}
	}

	/**
	 * Get the wheel joint maximum motor torque, usually in newton-meters.
	 */
	public float getMaxMotorTorque() {
		try {
			return (float) B2_WHEEL_JOINT_GET_MAX_MOTOR_TORQUE.invokeExact(b2JointId);
		} catch (Throwable e) {
			String className = e.getClass().getSimpleName();
			throw new Box2DRuntimeException("Box2D: Cannot get max motor torque: " + className);
		}
	}

	/**
	 * Get the wheel joint current motor torque, usually in newton-meters.
	 */
	public float getMotorTorque() {
		try {
			return (float) B2_WHEEL_JOINT_GET_MOTOR_TORQUE.invokeExact(b2JointId);
		} catch (Throwable e) {
			String className = e.getClass().getSimpleName();
			throw new Box2DRuntimeException("Box2D: Cannot get motor torque: " + className);
		}
	}

}
