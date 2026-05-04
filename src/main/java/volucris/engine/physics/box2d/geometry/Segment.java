package volucris.engine.physics.box2d.geometry;

import java.lang.foreign.Arena;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemoryLayout.PathElement;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.SegmentAllocator;
import java.lang.foreign.StructLayout;
import java.lang.invoke.MethodHandle;

import org.joml.Vector2f;

import volucris.engine.physics.box2d.math.AABB;
import volucris.engine.physics.box2d.math.Transform;
import volucris.engine.physics.box2d.math.Vec2;
import volucris.engine.utils.VolucrisRuntimeException;

import static java.lang.foreign.ValueLayout.*;
import static volucris.engine.utils.FFMUtils.*;

/**
 * A line segment with two-sided collision.
 */
public final class Segment {

	private static final StructLayout LAYOUT;

	private static final MethodHandle B2_COMPUTE_SEGMENT_AABB;
	private static final MethodHandle B2_RAY_CAST_SEGMENT;
	private static final MethodHandle B2_SHAPE_CAST_SEGMENT;

	private static final long POINT1_OFFSET;
	private static final long POINT2_OFFSET;

	private final MemorySegment b2Segment;

	private final Vec2 point1;
	private final Vec2 point2;

	static {
		//@formatter:off
		LAYOUT = MemoryLayout.structLayout(
				Vec2.LAYOUT().withName("point1"),
		        Vec2.LAYOUT().withName("point2")
			).withName("b2Segment");
		//@formatter:on

		B2_COMPUTE_SEGMENT_AABB = downcallHandle("b2ComputeSegmentAABB", AABB.LAYOUT(), ADDRESS, Transform.LAYOUT());
		B2_RAY_CAST_SEGMENT = downcallHandle("b2RayCastSegment", CastOutput.LAYOUT(), ADDRESS, ADDRESS);
		B2_SHAPE_CAST_SEGMENT = downcallHandle("b2ShapeCastSegment", CastOutput.LAYOUT(), ADDRESS, ADDRESS);

		POINT1_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("point1"));
		POINT2_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("point2"));
	}

	public Segment() {
		b2Segment = Arena.ofAuto().allocate(LAYOUT);

		point1 = new Vec2(b2Segment.asSlice(POINT1_OFFSET, Vec2.LAYOUT()));
		point2 = new Vec2(b2Segment.asSlice(POINT2_OFFSET, Vec2.LAYOUT()));
	}

	public Segment(MemorySegment memorySegment) {
		b2Segment = memorySegment;

		point1 = new Vec2(b2Segment.asSlice(POINT1_OFFSET, Vec2.LAYOUT()));
		point2 = new Vec2(b2Segment.asSlice(POINT2_OFFSET, Vec2.LAYOUT()));
	}

	public void set(MemorySegment memorySegment) {
		point1.set(memorySegment.asSlice(POINT1_OFFSET, Vec2.LAYOUT()));
		point2.set(memorySegment.asSlice(POINT2_OFFSET, Vec2.LAYOUT()));
	}

	/**
	 * Compute the bounding box of a transformed line segment.
	 */
	public AABB computeSegmentAABB(AABB target, Transform transform) {
		try (Arena arena = Arena.ofConfined()) {
			SegmentAllocator allocator = arena;
			MethodHandle method = B2_COMPUTE_SEGMENT_AABB;
			MemorySegment segment = (MemorySegment) method.invokeExact(allocator, b2Segment, transform.memorySegment());
			target.set(segment);
			return target;
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot compute segment AABB.");
		}
	}

	/**
	 * Compute the bounding box of a transformed line segment.
	 */
	public AABB computeSegmentAABB(Transform transform) {
		return computeSegmentAABB(new AABB(), transform);
	}

	/**
	 * Ray cast versus segment shape in local space.
	 */
	public CastOutput rayCastSegment(CastOutput target, RayCastInput input) {
		try (Arena arena = Arena.ofConfined()) {
			SegmentAllocator allocator = arena;
			MethodHandle method = B2_RAY_CAST_SEGMENT;
			MemorySegment segment = (MemorySegment) method.invokeExact(allocator, input.memorySegment(), b2Segment);
			target.set(segment);
			return target;
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot ray cast segment.");
		}
	}

	/**
	 * Ray cast versus segment shape in local space.
	 */
	public CastOutput rayCastSegment(RayCastInput input) {
		return rayCastSegment(new CastOutput(), input);
	}

	/**
	 * Shape cast versus a line segment. Initial overlap is treated as a miss.
	 */
	public CastOutput shapeCastSegment(CastOutput target, ShapeCastInput input) {
		try (Arena arena = Arena.ofConfined()) {
			SegmentAllocator allocator = arena;
			MethodHandle method = B2_SHAPE_CAST_SEGMENT;
			MemorySegment segment = (MemorySegment) method.invokeExact(allocator, input.memorySegment(), b2Segment);
			target.set(segment);
			return target;
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot shape cast segment.");
		}
	}

	/**
	 * Shape cast versus a line segment. Initial overlap is treated as a miss.
	 */
	public CastOutput shapeCastSegment(ShapeCastInput input) {
		return shapeCastSegment(new CastOutput(), input);
	}

	public Vector2f getPoint1(Vector2f target) {
		return point1.get(target);
	}

	public Vector2f getPoint1() {
		return getPoint1(new Vector2f());
	}

	public void setPoint1(float x, float y) {
		this.point1.set(x, y);
	}

	public void setPoint1(Vector2f point1) {
		this.point1.set(point1);
	}

	public Vector2f getPoint2(Vector2f target) {
		return point2.get(target);
	}

	public Vector2f getPoint2() {
		return getPoint1(new Vector2f());
	}

	public void setPoint2(float x, float y) {
		this.point2.set(x, y);
	}

	public void setPoint2(Vector2f point2) {
		this.point2.set(point2);
	}

	public MemorySegment memorySegment() {
		return b2Segment.asReadOnly();
	}

	public static StructLayout LAYOUT() {
		return LAYOUT;
	}

}
