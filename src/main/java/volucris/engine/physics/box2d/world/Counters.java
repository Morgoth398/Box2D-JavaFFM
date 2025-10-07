package volucris.engine.physics.box2d.world;

import java.lang.foreign.Arena;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.StructLayout;
import java.lang.invoke.VarHandle;

import static java.lang.foreign.ValueLayout.*;
import static volucris.engine.utils.FFMUtils.*;

public final class Counters {

	private static final StructLayout LAYOUT;

	private static final VarHandle BODY_COUNT;
	private static final VarHandle SHAPE_COUNT;
	private static final VarHandle CONTACT_COUNT;
	private static final VarHandle JOINT_COUNT;
	private static final VarHandle ISLAND_COUNT;
	private static final VarHandle STACK_USED;
	private static final VarHandle STATIC_TREE_HEIGHT;
	private static final VarHandle TREE_HEIGHT;
	private static final VarHandle BYTE_COUNT;
	private static final VarHandle TASK_COUNT;

	private final MemorySegment b2Counters;

	static {
		//@formatter:off
		LAYOUT = MemoryLayout.structLayout(
		        JAVA_INT.withName("bodyCount"),
		        JAVA_INT.withName("shapeCount"),
		        JAVA_INT.withName("contactCount"),
		        JAVA_INT.withName("jointCount"),
		        JAVA_INT.withName("islandCount"),
		        JAVA_INT.withName("stackUsed"),
		        JAVA_INT.withName("staticTreeHeight"),
		        JAVA_INT.withName("treeHeight"),
		        JAVA_INT.withName("byteCount"),
		        JAVA_INT.withName("taskCount"),
		        MemoryLayout.sequenceLayout(12, JAVA_INT).withName("colorCounts")
			).withName("b2Counters");
		//@formatter:on

		BODY_COUNT = varHandle(LAYOUT, "bodyCount");
		SHAPE_COUNT = varHandle(LAYOUT, "shapeCount");
		CONTACT_COUNT = varHandle(LAYOUT, "contactCount");
		JOINT_COUNT = varHandle(LAYOUT, "jointCount");
		ISLAND_COUNT = varHandle(LAYOUT, "islandCount");
		STACK_USED = varHandle(LAYOUT, "stackUsed");
		STATIC_TREE_HEIGHT = varHandle(LAYOUT, "staticTreeHeight");
		TREE_HEIGHT = varHandle(LAYOUT, "treeHeight");
		BYTE_COUNT = varHandle(LAYOUT, "byteCount");
		TASK_COUNT = varHandle(LAYOUT, "taskCount");
	}

	public Counters() {
		b2Counters = Arena.ofAuto().allocate(LAYOUT);
	}

	public Counters(MemorySegment memorySegment) {
		b2Counters = memorySegment;
	}

	public void set(MemorySegment memorySegment) {
		MemorySegment.copy(memorySegment, 0L, b2Counters, 0L, LAYOUT.byteSize());
	}

	public int getBodyCount() {
		return (int) BODY_COUNT.get(b2Counters);
	}

	public int getShapeCount() {
		return (int) SHAPE_COUNT.get(b2Counters);
	}

	public int getContactCount() {
		return (int) CONTACT_COUNT.get(b2Counters);
	}

	public int getJointCount() {
		return (int) JOINT_COUNT.get(b2Counters);
	}

	public int getIslandCount() {
		return (int) ISLAND_COUNT.get(b2Counters);
	}

	public int getStackUsed() {
		return (int) STACK_USED.get(b2Counters);
	}

	public int getStaticTreeheight() {
		return (int) STATIC_TREE_HEIGHT.get(b2Counters);
	}

	public int getTreeHeight() {
		return (int) TREE_HEIGHT.get(b2Counters);
	}

	public int getByteCount() {
		return (int) BYTE_COUNT.get(b2Counters);
	}

	public int getTaskCount() {
		return (int) TASK_COUNT.get(b2Counters);
	}

	public MemorySegment memorySegment() {
		return b2Counters;
	}

	public static StructLayout LAYOUT() {
		return LAYOUT;
	}

}
