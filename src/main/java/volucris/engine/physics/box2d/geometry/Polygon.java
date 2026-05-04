package volucris.engine.physics.box2d.geometry;

import java.lang.foreign.Arena;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.StructLayout;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;

import org.joml.Vector2f;

import volucris.engine.physics.box2d.math.AABB;
import volucris.engine.physics.box2d.math.Rot;
import volucris.engine.physics.box2d.math.Transform;
import volucris.engine.physics.box2d.math.Vec2;
import volucris.engine.utils.VolucrisRuntimeException;

import static java.lang.foreign.ValueLayout.*;
import static volucris.engine.utils.FFMUtils.*;

/**
 * A solid convex polygon.
 * <p>
 * It is assumed that the interior of the polygon is to the left of each edge.
 * Polygons have a maximum number of vertices equal to 8. In most cases you
 * should not need many vertices for a convex polygon.
 */
public final class Polygon {

	private static final StructLayout LAYOUT;

	private static final MemoryLayout VERTICES_LAYOUT;
	private static final MemoryLayout NORMALS_LAYOUT;

	private static final VarHandle COUNT;
	private static final VarHandle RADIUS;

	private static final MethodHandle B2_MAKE_POLYGON;
	private static final MethodHandle B2_MAKE_OFFSET_POLYGON;
	private static final MethodHandle B2_MAKE_OFFSET_ROUNDED_POLYGON;
	private static final MethodHandle B2_MAKE_SQUARE;
	private static final MethodHandle B2_MAKE_BOX;
	private static final MethodHandle B2_MAKE_ROUNDED_BOX;
	private static final MethodHandle B2_MAKE_OFFSET_BOX;
	private static final MethodHandle B2_MAKE_OFFSET_ROUNDED_BOX;
	private static final MethodHandle B2_TRANSFORM_POLYGON;
	private static final MethodHandle B2_COMPUTE_POLYGON_MASS;
	private static final MethodHandle B2_COMPUTE_POLYGON_AABB;
	private static final MethodHandle B2_POINT_IN_POLYGON;
	private static final MethodHandle B2_RAY_CAST_POLYGON;
	private static final MethodHandle B2_SHAPE_CAST_POLYGON;

	private static final long VERTICES_OFFSET;
	private static final long NORMALS_OFFSET;
	private static final long CENTROID_OFFSET;

	private static final Vec2 VEC_TMP;
	private static final Rot ROT_TMP;

	private final MemorySegment b2Polygon;
	private final MemorySegment vertices;
	private final MemorySegment normals;

	private final Vec2 centroid;

	private Vec2 vecTmp;

	static {
		//@formatter:off
		LAYOUT = MemoryLayout.structLayout(
				MemoryLayout.sequenceLayout(8, Vec2.LAYOUT()).withName("vertices"),
		        MemoryLayout.sequenceLayout(8, Vec2.LAYOUT()).withName("normals"),
		        Vec2.LAYOUT().withName("centroid"),
		        JAVA_FLOAT.withName("radius"),
		        JAVA_INT.withName("count")
			).withName("b2Polygon");
		
		VERTICES_LAYOUT = LAYOUT.select(PathElement.groupElement("vertices"));
		NORMALS_LAYOUT = LAYOUT.select(PathElement.groupElement("normals"));
		
		COUNT = varHandle(LAYOUT, "count");
		RADIUS = varHandle(LAYOUT, "radius");
		
		B2_MAKE_POLYGON = downcallHandle("b2MakePolygon", LAYOUT, ADDRESS, JAVA_FLOAT);
		B2_MAKE_OFFSET_POLYGON = downcallHandle("b2MakeOffsetPolygon", LAYOUT, ADDRESS, Vec2.LAYOUT(), Rot.LAYOUT());
		B2_MAKE_OFFSET_ROUNDED_POLYGON = downcallHandle("b2MakeOffsetRoundedPolygon", LAYOUT, ADDRESS, Vec2.LAYOUT(), Rot.LAYOUT(), JAVA_FLOAT);
		B2_MAKE_SQUARE = downcallHandle("b2MakeSquare", LAYOUT, JAVA_FLOAT);
		B2_MAKE_BOX = downcallHandle("b2MakeBox", LAYOUT, JAVA_FLOAT, JAVA_FLOAT);
		B2_MAKE_ROUNDED_BOX = downcallHandle("b2MakeRoundedBox", LAYOUT, JAVA_FLOAT, JAVA_FLOAT, JAVA_FLOAT);
		B2_MAKE_OFFSET_BOX = downcallHandle("b2MakeOffsetBox", LAYOUT, JAVA_FLOAT, JAVA_FLOAT, Vec2.LAYOUT(), Rot.LAYOUT());
		B2_MAKE_OFFSET_ROUNDED_BOX = downcallHandle("b2MakeOffsetRoundedBox", LAYOUT, JAVA_FLOAT, JAVA_FLOAT, Vec2.LAYOUT(), Rot.LAYOUT(), JAVA_FLOAT);
		B2_TRANSFORM_POLYGON = downcallHandle("b2TransformPolygon", LAYOUT, Transform.LAYOUT(), ADDRESS);	
		B2_COMPUTE_POLYGON_MASS = downcallHandle("b2ComputePolygonMass", MassData.LAYOUT(), ADDRESS, JAVA_FLOAT);
		B2_COMPUTE_POLYGON_AABB = downcallHandle("b2ComputePolygonAABB", AABB.LAYOUT(), ADDRESS, Transform.LAYOUT());
		B2_POINT_IN_POLYGON = downcallHandle("b2PointInPolygon", JAVA_BOOLEAN, Vec2.LAYOUT(), ADDRESS);
		B2_RAY_CAST_POLYGON = downcallHandle("b2RayCastPolygon", LAYOUT, CastOutput.LAYOUT(), ADDRESS, ADDRESS);
		B2_SHAPE_CAST_POLYGON = downcallHandle("b2ShapeCastPolygon", LAYOUT, CastOutput.LAYOUT(), ADDRESS, ADDRESS);
		
		VERTICES_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("vertices"));
		NORMALS_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("normals"));
		CENTROID_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("centroid"));
		//@formatter:on

		VEC_TMP = new Vec2();
		ROT_TMP = new Rot();
	}

	public Polygon() {
		this(Arena.ofAuto());
	}

	public Polygon(Arena arena) {
		b2Polygon = arena.allocate(LAYOUT);

		vertices = b2Polygon.asSlice(VERTICES_OFFSET, VERTICES_LAYOUT);
		normals = b2Polygon.asSlice(NORMALS_OFFSET, NORMALS_LAYOUT);

		centroid = new Vec2(b2Polygon.asSlice(CENTROID_OFFSET, Vec2.LAYOUT()));

		vecTmp = new Vec2(arena);
	}

	public Polygon(MemorySegment memorySegment) {
		b2Polygon = memorySegment;

		vertices = b2Polygon.asSlice(VERTICES_OFFSET, VERTICES_LAYOUT);
		normals = b2Polygon.asSlice(NORMALS_OFFSET, NORMALS_LAYOUT);

		centroid = new Vec2(b2Polygon.asSlice(CENTROID_OFFSET, Vec2.LAYOUT()));

		vecTmp = new Vec2();
	}

	public void set(MemorySegment memorySegment) {
		MemorySegment.copy(memorySegment, 0L, b2Polygon, 0L, LAYOUT.byteSize());
	}

	/**
	 * Transform a polygon. This is useful for transferring a shape from one body to
	 * another.
	 */
	public Polygon transformPolygon(Transform transform) {
		try {
			MemorySegment transformAddr = transform.memorySegment();
			MethodHandle method = B2_TRANSFORM_POLYGON;
			MemorySegment segment = (MemorySegment) method.invoke(Arena.ofAuto(), transformAddr, b2Polygon);
			return new Polygon(segment);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot transform polygon.");
		}
	}

	/**
	 * Compute mass properties of a polygon.
	 */
	public MassData computePolygonMass(MassData target, float density) {
		try (Arena arena = Arena.ofConfined()) {
			MemorySegment segment = (MemorySegment) B2_COMPUTE_POLYGON_MASS.invoke(arena, b2Polygon, density);
			target.set(segment);
			return target;
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot compute polygon mass.");
		}
	}

	/**
	 * Compute mass properties of a polygon.
	 */
	public MassData computePolygonMass(float density) {
		return computePolygonMass(new MassData(), density);
	}

	/**
	 * Compute the bounding box of a transformed polygon.
	 */
	public AABB computePolygonAABB(AABB target, Transform transform) {
		try (Arena arena = Arena.ofConfined()) {
			MethodHandle method = B2_COMPUTE_POLYGON_AABB;
			MemorySegment segment = (MemorySegment) method.invoke(arena, b2Polygon, transform.memorySegment());
			target.set(segment);
			return target;
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot compute polygon AABB.");
		}
	}

	/**
	 * Compute the bounding box of a transformed polygon.
	 */
	public AABB computePolygonAABB(Transform transform) {
		return computePolygonAABB(new AABB(), transform);
	}

	/**
	 * Test a point for overlap with a convex polygon in local space.
	 */
	public boolean pointInPolygon(Vector2f point) {
		try {
			vecTmp.set(point);
			return (boolean) B2_POINT_IN_POLYGON.invokeExact(vecTmp.memorySegment(), b2Polygon);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot check if point is in polygon.");
		}
	}

	/**
	 * Ray cast versus polygon shape in local space. Initial overlap is treated as a
	 * miss.
	 */
	public CastOutput rayCastPolygon(CastOutput target, RayCastInput input) {
		try (Arena arena = Arena.ofConfined()) {
			MemorySegment inputAddr = input.memorySegment();
			MemorySegment segment = (MemorySegment) B2_RAY_CAST_POLYGON.invoke(arena, inputAddr, b2Polygon);
			target.set(segment);
			return target;
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot ray cast polygon.");
		}
	}

	/**
	 * Ray cast versus polygon shape in local space. Initial overlap is treated as a
	 * miss.
	 */
	public CastOutput rayCastPolygon(RayCastInput input) {
		return rayCastPolygon(new CastOutput(), input);
	}

	/**
	 * Shape cast versus a convex polygon. Initial overlap is treated as a miss.
	 */
	public CastOutput shapeCastPolygon(CastOutput target, ShapeCastInput input) {
		try (Arena arena = Arena.ofConfined()) {
			MemorySegment inputAddr = input.memorySegment();
			MemorySegment segment = (MemorySegment) B2_SHAPE_CAST_POLYGON.invoke(arena, inputAddr, b2Polygon);
			target.set(segment);
			return target;
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot ray cast circle.");
		}
	}

	/**
	 * Shape cast versus a convex polygon. Initial overlap is treated as a miss.
	 */
	public CastOutput shapeCastPolygon(ShapeCastInput input) {
		return shapeCastPolygon(new CastOutput(), input);
	}

	public int getVertexCount() {
		return (int) COUNT.get(b2Polygon);
	}

	/**
	 * The external radius for rounded polygons.
	 */
	public float getRadius() {
		return (float) RADIUS.get(b2Polygon);
	}

	public int getVertices(Vector2f[] target) {
		int vertexCount = getVertexCount();
		int count = target.length < vertexCount ? target.length : vertexCount;

		for (int i = 0; i < count; i++) {
			long offset = i * Vec2.LAYOUT().byteSize();
			MemorySegment.copy(vertices, offset, vecTmp.memorySegment(), 0, Vec2.LAYOUT().byteSize());
			Vector2f targetVec = target[i];
			if (targetVec == null)
				target[i] = vecTmp.get();
			else
				target[i] = vecTmp.get(targetVec);
		}
		return count;
	}

	public int getNormals(Vector2f[] target) {
		int normalsCount = getVertexCount();
		int count = target.length < normalsCount ? target.length : normalsCount;

		for (int i = 0; i < count; i++) {
			long offset = i * Vec2.LAYOUT().byteSize();
			MemorySegment.copy(normals, offset, vecTmp.memorySegment(), 0, Vec2.LAYOUT().byteSize());
			Vector2f targetVec = target[i];
			if (targetVec == null)
				target[i] = vecTmp.get();
			else
				target[i] = vecTmp.get(targetVec);
		}
		return count;
	}

	/**
	 * The centroid of the polygon
	 */
	public Vector2f getCentroid(Vector2f target) {
		return centroid.get(target);
	}

	/**
	 * The centroid of the polygon
	 */
	public Vector2f getCentroid() {
		return getCentroid(new Vector2f());
	}

	public MemorySegment memorySegment() {
		return b2Polygon.asReadOnly();
	}

	/**
	 * Make a convex polygon from a convex hull.
	 */
	public static Polygon makePolygon(Polygon target, Hull hull, float radius) {
		try (Arena arena = Arena.ofConfined()) {
			MemorySegment hullAddr = hull.memorySegment();
			MemorySegment segment = (MemorySegment) B2_MAKE_POLYGON.invoke(arena, hullAddr, radius);
			target.set(segment);
			return target;
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot make polygon.");
		}
	}

	/**
	 * Make a convex polygon from a convex hull.
	 */
	public static Polygon makePolygon(Arena arena, Hull hull, float radius) {
		return makePolygon(new Polygon(arena), hull, radius);
	}

	/**
	 * Make a convex polygon from a convex hull.
	 */
	public static Polygon makePolygon(Hull hull, float radius) {
		return makePolygon(new Polygon(), hull, radius);
	}

	/**
	 * Make an offset convex polygon from a convex hull.
	 */
	public static Polygon makeOffsetPolygon(Hull hull, Vector2f position, float rotation) {
		return makeOffsetPolygon(new Polygon(), hull, position, rotation);
	}

	/**
	 * Make an offset convex polygon from a convex hull.
	 */
	public static Polygon makeOffsetPolygon(Arena arena, Hull hull, Vector2f position, float rotation) {
		return makeOffsetPolygon(new Polygon(arena), hull, position, rotation);
	}

	/**
	 * Make an offset convex polygon from a convex hull.
	 */
	public static Polygon makeOffsetPolygon(Polygon target, Hull hull, Vector2f position, float rotation) {
		try (Arena arena = Arena.ofConfined()) {

			VEC_TMP.set(position);
			ROT_TMP.setAngleRadians(rotation);

			MemorySegment hullAddr = hull.memorySegment();
			MemorySegment positionAddr = VEC_TMP.memorySegment();
			MemorySegment rotAddr = ROT_TMP.memorySegment();
			MethodHandle method = B2_MAKE_OFFSET_POLYGON;
			MemorySegment segment = (MemorySegment) method.invoke(arena, hullAddr, positionAddr, rotAddr);
			target.set(segment);
			return target;
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot make offset polygon.");
		}
	}

	/**
	 * Make an offset convex polygon from a convex hull.
	 */
	public static Polygon makeOffsetRoundedPolygon(Arena arena, Hull hull, Vector2f position, float rotation,
			float radius) {
		return makeOffsetRoundedPolygon(new Polygon(arena), hull, position, rotation, radius);
	}

	/**
	 * Make an offset convex polygon from a convex hull.
	 */
	public static Polygon makeOffsetRoundedPolygon(Hull hull, Vector2f position, float rotation, float radius) {
		return makeOffsetRoundedPolygon(new Polygon(), hull, position, rotation, radius);
	}

	/**
	 * Make an offset convex polygon from a convex hull.
	 */
	public static Polygon makeOffsetRoundedPolygon(Polygon target, Hull hull, Vector2f position, float rotation,
			float radius) {
		try (Arena arena = Arena.ofConfined()) {

			VEC_TMP.set(position);
			ROT_TMP.setAngleRadians(rotation);

			MemorySegment hullAddr = hull.memorySegment();
			MemorySegment posAddr = VEC_TMP.memorySegment();
			MemorySegment rotAddr = ROT_TMP.memorySegment();
			MethodHandle method = B2_MAKE_OFFSET_ROUNDED_POLYGON;
			MemorySegment segment = (MemorySegment) method.invoke(arena, hullAddr, posAddr, rotAddr, radius);
			target.set(segment);
			return target;
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot make offset rounded polygon.");
		}
	}

	/**
	 * Make a square polygon, bypassing the need for a convex hull.
	 */
	public static Polygon makeSquare(Polygon target, float halfWidth) {
		try (Arena arena = Arena.ofConfined()) {
			MemorySegment segment = (MemorySegment) B2_MAKE_SQUARE.invoke(arena, halfWidth);
			target.set(segment);
			return target;
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot make square.");
		}
	}

	/**
	 * Make a square polygon, bypassing the need for a convex hull.
	 */
	public static Polygon makeSquare(Arena arena, float halfWidth) {
		return makeSquare(new Polygon(arena), halfWidth);
	}

	/**
	 * Make a square polygon, bypassing the need for a convex hull.
	 */
	public static Polygon makeSquare(float halfWidth) {
		return makeSquare(new Polygon(), halfWidth);
	}

	/**
	 * Make a box (rectangle) polygon, bypassing the need for a convex hull.
	 */
	public static Polygon makeBox(Polygon target, float halfWidth, float halfHeight) {
		try (Arena arena = Arena.ofConfined()) {
			MemorySegment segment = (MemorySegment) B2_MAKE_BOX.invoke(arena, halfWidth, halfHeight);
			target.set(segment);
			return target;
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot make box.");
		}
	}

	/**
	 * Make a box (rectangle) polygon, bypassing the need for a convex hull.
	 */
	public static Polygon makeBox(Arena arena, float halfWidth, float halfHeight) {
		return makeBox(new Polygon(arena), halfWidth, halfHeight);
	}

	/**
	 * Make a box (rectangle) polygon, bypassing the need for a convex hull.
	 */
	public static Polygon makeBox(float halfWidth, float halfHeight) {
		return makeBox(new Polygon(), halfWidth, halfHeight);
	}

	/**
	 * Make a rounded box, bypassing the need for a convex hull.
	 */
	public static Polygon makeRoundedBox(Polygon target, float halfWidth, float halfHeight, float radius) {
		try (Arena arena = Arena.ofConfined()) {
			MethodHandle method = B2_MAKE_ROUNDED_BOX;
			MemorySegment segment = (MemorySegment) method.invoke(arena, halfWidth, halfHeight, radius);
			target.set(segment);
			return target;
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot make rounded box.");
		}
	}

	/**
	 * Make a rounded box, bypassing the need for a convex hull.
	 */
	public static Polygon makeRoundedBox(Arena arena, float halfWidth, float halfHeight, float radius) {
		return makeRoundedBox(new Polygon(arena), halfWidth, halfHeight, radius);
	}

	/**
	 * Make a rounded box, bypassing the need for a convex hull.
	 */
	public static Polygon makeRoundedBox(float halfWidth, float halfHeight, float radius) {
		return makeRoundedBox(new Polygon(), halfWidth, halfHeight, radius);
	}

	/**
	 * Make an offset box, bypassing the need for a convex hull.
	 */
	public static Polygon makeOffsetBox(Arena arena, float halfWidth, float halfHeight, Vector2f center,
			float rotation) {
		return makeOffsetBox(new Polygon(arena), halfWidth, halfHeight, center, rotation);
	}

	/**
	 * Make an offset box, bypassing the need for a convex hull.
	 */
	public static Polygon makeOffsetBox(float halfWidth, float halfHeight, Vector2f center, float rotation) {
		return makeOffsetBox(new Polygon(), halfWidth, halfHeight, center, rotation);
	}

	/**
	 * Make an offset box, bypassing the need for a convex hull.
	 */
	public static Polygon makeOffsetBox(Polygon target, float halfWidth, float halfHeight, Vector2f center,
			float rotation) {
		try (Arena arena = Arena.ofConfined()) {
			VEC_TMP.set(center);
			ROT_TMP.setAngleRadians(rotation);

			MemorySegment centerAddr = VEC_TMP.memorySegment();
			MemorySegment rotAddr = ROT_TMP.memorySegment();
			MethodHandle method = B2_MAKE_OFFSET_BOX;
			MemorySegment segment = (MemorySegment) method.invoke(arena, halfWidth, halfHeight, centerAddr, rotAddr);
			target.set(segment);
			return target;
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot make offset box.");
		}
	}

	/**
	 * Make an offset rounded box, bypassing the need for a convex hull.
	 */
	public static Polygon makeOffsetRoundedBox(Arena arena, float halfWidth, float halfHeight, Vector2f center,
			float rotation, float radius) {
		return makeOffsetRoundedBox(new Polygon(arena), halfWidth, halfHeight, center, rotation, radius);
	}

	/**
	 * Make an offset rounded box, bypassing the need for a convex hull.
	 */
	public static Polygon makeOffsetRoundedBox(float halfWidth, float halfHeight, Vector2f center, float rotation,
			float radius) {
		return makeOffsetRoundedBox(new Polygon(), halfWidth, halfHeight, center, rotation, radius);
	}

	/**
	 * Make an offset rounded box, bypassing the need for a convex hull.
	 */
	public static Polygon makeOffsetRoundedBox(Polygon target, float halfWidth, float halfHeight, Vector2f center,
			float rotation, float radius) {
		try (Arena arena = Arena.ofConfined()) {
			VEC_TMP.set(center);
			ROT_TMP.setAngleRadians(rotation);

			MemorySegment centerAddr = VEC_TMP.memorySegment();
			MemorySegment rotAddr = ROT_TMP.memorySegment();
			MethodHandle method = B2_MAKE_OFFSET_ROUNDED_BOX;
			MemorySegment segment = (MemorySegment) method.invoke(arena, halfWidth, halfHeight, centerAddr, rotAddr,
					radius);
			target.set(segment);
			return target;
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot make offset rounded box.");
		}
	}

	public static StructLayout LAYOUT() {
		return LAYOUT;
	}

}
