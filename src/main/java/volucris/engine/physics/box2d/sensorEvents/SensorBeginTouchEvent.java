package volucris.engine.physics.box2d.sensorEvents;

import java.lang.foreign.Arena;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemoryLayout.PathElement;

import volucris.engine.physics.box2d.Box2D;
import volucris.engine.physics.box2d.shape.Shape;
import volucris.engine.physics.box2d.world.World;

import java.lang.foreign.MemorySegment;
import java.lang.foreign.StructLayout;

/**
 * A begin touch event is generated when a shape starts to overlap a sensor
 * shape.
 */
public final class SensorBeginTouchEvent {

	private static final StructLayout LAYOUT;

	private static final long SENSOR_SHAPE_ID_OFFSET;
	private static final long VISITOR_SHAPE_ID_OFFSET;

	private final MemorySegment b2SensorBeginTouchEvent;

	private final MemorySegment sensorShapeId;
	private final MemorySegment visistorShapeId;

	private World world;

	static {
		//@formatter:off
		LAYOUT = MemoryLayout.structLayout(
				Shape.LAYOUT().withName("sensorShapeId"),
		        Shape.LAYOUT().withName("visitorShapeId")
			).withName("b2SensorBeginTouchEvent");
		//@formatter:on

		SENSOR_SHAPE_ID_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("sensorShapeId"));
		VISITOR_SHAPE_ID_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("visitorShapeId"));
	}

	public SensorBeginTouchEvent() {
		this(Arena.ofAuto());
	}

	public SensorBeginTouchEvent(Arena arena) {
		b2SensorBeginTouchEvent = arena.allocate(LAYOUT);

		sensorShapeId = b2SensorBeginTouchEvent.asSlice(SENSOR_SHAPE_ID_OFFSET, Shape.LAYOUT());
		visistorShapeId = b2SensorBeginTouchEvent.asSlice(VISITOR_SHAPE_ID_OFFSET, Shape.LAYOUT());
	}

	public SensorBeginTouchEvent(MemorySegment memorySegment, World world) {
		this.b2SensorBeginTouchEvent = memorySegment;
		this.world = world;

		sensorShapeId = b2SensorBeginTouchEvent.asSlice(SENSOR_SHAPE_ID_OFFSET, Shape.LAYOUT());
		visistorShapeId = b2SensorBeginTouchEvent.asSlice(VISITOR_SHAPE_ID_OFFSET, Shape.LAYOUT());
	}

	public void set(MemorySegment memorySegment, World world) {
		MemorySegment.copy(memorySegment, 0, b2SensorBeginTouchEvent, 0, LAYOUT.byteSize());
		this.world = world;
	}

	public Shape getSensorShape() {
		return Box2D.getShape(Shape.getShapeId(sensorShapeId), world);
	}

	public Shape getVisitorShape() {
		return Box2D.getShape(Shape.getShapeId(visistorShapeId), world);
	}

	public void setWorld(World world) {
		this.world = world;
	}

	public MemorySegment memorySegment() {
		return b2SensorBeginTouchEvent;
	}

	public static StructLayout LAYOUT() {
		return LAYOUT;
	}

}
