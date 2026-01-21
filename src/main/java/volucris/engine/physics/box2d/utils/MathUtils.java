package volucris.engine.physics.box2d.utils;

public final class MathUtils {

	private MathUtils() {

	}

	public static float toRadians(float degrees) {
		return (float) (degrees * Math.PI / 180);
	}

	public static float toDegrees(float radians) {
		return (float) (radians * 180 / Math.PI);
	}

}
