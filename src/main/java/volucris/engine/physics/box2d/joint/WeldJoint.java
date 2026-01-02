package volucris.engine.physics.box2d.joint;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.lang.invoke.MethodHandle;

import volucris.engine.physics.box2d.world.World;
import volucris.engine.utils.MathUtils;
import volucris.engine.utils.VolucrisRuntimeException;

import static java.lang.foreign.ValueLayout.*;
import static volucris.engine.utils.FFMUtils.*;

public final class WeldJoint extends Joint {

	private static final MethodHandle B2_CREATE_WELD_JOINT;
	private static final MethodHandle B2_WELD_JOINT_GET_REFERENCE_ANGLE;
	private static final MethodHandle B2_WELD_JOINT_SET_REFERENCE_ANGLE;
	private static final MethodHandle B2_WELD_JOINT_SET_LINEAR_HERTZ;
	private static final MethodHandle B2_WELD_JOINT_GET_LINEAR_HERTZ;
	private static final MethodHandle B2_WELD_JOINT_SET_LINEAR_DAMPING_RATIO;
	private static final MethodHandle B2_WELD_JOINT_GET_LINEAR_DAMPING_RATIO;
	private static final MethodHandle B2_WELD_JOINT_SET_ANGULAR_HERTZ;
	private static final MethodHandle B2_WELD_JOINT_GET_ANGULAR_HERTZ;
	private static final MethodHandle B2_WELD_JOINT_SET_ANGULAR_DAMPING_RATIO;
	private static final MethodHandle B2_WELD_JOINT_GET_ANGULAR_DAMPING_RATIO;

	static {
		//@formatter:off
		B2_CREATE_WELD_JOINT = downcallHandle("b2CreateWeldJoint", JOINT_ID_LAYOUT, World.LAYOUT(), ADDRESS);
		B2_WELD_JOINT_GET_REFERENCE_ANGLE = downcallHandle("b2WeldJoint_GetReferenceAngle", JAVA_FLOAT, JOINT_ID_LAYOUT);
		B2_WELD_JOINT_SET_REFERENCE_ANGLE = downcallHandleVoid("b2WeldJoint_SetReferenceAngle", JOINT_ID_LAYOUT, JAVA_FLOAT);
		B2_WELD_JOINT_SET_LINEAR_HERTZ = downcallHandleVoid("b2WeldJoint_SetLinearHertz", JOINT_ID_LAYOUT, JAVA_FLOAT);
		B2_WELD_JOINT_GET_LINEAR_HERTZ = downcallHandle("b2WeldJoint_GetLinearHertz", JAVA_FLOAT, JOINT_ID_LAYOUT);
		B2_WELD_JOINT_SET_LINEAR_DAMPING_RATIO = downcallHandleVoid("b2WeldJoint_SetLinearDampingRatio", JOINT_ID_LAYOUT, JAVA_FLOAT);
		B2_WELD_JOINT_GET_LINEAR_DAMPING_RATIO = downcallHandle("b2WeldJoint_GetLinearDampingRatio", JAVA_FLOAT, JOINT_ID_LAYOUT);
		B2_WELD_JOINT_SET_ANGULAR_HERTZ = downcallHandleVoid("b2WeldJoint_SetAngularHertz", JOINT_ID_LAYOUT, JAVA_FLOAT);
		B2_WELD_JOINT_GET_ANGULAR_HERTZ = downcallHandle("b2WeldJoint_GetAngularHertz", JAVA_FLOAT, JOINT_ID_LAYOUT);
		B2_WELD_JOINT_SET_ANGULAR_DAMPING_RATIO = downcallHandleVoid("b2WeldJoint_SetAngularDampingRatio", JOINT_ID_LAYOUT, JAVA_FLOAT);
		B2_WELD_JOINT_GET_ANGULAR_DAMPING_RATIO = downcallHandle("b2WeldJoint_GetAngularDampingRatio", JAVA_FLOAT, JOINT_ID_LAYOUT);
		//@formatter:on
	}

	public WeldJoint(World world, WeldJointDef weldJointDef) {
		this(world, weldJointDef, Arena.ofAuto());
	}
	
	/**
	 * Create the weld joint.
	 */
	public WeldJoint(World world, WeldJointDef weldJointDef, Arena arena) {
		MemorySegment b2WeldJoint;
		try {
			MemorySegment worldAddr = world.memorySegment();
			MemorySegment defAddr = weldJointDef.memorySegment();

			b2WeldJoint = (MemorySegment) B2_CREATE_WELD_JOINT.invoke(arena, worldAddr, defAddr);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot create weld joint.");
		}
		super(b2WeldJoint, world, arena);
	}

	/**
	 * Get the weld joint reference angle in radians.
	 */
	public float getReferenceAngleRadians() {
		try {
			return (float) B2_WELD_JOINT_GET_REFERENCE_ANGLE.invokeExact(b2JointId);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot get reference angle.");
		}
	}

	/**
	 * Get the weld joint reference angle in degrees.
	 */
	public float getReferenceAngle() {
		return MathUtils.toDegrees(getReferenceAngleRadians());
	}

	/**
	 * Set the weld joint reference angle in radians, must be in [-pi,pi].
	 */
	public void setReferenceAngleRadians(float angleInRadians) {
		try {
			B2_WELD_JOINT_SET_REFERENCE_ANGLE.invokeExact(b2JointId, angleInRadians);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot set reference angle.");
		}
	}

	/**
	 * Set the weld joint reference angle in radians, must be in [-180,180].
	 */
	public void setReferenceAngle(float angleInDegrees) {
		setReferenceAngleRadians(MathUtils.toRadians(angleInDegrees));
	}

	/**
	 * Set the weld joint linear stiffness in Hertz. 0 is rigid.
	 */
	public void setLinearHertz(float hertz) {
		try {
			B2_WELD_JOINT_SET_LINEAR_HERTZ.invokeExact(b2JointId, hertz);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot set linear hertz.");
		}
	}

	/**
	 * Get the weld joint linear stiffness in Hertz.
	 */
	public float getLinearHertz() {
		try {
			return (float) B2_WELD_JOINT_GET_LINEAR_HERTZ.invokeExact(b2JointId);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot get linear hertz.");
		}
	}

	/**
	 * Set the weld joint linear damping ratio (non-dimensional)
	 */
	public void setLinearDampingRatio(float dampingRatio) {
		try {
			B2_WELD_JOINT_SET_LINEAR_DAMPING_RATIO.invokeExact(b2JointId, dampingRatio);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot set linear damping ratio.");
		}
	}

	/**
	 * Get the weld joint linear damping ratio (non-dimensional)
	 */
	public float getLinearDampingRatio() {
		try {
			return (float) B2_WELD_JOINT_GET_LINEAR_DAMPING_RATIO.invokeExact(b2JointId);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot get linear damping ratio.");
		}
	}

	/**
	 * Set the weld joint angular stiffness in Hertz. 0 is rigid.
	 */
	public void setAngularHertz(float hertz) {
		try {
			B2_WELD_JOINT_SET_ANGULAR_HERTZ.invokeExact(b2JointId, hertz);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot set angular hertz.");
		}
	}

	/**
	 * Get the weld joint angular stiffness in Hertz.
	 */
	public float getAngularHertz() {
		try {
			return (float) B2_WELD_JOINT_GET_ANGULAR_HERTZ.invokeExact(b2JointId);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot get angular hertz.");
		}
	}

	/**
	 * Set weld joint angular damping ratio, non-dimensional.
	 */
	public void setAngularDampingRatio(float dampingRatio) {
		try {
			B2_WELD_JOINT_SET_ANGULAR_DAMPING_RATIO.invokeExact(b2JointId, dampingRatio);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot set angular damping ratio.");
		}
	}

	/**
	 * Get the weld joint angular damping ratio, non-dimensional.
	 */
	public float getAngularDampingRatio() {
		try {
			return (float) B2_WELD_JOINT_GET_ANGULAR_DAMPING_RATIO.invokeExact(b2JointId);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot get angular damping ratio.");
		}
	}

}
