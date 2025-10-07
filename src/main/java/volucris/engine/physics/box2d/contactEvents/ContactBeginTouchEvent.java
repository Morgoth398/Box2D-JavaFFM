package volucris.engine.physics.box2d.contactEvents;

import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.StructLayout;
import java.lang.foreign.MemoryLayout.PathElement;

import volucris.engine.physics.box2d.Box2D;
import volucris.engine.physics.box2d.collision.Manifold;
import volucris.engine.physics.box2d.shape.Shape;
import volucris.engine.physics.box2d.world.World;

/**
 * A begin touch event is generated when two shapes begin touching.
 */
public final class ContactBeginTouchEvent {

	private static final StructLayout LAYOUT;

	private static final long SHAPE_ID_A_OFFSET;
	private static final long SHAPE_ID_B_OFFSET;
	private static final long MANIFOLD_OFFSET;

	private final Manifold manifold;

	private Shape shapeA;
	private Shape shapeB;

	static {
		//@formatter:off
		LAYOUT = MemoryLayout.structLayout(
		        Shape.LAYOUT().withName("shapeIdA"),
		        Shape.LAYOUT().withName("shapeIdB"),
		        Manifold.LAYOUT().withName("manifold")
			);
		//@formatter:on

		SHAPE_ID_A_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("shapeIdA"));
		SHAPE_ID_B_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("shapeIdB"));
		MANIFOLD_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("manifold"));
	}

	public ContactBeginTouchEvent() {
		manifold = new Manifold();
	}

	public ContactBeginTouchEvent(MemorySegment memorySegment, World world) {
		manifold = new Manifold(memorySegment.asSlice(MANIFOLD_OFFSET, Manifold.LAYOUT()));

		MemorySegment shapeASegment = memorySegment.asSlice(SHAPE_ID_A_OFFSET, Shape.LAYOUT());
		shapeA = Box2D.getShape(Shape.getShapeId(shapeASegment), world);

		MemorySegment shapeBSegment = memorySegment.asSlice(SHAPE_ID_B_OFFSET, Shape.LAYOUT());
		shapeB = Box2D.getShape(Shape.getShapeId(shapeBSegment), world);
	}

	public void set(MemorySegment memorySegment, World world) {
		manifold.set(memorySegment.asSlice(MANIFOLD_OFFSET, Manifold.LAYOUT()));

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

	/**
	 * The initial contact manifold.
	 * <p>
	 * This is recorded before the solver is called, so all the impulses will be
	 * zero.
	 */
	public Manifold getManifold() {
		return manifold;
	}

	public static StructLayout LAYOUT() {
		return LAYOUT;
	}

}
