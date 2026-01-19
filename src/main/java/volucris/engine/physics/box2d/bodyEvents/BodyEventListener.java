package volucris.engine.physics.box2d.bodyEvents;

import volucris.engine.physics.box2d.world.World;

public abstract class BodyEventListener implements BodyMoveHandler {

	private BodyEvents bodyEvents;

	public BodyEventListener() {
		bodyEvents = new BodyEvents();
	}

	public final void handleBodyEvents(World world) {
		world.getBodyEvents(bodyEvents);

		bodyEvents.handleMoveEvents(this);
	}

}
