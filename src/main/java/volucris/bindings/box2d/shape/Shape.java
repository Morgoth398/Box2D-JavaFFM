/*
 * MACHINE GENERATED FILE, DO NOT EDIT.
 */
package volucris.bindings.box2d.shape;

import edu.umd.cs.findbugs.annotations.Nullable;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.SegmentAllocator;
import java.lang.invoke.MethodHandle;
import volucris.bindings.box2d.body.BodyId;
import volucris.bindings.box2d.events.ContactData;
import volucris.bindings.box2d.geometry.Capsule;
import volucris.bindings.box2d.geometry.CastOutput;
import volucris.bindings.box2d.geometry.ChainSegment;
import volucris.bindings.box2d.geometry.Circle;
import volucris.bindings.box2d.geometry.MassData;
import volucris.bindings.box2d.geometry.Polygon;
import volucris.bindings.box2d.geometry.RayCastInput;
import volucris.bindings.box2d.geometry.Segment;
import volucris.bindings.box2d.math.AABB;
import volucris.bindings.box2d.math.Vec2;
import volucris.bindings.box2d.world.WorldId;

import static java.lang.foreign.ValueLayout.*;
import static volucris.bindings.core.FFMUtils.*;

/**
 * 
 */
public final class Shape {

    private static final LazyConstant<MethodHandle> B2_CREATE_CIRCLE_SHAPE;
    private static final LazyConstant<MethodHandle> B2_CREATE_SEGMENT_SHAPE;
    private static final LazyConstant<MethodHandle> B2_CREATE_CAPSULE_SHAPE;
    private static final LazyConstant<MethodHandle> B2_CREATE_POLYGON_SHAPE;
    private static final LazyConstant<MethodHandle> B2_DESTROY_SHAPE;
    private static final LazyConstant<MethodHandle> B2_SHAPE_IS_VALID;
    private static final LazyConstant<MethodHandle> B2_SHAPE_GET_TYPE;
    private static final LazyConstant<MethodHandle> B2_SHAPE_GET_BODY;
    private static final LazyConstant<MethodHandle> B2_SHAPE_GET_WORLD;
    private static final LazyConstant<MethodHandle> B2_SHAPE_IS_SENSOR;
    private static final LazyConstant<MethodHandle> B2_SHAPE_SET_USER_DATA;
    private static final LazyConstant<MethodHandle> B2_SHAPE_GET_USER_DATA;
    private static final LazyConstant<MethodHandle> B2_SHAPE_SET_DENSITY;
    private static final LazyConstant<MethodHandle> B2_SHAPE_GET_DENSITY;
    private static final LazyConstant<MethodHandle> B2_SHAPE_SET_FRICTION;
    private static final LazyConstant<MethodHandle> B2_SHAPE_GET_FRICTION;
    private static final LazyConstant<MethodHandle> B2_SHAPE_SET_RESTITUTION;
    private static final LazyConstant<MethodHandle> B2_SHAPE_GET_RESTITUTION;
    private static final LazyConstant<MethodHandle> B2_SHAPE_SET_MATERIAL;
    private static final LazyConstant<MethodHandle> B2_SHAPE_GET_MATERIAL;
    private static final LazyConstant<MethodHandle> B2_SHAPE_SET_SURFACE_MATERIAL;
    private static final LazyConstant<MethodHandle> B2_SHAPE_GET_SURFACE_MATERIAL;
    private static final LazyConstant<MethodHandle> B2_SHAPE_GET_FILTER;
    private static final LazyConstant<MethodHandle> B2_SHAPE_SET_FILTER;
    private static final LazyConstant<MethodHandle> B2_SHAPE_ENABLE_SENSOR_EVENTS;
    private static final LazyConstant<MethodHandle> B2_SHAPE_ARE_SENSOR_EVENTS_ENABLED;
    private static final LazyConstant<MethodHandle> B2_SHAPE_ENABLE_CONTACT_EVENTS;
    private static final LazyConstant<MethodHandle> B2_SHAPE_ARE_CONTACT_EVENTS_ENABLED;
    private static final LazyConstant<MethodHandle> B2_SHAPE_ENABLE_PRE_SOLVE_EVENTS;
    private static final LazyConstant<MethodHandle> B2_SHAPE_ARE_PRE_SOLVE_EVENTS_ENABLED;
    private static final LazyConstant<MethodHandle> B2_SHAPE_ENABLE_HIT_EVENTS;
    private static final LazyConstant<MethodHandle> B2_SHAPE_ARE_HIT_EVENTS_ENABLED;
    private static final LazyConstant<MethodHandle> B2_SHAPE_TEST_POINT;
    private static final LazyConstant<MethodHandle> B2_SHAPE_RAY_CAST;
    private static final LazyConstant<MethodHandle> B2_SHAPE_GET_CIRCLE;
    private static final LazyConstant<MethodHandle> B2_SHAPE_GET_SEGMENT;
    private static final LazyConstant<MethodHandle> B2_SHAPE_GET_CHAIN_SEGMENT;
    private static final LazyConstant<MethodHandle> B2_SHAPE_GET_CAPSULE;
    private static final LazyConstant<MethodHandle> B2_SHAPE_GET_POLYGON;
    private static final LazyConstant<MethodHandle> B2_SHAPE_SET_CIRCLE;
    private static final LazyConstant<MethodHandle> B2_SHAPE_SET_CAPSULE;
    private static final LazyConstant<MethodHandle> B2_SHAPE_SET_SEGMENT;
    private static final LazyConstant<MethodHandle> B2_SHAPE_SET_POLYGON;
    private static final LazyConstant<MethodHandle> B2_SHAPE_GET_PARENT_CHAIN;
    private static final LazyConstant<MethodHandle> B2_SHAPE_GET_CONTACT_CAPACITY;
    private static final LazyConstant<MethodHandle> B2_SHAPE_GET_CONTACT_DATA;
    private static final LazyConstant<MethodHandle> B2_SHAPE_GET_SENSOR_CAPACITY;
    private static final LazyConstant<MethodHandle> B2_SHAPE_GET_SENSOR_OVERLAPS;
    private static final LazyConstant<MethodHandle> B2_SHAPE_GET_AABB;
    private static final LazyConstant<MethodHandle> B2_SHAPE_GET_MASS_DATA;
    private static final LazyConstant<MethodHandle> B2_SHAPE_GET_CLOSEST_POINT;

    static {
        //@formatter:off
        B2_CREATE_CIRCLE_SHAPE = downcallHandle("b2CreateCircleShape", ShapeId.LAYOUT, BodyId.LAYOUT, UNBOUNDED_ADDRESS, UNBOUNDED_ADDRESS);
        B2_CREATE_SEGMENT_SHAPE = downcallHandle("b2CreateSegmentShape", ShapeId.LAYOUT, BodyId.LAYOUT, UNBOUNDED_ADDRESS, UNBOUNDED_ADDRESS);
        B2_CREATE_CAPSULE_SHAPE = downcallHandle("b2CreateCapsuleShape", ShapeId.LAYOUT, BodyId.LAYOUT, UNBOUNDED_ADDRESS, UNBOUNDED_ADDRESS);
        B2_CREATE_POLYGON_SHAPE = downcallHandle("b2CreatePolygonShape", ShapeId.LAYOUT, BodyId.LAYOUT, UNBOUNDED_ADDRESS, UNBOUNDED_ADDRESS);
        B2_DESTROY_SHAPE = downcallHandleVoid("b2DestroyShape", ShapeId.LAYOUT, JAVA_BOOLEAN);
        B2_SHAPE_IS_VALID = downcallHandle("b2Shape_IsValid", JAVA_BOOLEAN, ShapeId.LAYOUT);
        B2_SHAPE_GET_TYPE = downcallHandle("b2Shape_GetType", JAVA_INT, ShapeId.LAYOUT);
        B2_SHAPE_GET_BODY = downcallHandle("b2Shape_GetBody", BodyId.LAYOUT, ShapeId.LAYOUT);
        B2_SHAPE_GET_WORLD = downcallHandle("b2Shape_GetWorld", WorldId.LAYOUT, ShapeId.LAYOUT);
        B2_SHAPE_IS_SENSOR = downcallHandle("b2Shape_IsSensor", JAVA_BOOLEAN, ShapeId.LAYOUT);
        B2_SHAPE_SET_USER_DATA = downcallHandleVoid("b2Shape_SetUserData", ShapeId.LAYOUT, UNBOUNDED_ADDRESS);
        B2_SHAPE_GET_USER_DATA = downcallHandle("b2Shape_GetUserData", UNBOUNDED_ADDRESS, ShapeId.LAYOUT);
        B2_SHAPE_SET_DENSITY = downcallHandleVoid("b2Shape_SetDensity", ShapeId.LAYOUT, JAVA_FLOAT, JAVA_BOOLEAN);
        B2_SHAPE_GET_DENSITY = downcallHandle("b2Shape_GetDensity", JAVA_FLOAT, ShapeId.LAYOUT);
        B2_SHAPE_SET_FRICTION = downcallHandleVoid("b2Shape_SetFriction", ShapeId.LAYOUT, JAVA_FLOAT);
        B2_SHAPE_GET_FRICTION = downcallHandle("b2Shape_GetFriction", JAVA_FLOAT, ShapeId.LAYOUT);
        B2_SHAPE_SET_RESTITUTION = downcallHandleVoid("b2Shape_SetRestitution", ShapeId.LAYOUT, JAVA_FLOAT);
        B2_SHAPE_GET_RESTITUTION = downcallHandle("b2Shape_GetRestitution", JAVA_FLOAT, ShapeId.LAYOUT);
        B2_SHAPE_SET_MATERIAL = downcallHandleVoid("b2Shape_SetMaterial", ShapeId.LAYOUT, JAVA_INT);
        B2_SHAPE_GET_MATERIAL = downcallHandle("b2Shape_GetMaterial", JAVA_INT, ShapeId.LAYOUT);
        B2_SHAPE_SET_SURFACE_MATERIAL = downcallHandleVoid("b2Shape_SetSurfaceMaterial", ShapeId.LAYOUT, SurfaceMaterial.LAYOUT);
        B2_SHAPE_GET_SURFACE_MATERIAL = downcallHandle("b2Shape_GetSurfaceMaterial", SurfaceMaterial.LAYOUT, ShapeId.LAYOUT);
        B2_SHAPE_GET_FILTER = downcallHandle("b2Shape_GetFilter", Filter.LAYOUT, ShapeId.LAYOUT);
        B2_SHAPE_SET_FILTER = downcallHandleVoid("b2Shape_SetFilter", ShapeId.LAYOUT, Filter.LAYOUT);
        B2_SHAPE_ENABLE_SENSOR_EVENTS = downcallHandleVoid("b2Shape_EnableSensorEvents", ShapeId.LAYOUT, JAVA_BOOLEAN);
        B2_SHAPE_ARE_SENSOR_EVENTS_ENABLED = downcallHandle("b2Shape_AreSensorEventsEnabled", JAVA_BOOLEAN, ShapeId.LAYOUT);
        B2_SHAPE_ENABLE_CONTACT_EVENTS = downcallHandleVoid("b2Shape_EnableContactEvents", ShapeId.LAYOUT, JAVA_BOOLEAN);
        B2_SHAPE_ARE_CONTACT_EVENTS_ENABLED = downcallHandle("b2Shape_AreContactEventsEnabled", JAVA_BOOLEAN, ShapeId.LAYOUT);
        B2_SHAPE_ENABLE_PRE_SOLVE_EVENTS = downcallHandleVoid("b2Shape_EnablePreSolveEvents", ShapeId.LAYOUT, JAVA_BOOLEAN);
        B2_SHAPE_ARE_PRE_SOLVE_EVENTS_ENABLED = downcallHandle("b2Shape_ArePreSolveEventsEnabled", JAVA_BOOLEAN, ShapeId.LAYOUT);
        B2_SHAPE_ENABLE_HIT_EVENTS = downcallHandleVoid("b2Shape_EnableHitEvents", ShapeId.LAYOUT, JAVA_BOOLEAN);
        B2_SHAPE_ARE_HIT_EVENTS_ENABLED = downcallHandle("b2Shape_AreHitEventsEnabled", JAVA_BOOLEAN, ShapeId.LAYOUT);
        B2_SHAPE_TEST_POINT = downcallHandle("b2Shape_TestPoint", JAVA_BOOLEAN, ShapeId.LAYOUT, Vec2.LAYOUT);
        B2_SHAPE_RAY_CAST = downcallHandle("b2Shape_RayCast", CastOutput.LAYOUT, ShapeId.LAYOUT, UNBOUNDED_ADDRESS);
        B2_SHAPE_GET_CIRCLE = downcallHandle("b2Shape_GetCircle", Circle.LAYOUT, ShapeId.LAYOUT);
        B2_SHAPE_GET_SEGMENT = downcallHandle("b2Shape_GetSegment", Segment.LAYOUT, ShapeId.LAYOUT);
        B2_SHAPE_GET_CHAIN_SEGMENT = downcallHandle("b2Shape_GetChainSegment", ChainSegment.LAYOUT, ShapeId.LAYOUT);
        B2_SHAPE_GET_CAPSULE = downcallHandle("b2Shape_GetCapsule", Capsule.LAYOUT, ShapeId.LAYOUT);
        B2_SHAPE_GET_POLYGON = downcallHandle("b2Shape_GetPolygon", Polygon.LAYOUT, ShapeId.LAYOUT);
        B2_SHAPE_SET_CIRCLE = downcallHandleVoid("b2Shape_SetCircle", ShapeId.LAYOUT, UNBOUNDED_ADDRESS);
        B2_SHAPE_SET_CAPSULE = downcallHandleVoid("b2Shape_SetCapsule", ShapeId.LAYOUT, UNBOUNDED_ADDRESS);
        B2_SHAPE_SET_SEGMENT = downcallHandleVoid("b2Shape_SetSegment", ShapeId.LAYOUT, UNBOUNDED_ADDRESS);
        B2_SHAPE_SET_POLYGON = downcallHandleVoid("b2Shape_SetPolygon", ShapeId.LAYOUT, UNBOUNDED_ADDRESS);
        B2_SHAPE_GET_PARENT_CHAIN = downcallHandle("b2Shape_GetParentChain", ChainId.LAYOUT, ShapeId.LAYOUT);
        B2_SHAPE_GET_CONTACT_CAPACITY = downcallHandle("b2Shape_GetContactCapacity", JAVA_INT, ShapeId.LAYOUT);
        B2_SHAPE_GET_CONTACT_DATA = downcallHandle("b2Shape_GetContactData", JAVA_INT, ShapeId.LAYOUT, UNBOUNDED_ADDRESS, JAVA_INT);
        B2_SHAPE_GET_SENSOR_CAPACITY = downcallHandle("b2Shape_GetSensorCapacity", JAVA_INT, ShapeId.LAYOUT);
        B2_SHAPE_GET_SENSOR_OVERLAPS = downcallHandle("b2Shape_GetSensorOverlaps", JAVA_INT, ShapeId.LAYOUT, UNBOUNDED_ADDRESS, JAVA_INT);
        B2_SHAPE_GET_AABB = downcallHandle("b2Shape_GetAABB", AABB.LAYOUT, ShapeId.LAYOUT);
        B2_SHAPE_GET_MASS_DATA = downcallHandle("b2Shape_GetMassData", MassData.LAYOUT, ShapeId.LAYOUT);
        B2_SHAPE_GET_CLOSEST_POINT = downcallHandle("b2Shape_GetClosestPoint", Vec2.LAYOUT, ShapeId.LAYOUT, Vec2.LAYOUT);
        //@formatter:on
    }

    private Shape() {
    }

    /**
     * Create a circle shape and attach it to a body. The shape definition and geometry are fully cloned. Contacts are not created until the next time step.
     */
    public static MemorySegment createCircleShape(
        SegmentAllocator allocator,
        MemorySegment bodyId, 
        MemorySegment def, 
        MemorySegment circle
    ) {
        MethodHandle method = B2_CREATE_CIRCLE_SHAPE.get();
        try {
            return (MemorySegment) method.invokeExact(
                allocator,
                bodyId, 
                def, 
                circle
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #createCircleShape}.
     */
    public static @Nullable ShapeId createCircleShape(
        SegmentAllocator allocator,
        BodyId bodyId, 
        ShapeDef def, 
        Circle circle
    ) {
        MemorySegment segment = createCircleShape(
            allocator,
            bodyId.memorySegment(), 
            def.memorySegment(), 
            circle.memorySegment()
        );
    
        if (segment.equals(MemorySegment.NULL))
            return null;
    
        return new ShapeId(segment);
    }
    
    /**
     * Create a line segment shape and attach it to a body. The shape definition and geometry are fully cloned. Contacts are not created until the next time step.
     */
    public static MemorySegment createSegmentShape(
        SegmentAllocator allocator,
        MemorySegment bodyId, 
        MemorySegment def, 
        MemorySegment paramSegment
    ) {
        MethodHandle method = B2_CREATE_SEGMENT_SHAPE.get();
        try {
            return (MemorySegment) method.invokeExact(
                allocator,
                bodyId, 
                def, 
                paramSegment
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #createSegmentShape}.
     */
    public static @Nullable ShapeId createSegmentShape(
        SegmentAllocator allocator,
        BodyId bodyId, 
        ShapeDef def, 
        Segment paramSegment
    ) {
        MemorySegment segment = createSegmentShape(
            allocator,
            bodyId.memorySegment(), 
            def.memorySegment(), 
            paramSegment.memorySegment()
        );
    
        if (segment.equals(MemorySegment.NULL))
            return null;
    
        return new ShapeId(segment);
    }
    
    /**
     * Create a capsule shape and attach it to a body. The shape definition and geometry are fully cloned. Contacts are not created until the next time step.
     */
    public static MemorySegment createCapsuleShape(
        SegmentAllocator allocator,
        MemorySegment bodyId, 
        MemorySegment def, 
        MemorySegment capsule
    ) {
        MethodHandle method = B2_CREATE_CAPSULE_SHAPE.get();
        try {
            return (MemorySegment) method.invokeExact(
                allocator,
                bodyId, 
                def, 
                capsule
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #createCapsuleShape}.
     */
    public static @Nullable ShapeId createCapsuleShape(
        SegmentAllocator allocator,
        BodyId bodyId, 
        ShapeDef def, 
        Capsule capsule
    ) {
        MemorySegment segment = createCapsuleShape(
            allocator,
            bodyId.memorySegment(), 
            def.memorySegment(), 
            capsule.memorySegment()
        );
    
        if (segment.equals(MemorySegment.NULL))
            return null;
    
        return new ShapeId(segment);
    }
    
    /**
     * Create a polygon shape and attach it to a body. The shape definition and geometry are fully cloned. Contacts are not created until the next time step.
     */
    public static MemorySegment createPolygonShape(
        SegmentAllocator allocator,
        MemorySegment bodyId, 
        MemorySegment def, 
        MemorySegment polygon
    ) {
        MethodHandle method = B2_CREATE_POLYGON_SHAPE.get();
        try {
            return (MemorySegment) method.invokeExact(
                allocator,
                bodyId, 
                def, 
                polygon
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #createPolygonShape}.
     */
    public static @Nullable ShapeId createPolygonShape(
        SegmentAllocator allocator,
        BodyId bodyId, 
        ShapeDef def, 
        Polygon polygon
    ) {
        MemorySegment segment = createPolygonShape(
            allocator,
            bodyId.memorySegment(), 
            def.memorySegment(), 
            polygon.memorySegment()
        );
    
        if (segment.equals(MemorySegment.NULL))
            return null;
    
        return new ShapeId(segment);
    }
    
    /**
     * Destroy a shape. You may defer the body mass update which can improve performance if several shapes on a body are destroyed at once.
     */
    public static void destroyShape(
        MemorySegment shapeId, 
        boolean updateBodyMass
    ) {
        MethodHandle method = B2_DESTROY_SHAPE.get();
        try {
            method.invokeExact(
                shapeId, 
                updateBodyMass
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #destroyShape}.
     */
    public static void destroyShape(
        ShapeId shapeId, 
        boolean updateBodyMass
    ) {
        destroyShape(
            shapeId.memorySegment(), 
            updateBodyMass
        );
    }
    
    /**
     * Shape identifier validation. Provides validation for up to 64K allocations.
     */
    public static boolean isValid(
        MemorySegment id
    ) {
        MethodHandle method = B2_SHAPE_IS_VALID.get();
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
        ShapeId id
    ) {
        return (boolean) isValid(
            id.memorySegment()
        );
    }
    
    /**
     * Get the type of a shape
     */
    public static int getType(
        MemorySegment shapeId
    ) {
        MethodHandle method = B2_SHAPE_GET_TYPE.get();
        try {
            return (int) method.invokeExact(
                shapeId
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #getType}.
     */
    public static int getType(
        ShapeId shapeId
    ) {
        return (int) getType(
            shapeId.memorySegment()
        );
    }
    
    /**
     * Get the id of the body that a shape is attached to
     */
    public static MemorySegment getBody(
        SegmentAllocator allocator,
        MemorySegment shapeId
    ) {
        MethodHandle method = B2_SHAPE_GET_BODY.get();
        try {
            return (MemorySegment) method.invokeExact(
                allocator,
                shapeId
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #getBody}.
     */
    public static @Nullable BodyId getBody(
        SegmentAllocator allocator,
        ShapeId shapeId
    ) {
        MemorySegment segment = getBody(
            allocator,
            shapeId.memorySegment()
        );
    
        if (segment.equals(MemorySegment.NULL))
            return null;
    
        return new BodyId(segment);
    }
    
    /**
     * Get the world that owns this shape
     */
    public static MemorySegment getWorld(
        SegmentAllocator allocator,
        MemorySegment shapeId
    ) {
        MethodHandle method = B2_SHAPE_GET_WORLD.get();
        try {
            return (MemorySegment) method.invokeExact(
                allocator,
                shapeId
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #getWorld}.
     */
    public static @Nullable WorldId getWorld(
        SegmentAllocator allocator,
        ShapeId shapeId
    ) {
        MemorySegment segment = getWorld(
            allocator,
            shapeId.memorySegment()
        );
    
        if (segment.equals(MemorySegment.NULL))
            return null;
    
        return new WorldId(segment);
    }
    
    /**
     * Returns true if the shape is a sensor. It is not possible to change a shape from sensor to solid dynamically because this breaks the contract for sensor events.
     */
    public static boolean isSensor(
        MemorySegment shapeId
    ) {
        MethodHandle method = B2_SHAPE_IS_SENSOR.get();
        try {
            return (boolean) method.invokeExact(
                shapeId
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #isSensor}.
     */
    public static boolean isSensor(
        ShapeId shapeId
    ) {
        return (boolean) isSensor(
            shapeId.memorySegment()
        );
    }
    
    /**
     * Set the user data for a shape
     */
    public static void setUserData(
        MemorySegment shapeId, 
        MemorySegment userData
    ) {
        MethodHandle method = B2_SHAPE_SET_USER_DATA.get();
        try {
            method.invokeExact(
                shapeId, 
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
        ShapeId shapeId, 
        MemorySegment userData
    ) {
        setUserData(
            shapeId.memorySegment(), 
            userData
        );
    }
    
    /**
     * Get the user data for a shape. This is useful when you get a shape id from an event or query.
     */
    public static MemorySegment getUserData(
        MemorySegment shapeId
    ) {
        MethodHandle method = B2_SHAPE_GET_USER_DATA.get();
        try {
            return (MemorySegment) method.invokeExact(
                shapeId
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #getUserData}.
     */
    public static @Nullable MemorySegment getUserData(
        ShapeId shapeId
    ) {
        MemorySegment segment = getUserData(
            shapeId.memorySegment()
        );
    
        if (segment.equals(MemorySegment.NULL))
            return null;
    
        return segment;
    }
    
    /**
     * Set the mass density of a shape, usually in kg/m^2. This will optionally update the mass properties on the parent body.
     */
    public static void setDensity(
        MemorySegment shapeId, 
        float density, 
        boolean updateBodyMass
    ) {
        MethodHandle method = B2_SHAPE_SET_DENSITY.get();
        try {
            method.invokeExact(
                shapeId, 
                density, 
                updateBodyMass
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #setDensity}.
     */
    public static void setDensity(
        ShapeId shapeId, 
        float density, 
        boolean updateBodyMass
    ) {
        setDensity(
            shapeId.memorySegment(), 
            density, 
            updateBodyMass
        );
    }
    
    /**
     * Get the density of a shape, usually in kg/m^2
     */
    public static float getDensity(
        MemorySegment shapeId
    ) {
        MethodHandle method = B2_SHAPE_GET_DENSITY.get();
        try {
            return (float) method.invokeExact(
                shapeId
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #getDensity}.
     */
    public static float getDensity(
        ShapeId shapeId
    ) {
        return (float) getDensity(
            shapeId.memorySegment()
        );
    }
    
    /**
     * Set the friction on a shape
     */
    public static void setFriction(
        MemorySegment shapeId, 
        float friction
    ) {
        MethodHandle method = B2_SHAPE_SET_FRICTION.get();
        try {
            method.invokeExact(
                shapeId, 
                friction
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #setFriction}.
     */
    public static void setFriction(
        ShapeId shapeId, 
        float friction
    ) {
        setFriction(
            shapeId.memorySegment(), 
            friction
        );
    }
    
    /**
     * Get the friction of a shape
     */
    public static float getFriction(
        MemorySegment shapeId
    ) {
        MethodHandle method = B2_SHAPE_GET_FRICTION.get();
        try {
            return (float) method.invokeExact(
                shapeId
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #getFriction}.
     */
    public static float getFriction(
        ShapeId shapeId
    ) {
        return (float) getFriction(
            shapeId.memorySegment()
        );
    }
    
    /**
     * Set the shape restitution (bounciness)
     */
    public static void setRestitution(
        MemorySegment shapeId, 
        float restitution
    ) {
        MethodHandle method = B2_SHAPE_SET_RESTITUTION.get();
        try {
            method.invokeExact(
                shapeId, 
                restitution
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #setRestitution}.
     */
    public static void setRestitution(
        ShapeId shapeId, 
        float restitution
    ) {
        setRestitution(
            shapeId.memorySegment(), 
            restitution
        );
    }
    
    /**
     * Get the shape restitution
     */
    public static float getRestitution(
        MemorySegment shapeId
    ) {
        MethodHandle method = B2_SHAPE_GET_RESTITUTION.get();
        try {
            return (float) method.invokeExact(
                shapeId
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #getRestitution}.
     */
    public static float getRestitution(
        ShapeId shapeId
    ) {
        return (float) getRestitution(
            shapeId.memorySegment()
        );
    }
    
    /**
     * Set the shape material identifier
     */
    public static void setMaterial(
        MemorySegment shapeId, 
        int material
    ) {
        MethodHandle method = B2_SHAPE_SET_MATERIAL.get();
        try {
            method.invokeExact(
                shapeId, 
                material
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #setMaterial}.
     */
    public static void setMaterial(
        ShapeId shapeId, 
        int material
    ) {
        setMaterial(
            shapeId.memorySegment(), 
            material
        );
    }
    
    /**
     * Get the shape material identifier
     */
    public static int getMaterial(
        MemorySegment shapeId
    ) {
        MethodHandle method = B2_SHAPE_GET_MATERIAL.get();
        try {
            return (int) method.invokeExact(
                shapeId
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #getMaterial}.
     */
    public static int getMaterial(
        ShapeId shapeId
    ) {
        return (int) getMaterial(
            shapeId.memorySegment()
        );
    }
    
    /**
     * Set the shape surface material
     */
    public static void setSurfaceMaterial(
        MemorySegment shapeId, 
        MemorySegment surfaceMaterial
    ) {
        MethodHandle method = B2_SHAPE_SET_SURFACE_MATERIAL.get();
        try {
            method.invokeExact(
                shapeId, 
                surfaceMaterial
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #setSurfaceMaterial}.
     */
    public static void setSurfaceMaterial(
        ShapeId shapeId, 
        SurfaceMaterial surfaceMaterial
    ) {
        setSurfaceMaterial(
            shapeId.memorySegment(), 
            surfaceMaterial.memorySegment()
        );
    }
    
    /**
     * Get the shape surface material
     */
    public static MemorySegment getSurfaceMaterial(
        SegmentAllocator allocator,
        MemorySegment shapeId
    ) {
        MethodHandle method = B2_SHAPE_GET_SURFACE_MATERIAL.get();
        try {
            return (MemorySegment) method.invokeExact(
                allocator,
                shapeId
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #getSurfaceMaterial}.
     */
    public static @Nullable SurfaceMaterial getSurfaceMaterial(
        SegmentAllocator allocator,
        ShapeId shapeId
    ) {
        MemorySegment segment = getSurfaceMaterial(
            allocator,
            shapeId.memorySegment()
        );
    
        if (segment.equals(MemorySegment.NULL))
            return null;
    
        return new SurfaceMaterial(segment);
    }
    
    /**
     * Get the shape filter
     */
    public static MemorySegment getFilter(
        SegmentAllocator allocator,
        MemorySegment shapeId
    ) {
        MethodHandle method = B2_SHAPE_GET_FILTER.get();
        try {
            return (MemorySegment) method.invokeExact(
                allocator,
                shapeId
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #getFilter}.
     */
    public static @Nullable Filter getFilter(
        SegmentAllocator allocator,
        ShapeId shapeId
    ) {
        MemorySegment segment = getFilter(
            allocator,
            shapeId.memorySegment()
        );
    
        if (segment.equals(MemorySegment.NULL))
            return null;
    
        return new Filter(segment);
    }
    
    /**
     * Set the current filter. This is almost as expensive as recreating the shape. This may cause contacts to be immediately destroyed. However contacts are not created until the next world step. Sensor overlap state is also not updated until the next world step.
     */
    public static void setFilter(
        MemorySegment shapeId, 
        MemorySegment filter
    ) {
        MethodHandle method = B2_SHAPE_SET_FILTER.get();
        try {
            method.invokeExact(
                shapeId, 
                filter
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #setFilter}.
     */
    public static void setFilter(
        ShapeId shapeId, 
        Filter filter
    ) {
        setFilter(
            shapeId.memorySegment(), 
            filter.memorySegment()
        );
    }
    
    /**
     * Enable sensor events for this shape.
     */
    public static void enableSensorEvents(
        MemorySegment shapeId, 
        boolean flag
    ) {
        MethodHandle method = B2_SHAPE_ENABLE_SENSOR_EVENTS.get();
        try {
            method.invokeExact(
                shapeId, 
                flag
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #enableSensorEvents}.
     */
    public static void enableSensorEvents(
        ShapeId shapeId, 
        boolean flag
    ) {
        enableSensorEvents(
            shapeId.memorySegment(), 
            flag
        );
    }
    
    /**
     * Returns true if sensor events are enabled.
     */
    public static boolean areSensorEventsEnabled(
        MemorySegment shapeId
    ) {
        MethodHandle method = B2_SHAPE_ARE_SENSOR_EVENTS_ENABLED.get();
        try {
            return (boolean) method.invokeExact(
                shapeId
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #areSensorEventsEnabled}.
     */
    public static boolean areSensorEventsEnabled(
        ShapeId shapeId
    ) {
        return (boolean) areSensorEventsEnabled(
            shapeId.memorySegment()
        );
    }
    
    /**
     * Enable contact events for this shape. Only applies to kinematic and dynamic bodies. Ignored for sensors.
     */
    public static void enableContactEvents(
        MemorySegment shapeId, 
        boolean flag
    ) {
        MethodHandle method = B2_SHAPE_ENABLE_CONTACT_EVENTS.get();
        try {
            method.invokeExact(
                shapeId, 
                flag
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #enableContactEvents}.
     */
    public static void enableContactEvents(
        ShapeId shapeId, 
        boolean flag
    ) {
        enableContactEvents(
            shapeId.memorySegment(), 
            flag
        );
    }
    
    /**
     * Returns true if contact events are enabled
     */
    public static boolean areContactEventsEnabled(
        MemorySegment shapeId
    ) {
        MethodHandle method = B2_SHAPE_ARE_CONTACT_EVENTS_ENABLED.get();
        try {
            return (boolean) method.invokeExact(
                shapeId
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #areContactEventsEnabled}.
     */
    public static boolean areContactEventsEnabled(
        ShapeId shapeId
    ) {
        return (boolean) areContactEventsEnabled(
            shapeId.memorySegment()
        );
    }
    
    /**
     * Enable pre-solve contact events for this shape. Only applies to dynamic bodies. These are expensive and must be carefully handled due to multithreading. Ignored for sensors.
     */
    public static void enablePreSolveEvents(
        MemorySegment shapeId, 
        boolean flag
    ) {
        MethodHandle method = B2_SHAPE_ENABLE_PRE_SOLVE_EVENTS.get();
        try {
            method.invokeExact(
                shapeId, 
                flag
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #enablePreSolveEvents}.
     */
    public static void enablePreSolveEvents(
        ShapeId shapeId, 
        boolean flag
    ) {
        enablePreSolveEvents(
            shapeId.memorySegment(), 
            flag
        );
    }
    
    /**
     * Returns true if pre-solve events are enabled
     */
    public static boolean arePreSolveEventsEnabled(
        MemorySegment shapeId
    ) {
        MethodHandle method = B2_SHAPE_ARE_PRE_SOLVE_EVENTS_ENABLED.get();
        try {
            return (boolean) method.invokeExact(
                shapeId
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #arePreSolveEventsEnabled}.
     */
    public static boolean arePreSolveEventsEnabled(
        ShapeId shapeId
    ) {
        return (boolean) arePreSolveEventsEnabled(
            shapeId.memorySegment()
        );
    }
    
    /**
     * Enable contact hit events for this shape. Ignored for sensors.
     */
    public static void enableHitEvents(
        MemorySegment shapeId, 
        boolean flag
    ) {
        MethodHandle method = B2_SHAPE_ENABLE_HIT_EVENTS.get();
        try {
            method.invokeExact(
                shapeId, 
                flag
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #enableHitEvents}.
     */
    public static void enableHitEvents(
        ShapeId shapeId, 
        boolean flag
    ) {
        enableHitEvents(
            shapeId.memorySegment(), 
            flag
        );
    }
    
    /**
     * Returns true if hit events are enabled
     */
    public static boolean areHitEventsEnabled(
        MemorySegment shapeId
    ) {
        MethodHandle method = B2_SHAPE_ARE_HIT_EVENTS_ENABLED.get();
        try {
            return (boolean) method.invokeExact(
                shapeId
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #areHitEventsEnabled}.
     */
    public static boolean areHitEventsEnabled(
        ShapeId shapeId
    ) {
        return (boolean) areHitEventsEnabled(
            shapeId.memorySegment()
        );
    }
    
    /**
     * Test a point for overlap with a shape
     */
    public static boolean testPoint(
        MemorySegment shapeId, 
        MemorySegment point
    ) {
        MethodHandle method = B2_SHAPE_TEST_POINT.get();
        try {
            return (boolean) method.invokeExact(
                shapeId, 
                point
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #testPoint}.
     */
    public static boolean testPoint(
        ShapeId shapeId, 
        Vec2 point
    ) {
        return (boolean) testPoint(
            shapeId.memorySegment(), 
            point.memorySegment()
        );
    }
    
    /**
     * Ray cast a shape directly
     */
    public static MemorySegment rayCast(
        SegmentAllocator allocator,
        MemorySegment shapeId, 
        MemorySegment input
    ) {
        MethodHandle method = B2_SHAPE_RAY_CAST.get();
        try {
            return (MemorySegment) method.invokeExact(
                allocator,
                shapeId, 
                input
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #rayCast}.
     */
    public static @Nullable CastOutput rayCast(
        SegmentAllocator allocator,
        ShapeId shapeId, 
        RayCastInput input
    ) {
        MemorySegment segment = rayCast(
            allocator,
            shapeId.memorySegment(), 
            input.memorySegment()
        );
    
        if (segment.equals(MemorySegment.NULL))
            return null;
    
        return new CastOutput(segment);
    }
    
    /**
     * Get a copy of the shape's circle. Asserts the type is correct.
     */
    public static MemorySegment getCircle(
        SegmentAllocator allocator,
        MemorySegment shapeId
    ) {
        MethodHandle method = B2_SHAPE_GET_CIRCLE.get();
        try {
            return (MemorySegment) method.invokeExact(
                allocator,
                shapeId
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #getCircle}.
     */
    public static @Nullable Circle getCircle(
        SegmentAllocator allocator,
        ShapeId shapeId
    ) {
        MemorySegment segment = getCircle(
            allocator,
            shapeId.memorySegment()
        );
    
        if (segment.equals(MemorySegment.NULL))
            return null;
    
        return new Circle(segment);
    }
    
    /**
     * Get a copy of the shape's line segment. Asserts the type is correct.
     */
    public static MemorySegment getSegment(
        SegmentAllocator allocator,
        MemorySegment shapeId
    ) {
        MethodHandle method = B2_SHAPE_GET_SEGMENT.get();
        try {
            return (MemorySegment) method.invokeExact(
                allocator,
                shapeId
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #getSegment}.
     */
    public static @Nullable Segment getSegment(
        SegmentAllocator allocator,
        ShapeId shapeId
    ) {
        MemorySegment segment = getSegment(
            allocator,
            shapeId.memorySegment()
        );
    
        if (segment.equals(MemorySegment.NULL))
            return null;
    
        return new Segment(segment);
    }
    
    /**
     * Get a copy of the shape's chain segment. These come from chain shapes. Asserts the type is correct.
     */
    public static MemorySegment getChainSegment(
        SegmentAllocator allocator,
        MemorySegment shapeId
    ) {
        MethodHandle method = B2_SHAPE_GET_CHAIN_SEGMENT.get();
        try {
            return (MemorySegment) method.invokeExact(
                allocator,
                shapeId
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #getChainSegment}.
     */
    public static @Nullable ChainSegment getChainSegment(
        SegmentAllocator allocator,
        ShapeId shapeId
    ) {
        MemorySegment segment = getChainSegment(
            allocator,
            shapeId.memorySegment()
        );
    
        if (segment.equals(MemorySegment.NULL))
            return null;
    
        return new ChainSegment(segment);
    }
    
    /**
     * Get a copy of the shape's capsule. Asserts the type is correct.
     */
    public static MemorySegment getCapsule(
        SegmentAllocator allocator,
        MemorySegment shapeId
    ) {
        MethodHandle method = B2_SHAPE_GET_CAPSULE.get();
        try {
            return (MemorySegment) method.invokeExact(
                allocator,
                shapeId
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #getCapsule}.
     */
    public static @Nullable Capsule getCapsule(
        SegmentAllocator allocator,
        ShapeId shapeId
    ) {
        MemorySegment segment = getCapsule(
            allocator,
            shapeId.memorySegment()
        );
    
        if (segment.equals(MemorySegment.NULL))
            return null;
    
        return new Capsule(segment);
    }
    
    /**
     * Get a copy of the shape's convex polygon. Asserts the type is correct.
     */
    public static MemorySegment getPolygon(
        SegmentAllocator allocator,
        MemorySegment shapeId
    ) {
        MethodHandle method = B2_SHAPE_GET_POLYGON.get();
        try {
            return (MemorySegment) method.invokeExact(
                allocator,
                shapeId
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #getPolygon}.
     */
    public static @Nullable Polygon getPolygon(
        SegmentAllocator allocator,
        ShapeId shapeId
    ) {
        MemorySegment segment = getPolygon(
            allocator,
            shapeId.memorySegment()
        );
    
        if (segment.equals(MemorySegment.NULL))
            return null;
    
        return new Polygon(segment);
    }
    
    /**
     * Allows you to change a shape to be a circle or update the current circle. This does not modify the mass properties.
     */
    public static void setCircle(
        MemorySegment shapeId, 
        MemorySegment circle
    ) {
        MethodHandle method = B2_SHAPE_SET_CIRCLE.get();
        try {
            method.invokeExact(
                shapeId, 
                circle
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #setCircle}.
     */
    public static void setCircle(
        ShapeId shapeId, 
        Circle circle
    ) {
        setCircle(
            shapeId.memorySegment(), 
            circle.memorySegment()
        );
    }
    
    /**
     * Allows you to change a shape to be a capsule or update the current capsule. This does not modify the mass properties.
     */
    public static void setCapsule(
        MemorySegment shapeId, 
        MemorySegment capsule
    ) {
        MethodHandle method = B2_SHAPE_SET_CAPSULE.get();
        try {
            method.invokeExact(
                shapeId, 
                capsule
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #setCapsule}.
     */
    public static void setCapsule(
        ShapeId shapeId, 
        Capsule capsule
    ) {
        setCapsule(
            shapeId.memorySegment(), 
            capsule.memorySegment()
        );
    }
    
    /**
     * Allows you to change a shape to be a segment or update the current segment.
     */
    public static void setSegment(
        MemorySegment shapeId, 
        MemorySegment paramSegment
    ) {
        MethodHandle method = B2_SHAPE_SET_SEGMENT.get();
        try {
            method.invokeExact(
                shapeId, 
                paramSegment
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #setSegment}.
     */
    public static void setSegment(
        ShapeId shapeId, 
        Segment paramSegment
    ) {
        setSegment(
            shapeId.memorySegment(), 
            paramSegment.memorySegment()
        );
    }
    
    /**
     * Allows you to change a shape to be a polygon or update the current polygon. This does not modify the mass properties.
     */
    public static void setPolygon(
        MemorySegment shapeId, 
        MemorySegment polygon
    ) {
        MethodHandle method = B2_SHAPE_SET_POLYGON.get();
        try {
            method.invokeExact(
                shapeId, 
                polygon
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #setPolygon}.
     */
    public static void setPolygon(
        ShapeId shapeId, 
        Polygon polygon
    ) {
        setPolygon(
            shapeId.memorySegment(), 
            polygon.memorySegment()
        );
    }
    
    /**
     * Get the parent chain id if the shape type is a chain segment, otherwise returns b2_nullChainId.
     */
    public static MemorySegment getParentChain(
        SegmentAllocator allocator,
        MemorySegment shapeId
    ) {
        MethodHandle method = B2_SHAPE_GET_PARENT_CHAIN.get();
        try {
            return (MemorySegment) method.invokeExact(
                allocator,
                shapeId
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #getParentChain}.
     */
    public static @Nullable ChainId getParentChain(
        SegmentAllocator allocator,
        ShapeId shapeId
    ) {
        MemorySegment segment = getParentChain(
            allocator,
            shapeId.memorySegment()
        );
    
        if (segment.equals(MemorySegment.NULL))
            return null;
    
        return new ChainId(segment);
    }
    
    /**
     * Get the maximum capacity required for retrieving all the touching contacts on a shape
     */
    public static int getContactCapacity(
        MemorySegment shapeId
    ) {
        MethodHandle method = B2_SHAPE_GET_CONTACT_CAPACITY.get();
        try {
            return (int) method.invokeExact(
                shapeId
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #getContactCapacity}.
     */
    public static int getContactCapacity(
        ShapeId shapeId
    ) {
        return (int) getContactCapacity(
            shapeId.memorySegment()
        );
    }
    
    /**
     * Get the touching contact data for a shape. The provided shapeId will be either shapeIdA or shapeIdB on the contact data.
     */
    public static int getContactData(
        MemorySegment shapeId, 
        MemorySegment contactData, 
        int capacity
    ) {
        MethodHandle method = B2_SHAPE_GET_CONTACT_DATA.get();
        try {
            return (int) method.invokeExact(
                shapeId, 
                contactData, 
                capacity
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #getContactData}.
     */
    public static int getContactData(
        ShapeId shapeId, 
        ContactData contactData, 
        int capacity
    ) {
        return (int) getContactData(
            shapeId.memorySegment(), 
            contactData.memorySegment(), 
            capacity
        );
    }
    
    /**
     * Get the maximum capacity required for retrieving all the overlapped shapes on a sensor shape. This returns 0 if the provided shape is not a sensor.
     */
    public static int getSensorCapacity(
        MemorySegment shapeId
    ) {
        MethodHandle method = B2_SHAPE_GET_SENSOR_CAPACITY.get();
        try {
            return (int) method.invokeExact(
                shapeId
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #getSensorCapacity}.
     */
    public static int getSensorCapacity(
        ShapeId shapeId
    ) {
        return (int) getSensorCapacity(
            shapeId.memorySegment()
        );
    }
    
    /**
     * Get the overlapped shapes for a sensor shape.
     */
    public static int getSensorOverlaps(
        MemorySegment shapeId, 
        MemorySegment overlaps, 
        int capacity
    ) {
        MethodHandle method = B2_SHAPE_GET_SENSOR_OVERLAPS.get();
        try {
            return (int) method.invokeExact(
                shapeId, 
                overlaps, 
                capacity
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #getSensorOverlaps}.
     */
    public static int getSensorOverlaps(
        ShapeId shapeId, 
        ShapeId overlaps, 
        int capacity
    ) {
        return (int) getSensorOverlaps(
            shapeId.memorySegment(), 
            overlaps.memorySegment(), 
            capacity
        );
    }
    
    /**
     * Get the current world AABB
     */
    public static MemorySegment getAABB(
        SegmentAllocator allocator,
        MemorySegment shapeId
    ) {
        MethodHandle method = B2_SHAPE_GET_AABB.get();
        try {
            return (MemorySegment) method.invokeExact(
                allocator,
                shapeId
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #getAABB}.
     */
    public static @Nullable AABB getAABB(
        SegmentAllocator allocator,
        ShapeId shapeId
    ) {
        MemorySegment segment = getAABB(
            allocator,
            shapeId.memorySegment()
        );
    
        if (segment.equals(MemorySegment.NULL))
            return null;
    
        return new AABB(segment);
    }
    
    /**
     * Get the mass data for a shape
     */
    public static MemorySegment getMassData(
        SegmentAllocator allocator,
        MemorySegment shapeId
    ) {
        MethodHandle method = B2_SHAPE_GET_MASS_DATA.get();
        try {
            return (MemorySegment) method.invokeExact(
                allocator,
                shapeId
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #getMassData}.
     */
    public static @Nullable MassData getMassData(
        SegmentAllocator allocator,
        ShapeId shapeId
    ) {
        MemorySegment segment = getMassData(
            allocator,
            shapeId.memorySegment()
        );
    
        if (segment.equals(MemorySegment.NULL))
            return null;
    
        return new MassData(segment);
    }
    
    /**
     * Get the closest point on a shape to a target point. Target and result are in world space. todo need sample
     */
    public static MemorySegment getClosestPoint(
        SegmentAllocator allocator,
        MemorySegment shapeId, 
        MemorySegment target
    ) {
        MethodHandle method = B2_SHAPE_GET_CLOSEST_POINT.get();
        try {
            return (MemorySegment) method.invokeExact(
                allocator,
                shapeId, 
                target
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #getClosestPoint}.
     */
    public static @Nullable Vec2 getClosestPoint(
        SegmentAllocator allocator,
        ShapeId shapeId, 
        Vec2 target
    ) {
        MemorySegment segment = getClosestPoint(
            allocator,
            shapeId.memorySegment(), 
            target.memorySegment()
        );
    
        if (segment.equals(MemorySegment.NULL))
            return null;
    
        return new Vec2(segment);
    }
    
}