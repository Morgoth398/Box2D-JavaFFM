/*
 * MACHINE GENERATED FILE, DO NOT EDIT.
 */
package volucris.bindings.box2d.joint;

import edu.umd.cs.findbugs.annotations.Nullable;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.SegmentAllocator;
import java.lang.invoke.MethodHandle;
import volucris.bindings.box2d.math.Vec2;
import volucris.bindings.box2d.world.WorldId;

import static java.lang.foreign.ValueLayout.*;
import static volucris.bindings.core.FFMUtils.*;

/**
 * 
 */
public final class MotorJoint {

    private static final LazyConstant<MethodHandle> B2_CREATE_MOTOR_JOINT;
    private static final LazyConstant<MethodHandle> B2_MOTOR_JOINT_SET_LINEAR_OFFSET;
    private static final LazyConstant<MethodHandle> B2_MOTOR_JOINT_GET_LINEAR_OFFSET;
    private static final LazyConstant<MethodHandle> B2_MOTOR_JOINT_SET_ANGULAR_OFFSET;
    private static final LazyConstant<MethodHandle> B2_MOTOR_JOINT_GET_ANGULAR_OFFSET;
    private static final LazyConstant<MethodHandle> B2_MOTOR_JOINT_SET_MAX_FORCE;
    private static final LazyConstant<MethodHandle> B2_MOTOR_JOINT_GET_MAX_FORCE;
    private static final LazyConstant<MethodHandle> B2_MOTOR_JOINT_SET_MAX_TORQUE;
    private static final LazyConstant<MethodHandle> B2_MOTOR_JOINT_GET_MAX_TORQUE;
    private static final LazyConstant<MethodHandle> B2_MOTOR_JOINT_SET_CORRECTION_FACTOR;
    private static final LazyConstant<MethodHandle> B2_MOTOR_JOINT_GET_CORRECTION_FACTOR;

    static {
        //@formatter:off
        B2_CREATE_MOTOR_JOINT = downcallHandle("b2CreateMotorJoint", JointId.LAYOUT, WorldId.LAYOUT, UNBOUNDED_ADDRESS);
        B2_MOTOR_JOINT_SET_LINEAR_OFFSET = downcallHandleVoid("b2MotorJoint_SetLinearOffset", JointId.LAYOUT, Vec2.LAYOUT);
        B2_MOTOR_JOINT_GET_LINEAR_OFFSET = downcallHandle("b2MotorJoint_GetLinearOffset", Vec2.LAYOUT, JointId.LAYOUT);
        B2_MOTOR_JOINT_SET_ANGULAR_OFFSET = downcallHandleVoid("b2MotorJoint_SetAngularOffset", JointId.LAYOUT, JAVA_FLOAT);
        B2_MOTOR_JOINT_GET_ANGULAR_OFFSET = downcallHandle("b2MotorJoint_GetAngularOffset", JAVA_FLOAT, JointId.LAYOUT);
        B2_MOTOR_JOINT_SET_MAX_FORCE = downcallHandleVoid("b2MotorJoint_SetMaxForce", JointId.LAYOUT, JAVA_FLOAT);
        B2_MOTOR_JOINT_GET_MAX_FORCE = downcallHandle("b2MotorJoint_GetMaxForce", JAVA_FLOAT, JointId.LAYOUT);
        B2_MOTOR_JOINT_SET_MAX_TORQUE = downcallHandleVoid("b2MotorJoint_SetMaxTorque", JointId.LAYOUT, JAVA_FLOAT);
        B2_MOTOR_JOINT_GET_MAX_TORQUE = downcallHandle("b2MotorJoint_GetMaxTorque", JAVA_FLOAT, JointId.LAYOUT);
        B2_MOTOR_JOINT_SET_CORRECTION_FACTOR = downcallHandleVoid("b2MotorJoint_SetCorrectionFactor", JointId.LAYOUT, JAVA_FLOAT);
        B2_MOTOR_JOINT_GET_CORRECTION_FACTOR = downcallHandle("b2MotorJoint_GetCorrectionFactor", JAVA_FLOAT, JointId.LAYOUT);
        //@formatter:on
    }

    private MotorJoint() {
    }

    /**
     * Create a motor joint
     */
    public static MemorySegment createMotorJoint(
        SegmentAllocator allocator,
        MemorySegment worldId, 
        MemorySegment def
    ) {
        MethodHandle method = B2_CREATE_MOTOR_JOINT.get();
        try {
            return (MemorySegment) method.invokeExact(
                allocator,
                worldId, 
                def
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #createMotorJoint}.
     */
    public static @Nullable JointId createMotorJoint(
        SegmentAllocator allocator,
        WorldId worldId, 
        MotorJointDef def
    ) {
        MemorySegment segment = createMotorJoint(
            allocator,
            worldId.memorySegment(), 
            def.memorySegment()
        );
    
        if (segment.equals(MemorySegment.NULL))
            return null;
    
        return new JointId(segment);
    }
    
    /**
     * Set the motor joint linear offset target
     */
    public static void setLinearOffset(
        MemorySegment jointId, 
        MemorySegment linearOffset
    ) {
        MethodHandle method = B2_MOTOR_JOINT_SET_LINEAR_OFFSET.get();
        try {
            method.invokeExact(
                jointId, 
                linearOffset
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #setLinearOffset}.
     */
    public static void setLinearOffset(
        JointId jointId, 
        Vec2 linearOffset
    ) {
        setLinearOffset(
            jointId.memorySegment(), 
            linearOffset.memorySegment()
        );
    }
    
    /**
     * Get the motor joint linear offset target
     */
    public static MemorySegment getLinearOffset(
        SegmentAllocator allocator,
        MemorySegment jointId
    ) {
        MethodHandle method = B2_MOTOR_JOINT_GET_LINEAR_OFFSET.get();
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
     * Typed method of {@link #getLinearOffset}.
     */
    public static @Nullable Vec2 getLinearOffset(
        SegmentAllocator allocator,
        JointId jointId
    ) {
        MemorySegment segment = getLinearOffset(
            allocator,
            jointId.memorySegment()
        );
    
        if (segment.equals(MemorySegment.NULL))
            return null;
    
        return new Vec2(segment);
    }
    
    /**
     * Set the motor joint angular offset target in radians. This angle will be unwound so the motor will drive along the shortest arc.
     */
    public static void setAngularOffset(
        MemorySegment jointId, 
        float angularOffset
    ) {
        MethodHandle method = B2_MOTOR_JOINT_SET_ANGULAR_OFFSET.get();
        try {
            method.invokeExact(
                jointId, 
                angularOffset
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #setAngularOffset}.
     */
    public static void setAngularOffset(
        JointId jointId, 
        float angularOffset
    ) {
        setAngularOffset(
            jointId.memorySegment(), 
            angularOffset
        );
    }
    
    /**
     * Get the motor joint angular offset target in radians
     */
    public static float getAngularOffset(
        MemorySegment jointId
    ) {
        MethodHandle method = B2_MOTOR_JOINT_GET_ANGULAR_OFFSET.get();
        try {
            return (float) method.invokeExact(
                jointId
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #getAngularOffset}.
     */
    public static float getAngularOffset(
        JointId jointId
    ) {
        return (float) getAngularOffset(
            jointId.memorySegment()
        );
    }
    
    /**
     * Set the motor joint maximum force, usually in newtons
     */
    public static void setMaxForce(
        MemorySegment jointId, 
        float maxForce
    ) {
        MethodHandle method = B2_MOTOR_JOINT_SET_MAX_FORCE.get();
        try {
            method.invokeExact(
                jointId, 
                maxForce
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #setMaxForce}.
     */
    public static void setMaxForce(
        JointId jointId, 
        float maxForce
    ) {
        setMaxForce(
            jointId.memorySegment(), 
            maxForce
        );
    }
    
    /**
     * Get the motor joint maximum force, usually in newtons
     */
    public static float getMaxForce(
        MemorySegment jointId
    ) {
        MethodHandle method = B2_MOTOR_JOINT_GET_MAX_FORCE.get();
        try {
            return (float) method.invokeExact(
                jointId
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #getMaxForce}.
     */
    public static float getMaxForce(
        JointId jointId
    ) {
        return (float) getMaxForce(
            jointId.memorySegment()
        );
    }
    
    /**
     * Set the motor joint maximum torque, usually in newton-meters
     */
    public static void setMaxTorque(
        MemorySegment jointId, 
        float maxTorque
    ) {
        MethodHandle method = B2_MOTOR_JOINT_SET_MAX_TORQUE.get();
        try {
            method.invokeExact(
                jointId, 
                maxTorque
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #setMaxTorque}.
     */
    public static void setMaxTorque(
        JointId jointId, 
        float maxTorque
    ) {
        setMaxTorque(
            jointId.memorySegment(), 
            maxTorque
        );
    }
    
    /**
     * Get the motor joint maximum torque, usually in newton-meters
     */
    public static float getMaxTorque(
        MemorySegment jointId
    ) {
        MethodHandle method = B2_MOTOR_JOINT_GET_MAX_TORQUE.get();
        try {
            return (float) method.invokeExact(
                jointId
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #getMaxTorque}.
     */
    public static float getMaxTorque(
        JointId jointId
    ) {
        return (float) getMaxTorque(
            jointId.memorySegment()
        );
    }
    
    /**
     * Set the motor joint correction factor, usually in [0, 1]
     */
    public static void setCorrectionFactor(
        MemorySegment jointId, 
        float correctionFactor
    ) {
        MethodHandle method = B2_MOTOR_JOINT_SET_CORRECTION_FACTOR.get();
        try {
            method.invokeExact(
                jointId, 
                correctionFactor
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #setCorrectionFactor}.
     */
    public static void setCorrectionFactor(
        JointId jointId, 
        float correctionFactor
    ) {
        setCorrectionFactor(
            jointId.memorySegment(), 
            correctionFactor
        );
    }
    
    /**
     * Get the motor joint correction factor, usually in [0, 1]
     */
    public static float getCorrectionFactor(
        MemorySegment jointId
    ) {
        MethodHandle method = B2_MOTOR_JOINT_GET_CORRECTION_FACTOR.get();
        try {
            return (float) method.invokeExact(
                jointId
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #getCorrectionFactor}.
     */
    public static float getCorrectionFactor(
        JointId jointId
    ) {
        return (float) getCorrectionFactor(
            jointId.memorySegment()
        );
    }
    
}