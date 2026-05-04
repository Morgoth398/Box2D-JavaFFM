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
 * A solid capsule can be viewed as two semicircles connected by a rectangle.
 */
public final class Capsule {

	private static final StructLayout LAYOUT;

	private static final VarHandle RADIUS;

	private static final MethodHandle B2_COMPUTE_CAPSULE_MASS;
	private static final MethodHandle B2_COMPUTE_CAPSULE_AABB;
	private static final MethodHandle B2_POINT_IN_CAPSULE;
	private static final MethodHandle B2_RAY_CAST_CAPSULE;
	private static final MethodHandle B2_SHAPE_CAST_CAPSULE;

	private static final long CENTER1_OFFSET;
	private static final long CENTER2_OFFSET;

	private final MemorySegment b2Capsule;

	private final Vec2 center1;
	private final Vec2 center2;

	private final Vec2 vecTmp;

	static {
		//@formatter:off
		LAYOUT = MemoryLayout.structLayout(
				Vec2.LAYOUT().withName("center1"),
		        Vec2.LAYOUT().withName("center2"),
		        JAVA_FLOAT.withName("radius")
			).withName("b2Capsule");
		//@formatter:on

		RADIUS = varHandle(LAYOUT, "radius");

		B2_COMPUTE_CAPSULE_MASS = downcallHandle("b2ComputeCapsuleMass", MassData.LAYOUT(), ADDRESS, JAVA_FLOAT);
		B2_COMPUTE_CAPSULE_AABB = downcallHandle("b2ComputeCapsuleAABB", AABB.LAYOUT(), ADDRESS, Transform.LAYOUT());
		B2_POINT_IN_CAPSULE = downcallHandle("b2PointInCapsule", JAVA_BOOLEAN, Vec2.LAYOUT(), ADDRESS);
		B2_RAY_CAST_CAPSULE = downcallHandle("b2RayCastCapsule", CastOutput.LAYOUT(), ADDRESS, ADDRESS);
		B2_SHAPE_CAST_CAPSULE = downcallHandle("b2ShapeCastCapsule", CastOutput.LAYOUT(), ADDRESS, ADDRESS);

		CENTER1_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("center1"));
		CENTER2_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("center2"));
	}

	public Capsule(Vector2f center1, Vector2f center2, float radius) {
		this(center1.x, center1.y, center2.x, center2.y, radius);
	}
	
	public Capsule(float x1, float y1, float x2, float y2, float radius) {
		b2Capsule = Arena.ofAuto().allocate(LAYOUT);

		center1 = new Vec2(b2Capsule.asSlice(CENTER1_OFFSET, Vec2.LAYOUT()));
		center2 = new Vec2(b2Capsule.asSlice(CENTER2_OFFSET, Vec2.LAYOUT()));

		vecTmp = new Vec2();
		
		setCenter1(x1, y1);
		setCenter2(x2, y2);
		setRadius(radius);
	}
	
	public Capsule() {
		b2Capsule = Arena.ofAuto().allocate(LAYOUT);

		center1 = new Vec2(b2Capsule.asSlice(CENTER1_OFFSET, Vec2.LAYOUT()));
		center2 = new Vec2(b2Capsule.asSlice(CENTER2_OFFSET, Vec2.LAYOUT()));

		vecTmp = new Vec2();
	}

	public Capsule(MemorySegment memorySegment) {
		b2Capsule = memorySegment;

		center1 = new Vec2(b2Capsule.asSlice(CENTER1_OFFSET, Vec2.LAYOUT()));
		center2 = new Vec2(b2Capsule.asSlice(CENTER2_OFFSET, Vec2.LAYOUT()));

		vecTmp = new Vec2();
	}

	public void set(MemorySegment memorySegment) {
		float radius = (float) RADIUS.get(memorySegment);

		setRadius(radius);

		center1.set(memorySegment.asSlice(CENTER1_OFFSET, Vec2.LAYOUT()));
		center2.set(memorySegment.asSlice(CENTER2_OFFSET, Vec2.LAYOUT()));
	}

	/**
	 * Compute mass properties of a capsule.
	 */
	public MassData computeCapsuleMass(MassData target, float density) {
		try (Arena arena = Arena.ofConfined()) {
			SegmentAllocator allocator = arena;
			MemorySegment segment = (MemorySegment) B2_COMPUTE_CAPSULE_MASS.invokeExact(allocator, b2Capsule, density);
			target.set(segment);
			return target;
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot compute capsule mass.");
		}
	}

	/**
	 * Compute mass properties of a capsule.
	 */
	public MassData computeCapsuleMass(float density) {
		return computeCapsuleMass(new MassData(), density);
	}

	/**
	 * Compute the bounding box of a transformed capsule.
	 */
	public AABB computeCapsuleAABB(AABB target, Transform transform) {
		try (Arena arena = Arena.ofConfined()) {
			SegmentAllocator allocator = arena;
			MethodHandle method = B2_COMPUTE_CAPSULE_AABB;
			MemorySegment segment = (MemorySegment) method.invokeExact(allocator, b2Capsule, transform.memorySegment());
			target.set(segment);
			return target;
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot compute capsule AABB.");
		}
	}

	/**
	 * Compute the bounding box of a transformed capsule.
	 */
	public AABB computeCapsuleAABB(Transform transform) {
		return computeCapsuleAABB(new AABB(), transform);
	}

	/**
	 * Test a point for overlap with a capsule in local space.
	 */
	public boolean pointInCapsule(Vector2f point) {
		try {
			vecTmp.set(point);
			return (boolean) B2_POINT_IN_CAPSULE.invokeExact(vecTmp.memorySegment(), b2Capsule);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot check if point is in capsule.");
		}
	}

	/**
	 * Ray cast versus capsule shape in local space. Initial overlap is treated as a
	 * miss.
	 */
	public CastOutput rayCastCapsule(CastOutput target, RayCastInput input) {
		try (Arena arena = Arena.ofConfined()) {
			SegmentAllocator allocator = arena;
			MethodHandle method = B2_RAY_CAST_CAPSULE;
			MemorySegment segment = (MemorySegment) method.invokeExact(allocator, input.memorySegment(), b2Capsule);
			target.set(segment);
			return target;
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot ray cast capsule.");
		}
	}

	/**
	 * Ray cast versus capsule shape in local space. Initial overlap is treated as a
	 * miss.
	 */
	public CastOutput rayCastCapsule(RayCastInput input) {
		return rayCastCapsule(new CastOutput(), input);
	}

	/**
	 * Shape cast versus a capsule. Initial overlap is treated as a miss.
	 */
	public CastOutput shapeCastCapsule(CastOutput target, ShapeCastInput input) {
		try (Arena arena = Arena.ofConfined()) {
			SegmentAllocator allocator = arena;
			MethodHandle method = B2_SHAPE_CAST_CAPSULE;
			MemorySegment segment = (MemorySegment) method.invokeExact(allocator, input.memorySegment(), b2Capsule);
			target.set(segment);
			return target;
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot shape cast capsule.");
		}
	}

	/**
	 * Shape cast versus a capsule. Initial overlap is treated as a miss.
	 */
	public CastOutput shapeCastCapsule(ShapeCastInput input) {
		return shapeCastCapsule(new CastOutput(), input);
	}

	/**
	 * Local center of the first semicircle.
	 */
	public Vector2f getCenter1(Vector2f target) {
		return center1.get(target);
	}

	/**
	 * Local center of the first semicircle.
	 */
	public Vector2f getCenter1() {
		return getCenter1(new Vector2f());
	}

	/**
	 * Local center of the first semicircle.
	 */
	public void setCenter1(float x, float y) {
		this.center1.set(x, y);
	}

	/**
	 * Local center of the first semicircle.
	 */
	public void setCenter1(Vector2f center1) {
		this.center1.set(center1);
	}

	/**
	 * Local center of the second semicircle.
	 */
	public Vector2f getCenter2(Vector2f target) {
		return center2.get(target);
	}

	/**
	 * Local center of the second semicircle.
	 */
	public Vector2f getCenter2() {
		return getCenter2(new Vector2f());
	}

	/**
	 * Local center of the second semicircle.
	 */
	public void setCenter2(float x, float y) {
		this.center2.set(x, y);
	}

	/**
	 * Local center of the second semicircle.
	 */
	public void setCenter2(Vector2f center2) {
		this.center2.set(center2);
	}

	/**
	 * The radius of the semicircles.
	 */
	public float getRadius() {
		return (float) RADIUS.get(b2Capsule);
	}

	/**
	 * The radius of the semicircles.
	 */
	public void setRadius(float radius) {
		RADIUS.set(b2Capsule, radius);
	}

	public MemorySegment memorySegment() {
		return b2Capsule.asReadOnly();
	}

	public static StructLayout LAYOUT() {
		return LAYOUT;
	}
}
