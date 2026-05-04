package volucris.engine.physics.box2d.joint;

import java.lang.foreign.Arena;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.StructLayout;
import java.lang.foreign.MemoryLayout.PathElement;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;

import org.joml.Vector2f;

import volucris.engine.physics.box2d.body.Body;
import volucris.engine.physics.box2d.math.Vec2;
import volucris.engine.utils.Box2DRuntimeException;

import static java.lang.foreign.ValueLayout.*;
import static volucris.engine.utils.FFMUtils.*;

/**
 * Wheel joint definition.
 * <p>
 * This requires defining a line of motion using an axis and an anchor point.
 * The definition uses local anchor points and a local axis so that the initial
 * configuration can violate the constraint slightly. The joint translation is
 * zero when the local anchor points coincide in world space.
 * 
 */
public final class WheelJointDef {

	private static final StructLayout LAYOUT;

	private static final VarHandle ENABLE_SPRING;
	private static final VarHandle HERTZ;
	private static final VarHandle DAMPING_RATIO;
	private static final VarHandle ENABLE_LIMIT;
	private static final VarHandle LOWER_TRANSLATION;
	private static final VarHandle UPPER_TRANSLATION;
	private static final VarHandle ENABLE_MOTOR;
	private static final VarHandle MAX_MOTOR_TORQUE;
	private static final VarHandle MOTOR_SPEED;
	private static final VarHandle COLLIDE_CONNECTED;

	private static final MethodHandle B2_DEFAULT_WHEEL_JOINT_DEF;

	private static final long BODY_ID_A_OFFSET;
	private static final long BODY_ID_B_OFFSET;
	private static final long LOCAL_ANCHOR_A_OFFSET;
	private static final long LOCAL_ANCHOR_B_OFFSET;
	private static final long LOCAL_AXIS_A_OFFSET;

	private final MemorySegment b2WheelJointDef;

	private final Vec2 localAnchorA;
	private final Vec2 localAnchorB;
	private final Vec2 localAxisA;

	static {
		//@formatter:off
		LAYOUT = MemoryLayout.structLayout(
		        Body.LAYOUT().withName("bodyIdA"),
		        Body.LAYOUT().withName("bodyIdB"),
		        Vec2.LAYOUT().withName("localAnchorA"),
		        Vec2.LAYOUT().withName("localAnchorB"),
		        Vec2.LAYOUT().withName("localAxisA"),
		        JAVA_BOOLEAN.withName("enableSpring"),
		        MemoryLayout.paddingLayout(3),
		        JAVA_FLOAT.withName("hertz"),
		        JAVA_FLOAT.withName("dampingRatio"),
		        JAVA_BOOLEAN.withName("enableLimit"),
		        MemoryLayout.paddingLayout(3),
		        JAVA_FLOAT.withName("lowerTranslation"),
		        JAVA_FLOAT.withName("upperTranslation"),
		        JAVA_BOOLEAN.withName("enableMotor"),
		        MemoryLayout.paddingLayout(3),
		        JAVA_FLOAT.withName("maxMotorTorque"),
		        JAVA_FLOAT.withName("motorSpeed"),
		        JAVA_BOOLEAN.withName("collideConnected"),
		        MemoryLayout.paddingLayout(3),
		        ADDRESS.withName("userData"),
		        JAVA_INT.withName("internalValue"),
		        MemoryLayout.paddingLayout(4)
			).withName("b2WheelJointDef");
		//@formatter:on

		ENABLE_SPRING = varHandle(LAYOUT, "enableSpring");
		HERTZ = varHandle(LAYOUT, "hertz");
		DAMPING_RATIO = varHandle(LAYOUT, "dampingRatio");
		ENABLE_LIMIT = varHandle(LAYOUT, "enableLimit");
		LOWER_TRANSLATION = varHandle(LAYOUT, "lowerTranslation");
		UPPER_TRANSLATION = varHandle(LAYOUT, "upperTranslation");
		ENABLE_MOTOR = varHandle(LAYOUT, "enableMotor");
		MAX_MOTOR_TORQUE = varHandle(LAYOUT, "maxMotorTorque");
		MOTOR_SPEED = varHandle(LAYOUT, "motorSpeed");
		COLLIDE_CONNECTED = varHandle(LAYOUT, "collideConnected");

		B2_DEFAULT_WHEEL_JOINT_DEF = downcallHandle("b2DefaultWheelJointDef", LAYOUT);

		BODY_ID_A_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("bodyIdA"));
		BODY_ID_B_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("bodyIdB"));
		LOCAL_ANCHOR_A_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("localAnchorA"));
		LOCAL_ANCHOR_B_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("localAnchorB"));
		LOCAL_AXIS_A_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("localAxisA"));
	}

	public WheelJointDef() {
		this(Arena.ofAuto());
	}

	public WheelJointDef(Arena arena) {
		try {
			b2WheelJointDef = (MemorySegment) B2_DEFAULT_WHEEL_JOINT_DEF.invoke(arena);
		} catch (Throwable e) {
			String className = e.getClass().getSimpleName();
			throw new Box2DRuntimeException("Cannot create distance joint def: " + className);
		}

		localAnchorA = new Vec2(b2WheelJointDef.asSlice(LOCAL_ANCHOR_A_OFFSET, Vec2.LAYOUT()));
		localAnchorB = new Vec2(b2WheelJointDef.asSlice(LOCAL_ANCHOR_B_OFFSET, Vec2.LAYOUT()));
		localAxisA = new Vec2(b2WheelJointDef.asSlice(LOCAL_AXIS_A_OFFSET, Vec2.LAYOUT()));
	}

	/**
	 * The local anchor point relative to bodyA's origin.
	 */
	public void setLocalAnchorA(float x, float y) {
		localAnchorA.set(x, y);
	}

	/**
	 * The local anchor point relative to bodyA's origin.
	 */
	public void setLocalAnchorA(Vector2f localAnchor) {
		localAnchorA.set(localAnchor);
	}

	/**
	 * The local anchor point relative to bodyB's origin.
	 */
	public void setLocalAnchorB(float x, float y) {
		localAnchorB.set(x, y);
	}

	/**
	 * The local anchor point relative to bodyB's origin.
	 */
	public void setLocalAnchorB(Vector2f localAnchor) {
		localAnchorB.set(localAnchor);
	}

	/**
	 * 
	 */
	public void setLocalAxisA(float x, float y) {
		localAxisA.set(x, y);
	}

	/**
	 * The local translation unit axis in bodyA.
	 */
	public void setLocalAxisA(Vector2f localAxisA) {
		this.localAxisA.set(localAxisA);
	}

	/**
	 * The first attached body.
	 */
	public void setBodyA(Body body) {
		MemorySegment.copy(body.memorySegment(), 0L, b2WheelJointDef, BODY_ID_A_OFFSET, Body.LAYOUT().byteSize());
	}

	/**
	 * The second attached body.
	 */
	public void setBodyB(Body body) {
		MemorySegment.copy(body.memorySegment(), 0L, b2WheelJointDef, BODY_ID_B_OFFSET, Body.LAYOUT().byteSize());
	}

	/**
	 * Enable a linear spring along the local axis.
	 */
	public void enableSpring(boolean enableSpring) {
		ENABLE_SPRING.set(b2WheelJointDef, enableSpring);
	}

	/**
	 * Spring stiffness in Hertz.
	 */
	public void setHertz(float hertz) {
		HERTZ.set(b2WheelJointDef, hertz);
	}

	/**
	 * Spring damping ratio, non-dimensional.
	 */
	public void setDampingRatio(float dampingRatio) {
		DAMPING_RATIO.set(b2WheelJointDef, dampingRatio);
	}

	/**
	 * Enable/disable the joint linear limit.
	 */
	public void enableLimit(boolean enableLimit) {
		ENABLE_LIMIT.set(b2WheelJointDef, enableLimit);
	}

	/**
	 * The lower translation limit.
	 */
	public void setLowerTranslation(float lowerTranslation) {
		LOWER_TRANSLATION.set(b2WheelJointDef, lowerTranslation);
	}

	/**
	 * The upper translation limit.
	 */
	public void setUpperTranslation(float upperTranslation) {
		UPPER_TRANSLATION.set(b2WheelJointDef, upperTranslation);
	}

	/**
	 * Enable/disable the joint rotational motor.
	 */
	public void enableMotor(boolean enableMotor) {
		ENABLE_MOTOR.set(b2WheelJointDef, enableMotor);
	}

	/**
	 * The maximum motor torque, typically in newton-meters.
	 */
	public void setMaxMotorTorque(float maxMotorTorque) {
		MAX_MOTOR_TORQUE.set(b2WheelJointDef, maxMotorTorque);
	}

	/**
	 * The desired motor speed in radians per second.
	 * 
	 */
	public void setMotorSpeed(float motorSpeed) {
		MOTOR_SPEED.set(b2WheelJointDef, motorSpeed);
	}

	/**
	 * Set this flag to true if the attached bodies should collide.
	 */
	public void collideConnected(boolean collideConnected) {
		COLLIDE_CONNECTED.set(b2WheelJointDef, collideConnected);
	}

	public MemorySegment memorySegment() {
		return b2WheelJointDef;
	}

	public static StructLayout LAYOUT() {
		return LAYOUT;
	}

}
