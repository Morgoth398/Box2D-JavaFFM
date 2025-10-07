package volucris.engine.physics.box2d.sensorEvents;

@FunctionalInterface
public interface SensorEndHandler {
	
	/**
	 * Do not store a reference to the end event. It will be reused internally.
	 */
	void sensorEnd(SensorEndTouchEvent endEvent);
}
