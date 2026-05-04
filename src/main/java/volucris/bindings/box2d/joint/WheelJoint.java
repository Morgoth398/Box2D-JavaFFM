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
public final class WheelJoint {

    private static final LazyConstant<MethodHandle> B2_CREATE_WHEEL_JOINT;
    private static final LazyConstant<MethodHandle> B2_WHEEL_JOINT_ENABLE_SPRING;
    private static final LazyConstant<MethodHandle> B2_WHEEL_JOINT_IS_SPRING_ENABLED;
    private static final LazyConstant<MethodHandle> B2_WHEEL_JOINT_SET_SPRING_HERTZ;
    private static final LazyConstant<MethodHandle> B2_WHEEL_JOINT_GET_SPRING_HERTZ;
    private static final LazyConstant<MethodHandle> B2_WHEEL_JOINT_SET_SPRING_DAMPING_RATIO;
    private static final LazyConstant<MethodHandle> B2_WHEEL_JOINT_GET_SPRING_DAMPING_RATIO;
    private static final LazyConstant<MethodHandle> B2_WHEEL_JOINT_ENABLE_LIMIT;
    private static final LazyConstant<MethodHandle> B2_WHEEL_JOINT_IS_LIMIT_ENABLED;
    private static final LazyConstant<MethodHandle> B2_WHEEL_JOINT_GET_LOWER_LIMIT;
    private static final LazyConstant<MethodHandle> B2_WHEEL_JOINT_GET_UPPER_LIMIT;
    private static final LazyConstant<MethodHandle> B2_WHEEL_JOINT_SET_LIMITS;
    private static final LazyConstant<MethodHandle> B2_WHEEL_JOINT_ENABLE_MOTOR;
    private static final LazyConstant<MethodHandle> B2_WHEEL_JOINT_IS_MOTOR_ENABLED;
    private static final LazyConstant<MethodHandle> B2_WHEEL_JOINT_SET_MOTOR_SPEED;
    private static final LazyConstant<MethodHandle> B2_WHEEL_JOINT_GET_MOTOR_SPEED;
    private static final LazyConstant<MethodHandle> B2_WHEEL_JOINT_SET_MAX_MOTOR_TORQUE;
    private static final LazyConstant<MethodHandle> B2_WHEEL_JOINT_GET_MAX_MOTOR_TORQUE;
    private static final LazyConstant<MethodHandle> B2_WHEEL_JOINT_GET_MOTOR_TORQUE;

    static {
        //@formatter:off
        B2_CREATE_WHEEL_JOINT = downcallHandle("b2CreateWheelJoint", JointId.LAYOUT, WorldId.LAYOUT, UNBOUNDED_ADDRESS);
        B2_WHEEL_JOINT_ENABLE_SPRING = downcallHandleVoid("b2WheelJoint_EnableSpring", JointId.LAYOUT, JAVA_BOOLEAN);
        B2_WHEEL_JOINT_IS_SPRING_ENABLED = downcallHandle("b2WheelJoint_IsSpringEnabled", JAVA_BOOLEAN, JointId.LAYOUT);
        B2_WHEEL_JOINT_SET_SPRING_HERTZ = downcallHandleVoid("b2WheelJoint_SetSpringHertz", JointId.LAYOUT, JAVA_FLOAT);
        B2_WHEEL_JOINT_GET_SPRING_HERTZ = downcallHandle("b2WheelJoint_GetSpringHertz", JAVA_FLOAT, JointId.LAYOUT);
        B2_WHEEL_JOINT_SET_SPRING_DAMPING_RATIO = downcallHandleVoid("b2WheelJoint_SetSpringDampingRatio", JointId.LAYOUT, JAVA_FLOAT);
        B2_WHEEL_JOINT_GET_SPRING_DAMPING_RATIO = downcallHandle("b2WheelJoint_GetSpringDampingRatio", JAVA_FLOAT, JointId.LAYOUT);
        B2_WHEEL_JOINT_ENABLE_LIMIT = downcallHandleVoid("b2WheelJoint_EnableLimit", JointId.LAYOUT, JAVA_BOOLEAN);
        B2_WHEEL_JOINT_IS_LIMIT_ENABLED = downcallHandle("b2WheelJoint_IsLimitEnabled", JAVA_BOOLEAN, JointId.LAYOUT);
        B2_WHEEL_JOINT_GET_LOWER_LIMIT = downcallHandle("b2WheelJoint_GetLowerLimit", JAVA_FLOAT, JointId.LAYOUT);
        B2_WHEEL_JOINT_GET_UPPER_LIMIT = downcallHandle("b2WheelJoint_GetUpperLimit", JAVA_FLOAT, JointId.LAYOUT);
        B2_WHEEL_JOINT_SET_LIMITS = downcallHandleVoid("b2WheelJoint_SetLimits", JointId.LAYOUT, JAVA_FLOAT, JAVA_FLOAT);
        B2_WHEEL_JOINT_ENABLE_MOTOR = downcallHandleVoid("b2WheelJoint_EnableMotor", JointId.LAYOUT, JAVA_BOOLEAN);
        B2_WHEEL_JOINT_IS_MOTOR_ENABLED = downcallHandle("b2WheelJoint_IsMotorEnabled", JAVA_BOOLEAN, JointId.LAYOUT);
        B2_WHEEL_JOINT_SET_MOTOR_SPEED = downcallHandleVoid("b2WheelJoint_SetMotorSpeed", JointId.LAYOUT, JAVA_FLOAT);
        B2_WHEEL_JOINT_GET_MOTOR_SPEED = downcallHandle("b2WheelJoint_GetMotorSpeed", JAVA_FLOAT, JointId.LAYOUT);
        B2_WHEEL_JOINT_SET_MAX_MOTOR_TORQUE = downcallHandleVoid("b2WheelJoint_SetMaxMotorTorque", JointId.LAYOUT, JAVA_FLOAT);
        B2_WHEEL_JOINT_GET_MAX_MOTOR_TORQUE = downcallHandle("b2WheelJoint_GetMaxMotorTorque", JAVA_FLOAT, JointId.LAYOUT);
        B2_WHEEL_JOINT_GET_MOTOR_TORQUE = downcallHandle("b2WheelJoint_GetMotorTorque", JAVA_FLOAT, JointId.LAYOUT);
        //@formatter:on
    }

    private WheelJoint() {
    }

    /**
     * Create a wheel joint
     */
    public static MemorySegment createWheelJoint(
        SegmentAllocator allocator,
        MemorySegment worldId, 
        MemorySegment def
    ) {
        MethodHandle method = B2_CREATE_WHEEL_JOINT.get();
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
     * Typed method of {@link #createWheelJoint}.
     */
    public static @Nullable JointId createWheelJoint(
        SegmentAllocator allocator,
        WorldId worldId, 
        WheelJointDef def
    ) {
        MemorySegment segment = createWheelJoint(
            allocator,
            worldId.memorySegment(), 
            def.memorySegment()
        );
    
        if (segment.equals(MemorySegment.NULL))
            return null;
    
        return new JointId(segment);
    }
    
    /**
     * Enable/disable the wheel joint spring
     */
    public static void wheelJoint_EnableSpring(
        MemorySegment jointId, 
        boolean enableSpring
    ) {
        MethodHandle method = B2_WHEEL_JOINT_ENABLE_SPRING.get();
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
     * Typed method of {@link #wheelJoint_EnableSpring}.
     */
    public static void wheelJoint_EnableSpring(
        JointId jointId, 
        boolean enableSpring
    ) {
        wheelJoint_EnableSpring(
            jointId.memorySegment(), 
            enableSpring
        );
    }
    
    /**
     * Is the wheel joint spring enabled?
     */
    public static boolean wheelJoint_IsSpringEnabled(
        MemorySegment jointId
    ) {
        MethodHandle method = B2_WHEEL_JOINT_IS_SPRING_ENABLED.get();
        try {
            return (boolean) method.invokeExact(
                jointId
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #wheelJoint_IsSpringEnabled}.
     */
    public static boolean wheelJoint_IsSpringEnabled(
        JointId jointId
    ) {
        return (boolean) wheelJoint_IsSpringEnabled(
            jointId.memorySegment()
        );
    }
    
    /**
     * Set the wheel joint stiffness in Hertz
     */
    public static void wheelJoint_SetSpringHertz(
        MemorySegment jointId, 
        float hertz
    ) {
        MethodHandle method = B2_WHEEL_JOINT_SET_SPRING_HERTZ.get();
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
     * Typed method of {@link #wheelJoint_SetSpringHertz}.
     */
    public static void wheelJoint_SetSpringHertz(
        JointId jointId, 
        float hertz
    ) {
        wheelJoint_SetSpringHertz(
            jointId.memorySegment(), 
            hertz
        );
    }
    
    /**
     * Get the wheel joint stiffness in Hertz
     */
    public static float wheelJoint_GetSpringHertz(
        MemorySegment jointId
    ) {
        MethodHandle method = B2_WHEEL_JOINT_GET_SPRING_HERTZ.get();
        try {
            return (float) method.invokeExact(
                jointId
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #wheelJoint_GetSpringHertz}.
     */
    public static float wheelJoint_GetSpringHertz(
        JointId jointId
    ) {
        return (float) wheelJoint_GetSpringHertz(
            jointId.memorySegment()
        );
    }
    
    /**
     * Set the wheel joint damping ratio, non-dimensional
     */
    public static void wheelJoint_SetSpringDampingRatio(
        MemorySegment jointId, 
        float dampingRatio
    ) {
        MethodHandle method = B2_WHEEL_JOINT_SET_SPRING_DAMPING_RATIO.get();
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
     * Typed method of {@link #wheelJoint_SetSpringDampingRatio}.
     */
    public static void wheelJoint_SetSpringDampingRatio(
        JointId jointId, 
        float dampingRatio
    ) {
        wheelJoint_SetSpringDampingRatio(
            jointId.memorySegment(), 
            dampingRatio
        );
    }
    
    /**
     * Get the wheel joint damping ratio, non-dimensional
     */
    public static float wheelJoint_GetSpringDampingRatio(
        MemorySegment jointId
    ) {
        MethodHandle method = B2_WHEEL_JOINT_GET_SPRING_DAMPING_RATIO.get();
        try {
            return (float) method.invokeExact(
                jointId
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #wheelJoint_GetSpringDampingRatio}.
     */
    public static float wheelJoint_GetSpringDampingRatio(
        JointId jointId
    ) {
        return (float) wheelJoint_GetSpringDampingRatio(
            jointId.memorySegment()
        );
    }
    
    /**
     * Enable/disable the wheel joint limit
     */
    public static void wheelJoint_EnableLimit(
        MemorySegment jointId, 
        boolean enableLimit
    ) {
        MethodHandle method = B2_WHEEL_JOINT_ENABLE_LIMIT.get();
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
     * Typed method of {@link #wheelJoint_EnableLimit}.
     */
    public static void wheelJoint_EnableLimit(
        JointId jointId, 
        boolean enableLimit
    ) {
        wheelJoint_EnableLimit(
            jointId.memorySegment(), 
            enableLimit
        );
    }
    
    /**
     * Is the wheel joint limit enabled?
     */
    public static boolean wheelJoint_IsLimitEnabled(
        MemorySegment jointId
    ) {
        MethodHandle method = B2_WHEEL_JOINT_IS_LIMIT_ENABLED.get();
        try {
            return (boolean) method.invokeExact(
                jointId
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #wheelJoint_IsLimitEnabled}.
     */
    public static boolean wheelJoint_IsLimitEnabled(
        JointId jointId
    ) {
        return (boolean) wheelJoint_IsLimitEnabled(
            jointId.memorySegment()
        );
    }
    
    /**
     * Get the wheel joint lower limit
     */
    public static float wheelJoint_GetLowerLimit(
        MemorySegment jointId
    ) {
        MethodHandle method = B2_WHEEL_JOINT_GET_LOWER_LIMIT.get();
        try {
            return (float) method.invokeExact(
                jointId
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #wheelJoint_GetLowerLimit}.
     */
    public static float wheelJoint_GetLowerLimit(
        JointId jointId
    ) {
        return (float) wheelJoint_GetLowerLimit(
            jointId.memorySegment()
        );
    }
    
    /**
     * Get the wheel joint upper limit
     */
    public static float wheelJoint_GetUpperLimit(
        MemorySegment jointId
    ) {
        MethodHandle method = B2_WHEEL_JOINT_GET_UPPER_LIMIT.get();
        try {
            return (float) method.invokeExact(
                jointId
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #wheelJoint_GetUpperLimit}.
     */
    public static float wheelJoint_GetUpperLimit(
        JointId jointId
    ) {
        return (float) wheelJoint_GetUpperLimit(
            jointId.memorySegment()
        );
    }
    
    /**
     * Set the wheel joint limits
     */
    public static void wheelJoint_SetLimits(
        MemorySegment jointId, 
        float lower, 
        float upper
    ) {
        MethodHandle method = B2_WHEEL_JOINT_SET_LIMITS.get();
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
     * Typed method of {@link #wheelJoint_SetLimits}.
     */
    public static void wheelJoint_SetLimits(
        JointId jointId, 
        float lower, 
        float upper
    ) {
        wheelJoint_SetLimits(
            jointId.memorySegment(), 
            lower, 
            upper
        );
    }
    
    /**
     * Enable/disable the wheel joint motor
     */
    public static void wheelJoint_EnableMotor(
        MemorySegment jointId, 
        boolean enableMotor
    ) {
        MethodHandle method = B2_WHEEL_JOINT_ENABLE_MOTOR.get();
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
     * Typed method of {@link #wheelJoint_EnableMotor}.
     */
    public static void wheelJoint_EnableMotor(
        JointId jointId, 
        boolean enableMotor
    ) {
        wheelJoint_EnableMotor(
            jointId.memorySegment(), 
            enableMotor
        );
    }
    
    /**
     * Is the wheel joint motor enabled?
     */
    public static boolean wheelJoint_IsMotorEnabled(
        MemorySegment jointId
    ) {
        MethodHandle method = B2_WHEEL_JOINT_IS_MOTOR_ENABLED.get();
        try {
            return (boolean) method.invokeExact(
                jointId
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #wheelJoint_IsMotorEnabled}.
     */
    public static boolean wheelJoint_IsMotorEnabled(
        JointId jointId
    ) {
        return (boolean) wheelJoint_IsMotorEnabled(
            jointId.memorySegment()
        );
    }
    
    /**
     * Set the wheel joint motor speed in radians per second
     */
    public static void wheelJoint_SetMotorSpeed(
        MemorySegment jointId, 
        float motorSpeed
    ) {
        MethodHandle method = B2_WHEEL_JOINT_SET_MOTOR_SPEED.get();
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
     * Typed method of {@link #wheelJoint_SetMotorSpeed}.
     */
    public static void wheelJoint_SetMotorSpeed(
        JointId jointId, 
        float motorSpeed
    ) {
        wheelJoint_SetMotorSpeed(
            jointId.memorySegment(), 
            motorSpeed
        );
    }
    
    /**
     * Get the wheel joint motor speed in radians per second
     */
    public static float wheelJoint_GetMotorSpeed(
        MemorySegment jointId
    ) {
        MethodHandle method = B2_WHEEL_JOINT_GET_MOTOR_SPEED.get();
        try {
            return (float) method.invokeExact(
                jointId
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #wheelJoint_GetMotorSpeed}.
     */
    public static float wheelJoint_GetMotorSpeed(
        JointId jointId
    ) {
        return (float) wheelJoint_GetMotorSpeed(
            jointId.memorySegment()
        );
    }
    
    /**
     * Set the wheel joint maximum motor torque, usually in newton-meters
     */
    public static void wheelJoint_SetMaxMotorTorque(
        MemorySegment jointId, 
        float torque
    ) {
        MethodHandle method = B2_WHEEL_JOINT_SET_MAX_MOTOR_TORQUE.get();
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
     * Typed method of {@link #wheelJoint_SetMaxMotorTorque}.
     */
    public static void wheelJoint_SetMaxMotorTorque(
        JointId jointId, 
        float torque
    ) {
        wheelJoint_SetMaxMotorTorque(
            jointId.memorySegment(), 
            torque
        );
    }
    
    /**
     * Get the wheel joint maximum motor torque, usually in newton-meters
     */
    public static float wheelJoint_GetMaxMotorTorque(
        MemorySegment jointId
    ) {
        MethodHandle method = B2_WHEEL_JOINT_GET_MAX_MOTOR_TORQUE.get();
        try {
            return (float) method.invokeExact(
                jointId
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #wheelJoint_GetMaxMotorTorque}.
     */
    public static float wheelJoint_GetMaxMotorTorque(
        JointId jointId
    ) {
        return (float) wheelJoint_GetMaxMotorTorque(
            jointId.memorySegment()
        );
    }
    
    /**
     * Get the wheel joint current motor torque, usually in newton-meters
     */
    public static float wheelJoint_GetMotorTorque(
        MemorySegment jointId
    ) {
        MethodHandle method = B2_WHEEL_JOINT_GET_MOTOR_TORQUE.get();
        try {
            return (float) method.invokeExact(
                jointId
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #wheelJoint_GetMotorTorque}.
     */
    public static float wheelJoint_GetMotorTorque(
        JointId jointId
    ) {
        return (float) wheelJoint_GetMotorTorque(
            jointId.memorySegment()
        );
    }
    
}