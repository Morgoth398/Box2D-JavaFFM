package volucris.engine.physics.box2d.body;

/**
 * The body simulation type.
 * 
 * Each body is one of these three types. The type determines how the body
 * behaves in the simulation.
 * <p>
 * <ul>
 * <li>STATIC_BODY: zero mass, zero velocity, may be manually moved.
 * <li>KINMEATIC_BODY: zero mass, velocity set by user, moved by solver.
 * <li>DYNAMIC_BOdY: positive mass, velocity determined by forces, moved by
 * solver.
 * </ul>
 */
public enum BodyType {
	STATIC_BODY(0), KINEMATIC_BODY(1), DYNAMIC_BODY(2);

	private int id;

	BodyType(int id) {
		this.id = id;
	}

	public int id() {
		return id;
	}

}
