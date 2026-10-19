/*
 * MACHINE GENERATED FILE, DO NOT EDIT.
 */
package volucris.bindings.box2d.body;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.SegmentAllocator;
import java.lang.invoke.MethodHandle;
import org.jspecify.annotations.Nullable;
import volucris.bindings.box2d.events.ContactData;
import volucris.bindings.box2d.geometry.MassData;
import volucris.bindings.box2d.joint.JointId;
import volucris.bindings.box2d.math.AABB;
import volucris.bindings.box2d.math.Rot;
import volucris.bindings.box2d.math.Transform;
import volucris.bindings.box2d.math.Vec2;
import volucris.bindings.box2d.shape.ShapeId;
import volucris.bindings.box2d.world.WorldId;
import volucris.bindings.core.MemoryStack;
import volucris.bindings.core.NativeStructArray;

import static java.lang.foreign.ValueLayout.*;
import static volucris.bindings.core.FFMUtils.*;

public final class Body {

	private static final LazyConstant<MethodHandle> B2_CREATE_BODY;
	private static final LazyConstant<MethodHandle> B2_DESTROY_BODY;
	private static final LazyConstant<MethodHandle> B2_BODY_IS_VALID;
	private static final LazyConstant<MethodHandle> B2_BODY_GET_TYPE;
	private static final LazyConstant<MethodHandle> B2_BODY_SET_TYPE;
	private static final LazyConstant<MethodHandle> B2_BODY_SET_NAME;
	private static final LazyConstant<MethodHandle> B2_BODY_GET_NAME;
	private static final LazyConstant<MethodHandle> B2_BODY_SET_USER_DATA;
	private static final LazyConstant<MethodHandle> B2_BODY_GET_USER_DATA;
	private static final LazyConstant<MethodHandle> B2_BODY_GET_POSITION;
	private static final LazyConstant<MethodHandle> B2_BODY_GET_ROTATION;
	private static final LazyConstant<MethodHandle> B2_BODY_GET_TRANSFORM;
	private static final LazyConstant<MethodHandle> B2_BODY_SET_TRANSFORM;
	private static final LazyConstant<MethodHandle> B2_BODY_GET_LOCAL_POINT;
	private static final LazyConstant<MethodHandle> B2_BODY_GET_WORLD_POINT;
	private static final LazyConstant<MethodHandle> B2_BODY_GET_LOCAL_VECTOR;
	private static final LazyConstant<MethodHandle> B2_BODY_GET_WORLD_VECTOR;
	private static final LazyConstant<MethodHandle> B2_BODY_GET_LINEAR_VELOCITY;
	private static final LazyConstant<MethodHandle> B2_BODY_GET_ANGULAR_VELOCITY;
	private static final LazyConstant<MethodHandle> B2_BODY_SET_LINEAR_VELOCITY;
	private static final LazyConstant<MethodHandle> B2_BODY_SET_ANGULAR_VELOCITY;
	private static final LazyConstant<MethodHandle> B2_BODY_SET_TARGET_TRANSFORM;
	private static final LazyConstant<MethodHandle> B2_BODY_GET_LOCAL_POINT_VELOCITY;
	private static final LazyConstant<MethodHandle> B2_BODY_GET_WORLD_POINT_VELOCITY;
	private static final LazyConstant<MethodHandle> B2_BODY_APPLY_FORCE;
	private static final LazyConstant<MethodHandle> B2_BODY_APPLY_FORCE_TO_CENTER;
	private static final LazyConstant<MethodHandle> B2_BODY_APPLY_TORQUE;
	private static final LazyConstant<MethodHandle> B2_BODY_CLEAR_FORCES;
	private static final LazyConstant<MethodHandle> B2_BODY_APPLY_LINEAR_IMPULSE;
	private static final LazyConstant<MethodHandle> B2_BODY_APPLY_LINEAR_IMPULSE_TO_CENTER;
	private static final LazyConstant<MethodHandle> B2_BODY_APPLY_ANGULAR_IMPULSE;
	private static final LazyConstant<MethodHandle> B2_BODY_GET_MASS;
	private static final LazyConstant<MethodHandle> B2_BODY_GET_ROTATIONAL_INERTIA;
	private static final LazyConstant<MethodHandle> B2_BODY_GET_LOCAL_CENTER;
	private static final LazyConstant<MethodHandle> B2_BODY_GET_WORLD_CENTER;
	private static final LazyConstant<MethodHandle> B2_BODY_SET_MASS_DATA;
	private static final LazyConstant<MethodHandle> B2_BODY_GET_MASS_DATA;
	private static final LazyConstant<MethodHandle> B2_BODY_UPDATE_MASS_FROM_SHAPES;
	private static final LazyConstant<MethodHandle> B2_BODY_SET_LINEAR_DAMPING;
	private static final LazyConstant<MethodHandle> B2_BODY_GET_LINEAR_DAMPING;
	private static final LazyConstant<MethodHandle> B2_BODY_SET_ANGULAR_DAMPING;
	private static final LazyConstant<MethodHandle> B2_BODY_GET_ANGULAR_DAMPING;
	private static final LazyConstant<MethodHandle> B2_BODY_SET_GRAVITY_SCALE;
	private static final LazyConstant<MethodHandle> B2_BODY_GET_GRAVITY_SCALE;
	private static final LazyConstant<MethodHandle> B2_BODY_IS_AWAKE;
	private static final LazyConstant<MethodHandle> B2_BODY_SET_AWAKE;
	private static final LazyConstant<MethodHandle> B2_BODY_WAKE_TOUCHING;
	private static final LazyConstant<MethodHandle> B2_BODY_ENABLE_SLEEPING;
	private static final LazyConstant<MethodHandle> B2_BODY_IS_SLEEPING_ENABLED;
	private static final LazyConstant<MethodHandle> B2_BODY_SET_SLEEP_THRESHOLD;
	private static final LazyConstant<MethodHandle> B2_BODY_GET_SLEEP_THRESHOLD;
	private static final LazyConstant<MethodHandle> B2_BODY_SET_SAFETY_FACTOR;
	private static final LazyConstant<MethodHandle> B2_BODY_GET_SAFETY_FACTOR;
	private static final LazyConstant<MethodHandle> B2_BODY_IS_ENABLED;
	private static final LazyConstant<MethodHandle> B2_BODY_DISABLE;
	private static final LazyConstant<MethodHandle> B2_BODY_ENABLE;
	private static final LazyConstant<MethodHandle> B2_BODY_SET_MOTION_LOCKS;
	private static final LazyConstant<MethodHandle> B2_BODY_GET_MOTION_LOCKS;
	private static final LazyConstant<MethodHandle> B2_BODY_SET_BULLET;
	private static final LazyConstant<MethodHandle> B2_BODY_IS_BULLET;
	private static final LazyConstant<MethodHandle> B2_BODY_ENABLE_CONTACT_RECYCLING;
	private static final LazyConstant<MethodHandle> B2_BODY_IS_CONTACT_RECYCLING_ENABLED;
	private static final LazyConstant<MethodHandle> B2_BODY_ENABLE_CONTACT_EVENTS;
	private static final LazyConstant<MethodHandle> B2_BODY_ENABLE_HIT_EVENTS;
	private static final LazyConstant<MethodHandle> B2_BODY_GET_WORLD;
	private static final LazyConstant<MethodHandle> B2_BODY_GET_SHAPE_COUNT;
	private static final LazyConstant<MethodHandle> B2_BODY_GET_SHAPES;
	private static final LazyConstant<MethodHandle> B2_BODY_GET_JOINT_COUNT;
	private static final LazyConstant<MethodHandle> B2_BODY_GET_JOINTS;
	private static final LazyConstant<MethodHandle> B2_BODY_GET_CONTACT_CAPACITY;
	private static final LazyConstant<MethodHandle> B2_BODY_GET_CONTACT_DATA;
	private static final LazyConstant<MethodHandle> B2_BODY_COMPUTE_BOUNDS;
	private static final LazyConstant<MethodHandle> B2_BODY_GET_MIN_EXTENT;
	private static final LazyConstant<MethodHandle> B2_BODY_GET_MAX_EXTENT;
	private static final LazyConstant<MethodHandle> B2_BODY_GET_MAX_EXTENT_FROM_ORIGIN;

	static {
		//@formatter:off
		B2_CREATE_BODY = downcallHandle("b2CreateBody", BodyId.LAYOUT, WorldId.LAYOUT, UNBOUNDED_ADDRESS);
		B2_DESTROY_BODY = downcallHandleVoid("b2DestroyBody", BodyId.LAYOUT);
		B2_BODY_IS_VALID = downcallHandle("b2Body_IsValid", JAVA_BOOLEAN, BodyId.LAYOUT);
		B2_BODY_GET_TYPE = downcallHandle("b2Body_GetType", JAVA_INT, BodyId.LAYOUT);
		B2_BODY_SET_TYPE = downcallHandleVoid("b2Body_SetType", BodyId.LAYOUT, JAVA_INT);
		B2_BODY_SET_NAME = downcallHandleVoid("b2Body_SetName", BodyId.LAYOUT, UNBOUNDED_ADDRESS);
		B2_BODY_GET_NAME = downcallHandle("b2Body_GetName", UNBOUNDED_ADDRESS, BodyId.LAYOUT);
		B2_BODY_SET_USER_DATA = downcallHandleVoid("b2Body_SetUserData", BodyId.LAYOUT, UNBOUNDED_ADDRESS);
		B2_BODY_GET_USER_DATA = downcallHandle("b2Body_GetUserData", UNBOUNDED_ADDRESS, BodyId.LAYOUT);
		B2_BODY_GET_POSITION = downcallHandle("b2Body_GetPosition", Vec2.LAYOUT, BodyId.LAYOUT);
		B2_BODY_GET_ROTATION = downcallHandle("b2Body_GetRotation", Rot.LAYOUT, BodyId.LAYOUT);
		B2_BODY_GET_TRANSFORM = downcallHandle("b2Body_GetTransform", Transform.LAYOUT, BodyId.LAYOUT);
		B2_BODY_SET_TRANSFORM = downcallHandleVoid("b2Body_SetTransform", BodyId.LAYOUT, Vec2.LAYOUT, Rot.LAYOUT);
		B2_BODY_GET_LOCAL_POINT = downcallHandle("b2Body_GetLocalPoint", Vec2.LAYOUT, BodyId.LAYOUT, Vec2.LAYOUT);
		B2_BODY_GET_WORLD_POINT = downcallHandle("b2Body_GetWorldPoint", Vec2.LAYOUT, BodyId.LAYOUT, Vec2.LAYOUT);
		B2_BODY_GET_LOCAL_VECTOR = downcallHandle("b2Body_GetLocalVector", Vec2.LAYOUT, BodyId.LAYOUT, Vec2.LAYOUT);
		B2_BODY_GET_WORLD_VECTOR = downcallHandle("b2Body_GetWorldVector", Vec2.LAYOUT, BodyId.LAYOUT, Vec2.LAYOUT);
		B2_BODY_GET_LINEAR_VELOCITY = downcallHandle("b2Body_GetLinearVelocity", Vec2.LAYOUT, BodyId.LAYOUT);
		B2_BODY_GET_ANGULAR_VELOCITY = downcallHandle("b2Body_GetAngularVelocity", JAVA_FLOAT, BodyId.LAYOUT);
		B2_BODY_SET_LINEAR_VELOCITY = downcallHandleVoid("b2Body_SetLinearVelocity", BodyId.LAYOUT, Vec2.LAYOUT);
		B2_BODY_SET_ANGULAR_VELOCITY = downcallHandleVoid("b2Body_SetAngularVelocity", BodyId.LAYOUT, JAVA_FLOAT);
		B2_BODY_SET_TARGET_TRANSFORM = downcallHandleVoid("b2Body_SetTargetTransform", BodyId.LAYOUT, Transform.LAYOUT, JAVA_FLOAT, JAVA_BOOLEAN);
		B2_BODY_GET_LOCAL_POINT_VELOCITY = downcallHandle("b2Body_GetLocalPointVelocity", Vec2.LAYOUT, BodyId.LAYOUT, Vec2.LAYOUT);
		B2_BODY_GET_WORLD_POINT_VELOCITY = downcallHandle("b2Body_GetWorldPointVelocity", Vec2.LAYOUT, BodyId.LAYOUT, Vec2.LAYOUT);
		B2_BODY_APPLY_FORCE = downcallHandleVoid("b2Body_ApplyForce", BodyId.LAYOUT, Vec2.LAYOUT, Vec2.LAYOUT, JAVA_BOOLEAN);
		B2_BODY_APPLY_FORCE_TO_CENTER = downcallHandleVoid("b2Body_ApplyForceToCenter", BodyId.LAYOUT, Vec2.LAYOUT, JAVA_BOOLEAN);
		B2_BODY_APPLY_TORQUE = downcallHandleVoid("b2Body_ApplyTorque", BodyId.LAYOUT, JAVA_FLOAT, JAVA_BOOLEAN);
		B2_BODY_CLEAR_FORCES = downcallHandleVoid("b2Body_ClearForces", BodyId.LAYOUT);
		B2_BODY_APPLY_LINEAR_IMPULSE = downcallHandleVoid("b2Body_ApplyLinearImpulse", BodyId.LAYOUT, Vec2.LAYOUT, Vec2.LAYOUT, JAVA_BOOLEAN);
		B2_BODY_APPLY_LINEAR_IMPULSE_TO_CENTER = downcallHandleVoid("b2Body_ApplyLinearImpulseToCenter", BodyId.LAYOUT, Vec2.LAYOUT, JAVA_BOOLEAN);
		B2_BODY_APPLY_ANGULAR_IMPULSE = downcallHandleVoid("b2Body_ApplyAngularImpulse", BodyId.LAYOUT, JAVA_FLOAT, JAVA_BOOLEAN);
		B2_BODY_GET_MASS = downcallHandle("b2Body_GetMass", JAVA_FLOAT, BodyId.LAYOUT);
		B2_BODY_GET_ROTATIONAL_INERTIA = downcallHandle("b2Body_GetRotationalInertia", JAVA_FLOAT, BodyId.LAYOUT);
		B2_BODY_GET_LOCAL_CENTER = downcallHandle("b2Body_GetLocalCenter", Vec2.LAYOUT, BodyId.LAYOUT);
		B2_BODY_GET_WORLD_CENTER = downcallHandle("b2Body_GetWorldCenter", Vec2.LAYOUT, BodyId.LAYOUT);
		B2_BODY_SET_MASS_DATA = downcallHandleVoid("b2Body_SetMassData", BodyId.LAYOUT, MassData.LAYOUT);
		B2_BODY_GET_MASS_DATA = downcallHandle("b2Body_GetMassData", MassData.LAYOUT, BodyId.LAYOUT);
		B2_BODY_UPDATE_MASS_FROM_SHAPES = downcallHandleVoid("b2Body_UpdateMassFromShapes", BodyId.LAYOUT);
		B2_BODY_SET_LINEAR_DAMPING = downcallHandleVoid("b2Body_SetLinearDamping", BodyId.LAYOUT, JAVA_FLOAT);
		B2_BODY_GET_LINEAR_DAMPING = downcallHandle("b2Body_GetLinearDamping", JAVA_FLOAT, BodyId.LAYOUT);
		B2_BODY_SET_ANGULAR_DAMPING = downcallHandleVoid("b2Body_SetAngularDamping", BodyId.LAYOUT, JAVA_FLOAT);
		B2_BODY_GET_ANGULAR_DAMPING = downcallHandle("b2Body_GetAngularDamping", JAVA_FLOAT, BodyId.LAYOUT);
		B2_BODY_SET_GRAVITY_SCALE = downcallHandleVoid("b2Body_SetGravityScale", BodyId.LAYOUT, JAVA_FLOAT);
		B2_BODY_GET_GRAVITY_SCALE = downcallHandle("b2Body_GetGravityScale", JAVA_FLOAT, BodyId.LAYOUT);
		B2_BODY_IS_AWAKE = downcallHandle("b2Body_IsAwake", JAVA_BOOLEAN, BodyId.LAYOUT);
		B2_BODY_SET_AWAKE = downcallHandleVoid("b2Body_SetAwake", BodyId.LAYOUT, JAVA_BOOLEAN);
		B2_BODY_WAKE_TOUCHING = downcallHandleVoid("b2Body_WakeTouching", BodyId.LAYOUT);
		B2_BODY_ENABLE_SLEEPING = downcallHandleVoid("b2Body_EnableSleeping", BodyId.LAYOUT, JAVA_BOOLEAN);
		B2_BODY_IS_SLEEPING_ENABLED = downcallHandle("b2Body_IsSleepingEnabled", JAVA_BOOLEAN, BodyId.LAYOUT);
		B2_BODY_SET_SLEEP_THRESHOLD = downcallHandleVoid("b2Body_SetSleepThreshold", BodyId.LAYOUT, JAVA_FLOAT);
		B2_BODY_GET_SLEEP_THRESHOLD = downcallHandle("b2Body_GetSleepThreshold", JAVA_FLOAT, BodyId.LAYOUT);
		B2_BODY_SET_SAFETY_FACTOR = downcallHandleVoid("b2Body_SetSafetyFactor", BodyId.LAYOUT, JAVA_FLOAT);
		B2_BODY_GET_SAFETY_FACTOR = downcallHandle("b2Body_GetSafetyFactor", JAVA_FLOAT, BodyId.LAYOUT);
		B2_BODY_IS_ENABLED = downcallHandle("b2Body_IsEnabled", JAVA_BOOLEAN, BodyId.LAYOUT);
		B2_BODY_DISABLE = downcallHandleVoid("b2Body_Disable", BodyId.LAYOUT);
		B2_BODY_ENABLE = downcallHandleVoid("b2Body_Enable", BodyId.LAYOUT);
		B2_BODY_SET_MOTION_LOCKS = downcallHandleVoid("b2Body_SetMotionLocks", BodyId.LAYOUT, MotionLocks.LAYOUT);
		B2_BODY_GET_MOTION_LOCKS = downcallHandle("b2Body_GetMotionLocks", MotionLocks.LAYOUT, BodyId.LAYOUT);
		B2_BODY_SET_BULLET = downcallHandleVoid("b2Body_SetBullet", BodyId.LAYOUT, JAVA_BOOLEAN);
		B2_BODY_IS_BULLET = downcallHandle("b2Body_IsBullet", JAVA_BOOLEAN, BodyId.LAYOUT);
		B2_BODY_ENABLE_CONTACT_RECYCLING = downcallHandleVoid("b2Body_EnableContactRecycling", BodyId.LAYOUT, JAVA_BOOLEAN);
		B2_BODY_IS_CONTACT_RECYCLING_ENABLED = downcallHandle("b2Body_IsContactRecyclingEnabled", JAVA_BOOLEAN, BodyId.LAYOUT);
		B2_BODY_ENABLE_CONTACT_EVENTS = downcallHandleVoid("b2Body_EnableContactEvents", BodyId.LAYOUT, JAVA_BOOLEAN);
		B2_BODY_ENABLE_HIT_EVENTS = downcallHandleVoid("b2Body_EnableHitEvents", BodyId.LAYOUT, JAVA_BOOLEAN);
		B2_BODY_GET_WORLD = downcallHandle("b2Body_GetWorld", WorldId.LAYOUT, BodyId.LAYOUT);
		B2_BODY_GET_SHAPE_COUNT = downcallHandle("b2Body_GetShapeCount", JAVA_INT, BodyId.LAYOUT);
		B2_BODY_GET_SHAPES = downcallHandle("b2Body_GetShapes", JAVA_INT, BodyId.LAYOUT, UNBOUNDED_ADDRESS, JAVA_INT);
		B2_BODY_GET_JOINT_COUNT = downcallHandle("b2Body_GetJointCount", JAVA_INT, BodyId.LAYOUT);
		B2_BODY_GET_JOINTS = downcallHandle("b2Body_GetJoints", JAVA_INT, BodyId.LAYOUT, UNBOUNDED_ADDRESS, JAVA_INT);
		B2_BODY_GET_CONTACT_CAPACITY = downcallHandle("b2Body_GetContactCapacity", JAVA_INT, BodyId.LAYOUT);
		B2_BODY_GET_CONTACT_DATA = downcallHandle("b2Body_GetContactData", JAVA_INT, BodyId.LAYOUT, UNBOUNDED_ADDRESS, JAVA_INT);
		B2_BODY_COMPUTE_BOUNDS = downcallHandle("b2Body_ComputeBounds", AABB.LAYOUT, BodyId.LAYOUT);
		B2_BODY_GET_MIN_EXTENT = downcallHandle("b2Body_GetMinExtent", JAVA_FLOAT, BodyId.LAYOUT);
		B2_BODY_GET_MAX_EXTENT = downcallHandle("b2Body_GetMaxExtent", JAVA_FLOAT, BodyId.LAYOUT);
		B2_BODY_GET_MAX_EXTENT_FROM_ORIGIN = downcallHandle("b2Body_GetMaxExtentFromOrigin", JAVA_FLOAT, BodyId.LAYOUT);
		//@formatter:on
	}

	private Body() {
	}

    /// ```
    /// Create a rigid body given a definition. No reference to the definition is retained. So you can
    /// create the definition on the stack and pass it as a pointer.
    /// @code{.c}
    /// b2BodyDef bodyDef = b2DefaultBodyDef();
    /// b2BodyId myBodyId = b2CreateBody(myWorldId, &bodyDef);
    /// @endcode
    /// @warning This function is locked during callbacks.
    /// ```
    public static MemorySegment createBody(
    	SegmentAllocator allocator,
    	MemorySegment worldId,
    	MemorySegment def
    ) {
    	MethodHandle method = B2_CREATE_BODY.get();
    	try {
    		return (MemorySegment) method.invokeExact(
    			allocator,
    			worldId,
    			def
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#createBody].
    public static @Nullable BodyId createBody(
    	SegmentAllocator allocator,
    	WorldId worldId,
    	BodyDef def
    ) {
    	MemorySegment segment = createBody(
    		allocator,
    		worldId.memorySegment(),
    		def.memorySegment()
    	);
    
    	if (segment.equals(MemorySegment.NULL))
    		return null;
    	
    	return new BodyId(segment);
    }
    
    /// ```
    /// Destroy a rigid body given an id. This destroys all shapes and joints attached to the body. Do
    /// not keep references to the associated shapes and joints.
    /// ```
    public static void destroyBody(
    	MemorySegment bodyId
    ) {
    	MethodHandle method = B2_DESTROY_BODY.get();
    	try {
    		 method.invokeExact(
    			bodyId
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#destroyBody].
    public static void destroyBody(
    	BodyId bodyId
    ) {
    	destroyBody(
    		bodyId.memorySegment()
    	);
    }
    
    /// ```
    /// Body identifier validation. A valid body exists in a world and is non-null. This can be used to
    /// detect orphaned ids. Provides validation for up to 64K allocations.
    /// ```
    public static boolean isValid(
    	MemorySegment id
    ) {
    	MethodHandle method = B2_BODY_IS_VALID.get();
    	try {
    		return (boolean) method.invokeExact(
    			id
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#isValid].
    public static boolean isValid(
    	BodyId id
    ) {
    	return isValid(
    		id.memorySegment()
    	);
    }
    
    /// ```
    /// Get the body type: static, kinematic, or dynamic
    /// ```
    public static int getType(
    	MemorySegment bodyId
    ) {
    	MethodHandle method = B2_BODY_GET_TYPE.get();
    	try {
    		return (int) method.invokeExact(
    			bodyId
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#getType].
    public static int getType(
    	BodyId bodyId
    ) {
    	return getType(
    		bodyId.memorySegment()
    	);
    }
    
    /// ```
    /// Change the body type. This is an expensive operation. This automatically updates the mass
    /// properties regardless of the automatic mass setting.
    /// ```
    public static void setType(
    	MemorySegment bodyId,
    	int type
    ) {
    	MethodHandle method = B2_BODY_SET_TYPE.get();
    	try {
    		 method.invokeExact(
    			bodyId,
    			type
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#setType].
    public static void setType(
    	BodyId bodyId,
    	int type
    ) {
    	setType(
    		bodyId.memorySegment(),
    		type
    	);
    }
    
    /// ```
    /// Set the body name. See B2_NAME_LENGTH.
    /// ```
    public static void setName(
    	MemorySegment bodyId,
    	MemorySegment name
    ) {
    	MethodHandle method = B2_BODY_SET_NAME.get();
    	try {
    		 method.invokeExact(
    			bodyId,
    			name
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#setName].
    public static void setName(
    	BodyId bodyId,
    	String name
    ) {
    	try (Arena arena = MemoryStack.stackPush()) {
    		setName(
    			bodyId.memorySegment(),
    			arena.allocateFrom(name)
    		);
    	}
    }
    
    /// ```
    /// Get the body name.
    /// ```
    public static MemorySegment getName(
    	MemorySegment bodyId
    ) {
    	MethodHandle method = B2_BODY_GET_NAME.get();
    	try {
    		return (MemorySegment) method.invokeExact(
    			bodyId
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#getName].
    public static @Nullable String getName(
    	BodyId bodyId
    ) {
    	MemorySegment segment = getName(
    		bodyId.memorySegment()
    	);
    
    	if (segment.equals(MemorySegment.NULL))
    		return null;
    	
    	return segment.getString(0);
    }
    
    /// ```
    /// Set the user data for a body
    /// ```
    public static void setUserData(
    	MemorySegment bodyId,
    	MemorySegment userData
    ) {
    	MethodHandle method = B2_BODY_SET_USER_DATA.get();
    	try {
    		 method.invokeExact(
    			bodyId,
    			userData
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#setUserData].
    public static void setUserData(
    	BodyId bodyId,
    	MemorySegment userData
    ) {
    	setUserData(
    		bodyId.memorySegment(),
    		userData
    	);
    }
    
    /// ```
    /// Get the user data stored in a body
    /// ```
    public static MemorySegment getUserData(
    	MemorySegment bodyId
    ) {
    	MethodHandle method = B2_BODY_GET_USER_DATA.get();
    	try {
    		return (MemorySegment) method.invokeExact(
    			bodyId
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#getUserData].
    public static @Nullable MemorySegment getUserData(
    	BodyId bodyId
    ) {
    	MemorySegment segment = getUserData(
    		bodyId.memorySegment()
    	);
    
    	if (segment.equals(MemorySegment.NULL))
    		return null;
    	
    	return segment;
    }
    
    /// ```
    /// Get the world position of a body. This is the location of the body origin.
    /// ```
    public static MemorySegment getPosition(
    	SegmentAllocator allocator,
    	MemorySegment bodyId
    ) {
    	MethodHandle method = B2_BODY_GET_POSITION.get();
    	try {
    		return (MemorySegment) method.invokeExact(
    			allocator,
    			bodyId
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#getPosition].
    public static @Nullable Vec2 getPosition(
    	SegmentAllocator allocator,
    	BodyId bodyId
    ) {
    	MemorySegment segment = getPosition(
    		allocator,
    		bodyId.memorySegment()
    	);
    
    	if (segment.equals(MemorySegment.NULL))
    		return null;
    	
    	return new Vec2(segment);
    }
    
    /// ```
    /// Get the world rotation of a body as a cosine/sine pair (complex number)
    /// ```
    public static MemorySegment getRotation(
    	SegmentAllocator allocator,
    	MemorySegment bodyId
    ) {
    	MethodHandle method = B2_BODY_GET_ROTATION.get();
    	try {
    		return (MemorySegment) method.invokeExact(
    			allocator,
    			bodyId
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#getRotation].
    public static @Nullable Rot getRotation(
    	SegmentAllocator allocator,
    	BodyId bodyId
    ) {
    	MemorySegment segment = getRotation(
    		allocator,
    		bodyId.memorySegment()
    	);
    
    	if (segment.equals(MemorySegment.NULL))
    		return null;
    	
    	return new Rot(segment);
    }
    
    /// ```
    /// Get the world transform of a body.
    /// ```
    public static MemorySegment getTransform(
    	SegmentAllocator allocator,
    	MemorySegment bodyId
    ) {
    	MethodHandle method = B2_BODY_GET_TRANSFORM.get();
    	try {
    		return (MemorySegment) method.invokeExact(
    			allocator,
    			bodyId
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#getTransform].
    public static @Nullable Transform getTransform(
    	SegmentAllocator allocator,
    	BodyId bodyId
    ) {
    	MemorySegment segment = getTransform(
    		allocator,
    		bodyId.memorySegment()
    	);
    
    	if (segment.equals(MemorySegment.NULL))
    		return null;
    	
    	return new Transform(segment);
    }
    
    /// ```
    /// Set the world transform of a body. This acts as a teleport and is fairly expensive.
    /// @note Generally you should create a body with the intended transform.
    /// @see b2BodyDef::position and b2BodyDef::rotation
    /// ```
    public static void setTransform(
    	MemorySegment bodyId,
    	MemorySegment position,
    	MemorySegment rotation
    ) {
    	MethodHandle method = B2_BODY_SET_TRANSFORM.get();
    	try {
    		 method.invokeExact(
    			bodyId,
    			position,
    			rotation
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#setTransform].
    public static void setTransform(
    	BodyId bodyId,
    	Vec2 position,
    	Rot rotation
    ) {
    	setTransform(
    		bodyId.memorySegment(),
    		position.memorySegment(),
    		rotation.memorySegment()
    	);
    }
    
    /// ```
    /// Get a local point on a body given a world point
    /// ```
    public static MemorySegment getLocalPoint(
    	SegmentAllocator allocator,
    	MemorySegment bodyId,
    	MemorySegment worldPoint
    ) {
    	MethodHandle method = B2_BODY_GET_LOCAL_POINT.get();
    	try {
    		return (MemorySegment) method.invokeExact(
    			allocator,
    			bodyId,
    			worldPoint
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#getLocalPoint].
    public static @Nullable Vec2 getLocalPoint(
    	SegmentAllocator allocator,
    	BodyId bodyId,
    	Vec2 worldPoint
    ) {
    	MemorySegment segment = getLocalPoint(
    		allocator,
    		bodyId.memorySegment(),
    		worldPoint.memorySegment()
    	);
    
    	if (segment.equals(MemorySegment.NULL))
    		return null;
    	
    	return new Vec2(segment);
    }
    
    /// ```
    /// Get a world point on a body given a local point
    /// ```
    public static MemorySegment getWorldPoint(
    	SegmentAllocator allocator,
    	MemorySegment bodyId,
    	MemorySegment localPoint
    ) {
    	MethodHandle method = B2_BODY_GET_WORLD_POINT.get();
    	try {
    		return (MemorySegment) method.invokeExact(
    			allocator,
    			bodyId,
    			localPoint
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#getWorldPoint].
    public static @Nullable Vec2 getWorldPoint(
    	SegmentAllocator allocator,
    	BodyId bodyId,
    	Vec2 localPoint
    ) {
    	MemorySegment segment = getWorldPoint(
    		allocator,
    		bodyId.memorySegment(),
    		localPoint.memorySegment()
    	);
    
    	if (segment.equals(MemorySegment.NULL))
    		return null;
    	
    	return new Vec2(segment);
    }
    
    /// ```
    /// Get a local vector on a body given a world vector
    /// ```
    public static MemorySegment getLocalVector(
    	SegmentAllocator allocator,
    	MemorySegment bodyId,
    	MemorySegment worldVector
    ) {
    	MethodHandle method = B2_BODY_GET_LOCAL_VECTOR.get();
    	try {
    		return (MemorySegment) method.invokeExact(
    			allocator,
    			bodyId,
    			worldVector
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#getLocalVector].
    public static @Nullable Vec2 getLocalVector(
    	SegmentAllocator allocator,
    	BodyId bodyId,
    	Vec2 worldVector
    ) {
    	MemorySegment segment = getLocalVector(
    		allocator,
    		bodyId.memorySegment(),
    		worldVector.memorySegment()
    	);
    
    	if (segment.equals(MemorySegment.NULL))
    		return null;
    	
    	return new Vec2(segment);
    }
    
    /// ```
    /// Get a world vector on a body given a local vector
    /// ```
    public static MemorySegment getWorldVector(
    	SegmentAllocator allocator,
    	MemorySegment bodyId,
    	MemorySegment localVector
    ) {
    	MethodHandle method = B2_BODY_GET_WORLD_VECTOR.get();
    	try {
    		return (MemorySegment) method.invokeExact(
    			allocator,
    			bodyId,
    			localVector
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#getWorldVector].
    public static @Nullable Vec2 getWorldVector(
    	SegmentAllocator allocator,
    	BodyId bodyId,
    	Vec2 localVector
    ) {
    	MemorySegment segment = getWorldVector(
    		allocator,
    		bodyId.memorySegment(),
    		localVector.memorySegment()
    	);
    
    	if (segment.equals(MemorySegment.NULL))
    		return null;
    	
    	return new Vec2(segment);
    }
    
    /// ```
    /// Get the linear velocity of a body's center of mass. Usually in meters per second.
    /// ```
    public static MemorySegment getLinearVelocity(
    	SegmentAllocator allocator,
    	MemorySegment bodyId
    ) {
    	MethodHandle method = B2_BODY_GET_LINEAR_VELOCITY.get();
    	try {
    		return (MemorySegment) method.invokeExact(
    			allocator,
    			bodyId
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#getLinearVelocity].
    public static @Nullable Vec2 getLinearVelocity(
    	SegmentAllocator allocator,
    	BodyId bodyId
    ) {
    	MemorySegment segment = getLinearVelocity(
    		allocator,
    		bodyId.memorySegment()
    	);
    
    	if (segment.equals(MemorySegment.NULL))
    		return null;
    	
    	return new Vec2(segment);
    }
    
    /// ```
    /// Get the angular velocity of a body in radians per second
    /// ```
    public static float getAngularVelocity(
    	MemorySegment bodyId
    ) {
    	MethodHandle method = B2_BODY_GET_ANGULAR_VELOCITY.get();
    	try {
    		return (float) method.invokeExact(
    			bodyId
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#getAngularVelocity].
    public static float getAngularVelocity(
    	BodyId bodyId
    ) {
    	return getAngularVelocity(
    		bodyId.memorySegment()
    	);
    }
    
    /// ```
    /// Set the linear velocity of a body. Usually in meters per second.
    /// ```
    public static void setLinearVelocity(
    	MemorySegment bodyId,
    	MemorySegment linearVelocity
    ) {
    	MethodHandle method = B2_BODY_SET_LINEAR_VELOCITY.get();
    	try {
    		 method.invokeExact(
    			bodyId,
    			linearVelocity
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#setLinearVelocity].
    public static void setLinearVelocity(
    	BodyId bodyId,
    	Vec2 linearVelocity
    ) {
    	setLinearVelocity(
    		bodyId.memorySegment(),
    		linearVelocity.memorySegment()
    	);
    }
    
    /// ```
    /// Set the angular velocity of a body in radians per second
    /// ```
    public static void setAngularVelocity(
    	MemorySegment bodyId,
    	float angularVelocity
    ) {
    	MethodHandle method = B2_BODY_SET_ANGULAR_VELOCITY.get();
    	try {
    		 method.invokeExact(
    			bodyId,
    			angularVelocity
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#setAngularVelocity].
    public static void setAngularVelocity(
    	BodyId bodyId,
    	float angularVelocity
    ) {
    	setAngularVelocity(
    		bodyId.memorySegment(),
    		angularVelocity
    	);
    }
    
    /// ```
    /// Set the velocity to reach the given transform after a given time step. The result will be close
    /// but may not be exact. This is meant for kinematic bodies. The target is not applied if the
    /// velocity would be below the sleep threshold and the body is currently asleep.
    /// @param bodyId The body id
    /// @param target The target transform for the body
    /// @param timeStep The time step of the next call to b2World_Step
    /// @param wake Option to wake the body or not
    /// ```
    public static void setTargetTransform(
    	MemorySegment bodyId,
    	MemorySegment target,
    	float timeStep,
    	boolean wake
    ) {
    	MethodHandle method = B2_BODY_SET_TARGET_TRANSFORM.get();
    	try {
    		 method.invokeExact(
    			bodyId,
    			target,
    			timeStep,
    			wake
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#setTargetTransform].
    public static void setTargetTransform(
    	BodyId bodyId,
    	Transform target,
    	float timeStep,
    	boolean wake
    ) {
    	setTargetTransform(
    		bodyId.memorySegment(),
    		target.memorySegment(),
    		timeStep,
    		wake
    	);
    }
    
    /// ```
    /// Get the linear velocity of a local point attached to a body. Usually in meters per second.
    /// ```
    public static MemorySegment getLocalPointVelocity(
    	SegmentAllocator allocator,
    	MemorySegment bodyId,
    	MemorySegment localPoint
    ) {
    	MethodHandle method = B2_BODY_GET_LOCAL_POINT_VELOCITY.get();
    	try {
    		return (MemorySegment) method.invokeExact(
    			allocator,
    			bodyId,
    			localPoint
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#getLocalPointVelocity].
    public static @Nullable Vec2 getLocalPointVelocity(
    	SegmentAllocator allocator,
    	BodyId bodyId,
    	Vec2 localPoint
    ) {
    	MemorySegment segment = getLocalPointVelocity(
    		allocator,
    		bodyId.memorySegment(),
    		localPoint.memorySegment()
    	);
    
    	if (segment.equals(MemorySegment.NULL))
    		return null;
    	
    	return new Vec2(segment);
    }
    
    /// ```
    /// Get the linear velocity of a world point attached to a body. Usually in meters per second.
    /// ```
    public static MemorySegment getWorldPointVelocity(
    	SegmentAllocator allocator,
    	MemorySegment bodyId,
    	MemorySegment worldPoint
    ) {
    	MethodHandle method = B2_BODY_GET_WORLD_POINT_VELOCITY.get();
    	try {
    		return (MemorySegment) method.invokeExact(
    			allocator,
    			bodyId,
    			worldPoint
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#getWorldPointVelocity].
    public static @Nullable Vec2 getWorldPointVelocity(
    	SegmentAllocator allocator,
    	BodyId bodyId,
    	Vec2 worldPoint
    ) {
    	MemorySegment segment = getWorldPointVelocity(
    		allocator,
    		bodyId.memorySegment(),
    		worldPoint.memorySegment()
    	);
    
    	if (segment.equals(MemorySegment.NULL))
    		return null;
    	
    	return new Vec2(segment);
    }
    
    /// ```
    /// Apply a force at a world point. If the force is not applied at the center of mass, it will
    /// generate a torque and affect the angular velocity. This optionally wakes up the body. The force
    /// is ignored if the body is not awake.
    /// @param bodyId The body id
    /// @param force The world force vector, usually in newtons (N)
    /// @param point The world position of the point of application
    /// @param wake Option to wake up the body
    /// ```
    public static void applyForce(
    	MemorySegment bodyId,
    	MemorySegment force,
    	MemorySegment point,
    	boolean wake
    ) {
    	MethodHandle method = B2_BODY_APPLY_FORCE.get();
    	try {
    		 method.invokeExact(
    			bodyId,
    			force,
    			point,
    			wake
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#applyForce].
    public static void applyForce(
    	BodyId bodyId,
    	Vec2 force,
    	Vec2 point,
    	boolean wake
    ) {
    	applyForce(
    		bodyId.memorySegment(),
    		force.memorySegment(),
    		point.memorySegment(),
    		wake
    	);
    }
    
    /// ```
    /// Apply a force to the center of mass. This optionally wakes up the body. The force is ignored if
    /// the body is not awake.
    /// @param bodyId The body id
    /// @param force the world force vector, usually in newtons (N).
    /// @param wake also wake up the body
    /// ```
    public static void applyForceToCenter(
    	MemorySegment bodyId,
    	MemorySegment force,
    	boolean wake
    ) {
    	MethodHandle method = B2_BODY_APPLY_FORCE_TO_CENTER.get();
    	try {
    		 method.invokeExact(
    			bodyId,
    			force,
    			wake
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#applyForceToCenter].
    public static void applyForceToCenter(
    	BodyId bodyId,
    	Vec2 force,
    	boolean wake
    ) {
    	applyForceToCenter(
    		bodyId.memorySegment(),
    		force.memorySegment(),
    		wake
    	);
    }
    
    /// ```
    /// Apply a torque. This affects the angular velocity without affecting the linear velocity. This
    /// optionally wakes the body. The torque is ignored if the body is not awake.
    /// @param bodyId The body id
    /// @param torque about the z-axis (out of the screen), usually in N*m.
    /// @param wake also wake up the body
    /// ```
    public static void applyTorque(
    	MemorySegment bodyId,
    	float torque,
    	boolean wake
    ) {
    	MethodHandle method = B2_BODY_APPLY_TORQUE.get();
    	try {
    		 method.invokeExact(
    			bodyId,
    			torque,
    			wake
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#applyTorque].
    public static void applyTorque(
    	BodyId bodyId,
    	float torque,
    	boolean wake
    ) {
    	applyTorque(
    		bodyId.memorySegment(),
    		torque,
    		wake
    	);
    }
    
    /// ```
    /// Clear the force and torque on this body. Forces and torques are automatically cleared after each
    /// world step. So this only needs to be called if the application wants to remove the effect of
    /// previous calls to apply forces and torques before the world step is called.
    /// @param bodyId The body id
    /// ```
    public static void clearForces(
    	MemorySegment bodyId
    ) {
    	MethodHandle method = B2_BODY_CLEAR_FORCES.get();
    	try {
    		 method.invokeExact(
    			bodyId
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#clearForces].
    public static void clearForces(
    	BodyId bodyId
    ) {
    	clearForces(
    		bodyId.memorySegment()
    	);
    }
    
    /// ```
    /// Apply an impulse at a point. This immediately modifies the velocity. It also modifies the
    /// angular velocity if the point of application is not at the center of mass. This optionally wakes
    /// the body. The impulse is ignored if the body is not awake.
    /// @param bodyId The body id
    /// @param impulse the world impulse vector, usually in N*s or kg*m/s.
    /// @param point the world position of the point of application.
    /// @param wake also wake up the body
    /// @warning This should be used for one-shot impulses. If you need a steady force, use a force
    /// instead, which will work better with the sub-stepping solver.
    /// ```
    public static void applyLinearImpulse(
    	MemorySegment bodyId,
    	MemorySegment impulse,
    	MemorySegment point,
    	boolean wake
    ) {
    	MethodHandle method = B2_BODY_APPLY_LINEAR_IMPULSE.get();
    	try {
    		 method.invokeExact(
    			bodyId,
    			impulse,
    			point,
    			wake
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#applyLinearImpulse].
    public static void applyLinearImpulse(
    	BodyId bodyId,
    	Vec2 impulse,
    	Vec2 point,
    	boolean wake
    ) {
    	applyLinearImpulse(
    		bodyId.memorySegment(),
    		impulse.memorySegment(),
    		point.memorySegment(),
    		wake
    	);
    }
    
    /// ```
    /// Apply an impulse to the center of mass. This immediately modifies the velocity. The impulse is
    /// ignored if the body is not awake. This optionally wakes the body.
    /// @param bodyId The body id
    /// @param impulse the world impulse vector, usually in N*s or kg*m/s.
    /// @param wake also wake up the body
    /// @warning This should be used for one-shot impulses. If you need a steady force, use a force
    /// instead, which will work better with the sub-stepping solver.
    /// ```
    public static void applyLinearImpulseToCenter(
    	MemorySegment bodyId,
    	MemorySegment impulse,
    	boolean wake
    ) {
    	MethodHandle method = B2_BODY_APPLY_LINEAR_IMPULSE_TO_CENTER.get();
    	try {
    		 method.invokeExact(
    			bodyId,
    			impulse,
    			wake
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#applyLinearImpulseToCenter].
    public static void applyLinearImpulseToCenter(
    	BodyId bodyId,
    	Vec2 impulse,
    	boolean wake
    ) {
    	applyLinearImpulseToCenter(
    		bodyId.memorySegment(),
    		impulse.memorySegment(),
    		wake
    	);
    }
    
    /// ```
    /// Apply an angular impulse. The impulse is ignored if the body is not awake. This optionally wakes
    /// the body.
    /// @param bodyId The body id
    /// @param impulse the angular impulse, usually in units of kg*m*m/s
    /// @param wake also wake up the body
    /// @warning This should be used for one-shot impulses. If you need a steady torque, use a torque
    /// instead, which will work better with the sub-stepping solver.
    /// ```
    public static void applyAngularImpulse(
    	MemorySegment bodyId,
    	float impulse,
    	boolean wake
    ) {
    	MethodHandle method = B2_BODY_APPLY_ANGULAR_IMPULSE.get();
    	try {
    		 method.invokeExact(
    			bodyId,
    			impulse,
    			wake
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#applyAngularImpulse].
    public static void applyAngularImpulse(
    	BodyId bodyId,
    	float impulse,
    	boolean wake
    ) {
    	applyAngularImpulse(
    		bodyId.memorySegment(),
    		impulse,
    		wake
    	);
    }
    
    /// ```
    /// Get the mass of the body, usually in kilograms
    /// ```
    public static float getMass(
    	MemorySegment bodyId
    ) {
    	MethodHandle method = B2_BODY_GET_MASS.get();
    	try {
    		return (float) method.invokeExact(
    			bodyId
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#getMass].
    public static float getMass(
    	BodyId bodyId
    ) {
    	return getMass(
    		bodyId.memorySegment()
    	);
    }
    
    /// ```
    /// Get the rotational inertia of the body, usually in kg*m^2
    /// ```
    public static float getRotationalInertia(
    	MemorySegment bodyId
    ) {
    	MethodHandle method = B2_BODY_GET_ROTATIONAL_INERTIA.get();
    	try {
    		return (float) method.invokeExact(
    			bodyId
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#getRotationalInertia].
    public static float getRotationalInertia(
    	BodyId bodyId
    ) {
    	return getRotationalInertia(
    		bodyId.memorySegment()
    	);
    }
    
    /// ```
    /// Get the center of mass position of the body in local space.
    /// ```
    public static MemorySegment getLocalCenter(
    	SegmentAllocator allocator,
    	MemorySegment bodyId
    ) {
    	MethodHandle method = B2_BODY_GET_LOCAL_CENTER.get();
    	try {
    		return (MemorySegment) method.invokeExact(
    			allocator,
    			bodyId
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#getLocalCenter].
    public static @Nullable Vec2 getLocalCenter(
    	SegmentAllocator allocator,
    	BodyId bodyId
    ) {
    	MemorySegment segment = getLocalCenter(
    		allocator,
    		bodyId.memorySegment()
    	);
    
    	if (segment.equals(MemorySegment.NULL))
    		return null;
    	
    	return new Vec2(segment);
    }
    
    /// ```
    /// Get the center of mass position of the body in world space.
    /// ```
    public static MemorySegment getWorldCenter(
    	SegmentAllocator allocator,
    	MemorySegment bodyId
    ) {
    	MethodHandle method = B2_BODY_GET_WORLD_CENTER.get();
    	try {
    		return (MemorySegment) method.invokeExact(
    			allocator,
    			bodyId
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#getWorldCenter].
    public static @Nullable Vec2 getWorldCenter(
    	SegmentAllocator allocator,
    	BodyId bodyId
    ) {
    	MemorySegment segment = getWorldCenter(
    		allocator,
    		bodyId.memorySegment()
    	);
    
    	if (segment.equals(MemorySegment.NULL))
    		return null;
    	
    	return new Vec2(segment);
    }
    
    /// ```
    /// Override the body's mass properties. Normally this is computed automatically using the shape
    /// geometry and density. This information is lost if a shape is added or removed or if the body
    /// type changes. If motion locks are used to fix rotation then the rotational inertia value is
    /// ignored and rotational inertia remains fixed at zero.
    /// ```
    public static void setMassData(
    	MemorySegment bodyId,
    	MemorySegment massData
    ) {
    	MethodHandle method = B2_BODY_SET_MASS_DATA.get();
    	try {
    		 method.invokeExact(
    			bodyId,
    			massData
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#setMassData].
    public static void setMassData(
    	BodyId bodyId,
    	MassData massData
    ) {
    	setMassData(
    		bodyId.memorySegment(),
    		massData.memorySegment()
    	);
    }
    
    /// ```
    /// Get the mass data for a body
    /// ```
    public static MemorySegment getMassData(
    	SegmentAllocator allocator,
    	MemorySegment bodyId
    ) {
    	MethodHandle method = B2_BODY_GET_MASS_DATA.get();
    	try {
    		return (MemorySegment) method.invokeExact(
    			allocator,
    			bodyId
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#getMassData].
    public static @Nullable MassData getMassData(
    	SegmentAllocator allocator,
    	BodyId bodyId
    ) {
    	MemorySegment segment = getMassData(
    		allocator,
    		bodyId.memorySegment()
    	);
    
    	if (segment.equals(MemorySegment.NULL))
    		return null;
    	
    	return new MassData(segment);
    }
    
    /// ```
    /// This updates the mass properties to the sum of the mass properties of the shapes. This normally
    /// does not need to be called unless you called b2Body_SetMassData to override the mass and you
    /// later want to reset the mass. You may also use this when automatic mass computation has been
    /// disabled. You should call this regardless of body type. Note that sensor shapes may have mass.
    /// ```
    public static void updateMassFromShapes(
    	MemorySegment bodyId
    ) {
    	MethodHandle method = B2_BODY_UPDATE_MASS_FROM_SHAPES.get();
    	try {
    		 method.invokeExact(
    			bodyId
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#updateMassFromShapes].
    public static void updateMassFromShapes(
    	BodyId bodyId
    ) {
    	updateMassFromShapes(
    		bodyId.memorySegment()
    	);
    }
    
    /// ```
    /// Adjust the linear damping. Normally this is set in b2BodyDef before creation.
    /// ```
    public static void setLinearDamping(
    	MemorySegment bodyId,
    	float linearDamping
    ) {
    	MethodHandle method = B2_BODY_SET_LINEAR_DAMPING.get();
    	try {
    		 method.invokeExact(
    			bodyId,
    			linearDamping
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#setLinearDamping].
    public static void setLinearDamping(
    	BodyId bodyId,
    	float linearDamping
    ) {
    	setLinearDamping(
    		bodyId.memorySegment(),
    		linearDamping
    	);
    }
    
    /// ```
    /// Get the current linear damping.
    /// ```
    public static float getLinearDamping(
    	MemorySegment bodyId
    ) {
    	MethodHandle method = B2_BODY_GET_LINEAR_DAMPING.get();
    	try {
    		return (float) method.invokeExact(
    			bodyId
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#getLinearDamping].
    public static float getLinearDamping(
    	BodyId bodyId
    ) {
    	return getLinearDamping(
    		bodyId.memorySegment()
    	);
    }
    
    /// ```
    /// Adjust the angular damping. Normally this is set in b2BodyDef before creation.
    /// ```
    public static void setAngularDamping(
    	MemorySegment bodyId,
    	float angularDamping
    ) {
    	MethodHandle method = B2_BODY_SET_ANGULAR_DAMPING.get();
    	try {
    		 method.invokeExact(
    			bodyId,
    			angularDamping
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#setAngularDamping].
    public static void setAngularDamping(
    	BodyId bodyId,
    	float angularDamping
    ) {
    	setAngularDamping(
    		bodyId.memorySegment(),
    		angularDamping
    	);
    }
    
    /// ```
    /// Get the current angular damping.
    /// ```
    public static float getAngularDamping(
    	MemorySegment bodyId
    ) {
    	MethodHandle method = B2_BODY_GET_ANGULAR_DAMPING.get();
    	try {
    		return (float) method.invokeExact(
    			bodyId
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#getAngularDamping].
    public static float getAngularDamping(
    	BodyId bodyId
    ) {
    	return getAngularDamping(
    		bodyId.memorySegment()
    	);
    }
    
    /// ```
    /// Adjust the gravity scale. Normally this is set in b2BodyDef before creation.
    /// @see b2BodyDef::gravityScale
    /// ```
    public static void setGravityScale(
    	MemorySegment bodyId,
    	float gravityScale
    ) {
    	MethodHandle method = B2_BODY_SET_GRAVITY_SCALE.get();
    	try {
    		 method.invokeExact(
    			bodyId,
    			gravityScale
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#setGravityScale].
    public static void setGravityScale(
    	BodyId bodyId,
    	float gravityScale
    ) {
    	setGravityScale(
    		bodyId.memorySegment(),
    		gravityScale
    	);
    }
    
    /// ```
    /// Get the current gravity scale
    /// ```
    public static float getGravityScale(
    	MemorySegment bodyId
    ) {
    	MethodHandle method = B2_BODY_GET_GRAVITY_SCALE.get();
    	try {
    		return (float) method.invokeExact(
    			bodyId
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#getGravityScale].
    public static float getGravityScale(
    	BodyId bodyId
    ) {
    	return getGravityScale(
    		bodyId.memorySegment()
    	);
    }
    
    /// ```
    /// @return true if this body is awake
    /// ```
    public static boolean isAwake(
    	MemorySegment bodyId
    ) {
    	MethodHandle method = B2_BODY_IS_AWAKE.get();
    	try {
    		return (boolean) method.invokeExact(
    			bodyId
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#isAwake].
    public static boolean isAwake(
    	BodyId bodyId
    ) {
    	return isAwake(
    		bodyId.memorySegment()
    	);
    }
    
    /// ```
    /// Wake a body from sleep. This wakes the entire island the body is touching.
    /// @warning Putting a body to sleep will put the entire island of bodies touching this body to
    /// sleep, which can be expensive and possibly unintuitive.
    /// ```
    public static void setAwake(
    	MemorySegment bodyId,
    	boolean awake
    ) {
    	MethodHandle method = B2_BODY_SET_AWAKE.get();
    	try {
    		 method.invokeExact(
    			bodyId,
    			awake
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#setAwake].
    public static void setAwake(
    	BodyId bodyId,
    	boolean awake
    ) {
    	setAwake(
    		bodyId.memorySegment(),
    		awake
    	);
    }
    
    /// ```
    /// Wake bodies touching this body. Works for static bodies.
    /// ```
    public static void wakeTouching(
    	MemorySegment bodyId
    ) {
    	MethodHandle method = B2_BODY_WAKE_TOUCHING.get();
    	try {
    		 method.invokeExact(
    			bodyId
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#wakeTouching].
    public static void wakeTouching(
    	BodyId bodyId
    ) {
    	wakeTouching(
    		bodyId.memorySegment()
    	);
    }
    
    /// ```
    /// Enable or disable sleeping for this body. If sleeping is disabled the body will wake (and the
    /// entire island).
    /// ```
    public static void enableSleeping(
    	MemorySegment bodyId,
    	boolean enableSleep
    ) {
    	MethodHandle method = B2_BODY_ENABLE_SLEEPING.get();
    	try {
    		 method.invokeExact(
    			bodyId,
    			enableSleep
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#enableSleeping].
    public static void enableSleeping(
    	BodyId bodyId,
    	boolean enableSleep
    ) {
    	enableSleeping(
    		bodyId.memorySegment(),
    		enableSleep
    	);
    }
    
    /// ```
    /// Returns true if sleeping is enabled for this body
    /// ```
    public static boolean isSleepingEnabled(
    	MemorySegment bodyId
    ) {
    	MethodHandle method = B2_BODY_IS_SLEEPING_ENABLED.get();
    	try {
    		return (boolean) method.invokeExact(
    			bodyId
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#isSleepingEnabled].
    public static boolean isSleepingEnabled(
    	BodyId bodyId
    ) {
    	return isSleepingEnabled(
    		bodyId.memorySegment()
    	);
    }
    
    /// ```
    /// Set the sleep threshold, usually in meters per second
    /// ```
    public static void setSleepThreshold(
    	MemorySegment bodyId,
    	float sleepThreshold
    ) {
    	MethodHandle method = B2_BODY_SET_SLEEP_THRESHOLD.get();
    	try {
    		 method.invokeExact(
    			bodyId,
    			sleepThreshold
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#setSleepThreshold].
    public static void setSleepThreshold(
    	BodyId bodyId,
    	float sleepThreshold
    ) {
    	setSleepThreshold(
    		bodyId.memorySegment(),
    		sleepThreshold
    	);
    }
    
    /// ```
    /// Get the sleep threshold, usually in meters per second.
    /// ```
    public static float getSleepThreshold(
    	MemorySegment bodyId
    ) {
    	MethodHandle method = B2_BODY_GET_SLEEP_THRESHOLD.get();
    	try {
    		return (float) method.invokeExact(
    			bodyId
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#getSleepThreshold].
    public static float getSleepThreshold(
    	BodyId bodyId
    ) {
    	return getSleepThreshold(
    		bodyId.memorySegment()
    	);
    }
    
    /// ```
    /// Set the continuous collision safety factor. Smaller is safer but can lead to hitching.
    /// Recommended range [0.01, 0.5]. Non-dimensional.
    /// ```
    public static void setSafetyFactor(
    	MemorySegment bodyId,
    	float safetyFactor
    ) {
    	MethodHandle method = B2_BODY_SET_SAFETY_FACTOR.get();
    	try {
    		 method.invokeExact(
    			bodyId,
    			safetyFactor
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#setSafetyFactor].
    public static void setSafetyFactor(
    	BodyId bodyId,
    	float safetyFactor
    ) {
    	setSafetyFactor(
    		bodyId.memorySegment(),
    		safetyFactor
    	);
    }
    
    /// ```
    /// Get the continuous collision safety factor. Non-dimensional.
    /// ```
    public static float getSafetyFactor(
    	MemorySegment bodyId
    ) {
    	MethodHandle method = B2_BODY_GET_SAFETY_FACTOR.get();
    	try {
    		return (float) method.invokeExact(
    			bodyId
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#getSafetyFactor].
    public static float getSafetyFactor(
    	BodyId bodyId
    ) {
    	return getSafetyFactor(
    		bodyId.memorySegment()
    	);
    }
    
    /// ```
    /// Returns true if this body is enabled
    /// ```
    public static boolean isEnabled(
    	MemorySegment bodyId
    ) {
    	MethodHandle method = B2_BODY_IS_ENABLED.get();
    	try {
    		return (boolean) method.invokeExact(
    			bodyId
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#isEnabled].
    public static boolean isEnabled(
    	BodyId bodyId
    ) {
    	return isEnabled(
    		bodyId.memorySegment()
    	);
    }
    
    /// ```
    /// Disable a body by removing it completely from the simulation. This is expensive.
    /// ```
    public static void disable(
    	MemorySegment bodyId
    ) {
    	MethodHandle method = B2_BODY_DISABLE.get();
    	try {
    		 method.invokeExact(
    			bodyId
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#disable].
    public static void disable(
    	BodyId bodyId
    ) {
    	disable(
    		bodyId.memorySegment()
    	);
    }
    
    /// ```
    /// Enable a body by adding it to the simulation. This is expensive.
    /// ```
    public static void enable(
    	MemorySegment bodyId
    ) {
    	MethodHandle method = B2_BODY_ENABLE.get();
    	try {
    		 method.invokeExact(
    			bodyId
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#enable].
    public static void enable(
    	BodyId bodyId
    ) {
    	enable(
    		bodyId.memorySegment()
    	);
    }
    
    /// ```
    /// Set the motion locks on this body. This causes mass properties to be recomputed because fixed
    /// rotation sets the rotational inertia to zero.
    /// ```
    public static void setMotionLocks(
    	MemorySegment bodyId,
    	MemorySegment locks
    ) {
    	MethodHandle method = B2_BODY_SET_MOTION_LOCKS.get();
    	try {
    		 method.invokeExact(
    			bodyId,
    			locks
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#setMotionLocks].
    public static void setMotionLocks(
    	BodyId bodyId,
    	MotionLocks locks
    ) {
    	setMotionLocks(
    		bodyId.memorySegment(),
    		locks.memorySegment()
    	);
    }
    
    /// ```
    /// Get the motion locks for this body.
    /// ```
    public static MemorySegment getMotionLocks(
    	SegmentAllocator allocator,
    	MemorySegment bodyId
    ) {
    	MethodHandle method = B2_BODY_GET_MOTION_LOCKS.get();
    	try {
    		return (MemorySegment) method.invokeExact(
    			allocator,
    			bodyId
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#getMotionLocks].
    public static @Nullable MotionLocks getMotionLocks(
    	SegmentAllocator allocator,
    	BodyId bodyId
    ) {
    	MemorySegment segment = getMotionLocks(
    		allocator,
    		bodyId.memorySegment()
    	);
    
    	if (segment.equals(MemorySegment.NULL))
    		return null;
    	
    	return new MotionLocks(segment);
    }
    
    /// ```
    /// Set this body to be a bullet. A bullet does continuous collision detection against dynamic
    /// and kinematic bodies (but not other bullets). This only works on dynamic bodies.
    /// ```
    public static void setBullet(
    	MemorySegment bodyId,
    	boolean flag
    ) {
    	MethodHandle method = B2_BODY_SET_BULLET.get();
    	try {
    		 method.invokeExact(
    			bodyId,
    			flag
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#setBullet].
    public static void setBullet(
    	BodyId bodyId,
    	boolean flag
    ) {
    	setBullet(
    		bodyId.memorySegment(),
    		flag
    	);
    }
    
    /// ```
    /// Is this body a bullet?
    /// ```
    public static boolean isBullet(
    	MemorySegment bodyId
    ) {
    	MethodHandle method = B2_BODY_IS_BULLET.get();
    	try {
    		return (boolean) method.invokeExact(
    			bodyId
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#isBullet].
    public static boolean isBullet(
    	BodyId bodyId
    ) {
    	return isBullet(
    		bodyId.memorySegment()
    	);
    }
    
    /// ```
    /// Enable or disable contact recycling for this body. Contact recycling is a performance
    /// optimization that reuses contact manifolds when bodies move slightly. Disabling it can avoid
    /// ghost collisions
    /// on characters at the cost of higher per-step work. Existing contacts retain their prior setting;
    /// only contacts created after this call see the new value.
    /// @see b2BodyDef::enableContactRecycling
    /// ```
    public static void enableContactRecycling(
    	MemorySegment bodyId,
    	boolean flag
    ) {
    	MethodHandle method = B2_BODY_ENABLE_CONTACT_RECYCLING.get();
    	try {
    		 method.invokeExact(
    			bodyId,
    			flag
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#enableContactRecycling].
    public static void enableContactRecycling(
    	BodyId bodyId,
    	boolean flag
    ) {
    	enableContactRecycling(
    		bodyId.memorySegment(),
    		flag
    	);
    }
    
    /// ```
    /// Is contact recycling enabled on this body?
    /// ```
    public static boolean isContactRecyclingEnabled(
    	MemorySegment bodyId
    ) {
    	MethodHandle method = B2_BODY_IS_CONTACT_RECYCLING_ENABLED.get();
    	try {
    		return (boolean) method.invokeExact(
    			bodyId
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#isContactRecyclingEnabled].
    public static boolean isContactRecyclingEnabled(
    	BodyId bodyId
    ) {
    	return isContactRecyclingEnabled(
    		bodyId.memorySegment()
    	);
    }
    
    /// ```
    /// Enable/disable contact events on all shapes.
    /// @see b2ShapeDef::enableContactEvents
    /// @warning changing this at runtime may cause mismatched begin/end touch events
    /// ```
    public static void enableContactEvents(
    	MemorySegment bodyId,
    	boolean flag
    ) {
    	MethodHandle method = B2_BODY_ENABLE_CONTACT_EVENTS.get();
    	try {
    		 method.invokeExact(
    			bodyId,
    			flag
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#enableContactEvents].
    public static void enableContactEvents(
    	BodyId bodyId,
    	boolean flag
    ) {
    	enableContactEvents(
    		bodyId.memorySegment(),
    		flag
    	);
    }
    
    /// ```
    /// Enable/disable hit events on all shapes
    /// @see b2ShapeDef::enableHitEvents
    /// ```
    public static void enableHitEvents(
    	MemorySegment bodyId,
    	boolean flag
    ) {
    	MethodHandle method = B2_BODY_ENABLE_HIT_EVENTS.get();
    	try {
    		 method.invokeExact(
    			bodyId,
    			flag
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#enableHitEvents].
    public static void enableHitEvents(
    	BodyId bodyId,
    	boolean flag
    ) {
    	enableHitEvents(
    		bodyId.memorySegment(),
    		flag
    	);
    }
    
    /// ```
    /// Get the world that owns this body
    /// ```
    public static MemorySegment getWorld(
    	SegmentAllocator allocator,
    	MemorySegment bodyId
    ) {
    	MethodHandle method = B2_BODY_GET_WORLD.get();
    	try {
    		return (MemorySegment) method.invokeExact(
    			allocator,
    			bodyId
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#getWorld].
    public static @Nullable WorldId getWorld(
    	SegmentAllocator allocator,
    	BodyId bodyId
    ) {
    	MemorySegment segment = getWorld(
    		allocator,
    		bodyId.memorySegment()
    	);
    
    	if (segment.equals(MemorySegment.NULL))
    		return null;
    	
    	return new WorldId(segment);
    }
    
    /// ```
    /// Get the number of shapes on this body
    /// ```
    public static int getShapeCount(
    	MemorySegment bodyId
    ) {
    	MethodHandle method = B2_BODY_GET_SHAPE_COUNT.get();
    	try {
    		return (int) method.invokeExact(
    			bodyId
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#getShapeCount].
    public static int getShapeCount(
    	BodyId bodyId
    ) {
    	return getShapeCount(
    		bodyId.memorySegment()
    	);
    }
    
    /// ```
    /// Get the shape ids for all shapes on this body, up to the provided capacity.
    /// @returns the number of shape ids stored in the user array
    /// ```
    public static int getShapes(
    	MemorySegment bodyId,
    	MemorySegment shapeArray,
    	int capacity
    ) {
    	MethodHandle method = B2_BODY_GET_SHAPES.get();
    	try {
    		return (int) method.invokeExact(
    			bodyId,
    			shapeArray,
    			capacity
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#getShapes].
    public static int getShapes(
    	BodyId bodyId,
    	NativeStructArray<ShapeId> shapeArray,
    	int capacity
    ) {
    	return getShapes(
    		bodyId.memorySegment(),
    		shapeArray.memorySegment(),
    		capacity
    	);
    }
    
    /// ```
    /// Get the number of joints on this body
    /// ```
    public static int getJointCount(
    	MemorySegment bodyId
    ) {
    	MethodHandle method = B2_BODY_GET_JOINT_COUNT.get();
    	try {
    		return (int) method.invokeExact(
    			bodyId
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#getJointCount].
    public static int getJointCount(
    	BodyId bodyId
    ) {
    	return getJointCount(
    		bodyId.memorySegment()
    	);
    }
    
    /// ```
    /// Get the joint ids for all joints on this body, up to the provided capacity
    /// @returns the number of joint ids stored in the user array
    /// ```
    public static int getJoints(
    	MemorySegment bodyId,
    	MemorySegment jointArray,
    	int capacity
    ) {
    	MethodHandle method = B2_BODY_GET_JOINTS.get();
    	try {
    		return (int) method.invokeExact(
    			bodyId,
    			jointArray,
    			capacity
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#getJoints].
    public static int getJoints(
    	BodyId bodyId,
    	NativeStructArray<JointId> jointArray,
    	int capacity
    ) {
    	return getJoints(
    		bodyId.memorySegment(),
    		jointArray.memorySegment(),
    		capacity
    	);
    }
    
    /// ```
    /// Get the maximum capacity required for retrieving all the touching contacts on a body
    /// ```
    public static int getContactCapacity(
    	MemorySegment bodyId
    ) {
    	MethodHandle method = B2_BODY_GET_CONTACT_CAPACITY.get();
    	try {
    		return (int) method.invokeExact(
    			bodyId
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#getContactCapacity].
    public static int getContactCapacity(
    	BodyId bodyId
    ) {
    	return getContactCapacity(
    		bodyId.memorySegment()
    	);
    }
    
    /// ```
    /// Get the touching contact data for a body.
    /// @note Box2D uses speculative collision so some contact points may be separated.
    /// @returns the number of elements filled in the provided array
    /// @warning do not ignore the return value, it specifies the valid number of elements
    /// ```
    public static int getContactData(
    	MemorySegment bodyId,
    	MemorySegment contactData,
    	int capacity
    ) {
    	MethodHandle method = B2_BODY_GET_CONTACT_DATA.get();
    	try {
    		return (int) method.invokeExact(
    			bodyId,
    			contactData,
    			capacity
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#getContactData].
    public static int getContactData(
    	BodyId bodyId,
    	ContactData contactData,
    	int capacity
    ) {
    	return getContactData(
    		bodyId.memorySegment(),
    		contactData.memorySegment(),
    		capacity
    	);
    }
    
    /// ```
    /// Get the current world AABB that contains all the attached shapes. Note that this may not
    /// encompass the body origin. If there are no shapes attached then the returned AABB is empty and
    /// centered on the body origin.
    /// ```
    public static MemorySegment computeBounds(
    	SegmentAllocator allocator,
    	MemorySegment bodyId
    ) {
    	MethodHandle method = B2_BODY_COMPUTE_BOUNDS.get();
    	try {
    		return (MemorySegment) method.invokeExact(
    			allocator,
    			bodyId
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#computeBounds].
    public static @Nullable AABB computeBounds(
    	SegmentAllocator allocator,
    	BodyId bodyId
    ) {
    	MemorySegment segment = computeBounds(
    		allocator,
    		bodyId.memorySegment()
    	);
    
    	if (segment.equals(MemorySegment.NULL))
    		return null;
    	
    	return new AABB(segment);
    }
    
    /// ```
    /// The minimum distance from any point on the body shapes to the center of mass.
    /// ```
    public static float getMinExtent(
    	MemorySegment bodyId
    ) {
    	MethodHandle method = B2_BODY_GET_MIN_EXTENT.get();
    	try {
    		return (float) method.invokeExact(
    			bodyId
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#getMinExtent].
    public static float getMinExtent(
    	BodyId bodyId
    ) {
    	return getMinExtent(
    		bodyId.memorySegment()
    	);
    }
    
    /// ```
    /// The maximum distance from any point on the body shapes to the center of mass.
    /// ```
    public static float getMaxExtent(
    	MemorySegment bodyId
    ) {
    	MethodHandle method = B2_BODY_GET_MAX_EXTENT.get();
    	try {
    		return (float) method.invokeExact(
    			bodyId
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#getMaxExtent].
    public static float getMaxExtent(
    	BodyId bodyId
    ) {
    	return getMaxExtent(
    		bodyId.memorySegment()
    	);
    }
    
    /// ```
    /// The maximum distance from any point on the body shapes to the body origin. Conservative.
    /// ```
    public static float getMaxExtentFromOrigin(
    	MemorySegment bodyId
    ) {
    	MethodHandle method = B2_BODY_GET_MAX_EXTENT_FROM_ORIGIN.get();
    	try {
    		return (float) method.invokeExact(
    			bodyId
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#getMaxExtentFromOrigin].
    public static float getMaxExtentFromOrigin(
    	BodyId bodyId
    ) {
    	return getMaxExtentFromOrigin(
    		bodyId.memorySegment()
    	);
    }

}