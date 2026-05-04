package volucris.engine.physics.box2d.contactEvents;

import java.lang.foreign.MemoryLayout;
import java.lang.foreign.StructLayout;
import java.lang.foreign.MemoryLayout.PathElement;

import volucris.engine.physics.box2d.Box2D;
import volucris.engine.physics.box2d.shape.Shape;
import volucris.engine.physics.box2d.world.World;

import java.lang.foreign.MemorySegment;

/**
 * An end touch event is generated when two shapes stop touching.
 * <p>
 * You will get an end event if you do anything that destroys contacts previous
 * to the last world step. These include things like setting the transform,
 * destroying a body or shape, or changing a filter or body type. You should
 * always confirm the shape id is valid using {@link Shape#isValid()}.
 */
public final class ContactEndTouchEvent {

	private static final StructLayout LAYOUT;

	private static final long SHAPE_ID_A_OFFSET;
	private static final long SHAPE_ID_B_OFFSET;

	private Shape shapeA;
	private Shape shapeB;

	static {
		//@formatter:off
		LAYOUT = MemoryLayout.structLayout(
		        Shape.LAYOUT().withName("shapeIdA"),
		        Shape.LAYOUT().withName("shapeIdB")
			);
		//@formatter:on

		SHAPE_ID_A_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("shapeIdA"));
		SHAPE_ID_B_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("shapeIdB"));
	}

	public ContactEndTouchEvent() {
	}

	public ContactEndTouchEvent(MemorySegment memorySegment, World world) {
		MemorySegment shapeASegment = memorySegment.asSlice(SHAPE_ID_A_OFFSET, Shape.LAYOUT());
		shapeA = Box2D.getShape(Shape.getShapeId(shapeASegment), world);

		MemorySegment shapeBSegment = memorySegment.asSlice(SHAPE_ID_B_OFFSET, Shape.LAYOUT());
		shapeB = Box2D.getShape(Shape.getShapeId(shapeBSegment), world);
	}

	public void set(MemorySegment memorySegment, World world) {
		MemorySegment shapeASegment = memorySegment.asSlice(SHAPE_ID_A_OFFSET, Shape.LAYOUT());
		shapeA = Box2D.getShape(Shape.getShapeId(shapeASegment), world);

		MemorySegment shapeBSegment = memorySegment.asSlice(SHAPE_ID_B_OFFSET, Shape.LAYOUT());
		shapeB = Box2D.getShape(Shape.getShapeId(shapeBSegment), world);
	}

	/**
	 * The first shape.
	 */
	public Shape getShapeA() {
		return shapeA;
	}

	/**
	 * The second shape.
	 */
	public Shape getShapeB() {
		return shapeB;
	}

	public static StructLayout LAYOUT() {
		return LAYOUT;
	}

}
