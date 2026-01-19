package volucris.engine.physics.box2d.collision;

import java.lang.foreign.Arena;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.StructLayout;
import java.lang.invoke.VarHandle;

import org.joml.Vector2f;

import volucris.engine.physics.box2d.math.Vec2;

import static java.lang.foreign.ValueLayout.*;
import static volucris.engine.utils.FFMUtils.*;

/**
 * A contact manifold describes the contact points between colliding shapes.
 * <p>
 * Note: Box2D uses speculative collision so some contact points may be
 * separated.
 */
public final class Manifold {

	private static final StructLayout LAYOUT;

	private static final VarHandle ROLLING_IMPULSE;
	private static final VarHandle POINT_COUNT;

	private static final long NORMAL_OFFSET;
	private static final long POINT1_OFFSET;
	private static final long POINT2_OFFSET;

	private final MemorySegment b2Manifold;

	private final ManifoldPoint point1;
	private final ManifoldPoint point2;

	private final Vec2 normal;

	static {
		//@formatter:off
		LAYOUT = MemoryLayout.structLayout(
		        Vec2.LAYOUT().withName("normal"),
		        JAVA_FLOAT.withName("rollingImpulse"),
		        MemoryLayout.sequenceLayout(2, ManifoldPoint.LAYOUT()).withName("points"),
		        JAVA_INT.withName("pointCount")
			);
		//@formatter:on

		ROLLING_IMPULSE = varHandle(LAYOUT, "rollingImpulse");
		POINT_COUNT = varHandle(LAYOUT, "pointCount");

		NORMAL_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("normal"));
		POINT1_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("points"), PathElement.sequenceElement(0));
		POINT2_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("points"), PathElement.sequenceElement(1));
	}

	public Manifold() {
		this(Arena.ofAuto());
	}

	public Manifold(Arena arena) {
		b2Manifold = arena.allocate(LAYOUT);

		normal = new Vec2(b2Manifold.asSlice(NORMAL_OFFSET, Vec2.LAYOUT()));
		point1 = new ManifoldPoint(b2Manifold.asSlice(POINT1_OFFSET, ManifoldPoint.LAYOUT()));
		point2 = new ManifoldPoint(b2Manifold.asSlice(POINT2_OFFSET, ManifoldPoint.LAYOUT()));
	}

	public Manifold(MemorySegment memorySegment) {
		b2Manifold = memorySegment;

		normal = new Vec2(b2Manifold.asSlice(NORMAL_OFFSET, Vec2.LAYOUT()));
		point1 = new ManifoldPoint(b2Manifold.asSlice(POINT1_OFFSET, ManifoldPoint.LAYOUT()));
		point2 = new ManifoldPoint(b2Manifold.asSlice(POINT2_OFFSET, ManifoldPoint.LAYOUT()));
	}

	public void set(MemorySegment memorySegment) {
		MemorySegment.copy(memorySegment, 0, b2Manifold, 0, LAYOUT.byteSize());
	}

	/**
	 * Call only if {@link #getPointCount()} > 0.
	 * 
	 * @return
	 */
	public ManifoldPoint getPoint1() {
		return point1;
	}

	/**
	 * Call only if {@link #getPointCount()} > 1.
	 * 
	 * @return
	 */
	public ManifoldPoint getPoint2() {
		return point2;
	}

	/**
	 * The unit normal vector in world space, points from shape A to bodyB.
	 */
	public Vector2f getNormal(Vector2f target) {
		return normal.get(target);
	}

	/**
	 * The unit normal vector in world space, points from shape A to bodyB.
	 */
	public Vector2f getNormal() {
		return getNormal(new Vector2f());
	}

	/**
	 * The number of contacts points, will be 0, 1, or 2.
	 */
	public int getPointCount() {
		return (int) POINT_COUNT.get(b2Manifold);
	}

	/**
	 * Angular impulse applied for rolling resistance. N * m * s = kg * m^2 / s.
	 */
	public float getRollingImpulse() {
		return (float) ROLLING_IMPULSE.get(b2Manifold);
	}

	public MemorySegment memorySegment() {
		return b2Manifold;
	}

	public static StructLayout LAYOUT() {
		return LAYOUT;
	}

}
