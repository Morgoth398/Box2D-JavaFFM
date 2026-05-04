package volucris.engine.physics.box2d.utils;

public final class Box2DRuntimeException extends RuntimeException {
	private static final long serialVersionUID = 5110412887151439333L;

	public Box2DRuntimeException(String message) {
		super(message);
	}

	public Box2DRuntimeException(Throwable throwable) {
		super(throwable);
	}

	public Box2DRuntimeException(String message, Throwable throwable) {
		super(message, throwable);
	}
}
