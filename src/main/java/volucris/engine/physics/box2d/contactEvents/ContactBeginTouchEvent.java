package volucris.engine.physics.box2d.contactEvents;

import java.lang.foreign.Arena;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.StructLayout;
import java.lang.foreign.MemoryLayout.PathElement;

import volucris.engine.physics.box2d.Box2D;
import volucris.engine.physics.box2d.collision.Manifold;
import volucris.engine.physics.box2d.shape.Shape;
import volucris.engine.physics.box2d.world.World;
import volucris.engine.physics.box2d.world.World.WorldId;

/**
 * A begin touch event is generated when two shapes begin touching.
 */
public final class ContactBeginTouchEvent {

	private static final StructLayout LAYOUT;

	private static final long SHAPE_ID_A_OFFSET;
	private static final long SHAPE_ID_B_OFFSET;
	private static final long MANIFOLD_OFFSET;

	private final MemorySegment b2ContactBeginTouchEvent;

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

	public ContactBeginTouchEvent() {
		this(Arena.ofAuto());
	}

	public ContactBeginTouchEvent(Arena arena) {
		b2ContactBeginTouchEvent = arena.allocate(LAYOUT);

		shapeIdA = b2ContactBeginTouchEvent.asSlice(SHAPE_ID_A_OFFSET, Shape.LAYOUT());
		shapeIdB = b2ContactBeginTouchEvent.asSlice(SHAPE_ID_B_OFFSET, Shape.LAYOUT());

		manifold = new Manifold(arena);
	}

	public ContactBeginTouchEvent(MemorySegment memorySegment, World world) {
		this.b2ContactBeginTouchEvent = memorySegment;
		this.world = world;

		shapeIdA = b2ContactBeginTouchEvent.asSlice(SHAPE_ID_A_OFFSET, Shape.LAYOUT());
		shapeIdB = b2ContactBeginTouchEvent.asSlice(SHAPE_ID_B_OFFSET, Shape.LAYOUT());

		manifold = new Manifold(memorySegment.asSlice(MANIFOLD_OFFSET, Manifold.LAYOUT()));
	}

	public void set(MemorySegment memorySegment, World world) {
		MemorySegment.copy(memorySegment, 0, b2ContactBeginTouchEvent, 0, LAYOUT.byteSize());
		this.world = world;
	}

	/*
	 * The first shape.
	 */
	public Shape getShapeA() {
		WorldId worldId = world.getWorldId();
		
		Shape shape = Box2D.getShape(Shape.getShapeId(shapeIdA), worldId);
		
		if (shape != null)
			return shape;
		
		return new Shape(shapeIdA, 0L, worldId);
	}

	/**
	 * The second shape.
	 */
	public Shape getShapeB() {
		WorldId worldId = world.getWorldId();
		
		Shape shape = Box2D.getShape(Shape.getShapeId(shapeIdB), worldId);
		
		if (shape != null)
			return shape;
		
		return new Shape(shapeIdB, 0L, worldId);
	}

	public void setWorld(World world) {
		this.world = world;
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

	public MemorySegment memorySegment() {
		return b2ContactBeginTouchEvent;
	}

	public static StructLayout LAYOUT() {
		return LAYOUT;
	}

}
