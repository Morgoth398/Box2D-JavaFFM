/*
 * MACHINE GENERATED FILE, DO NOT EDIT.
 */
package volucris.bindings.box2d.joint;

import java.lang.foreign.MemorySegment;
import java.lang.foreign.SegmentAllocator;
import java.lang.invoke.MethodHandle;
import org.jspecify.annotations.Nullable;
import volucris.bindings.box2d.world.WorldId;

import static java.lang.foreign.ValueLayout.*;
import static volucris.bindings.core.FFMUtils.*;

public final class PogoJoint {

	private static final LazyConstant<MethodHandle> B2_CREATE_POGO_JOINT;
	private static final LazyConstant<MethodHandle> B2_POGO_JOINT_SET_REST_LENGTH;
	private static final LazyConstant<MethodHandle> B2_POGO_JOINT_GET_REST_LENGTH;
	private static final LazyConstant<MethodHandle> B2_POGO_JOINT_SET_SPRING_HERTZ;
	private static final LazyConstant<MethodHandle> B2_POGO_JOINT_GET_SPRING_HERTZ;
	private static final LazyConstant<MethodHandle> B2_POGO_JOINT_SET_SPRING_DAMPING_RATIO;
	private static final LazyConstant<MethodHandle> B2_POGO_JOINT_GET_SPRING_DAMPING_RATIO;
	private static final LazyConstant<MethodHandle> B2_POGO_JOINT_GET_CURRENT_LENGTH;
	private static final LazyConstant<MethodHandle> B2_POGO_JOINT_GET_CURRENT_SPEED;
	private static final LazyConstant<MethodHandle> B2_POGO_JOINT_GET_IMPULSE;

	static {
		//@formatter:off
		B2_CREATE_POGO_JOINT = downcallHandle("b2CreatePogoJoint", JointId.LAYOUT, WorldId.LAYOUT, UNBOUNDED_ADDRESS);
		B2_POGO_JOINT_SET_REST_LENGTH = downcallHandleVoid("b2PogoJoint_SetRestLength", JointId.LAYOUT, JAVA_FLOAT);
		B2_POGO_JOINT_GET_REST_LENGTH = downcallHandle("b2PogoJoint_GetRestLength", JAVA_FLOAT, JointId.LAYOUT);
		B2_POGO_JOINT_SET_SPRING_HERTZ = downcallHandleVoid("b2PogoJoint_SetSpringHertz", JointId.LAYOUT, JAVA_FLOAT);
		B2_POGO_JOINT_GET_SPRING_HERTZ = downcallHandle("b2PogoJoint_GetSpringHertz", JAVA_FLOAT, JointId.LAYOUT);
		B2_POGO_JOINT_SET_SPRING_DAMPING_RATIO = downcallHandleVoid("b2PogoJoint_SetSpringDampingRatio", JointId.LAYOUT, JAVA_FLOAT);
		B2_POGO_JOINT_GET_SPRING_DAMPING_RATIO = downcallHandle("b2PogoJoint_GetSpringDampingRatio", JAVA_FLOAT, JointId.LAYOUT);
		B2_POGO_JOINT_GET_CURRENT_LENGTH = downcallHandle("b2PogoJoint_GetCurrentLength", JAVA_FLOAT, JointId.LAYOUT);
		B2_POGO_JOINT_GET_CURRENT_SPEED = downcallHandle("b2PogoJoint_GetCurrentSpeed", JAVA_FLOAT, JointId.LAYOUT);
		B2_POGO_JOINT_GET_IMPULSE = downcallHandle("b2PogoJoint_GetImpulse", JAVA_FLOAT, JointId.LAYOUT);
		//@formatter:on
	}

	private PogoJoint() {
	}

    /// ```
    /// Create a pogo joint
    /// @see b2PogoJointDef for details
    /// ```
    public static MemorySegment createPogoJoint(
    	SegmentAllocator allocator,
    	MemorySegment worldId,
    	MemorySegment def
    ) {
    	MethodHandle method = B2_CREATE_POGO_JOINT.get();
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
    
    /// Typed method of [#createPogoJoint].
    public static @Nullable JointId createPogoJoint(
    	SegmentAllocator allocator,
    	WorldId worldId,
    	PogoJointDef def
    ) {
    	MemorySegment segment = createPogoJoint(
    		allocator,
    		worldId.memorySegment(),
    		def.memorySegment()
    	);
    
    	if (segment.equals(MemorySegment.NULL))
    		return null;
    	
    	return new JointId(segment);
    }
    
    /// ```
    /// Set the rest length of a pogo joint
    /// @param jointId The id for a pogo joint
    /// @param length The new pogo joint length
    /// ```
    public static void pogoJoint_SetRestLength(
    	MemorySegment jointId,
    	float length
    ) {
    	MethodHandle method = B2_POGO_JOINT_SET_REST_LENGTH.get();
    	try {
    		 method.invokeExact(
    			jointId,
    			length
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#pogoJoint_SetRestLength].
    public static void pogoJoint_SetRestLength(
    	JointId jointId,
    	float length
    ) {
    	pogoJoint_SetRestLength(
    		jointId.memorySegment(),
    		length
    	);
    }
    
    /// ```
    /// Get the rest length of a pogo joint
    /// ```
    public static float pogoJoint_GetRestLength(
    	MemorySegment jointId
    ) {
    	MethodHandle method = B2_POGO_JOINT_GET_REST_LENGTH.get();
    	try {
    		return (float) method.invokeExact(
    			jointId
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#pogoJoint_GetRestLength].
    public static float pogoJoint_GetRestLength(
    	JointId jointId
    ) {
    	return pogoJoint_GetRestLength(
    		jointId.memorySegment()
    	);
    }
    
    /// ```
    /// Set the spring stiffness in Hertz
    /// ```
    public static void pogoJoint_SetSpringHertz(
    	MemorySegment jointId,
    	float hertz
    ) {
    	MethodHandle method = B2_POGO_JOINT_SET_SPRING_HERTZ.get();
    	try {
    		 method.invokeExact(
    			jointId,
    			hertz
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#pogoJoint_SetSpringHertz].
    public static void pogoJoint_SetSpringHertz(
    	JointId jointId,
    	float hertz
    ) {
    	pogoJoint_SetSpringHertz(
    		jointId.memorySegment(),
    		hertz
    	);
    }
    
    /// ```
    /// Get the spring Hertz
    /// ```
    public static float pogoJoint_GetSpringHertz(
    	MemorySegment jointId
    ) {
    	MethodHandle method = B2_POGO_JOINT_GET_SPRING_HERTZ.get();
    	try {
    		return (float) method.invokeExact(
    			jointId
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#pogoJoint_GetSpringHertz].
    public static float pogoJoint_GetSpringHertz(
    	JointId jointId
    ) {
    	return pogoJoint_GetSpringHertz(
    		jointId.memorySegment()
    	);
    }
    
    /// ```
    /// Set the spring damping ratio, non-dimensional
    /// ```
    public static void pogoJoint_SetSpringDampingRatio(
    	MemorySegment jointId,
    	float dampingRatio
    ) {
    	MethodHandle method = B2_POGO_JOINT_SET_SPRING_DAMPING_RATIO.get();
    	try {
    		 method.invokeExact(
    			jointId,
    			dampingRatio
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#pogoJoint_SetSpringDampingRatio].
    public static void pogoJoint_SetSpringDampingRatio(
    	JointId jointId,
    	float dampingRatio
    ) {
    	pogoJoint_SetSpringDampingRatio(
    		jointId.memorySegment(),
    		dampingRatio
    	);
    }
    
    /// ```
    /// Get the spring damping ratio
    /// ```
    public static float pogoJoint_GetSpringDampingRatio(
    	MemorySegment jointId
    ) {
    	MethodHandle method = B2_POGO_JOINT_GET_SPRING_DAMPING_RATIO.get();
    	try {
    		return (float) method.invokeExact(
    			jointId
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#pogoJoint_GetSpringDampingRatio].
    public static float pogoJoint_GetSpringDampingRatio(
    	JointId jointId
    ) {
    	return pogoJoint_GetSpringDampingRatio(
    		jointId.memorySegment()
    	);
    }
    
    /// ```
    /// Get the current length of the pogo.
    /// ```
    public static float pogoJoint_GetCurrentLength(
    	MemorySegment jointId
    ) {
    	MethodHandle method = B2_POGO_JOINT_GET_CURRENT_LENGTH.get();
    	try {
    		return (float) method.invokeExact(
    			jointId
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#pogoJoint_GetCurrentLength].
    public static float pogoJoint_GetCurrentLength(
    	JointId jointId
    ) {
    	return pogoJoint_GetCurrentLength(
    		jointId.memorySegment()
    	);
    }
    
    /// ```
    /// Get the internal pogo velocity.
    /// ```
    public static float pogoJoint_GetCurrentSpeed(
    	MemorySegment jointId
    ) {
    	MethodHandle method = B2_POGO_JOINT_GET_CURRENT_SPEED.get();
    	try {
    		return (float) method.invokeExact(
    			jointId
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#pogoJoint_GetCurrentSpeed].
    public static float pogoJoint_GetCurrentSpeed(
    	JointId jointId
    ) {
    	return pogoJoint_GetCurrentSpeed(
    		jointId.memorySegment()
    	);
    }
    
    /// ```
    /// Get the internal pogo impulse.
    /// ```
    public static float pogoJoint_GetImpulse(
    	MemorySegment jointId
    ) {
    	MethodHandle method = B2_POGO_JOINT_GET_IMPULSE.get();
    	try {
    		return (float) method.invokeExact(
    			jointId
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#pogoJoint_GetImpulse].
    public static float pogoJoint_GetImpulse(
    	JointId jointId
    ) {
    	return pogoJoint_GetImpulse(
    		jointId.memorySegment()
    	);
    }

}