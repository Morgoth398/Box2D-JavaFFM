package volucris.engine.physics.box2d.joint;

import java.lang.foreign.Arena;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.StructLayout;
import java.lang.foreign.MemoryLayout.PathElement;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;

import org.joml.Vector2f;

import volucris.engine.physics.box2d.Box2D;
import volucris.engine.physics.box2d.body.Body;
import volucris.engine.physics.box2d.math.Vec2;
import volucris.engine.physics.box2d.utils.Box2DRuntimeException;
import volucris.engine.physics.box2d.world.World;
import volucris.engine.physics.box2d.world.World.WorldId;

import static java.lang.foreign.ValueLayout.*;
import static volucris.engine.physics.box2d.utils.FFMUtils.*;

/**
 * Joints allow you to connect rigid bodies together while allowing various
 * forms of relative motions.
 */
public sealed class Joint permits DistanceJoint, MotorJoint, MouseJoint, FilterJoint, PrismaticJoint, RevoluteJoint,
		WeldJoint, WheelJoint {

	protected static final StructLayout JOINT_ID_LAYOUT;

	private static final VarHandle INDEX_1;
	private static final VarHandle WORLD_0;
	private static final VarHandle GENERATION;

	private static final MethodHandle B2_DESTROY_JOINT;
	private static final MethodHandle B2_JOINT_IS_VALID;
	private static final MethodHandle B2_JOINT_GET_TYPE;
	private static final MethodHandle B2_JOINT_GET_BODY_A;
	private static final MethodHandle B2_JOINT_GET_BODY_B;
	private static final MethodHandle B2_JOINT_GET_WORLD;
	private static final MethodHandle B2_JOINT_GET_LOCAL_ANCHOR_A;
	private static final MethodHandle B2_JOINT_GET_LOCAL_ANCHOR_B;
	private static final MethodHandle B2_JOINT_SET_COLLIDE_CONNECTED;
	private static final MethodHandle B2_JOINT_GET_COLLIDE_CONNECTED;
	private static final MethodHandle B2_JOINT_WAKE_BODIES;
	private static final MethodHandle B2_JOINT_GET_CONSTRAINT_FORCE;
	private static final MethodHandle B2_JOINT_GET_CONSTRAINT_TORQUE;

	protected final MemorySegment b2JointId;

	protected Vec2 vecTmp;

	static {
		//@formatter:off
		JOINT_ID_LAYOUT = MemoryLayout.structLayout(
				JAVA_INT.withName("index1"),
				JAVA_SHORT.withName("world0"),
				JAVA_SHORT.withName("generation")
			).withName("b2JointId");

		INDEX_1 = JOINT_ID_LAYOUT.varHandle(PathElement.groupElement("index1"));
		WORLD_0 = JOINT_ID_LAYOUT.varHandle(PathElement.groupElement("world0"));
		GENERATION = JOINT_ID_LAYOUT.varHandle(PathElement.groupElement("generation"));

		B2_DESTROY_JOINT = downcallHandleVoid("b2DestroyJoint", JOINT_ID_LAYOUT);
		B2_JOINT_IS_VALID = downcallHandle("b2Joint_IsValid", JAVA_BOOLEAN, JOINT_ID_LAYOUT);
		B2_JOINT_GET_TYPE = downcallHandle("b2Joint_GetType", JAVA_INT, JOINT_ID_LAYOUT);
		B2_JOINT_GET_BODY_A = downcallHandle("b2Joint_GetBodyA", Body.LAYOUT(), JOINT_ID_LAYOUT);
		B2_JOINT_GET_BODY_B = downcallHandle("b2Joint_GetBodyB", Body.LAYOUT(), JOINT_ID_LAYOUT);
		B2_JOINT_GET_WORLD = downcallHandle("b2Joint_GetWorld", World.LAYOUT(), JOINT_ID_LAYOUT);
		B2_JOINT_GET_LOCAL_ANCHOR_A = downcallHandle("b2Joint_GetLocalAnchorA", Vec2.LAYOUT(), JOINT_ID_LAYOUT);
		B2_JOINT_GET_LOCAL_ANCHOR_B = downcallHandle("b2Joint_GetLocalAnchorB", Vec2.LAYOUT(), JOINT_ID_LAYOUT);
		B2_JOINT_SET_COLLIDE_CONNECTED = downcallHandleVoid("b2Joint_SetCollideConnected", JOINT_ID_LAYOUT, JAVA_BOOLEAN);
		B2_JOINT_GET_COLLIDE_CONNECTED = downcallHandle("b2Joint_GetCollideConnected", JAVA_BOOLEAN, JOINT_ID_LAYOUT);
		B2_JOINT_WAKE_BODIES = downcallHandleVoid("b2Joint_WakeBodies", JOINT_ID_LAYOUT);
		B2_JOINT_GET_CONSTRAINT_FORCE = downcallHandle("b2Joint_GetConstraintForce", Vec2.LAYOUT(), JOINT_ID_LAYOUT);
		B2_JOINT_GET_CONSTRAINT_TORQUE = downcallHandle("b2Joint_GetConstraintTorque", JAVA_FLOAT, JOINT_ID_LAYOUT);
		//@formatter:on
	}

	public Joint(MemorySegment segment, long offset, WorldId worldId) {
		this(segment, Arena.ofAuto(), offset, worldId);
	}
	
	public Joint(MemorySegment segment, Arena arena, long offset, WorldId worldId) {
		b2JointId = arena.allocate(JOINT_ID_LAYOUT);
		MemorySegment.copy(segment, offset, b2JointId, 0, JOINT_ID_LAYOUT.byteSize());

		vecTmp = new Vec2(arena);

		Box2D.addJoint(this, getJointId(b2JointId), worldId);
	}

	public Joint(MemorySegment segment, World world, Arena arena) {
		b2JointId = segment;
		
		vecTmp = new Vec2(arena);

		Box2D.addJoint(this, getJointId(b2JointId), world.getWorldId());
	}
	
	/**
	 * Destroy the joint.
	 */
	public void destroyJoint() {
		Box2D.removeJoint(getJointId(b2JointId), getWorld().getWorldId());

		try {
			B2_DESTROY_JOINT.invokeExact(b2JointId);
		} catch (Throwable e) {
			String className = e.getClass().getSimpleName();
			throw new Box2DRuntimeException("Cannot destroy joint: " + className);
		}
	}

	/**
	 * Joint identifier validation. Provides validation for up to 64K allocations.
	 */
	public final boolean isValid() {
		try {
			return (boolean) B2_JOINT_IS_VALID.invokeExact(b2JointId);
		} catch (Throwable e) {
			String className = e.getClass().getSimpleName();
			throw new Box2DRuntimeException("Cannot validate joint: " + className);
		}
	}

	/**
	 * Get the joint type.
	 */
	public final JointType getType() {
		try {
			int type = (int) B2_JOINT_GET_TYPE.invokeExact(b2JointId);
			switch (type) {
			case 0:
				return JointType.DISTANCE_JOINT;
			case 1:
				return JointType.FILTER_JOINT;
			case 2:
				return JointType.MOTOR_JOINT;
			case 3:
				return JointType.MOUSE_JOINT;
			case 4:
				return JointType.PRISMATIC_JOINT;
			case 5:
				return JointType.REVOLUTE_JOINT;
			case 6:
				return JointType.WELD_JOINT;
			default:
				return JointType.WHEEL_JOINT;
			}
		} catch (Throwable e) {
			String className = e.getClass().getSimpleName();
			throw new Box2DRuntimeException(": " + className);
		}
	}

	/**
	 * Get body A id on the joint.
	 */
	public final Body getBodyA() {
		try (Arena arena = Arena.ofConfined()) {
			MemorySegment segment = (MemorySegment) B2_JOINT_GET_BODY_A.invoke(arena, b2JointId);
			WorldId worldId = getWorld().getWorldId();
			
			Body body = Box2D.getBody(Body.getBodyId(segment), worldId);
			
			if (body != null)
				return body;

			return new Body(segment, 0, worldId);
		} catch (Throwable e) {
			String className = e.getClass().getSimpleName();
			throw new Box2DRuntimeException("Cannot get body A: " + className);
		}
	}

	/**
	 * Get body B id on the joint.
	 */
	public final Body getBodyB() {
		try (Arena arena = Arena.ofConfined()) {
			MemorySegment segment = (MemorySegment) B2_JOINT_GET_BODY_B.invoke(arena, b2JointId);
			WorldId worldId = getWorld().getWorldId();
			
			Body body = Box2D.getBody(Body.getBodyId(segment), worldId);
			
			if (body != null)
				return body;

			return new Body(segment, 0, worldId);
		} catch (Throwable e) {
			String className = e.getClass().getSimpleName();
			throw new Box2DRuntimeException("Cannot get body B: " + className);
		}
	}

	/**
	 * Get the world that owns this joint.
	 */
	public final World getWorld() {
		try (Arena arena = Arena.ofConfined()) {
			MethodHandle method = B2_JOINT_GET_WORLD;
			MemorySegment b2WorldId = (MemorySegment) method.invoke(arena, b2JointId);
			
			World world = Box2D.getWorld(World.getWorldId(b2WorldId));
			
			if (world != null)
				return world;
			
			return new World(b2WorldId, 0L);
		} catch (Throwable e) {
			String className = e.getClass().getSimpleName();
			throw new Box2DRuntimeException("Cannot get world: " + className);
		}
	}

	/**
	 * Get the local anchor on bodyA.
	 */
	public final Vector2f getLocalAnchorA(Vector2f target) {
		try (Arena arena = Arena.ofConfined()) {
			MemorySegment segment = (MemorySegment) B2_JOINT_GET_LOCAL_ANCHOR_A.invoke(arena, b2JointId);
			vecTmp.set(segment);
			return vecTmp.get(target);
		} catch (Throwable e) {
			String className = e.getClass().getSimpleName();
			throw new Box2DRuntimeException("Cannot get local anchor A: " + className);
		}
	}

	/**
	 * Get the local anchor on bodyA.
	 */
	public final Vector2f getLocalAnchorA() {
		return getLocalAnchorA(new Vector2f());
	}

	/**
	 * Get the local anchor on bodyB.
	 */
	public final Vector2f getLocalAnchorB(Vector2f target) {
		try (Arena arena = Arena.ofConfined()) {
			MemorySegment segment = (MemorySegment) B2_JOINT_GET_LOCAL_ANCHOR_B.invoke(arena, b2JointId);
			vecTmp.set(segment);
			return vecTmp.get(target);
		} catch (Throwable e) {
			String className = e.getClass().getSimpleName();
			throw new Box2DRuntimeException("Cannot get local anchor B: " + className);
		}
	}

	/**
	 * Get the local anchor on bodyB.
	 */
	public final Vector2f getLocalAnchorB() {
		return getLocalAnchorB(new Vector2f());
	}

	/**
	 * Toggle collision between connected bodies.
	 */
	public final void setCollideConnected(boolean shouldCollide) {
		try {
			B2_JOINT_SET_COLLIDE_CONNECTED.invokeExact(b2JointId, shouldCollide);
		} catch (Throwable e) {
			String className = e.getClass().getSimpleName();
			throw new Box2DRuntimeException("Cannot set collide connected: " + className);
		}
	}

	/**
	 * Is collision allowed between connected bodies?
	 */
	public final boolean getCollideConnected() {
		try {
			return (boolean) B2_JOINT_GET_COLLIDE_CONNECTED.invokeExact(b2JointId);
		} catch (Throwable e) {
			String className = e.getClass().getSimpleName();
			throw new Box2DRuntimeException("Cannot get collide connected: " + className);
		}
	}

	/**
	 * Set the internal user data for the body.
	 */
	public void setInternalUserData(Object internalUserData) {
		Box2D.setInternalUserData(getJointId(b2JointId), getWorld().getWorldId(), internalUserData);
	}

	/**
	 * Get the internal user data stored in the body.
	 */
	public Object getInternalUserData() {
		return Box2D.getInternalUserData(getJointId(b2JointId), getWorld().getWorldId());
	}

	/**
	 * Set the user data for the body.
	 * <p>
	 * The implementation does not pass this object to the native code.
	 */
	public void setUserData(Object userData) {
		Box2D.setUserData(getJointId(b2JointId), getWorld().getWorldId(), userData);
	}

	/**
	 * Get the user data stored in the body.
	 */
	public Object getUserData() {
		return Box2D.getUserData(getJointId(b2JointId), getWorld().getWorldId());
	}

	/**
	 * Wake the bodies connect to this joint.
	 */
	public final void wakeBodies() {
		try {
			B2_JOINT_WAKE_BODIES.invokeExact(b2JointId);
		} catch (Throwable e) {
			String className = e.getClass().getSimpleName();
			throw new Box2DRuntimeException("Cannot wake bodies: " + className);
		}
	}

	/**
	 * Get the current constraint force for this joint. Usually in Newtons.
	 */
	public final Vector2f getConstraintForce(Vector2f target) {
		try (Arena arena = Arena.ofConfined()) {
			MemorySegment segment = (MemorySegment) B2_JOINT_GET_CONSTRAINT_FORCE.invoke(arena, b2JointId);
			vecTmp.set(segment);
			return vecTmp.get(target);
		} catch (Throwable e) {
			String className = e.getClass().getSimpleName();
			throw new Box2DRuntimeException("Cannot get constraint force: " + className);
		}
	}

	/**
	 * Get the current constraint force for this joint. Usually in Newtons.
	 */
	public final Vector2f getConstraintForce() {
		return getConstraintForce(new Vector2f());
	}

	/**
	 * Get the current constraint torque for this joint. Usually in Newton * meters.
	 */
	public final float getConstraintTorque() {
		try {
			return (float) B2_JOINT_GET_CONSTRAINT_TORQUE.invokeExact(b2JointId);
		} catch (Throwable e) {
			String className = e.getClass().getSimpleName();
			throw new Box2DRuntimeException("Cannot get constraint torque: " + className);
		}
	}

	public final MemorySegment memorySegment() {
		return b2JointId;
	}

	public static StructLayout LAYOUT() {
		return JOINT_ID_LAYOUT;
	}

	public static JointId getJointId(MemorySegment memorySegment) {
		return getJointId(memorySegment, 0L);
	}

	public static JointId getJointId(MemorySegment memorySegment, long offset) {
		int index1 = (int) INDEX_1.get(memorySegment, offset);
		short world0 = (short) WORLD_0.get(memorySegment, offset);
		short generation = (short) GENERATION.get(memorySegment, offset);
		return new JointId(index1, world0, generation);
	}

	public static record JointId(int index1, short world0, short generation) {
	};
}
