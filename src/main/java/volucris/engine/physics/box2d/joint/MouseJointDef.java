package volucris.engine.physics.box2d.joint;

import java.lang.foreign.Arena;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.StructLayout;
import java.lang.foreign.MemoryLayout.PathElement;
import java.lang.foreign.MemorySegment;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;

import org.joml.Vector2f;

import volucris.engine.physics.box2d.body.Body;
import volucris.engine.physics.box2d.math.Vec2;
import volucris.engine.utils.VolucrisRuntimeException;

import static java.lang.foreign.ValueLayout.*;
import static volucris.engine.utils.FFMUtils.*;

/**
 * A mouse joint is used to make a point on a body track a specified world
 * point.
 * <p>
 * This a soft constraint and allows the constraint to stretch without applying
 * huge forces. This also applies rotation constraint heuristic to improve
 * control.
 * 
 */
public final class MouseJointDef {

	private static final StructLayout LAYOUT;

	private static final MethodHandle B2_DEFAULT_MOUSE_JOINT_DEF;

	private static final VarHandle HERTZ;
	private static final VarHandle DAMPING_RATIO;
	private static final VarHandle MAX_FORCE;
	private static final VarHandle COLLIDE_CONNECTED;

	private static final long BODY_ID_A_OFFSET;
	private static final long BODY_ID_B_OFFSET;
	private static final long TARGET_OFFSET;

	private final MemorySegment b2MouseJointDef;

	private final Vec2 target;

	static {
		//@formatter:off
		LAYOUT = MemoryLayout.structLayout(
		        Body.LAYOUT().withName("bodyIdA"),
		        Body.LAYOUT().withName("bodyIdB"),
		        Vec2.LAYOUT().withName("target"),
		        JAVA_FLOAT.withName("hertz"),
		        JAVA_FLOAT.withName("dampingRatio"),
		        JAVA_FLOAT.withName("maxForce"),
		        JAVA_BOOLEAN.withName("collideConnected"),
		        MemoryLayout.paddingLayout(3),
		        ADDRESS.withName("userData"),
		        JAVA_INT.withName("internalValue"),
		        MemoryLayout.paddingLayout(4)
			).withName("b2MouseJointDef");
		//@formatter:on

		HERTZ = varHandle(LAYOUT, "hertz");
		DAMPING_RATIO = varHandle(LAYOUT, "dampingRatio");
		MAX_FORCE = varHandle(LAYOUT, "maxForce");
		COLLIDE_CONNECTED = varHandle(LAYOUT, "collideConnected");

		B2_DEFAULT_MOUSE_JOINT_DEF = downcallHandle("b2DefaultMouseJointDef", LAYOUT);

		BODY_ID_A_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("bodyIdA"));
		BODY_ID_B_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("bodyIdB"));
		TARGET_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("target"));
	}

	public MouseJointDef() {
		this(Arena.ofAuto());
	}
	
	public MouseJointDef(Arena arena) {
		try {
			b2MouseJointDef = (MemorySegment) B2_DEFAULT_MOUSE_JOINT_DEF.invoke(arena);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot create motor joint def.");
		}

		target = new Vec2(b2MouseJointDef.asSlice(TARGET_OFFSET, Vec2.LAYOUT()));
	}

	/**
	 * The initial target point in world space.
	 */
	public void setTarget(float x, float y) {
		target.set(x, y);
	}

	/**
	 * The initial target point in world space.
	 */
	public void setTarget(Vector2f target) {
		this.target.set(target);
	}

	/**
	 * The first attached body. This is assumed to be static.
	 */
	public void setBodyA(Body body) {
		MemorySegment.copy(body.memorySegment(), 0L, b2MouseJointDef, BODY_ID_A_OFFSET, Body.LAYOUT().byteSize());
	}

	/**
	 * The second attached body.
	 */
	public void setBodyB(Body body) {
		MemorySegment.copy(body.memorySegment(), 0L, b2MouseJointDef, BODY_ID_B_OFFSET, Body.LAYOUT().byteSize());
	}

	/**
	 * Stiffness in hertz.
	 */
	public void setHertz(float hertz) {
		HERTZ.set(b2MouseJointDef, hertz);
	}

	/**
	 * Damping ratio, non-dimensional.
	 */
	public void setDampingRatio(float dampingRatio) {
		DAMPING_RATIO.set(b2MouseJointDef, dampingRatio);
	}

	/**
	 * Maximum force, typically in newtons.
	 */
	public void setMaxForce(float maxForce) {
		MAX_FORCE.set(b2MouseJointDef, maxForce);
	}

	/**
	 * Set this flag to true if the attached bodies should collide.
	 */
	public void collideConnected(boolean collideConnected) {
		COLLIDE_CONNECTED.set(b2MouseJointDef, collideConnected);
	}

	public MemorySegment memorySegment() {
		return b2MouseJointDef;
	}

	public static StructLayout LAYOUT() {
		return LAYOUT;
	}

}
