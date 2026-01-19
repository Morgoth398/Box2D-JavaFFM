package volucris.engine.physics.box2d.bodyEvents;

@FunctionalInterface
public interface BodyMoveHandler {

	/**
	 * Do not store a reference to the move event. It will be reused internally.
	 */
	void bodyMove(BodyMoveEvent moveEvent);

}
