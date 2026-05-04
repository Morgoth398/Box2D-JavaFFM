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
public final class PrismaticJoint {

    private static final LazyConstant<MethodHandle> B2_CREATE_PRISMATIC_JOINT;
    private static final LazyConstant<MethodHandle> B2_PRISMATIC_JOINT_ENABLE_SPRING;
    private static final LazyConstant<MethodHandle> B2_PRISMATIC_JOINT_IS_SPRING_ENABLED;
    private static final LazyConstant<MethodHandle> B2_PRISMATIC_JOINT_SET_SPRING_HERTZ;
    private static final LazyConstant<MethodHandle> B2_PRISMATIC_JOINT_GET_SPRING_HERTZ;
    private static final LazyConstant<MethodHandle> B2_PRISMATIC_JOINT_SET_SPRING_DAMPING_RATIO;
    private static final LazyConstant<MethodHandle> B2_PRISMATIC_JOINT_GET_SPRING_DAMPING_RATIO;
    private static final LazyConstant<MethodHandle> B2_PRISMATIC_JOINT_SET_TARGET_TRANSLATION;
    private static final LazyConstant<MethodHandle> B2_PRISMATIC_JOINT_GET_TARGET_TRANSLATION;
    private static final LazyConstant<MethodHandle> B2_PRISMATIC_JOINT_ENABLE_LIMIT;
    private static final LazyConstant<MethodHandle> B2_PRISMATIC_JOINT_IS_LIMIT_ENABLED;
    private static final LazyConstant<MethodHandle> B2_PRISMATIC_JOINT_GET_LOWER_LIMIT;
    private static final LazyConstant<MethodHandle> B2_PRISMATIC_JOINT_GET_UPPER_LIMIT;
    private static final LazyConstant<MethodHandle> B2_PRISMATIC_JOINT_SET_LIMITS;
    private static final LazyConstant<MethodHandle> B2_PRISMATIC_JOINT_ENABLE_MOTOR;
    private static final LazyConstant<MethodHandle> B2_PRISMATIC_JOINT_IS_MOTOR_ENABLED;
    private static final LazyConstant<MethodHandle> B2_PRISMATIC_JOINT_SET_MOTOR_SPEED;
    private static final LazyConstant<MethodHandle> B2_PRISMATIC_JOINT_GET_MOTOR_SPEED;
    private static final LazyConstant<MethodHandle> B2_PRISMATIC_JOINT_SET_MAX_MOTOR_FORCE;
    private static final LazyConstant<MethodHandle> B2_PRISMATIC_JOINT_GET_MAX_MOTOR_FORCE;
    private static final LazyConstant<MethodHandle> B2_PRISMATIC_JOINT_GET_MOTOR_FORCE;
    private static final LazyConstant<MethodHandle> B2_PRISMATIC_JOINT_GET_TRANSLATION;
    private static final LazyConstant<MethodHandle> B2_PRISMATIC_JOINT_GET_SPEED;

    static {
        //@formatter:off
        B2_CREATE_PRISMATIC_JOINT = downcallHandle("b2CreatePrismaticJoint", JointId.LAYOUT, WorldId.LAYOUT, UNBOUNDED_ADDRESS);
        B2_PRISMATIC_JOINT_ENABLE_SPRING = downcallHandleVoid("b2PrismaticJoint_EnableSpring", JointId.LAYOUT, JAVA_BOOLEAN);
        B2_PRISMATIC_JOINT_IS_SPRING_ENABLED = downcallHandle("b2PrismaticJoint_IsSpringEnabled", JAVA_BOOLEAN, JointId.LAYOUT);
        B2_PRISMATIC_JOINT_SET_SPRING_HERTZ = downcallHandleVoid("b2PrismaticJoint_SetSpringHertz", JointId.LAYOUT, JAVA_FLOAT);
        B2_PRISMATIC_JOINT_GET_SPRING_HERTZ = downcallHandle("b2PrismaticJoint_GetSpringHertz", JAVA_FLOAT, JointId.LAYOUT);
        B2_PRISMATIC_JOINT_SET_SPRING_DAMPING_RATIO = downcallHandleVoid("b2PrismaticJoint_SetSpringDampingRatio", JointId.LAYOUT, JAVA_FLOAT);
        B2_PRISMATIC_JOINT_GET_SPRING_DAMPING_RATIO = downcallHandle("b2PrismaticJoint_GetSpringDampingRatio", JAVA_FLOAT, JointId.LAYOUT);
        B2_PRISMATIC_JOINT_SET_TARGET_TRANSLATION = downcallHandleVoid("b2PrismaticJoint_SetTargetTranslation", JointId.LAYOUT, JAVA_FLOAT);
        B2_PRISMATIC_JOINT_GET_TARGET_TRANSLATION = downcallHandle("b2PrismaticJoint_GetTargetTranslation", JAVA_FLOAT, JointId.LAYOUT);
        B2_PRISMATIC_JOINT_ENABLE_LIMIT = downcallHandleVoid("b2PrismaticJoint_EnableLimit", JointId.LAYOUT, JAVA_BOOLEAN);
        B2_PRISMATIC_JOINT_IS_LIMIT_ENABLED = downcallHandle("b2PrismaticJoint_IsLimitEnabled", JAVA_BOOLEAN, JointId.LAYOUT);
        B2_PRISMATIC_JOINT_GET_LOWER_LIMIT = downcallHandle("b2PrismaticJoint_GetLowerLimit", JAVA_FLOAT, JointId.LAYOUT);
        B2_PRISMATIC_JOINT_GET_UPPER_LIMIT = downcallHandle("b2PrismaticJoint_GetUpperLimit", JAVA_FLOAT, JointId.LAYOUT);
        B2_PRISMATIC_JOINT_SET_LIMITS = downcallHandleVoid("b2PrismaticJoint_SetLimits", JointId.LAYOUT, JAVA_FLOAT, JAVA_FLOAT);
        B2_PRISMATIC_JOINT_ENABLE_MOTOR = downcallHandleVoid("b2PrismaticJoint_EnableMotor", JointId.LAYOUT, JAVA_BOOLEAN);
        B2_PRISMATIC_JOINT_IS_MOTOR_ENABLED = downcallHandle("b2PrismaticJoint_IsMotorEnabled", JAVA_BOOLEAN, JointId.LAYOUT);
        B2_PRISMATIC_JOINT_SET_MOTOR_SPEED = downcallHandleVoid("b2PrismaticJoint_SetMotorSpeed", JointId.LAYOUT, JAVA_FLOAT);
        B2_PRISMATIC_JOINT_GET_MOTOR_SPEED = downcallHandle("b2PrismaticJoint_GetMotorSpeed", JAVA_FLOAT, JointId.LAYOUT);
        B2_PRISMATIC_JOINT_SET_MAX_MOTOR_FORCE = downcallHandleVoid("b2PrismaticJoint_SetMaxMotorForce", JointId.LAYOUT, JAVA_FLOAT);
        B2_PRISMATIC_JOINT_GET_MAX_MOTOR_FORCE = downcallHandle("b2PrismaticJoint_GetMaxMotorForce", JAVA_FLOAT, JointId.LAYOUT);
        B2_PRISMATIC_JOINT_GET_MOTOR_FORCE = downcallHandle("b2PrismaticJoint_GetMotorForce", JAVA_FLOAT, JointId.LAYOUT);
        B2_PRISMATIC_JOINT_GET_TRANSLATION = downcallHandle("b2PrismaticJoint_GetTranslation", JAVA_FLOAT, JointId.LAYOUT);
        B2_PRISMATIC_JOINT_GET_SPEED = downcallHandle("b2PrismaticJoint_GetSpeed", JAVA_FLOAT, JointId.LAYOUT);
        //@formatter:on
    }

    private PrismaticJoint() {
    }

    /**
     * Create a prismatic (slider) joint.
     */
    public static MemorySegment createPrismaticJoint(
        SegmentAllocator allocator,
        MemorySegment worldId, 
        MemorySegment def
    ) {
        MethodHandle method = B2_CREATE_PRISMATIC_JOINT.get();
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
     * Typed method of {@link #createPrismaticJoint}.
     */
    public static @Nullable JointId createPrismaticJoint(
        SegmentAllocator allocator,
        WorldId worldId, 
        PrismaticJointDef def
    ) {
        MemorySegment segment = createPrismaticJoint(
            allocator,
            worldId.memorySegment(), 
            def.memorySegment()
        );
    
        if (segment.equals(MemorySegment.NULL))
            return null;
    
        return new JointId(segment);
    }
    
    /**
     * Enable/disable the joint spring.
     */
    public static void enableSpring(
        MemorySegment jointId, 
        boolean enableSpring
    ) {
        MethodHandle method = B2_PRISMATIC_JOINT_ENABLE_SPRING.get();
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
     * Is the prismatic joint spring enabled or not?
     */
    public static boolean isSpringEnabled(
        MemorySegment jointId
    ) {
        MethodHandle method = B2_PRISMATIC_JOINT_IS_SPRING_ENABLED.get();
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
     * Set the prismatic joint stiffness in Hertz. This should usually be less than a quarter of the simulation rate. For example, if the simulation runs at 60Hz then the joint stiffness should be 15Hz or less.
     */
    public static void setSpringHertz(
        MemorySegment jointId, 
        float hertz
    ) {
        MethodHandle method = B2_PRISMATIC_JOINT_SET_SPRING_HERTZ.get();
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
     * Get the prismatic joint stiffness in Hertz
     */
    public static float getSpringHertz(
        MemorySegment jointId
    ) {
        MethodHandle method = B2_PRISMATIC_JOINT_GET_SPRING_HERTZ.get();
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
     * Set the prismatic joint damping ratio (non-dimensional)
     */
    public static void setSpringDampingRatio(
        MemorySegment jointId, 
        float dampingRatio
    ) {
        MethodHandle method = B2_PRISMATIC_JOINT_SET_SPRING_DAMPING_RATIO.get();
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
     * Get the prismatic spring damping ratio (non-dimensional)
     */
    public static float getSpringDampingRatio(
        MemorySegment jointId
    ) {
        MethodHandle method = B2_PRISMATIC_JOINT_GET_SPRING_DAMPING_RATIO.get();
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
     * Set the prismatic joint spring target angle, usually in meters
     */
    public static void setTargetTranslation(
        MemorySegment jointId, 
        float translation
    ) {
        MethodHandle method = B2_PRISMATIC_JOINT_SET_TARGET_TRANSLATION.get();
        try {
            method.invokeExact(
                jointId, 
                translation
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #setTargetTranslation}.
     */
    public static void setTargetTranslation(
        JointId jointId, 
        float translation
    ) {
        setTargetTranslation(
            jointId.memorySegment(), 
            translation
        );
    }
    
    /**
     * Get the prismatic joint spring target translation, usually in meters
     */
    public static float getTargetTranslation(
        MemorySegment jointId
    ) {
        MethodHandle method = B2_PRISMATIC_JOINT_GET_TARGET_TRANSLATION.get();
        try {
            return (float) method.invokeExact(
                jointId
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #getTargetTranslation}.
     */
    public static float getTargetTranslation(
        JointId jointId
    ) {
        return (float) getTargetTranslation(
            jointId.memorySegment()
        );
    }
    
    /**
     * Enable/disable a prismatic joint limit
     */
    public static void enableLimit(
        MemorySegment jointId, 
        boolean enableLimit
    ) {
        MethodHandle method = B2_PRISMATIC_JOINT_ENABLE_LIMIT.get();
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
     * Is the prismatic joint limit enabled?
     */
    public static boolean isLimitEnabled(
        MemorySegment jointId
    ) {
        MethodHandle method = B2_PRISMATIC_JOINT_IS_LIMIT_ENABLED.get();
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
     * Get the prismatic joint lower limit
     */
    public static float getLowerLimit(
        MemorySegment jointId
    ) {
        MethodHandle method = B2_PRISMATIC_JOINT_GET_LOWER_LIMIT.get();
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
     * Get the prismatic joint upper limit
     */
    public static float getUpperLimit(
        MemorySegment jointId
    ) {
        MethodHandle method = B2_PRISMATIC_JOINT_GET_UPPER_LIMIT.get();
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
     * Set the prismatic joint limits
     */
    public static void setLimits(
        MemorySegment jointId, 
        float lower, 
        float upper
    ) {
        MethodHandle method = B2_PRISMATIC_JOINT_SET_LIMITS.get();
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
     * Enable/disable a prismatic joint motor
     */
    public static void enableMotor(
        MemorySegment jointId, 
        boolean enableMotor
    ) {
        MethodHandle method = B2_PRISMATIC_JOINT_ENABLE_MOTOR.get();
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
     * Is the prismatic joint motor enabled?
     */
    public static boolean isMotorEnabled(
        MemorySegment jointId
    ) {
        MethodHandle method = B2_PRISMATIC_JOINT_IS_MOTOR_ENABLED.get();
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
     * Set the prismatic joint motor speed, usually in meters per second
     */
    public static void setMotorSpeed(
        MemorySegment jointId, 
        float motorSpeed
    ) {
        MethodHandle method = B2_PRISMATIC_JOINT_SET_MOTOR_SPEED.get();
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
     * Get the prismatic joint motor speed, usually in meters per second
     */
    public static float getMotorSpeed(
        MemorySegment jointId
    ) {
        MethodHandle method = B2_PRISMATIC_JOINT_GET_MOTOR_SPEED.get();
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
     * Set the prismatic joint maximum motor force, usually in newtons
     */
    public static void setMaxMotorForce(
        MemorySegment jointId, 
        float force
    ) {
        MethodHandle method = B2_PRISMATIC_JOINT_SET_MAX_MOTOR_FORCE.get();
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
     * Get the prismatic joint maximum motor force, usually in newtons
     */
    public static float getMaxMotorForce(
        MemorySegment jointId
    ) {
        MethodHandle method = B2_PRISMATIC_JOINT_GET_MAX_MOTOR_FORCE.get();
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
     * Get the prismatic joint current motor force, usually in newtons
     */
    public static float getMotorForce(
        MemorySegment jointId
    ) {
        MethodHandle method = B2_PRISMATIC_JOINT_GET_MOTOR_FORCE.get();
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
    
    /**
     * Get the current joint translation, usually in meters.
     */
    public static float getTranslation(
        MemorySegment jointId
    ) {
        MethodHandle method = B2_PRISMATIC_JOINT_GET_TRANSLATION.get();
        try {
            return (float) method.invokeExact(
                jointId
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #getTranslation}.
     */
    public static float getTranslation(
        JointId jointId
    ) {
        return (float) getTranslation(
            jointId.memorySegment()
        );
    }
    
    /**
     * Get the current joint translation speed, usually in meters per second.
     */
    public static float getSpeed(
        MemorySegment jointId
    ) {
        MethodHandle method = B2_PRISMATIC_JOINT_GET_SPEED.get();
        try {
            return (float) method.invokeExact(
                jointId
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #getSpeed}.
     */
    public static float getSpeed(
        JointId jointId
    ) {
        return (float) getSpeed(
            jointId.memorySegment()
        );
    }
    
}