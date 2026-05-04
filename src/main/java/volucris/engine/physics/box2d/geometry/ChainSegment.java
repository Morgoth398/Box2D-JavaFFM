package volucris.engine.physics.box2d.geometry;

import java.lang.foreign.Arena;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.StructLayout;

import org.joml.Vector2f;

import volucris.engine.physics.box2d.math.Vec2;

import static java.lang.foreign.ValueLayout.*;

/**
 * A line segment with one-sided collision.
 * <p>
 * Only collides on the right side. Several of these are generated for a chain
 * shape. ghost1 -> point1 -> point2 -> ghost2
 */
public final class ChainSegment {

	private static final StructLayout LAYOUT;

	private static final long SEGMENT_OFFSET;
	private static final long GHOST1_OFFSET;
	private static final long GHOST2_OFFSET;

	private final MemorySegment b2ChainSegment;

	private final Segment segment;

	private final Vec2 ghost1;
	private final Vec2 ghost2;

	static {
		//@formatter:off
		LAYOUT = MemoryLayout.structLayout(
				Vec2.LAYOUT().withName("ghost1"),
		        Segment.LAYOUT().withName("segment"),
		        Vec2.LAYOUT().withName("ghost2"),
		        JAVA_INT.withName("chainId")
			).withName("b2ChainSegment");
		//@formatter:on

		SEGMENT_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("segment"));
		GHOST1_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("ghost1"));
		GHOST2_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("ghost2"));
	}

	public ChainSegment() {
		b2ChainSegment = Arena.ofAuto().allocate(LAYOUT);

		segment = new Segment(b2ChainSegment.asSlice(SEGMENT_OFFSET, Segment.LAYOUT()));
		ghost1 = new Vec2(b2ChainSegment.asSlice(GHOST1_OFFSET, Vec2.LAYOUT()));
		ghost2 = new Vec2(b2ChainSegment.asSlice(GHOST2_OFFSET, Vec2.LAYOUT()));
	}

	public ChainSegment(MemorySegment memorySegment) {
		b2ChainSegment = memorySegment;

		segment = new Segment(b2ChainSegment.asSlice(SEGMENT_OFFSET, Segment.LAYOUT()));
		ghost1 = new Vec2(b2ChainSegment.asSlice(GHOST1_OFFSET, Vec2.LAYOUT()));
		ghost2 = new Vec2(b2ChainSegment.asSlice(GHOST2_OFFSET, Vec2.LAYOUT()));
	}

	public void set(MemorySegment memorySegment) {
		MemorySegment.copy(memorySegment, 0, b2ChainSegment, 0, LAYOUT.byteSize());
	}

	/**
	 * The line segment.
	 */
	public Segment getSegment() {
		return segment;
	}

	/**
	 * The tail ghost vertex.
	 */
	public Vector2f getGhost1(Vector2f target) {
		return ghost1.get(target);
	}

	/**
	 * The tail ghost vertex.
	 */
	public Vector2f getGhost1() {
		return getGhost1(new Vector2f());
	}

	/**
	 * The head ghost vertex.
	 */
	public Vector2f getGhost2(Vector2f target) {
		return ghost2.get(target);
	}

	/**
	 * The head ghost vertex.
	 */
	public Vector2f getGhost2() {
		return getGhost2(new Vector2f());
	}

	public MemorySegment memorySegment() {
		return b2ChainSegment;
	}

	public static StructLayout LAYOUT() {
		return LAYOUT;
	}

}
