/*
 * MACHINE GENERATED FILE, DO NOT EDIT.
 */
package volucris.bindings.box2d.collision;

import java.lang.foreign.Arena;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.StructLayout;
import java.lang.invoke.VarHandle;
import java.util.function.Consumer;
import volucris.bindings.box2d.math.Vec2;
import volucris.bindings.core.NativeStructArray;
import volucris.bindings.core.Struct;

import static java.lang.foreign.ValueLayout.*;

/// ```
/// A manifold point is a contact point belonging to a contact manifold.
/// It holds details related to the geometry and dynamics of the contact points.
/// Box2D uses speculative collision so some contact points may be separated.
/// You may use the totalNormalImpulse to determine if there was an interaction during
/// the time step.
/// ```
public final class ManifoldPoint
		implements Struct<ManifoldPoint> {

    public static final StructLayout LAYOUT;

    public static final VarHandle SEPARATION_HANDLE;
    public static final VarHandle NORMAL_IMPULSE_HANDLE;
    public static final VarHandle TANGENT_IMPULSE_HANDLE;
    public static final VarHandle TOTAL_NORMAL_IMPULSE_HANDLE;
    public static final VarHandle NORMAL_VELOCITY_HANDLE;
    public static final VarHandle ID_HANDLE;
    public static final VarHandle PERSISTED_HANDLE;

    public static final long POINT_BYTE_OFFSET;
    public static final long ANCHOR_A_BYTE_OFFSET;
    public static final long ANCHOR_B_BYTE_OFFSET;
    public static final long SEPARATION_BYTE_OFFSET;
    public static final long NORMAL_IMPULSE_BYTE_OFFSET;
    public static final long TANGENT_IMPULSE_BYTE_OFFSET;
    public static final long TOTAL_NORMAL_IMPULSE_BYTE_OFFSET;
    public static final long NORMAL_VELOCITY_BYTE_OFFSET;
    public static final long ID_BYTE_OFFSET;
    public static final long PERSISTED_BYTE_OFFSET;

    private final MemorySegment segment;

    private final Vec2 point;
    private final Vec2 anchorA;
    private final Vec2 anchorB;

    static {
        //@formatter:off
        LAYOUT = MemoryLayout.structLayout(
            Vec2.LAYOUT.withName("point"),
            Vec2.LAYOUT.withName("anchorA"),
            Vec2.LAYOUT.withName("anchorB"),
            JAVA_FLOAT.withName("separation"),
            JAVA_FLOAT.withName("normalImpulse"),
            JAVA_FLOAT.withName("tangentImpulse"),
            JAVA_FLOAT.withName("totalNormalImpulse"),
            JAVA_FLOAT.withName("normalVelocity"),
            JAVA_SHORT.withName("id"),
            JAVA_BOOLEAN.withName("persisted"),
            MemoryLayout.paddingLayout(1)
        ).withName("b2ManifoldPoint").withByteAlignment(4);
        
        SEPARATION_HANDLE = LAYOUT.varHandle(PathElement.groupElement("separation"));
        NORMAL_IMPULSE_HANDLE = LAYOUT.varHandle(PathElement.groupElement("normalImpulse"));
        TANGENT_IMPULSE_HANDLE = LAYOUT.varHandle(PathElement.groupElement("tangentImpulse"));
        TOTAL_NORMAL_IMPULSE_HANDLE = LAYOUT.varHandle(PathElement.groupElement("totalNormalImpulse"));
        NORMAL_VELOCITY_HANDLE = LAYOUT.varHandle(PathElement.groupElement("normalVelocity"));
        ID_HANDLE = LAYOUT.varHandle(PathElement.groupElement("id"));
        PERSISTED_HANDLE = LAYOUT.varHandle(PathElement.groupElement("persisted"));
        
        POINT_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("point"));
        ANCHOR_A_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("anchorA"));
        ANCHOR_B_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("anchorB"));
        SEPARATION_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("separation"));
        NORMAL_IMPULSE_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("normalImpulse"));
        TANGENT_IMPULSE_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("tangentImpulse"));
        TOTAL_NORMAL_IMPULSE_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("totalNormalImpulse"));
        NORMAL_VELOCITY_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("normalVelocity"));
        ID_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("id"));
        PERSISTED_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("persisted"));
        //@formatter:on
    }

    public ManifoldPoint() {
        this(Arena.ofAuto());
    }
    
    public ManifoldPoint(Arena arena) {
        this(arena.allocate(LAYOUT));
    }
    
    public ManifoldPoint(MemorySegment segment) {
        this.segment = segment;
    
        point = new Vec2(segment.asSlice(POINT_BYTE_OFFSET, Vec2.LAYOUT));
        anchorA = new Vec2(segment.asSlice(ANCHOR_A_BYTE_OFFSET, Vec2.LAYOUT));
        anchorB = new Vec2(segment.asSlice(ANCHOR_B_BYTE_OFFSET, Vec2.LAYOUT));
    }

    /// @see #separation()
    public ManifoldPoint separation(float separation) {
    	SEPARATION_HANDLE.set(segment, 0L, separation);
    	return this;
    }
    
    /// ```
    /// The separation of the contact point, negative if penetrating
    /// ```
    public float separation() {
    	return (float) SEPARATION_HANDLE.get(segment, 0L);
    }
    
    /// @see #normalImpulse()
    public ManifoldPoint normalImpulse(float normalImpulse) {
    	NORMAL_IMPULSE_HANDLE.set(segment, 0L, normalImpulse);
    	return this;
    }
    
    /// ```
    /// The impulse along the manifold normal vector.
    /// ```
    public float normalImpulse() {
    	return (float) NORMAL_IMPULSE_HANDLE.get(segment, 0L);
    }
    
    /// @see #tangentImpulse()
    public ManifoldPoint tangentImpulse(float tangentImpulse) {
    	TANGENT_IMPULSE_HANDLE.set(segment, 0L, tangentImpulse);
    	return this;
    }
    
    /// ```
    /// The friction impulse
    /// ```
    public float tangentImpulse() {
    	return (float) TANGENT_IMPULSE_HANDLE.get(segment, 0L);
    }
    
    /// @see #totalNormalImpulse()
    public ManifoldPoint totalNormalImpulse(float totalNormalImpulse) {
    	TOTAL_NORMAL_IMPULSE_HANDLE.set(segment, 0L, totalNormalImpulse);
    	return this;
    }
    
    /// ```
    /// The total normal impulse applied across sub-stepping and restitution. This is important
    /// to identify speculative contact points that had an interaction in the time step.
    /// ```
    public float totalNormalImpulse() {
    	return (float) TOTAL_NORMAL_IMPULSE_HANDLE.get(segment, 0L);
    }
    
    /// @see #normalVelocity()
    public ManifoldPoint normalVelocity(float normalVelocity) {
    	NORMAL_VELOCITY_HANDLE.set(segment, 0L, normalVelocity);
    	return this;
    }
    
    /// ```
    /// Relative normal velocity pre-solve. Used for hit events. If the normal impulse is
    /// zero then there was no hit. Negative means shapes are approaching.
    /// ```
    public float normalVelocity() {
    	return (float) NORMAL_VELOCITY_HANDLE.get(segment, 0L);
    }
    
    /// @see #id()
    public ManifoldPoint id(short id) {
    	ID_HANDLE.set(segment, 0L, id);
    	return this;
    }
    
    /// ```
    /// Uniquely identifies a contact point between two shapes
    /// ```
    public short id() {
    	return (short) ID_HANDLE.get(segment, 0L);
    }
    
    /// @see #persisted()
    public ManifoldPoint persisted(boolean persisted) {
    	PERSISTED_HANDLE.set(segment, 0L, persisted);
    	return this;
    }
    
    /// ```
    /// Did this contact point exist the previous step?
    /// ```
    public boolean persisted() {
    	return (boolean) PERSISTED_HANDLE.get(segment, 0L);
    }
    
    /// @see #point()
    public ManifoldPoint point(Consumer<Vec2> consumer) {
    	consumer.accept(point);
    	return this;
    }
    
    /// @see #point()
    public ManifoldPoint point(Vec2 other) {
    	point.set(other);
    	return this;
    }
    
    /// ```
    /// Location of the contact point in world space. Subject to precision loss at large coordinates.
    /// @note Should only be used for debugging.
    /// ```
    public Vec2 point() {
    	return point;
    }
    
    /// @see #anchorA()
    public ManifoldPoint anchorA(Consumer<Vec2> consumer) {
    	consumer.accept(anchorA);
    	return this;
    }
    
    /// @see #anchorA()
    public ManifoldPoint anchorA(Vec2 other) {
    	anchorA.set(other);
    	return this;
    }
    
    /// ```
    /// Location of the contact point relative to shapeA's origin in world space
    /// @note When used internally to the Box2D solver, this is relative to the body center of mass.
    /// ```
    public Vec2 anchorA() {
    	return anchorA;
    }
    
    /// @see #anchorB()
    public ManifoldPoint anchorB(Consumer<Vec2> consumer) {
    	consumer.accept(anchorB);
    	return this;
    }
    
    /// @see #anchorB()
    public ManifoldPoint anchorB(Vec2 other) {
    	anchorB.set(other);
    	return this;
    }
    
    /// ```
    /// Location of the contact point relative to shapeB's origin in world space
    /// @note When used internally to the Box2D solver, this is relative to the body center of mass.
    /// ```
    public Vec2 anchorB() {
    	return anchorB;
    }
    
    @Override
    public ManifoldPoint set(ManifoldPoint other) {
        return set(other.segment);
    }
    
    @Override
    public ManifoldPoint set(MemorySegment src) {
        MemorySegment.copy(src, 0L, segment, 0L, LAYOUT.byteSize());
        return this;
    }
    
    @Override
    public MemorySegment memorySegment() {
        return segment;
    }
    
    public NativeStructArray<ManifoldPoint> asArray() {
        return new NativeStructArray<>(this);
    }
    
    public static NativeStructArray<ManifoldPoint> array(Arena arena, int count) {
        return new NativeStructArray<>(
            arena,
            LAYOUT,
            segment -> new ManifoldPoint(segment),
            count
        );
    }
    
    public static NativeStructArray<ManifoldPoint> array(Arena arena, ManifoldPoint... structs) {
        NativeStructArray<ManifoldPoint> array = new NativeStructArray<>(
            arena,
            LAYOUT,
            segment -> new ManifoldPoint(segment),
            structs.length
        );
    
        for (int i = 0; i < structs.length; i++) {
            array.set(i, structs[i]);
        }
    
        return array;
    }
    
    public static NativeStructArray<ManifoldPoint> array(MemorySegment array) {
        return new NativeStructArray<>(
            array,
            LAYOUT,
            segment -> new ManifoldPoint(segment)
        );
    }
    
}