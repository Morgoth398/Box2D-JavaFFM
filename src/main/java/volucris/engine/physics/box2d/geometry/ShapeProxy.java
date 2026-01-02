package volucris.engine.physics.box2d.geometry;

import java.lang.foreign.Arena;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.SequenceLayout;
import java.lang.foreign.StructLayout;
import java.lang.invoke.VarHandle;

import org.joml.Vector2f;

import volucris.engine.physics.box2d.math.Vec2;

import static java.lang.foreign.ValueLayout.*;
import static volucris.engine.utils.FFMUtils.*;

/**
 * A distance proxy is used by the GJK algorithm.
 * <p>
 * It encapsulates any shape. You can provide between 1 and 8 vertices and a
 * radius.
 * 
 */
public final class ShapeProxy {

	private static final StructLayout LAYOUT;

	private static final VarHandle COUNT;
	private static final VarHandle RADIUS;

	private static final long[] POINT_OFFSETS;

	private final MemorySegment b2ShapeProxy;

	private final Vec2[] points;

	static {
		//@formatter:off
		LAYOUT = MemoryLayout.structLayout(
				MemoryLayout.sequenceLayout(8, Vec2.LAYOUT()).withName("points"),
				JAVA_INT.withName("count"),
				JAVA_FLOAT.withName("radius")
			).withName("b2ShapeProxy");
		//@formatter:on

		COUNT = varHandle(LAYOUT, "count");
		RADIUS = varHandle(LAYOUT, "radius");

		SequenceLayout POINTS_SEQUENCE = (SequenceLayout) LAYOUT.select(PathElement.groupElement("points"));
		POINT_OFFSETS = new long[8];
		for (int i = 0; i < 8; i++) {
			POINT_OFFSETS[i] = POINTS_SEQUENCE.byteOffset(PathElement.sequenceElement(i));
		}
	}

	public ShapeProxy() {
		this(Arena.ofAuto());
	}
	
	public ShapeProxy(Arena arena) {
		b2ShapeProxy = arena.allocate(LAYOUT);

		points = new Vec2[8];
		for (int i = 0; i < 8; i++)
			points[i] = new Vec2(b2ShapeProxy.asSlice(POINT_OFFSETS[i], Vec2.LAYOUT()));
	}

	public ShapeProxy(MemorySegment memorySegment) {
		b2ShapeProxy = memorySegment;

		points = new Vec2[8];
		for (int i = 0; i < 8; i++)
			points[i] = new Vec2(b2ShapeProxy.asSlice(POINT_OFFSETS[i], Vec2.LAYOUT()));
	}

	public void set(MemorySegment memorySegment) {
		MemorySegment.copy(memorySegment, 0L, b2ShapeProxy, 0L, LAYOUT.byteSize());
	}

	public float getPoints(Vector2f[] target) {
		int count = getCount();

		for (int i = 0; i < count; i++) {
			Vector2f vector = target[i] == null ? new Vector2f() : target[i];
			points[i].get(vector);
			target[i] = vector;
		}

		return count;
	}

	/**
	 * Maximum are 8 points.
	 * 
	 * @param points The points. Must be greater than 0.
	 * @param radius The external radius of the point cloud. May be zero.
	 */
	public void setPoints(Vector2f[] points, float radius) {
		int count = points.length > 8 ? 8 : points.length;

		for (int i = 0; i < count; i++) {
			this.points[i].set(points[i]);
		}

		COUNT.set(b2ShapeProxy, count);
		RADIUS.set(b2ShapeProxy, radius);
	}

	public int getCount() {
		return (int) COUNT.get(b2ShapeProxy);
	}

	public float getRadius() {
		return (float) RADIUS.get(b2ShapeProxy);
	}

	public MemorySegment memorySegment() {
		return b2ShapeProxy;
	}

	public static StructLayout LAYOUT() {
		return LAYOUT;
	}

}
