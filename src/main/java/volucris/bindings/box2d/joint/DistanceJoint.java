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
public final class DistanceJoint {

    private static final LazyConstant<MethodHandle> B2_CREATE_DISTANCE_JOINT;
    private static final LazyConstant<MethodHandle> B2_DISTANCE_JOINT_SET_LENGTH;
    private static final LazyConstant<MethodHandle> B2_DISTANCE_JOINT_GET_LENGTH;
    private static final LazyConstant<MethodHandle> B2_DISTANCE_JOINT_ENABLE_SPRING;
    private static final LazyConstant<MethodHandle> B2_DISTANCE_JOINT_IS_SPRING_ENABLED;
    private static final LazyConstant<MethodHandle> B2_DISTANCE_JOINT_SET_SPRING_HERTZ;
    private static final LazyConstant<MethodHandle> B2_DISTANCE_JOINT_SET_SPRING_DAMPING_RATIO;
    private static final LazyConstant<MethodHandle> B2_DISTANCE_JOINT_GET_SPRING_HERTZ;
    private static final LazyConstant<MethodHandle> B2_DISTANCE_JOINT_GET_SPRING_DAMPING_RATIO;
    private static final LazyConstant<MethodHandle> B2_DISTANCE_JOINT_ENABLE_LIMIT;
    private static final LazyConstant<MethodHandle> B2_DISTANCE_JOINT_IS_LIMIT_ENABLED;
    private static final LazyConstant<MethodHandle> B2_DISTANCE_JOINT_SET_LENGTH_RANGE;
    private static final LazyConstant<MethodHandle> B2_DISTANCE_JOINT_GET_MIN_LENGTH;
    private static final LazyConstant<MethodHandle> B2_DISTANCE_JOINT_GET_MAX_LENGTH;
    private static final LazyConstant<MethodHandle> B2_DISTANCE_JOINT_GET_CURRENT_LENGTH;
    private static final LazyConstant<MethodHandle> B2_DISTANCE_JOINT_ENABLE_MOTOR;
    private static final LazyConstant<MethodHandle> B2_DISTANCE_JOINT_IS_MOTOR_ENABLED;
    private static final LazyConstant<MethodHandle> B2_DISTANCE_JOINT_SET_MOTOR_SPEED;
    private static final LazyConstant<MethodHandle> B2_DISTANCE_JOINT_GET_MOTOR_SPEED;
    private static final LazyConstant<MethodHandle> B2_DISTANCE_JOINT_SET_MAX_MOTOR_FORCE;
    private static final LazyConstant<MethodHandle> B2_DISTANCE_JOINT_GET_MAX_MOTOR_FORCE;
    private static final LazyConstant<MethodHandle> B2_DISTANCE_JOINT_GET_MOTOR_FORCE;

    static {
        //@formatter:off
        B2_CREATE_DISTANCE_JOINT = downcallHandle("b2CreateDistanceJoint", JointId.LAYOUT, WorldId.LAYOUT, UNBOUNDED_ADDRESS);
        B2_DISTANCE_JOINT_SET_LENGTH = downcallHandleVoid("b2DistanceJoint_SetLength", JointId.LAYOUT, JAVA_FLOAT);
        B2_DISTANCE_JOINT_GET_LENGTH = downcallHandle("b2DistanceJoint_GetLength", JAVA_FLOAT, JointId.LAYOUT);
        B2_DISTANCE_JOINT_ENABLE_SPRING = downcallHandleVoid("b2DistanceJoint_EnableSpring", JointId.LAYOUT, JAVA_BOOLEAN);
        B2_DISTANCE_JOINT_IS_SPRING_ENABLED = downcallHandle("b2DistanceJoint_IsSpringEnabled", JAVA_BOOLEAN, JointId.LAYOUT);
        B2_DISTANCE_JOINT_SET_SPRING_HERTZ = downcallHandleVoid("b2DistanceJoint_SetSpringHertz", JointId.LAYOUT, JAVA_FLOAT);
        B2_DISTANCE_JOINT_SET_SPRING_DAMPING_RATIO = downcallHandleVoid("b2DistanceJoint_SetSpringDampingRatio", JointId.LAYOUT, JAVA_FLOAT);
        B2_DISTANCE_JOINT_GET_SPRING_HERTZ = downcallHandle("b2DistanceJoint_GetSpringHertz", JAVA_FLOAT, JointId.LAYOUT);
        B2_DISTANCE_JOINT_GET_SPRING_DAMPING_RATIO = downcallHandle("b2DistanceJoint_GetSpringDampingRatio", JAVA_FLOAT, JointId.LAYOUT);
        B2_DISTANCE_JOINT_ENABLE_LIMIT = downcallHandleVoid("b2DistanceJoint_EnableLimit", JointId.LAYOUT, JAVA_BOOLEAN);
        B2_DISTANCE_JOINT_IS_LIMIT_ENABLED = downcallHandle("b2DistanceJoint_IsLimitEnabled", JAVA_BOOLEAN, JointId.LAYOUT);
        B2_DISTANCE_JOINT_SET_LENGTH_RANGE = downcallHandleVoid("b2DistanceJoint_SetLengthRange", JointId.LAYOUT, JAVA_FLOAT, JAVA_FLOAT);
        B2_DISTANCE_JOINT_GET_MIN_LENGTH = downcallHandle("b2DistanceJoint_GetMinLength", JAVA_FLOAT, JointId.LAYOUT);
        B2_DISTANCE_JOINT_GET_MAX_LENGTH = downcallHandle("b2DistanceJoint_GetMaxLength", JAVA_FLOAT, JointId.LAYOUT);
        B2_DISTANCE_JOINT_GET_CURRENT_LENGTH = downcallHandle("b2DistanceJoint_GetCurrentLength", JAVA_FLOAT, JointId.LAYOUT);
        B2_DISTANCE_JOINT_ENABLE_MOTOR = downcallHandleVoid("b2DistanceJoint_EnableMotor", JointId.LAYOUT, JAVA_BOOLEAN);
        B2_DISTANCE_JOINT_IS_MOTOR_ENABLED = downcallHandle("b2DistanceJoint_IsMotorEnabled", JAVA_BOOLEAN, JointId.LAYOUT);
        B2_DISTANCE_JOINT_SET_MOTOR_SPEED = downcallHandleVoid("b2DistanceJoint_SetMotorSpeed", JointId.LAYOUT, JAVA_FLOAT);
        B2_DISTANCE_JOINT_GET_MOTOR_SPEED = downcallHandle("b2DistanceJoint_GetMotorSpeed", JAVA_FLOAT, JointId.LAYOUT);
        B2_DISTANCE_JOINT_SET_MAX_MOTOR_FORCE = downcallHandleVoid("b2DistanceJoint_SetMaxMotorForce", JointId.LAYOUT, JAVA_FLOAT);
        B2_DISTANCE_JOINT_GET_MAX_MOTOR_FORCE = downcallHandle("b2DistanceJoint_GetMaxMotorForce", JAVA_FLOAT, JointId.LAYOUT);
        B2_DISTANCE_JOINT_GET_MOTOR_FORCE = downcallHandle("b2DistanceJoint_GetMotorForce", JAVA_FLOAT, JointId.LAYOUT);
        //@formatter:on
    }

    private DistanceJoint() {
    }

    /**
     * Create a distance joint
     */
    public static MemorySegment createDistanceJoint(
        SegmentAllocator allocator,
        MemorySegment worldId, 
        MemorySegment def
    ) {
        MethodHandle method = B2_CREATE_DISTANCE_JOINT.get();
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
     * Typed method of {@link #createDistanceJoint}.
     */
    public static @Nullable JointId createDistanceJoint(
        SegmentAllocator allocator,
        WorldId worldId, 
        DistanceJointDef def
    ) {
        MemorySegment segment = createDistanceJoint(
            allocator,
            worldId.memorySegment(), 
            def.memorySegment()
        );
    
        if (segment.equals(MemorySegment.NULL))
            return null;
    
        return new JointId(segment);
    }
    
    /**
     * Set the rest length of a distance joint
     */
    public static void setLength(
        MemorySegment jointId, 
        float length
    ) {
        MethodHandle method = B2_DISTANCE_JOINT_SET_LENGTH.get();
        try {
            method.invokeExact(
                jointId, 
                length
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #setLength}.
     */
    public static void setLength(
        JointId jointId, 
        float length
    ) {
        setLength(
            jointId.memorySegment(), 
            length
        );
    }
    
    /**
     * Get the rest length of a distance joint
     */
    public static float getLength(
        MemorySegment jointId
    ) {
        MethodHandle method = B2_DISTANCE_JOINT_GET_LENGTH.get();
        try {
            return (float) method.invokeExact(
                jointId
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #getLength}.
     */
    public static float getLength(
        JointId jointId
    ) {
        return (float) getLength(
            jointId.memorySegment()
        );
    }
    
    /**
     * Enable/disable the distance joint spring. When disabled the distance joint is rigid.
     */
    public static void enableSpring(
        MemorySegment jointId, 
        boolean enableSpring
    ) {
        MethodHandle method = B2_DISTANCE_JOINT_ENABLE_SPRING.get();
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
     * Is the distance joint spring enabled?
     */
    public static boolean isSpringEnabled(
        MemorySegment jointId
    ) {
        MethodHandle method = B2_DISTANCE_JOINT_IS_SPRING_ENABLED.get();
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
     * Set the spring stiffness in Hertz
     */
    public static void setSpringHertz(
        MemorySegment jointId, 
        float hertz
    ) {
        MethodHandle method = B2_DISTANCE_JOINT_SET_SPRING_HERTZ.get();
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
     * Set the spring damping ratio, non-dimensional
     */
    public static void setSpringDampingRatio(
        MemorySegment jointId, 
        float dampingRatio
    ) {
        MethodHandle method = B2_DISTANCE_JOINT_SET_SPRING_DAMPING_RATIO.get();
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
     * Get the spring Hertz
     */
    public static float getSpringHertz(
        MemorySegment jointId
    ) {
        MethodHandle method = B2_DISTANCE_JOINT_GET_SPRING_HERTZ.get();
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
     * Get the spring damping ratio
     */
    public static float getSpringDampingRatio(
        MemorySegment jointId
    ) {
        MethodHandle method = B2_DISTANCE_JOINT_GET_SPRING_DAMPING_RATIO.get();
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
     * Enable joint limit. The limit only works if the joint spring is enabled. Otherwise the joint is rigid and the limit has no effect.
     */
    public static void enableLimit(
        MemorySegment jointId, 
        boolean enableLimit
    ) {
        MethodHandle method = B2_DISTANCE_JOINT_ENABLE_LIMIT.get();
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
     * Is the distance joint limit enabled?
     */
    public static boolean isLimitEnabled(
        MemorySegment jointId
    ) {
        MethodHandle method = B2_DISTANCE_JOINT_IS_LIMIT_ENABLED.get();
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
     * Set the minimum and maximum length parameters of a distance joint
     */
    public static void setLengthRange(
        MemorySegment jointId, 
        float minLength, 
        float maxLength
    ) {
        MethodHandle method = B2_DISTANCE_JOINT_SET_LENGTH_RANGE.get();
        try {
            method.invokeExact(
                jointId, 
                minLength, 
                maxLength
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #setLengthRange}.
     */
    public static void setLengthRange(
        JointId jointId, 
        float minLength, 
        float maxLength
    ) {
        setLengthRange(
            jointId.memorySegment(), 
            minLength, 
            maxLength
        );
    }
    
    /**
     * Get the distance joint minimum length
     */
    public static float getMinLength(
        MemorySegment jointId
    ) {
        MethodHandle method = B2_DISTANCE_JOINT_GET_MIN_LENGTH.get();
        try {
            return (float) method.invokeExact(
                jointId
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #getMinLength}.
     */
    public static float getMinLength(
        JointId jointId
    ) {
        return (float) getMinLength(
            jointId.memorySegment()
        );
    }
    
    /**
     * Get the distance joint maximum length
     */
    public static float getMaxLength(
        MemorySegment jointId
    ) {
        MethodHandle method = B2_DISTANCE_JOINT_GET_MAX_LENGTH.get();
        try {
            return (float) method.invokeExact(
                jointId
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #getMaxLength}.
     */
    public static float getMaxLength(
        JointId jointId
    ) {
        return (float) getMaxLength(
            jointId.memorySegment()
        );
    }
    
    /**
     * Get the current length of a distance joint
     */
    public static float getCurrentLength(
        MemorySegment jointId
    ) {
        MethodHandle method = B2_DISTANCE_JOINT_GET_CURRENT_LENGTH.get();
        try {
            return (float) method.invokeExact(
                jointId
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #getCurrentLength}.
     */
    public static float getCurrentLength(
        JointId jointId
    ) {
        return (float) getCurrentLength(
            jointId.memorySegment()
        );
    }
    
    /**
     * Enable/disable the distance joint motor
     */
    public static void enableMotor(
        MemorySegment jointId, 
        boolean enableMotor
    ) {
        MethodHandle method = B2_DISTANCE_JOINT_ENABLE_MOTOR.get();
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
     * Is the distance joint motor enabled?
     */
    public static boolean isMotorEnabled(
        MemorySegment jointId
    ) {
        MethodHandle method = B2_DISTANCE_JOINT_IS_MOTOR_ENABLED.get();
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
     * Set the distance joint motor speed, usually in meters per second
     */
    public static void setMotorSpeed(
        MemorySegment jointId, 
        float motorSpeed
    ) {
        MethodHandle method = B2_DISTANCE_JOINT_SET_MOTOR_SPEED.get();
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
     * Get the distance joint motor speed, usually in meters per second
     */
    public static float getMotorSpeed(
        MemorySegment jointId
    ) {
        MethodHandle method = B2_DISTANCE_JOINT_GET_MOTOR_SPEED.get();
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
     * Set the distance joint maximum motor force, usually in newtons
     */
    public static void setMaxMotorForce(
        MemorySegment jointId, 
        float force
    ) {
        MethodHandle method = B2_DISTANCE_JOINT_SET_MAX_MOTOR_FORCE.get();
        try {
            method.invokeExact(
                jointId, 
                force
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #setMaxMotorForce}.
     */
    public static void setMaxMotorForce(
        JointId jointId, 
        float force
    ) {
        setMaxMotorForce(
            jointId.memorySegment(), 
            force
        );
    }
    
    /**
     * Get the distance joint maximum motor force, usually in newtons
     */
    public static float getMaxMotorForce(
        MemorySegment jointId
    ) {
        MethodHandle method = B2_DISTANCE_JOINT_GET_MAX_MOTOR_FORCE.get();
        try {
            return (float) method.invokeExact(
                jointId
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #getMaxMotorForce}.
     */
    public static float getMaxMotorForce(
        JointId jointId
    ) {
        return (float) getMaxMotorForce(
            jointId.memorySegment()
        );
    }
    
    /**
     * Get the distance joint current motor force, usually in newtons
     */
    public static float getMotorForce(
        MemorySegment jointId
    ) {
        MethodHandle method = B2_DISTANCE_JOINT_GET_MOTOR_FORCE.get();
        try {
            return (float) method.invokeExact(
                jointId
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #getMotorForce}.
     */
    public static float getMotorForce(
        JointId jointId
    ) {
        return (float) getMotorForce(
            jointId.memorySegment()
        );
    }
    
}