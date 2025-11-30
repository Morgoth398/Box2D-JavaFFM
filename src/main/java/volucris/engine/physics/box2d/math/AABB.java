package volucris.engine.physics.box2d.math;

import java.lang.foreign.Arena;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemoryLayout.PathElement;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.StructLayout;
import java.lang.invoke.MethodHandle;

import org.joml.Vector2f;

import volucris.engine.utils.VolucrisRuntimeException;

import static java.lang.foreign.ValueLayout.*;
import static volucris.engine.utils.FFMUtils.*;

public final class AABB {

	private static final StructLayout LAYOUT;

	private static final MethodHandle B2_IS_VALID_AABB;
	
	private static final long LOWER_BOUND_OFFSET;
	private static final long UPPER_BOUND_OFFSET;

	private final MemorySegment b2AABB;

	private final Vec2 lowerBound;
	private final Vec2 upperBound;

	static {
		//@formatter:off
		LAYOUT = MemoryLayout.structLayout(
				Vec2.LAYOUT().withName("lowerBound"),
				Vec2.LAYOUT().withName("upperBound")
			).withName("b2AABB");
		//@formatter:on

		B2_IS_VALID_AABB = downcallHandle("b2IsValidAABB", JAVA_BOOLEAN, LAYOUT);
		
		LOWER_BOUND_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("lowerBound"));
		UPPER_BOUND_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("upperBound"));
	}

	public AABB() {
		b2AABB = Arena.ofAuto().allocate(LAYOUT);

		lowerBound = new Vec2(b2AABB.asSlice(LOWER_BOUND_OFFSET, Vec2.LAYOUT()));
		upperBound = new Vec2(b2AABB.asSlice(UPPER_BOUND_OFFSET, Vec2.LAYOUT()));
	}

	public AABB(MemorySegment memorySegment) {
		this.b2AABB = memorySegment;

		lowerBound = new Vec2(b2AABB.asSlice(LOWER_BOUND_OFFSET, Vec2.LAYOUT()));
		upperBound = new Vec2(b2AABB.asSlice(UPPER_BOUND_OFFSET, Vec2.LAYOUT()));
	}

	public void set(MemorySegment memorySegment) {
		lowerBound.set(memorySegment.asSlice(LOWER_BOUND_OFFSET, Vec2.LAYOUT()));
		upperBound.set(memorySegment.asSlice(UPPER_BOUND_OFFSET, Vec2.LAYOUT()));
	}

	public boolean isValid() {
		try {
			return (boolean) B2_IS_VALID_AABB.invokeExact(b2AABB);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot validate AABB.");
		}
	}
	
	@Override
	public String toString() {
		return "AABB (Lower Bound: " + lowerBound.toString() + ", UpperBound: " + upperBound.toString() + ")";
	}

	public Vector2f getLowerBound(Vector2f target) {
		return lowerBound.get(target);
	}

	public Vector2f getLowerBound() {
		return getLowerBound(new Vector2f());
	}

	public void setLowerBound(Vector2f lowerBound) {
		this.lowerBound.set(lowerBound);
	}

	public Vector2f getUpperBound(Vector2f target) {
		return upperBound.get(target);
	}

	public Vector2f getUpperBound() {
		return getUpperBound(new Vector2f());
	}

	public void setUpperBound(Vector2f upperBound) {
		this.upperBound.set(upperBound);
	}

	public MemorySegment memorySegment() {
		return b2AABB;
	}

	public static StructLayout LAYOUT() {
		return LAYOUT;
	}

}
