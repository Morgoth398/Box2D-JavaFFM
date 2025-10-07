package volucris.engine.physics.box2d.bodyEvents;

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

	private final Transform transform;

	private Body body;

	private boolean fellAsleep;

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
		transform = new Transform();
	}

	public BodyMoveEvent(MemorySegment memorySegment, World world) {
		transform = new Transform();
		transform.set(memorySegment.asSlice(TRANSFORM_OFFSET, Transform.LAYOUT()));

		MemorySegment bodyIdSegment = memorySegment.asSlice(BODY_ID_OFFSET, Body.LAYOUT());
		body = Box2D.getBody(Body.getBodyId(bodyIdSegment), world);

		fellAsleep = (boolean) FELL_ASLEEP.get(memorySegment);
	}

	public void set(MemorySegment memorySegment, World world) {
		transform.set(memorySegment.asSlice(TRANSFORM_OFFSET, Transform.LAYOUT()));

		MemorySegment bodyIdSegment = memorySegment.asSlice(BODY_ID_OFFSET, Body.LAYOUT());
		body = Box2D.getBody(Body.getBodyId(bodyIdSegment), world);

		fellAsleep = (boolean) FELL_ASLEEP.get(memorySegment);
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
		return body;
	}

	public boolean fellAsleep() {
		return fellAsleep;
	}

	public static StructLayout LAYOUT() {
		return LAYOUT;
	}

}
