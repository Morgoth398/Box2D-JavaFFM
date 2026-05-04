package volucris.engine.physics.box2d.joint;

import java.lang.foreign.Arena;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.StructLayout;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;

import org.joml.Vector2f;

import volucris.engine.physics.box2d.body.Body;
import volucris.engine.physics.box2d.math.Vec2;
import volucris.engine.utils.VolucrisRuntimeException;

import static java.lang.foreign.ValueLayout.*;
import static volucris.engine.utils.FFMUtils.*;

/**
 * Distance joint definition.
 * <p>
 * This requires defining an anchor point on both bodies and the non-zero
 * distance of the distance joint. The definition uses local anchor points so
 * that the initial configuration can violate the constraint slightly. This
 * helps when saving and loading a game.
 * 
 */
public final class DistanceJointDef {

	private static final StructLayout LAYOUT;

	private static final VarHandle LENGTH;
	private static final VarHandle ENABLE_SPRING;
	private static final VarHandle HERTZ;
	private static final VarHandle DAMPING_RATIO;
	private static final VarHandle ENABLE_LIMIT;
	private static final VarHandle MIN_LENGTH;
	private static final VarHandle MAX_LENGTH;
	private static final VarHandle ENABLE_MOTOR;
	private static final VarHandle MAX_MOTOR_FORCE;
	private static final VarHandle MOTOR_SPEED;
	private static final VarHandle COLLIDE_CONNECTED;

	private static final MethodHandle B2_DEFAULT_DISTANCE_JOINT_DEF;

	private static final long BODY_ID_A_OFFSET;
	private static final long BODY_ID_B_OFFSET;
	private static final long LOCAL_ANCHOR_A_OFFSET;
	private static final long LOCAL_ANCHOR_B_OFFSET;

	private final MemorySegment b2DistanceJointDef;

	private final Vec2 localAnchorA;
	private final Vec2 localAnchorB;

	static {
		//@formatter:off
		LAYOUT = MemoryLayout.structLayout(
				Body.LAYOUT().withName("bodyIdA"),
		        Body.LAYOUT().withName("bodyIdB"),
		        Vec2.LAYOUT().withName("localAnchorA"),
		        Vec2.LAYOUT().withName("localAnchorB"),
		        JAVA_FLOAT.withName("length"),
		        JAVA_BOOLEAN.withName("enableSpring"),
		        MemoryLayout.paddingLayout(3),
		        JAVA_FLOAT.withName("hertz"),
		        JAVA_FLOAT.withName("dampingRatio"),
		        JAVA_BOOLEAN.withName("enableLimit"),
		        MemoryLayout.paddingLayout(3),
		        JAVA_FLOAT.withName("minLength"),
		        JAVA_FLOAT.withName("maxLength"),
		        JAVA_BOOLEAN.withName("enableMotor"),
		        MemoryLayout.paddingLayout(3),
		        JAVA_FLOAT.withName("maxMotorForce"),
		        JAVA_FLOAT.withName("motorSpeed"),
		        JAVA_BOOLEAN.withName("collideConnected"),
		        MemoryLayout.paddingLayout(7),
		        ADDRESS.withName("userData"),
		        JAVA_INT.withName("internalValue"),
		        MemoryLayout.paddingLayout(4)
			).withName("b2DistanceJointDef");
		//@formatter:on

		LENGTH = varHandle(LAYOUT, "length");
		ENABLE_SPRING = varHandle(LAYOUT, "enableSpring");
		HERTZ = varHandle(LAYOUT, "hertz");
		DAMPING_RATIO = varHandle(LAYOUT, "dampingRatio");
		ENABLE_LIMIT = varHandle(LAYOUT, "enableLimit");
		MIN_LENGTH = varHandle(LAYOUT, "minLength");
		MAX_LENGTH = varHandle(LAYOUT, "maxLength");
		ENABLE_MOTOR = varHandle(LAYOUT, "enableMotor");
		MAX_MOTOR_FORCE = varHandle(LAYOUT, "maxMotorForce");
		MOTOR_SPEED = varHandle(LAYOUT, "motorSpeed");
		COLLIDE_CONNECTED = varHandle(LAYOUT, "collideConnected");

		B2_DEFAULT_DISTANCE_JOINT_DEF = downcallHandle("b2DefaultDistanceJointDef", LAYOUT);

		BODY_ID_A_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("bodyIdA"));
		BODY_ID_B_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("bodyIdB"));
		LOCAL_ANCHOR_A_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("localAnchorA"));
		LOCAL_ANCHOR_B_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("localAnchorB"));
	}

	public DistanceJointDef() {
		this(Arena.ofAuto());
	}
	
	public DistanceJointDef(Arena arena) {
		try {
			b2DistanceJointDef = (MemorySegment) B2_DEFAULT_DISTANCE_JOINT_DEF.invoke(arena);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot create distance joint def.");
		}

		localAnchorA = new Vec2(b2DistanceJointDef.asSlice(LOCAL_ANCHOR_A_OFFSET, Vec2.LAYOUT()));
		localAnchorB = new Vec2(b2DistanceJointDef.asSlice(LOCAL_ANCHOR_B_OFFSET, Vec2.LAYOUT()));
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
		MemorySegment.copy(body.memorySegment(), 0L, b2DistanceJointDef, BODY_ID_A_OFFSET, Body.LAYOUT().byteSize());
	}

	/**
	 * The second attached body.
	 */
	public void setBodyB(Body body) {
		MemorySegment.copy(body.memorySegment(), 0L, b2DistanceJointDef, BODY_ID_B_OFFSET, Body.LAYOUT().byteSize());
	}

	/**
	 * The rest length of this joint. Clamped to a stable minimum value.
	 */
	public void setLength(float length) {
		LENGTH.set(b2DistanceJointDef, length);
	}

	/**
	 * Enable the distance constraint to behave like a spring.
	 * 
	 * If false then the distance joint will be rigid, overriding the limit and
	 * motor.
	 */
	public void enableSpring(boolean enableSpring) {
		ENABLE_SPRING.set(b2DistanceJointDef, enableSpring);
	}

	/**
	 * The spring linear stiffness Hertz, cycles per second.
	 */
	public void setHertz(float hertz) {
		HERTZ.set(b2DistanceJointDef, hertz);
	}

	/**
	 * The spring linear damping ratio, non-dimensional.
	 */
	public void setDampingRatio(float dampingRatio) {
		DAMPING_RATIO.set(b2DistanceJointDef, dampingRatio);
	}

	/**
	 * Enable/disable the joint limit.
	 */
	public void enableLimit(boolean enableLimit) {
		ENABLE_LIMIT.set(b2DistanceJointDef, enableLimit);
	}

	/**
	 * Minimum length. Clamped to a stable minimum value.
	 */
	public void setMinLength(float minLength) {
		MIN_LENGTH.set(b2DistanceJointDef, minLength);
	}

	/**
	 * Maximum length. Must be greater than or equal to the minimum length.
	 */
	public void setMaxLength(float maxLength) {
		MAX_LENGTH.set(b2DistanceJointDef, maxLength);
	}

	/**
	 * Enable/disable the joint motor.
	 */
	public void enableMotor(boolean enableMotor) {
		ENABLE_MOTOR.set(b2DistanceJointDef, enableMotor);
	}

	/**
	 * The maximum motor force, usually in newtons.
	 */
	public void setMaxMotorForce(float maxMotorForce) {
		MAX_MOTOR_FORCE.set(b2DistanceJointDef, maxMotorForce);
	}

	/**
	 * The desired motor speed, usually in meters per second.
	 */
	public void setMotorSpeed(float motorSpeed) {
		MOTOR_SPEED.set(b2DistanceJointDef, motorSpeed);
	}

	/**
	 * Set this flag to true if the attached bodies should collide.
	 */
	public void collideConnected(boolean collideConnected) {
		COLLIDE_CONNECTED.set(b2DistanceJointDef, collideConnected);
	}

	public MemorySegment memorySegment() {
		return b2DistanceJointDef;
	}

	public static StructLayout LAYOUT() {
		return LAYOUT;
	}

}
