package volucris.engine.physics.box2d.contactEvents;

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

	private World world;
	
	private ContactBeginTouchEvent beginEvent;
	private ContactEndTouchEvent endEvent;
	private ContactHitEvent hitEvent;
	
	static {
		//@formatter:off
		LAYOUT = MemoryLayout.structLayout(
				ADDRESS.withName("beginEvents"),
				ADDRESS.withName("endEvents"),
				ADDRESS.withName("hitEvents"),
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
		b2ContactEvents = Arena.ofAuto().allocate(LAYOUT);
		
		beginEvent = new ContactBeginTouchEvent();
		endEvent = new ContactEndTouchEvent();
		hitEvent = new ContactHitEvent(); 
	}

	public ContactEvents(MemorySegment memorySegment, World world) {
		this.b2ContactEvents = memorySegment;
		this.world = world;
	}

	public void set(MemorySegment memorySegment, World world) {
		MemorySegment.copy(memorySegment, 0L, b2ContactEvents, 0L, LAYOUT.byteSize());
		this.world = world;
	}

	public void handleBeginEvents(ContactBeginHandler beginHandler) {
		int elementCount = getBeginCount();
		
		long arraySize = elementCount * ContactBeginTouchEvent.LAYOUT().byteSize();
		MemorySegment array = ((MemorySegment) BEGIN_EVENTS.get(b2ContactEvents)).reinterpret(arraySize);
		
		for (int i = 0; i < elementCount; i++) {
			long offset = i * ContactBeginTouchEvent.LAYOUT().byteSize();
			beginEvent.set(array.asSlice(offset, ContactBeginTouchEvent.LAYOUT()), world);
			beginHandler.contactBegin(beginEvent);
		}
	}

	public void handleEndEvents(ContactEndHandler endHandler) {
		int elementCount = getEndCount();
		
		long arraySize = elementCount * ContactEndTouchEvent.LAYOUT().byteSize();
		MemorySegment array = ((MemorySegment) END_EVENTS.get(b2ContactEvents)).reinterpret(arraySize);
		
		for (int i = 0; i < elementCount; i++) {
			long offset = i * ContactEndTouchEvent.LAYOUT().byteSize();
			endEvent.set(array.asSlice(offset, ContactEndTouchEvent.LAYOUT()), world);
			endHandler.contactEnd(endEvent);
		}
		
	}
	
	public void handleHitEvents(ContactHitHandler hitHandler) {
		int elementCount = getHitCount();
		
		long arraySize = elementCount * ContactHitEvent.LAYOUT().byteSize();
		MemorySegment array = ((MemorySegment) HIT_EVENTS.get(b2ContactEvents)).reinterpret(arraySize);
		
		for (int i = 0; i < elementCount; i++) {
			long offset = i * ContactHitEvent.LAYOUT().byteSize();
			hitEvent.set(array.asSlice(offset, ContactHitEvent.LAYOUT()), world);
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
