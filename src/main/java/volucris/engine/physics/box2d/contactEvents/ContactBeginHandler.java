package volucris.engine.physics.box2d.contactEvents;

@FunctionalInterface
public interface ContactBeginHandler {
	
	/**
	 * Do not store a reference to the begin event. It will be reused internally.
	 */
	void contactBegin(ContactBeginTouchEvent beginEvent);
}
