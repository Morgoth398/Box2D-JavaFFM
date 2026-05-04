package volucris.engine.physics.box2d.sensorEvents;

@FunctionalInterface
public interface SensorBeginHandler {
	
	/**
	 * Do not store a reference to the begin event. It will be reused internally.
	 */
	void sensorBegin(SensorBeginTouchEvent beginEvent);
}
