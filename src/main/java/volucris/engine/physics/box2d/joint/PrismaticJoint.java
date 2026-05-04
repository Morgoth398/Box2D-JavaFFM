package volucris.engine.physics.box2d.joint;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.lang.invoke.MethodHandle;

import volucris.engine.physics.box2d.world.World;
import volucris.engine.utils.Box2DRuntimeException;

import static java.lang.foreign.ValueLayout.*;
import static volucris.engine.utils.FFMUtils.*;

public final class PrismaticJoint extends Joint {

	private static final MethodHandle B2_CREATE_PRISMATIC_JOINT;
	private static final MethodHandle B2_PRISMATIC_JOINT_ENABLE_SPRING;
	private static final MethodHandle B2_PRISMATIC_JOINT_IS_SPRING_ENABLED;
	private static final MethodHandle B2_PRISMATIC_JOINT_SET_SPRING_HERTZ;
	private static final MethodHandle B2_PRISMATIC_JOINT_GET_SPRING_HERTZ;
	private static final MethodHandle B2_PRISMATIC_JOINT_SET_SPRING_DAMPING_RATIO;
	private static final MethodHandle B2_PRISMATIC_JOINT_GET_SPRING_DAMPING_RATIO;
	private static final MethodHandle B2_PRISMATIC_JOINT_ENABLE_LIMIT;
	private static final MethodHandle B2_PRISMATIC_JOINT_IS_LIMIT_ENABLED;
	private static final MethodHandle B2_PRISMATIC_JOINT_GET_LOWER_LIMIT;
	private static final MethodHandle B2_PRISMATIC_JOINT_GET_UPPER_LIMIT;
	private static final MethodHandle B2_PRISMATIC_JOINT_SET_LIMITS;
	private static final MethodHandle B2_PRISMATIC_JOINT_ENABLE_MOTOR;
	private static final MethodHandle B2_PRISMATIC_JOINT_IS_MOTOR_ENABLED;
	private static final MethodHandle B2_PRISMATIC_JOINT_SET_MOTOR_SPEED;
	private static final MethodHandle B2_PRISMATIC_JOINT_GET_MOTOR_SPEED;
	private static final MethodHandle B2_PRISMATIC_JOINT_SET_MAX_MOTOR_FORCE;
	private static final MethodHandle B2_PRISMATIC_JOINT_GET_MAX_MOTOR_FORCE;
	private static final MethodHandle B2_PRISMATIC_JOINT_GET_MOTOR_FORCE;
	private static final MethodHandle B2_PRISMATIC_JOINT_GET_TRANSLATION;
	private static final MethodHandle B2_PRISMATIC_JOINT_GET_SPEED;

	static {
		//@formatter:off
		B2_CREATE_PRISMATIC_JOINT = downcallHandle("b2CreatePrismaticJoint", JOINT_ID_LAYOUT, World.LAYOUT(), ADDRESS);
		B2_PRISMATIC_JOINT_ENABLE_SPRING = downcallHandleVoid("b2PrismaticJoint_EnableSpring", JOINT_ID_LAYOUT, JAVA_BOOLEAN);
		B2_PRISMATIC_JOINT_IS_SPRING_ENABLED = downcallHandle("b2PrismaticJoint_IsSpringEnabled", JAVA_BOOLEAN, JOINT_ID_LAYOUT);
		B2_PRISMATIC_JOINT_SET_SPRING_HERTZ = downcallHandleVoid("b2PrismaticJoint_SetSpringHertz", JOINT_ID_LAYOUT, JAVA_FLOAT);
		B2_PRISMATIC_JOINT_SET_SPRING_DAMPING_RATIO = downcallHandleVoid("b2PrismaticJoint_SetSpringDampingRatio", JOINT_ID_LAYOUT, JAVA_FLOAT);
		B2_PRISMATIC_JOINT_GET_SPRING_HERTZ = downcallHandle("b2PrismaticJoint_GetSpringHertz", JAVA_FLOAT, JOINT_ID_LAYOUT);
		B2_PRISMATIC_JOINT_GET_SPRING_DAMPING_RATIO = downcallHandle("b2PrismaticJoint_GetSpringDampingRatio", JAVA_FLOAT, JOINT_ID_LAYOUT);
		B2_PRISMATIC_JOINT_ENABLE_LIMIT =  downcallHandleVoid("b2PrismaticJoint_EnableLimit", JOINT_ID_LAYOUT, JAVA_BOOLEAN);
		B2_PRISMATIC_JOINT_IS_LIMIT_ENABLED = downcallHandle("b2PrismaticJoint_IsLimitEnabled", JAVA_BOOLEAN, JOINT_ID_LAYOUT);
		B2_PRISMATIC_JOINT_GET_LOWER_LIMIT = downcallHandle("b2PrismaticJoint_GetLowerLimit", JAVA_FLOAT, JOINT_ID_LAYOUT);
		B2_PRISMATIC_JOINT_GET_UPPER_LIMIT = downcallHandle("b2PrismaticJoint_GetUpperLimit", JAVA_FLOAT, JOINT_ID_LAYOUT);
		B2_PRISMATIC_JOINT_SET_LIMITS = downcallHandleVoid("b2PrismaticJoint_SetLimits", JOINT_ID_LAYOUT, JAVA_FLOAT, JAVA_FLOAT);
		B2_PRISMATIC_JOINT_ENABLE_MOTOR = downcallHandleVoid("b2PrismaticJoint_EnableMotor", JOINT_ID_LAYOUT, JAVA_BOOLEAN);
		B2_PRISMATIC_JOINT_IS_MOTOR_ENABLED = downcallHandle("b2PrismaticJoint_IsMotorEnabled", JAVA_BOOLEAN, JOINT_ID_LAYOUT);
		B2_PRISMATIC_JOINT_SET_MOTOR_SPEED = downcallHandleVoid("b2PrismaticJoint_SetMotorSpeed", JOINT_ID_LAYOUT, JAVA_FLOAT);
		B2_PRISMATIC_JOINT_GET_MOTOR_SPEED = downcallHandle("b2PrismaticJoint_GetMotorSpeed", JAVA_FLOAT, JOINT_ID_LAYOUT);
		B2_PRISMATIC_JOINT_SET_MAX_MOTOR_FORCE = downcallHandleVoid("b2PrismaticJoint_SetMaxMotorForce", JOINT_ID_LAYOUT, JAVA_FLOAT);
		B2_PRISMATIC_JOINT_GET_MAX_MOTOR_FORCE = downcallHandle("b2PrismaticJoint_GetMaxMotorForce", JAVA_FLOAT, JOINT_ID_LAYOUT);
		B2_PRISMATIC_JOINT_GET_MOTOR_FORCE = downcallHandle("b2PrismaticJoint_GetMotorForce", JAVA_FLOAT, JOINT_ID_LAYOUT);
		B2_PRISMATIC_JOINT_GET_TRANSLATION = downcallHandle("b2PrismaticJoint_GetTranslation", JAVA_FLOAT, JOINT_ID_LAYOUT);
		B2_PRISMATIC_JOINT_GET_SPEED = downcallHandle("b2PrismaticJoint_GetSpeed", JAVA_FLOAT, JOINT_ID_LAYOUT);
		//@formatter:on
	}

	public PrismaticJoint(World world, PrismaticJointDef prismaticJointDef) {
		this(world, prismaticJointDef, Arena.ofAuto());
	}

	/**
	 * Create a prismatic (slider) joint.
	 */
	public PrismaticJoint(World world, PrismaticJointDef prismaticJointDef, Arena arena) {
		MemorySegment b2PrismaticJoint;
		try {
			MemorySegment worldAddr = world.memorySegment();
			MemorySegment defAddr = prismaticJointDef.memorySegment();

			b2PrismaticJoint = (MemorySegment) B2_CREATE_PRISMATIC_JOINT.invoke(arena, worldAddr, defAddr);
		} catch (Throwable e) {
			String className = e.getClass().getSimpleName();
			throw new Box2DRuntimeException("Cannot create distance joint: " + className);
		}
		super(b2PrismaticJoint, world, arena);
	}

	/**
	 * Enable/disable the joint spring.
	 */
	public void enableSpring(boolean enableSpring) {
		try {
			B2_PRISMATIC_JOINT_ENABLE_SPRING.invokeExact(b2JointId, enableSpring);
		} catch (Throwable e) {
			String className = e.getClass().getSimpleName();
			throw new Box2DRuntimeException("Cannot enable/ disable spring: " + className);
		}
	}

	/**
	 * Is the prismatic joint spring enabled or not?
	 */
	public boolean isSpringEnabled() {
		try {
			return (boolean) B2_PRISMATIC_JOINT_IS_SPRING_ENABLED.invokeExact(b2JointId);
		} catch (Throwable e) {
			String className = e.getClass().getSimpleName();
			throw new Box2DRuntimeException("Cannot check if spring is enabled: " + className);
		}
	}

	/**
	 * Set the prismatic joint stiffness in Hertz.
	 */
	public void setSpringHertz(float springHertz) {
		try {
			B2_PRISMATIC_JOINT_SET_SPRING_HERTZ.invokeExact(b2JointId, springHertz);
		} catch (Throwable e) {
			String className = e.getClass().getSimpleName();
			throw new Box2DRuntimeException("Cannot set spring hertz: " + className);
		}
	}

	/**
	 * Set the prismatic joint damping ratio (non-dimensional)
	 */
	public void setSpringDampingRatio(float springDampingRatio) {
		try {
			B2_PRISMATIC_JOINT_SET_SPRING_DAMPING_RATIO.invokeExact(b2JointId, springDampingRatio);
		} catch (Throwable e) {
			String className = e.getClass().getSimpleName();
			throw new Box2DRuntimeException("Cannot set spring damping ratio: " + className);
		}
	}

	/**
	 * Get the prismatic joint stiffness in Hertz.
	 */
	public float getSpringHertz() {
		try {
			return (float) B2_PRISMATIC_JOINT_GET_SPRING_HERTZ.invokeExact(b2JointId);
		} catch (Throwable e) {
			String className = e.getClass().getSimpleName();
			throw new Box2DRuntimeException("Cannot get spring hertz: " + className);
		}
	}

	/**
	 * Get the prismatic spring damping ratio (non-dimensional)
	 */
	public float getSpringDampingRatio() {
		try {
			return (float) B2_PRISMATIC_JOINT_GET_SPRING_DAMPING_RATIO.invokeExact(b2JointId);
		} catch (Throwable e) {
			String className = e.getClass().getSimpleName();
			throw new Box2DRuntimeException("Cannot get spring damping ratio: " + className);
		}
	}

	/**
	 * Enable/disable the prismatic joint limit.
	 */
	public void enableLimit(boolean enableLimit) {
		try {
			B2_PRISMATIC_JOINT_ENABLE_LIMIT.invokeExact(b2JointId, enableLimit);
		} catch (Throwable e) {
			String className = e.getClass().getSimpleName();
			throw new Box2DRuntimeException("Cannot enable/ disable limit: " + className);
		}
	}

	/**
	 * Is the prismatic joint limit enabled?
	 */
	public boolean isLimitEnabled() {
		try {
			return (boolean) B2_PRISMATIC_JOINT_IS_LIMIT_ENABLED.invokeExact(b2JointId);
		} catch (Throwable e) {
			String className = e.getClass().getSimpleName();
			throw new Box2DRuntimeException("Cannot check if limit is enabled: " + className);
		}
	}

	/**
	 * Get the prismatic joint lower limit.
	 */
	public float getLowerLimit() {
		try {
			return (float) B2_PRISMATIC_JOINT_GET_LOWER_LIMIT.invokeExact(b2JointId);
		} catch (Throwable e) {
			String className = e.getClass().getSimpleName();
			throw new Box2DRuntimeException("Cannot get lower limit: " + className);
		}
	}

	/**
	 * Get the prismatic joint upper limit.
	 */
	public float getUpperLimit() {
		try {
			return (float) B2_PRISMATIC_JOINT_GET_UPPER_LIMIT.invokeExact(b2JointId);
		} catch (Throwable e) {
			String className = e.getClass().getSimpleName();
			throw new Box2DRuntimeException("Cannot get upper limit: " + className);
		}
	}

	/**
	 * Set the prismatic joint limits.
	 */
	public void setLimits(float lower, float upper) {
		try {
			B2_PRISMATIC_JOINT_SET_LIMITS.invokeExact(b2JointId, lower, upper);
		} catch (Throwable e) {
			String className = e.getClass().getSimpleName();
			throw new Box2DRuntimeException("Cannot set limits: " + className);
		}
	}

	/**
	 * Enable/disable the prismatic joint motor.
	 */
	public void enableMotor(boolean enableMotor) {
		try {
			B2_PRISMATIC_JOINT_ENABLE_MOTOR.invokeExact(b2JointId, enableMotor);
		} catch (Throwable e) {
			String className = e.getClass().getSimpleName();
			throw new Box2DRuntimeException("Cannot enable/ disable motor: " + className);
		}
	}

	/**
	 * Is the prismatic joint motor enabled?
	 */
	public boolean isMotorEnabled() {
		try {
			return (boolean) B2_PRISMATIC_JOINT_IS_MOTOR_ENABLED.invokeExact(b2JointId);
		} catch (Throwable e) {
			String className = e.getClass().getSimpleName();
			throw new Box2DRuntimeException("Cannot check if motor is enabled: " + className);
		}
	}

	/**
	 * Set the prismatic joint motor speed, usually in meters per second.
	 */
	public void setMotorSpeed(float motorSpeed) {
		try {
			B2_PRISMATIC_JOINT_SET_MOTOR_SPEED.invokeExact(b2JointId, motorSpeed);
		} catch (Throwable e) {
			String className = e.getClass().getSimpleName();
			throw new Box2DRuntimeException("Cannot set motor speed: " + className);
		}
	}

	/**
	 * Get the prismatic joint motor speed, usually in meters per second.
	 */
	public float getMotorSpeed() {
		try {
			return (float) B2_PRISMATIC_JOINT_GET_MOTOR_SPEED.invokeExact(b2JointId);
		} catch (Throwable e) {
			String className = e.getClass().getSimpleName();
			throw new Box2DRuntimeException("Cannot get motor speed: " + className);
		}
	}

	/**
	 * Set the prismatic joint maximum motor force, usually in newtons.
	 */
	public void setMaxMotorForce(float maxMotorForce) {
		try {
			B2_PRISMATIC_JOINT_SET_MAX_MOTOR_FORCE.invoke(b2JointId, maxMotorForce);
		} catch (Throwable e) {
			String className = e.getClass().getSimpleName();
			throw new Box2DRuntimeException("Cannot set max motor force: " + className);
		}
	}

	/**
	 * Get the prismatic joint maximum motor force, usually in newtons.
	 */
	public float getMaxMotorForce() {
		try {
			return (float) B2_PRISMATIC_JOINT_GET_MAX_MOTOR_FORCE.invokeExact(b2JointId);
		} catch (Throwable e) {
			String className = e.getClass().getSimpleName();
			throw new Box2DRuntimeException("Cannot get max motor force: " + className);
		}
	}

	/**
	 * Get the prismatic joint current motor force, usually in newtons.
	 */
	public float getMotorForce() {
		try {
			return (float) B2_PRISMATIC_JOINT_GET_MOTOR_FORCE.invokeExact(b2JointId);
		} catch (Throwable e) {
			String className = e.getClass().getSimpleName();
			throw new Box2DRuntimeException("Cannot get motor force: " + className);
		}
	}

	/**
	 * Get the current joint translation, usually in meters.
	 */
	public float getTranslation() {
		try {
			return (float) B2_PRISMATIC_JOINT_GET_TRANSLATION.invokeExact(b2JointId);
		} catch (Throwable e) {
			String className = e.getClass().getSimpleName();
			throw new Box2DRuntimeException("Cannot get translation: " + className);
		}
	}

	/**
	 * Get the current joint translation speed, usually in meters per second.
	 */
	public float getSpeed() {
		try {
			return (float) B2_PRISMATIC_JOINT_GET_SPEED.invokeExact(b2JointId);
		} catch (Throwable e) {
			String className = e.getClass().getSimpleName();
			throw new Box2DRuntimeException("Cannot get speed: " + className);
		}
	}

}
