package volucris.engine.physics.box2d.math;

import java.lang.foreign.Arena;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.StructLayout;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;

import volucris.engine.utils.MathUtils;
import volucris.engine.utils.VolucrisRuntimeException;

import static java.lang.foreign.ValueLayout.*;
import static volucris.engine.utils.FFMUtils.*;

public final class Rot {

	protected static StructLayout LAYOUT;

	private static final VarHandle C;
	private static final VarHandle S;

	private static final MethodHandle B2_ATAN2;

	private final MemorySegment b2Rot;

	private final CosSin cosSinTmp;

	static {
		//@formatter:off
		LAYOUT = MemoryLayout.structLayout(
				JAVA_FLOAT.withName("c"),
				JAVA_FLOAT.withName("s")
			).withName("b2Rot");
		//@formatter:on

		C = varHandle(LAYOUT, "c");
		S = varHandle(LAYOUT, "s");

		B2_ATAN2 = downcallHandle("b2Atan2", JAVA_FLOAT, JAVA_FLOAT, JAVA_FLOAT);
	}

	public Rot() {
		this(Arena.ofAuto());
	}
	
	public Rot(Arena arena) {
		b2Rot = arena.allocate(LAYOUT);

		cosSinTmp = new CosSin(arena);
	}

	public Rot(MemorySegment memorySegment) {
		this.b2Rot = memorySegment;

		cosSinTmp = new CosSin();
	}

	@Override
	public String toString() {
		return "Rot (C: " + getC() + ", S: " + getS() + ")";
	}

	public void set(MemorySegment memorySegment) {
		float c = (float) C.get(memorySegment);
		float s = (float) S.get(memorySegment);
		setC(c);
		setS(s);
	}

	public void set(CosSin cosSin) {
		setC(cosSin.getCosine());
		setS(cosSin.getSine());
	}

	private void setC(float c) {
		C.set(b2Rot, c);
	}

	private float getC() {
		return (float) C.get(b2Rot);
	}

	private void setS(float s) {
		S.set(b2Rot, s);
	}

	private float getS() {
		return (float) S.get(b2Rot);
	}

	public float getAngle() {
		return MathUtils.toDegrees(getAngleRadians());
	}

	public float getAngleRadians() {
		try {
			return (float) B2_ATAN2.invokeExact(getS(), getC());
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot get rotation angle.");
		}
	}

	public void setAngle(float angle) {
		setAngleRadians(MathUtils.toRadians(angle));
	}

	public void setAngleRadians(float angle) {
		set(CosSin.computeCosSin(cosSinTmp, angle));
	}

	public MemorySegment memorySegment() {
		return b2Rot;
	}

	public static StructLayout LAYOUT() {
		return LAYOUT;
	}

}
