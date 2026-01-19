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
import volucris.engine.utils.MathUtils;
import volucris.engine.utils.Box2DRuntimeException;

import static java.lang.foreign.ValueLayout.*;
import static volucris.engine.utils.FFMUtils.*;

/**
 * Revolute joint definition.
 * <p>
 * This requires defining an anchor point where the bodies are joined. The
 * definition uses local anchor points so that the initial configuration can
 * violate the constraint slightly. You also need to specify the initial
 * relative angle for joint limits. This helps when saving and loading a game.
 * The local anchor points are measured from the body's origin rather than the
 * center of mass because:
 * <ol>
 * <li>you might not know where the center of mass will be
 * <li>if you add/remove shapes from a body and recompute the mass, the joints
 * will be broken
 * </ol>
 */
public final class RevoluteJointDef {

	private static final StructLayout LAYOUT;

	private static final VarHandle REFERENCE_ANGLE;
	private static final VarHandle TARGET_ANGLE;
	private static final VarHandle ENABLE_SPRING;
	private static final VarHandle HERTZ;
	private static final VarHandle DAMPING_RATIO;
	private static final VarHandle ENABLE_LIMIT;
	private static final VarHandle LOWER_ANGLE;
	private static final VarHandle UPPER_ANGLE;
	private static final VarHandle ENABLE_MOTOR;
	private static final VarHandle MAX_MOTOR_TORQUE;
	private static final VarHandle MOTOR_SPEED;
	private static final VarHandle DRAW_SIZE;
	private static final VarHandle COLLIDE_CONNECTED;

	private static final MethodHandle B2_DEFAULT_REVOLUTE_JOINT_DEF;

	private static final long BODY_ID_A_OFFSET;
	private static final long BODY_ID_B_OFFSET;
	private static final long LOCAL_ANCHOR_A_OFFSET;
	private static final long LOCAL_ANCHOR_B_OFFSET;

	private final MemorySegment b2RevoluteJointDef;

	private final Vec2 localAnchorA;
	private final Vec2 localAnchorB;

	static {
		//@formatter:off
		LAYOUT = MemoryLayout.structLayout(
				Body.LAYOUT().withName("bodyIdA"),
		        Body.LAYOUT().withName("bodyIdB"),
		        Vec2.LAYOUT().withName("localAnchorA"),
		        Vec2.LAYOUT().withName("localAnchorB"),
		        JAVA_FLOAT.withName("referenceAngle"),
		        JAVA_FLOAT.withName("targetAngle"),
		        JAVA_BOOLEAN.withName("enableSpring"),
		        MemoryLayout.paddingLayout(3),
		        JAVA_FLOAT.withName("hertz"),
		        JAVA_FLOAT.withName("dampingRatio"),
		        JAVA_BOOLEAN.withName("enableLimit"),
		        MemoryLayout.paddingLayout(3),
		        JAVA_FLOAT.withName("lowerAngle"),
		        JAVA_FLOAT.withName("upperAngle"),
		        JAVA_BOOLEAN.withName("enableMotor"),
		        MemoryLayout.paddingLayout(3),
		        JAVA_FLOAT.withName("maxMotorTorque"),
		        JAVA_FLOAT.withName("motorSpeed"),
		        JAVA_FLOAT.withName("drawSize"),
		        JAVA_BOOLEAN.withName("collideConnected"),
		        MemoryLayout.paddingLayout(7),
		        ADDRESS.withName("userData"),
		        JAVA_INT.withName("internalValue"),
		        MemoryLayout.paddingLayout(4)
			).withName("b2RevoluteJointDef");
		//@formatter:on

		REFERENCE_ANGLE = varHandle(LAYOUT, "referenceAngle");
		TARGET_ANGLE = varHandle(LAYOUT, "targetAngle");
		ENABLE_SPRING = varHandle(LAYOUT, "enableSpring");
		HERTZ = varHandle(LAYOUT, "hertz");
		DAMPING_RATIO = varHandle(LAYOUT, "dampingRatio");
		ENABLE_LIMIT = varHandle(LAYOUT, "enableLimit");
		LOWER_ANGLE = varHandle(LAYOUT, "lowerAngle");
		UPPER_ANGLE = varHandle(LAYOUT, "upperAngle");
		ENABLE_MOTOR = varHandle(LAYOUT, "enableMotor");
		MAX_MOTOR_TORQUE = varHandle(LAYOUT, "maxMotorTorque");
		MOTOR_SPEED = varHandle(LAYOUT, "motorSpeed");
		DRAW_SIZE = varHandle(LAYOUT, "drawSize");
		COLLIDE_CONNECTED = varHandle(LAYOUT, "collideConnected");

		B2_DEFAULT_REVOLUTE_JOINT_DEF = downcallHandle("b2DefaultRevoluteJointDef", LAYOUT);

		BODY_ID_A_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("bodyIdA"));
		BODY_ID_B_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("bodyIdB"));
		LOCAL_ANCHOR_A_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("localAnchorA"));
		LOCAL_ANCHOR_B_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("localAnchorB"));
	}

	public RevoluteJointDef() {
		this(Arena.ofAuto());
	}

	public RevoluteJointDef(Arena arena) {
		try {
			b2RevoluteJointDef = (MemorySegment) B2_DEFAULT_REVOLUTE_JOINT_DEF.invoke(arena);
		} catch (Throwable e) {
			String className = e.getClass().getSimpleName();
			throw new Box2DRuntimeException("Box2D: Cannot create revolute joint dev: " + className);
		}

		localAnchorA = new Vec2(b2RevoluteJointDef.asSlice(LOCAL_ANCHOR_A_OFFSET, Vec2.LAYOUT()));
		localAnchorB = new Vec2(b2RevoluteJointDef.asSlice(LOCAL_ANCHOR_B_OFFSET, Vec2.LAYOUT()));
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
	 * The first attached body.
	 */
	public void setBodyA(Body body) {
		MemorySegment.copy(body.memorySegment(), 0L, b2RevoluteJointDef, BODY_ID_A_OFFSET, Body.LAYOUT().byteSize());
	}

	/**
	 * The second attached body.
	 */
	public void setBodyB(Body body) {
		MemorySegment.copy(body.memorySegment(), 0L, b2RevoluteJointDef, BODY_ID_B_OFFSET, Body.LAYOUT().byteSize());
	}

	/**
	 * The bodyB angle minus bodyA angle in the reference state (radians).
	 * 
	 * This defines the zero angle for the joint limit.
	 */
	public void setReferenceAngleRadians(float referenceAngle) {
		REFERENCE_ANGLE.set(b2RevoluteJointDef, referenceAngle);
	}

	/**
	 * The bodyB angle minus bodyA angle in the reference state (degrees).
	 * 
	 * This defines the zero angle for the joint limit.
	 */
	public void setReferenceAngle(float referenceAngle) {
		REFERENCE_ANGLE.set(b2RevoluteJointDef, MathUtils.toRadians(referenceAngle));
	}

	/**
	 * The target angle for the joint in radians. The spring-damper will drive to
	 * this angle.
	 */
	public void setTargetAngleRadians(float targetAngle) {
		TARGET_ANGLE.set(b2RevoluteJointDef, targetAngle);
	}

	/**
	 * The target angle for the joint in degrees. The spring-damper will drive to
	 * this angle.
	 */
	public void setTargetAngle(float targetAngle) {
		TARGET_ANGLE.set(b2RevoluteJointDef, MathUtils.toRadians(targetAngle));
	}

	/**
	 * Enable a rotational spring on the revolute hinge axis.
	 */
	public void enableSpring(boolean enableSpring) {
		ENABLE_SPRING.set(b2RevoluteJointDef, enableSpring);
	}

	/**
	 * The spring stiffness Hertz, cycles per second.
	 */
	public void setHertz(float hertz) {
		HERTZ.set(b2RevoluteJointDef, hertz);
	}

	/**
	 * The spring damping ratio, non-dimensional.
	 */
	public void setDampingRatio(float dampingRatio) {
		DAMPING_RATIO.set(b2RevoluteJointDef, dampingRatio);
	}

	/**
	 * A flag to enable joint limits.
	 */
	public void enableLimit(boolean enableLimit) {
		ENABLE_LIMIT.set(b2RevoluteJointDef, enableLimit);
	}

	/**
	 * The lower angle for the joint limit in radians. Minimum of -0.95*pi radians.
	 */
	public void setLowerAngle(float lowerAngle) {
		LOWER_ANGLE.set(b2RevoluteJointDef, lowerAngle);
	}

	/**
	 * The upper angle for the joint limit in radians. Maximum of 0.95*pi radians.
	 */
	public void setUpperAngle(float upperAngle) {
		UPPER_ANGLE.set(b2RevoluteJointDef, upperAngle);
	}

	/**
	 * A flag to enable the joint motor.
	 */
	public void enableMotor(boolean enableMotor) {
		ENABLE_MOTOR.set(b2RevoluteJointDef, enableMotor);
	}

	/**
	 * The maximum motor torque, typically in newton-meters.
	 */
	public void setMaxMotorTorque(float maxMotorTorque) {
		MAX_MOTOR_TORQUE.set(b2RevoluteJointDef, maxMotorTorque);
	}

	/**
	 * The desired motor speed in radians per second.
	 */
	public void setMotorSpeed(float motorSpeed) {
		MOTOR_SPEED.set(b2RevoluteJointDef, motorSpeed);
	}

	/**
	 * Scale the debug draw.
	 */
	public void setDrawSize(float drawSize) {
		DRAW_SIZE.set(b2RevoluteJointDef, drawSize);
	}

	/**
	 * Set this flag to true if the attached bodies should collide.
	 */
	public void collideConnected(boolean collideConnected) {
		COLLIDE_CONNECTED.set(b2RevoluteJointDef, collideConnected);
	}

	public MemorySegment memorySegment() {
		return b2RevoluteJointDef;
	}

	public static StructLayout LAYOUT() {
		return LAYOUT;
	}

}
