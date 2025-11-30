package volucris.engine.physics.box2d.body;

import java.lang.foreign.Arena;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.SegmentAllocator;
import java.lang.foreign.StructLayout;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;

import org.joml.Vector2f;

import volucris.engine.physics.box2d.math.Rot;
import volucris.engine.physics.box2d.math.Vec2;
import volucris.engine.utils.MathUtils;

import static java.lang.foreign.ValueLayout.*;
import static volucris.engine.utils.FFMUtils.*;

/**
 * A body definition holds all the data needed to construct a rigid body.
 * 
 * You can safely re-use body definitions. Shapes are added to a body after
 * construction. Body definitions are temporary objects used to bundle creation
 * parameters.
 * 
 */
public final class BodyDef {

	private final static StructLayout LAYOUT;

	private static final VarHandle TYPE;
	private static final VarHandle ANGULAR_VELOCITY;
	private static final VarHandle LINEAR_DAMPING;
	private static final VarHandle ANGULAR_DAMPING;
	private static final VarHandle GRAVITY_SCALE;
	private static final VarHandle SLEEP_THRESHOLD;
	private static final VarHandle NAME;
	private static final VarHandle ENABLE_SLEEP;
	private static final VarHandle IS_AWAKE;
	private static final VarHandle FIXED_ROTATION;
	private static final VarHandle IS_BULLET;
	private static final VarHandle IS_ENABLED;
	private static final VarHandle ALLOW_FAST_ROTATION;

	private static final MethodHandle B2_DEFAULT_BODY_DEF;

	private static final long POSITION_OFFSET;
	private static final long LINEAR_VELOCITY_OFFSET;
	private static final long ROTAION_OFFSET;

	private final Arena arena;

	private final MemorySegment b2BodyDef;

	private final Rot rotation;

	private final Vec2 position;
	private final Vec2 linearVelocity;

	static {
		//@formatter:off
		LAYOUT = MemoryLayout.structLayout(
					JAVA_INT.withName("type"),
					Vec2.LAYOUT().withName("position"),
					Rot.LAYOUT().withName("rotation"),
					Vec2.LAYOUT().withName("linearVelocity"),
					JAVA_FLOAT.withName("angularVelocity"),
					JAVA_FLOAT.withName("linearDamping"),
					JAVA_FLOAT.withName("angularDamping"),
					JAVA_FLOAT.withName("gravityScale"),
					JAVA_FLOAT.withName("sleepThreshold"),
					ADDRESS.withName("name"),
					ADDRESS.withName("userData"),
					JAVA_BOOLEAN.withName("enableSleep"),
					JAVA_BOOLEAN.withName("isAwake"),
					JAVA_BOOLEAN.withName("fixedRotation"),
					JAVA_BOOLEAN.withName("isBullet"),
					JAVA_BOOLEAN.withName("isEnabled"),
					JAVA_BOOLEAN.withName("allowFastRotation"),
					MemoryLayout.paddingLayout(2),
					JAVA_INT.withName("internalValue"),
					MemoryLayout.paddingLayout(4)
				).withName("b2BodyDef");
		//@formatter:on

		POSITION_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("position"));
		LINEAR_VELOCITY_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("linearVelocity"));
		ROTAION_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("rotation"));

		TYPE = varHandle(LAYOUT, "type");
		ANGULAR_VELOCITY = varHandle(LAYOUT, "angularVelocity");
		LINEAR_DAMPING = varHandle(LAYOUT, "linearDamping");
		ANGULAR_DAMPING = varHandle(LAYOUT, "angularDamping");
		GRAVITY_SCALE = varHandle(LAYOUT, "gravityScale");
		SLEEP_THRESHOLD = varHandle(LAYOUT, "sleepThreshold");
		NAME = varHandle(LAYOUT, "name");
		ENABLE_SLEEP = varHandle(LAYOUT, "enableSleep");
		IS_AWAKE = varHandle(LAYOUT, "isAwake");
		FIXED_ROTATION = varHandle(LAYOUT, "fixedRotation");
		IS_BULLET = varHandle(LAYOUT, "isBullet");
		IS_ENABLED = varHandle(LAYOUT, "isEnabled");
		ALLOW_FAST_ROTATION = varHandle(LAYOUT, "allowFastRotation");

		B2_DEFAULT_BODY_DEF = downcallHandle("b2DefaultBodyDef", LAYOUT);
	}

	public BodyDef() {
		try {
			arena = Arena.ofAuto();
			b2BodyDef = (MemorySegment) B2_DEFAULT_BODY_DEF.invokeExact((SegmentAllocator) arena);
		} catch (Throwable e) {
			throw new RuntimeException("Box2D: Cannot create body def.");
		}

		position = new Vec2(b2BodyDef.asSlice(POSITION_OFFSET, Vec2.LAYOUT()));
		linearVelocity = new Vec2(b2BodyDef.asSlice(LINEAR_VELOCITY_OFFSET, Vec2.LAYOUT()));
		rotation = new Rot(b2BodyDef.asSlice(ROTAION_OFFSET, Rot.LAYOUT()));
	}

	/**
	 * The body type: static, kinematic, or dynamic.
	 */
	public void setType(BodyType type) {
		TYPE.set(b2BodyDef, type.id());
	}

	/**
	 * The initial angular velocity of the body. Radians per second.
	 */
	public void setAngularVelocity(float angularVelocity) {
		ANGULAR_VELOCITY.set(b2BodyDef, angularVelocity);
	}

	/**
	 * Linear damping is used to reduce the linear velocity.
	 * 
	 * The damping parameter can be larger than 1 but the damping effect becomes
	 * sensitive to the time step when the damping parameter is large. Generally
	 * linear damping is undesirable because it makes objects move slowly as if they
	 * are floating.
	 */
	public void setLinearDamping(float linearDamping) {
		LINEAR_DAMPING.set(b2BodyDef, linearDamping);
	}

	/**
	 * Angular damping is used to reduce the angular velocity.
	 * 
	 * The damping parameter can be larger than 1.0f but the damping effect becomes
	 * sensitive to the time step when the damping parameter is large. Angular
	 * damping can be use slow down rotating bodies.
	 */
	public void setAngularDamping(float angularDamping) {
		ANGULAR_DAMPING.set(b2BodyDef, angularDamping);
	}

	/**
	 * Scale the gravity applied to this body. Non-dimensional.
	 */
	public void setGravityScale(float gravityScale) {
		GRAVITY_SCALE.set(b2BodyDef, gravityScale);
	}

	/**
	 * Sleep speed threshold, default is 0.05 meters per second.
	 */
	public void setSleepThreshold(float sleepThreshold) {
		SLEEP_THRESHOLD.set(b2BodyDef, sleepThreshold);
	}

	/**
	 * Optional body name for debugging. Up to 31 characters (excluding null
	 * termination)
	 */
	public void setName(String name) {
		MemorySegment nativeString = arena.allocateFrom(name);
		NAME.set(b2BodyDef, nativeString);
	}

	/**
	 * Set this flag to false if this body should never fall asleep.
	 */
	public void enableSleep(boolean enableSleep) {
		ENABLE_SLEEP.set(b2BodyDef, enableSleep);
	}

	/**
	 * Is this body initially awake or sleeping?
	 */
	public void isAwake(boolean isAwake) {
		IS_AWAKE.set(b2BodyDef, isAwake);
	}

	/**
	 * Should this body be prevented from rotating? Useful for characters.
	 */
	public void setFixedRotation(boolean fixedRotation) {
		FIXED_ROTATION.set(b2BodyDef, fixedRotation);
	}

	/**
	 * Treat this body as high speed object that performs continuous collision
	 * detection against dynamic and kinematic bodies, but not other bullet bodies.
	 * <p>
	 * Warning: Bullets should be used sparingly. They are not a solution for
	 * general dynamic-versus-dynamic continuous collision. They may interfere with
	 * joint constraints.
	 */
	public void isBullet(boolean isBullet) {
		IS_BULLET.set(b2BodyDef, isBullet);
	}

	/**
	 * Used to disable a body. A disabled body does not move or collide.
	 */
	public void isEnabled(boolean isEnabled) {
		IS_ENABLED.set(b2BodyDef, isEnabled);
	}

	/**
	 * This allows this body to bypass rotational speed limits.
	 * 
	 * Should only be used for circular objects, like wheels.
	 */
	public void allowFastRotation(boolean allowFastRotation) {
		ALLOW_FAST_ROTATION.set(b2BodyDef, allowFastRotation);
	}

	/**
	 * The initial world rotation of the body.
	 */
	public void setRotationRadians(float rotation) {
		this.rotation.setAngleRadians(rotation);
	}

	/**
	 * The initial world rotation of the body.
	 */
	public void setRotation(float rotation) {
		setRotationRadians(MathUtils.toRadians(rotation));
	}

	/**
	 * The initial world position of the body. Bodies should be created with the
	 * desired position.
	 * <p>
	 * Note: Creating bodies at the origin and then moving them nearly doubles the
	 * cost of body creation, especially if the body is moved after shapes have been
	 * added.
	 */
	public void setPosition(float x, float y) {
		this.position.set(x, y);
	}

	/**
	 * The initial world position of the body. Bodies should be created with the
	 * desired position.
	 * <p>
	 * Note: Creating bodies at the origin and then moving them nearly doubles the
	 * cost of body creation, especially if the body is moved after shapes have been
	 * added.
	 */
	public void setPosition(Vector2f position) {
		this.position.set(position);
	}

	/**
	 * 
	 */
	public void setLinearVelocity(float x, float y) {
		this.linearVelocity.set(x, y);
	}

	/**
	 * The initial linear velocity of the body's origin. Usually in meters per
	 * second.
	 */
	public void setLinearVelocity(Vector2f linearVelocity) {
		this.linearVelocity.set(linearVelocity);
	}

	public MemorySegment memorySegment() {
		return b2BodyDef.asReadOnly();
	}

	public static StructLayout LAYOUT() {
		return LAYOUT;
	}

}
