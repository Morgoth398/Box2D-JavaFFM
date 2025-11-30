package volucris.engine.physics.box2d.world;

import java.lang.foreign.Arena;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.SegmentAllocator;
import java.lang.foreign.StructLayout;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;

import org.joml.Vector2f;

import volucris.engine.physics.box2d.Box2D;
import volucris.engine.physics.box2d.bodyEvents.BodyEventListener;
import volucris.engine.physics.box2d.bodyEvents.BodyEvents;
import volucris.engine.physics.box2d.contactEvents.ContactEvents;
import volucris.engine.physics.box2d.contactEvents.ContactListener;
import volucris.engine.physics.box2d.dynamicTree.TreeStats;
import volucris.engine.physics.box2d.geometry.Capsule;
import volucris.engine.physics.box2d.geometry.ShapeProxy;
import volucris.engine.physics.box2d.math.AABB;
import volucris.engine.physics.box2d.math.Vec2;
import volucris.engine.physics.box2d.sensorEvents.SensorEvents;
import volucris.engine.physics.box2d.sensorEvents.SensorListener;
import volucris.engine.physics.box2d.shape.QueryFilter;
import volucris.engine.physics.box2d.world.callbacks.FrictionCallback;
import volucris.engine.physics.box2d.world.callbacks.RestitutionCallback;
import volucris.engine.physics.box2d.world.functions.CastResultFunction;
import volucris.engine.physics.box2d.world.functions.CustomFilterFunction;
import volucris.engine.physics.box2d.world.functions.OverlapResultFunction;
import volucris.engine.physics.box2d.world.functions.PreSolveFunction;
import volucris.engine.utils.VolucrisRuntimeException;

import static java.lang.foreign.ValueLayout.*;
import static volucris.engine.utils.FFMUtils.*;

public final class World {

	private static final StructLayout WORLD_ID_LAYOUT;

	private static final VarHandle INDEX_1;
	private static final VarHandle GENERATION;

	private static final MethodHandle B2_CREATE_WORLD;
	private static final MethodHandle B2_DESTORY_WORLD;
	private static final MethodHandle B2_WORLD_IS_VALID;
	private static final MethodHandle B2_WORLD_STEP;
	private static final MethodHandle B2_WORLD_DRAW;
	private static final MethodHandle B2_WORLD_GET_BODY_EVENTS;
	private static final MethodHandle B2_WORLD_GET_SENSOR_EVENTS;
	private static final MethodHandle B2_WORLD_GET_CONTACT_EVENTS;
	private static final MethodHandle B2_WORLD_OVERLAP_AABB;
	private static final MethodHandle B2_WORLD_OVERLAP_SHAPE;
	private static final MethodHandle B2_WORLD_CAST_RAY;
	private static final MethodHandle B2_WORLD_CAST_RAY_CLOSEST;
	private static final MethodHandle B2_WORLD_CAST_SHAPE;
	private static final MethodHandle B2_WORLD_CAST_MOVER;
	private static final MethodHandle B2_WORLD_ENABLE_SLEEPING;
	private static final MethodHandle B2_WORLD_IS_SLEEPING_ENABLED;
	private static final MethodHandle B2_WORLD_ENABLE_CONTINUOUS;
	private static final MethodHandle B2_WORLD_IS_CONTINUOUS_ENABLED;
	private static final MethodHandle B2_WORLD_SET_RESTITUTION_THRESHOLD;
	private static final MethodHandle B2_WORLD_GET_RESTITUTION_THRESHOLD;
	private static final MethodHandle B2_WORLD_SET_HIT_EVENT_THRESHOLD;
	private static final MethodHandle B2_WORLD_GET_HIT_EVENT_THRESHOLD;
	private static final MethodHandle B2_WORLD_SET_CUSTOM_FILTER_CALLBACK;
	private static final MethodHandle B2_WORLD_SET_PRE_SOLVE_CALLBACK;
	private static final MethodHandle B2_WORLD_SET_GRAVITY;
	private static final MethodHandle B2_WORLD_GET_GRAVITY;
	private static final MethodHandle B2_WORLD_EXPLODE;
	private static final MethodHandle B2_WORLD_SET_CONTACT_TUNING;
	private static final MethodHandle B2_WORLD_SET_MAXIMUM_LINEAR_SPEED;
	private static final MethodHandle B2_WORLD_GET_MAXIMUM_LINEAR_SPEED;
	private static final MethodHandle B2_WORLD_ENABLE_WARM_STARTING;
	private static final MethodHandle B2_WORLD_IS_WARM_STARTING_ENABLED;
	private static final MethodHandle B2_WORLD_GET_AWAKE_BODY_COUNT;
	private static final MethodHandle B2_WORLD_GET_PROFILE;
	private static final MethodHandle B2_WORLD_GET_COUNTERS;
	private static final MethodHandle B2_WORLD_SET_FRICTION_CALLBACK;
	private static final MethodHandle B2_WORLD_SET_RESTITUTION_CALLBACK;
	private static final MethodHandle B2_WORLD_DUMP_MEMORY_STATS;
	private static final MethodHandle B2_WORLD_REBUILD_STATIC_TREE;
	private static final MethodHandle B2_WORLD_ENABLE_SPECULATIVE;

	private final MemorySegment b2WorldId;

	private WorldId worldId;

	private ContactListener contactListener;
	private SensorListener sensorListener;
	private BodyEventListener bodyListener;
	
	private Object internalUserData;
	private Object userData;

	private Vec2 vecTmp;
	private Vec2 vecTmp2;

	static {

		//@formatter:off
		WORLD_ID_LAYOUT = MemoryLayout.structLayout(
				JAVA_SHORT.withName("index1"),
				JAVA_SHORT.withName("generation")
			).withName("b2WorldId");

		INDEX_1 = varHandle(WORLD_ID_LAYOUT, "index1");
		GENERATION = varHandle(WORLD_ID_LAYOUT, "generation");
		
		B2_CREATE_WORLD = downcallHandle("b2CreateWorld", WORLD_ID_LAYOUT, ADDRESS);
		B2_DESTORY_WORLD = downcallHandleVoid("b2DestroyWorld", WORLD_ID_LAYOUT);	
		B2_WORLD_IS_VALID = downcallHandle("b2World_IsValid", JAVA_BOOLEAN, WORLD_ID_LAYOUT);
		B2_WORLD_STEP = downcallHandleVoid("b2World_Step", WORLD_ID_LAYOUT, JAVA_FLOAT, JAVA_INT);
		B2_WORLD_DRAW = downcallHandleVoid("b2World_Draw", WORLD_ID_LAYOUT, ADDRESS);
		B2_WORLD_GET_BODY_EVENTS = downcallHandle("b2World_GetBodyEvents", BodyEvents.LAYOUT(), WORLD_ID_LAYOUT);
		B2_WORLD_GET_SENSOR_EVENTS = downcallHandle("b2World_GetSensorEvents", SensorEvents.LAYOUT(), WORLD_ID_LAYOUT);
		B2_WORLD_GET_CONTACT_EVENTS = downcallHandle("b2World_GetContactEvents", ContactEvents.LAYOUT(), WORLD_ID_LAYOUT);
		B2_WORLD_OVERLAP_AABB = downcallHandle("b2World_OverlapAABB", TreeStats.LAYOUT(), WORLD_ID_LAYOUT, AABB.LAYOUT(), QueryFilter.LAYOUT(), ADDRESS, ADDRESS);
		B2_WORLD_OVERLAP_SHAPE = downcallHandle("b2World_OverlapShape", TreeStats.LAYOUT(), WORLD_ID_LAYOUT, ADDRESS, QueryFilter.LAYOUT(), ADDRESS, ADDRESS);
		B2_WORLD_CAST_RAY = downcallHandle("b2World_CastRay", TreeStats.LAYOUT(), WORLD_ID_LAYOUT, Vec2.LAYOUT(), Vec2.LAYOUT(), QueryFilter.LAYOUT(), ADDRESS, ADDRESS);
		B2_WORLD_CAST_RAY_CLOSEST = downcallHandle("b2World_CastRayClosest", RayResult.LAYOUT(), WORLD_ID_LAYOUT, Vec2.LAYOUT(), Vec2.LAYOUT(), QueryFilter.LAYOUT());
		B2_WORLD_CAST_SHAPE = downcallHandle("b2World_CastShape", TreeStats.LAYOUT(), WORLD_ID_LAYOUT, ADDRESS, Vec2.LAYOUT(), QueryFilter.LAYOUT(), ADDRESS, ADDRESS);
		B2_WORLD_CAST_MOVER = downcallHandle("b2World_CastMover", JAVA_FLOAT, WORLD_ID_LAYOUT, ADDRESS, Vec2.LAYOUT(), QueryFilter.LAYOUT());
		B2_WORLD_ENABLE_SLEEPING = downcallHandleVoid("b2World_EnableSleeping", WORLD_ID_LAYOUT, JAVA_BOOLEAN);
		B2_WORLD_IS_SLEEPING_ENABLED = downcallHandle("b2World_IsSleepingEnabled", JAVA_BOOLEAN, WORLD_ID_LAYOUT);
		B2_WORLD_ENABLE_CONTINUOUS = downcallHandleVoid("b2World_EnableContinuous", WORLD_ID_LAYOUT, JAVA_BOOLEAN);
		B2_WORLD_IS_CONTINUOUS_ENABLED = downcallHandle("b2World_IsContinuousEnabled", JAVA_BOOLEAN, WORLD_ID_LAYOUT);
		B2_WORLD_SET_RESTITUTION_THRESHOLD = downcallHandleVoid("b2World_SetRestitutionThreshold", WORLD_ID_LAYOUT, JAVA_FLOAT);
		B2_WORLD_GET_RESTITUTION_THRESHOLD = downcallHandle("b2World_GetRestitutionThreshold", JAVA_FLOAT, WORLD_ID_LAYOUT);
		B2_WORLD_SET_HIT_EVENT_THRESHOLD = downcallHandleVoid("b2World_SetHitEventThreshold", WORLD_ID_LAYOUT, JAVA_FLOAT);
		B2_WORLD_GET_HIT_EVENT_THRESHOLD = downcallHandle("b2World_GetHitEventThreshold", JAVA_FLOAT, WORLD_ID_LAYOUT);
		B2_WORLD_SET_CUSTOM_FILTER_CALLBACK = downcallHandleVoid("b2World_SetCustomFilterCallback", WORLD_ID_LAYOUT, ADDRESS, ADDRESS);
		B2_WORLD_SET_PRE_SOLVE_CALLBACK = downcallHandleVoid("b2World_SetPreSolveCallback", WORLD_ID_LAYOUT, ADDRESS, ADDRESS);
		B2_WORLD_SET_GRAVITY = downcallHandleVoid("b2World_SetGravity", WORLD_ID_LAYOUT, Vec2.LAYOUT());
		B2_WORLD_GET_GRAVITY = downcallHandle("b2World_GetGravity", Vec2.LAYOUT(), WORLD_ID_LAYOUT);
		B2_WORLD_EXPLODE = downcallHandleVoid("b2World_Explode", WORLD_ID_LAYOUT, ADDRESS);
		B2_WORLD_SET_CONTACT_TUNING = downcallHandleVoid("b2World_SetContactTuning", WORLD_ID_LAYOUT, JAVA_FLOAT, JAVA_FLOAT, JAVA_FLOAT);
		B2_WORLD_SET_MAXIMUM_LINEAR_SPEED = downcallHandleVoid("b2World_SetMaximumLinearSpeed", WORLD_ID_LAYOUT, JAVA_FLOAT);
		B2_WORLD_GET_MAXIMUM_LINEAR_SPEED = downcallHandle("b2World_GetMaximumLinearSpeed", JAVA_FLOAT, WORLD_ID_LAYOUT);
		B2_WORLD_ENABLE_WARM_STARTING = downcallHandleVoid("b2World_EnableWarmStarting", WORLD_ID_LAYOUT, JAVA_BOOLEAN);
		B2_WORLD_IS_WARM_STARTING_ENABLED = downcallHandle("b2World_IsWarmStartingEnabled", JAVA_BOOLEAN, WORLD_ID_LAYOUT);
		B2_WORLD_GET_AWAKE_BODY_COUNT = downcallHandle("b2World_GetAwakeBodyCount", JAVA_INT, WORLD_ID_LAYOUT);
		B2_WORLD_GET_PROFILE = downcallHandle("b2World_GetProfile", Profile.LAYOUT(), WORLD_ID_LAYOUT);
		B2_WORLD_GET_COUNTERS = downcallHandle("b2World_GetCounters", Counters.LAYOUT(), WORLD_ID_LAYOUT);
		B2_WORLD_SET_FRICTION_CALLBACK = downcallHandleVoid("b2World_SetFrictionCallback", WORLD_ID_LAYOUT, ADDRESS);
		B2_WORLD_SET_RESTITUTION_CALLBACK = downcallHandleVoid("b2World_SetRestitutionCallback", WORLD_ID_LAYOUT, ADDRESS);
		B2_WORLD_DUMP_MEMORY_STATS = downcallHandleVoid("b2World_DumpMemoryStats", WORLD_ID_LAYOUT);
		B2_WORLD_REBUILD_STATIC_TREE = downcallHandleVoid("b2World_RebuildStaticTree", WORLD_ID_LAYOUT);
		B2_WORLD_ENABLE_SPECULATIVE = downcallHandleVoid("b2World_EnableSpeculative", WORLD_ID_LAYOUT, JAVA_BOOLEAN);
		//@formatter:on
	}

	/**
	 * Create a world for rigid body simulation.
	 */
	public World() {
		this(new WorldDef());
	}

	/**
	 * Create a world for rigid body simulation.
	 */
	public World(WorldDef worldDef) {
		try {
			SegmentAllocator allocator = Arena.ofAuto();
			b2WorldId = (MemorySegment) B2_CREATE_WORLD.invokeExact(allocator, worldDef.memorySegment());
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot create World.");
		}

		vecTmp = new Vec2();
		vecTmp2 = new Vec2();

		worldId = getWorldId(b2WorldId);

		Box2D.addWorld(this, worldId);
	}

	/**
	 * Destroy a world.
	 */
	public void destroyWorld() {
		try {
			B2_DESTORY_WORLD.invokeExact(b2WorldId);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot destroy world.");
		}

		Box2D.removeWorld(worldId);
	}

	/**
	 * World id validation. Provides validation for up to 64K allocations.
	 */
	public boolean isValid() {
		try {
			return (boolean) B2_WORLD_IS_VALID.invokeExact(b2WorldId);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot validate world.");
		}
	}

	/**
	 * Simulate a world for one time step.
	 * <p>
	 * Implementation: Invokes the set listeners for events after the step.
	 */
	public void step(float timeStep, int subStepCount) {
		try {
			B2_WORLD_STEP.invokeExact(b2WorldId, timeStep, subStepCount);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot do physics step.");
		}
		
		if (contactListener != null)
			contactListener.handleContactEvents(this);
		if (sensorListener != null)
			sensorListener.handleSensorEvents(this);
		if (bodyListener != null)
			bodyListener.handleBodyEvents(this);
	}

	/**
	 * Call this to draw shapes and other debug draw data.
	 */
	public void draw(DebugDraw debugDraw) {
		try {
			B2_WORLD_DRAW.invokeExact(b2WorldId, debugDraw.memorySegment());
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot draw world.");
		}
	}

	/**
	 * Get the body events for the current time step.
	 */
	public BodyEvents getBodyEvents(BodyEvents target) {
		try (Arena arena = Arena.ofConfined()) {
			SegmentAllocator allocator = arena;
			MemorySegment segment = (MemorySegment) B2_WORLD_GET_BODY_EVENTS.invokeExact(allocator, b2WorldId);
			target.set(segment, this);
			return target;
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot get body events.");
		}
	}

	/**
	 * Get sensor events for the current time step.
	 */
	public SensorEvents getSensorEvents(SensorEvents target) {
		try (Arena arena = Arena.ofConfined()) {
			SegmentAllocator allocator = arena;
			MemorySegment segment = (MemorySegment) B2_WORLD_GET_SENSOR_EVENTS.invokeExact(allocator, b2WorldId);
			target.set(segment, this);
			return target;
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot get sensor events.");
		}
	}

	/**
	 * Get contact events for this current time step.
	 */
	public ContactEvents getContactEvents(ContactEvents target) {
		try (Arena arena = Arena.ofConfined()) {
			SegmentAllocator allocator = arena;
			MemorySegment segment = (MemorySegment) B2_WORLD_GET_CONTACT_EVENTS.invokeExact(allocator, b2WorldId);
			target.set(segment, this);
			return target;
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot get contact events.");
		}
	}

	/**
	 * Overlap test for all shapes that potentially overlap the provided AABB.
	 */
	public TreeStats overlapAABB(TreeStats target, AABB aabb, QueryFilter queryFilter, OverlapResultFunction fcn,
			MemorySegment context) {
		try (Arena arena = Arena.ofConfined()) {
			SegmentAllocator allocator = arena;

			MemorySegment aabbAddr = aabb.memorySegment();
			MemorySegment filterAddr = queryFilter.memorySegment();
			MemorySegment fcnAddr = fcn.memorySegment();
			MethodHandle method = B2_WORLD_OVERLAP_AABB;
			MemorySegment segment = (MemorySegment) method.invokeExact(allocator, b2WorldId, aabbAddr, filterAddr,
					fcnAddr, context);

			target.set(segment);
			return target;
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot call overlap aabb.");
		}
	}

	/**
	 * Overlap test for all shapes that potentially overlap the provided AABB.
	 */
	public TreeStats overlapAABB(AABB aabb, QueryFilter queryFilter, OverlapResultFunction fcn, MemorySegment context) {
		return overlapAABB(new TreeStats(), aabb, queryFilter, fcn, context);
	}

	/**
	 * Overlap test for all shapes that overlap the provided shape proxy.
	 */
	public TreeStats overlapShape(TreeStats target, ShapeProxy proxy, QueryFilter queryFilter,
			OverlapResultFunction fcn, MemorySegment context) {
		try (Arena arena = Arena.ofConfined()) {
			SegmentAllocator allocator = arena;

			MemorySegment proxyAddr = proxy.memorySegment();
			MemorySegment filterAddr = queryFilter.memorySegment();
			MemorySegment fcnAddr = fcn.memorySegment();
			MethodHandle method = B2_WORLD_OVERLAP_SHAPE;
			MemorySegment segment = (MemorySegment) method.invokeExact(allocator, b2WorldId, proxyAddr, filterAddr,
					fcnAddr, context);

			target.set(segment);
			return target;
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot call overlap shape.");
		}
	}

	/**
	 * Overlap test for all shapes that overlap the provided shape proxy.
	 */
	public TreeStats overlapShape(ShapeProxy proxy, QueryFilter queryFilter, OverlapResultFunction fcn,
			MemorySegment context) {
		return overlapShape(new TreeStats(), proxy, queryFilter, fcn, context);
	}

	/**
	 * Cast a ray into the world to collect shapes in the path of the ray.
	 */
	public TreeStats castRay(TreeStats target, Vector2f origin, Vector2f translation, QueryFilter queryFilter,
			CastResultFunction fcn, MemorySegment context) {
		try (Arena arena = Arena.ofConfined()) {
			SegmentAllocator allocator = arena;

			vecTmp.set(origin);
			vecTmp2.set(translation);

			MemorySegment originAddr = vecTmp.memorySegment();
			MemorySegment translationAddr = vecTmp2.memorySegment();
			MemorySegment filterAddr = queryFilter.memorySegment();
			MemorySegment fcnAddr = fcn.memorySegment();
			MethodHandle method = B2_WORLD_CAST_RAY;
			MemorySegment segment = (MemorySegment) method.invokeExact(allocator, b2WorldId, originAddr,
					translationAddr, filterAddr, fcnAddr, context);

			target.set(segment);
			return target;
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot cast ray.");
		}
	}

	/**
	 * Cast a ray into the world to collect shapes in the path of the ray.
	 */
	public TreeStats castRay(Vector2f origin, Vector2f translation, QueryFilter queryFilter, CastResultFunction fcn,
			MemorySegment context) {
		return castRay(new TreeStats(), origin, translation, queryFilter, fcn, context);
	}

	/**
	 * Cast a ray into the world to collect the closest hit.
	 */
	public RayResult castRayClosest(RayResult target, Vector2f origin, Vector2f translation, QueryFilter queryFilter) {
		try (Arena arena = Arena.ofConfined()) {
			SegmentAllocator allocator = arena;

			vecTmp.set(origin);
			vecTmp2.set(translation);

			MemorySegment originAddr = vecTmp.memorySegment();
			MemorySegment translationAddr = vecTmp2.memorySegment();
			MemorySegment filterAddr = queryFilter.memorySegment();
			MethodHandle method = B2_WORLD_CAST_RAY_CLOSEST;
			MemorySegment segment = (MemorySegment) method.invokeExact(allocator, b2WorldId, originAddr,
					translationAddr, filterAddr);

			target.set(segment, this);
			return target;
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot cast ray closest.");
		}
	}

	/**
	 * Cast a ray into the world to collect the closest hit.
	 */
	public RayResult castRayClosest(Vector2f origin, Vector2f translation, QueryFilter queryFilter) {
		return castRayClosest(new RayResult(), origin, translation, queryFilter);
	}

	/**
	 * Cast a shape through the world.
	 */
	public TreeStats castShape(TreeStats target, ShapeProxy proxy, Vector2f translation, QueryFilter filter,
			CastResultFunction fcn, MemorySegment context) {
		try (Arena arena = Arena.ofConfined()) {
			SegmentAllocator allocator = arena;

			vecTmp.set(translation);

			MemorySegment proxyAddr = proxy.memorySegment();
			MemorySegment translationAddr = vecTmp.memorySegment();
			MemorySegment filterAddr = filter.memorySegment();
			MemorySegment fcnAddr = fcn.memorySegment();
			MethodHandle method = B2_WORLD_CAST_SHAPE;
			MemorySegment segment = (MemorySegment) method.invokeExact(allocator, b2WorldId, proxyAddr, translationAddr,
					filterAddr, fcnAddr, context);

			target.set(segment);
			return target;
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot chast shape.");
		}
	}

	/**
	 * Cast a shape through the world.
	 */
	public TreeStats castShape(ShapeProxy proxy, Vector2f translation, QueryFilter filter, CastResultFunction fcn,
			MemorySegment context) {
		return castShape(new TreeStats(), proxy, translation, filter, fcn, context);
	}

	/**
	 * Cast a capsule mover through the world.
	 */
	public float castMover(Capsule mover, Vector2f translation, QueryFilter filter) {
		try {
			vecTmp.set(translation);

			MemorySegment moverAddr = mover.memorySegment();
			MemorySegment translationAddr = vecTmp.memorySegment();
			MemorySegment filterAddr = filter.memorySegment();

			return (float) B2_WORLD_CAST_MOVER.invokeExact(b2WorldId, moverAddr, translationAddr, filterAddr);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot cast mover.");
		}
	}

	/**
	 * Enable/disable sleep.
	 */
	public void enableSleeping(boolean enableSleeping) {
		try {
			B2_WORLD_ENABLE_SLEEPING.invokeExact(b2WorldId, enableSleeping);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot enable/ disable sleeping.");
		}
	}

	/**
	 * Is body sleeping enabled?
	 */
	public boolean isSleepingEnabled() {
		try {
			return (boolean) B2_WORLD_IS_SLEEPING_ENABLED.invokeExact(b2WorldId);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot check if sleeping is enabled.");
		}
	}

	/**
	 * Enable/disable continuous collision between dynamic and static bodies.
	 */
	public void enableContinuous(boolean enableContinuous) {
		try {
			B2_WORLD_ENABLE_CONTINUOUS.invokeExact(b2WorldId, enableContinuous);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot enable/ disable continuous.");
		}
	}

	/**
	 * Is continuous collision enabled?
	 */
	public boolean isContinuousEnabled() {
		try {
			return (boolean) B2_WORLD_IS_CONTINUOUS_ENABLED.invokeExact(b2WorldId);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot check if continuous is enabled.");
		}
	}

	/**
	 * Adjust the restitution threshold.
	 */
	public void setRestitutionThreshold(float restitutionThreshold) {
		try {
			B2_WORLD_SET_RESTITUTION_THRESHOLD.invokeExact(b2WorldId, restitutionThreshold);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot set restitution threshold.");
		}
	}

	/**
	 * Get the the restitution speed threshold. Usually in meters per second.
	 */
	public float getRestitutionThreshold() {
		try {
			return (float) B2_WORLD_GET_RESTITUTION_THRESHOLD.invokeExact(b2WorldId);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot get restitution threshold.");
		}
	}

	/**
	 * Adjust the hit event threshold.
	 */
	public void setHitEventThreshold(float hitEventThreshold) {
		try {
			B2_WORLD_SET_HIT_EVENT_THRESHOLD.invokeExact(b2WorldId, hitEventThreshold);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot set hit event threshold.");
		}
	}

	/**
	 * Get the the hit event speed threshold. Usually in meters per second.
	 */
	public float getHitEventThreshold() {
		try {
			return (float) B2_WORLD_GET_HIT_EVENT_THRESHOLD.invokeExact(b2WorldId);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot get hit event threshold.");
		}
	}

	/**
	 * Register the custom filter callback. This is optional.
	 */
	public void setCustomFilterCallback(CustomFilterFunction fcn, MemorySegment context) {
		try {
			B2_WORLD_SET_CUSTOM_FILTER_CALLBACK.invokeExact(b2WorldId, fcn.memorySegment(), context);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot set custom filter callback");
		}
	}

	/**
	 * Register the pre-solve callback. This is optional.
	 */
	public void setPreSolveCallback(PreSolveFunction fcn, MemorySegment context) {
		try {
			B2_WORLD_SET_PRE_SOLVE_CALLBACK.invokeExact(b2WorldId, fcn.memorySegment(), context);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot set pre solve callback.");
		}
	}

	/**
	 * Set the gravity vector for the entire world.
	 */
	public void setGravity(Vector2f gravity) {
		vecTmp.set(gravity);
		setGravity(vecTmp);
	}

	/**
	 * Set the gravity vector for the entire world.
	 */
	public void setGravity(float x, float y) {
		vecTmp.set(x, y);
		setGravity(vecTmp);
	}

	/**
	 * Set the gravity vector for the entire world.
	 */
	private void setGravity(Vec2 gravity) {
		try {
			B2_WORLD_SET_GRAVITY.invokeExact(b2WorldId, gravity.memorySegment());
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot set gravity.");
		}
	}

	/**
	 * Get the gravity vector.
	 */
	public Vector2f getGravity(Vector2f target) {
		try {
			SegmentAllocator allocator = Arena.ofAuto();
			MemorySegment segment = (MemorySegment) B2_WORLD_GET_GRAVITY.invokeExact(allocator, b2WorldId);
			vecTmp.set(segment);
			return vecTmp.get(target);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot get gravity.");
		}
	}

	/**
	 * Get the gravity vector.
	 */
	public Vector2f getGravity() {
		return getGravity(new Vector2f());
	}

	/**
	 * Apply a radial explosion.
	 */
	public void explode(ExplosionDef explosionDef) {
		try {
			B2_WORLD_EXPLODE.invokeExact(b2WorldId, explosionDef.memorySegment());
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Canot explode world.");
		}
	}

	/**
	 * Adjust contact tuning parameters.
	 */
	public void setContactTuning(float hertz, float dampingRatio, float pushSpeed) {
		try {
			B2_WORLD_SET_CONTACT_TUNING.invokeExact(b2WorldId, hertz, dampingRatio, pushSpeed);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot set contact tuning.");
		}
	}

	/**
	 * Set the maximum linear speed. Usually in m/s.
	 */
	public void setMaximumLinearSpeed(float maximumLinearSpeed) {
		try {
			B2_WORLD_SET_MAXIMUM_LINEAR_SPEED.invokeExact(b2WorldId, maximumLinearSpeed);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot set maximum linear speed.");
		}
	}

	/**
	 * Get the maximum linear speed. Usually in m/s.
	 */
	public float getMaximumLinearSpeed() {
		try {
			return (float) B2_WORLD_GET_MAXIMUM_LINEAR_SPEED.invokeExact(b2WorldId);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot get maximum linear speed.");
		}
	}

	/**
	 * Enable/disable constraint warm starting.
	 */
	public void enableWarmStarting(boolean enableWarmStarting) {
		try {
			B2_WORLD_ENABLE_WARM_STARTING.invokeExact(b2WorldId, enableWarmStarting);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot enable/ disable warm starting.");
		}
	}

	/**
	 * Is constraint warm starting enabled?
	 */
	public boolean isWarmStartingEnabled() {
		try {
			return (boolean) B2_WORLD_IS_WARM_STARTING_ENABLED.invokeExact(b2WorldId);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot check if warm starting is enabled.");
		}
	}

	/**
	 * Get the number of awake bodies.
	 */
	public int getAwakeBodyCount() {
		try {
			return (int) B2_WORLD_GET_AWAKE_BODY_COUNT.invokeExact(b2WorldId);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot get awake body count.");
		}
	}

	/**
	 * Get the current world performance profile.
	 */
	public Profile getProfile(Profile target) {
		try (Arena arena = Arena.ofConfined()) {
			SegmentAllocator allocator = arena;

			MemorySegment segment = (MemorySegment) B2_WORLD_GET_PROFILE.invokeExact(allocator, b2WorldId);
			target.set(segment);
			return target;
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot get profile.");
		}
	}

	/**
	 * Get the current world performance profile.
	 */
	public Profile getProfile() {
		return getProfile(new Profile());
	}

	/**
	 * Get world counters and sizes.
	 */
	public Counters getCounters(Counters target) {
		try (Arena arena = Arena.ofConfined()) {
			SegmentAllocator allocator = arena;

			MemorySegment segment = (MemorySegment) B2_WORLD_GET_COUNTERS.invokeExact(allocator, b2WorldId);
			target.set(segment);
			return target;
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot get counters.");
		}
	}

	/**
	 * Get world counters and sizes.
	 */
	public Counters getCounters() {
		return getCounters(new Counters());
	}

	/**
	 * Set the internal user data for the body.
	 * <p>
	 * Do not call.
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
	 * Set the friction callback.
	 */
	public void setFrictionCallback(FrictionCallback callback) {
		try {
			B2_WORLD_SET_FRICTION_CALLBACK.invokeExact(b2WorldId, callback.memorySegment());
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot set friction callback.");
		}
	}

	public void resetFrictionCallback() {
		try {
			B2_WORLD_SET_FRICTION_CALLBACK.invokeExact(b2WorldId, MemorySegment.NULL);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot set friction callback.");
		}
	}

	/**
	 * Set the restitution callback.
	 */
	public void setRestitutionCallback(RestitutionCallback callback) {
		try {
			B2_WORLD_SET_RESTITUTION_CALLBACK.invokeExact(b2WorldId, callback.memorySegment());
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot set restitution callback.");
		}
	}

	public void resetRestitutionCallback() {
		try {
			B2_WORLD_SET_RESTITUTION_CALLBACK.invokeExact(b2WorldId, MemorySegment.NULL);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot set restitution callback.");
		}
	}

	/**
	 * Dump memory stats to box2d_memory.txt.
	 */
	public void dumpMemoryStats() {
		try {
			B2_WORLD_DUMP_MEMORY_STATS.invokeExact(b2WorldId);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot dump memory stats.");
		}
	}

	/**
	 * This is for internal testing.
	 */
	public void rebuildStaticTree() {
		try {
			B2_WORLD_REBUILD_STATIC_TREE.invokeExact(b2WorldId);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot rebuild static tree.");
		}
	}

	/**
	 * This is for internal testing.
	 */
	public void enableSpeculative(boolean enableSpeculative) {
		try {
			B2_WORLD_ENABLE_SPECULATIVE.invokeExact(b2WorldId, enableSpeculative);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot enable/ disable speculative.");
		}
	}

	public void setContactListener(ContactListener contactListener) {
		this.contactListener = contactListener;
	}
	
	public void setSensorListener(SensorListener sensorListener) {
		this.sensorListener = sensorListener;
	}
	
	public void setBodyListener(BodyEventListener bodyListener) {
		this.bodyListener = bodyListener;
	}
	
	public MemorySegment memorySegment() {
		return b2WorldId;
	}

	public WorldId getWorldId() {
		return worldId;
	}

	public static StructLayout LAYOUT() {
		return WORLD_ID_LAYOUT;
	}

	public static WorldId getWorldId(MemorySegment memorySegment) {
		return new WorldId((int) INDEX_1.get(memorySegment), (short) GENERATION.get(memorySegment));
	}

	public static record WorldId(int index1, short generation) {
	};

}
