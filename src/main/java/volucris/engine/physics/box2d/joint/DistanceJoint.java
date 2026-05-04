package volucris.engine.physics.box2d.joint;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.SegmentAllocator;
import java.lang.invoke.MethodHandle;

import volucris.engine.physics.box2d.world.World;
import volucris.engine.utils.VolucrisRuntimeException;

import static java.lang.foreign.ValueLayout.*;
import static volucris.engine.utils.FFMUtils.*;

public final class DistanceJoint extends Joint {

	private static final MethodHandle B2_CREATE_DISTANCE_JOINT;
	private static final MethodHandle B2_DISTANCE_JOINT_SET_LENGTH;
	private static final MethodHandle B2_DISTANCE_JOINT_GET_LENGTH;
	private static final MethodHandle B2_DISTANCE_JOINT_ENABLE_SPRING;
	private static final MethodHandle B2_DISTANCE_JOINT_IS_SPRING_ENABLED;
	private static final MethodHandle B2_DISTANCE_JOINT_SET_SPRING_HERTZ;
	private static final MethodHandle B2_DISTANCE_JOINT_SET_SPRING_DAMPING_RATIO;
	private static final MethodHandle B2_DISTANCE_JOINT_GET_SPRING_HERTZ;
	private static final MethodHandle B2_DISTANCE_JOINT_GET_SPRING_DAMPING_RATIO;
	private static final MethodHandle B2_DISTANCE_JOINT_ENABLE_LIMIT;
	private static final MethodHandle B2_DISTANCE_JOINT_IS_LIMIT_ENABLED;
	private static final MethodHandle B2_DISTANCE_JOINT_SET_LENGTH_RANGE;
	private static final MethodHandle B2_DISTANCE_JOINT_GET_MIN_LENGTH;
	private static final MethodHandle B2_DISTANCE_JOINT_GET_MAX_LENGTH;
	private static final MethodHandle B2_DISTANCE_JOINT_GET_CURRENT_LENGTH;
	private static final MethodHandle B2_DISTANCE_JOINT_ENABLE_MOTOR;
	private static final MethodHandle B2_DISTANCE_JOINT_IS_MOTOR_ENABLED;
	private static final MethodHandle B2_DISTANCE_JOINT_SET_MOTOR_SPEED;
	private static final MethodHandle B2_DISTANCE_JOINT_GET_MOTOR_SPEED;
	private static final MethodHandle B2_DISTANCE_JOINT_SET_MAX_MOTOR_FORCE;
	private static final MethodHandle B2_DISTANCE_JOINT_GET_MAX_MOTOR_FORCE;
	private static final MethodHandle B2_DISTANCE_JOINT_GET_MOTOR_FORCE;

	static {
		//@formatter:off
		B2_CREATE_DISTANCE_JOINT = downcallHandle("b2CreateDistanceJoint", JOINT_ID_LAYOUT, World.LAYOUT(), ADDRESS);
		B2_DISTANCE_JOINT_SET_LENGTH = downcallHandleVoid("b2DistanceJoint_SetLength", JOINT_ID_LAYOUT, JAVA_FLOAT);
		B2_DISTANCE_JOINT_GET_LENGTH = downcallHandle("b2DistanceJoint_GetLength", JAVA_FLOAT, JOINT_ID_LAYOUT);
		B2_DISTANCE_JOINT_ENABLE_SPRING = downcallHandleVoid("b2DistanceJoint_EnableSpring", JOINT_ID_LAYOUT, JAVA_BOOLEAN);
		B2_DISTANCE_JOINT_IS_SPRING_ENABLED = downcallHandle("b2DistanceJoint_IsSpringEnabled", JAVA_BOOLEAN, JOINT_ID_LAYOUT);
		B2_DISTANCE_JOINT_SET_SPRING_HERTZ = downcallHandleVoid("b2DistanceJoint_SetSpringHertz", JOINT_ID_LAYOUT, JAVA_FLOAT);
		B2_DISTANCE_JOINT_SET_SPRING_DAMPING_RATIO = downcallHandleVoid("b2DistanceJoint_SetSpringDampingRatio", JOINT_ID_LAYOUT, JAVA_FLOAT);
		B2_DISTANCE_JOINT_GET_SPRING_HERTZ = downcallHandle("b2DistanceJoint_GetSpringHertz", JAVA_FLOAT, JOINT_ID_LAYOUT);
		B2_DISTANCE_JOINT_GET_SPRING_DAMPING_RATIO = downcallHandle("b2DistanceJoint_GetSpringDampingRatio", JAVA_FLOAT, JOINT_ID_LAYOUT);
		B2_DISTANCE_JOINT_ENABLE_LIMIT =  downcallHandleVoid("b2DistanceJoint_EnableLimit", JOINT_ID_LAYOUT, JAVA_BOOLEAN);
		B2_DISTANCE_JOINT_IS_LIMIT_ENABLED = downcallHandle("b2DistanceJoint_IsLimitEnabled", JAVA_BOOLEAN, JOINT_ID_LAYOUT);
		B2_DISTANCE_JOINT_SET_LENGTH_RANGE = downcallHandleVoid("b2DistanceJoint_SetLengthRange", JOINT_ID_LAYOUT, JAVA_FLOAT, JAVA_FLOAT);
		B2_DISTANCE_JOINT_GET_MIN_LENGTH = downcallHandle("b2DistanceJoint_GetMinLength", JAVA_FLOAT, JOINT_ID_LAYOUT);
		B2_DISTANCE_JOINT_GET_MAX_LENGTH = downcallHandle("b2DistanceJoint_GetMaxLength", JAVA_FLOAT, JOINT_ID_LAYOUT);
		B2_DISTANCE_JOINT_GET_CURRENT_LENGTH = downcallHandle("b2DistanceJoint_GetCurrentLength", JAVA_FLOAT, JOINT_ID_LAYOUT);
		B2_DISTANCE_JOINT_ENABLE_MOTOR = downcallHandleVoid("b2DistanceJoint_EnableMotor", JOINT_ID_LAYOUT, JAVA_BOOLEAN);
		B2_DISTANCE_JOINT_IS_MOTOR_ENABLED = downcallHandle("b2DistanceJoint_IsMotorEnabled", JAVA_BOOLEAN, JOINT_ID_LAYOUT);
		B2_DISTANCE_JOINT_SET_MOTOR_SPEED = downcallHandleVoid("b2DistanceJoint_SetMotorSpeed", JOINT_ID_LAYOUT, JAVA_FLOAT);
		B2_DISTANCE_JOINT_GET_MOTOR_SPEED = downcallHandle("b2DistanceJoint_GetMotorSpeed", JAVA_FLOAT, JOINT_ID_LAYOUT);
		B2_DISTANCE_JOINT_SET_MAX_MOTOR_FORCE = downcallHandleVoid("b2DistanceJoint_SetMaxMotorForce", JOINT_ID_LAYOUT, JAVA_FLOAT);
		B2_DISTANCE_JOINT_GET_MAX_MOTOR_FORCE = downcallHandle("b2DistanceJoint_GetMaxMotorForce", JAVA_FLOAT, JOINT_ID_LAYOUT);
		B2_DISTANCE_JOINT_GET_MOTOR_FORCE = downcallHandle("b2DistanceJoint_GetMotorForce", JAVA_FLOAT, JOINT_ID_LAYOUT);
		//@formatter:on
	}

	/**
	 * Create the distance joint.
	 */
	public DistanceJoint(World world, DistanceJointDef distanceJointDef) {
		MemorySegment b2DistanceJoint;
		try {
			SegmentAllocator allocator = Arena.ofAuto();

			MemorySegment worldAddr = world.memorySegment();
			MemorySegment defAddr = distanceJointDef.memorySegment();

			b2DistanceJoint = (MemorySegment) B2_CREATE_DISTANCE_JOINT.invokeExact(allocator, worldAddr, defAddr);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot create distance joint.");
		}
		super(b2DistanceJoint, world);
	}

	/**
	 * Set the rest length of the distance joint.
	 */
	public void setLength(float length) {
		try {
			B2_DISTANCE_JOINT_SET_LENGTH.invokeExact(b2JointId, length);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot set length.");
		}
	}

	/**
	 * Get the rest length of the distance joint.
	 */
	public float getLength() {
		try {
			return (float) B2_DISTANCE_JOINT_GET_LENGTH.invokeExact(b2JointId);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot get length.");
		}
	}

	/**
	 * Enable/disable the distance joint spring. When disabled the distance joint is
	 * rigid.
	 */
	public void enableSpring(boolean enableSpring) {
		try {
			B2_DISTANCE_JOINT_ENABLE_SPRING.invokeExact(b2JointId, enableSpring);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot enable/ disable spring.");
		}
	}

	/**
	 * Is the distance joint spring enabled?
	 */
	public boolean isSpringEnabled() {
		try {
			return (boolean) B2_DISTANCE_JOINT_IS_SPRING_ENABLED.invokeExact(b2JointId);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot check if spring is enabled.");
		}
	}

	/**
	 * Set the spring stiffness in Hertz.
	 */
	public void setSpringHertz(float springHertz) {
		try {
			B2_DISTANCE_JOINT_SET_SPRING_HERTZ.invokeExact(b2JointId, springHertz);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot set spring hertz.");
		}
	}

	/**
	 * Set the spring damping ratio, non-dimensional.
	 */
	public void setSpringDampingRatio(float springDampingRatio) {
		try {
			B2_DISTANCE_JOINT_SET_SPRING_DAMPING_RATIO.invokeExact(b2JointId, springDampingRatio);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot set spring damping ratio.");
		}
	}

	/**
	 * Get the spring Hertz.
	 */
	public float getSpringHertz() {
		try {
			return (float) B2_DISTANCE_JOINT_GET_SPRING_HERTZ.invokeExact(b2JointId);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot get spring hertz.");
		}
	}

	/**
	 * Get the spring damping ratio.
	 */
	public float getSpringDampingRatio() {
		try {
			return (float) B2_DISTANCE_JOINT_GET_SPRING_DAMPING_RATIO.invokeExact(b2JointId);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot get spring damping ratio.");
		}
	}

	/**
	 * Enable joint limit.
	 */
	public void enableLimit(boolean enableLimit) {
		try {
			B2_DISTANCE_JOINT_ENABLE_LIMIT.invokeExact(b2JointId, enableLimit);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot enable/ disable limit.");
		}
	}

	/**
	 * Is the distance joint limit enabled?
	 */
	public boolean isLimitEnabled() {
		try {
			return (boolean) B2_DISTANCE_JOINT_IS_LIMIT_ENABLED.invokeExact(b2JointId);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot check if limit is enabled.");
		}
	}

	/**
	 * Set the minimum and maximum length parameters of the distance joint.
	 */
	public void setLengthRange(float minLength, float maxLength) {
		try {
			B2_DISTANCE_JOINT_SET_LENGTH_RANGE.invokeExact(b2JointId, minLength, maxLength);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot set length range.");
		}
	}

	/**
	 * Get the distance joint minimum length.
	 */
	public float getMinLength() {
		try {
			return (float) B2_DISTANCE_JOINT_GET_MIN_LENGTH.invokeExact(b2JointId);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot get min length.");
		}
	}

	/**
	 * Get the distance joint maximum length.
	 */
	public float getMaxLength() {
		try {
			return (float) B2_DISTANCE_JOINT_GET_MAX_LENGTH.invokeExact(b2JointId);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot get max length.");
		}
	}

	/**
	 * Get the current length of the distance joint.
	 */
	public float getCurrentLength() {
		try {
			return (float) B2_DISTANCE_JOINT_GET_CURRENT_LENGTH.invokeExact(b2JointId);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot get current length.");
		}
	}

	/**
	 * Enable/disable the distance joint motor.
	 */
	public void enableMotor(boolean enableMotor) {
		try {
			B2_DISTANCE_JOINT_ENABLE_MOTOR.invokeExact(b2JointId, enableMotor);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot enable/ disable motor.");
		}
	}

	/**
	 * Is the distance joint motor enabled?
	 */
	public boolean isMotorEnabled() {
		try {
			return (boolean) B2_DISTANCE_JOINT_IS_MOTOR_ENABLED.invokeExact(b2JointId);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot check if motor is enabled.");
		}
	}

	/**
	 * Set the distance joint motor speed, usually in meters per second
	 */
	public void setMotorSpeed(float motorSpeed) {
		try {
			B2_DISTANCE_JOINT_SET_MOTOR_SPEED.invokeExact(b2JointId, motorSpeed);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot set motor speed.");
		}
	}

	/**
	 * Get the distance joint motor speed, usually in meters per second.
	 */
	public float getMotorSpeed() {
		try {
			return (float) B2_DISTANCE_JOINT_GET_MOTOR_SPEED.invokeExact(b2JointId);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot get motor speed.");
		}
	}

	/**
	 * Set the distance joint maximum motor force, usually in newtons.
	 */
	public void setMaxMotorForce(float maxMotorForce) {
		try {
			B2_DISTANCE_JOINT_SET_MAX_MOTOR_FORCE.invoke(b2JointId, maxMotorForce);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot set max motor force.");
		}
	}

	/**
	 * Get the distance joint maximum motor force, usually in newtons.
	 */
	public float getMaxMotorForce() {
		try {
			return (float) B2_DISTANCE_JOINT_GET_MAX_MOTOR_FORCE.invokeExact(b2JointId);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot get max motor force.");
		}
	}

	/**
	 * Get the distance joint current motor force, usually in newtons.
	 */
	public float getMotorForce() {
		try {
			return (float) B2_DISTANCE_JOINT_GET_MOTOR_FORCE.invokeExact(b2JointId);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot get motor force.");
		}
	}

}
