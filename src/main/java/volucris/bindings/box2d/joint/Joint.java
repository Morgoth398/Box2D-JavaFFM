/*
 * MACHINE GENERATED FILE, DO NOT EDIT.
 */
package volucris.bindings.box2d.joint;

import java.lang.foreign.MemorySegment;
import java.lang.foreign.SegmentAllocator;
import java.lang.invoke.MethodHandle;
import org.jspecify.annotations.Nullable;
import volucris.bindings.box2d.body.BodyId;
import volucris.bindings.box2d.math.Transform;
import volucris.bindings.box2d.math.Vec2;
import volucris.bindings.box2d.world.WorldId;
import volucris.bindings.core.NativeFloatArray;

import static java.lang.foreign.ValueLayout.*;
import static volucris.bindings.core.FFMUtils.*;

public final class Joint {

	private static final LazyConstant<MethodHandle> B2_DESTROY_JOINT;
	private static final LazyConstant<MethodHandle> B2_JOINT_IS_VALID;
	private static final LazyConstant<MethodHandle> B2_JOINT_GET_TYPE;
	private static final LazyConstant<MethodHandle> B2_JOINT_GET_BODY_A;
	private static final LazyConstant<MethodHandle> B2_JOINT_GET_BODY_B;
	private static final LazyConstant<MethodHandle> B2_JOINT_GET_WORLD;
	private static final LazyConstant<MethodHandle> B2_JOINT_SET_LOCAL_FRAME_A;
	private static final LazyConstant<MethodHandle> B2_JOINT_GET_LOCAL_FRAME_A;
	private static final LazyConstant<MethodHandle> B2_JOINT_SET_LOCAL_FRAME_B;
	private static final LazyConstant<MethodHandle> B2_JOINT_GET_LOCAL_FRAME_B;
	private static final LazyConstant<MethodHandle> B2_JOINT_SET_COLLIDE_CONNECTED;
	private static final LazyConstant<MethodHandle> B2_JOINT_GET_COLLIDE_CONNECTED;
	private static final LazyConstant<MethodHandle> B2_JOINT_SET_USER_DATA;
	private static final LazyConstant<MethodHandle> B2_JOINT_GET_USER_DATA;
	private static final LazyConstant<MethodHandle> B2_JOINT_WAKE_BODIES;
	private static final LazyConstant<MethodHandle> B2_JOINT_GET_CONSTRAINT_FORCE;
	private static final LazyConstant<MethodHandle> B2_JOINT_GET_CONSTRAINT_TORQUE;
	private static final LazyConstant<MethodHandle> B2_JOINT_GET_LINEAR_SEPARATION;
	private static final LazyConstant<MethodHandle> B2_JOINT_GET_ANGULAR_SEPARATION;
	private static final LazyConstant<MethodHandle> B2_JOINT_SET_CONSTRAINT_TUNING;
	private static final LazyConstant<MethodHandle> B2_JOINT_GET_CONSTRAINT_TUNING;
	private static final LazyConstant<MethodHandle> B2_JOINT_SET_FORCE_THRESHOLD;
	private static final LazyConstant<MethodHandle> B2_JOINT_GET_FORCE_THRESHOLD;
	private static final LazyConstant<MethodHandle> B2_JOINT_SET_TORQUE_THRESHOLD;
	private static final LazyConstant<MethodHandle> B2_JOINT_GET_TORQUE_THRESHOLD;

	static {
		//@formatter:off
		B2_DESTROY_JOINT = downcallHandleVoid("b2DestroyJoint", JointId.LAYOUT);
		B2_JOINT_IS_VALID = downcallHandle("b2Joint_IsValid", JAVA_BOOLEAN, JointId.LAYOUT);
		B2_JOINT_GET_TYPE = downcallHandle("b2Joint_GetType", JAVA_INT, JointId.LAYOUT);
		B2_JOINT_GET_BODY_A = downcallHandle("b2Joint_GetBodyA", BodyId.LAYOUT, JointId.LAYOUT);
		B2_JOINT_GET_BODY_B = downcallHandle("b2Joint_GetBodyB", BodyId.LAYOUT, JointId.LAYOUT);
		B2_JOINT_GET_WORLD = downcallHandle("b2Joint_GetWorld", WorldId.LAYOUT, JointId.LAYOUT);
		B2_JOINT_SET_LOCAL_FRAME_A = downcallHandleVoid("b2Joint_SetLocalFrameA", JointId.LAYOUT, Transform.LAYOUT);
		B2_JOINT_GET_LOCAL_FRAME_A = downcallHandle("b2Joint_GetLocalFrameA", Transform.LAYOUT, JointId.LAYOUT);
		B2_JOINT_SET_LOCAL_FRAME_B = downcallHandleVoid("b2Joint_SetLocalFrameB", JointId.LAYOUT, Transform.LAYOUT);
		B2_JOINT_GET_LOCAL_FRAME_B = downcallHandle("b2Joint_GetLocalFrameB", Transform.LAYOUT, JointId.LAYOUT);
		B2_JOINT_SET_COLLIDE_CONNECTED = downcallHandleVoid("b2Joint_SetCollideConnected", JointId.LAYOUT, JAVA_BOOLEAN);
		B2_JOINT_GET_COLLIDE_CONNECTED = downcallHandle("b2Joint_GetCollideConnected", JAVA_BOOLEAN, JointId.LAYOUT);
		B2_JOINT_SET_USER_DATA = downcallHandleVoid("b2Joint_SetUserData", JointId.LAYOUT, UNBOUNDED_ADDRESS);
		B2_JOINT_GET_USER_DATA = downcallHandle("b2Joint_GetUserData", UNBOUNDED_ADDRESS, JointId.LAYOUT);
		B2_JOINT_WAKE_BODIES = downcallHandleVoid("b2Joint_WakeBodies", JointId.LAYOUT);
		B2_JOINT_GET_CONSTRAINT_FORCE = downcallHandle("b2Joint_GetConstraintForce", Vec2.LAYOUT, JointId.LAYOUT);
		B2_JOINT_GET_CONSTRAINT_TORQUE = downcallHandle("b2Joint_GetConstraintTorque", JAVA_FLOAT, JointId.LAYOUT);
		B2_JOINT_GET_LINEAR_SEPARATION = downcallHandle("b2Joint_GetLinearSeparation", JAVA_FLOAT, JointId.LAYOUT);
		B2_JOINT_GET_ANGULAR_SEPARATION = downcallHandle("b2Joint_GetAngularSeparation", JAVA_FLOAT, JointId.LAYOUT);
		B2_JOINT_SET_CONSTRAINT_TUNING = downcallHandleVoid("b2Joint_SetConstraintTuning", JointId.LAYOUT, JAVA_FLOAT, JAVA_FLOAT);
		B2_JOINT_GET_CONSTRAINT_TUNING = downcallHandleVoid("b2Joint_GetConstraintTuning", JointId.LAYOUT, UNBOUNDED_ADDRESS, UNBOUNDED_ADDRESS);
		B2_JOINT_SET_FORCE_THRESHOLD = downcallHandleVoid("b2Joint_SetForceThreshold", JointId.LAYOUT, JAVA_FLOAT);
		B2_JOINT_GET_FORCE_THRESHOLD = downcallHandle("b2Joint_GetForceThreshold", JAVA_FLOAT, JointId.LAYOUT);
		B2_JOINT_SET_TORQUE_THRESHOLD = downcallHandleVoid("b2Joint_SetTorqueThreshold", JointId.LAYOUT, JAVA_FLOAT);
		B2_JOINT_GET_TORQUE_THRESHOLD = downcallHandle("b2Joint_GetTorqueThreshold", JAVA_FLOAT, JointId.LAYOUT);
		//@formatter:on
	}

	private Joint() {
	}

    /// ```
    /// Destroy a joint.
    /// ```
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
    
    /// Typed method of [#destroyJoint].
    public static void destroyJoint(
    	JointId jointId
    ) {
    	destroyJoint(
    		jointId.memorySegment()
    	);
    }
    
    /// ```
    /// Joint identifier validation. Provides validation for up to 64K allocations.
    /// ```
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
    
    /// Typed method of [#isValid].
    public static boolean isValid(
    	JointId id
    ) {
    	return isValid(
    		id.memorySegment()
    	);
    }
    
    /// ```
    /// Get the joint type
    /// ```
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
    
    /// Typed method of [#getType].
    public static int getType(
    	JointId jointId
    ) {
    	return getType(
    		jointId.memorySegment()
    	);
    }
    
    /// ```
    /// Get body A id on a joint
    /// ```
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
    
    /// Typed method of [#getBodyA].
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
    
    /// ```
    /// Get body B id on a joint
    /// ```
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
    
    /// Typed method of [#getBodyB].
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
    
    /// ```
    /// Get the world that owns this joint
    /// ```
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
    
    /// Typed method of [#getWorld].
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
    
    /// ```
    /// Set the local frame on bodyA
    /// ```
    public static void setLocalFrameA(
    	MemorySegment jointId,
    	MemorySegment localFrame
    ) {
    	MethodHandle method = B2_JOINT_SET_LOCAL_FRAME_A.get();
    	try {
    		 method.invokeExact(
    			jointId,
    			localFrame
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#setLocalFrameA].
    public static void setLocalFrameA(
    	JointId jointId,
    	Transform localFrame
    ) {
    	setLocalFrameA(
    		jointId.memorySegment(),
    		localFrame.memorySegment()
    	);
    }
    
    /// ```
    /// Get the local frame on bodyA
    /// ```
    public static MemorySegment getLocalFrameA(
    	SegmentAllocator allocator,
    	MemorySegment jointId
    ) {
    	MethodHandle method = B2_JOINT_GET_LOCAL_FRAME_A.get();
    	try {
    		return (MemorySegment) method.invokeExact(
    			allocator,
    			jointId
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#getLocalFrameA].
    public static @Nullable Transform getLocalFrameA(
    	SegmentAllocator allocator,
    	JointId jointId
    ) {
    	MemorySegment segment = getLocalFrameA(
    		allocator,
    		jointId.memorySegment()
    	);
    
    	if (segment.equals(MemorySegment.NULL))
    		return null;
    	
    	return new Transform(segment);
    }
    
    /// ```
    /// Set the local frame on bodyB
    /// ```
    public static void setLocalFrameB(
    	MemorySegment jointId,
    	MemorySegment localFrame
    ) {
    	MethodHandle method = B2_JOINT_SET_LOCAL_FRAME_B.get();
    	try {
    		 method.invokeExact(
    			jointId,
    			localFrame
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#setLocalFrameB].
    public static void setLocalFrameB(
    	JointId jointId,
    	Transform localFrame
    ) {
    	setLocalFrameB(
    		jointId.memorySegment(),
    		localFrame.memorySegment()
    	);
    }
    
    /// ```
    /// Get the local frame on bodyB
    /// ```
    public static MemorySegment getLocalFrameB(
    	SegmentAllocator allocator,
    	MemorySegment jointId
    ) {
    	MethodHandle method = B2_JOINT_GET_LOCAL_FRAME_B.get();
    	try {
    		return (MemorySegment) method.invokeExact(
    			allocator,
    			jointId
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#getLocalFrameB].
    public static @Nullable Transform getLocalFrameB(
    	SegmentAllocator allocator,
    	JointId jointId
    ) {
    	MemorySegment segment = getLocalFrameB(
    		allocator,
    		jointId.memorySegment()
    	);
    
    	if (segment.equals(MemorySegment.NULL))
    		return null;
    	
    	return new Transform(segment);
    }
    
    /// ```
    /// Toggle collision between connected bodies
    /// ```
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
    
    /// Typed method of [#setCollideConnected].
    public static void setCollideConnected(
    	JointId jointId,
    	boolean shouldCollide
    ) {
    	setCollideConnected(
    		jointId.memorySegment(),
    		shouldCollide
    	);
    }
    
    /// ```
    /// Is collision allowed between connected bodies?
    /// ```
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
    
    /// Typed method of [#getCollideConnected].
    public static boolean getCollideConnected(
    	JointId jointId
    ) {
    	return getCollideConnected(
    		jointId.memorySegment()
    	);
    }
    
    /// ```
    /// Set the user data on a joint
    /// ```
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
    
    /// Typed method of [#setUserData].
    public static void setUserData(
    	JointId jointId,
    	MemorySegment userData
    ) {
    	setUserData(
    		jointId.memorySegment(),
    		userData
    	);
    }
    
    /// ```
    /// Get the user data on a joint
    /// ```
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
    
    /// Typed method of [#getUserData].
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
    
    /// ```
    /// Wake the bodies connected to this joint
    /// ```
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
    
    /// Typed method of [#wakeBodies].
    public static void wakeBodies(
    	JointId jointId
    ) {
    	wakeBodies(
    		jointId.memorySegment()
    	);
    }
    
    /// ```
    /// Get the current constraint force for this joint. Usually in Newtons.
    /// ```
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
    
    /// Typed method of [#getConstraintForce].
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
    
    /// ```
    /// Get the current constraint torque for this joint. Usually in Newton * meters.
    /// ```
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
    
    /// Typed method of [#getConstraintTorque].
    public static float getConstraintTorque(
    	JointId jointId
    ) {
    	return getConstraintTorque(
    		jointId.memorySegment()
    	);
    }
    
    /// ```
    /// Get the current linear separation error for this joint. Does not consider admissible movement.
    /// Usually in meters.
    /// ```
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
    
    /// Typed method of [#getLinearSeparation].
    public static float getLinearSeparation(
    	JointId jointId
    ) {
    	return getLinearSeparation(
    		jointId.memorySegment()
    	);
    }
    
    /// ```
    /// Get the current angular separation error for this joint. Does not consider admissible movement.
    /// Radians.
    /// ```
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
    
    /// Typed method of [#getAngularSeparation].
    public static float getAngularSeparation(
    	JointId jointId
    ) {
    	return getAngularSeparation(
    		jointId.memorySegment()
    	);
    }
    
    /// ```
    /// Set the joint constraint tuning. Advanced feature.
    /// @param jointId the joint
    /// @param hertz the stiffness in Hertz (cycles per second)
    /// @param dampingRatio the non-dimensional damping ratio (one for critical damping)
    /// ```
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
    
    /// Typed method of [#setConstraintTuning].
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
    
    /// ```
    /// Get the joint constraint tuning. Advanced feature.
    /// ```
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
    
    /// Typed method of [#getConstraintTuning].
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
    
    /// ```
    /// Set the force threshold for joint events (Newtons)
    /// ```
    public static void setForceThreshold(
    	MemorySegment jointId,
    	float threshold
    ) {
    	MethodHandle method = B2_JOINT_SET_FORCE_THRESHOLD.get();
    	try {
    		 method.invokeExact(
    			jointId,
    			threshold
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#setForceThreshold].
    public static void setForceThreshold(
    	JointId jointId,
    	float threshold
    ) {
    	setForceThreshold(
    		jointId.memorySegment(),
    		threshold
    	);
    }
    
    /// ```
    /// Get the force threshold for joint events (Newtons)
    /// ```
    public static float getForceThreshold(
    	MemorySegment jointId
    ) {
    	MethodHandle method = B2_JOINT_GET_FORCE_THRESHOLD.get();
    	try {
    		return (float) method.invokeExact(
    			jointId
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#getForceThreshold].
    public static float getForceThreshold(
    	JointId jointId
    ) {
    	return getForceThreshold(
    		jointId.memorySegment()
    	);
    }
    
    /// ```
    /// Set the torque threshold for joint events (N-m)
    /// ```
    public static void setTorqueThreshold(
    	MemorySegment jointId,
    	float threshold
    ) {
    	MethodHandle method = B2_JOINT_SET_TORQUE_THRESHOLD.get();
    	try {
    		 method.invokeExact(
    			jointId,
    			threshold
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#setTorqueThreshold].
    public static void setTorqueThreshold(
    	JointId jointId,
    	float threshold
    ) {
    	setTorqueThreshold(
    		jointId.memorySegment(),
    		threshold
    	);
    }
    
    /// ```
    /// Get the torque threshold for joint events (N-m)
    /// ```
    public static float getTorqueThreshold(
    	MemorySegment jointId
    ) {
    	MethodHandle method = B2_JOINT_GET_TORQUE_THRESHOLD.get();
    	try {
    		return (float) method.invokeExact(
    			jointId
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#getTorqueThreshold].
    public static float getTorqueThreshold(
    	JointId jointId
    ) {
    	return getTorqueThreshold(
    		jointId.memorySegment()
    	);
    }

}