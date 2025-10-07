package volucris.engine.physics.box2d.shape;

/**
 * <ul>
 * <li>CIRCLE_SHAPE: A circle with an offset.
 * <li>CAPSULE_SHAPE: A capsule is an extruded cirlce.
 * <li>SEGMENT_SHAPE: A line segment.
 * <li>POLYGON_SHAPE: A convex polygon.
 * <li>CHAIN_SEGMENT_SHAPE: A line segment owned by a chain shape.
 * </ul>
 */
public enum ShapeType {
	CIRCLE_SHAPE(0), CAPSULE_SHAPE(1), SEGMENT_SHAPE(2), POLYGON_SHAPE(3), CHAIN_SEGMENT_SHAPE(4);

	private int id;

	ShapeType(int id) {
		this.id = id;
	}

	public int id() {
		return id;
	}

}
