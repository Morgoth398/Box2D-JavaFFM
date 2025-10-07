package volucris.engine.physics.box2d.geometry;

import java.lang.foreign.Arena;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.SegmentAllocator;
import java.lang.foreign.StructLayout;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;

import org.joml.Vector2f;

import volucris.engine.physics.box2d.math.AABB;
import volucris.engine.physics.box2d.math.Transform;
import volucris.engine.physics.box2d.math.Vec2;
import volucris.engine.utils.VolucrisRuntimeException;

import static java.lang.foreign.ValueLayout.*;
import static volucris.engine.utils.FFMUtils.*;

/**
 * A solid circle.
 */
public final class Circle {

	private static final StructLayout LAYOUT;

	private static final VarHandle RADIUS;

	private static final MethodHandle B2_COMPUTE_CIRCLE_MASS;
	private static final MethodHandle B2_COMPUTE_CIRCLE_AABB;
	private static final MethodHandle B2_POINT_IN_CIRCLE;
	private static final MethodHandle B2_RAY_CAST_CIRCLE;
	private static final MethodHandle B2_SHAPE_CAST_CIRCLE;

	private static final long CENTER_OFFSET;

	private final MemorySegment b2Circle;

	private final Vec2 center;
	private final Vec2 vecTmp;

	static {
		//@formatter:off
		LAYOUT = MemoryLayout.structLayout(
				Vec2.LAYOUT().withName("center"),
		        JAVA_FLOAT.withName("radius")
			).withName("b2Circle");
		//@formatter:on

		RADIUS = varHandle(LAYOUT, "radius");

		B2_COMPUTE_CIRCLE_MASS = downcallHandle("b2ComputeCircleMass", MassData.LAYOUT(), ADDRESS, JAVA_FLOAT);
		B2_COMPUTE_CIRCLE_AABB = downcallHandle("b2ComputeCircleAABB", AABB.LAYOUT(), ADDRESS, Transform.LAYOUT());
		B2_POINT_IN_CIRCLE = downcallHandle("b2PointInCircle", JAVA_BOOLEAN, Vec2.LAYOUT(), ADDRESS);
		B2_RAY_CAST_CIRCLE = downcallHandle("b2RayCastCircle", CastOutput.LAYOUT(), ADDRESS, ADDRESS);
		B2_SHAPE_CAST_CIRCLE = downcallHandle("b2ShapeCastCircle", CastOutput.LAYOUT(), ADDRESS, ADDRESS);

		CENTER_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("center"));
	}

	public Circle(Vector2f position, float radius) {
		this(position.x, position.y, radius);
	}
	
	public Circle(float x, float y, float radius) {
		b2Circle = Arena.ofAuto().allocate(LAYOUT);

		center = new Vec2(b2Circle.asSlice(CENTER_OFFSET, Vec2.LAYOUT()));
		vecTmp = new Vec2();
		
		setCenter(x, y);
		setRadius(radius);
	}

	public Circle() {
		b2Circle = Arena.ofAuto().allocate(LAYOUT);

		center = new Vec2(b2Circle.asSlice(CENTER_OFFSET, Vec2.LAYOUT()));
		vecTmp = new Vec2();
	}
	
	public Circle(MemorySegment memorySegment) {
		b2Circle = memorySegment;

		center = new Vec2(b2Circle.asSlice(CENTER_OFFSET, Vec2.LAYOUT()));
		vecTmp = new Vec2();
	}

	public void set(MemorySegment memorySegment) {
		float radius = (float) RADIUS.get(memorySegment);

		setRadius(radius);

		center.set(memorySegment.asSlice(CENTER_OFFSET, Vec2.LAYOUT()));
	}

	/**
	 * Compute mass properties of a circle.
	 */
	public MassData computeCircleMass(MassData target, float density) {
		try (Arena arena = Arena.ofConfined()) {
			SegmentAllocator allocator = arena;
			MemorySegment segment = (MemorySegment) B2_COMPUTE_CIRCLE_MASS.invokeExact(allocator, b2Circle, density);
			target.set(segment);
			return target;
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot compute circle mass.");
		}
	}

	/**
	 * Compute mass properties of a circle.
	 */
	public MassData computeCircleMass(float density) {
		return computeCircleMass(new MassData(), density);
	}

	/**
	 * Compute the bounding box of a transformed circle.
	 */
	public AABB computeCircleAABB(AABB target, Transform transform) {
		try (Arena arena = Arena.ofConfined()) {
			SegmentAllocator allocator = arena;
			MethodHandle method = B2_COMPUTE_CIRCLE_AABB;
			MemorySegment segment = (MemorySegment) method.invokeExact(allocator, b2Circle, transform.memorySegment());
			target.set(segment);
			return target;
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot compute circle AABB.");
		}
	}

	/**
	 * Compute the bounding box of a transformed circle.
	 */
	public AABB computeCircleAABB(Transform transform) {
		return computeCircleAABB(new AABB(), transform);
	}

	/**
	 * Test a point for overlap with a circle in local space.
	 */
	public boolean pointInCircle(Vector2f point) {
		try {
			vecTmp.set(point);
			return (boolean) B2_POINT_IN_CIRCLE.invokeExact(vecTmp.memorySegment(), b2Circle);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot check if point is in circle.");
		}
	}

	/**
	 * Ray cast versus circle shape in local space. Initial overlap is treated as a
	 * miss.
	 */
	public CastOutput rayCastCircle(CastOutput target, RayCastInput input) {
		try (Arena arena = Arena.ofConfined()) {
			SegmentAllocator allocator = arena;
			MethodHandle method = B2_RAY_CAST_CIRCLE;
			MemorySegment segment = (MemorySegment) method.invokeExact(allocator, input.memorySegment(), b2Circle);
			target.set(segment);
			return target;
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot ray cast circle.");
		}
	}

	/**
	 * Ray cast versus circle shape in local space. Initial overlap is treated as a
	 * miss.
	 */
	public CastOutput rayCastCircle(RayCastInput input) {
		return rayCastCircle(new CastOutput(), input);
	}

	/**
	 * Shape cast versus a circle. Initial overlap is treated as a miss.
	 */
	public CastOutput shapeCastCircle(CastOutput target, ShapeCastInput input) {
		try (Arena arena = Arena.ofConfined()) {
			SegmentAllocator allocator = arena;
			MethodHandle method = B2_SHAPE_CAST_CIRCLE;
			MemorySegment segment = (MemorySegment) method.invokeExact(allocator, input.memorySegment(), b2Circle);
			target.set(segment);
			return target;
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot ray cast circle.");
		}
	}

	/**
	 * Shape cast versus a circle. Initial overlap is treated as a miss.
	 */
	public CastOutput shapeCastCircle(ShapeCastInput input) {
		return shapeCastCircle(new CastOutput(), input);
	}

	public Vector2f getCenter(Vector2f target) {
		return center.get(target);
	}

	public Vector2f getCenter() {
		return getCenter(new Vector2f());
	}

	public void setCenter(float x, float y) {
		this.center.set(x, y);
	}

	public void setCenter(Vector2f center) {
		this.center.set(center);
	}

	public float getRadius() {
		return (float) RADIUS.get(b2Circle);
	}

	public void setRadius(float radius) {
		RADIUS.set(b2Circle, radius);
	}

	public MemorySegment memorySegment() {
		return b2Circle.asReadOnly();
	}

	public static StructLayout LAYOUT() {
		return LAYOUT;
	}

}
