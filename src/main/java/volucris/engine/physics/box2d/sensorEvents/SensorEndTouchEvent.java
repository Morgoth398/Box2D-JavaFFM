package volucris.engine.physics.box2d.sensorEvents;

import java.lang.foreign.Arena;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.StructLayout;
import java.lang.foreign.MemoryLayout.PathElement;

import volucris.engine.physics.box2d.Box2D;
import volucris.engine.physics.box2d.shape.Shape;
import volucris.engine.physics.box2d.world.World;
import volucris.engine.physics.box2d.world.World.WorldId;

/**
 * An end touch event is generated when a shape stops overlapping a sensor
 * shape.
 * <p>
 * These include things like setting the transform, destroying a body or shape,
 * or changing a filter. You will also get an end event if the sensor or visitor
 * are destroyed. Therefore you should always confirm the shape id is valid
 * using {@link Shape#isValid()}.
 * 
 */
public final class SensorEndTouchEvent {

	private static final StructLayout LAYOUT;

	private static final long SENSOR_SHAPE_ID_OFFSET;
	private static final long VISITOR_SHAPE_ID_OFFSET;

	private final MemorySegment b2SensorEndTouchEvent;

	private final MemorySegment sensorShapeId;
	private final MemorySegment visitorShapeId;

	private World world;

	static {
		//@formatter:off
		LAYOUT = MemoryLayout.structLayout(
				Shape.LAYOUT().withName("sensorShapeId"),
		        Shape.LAYOUT().withName("visitorShapeId")
			).withName("b2SensorEndTouchEvent");
		//@formatter:on

		SENSOR_SHAPE_ID_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("sensorShapeId"));
		VISITOR_SHAPE_ID_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("visitorShapeId"));
	}

	public SensorEndTouchEvent() {
		this(Arena.ofAuto());
	}

	public SensorEndTouchEvent(Arena arena) {
		b2SensorEndTouchEvent = arena.allocate(LAYOUT);

		sensorShapeId = b2SensorEndTouchEvent.asSlice(SENSOR_SHAPE_ID_OFFSET, Shape.LAYOUT());
		visitorShapeId = b2SensorEndTouchEvent.asSlice(VISITOR_SHAPE_ID_OFFSET, Shape.LAYOUT());
	}

	public SensorEndTouchEvent(MemorySegment memorySegment, World world) {
		this.b2SensorEndTouchEvent = memorySegment;
		this.world = world;

		sensorShapeId = b2SensorEndTouchEvent.asSlice(SENSOR_SHAPE_ID_OFFSET, Shape.LAYOUT());
		visitorShapeId = b2SensorEndTouchEvent.asSlice(VISITOR_SHAPE_ID_OFFSET, Shape.LAYOUT());
	}

	public void set(MemorySegment memorySegment, World world) {
		MemorySegment.copy(memorySegment, 0, b2SensorEndTouchEvent, 0, LAYOUT.byteSize());
	}

	public Shape getSensorShape() {
		WorldId worldId = world.getWorldId();
		
		Shape shape = Box2D.getShape(Shape.getShapeId(sensorShapeId), worldId);
		
		if (shape != null)
			return shape;
		
		return new Shape(sensorShapeId, 0L, worldId);
	}

	public Shape getVisitorShape() {
		WorldId worldId = world.getWorldId();
		
		Shape shape = Box2D.getShape(Shape.getShapeId(visitorShapeId), worldId);
		
		if (shape != null)
			return shape;
		
		return new Shape(sensorShapeId, 0L, worldId);
	}

	public void setWorld(World world) {
		this.world = world;
	}

	public MemorySegment memorySegment() {
		return b2SensorEndTouchEvent;
	}

	public static StructLayout LAYOUT() {
		return LAYOUT;
	}
}
