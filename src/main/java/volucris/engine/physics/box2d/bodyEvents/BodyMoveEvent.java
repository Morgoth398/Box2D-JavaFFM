package volucris.engine.physics.box2d.bodyEvents;

import java.lang.foreign.Arena;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.StructLayout;
import java.lang.invoke.VarHandle;

import volucris.engine.physics.box2d.Box2D;
import volucris.engine.physics.box2d.body.Body;
import volucris.engine.physics.box2d.math.Transform;
import volucris.engine.physics.box2d.world.World;

import static java.lang.foreign.ValueLayout.*;
import static volucris.engine.utils.FFMUtils.*;

/**
 * Body move events triggered when a body moves.
 * <p>
 * Triggered when a body moves due to simulation. Not reported for bodies moved
 * by the user. This also has a flag to indicate that the body went to sleep so
 * the application can also sleep that actor/entity/object associated with the
 * body. On the other hand if the flag does not indicate the body went to sleep
 * then the application can treat the actor/entity/object associated with the
 * body as awake. This is an efficient way for an application to update game
 * object transforms rather than calling functions such as
 * {@link Body#getTransform()} because this data is delivered as a contiguous
 * array and it is only populated with bodies that have moved.
 * <p>
 * Note: If sleeping is disabled all dynamic and kinematic bodies will trigger
 * move events.
 */
public final class BodyMoveEvent {

	private static final StructLayout LAYOUT;

	private static final VarHandle FELL_ASLEEP;

	private static final long TRANSFORM_OFFSET;
	private static final long BODY_ID_OFFSET;

	private final MemorySegment b2BodyMoveEvent;
	
	private final Transform transform;

	private World world;

	static {
		//@formatter:off
		LAYOUT = MemoryLayout.structLayout(
				Transform.LAYOUT().withName("transform"),
		        Body.LAYOUT().withName("bodyId"),
		        ADDRESS.withName("userData"),
		        JAVA_BOOLEAN.withName("fellAsleep"),
		        MemoryLayout.paddingLayout(7)
			).withName("b2BodyMoveEvent");
		//@formatter:on

		FELL_ASLEEP = varHandle(LAYOUT, "gellAsleep");

		TRANSFORM_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("transform"));
		BODY_ID_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("bodyId"));
	}

	public BodyMoveEvent() {
		this(Arena.ofAuto());
	}
	
	public BodyMoveEvent(Arena arena) {
		b2BodyMoveEvent = arena.allocate(LAYOUT);
		
		transform = new Transform(b2BodyMoveEvent.asSlice(TRANSFORM_OFFSET, Transform.LAYOUT()));
	}

	public BodyMoveEvent(MemorySegment memorySegment, World world) {
		this.b2BodyMoveEvent = memorySegment;
		this.world = world;
		
		transform = new Transform(b2BodyMoveEvent.asSlice(TRANSFORM_OFFSET, Transform.LAYOUT()));
	}

	public void set(MemorySegment memorySegment, World world) {
		MemorySegment.copy(memorySegment, 0, b2BodyMoveEvent, 0, LAYOUT.byteSize());
		this.world = world;
	}

	/**
	 * Get the new transform.
	 * <p>
	 * Do not keep a reference.
	 */
	public Transform getTransform() {
		return transform;
	}

	public Body getBody() {
		MemorySegment bodyId = b2BodyMoveEvent.asSlice(BODY_ID_OFFSET, Body.LAYOUT());
		return Box2D.getBody(Body.getBodyId(bodyId), world);
	}

	public boolean fellAsleep() {
		return (boolean) FELL_ASLEEP.get(b2BodyMoveEvent);
	}

	public void setWorld(World world) {
		this.world = world;
	}
	
	public MemorySegment memorySegment() {
		return b2BodyMoveEvent;
	}
	
	public static StructLayout LAYOUT() {
		return LAYOUT;
	}

}
