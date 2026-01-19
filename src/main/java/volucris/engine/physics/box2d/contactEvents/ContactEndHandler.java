package volucris.engine.physics.box2d.contactEvents;

@FunctionalInterface
public interface ContactEndHandler {

	/**
	 * Do not store a reference to the end event. It will be reused internally.
	 */
	void contactEnd(ContactEndTouchEvent endEvent);
}
