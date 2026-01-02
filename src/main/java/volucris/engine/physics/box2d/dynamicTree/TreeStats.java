package volucris.engine.physics.box2d.dynamicTree;

import java.lang.foreign.Arena;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.StructLayout;
import java.lang.invoke.VarHandle;

import static java.lang.foreign.ValueLayout.*;
import static volucris.engine.utils.FFMUtils.*;

/**
 * These are performance results returned by dynamic tree queries.
 */
public final class TreeStats {

	private static final StructLayout LAYOUT;

	private static final VarHandle NODE_VISITS;
	private static final VarHandle LEAF_VISITS;

	private final MemorySegment b2TreeStats;

	static {
		//@formatter:off
		LAYOUT = MemoryLayout.structLayout(
		        JAVA_INT.withName("nodeVisits"),
		        JAVA_INT.withName("leafVisits")
			).withName("b2TreeStats");
		//@formatter:on

		NODE_VISITS = varHandle(LAYOUT, "nodeVisits");
		LEAF_VISITS = varHandle(LAYOUT, "leafVisits");
	}

	public TreeStats() {
		this(Arena.ofAuto());
	}
	
	public TreeStats(Arena arena) {
		b2TreeStats = arena.allocate(LAYOUT);
	}

	public TreeStats(MemorySegment memorySegment) {
		b2TreeStats = memorySegment;
	}

	public void set(MemorySegment memorySegment) {
		MemorySegment.copy(memorySegment, 0, b2TreeStats, 0, LAYOUT.byteSize());
	}

	/**
	 * Number of internal nodes visited during the query.
	 */
	public int getNodeVisits() {
		return (int) NODE_VISITS.get(b2TreeStats);
	}

	/**
	 * Number of leaf nodes visited during the query.
	 */
	public int getLeafVisits() {
		return (int) LEAF_VISITS.get(b2TreeStats);
	}

	public MemorySegment memorySegment() {
		return b2TreeStats;
	}

	public static StructLayout LAYOUT() {
		return LAYOUT;
	}

}
