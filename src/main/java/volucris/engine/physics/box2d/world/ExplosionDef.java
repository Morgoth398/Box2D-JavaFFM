package volucris.engine.physics.box2d.world;

import java.lang.foreign.Arena;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.StructLayout;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;

import org.joml.Vector2f;

import volucris.engine.physics.box2d.math.Vec2;
import volucris.engine.utils.Box2DRuntimeException;

import static java.lang.foreign.ValueLayout.*;
import static volucris.engine.utils.FFMUtils.*;

/**
 * The explosion definition is used to configure options for explosions.
 * Explosions consider shape geometry when computing the impulse.
 * 
 */
public final class ExplosionDef {

	private static final StructLayout LAYOUT;

	private static final VarHandle MASK_BITS;
	private static final VarHandle RADIUS;
	private static final VarHandle FALLOFF;
	private static final VarHandle IMPULSE_PER_LENGTH;

	private static final MethodHandle B2_DEFAULT_EXPLOSION_DEF;

	private static final long POSITION_OFFSET;

	private final MemorySegment b2ExplosionDef;

	private final Vec2 position;

	static {
		//@formatter:off
		LAYOUT = MemoryLayout.structLayout(
		        JAVA_LONG.withName("maskBits"),
		        Vec2.LAYOUT().withName("position"),
		        JAVA_FLOAT.withName("radius"),
		        JAVA_FLOAT.withName("falloff"),
		        JAVA_FLOAT.withName("impulsePerLength"),
		        MemoryLayout.paddingLayout(4)
			).withName("b2ExplosionDef");
		//@formatter:on

		MASK_BITS = varHandle(LAYOUT, "maskBits");
		RADIUS = varHandle(LAYOUT, "radius");
		FALLOFF = varHandle(LAYOUT, "falloff");
		IMPULSE_PER_LENGTH = varHandle(LAYOUT, "impulsePerLength");

		B2_DEFAULT_EXPLOSION_DEF = downcallHandle("b2DefaultExplosionDef", LAYOUT);

		POSITION_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("position"));
	}

	public ExplosionDef() {
		this(Arena.ofAuto());
	}

	public ExplosionDef(Arena arena) {
		try {
			b2ExplosionDef = (MemorySegment) B2_DEFAULT_EXPLOSION_DEF.invoke(arena);
		} catch (Throwable e) {
			String className = e.getClass().getSimpleName();
			throw new Box2DRuntimeException("Cannot create explosion def: " + className);
		}

		position = new Vec2(b2ExplosionDef.asSlice(POSITION_OFFSET, Vec2.LAYOUT()));
	}

	/**
	 * The center of the explosion in world space.
	 */
	public void setPosition(float x, float y) {
		this.position.set(x, y);
	}

	/**
	 * The center of the explosion in world space.
	 */
	public void setPosition(Vector2f position) {
		this.position.set(position);
	}

	/**
	 * Mask bits to filter shapes.
	 */
	public void setMaskBits(long maskBits) {
		MASK_BITS.set(b2ExplosionDef, maskBits);
	}

	/**
	 * The radius of the explosion.
	 */
	public void setRadius(float radius) {
		RADIUS.set(b2ExplosionDef, radius);
	}

	/**
	 * The falloff distance beyond the radius. Impulse is reduced to zero at this
	 * distance.
	 */
	public void setFalloff(float falloff) {
		FALLOFF.set(b2ExplosionDef, falloff);
	}

	/**
	 * Impulse per unit length.
	 * <p>
	 * This applies an impulse according to the shape perimeter that is facing the
	 * explosion. Explosions only apply to circles, capsules, and polygons. This may
	 * be negative for implosions.
	 */
	public void setImpulsePerLength(float impulsePerLength) {
		IMPULSE_PER_LENGTH.set(b2ExplosionDef, impulsePerLength);
	}

	public MemorySegment memorySegment() {
		return b2ExplosionDef;
	}

	public static StructLayout LAYOUT() {
		return LAYOUT;
	}

}
