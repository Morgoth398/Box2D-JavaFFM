package volucris.engine.physics.box2d.contactEvents;

import java.lang.foreign.Arena;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.StructLayout;
import java.lang.invoke.VarHandle;

import org.joml.Vector2f;

import volucris.engine.physics.box2d.Box2D;
import volucris.engine.physics.box2d.math.Vec2;
import volucris.engine.physics.box2d.shape.Shape;
import volucris.engine.physics.box2d.world.World;

import static java.lang.foreign.ValueLayout.*;
import static volucris.engine.utils.FFMUtils.*;

/**
 * A hit touch event is generated when two shapes collide with a speed faster
 * than the hit speed threshold.
 */
public final class ContactHitEvent {

	private static final StructLayout LAYOUT;

	private static final VarHandle APPROACH_SPEED;

	private static final long SHAPE_ID_A_OFFSET;
	private static final long SHAPE_ID_B_OFFSET;
	private static final long POINT_OFFSET;
	private static final long NORMAL_OFFSET;

	private final MemorySegment b2ContactHitEvent;
	
	private final MemorySegment shapeIdA;
	private final MemorySegment shapeIdB;
	
	private final Vec2 point;
	private final Vec2 normal;

	private World world;
	
	static {
		//@formatter:off
		LAYOUT = MemoryLayout.structLayout(
		        Shape.LAYOUT().withName("shapeIdA"),
		        Shape.LAYOUT().withName("shapeIdB"),
		        Vec2.LAYOUT().withName("point"),
		        Vec2.LAYOUT().withName("normal"),
		        JAVA_FLOAT.withName("approachSpeed")
			);
		//@formatter:on

		APPROACH_SPEED = varHandle(LAYOUT, "approachSpeed");

		SHAPE_ID_A_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("shapeIdA"));
		SHAPE_ID_B_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("shapeIdB"));
		POINT_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("point"));
		NORMAL_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("normal"));
	}

	public ContactHitEvent() {
		this(Arena.ofAuto());
	}
	
	public ContactHitEvent(Arena arena) {
		b2ContactHitEvent = arena.allocate(LAYOUT);
		
		shapeIdA = b2ContactHitEvent.asSlice(SHAPE_ID_A_OFFSET, Shape.LAYOUT());
		shapeIdB = b2ContactHitEvent.asSlice(SHAPE_ID_B_OFFSET, Shape.LAYOUT());
		
		point = new Vec2(b2ContactHitEvent.asSlice(POINT_OFFSET, Vec2.LAYOUT()));
		normal = new Vec2(b2ContactHitEvent.asSlice(NORMAL_OFFSET, Vec2.LAYOUT()));
	}

	public ContactHitEvent(MemorySegment memorySegment, World world) {
		this.b2ContactHitEvent = memorySegment;
		this.world = world;
		
		shapeIdA = b2ContactHitEvent.asSlice(SHAPE_ID_A_OFFSET, Shape.LAYOUT());
		shapeIdB = b2ContactHitEvent.asSlice(SHAPE_ID_B_OFFSET, Shape.LAYOUT());
		
		point = new Vec2(b2ContactHitEvent.asSlice(POINT_OFFSET, Vec2.LAYOUT()));
		normal = new Vec2(b2ContactHitEvent.asSlice(NORMAL_OFFSET, Vec2.LAYOUT()));
	}

	public void set(MemorySegment memorySegment, World world) {
		MemorySegment.copy(memorySegment, 0, b2ContactHitEvent, 0, LAYOUT.byteSize());
	}

	public Shape getShapeA() {
		return Box2D.getShape(Shape.getShapeId(shapeIdA), world);
	}

	public Shape getShapeB() {
		return Box2D.getShape(Shape.getShapeId(shapeIdB), world);
	}

	/**
	 * Point where the shapes hit.
	 */
	public Vector2f getPoint(Vector2f vector2f) {
		return point.get(vector2f);
	}

	/**
	 * Point where the shapes hit.
	 */
	public Vector2f getPoint() {
		return getPoint(new Vector2f());
	}

	/**
	 * Normal vector pointing from shape A to shape B.
	 */
	public Vector2f getNormal(Vector2f target) {
		return normal.get(target);
	}

	/**
	 * Normal vector pointing from shape A to shape B.
	 */
	public Vector2f getNormal() {
		return getNormal(new Vector2f());
	}

	/**
	 * The speed the shapes are approaching. Always positive. Typically in meters
	 * per second.
	 */
	public float getApproachSpeed() {
		return (float) APPROACH_SPEED.get(b2ContactHitEvent);
	}

	public void setWorld(World world) {
		this.world = world;
	}
	
	public MemorySegment memorySegment() {
		return b2ContactHitEvent;
	}
	
	public static StructLayout LAYOUT() {
		return LAYOUT;
	}

}
