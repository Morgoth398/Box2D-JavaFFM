package volucris.engine.physics.box2d.collision;

import java.lang.foreign.Arena;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.StructLayout;
import java.lang.invoke.VarHandle;

import org.joml.Vector2f;

import volucris.engine.physics.box2d.math.Vec2;

import static java.lang.foreign.ValueLayout.*;
import static volucris.engine.physics.box2d.utils.FFMUtils.*;

/**
 * A manifold point is a contact point belonging to a contact manifold.
 * 
 * It holds details related to the geometry and dynamics of the contact points.
 * Box2D uses speculative collision so some contact points may be separated. You
 * may use the totalNormalImpulse to determine if there was an interaction
 * during the time step.
 */
public final class ManifoldPoint {

	private static final StructLayout LAYOUT;

	private static final VarHandle SEPARATION;
	private static final VarHandle NORMAL_IMPULSE;
	private static final VarHandle TANGENT_IMPULSE;
	private static final VarHandle TOTAL_NORMAL_IMPULSE;
	private static final VarHandle NORMAL_VELOCITY;
	private static final VarHandle ID;
	private static final VarHandle PERSISTED;

	private static final long POINT_OFFSET;
	private static final long ANCHOR_A_OFFSET;
	private static final long ANCHOR_B_OFFSET;

	private final MemorySegment b2ManifoldPoint;

	private final Vec2 point;
	private final Vec2 anchorA;
	private final Vec2 anchorB;

	static {
		//@formatter:off
		LAYOUT = MemoryLayout.structLayout(
				Vec2.LAYOUT().withName("point"),
		        Vec2.LAYOUT().withName("anchorA"),
		        Vec2.LAYOUT().withName("anchorB"),
		        JAVA_FLOAT.withName("separation"),
		        JAVA_FLOAT.withName("normalImpulse"),
		        JAVA_FLOAT.withName("tangentImpulse"),
		        JAVA_FLOAT.withName("totalNormalImpulse"),
		        JAVA_FLOAT.withName("normalVelocity"),
		        JAVA_SHORT.withName("id"),
		        JAVA_BOOLEAN.withName("persisted"),
		        MemoryLayout.paddingLayout(1)
			).withName("b2ManifoldPoint");
		//@formatter:on

		SEPARATION = varHandle(LAYOUT, "separation");
		NORMAL_IMPULSE = varHandle(LAYOUT, "normalImpulse");
		TANGENT_IMPULSE = varHandle(LAYOUT, "tangentImpulse");
		TOTAL_NORMAL_IMPULSE = varHandle(LAYOUT, "totalNormalImpulse");
		NORMAL_VELOCITY = varHandle(LAYOUT, "normalVelocity");
		ID = varHandle(LAYOUT, "id");
		PERSISTED = varHandle(LAYOUT, "persisted");

		POINT_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("point"));
		ANCHOR_A_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("anchorA"));
		ANCHOR_B_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("anchorB"));
	}

	public ManifoldPoint() {
		b2ManifoldPoint = Arena.ofAuto().allocate(LAYOUT);

		point = new Vec2(b2ManifoldPoint.asSlice(POINT_OFFSET, Vec2.LAYOUT()));
		anchorA = new Vec2(b2ManifoldPoint.asSlice(ANCHOR_A_OFFSET, Vec2.LAYOUT()));
		anchorB = new Vec2(b2ManifoldPoint.asSlice(ANCHOR_B_OFFSET, Vec2.LAYOUT()));
	}

	public ManifoldPoint(MemorySegment memorySegment) {
		b2ManifoldPoint = memorySegment;

		point = new Vec2(b2ManifoldPoint.asSlice(POINT_OFFSET, Vec2.LAYOUT()));
		anchorA = new Vec2(b2ManifoldPoint.asSlice(ANCHOR_A_OFFSET, Vec2.LAYOUT()));
		anchorB = new Vec2(b2ManifoldPoint.asSlice(ANCHOR_B_OFFSET, Vec2.LAYOUT()));
	}

	public void set(MemorySegment memorySegment) {
		MemorySegment.copy(memorySegment, 0L, b2ManifoldPoint, 0L, LAYOUT.byteSize());
	}

	/**
	 * Location of the contact point in world space. Subject to precision loss at
	 * large coordinates.
	 * <p>
	 * Note: Should only be used for debugging.
	 */
	public Vector2f getPoint(Vector2f target) {
		return point.get(target);
	}

	/**
	 * Location of the contact point in world space. Subject to precision loss at
	 * large coordinates.
	 * <p>
	 * Note: Should only be used for debugging.
	 */
	public Vector2f getPoint() {
		return getPoint(new Vector2f());
	}

	/**
	 * Location of the contact point relative to shapeA's origin in world space.
	 * <p>
	 * Note: When used internally to the Box2D solver, this is relative to the body
	 * center of mass.
	 */
	public Vector2f getAnchorA(Vector2f target) {
		return anchorA.get(target);
	}

	/**
	 * Location of the contact point relative to shapeA's origin in world space.
	 * <p>
	 * Note: When used internally to the Box2D solver, this is relative to the body
	 * center of mass.
	 */
	public Vector2f getAnchorA() {
		return getAnchorA(new Vector2f());
	}

	/**
	 * Location of the contact point relative to shapeB's origin in world space.
	 * <p>
	 * Note: When used internally to the Box2D solver, this is relative to the body
	 * center of mass.
	 */
	public Vector2f getAnchorB(Vector2f target) {
		return anchorB.get(target);
	}

	/**
	 * Location of the contact point relative to shapeB's origin in world space.
	 * <p>
	 * Note: When used internally to the Box2D solver, this is relative to the body
	 * center of mass.
	 */
	public Vector2f getAnchorB() {
		return getAnchorB(new Vector2f());
	}

	/**
	 * The separation of the contact point, negative if penetrating.
	 */
	public float getSeparation() {
		return (float) SEPARATION.get(b2ManifoldPoint);
	}

	/**
	 * The impulse along the manifold normal vector.
	 */
	public float getNormalImpulse() {
		return (float) NORMAL_IMPULSE.get(b2ManifoldPoint);
	}

	/**
	 * The friction impulse.
	 */
	public float getTangentImpulse() {
		return (float) TANGENT_IMPULSE.get(b2ManifoldPoint);
	}

	/**
	 * The total normal impulse applied across sub-stepping and restitution. This is
	 * important to identify speculative contact points that had an interaction in
	 * the time step.
	 */
	public float getTotalNormalImpulse() {
		return (float) TOTAL_NORMAL_IMPULSE.get(b2ManifoldPoint);
	}

	/**
	 * Relative normal velocity pre-solve. Used for hit events. If the normal
	 * impulse is zero then there was no hit. Negative means shapes are approaching.
	 */
	public float getNormalVelocity() {
		return (float) NORMAL_VELOCITY.get(b2ManifoldPoint);
	}

	/**
	 * Uniquely identifies a contact point between two shapes.
	 */
	public short getId() {
		return (short) ID.get(b2ManifoldPoint);
	}

	/**
	 * Did this contact point exist the previous step?
	 */
	public boolean persisted() {
		return (boolean) PERSISTED.get(b2ManifoldPoint);
	}

	public MemorySegment memorySegment() {
		return b2ManifoldPoint;
	}

	public static StructLayout LAYOUT() {
		return LAYOUT;
	}

}
