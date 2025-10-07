package volucris.engine.physics.box2d.shape;

import java.lang.foreign.Arena;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.SegmentAllocator;
import java.lang.foreign.StructLayout;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;

import org.joml.Vector2f;

import volucris.engine.physics.box2d.Box2D;
import volucris.engine.physics.box2d.body.Body;
import volucris.engine.physics.box2d.contactEvents.ContactData;
import volucris.engine.physics.box2d.geometry.Capsule;
import volucris.engine.physics.box2d.geometry.CastOutput;
import volucris.engine.physics.box2d.geometry.ChainSegment;
import volucris.engine.physics.box2d.geometry.Circle;
import volucris.engine.physics.box2d.geometry.MassData;
import volucris.engine.physics.box2d.geometry.Polygon;
import volucris.engine.physics.box2d.geometry.RayCastInput;
import volucris.engine.physics.box2d.geometry.Segment;
import volucris.engine.physics.box2d.math.AABB;
import volucris.engine.physics.box2d.math.Vec2;
import volucris.engine.physics.box2d.world.World;
import volucris.engine.utils.VolucrisRuntimeException;

import static java.lang.foreign.ValueLayout.*;
import static volucris.engine.utils.FFMUtils.*;

public final class Shape {

	private static final StructLayout SHAPE_ID_LAYOUT;

	private static final VarHandle INDEX_1;
	private static final VarHandle WORLD_0;
	private static final VarHandle GENERATION;

	private static final MethodHandle B2_CREATE_CIRCLE_SHAPE;
	private static final MethodHandle B2_CREATE_SEGMENT_SHAPE;
	private static final MethodHandle B2_CREATE_CAPSULE_SHAPE;
	private static final MethodHandle B2_CREATE_POLYGON_SHAPE;
	private static final MethodHandle B2_DESTROY_SHAPE;
	private static final MethodHandle B2_SHAPE_IS_VALID;
	private static final MethodHandle B2_SHAPE_GET_TYPE;
	private static final MethodHandle B2_SHAPE_IS_SENSOR;
	private static final MethodHandle B2_SHAPE_SET_DENSITY;
	private static final MethodHandle B2_SHAPE_GET_DENSITY;
	private static final MethodHandle B2_SHAPE_SET_FRICTION;
	private static final MethodHandle B2_SHAPE_GET_FRICTION;
	private static final MethodHandle B2_SHAPE_SET_RESTITUTION;
	private static final MethodHandle B2_SHAPE_GET_RESTITUTION;
	private static final MethodHandle B2_SHAPE_SET_MATERIAL;
	private static final MethodHandle B2_SHAPE_GET_MATERIAL;
	private static final MethodHandle B2_SHAPE_SET_SURFACE_MATERIAL;
	private static final MethodHandle B2_SHAPE_GET_SURFACE_MATERIAL;
	private static final MethodHandle B2_SHAPE_GET_FILTER;
	private static final MethodHandle B2_SHAPE_SET_FILTER;
	private static final MethodHandle B2_SHAPE_ENABLE_SENSOR_EVENTS;
	private static final MethodHandle B2_SHAPE_ARE_SENSOR_EVENTS_ENABLED;
	private static final MethodHandle B2_SHAPE_ENABLE_CONTACT_EVENTS;
	private static final MethodHandle B2_SHAPE_ARE_CONTACT_EVENTS_ENABLED;
	private static final MethodHandle B2_SHAPE_ENABLE_PRE_SOLVE_EVENTS;
	private static final MethodHandle B2_SHAPE_ARE_PRE_SOLVE_EVENTS_ENABLED;
	private static final MethodHandle B2_SHAPE_ENABLE_HIT_EVENTS;
	private static final MethodHandle B2_SHAPE_ARE_HIT_EVENTS_ENABLED;
	private static final MethodHandle B2_SHAPE_TEST_POINT;
	private static final MethodHandle B2_SHAPE_RAY_CAST;
	private static final MethodHandle B2_SHAPE_GET_CIRCLE;
	private static final MethodHandle B2_SHAPE_GET_SEGMENT;
	private static final MethodHandle B2_SHAPE_GET_CHAIN_SEGMENT;
	private static final MethodHandle B2_SHAPE_GET_CAPSULE;
	private static final MethodHandle B2_SHAPE_GET_POLYGON;
	private static final MethodHandle B2_SHAPE_SET_CIRCLE;
	private static final MethodHandle B2_SHAPE_SET_CAPSULE;
	private static final MethodHandle B2_SHAPE_SET_SEGMENT;
	private static final MethodHandle B2_SHAPE_SET_POLYGON;
	private static final MethodHandle B2_SHAPE_GET_PARENT_CHAIN;
	private static final MethodHandle B2_SHAPE_GET_CONTACT_CAPACITY;
	private static final MethodHandle B2_SHAPE_GET_CONTACT_DATA;
	private static final MethodHandle B2_SHAPE_GET_SENSOR_CAPACITY;
	private static final MethodHandle B2_SHAPE_GET_SENSOR_OVERLAPS;
	private static final MethodHandle B2_SHAPE_GET_AABB;
	private static final MethodHandle B2_SHAPE_GET_MASS_DATA;
	private static final MethodHandle B2_SHAPE_GET_CLOSEST_POINT;

	private final MemorySegment b2ShapeId;

	private ShapeId shapeId;

	private Body body;

	private Object internalUserData;
	private Object userData;

	private Vec2 vecTmp;

	static {
		//@formatter:off
		SHAPE_ID_LAYOUT = MemoryLayout.structLayout(
				JAVA_INT.withName("index1"),
		        JAVA_SHORT.withName("world0"),
		        JAVA_SHORT.withName("generation")
			);
		
		INDEX_1 = varHandle(SHAPE_ID_LAYOUT, "index1");
		WORLD_0 = varHandle(SHAPE_ID_LAYOUT, "world0");
		GENERATION = varHandle(SHAPE_ID_LAYOUT, "generation");
		
		B2_CREATE_CIRCLE_SHAPE = downcallHandle("b2CreateCircleShape", SHAPE_ID_LAYOUT, Body.LAYOUT(), ADDRESS, ADDRESS);
		B2_CREATE_SEGMENT_SHAPE = downcallHandle("b2CreateSegmentShape", SHAPE_ID_LAYOUT, Body.LAYOUT(), ADDRESS, ADDRESS);
		B2_CREATE_CAPSULE_SHAPE = downcallHandle("b2CreateCapsuleShape", SHAPE_ID_LAYOUT, Body.LAYOUT(), ADDRESS, ADDRESS);
		B2_CREATE_POLYGON_SHAPE = downcallHandle("b2CreatePolygonShape", SHAPE_ID_LAYOUT, Body.LAYOUT(), ADDRESS, ADDRESS);
		B2_DESTROY_SHAPE = downcallHandleVoid("b2DestroyShape", SHAPE_ID_LAYOUT);
		B2_SHAPE_IS_VALID = downcallHandle("b2Shape_IsValid", JAVA_BOOLEAN, SHAPE_ID_LAYOUT);
		B2_SHAPE_GET_TYPE = downcallHandle("b2Shape_GetType", JAVA_INT, SHAPE_ID_LAYOUT);
		B2_SHAPE_IS_SENSOR = downcallHandle("b2Shape_IsSensor", JAVA_BOOLEAN, SHAPE_ID_LAYOUT);
		B2_SHAPE_SET_DENSITY = downcallHandleVoid("b2Shape_SetDensity", SHAPE_ID_LAYOUT, JAVA_FLOAT, JAVA_BOOLEAN);
		B2_SHAPE_GET_DENSITY = downcallHandle("b2Shape_GetDensity", JAVA_FLOAT, SHAPE_ID_LAYOUT);
		B2_SHAPE_SET_FRICTION = downcallHandleVoid("b2Shape_SetFriction", SHAPE_ID_LAYOUT, JAVA_FLOAT);
		B2_SHAPE_GET_FRICTION = downcallHandle("b2Shape_GetFriction", JAVA_FLOAT, SHAPE_ID_LAYOUT);
		B2_SHAPE_SET_RESTITUTION = downcallHandleVoid("b2Shape_SetRestitution", SHAPE_ID_LAYOUT, JAVA_FLOAT);
		B2_SHAPE_GET_RESTITUTION = downcallHandle("b2Shape_GetRestitution", JAVA_FLOAT, SHAPE_ID_LAYOUT);
		B2_SHAPE_SET_MATERIAL = downcallHandleVoid("b2Shape_SetMaterial", SHAPE_ID_LAYOUT, JAVA_INT);
		B2_SHAPE_GET_MATERIAL = downcallHandle("b2Shape_GetMaterial", JAVA_INT, SHAPE_ID_LAYOUT);
		B2_SHAPE_SET_SURFACE_MATERIAL = downcallHandleVoid("b2Shape_SetSurfaceMaterial", SHAPE_ID_LAYOUT, SurfaceMaterial.LAYOUT());
		B2_SHAPE_GET_SURFACE_MATERIAL = downcallHandle("b2Shape_GetSurfaceMaterial", SurfaceMaterial.LAYOUT(), SHAPE_ID_LAYOUT);
		B2_SHAPE_GET_FILTER = downcallHandle("b2Shape_GetFilter", Filter.LAYOUT(), SHAPE_ID_LAYOUT);
		B2_SHAPE_SET_FILTER = downcallHandleVoid("b2Shape_SetFilter", SHAPE_ID_LAYOUT, Filter.LAYOUT());
		B2_SHAPE_ENABLE_SENSOR_EVENTS = downcallHandleVoid("b2Shape_EnableSensorEvents", SHAPE_ID_LAYOUT, JAVA_BOOLEAN);
		B2_SHAPE_ARE_SENSOR_EVENTS_ENABLED = downcallHandle("b2Shape_AreSensorEventsEnabled", JAVA_BOOLEAN, SHAPE_ID_LAYOUT);
		B2_SHAPE_ENABLE_CONTACT_EVENTS = downcallHandleVoid("b2Shape_EnableContactEvents", SHAPE_ID_LAYOUT, JAVA_BOOLEAN);
		B2_SHAPE_ARE_CONTACT_EVENTS_ENABLED = downcallHandle("b2Shape_AreContactEventsEnabled", JAVA_BOOLEAN, SHAPE_ID_LAYOUT);
		B2_SHAPE_ENABLE_PRE_SOLVE_EVENTS = downcallHandleVoid("b2Shape_EnablePreSolveEvents", SHAPE_ID_LAYOUT, JAVA_BOOLEAN);
		B2_SHAPE_ARE_PRE_SOLVE_EVENTS_ENABLED = downcallHandle("b2Shape_ArePreSolveEventsEnabled", JAVA_BOOLEAN, SHAPE_ID_LAYOUT);
		B2_SHAPE_ENABLE_HIT_EVENTS = downcallHandleVoid("b2Shape_EnableHitEvents", SHAPE_ID_LAYOUT, JAVA_BOOLEAN);
		B2_SHAPE_ARE_HIT_EVENTS_ENABLED = downcallHandle("b2Shape_AreHitEventsEnabled", JAVA_BOOLEAN, SHAPE_ID_LAYOUT);
		B2_SHAPE_TEST_POINT = downcallHandle("b2Shape_TestPoint", JAVA_BOOLEAN, SHAPE_ID_LAYOUT, Vec2.LAYOUT());
		B2_SHAPE_RAY_CAST = downcallHandle("b2Shape_RayCast", CastOutput.LAYOUT(), SHAPE_ID_LAYOUT, ADDRESS);
		B2_SHAPE_GET_CIRCLE = downcallHandle("b2Shape_GetCircle", Circle.LAYOUT(), SHAPE_ID_LAYOUT);
		B2_SHAPE_GET_SEGMENT = downcallHandle("b2Shape_GetSegment", Segment.LAYOUT(), SHAPE_ID_LAYOUT);
		B2_SHAPE_GET_CHAIN_SEGMENT = downcallHandle("b2Shape_GetChainSegment", ChainSegment.LAYOUT(), SHAPE_ID_LAYOUT);
		B2_SHAPE_GET_CAPSULE = downcallHandle("b2Shape_GetCapsule", Capsule.LAYOUT(), SHAPE_ID_LAYOUT);
		B2_SHAPE_GET_POLYGON = downcallHandle("b2Shape_GetPolygon", Polygon.LAYOUT(), SHAPE_ID_LAYOUT);
		B2_SHAPE_SET_CIRCLE = downcallHandleVoid("b2Shape_SetCircle", SHAPE_ID_LAYOUT, ADDRESS);
		B2_SHAPE_SET_CAPSULE = downcallHandleVoid("b2Shape_SetCapsule", SHAPE_ID_LAYOUT, ADDRESS);
		B2_SHAPE_SET_SEGMENT = downcallHandleVoid("b2Shape_SetSegment", SHAPE_ID_LAYOUT, ADDRESS);
		B2_SHAPE_SET_POLYGON = downcallHandleVoid("b2Shape_SetPolygon", SHAPE_ID_LAYOUT, ADDRESS);
		B2_SHAPE_GET_PARENT_CHAIN = downcallHandle("b2Shape_GetParentChain", Chain.LAYOUT(), SHAPE_ID_LAYOUT);
		B2_SHAPE_GET_CONTACT_CAPACITY = downcallHandle("b2Shape_GetContactCapacity", JAVA_INT, SHAPE_ID_LAYOUT);
		B2_SHAPE_GET_CONTACT_DATA = downcallHandle("b2Shape_GetContactData", JAVA_INT, SHAPE_ID_LAYOUT, ADDRESS, JAVA_INT);
		B2_SHAPE_GET_SENSOR_CAPACITY = downcallHandle("b2Shape_GetSensorCapacity", JAVA_INT, SHAPE_ID_LAYOUT);
		B2_SHAPE_GET_SENSOR_OVERLAPS = downcallHandle("b2Shape_GetSensorOverlaps", JAVA_INT, SHAPE_ID_LAYOUT, ADDRESS, JAVA_INT);
		B2_SHAPE_GET_AABB = downcallHandle("b2Shape_GetAABB", AABB.LAYOUT(), SHAPE_ID_LAYOUT);
		B2_SHAPE_GET_MASS_DATA = downcallHandle("b2Shape_GetMassData", MassData.LAYOUT(), SHAPE_ID_LAYOUT);
		B2_SHAPE_GET_CLOSEST_POINT = downcallHandle("b2Shape_GetClosestPoint", Vec2.LAYOUT(), SHAPE_ID_LAYOUT, Vec2.LAYOUT());
	}

	{
		vecTmp = new Vec2();
	}
	
	/**
	 *Create a circle shape and attach it to a body.  
	 *<p>
	 *The shape definition and geometry are fully cloned. Contacts are not created until the next time step. 
	 */
	public Shape(Body body, ShapeDef shapeDef, Circle circle) {
		try {
			SegmentAllocator allocator = Arena.ofAuto();
			MemorySegment bodyAddr = body.memorySegment();
			MemorySegment shapeDefAddr = shapeDef.memorySegment();
			MemorySegment circleAddr = circle.memorySegment();
			b2ShapeId = (MemorySegment) B2_CREATE_CIRCLE_SHAPE.invokeExact(allocator, bodyAddr, shapeDefAddr, circleAddr);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot create circle shape.");
		}
		
		this.shapeId = getShapeId(b2ShapeId);
		this.body = body;
		
		Box2D.addShape(this, shapeId, body.getWorld());
	}
	
	/**
	 *Create a line segment shape and attach it to a body.  
	 *<p>
	 *The shape definition and geometry are fully cloned. Contacts are not created until the next time step. 
	 */
	public Shape(Body body, ShapeDef shapeDef, Segment segment) {
		try {
			SegmentAllocator allocator = Arena.ofAuto();
			MemorySegment bodyAddr = body.memorySegment();
			MemorySegment shapeDefAddr = shapeDef.memorySegment();
			MemorySegment segmentAddr = segment.memorySegment();
			b2ShapeId = (MemorySegment) B2_CREATE_SEGMENT_SHAPE.invokeExact(allocator, bodyAddr, shapeDefAddr, segmentAddr);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot create segment shape.");
		}
		
		this.shapeId = getShapeId(b2ShapeId);
		this.body = body;
		
		Box2D.addShape(this, shapeId, body.getWorld());
	}
	
	/**
	 *Create a capsule shape and attach it to a body.  
	 *<p>
	 *The shape definition and geometry are fully cloned. Contacts are not created until the next time step. 
	 */
	public Shape(Body body, ShapeDef shapeDef, Capsule capsule) {
		try {
			SegmentAllocator allocator = Arena.ofAuto();
			MemorySegment bodyAddr = body.memorySegment();
			MemorySegment shapeDefAddr = shapeDef.memorySegment();
			MemorySegment capsuleAddr = capsule.memorySegment();
			b2ShapeId = (MemorySegment) B2_CREATE_CAPSULE_SHAPE.invokeExact(allocator, bodyAddr, shapeDefAddr, capsuleAddr);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot create capsule shape.");
		}
		
		this.shapeId = getShapeId(b2ShapeId);
		this.body = body;
		
		Box2D.addShape(this, shapeId, body.getWorld());
	}
	
	/**
	 *Create a polygon shape and attach it to a body. 
	 *<p>
	 *The shape definition and geometry are fully cloned. Contacts are not created until the next time step. 
	 */
	public Shape(Body body, ShapeDef shapeDef, Polygon polygon) {
		try {
			SegmentAllocator allocator = Arena.ofAuto();
			MemorySegment bodyAddr = body.memorySegment();
			MemorySegment shapeDefAddr = shapeDef.memorySegment();
			MemorySegment polygonAddr = polygon.memorySegment();
			b2ShapeId = (MemorySegment) B2_CREATE_POLYGON_SHAPE.invokeExact(allocator, bodyAddr, shapeDefAddr, polygonAddr);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot create polygon shape.");
		}
		
		this.shapeId = getShapeId(b2ShapeId);
		this.body = body;
		
		Box2D.addShape(this, shapeId, body.getWorld());
	}
	//@formatter:on

	public Shape(MemorySegment memorySegment, Body body) {
		b2ShapeId = memorySegment;

		this.shapeId = getShapeId(b2ShapeId);
		this.body = body;

		Box2D.addShape(this, shapeId, body.getWorld());
	}

	/**
	 * Destroy a shape.
	 */
	public void destroyShape() {
		try {
			B2_DESTROY_SHAPE.invokeExact(b2ShapeId);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot destroy shape.");
		}

		int index1 = (int) INDEX_1.get(b2ShapeId);
		short world0 = (short) WORLD_0.get(b2ShapeId);
		short generation = (short) GENERATION.get(b2ShapeId);
		ShapeId shapeId = new ShapeId(index1, world0, generation);
		Box2D.removeShape(shapeId, body.getWorld());
	}

	/**
	 * Shape identifier validation. Provides validation for up to 64K allocations.
	 */
	public boolean isValid() {
		try {
			return (boolean) B2_SHAPE_IS_VALID.invokeExact(b2ShapeId);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot validate shape.");
		}
	}

	/**
	 * Get the type of a shape.
	 */
	public ShapeType getType() {
		try {
			int type = (int) B2_SHAPE_GET_TYPE.invokeExact(b2ShapeId);
			if (type == 0)
				return ShapeType.CIRCLE_SHAPE;
			else if (type == 1)
				return ShapeType.CAPSULE_SHAPE;
			else if (type == 2)
				return ShapeType.SEGMENT_SHAPE;
			else if (type == 3)
				return ShapeType.POLYGON_SHAPE;
			else
				return ShapeType.CHAIN_SEGMENT_SHAPE;
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot get type");
		}
	}

	/**
	 * Get the body that a shape is attached to.
	 */
	public Body getBody() {
		return body;
	}

	/**
	 * Get the world that owns this shape.
	 */
	public World getWorld() {
		return body.getWorld();
	}

	/**
	 * Returns true if the shape is a sensor.
	 */
	public boolean isSensor() {
		try {
			return (boolean) B2_SHAPE_IS_SENSOR.invokeExact(b2ShapeId);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot check if shape is sensor.");
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
	 * Set the mass density of a shape, usually in kg/m^2.
	 */
	public void setDensity(float density, boolean updateBodyMass) {
		try {
			B2_SHAPE_SET_DENSITY.invokeExact(b2ShapeId, density, updateBodyMass);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot set density.");
		}
	}

	/**
	 * Get the density of a shape, usually in kg/m^2.
	 */
	public float getDensity() {
		try {
			return (float) B2_SHAPE_GET_DENSITY.invokeExact(b2ShapeId);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot get density.");
		}
	}

	/**
	 * Set the friction on a shape.
	 */
	public void setFriction(float friction) {
		try {
			B2_SHAPE_SET_FRICTION.invokeExact(b2ShapeId, friction);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot set friction.");
		}
	}

	/**
	 * Get the friction of a shape.
	 */
	public float getFriction() {
		try {
			return (float) B2_SHAPE_GET_FRICTION.invokeExact(b2ShapeId);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot get friction.");
		}
	}

	/**
	 * Set the shape restitution (bounciness)
	 */
	public void setRestitution(float restitution) {
		try {
			B2_SHAPE_SET_RESTITUTION.invokeExact(b2ShapeId, restitution);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot set restitution.");
		}
	}

	/**
	 * Get the shape restitution.
	 */
	public float getRestitution() {
		try {
			return (float) B2_SHAPE_GET_RESTITUTION.invokeExact(b2ShapeId);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot get restitution.");
		}
	}

	/**
	 * Set the shape material identifier.
	 */
	public void setMaterial(int material) {
		try {
			B2_SHAPE_SET_MATERIAL.invoke(b2ShapeId, material);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot set material.");
		}
	}

	/**
	 * Get the shape material identifier.
	 */
	public int getMaterial() {
		try {
			return (int) B2_SHAPE_GET_MATERIAL.invokeExact(b2ShapeId);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot get material.");
		}
	}

	/**
	 * Set the shape surface material
	 */
	public void setSurfaceMaterial(SurfaceMaterial surfaceMaterial) {
		try {
			B2_SHAPE_SET_SURFACE_MATERIAL.invokeExact(b2ShapeId, surfaceMaterial.memorySegment());
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot set surface material.");
		}
	}

	/**
	 * Get the shape surface material
	 */
	public SurfaceMaterial getSurfaceMaterial(SurfaceMaterial target) {
		try (Arena arena = Arena.ofConfined()) {
			SegmentAllocator allocator = arena;
			MemorySegment segment = (MemorySegment) B2_SHAPE_GET_SURFACE_MATERIAL.invokeExact(allocator, b2ShapeId);
			target.set(segment);
			return target;
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot get surface material.");
		}
	}

	/**
	 * Get the shape surface material
	 */
	public SurfaceMaterial getSurfaceMaterial() {
		return getSurfaceMaterial(new SurfaceMaterial());
	}

	/**
	 * Get the shape filter.
	 */
	public Filter getFilter(Filter target) {
		try (Arena arena = Arena.ofConfined()) {
			SegmentAllocator allocator = arena;
			MemorySegment segment = (MemorySegment) B2_SHAPE_GET_FILTER.invokeExact(allocator, b2ShapeId);
			target.set(segment);
			return target;
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot get filter.");
		}
	}

	/**
	 * Set the current filter.
	 */
	public void setFilter(Filter filter) {
		try {
			B2_SHAPE_SET_FILTER.invokeExact(b2ShapeId, filter.memorySegment());
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot set filter.");
		}
	}

	/**
	 * Get the shape filter.
	 */
	public Filter getFilter() {
		return getFilter(new Filter());
	}

	/**
	 * Enable sensor events for this shape.
	 */
	public void enableSensorEvents(boolean enableSensorEvents) {
		try {
			B2_SHAPE_ENABLE_SENSOR_EVENTS.invokeExact(b2ShapeId, enableSensorEvents);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot enable/ disable sensor events.");
		}
	}

	/**
	 * Returns true if sensor events are enabled.
	 */
	public boolean areSensorEventsEnabled() {
		try {
			return (boolean) B2_SHAPE_ARE_SENSOR_EVENTS_ENABLED.invoke(b2ShapeId);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot check if sensor events are enabled.");
		}
	}

	/**
	 * Enable contact events for this shape.
	 */
	public void enableContactEvents(boolean enableContactEvents) {
		try {
			B2_SHAPE_ENABLE_CONTACT_EVENTS.invokeExact(b2ShapeId, enableContactEvents);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot enable/ disable contact events.");
		}
	}

	/**
	 * Returns true if contact events are enabled.
	 */
	public boolean areContactEventsEnabled() {
		try {
			return (boolean) B2_SHAPE_ARE_CONTACT_EVENTS_ENABLED.invokeExact(b2ShapeId);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot check if contact events are enabled.");
		}
	}

	/**
	 * Enable pre-solve contact events for this shape.
	 */
	public void enablePreSolveEvents(boolean enablePreSolveEvents) {
		try {
			B2_SHAPE_ENABLE_PRE_SOLVE_EVENTS.invokeExact(b2ShapeId, enablePreSolveEvents);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot enable/ disable pre solve events.");
		}
	}

	/**
	 * Returns true if pre-solve events are enabled.
	 */
	public boolean arePreSolveEventsEnabled() {
		try {
			return (boolean) B2_SHAPE_ARE_PRE_SOLVE_EVENTS_ENABLED.invoke(b2ShapeId);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot check if pre solve events are enabled.");
		}
	}

	/**
	 * Enable contact hit events for this shape.
	 */
	public void enableHitEvents(boolean enableHitEvents) {
		try {
			B2_SHAPE_ENABLE_HIT_EVENTS.invokeExact(b2ShapeId, enableHitEvents);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot enable/ disable hit events.");
		}
	}

	/**
	 * Returns true if hit events are enabled.
	 */
	public boolean areHitEventsEnabled() {
		try {
			return (boolean) B2_SHAPE_ARE_HIT_EVENTS_ENABLED.invokeExact(b2ShapeId);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot check if hit events are enabled.");
		}
	}

	/**
	 * Test a point for overlap with a shape.
	 */
	public boolean testPoint(Vector2f point) {
		try {
			vecTmp.set(point);
			return (boolean) B2_SHAPE_TEST_POINT.invokeExact(b2ShapeId, vecTmp.memorySegment());
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot test point.");
		}
	}

	/**
	 * Ray cast a shape directly.
	 */
	public CastOutput rayCast(CastOutput target, RayCastInput rayCastInput) {
		try (Arena arena = Arena.ofConfined()) {
			SegmentAllocator allocator = arena;
			MemorySegment inputAddr = rayCastInput.memorySegment();

			MemorySegment segment = (MemorySegment) B2_SHAPE_RAY_CAST.invokeExact(allocator, b2ShapeId, inputAddr);
			target.set(segment);
			return target;
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot ray cast.");
		}
	}

	/**
	 * Ray cast a shape directly.
	 */
	public CastOutput rayCast(RayCastInput rayCastInput) {
		return rayCast(new CastOutput(), rayCastInput);
	}

	/**
	 * Get a copy of the shape's circle. Asserts the type is correct.
	 */
	public Circle getCircle(Circle target) {
		try (Arena arena = Arena.ofConfined()) {
			SegmentAllocator allocator = arena;
			MemorySegment segment = (MemorySegment) B2_SHAPE_GET_CIRCLE.invokeExact(allocator, b2ShapeId);
			target.set(segment);
			return target;
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot get circle.");
		}
	}

	/**
	 * Get a copy of the shape's circle. Asserts the type is correct.
	 */
	public Circle getCircle() {
		return getCircle(new Circle());
	}

	/**
	 * Get a copy of the shape's line segment. Asserts the type is correct.
	 */
	public Segment getSegment(Segment target) {
		try (Arena arena = Arena.ofConfined()) {
			SegmentAllocator allocator = arena;
			MemorySegment segment = (MemorySegment) B2_SHAPE_GET_SEGMENT.invokeExact(allocator, b2ShapeId);
			target.set(segment);
			return target;
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot get segment.");
		}
	}

	/**
	 * Get a copy of the shape's line segment. Asserts the type is correct.
	 */
	public Segment getSegment() {
		return getSegment(new Segment());
	}

	/**
	 * Get a copy of the shape's chain segment.
	 */
	public ChainSegment getChainSegment(ChainSegment target) {
		try (Arena arena = Arena.ofConfined()) {
			SegmentAllocator allocator = arena;
			MemorySegment segment = (MemorySegment) B2_SHAPE_GET_CHAIN_SEGMENT.invokeExact(allocator, b2ShapeId);
			target.set(segment);
			return target;
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot get segment.");
		}
	}

	/**
	 * Get a copy of the shape's chain segment.
	 */
	public ChainSegment getChainSegment() {
		return getChainSegment(new ChainSegment());
	}

	/**
	 * Get a copy of the shape's capsule. Asserts the type is correct.
	 */
	public Capsule getCapsule(Capsule target) {
		try (Arena arena = Arena.ofConfined()) {
			SegmentAllocator allocator = arena;
			MemorySegment segment = (MemorySegment) B2_SHAPE_GET_CAPSULE.invokeExact(allocator, b2ShapeId);
			target.set(segment);
			return target;
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot get segment.");
		}
	}

	/**
	 * Get a copy of the shape's capsule. Asserts the type is correct.
	 */
	public Capsule getCapsule() {
		return getCapsule(new Capsule());
	}

	/**
	 * Get a copy of the shape's convex polygon. Asserts the type is correct.
	 */
	public Polygon getPolygon() {
		try (Arena arena = Arena.ofConfined()) {
			SegmentAllocator allocator = arena;
			MemorySegment segment = (MemorySegment) B2_SHAPE_GET_POLYGON.invokeExact(allocator, b2ShapeId);
			return new Polygon(segment);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot get segment.");
		}
	}

	/**
	 * Allows you to change a shape to be a circle or update the current circle.
	 */
	public void setCircle(Circle circle) {
		try {
			B2_SHAPE_SET_CIRCLE.invokeExact(b2ShapeId, circle.memorySegment());
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot set circle.");
		}
	}

	/**
	 * Allows you to change a shape to be a capsule or update the current capsule.
	 */
	public void setCapsule(Capsule capsule) {
		try {
			B2_SHAPE_SET_CAPSULE.invokeExact(b2ShapeId, capsule.memorySegment());
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot set capsule.");
		}
	}

	/**
	 * Allows you to change a shape to be a segment or update the current segment.
	 */
	public void setSegment(Segment segment) {
		try {
			B2_SHAPE_SET_SEGMENT.invokeExact(b2ShapeId, segment.memorySegment());
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot set segment.");
		}
	}

	/**
	 * Allows you to change a shape to be a polygon or update the current polygon.
	 */
	public void setPolygon(Polygon polygon) {
		try {
			B2_SHAPE_SET_POLYGON.invokeExact(b2ShapeId, polygon.memorySegment());
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot set polygon.");
		}
	}

	/**
	 * Get the parent chain id if the shape type is a chain segment, otherwise
	 * returns null.
	 */
	public Chain getParentChain() {
		try (Arena arena = Arena.ofConfined()) {
			SegmentAllocator allocator = arena;
			MemorySegment segment = (MemorySegment) B2_SHAPE_GET_PARENT_CHAIN.invokeExact(allocator, b2ShapeId);
			return Box2D.getChain(Chain.getChainId(segment), body.getWorld());
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot get parent chain.");
		}
	}

	/**
	 * Get the maximum capacity required for retrieving all the touching contacts on
	 * a shape.
	 */
	public int getContactCapacity() {
		try {
			return (int) B2_SHAPE_GET_CONTACT_CAPACITY.invokeExact(b2ShapeId);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot get contact capacity");
		}
	}

	/**
	 * Get the touching contact data for a shape.
	 */
	public int getContactData(ContactData[] target) {
		try (Arena arena = Arena.ofConfined()) {
			MemorySegment array = arena.allocate(MemoryLayout.sequenceLayout(target.length, ContactData.LAYOUT()));

			int count = (int) B2_SHAPE_GET_CONTACT_DATA.invokeExact(b2ShapeId, array, target.length);

			for (int i = 0; i < count; i++) {
				long offset = i * ContactData.LAYOUT().byteSize();
				ContactData data = target[i];

				if (data == null) {
					MemorySegment arraySegment = array.asSlice(offset, ContactData.LAYOUT());
					MemorySegment dataSegment = Arena.ofAuto().allocate(ContactData.LAYOUT());
					MemorySegment.copy(arraySegment, 0L, dataSegment, 0L, ContactData.LAYOUT().byteSize());
					target[i] = new ContactData(dataSegment, body.getWorld());
				} else {
					target[i].set(array.asSlice(offset, ContactData.LAYOUT()), body.getWorld());
				}
			}

			return count;
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot get contact data.");
		}
	}

	/**
	 * Get the maximum capacity required for retrieving all the overlapped shapes on
	 * a sensor shape.
	 */
	public int getSensorCapacity() {
		try {
			return (int) B2_SHAPE_GET_SENSOR_CAPACITY.invokeExact(b2ShapeId);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot get sensor capacity.");
		}
	}

	/**
	 * Get the overlapped shapes for a sensor shape.
	 */
	public int getSensorOverlaps(Shape[] target) {
		try (Arena arena = Arena.ofConfined()) {
			MemorySegment array = arena.allocate(MemoryLayout.sequenceLayout(target.length, Shape.LAYOUT()));

			int count = (int) B2_SHAPE_GET_SENSOR_OVERLAPS.invokeExact(b2ShapeId, array, target.length);

			for (int i = 0; i < count; i++) {
				long offset = i * Shape.LAYOUT().byteSize();
				MemorySegment arraySegment = array.asSlice(offset, Shape.LAYOUT());
				Shape shape = Box2D.getShape(Shape.getShapeId(arraySegment), body.getWorld());

				if (shape == null) {
					MemorySegment shapeSegment = Arena.ofAuto().allocate(Shape.LAYOUT());
					MemorySegment.copy(arraySegment, offset, shapeSegment, 0L, Shape.LAYOUT().byteSize());
					target[i] = new Shape(shapeSegment, body);
				} else {
					target[i] = shape;
				}
			}

			return count;
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot get sensor overlaps.");
		}
	}

	/**
	 * Get the current world AABB.
	 */
	public AABB getAABB(AABB target) {
		try (Arena arena = Arena.ofConfined()) {
			SegmentAllocator allocator = arena;
			MemorySegment segment = (MemorySegment) B2_SHAPE_GET_AABB.invokeExact(allocator, b2ShapeId);
			target.set(segment);
			return target;
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot get AABB.");
		}
	}

	/**
	 * Get the current world AABB.
	 */
	public AABB getAABB() {
		return getAABB(new AABB());
	}

	/**
	 * Get the mass data for a shape.
	 */
	public MassData getMassData(MassData target) {
		try (Arena arena = Arena.ofConfined()) {
			SegmentAllocator allocator = arena;
			MemorySegment segment = (MemorySegment) B2_SHAPE_GET_MASS_DATA.invokeExact(allocator, b2ShapeId);
			target.set(segment);
			return target;
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot get mass data.");
		}
	}

	/**
	 * Get the mass data for a shape.
	 */
	public MassData getMassData() {
		return getMassData(new MassData());
	}

	/**
	 * Get the closest point on a shape to a target point.
	 */
	public Vector2f getClosestPoint(Vector2f point, Vector2f target) {
		try (Arena arena = Arena.ofConfined()) {
			SegmentAllocator allocator = arena;
			vecTmp.set(point);

			MethodHandle method = B2_SHAPE_GET_CLOSEST_POINT;
			MemorySegment segment = (MemorySegment) method.invokeExact(allocator, b2ShapeId, vecTmp.memorySegment());

			vecTmp.set(segment);
			return vecTmp.get(target);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot get closest point.");
		}
	}

	/**
	 * Get the closest point on a shape to a target point.
	 */
	public Vector2f getClosestPoint(Vector2f point) {
		return getClosestPoint(point, new Vector2f());
	}

	public MemorySegment memorySegment() {
		return b2ShapeId.asReadOnly();
	}

	public static StructLayout LAYOUT() {
		return SHAPE_ID_LAYOUT;
	}

	public static ShapeId getShapeId(MemorySegment memorySegment) {
		int index1 = (int) INDEX_1.get(memorySegment);
		short world0 = (short) WORLD_0.get(memorySegment);
		short generation = (short) GENERATION.get(memorySegment);
		return new ShapeId(index1, world0, generation);
	}

	public static record ShapeId(int index1, short world0, short generation) {
	};
}
