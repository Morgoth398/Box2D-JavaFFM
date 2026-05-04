/*
 * MACHINE GENERATED FILE, DO NOT EDIT.
 */
package volucris.bindings.box2d.joint;

import edu.umd.cs.findbugs.annotations.Nullable;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.SegmentAllocator;
import java.lang.invoke.MethodHandle;
import volucris.bindings.box2d.body.BodyId;
import volucris.bindings.box2d.math.Vec2;
import volucris.bindings.box2d.world.WorldId;
import volucris.bindings.core.NativeFloatArray;

import static java.lang.foreign.ValueLayout.*;
import static volucris.bindings.core.FFMUtils.*;

/**
 * 
 */
public final class Joint {

    private static final LazyConstant<MethodHandle> B2_DESTROY_JOINT;
    private static final LazyConstant<MethodHandle> B2_JOINT_IS_VALID;
    private static final LazyConstant<MethodHandle> B2_JOINT_GET_TYPE;
    private static final LazyConstant<MethodHandle> B2_JOINT_GET_BODY_A;
    private static final LazyConstant<MethodHandle> B2_JOINT_GET_BODY_B;
    private static final LazyConstant<MethodHandle> B2_JOINT_GET_WORLD;
    private static final LazyConstant<MethodHandle> B2_JOINT_SET_LOCAL_ANCHOR_A;
    private static final LazyConstant<MethodHandle> B2_JOINT_GET_LOCAL_ANCHOR_A;
    private static final LazyConstant<MethodHandle> B2_JOINT_SET_LOCAL_ANCHOR_B;
    private static final LazyConstant<MethodHandle> B2_JOINT_GET_LOCAL_ANCHOR_B;
    private static final LazyConstant<MethodHandle> B2_JOINT_GET_REFERENCE_ANGLE;
    private static final LazyConstant<MethodHandle> B2_JOINT_SET_REFERENCE_ANGLE;
    private static final LazyConstant<MethodHandle> B2_JOINT_SET_LOCAL_AXIS_A;
    private static final LazyConstant<MethodHandle> B2_JOINT_GET_LOCAL_AXIS_A;
    private static final LazyConstant<MethodHandle> B2_JOINT_SET_COLLIDE_CONNECTED;
    private static final LazyConstant<MethodHandle> B2_JOINT_GET_COLLIDE_CONNECTED;
    private static final LazyConstant<MethodHandle> B2_JOINT_SET_USER_DATA;
    private static final LazyConstant<MethodHandle> B2_JOINT_GET_USER_DATA;
    private static final LazyConstant<MethodHandle> B2_JOINT_WAKE_BODIES;
    private static final LazyConstant<MethodHandle> B2_JOINT_GET_CONSTRAINT_FORCE;
    private static final LazyConstant<MethodHandle> B2_JOINT_GET_CONSTRAINT_TORQUE;
    private static final LazyConstant<MethodHandle> B2_JOINT_GET_LINEAR_SEPARATION;
    private static final LazyConstant<MethodHandle> B2_JOINT_GET_ANGULAR_SEPARATION;
    private static final LazyConstant<MethodHandle> B2_JOINT_GET_CONSTRAINT_TUNING;
    private static final LazyConstant<MethodHandle> B2_JOINT_SET_CONSTRAINT_TUNING;

    static {
        //@formatter:off
        B2_DESTROY_JOINT = downcallHandleVoid("b2DestroyJoint", JointId.LAYOUT);
        B2_JOINT_IS_VALID = downcallHandle("b2Joint_IsValid", JAVA_BOOLEAN, JointId.LAYOUT);
        B2_JOINT_GET_TYPE = downcallHandle("b2Joint_GetType", JAVA_INT, JointId.LAYOUT);
        B2_JOINT_GET_BODY_A = downcallHandle("b2Joint_GetBodyA", BodyId.LAYOUT, JointId.LAYOUT);
        B2_JOINT_GET_BODY_B = downcallHandle("b2Joint_GetBodyB", BodyId.LAYOUT, JointId.LAYOUT);
        B2_JOINT_GET_WORLD = downcallHandle("b2Joint_GetWorld", WorldId.LAYOUT, JointId.LAYOUT);
        B2_JOINT_SET_LOCAL_ANCHOR_A = downcallHandleVoid("b2Joint_SetLocalAnchorA", JointId.LAYOUT, Vec2.LAYOUT);
        B2_JOINT_GET_LOCAL_ANCHOR_A = downcallHandle("b2Joint_GetLocalAnchorA", Vec2.LAYOUT, JointId.LAYOUT);
        B2_JOINT_SET_LOCAL_ANCHOR_B = downcallHandleVoid("b2Joint_SetLocalAnchorB", JointId.LAYOUT, Vec2.LAYOUT);
        B2_JOINT_GET_LOCAL_ANCHOR_B = downcallHandle("b2Joint_GetLocalAnchorB", Vec2.LAYOUT, JointId.LAYOUT);
        B2_JOINT_GET_REFERENCE_ANGLE = downcallHandle("b2Joint_GetReferenceAngle", JAVA_FLOAT, JointId.LAYOUT);
        B2_JOINT_SET_REFERENCE_ANGLE = downcallHandleVoid("b2Joint_SetReferenceAngle", JointId.LAYOUT, JAVA_FLOAT);
        B2_JOINT_SET_LOCAL_AXIS_A = downcallHandleVoid("b2Joint_SetLocalAxisA", JointId.LAYOUT, Vec2.LAYOUT);
        B2_JOINT_GET_LOCAL_AXIS_A = downcallHandle("b2Joint_GetLocalAxisA", Vec2.LAYOUT, JointId.LAYOUT);
        B2_JOINT_SET_COLLIDE_CONNECTED = downcallHandleVoid("b2Joint_SetCollideConnected", JointId.LAYOUT, JAVA_BOOLEAN);
        B2_JOINT_GET_COLLIDE_CONNECTED = downcallHandle("b2Joint_GetCollideConnected", JAVA_BOOLEAN, JointId.LAYOUT);
        B2_JOINT_SET_USER_DATA = downcallHandleVoid("b2Joint_SetUserData", JointId.LAYOUT, UNBOUNDED_ADDRESS);
        B2_JOINT_GET_USER_DATA = downcallHandle("b2Joint_GetUserData", UNBOUNDED_ADDRESS, JointId.LAYOUT);
        B2_JOINT_WAKE_BODIES = downcallHandleVoid("b2Joint_WakeBodies", JointId.LAYOUT);
        B2_JOINT_GET_CONSTRAINT_FORCE = downcallHandle("b2Joint_GetConstraintForce", Vec2.LAYOUT, JointId.LAYOUT);
        B2_JOINT_GET_CONSTRAINT_TORQUE = downcallHandle("b2Joint_GetConstraintTorque", JAVA_FLOAT, JointId.LAYOUT);
        B2_JOINT_GET_LINEAR_SEPARATION = downcallHandle("b2Joint_GetLinearSeparation", JAVA_FLOAT, JointId.LAYOUT);
        B2_JOINT_GET_ANGULAR_SEPARATION = downcallHandle("b2Joint_GetAngularSeparation", JAVA_FLOAT, JointId.LAYOUT);
        B2_JOINT_GET_CONSTRAINT_TUNING = downcallHandleVoid("b2Joint_GetConstraintTuning", JointId.LAYOUT, UNBOUNDED_ADDRESS, UNBOUNDED_ADDRESS);
        B2_JOINT_SET_CONSTRAINT_TUNING = downcallHandleVoid("b2Joint_SetConstraintTuning", JointId.LAYOUT, JAVA_FLOAT, JAVA_FLOAT);
        //@formatter:on
    }

    private Joint() {
    }

    /**
     * Destroy a joint
     */
    public static void destroyJoint(
        MemorySegment jointId
    ) {
        MethodHandle method = B2_DESTROY_JOINT.get();
        try {
            method.invokeExact(
                jointId
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #destroyJoint}.
     */
    public static void destroyJoint(
        JointId jointId
    ) {
        destroyJoint(
            jointId.memorySegment()
        );
    }
    
    /**
     * Joint identifier validation. Provides validation for up to 64K allocations.
     */
    public static boolean isValid(
        MemorySegment id
    ) {
        MethodHandle method = B2_JOINT_IS_VALID.get();
        try {
            return (boolean) method.invokeExact(
                id
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #isValid}.
     */
    public static boolean isValid(
        JointId id
    ) {
        return (boolean) isValid(
            id.memorySegment()
        );
    }
    
    /**
     * Get the joint type
     */
    public static int getType(
        MemorySegment jointId
    ) {
        MethodHandle method = B2_JOINT_GET_TYPE.get();
        try {
            return (int) method.invokeExact(
                jointId
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #getType}.
     */
    public static int getType(
        JointId jointId
    ) {
        return (int) getType(
            jointId.memorySegment()
        );
    }
    
    /**
     * Get body A id on a joint
     */
    public static MemorySegment getBodyA(
        SegmentAllocator allocator,
        MemorySegment jointId
    ) {
        MethodHandle method = B2_JOINT_GET_BODY_A.get();
        try {
            return (MemorySegment) method.invokeExact(
                allocator,
                jointId
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #getBodyA}.
     */
    public static @Nullable BodyId getBodyA(
        SegmentAllocator allocator,
        JointId jointId
    ) {
        MemorySegment segment = getBodyA(
            allocator,
            jointId.memorySegment()
        );
    
        if (segment.equals(MemorySegment.NULL))
            return null;
    
        return new BodyId(segment);
    }
    
    /**
     * Get body B id on a joint
     */
    public static MemorySegment getBodyB(
        SegmentAllocator allocator,
        MemorySegment jointId
    ) {
        MethodHandle method = B2_JOINT_GET_BODY_B.get();
        try {
            return (MemorySegment) method.invokeExact(
                allocator,
                jointId
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #getBodyB}.
     */
    public static @Nullable BodyId getBodyB(
        SegmentAllocator allocator,
        JointId jointId
    ) {
        MemorySegment segment = getBodyB(
            allocator,
            jointId.memorySegment()
        );
    
        if (segment.equals(MemorySegment.NULL))
            return null;
    
        return new BodyId(segment);
    }
    
    /**
     * Get the world that owns this joint
     */
    public static MemorySegment getWorld(
        SegmentAllocator allocator,
        MemorySegment jointId
    ) {
        MethodHandle method = B2_JOINT_GET_WORLD.get();
        try {
            return (MemorySegment) method.invokeExact(
                allocator,
                jointId
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #getWorld}.
     */
    public static @Nullable WorldId getWorld(
        SegmentAllocator allocator,
        JointId jointId
    ) {
        MemorySegment segment = getWorld(
            allocator,
            jointId.memorySegment()
        );
    
        if (segment.equals(MemorySegment.NULL))
            return null;
    
        return new WorldId(segment);
    }
    
    /**
     * Set the local anchor on bodyA
     */
    public static void setLocalAnchorA(
        MemorySegment jointId, 
        MemorySegment localAnchor
    ) {
        MethodHandle method = B2_JOINT_SET_LOCAL_ANCHOR_A.get();
        try {
            method.invokeExact(
                jointId, 
                localAnchor
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #setLocalAnchorA}.
     */
    public static void setLocalAnchorA(
        JointId jointId, 
        Vec2 localAnchor
    ) {
        setLocalAnchorA(
            jointId.memorySegment(), 
            localAnchor.memorySegment()
        );
    }
    
    /**
     * Get the local anchor on bodyA
     */
    public static MemorySegment getLocalAnchorA(
        SegmentAllocator allocator,
        MemorySegment jointId
    ) {
        MethodHandle method = B2_JOINT_GET_LOCAL_ANCHOR_A.get();
        try {
            return (MemorySegment) method.invokeExact(
                allocator,
                jointId
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #getLocalAnchorA}.
     */
    public static @Nullable Vec2 getLocalAnchorA(
        SegmentAllocator allocator,
        JointId jointId
    ) {
        MemorySegment segment = getLocalAnchorA(
            allocator,
            jointId.memorySegment()
        );
    
        if (segment.equals(MemorySegment.NULL))
            return null;
    
        return new Vec2(segment);
    }
    
    /**
     * Set the local anchor on bodyB
     */
    public static void setLocalAnchorB(
        MemorySegment jointId, 
        MemorySegment localAnchor
    ) {
        MethodHandle method = B2_JOINT_SET_LOCAL_ANCHOR_B.get();
        try {
            method.invokeExact(
                jointId, 
                localAnchor
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #setLocalAnchorB}.
     */
    public static void setLocalAnchorB(
        JointId jointId, 
        Vec2 localAnchor
    ) {
        setLocalAnchorB(
            jointId.memorySegment(), 
            localAnchor.memorySegment()
        );
    }
    
    /**
     * Get the local anchor on bodyB
     */
    public static MemorySegment getLocalAnchorB(
        SegmentAllocator allocator,
        MemorySegment jointId
    ) {
        MethodHandle method = B2_JOINT_GET_LOCAL_ANCHOR_B.get();
        try {
            return (MemorySegment) method.invokeExact(
                allocator,
                jointId
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #getLocalAnchorB}.
     */
    public static @Nullable Vec2 getLocalAnchorB(
        SegmentAllocator allocator,
        JointId jointId
    ) {
        MemorySegment segment = getLocalAnchorB(
            allocator,
            jointId.memorySegment()
        );
    
        if (segment.equals(MemorySegment.NULL))
            return null;
    
        return new Vec2(segment);
    }
    
    /**
     * Get the joint reference angle in radians (revolute, prismatic, and weld)
     */
    public static float getReferenceAngle(
        MemorySegment jointId
    ) {
        MethodHandle method = B2_JOINT_GET_REFERENCE_ANGLE.get();
        try {
            return (float) method.invokeExact(
                jointId
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #getReferenceAngle}.
     */
    public static float getReferenceAngle(
        JointId jointId
    ) {
        return (float) getReferenceAngle(
            jointId.memorySegment()
        );
    }
    
    /**
     * Set the joint reference angle in radians, must be in [-pi,pi]. (revolute, prismatic, and weld)
     */
    public static void setReferenceAngle(
        MemorySegment jointId, 
        float angleInRadians
    ) {
        MethodHandle method = B2_JOINT_SET_REFERENCE_ANGLE.get();
        try {
            method.invokeExact(
                jointId, 
                angleInRadians
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #setReferenceAngle}.
     */
    public static void setReferenceAngle(
        JointId jointId, 
        float angleInRadians
    ) {
        setReferenceAngle(
            jointId.memorySegment(), 
            angleInRadians
        );
    }
    
    /**
     * Set the local axis on bodyA (prismatic and wheel)
     */
    public static void setLocalAxisA(
        MemorySegment jointId, 
        MemorySegment localAxis
    ) {
        MethodHandle method = B2_JOINT_SET_LOCAL_AXIS_A.get();
        try {
            method.invokeExact(
                jointId, 
                localAxis
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #setLocalAxisA}.
     */
    public static void setLocalAxisA(
        JointId jointId, 
        Vec2 localAxis
    ) {
        setLocalAxisA(
            jointId.memorySegment(), 
            localAxis.memorySegment()
        );
    }
    
    /**
     * Get the local axis on bodyA (prismatic and wheel)
     */
    public static MemorySegment getLocalAxisA(
        SegmentAllocator allocator,
        MemorySegment jointId
    ) {
        MethodHandle method = B2_JOINT_GET_LOCAL_AXIS_A.get();
        try {
            return (MemorySegment) method.invokeExact(
                allocator,
                jointId
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #getLocalAxisA}.
     */
    public static @Nullable Vec2 getLocalAxisA(
        SegmentAllocator allocator,
        JointId jointId
    ) {
        MemorySegment segment = getLocalAxisA(
            allocator,
            jointId.memorySegment()
        );
    
        if (segment.equals(MemorySegment.NULL))
            return null;
    
        return new Vec2(segment);
    }
    
    /**
     * Toggle collision between connected bodies
     */
    public static void setCollideConnected(
        MemorySegment jointId, 
        boolean shouldCollide
    ) {
        MethodHandle method = B2_JOINT_SET_COLLIDE_CONNECTED.get();
        try {
            method.invokeExact(
                jointId, 
                shouldCollide
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #setCollideConnected}.
     */
    public static void setCollideConnected(
        JointId jointId, 
        boolean shouldCollide
    ) {
        setCollideConnected(
            jointId.memorySegment(), 
            shouldCollide
        );
    }
    
    /**
     * Is collision allowed between connected bodies?
     */
    public static boolean getCollideConnected(
        MemorySegment jointId
    ) {
        MethodHandle method = B2_JOINT_GET_COLLIDE_CONNECTED.get();
        try {
            return (boolean) method.invokeExact(
                jointId
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #getCollideConnected}.
     */
    public static boolean getCollideConnected(
        JointId jointId
    ) {
        return (boolean) getCollideConnected(
            jointId.memorySegment()
        );
    }
    
    /**
     * Set the user data on a joint
     */
    public static void setUserData(
        MemorySegment jointId, 
        MemorySegment userData
    ) {
        MethodHandle method = B2_JOINT_SET_USER_DATA.get();
        try {
            method.invokeExact(
                jointId, 
                userData
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #setUserData}.
     */
    public static void setUserData(
        JointId jointId, 
        MemorySegment userData
    ) {
        setUserData(
            jointId.memorySegment(), 
            userData
        );
    }
    
    /**
     * Get the user data on a joint
     */
    public static MemorySegment getUserData(
        MemorySegment jointId
    ) {
        MethodHandle method = B2_JOINT_GET_USER_DATA.get();
        try {
            return (MemorySegment) method.invokeExact(
                jointId
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #getUserData}.
     */
    public static @Nullable MemorySegment getUserData(
        JointId jointId
    ) {
        MemorySegment segment = getUserData(
            jointId.memorySegment()
        );
    
        if (segment.equals(MemorySegment.NULL))
            return null;
    
        return segment;
    }
    
    /**
     * Wake the bodies connect to this joint
     */
    public static void wakeBodies(
        MemorySegment jointId
    ) {
        MethodHandle method = B2_JOINT_WAKE_BODIES.get();
        try {
            method.invokeExact(
                jointId
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #wakeBodies}.
     */
    public static void wakeBodies(
        JointId jointId
    ) {
        wakeBodies(
            jointId.memorySegment()
        );
    }
    
    /**
     * Get the current constraint force for this joint. Usually in Newtons.
     */
    public static MemorySegment getConstraintForce(
        SegmentAllocator allocator,
        MemorySegment jointId
    ) {
        MethodHandle method = B2_JOINT_GET_CONSTRAINT_FORCE.get();
        try {
            return (MemorySegment) method.invokeExact(
                allocator,
                jointId
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #getConstraintForce}.
     */
    public static @Nullable Vec2 getConstraintForce(
        SegmentAllocator allocator,
        JointId jointId
    ) {
        MemorySegment segment = getConstraintForce(
            allocator,
            jointId.memorySegment()
        );
    
        if (segment.equals(MemorySegment.NULL))
            return null;
    
        return new Vec2(segment);
    }
    
    /**
     * Get the current constraint torque for this joint. Usually in Newton * meters.
     */
    public static float getConstraintTorque(
        MemorySegment jointId
    ) {
        MethodHandle method = B2_JOINT_GET_CONSTRAINT_TORQUE.get();
        try {
            return (float) method.invokeExact(
                jointId
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #getConstraintTorque}.
     */
    public static float getConstraintTorque(
        JointId jointId
    ) {
        return (float) getConstraintTorque(
            jointId.memorySegment()
        );
    }
    
    /**
     * Get the current linear separation error for this joint. Does not consider admissible movement. Usually in meters.
     */
    public static float getLinearSeparation(
        MemorySegment jointId
    ) {
        MethodHandle method = B2_JOINT_GET_LINEAR_SEPARATION.get();
        try {
            return (float) method.invokeExact(
                jointId
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #getLinearSeparation}.
     */
    public static float getLinearSeparation(
        JointId jointId
    ) {
        return (float) getLinearSeparation(
            jointId.memorySegment()
        );
    }
    
    /**
     * Get the current angular separation error for this joint. Does not consider admissible movement. Usually in meters.
     */
    public static float getAngularSeparation(
        MemorySegment jointId
    ) {
        MethodHandle method = B2_JOINT_GET_ANGULAR_SEPARATION.get();
        try {
            return (float) method.invokeExact(
                jointId
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #getAngularSeparation}.
     */
    public static float getAngularSeparation(
        JointId jointId
    ) {
        return (float) getAngularSeparation(
            jointId.memorySegment()
        );
    }
    
    /**
     * Get the joint constraint tuning. Advanced feature.
     */
    public static void getConstraintTuning(
        MemorySegment jointId, 
        MemorySegment hertz, 
        MemorySegment dampingRatio
    ) {
        MethodHandle method = B2_JOINT_GET_CONSTRAINT_TUNING.get();
        try {
            method.invokeExact(
                jointId, 
                hertz, 
                dampingRatio
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #getConstraintTuning}.
     */
    public static void getConstraintTuning(
        JointId jointId, 
        NativeFloatArray hertz, 
        NativeFloatArray dampingRatio
    ) {
        getConstraintTuning(
            jointId.memorySegment(), 
            hertz.memorySegment(), 
            dampingRatio.memorySegment()
        );
    }
    
    /**
     * Set the joint constraint tuning. Advanced feature.
     */
    public static void setConstraintTuning(
        MemorySegment jointId, 
        float hertz, 
        float dampingRatio
    ) {
        MethodHandle method = B2_JOINT_SET_CONSTRAINT_TUNING.get();
        try {
            method.invokeExact(
                jointId, 
                hertz, 
                dampingRatio
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #setConstraintTuning}.
     */
    public static void setConstraintTuning(
        JointId jointId, 
        float hertz, 
        float dampingRatio
    ) {
        setConstraintTuning(
            jointId.memorySegment(), 
            hertz, 
            dampingRatio
        );
    }
    
}