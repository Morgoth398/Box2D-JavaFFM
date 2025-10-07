package volucris.engine.physics.box2d.world;

import java.lang.foreign.Arena;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.StructLayout;
import java.lang.invoke.VarHandle;

import org.joml.Vector2f;

import volucris.engine.physics.box2d.Box2D;
import volucris.engine.physics.box2d.math.Vec2;
import volucris.engine.physics.box2d.shape.Shape;

import static java.lang.foreign.ValueLayout.*;
import static volucris.engine.utils.FFMUtils.*;

public final class RayResult {

	private static final StructLayout LAYOUT;

	private static final VarHandle FRACTION;
	private static final VarHandle NODE_VISITS;
	private static final VarHandle LEAF_VISITS;
	private static final VarHandle HIT;

	private static final long SHAPE_ID_OFFSET;
	private static final long POINT_OFFSET;
	private static final long NORMAL_OFFSET;

	private final MemorySegment b2RayResult;

	private final Vec2 point;
	private final Vec2 normal;

	private Shape shape;

	static {
		//@formatter:off
		LAYOUT = MemoryLayout.structLayout(
		        Shape.LAYOUT().withName("shapeId"),
		        Vec2.LAYOUT().withName("point"),
		        Vec2.LAYOUT().withName("normal"),
		        JAVA_FLOAT.withName("fraction"),
		        JAVA_INT.withName("nodeVisits"),
		        JAVA_INT.withName("leafVisits"),
		        JAVA_BOOLEAN.withName("hit"),
		        MemoryLayout.paddingLayout(3)
			).withName("b2RayResult");
		//@formatter:on

		FRACTION = varHandle(LAYOUT, "fraction");
		NODE_VISITS = varHandle(LAYOUT, "nodeVisits");
		LEAF_VISITS = varHandle(LAYOUT, "leafVisits");
		HIT = varHandle(LAYOUT, "hit");

		SHAPE_ID_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("shapeId"));
		POINT_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("point"));
		NORMAL_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("normal"));
	}

	public RayResult() {
		b2RayResult = Arena.ofAuto().allocate(LAYOUT);

		point = new Vec2(b2RayResult.asSlice(POINT_OFFSET, Vec2.LAYOUT()));
		normal = new Vec2(b2RayResult.asSlice(NORMAL_OFFSET, Vec2.LAYOUT()));
	}

	public RayResult(MemorySegment memorySegment, World world) {
		b2RayResult = memorySegment;

		point = new Vec2(b2RayResult.asSlice(POINT_OFFSET, Vec2.LAYOUT()));
		normal = new Vec2(b2RayResult.asSlice(NORMAL_OFFSET, Vec2.LAYOUT()));

		shape = Box2D.getShape(Shape.getShapeId(memorySegment.asSlice(SHAPE_ID_OFFSET, Shape.LAYOUT())), world);
	}

	public void set(MemorySegment memorySegment, World world) {
		point.set(b2RayResult.asSlice(POINT_OFFSET, Vec2.LAYOUT()));
		normal.set(b2RayResult.asSlice(NORMAL_OFFSET, Vec2.LAYOUT()));

		shape = Box2D.getShape(Shape.getShapeId(memorySegment.asSlice(SHAPE_ID_OFFSET, Shape.LAYOUT())), world);
	}

	public Vector2f getPoint(Vector2f target) {
		return point.get(target);
	}

	public Vector2f getPoint() {
		return getPoint(new Vector2f());
	}

	public Vector2f getNormal(Vector2f target) {
		return normal.get(target);
	}

	public Vector2f getNormal() {
		return getNormal(new Vector2f());
	}

	public Shape getShape() {
		return shape;
	}

	public float getFraction() {
		return (float) FRACTION.get(b2RayResult);
	}

	public int getNodeVisits() {
		return (int) NODE_VISITS.get(b2RayResult);
	}

	public int getLeafVisits() {
		return (int) LEAF_VISITS.get(b2RayResult);
	}

	public boolean hit() {
		return (boolean) HIT.get(b2RayResult);
	}

	public MemorySegment memorySegment() {
		return b2RayResult;
	}

	public static StructLayout LAYOUT() {
		return LAYOUT;
	}

}
