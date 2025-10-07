package volucris.engine.physics.box2d.sensorEvents;

import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.StructLayout;
import java.lang.foreign.MemoryLayout.PathElement;

import volucris.engine.physics.box2d.Box2D;
import volucris.engine.physics.box2d.shape.Shape;
import volucris.engine.physics.box2d.world.World;

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

	private Shape sensorShape;
	private Shape visitorShape;

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
	}

	public SensorEndTouchEvent(MemorySegment memorySegment, World world) {
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
