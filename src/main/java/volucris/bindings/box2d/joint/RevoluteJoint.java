/*
 * MACHINE GENERATED FILE, DO NOT EDIT.
 */
package volucris.bindings.box2d.joint;

import edu.umd.cs.findbugs.annotations.Nullable;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.SegmentAllocator;
import java.lang.invoke.MethodHandle;
import volucris.bindings.box2d.world.WorldId;

import static java.lang.foreign.ValueLayout.*;
import static volucris.bindings.core.FFMUtils.*;

/**
 * 
 */
public final class RevoluteJoint {

    private static final LazyConstant<MethodHandle> B2_CREATE_REVOLUTE_JOINT;
    private static final LazyConstant<MethodHandle> B2_REVOLUTE_JOINT_ENABLE_SPRING;
    private static final LazyConstant<MethodHandle> B2_REVOLUTE_JOINT_IS_SPRING_ENABLED;
    private static final LazyConstant<MethodHandle> B2_REVOLUTE_JOINT_SET_SPRING_HERTZ;
    private static final LazyConstant<MethodHandle> B2_REVOLUTE_JOINT_GET_SPRING_HERTZ;
    private static final LazyConstant<MethodHandle> B2_REVOLUTE_JOINT_SET_SPRING_DAMPING_RATIO;
    private static final LazyConstant<MethodHandle> B2_REVOLUTE_JOINT_GET_SPRING_DAMPING_RATIO;
    private static final LazyConstant<MethodHandle> B2_REVOLUTE_JOINT_SET_TARGET_ANGLE;
    private static final LazyConstant<MethodHandle> B2_REVOLUTE_JOINT_GET_TARGET_ANGLE;
    private static final LazyConstant<MethodHandle> B2_REVOLUTE_JOINT_GET_ANGLE;
    private static final LazyConstant<MethodHandle> B2_REVOLUTE_JOINT_ENABLE_LIMIT;
    private static final LazyConstant<MethodHandle> B2_REVOLUTE_JOINT_IS_LIMIT_ENABLED;
    private static final LazyConstant<MethodHandle> B2_REVOLUTE_JOINT_GET_LOWER_LIMIT;
    private static final LazyConstant<MethodHandle> B2_REVOLUTE_JOINT_GET_UPPER_LIMIT;
    private static final LazyConstant<MethodHandle> B2_REVOLUTE_JOINT_SET_LIMITS;
    private static final LazyConstant<MethodHandle> B2_REVOLUTE_JOINT_ENABLE_MOTOR;
    private static final LazyConstant<MethodHandle> B2_REVOLUTE_JOINT_IS_MOTOR_ENABLED;
    private static final LazyConstant<MethodHandle> B2_REVOLUTE_JOINT_SET_MOTOR_SPEED;
    private static final LazyConstant<MethodHandle> B2_REVOLUTE_JOINT_GET_MOTOR_SPEED;
    private static final LazyConstant<MethodHandle> B2_REVOLUTE_JOINT_GET_MOTOR_TORQUE;
    private static final LazyConstant<MethodHandle> B2_REVOLUTE_JOINT_SET_MAX_MOTOR_TORQUE;
    private static final LazyConstant<MethodHandle> B2_REVOLUTE_JOINT_GET_MAX_MOTOR_TORQUE;

    static {
        //@formatter:off
        B2_CREATE_REVOLUTE_JOINT = downcallHandle("b2CreateRevoluteJoint", JointId.LAYOUT, WorldId.LAYOUT, UNBOUNDED_ADDRESS);
        B2_REVOLUTE_JOINT_ENABLE_SPRING = downcallHandleVoid("b2RevoluteJoint_EnableSpring", JointId.LAYOUT, JAVA_BOOLEAN);
        B2_REVOLUTE_JOINT_IS_SPRING_ENABLED = downcallHandle("b2RevoluteJoint_IsSpringEnabled", JAVA_BOOLEAN, JointId.LAYOUT);
        B2_REVOLUTE_JOINT_SET_SPRING_HERTZ = downcallHandleVoid("b2RevoluteJoint_SetSpringHertz", JointId.LAYOUT, JAVA_FLOAT);
        B2_REVOLUTE_JOINT_GET_SPRING_HERTZ = downcallHandle("b2RevoluteJoint_GetSpringHertz", JAVA_FLOAT, JointId.LAYOUT);
        B2_REVOLUTE_JOINT_SET_SPRING_DAMPING_RATIO = downcallHandleVoid("b2RevoluteJoint_SetSpringDampingRatio", JointId.LAYOUT, JAVA_FLOAT);
        B2_REVOLUTE_JOINT_GET_SPRING_DAMPING_RATIO = downcallHandle("b2RevoluteJoint_GetSpringDampingRatio", JAVA_FLOAT, JointId.LAYOUT);
        B2_REVOLUTE_JOINT_SET_TARGET_ANGLE = downcallHandleVoid("b2RevoluteJoint_SetTargetAngle", JointId.LAYOUT, JAVA_FLOAT);
        B2_REVOLUTE_JOINT_GET_TARGET_ANGLE = downcallHandle("b2RevoluteJoint_GetTargetAngle", JAVA_FLOAT, JointId.LAYOUT);
        B2_REVOLUTE_JOINT_GET_ANGLE = downcallHandle("b2RevoluteJoint_GetAngle", JAVA_FLOAT, JointId.LAYOUT);
        B2_REVOLUTE_JOINT_ENABLE_LIMIT = downcallHandleVoid("b2RevoluteJoint_EnableLimit", JointId.LAYOUT, JAVA_BOOLEAN);
        B2_REVOLUTE_JOINT_IS_LIMIT_ENABLED = downcallHandle("b2RevoluteJoint_IsLimitEnabled", JAVA_BOOLEAN, JointId.LAYOUT);
        B2_REVOLUTE_JOINT_GET_LOWER_LIMIT = downcallHandle("b2RevoluteJoint_GetLowerLimit", JAVA_FLOAT, JointId.LAYOUT);
        B2_REVOLUTE_JOINT_GET_UPPER_LIMIT = downcallHandle("b2RevoluteJoint_GetUpperLimit", JAVA_FLOAT, JointId.LAYOUT);
        B2_REVOLUTE_JOINT_SET_LIMITS = downcallHandleVoid("b2RevoluteJoint_SetLimits", JointId.LAYOUT, JAVA_FLOAT, JAVA_FLOAT);
        B2_REVOLUTE_JOINT_ENABLE_MOTOR = downcallHandleVoid("b2RevoluteJoint_EnableMotor", JointId.LAYOUT, JAVA_BOOLEAN);
        B2_REVOLUTE_JOINT_IS_MOTOR_ENABLED = downcallHandle("b2RevoluteJoint_IsMotorEnabled", JAVA_BOOLEAN, JointId.LAYOUT);
        B2_REVOLUTE_JOINT_SET_MOTOR_SPEED = downcallHandleVoid("b2RevoluteJoint_SetMotorSpeed", JointId.LAYOUT, JAVA_FLOAT);
        B2_REVOLUTE_JOINT_GET_MOTOR_SPEED = downcallHandle("b2RevoluteJoint_GetMotorSpeed", JAVA_FLOAT, JointId.LAYOUT);
        B2_REVOLUTE_JOINT_GET_MOTOR_TORQUE = downcallHandle("b2RevoluteJoint_GetMotorTorque", JAVA_FLOAT, JointId.LAYOUT);
        B2_REVOLUTE_JOINT_SET_MAX_MOTOR_TORQUE = downcallHandleVoid("b2RevoluteJoint_SetMaxMotorTorque", JointId.LAYOUT, JAVA_FLOAT);
        B2_REVOLUTE_JOINT_GET_MAX_MOTOR_TORQUE = downcallHandle("b2RevoluteJoint_GetMaxMotorTorque", JAVA_FLOAT, JointId.LAYOUT);
        //@formatter:on
    }

    private RevoluteJoint() {
    }

    /**
     * Create a revolute joint
     */
    public static MemorySegment createRevoluteJoint(
        SegmentAllocator allocator,
        MemorySegment worldId, 
        MemorySegment def
    ) {
        MethodHandle method = B2_CREATE_REVOLUTE_JOINT.get();
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
     * Typed method of {@link #createRevoluteJoint}.
     */
    public static @Nullable JointId createRevoluteJoint(
        SegmentAllocator allocator,
        WorldId worldId, 
        RevoluteJointDef def
    ) {
        MemorySegment segment = createRevoluteJoint(
            allocator,
            worldId.memorySegment(), 
            def.memorySegment()
        );
    
        if (segment.equals(MemorySegment.NULL))
            return null;
    
        return new JointId(segment);
    }
    
    /**
     * Enable/disable the revolute joint spring
     */
    public static void enableSpring(
        MemorySegment jointId, 
        boolean enableSpring
    ) {
        MethodHandle method = B2_REVOLUTE_JOINT_ENABLE_SPRING.get();
        try {
            method.invokeExact(
                jointId, 
                enableSpring
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #enableSpring}.
     */
    public static void enableSpring(
        JointId jointId, 
        boolean enableSpring
    ) {
        enableSpring(
            jointId.memorySegment(), 
            enableSpring
        );
    }
    
    /**
     * It the revolute angular spring enabled?
     */
    public static boolean isSpringEnabled(
        MemorySegment jointId
    ) {
        MethodHandle method = B2_REVOLUTE_JOINT_IS_SPRING_ENABLED.get();
        try {
            return (boolean) method.invokeExact(
                jointId
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #isSpringEnabled}.
     */
    public static boolean isSpringEnabled(
        JointId jointId
    ) {
        return (boolean) isSpringEnabled(
            jointId.memorySegment()
        );
    }
    
    /**
     * Set the revolute joint spring stiffness in Hertz
     */
    public static void setSpringHertz(
        MemorySegment jointId, 
        float hertz
    ) {
        MethodHandle method = B2_REVOLUTE_JOINT_SET_SPRING_HERTZ.get();
        try {
            method.invokeExact(
                jointId, 
                hertz
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #setSpringHertz}.
     */
    public static void setSpringHertz(
        JointId jointId, 
        float hertz
    ) {
        setSpringHertz(
            jointId.memorySegment(), 
            hertz
        );
    }
    
    /**
     * Get the revolute joint spring stiffness in Hertz
     */
    public static float getSpringHertz(
        MemorySegment jointId
    ) {
        MethodHandle method = B2_REVOLUTE_JOINT_GET_SPRING_HERTZ.get();
        try {
            return (float) method.invokeExact(
                jointId
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #getSpringHertz}.
     */
    public static float getSpringHertz(
        JointId jointId
    ) {
        return (float) getSpringHertz(
            jointId.memorySegment()
        );
    }
    
    /**
     * Set the revolute joint spring damping ratio, non-dimensional
     */
    public static void setSpringDampingRatio(
        MemorySegment jointId, 
        float dampingRatio
    ) {
        MethodHandle method = B2_REVOLUTE_JOINT_SET_SPRING_DAMPING_RATIO.get();
        try {
            method.invokeExact(
                jointId, 
                dampingRatio
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #setSpringDampingRatio}.
     */
    public static void setSpringDampingRatio(
        JointId jointId, 
        float dampingRatio
    ) {
        setSpringDampingRatio(
            jointId.memorySegment(), 
            dampingRatio
        );
    }
    
    /**
     * Get the revolute joint spring damping ratio, non-dimensional
     */
    public static float getSpringDampingRatio(
        MemorySegment jointId
    ) {
        MethodHandle method = B2_REVOLUTE_JOINT_GET_SPRING_DAMPING_RATIO.get();
        try {
            return (float) method.invokeExact(
                jointId
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #getSpringDampingRatio}.
     */
    public static float getSpringDampingRatio(
        JointId jointId
    ) {
        return (float) getSpringDampingRatio(
            jointId.memorySegment()
        );
    }
    
    /**
     * Set the revolute joint spring target angle, radians
     */
    public static void setTargetAngle(
        MemorySegment jointId, 
        float angle
    ) {
        MethodHandle method = B2_REVOLUTE_JOINT_SET_TARGET_ANGLE.get();
        try {
            method.invokeExact(
                jointId, 
                angle
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #setTargetAngle}.
     */
    public static void setTargetAngle(
        JointId jointId, 
        float angle
    ) {
        setTargetAngle(
            jointId.memorySegment(), 
            angle
        );
    }
    
    /**
     * Get the revolute joint spring target angle, radians
     */
    public static float getTargetAngle(
        MemorySegment jointId
    ) {
        MethodHandle method = B2_REVOLUTE_JOINT_GET_TARGET_ANGLE.get();
        try {
            return (float) method.invokeExact(
                jointId
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #getTargetAngle}.
     */
    public static float getTargetAngle(
        JointId jointId
    ) {
        return (float) getTargetAngle(
            jointId.memorySegment()
        );
    }
    
    /**
     * Get the revolute joint current angle in radians relative to the reference angle
     */
    public static float getAngle(
        MemorySegment jointId
    ) {
        MethodHandle method = B2_REVOLUTE_JOINT_GET_ANGLE.get();
        try {
            return (float) method.invokeExact(
                jointId
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #getAngle}.
     */
    public static float getAngle(
        JointId jointId
    ) {
        return (float) getAngle(
            jointId.memorySegment()
        );
    }
    
    /**
     * Enable/disable the revolute joint limit
     */
    public static void enableLimit(
        MemorySegment jointId, 
        boolean enableLimit
    ) {
        MethodHandle method = B2_REVOLUTE_JOINT_ENABLE_LIMIT.get();
        try {
            method.invokeExact(
                jointId, 
                enableLimit
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #enableLimit}.
     */
    public static void enableLimit(
        JointId jointId, 
        boolean enableLimit
    ) {
        enableLimit(
            jointId.memorySegment(), 
            enableLimit
        );
    }
    
    /**
     * Is the revolute joint limit enabled?
     */
    public static boolean isLimitEnabled(
        MemorySegment jointId
    ) {
        MethodHandle method = B2_REVOLUTE_JOINT_IS_LIMIT_ENABLED.get();
        try {
            return (boolean) method.invokeExact(
                jointId
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #isLimitEnabled}.
     */
    public static boolean isLimitEnabled(
        JointId jointId
    ) {
        return (boolean) isLimitEnabled(
            jointId.memorySegment()
        );
    }
    
    /**
     * Get the revolute joint lower limit in radians
     */
    public static float getLowerLimit(
        MemorySegment jointId
    ) {
        MethodHandle method = B2_REVOLUTE_JOINT_GET_LOWER_LIMIT.get();
        try {
            return (float) method.invokeExact(
                jointId
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #getLowerLimit}.
     */
    public static float getLowerLimit(
        JointId jointId
    ) {
        return (float) getLowerLimit(
            jointId.memorySegment()
        );
    }
    
    /**
     * Get the revolute joint upper limit in radians
     */
    public static float getUpperLimit(
        MemorySegment jointId
    ) {
        MethodHandle method = B2_REVOLUTE_JOINT_GET_UPPER_LIMIT.get();
        try {
            return (float) method.invokeExact(
                jointId
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #getUpperLimit}.
     */
    public static float getUpperLimit(
        JointId jointId
    ) {
        return (float) getUpperLimit(
            jointId.memorySegment()
        );
    }
    
    /**
     * Set the revolute joint limits in radians. It is expected that lower <= upper and that -0.99 * B2_PI <= lower && upper <= -0.99 * B2_PI.
     */
    public static void setLimits(
        MemorySegment jointId, 
        float lower, 
        float upper
    ) {
        MethodHandle method = B2_REVOLUTE_JOINT_SET_LIMITS.get();
        try {
            method.invokeExact(
                jointId, 
                lower, 
                upper
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #setLimits}.
     */
    public static void setLimits(
        JointId jointId, 
        float lower, 
        float upper
    ) {
        setLimits(
            jointId.memorySegment(), 
            lower, 
            upper
        );
    }
    
    /**
     * Enable/disable a revolute joint motor
     */
    public static void enableMotor(
        MemorySegment jointId, 
        boolean enableMotor
    ) {
        MethodHandle method = B2_REVOLUTE_JOINT_ENABLE_MOTOR.get();
        try {
            method.invokeExact(
                jointId, 
                enableMotor
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #enableMotor}.
     */
    public static void enableMotor(
        JointId jointId, 
        boolean enableMotor
    ) {
        enableMotor(
            jointId.memorySegment(), 
            enableMotor
        );
    }
    
    /**
     * Is the revolute joint motor enabled?
     */
    public static boolean isMotorEnabled(
        MemorySegment jointId
    ) {
        MethodHandle method = B2_REVOLUTE_JOINT_IS_MOTOR_ENABLED.get();
        try {
            return (boolean) method.invokeExact(
                jointId
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #isMotorEnabled}.
     */
    public static boolean isMotorEnabled(
        JointId jointId
    ) {
        return (boolean) isMotorEnabled(
            jointId.memorySegment()
        );
    }
    
    /**
     * Set the revolute joint motor speed in radians per second
     */
    public static void setMotorSpeed(
        MemorySegment jointId, 
        float motorSpeed
    ) {
        MethodHandle method = B2_REVOLUTE_JOINT_SET_MOTOR_SPEED.get();
        try {
            method.invokeExact(
                jointId, 
                motorSpeed
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #setMotorSpeed}.
     */
    public static void setMotorSpeed(
        JointId jointId, 
        float motorSpeed
    ) {
        setMotorSpeed(
            jointId.memorySegment(), 
            motorSpeed
        );
    }
    
    /**
     * Get the revolute joint motor speed in radians per second
     */
    public static float getMotorSpeed(
        MemorySegment jointId
    ) {
        MethodHandle method = B2_REVOLUTE_JOINT_GET_MOTOR_SPEED.get();
        try {
            return (float) method.invokeExact(
                jointId
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #getMotorSpeed}.
     */
    public static float getMotorSpeed(
        JointId jointId
    ) {
        return (float) getMotorSpeed(
            jointId.memorySegment()
        );
    }
    
    /**
     * Get the revolute joint current motor torque, usually in newton-meters
     */
    public static float getMotorTorque(
        MemorySegment jointId
    ) {
        MethodHandle method = B2_REVOLUTE_JOINT_GET_MOTOR_TORQUE.get();
        try {
            return (float) method.invokeExact(
                jointId
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #getMotorTorque}.
     */
    public static float getMotorTorque(
        JointId jointId
    ) {
        return (float) getMotorTorque(
            jointId.memorySegment()
        );
    }
    
    /**
     * Set the revolute joint maximum motor torque, usually in newton-meters
     */
    public static void setMaxMotorTorque(
        MemorySegment jointId, 
        float torque
    ) {
        MethodHandle method = B2_REVOLUTE_JOINT_SET_MAX_MOTOR_TORQUE.get();
        try {
            method.invokeExact(
                jointId, 
                torque
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #setMaxMotorTorque}.
     */
    public static void setMaxMotorTorque(
        JointId jointId, 
        float torque
    ) {
        setMaxMotorTorque(
            jointId.memorySegment(), 
            torque
        );
    }
    
    /**
     * Get the revolute joint maximum motor torque, usually in newton-meters
     */
    public static float getMaxMotorTorque(
        MemorySegment jointId
    ) {
        MethodHandle method = B2_REVOLUTE_JOINT_GET_MAX_MOTOR_TORQUE.get();
        try {
            return (float) method.invokeExact(
                jointId
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #getMaxMotorTorque}.
     */
    public static float getMaxMotorTorque(
        JointId jointId
    ) {
        return (float) getMaxMotorTorque(
            jointId.memorySegment()
        );
    }
    
}