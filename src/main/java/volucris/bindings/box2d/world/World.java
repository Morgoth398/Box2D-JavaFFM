/*
 * MACHINE GENERATED FILE, DO NOT EDIT.
 */
package volucris.bindings.box2d.world;

import edu.umd.cs.findbugs.annotations.Nullable;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.SegmentAllocator;
import java.lang.invoke.MethodHandle;
import volucris.bindings.box2d.Profile;
import volucris.bindings.box2d.dynamicTree.TreeStats;
import volucris.bindings.box2d.events.BodyEvents;
import volucris.bindings.box2d.events.ContactEvents;
import volucris.bindings.box2d.events.SensorEvents;
import volucris.bindings.box2d.geometry.Capsule;
import volucris.bindings.box2d.geometry.ShapeProxy;
import volucris.bindings.box2d.math.AABB;
import volucris.bindings.box2d.math.Vec2;
import volucris.bindings.box2d.shape.QueryFilter;

import static java.lang.foreign.ValueLayout.*;
import static volucris.bindings.core.FFMUtils.*;

/**
 * 
 */
public final class World {

    private static final LazyConstant<MethodHandle> B2_CREATE_WORLD;
    private static final LazyConstant<MethodHandle> B2_DESTROY_WORLD;
    private static final LazyConstant<MethodHandle> B2_WORLD_IS_VALID;
    private static final LazyConstant<MethodHandle> B2_WORLD_STEP;
    private static final LazyConstant<MethodHandle> B2_WORLD_DRAW;
    private static final LazyConstant<MethodHandle> B2_WORLD_GET_BODY_EVENTS;
    private static final LazyConstant<MethodHandle> B2_WORLD_GET_SENSOR_EVENTS;
    private static final LazyConstant<MethodHandle> B2_WORLD_GET_CONTACT_EVENTS;
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
    private static final LazyConstant<MethodHandle> B2_WORLD_SET_HIT_EVENT_THRESHOLD;
    private static final LazyConstant<MethodHandle> B2_WORLD_GET_HIT_EVENT_THRESHOLD;
    private static final LazyConstant<MethodHandle> B2_WORLD_SET_CUSTOM_FILTER_CALLBACK;
    private static final LazyConstant<MethodHandle> B2_WORLD_SET_PRE_SOLVE_CALLBACK;
    private static final LazyConstant<MethodHandle> B2_WORLD_SET_GRAVITY;
    private static final LazyConstant<MethodHandle> B2_WORLD_GET_GRAVITY;
    private static final LazyConstant<MethodHandle> B2_WORLD_EXPLODE;
    private static final LazyConstant<MethodHandle> B2_WORLD_SET_CONTACT_TUNING;
    private static final LazyConstant<MethodHandle> B2_WORLD_SET_MAXIMUM_LINEAR_SPEED;
    private static final LazyConstant<MethodHandle> B2_WORLD_GET_MAXIMUM_LINEAR_SPEED;
    private static final LazyConstant<MethodHandle> B2_WORLD_ENABLE_WARM_STARTING;
    private static final LazyConstant<MethodHandle> B2_WORLD_IS_WARM_STARTING_ENABLED;
    private static final LazyConstant<MethodHandle> B2_WORLD_GET_AWAKE_BODY_COUNT;
    private static final LazyConstant<MethodHandle> B2_WORLD_GET_PROFILE;
    private static final LazyConstant<MethodHandle> B2_WORLD_GET_COUNTERS;
    private static final LazyConstant<MethodHandle> B2_WORLD_SET_USER_DATA;
    private static final LazyConstant<MethodHandle> B2_WORLD_GET_USER_DATA;
    private static final LazyConstant<MethodHandle> B2_WORLD_SET_FRICTION_CALLBACK;
    private static final LazyConstant<MethodHandle> B2_WORLD_SET_RESTITUTION_CALLBACK;
    private static final LazyConstant<MethodHandle> B2_WORLD_DUMP_MEMORY_STATS;
    private static final LazyConstant<MethodHandle> B2_WORLD_REBUILD_STATIC_TREE;
    private static final LazyConstant<MethodHandle> B2_WORLD_ENABLE_SPECULATIVE;

    static {
        //@formatter:off
        B2_CREATE_WORLD = downcallHandle("b2CreateWorld", WorldId.LAYOUT, UNBOUNDED_ADDRESS);
        B2_DESTROY_WORLD = downcallHandleVoid("b2DestroyWorld", WorldId.LAYOUT);
        B2_WORLD_IS_VALID = downcallHandle("b2World_IsValid", JAVA_BOOLEAN, WorldId.LAYOUT);
        B2_WORLD_STEP = downcallHandleVoid("b2World_Step", WorldId.LAYOUT, JAVA_FLOAT, JAVA_INT);
        B2_WORLD_DRAW = downcallHandleVoid("b2World_Draw", WorldId.LAYOUT, UNBOUNDED_ADDRESS);
        B2_WORLD_GET_BODY_EVENTS = downcallHandle("b2World_GetBodyEvents", BodyEvents.LAYOUT, WorldId.LAYOUT);
        B2_WORLD_GET_SENSOR_EVENTS = downcallHandle("b2World_GetSensorEvents", SensorEvents.LAYOUT, WorldId.LAYOUT);
        B2_WORLD_GET_CONTACT_EVENTS = downcallHandle("b2World_GetContactEvents", ContactEvents.LAYOUT, WorldId.LAYOUT);
        B2_WORLD_OVERLAP_AABB = downcallHandle("b2World_OverlapAABB", TreeStats.LAYOUT, WorldId.LAYOUT, AABB.LAYOUT, QueryFilter.LAYOUT, UNBOUNDED_ADDRESS, UNBOUNDED_ADDRESS);
        B2_WORLD_OVERLAP_SHAPE = downcallHandle("b2World_OverlapShape", TreeStats.LAYOUT, WorldId.LAYOUT, UNBOUNDED_ADDRESS, QueryFilter.LAYOUT, UNBOUNDED_ADDRESS, UNBOUNDED_ADDRESS);
        B2_WORLD_CAST_RAY = downcallHandle("b2World_CastRay", TreeStats.LAYOUT, WorldId.LAYOUT, Vec2.LAYOUT, Vec2.LAYOUT, QueryFilter.LAYOUT, UNBOUNDED_ADDRESS, UNBOUNDED_ADDRESS);
        B2_WORLD_CAST_RAY_CLOSEST = downcallHandle("b2World_CastRayClosest", RayResult.LAYOUT, WorldId.LAYOUT, Vec2.LAYOUT, Vec2.LAYOUT, QueryFilter.LAYOUT);
        B2_WORLD_CAST_SHAPE = downcallHandle("b2World_CastShape", TreeStats.LAYOUT, WorldId.LAYOUT, UNBOUNDED_ADDRESS, Vec2.LAYOUT, QueryFilter.LAYOUT, UNBOUNDED_ADDRESS, UNBOUNDED_ADDRESS);
        B2_WORLD_CAST_MOVER = downcallHandle("b2World_CastMover", JAVA_FLOAT, WorldId.LAYOUT, UNBOUNDED_ADDRESS, Vec2.LAYOUT, QueryFilter.LAYOUT);
        B2_WORLD_COLLIDE_MOVER = downcallHandleVoid("b2World_CollideMover", WorldId.LAYOUT, UNBOUNDED_ADDRESS, QueryFilter.LAYOUT, UNBOUNDED_ADDRESS, UNBOUNDED_ADDRESS);
        B2_WORLD_ENABLE_SLEEPING = downcallHandleVoid("b2World_EnableSleeping", WorldId.LAYOUT, JAVA_BOOLEAN);
        B2_WORLD_IS_SLEEPING_ENABLED = downcallHandle("b2World_IsSleepingEnabled", JAVA_BOOLEAN, WorldId.LAYOUT);
        B2_WORLD_ENABLE_CONTINUOUS = downcallHandleVoid("b2World_EnableContinuous", WorldId.LAYOUT, JAVA_BOOLEAN);
        B2_WORLD_IS_CONTINUOUS_ENABLED = downcallHandle("b2World_IsContinuousEnabled", JAVA_BOOLEAN, WorldId.LAYOUT);
        B2_WORLD_SET_RESTITUTION_THRESHOLD = downcallHandleVoid("b2World_SetRestitutionThreshold", WorldId.LAYOUT, JAVA_FLOAT);
        B2_WORLD_GET_RESTITUTION_THRESHOLD = downcallHandle("b2World_GetRestitutionThreshold", JAVA_FLOAT, WorldId.LAYOUT);
        B2_WORLD_SET_HIT_EVENT_THRESHOLD = downcallHandleVoid("b2World_SetHitEventThreshold", WorldId.LAYOUT, JAVA_FLOAT);
        B2_WORLD_GET_HIT_EVENT_THRESHOLD = downcallHandle("b2World_GetHitEventThreshold", JAVA_FLOAT, WorldId.LAYOUT);
        B2_WORLD_SET_CUSTOM_FILTER_CALLBACK = downcallHandleVoid("b2World_SetCustomFilterCallback", WorldId.LAYOUT, UNBOUNDED_ADDRESS, UNBOUNDED_ADDRESS);
        B2_WORLD_SET_PRE_SOLVE_CALLBACK = downcallHandleVoid("b2World_SetPreSolveCallback", WorldId.LAYOUT, UNBOUNDED_ADDRESS, UNBOUNDED_ADDRESS);
        B2_WORLD_SET_GRAVITY = downcallHandleVoid("b2World_SetGravity", WorldId.LAYOUT, Vec2.LAYOUT);
        B2_WORLD_GET_GRAVITY = downcallHandle("b2World_GetGravity", Vec2.LAYOUT, WorldId.LAYOUT);
        B2_WORLD_EXPLODE = downcallHandleVoid("b2World_Explode", WorldId.LAYOUT, UNBOUNDED_ADDRESS);
        B2_WORLD_SET_CONTACT_TUNING = downcallHandleVoid("b2World_SetContactTuning", WorldId.LAYOUT, JAVA_FLOAT, JAVA_FLOAT, JAVA_FLOAT);
        B2_WORLD_SET_MAXIMUM_LINEAR_SPEED = downcallHandleVoid("b2World_SetMaximumLinearSpeed", WorldId.LAYOUT, JAVA_FLOAT);
        B2_WORLD_GET_MAXIMUM_LINEAR_SPEED = downcallHandle("b2World_GetMaximumLinearSpeed", JAVA_FLOAT, WorldId.LAYOUT);
        B2_WORLD_ENABLE_WARM_STARTING = downcallHandleVoid("b2World_EnableWarmStarting", WorldId.LAYOUT, JAVA_BOOLEAN);
        B2_WORLD_IS_WARM_STARTING_ENABLED = downcallHandle("b2World_IsWarmStartingEnabled", JAVA_BOOLEAN, WorldId.LAYOUT);
        B2_WORLD_GET_AWAKE_BODY_COUNT = downcallHandle("b2World_GetAwakeBodyCount", JAVA_INT, WorldId.LAYOUT);
        B2_WORLD_GET_PROFILE = downcallHandle("b2World_GetProfile", Profile.LAYOUT, WorldId.LAYOUT);
        B2_WORLD_GET_COUNTERS = downcallHandle("b2World_GetCounters", Counters.LAYOUT, WorldId.LAYOUT);
        B2_WORLD_SET_USER_DATA = downcallHandleVoid("b2World_SetUserData", WorldId.LAYOUT, UNBOUNDED_ADDRESS);
        B2_WORLD_GET_USER_DATA = downcallHandle("b2World_GetUserData", UNBOUNDED_ADDRESS, WorldId.LAYOUT);
        B2_WORLD_SET_FRICTION_CALLBACK = downcallHandleVoid("b2World_SetFrictionCallback", WorldId.LAYOUT, UNBOUNDED_ADDRESS);
        B2_WORLD_SET_RESTITUTION_CALLBACK = downcallHandleVoid("b2World_SetRestitutionCallback", WorldId.LAYOUT, UNBOUNDED_ADDRESS);
        B2_WORLD_DUMP_MEMORY_STATS = downcallHandleVoid("b2World_DumpMemoryStats", WorldId.LAYOUT);
        B2_WORLD_REBUILD_STATIC_TREE = downcallHandleVoid("b2World_RebuildStaticTree", WorldId.LAYOUT);
        B2_WORLD_ENABLE_SPECULATIVE = downcallHandleVoid("b2World_EnableSpeculative", WorldId.LAYOUT, JAVA_BOOLEAN);
        //@formatter:on
    }

    private World() {
    }

    /**
     * Create a world for rigid body simulation. A world contains bodies, shapes, and constraints. You make create up to 128 worlds. Each world is completely independent and may be simulated in parallel.
     */
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
    
    /**
     * Typed method of {@link #createWorld}.
     */
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
    
    /**
     * Destroy a world
     */
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
    
    /**
     * Typed method of {@link #destroyWorld}.
     */
    public static void destroyWorld(
        WorldId worldId
    ) {
        destroyWorld(
            worldId.memorySegment()
        );
    }
    
    /**
     * World id validation. Provides validation for up to 64K allocations.
     */
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
    
    /**
     * Typed method of {@link #isValid}.
     */
    public static boolean isValid(
        WorldId id
    ) {
        return (boolean) isValid(
            id.memorySegment()
        );
    }
    
    /**
     * Simulate a world for one time step. This performs collision detection, integration, and constraint solution.
     */
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
    
    /**
     * Typed method of {@link #step}.
     */
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
    
    /**
     * Call this to draw shapes and other debug draw data
     */
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
    
    /**
     * Typed method of {@link #draw}.
     */
    public static void draw(
        WorldId worldId, 
        DebugDraw draw
    ) {
        draw(
            worldId.memorySegment(), 
            draw.memorySegment()
        );
    }
    
    /**
     * Get the body events for the current time step. The event data is transient. Do not store a reference to this data.
     */
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
    
    /**
     * Typed method of {@link #getBodyEvents}.
     */
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
    
    /**
     * Get sensor events for the current time step. The event data is transient. Do not store a reference to this data.
     */
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
    
    /**
     * Typed method of {@link #getSensorEvents}.
     */
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
    
    /**
     * Get contact events for this current time step. The event data is transient. Do not store a reference to this data.
     */
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
    
    /**
     * Typed method of {@link #getContactEvents}.
     */
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
    
    /**
     * Overlap test for all shapes that *potentially* overlap the provided AABB
     */
    public static MemorySegment overlapAABB(
        SegmentAllocator allocator,
        MemorySegment worldId, 
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
                aabb, 
                filter, 
                fcn, 
                context
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #overlapAABB}.
     */
    public static @Nullable TreeStats overlapAABB(
        SegmentAllocator allocator,
        WorldId worldId, 
        AABB aabb, 
        QueryFilter filter, 
        OverlapResultFcn fcn, 
        MemorySegment context
    ) {
        MemorySegment segment = overlapAABB(
            allocator,
            worldId.memorySegment(), 
            aabb.memorySegment(), 
            filter.memorySegment(), 
            fcn.memorySegment(), 
            context
        );
    
        if (segment.equals(MemorySegment.NULL))
            return null;
    
        return new TreeStats(segment);
    }
    
    /**
     * Overlap test for all shapes that overlap the provided shape proxy.
     */
    public static MemorySegment overlapShape(
        SegmentAllocator allocator,
        MemorySegment worldId, 
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
                proxy, 
                filter, 
                fcn, 
                context
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #overlapShape}.
     */
    public static @Nullable TreeStats overlapShape(
        SegmentAllocator allocator,
        WorldId worldId, 
        ShapeProxy proxy, 
        QueryFilter filter, 
        OverlapResultFcn fcn, 
        MemorySegment context
    ) {
        MemorySegment segment = overlapShape(
            allocator,
            worldId.memorySegment(), 
            proxy.memorySegment(), 
            filter.memorySegment(), 
            fcn.memorySegment(), 
            context
        );
    
        if (segment.equals(MemorySegment.NULL))
            return null;
    
        return new TreeStats(segment);
    }
    
    /**
     * Cast a ray into the world to collect shapes in the path of the ray. Your callback function controls whether you get the closest point, any point, or n-points.
     */
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
    
    /**
     * Typed method of {@link #castRay}.
     */
    public static @Nullable TreeStats castRay(
        SegmentAllocator allocator,
        WorldId worldId, 
        Vec2 origin, 
        Vec2 translation, 
        QueryFilter filter, 
        CastResultFcn fcn, 
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
    
    /**
     * Cast a ray into the world to collect the closest hit. This is a convenience function. Ignores initial overlap. This is less general than b2World_CastRay() and does not allow for custom filtering.
     */
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
    
    /**
     * Typed method of {@link #castRayClosest}.
     */
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
    
    /**
     * Cast a shape through the world. Similar to a cast ray except that a shape is cast instead of a point.
     */
    public static MemorySegment castShape(
        SegmentAllocator allocator,
        MemorySegment worldId, 
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
    
    /**
     * Typed method of {@link #castShape}.
     */
    public static @Nullable TreeStats castShape(
        SegmentAllocator allocator,
        WorldId worldId, 
        ShapeProxy proxy, 
        Vec2 translation, 
        QueryFilter filter, 
        CastResultFcn fcn, 
        MemorySegment context
    ) {
        MemorySegment segment = castShape(
            allocator,
            worldId.memorySegment(), 
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
    
    /**
     * Cast a capsule mover through the world. This is a special shape cast that handles sliding along other shapes while reducing clipping.
     */
    public static float castMover(
        MemorySegment worldId, 
        MemorySegment mover, 
        MemorySegment translation, 
        MemorySegment filter
    ) {
        MethodHandle method = B2_WORLD_CAST_MOVER.get();
        try {
            return (float) method.invokeExact(
                worldId, 
                mover, 
                translation, 
                filter
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #castMover}.
     */
    public static float castMover(
        WorldId worldId, 
        Capsule mover, 
        Vec2 translation, 
        QueryFilter filter
    ) {
        return (float) castMover(
            worldId.memorySegment(), 
            mover.memorySegment(), 
            translation.memorySegment(), 
            filter.memorySegment()
        );
    }
    
    /**
     * Collide a capsule mover with the world, gathering collision planes that can be fed to b2SolvePlanes. Useful for kinematic character movement.
     */
    public static void collideMover(
        MemorySegment worldId, 
        MemorySegment mover, 
        MemorySegment filter, 
        MemorySegment fcn, 
        MemorySegment context
    ) {
        MethodHandle method = B2_WORLD_COLLIDE_MOVER.get();
        try {
            method.invokeExact(
                worldId, 
                mover, 
                filter, 
                fcn, 
                context
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #collideMover}.
     */
    public static void collideMover(
        WorldId worldId, 
        Capsule mover, 
        QueryFilter filter, 
        PlaneResultFcn fcn, 
        MemorySegment context
    ) {
        collideMover(
            worldId.memorySegment(), 
            mover.memorySegment(), 
            filter.memorySegment(), 
            fcn.memorySegment(), 
            context
        );
    }
    
    /**
     * Enable/disable sleep. If your application does not need sleeping, you can gain some performance by disabling sleep completely at the world level.
     */
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
    
    /**
     * Typed method of {@link #enableSleeping}.
     */
    public static void enableSleeping(
        WorldId worldId, 
        boolean flag
    ) {
        enableSleeping(
            worldId.memorySegment(), 
            flag
        );
    }
    
    /**
     * Is body sleeping enabled?
     */
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
    
    /**
     * Typed method of {@link #isSleepingEnabled}.
     */
    public static boolean isSleepingEnabled(
        WorldId worldId
    ) {
        return (boolean) isSleepingEnabled(
            worldId.memorySegment()
        );
    }
    
    /**
     * Enable/disable continuous collision between dynamic and static bodies. Generally you should keep continuous collision enabled to prevent fast moving objects from going through static objects. The performance gain from disabling continuous collision is minor.
     */
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
    
    /**
     * Typed method of {@link #enableContinuous}.
     */
    public static void enableContinuous(
        WorldId worldId, 
        boolean flag
    ) {
        enableContinuous(
            worldId.memorySegment(), 
            flag
        );
    }
    
    /**
     * Is continuous collision enabled?
     */
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
    
    /**
     * Typed method of {@link #isContinuousEnabled}.
     */
    public static boolean isContinuousEnabled(
        WorldId worldId
    ) {
        return (boolean) isContinuousEnabled(
            worldId.memorySegment()
        );
    }
    
    /**
     * Adjust the restitution threshold. It is recommended not to make this value very small because it will prevent bodies from sleeping. Usually in meters per second.
     */
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
    
    /**
     * Typed method of {@link #setRestitutionThreshold}.
     */
    public static void setRestitutionThreshold(
        WorldId worldId, 
        float value
    ) {
        setRestitutionThreshold(
            worldId.memorySegment(), 
            value
        );
    }
    
    /**
     * Get the the restitution speed threshold. Usually in meters per second.
     */
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
    
    /**
     * Typed method of {@link #getRestitutionThreshold}.
     */
    public static float getRestitutionThreshold(
        WorldId worldId
    ) {
        return (float) getRestitutionThreshold(
            worldId.memorySegment()
        );
    }
    
    /**
     * Adjust the hit event threshold. This controls the collision speed needed to generate a b2ContactHitEvent. Usually in meters per second.
     */
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
    
    /**
     * Typed method of {@link #setHitEventThreshold}.
     */
    public static void setHitEventThreshold(
        WorldId worldId, 
        float value
    ) {
        setHitEventThreshold(
            worldId.memorySegment(), 
            value
        );
    }
    
    /**
     * Get the the hit event speed threshold. Usually in meters per second.
     */
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
    
    /**
     * Typed method of {@link #getHitEventThreshold}.
     */
    public static float getHitEventThreshold(
        WorldId worldId
    ) {
        return (float) getHitEventThreshold(
            worldId.memorySegment()
        );
    }
    
    /**
     * Register the custom filter callback. This is optional.
     */
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
    
    /**
     * Typed method of {@link #setCustomFilterCallback}.
     */
    public static void setCustomFilterCallback(
        WorldId worldId, 
        CustomFilterFcn fcn, 
        MemorySegment context
    ) {
        setCustomFilterCallback(
            worldId.memorySegment(), 
            fcn.memorySegment(), 
            context
        );
    }
    
    /**
     * Register the pre-solve callback. This is optional.
     */
    public static void setPreSolveCallback(
        MemorySegment worldId, 
        MemorySegment fcn, 
        MemorySegment context
    ) {
        MethodHandle method = B2_WORLD_SET_PRE_SOLVE_CALLBACK.get();
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
    
    /**
     * Typed method of {@link #setPreSolveCallback}.
     */
    public static void setPreSolveCallback(
        WorldId worldId, 
        PreSolveFcn fcn, 
        MemorySegment context
    ) {
        setPreSolveCallback(
            worldId.memorySegment(), 
            fcn.memorySegment(), 
            context
        );
    }
    
    /**
     * Set the gravity vector for the entire world. Box2D has no concept of an up direction and this is left as a decision for the application. Usually in m/s^2.
     */
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
    
    /**
     * Typed method of {@link #setGravity}.
     */
    public static void setGravity(
        WorldId worldId, 
        Vec2 gravity
    ) {
        setGravity(
            worldId.memorySegment(), 
            gravity.memorySegment()
        );
    }
    
    /**
     * Get the gravity vector
     */
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
    
    /**
     * Typed method of {@link #getGravity}.
     */
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
    
    /**
     * Apply a radial explosion
     */
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
    
    /**
     * Typed method of {@link #explode}.
     */
    public static void explode(
        WorldId worldId, 
        ExplosionDef explosionDef
    ) {
        explode(
            worldId.memorySegment(), 
            explosionDef.memorySegment()
        );
    }
    
    /**
     * Adjust contact tuning parameters
     */
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
    
    /**
     * Typed method of {@link #setContactTuning}.
     */
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
    
    /**
     * Set the maximum linear speed. Usually in m/s.
     */
    public static void setMaximumLinearSpeed(
        MemorySegment worldId, 
        float maximumLinearSpeed
    ) {
        MethodHandle method = B2_WORLD_SET_MAXIMUM_LINEAR_SPEED.get();
        try {
            method.invokeExact(
                worldId, 
                maximumLinearSpeed
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #setMaximumLinearSpeed}.
     */
    public static void setMaximumLinearSpeed(
        WorldId worldId, 
        float maximumLinearSpeed
    ) {
        setMaximumLinearSpeed(
            worldId.memorySegment(), 
            maximumLinearSpeed
        );
    }
    
    /**
     * Get the maximum linear speed. Usually in m/s.
     */
    public static float getMaximumLinearSpeed(
        MemorySegment worldId
    ) {
        MethodHandle method = B2_WORLD_GET_MAXIMUM_LINEAR_SPEED.get();
        try {
            return (float) method.invokeExact(
                worldId
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #getMaximumLinearSpeed}.
     */
    public static float getMaximumLinearSpeed(
        WorldId worldId
    ) {
        return (float) getMaximumLinearSpeed(
            worldId.memorySegment()
        );
    }
    
    /**
     * Enable/disable constraint warm starting. Advanced feature for testing. Disabling warm starting greatly reduces stability and provides no performance gain.
     */
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
    
    /**
     * Typed method of {@link #enableWarmStarting}.
     */
    public static void enableWarmStarting(
        WorldId worldId, 
        boolean flag
    ) {
        enableWarmStarting(
            worldId.memorySegment(), 
            flag
        );
    }
    
    /**
     * Is constraint warm starting enabled?
     */
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
    
    /**
     * Typed method of {@link #isWarmStartingEnabled}.
     */
    public static boolean isWarmStartingEnabled(
        WorldId worldId
    ) {
        return (boolean) isWarmStartingEnabled(
            worldId.memorySegment()
        );
    }
    
    /**
     * Get the number of awake bodies.
     */
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
    
    /**
     * Typed method of {@link #getAwakeBodyCount}.
     */
    public static int getAwakeBodyCount(
        WorldId worldId
    ) {
        return (int) getAwakeBodyCount(
            worldId.memorySegment()
        );
    }
    
    /**
     * Get the current world performance profile
     */
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
    
    /**
     * Typed method of {@link #getProfile}.
     */
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
    
    /**
     * Get world counters and sizes
     */
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
    
    /**
     * Typed method of {@link #getCounters}.
     */
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
    
    /**
     * Set the user data pointer.
     */
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
    
    /**
     * Typed method of {@link #setUserData}.
     */
    public static void setUserData(
        WorldId worldId, 
        MemorySegment userData
    ) {
        setUserData(
            worldId.memorySegment(), 
            userData
        );
    }
    
    /**
     * Get the user data pointer.
     */
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
    
    /**
     * Typed method of {@link #getUserData}.
     */
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
    
    /**
     * Set the friction callback. Passing NULL resets to default.
     */
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
    
    /**
     * Typed method of {@link #setFrictionCallback}.
     */
    public static void setFrictionCallback(
        WorldId worldId, 
        FrictionCallback callback
    ) {
        setFrictionCallback(
            worldId.memorySegment(), 
            callback.memorySegment()
        );
    }
    
    /**
     * Set the restitution callback. Passing NULL resets to default.
     */
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
    
    /**
     * Typed method of {@link #setRestitutionCallback}.
     */
    public static void setRestitutionCallback(
        WorldId worldId, 
        RestitutionCallback callback
    ) {
        setRestitutionCallback(
            worldId.memorySegment(), 
            callback.memorySegment()
        );
    }
    
    /**
     * Dump memory stats to box2d_memory.txt
     */
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
    
    /**
     * Typed method of {@link #dumpMemoryStats}.
     */
    public static void dumpMemoryStats(
        WorldId worldId
    ) {
        dumpMemoryStats(
            worldId.memorySegment()
        );
    }
    
    /**
     * This is for internal testing
     */
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
    
    /**
     * Typed method of {@link #rebuildStaticTree}.
     */
    public static void rebuildStaticTree(
        WorldId worldId
    ) {
        rebuildStaticTree(
            worldId.memorySegment()
        );
    }
    
    /**
     * This is for internal testing
     */
    public static void enableSpeculative(
        MemorySegment worldId, 
        boolean flag
    ) {
        MethodHandle method = B2_WORLD_ENABLE_SPECULATIVE.get();
        try {
            method.invokeExact(
                worldId, 
                flag
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #enableSpeculative}.
     */
    public static void enableSpeculative(
        WorldId worldId, 
        boolean flag
    ) {
        enableSpeculative(
            worldId.memorySegment(), 
            flag
        );
    }
    
}