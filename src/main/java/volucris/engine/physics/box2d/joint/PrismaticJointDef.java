package volucris.engine.physics.box2d.joint;

import java.lang.foreign.Arena;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.SegmentAllocator;
import java.lang.foreign.StructLayout;
import java.lang.foreign.MemoryLayout.PathElement;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;

import org.joml.Vector2f;

import volucris.engine.physics.box2d.body.Body;
import volucris.engine.physics.box2d.math.Vec2;
import volucris.engine.utils.VolucrisRuntimeException;

import static java.lang.foreign.ValueLayout.*;
import static volucris.engine.utils.FFMUtils.*;

/**
 * Prismatic joint definition.
 * <p>
 * This requires defining a line of motion using an axis and an anchor point.
 * The definition uses local anchor points and a local axis so that the initial
 * configuration can violate the constraint slightly. The joint translation is
 * zero when the local anchor points coincide in world space.
 * 
 */
public final class PrismaticJointDef {

	private static final StructLayout LAYOUT;

	private static final MethodHandle B2_DEFAULT_PRISMATIC_JOINT_DEF;

	private static final VarHandle REFERENCE_ANGLE;
	private static final VarHandle TARGET_TRANSLATION;
	private static final VarHandle ENABLE_SPRING;
	private static final VarHandle HERTZ;
	private static final VarHandle DAMPING_RATIO;
	private static final VarHandle ENABLE_LIMIT;
	private static final VarHandle LOWER_TRANSLATION;
	private static final VarHandle UPPER_TRANSLATION;
	private static final VarHandle ENABLE_MOTOR;
	private static final VarHandle MAX_MOTOR_FORCE;
	private static final VarHandle MOTOR_SPEED;
	private static final VarHandle COLLIDE_CONNECTED;

	private static final long BODY_ID_A_OFFSET;
	private static final long BODY_ID_B_OFFSET;
	private static final long LOCAL_ANCHOR_A_OFFSET;
	private static final long LOCAL_ANCHOR_B_OFFSET;
	private static final long LOCAL_AXIS_A_OFFSET;

	private final MemorySegment b2PrismaticJointDef;

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
		        JAVA_FLOAT.withName("referenceAngle"),
		        JAVA_FLOAT.withName("targetTranslation"),
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
		        JAVA_FLOAT.withName("maxMotorForce"),
		        JAVA_FLOAT.withName("motorSpeed"),
		        JAVA_BOOLEAN.withName("collideConnected"),
		        MemoryLayout.paddingLayout(3),
		        ADDRESS.withName("userData"),
		        JAVA_INT.withName("internalValue"),
		        MemoryLayout.paddingLayout(4)
			).withName("b2PrismaticJointDef");
		//@formatter:on

		REFERENCE_ANGLE = varHandle(LAYOUT, "referenceAngle");
		TARGET_TRANSLATION = varHandle(LAYOUT, "targetTranslation");
		ENABLE_SPRING = varHandle(LAYOUT, "enableSpring");
		HERTZ = varHandle(LAYOUT, "hertz");
		DAMPING_RATIO = varHandle(LAYOUT, "dampingRatio");
		ENABLE_LIMIT = varHandle(LAYOUT, "enableLimit");
		LOWER_TRANSLATION = varHandle(LAYOUT, "lowerTranslation");
		UPPER_TRANSLATION = varHandle(LAYOUT, "upperTranslation");
		ENABLE_MOTOR = varHandle(LAYOUT, "enableMotor");
		MAX_MOTOR_FORCE = varHandle(LAYOUT, "maxMotorForce");
		MOTOR_SPEED = varHandle(LAYOUT, "motorSpeed");
		COLLIDE_CONNECTED = varHandle(LAYOUT, "collideConnected");

		BODY_ID_A_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("bodyIdA"));
		BODY_ID_B_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("bodyIdB"));
		LOCAL_ANCHOR_A_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("localAnchorA"));
		LOCAL_ANCHOR_B_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("localAnchorB"));
		LOCAL_AXIS_A_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("localAxisA"));

		B2_DEFAULT_PRISMATIC_JOINT_DEF = downcallHandle("b2DefaultPrismaticJointDef", LAYOUT);
	}

	public PrismaticJointDef() {
		try {
			SegmentAllocator allocator = Arena.ofAuto();
			b2PrismaticJointDef = (MemorySegment) B2_DEFAULT_PRISMATIC_JOINT_DEF.invokeExact(allocator);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot create prismatic joint def.");
		}

		localAnchorA = new Vec2(b2PrismaticJointDef.asSlice(LOCAL_ANCHOR_A_OFFSET, Vec2.LAYOUT()));
		localAnchorB = new Vec2(b2PrismaticJointDef.asSlice(LOCAL_ANCHOR_B_OFFSET, Vec2.LAYOUT()));
		localAxisA = new Vec2(b2PrismaticJointDef.asSlice(LOCAL_AXIS_A_OFFSET, Vec2.LAYOUT()));
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
	 * The local translation unit axis in bodyA.
	 */
	public void setLocalAxisA(float x, float y) {
		localAxisA.set(x, y);
	}

	/**
	 * The local translation unit axis in bodyA.
	 */
	public void setLocalAxisA(Vector2f localAxis) {
		localAxisA.set(localAxis);
	}

	/**
	 * The first attached body.
	 */
	public void setBodyA(Body body) {
		MemorySegment.copy(body.memorySegment(), 0L, b2PrismaticJointDef, BODY_ID_A_OFFSET, Body.LAYOUT().byteSize());
	}

	/**
	 * The second attached body.
	 */
	public void setBodyB(Body body) {
		MemorySegment.copy(body.memorySegment(), 0L, b2PrismaticJointDef, BODY_ID_B_OFFSET, Body.LAYOUT().byteSize());
	}

	/**
	 * The constrained angle between the bodies: bodyB_angle - bodyA_angle.
	 */
	public void setReferenceAngle(float referenceAngle) {
		REFERENCE_ANGLE.set(b2PrismaticJointDef, referenceAngle);
	}

	/**
	 * The target translation for the joint in meters. The spring-damper will drive
	 * to this translation.
	 */
	public void setTargetTranslation(float targetTranslation) {
		TARGET_TRANSLATION.set(b2PrismaticJointDef, targetTranslation);
	}

	/**
	 * Enable a linear spring along the prismatic joint axis.
	 */
	public void enableSpring(boolean enableSpring) {
		ENABLE_SPRING.set(b2PrismaticJointDef, enableSpring);
	}

	/**
	 * The spring stiffness Hertz, cycles per second.
	 */
	public void setHertz(float hertz) {
		HERTZ.set(b2PrismaticJointDef, hertz);
	}

	/**
	 * The spring damping ratio, non-dimensional.
	 */
	public void setDampingRatio(float dampingRatio) {
		DAMPING_RATIO.set(b2PrismaticJointDef, dampingRatio);
	}

	/**
	 * Enable/disable the joint limit.
	 */
	public void enableLimit(boolean enableLimit) {
		ENABLE_LIMIT.set(b2PrismaticJointDef, enableLimit);
	}

	/**
	 * The lower translation limit.
	 */
	public void setLowerTranslation(float lowerTranslation) {
		LOWER_TRANSLATION.set(b2PrismaticJointDef, lowerTranslation);
	}

	/**
	 * The upper translation limit.
	 */
	public void setUpperTranslation(float upperTranslation) {
		UPPER_TRANSLATION.set(b2PrismaticJointDef, upperTranslation);
	}

	/**
	 * Enable/disable the joint motor.
	 */
	public void enableMotor(boolean enableMotor) {
		ENABLE_MOTOR.set(b2PrismaticJointDef, enableMotor);
	}

	/**
	 * The maximum motor force, typically in newtons.
	 */
	public void setMaxMotorForce(float maxMotorForce) {
		MAX_MOTOR_FORCE.set(b2PrismaticJointDef, maxMotorForce);
	}

	/**
	 * 
	 */
	public void setMotorSpeed(float motorSpeed) {
		MOTOR_SPEED.set(b2PrismaticJointDef, motorSpeed);
	}

	/**
	 * The desired motor speed, typically in meters per second.
	 */
	public void collideConnected(boolean collideConnected) {
		COLLIDE_CONNECTED.set(b2PrismaticJointDef, collideConnected);
	}

	public MemorySegment memorySegment() {
		return b2PrismaticJointDef.asReadOnly();
	}

	public static StructLayout LAYOUT() {
		return LAYOUT;
	}

}
