package volucris.engine.physics.box2d.bodyEvents;

import java.lang.foreign.Arena;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.StructLayout;
import java.lang.invoke.VarHandle;

import volucris.engine.physics.box2d.world.World;

import static java.lang.foreign.ValueLayout.*;
import static volucris.engine.utils.FFMUtils.*;

/**
 * Body events are buffered in the Box2D world and are available as event arrays
 * after the time step is complete.
 * <p>
 * Note: this data becomes invalid if bodies are destroyed
 */
public final class BodyEvents {

	private static final StructLayout LAYOUT;

	private static final VarHandle MOVE_EVENTS;
	private static final VarHandle MOVE_COUNT;

	private final MemorySegment b2BodyEvents;

	private BodyMoveEvent bodyMoveEvent;

	static {
		//@formatter:off
		LAYOUT = MemoryLayout.structLayout(
		        ADDRESS.withName("moveEvents"),
		        JAVA_INT.withName("moveCount"),
		        MemoryLayout.paddingLayout(4)
			);
		//@formatter:on

		MOVE_EVENTS = varHandle(LAYOUT, "moveEvents");
		MOVE_COUNT = varHandle(LAYOUT, "moveCount");
	}

	public BodyEvents() {
		Arena arena = Arena.ofAuto();
		
		b2BodyEvents = arena.allocate(LAYOUT);
		
		bodyMoveEvent = new BodyMoveEvent(arena);
	}

	public BodyEvents(MemorySegment memorySegment, World world) {
		this.b2BodyEvents = memorySegment;
		
		bodyMoveEvent = new BodyMoveEvent();
		bodyMoveEvent.setWorld(world);
	}

	public void set(MemorySegment memorySegment, World world) {
		MemorySegment.copy(memorySegment, 0L, b2BodyEvents, 0L, LAYOUT.byteSize());
		bodyMoveEvent.setWorld(world);
	}

	public void handleMoveEvents(BodyMoveHandler moveHandler) {
		int elementCount = getMoveCount();

		long arraySize = elementCount * BodyMoveEvent.LAYOUT().byteSize();
		MemorySegment array = ((MemorySegment) MOVE_EVENTS.get(b2BodyEvents)).reinterpret(arraySize);

		for (int i = 0; i < elementCount; i++) {
			long offset = i * BodyMoveEvent.LAYOUT().byteSize();
			MemorySegment.copy(array, offset, bodyMoveEvent.memorySegment(), 0, BodyMoveEvent.LAYOUT().byteSize());
			moveHandler.bodyMove(bodyMoveEvent);
		}
	}

	/**
	 * Number of move events.
	 */
	public int getMoveCount() {
		return (int) MOVE_COUNT.get(b2BodyEvents);
	}

	public static StructLayout LAYOUT() {
		return LAYOUT;
	}

}
