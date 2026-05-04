package volucris.engine.physics.box2d.sensorEvents;

import volucris.engine.physics.box2d.world.World;

public abstract class SensorListener implements SensorBeginHandler, SensorEndHandler {

	private SensorEvents sensorEvents;

	public SensorListener() {
		sensorEvents = new SensorEvents();
	}

	public final void handleSensorEvents(World world) {
		world.getSensorEvents(sensorEvents);

		sensorEvents.handleBeginEvents(this);
		sensorEvents.handleEndEvents(this);
	}

}
