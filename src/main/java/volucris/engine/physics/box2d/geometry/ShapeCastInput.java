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
 * Low level shape cast input in generic form.
 * <p>
 * This allows casting an arbitrary point cloud wrap with a radius. For example,
 * a circle is a single point with a non-zero radius. A capsule is two points
 * with a non-zero radius. A box is four points with a zero radius.
 */
public final class ShapeCastInput {

	private static final StructLayout LAYOUT;

	private static final VarHandle MAX_FRACTION;
	private static final VarHandle CAN_ENCROACH;

	private static final long PROXY_OFFSET;
	private static final long TRANSLATION_OFFSET;

	private final MemorySegment b2ShapeCastInput;

	private final ShapeProxy proxy;

	private final Vec2 translation;

	static {
		//@formatter:off
		LAYOUT = MemoryLayout.structLayout(
				ShapeProxy.LAYOUT().withName("proxy"),
				Vec2.LAYOUT().withName("translation"),
				JAVA_FLOAT.withName("maxFraction"),
		        JAVA_BOOLEAN.withName("canEncroach"),
		        MemoryLayout.paddingLayout(3)
			).withName("b2ShapeCastInput");
		//@formatter:on		

		MAX_FRACTION = varHandle(LAYOUT, "maxFraction");
		CAN_ENCROACH = varHandle(LAYOUT, "canEncroach");

		PROXY_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("proxy"));
		TRANSLATION_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("translation"));
	}

	public ShapeCastInput() {
		b2ShapeCastInput = Arena.ofAuto().allocate(LAYOUT);

		proxy = new ShapeProxy(b2ShapeCastInput.asSlice(PROXY_OFFSET, ShapeProxy.LAYOUT()));
		translation = new Vec2(b2ShapeCastInput.asSlice(TRANSLATION_OFFSET, Vec2.LAYOUT()));
	}

	public ShapeCastInput(MemorySegment memorySegment) {
		b2ShapeCastInput = memorySegment;

		proxy = new ShapeProxy(b2ShapeCastInput.asSlice(PROXY_OFFSET, ShapeProxy.LAYOUT()));
		translation = new Vec2(b2ShapeCastInput.asSlice(TRANSLATION_OFFSET, Vec2.LAYOUT()));
	}

	public void set(MemorySegment memorySegment) {
		float maxFraction = (float) MAX_FRACTION.get(memorySegment);
		boolean canEncroach = (boolean) CAN_ENCROACH.get(memorySegment);

		setMaxFraction(maxFraction);
		setCanEncroach(canEncroach);

		proxy.set(memorySegment.asSlice(PROXY_OFFSET, ShapeProxy.LAYOUT()));
		translation.set(memorySegment.asSlice(TRANSLATION_OFFSET, Vec2.LAYOUT()));
	}

	public ShapeProxy getProxy() {
		return proxy;
	}

	/**
	 * A generic shape
	 */
	public void setProxy(ShapeProxy proxy) {
		this.proxy.set(proxy.memorySegment());
	}

	/**
	 * The translation of the shape cast.
	 */
	public Vector2f getTranslation(Vector2f target) {
		return translation.get(target);
	}

	/**
	 * The translation of the shape cast.
	 */
	public Vector2f getTranslation() {
		return getTranslation(new Vector2f());
	}

	/**
	 * The translation of the shape cast.
	 */
	public void setTranslation(float x, float y) {
		this.translation.set(x, y);
	}

	/**
	 * The translation of the shape cast.
	 */
	public void setTranslation(Vector2f translation) {
		this.translation.set(translation);
	}

	/**
	 * The maximum fraction of the translation to consider, typically 1.
	 */
	public float getMaxFraction() {
		return (float) MAX_FRACTION.get(b2ShapeCastInput);
	}

	/**
	 * The maximum fraction of the translation to consider, typically 1.
	 */
	public void setMaxFraction(float maxFraction) {
		MAX_FRACTION.set(b2ShapeCastInput, maxFraction);
	}

	public boolean canEncroach() {
		return (boolean) CAN_ENCROACH.get(b2ShapeCastInput);
	}

	/**
	 * Allow shape cast to encroach when initially touching. This only works if the
	 * radius is greater than zero.
	 */
	public void setCanEncroach(boolean canEncroach) {
		CAN_ENCROACH.set(b2ShapeCastInput, canEncroach);
	}

	public MemorySegment memorySegment() {
		return b2ShapeCastInput.asReadOnly();
	}

	public static StructLayout LAYOUT() {
		return LAYOUT;
	}

}
