package volucris.engine.physics.box2d.shape;

import java.lang.foreign.Arena;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.StructLayout;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;

import volucris.engine.utils.Box2DRuntimeException;

import static java.lang.foreign.ValueLayout.*;
import static volucris.engine.utils.FFMUtils.*;

/**
 * The query filter is used to filter collisions between queries and shapes.
 * <p>
 * For example, you may want a ray-cast representing a projectile to hit players
 * and the static environment but not debris.
 * 
 */
public final class QueryFilter {

	private static final StructLayout LAYOUT;

	private static final VarHandle CATEGORY_BITS;
	private static final VarHandle MASK_BITS;

	private static final MethodHandle B2_DEFAULT_QUERY_FILTER;

	private final MemorySegment b2QueryFilter;

	static {
		//@formatter:off
		LAYOUT = MemoryLayout.structLayout(
		        JAVA_LONG.withName("categoryBits"),
		        JAVA_LONG.withName("maskBits")
			);
		//@formatter:on

		CATEGORY_BITS = varHandle(LAYOUT, "categoryBits");
		MASK_BITS = varHandle(LAYOUT, "maskBits");

		B2_DEFAULT_QUERY_FILTER = downcallHandle("b2DefaultQueryFilter", LAYOUT);
	}

	public QueryFilter() {
		this(Arena.ofAuto());
	}

	public QueryFilter(Arena arena) {
		try {
			b2QueryFilter = (MemorySegment) B2_DEFAULT_QUERY_FILTER.invoke(arena);
		} catch (Throwable e) {
			String className = e.getClass().getSimpleName();
			throw new Box2DRuntimeException("Box2D: Cannot create query filter: " + className);
		}
	}

	public void set(long categoryBits, long maskBits) {
		setCategoryBits(categoryBits);
		setMaskBits(maskBits);
	}

	/**
	 * The collision category bits of this query. Normally you would just set one
	 * bit.
	 */
	public void setCategoryBits(float categoryBits) {
		CATEGORY_BITS.set(b2QueryFilter, categoryBits);
	}

	/**
	 * The collision category bits of this query. Normally you would just set one
	 * bit.
	 */
	public float getCategoryBits() {
		return (float) CATEGORY_BITS.get(b2QueryFilter);
	}

	/**
	 * The collision mask bits.
	 * <p>
	 * This states the shape categories that this query would accept for collision.
	 */
	public void setMaskBits(float maskBits) {
		MASK_BITS.set(b2QueryFilter, maskBits);
	}

	/**
	 * The collision mask bits.
	 * <p>
	 * This states the shape categories that this query would accept for collision.
	 */
	public float getMaskBits() {
		return (float) MASK_BITS.get(b2QueryFilter);
	}

	public MemorySegment memorySegment() {
		return b2QueryFilter;
	}

	public static StructLayout LAYOUT() {
		return LAYOUT;
	}

}
