package volucris.engine.physics.box2d.shape;

import java.lang.foreign.Arena;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.StructLayout;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;

import org.joml.Vector2f;

import volucris.engine.physics.box2d.world.World;
import volucris.engine.physics.box2d.world.functions.CastResultFunction;
import volucris.engine.utils.Box2DRuntimeException;

import static java.lang.foreign.ValueLayout.*;
import static volucris.engine.utils.FFMUtils.*;

/**
 * This is used to filter collision on shapes.
 * <p>
 * It affects shape-vs-shape collision and shape-versus-query collision (such as
 * {@link World#castRay(Vector2f, Vector2f, QueryFilter, CastResultFunction, MemorySegment)
 * World.castRay}).
 * <p>
 * <ul>
 * <li>categoryBits:
 * <p>
 * The collision category bits. Normally you would just set one bit. The
 * category bits should represent your application object types.
 * <p>
 * {@code 
 * Static = 0x00000001; Dynamic = 0x00000002; Debris = 0x00000004;
 * Player = 0x00000008;}
 * <li>groupIndex:
 * <p>
 * Collision groups allow a certain group of objects to never collide (negative)
 * or always collide (positive).
 * <p>
 * A group index of zero has no effect. Non-zero group filtering always wins
 * against the mask bits. For example, you may want ragdolls to collide with
 * other ragdolls but you don't want ragdoll self-collision. In this case you
 * would give each ragdoll a unique negative group index and apply that group
 * index to all shapes on the ragdoll.
 * <li>maskBits:
 * <p>
 * The collision mask bits.
 * <p>
 * This states the categories that this shape would accept for collision. For
 * example, you may want your player to only collide with static objects and
 * other players. (e. g. maskBits = Static | Player)
 * </ul>
 */
public final class Filter {

	private static final StructLayout LAYOUT;

	private static final VarHandle CATEGORY_BITS;
	private static final VarHandle MASK_BITS;
	private static final VarHandle GROUP_INDEX;

	private static final MethodHandle B2_DEFAULT_FILTER;

	private final MemorySegment b2Filter;

	static {
		//@formatter:off
		LAYOUT = MemoryLayout.structLayout(
				JAVA_LONG.withName("categoryBits"),
				JAVA_LONG.withName("maskBits"),
		        JAVA_INT.withName("groupIndex"),
		        MemoryLayout.paddingLayout(4)
			).withName("b2Filter");
		//@formatter:on

		CATEGORY_BITS = varHandle(LAYOUT, "categoryBits");
		MASK_BITS = varHandle(LAYOUT, "maskBits");
		GROUP_INDEX = varHandle(LAYOUT, "groupIndex");

		B2_DEFAULT_FILTER = downcallHandle("b2DefaultFilter", LAYOUT);
	}

	public Filter() {
		this(Arena.ofAuto());
	}

	public Filter(Arena arena) {
		try {
			b2Filter = (MemorySegment) B2_DEFAULT_FILTER.invoke(arena);
		} catch (Throwable e) {
			String className = e.getClass().getSimpleName();
			throw new Box2DRuntimeException("Box2D: Cannot create filter: " + className);
		}
	}

	public Filter(MemorySegment memorySegment) {
		b2Filter = memorySegment;
	}

	public void set(MemorySegment memorySegment) {
		long categoryBits = (long) CATEGORY_BITS.get(memorySegment);
		long maskBits = (long) MASK_BITS.get(memorySegment);
		int groupIndex = (int) GROUP_INDEX.get(memorySegment);

		set(categoryBits, maskBits, groupIndex);
	}

	public void set(long categoryBits, long maskBits, int groupIndex) {
		setCategoryBits(categoryBits);
		setMaskBits(maskBits);
		setGroupIndex(groupIndex);
	}

	public void setCategoryBits(long categoryBits) {
		CATEGORY_BITS.set(b2Filter, categoryBits);
	}

	public void setMaskBits(long maskBits) {
		MASK_BITS.set(b2Filter, maskBits);
	}

	public void setGroupIndex(int groupIndex) {
		GROUP_INDEX.set(b2Filter, groupIndex);
	}

	public MemorySegment memorySegment() {
		return b2Filter;
	}

	public static StructLayout LAYOUT() {
		return LAYOUT;
	}

}
