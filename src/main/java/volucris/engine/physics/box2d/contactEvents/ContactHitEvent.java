package volucris.engine.physics.box2d.contactEvents;

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

	private final Vec2 point;
	private final Vec2 normal;

	private Shape shapeA;
	private Shape shapeB;

	private float approachSpeed;

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
		point = new Vec2();
		normal = new Vec2();
	}

	public ContactHitEvent(MemorySegment memorySegment, World world) {
		point = new Vec2();
		point.set(memorySegment.asSlice(POINT_OFFSET, Vec2.LAYOUT()));

		normal = new Vec2();
		normal.set(memorySegment.asSlice(NORMAL_OFFSET, Vec2.LAYOUT()));

		MemorySegment shapeASegment = memorySegment.asSlice(SHAPE_ID_A_OFFSET, Shape.LAYOUT());
		shapeA = Box2D.getShape(Shape.getShapeId(shapeASegment), world);

		MemorySegment shapeBSegment = memorySegment.asSlice(SHAPE_ID_B_OFFSET, Shape.LAYOUT());
		shapeB = Box2D.getShape(Shape.getShapeId(shapeBSegment), world);
	}

	public void set(MemorySegment memorySegment, World world) {
		approachSpeed = (float) APPROACH_SPEED.get(memorySegment);

		point.set(memorySegment.asSlice(POINT_OFFSET, Vec2.LAYOUT()));
		normal.set(memorySegment.asSlice(NORMAL_OFFSET, Vec2.LAYOUT()));

		MemorySegment shapeASegment = memorySegment.asSlice(SHAPE_ID_A_OFFSET, Shape.LAYOUT());
		shapeA = Box2D.getShape(Shape.getShapeId(shapeASegment), world);

		MemorySegment shapeBSegment = memorySegment.asSlice(SHAPE_ID_B_OFFSET, Shape.LAYOUT());
		shapeB = Box2D.getShape(Shape.getShapeId(shapeBSegment), world);
	}

	public Shape getShapeA() {
		return shapeA;
	}

	public Shape getShapeB() {
		return shapeB;
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
		return approachSpeed;
	}

	public static StructLayout LAYOUT() {
		return LAYOUT;
	}

}
