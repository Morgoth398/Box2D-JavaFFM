package volucris.engine.physics.box2d.joint;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.SegmentAllocator;
import java.lang.invoke.MethodHandle;

import org.joml.Vector2f;

import volucris.engine.physics.box2d.math.Vec2;
import volucris.engine.physics.box2d.world.World;
import volucris.engine.utils.VolucrisRuntimeException;

import static java.lang.foreign.ValueLayout.*;
import static volucris.engine.utils.FFMUtils.*;

public final class MouseJoint extends Joint {

	private static final MethodHandle B2_CREATE_MOUSE_JOINT;
	private static final MethodHandle B2_MOUSE_JOINT_SET_TARGET;
	private static final MethodHandle B2_MOUSE_JOINT_GET_TARGET;
	private static final MethodHandle B2_MOUSE_JOINT_SET_SPRING_HERTZ;
	private static final MethodHandle B2_MOUSE_JOINT_GET_SPRING_HERTZ;
	private static final MethodHandle B2_MOUSE_JOINT_SET_SPRING_DAMPING_RATIO;
	private static final MethodHandle B2_MOUSE_JOINT_GET_SPRING_DAMPING_RATIO;
	private static final MethodHandle B2_MOUSE_JOINT_SET_MAX_FORCE;
	private static final MethodHandle B2_MOUSE_JOINT_GET_MAX_FORCE;

	static {
		//@formatter:off
		B2_CREATE_MOUSE_JOINT = downcallHandle("b2CreateMouseJoint", World.LAYOUT(), ADDRESS);
		B2_MOUSE_JOINT_SET_TARGET = downcallHandleVoid("b2MouseJoint_SetTarget", JOINT_ID_LAYOUT, Vec2.LAYOUT());
		B2_MOUSE_JOINT_GET_TARGET = downcallHandle("b2MouseJoint_GetTarget", Vec2.LAYOUT(), JOINT_ID_LAYOUT);
		B2_MOUSE_JOINT_SET_SPRING_HERTZ = downcallHandleVoid("b2MouseJoint_SetSpringHertz", JOINT_ID_LAYOUT, JAVA_FLOAT);
		B2_MOUSE_JOINT_GET_SPRING_HERTZ = downcallHandle("b2MouseJoint_GetSpringHertz", JAVA_FLOAT, JOINT_ID_LAYOUT);
		B2_MOUSE_JOINT_SET_SPRING_DAMPING_RATIO = downcallHandleVoid("b2MouseJoint_SetSpringDampingRatio", JOINT_ID_LAYOUT, JAVA_FLOAT);
		B2_MOUSE_JOINT_GET_SPRING_DAMPING_RATIO = downcallHandle("b2MouseJoint_GetSpringDampingRatio", JAVA_FLOAT, JOINT_ID_LAYOUT);
		B2_MOUSE_JOINT_SET_MAX_FORCE = downcallHandleVoid("b2MouseJoint_SetMaxForce", JOINT_ID_LAYOUT, JAVA_FLOAT);
		B2_MOUSE_JOINT_GET_MAX_FORCE = downcallHandle("b2MouseJoint_GetMaxForce", JAVA_FLOAT, JOINT_ID_LAYOUT);
		//@formatter:on
	}

	/**
	 * Create the mouse joint.
	 */
	public MouseJoint(World world, MouseJointDef mouseJointDef) {
		MemorySegment b2MouseJoint;
		try {
			SegmentAllocator allocator = Arena.ofAuto();

			MemorySegment worldAddr = world.memorySegment();
			MemorySegment defAddr = mouseJointDef.memorySegment();

			b2MouseJoint = (MemorySegment) B2_CREATE_MOUSE_JOINT.invokeExact(allocator, worldAddr, defAddr);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot create mouse joint.");
		}
		super(b2MouseJoint, world);
	}

	/**
	 * Set the mouse joint target.
	 */
	public void setTarget(Vector2f target) {
		try {
			vecTmp.set(target);
			B2_MOUSE_JOINT_SET_TARGET.invokeExact(b2JointId, vecTmp.memorySegment());
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot set target.");
		}
	}

	/**
	 * Get the mouse joint target.
	 */
	public Vector2f getTarget(Vector2f target) {
		try (Arena arena = Arena.ofConfined()) {
			SegmentAllocator allocator = arena;
			MemorySegment segment = (MemorySegment) B2_MOUSE_JOINT_GET_TARGET.invokeExact(allocator, b2JointId);
			vecTmp.set(segment);
			return vecTmp.get(target);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot get target.");
		}
	}

	/**
	 * Get the mouse joint target.
	 */
	public Vector2f getTarget() {
		return getTarget(new Vector2f());
	}

	/**
	 * Set the mouse joint spring stiffness in Hertz.
	 */
	public void setSpringHertz(float springHertz) {
		try {
			B2_MOUSE_JOINT_SET_SPRING_HERTZ.invokeExact(b2JointId, springHertz);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot set spring hertz.");
		}
	}

	/**
	 * Get the mouse joint spring stiffness in Hertz.
	 */
	public float getSpringHertz() {
		try {
			return (float) B2_MOUSE_JOINT_GET_SPRING_HERTZ.invokeExact(b2JointId);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot get spring hertz.");
		}
	}

	/**
	 * Set the mouse joint spring damping ratio, non-dimensional.
	 */
	public void setSpringDampingRatio(float dampingRatio) {
		try {
			B2_MOUSE_JOINT_SET_SPRING_DAMPING_RATIO.invokeExact(b2JointId, dampingRatio);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot set spring damping ratio.");
		}
	}

	/**
	 * Get the mouse joint damping ratio, non-dimensional.
	 */
	public float getSpringDampingRatio() {
		try {
			return (float) B2_MOUSE_JOINT_GET_SPRING_DAMPING_RATIO.invokeExact(b2JointId);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot get spring damping ratio.");
		}
	}

	/**
	 * Set the mouse joint maximum force, usually in newtons.
	 */
	public void setMaxForce(float maxForce) {
		try {
			B2_MOUSE_JOINT_SET_MAX_FORCE.invokeExact(b2JointId, maxForce);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot set max force.");
		}
	}

	/**
	 * Get the mouse joint maximum force, usually in newtons.
	 */
	public float getMaxForce() {
		try {
			return (float) B2_MOUSE_JOINT_GET_MAX_FORCE.invokeExact(b2JointId);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot get max force.");
		}
	}

}
