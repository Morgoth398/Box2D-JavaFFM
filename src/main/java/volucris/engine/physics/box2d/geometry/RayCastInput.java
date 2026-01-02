package volucris.engine.physics.box2d.geometry;

import java.lang.foreign.Arena;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.StructLayout;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;

import org.joml.Vector2f;

import volucris.engine.physics.box2d.math.Vec2;
import volucris.engine.utils.VolucrisRuntimeException;

import static java.lang.foreign.ValueLayout.*;
import static volucris.engine.utils.FFMUtils.*;

/**
 * Low level ray cast input data.
 */
public final class RayCastInput {

	private static final StructLayout LAYOUT;

	private static final VarHandle MAX_FRACTION;

	private static final MethodHandle B2_IS_VALID_RAY;

	private static final long ORIGIN_OFFSET;
	private static final long TRANSLATION_OFFSET;

	private final MemorySegment b2RayCastInput;

	private final Vec2 origin;
	private final Vec2 translation;

	static {
		//@formatter:off
		LAYOUT = MemoryLayout.structLayout(
		        Vec2.LAYOUT().withName("origin"),
		        Vec2.LAYOUT().withName("translation"),
		        JAVA_FLOAT.withName("maxFraction")
			).withName("b2RayCastInput");
		//@formatter:on

		MAX_FRACTION = varHandle(LAYOUT, "maxFraction");

		B2_IS_VALID_RAY = downcallHandle("b2IsValidRay", JAVA_BOOLEAN, ADDRESS);

		ORIGIN_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("origin"));
		TRANSLATION_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("translation"));
	}

	public RayCastInput() {
		this(Arena.ofAuto());
	}
	
	public RayCastInput(Arena arena) {
		b2RayCastInput = arena.allocate(LAYOUT);

		origin = new Vec2(b2RayCastInput.asSlice(ORIGIN_OFFSET, LAYOUT));
		translation = new Vec2(b2RayCastInput.asSlice(TRANSLATION_OFFSET, LAYOUT));
	}

	public RayCastInput(MemorySegment memorySegment) {
		b2RayCastInput = memorySegment;

		origin = new Vec2(b2RayCastInput.asSlice(ORIGIN_OFFSET, LAYOUT));
		translation = new Vec2(b2RayCastInput.asSlice(TRANSLATION_OFFSET, LAYOUT));
	}

	public void set(MemorySegment memorySegment) {
		MemorySegment.copy(memorySegment, 0, b2RayCastInput, 0, LAYOUT.byteSize());
	}

	public boolean isValidRay() {
		try {
			return (boolean) B2_IS_VALID_RAY.invokeExact(b2RayCastInput);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot validate ray.");
		}
	}

	public Vector2f getOrigin(Vector2f target) {
		return origin.get(target);
	}

	public Vector2f getOrigin() {
		return getOrigin(new Vector2f());
	}

	/**
	 * Start point of the ray cast.
	 */
	public void setOrigin(float x, float y) {
		this.origin.set(x, y);
	}

	/**
	 * Start point of the ray cast.
	 */
	public void setOrigin(Vector2f origin) {
		this.origin.set(origin);
	}

	/**
	 * Translation of the ray cast.
	 */
	public Vector2f getTranslation(Vector2f target) {
		return translation.get(target);
	}

	/**
	 * Translation of the ray cast.
	 */
	public Vector2f getTranslation() {
		return getTranslation(new Vector2f());
	}

	public void setTranslation(float x, float y) {
		this.translation.set(x, y);
	}

	public void setTranslation(Vector2f translation) {
		this.translation.set(translation);
	}

	/**
	 * The maximum fraction of the translation to consider, typically 1.
	 */
	public void setMaxFraction(float maxFraction) {
		MAX_FRACTION.set(b2RayCastInput, maxFraction);
	}

	public float getMaxFraction() {
		return (float) MAX_FRACTION.get(b2RayCastInput);
	}

	public MemorySegment memorySegment() {
		return b2RayCastInput;
	}

	public static StructLayout LAYOUT() {
		return LAYOUT;
	}

}
