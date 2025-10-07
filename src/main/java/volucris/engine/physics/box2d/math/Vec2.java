package volucris.engine.physics.box2d.math;

import java.lang.foreign.Arena;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.StructLayout;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;

import org.joml.Vector2f;

import volucris.engine.utils.VolucrisRuntimeException;

import static java.lang.foreign.ValueLayout.*;
import static volucris.engine.utils.FFMUtils.*;

public final class Vec2 {

	private static StructLayout LAYOUT;

	private static final VarHandle X;
	private static final VarHandle Y;

	private static final MethodHandle B2_IS_VALID_VEC2;

	private final MemorySegment b2Vec2;

	static {
		//@formatter:off
		LAYOUT = MemoryLayout.structLayout(
				JAVA_FLOAT.withName("x"),
				JAVA_FLOAT.withName("y")
			).withName("b2Vec2");
		//@formatter:on

		X = varHandle(LAYOUT, "x");
		Y = varHandle(LAYOUT, "y");

		B2_IS_VALID_VEC2 = downcallHandle("b2IsValidVec2", JAVA_BOOLEAN, LAYOUT);
	}

	public Vec2(float x, float y) {
		b2Vec2 = Arena.ofAuto().allocate(LAYOUT);

		set(x, y);
	}

	public Vec2(Vector2f vector) {
		this(vector.x, vector.y);
	}

	public Vec2(MemorySegment memorySegment) {
		this.b2Vec2 = memorySegment;
	}

	public Vec2() {
		this(0, 0);
	}

	public boolean isValid() {
		try {
			return (boolean) B2_IS_VALID_VEC2.invokeExact(b2Vec2);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot check if vector is valid.");
		}
	}

	public void set(MemorySegment memorySegment) {
		float x = (float) X.get(memorySegment);
		float y = (float) Y.get(memorySegment);
		setX(x);
		setY(y);
	}

	public void set(float x, float y) {
		setX(x);
		setY(y);
	}

	public void set(Vector2f vector) {
		set(vector.x, vector.y);
	}

	public void setX(float x) {
		X.set(b2Vec2, x);
	}

	public void setY(float y) {
		Y.set(b2Vec2, y);
	}

	public float getX() {
		return (float) X.get(b2Vec2);
	}

	public float getY() {
		return (float) Y.get(b2Vec2);
	}

	public Vector2f get(Vector2f target) {
		return target.set(getX(), getY());
	}

	public Vector2f get() {
		return get(new Vector2f());
	}

	@Override
	public String toString() {
		return "Vec2 (X: " + getX() + ", Y: " + getY() + ")";
	}

	public MemorySegment memorySegment() {
		return b2Vec2.asReadOnly();
	}

	public static StructLayout LAYOUT() {
		return LAYOUT;
	}

}
