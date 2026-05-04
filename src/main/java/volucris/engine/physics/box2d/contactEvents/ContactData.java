package volucris.engine.physics.box2d.contactEvents;

import java.lang.foreign.Arena;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.StructLayout;

import volucris.engine.physics.box2d.Box2D;
import volucris.engine.physics.box2d.body.Body;
import volucris.engine.physics.box2d.collision.Manifold;
import volucris.engine.physics.box2d.shape.Shape;
import volucris.engine.physics.box2d.world.World;

import static java.lang.foreign.ValueLayout.*;

/**
 * The contact data for two shapes.
 * 
 * By convention the manifold normal points from shape A to shape B.
 * 
 * @see Shape#getContactData(ContactData[]) Shape.getContactData
 * @see Body#getContactData(ContactData[]) Body.getContactData
 */
public final class ContactData {

	private static final StructLayout LAYOUT;

	private static final long SHAPE_ID_A_OFFSET;
	private static final long SHAPE_ID_B_OFFSET;
	private static final long MANIFOLD_OFFSET;

	private final MemorySegment b2ContactData;

	private final MemorySegment shapeIdA;
	private final MemorySegment shapeIdB;

	private final Manifold manifold;

	private World world;

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

	public ContactData() {
		this(Arena.ofAuto());
	}

	public ContactData(Arena arena) {
		b2ContactData = arena.allocate(LAYOUT);

		shapeIdA = b2ContactData.asSlice(SHAPE_ID_A_OFFSET, Shape.LAYOUT());
		shapeIdB = b2ContactData.asSlice(SHAPE_ID_B_OFFSET, Shape.LAYOUT());

		manifold = new Manifold(b2ContactData.asSlice(MANIFOLD_OFFSET, Manifold.LAYOUT()));
	}

	public ContactData(MemorySegment memorySegment, World world) {
		this.b2ContactData = memorySegment;
		this.world = world;

		shapeIdA = b2ContactData.asSlice(SHAPE_ID_A_OFFSET, Shape.LAYOUT());
		shapeIdB = b2ContactData.asSlice(SHAPE_ID_B_OFFSET, Shape.LAYOUT());

		manifold = new Manifold(b2ContactData.asSlice(MANIFOLD_OFFSET, Manifold.LAYOUT()));
	}

	public void set(MemorySegment memorySegment, World world) {
		MemorySegment.copy(memorySegment, 0, b2ContactData, 0, LAYOUT.byteSize());
	}

	public Manifold getManifold() {
		return manifold;
	}

	public Shape getShapeA() {
		return Box2D.getShape(Shape.getShapeId(shapeIdA), world);
	}

	public Shape getShapeB() {
		return Box2D.getShape(Shape.getShapeId(shapeIdB), world);
	}

	public void setWorld(World world) {
		this.world = world;
	}

	public MemorySegment memorySegment() {
		return b2ContactData;
	}

	public static StructLayout LAYOUT() {
		return LAYOUT;
	}

}
