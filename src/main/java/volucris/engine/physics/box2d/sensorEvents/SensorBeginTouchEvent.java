package volucris.engine.physics.box2d.sensorEvents;

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

	private Shape sensorShape;
	private Shape visitorShape;

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
	}

	public SensorBeginTouchEvent(MemorySegment memorySegment, World world) {
		MemorySegment sensorShapeSegment = memorySegment.asSlice(SENSOR_SHAPE_ID_OFFSET, Shape.LAYOUT());
		sensorShape = Box2D.getShape(Shape.getShapeId(sensorShapeSegment), world);

		MemorySegment visitorShapeSegment = memorySegment.asSlice(VISITOR_SHAPE_ID_OFFSET, Shape.LAYOUT());
		visitorShape = Box2D.getShape(Shape.getShapeId(visitorShapeSegment), world);
	}

	public void set(MemorySegment memorySegment, World world) {
		MemorySegment sensorShapeSegment = memorySegment.asSlice(SENSOR_SHAPE_ID_OFFSET, Shape.LAYOUT());
		sensorShape = Box2D.getShape(Shape.getShapeId(sensorShapeSegment), world);

		MemorySegment visitorShapeSegment = memorySegment.asSlice(VISITOR_SHAPE_ID_OFFSET, Shape.LAYOUT());
		visitorShape = Box2D.getShape(Shape.getShapeId(visitorShapeSegment), world);
	}

	public Shape getSensorShape() {
		return sensorShape;
	}

	public Shape getVisitorShape() {
		return visitorShape;
	}

	public static StructLayout LAYOUT() {
		return LAYOUT;
	}

}
