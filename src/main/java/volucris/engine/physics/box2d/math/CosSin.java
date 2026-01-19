package volucris.engine.physics.box2d.math;

import java.lang.foreign.Arena;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.SegmentAllocator;
import java.lang.foreign.StructLayout;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;

import volucris.engine.utils.Box2DRuntimeException;

import static java.lang.foreign.ValueLayout.*;
import static volucris.engine.utils.FFMUtils.*;

public final class CosSin {

	private static StructLayout LAYOUT;

	private static final VarHandle COSINE;
	private static final VarHandle SINE;

	private static final MethodHandle B2_COMPUTE_COS_SIN;

	private final MemorySegment b2CosSin;

	static {
		//@formatter:off
		LAYOUT = MemoryLayout.structLayout(
				JAVA_FLOAT.withName("cosine"),
				JAVA_FLOAT.withName("sine")
			).withName("b2CosSin");
		//@formatter:on

		COSINE = varHandle(LAYOUT, "cosine");
		SINE = varHandle(LAYOUT, "sine");

		B2_COMPUTE_COS_SIN = downcallHandle("b2ComputeCosSin", LAYOUT, JAVA_FLOAT);
	}

	public CosSin(Arena arena) {
		b2CosSin = arena.allocate(LAYOUT);
	}

	public CosSin() {
		b2CosSin = Arena.ofAuto().allocate(LAYOUT);
	}

	public CosSin(MemorySegment memorySegment) {
		this.b2CosSin = memorySegment;
	}

	@Override
	public String toString() {
		return "CosSin (Cosine: " + getCosine() + ", Sine: " + getSine() + ")";
	}

	public void set(MemorySegment segment) {
		float cosine = (float) COSINE.get(segment);
		float sine = (float) SINE.get(segment);
		setSine(sine);
		setCosine(cosine);
	}

	public void setCosine(float cosine) {
		COSINE.set(b2CosSin, cosine);
	}

	public float getCosine() {
		return (float) COSINE.get(b2CosSin);
	}

	public void setSine(float sine) {
		SINE.set(b2CosSin, sine);
	}

	public float getSine() {
		return (float) SINE.get(b2CosSin);
	}

	public MemorySegment memorySegment() {
		return b2CosSin;
	}

	public static CosSin computeCosSin(float radians) {
		return computeCosSin(new CosSin(), radians);
	}

	public static CosSin computeCosSin(CosSin target, float radians) {
		try (Arena arena = Arena.ofConfined()) {
			SegmentAllocator allocator = arena;
			MemorySegment segment = (MemorySegment) B2_COMPUTE_COS_SIN.invokeExact(allocator, radians);
			target.set(segment);
			return target;
		} catch (Throwable e) {
			String className = e.getClass().getSimpleName();
			throw new Box2DRuntimeException("Box2D: Cannot compute cosSin: " + className);
		}
	}

	public static StructLayout LAYOUT() {
		return LAYOUT;
	}

}
