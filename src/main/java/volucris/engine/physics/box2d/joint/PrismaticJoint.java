package volucris.engine.physics.box2d.joint;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.SegmentAllocator;
import java.lang.invoke.MethodHandle;

import volucris.engine.physics.box2d.world.World;
import volucris.engine.utils.VolucrisRuntimeException;

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

	/**
	 * Create a prismatic (slider) joint.
	 */
	public PrismaticJoint(World world, PrismaticJointDef prismaticJointDef) {
		MemorySegment b2PrismaticJoint;
		try {
			SegmentAllocator allocator = Arena.ofAuto();

			MemorySegment worldAddr = world.memorySegment();
			MemorySegment defAddr = prismaticJointDef.memorySegment();

			b2PrismaticJoint = (MemorySegment) B2_CREATE_PRISMATIC_JOINT.invokeExact(allocator, worldAddr, defAddr);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot create distance joint.");
		}
		super(b2PrismaticJoint, world);
	}

	/**
	 * Enable/disable the joint spring.
	 */
	public void enableSpring(boolean enableSpring) {
		try {
			B2_PRISMATIC_JOINT_ENABLE_SPRING.invokeExact(b2JointId, enableSpring);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot enable/ disable spring.");
		}
	}

	/**
	 * Is the prismatic joint spring enabled or not?
	 */
	public boolean isSpringEnabled() {
		try {
			return (boolean) B2_PRISMATIC_JOINT_IS_SPRING_ENABLED.invokeExact(b2JointId);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot check if spring is enabled.");
		}
	}

	/**
	 * Set the prismatic joint stiffness in Hertz.
	 */
	public void setSpringHertz(float springHertz) {
		try {
			B2_PRISMATIC_JOINT_SET_SPRING_HERTZ.invokeExact(b2JointId, springHertz);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot set spring hertz.");
		}
	}

	/**
	 * Set the prismatic joint damping ratio (non-dimensional)
	 */
	public void setSpringDampingRatio(float springDampingRatio) {
		try {
			B2_PRISMATIC_JOINT_SET_SPRING_DAMPING_RATIO.invokeExact(b2JointId, springDampingRatio);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot set spring damping ratio.");
		}
	}

	/**
	 * Get the prismatic joint stiffness in Hertz.
	 */
	public float getSpringHertz() {
		try {
			return (float) B2_PRISMATIC_JOINT_GET_SPRING_HERTZ.invokeExact(b2JointId);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot get spring hertz.");
		}
	}

	/**
	 * Get the prismatic spring damping ratio (non-dimensional)
	 */
	public float getSpringDampingRatio() {
		try {
			return (float) B2_PRISMATIC_JOINT_GET_SPRING_DAMPING_RATIO.invokeExact(b2JointId);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot get spring damping ratio.");
		}
	}

	/**
	 * Enable/disable the prismatic joint limit.
	 */
	public void enableLimit(boolean enableLimit) {
		try {
			B2_PRISMATIC_JOINT_ENABLE_LIMIT.invokeExact(b2JointId, enableLimit);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot enable/ disable limit.");
		}
	}

	/**
	 * Is the prismatic joint limit enabled?
	 */
	public boolean isLimitEnabled() {
		try {
			return (boolean) B2_PRISMATIC_JOINT_IS_LIMIT_ENABLED.invokeExact(b2JointId);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot check if limit is enabled.");
		}
	}

	/**
	 * Get the prismatic joint lower limit.
	 */
	public float getLowerLimit() {
		try {
			return (float) B2_PRISMATIC_JOINT_GET_LOWER_LIMIT.invokeExact(b2JointId);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot get lower limit.");
		}
	}

	/**
	 * Get the prismatic joint upper limit.
	 */
	public float getUpperLimit() {
		try {
			return (float) B2_PRISMATIC_JOINT_GET_UPPER_LIMIT.invokeExact(b2JointId);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot get upper limit.");
		}
	}

	/**
	 * Set the prismatic joint limits.
	 */
	public void setLimits(float lower, float upper) {
		try {
			B2_PRISMATIC_JOINT_SET_LIMITS.invokeExact(b2JointId, lower, upper);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot set limits.");
		}
	}

	/**
	 * Enable/disable the prismatic joint motor.
	 */
	public void enableMotor(boolean enableMotor) {
		try {
			B2_PRISMATIC_JOINT_ENABLE_MOTOR.invokeExact(b2JointId, enableMotor);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot enable/ disable motor.");
		}
	}

	/**
	 * Is the prismatic joint motor enabled?
	 */
	public boolean isMotorEnabled() {
		try {
			return (boolean) B2_PRISMATIC_JOINT_IS_MOTOR_ENABLED.invokeExact(b2JointId);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot check if motor is enabled.");
		}
	}

	/**
	 * Set the prismatic joint motor speed, usually in meters per second.
	 */
	public void setMotorSpeed(float motorSpeed) {
		try {
			B2_PRISMATIC_JOINT_SET_MOTOR_SPEED.invokeExact(b2JointId, motorSpeed);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot set motor speed.");
		}
	}

	/**
	 * Get the prismatic joint motor speed, usually in meters per second.
	 */
	public float getMotorSpeed() {
		try {
			return (float) B2_PRISMATIC_JOINT_GET_MOTOR_SPEED.invokeExact(b2JointId);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot get motor speed.");
		}
	}

	/**
	 * Set the prismatic joint maximum motor force, usually in newtons.
	 */
	public void setMaxMotorForce(float maxMotorForce) {
		try {
			B2_PRISMATIC_JOINT_SET_MAX_MOTOR_FORCE.invoke(b2JointId, maxMotorForce);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot set max motor force.");
		}
	}

	/**
	 * Get the prismatic joint maximum motor force, usually in newtons.
	 */
	public float getMaxMotorForce() {
		try {
			return (float) B2_PRISMATIC_JOINT_GET_MAX_MOTOR_FORCE.invokeExact(b2JointId);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot get max motor force.");
		}
	}

	/**
	 * Get the prismatic joint current motor force, usually in newtons.
	 */
	public float getMotorForce() {
		try {
			return (float) B2_PRISMATIC_JOINT_GET_MOTOR_FORCE.invokeExact(b2JointId);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot get motor force.");
		}
	}

	/**
	 * Get the current joint translation, usually in meters.
	 */
	public float getTranslation() {
		try {
			return (float) B2_PRISMATIC_JOINT_GET_TRANSLATION.invokeExact(b2JointId);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot get translation.");
		}
	}

	/**
	 * Get the current joint translation speed, usually in meters per second.
	 */
	public float getSpeed() {
		try {
			return (float) B2_PRISMATIC_JOINT_GET_SPEED.invokeExact(b2JointId);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot get speed.");
		}
	}

}
