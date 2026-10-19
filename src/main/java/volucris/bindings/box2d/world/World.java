/*
 * MACHINE GENERATED FILE, DO NOT EDIT.
 */
package volucris.bindings.box2d.world;

import java.lang.foreign.MemorySegment;
import java.lang.foreign.SegmentAllocator;
import java.lang.invoke.MethodHandle;
import org.jspecify.annotations.Nullable;
import volucris.bindings.box2d.Profile;
import volucris.bindings.box2d.dynamicTree.TreeStats;
import volucris.bindings.box2d.events.BodyEvents;
import volucris.bindings.box2d.events.ContactEvents;
import volucris.bindings.box2d.events.JointEvents;
import volucris.bindings.box2d.events.SensorEvents;
import volucris.bindings.box2d.geometry.Capsule;
import volucris.bindings.box2d.geometry.ShapeProxy;
import volucris.bindings.box2d.math.AABB;
import volucris.bindings.box2d.math.Vec2;
import volucris.bindings.box2d.recording.Recording;
import volucris.bindings.box2d.shape.QueryFilter;
import volucris.bindings.box2d.world.debug.DebugDraw;
import volucris.bindings.core.NativeByteArray;
import volucris.bindings.core.NativeFloatArray;

import static java.lang.foreign.ValueLayout.*;
import static volucris.bindings.core.FFMUtils.*;

public final class World {

	private static final LazyConstant<MethodHandle> B2_CREATE_WORLD;
	private static final LazyConstant<MethodHandle> B2_DESTROY_WORLD;
	private static final LazyConstant<MethodHandle> B2_WORLD_IS_VALID;
	private static final LazyConstant<MethodHandle> B2_WORLD_STEP;
	private static final LazyConstant<MethodHandle> B2_WORLD_DRAW;
	private static final LazyConstant<MethodHandle> B2_WORLD_GET_BOUNDS;
	private static final LazyConstant<MethodHandle> B2_WORLD_GET_BODY_EVENTS;
	private static final LazyConstant<MethodHandle> B2_WORLD_GET_SENSOR_EVENTS;
	private static final LazyConstant<MethodHandle> B2_WORLD_GET_CONTACT_EVENTS;
	private static final LazyConstant<MethodHandle> B2_WORLD_GET_JOINT_EVENTS;
	private static final LazyConstant<MethodHandle> B2_WORLD_OVERLAP_AABB;
	private static final LazyConstant<MethodHandle> B2_WORLD_OVERLAP_SHAPE;
	private static final LazyConstant<MethodHandle> B2_WORLD_CAST_RAY;
	private static final LazyConstant<MethodHandle> B2_WORLD_CAST_RAY_CLOSEST;
	private static final LazyConstant<MethodHandle> B2_WORLD_CAST_SHAPE;
	private static final LazyConstant<MethodHandle> B2_WORLD_CAST_MOVER;
	private static final LazyConstant<MethodHandle> B2_WORLD_COLLIDE_MOVER;
	private static final LazyConstant<MethodHandle> B2_WORLD_ENABLE_SLEEPING;
	private static final LazyConstant<MethodHandle> B2_WORLD_IS_SLEEPING_ENABLED;
	private static final LazyConstant<MethodHandle> B2_WORLD_ENABLE_CONTINUOUS;
	private static final LazyConstant<MethodHandle> B2_WORLD_IS_CONTINUOUS_ENABLED;
	private static final LazyConstant<MethodHandle> B2_WORLD_SET_RESTITUTION_THRESHOLD;
	private static final LazyConstant<MethodHandle> B2_WORLD_GET_RESTITUTION_THRESHOLD;
	private static final LazyConstant<MethodHandle> B2_WORLD_SET_RESTITUTION_ITERATIONS;
	private static final LazyConstant<MethodHandle> B2_WORLD_GET_RESTITUTION_ITERATIONS;
	private static final LazyConstant<MethodHandle> B2_WORLD_ENABLE_RESTITUTION_PROPAGATION;
	private static final LazyConstant<MethodHandle> B2_WORLD_IS_RESTITUTION_PROPAGATION_ENABLED;
	private static final LazyConstant<MethodHandle> B2_WORLD_SET_HIT_EVENT_THRESHOLD;
	private static final LazyConstant<MethodHandle> B2_WORLD_GET_HIT_EVENT_THRESHOLD;
	private static final LazyConstant<MethodHandle> B2_WORLD_SET_CUSTOM_FILTER_CALLBACK;
	private static final LazyConstant<MethodHandle> B2_WORLD_SET_PRE_SOLVE_CALLBACK;
	private static final LazyConstant<MethodHandle> B2_WORLD_SET_GRAVITY;
	private static final LazyConstant<MethodHandle> B2_WORLD_GET_GRAVITY;
	private static final LazyConstant<MethodHandle> B2_WORLD_EXPLODE;
	private static final LazyConstant<MethodHandle> B2_WORLD_SET_CONTACT_TUNING;
	private static final LazyConstant<MethodHandle> B2_WORLD_GET_CONTACT_TUNING;
	private static final LazyConstant<MethodHandle> B2_WORLD_SET_CONTACT_RECYCLE_DISTANCE;
	private static final LazyConstant<MethodHandle> B2_WORLD_GET_CONTACT_RECYCLE_DISTANCE;
	private static final LazyConstant<MethodHandle> B2_WORLD_SET_MAX_LINEAR_SPEED;
	private static final LazyConstant<MethodHandle> B2_WORLD_GET_MAX_LINEAR_SPEED;
	private static final LazyConstant<MethodHandle> B2_WORLD_ENABLE_WARM_STARTING;
	private static final LazyConstant<MethodHandle> B2_WORLD_IS_WARM_STARTING_ENABLED;
	private static final LazyConstant<MethodHandle> B2_WORLD_ENABLE_SSE2_FALLBACK;
	private static final LazyConstant<MethodHandle> B2_WORLD_GET_AWAKE_BODY_COUNT;
	private static final LazyConstant<MethodHandle> B2_WORLD_GET_PROFILE;
	private static final LazyConstant<MethodHandle> B2_WORLD_GET_COUNTERS;
	private static final LazyConstant<MethodHandle> B2_WORLD_GET_MAX_CAPACITY;
	private static final LazyConstant<MethodHandle> B2_WORLD_SET_USER_DATA;
	private static final LazyConstant<MethodHandle> B2_WORLD_GET_USER_DATA;
	private static final LazyConstant<MethodHandle> B2_WORLD_SET_FRICTION_CALLBACK;
	private static final LazyConstant<MethodHandle> B2_WORLD_SET_RESTITUTION_CALLBACK;
	private static final LazyConstant<MethodHandle> B2_WORLD_SET_WORKER_COUNT;
	private static final LazyConstant<MethodHandle> B2_WORLD_GET_WORKER_COUNT;
	private static final LazyConstant<MethodHandle> B2_WORLD_DUMP_MEMORY_STATS;
	private static final LazyConstant<MethodHandle> B2_WORLD_REBUILD_STATIC_TREE;
	private static final LazyConstant<MethodHandle> B2_WORLD_GET_STATE_HASH;
	private static final LazyConstant<MethodHandle> B2_WORLD_START_RECORDING;
	private static final LazyConstant<MethodHandle> B2_WORLD_STOP_RECORDING;
	private static final LazyConstant<MethodHandle> B2_WORLD_GET_SNAPSHOT;
	private static final LazyConstant<MethodHandle> B2_WORLD_RESTORE_FROM_SNAPSHOT;
	private static final LazyConstant<MethodHandle> B2_CREATE_WORLD_FROM_SNAPSHOT;

	static {
		//@formatter:off
		B2_CREATE_WORLD = downcallHandle("b2CreateWorld", WorldId.LAYOUT, UNBOUNDED_ADDRESS);
		B2_DESTROY_WORLD = downcallHandleVoid("b2DestroyWorld", WorldId.LAYOUT);
		B2_WORLD_IS_VALID = downcallHandle("b2World_IsValid", JAVA_BOOLEAN, WorldId.LAYOUT);
		B2_WORLD_STEP = downcallHandleVoid("b2World_Step", WorldId.LAYOUT, JAVA_FLOAT, JAVA_INT);
		B2_WORLD_DRAW = downcallHandleVoid("b2World_Draw", WorldId.LAYOUT, UNBOUNDED_ADDRESS);
		B2_WORLD_GET_BOUNDS = downcallHandle("b2World_GetBounds", AABB.LAYOUT, WorldId.LAYOUT);
		B2_WORLD_GET_BODY_EVENTS = downcallHandle("b2World_GetBodyEvents", BodyEvents.LAYOUT, WorldId.LAYOUT);
		B2_WORLD_GET_SENSOR_EVENTS = downcallHandle("b2World_GetSensorEvents", SensorEvents.LAYOUT, WorldId.LAYOUT);
		B2_WORLD_GET_CONTACT_EVENTS = downcallHandle("b2World_GetContactEvents", ContactEvents.LAYOUT, WorldId.LAYOUT);
		B2_WORLD_GET_JOINT_EVENTS = downcallHandle("b2World_GetJointEvents", JointEvents.LAYOUT, WorldId.LAYOUT);
		B2_WORLD_OVERLAP_AABB = downcallHandle("b2World_OverlapAABB", TreeStats.LAYOUT, WorldId.LAYOUT, Vec2.LAYOUT, AABB.LAYOUT, QueryFilter.LAYOUT, UNBOUNDED_ADDRESS, UNBOUNDED_ADDRESS);
		B2_WORLD_OVERLAP_SHAPE = downcallHandle("b2World_OverlapShape", TreeStats.LAYOUT, WorldId.LAYOUT, Vec2.LAYOUT, UNBOUNDED_ADDRESS, QueryFilter.LAYOUT, UNBOUNDED_ADDRESS, UNBOUNDED_ADDRESS);
		B2_WORLD_CAST_RAY = downcallHandle("b2World_CastRay", TreeStats.LAYOUT, WorldId.LAYOUT, Vec2.LAYOUT, Vec2.LAYOUT, QueryFilter.LAYOUT, UNBOUNDED_ADDRESS, UNBOUNDED_ADDRESS);
		B2_WORLD_CAST_RAY_CLOSEST = downcallHandle("b2World_CastRayClosest", RayResult.LAYOUT, WorldId.LAYOUT, Vec2.LAYOUT, Vec2.LAYOUT, QueryFilter.LAYOUT);
		B2_WORLD_CAST_SHAPE = downcallHandle("b2World_CastShape", TreeStats.LAYOUT, WorldId.LAYOUT, Vec2.LAYOUT, UNBOUNDED_ADDRESS, Vec2.LAYOUT, QueryFilter.LAYOUT, UNBOUNDED_ADDRESS, UNBOUNDED_ADDRESS);
		B2_WORLD_CAST_MOVER = downcallHandle("b2World_CastMover", JAVA_FLOAT, WorldId.LAYOUT, Vec2.LAYOUT, UNBOUNDED_ADDRESS, Vec2.LAYOUT, QueryFilter.LAYOUT);
		B2_WORLD_COLLIDE_MOVER = downcallHandleVoid("b2World_CollideMover", WorldId.LAYOUT, Vec2.LAYOUT, UNBOUNDED_ADDRESS, QueryFilter.LAYOUT, UNBOUNDED_ADDRESS, UNBOUNDED_ADDRESS);
		B2_WORLD_ENABLE_SLEEPING = downcallHandleVoid("b2World_EnableSleeping", WorldId.LAYOUT, JAVA_BOOLEAN);
		B2_WORLD_IS_SLEEPING_ENABLED = downcallHandle("b2World_IsSleepingEnabled", JAVA_BOOLEAN, WorldId.LAYOUT);
		B2_WORLD_ENABLE_CONTINUOUS = downcallHandleVoid("b2World_EnableContinuous", WorldId.LAYOUT, JAVA_BOOLEAN);
		B2_WORLD_IS_CONTINUOUS_ENABLED = downcallHandle("b2World_IsContinuousEnabled", JAVA_BOOLEAN, WorldId.LAYOUT);
		B2_WORLD_SET_RESTITUTION_THRESHOLD = downcallHandleVoid("b2World_SetRestitutionThreshold", WorldId.LAYOUT, JAVA_FLOAT);
		B2_WORLD_GET_RESTITUTION_THRESHOLD = downcallHandle("b2World_GetRestitutionThreshold", JAVA_FLOAT, WorldId.LAYOUT);
		B2_WORLD_SET_RESTITUTION_ITERATIONS = downcallHandleVoid("b2World_SetRestitutionIterations", WorldId.LAYOUT, JAVA_INT);
		B2_WORLD_GET_RESTITUTION_ITERATIONS = downcallHandle("b2World_GetRestitutionIterations", JAVA_INT, WorldId.LAYOUT);
		B2_WORLD_ENABLE_RESTITUTION_PROPAGATION = downcallHandleVoid("b2World_EnableRestitutionPropagation", WorldId.LAYOUT, JAVA_BOOLEAN);
		B2_WORLD_IS_RESTITUTION_PROPAGATION_ENABLED = downcallHandle("b2World_IsRestitutionPropagationEnabled", JAVA_BOOLEAN, WorldId.LAYOUT);
		B2_WORLD_SET_HIT_EVENT_THRESHOLD = downcallHandleVoid("b2World_SetHitEventThreshold", WorldId.LAYOUT, JAVA_FLOAT);
		B2_WORLD_GET_HIT_EVENT_THRESHOLD = downcallHandle("b2World_GetHitEventThreshold", JAVA_FLOAT, WorldId.LAYOUT);
		B2_WORLD_SET_CUSTOM_FILTER_CALLBACK = downcallHandleVoid("b2World_SetCustomFilterCallback", WorldId.LAYOUT, UNBOUNDED_ADDRESS, UNBOUNDED_ADDRESS);
		B2_WORLD_SET_PRE_SOLVE_CALLBACK = downcallHandleVoid("b2World_SetPreSolveCallback", WorldId.LAYOUT, UNBOUNDED_ADDRESS, UNBOUNDED_ADDRESS, UNBOUNDED_ADDRESS);
		B2_WORLD_SET_GRAVITY = downcallHandleVoid("b2World_SetGravity", WorldId.LAYOUT, Vec2.LAYOUT);
		B2_WORLD_GET_GRAVITY = downcallHandle("b2World_GetGravity", Vec2.LAYOUT, WorldId.LAYOUT);
		B2_WORLD_EXPLODE = downcallHandleVoid("b2World_Explode", WorldId.LAYOUT, UNBOUNDED_ADDRESS);
		B2_WORLD_SET_CONTACT_TUNING = downcallHandleVoid("b2World_SetContactTuning", WorldId.LAYOUT, JAVA_FLOAT, JAVA_FLOAT, JAVA_FLOAT);
		B2_WORLD_GET_CONTACT_TUNING = downcallHandleVoid("b2World_GetContactTuning", WorldId.LAYOUT, UNBOUNDED_ADDRESS, UNBOUNDED_ADDRESS, UNBOUNDED_ADDRESS);
		B2_WORLD_SET_CONTACT_RECYCLE_DISTANCE = downcallHandleVoid("b2World_SetContactRecycleDistance", WorldId.LAYOUT, JAVA_FLOAT);
		B2_WORLD_GET_CONTACT_RECYCLE_DISTANCE = downcallHandle("b2World_GetContactRecycleDistance", JAVA_FLOAT, WorldId.LAYOUT);
		B2_WORLD_SET_MAX_LINEAR_SPEED = downcallHandleVoid("b2World_SetMaxLinearSpeed", WorldId.LAYOUT, JAVA_FLOAT);
		B2_WORLD_GET_MAX_LINEAR_SPEED = downcallHandle("b2World_GetMaxLinearSpeed", JAVA_FLOAT, WorldId.LAYOUT);
		B2_WORLD_ENABLE_WARM_STARTING = downcallHandleVoid("b2World_EnableWarmStarting", WorldId.LAYOUT, JAVA_BOOLEAN);
		B2_WORLD_IS_WARM_STARTING_ENABLED = downcallHandle("b2World_IsWarmStartingEnabled", JAVA_BOOLEAN, WorldId.LAYOUT);
		B2_WORLD_ENABLE_SSE2_FALLBACK = downcallHandleVoid("b2World_EnableSSE2Fallback", WorldId.LAYOUT, JAVA_BOOLEAN);
		B2_WORLD_GET_AWAKE_BODY_COUNT = downcallHandle("b2World_GetAwakeBodyCount", JAVA_INT, WorldId.LAYOUT);
		B2_WORLD_GET_PROFILE = downcallHandle("b2World_GetProfile", Profile.LAYOUT, WorldId.LAYOUT);
		B2_WORLD_GET_COUNTERS = downcallHandle("b2World_GetCounters", Counters.LAYOUT, WorldId.LAYOUT);
		B2_WORLD_GET_MAX_CAPACITY = downcallHandle("b2World_GetMaxCapacity", Capacity.LAYOUT, WorldId.LAYOUT);
		B2_WORLD_SET_USER_DATA = downcallHandleVoid("b2World_SetUserData", WorldId.LAYOUT, UNBOUNDED_ADDRESS);
		B2_WORLD_GET_USER_DATA = downcallHandle("b2World_GetUserData", UNBOUNDED_ADDRESS, WorldId.LAYOUT);
		B2_WORLD_SET_FRICTION_CALLBACK = downcallHandleVoid("b2World_SetFrictionCallback", WorldId.LAYOUT, UNBOUNDED_ADDRESS);
		B2_WORLD_SET_RESTITUTION_CALLBACK = downcallHandleVoid("b2World_SetRestitutionCallback", WorldId.LAYOUT, UNBOUNDED_ADDRESS);
		B2_WORLD_SET_WORKER_COUNT = downcallHandleVoid("b2World_SetWorkerCount", WorldId.LAYOUT, JAVA_INT);
		B2_WORLD_GET_WORKER_COUNT = downcallHandle("b2World_GetWorkerCount", JAVA_INT, WorldId.LAYOUT);
		B2_WORLD_DUMP_MEMORY_STATS = downcallHandleVoid("b2World_DumpMemoryStats", WorldId.LAYOUT);
		B2_WORLD_REBUILD_STATIC_TREE = downcallHandleVoid("b2World_RebuildStaticTree", WorldId.LAYOUT);
		B2_WORLD_GET_STATE_HASH = downcallHandle("b2World_GetStateHash", JAVA_LONG, WorldId.LAYOUT);
		B2_WORLD_START_RECORDING = downcallHandleVoid("b2World_StartRecording", WorldId.LAYOUT, UNBOUNDED_ADDRESS);
		B2_WORLD_STOP_RECORDING = downcallHandleVoid("b2World_StopRecording", WorldId.LAYOUT);
		B2_WORLD_GET_SNAPSHOT = downcallHandle("b2World_GetSnapshot", JAVA_INT, WorldId.LAYOUT, UNBOUNDED_ADDRESS, JAVA_INT);
		B2_WORLD_RESTORE_FROM_SNAPSHOT = downcallHandle("b2World_RestoreFromSnapshot", JAVA_BOOLEAN, WorldId.LAYOUT, UNBOUNDED_ADDRESS, JAVA_INT);
		B2_CREATE_WORLD_FROM_SNAPSHOT = downcallHandle("b2CreateWorldFromSnapshot", WorldId.LAYOUT, UNBOUNDED_ADDRESS, JAVA_INT, JAVA_INT);
		//@formatter:on
	}

	private World() {
	}

    /// ```
    /// Create a world for rigid body simulation. A world contains bodies, shapes, and constraints. You
    /// may create up to B2_MAX_WORLDS worlds. Each world is completely independent and may be simulated
    /// in parallel.
    /// @return the world id.
    /// ```
    public static MemorySegment createWorld(
    	SegmentAllocator allocator,
    	MemorySegment def
    ) {
    	MethodHandle method = B2_CREATE_WORLD.get();
    	try {
    		return (MemorySegment) method.invokeExact(
    			allocator,
    			def
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#createWorld].
    public static @Nullable WorldId createWorld(
    	SegmentAllocator allocator,
    	WorldDef def
    ) {
    	MemorySegment segment = createWorld(
    		allocator,
    		def.memorySegment()
    	);
    
    	if (segment.equals(MemorySegment.NULL))
    		return null;
    	
    	return new WorldId(segment);
    }
    
    /// ```
    /// Destroy a world
    /// ```
    public static void destroyWorld(
    	MemorySegment worldId
    ) {
    	MethodHandle method = B2_DESTROY_WORLD.get();
    	try {
    		 method.invokeExact(
    			worldId
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#destroyWorld].
    public static void destroyWorld(
    	WorldId worldId
    ) {
    	destroyWorld(
    		worldId.memorySegment()
    	);
    }
    
    /// ```
    /// World id validation. Provides validation for up to 64K allocations.
    /// ```
    public static boolean isValid(
    	MemorySegment id
    ) {
    	MethodHandle method = B2_WORLD_IS_VALID.get();
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
    	WorldId id
    ) {
    	return isValid(
    		id.memorySegment()
    	);
    }
    
    /// ```
    /// Simulate a world for one time step. This performs collision detection, integration, and
    /// constraint solution.
    /// @param worldId The world to simulate
    /// @param timeStep The amount of time to simulate, this should be a fixed number. Usually 1/60.
    /// @param subStepCount The number of sub-steps, increasing the sub-step count can increase
    /// accuracy. Usually 4.
    /// ```
    public static void step(
    	MemorySegment worldId,
    	float timeStep,
    	int subStepCount
    ) {
    	MethodHandle method = B2_WORLD_STEP.get();
    	try {
    		 method.invokeExact(
    			worldId,
    			timeStep,
    			subStepCount
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#step].
    public static void step(
    	WorldId worldId,
    	float timeStep,
    	int subStepCount
    ) {
    	step(
    		worldId.memorySegment(),
    		timeStep,
    		subStepCount
    	);
    }
    
    /// ```
    /// Call this to draw shapes and other debug draw data
    /// ```
    public static void draw(
    	MemorySegment worldId,
    	MemorySegment draw
    ) {
    	MethodHandle method = B2_WORLD_DRAW.get();
    	try {
    		 method.invokeExact(
    			worldId,
    			draw
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#draw].
    public static void draw(
    	WorldId worldId,
    	DebugDraw draw
    ) {
    	draw(
    		worldId.memorySegment(),
    		draw.memorySegment()
    	);
    }
    
    /// ```
    /// Call this to get the world bounds based on the union of all shape bounds.
    /// ```
    public static MemorySegment getBounds(
    	SegmentAllocator allocator,
    	MemorySegment worldId
    ) {
    	MethodHandle method = B2_WORLD_GET_BOUNDS.get();
    	try {
    		return (MemorySegment) method.invokeExact(
    			allocator,
    			worldId
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#getBounds].
    public static @Nullable AABB getBounds(
    	SegmentAllocator allocator,
    	WorldId worldId
    ) {
    	MemorySegment segment = getBounds(
    		allocator,
    		worldId.memorySegment()
    	);
    
    	if (segment.equals(MemorySegment.NULL))
    		return null;
    	
    	return new AABB(segment);
    }
    
    /// ```
    /// Get the body events for the current time step. The event data is transient. Do not store a
    /// reference to this data.
    /// ```
    public static MemorySegment getBodyEvents(
    	SegmentAllocator allocator,
    	MemorySegment worldId
    ) {
    	MethodHandle method = B2_WORLD_GET_BODY_EVENTS.get();
    	try {
    		return (MemorySegment) method.invokeExact(
    			allocator,
    			worldId
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#getBodyEvents].
    public static @Nullable BodyEvents getBodyEvents(
    	SegmentAllocator allocator,
    	WorldId worldId
    ) {
    	MemorySegment segment = getBodyEvents(
    		allocator,
    		worldId.memorySegment()
    	);
    
    	if (segment.equals(MemorySegment.NULL))
    		return null;
    	
    	return new BodyEvents(segment);
    }
    
    /// ```
    /// Get sensor events for the current time step. The event data is transient. Do not store a
    /// reference to this data.
    /// ```
    public static MemorySegment getSensorEvents(
    	SegmentAllocator allocator,
    	MemorySegment worldId
    ) {
    	MethodHandle method = B2_WORLD_GET_SENSOR_EVENTS.get();
    	try {
    		return (MemorySegment) method.invokeExact(
    			allocator,
    			worldId
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#getSensorEvents].
    public static @Nullable SensorEvents getSensorEvents(
    	SegmentAllocator allocator,
    	WorldId worldId
    ) {
    	MemorySegment segment = getSensorEvents(
    		allocator,
    		worldId.memorySegment()
    	);
    
    	if (segment.equals(MemorySegment.NULL))
    		return null;
    	
    	return new SensorEvents(segment);
    }
    
    /// ```
    /// Get contact events for the current time step. The event data is transient. Do not store a
    /// reference to this data.
    /// ```
    public static MemorySegment getContactEvents(
    	SegmentAllocator allocator,
    	MemorySegment worldId
    ) {
    	MethodHandle method = B2_WORLD_GET_CONTACT_EVENTS.get();
    	try {
    		return (MemorySegment) method.invokeExact(
    			allocator,
    			worldId
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#getContactEvents].
    public static @Nullable ContactEvents getContactEvents(
    	SegmentAllocator allocator,
    	WorldId worldId
    ) {
    	MemorySegment segment = getContactEvents(
    		allocator,
    		worldId.memorySegment()
    	);
    
    	if (segment.equals(MemorySegment.NULL))
    		return null;
    	
    	return new ContactEvents(segment);
    }
    
    /// ```
    /// Get the joint events for the current time step. The event data is transient. Do not store a
    /// reference to this data.
    /// ```
    public static MemorySegment getJointEvents(
    	SegmentAllocator allocator,
    	MemorySegment worldId
    ) {
    	MethodHandle method = B2_WORLD_GET_JOINT_EVENTS.get();
    	try {
    		return (MemorySegment) method.invokeExact(
    			allocator,
    			worldId
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#getJointEvents].
    public static @Nullable JointEvents getJointEvents(
    	SegmentAllocator allocator,
    	WorldId worldId
    ) {
    	MemorySegment segment = getJointEvents(
    		allocator,
    		worldId.memorySegment()
    	);
    
    	if (segment.equals(MemorySegment.NULL))
    		return null;
    	
    	return new JointEvents(segment);
    }
    
    /// ```
    /// Overlap test for all shapes that *potentially* overlap the provided AABB. The AABB is relative
    /// to the origin, which keeps the test precise far from the world origin in large world mode. Near
    /// the origin pass b2Pos_zero and a world AABB.
    /// ```
    public static MemorySegment overlapAABB(
    	SegmentAllocator allocator,
    	MemorySegment worldId,
    	MemorySegment origin,
    	MemorySegment aabb,
    	MemorySegment filter,
    	MemorySegment fcn,
    	MemorySegment context
    ) {
    	MethodHandle method = B2_WORLD_OVERLAP_AABB.get();
    	try {
    		return (MemorySegment) method.invokeExact(
    			allocator,
    			worldId,
    			origin,
    			aabb,
    			filter,
    			fcn,
    			context
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#overlapAABB].
    public static @Nullable TreeStats overlapAABB(
    	SegmentAllocator allocator,
    	WorldId worldId,
    	Vec2 origin,
    	AABB aabb,
    	QueryFilter filter,
    	OverlapResultCallbackFcn fcn,
    	MemorySegment context
    ) {
    	MemorySegment segment = overlapAABB(
    		allocator,
    		worldId.memorySegment(),
    		origin.memorySegment(),
    		aabb.memorySegment(),
    		filter.memorySegment(),
    		fcn.memorySegment(),
    		context
    	);
    
    	if (segment.equals(MemorySegment.NULL))
    		return null;
    	
    	return new TreeStats(segment);
    }
    
    /// ```
    /// Overlap test for all shapes that overlap the provided shape proxy. The proxy points are relative
    /// to the origin. Near the origin pass b2Pos_zero and world points.
    /// ```
    public static MemorySegment overlapShape(
    	SegmentAllocator allocator,
    	MemorySegment worldId,
    	MemorySegment origin,
    	MemorySegment proxy,
    	MemorySegment filter,
    	MemorySegment fcn,
    	MemorySegment context
    ) {
    	MethodHandle method = B2_WORLD_OVERLAP_SHAPE.get();
    	try {
    		return (MemorySegment) method.invokeExact(
    			allocator,
    			worldId,
    			origin,
    			proxy,
    			filter,
    			fcn,
    			context
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#overlapShape].
    public static @Nullable TreeStats overlapShape(
    	SegmentAllocator allocator,
    	WorldId worldId,
    	Vec2 origin,
    	ShapeProxy proxy,
    	QueryFilter filter,
    	OverlapResultCallbackFcn fcn,
    	MemorySegment context
    ) {
    	MemorySegment segment = overlapShape(
    		allocator,
    		worldId.memorySegment(),
    		origin.memorySegment(),
    		proxy.memorySegment(),
    		filter.memorySegment(),
    		fcn.memorySegment(),
    		context
    	);
    
    	if (segment.equals(MemorySegment.NULL))
    		return null;
    	
    	return new TreeStats(segment);
    }
    
    /// ```
    /// Cast a ray into the world to collect shapes in the path of the ray. Your callback function
    /// controls whether you get the closest point, any point, or n-points.
    /// @note The callback function may receive shapes in any order
    /// @param worldId The world to cast the ray against
    /// @param origin The start point of the ray
    /// @param translation The translation of the ray from the start point to the end point
    /// @param filter Contains bit flags to filter unwanted shapes from the results
    /// @param fcn A user implemented callback function
    /// @param context A user context that is passed along to the callback function
    /// @return traversal performance counters
    /// ```
    public static MemorySegment castRay(
    	SegmentAllocator allocator,
    	MemorySegment worldId,
    	MemorySegment origin,
    	MemorySegment translation,
    	MemorySegment filter,
    	MemorySegment fcn,
    	MemorySegment context
    ) {
    	MethodHandle method = B2_WORLD_CAST_RAY.get();
    	try {
    		return (MemorySegment) method.invokeExact(
    			allocator,
    			worldId,
    			origin,
    			translation,
    			filter,
    			fcn,
    			context
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#castRay].
    public static @Nullable TreeStats castRay(
    	SegmentAllocator allocator,
    	WorldId worldId,
    	Vec2 origin,
    	Vec2 translation,
    	QueryFilter filter,
    	CastResultCallbackFcn fcn,
    	MemorySegment context
    ) {
    	MemorySegment segment = castRay(
    		allocator,
    		worldId.memorySegment(),
    		origin.memorySegment(),
    		translation.memorySegment(),
    		filter.memorySegment(),
    		fcn.memorySegment(),
    		context
    	);
    
    	if (segment.equals(MemorySegment.NULL))
    		return null;
    	
    	return new TreeStats(segment);
    }
    
    /// ```
    /// Cast a ray into the world to collect the closest hit. This is a convenience function. Ignores
    /// initial overlap. This is less general than b2World_CastRay() and does not allow for custom
    /// filtering.
    /// ```
    public static MemorySegment castRayClosest(
    	SegmentAllocator allocator,
    	MemorySegment worldId,
    	MemorySegment origin,
    	MemorySegment translation,
    	MemorySegment filter
    ) {
    	MethodHandle method = B2_WORLD_CAST_RAY_CLOSEST.get();
    	try {
    		return (MemorySegment) method.invokeExact(
    			allocator,
    			worldId,
    			origin,
    			translation,
    			filter
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#castRayClosest].
    public static @Nullable RayResult castRayClosest(
    	SegmentAllocator allocator,
    	WorldId worldId,
    	Vec2 origin,
    	Vec2 translation,
    	QueryFilter filter
    ) {
    	MemorySegment segment = castRayClosest(
    		allocator,
    		worldId.memorySegment(),
    		origin.memorySegment(),
    		translation.memorySegment(),
    		filter.memorySegment()
    	);
    
    	if (segment.equals(MemorySegment.NULL))
    		return null;
    	
    	return new RayResult(segment);
    }
    
    /// ```
    /// Cast a shape through the world. Similar to a ray cast except that a shape is cast instead of a
    /// point. The proxy points are relative to the origin. Callback points are world positions.
    /// @see b2World_CastRay
    /// ```
    public static MemorySegment castShape(
    	SegmentAllocator allocator,
    	MemorySegment worldId,
    	MemorySegment origin,
    	MemorySegment proxy,
    	MemorySegment translation,
    	MemorySegment filter,
    	MemorySegment fcn,
    	MemorySegment context
    ) {
    	MethodHandle method = B2_WORLD_CAST_SHAPE.get();
    	try {
    		return (MemorySegment) method.invokeExact(
    			allocator,
    			worldId,
    			origin,
    			proxy,
    			translation,
    			filter,
    			fcn,
    			context
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#castShape].
    public static @Nullable TreeStats castShape(
    	SegmentAllocator allocator,
    	WorldId worldId,
    	Vec2 origin,
    	ShapeProxy proxy,
    	Vec2 translation,
    	QueryFilter filter,
    	CastResultCallbackFcn fcn,
    	MemorySegment context
    ) {
    	MemorySegment segment = castShape(
    		allocator,
    		worldId.memorySegment(),
    		origin.memorySegment(),
    		proxy.memorySegment(),
    		translation.memorySegment(),
    		filter.memorySegment(),
    		fcn.memorySegment(),
    		context
    	);
    
    	if (segment.equals(MemorySegment.NULL))
    		return null;
    	
    	return new TreeStats(segment);
    }
    
    /// ```
    /// Cast a capsule mover through the world. This is a special shape cast that handles sliding along
    /// other shapes while reducing clipping. The mover capsule is relative to the origin. Near the
    /// origin pass b2Pos_zero and a world capsule. Returns the translation fraction at the first hit.
    /// ```
    public static float castMover(
    	MemorySegment worldId,
    	MemorySegment origin,
    	MemorySegment mover,
    	MemorySegment translation,
    	MemorySegment filter
    ) {
    	MethodHandle method = B2_WORLD_CAST_MOVER.get();
    	try {
    		return (float) method.invokeExact(
    			worldId,
    			origin,
    			mover,
    			translation,
    			filter
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#castMover].
    public static float castMover(
    	WorldId worldId,
    	Vec2 origin,
    	Capsule mover,
    	Vec2 translation,
    	QueryFilter filter
    ) {
    	return castMover(
    		worldId.memorySegment(),
    		origin.memorySegment(),
    		mover.memorySegment(),
    		translation.memorySegment(),
    		filter.memorySegment()
    	);
    }
    
    /// ```
    /// Collide a capsule mover with the world, gathering collision planes that can be fed to
    /// b2SolvePlanes. Useful for kinematic character movement. The mover capsule and the resulting
    /// planes are relative to the origin.
    /// ```
    public static void collideMover(
    	MemorySegment worldId,
    	MemorySegment origin,
    	MemorySegment mover,
    	MemorySegment filter,
    	MemorySegment fcn,
    	MemorySegment context
    ) {
    	MethodHandle method = B2_WORLD_COLLIDE_MOVER.get();
    	try {
    		 method.invokeExact(
    			worldId,
    			origin,
    			mover,
    			filter,
    			fcn,
    			context
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#collideMover].
    public static void collideMover(
    	WorldId worldId,
    	Vec2 origin,
    	Capsule mover,
    	QueryFilter filter,
    	PlaneResultFcn fcn,
    	MemorySegment context
    ) {
    	collideMover(
    		worldId.memorySegment(),
    		origin.memorySegment(),
    		mover.memorySegment(),
    		filter.memorySegment(),
    		fcn.memorySegment(),
    		context
    	);
    }
    
    /// ```
    /// Enable/disable sleep. If your application does not need sleeping, you can gain some performance
    /// by disabling sleep completely at the world level.
    /// @see b2WorldDef
    /// ```
    public static void enableSleeping(
    	MemorySegment worldId,
    	boolean flag
    ) {
    	MethodHandle method = B2_WORLD_ENABLE_SLEEPING.get();
    	try {
    		 method.invokeExact(
    			worldId,
    			flag
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#enableSleeping].
    public static void enableSleeping(
    	WorldId worldId,
    	boolean flag
    ) {
    	enableSleeping(
    		worldId.memorySegment(),
    		flag
    	);
    }
    
    /// ```
    /// Is body sleeping enabled?
    /// ```
    public static boolean isSleepingEnabled(
    	MemorySegment worldId
    ) {
    	MethodHandle method = B2_WORLD_IS_SLEEPING_ENABLED.get();
    	try {
    		return (boolean) method.invokeExact(
    			worldId
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#isSleepingEnabled].
    public static boolean isSleepingEnabled(
    	WorldId worldId
    ) {
    	return isSleepingEnabled(
    		worldId.memorySegment()
    	);
    }
    
    /// ```
    /// Enable/disable continuous collision between dynamic and static bodies. Generally you should keep
    /// continuous collision enabled to prevent fast moving objects from going through static objects.
    /// The performance gain from disabling continuous collision is minor.
    /// @see b2WorldDef
    /// ```
    public static void enableContinuous(
    	MemorySegment worldId,
    	boolean flag
    ) {
    	MethodHandle method = B2_WORLD_ENABLE_CONTINUOUS.get();
    	try {
    		 method.invokeExact(
    			worldId,
    			flag
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#enableContinuous].
    public static void enableContinuous(
    	WorldId worldId,
    	boolean flag
    ) {
    	enableContinuous(
    		worldId.memorySegment(),
    		flag
    	);
    }
    
    /// ```
    /// Is continuous collision enabled?
    /// ```
    public static boolean isContinuousEnabled(
    	MemorySegment worldId
    ) {
    	MethodHandle method = B2_WORLD_IS_CONTINUOUS_ENABLED.get();
    	try {
    		return (boolean) method.invokeExact(
    			worldId
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#isContinuousEnabled].
    public static boolean isContinuousEnabled(
    	WorldId worldId
    ) {
    	return isContinuousEnabled(
    		worldId.memorySegment()
    	);
    }
    
    /// ```
    /// Adjust the restitution threshold. It is recommended not to make this value very small because it
    /// will prevent bodies from sleeping. Usually in meters per second.
    /// @see b2WorldDef
    /// ```
    public static void setRestitutionThreshold(
    	MemorySegment worldId,
    	float value
    ) {
    	MethodHandle method = B2_WORLD_SET_RESTITUTION_THRESHOLD.get();
    	try {
    		 method.invokeExact(
    			worldId,
    			value
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#setRestitutionThreshold].
    public static void setRestitutionThreshold(
    	WorldId worldId,
    	float value
    ) {
    	setRestitutionThreshold(
    		worldId.memorySegment(),
    		value
    	);
    }
    
    /// ```
    /// Get the restitution speed threshold. Usually in meters per second.
    /// ```
    public static float getRestitutionThreshold(
    	MemorySegment worldId
    ) {
    	MethodHandle method = B2_WORLD_GET_RESTITUTION_THRESHOLD.get();
    	try {
    		return (float) method.invokeExact(
    			worldId
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#getRestitutionThreshold].
    public static float getRestitutionThreshold(
    	WorldId worldId
    ) {
    	return getRestitutionThreshold(
    		worldId.memorySegment()
    	);
    }
    
    /// ```
    /// Set the number of iterations used by the restitution solver.
    /// @see B2_MAX_RESTITUTION_ITERATIONS
    /// ```
    public static void setRestitutionIterations(
    	MemorySegment worldId,
    	int iterations
    ) {
    	MethodHandle method = B2_WORLD_SET_RESTITUTION_ITERATIONS.get();
    	try {
    		 method.invokeExact(
    			worldId,
    			iterations
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#setRestitutionIterations].
    public static void setRestitutionIterations(
    	WorldId worldId,
    	int iterations
    ) {
    	setRestitutionIterations(
    		worldId.memorySegment(),
    		iterations
    	);
    }
    
    /// ```
    /// Get the number of iterations used by the restitution solver.
    /// ```
    public static int getRestitutionIterations(
    	MemorySegment worldId
    ) {
    	MethodHandle method = B2_WORLD_GET_RESTITUTION_ITERATIONS.get();
    	try {
    		return (int) method.invokeExact(
    			worldId
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#getRestitutionIterations].
    public static int getRestitutionIterations(
    	WorldId worldId
    ) {
    	return getRestitutionIterations(
    		worldId.memorySegment()
    	);
    }
    
    /// ```
    /// Enable/disable restitution propagation.
    /// @see b2WorldDef::enableRestitutionPropagation
    /// ```
    public static void enableRestitutionPropagation(
    	MemorySegment worldId,
    	boolean flag
    ) {
    	MethodHandle method = B2_WORLD_ENABLE_RESTITUTION_PROPAGATION.get();
    	try {
    		 method.invokeExact(
    			worldId,
    			flag
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#enableRestitutionPropagation].
    public static void enableRestitutionPropagation(
    	WorldId worldId,
    	boolean flag
    ) {
    	enableRestitutionPropagation(
    		worldId.memorySegment(),
    		flag
    	);
    }
    
    /// ```
    /// Is restitution propagation enabled?
    /// ```
    public static boolean isRestitutionPropagationEnabled(
    	MemorySegment worldId
    ) {
    	MethodHandle method = B2_WORLD_IS_RESTITUTION_PROPAGATION_ENABLED.get();
    	try {
    		return (boolean) method.invokeExact(
    			worldId
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#isRestitutionPropagationEnabled].
    public static boolean isRestitutionPropagationEnabled(
    	WorldId worldId
    ) {
    	return isRestitutionPropagationEnabled(
    		worldId.memorySegment()
    	);
    }
    
    /// ```
    /// Adjust the hit event threshold. This controls the collision speed needed to generate a
    /// b2ContactHitEvent. Usually in meters per second.
    /// @see b2WorldDef::hitEventThreshold
    /// ```
    public static void setHitEventThreshold(
    	MemorySegment worldId,
    	float value
    ) {
    	MethodHandle method = B2_WORLD_SET_HIT_EVENT_THRESHOLD.get();
    	try {
    		 method.invokeExact(
    			worldId,
    			value
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#setHitEventThreshold].
    public static void setHitEventThreshold(
    	WorldId worldId,
    	float value
    ) {
    	setHitEventThreshold(
    		worldId.memorySegment(),
    		value
    	);
    }
    
    /// ```
    /// Get the hit event speed threshold. Usually in meters per second.
    /// ```
    public static float getHitEventThreshold(
    	MemorySegment worldId
    ) {
    	MethodHandle method = B2_WORLD_GET_HIT_EVENT_THRESHOLD.get();
    	try {
    		return (float) method.invokeExact(
    			worldId
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#getHitEventThreshold].
    public static float getHitEventThreshold(
    	WorldId worldId
    ) {
    	return getHitEventThreshold(
    		worldId.memorySegment()
    	);
    }
    
    /// ```
    /// Register the custom filter callback. This is optional.
    /// ```
    public static void setCustomFilterCallback(
    	MemorySegment worldId,
    	MemorySegment fcn,
    	MemorySegment context
    ) {
    	MethodHandle method = B2_WORLD_SET_CUSTOM_FILTER_CALLBACK.get();
    	try {
    		 method.invokeExact(
    			worldId,
    			fcn,
    			context
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#setCustomFilterCallback].
    public static void setCustomFilterCallback(
    	WorldId worldId,
    	CustomFilterCallbackFcn fcn,
    	MemorySegment context
    ) {
    	setCustomFilterCallback(
    		worldId.memorySegment(),
    		fcn.memorySegment(),
    		context
    	);
    }
    
    /// ```
    /// Register the pre-solve and pre-continuous callbacks. This is optional.
    /// ```
    public static void setPreSolveCallback(
    	MemorySegment worldId,
    	MemorySegment preSolveFcn,
    	MemorySegment preContinuousFcn,
    	MemorySegment context
    ) {
    	MethodHandle method = B2_WORLD_SET_PRE_SOLVE_CALLBACK.get();
    	try {
    		 method.invokeExact(
    			worldId,
    			preSolveFcn,
    			preContinuousFcn,
    			context
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#setPreSolveCallback].
    public static void setPreSolveCallback(
    	WorldId worldId,
    	PreSolveCallbackFcn preSolveFcn,
    	PreContinuousCallbackFcn preContinuousFcn,
    	MemorySegment context
    ) {
    	setPreSolveCallback(
    		worldId.memorySegment(),
    		preSolveFcn.memorySegment(),
    		preContinuousFcn.memorySegment(),
    		context
    	);
    }
    
    /// ```
    /// Set the gravity vector for the entire world. Box2D has no concept of an up direction and this is
    /// left as a decision for the application. Usually in m/s^2.
    /// @see b2WorldDef
    /// ```
    public static void setGravity(
    	MemorySegment worldId,
    	MemorySegment gravity
    ) {
    	MethodHandle method = B2_WORLD_SET_GRAVITY.get();
    	try {
    		 method.invokeExact(
    			worldId,
    			gravity
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#setGravity].
    public static void setGravity(
    	WorldId worldId,
    	Vec2 gravity
    ) {
    	setGravity(
    		worldId.memorySegment(),
    		gravity.memorySegment()
    	);
    }
    
    /// ```
    /// Get the gravity vector
    /// ```
    public static MemorySegment getGravity(
    	SegmentAllocator allocator,
    	MemorySegment worldId
    ) {
    	MethodHandle method = B2_WORLD_GET_GRAVITY.get();
    	try {
    		return (MemorySegment) method.invokeExact(
    			allocator,
    			worldId
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#getGravity].
    public static @Nullable Vec2 getGravity(
    	SegmentAllocator allocator,
    	WorldId worldId
    ) {
    	MemorySegment segment = getGravity(
    		allocator,
    		worldId.memorySegment()
    	);
    
    	if (segment.equals(MemorySegment.NULL))
    		return null;
    	
    	return new Vec2(segment);
    }
    
    /// ```
    /// Apply a radial explosion
    /// @param worldId The world id
    /// @param explosionDef The explosion definition
    /// ```
    public static void explode(
    	MemorySegment worldId,
    	MemorySegment explosionDef
    ) {
    	MethodHandle method = B2_WORLD_EXPLODE.get();
    	try {
    		 method.invokeExact(
    			worldId,
    			explosionDef
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#explode].
    public static void explode(
    	WorldId worldId,
    	ExplosionDef explosionDef
    ) {
    	explode(
    		worldId.memorySegment(),
    		explosionDef.memorySegment()
    	);
    }
    
    /// ```
    /// Adjust contact tuning parameters
    /// @param worldId The world id
    /// @param hertz The contact stiffness (cycles per second)
    /// @param dampingRatio The contact bounciness with 1 being critical damping (non-dimensional)
    /// @param pushSpeed The maximum contact constraint push out speed (meters per second)
    /// @note Advanced feature
    /// ```
    public static void setContactTuning(
    	MemorySegment worldId,
    	float hertz,
    	float dampingRatio,
    	float pushSpeed
    ) {
    	MethodHandle method = B2_WORLD_SET_CONTACT_TUNING.get();
    	try {
    		 method.invokeExact(
    			worldId,
    			hertz,
    			dampingRatio,
    			pushSpeed
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#setContactTuning].
    public static void setContactTuning(
    	WorldId worldId,
    	float hertz,
    	float dampingRatio,
    	float pushSpeed
    ) {
    	setContactTuning(
    		worldId.memorySegment(),
    		hertz,
    		dampingRatio,
    		pushSpeed
    	);
    }
    
    /// ```
    /// Get the contact tuning.
    /// ```
    public static void getContactTuning(
    	MemorySegment worldId,
    	MemorySegment hertz,
    	MemorySegment dampingRatio,
    	MemorySegment pushSpeed
    ) {
    	MethodHandle method = B2_WORLD_GET_CONTACT_TUNING.get();
    	try {
    		 method.invokeExact(
    			worldId,
    			hertz,
    			dampingRatio,
    			pushSpeed
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#getContactTuning].
    public static void getContactTuning(
    	WorldId worldId,
    	NativeFloatArray hertz,
    	NativeFloatArray dampingRatio,
    	NativeFloatArray pushSpeed
    ) {
    	getContactTuning(
    		worldId.memorySegment(),
    		hertz.memorySegment(),
    		dampingRatio.memorySegment(),
    		pushSpeed.memorySegment()
    	);
    }
    
    /// ```
    /// Set the contact point recycling distance. Setting this to zero disables contact point recycling.
    /// Usually in meters.
    /// ```
    public static void setContactRecycleDistance(
    	MemorySegment worldId,
    	float recycleDistance
    ) {
    	MethodHandle method = B2_WORLD_SET_CONTACT_RECYCLE_DISTANCE.get();
    	try {
    		 method.invokeExact(
    			worldId,
    			recycleDistance
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#setContactRecycleDistance].
    public static void setContactRecycleDistance(
    	WorldId worldId,
    	float recycleDistance
    ) {
    	setContactRecycleDistance(
    		worldId.memorySegment(),
    		recycleDistance
    	);
    }
    
    /// ```
    /// Get the contact point recycling distance. Usually in meters.
    /// ```
    public static float getContactRecycleDistance(
    	MemorySegment worldId
    ) {
    	MethodHandle method = B2_WORLD_GET_CONTACT_RECYCLE_DISTANCE.get();
    	try {
    		return (float) method.invokeExact(
    			worldId
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#getContactRecycleDistance].
    public static float getContactRecycleDistance(
    	WorldId worldId
    ) {
    	return getContactRecycleDistance(
    		worldId.memorySegment()
    	);
    }
    
    /// ```
    /// Set the maximum linear speed. Usually in m/s.
    /// ```
    public static void setMaxLinearSpeed(
    	MemorySegment worldId,
    	float maximumLinearSpeed
    ) {
    	MethodHandle method = B2_WORLD_SET_MAX_LINEAR_SPEED.get();
    	try {
    		 method.invokeExact(
    			worldId,
    			maximumLinearSpeed
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#setMaxLinearSpeed].
    public static void setMaxLinearSpeed(
    	WorldId worldId,
    	float maximumLinearSpeed
    ) {
    	setMaxLinearSpeed(
    		worldId.memorySegment(),
    		maximumLinearSpeed
    	);
    }
    
    /// ```
    /// Get the maximum linear speed. Usually in m/s.
    /// ```
    public static float getMaxLinearSpeed(
    	MemorySegment worldId
    ) {
    	MethodHandle method = B2_WORLD_GET_MAX_LINEAR_SPEED.get();
    	try {
    		return (float) method.invokeExact(
    			worldId
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#getMaxLinearSpeed].
    public static float getMaxLinearSpeed(
    	WorldId worldId
    ) {
    	return getMaxLinearSpeed(
    		worldId.memorySegment()
    	);
    }
    
    /// ```
    /// Enable/disable constraint warm starting. Advanced feature for testing. Disabling warm starting
    /// greatly reduces stability and provides no performance gain.
    /// ```
    public static void enableWarmStarting(
    	MemorySegment worldId,
    	boolean flag
    ) {
    	MethodHandle method = B2_WORLD_ENABLE_WARM_STARTING.get();
    	try {
    		 method.invokeExact(
    			worldId,
    			flag
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#enableWarmStarting].
    public static void enableWarmStarting(
    	WorldId worldId,
    	boolean flag
    ) {
    	enableWarmStarting(
    		worldId.memorySegment(),
    		flag
    	);
    }
    
    /// ```
    /// Is constraint warm starting enabled?
    /// ```
    public static boolean isWarmStartingEnabled(
    	MemorySegment worldId
    ) {
    	MethodHandle method = B2_WORLD_IS_WARM_STARTING_ENABLED.get();
    	try {
    		return (boolean) method.invokeExact(
    			worldId
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#isWarmStartingEnabled].
    public static boolean isWarmStartingEnabled(
    	WorldId worldId
    ) {
    	return isWarmStartingEnabled(
    		worldId.memorySegment()
    	);
    }
    
    /// ```
    /// Force SSE2 to be used even when AVX2 is available. This is for testing.
    /// ```
    public static void enableSSE2Fallback(
    	MemorySegment worldId,
    	boolean flag
    ) {
    	MethodHandle method = B2_WORLD_ENABLE_SSE2_FALLBACK.get();
    	try {
    		 method.invokeExact(
    			worldId,
    			flag
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#enableSSE2Fallback].
    public static void enableSSE2Fallback(
    	WorldId worldId,
    	boolean flag
    ) {
    	enableSSE2Fallback(
    		worldId.memorySegment(),
    		flag
    	);
    }
    
    /// ```
    /// Get the number of awake bodies.
    /// ```
    public static int getAwakeBodyCount(
    	MemorySegment worldId
    ) {
    	MethodHandle method = B2_WORLD_GET_AWAKE_BODY_COUNT.get();
    	try {
    		return (int) method.invokeExact(
    			worldId
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#getAwakeBodyCount].
    public static int getAwakeBodyCount(
    	WorldId worldId
    ) {
    	return getAwakeBodyCount(
    		worldId.memorySegment()
    	);
    }
    
    /// ```
    /// Get the current world performance profile
    /// ```
    public static MemorySegment getProfile(
    	SegmentAllocator allocator,
    	MemorySegment worldId
    ) {
    	MethodHandle method = B2_WORLD_GET_PROFILE.get();
    	try {
    		return (MemorySegment) method.invokeExact(
    			allocator,
    			worldId
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#getProfile].
    public static @Nullable Profile getProfile(
    	SegmentAllocator allocator,
    	WorldId worldId
    ) {
    	MemorySegment segment = getProfile(
    		allocator,
    		worldId.memorySegment()
    	);
    
    	if (segment.equals(MemorySegment.NULL))
    		return null;
    	
    	return new Profile(segment);
    }
    
    /// ```
    /// Get world counters and sizes
    /// ```
    public static MemorySegment getCounters(
    	SegmentAllocator allocator,
    	MemorySegment worldId
    ) {
    	MethodHandle method = B2_WORLD_GET_COUNTERS.get();
    	try {
    		return (MemorySegment) method.invokeExact(
    			allocator,
    			worldId
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#getCounters].
    public static @Nullable Counters getCounters(
    	SegmentAllocator allocator,
    	WorldId worldId
    ) {
    	MemorySegment segment = getCounters(
    		allocator,
    		worldId.memorySegment()
    	);
    
    	if (segment.equals(MemorySegment.NULL))
    		return null;
    	
    	return new Counters(segment);
    }
    
    /// ```
    /// Get max capacity. This can be used with b2WorldDef to avoid run-time allocations and copies
    /// ```
    public static MemorySegment getMaxCapacity(
    	SegmentAllocator allocator,
    	MemorySegment worldId
    ) {
    	MethodHandle method = B2_WORLD_GET_MAX_CAPACITY.get();
    	try {
    		return (MemorySegment) method.invokeExact(
    			allocator,
    			worldId
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#getMaxCapacity].
    public static @Nullable Capacity getMaxCapacity(
    	SegmentAllocator allocator,
    	WorldId worldId
    ) {
    	MemorySegment segment = getMaxCapacity(
    		allocator,
    		worldId.memorySegment()
    	);
    
    	if (segment.equals(MemorySegment.NULL))
    		return null;
    	
    	return new Capacity(segment);
    }
    
    /// ```
    /// Set the user data pointer.
    /// ```
    public static void setUserData(
    	MemorySegment worldId,
    	MemorySegment userData
    ) {
    	MethodHandle method = B2_WORLD_SET_USER_DATA.get();
    	try {
    		 method.invokeExact(
    			worldId,
    			userData
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#setUserData].
    public static void setUserData(
    	WorldId worldId,
    	MemorySegment userData
    ) {
    	setUserData(
    		worldId.memorySegment(),
    		userData
    	);
    }
    
    /// ```
    /// Get the user data pointer.
    /// ```
    public static MemorySegment getUserData(
    	MemorySegment worldId
    ) {
    	MethodHandle method = B2_WORLD_GET_USER_DATA.get();
    	try {
    		return (MemorySegment) method.invokeExact(
    			worldId
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#getUserData].
    public static @Nullable MemorySegment getUserData(
    	WorldId worldId
    ) {
    	MemorySegment segment = getUserData(
    		worldId.memorySegment()
    	);
    
    	if (segment.equals(MemorySegment.NULL))
    		return null;
    	
    	return segment;
    }
    
    /// ```
    /// Set the friction callback. Passing NULL resets to default.
    /// ```
    public static void setFrictionCallback(
    	MemorySegment worldId,
    	MemorySegment callback
    ) {
    	MethodHandle method = B2_WORLD_SET_FRICTION_CALLBACK.get();
    	try {
    		 method.invokeExact(
    			worldId,
    			callback
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#setFrictionCallback].
    public static void setFrictionCallback(
    	WorldId worldId,
    	FrictionCallbackFcn callback
    ) {
    	setFrictionCallback(
    		worldId.memorySegment(),
    		callback.memorySegment()
    	);
    }
    
    /// ```
    /// Set the restitution callback. Passing NULL resets to default.
    /// ```
    public static void setRestitutionCallback(
    	MemorySegment worldId,
    	MemorySegment callback
    ) {
    	MethodHandle method = B2_WORLD_SET_RESTITUTION_CALLBACK.get();
    	try {
    		 method.invokeExact(
    			worldId,
    			callback
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#setRestitutionCallback].
    public static void setRestitutionCallback(
    	WorldId worldId,
    	RestitutionCallbackFcn callback
    ) {
    	setRestitutionCallback(
    		worldId.memorySegment(),
    		callback.memorySegment()
    	);
    }
    
    /// ```
    /// Set the worker count. Must be in the range [1, B2_MAX_WORKERS]
    /// ```
    public static void setWorkerCount(
    	MemorySegment worldId,
    	int count
    ) {
    	MethodHandle method = B2_WORLD_SET_WORKER_COUNT.get();
    	try {
    		 method.invokeExact(
    			worldId,
    			count
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#setWorkerCount].
    public static void setWorkerCount(
    	WorldId worldId,
    	int count
    ) {
    	setWorkerCount(
    		worldId.memorySegment(),
    		count
    	);
    }
    
    /// ```
    /// Get the worker count.
    /// ```
    public static int getWorkerCount(
    	MemorySegment worldId
    ) {
    	MethodHandle method = B2_WORLD_GET_WORKER_COUNT.get();
    	try {
    		return (int) method.invokeExact(
    			worldId
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#getWorkerCount].
    public static int getWorkerCount(
    	WorldId worldId
    ) {
    	return getWorkerCount(
    		worldId.memorySegment()
    	);
    }
    
    /// ```
    /// Dump memory stats to box2d_memory.txt
    /// ```
    public static void dumpMemoryStats(
    	MemorySegment worldId
    ) {
    	MethodHandle method = B2_WORLD_DUMP_MEMORY_STATS.get();
    	try {
    		 method.invokeExact(
    			worldId
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#dumpMemoryStats].
    public static void dumpMemoryStats(
    	WorldId worldId
    ) {
    	dumpMemoryStats(
    		worldId.memorySegment()
    	);
    }
    
    /// ```
    /// This is for internal testing
    /// ```
    public static void rebuildStaticTree(
    	MemorySegment worldId
    ) {
    	MethodHandle method = B2_WORLD_REBUILD_STATIC_TREE.get();
    	try {
    		 method.invokeExact(
    			worldId
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#rebuildStaticTree].
    public static void rebuildStaticTree(
    	WorldId worldId
    ) {
    	rebuildStaticTree(
    		worldId.memorySegment()
    	);
    }
    
    /// ```
    /// Compute a hash of the simulation state. Use this to detect desyncs, for example in rollback
    /// resimulation.
    /// ```
    public static long getStateHash(
    	MemorySegment worldId
    ) {
    	MethodHandle method = B2_WORLD_GET_STATE_HASH.get();
    	try {
    		return (long) method.invokeExact(
    			worldId
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#getStateHash].
    public static long getStateHash(
    	WorldId worldId
    ) {
    	return getStateHash(
    		worldId.memorySegment()
    	);
    }
    
    /// ```
    /// Begin recording the world into @p recording. Serializes a snapshot of the current world as the
    /// seed, then logs every mutating call. Call at a step boundary, before or after creating bodies.
    /// Start before the first step to capture the whole session. No effect if already recording or if
    /// the world is locked.
    /// @param worldId The world to record
    /// @param recording A recording buffer from b2CreateRecording
    /// ```
    public static void startRecording(
    	MemorySegment worldId,
    	MemorySegment recording
    ) {
    	MethodHandle method = B2_WORLD_START_RECORDING.get();
    	try {
    		 method.invokeExact(
    			worldId,
    			recording
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#startRecording].
    public static void startRecording(
    	WorldId worldId,
    	Recording recording
    ) {
    	startRecording(
    		worldId.memorySegment(),
    		recording.memorySegment()
    	);
    }
    
    /// ```
    /// Stop recording. The recording buffer keeps its bytes. Save and destroy it yourself.
    /// @param worldId The world being recorded
    /// ```
    public static void stopRecording(
    	MemorySegment worldId
    ) {
    	MethodHandle method = B2_WORLD_STOP_RECORDING.get();
    	try {
    		 method.invokeExact(
    			worldId
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#stopRecording].
    public static void stopRecording(
    	WorldId worldId
    ) {
    	stopRecording(
    		worldId.memorySegment()
    	);
    }
    
    /// ```
    /// Write a snapshot of the world's simulation state into a caller-owned buffer. Call once with
    /// image == NULL to get the required size, then again with a buffer of at least that size. Must be
    /// called at a step boundary.
    /// @param worldId The world to snapshot
    /// @param image Destination buffer, or NULL to query the size
    /// @param capacity Size of image in bytes, ignored when querying
    /// @return The number of bytes the snapshot needs. If it exceeds capacity nothing is written.
    /// Returns 0 if the world is mid-step.
    /// ```
    public static int getSnapshot(
    	MemorySegment worldId,
    	MemorySegment image,
    	int capacity
    ) {
    	MethodHandle method = B2_WORLD_GET_SNAPSHOT.get();
    	try {
    		return (int) method.invokeExact(
    			worldId,
    			image,
    			capacity
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#getSnapshot].
    public static int getSnapshot(
    	WorldId worldId,
    	NativeByteArray image,
    	int capacity
    ) {
    	return getSnapshot(
    		worldId.memorySegment(),
    		image.memorySegment(),
    		capacity
    	);
    }
    
    /// ```
    /// Restore a world's simulation state from a snapshot image. The b2WorldId and ids held from this
    /// same world stay valid for objects that existed at the snapshot instant. Callbacks and threading
    /// configuration are preserved. User data on shapes, bodies, and joints is nulled.
    /// @param worldId The world to restore into
    /// @param image A snapshot image produced by b2World_GetSnapshot
    /// @param size Size of image in bytes
    /// @return true on success. On a rejected image (bad magic, version, or layout) the world is left
    /// unchanged. A corrupt payload detected after the rebuild begins returns false and leaves
    /// the world unusable, so the caller must destroy it.
    /// ```
    public static boolean restoreFromSnapshot(
    	MemorySegment worldId,
    	MemorySegment image,
    	int size
    ) {
    	MethodHandle method = B2_WORLD_RESTORE_FROM_SNAPSHOT.get();
    	try {
    		return (boolean) method.invokeExact(
    			worldId,
    			image,
    			size
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#restoreFromSnapshot].
    public static boolean restoreFromSnapshot(
    	WorldId worldId,
    	NativeByteArray image,
    	int size
    ) {
    	return restoreFromSnapshot(
    		worldId.memorySegment(),
    		image.memorySegment(),
    		size
    	);
    }
    
    /// ```
    /// Create a new world from a snapshot image. This is mainly useful for replay. Callbacks are reset
    /// to default.
    /// @param image A snapshot image produced by b2World_GetSnapshot
    /// @param size Size of image in bytes
    /// @param workerCount Worker count for the new world. 0 uses the serial single-worker fallback.
    /// @return The new world id, or b2_nullWorldId on failure.
    /// ```
    public static MemorySegment createWorldFromSnapshot(
    	SegmentAllocator allocator,
    	MemorySegment image,
    	int size,
    	int workerCount
    ) {
    	MethodHandle method = B2_CREATE_WORLD_FROM_SNAPSHOT.get();
    	try {
    		return (MemorySegment) method.invokeExact(
    			allocator,
    			image,
    			size,
    			workerCount
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#createWorldFromSnapshot].
    public static @Nullable WorldId createWorldFromSnapshot(
    	SegmentAllocator allocator,
    	NativeByteArray image,
    	int size,
    	int workerCount
    ) {
    	MemorySegment segment = createWorldFromSnapshot(
    		allocator,
    		image.memorySegment(),
    		size,
    		workerCount
    	);
    
    	if (segment.equals(MemorySegment.NULL))
    		return null;
    	
    	return new WorldId(segment);
    }

}