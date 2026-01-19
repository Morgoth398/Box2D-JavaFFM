package volucris.engine.physics.box2d.geometry;

import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.StructLayout;
import java.lang.invoke.MethodHandle;

import org.joml.Vector2f;

import volucris.engine.physics.box2d.math.Vec2;
import volucris.engine.utils.Box2DRuntimeException;

import java.lang.foreign.Arena;

import static java.lang.foreign.ValueLayout.*;
import static volucris.engine.utils.FFMUtils.*;

/**
 * A convex hull.
 * <p>
 * Used to create convex polygons.
 */
public final class Hull {

	private static final StructLayout LAYOUT;

	private static final MemoryLayout POINTS_ARRAY_LAYOUT;

	private static final MethodHandle B2_VALIDATE_HULL;
	private static final MethodHandle B2_COMPUTE_HULL;

	private static final Vec2 VEC_TMP;

	private final MemorySegment b2Hull;

	static {
		//@formatter:off
		POINTS_ARRAY_LAYOUT = MemoryLayout.sequenceLayout(8, Vec2.LAYOUT());
		
		LAYOUT = MemoryLayout.structLayout(
				POINTS_ARRAY_LAYOUT.withName("points"),
		        JAVA_INT.withName("count")
			).withName("b2Hull");
		//@formatter:on

		B2_VALIDATE_HULL = downcallHandle("b2ValidateHull", JAVA_BOOLEAN, ADDRESS);
		B2_COMPUTE_HULL = downcallHandle("b2ComputeHull", LAYOUT, ADDRESS, JAVA_INT);

		VEC_TMP = new Vec2();
	}

	private Hull() {
		this(Arena.ofAuto());
	}

	private Hull(Arena arena) {
		b2Hull = arena.allocate(LAYOUT);
	}

	private Hull(MemorySegment memorySegmet) {
		b2Hull = memorySegmet;
	}

	/**
	 * This determines if a hull is valid.
	 */
	public boolean validateHull() {
		try {
			return (boolean) B2_VALIDATE_HULL.invokeExact(b2Hull);
		} catch (Throwable e) {
			String className = e.getClass().getSimpleName();
			throw new Box2DRuntimeException("Cannot validate hull: " + className);
		}
	}

	public MemorySegment memorySegment() {
		return b2Hull;
	}

	public static Hull computeHull(Vector2f[] points) {
		return computeHull(Arena.ofAuto(), points);
	}

	/**
	 * Compute the convex hull of a set of points.
	 * <p>
	 * Maximum are 8 points.
	 */
	public static Hull computeHull(Arena arena, Vector2f[] points) {
		int count = points.length > 8 ? 8 : points.length;
		try (Arena confinedArena = Arena.ofConfined()) {
			MemorySegment array = confinedArena.allocate(POINTS_ARRAY_LAYOUT);
			for (int i = 0; i < count; i++) {
				long offset = i * POINTS_ARRAY_LAYOUT.byteSize();
				VEC_TMP.set(points[i]);
				MemorySegment.copy(VEC_TMP.memorySegment(), 0, array, offset, Vec2.LAYOUT().byteSize());
			}

			MemorySegment segment = (MemorySegment) B2_COMPUTE_HULL.invoke(arena, array, count);
			return new Hull(segment);
		} catch (Throwable e) {
			String className = e.getClass().getSimpleName();
			throw new Box2DRuntimeException("Cannot compute hull: " + className);
		}
	}

	public static StructLayout LAYOUT() {
		return LAYOUT;
	}
}
