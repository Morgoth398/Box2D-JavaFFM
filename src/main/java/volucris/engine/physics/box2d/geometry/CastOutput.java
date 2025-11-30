package volucris.engine.physics.box2d.geometry;

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
 * Low level ray cast or shape-cast output data.
 */
public final class CastOutput {

	private static final StructLayout LAYOUT;

	private static final VarHandle FRACTION;
	private static final VarHandle ITERATIONS;
	private static final VarHandle HIT;

	private static final long NORMAL_OFFSET;
	private static final long POINT_OFFSET;

	private final MemorySegment b2CastOutput;

	private final Vec2 normal;
	private final Vec2 point;

	static {
		//@formatter:off
		LAYOUT = MemoryLayout.structLayout(
				Vec2.LAYOUT().withName("normal"),
		        Vec2.LAYOUT().withName("point"),
		        JAVA_FLOAT.withName("fraction"),
		        JAVA_INT.withName("iterations"),
		        JAVA_BOOLEAN.withName("hit"),
		        MemoryLayout.paddingLayout(3)
			).withName("b2CastOutput");
		//@formatter:on

		FRACTION = varHandle(LAYOUT, "fraction");
		ITERATIONS = varHandle(LAYOUT, "iterations");
		HIT = varHandle(LAYOUT, "hit");

		NORMAL_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("normal"));
		POINT_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("point"));
	}

	public CastOutput() {
		b2CastOutput = Arena.ofAuto().allocate(LAYOUT);

		normal = new Vec2(b2CastOutput.asSlice(NORMAL_OFFSET, Vec2.LAYOUT()));
		point = new Vec2(b2CastOutput.asSlice(POINT_OFFSET, Vec2.LAYOUT()));
	}

	public CastOutput(MemorySegment memorySegment) {
		b2CastOutput = memorySegment;

		normal = new Vec2(b2CastOutput.asSlice(NORMAL_OFFSET, Vec2.LAYOUT()));
		point = new Vec2(b2CastOutput.asSlice(POINT_OFFSET, Vec2.LAYOUT()));
	}

	public void set(MemorySegment memorySegment) {
		MemorySegment.copy(memorySegment, 0L, b2CastOutput, 0L, LAYOUT.byteSize());
	}

	/**
	 * The surface normal at the hit point.
	 */
	public Vector2f getNormal(Vector2f target) {
		return normal.get(target);
	}

	/**
	 * The surface normal at the hit point.
	 */
	public Vector2f getNormal() {
		return getNormal(new Vector2f());
	}

	/**
	 * The surface hit point.
	 */
	public Vector2f getPoint(Vector2f target) {
		return point.get(target);
	}

	/**
	 * The surface hit point.
	 */
	public Vector2f getPoint() {
		return getPoint(new Vector2f());
	}

	/**
	 * The fraction of the input translation at collision.
	 */
	public float getFraction() {
		return (float) FRACTION.get(b2CastOutput);
	}

	/**
	 * The number of iterations used.
	 */
	public float getIterations() {
		return (float) ITERATIONS.get(b2CastOutput);
	}

	/**
	 * Did the cast hit?
	 */
	public boolean getHit() {
		return (boolean) HIT.get(b2CastOutput);
	}

	public MemorySegment memorySegment() {
		return b2CastOutput;
	}

	public static StructLayout LAYOUT() {
		return LAYOUT;
	}

}
