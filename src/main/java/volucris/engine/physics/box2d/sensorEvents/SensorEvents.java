package volucris.engine.physics.box2d.sensorEvents;

import java.lang.foreign.AddressLayout;
import java.lang.foreign.Arena;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.StructLayout;
import java.lang.invoke.VarHandle;

import volucris.engine.physics.box2d.world.World;

import static java.lang.foreign.ValueLayout.*;
import static volucris.engine.utils.FFMUtils.*;

/**
 * Sensor events are buffered in the Box2D world and are available as begin/end
 * overlap event arrays after the time step is complete.
 * <p>
 * Note: these may become invalid if bodies and/or shapes are destroyed
 * 
 */
public final class SensorEvents {

	private static final StructLayout LAYOUT;

	private static final VarHandle BEGIN_EVENTS;
	private static final VarHandle END_EVENTS;
	private static final VarHandle BEGIN_COUNT;
	private static final VarHandle END_COUNT;

	private final MemorySegment b2SensorEvents;

	private SensorBeginTouchEvent beginEvent;
	private SensorEndTouchEvent endEvent;

	static {
		//@formatter:off
		AddressLayout UNBOUNDED_ADDRESS = ADDRESS.withTargetLayout(MemoryLayout.sequenceLayout(Long.MAX_VALUE, JAVA_BYTE));
		
		LAYOUT = MemoryLayout.structLayout(
				UNBOUNDED_ADDRESS.withName("beginEvents"),
				UNBOUNDED_ADDRESS.withName("endEvents"),
		        JAVA_INT.withName("beginCount"),
		        JAVA_INT.withName("endCount")
			).withName("b2SensorEvents");
		//@formatter:on

		BEGIN_EVENTS = varHandle(LAYOUT, "beginEvents");
		END_EVENTS = varHandle(LAYOUT, "endEvents");
		BEGIN_COUNT = varHandle(LAYOUT, "beginCount");
		END_COUNT = varHandle(LAYOUT, "endCount");
	}

	public SensorEvents() {
		this(Arena.ofAuto());
	}

	public SensorEvents(Arena arena) {
		b2SensorEvents = arena.allocate(LAYOUT);

		beginEvent = new SensorBeginTouchEvent(arena);
		endEvent = new SensorEndTouchEvent(arena);
	}

	public SensorEvents(MemorySegment memorySegment, World world) {
		this.b2SensorEvents = memorySegment;

		Arena arena = Arena.ofAuto();
		beginEvent = new SensorBeginTouchEvent(arena);
		endEvent = new SensorEndTouchEvent(arena);

		beginEvent.setWorld(world);
		endEvent.setWorld(world);
	}

	public void set(MemorySegment memorySegment, World world) {
		MemorySegment.copy(memorySegment, 0L, b2SensorEvents, 0L, LAYOUT.byteSize());

		beginEvent.setWorld(world);
		endEvent.setWorld(world);
	}

	public void handleBeginEvents(SensorBeginHandler beginHandler) {
		int elementCount = getBeginCount();

		if (elementCount == 0)
			return;

		MemorySegment array = (MemorySegment) BEGIN_EVENTS.get(b2SensorEvents);

		for (int i = 0; i < elementCount; i++) {
			long offset = i * SensorBeginTouchEvent.LAYOUT().byteSize();
			MemorySegment.copy(array, offset, beginEvent.memorySegment(), 0, SensorBeginTouchEvent.LAYOUT().byteSize());
			beginHandler.sensorBegin(beginEvent);
		}
	}

	public void handleEndEvents(SensorEndHandler endHandler) {
		int elementCount = getEndCount();

		if (elementCount == 0)
			return;

		MemorySegment array = (MemorySegment) END_EVENTS.get(b2SensorEvents);

		for (int i = 0; i < elementCount; i++) {
			long offset = i * SensorEndTouchEvent.LAYOUT().byteSize();
			MemorySegment.copy(array, offset, endEvent.memorySegment(), 0, SensorEndTouchEvent.LAYOUT().byteSize());
			;
			endHandler.sensorEnd(endEvent);
		}

	}

	/**
	 * The number of begin sensor events.
	 */
	public int getBeginCount() {
		return (int) BEGIN_COUNT.get(b2SensorEvents);
	}

	/**
	 * The number of end sensor events.
	 */
	public int getEndCount() {
		return (int) END_COUNT.get(b2SensorEvents);
	}

	public static StructLayout LAYOUT() {
		return LAYOUT;
	}
}
