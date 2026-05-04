package volucris.engine.physics.box2d.contactEvents;

import org.joml.Vector2f;

import volucris.engine.physics.box2d.collision.Manifold;
import volucris.engine.physics.box2d.shape.Shape;
import volucris.engine.physics.box2d.world.World;

public abstract class ContactListener implements ContactBeginHandler, ContactEndHandler, ContactHitHandler {

	private ContactEvents contactEvents;

	private Vector2f vectorTmp1;
	private Vector2f vectorTmp2;

	public ContactListener() {
		contactEvents = new ContactEvents();

		vectorTmp1 = new Vector2f();
		vectorTmp2 = new Vector2f();
	}

	public final void handleContactEvents(World world) {
		world.getContactEvents(contactEvents);

		contactEvents.handleBeginEvents(this);
		contactEvents.handleEndEvents(this);
		contactEvents.handleHitEvents(this);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void contactBegin(ContactBeginTouchEvent beginEvent) {
		contactBegin(beginEvent.getShapeA(), beginEvent.getShapeB(), beginEvent.getManifold());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void contactEnd(ContactEndTouchEvent endEvent) {
		contactEnd(endEvent.getShapeA(), endEvent.getShapeB());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void contactHit(ContactHitEvent hitEvent) {
		Vector2f point = hitEvent.getPoint(vectorTmp1);
		Vector2f normal = hitEvent.getNormal(vectorTmp2);
		contactHit(hitEvent.getShapeA(), hitEvent.getShapeB(), point, normal);
	}

	/**
	 * Handle the contact begin event.
	 * <p>
	 * Do not keep a reference to the manifold.
	 */
	protected abstract void contactBegin(Shape shapeA, Shape shapeB, Manifold manifold);

	/**
	 * Handle the contact end event.
	 */
	protected abstract void contactEnd(Shape shapeA, Shape shapeB);

	/**
	 * Handle the contact hit event.
	 * <p>
	 * Do not keep a reference to the point and normal vectors.
	 */
	protected abstract void contactHit(Shape shapeA, Shape shapeB, Vector2f point, Vector2f normal);

}
