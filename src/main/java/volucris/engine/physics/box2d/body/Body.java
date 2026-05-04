package volucris.engine.physics.box2d.body;

import java.lang.foreign.AddressLayout;
import java.lang.foreign.Arena;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.StructLayout;
import java.lang.foreign.MemoryLayout.PathElement;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;

import org.joml.Vector2f;

import volucris.engine.physics.box2d.Box2D;
import volucris.engine.physics.box2d.contactEvents.ContactData;
import volucris.engine.physics.box2d.geometry.MassData;
import volucris.engine.physics.box2d.joint.Joint;
import volucris.engine.physics.box2d.math.AABB;
import volucris.engine.physics.box2d.math.Rot;
import volucris.engine.physics.box2d.math.Transform;
import volucris.engine.physics.box2d.math.Vec2;
import volucris.engine.physics.box2d.shape.Shape;
import volucris.engine.physics.box2d.world.World;
import volucris.engine.utils.MathUtils;
import volucris.engine.utils.VolucrisRuntimeException;

import static java.lang.foreign.ValueLayout.*;
import static volucris.engine.utils.FFMUtils.*;

public final class Body {

	private static final StructLayout BODY_ID_LAYOUT;

	private static final VarHandle INDEX_1;
	private static final VarHandle WORLD_0;
	private static final VarHandle GENERATION;

	private static final MethodHandle B2_CREATE_BODY;
	private static final MethodHandle B2_DESTROY_BODY;
	private static final MethodHandle B2_BODY_IS_VALID;
	private static final MethodHandle B2_BODY_GET_TYPE;
	private static final MethodHandle B2_BODY_SET_TYPE;
	private static final MethodHandle B2_BODY_SET_NAME;
	private static final MethodHandle B2_BODY_GET_NAME;
	private static final MethodHandle B2_BODY_GET_POSITION;
	private static final MethodHandle B2_BODY_GET_ROTATION;
	private static final MethodHandle B2_BODY_GET_TRANSFORM;
	private static final MethodHandle B2_BODY_SET_TRANSFORM;
	private static final MethodHandle B2_BODY_GET_LOCAL_POINT;
	private static final MethodHandle B2_BODY_GET_WORLD_POINT;
	private static final MethodHandle B2_BODY_GET_LOCAL_VECTOR;
	private static final MethodHandle B2_BODY_GET_WORLD_VECTOR;
	private static final MethodHandle B2_BODY_GET_LINEAR_VELOCITY;
	private static final MethodHandle B2_BODY_GET_ANGULAR_VELOCITY;
	private static final MethodHandle B2_BODY_SET_LINEAR_VELOCITY;
	private static final MethodHandle B2_BODY_SET_ANGULAR_VELOCITY;
	private static final MethodHandle B2_BODY_SET_TARGET_TRANSFORM;
	private static final MethodHandle B2_BODY_GET_LOCAL_POINT_VELOCITY;
	private static final MethodHandle B2_BODY_GET_WORLD_POINT_VELOCITY;
	private static final MethodHandle B2_BODY_APPLY_FORCE;
	private static final MethodHandle B2_BODY_APPLY_FORCE_TO_CENTER;
	private static final MethodHandle B2_BODY_APPLY_TORQUE;
	private static final MethodHandle B2_BODY_APPLY_LINEAR_IMPULSE;
	private static final MethodHandle B2_BODY_APPLY_LINEAR_IMPULSE_TO_CENTER;
	private static final MethodHandle B2_BODY_APPLY_ANGULAR_IMPULSE;
	private static final MethodHandle B2_BODY_GET_MASS;
	private static final MethodHandle B2_BODY_GET_ROTATION_INERTIA;
	private static final MethodHandle B2_BODY_GET_LOCAL_CENTER_OF_MASS;
	private static final MethodHandle B2_BODY_GET_WORLD_CENTER_OF_MASS;
	private static final MethodHandle B2_BODY_SET_MASS_DATA;
	private static final MethodHandle B2_BODY_GET_MASS_DATA;
	private static final MethodHandle B2_BODY_APPLY_MASS_FROM_SHAPES;
	private static final MethodHandle B2_BODY_SET_LINEAR_DAMPING;
	private static final MethodHandle B2_BODY_GET_LINEAR_DAMPING;
	private static final MethodHandle B2_BODY_SET_ANGULAR_DAMPING;
	private static final MethodHandle B2_BODY_GET_ANGULAR_DAMPING;
	private static final MethodHandle B2_BODY_SET_GRAVITY_SCALE;
	private static final MethodHandle B2_BODY_GET_GRAVITY_SCALE;
	private static final MethodHandle B2_BODY_IS_AWAKE;
	private static final MethodHandle B2_BODY_SET_AWAKE;
	private static final MethodHandle B2_BODY_ENABLE_SLEEP;
	private static final MethodHandle B2_BODY_IS_SLEEP_ENABLED;
	private static final MethodHandle B2_BODY_SET_SLEEP_THRESHOLD;
	private static final MethodHandle B2_BODY_GET_SLEEP_THRESHOLD;
	private static final MethodHandle B2_BODY_IS_ENABLED;
	private static final MethodHandle B2_BODY_DISABLE;
	private static final MethodHandle B2_BODY_ENABLE;
	private static final MethodHandle B2_BODY_SET_FIXED_ROTATION;
	private static final MethodHandle B2_BODY_IS_FIXED_ROTATION;
	private static final MethodHandle B2_BODY_SET_BULLET;
	private static final MethodHandle B2_BODY_IS_BULLET;
	private static final MethodHandle B2_BODY_ENABLE_CONTACT_EVENTS;
	private static final MethodHandle B2_BODY_ENABLE_HIT_EVENTS;
	private static final MethodHandle B2_BODY_GET_SHAPE_COUNT;
	private static final MethodHandle B2_BODY_GET_SHAPES;
	private static final MethodHandle B2_BODY_GET_JOINT_COUNT;
	private static final MethodHandle B2_BODY_GET_JOINTS;
	private static final MethodHandle B2_BODY_GET_CONTACT_CAPACITY;
	private static final MethodHandle B2_BODY_GET_CONTACT_DATA;
	private static final MethodHandle B2_BODY_COMPUTE_AABB;

	private final MemorySegment b2BodyId;

	private World world;

	private Object internalUserData;
	private Object userData;

	private Vec2 vecTmp;
	private Vec2 vecTmp2;
	private Rot rotTmp;

	static {
		//@formatter:off
		AddressLayout UNBOUNDED_ADDRESS = ADDRESS.withTargetLayout(MemoryLayout.sequenceLayout(Long.MAX_VALUE, JAVA_BYTE));
		
		BODY_ID_LAYOUT = MemoryLayout.structLayout(
					JAVA_INT.withName("index1"),
					JAVA_SHORT.withName("world0"),
					JAVA_SHORT.withName("generation")
				).withName("b2BodyId");

		INDEX_1 = BODY_ID_LAYOUT.varHandle(PathElement.groupElement("index1"));
		WORLD_0 = BODY_ID_LAYOUT.varHandle(PathElement.groupElement("world0"));
		GENERATION = BODY_ID_LAYOUT.varHandle(PathElement.groupElement("generation"));
		
		B2_CREATE_BODY = downcallHandle("b2CreateBody", BODY_ID_LAYOUT, World.LAYOUT(), ADDRESS);
		B2_DESTROY_BODY = downcallHandleVoid("b2DestroyBody", BODY_ID_LAYOUT);
		B2_BODY_IS_VALID = downcallHandle("b2Body_IsValid", JAVA_BOOLEAN, BODY_ID_LAYOUT);
		B2_BODY_GET_TYPE = downcallHandle("b2Body_GetType", JAVA_INT, BODY_ID_LAYOUT);
		B2_BODY_SET_TYPE = downcallHandleVoid("b2Body_SetType", BODY_ID_LAYOUT, JAVA_INT);
		B2_BODY_SET_NAME = downcallHandleVoid("b2Body_SetName", BODY_ID_LAYOUT, ADDRESS);
		B2_BODY_GET_NAME = downcallHandle("b2Body_GetName", UNBOUNDED_ADDRESS, BODY_ID_LAYOUT);
		B2_BODY_GET_POSITION = downcallHandle("b2Body_GetPosition", Vec2.LAYOUT(), BODY_ID_LAYOUT);
		B2_BODY_GET_ROTATION = downcallHandle("b2Body_GetRotation", Rot.LAYOUT(), BODY_ID_LAYOUT);
		B2_BODY_GET_TRANSFORM = downcallHandle("b2Body_GetTransform", Transform.LAYOUT(), BODY_ID_LAYOUT);
		B2_BODY_SET_TRANSFORM = downcallHandleVoid("b2Body_SetTransform", BODY_ID_LAYOUT, Vec2.LAYOUT(), Rot.LAYOUT());
		B2_BODY_GET_LOCAL_POINT = downcallHandle("b2Body_GetLocalPoint", Vec2.LAYOUT(), BODY_ID_LAYOUT, Vec2.LAYOUT());
		B2_BODY_GET_WORLD_POINT = downcallHandle("b2Body_GetWorldPoint", Vec2.LAYOUT(), BODY_ID_LAYOUT, Vec2.LAYOUT());
		B2_BODY_GET_LOCAL_VECTOR = downcallHandle("b2Body_GetLocalVector", Vec2.LAYOUT(), BODY_ID_LAYOUT, Vec2.LAYOUT());
		B2_BODY_GET_WORLD_VECTOR = downcallHandle("b2Body_GetWorldVector", Vec2.LAYOUT(), BODY_ID_LAYOUT, Vec2.LAYOUT());
		B2_BODY_GET_LINEAR_VELOCITY = downcallHandle("b2Body_GetLinearVelocity", Vec2.LAYOUT(), BODY_ID_LAYOUT);
		B2_BODY_GET_ANGULAR_VELOCITY = downcallHandle("b2Body_GetAngularVelocity", JAVA_FLOAT, BODY_ID_LAYOUT);
		B2_BODY_SET_LINEAR_VELOCITY = downcallHandleVoid("b2Body_SetLinearVelocity", BODY_ID_LAYOUT, Vec2.LAYOUT());
		B2_BODY_SET_ANGULAR_VELOCITY = downcallHandleVoid("b2Body_SetAngularVelocity", BODY_ID_LAYOUT, JAVA_FLOAT);
		B2_BODY_SET_TARGET_TRANSFORM = downcallHandleVoid("b2Body_SetTargetTransform", BODY_ID_LAYOUT, Transform.LAYOUT(), JAVA_FLOAT);
		B2_BODY_GET_LOCAL_POINT_VELOCITY = downcallHandle("b2Body_GetLocalPointVelocity", Vec2.LAYOUT(), BODY_ID_LAYOUT, Vec2.LAYOUT());
		B2_BODY_GET_WORLD_POINT_VELOCITY = downcallHandle("b2Body_GetWorldPointVelocity", Vec2.LAYOUT(), BODY_ID_LAYOUT, Vec2.LAYOUT());
		B2_BODY_APPLY_FORCE = downcallHandleVoid("b2Body_ApplyForce", BODY_ID_LAYOUT, Vec2.LAYOUT(), Vec2.LAYOUT(), JAVA_BOOLEAN);
		B2_BODY_APPLY_FORCE_TO_CENTER = downcallHandleVoid("b2Body_ApplyForceToCenter", BODY_ID_LAYOUT, Vec2.LAYOUT(), JAVA_BOOLEAN);
		B2_BODY_APPLY_TORQUE = downcallHandleVoid("b2Body_ApplyTorque", BODY_ID_LAYOUT, JAVA_FLOAT, JAVA_BOOLEAN);
		B2_BODY_APPLY_LINEAR_IMPULSE = downcallHandleVoid("b2Body_ApplyLinearImpulse", BODY_ID_LAYOUT, Vec2.LAYOUT(), Vec2.LAYOUT(), JAVA_BOOLEAN);
		B2_BODY_APPLY_LINEAR_IMPULSE_TO_CENTER = downcallHandleVoid("b2Body_ApplyLinearImpulseToCenter", BODY_ID_LAYOUT, Vec2.LAYOUT(), JAVA_BOOLEAN);
		B2_BODY_APPLY_ANGULAR_IMPULSE = downcallHandleVoid("b2Body_ApplyAngularImpulse", BODY_ID_LAYOUT, JAVA_FLOAT, JAVA_BOOLEAN);
		B2_BODY_GET_MASS = downcallHandle("b2Body_GetMass", JAVA_FLOAT, BODY_ID_LAYOUT);
		B2_BODY_GET_ROTATION_INERTIA = downcallHandle("b2Body_GetRotationalInertia", JAVA_FLOAT, BODY_ID_LAYOUT);
		B2_BODY_GET_LOCAL_CENTER_OF_MASS = downcallHandle("b2Body_GetLocalCenterOfMass", Vec2.LAYOUT(), BODY_ID_LAYOUT);
		B2_BODY_GET_WORLD_CENTER_OF_MASS = downcallHandle("b2Body_GetWorldCenterOfMass", Vec2.LAYOUT(), BODY_ID_LAYOUT);
		B2_BODY_SET_MASS_DATA = downcallHandleVoid("b2Body_SetMassData", BODY_ID_LAYOUT, MassData.LAYOUT());
		B2_BODY_GET_MASS_DATA = downcallHandle("b2Body_GetMassData", MassData.LAYOUT(), BODY_ID_LAYOUT);
		B2_BODY_APPLY_MASS_FROM_SHAPES = downcallHandleVoid("b2Body_ApplyMassFromShapes", BODY_ID_LAYOUT);
		B2_BODY_SET_LINEAR_DAMPING = downcallHandleVoid("b2Body_SetLinearDamping", BODY_ID_LAYOUT, JAVA_FLOAT);
		B2_BODY_GET_LINEAR_DAMPING = downcallHandle("b2Body_GetLinearDamping", JAVA_FLOAT, BODY_ID_LAYOUT);
		B2_BODY_SET_ANGULAR_DAMPING = downcallHandleVoid("b2Body_SetAngularDamping", BODY_ID_LAYOUT, JAVA_FLOAT);
		B2_BODY_GET_ANGULAR_DAMPING = downcallHandle("b2Body_GetAngularDamping", JAVA_FLOAT, BODY_ID_LAYOUT);
		B2_BODY_SET_GRAVITY_SCALE = downcallHandleVoid("b2Body_SetGravityScale", BODY_ID_LAYOUT, JAVA_FLOAT);
		B2_BODY_GET_GRAVITY_SCALE = downcallHandle("b2Body_GetGravityScale", JAVA_FLOAT, BODY_ID_LAYOUT);
		B2_BODY_IS_AWAKE = downcallHandle("b2Body_IsAwake", JAVA_BOOLEAN, BODY_ID_LAYOUT);
		B2_BODY_SET_AWAKE = downcallHandleVoid("b2Body_SetAwake", BODY_ID_LAYOUT, JAVA_BOOLEAN);
		B2_BODY_ENABLE_SLEEP = downcallHandleVoid("b2Body_EnableSleep", BODY_ID_LAYOUT, JAVA_BOOLEAN);
		B2_BODY_IS_SLEEP_ENABLED = downcallHandle("b2Body_IsSleepEnabled", JAVA_BOOLEAN, BODY_ID_LAYOUT);
		B2_BODY_SET_SLEEP_THRESHOLD = downcallHandleVoid("b2Body_SetSleepThreshold", BODY_ID_LAYOUT, JAVA_FLOAT);
		B2_BODY_GET_SLEEP_THRESHOLD = downcallHandle("b2Body_GetSleepThreshold", JAVA_FLOAT, BODY_ID_LAYOUT);
		B2_BODY_IS_ENABLED = downcallHandle("b2Body_IsEnabled", JAVA_BOOLEAN, BODY_ID_LAYOUT);
		B2_BODY_DISABLE = downcallHandleVoid("b2Body_Disable", BODY_ID_LAYOUT);
		B2_BODY_ENABLE = downcallHandleVoid("b2Body_Enable", BODY_ID_LAYOUT);
		B2_BODY_SET_FIXED_ROTATION = downcallHandleVoid("b2Body_SetFixedRotation", BODY_ID_LAYOUT, JAVA_BOOLEAN);
		B2_BODY_IS_FIXED_ROTATION = downcallHandle("b2Body_IsFixedRotation", JAVA_BOOLEAN, BODY_ID_LAYOUT);
		B2_BODY_SET_BULLET = downcallHandleVoid("b2Body_SetBullet", BODY_ID_LAYOUT, JAVA_BOOLEAN);
		B2_BODY_IS_BULLET = downcallHandle("b2Body_IsBullet", JAVA_BOOLEAN, BODY_ID_LAYOUT);
		B2_BODY_ENABLE_CONTACT_EVENTS = downcallHandleVoid("b2Body_EnableContactEvents", BODY_ID_LAYOUT, JAVA_BOOLEAN);
		B2_BODY_ENABLE_HIT_EVENTS = downcallHandleVoid("b2Body_EnableHitEvents", BODY_ID_LAYOUT, JAVA_BOOLEAN);
		B2_BODY_GET_SHAPE_COUNT = downcallHandle("b2Body_GetShapeCount", JAVA_INT, BODY_ID_LAYOUT);
		B2_BODY_GET_SHAPES = downcallHandle("b2Body_GetShapes", JAVA_INT, BODY_ID_LAYOUT, ADDRESS, JAVA_INT);
		B2_BODY_GET_JOINT_COUNT = downcallHandle("b2Body_GetJointCount", JAVA_INT, BODY_ID_LAYOUT);
		B2_BODY_GET_JOINTS = downcallHandle("b2Body_GetJoints", JAVA_INT, BODY_ID_LAYOUT, ADDRESS, JAVA_INT);
		B2_BODY_GET_CONTACT_CAPACITY = downcallHandle("b2Body_GetContactCapacity", JAVA_INT, BODY_ID_LAYOUT);
		B2_BODY_GET_CONTACT_DATA = downcallHandle("b2Body_GetContactData", JAVA_INT, BODY_ID_LAYOUT, ADDRESS, JAVA_INT);
		B2_BODY_COMPUTE_AABB = downcallHandle("b2Body_ComputeAABB", AABB.LAYOUT(), BODY_ID_LAYOUT);
		//@formatter:on
	}

	/**
	 * Create a rigid body given a definition.
	 */
	public Body(World world, BodyDef bodyDef) {
		this(world, bodyDef, Arena.ofAuto());
	}

	/**
	 * Create a rigid body given a definition.
	 */
	public Body(World world, BodyDef bodyDef, Arena arena) {
		try {
			MemorySegment worldSegment = world.memorySegment();
			MemorySegment bodyDefSegment = bodyDef.memorySegment();
			b2BodyId = (MemorySegment) B2_CREATE_BODY.invoke(arena, worldSegment, bodyDefSegment);

			vecTmp = new Vec2(arena);
			vecTmp2 = new Vec2(arena);
			rotTmp = new Rot(arena);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot create body.");
		}

		this.world = world;

		Box2D.addBody(this, getBodyId(b2BodyId), world);
	}

	/**
	 * Create a rigid body with the default definition.
	 */
	public Body(World world) {
		this(world, new BodyDef());
	}

	/**
	 * Create a rigid body given with the default definition.
	 */
	public Body(World world, Arena arena) {
		this(world, new BodyDef(arena), arena);
	}

	public Body(MemorySegment segment, long offset, World world) {
		Arena arena = Arena.ofAuto();
		
		b2BodyId = arena.allocate(BODY_ID_LAYOUT);
		MemorySegment.copy(segment, offset, b2BodyId, 0, BODY_ID_LAYOUT.byteSize());
		
		vecTmp = new Vec2(arena);
		vecTmp2 = new Vec2(arena);
		rotTmp = new Rot(arena);
		
		this.world = world;

		Box2D.addBody(this, getBodyId(b2BodyId), world);
	}
	
	/**
	 * Destroy the rigid body..
	 * <p>
	 * This destroys all shapes and joints attached to the body. Do not keep
	 * references to the associated shapes and joints.
	 */
	public void destroyBody() {
		Box2D.removeBody(getBodyId(b2BodyId), world);

		try {
			B2_DESTROY_BODY.invokeExact(b2BodyId);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot destroy body.");
		}
	}

	/**
	 * Body identifier validation. Can be used to detect orphaned ids. Provides
	 * validation for up to 64K allocations.
	 */
	public boolean isValid() {
		try {
			return (boolean) B2_BODY_IS_VALID.invokeExact(b2BodyId);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot validate body.");
		}
	}

	/**
	 * Get the body type: static, kinematic, or dynamic.
	 */
	public BodyType getType() {
		try {
			int type = (int) B2_BODY_GET_TYPE.invokeExact(b2BodyId);

			if (type == 0)
				return BodyType.STATIC_BODY;
			else if (type == 1)
				return BodyType.KINEMATIC_BODY;
			else
				return BodyType.DYNAMIC_BODY;
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot get body type.");
		}
	}

	/**
	 * Change the body type.
	 */
	public void setType(BodyType type) {
		try {
			B2_BODY_SET_TYPE.invokeExact(b2BodyId, type.id());
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot set body type.");
		}
	}

	/**
	 * Set the body name. Up to 31 characters excluding 0 termination.
	 */
	public void setName(String name) {
		try (Arena arena = Arena.ofConfined()) {
			B2_BODY_SET_NAME.invokeExact(b2BodyId, arena.allocateFrom(name));
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot set body name.");
		}
	}

	/**
	 * Get the body name. May be null.
	 */
	public String getName() {
		try {
			MemorySegment segment = (MemorySegment) B2_BODY_GET_NAME.invokeExact(b2BodyId);
			return segment.getString(0);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot get body name.");
		}
	}

	/**
	 * Set the internal user data for the body.
	 */
	public void setInternalUserData(Object internalUserData) {
		this.internalUserData = internalUserData;
	}

	/**
	 * Get the internal user data stored in the body.
	 */
	public Object getInternalUserData() {
		return internalUserData;
	}

	/**
	 * Set the user data for the body.
	 * <p>
	 * The implementation does not pass this object to the native code.
	 */
	public void setUserData(Object userData) {
		this.userData = userData;
	}

	/**
	 * Get the user data stored in the body.
	 */
	public Object getUserData() {
		return userData;
	}

	/**
	 * Get the world position of the body. This is the location of the body origin.
	 */
	public Vector2f getPosition(Vector2f target) {
		try (Arena arena = Arena.ofConfined()) {
			MemorySegment segment = (MemorySegment) B2_BODY_GET_POSITION.invoke(arena, b2BodyId);
			vecTmp.set(segment);
			return vecTmp.get(target);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot get body position.");
		}
	}

	/**
	 * Get the world position of the body. This is the location of the body origin.
	 */
	public Vector2f getPosition() {
		return getPosition(new Vector2f());
	}

	/**
	 * Get the world rotation of the body in radians.
	 */
	public float getRotation() {
		try (Arena arena = Arena.ofConfined()) {
			MemorySegment segment = (MemorySegment) B2_BODY_GET_ROTATION.invoke(arena, b2BodyId);
			rotTmp.set(segment);
			return rotTmp.getAngleRadians();
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot get body rotation.");
		}
	}

	/**
	 * Get the world transform of the body.
	 */
	public Transform getTransform() {
		return getTransform(new Transform());
	}

	/**
	 * Get the world transform of the body.
	 */
	public Transform getTransform(Transform target) {
		try (Arena arena = Arena.ofConfined()) {
			MemorySegment segment = (MemorySegment) B2_BODY_GET_TRANSFORM.invoke(arena, b2BodyId);
			target.set(segment);
			return target;
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot get body transform.");
		}
	}

	/**
	 * Set the world transform of the body.
	 */
	public void setTransform(Vector2f position, float rotation) {
		setTransform(position.x, position.y, rotation);
	}

	/**
	 * Set the world transform of the body.
	 */
	public void setTransform(float x, float y, float rotation) {
		setTransformRadians(x, y, MathUtils.toRadians(rotation));
	}

	/**
	 * Set the world transform of the body.
	 */
	public void setTransformRadians(Vector2f position, float rotation) {
		setTransformRadians(position.x, position.y, rotation);
	}

	/**
	 * Set the world transform of the body.
	 */
	public void setTransformRadians(float x, float y, float rotation) {
		try {
			rotTmp.setAngleRadians(rotation);
			vecTmp.set(x, y);
			B2_BODY_SET_TRANSFORM.invokeExact(b2BodyId, vecTmp.memorySegment(), rotTmp.memorySegment());
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot set body transform.");
		}
	}

	/**
	 * Get a local point on the body given a world point
	 */
	public Vector2f getLocalPoint(Vector2f target, Vector2f worldPoint) {
		try (Arena arena = Arena.ofConfined()) {
			vecTmp.set(worldPoint);

			MethodHandle method = B2_BODY_GET_LOCAL_POINT;
			MemorySegment segment = (MemorySegment) method.invoke(arena, b2BodyId, vecTmp.memorySegment());

			vecTmp.set(segment);
			return vecTmp.get(target);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot get local point.");
		}
	}

	/**
	 * Get a local point on the body given a world point
	 */
	public Vector2f getLocalPoint(Vector2f worldPoint) {
		return getLocalPoint(new Vector2f(), worldPoint);
	}

	/**
	 * Get a world point on the body given a local point.
	 */
	public Vector2f getWorldPoint(Vector2f target, Vector2f localPoint) {
		try (Arena arena = Arena.ofConfined()) {
			vecTmp.set(localPoint);

			MethodHandle method = B2_BODY_GET_WORLD_POINT;
			MemorySegment segment = (MemorySegment) method.invoke(arena, b2BodyId, vecTmp.memorySegment());

			vecTmp.set(segment);
			return vecTmp.get(target);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot get world point.");
		}
	}

	/**
	 * Get a world point on the body given a local point.
	 */
	public Vector2f getWorldPoint(Vector2f worldPoint) {
		return getWorldPoint(new Vector2f(), worldPoint);
	}

	/**
	 * Get a local vector on the body given a world vector.
	 */
	public Vector2f getLocalVector(Vector2f target, Vector2f worldVector) {
		try (Arena arena = Arena.ofConfined()) {
			vecTmp.set(worldVector);

			MethodHandle method = B2_BODY_GET_LOCAL_VECTOR;
			MemorySegment segment = (MemorySegment) method.invoke(arena, b2BodyId, vecTmp.memorySegment());

			vecTmp.set(segment);
			return vecTmp.get(target);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot get local vector.");
		}
	}

	/**
	 * Get a local vector on the body given a world vector.
	 */
	public Vector2f getLocalVector(Vector2f worldVector) {
		return getLocalVector(new Vector2f(), worldVector);
	}

	/**
	 * Get a world vector on the body given a local vector.
	 */
	public Vector2f getWorldVector(Vector2f target, Vector2f localVector) {
		try (Arena arena = Arena.ofConfined()) {
			vecTmp.set(localVector);

			MethodHandle method = B2_BODY_GET_WORLD_VECTOR;
			MemorySegment segment = (MemorySegment) method.invoke(arena, b2BodyId, vecTmp.memorySegment());

			vecTmp.set(segment);
			return vecTmp.get(target);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot get world vector.");
		}
	}

	/**
	 * Get a world vector on the body given a local vector.
	 */
	public Vector2f getWorldVector(Vector2f localVector) {
		return getLocalVector(new Vector2f(), localVector);
	}

	/**
	 * Get the linear velocity of the body's center of mass. Usually in meters per
	 * second.
	 */
	public Vector2f getLinearVelocity(Vector2f target) {
		try (Arena arena = Arena.ofConfined()) {
			MemorySegment segment = (MemorySegment) B2_BODY_GET_LINEAR_VELOCITY.invoke(arena, b2BodyId);
			vecTmp.set(segment);
			return vecTmp.get(target);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot get linear velocity.");
		}
	}

	/**
	 * Get the linear velocity of the body's center of mass. Usually in meters per
	 * second.
	 */
	public Vector2f getLinearVelocity() {
		return getLinearVelocity(new Vector2f());
	}

	/**
	 * Get the angular velocity of the body in radians per second.
	 */
	public float getAngularVelocity() {
		try {
			return (float) B2_BODY_GET_ANGULAR_VELOCITY.invokeExact(b2BodyId);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot get angular velocity.");
		}
	}

	/**
	 * Set the linear velocity of the body. Usually in meters per second.
	 */
	public void setLinearVelocity(Vector2f linearVelocity) {
		try {
			vecTmp.set(linearVelocity);
			B2_BODY_SET_LINEAR_VELOCITY.invokeExact(b2BodyId, vecTmp.memorySegment());
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot set linear velocity.");
		}
	}

	/**
	 * Set the angular velocity of the body in radians per second.
	 */
	public void setAngularVelocity(float angularVelocity) {
		try {
			B2_BODY_SET_ANGULAR_VELOCITY.invokeExact(b2BodyId, angularVelocity);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot set angular velocity.");
		}
	}

	/**
	 * Set the velocity to reach the given transform after a given time step.
	 */
	public void setTargetTransformRadians(Transform transform, float timeStep) {
		try {
			B2_BODY_SET_TARGET_TRANSFORM.invokeExact(b2BodyId, transform.memorySegment(), timeStep);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot set target transform.");
		}
	}

	/**
	 * Set the velocity to reach the given transform after a given time step.
	 */
	public void setTargetTransform(Vector2f position, float rotation, float timeStep) {
		setTargetTransform(position, MathUtils.toRadians(rotation), timeStep);
	}

	/**
	 * Get the linear velocity of a local point attached to the body. Usually in
	 * meters per second.
	 */
	public Vector2f getLocalPointVelocity(Vector2f target, Vector2f localPoint) {
		try (Arena arena = Arena.ofConfined()) {
			vecTmp.set(localPoint);

			MethodHandle method = B2_BODY_GET_LOCAL_POINT_VELOCITY;
			MemorySegment segment = (MemorySegment) method.invoke(arena, b2BodyId, vecTmp.memorySegment());

			vecTmp.set(segment);
			return vecTmp.get(target);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot get local point velocity.");
		}
	}

	/**
	 * Get the linear velocity of a local point attached to the body. Usually in
	 * meters per second.
	 */
	public Vector2f getLocalPointVelocity(Vector2f localPoint) {
		return getLocalPointVelocity(new Vector2f(), localPoint);
	}

	/**
	 * Get the linear velocity of a world point attached to the body. Usually in
	 * meters per second.
	 */
	public Vector2f getWorldPointVelocity(Vector2f target, Vector2f worldPoint) {
		try (Arena arena = Arena.ofConfined()) {
			vecTmp.set(worldPoint);

			MethodHandle method = B2_BODY_GET_WORLD_POINT_VELOCITY;
			MemorySegment segment = (MemorySegment) method.invoke(arena, b2BodyId, vecTmp.memorySegment());

			vecTmp.set(segment);
			return vecTmp.get(target);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot get world point velocity.");
		}
	}

	/**
	 * Get the linear velocity of a world point attached to the body. Usually in
	 * meters per second.
	 */
	public Vector2f getWorldPointVelocity(Vector2f worldPoint) {
		return getWorldPointVelocity(new Vector2f(), worldPoint);
	}

	/**
	 * Apply a force at a world point.
	 */
	public void applyForce(Vector2f force, Vector2f point, boolean wake) {
		try {
			vecTmp.set(force);
			vecTmp2.set(point);
			B2_BODY_APPLY_FORCE.invokeExact(b2BodyId, vecTmp.memorySegment(), vecTmp2.memorySegment(), wake);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot apply force.");
		}
	}

	/**
	 * Apply a force to the center of mass.
	 */
	public void applyForceToCenter(Vector2f force, boolean wake) {
		try {
			vecTmp.set(force);
			B2_BODY_APPLY_FORCE_TO_CENTER.invokeExact(b2BodyId, vecTmp.memorySegment());
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot apply force to center.");
		}
	}

	/**
	 * Apply a torque.
	 */
	public void applyTorque(float torque, boolean wake) {
		try {
			B2_BODY_APPLY_TORQUE.invokeExact(b2BodyId, torque, wake);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot apply torque.");
		}
	}

	/**
	 * Apply an impulse at a point.
	 */
	public void applyLinearImpulse(Vector2f impulse, Vector2f point, boolean wake) {
		try {
			vecTmp.set(point);
			vecTmp2.set(point);
			B2_BODY_APPLY_LINEAR_IMPULSE.invokeExact(b2BodyId, vecTmp.memorySegment(), vecTmp2.memorySegment(), wake);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot apply linear impulse.");
		}
	}

	/**
	 * Apply an impulse to the center of mass.
	 */
	public void applyLinearImpulseToCenter(Vector2f impulse, boolean wake) {
		try {
			vecTmp.set(impulse);
			B2_BODY_APPLY_LINEAR_IMPULSE_TO_CENTER.invokeExact(b2BodyId, vecTmp.memorySegment(), wake);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot apply linear impulse to center.");
		}
	}

	/**
	 * Apply an angular impulse.
	 */
	public void applyAngularImpulse(float impulse, boolean wake) {
		try {
			B2_BODY_APPLY_ANGULAR_IMPULSE.invokeExact(b2BodyId, impulse, wake);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot apply angular impulse.");
		}
	}

	/**
	 * Get the mass of the body, usually in kilograms.
	 */
	public float getMass() {
		try {
			return (float) B2_BODY_GET_MASS.invokeExact(b2BodyId);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot get mass.");
		}
	}

	/**
	 * Get the rotational inertia of the body, usually in kg*m^2.
	 */
	public float getRotationInertia() {
		try {
			return (float) B2_BODY_GET_ROTATION_INERTIA.invokeExact(b2BodyId);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot get rotation inertia.");
		}
	}

	/**
	 * Get the center of mass position of the body in local space.
	 */
	public Vector2f getLocalCenterOfMass(Vector2f target) {
		try (Arena arena = Arena.ofConfined()) {
			MemorySegment segment = (MemorySegment) B2_BODY_GET_LOCAL_CENTER_OF_MASS.invoke(arena, b2BodyId);
			vecTmp.set(segment);
			return vecTmp.get(target);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot get local center of mass.");
		}
	}

	/**
	 * Get the center of mass position of the body in local space.
	 */
	public Vector2f getLocalCenterOfMass() {
		return getLocalCenterOfMass(new Vector2f());
	}

	/**
	 * Get the center of mass position of the body in world space.
	 */
	public Vector2f getWorldCenterOfMass(Vector2f target) {
		try (Arena arena = Arena.ofConfined()) {
			MemorySegment segment = (MemorySegment) B2_BODY_GET_WORLD_CENTER_OF_MASS.invoke(arena, b2BodyId);
			vecTmp.set(segment);
			return vecTmp.get(target);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot get world center of mass.");
		}
	}

	/**
	 * Get the center of mass position of the body in world space.
	 */
	public Vector2f getWorldCenterOfMass() {
		return getWorldCenterOfMass(new Vector2f());
	}

	/**
	 * Override the body's mass properties.
	 */
	public void setMassData(MassData massData) {
		try {
			B2_BODY_SET_MASS_DATA.invokeExact(b2BodyId, massData.memorySegment());
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot set mass data.");
		}
	}

	/**
	 * Get the mass data for the body.
	 */
	public MassData getMassData(MassData target) {
		try (Arena arena = Arena.ofConfined()) {
			MemorySegment segment = (MemorySegment) B2_BODY_GET_MASS_DATA.invoke(arena, b2BodyId);
			target.set(segment);
			return target;
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot get mass data.");
		}
	}

	/**
	 * Get the mass data for the body.
	 */
	public MassData getMassData() {
		return getMassData(new MassData());
	}

	/**
	 * This update the mass properties to the sum of the mass properties of the
	 * shapes.
	 */
	public void applyMassFromShapes() {
		try {
			B2_BODY_APPLY_MASS_FROM_SHAPES.invokeExact(b2BodyId);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot apply mass from shapes.");
		}
	}

	/**
	 * Adjust the linear damping. Normally this is set in {@link BodyDef} before
	 * creation.
	 */
	public void setLinearDamping(float linearDamping) {
		try {
			B2_BODY_SET_LINEAR_DAMPING.invokeExact(b2BodyId, linearDamping);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot set linear damping.");
		}
	}

	/**
	 * Get the current linear damping.
	 */
	public float getLinearDamping() {
		try {
			return (float) B2_BODY_GET_LINEAR_DAMPING.invokeExact(b2BodyId);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot get linear damping.");
		}
	}

	/**
	 * Adjust the angular damping. Normally this is set in {@link BodyDef} before
	 * creation.
	 */
	public void setAngularDamping(float angularDamping) {
		try {
			B2_BODY_SET_ANGULAR_DAMPING.invokeExact(b2BodyId, angularDamping);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot set angular damping.");
		}
	}

	/**
	 * Get the current angular damping.
	 */
	public float getAngularDamping(float angularDamping) {
		try {
			return (float) B2_BODY_GET_ANGULAR_DAMPING.invokeExact(b2BodyId);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot get angular damping.");
		}
	}

	/**
	 * Adjust the gravity scale.
	 */
	public void setGravityScale(float gravityScale) {
		try {
			B2_BODY_SET_GRAVITY_SCALE.invokeExact(b2BodyId, gravityScale);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot set gravity scale.");
		}
	}

	/**
	 * Get the current gravity scale.
	 */
	public float getGravityScale() {
		try {
			return (float) B2_BODY_GET_GRAVITY_SCALE.invokeExact(b2BodyId);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot get gravity scale.");
		}
	}

	/**
	 * 
	 */
	public boolean isAwake() {
		try {
			return (boolean) B2_BODY_IS_AWAKE.invokeExact(b2BodyId);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot check if body is awake.");
		}
	}

	/**
	 * Wake the body from sleep.
	 */
	public void setAwake(boolean awake) {
		try {
			B2_BODY_SET_AWAKE.invokeExact(b2BodyId, awake);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot set awake.");
		}
	}

	/**
	 * Enable or disable sleeping for this body. If sleeping is disabled the body
	 * will wake.
	 */
	public void enableSleep(boolean enableSleep) {
		try {
			B2_BODY_ENABLE_SLEEP.invokeExact(b2BodyId, enableSleep);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot enable/ disable sleep.");
		}
	}

	/**
	 * Returns true if sleeping is enabled for this body.
	 */
	public boolean isSleepEnabled() {
		try {
			return (boolean) B2_BODY_IS_SLEEP_ENABLED.invokeExact(b2BodyId);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot check if sleep is enabled.");
		}
	}

	/**
	 * Set the sleep threshold, usually in meters per second.
	 */
	public void setSleepThreshold(float sleepThreshold) {
		try {
			B2_BODY_SET_SLEEP_THRESHOLD.invokeExact(b2BodyId, sleepThreshold);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D:  Cannot set sleep threshold.");
		}
	}

	/**
	 * Get the sleep threshold, usually in meters per second.
	 */
	public float getSleepThreshold() {
		try {
			return (float) B2_BODY_GET_SLEEP_THRESHOLD.invokeExact(b2BodyId);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot get sleep threshold.");
		}
	}

	/**
	 * Returns true if this body is enabled.
	 */
	public boolean isEnabled() {
		try {
			return (boolean) B2_BODY_IS_ENABLED.invokeExact(b2BodyId);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot check if body is enabled.");
		}
	}

	/**
	 * Disable the body by removing it completely from the simulation. This is
	 * expensive.
	 */
	public void disable() {
		try {
			B2_BODY_DISABLE.invokeExact(b2BodyId);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot disable body.");
		}
	}

	/**
	 * Enable the body by adding it to the simulation. This is expensive.
	 */
	public void enable() {
		try {
			B2_BODY_ENABLE.invokeExact(b2BodyId);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot enable body.");
		}
	}

	/**
	 * Set this body to have fixed rotation. This causes the mass to be reset in all
	 * cases.
	 */
	public void setFixedRotation(boolean flag) {
		try {
			B2_BODY_SET_FIXED_ROTATION.invokeExact(b2BodyId, flag);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot set fixed rotation.");
		}
	}

	/**
	 * Does this body have fixed rotation?
	 */
	public boolean isFixedRotation() {
		try {
			return (boolean) B2_BODY_IS_FIXED_ROTATION.invokeExact(b2BodyId);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot check if body is fixed rotation.");
		}
	}

	/**
	 * Set this body to be a bullet.
	 */
	public void setBullet(boolean flag) {
		try {
			B2_BODY_SET_BULLET.invokeExact(b2BodyId, flag);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot set bullet.");
		}
	}

	/**
	 * Is this body a bullet?
	 */
	public boolean isBullet() {
		try {
			return (boolean) B2_BODY_IS_BULLET.invokeExact(b2BodyId);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot check if body is bullet.");
		}
	}

	/**
	 * Enable/disable contact events on all shapes.
	 */
	public void enableContactEvents(boolean flag) {
		try {
			B2_BODY_ENABLE_CONTACT_EVENTS.invokeExact(b2BodyId, flag);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot enable/ disable contact events.");
		}
	}

	/**
	 * Enable/disable hit events on all shapes.
	 */
	public void enableHitEvents(boolean flag) {
		try {
			B2_BODY_ENABLE_HIT_EVENTS.invokeExact(b2BodyId, flag);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot enable/ disable hit events.");
		}
	}

	/**
	 * Get the world that owns this body.
	 */
	public World getWorld() {
		return world;
	}

	/**
	 * Get the number of shapes on this body.
	 */
	public int getShapeCount() {
		try {
			return (int) B2_BODY_GET_SHAPE_COUNT.invokeExact(b2BodyId);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot get shape count.");
		}
	}

	/**
	 * Get all shapes on this body, up to the provided capacity.
	 */
	public int getShapes(Shape[] target) {
		return getShapes(target, Arena.ofAuto());
	}

	/**
	 * Get all shapes on this body, up to the provided capacity.
	 */
	public int getShapes(Shape[] target, Arena shapeArena) {
		try (Arena arena = Arena.ofConfined()) {
			MemorySegment array = arena.allocate(MemoryLayout.sequenceLayout(target.length, Shape.LAYOUT()));
			int count = (int) B2_BODY_GET_SHAPES.invokeExact(b2BodyId, array, target.length);

			for (int i = 0; i < count; i++) {
				long offset = i * Shape.LAYOUT().byteSize();

				Shape shape = Box2D.getShape(Shape.getShapeId(array, offset), world);

				if (shape == null) {
					MemorySegment shapeSegment = shapeArena.allocate(Shape.LAYOUT());
					MemorySegment.copy(array, offset, shapeSegment, 0L, Shape.LAYOUT().byteSize());
					target[i] = new Shape(shapeSegment, this);
				} else {
					target[i] = shape;
				}
			}
			return count;
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot get shapes.", e);
		}
	}

	/**
	 * Get the number of joints on this body.
	 */
	public int getJointCount() {
		try {
			return (int) B2_BODY_GET_JOINT_COUNT.invokeExact(b2BodyId);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot get joint count.");
		}
	}

	/**
	 * Get all joints on this body, up to the provided capacity.
	 */
	public int getJoints(Joint[] target) {
		return getJoints(target, Arena.ofAuto());
	}

	/**
	 * Get all joints on this body, up to the provided capacity.
	 */
	public int getJoints(Joint[] target, Arena jointArena) {
		try (Arena arena = Arena.ofConfined()) {
			MemorySegment array = arena.allocate(MemoryLayout.sequenceLayout(target.length, Joint.LAYOUT()));
			int count = (int) B2_BODY_GET_JOINTS.invokeExact(b2BodyId, array, target.length);

			for (int i = 0; i < count; i++) {
				long offset = i * Joint.LAYOUT().byteSize();
				Joint joint = Box2D.getJoint(Joint.getJointId(array, offset), world);

				if (joint == null) {
					MemorySegment shapeSegment = jointArena.allocate(Joint.LAYOUT());
					MemorySegment.copy(array, offset, shapeSegment, 0L, Joint.LAYOUT().byteSize());
					target[i] = new Joint(shapeSegment, world, jointArena);
				} else {
					target[i] = joint;
				}
			}

			return count;
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot get joints.");
		}
	}

	/**
	 * Get the maximum capacity required for retrieving all the touching contacts on
	 * the body.
	 */
	public int getContactCapacity() {
		try {
			return (int) B2_BODY_GET_CONTACT_CAPACITY.invokeExact(b2BodyId);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot get contact capacity.");
		}
	}

	/**
	 * Get the touching contact data for the body.
	 */
	public int getContactData(ContactData[] target) {
		try (Arena arena = Arena.ofConfined()) {
			MemorySegment array = arena.allocate(MemoryLayout.sequenceLayout(target.length, ContactData.LAYOUT()));

			int count = (int) B2_BODY_GET_CONTACT_DATA.invokeExact(b2BodyId, array, target.length);

			for (int i = 0; i < count; i++) {
				long offset = i * ContactData.LAYOUT().byteSize();

				if (target[i] == null)
					target[i] = new ContactData();

				MemorySegment.copy(array, offset, target[i].memorySegment(), 0, ContactData.LAYOUT().byteSize());
			}

			return count;
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot get contact data.");
		}
	}

	/**
	 * Get the current world AABB that contains all the attached shapes.
	 */
	public AABB computeAABB(AABB target) {
		try (Arena arena = Arena.ofConfined()) {
			MemorySegment segment = (MemorySegment) B2_BODY_COMPUTE_AABB.invoke(arena, b2BodyId);
			target.set(segment);
			return target;
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot compute AABB.");
		}
	}

	/**
	 * Get the current world AABB that contains all the attached shapes.
	 */
	public AABB computeAABB() {
		return computeAABB(new AABB());
	}

	public MemorySegment memorySegment() {
		return b2BodyId;
	}

	public static StructLayout LAYOUT() {
		return BODY_ID_LAYOUT;
	}

	public static BodyId getBodyId(MemorySegment memorySegment) {
		return getBodyId(memorySegment, 0L);
	}

	public static BodyId getBodyId(MemorySegment memorySegment, long offset) {
		int index1 = (int) INDEX_1.get(memorySegment, offset);
		short world0 = (short) WORLD_0.get(memorySegment, offset);
		short generation = (short) GENERATION.get(memorySegment, offset);
		return new BodyId(index1, world0, generation);
	}

	public static record BodyId(int index1, short world0, short generation) {
	};

}