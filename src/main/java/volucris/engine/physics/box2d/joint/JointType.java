package volucris.engine.physics.box2d.joint;

public enum JointType {

	DISTANCE_JOINT(0), FILTER_JOINT(1), MOTOR_JOINT(2), MOUSE_JOINT(3), PRISMATIC_JOINT(4), REVOLUTE_JOINT(5),
	WELD_JOINT(6), WHEEL_JOINT(7);

	private int id;

	JointType(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

}
