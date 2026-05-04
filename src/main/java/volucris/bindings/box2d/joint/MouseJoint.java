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
public final class MouseJoint {

    private static final LazyConstant<MethodHandle> B2_CREATE_MOUSE_JOINT;
    private static final LazyConstant<MethodHandle> B2_MOUSE_JOINT_SET_TARGET;
    private static final LazyConstant<MethodHandle> B2_MOUSE_JOINT_GET_TARGET;
    private static final LazyConstant<MethodHandle> B2_MOUSE_JOINT_SET_SPRING_HERTZ;
    private static final LazyConstant<MethodHandle> B2_MOUSE_JOINT_GET_SPRING_HERTZ;
    private static final LazyConstant<MethodHandle> B2_MOUSE_JOINT_SET_SPRING_DAMPING_RATIO;
    private static final LazyConstant<MethodHandle> B2_MOUSE_JOINT_GET_SPRING_DAMPING_RATIO;
    private static final LazyConstant<MethodHandle> B2_MOUSE_JOINT_SET_MAX_FORCE;
    private static final LazyConstant<MethodHandle> B2_MOUSE_JOINT_GET_MAX_FORCE;

    static {
        //@formatter:off
        B2_CREATE_MOUSE_JOINT = downcallHandle("b2CreateMouseJoint", JointId.LAYOUT, WorldId.LAYOUT, UNBOUNDED_ADDRESS);
        B2_MOUSE_JOINT_SET_TARGET = downcallHandleVoid("b2MouseJoint_SetTarget", JointId.LAYOUT, Vec2.LAYOUT);
        B2_MOUSE_JOINT_GET_TARGET = downcallHandle("b2MouseJoint_GetTarget", Vec2.LAYOUT, JointId.LAYOUT);
        B2_MOUSE_JOINT_SET_SPRING_HERTZ = downcallHandleVoid("b2MouseJoint_SetSpringHertz", JointId.LAYOUT, JAVA_FLOAT);
        B2_MOUSE_JOINT_GET_SPRING_HERTZ = downcallHandle("b2MouseJoint_GetSpringHertz", JAVA_FLOAT, JointId.LAYOUT);
        B2_MOUSE_JOINT_SET_SPRING_DAMPING_RATIO = downcallHandleVoid("b2MouseJoint_SetSpringDampingRatio", JointId.LAYOUT, JAVA_FLOAT);
        B2_MOUSE_JOINT_GET_SPRING_DAMPING_RATIO = downcallHandle("b2MouseJoint_GetSpringDampingRatio", JAVA_FLOAT, JointId.LAYOUT);
        B2_MOUSE_JOINT_SET_MAX_FORCE = downcallHandleVoid("b2MouseJoint_SetMaxForce", JointId.LAYOUT, JAVA_FLOAT);
        B2_MOUSE_JOINT_GET_MAX_FORCE = downcallHandle("b2MouseJoint_GetMaxForce", JAVA_FLOAT, JointId.LAYOUT);
        //@formatter:on
    }

    private MouseJoint() {
    }

    /**
     * Create a mouse joint
     */
    public static MemorySegment createMouseJoint(
        SegmentAllocator allocator,
        MemorySegment worldId, 
        MemorySegment def
    ) {
        MethodHandle method = B2_CREATE_MOUSE_JOINT.get();
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
     * Typed method of {@link #createMouseJoint}.
     */
    public static @Nullable JointId createMouseJoint(
        SegmentAllocator allocator,
        WorldId worldId, 
        MouseJointDef def
    ) {
        MemorySegment segment = createMouseJoint(
            allocator,
            worldId.memorySegment(), 
            def.memorySegment()
        );
    
        if (segment.equals(MemorySegment.NULL))
            return null;
    
        return new JointId(segment);
    }
    
    /**
     * Set the mouse joint target
     */
    public static void setTarget(
        MemorySegment jointId, 
        MemorySegment target
    ) {
        MethodHandle method = B2_MOUSE_JOINT_SET_TARGET.get();
        try {
            method.invokeExact(
                jointId, 
                target
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #setTarget}.
     */
    public static void setTarget(
        JointId jointId, 
        Vec2 target
    ) {
        setTarget(
            jointId.memorySegment(), 
            target.memorySegment()
        );
    }
    
    /**
     * Get the mouse joint target
     */
    public static MemorySegment getTarget(
        SegmentAllocator allocator,
        MemorySegment jointId
    ) {
        MethodHandle method = B2_MOUSE_JOINT_GET_TARGET.get();
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
     * Typed method of {@link #getTarget}.
     */
    public static @Nullable Vec2 getTarget(
        SegmentAllocator allocator,
        JointId jointId
    ) {
        MemorySegment segment = getTarget(
            allocator,
            jointId.memorySegment()
        );
    
        if (segment.equals(MemorySegment.NULL))
            return null;
    
        return new Vec2(segment);
    }
    
    /**
     * Set the mouse joint spring stiffness in Hertz
     */
    public static void setSpringHertz(
        MemorySegment jointId, 
        float hertz
    ) {
        MethodHandle method = B2_MOUSE_JOINT_SET_SPRING_HERTZ.get();
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
     * Get the mouse joint spring stiffness in Hertz
     */
    public static float getSpringHertz(
        MemorySegment jointId
    ) {
        MethodHandle method = B2_MOUSE_JOINT_GET_SPRING_HERTZ.get();
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
     * Set the mouse joint spring damping ratio, non-dimensional
     */
    public static void setSpringDampingRatio(
        MemorySegment jointId, 
        float dampingRatio
    ) {
        MethodHandle method = B2_MOUSE_JOINT_SET_SPRING_DAMPING_RATIO.get();
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
     * Get the mouse joint damping ratio, non-dimensional
     */
    public static float getSpringDampingRatio(
        MemorySegment jointId
    ) {
        MethodHandle method = B2_MOUSE_JOINT_GET_SPRING_DAMPING_RATIO.get();
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
     * Set the mouse joint maximum force, usually in newtons
     */
    public static void setMaxForce(
        MemorySegment jointId, 
        float maxForce
    ) {
        MethodHandle method = B2_MOUSE_JOINT_SET_MAX_FORCE.get();
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
     * Get the mouse joint maximum force, usually in newtons
     */
    public static float getMaxForce(
        MemorySegment jointId
    ) {
        MethodHandle method = B2_MOUSE_JOINT_GET_MAX_FORCE.get();
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
    
}