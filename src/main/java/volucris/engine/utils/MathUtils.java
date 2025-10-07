package volucris.engine.utils;

import java.util.Random;

import org.joml.Vector2f;

public final class MathUtils {

	private static Random random = new Random();

	private MathUtils() {

	}

	public static float round(float value, int precision) {
		int scale = (int) Math.pow(10, precision);
		return (float) Math.round(value * scale) / scale;
	}

	public static float toRadians(float degrees) {
		return (float) (degrees * Math.PI / 180);
	}

	public static float toDegrees(float radians) {
		return (float) (radians * 180 / Math.PI);
	}

	public static float sinDegrees(float degrees) {
		return (float) Math.sin(toRadians(degrees));
	}

	public static float cosDegrees(float degrees) {
		return (float) Math.cos(toRadians(degrees));
	}

	public static float tanDegrees(float degrees) {
		return (float) Math.tan(toRadians(degrees));
	}

	public static float sinRadians(float radians) {
		return (float) Math.sin(radians);
	}

	public static float cosRadians(float radians) {
		return (float) Math.cos(radians);
	}

	public static float tanRadians(float radians) {
		return (float) Math.tan(radians);
	}

	public static float asinDegrees(float value) {
		return toDegrees((float) Math.asin(value));
	}

	public static float acosDegrees(float value) {
		return toDegrees((float) Math.acos(value));
	}

	public static float atanDegrees(float value) {
		return toDegrees((float) Math.atan(value));
	}

	public static float asinRadians(float value) {
		return (float) Math.asin(value);
	}

	public static float acosRadians(float value) {
		return (float) Math.acos(value);
	}

	public static float atanRadians(float value) {
		return (float) Math.atan(value);
	}

	/**
	 * Returns a random number between 0 (inclusive) and the specified value
	 * (inclusive).
	 */
	public static int random(int range) {
		return random.nextInt(range + 1);
	}

	/**
	 * Returns a random number between 0 (inclusive) and the specified value
	 * (exclusive).
	 */
	public static float random(float range) {
		return random.nextFloat(range);
	}

	/**
	 * Returns a random number between start (inclusive) and end (inclusive).
	 */
	public static int random(int start, int end) {
		return random.nextInt(start, end + 1);
	}

	/**
	 * Returns a random number between start (inclusive) and end (exclusive).
	 */
	public static float random(float start, float end) {
		return random.nextFloat(start, end);
	}

	public static float rotatePointXDegrees(float x, float y, float centerX, float centerY, float degrees) {
		return centerX + (x - centerX) * cosDegrees(degrees) - (y - centerY) * sinDegrees(degrees);
	}

	public static float rotatePointXRadians(float x, float y, float centerX, float centerY, float radians) {
		return centerX + (x - centerX) * cosRadians(radians) - (y - centerY) * sinRadians(radians);
	}

	public static float rotatePointYDegrees(float x, float y, float centerX, float centerY, float degrees) {
		return centerY + (x - centerX) * sinDegrees(degrees) + (y - centerY) * cosDegrees(degrees);
	}

	public static float rotatePointYRadians(float x, float y, float centerX, float centerY, float radians) {
		return centerY + (x - centerX) * sinRadians(radians) + (y - centerY) * cosRadians(radians);
	}

	public static Vector2f rotatePointDegrees(float x, float y, float centerX, float centerY, float degrees,
			Vector2f target) {
		target.x = rotatePointXDegrees(x, y, centerX, centerY, degrees);
		target.y = rotatePointYDegrees(x, y, centerX, centerY, degrees);
		return target;
	}

	public static Vector2f rotatePointRadians(float x, float y, float centerX, float centerY, float radians,
			Vector2f target) {
		target.x = rotatePointXRadians(x, y, centerX, centerY, radians);
		target.y = rotatePointYRadians(x, y, centerX, centerY, radians);
		return target;
	}

	public static float clamp(float value, float min, float max) {
		if (value < min)
			return min;
		if (value > max)
			return max;
		return value;
	}

	public static int clamp(int value, int min, int max) {
		if (value < min)
			return min;
		if (value > max)
			return max;
		return value;
	}

	public static float sqrt(float value) {
		return (float) Math.sqrt(value);
	}

	public static int ceil(float value) {
		return (int) Math.ceil(value);
	}

	public static int floor(float value) {
		return (int) Math.floor(value);
	}

	public static int roundPositive(float value) {
		return (int) (value + 0.5f);
	}

	public static int max(int value1, int value2) {
		if (value1 > value2)
			return value1;
		return value2;
	}

	public static int min(int value1, int value2) {
		if (value1 < value2)
			return value1;
		return value2;
	}

	public static float max(float value1, float value2) {
		if (value1 > value2)
			return value1;
		return value2;
	}

	public static float min(float value1, float value2) {
		if (value1 < value2)
			return value1;
		return value2;
	}

	public static float pow(float base, float exponent) {
		return (float) Math.pow(base, exponent);
	}

	public static float log(float base, float value) {
		return (float) (Math.log(value) / Math.log(base));
	}

	/**
	 * Returns the natural logarithm (base e) of a float value.
	 * 
	 * @param value The value
	 */
	public static float log(float value) {
		return (float) Math.log(value);
	}

	public static float log10(float value) {
		return (float) Math.log10(value);
	}

}
