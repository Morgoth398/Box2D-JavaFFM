package volucris.engine.physics.box2d.geometry;

import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.SegmentAllocator;
import java.lang.foreign.SequenceLayout;
import java.lang.foreign.StructLayout;
import java.lang.foreign.MemoryLayout.PathElement;
import java.lang.invoke.MethodHandle;

import org.joml.Vector2f;

import volucris.engine.physics.box2d.math.Vec2;
import volucris.engine.utils.VolucrisRuntimeException;

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

	private static final MethodHandle B2_VALIDATE_HULL;
	private static final MethodHandle B2_COMPUTE_HULL;

	private static final MemorySegment POINTS_ARRAY;

	private static final Vec2[] POINTS;

	private final MemorySegment b2Hull;

	static {
		//@formatter:off
		LAYOUT = MemoryLayout.structLayout(
				MemoryLayout.sequenceLayout(8, Vec2.LAYOUT()).withName("points"),
		        JAVA_INT.withName("count")
			).withName("b2Hull");
		//@formatter:on

		B2_VALIDATE_HULL = downcallHandle("b2ValidateHull", JAVA_BOOLEAN, ADDRESS);
		B2_COMPUTE_HULL = downcallHandle("b2ComputeHull", LAYOUT, ADDRESS, JAVA_INT);

		SequenceLayout arrayLayout = MemoryLayout.sequenceLayout(8, Vec2.LAYOUT());
		POINTS_ARRAY = Arena.ofAuto().allocate(arrayLayout);
		POINTS = new Vec2[8];

		for (int i = 0; i < 8; i++) {
			long offset = arrayLayout.byteOffset(PathElement.sequenceElement(i));
			POINTS[i] = new Vec2(POINTS_ARRAY.asSlice(offset, Vec2.LAYOUT()));
		}

	}

	private Hull() {
		b2Hull = Arena.ofAuto().allocate(LAYOUT);
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
			throw new VolucrisRuntimeException("Box2D: Cannot validate hull.");
		}
	}

	public MemorySegment memorySegment() {
		return b2Hull;
	}

	/**
	 * Compute the convex hull of a set of points.
	 * <p>
	 * Maximum are 8 points.
	 */
	public static Hull computeHull(Vector2f[] points) {
		int count = points.length > 8 ? 8 : points.length;

		for (int i = 0; i < count; i++)
			POINTS[i].set(points[i]);

		try {
			SegmentAllocator allocator = Arena.ofAuto();
			MemorySegment segment = (MemorySegment) B2_COMPUTE_HULL.invokeExact(allocator, POINTS_ARRAY, count);
			return new Hull(segment);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot compute hull.");
		}
	}

	public static StructLayout LAYOUT() {
		return LAYOUT;
	}
}
