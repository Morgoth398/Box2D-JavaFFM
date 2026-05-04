package volucris.engine.physics.box2d.contactEvents;

@FunctionalInterface
public interface ContactHitHandler {
	/**
	 * Do not store a reference to the hit event. It will be reused internally.
	 */
	void contactHit(ContactHitEvent hitEvent);
}
