package volucris.engine.physics.box2d.contactEvents;

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
 * Contact events are buffered in the Box2D world and are available as event
 * arrays after the time step is complete.
 * <p>
 * Note: these may become invalid if bodies and/or shapes are destroyed.
 */
public final class ContactEvents {

	private static final StructLayout LAYOUT;

	private static final VarHandle BEGIN_EVENTS;
	private static final VarHandle END_EVENTS;
	private static final VarHandle HIT_EVENTS;
	private static final VarHandle BEGIN_COUNT;
	private static final VarHandle END_COUNT;
	private static final VarHandle HIT_COUNT;

	private final MemorySegment b2ContactEvents;

	private ContactBeginTouchEvent beginEvent;
	private ContactEndTouchEvent endEvent;
	private ContactHitEvent hitEvent;

	static {
		//@formatter:off
		AddressLayout UNBOUNDED_ADDRESS = ADDRESS.withTargetLayout(MemoryLayout.sequenceLayout(Long.MAX_VALUE, JAVA_BYTE));

		LAYOUT = MemoryLayout.structLayout(
				UNBOUNDED_ADDRESS.withName("beginEvents"),
				UNBOUNDED_ADDRESS.withName("endEvents"),
				UNBOUNDED_ADDRESS.withName("hitEvents"),
		        JAVA_INT.withName("beginCount"),
		        JAVA_INT.withName("endCount"),
		        JAVA_INT.withName("hitCount"),
		        MemoryLayout.paddingLayout(4)
			).withName("b2ContactEvents");
		//@formatter:on

		BEGIN_EVENTS = varHandle(LAYOUT, "beginEvents");
		END_EVENTS = varHandle(LAYOUT, "endEvents");
		HIT_EVENTS = varHandle(LAYOUT, "hitEvents");
		BEGIN_COUNT = varHandle(LAYOUT, "beginCount");
		END_COUNT = varHandle(LAYOUT, "endCount");
		HIT_COUNT = varHandle(LAYOUT, "hitCount");
	}

	public ContactEvents() {
		this(Arena.ofAuto());
	}

	public ContactEvents(Arena arena) {
		b2ContactEvents = arena.allocate(LAYOUT);

		beginEvent = new ContactBeginTouchEvent(arena);
		endEvent = new ContactEndTouchEvent(arena);
		hitEvent = new ContactHitEvent(arena);
	}

	public ContactEvents(MemorySegment memorySegment, World world) {
		this.b2ContactEvents = memorySegment;

		Arena arena = Arena.ofAuto();
		beginEvent = new ContactBeginTouchEvent(arena);
		endEvent = new ContactEndTouchEvent(arena);
		hitEvent = new ContactHitEvent(arena);

		beginEvent.setWorld(world);
		endEvent.setWorld(world);
		hitEvent.setWorld(world);
	}

	public void set(MemorySegment memorySegment, World world) {
		MemorySegment.copy(memorySegment, 0, b2ContactEvents, 0, LAYOUT.byteSize());

		beginEvent.setWorld(world);
		endEvent.setWorld(world);
		hitEvent.setWorld(world);
	}

	public void handleBeginEvents(ContactBeginHandler beginHandler) {
		int elementCount = getBeginCount();

		if (elementCount == 0)
			return;

		MemorySegment array = (MemorySegment) BEGIN_EVENTS.get(b2ContactEvents);

		long byteSize = ContactBeginTouchEvent.LAYOUT().byteSize();
		for (int i = 0; i < elementCount; i++) {
			long offset = i * byteSize;
			MemorySegment.copy(array, offset, beginEvent.memorySegment(), 0, byteSize);
			beginHandler.contactBegin(beginEvent);
		}
	}

	public void handleEndEvents(ContactEndHandler endHandler) {
		int elementCount = getEndCount();

		if (elementCount == 0)
			return;

		MemorySegment array = (MemorySegment) END_EVENTS.get(b2ContactEvents);

		for (int i = 0; i < elementCount; i++) {
			long offset = i * ContactEndTouchEvent.LAYOUT().byteSize();
			MemorySegment.copy(array, offset, endEvent.memorySegment(), 0, ContactEndTouchEvent.LAYOUT().byteSize());
			endHandler.contactEnd(endEvent);
		}

	}

	public void handleHitEvents(ContactHitHandler hitHandler) {
		int elementCount = getHitCount();

		if (elementCount == 0)
			return;

		MemorySegment array = (MemorySegment) HIT_EVENTS.get(b2ContactEvents);

		for (int i = 0; i < elementCount; i++) {
			long offset = i * ContactHitEvent.LAYOUT().byteSize();
			MemorySegment.copy(array, offset, hitEvent.memorySegment(), 0, ContactHitEvent.LAYOUT().byteSize());
			hitHandler.contactHit(hitEvent);
		}

	}

	/**
	 * Number of begin touch events.
	 */
	public int getBeginCount() {
		return (int) BEGIN_COUNT.get(b2ContactEvents);
	}

	/**
	 * Number of end touch events.
	 */
	public int getEndCount() {
		return (int) END_COUNT.get(b2ContactEvents);
	}

	/**
	 * Number of hit events.
	 */
	public int getHitCount() {
		return (int) HIT_COUNT.get(b2ContactEvents);
	}

	public static StructLayout LAYOUT() {
		return LAYOUT;
	}

}
