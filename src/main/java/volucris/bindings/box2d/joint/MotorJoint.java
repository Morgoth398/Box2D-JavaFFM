/*
 * MACHINE GENERATED FILE, DO NOT EDIT.
 */
package volucris.bindings.box2d.joint;

import java.lang.foreign.MemorySegment;
import java.lang.foreign.SegmentAllocator;
import java.lang.invoke.MethodHandle;
import org.jspecify.annotations.Nullable;
import volucris.bindings.box2d.math.Vec2;
import volucris.bindings.box2d.world.WorldId;

import static java.lang.foreign.ValueLayout.*;
import static volucris.bindings.core.FFMUtils.*;

public final class MotorJoint {

	private static final LazyConstant<MethodHandle> B2_CREATE_MOTOR_JOINT;
	private static final LazyConstant<MethodHandle> B2_MOTOR_JOINT_SET_LINEAR_VELOCITY;
	private static final LazyConstant<MethodHandle> B2_MOTOR_JOINT_GET_LINEAR_VELOCITY;
	private static final LazyConstant<MethodHandle> B2_MOTOR_JOINT_SET_ANGULAR_VELOCITY;
	private static final LazyConstant<MethodHandle> B2_MOTOR_JOINT_GET_ANGULAR_VELOCITY;
	private static final LazyConstant<MethodHandle> B2_MOTOR_JOINT_SET_MAX_VELOCITY_FORCE;
	private static final LazyConstant<MethodHandle> B2_MOTOR_JOINT_GET_MAX_VELOCITY_FORCE;
	private static final LazyConstant<MethodHandle> B2_MOTOR_JOINT_SET_MAX_VELOCITY_TORQUE;
	private static final LazyConstant<MethodHandle> B2_MOTOR_JOINT_GET_MAX_VELOCITY_TORQUE;
	private static final LazyConstant<MethodHandle> B2_MOTOR_JOINT_SET_LINEAR_HERTZ;
	private static final LazyConstant<MethodHandle> B2_MOTOR_JOINT_GET_LINEAR_HERTZ;
	private static final LazyConstant<MethodHandle> B2_MOTOR_JOINT_SET_LINEAR_DAMPING_RATIO;
	private static final LazyConstant<MethodHandle> B2_MOTOR_JOINT_GET_LINEAR_DAMPING_RATIO;
	private static final LazyConstant<MethodHandle> B2_MOTOR_JOINT_SET_ANGULAR_HERTZ;
	private static final LazyConstant<MethodHandle> B2_MOTOR_JOINT_GET_ANGULAR_HERTZ;
	private static final LazyConstant<MethodHandle> B2_MOTOR_JOINT_SET_ANGULAR_DAMPING_RATIO;
	private static final LazyConstant<MethodHandle> B2_MOTOR_JOINT_GET_ANGULAR_DAMPING_RATIO;
	private static final LazyConstant<MethodHandle> B2_MOTOR_JOINT_SET_MAX_SPRING_FORCE;
	private static final LazyConstant<MethodHandle> B2_MOTOR_JOINT_GET_MAX_SPRING_FORCE;
	private static final LazyConstant<MethodHandle> B2_MOTOR_JOINT_SET_MAX_SPRING_TORQUE;
	private static final LazyConstant<MethodHandle> B2_MOTOR_JOINT_GET_MAX_SPRING_TORQUE;

	static {
		//@formatter:off
		B2_CREATE_MOTOR_JOINT = downcallHandle("b2CreateMotorJoint", JointId.LAYOUT, WorldId.LAYOUT, UNBOUNDED_ADDRESS);
		B2_MOTOR_JOINT_SET_LINEAR_VELOCITY = downcallHandleVoid("b2MotorJoint_SetLinearVelocity", JointId.LAYOUT, Vec2.LAYOUT);
		B2_MOTOR_JOINT_GET_LINEAR_VELOCITY = downcallHandle("b2MotorJoint_GetLinearVelocity", Vec2.LAYOUT, JointId.LAYOUT);
		B2_MOTOR_JOINT_SET_ANGULAR_VELOCITY = downcallHandleVoid("b2MotorJoint_SetAngularVelocity", JointId.LAYOUT, JAVA_FLOAT);
		B2_MOTOR_JOINT_GET_ANGULAR_VELOCITY = downcallHandle("b2MotorJoint_GetAngularVelocity", JAVA_FLOAT, JointId.LAYOUT);
		B2_MOTOR_JOINT_SET_MAX_VELOCITY_FORCE = downcallHandleVoid("b2MotorJoint_SetMaxVelocityForce", JointId.LAYOUT, JAVA_FLOAT);
		B2_MOTOR_JOINT_GET_MAX_VELOCITY_FORCE = downcallHandle("b2MotorJoint_GetMaxVelocityForce", JAVA_FLOAT, JointId.LAYOUT);
		B2_MOTOR_JOINT_SET_MAX_VELOCITY_TORQUE = downcallHandleVoid("b2MotorJoint_SetMaxVelocityTorque", JointId.LAYOUT, JAVA_FLOAT);
		B2_MOTOR_JOINT_GET_MAX_VELOCITY_TORQUE = downcallHandle("b2MotorJoint_GetMaxVelocityTorque", JAVA_FLOAT, JointId.LAYOUT);
		B2_MOTOR_JOINT_SET_LINEAR_HERTZ = downcallHandleVoid("b2MotorJoint_SetLinearHertz", JointId.LAYOUT, JAVA_FLOAT);
		B2_MOTOR_JOINT_GET_LINEAR_HERTZ = downcallHandle("b2MotorJoint_GetLinearHertz", JAVA_FLOAT, JointId.LAYOUT);
		B2_MOTOR_JOINT_SET_LINEAR_DAMPING_RATIO = downcallHandleVoid("b2MotorJoint_SetLinearDampingRatio", JointId.LAYOUT, JAVA_FLOAT);
		B2_MOTOR_JOINT_GET_LINEAR_DAMPING_RATIO = downcallHandle("b2MotorJoint_GetLinearDampingRatio", JAVA_FLOAT, JointId.LAYOUT);
		B2_MOTOR_JOINT_SET_ANGULAR_HERTZ = downcallHandleVoid("b2MotorJoint_SetAngularHertz", JointId.LAYOUT, JAVA_FLOAT);
		B2_MOTOR_JOINT_GET_ANGULAR_HERTZ = downcallHandle("b2MotorJoint_GetAngularHertz", JAVA_FLOAT, JointId.LAYOUT);
		B2_MOTOR_JOINT_SET_ANGULAR_DAMPING_RATIO = downcallHandleVoid("b2MotorJoint_SetAngularDampingRatio", JointId.LAYOUT, JAVA_FLOAT);
		B2_MOTOR_JOINT_GET_ANGULAR_DAMPING_RATIO = downcallHandle("b2MotorJoint_GetAngularDampingRatio", JAVA_FLOAT, JointId.LAYOUT);
		B2_MOTOR_JOINT_SET_MAX_SPRING_FORCE = downcallHandleVoid("b2MotorJoint_SetMaxSpringForce", JointId.LAYOUT, JAVA_FLOAT);
		B2_MOTOR_JOINT_GET_MAX_SPRING_FORCE = downcallHandle("b2MotorJoint_GetMaxSpringForce", JAVA_FLOAT, JointId.LAYOUT);
		B2_MOTOR_JOINT_SET_MAX_SPRING_TORQUE = downcallHandleVoid("b2MotorJoint_SetMaxSpringTorque", JointId.LAYOUT, JAVA_FLOAT);
		B2_MOTOR_JOINT_GET_MAX_SPRING_TORQUE = downcallHandle("b2MotorJoint_GetMaxSpringTorque", JAVA_FLOAT, JointId.LAYOUT);
		//@formatter:on
	}

	private MotorJoint() {
	}

    /// ```
    /// Create a motor joint
    /// @see b2MotorJointDef for details
    /// ```
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
    
    /// Typed method of [#createMotorJoint].
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
    
    /// ```
    /// Set the desired relative linear velocity in meters per second
    /// ```
    public static void setLinearVelocity(
    	MemorySegment jointId,
    	MemorySegment velocity
    ) {
    	MethodHandle method = B2_MOTOR_JOINT_SET_LINEAR_VELOCITY.get();
    	try {
    		 method.invokeExact(
    			jointId,
    			velocity
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#setLinearVelocity].
    public static void setLinearVelocity(
    	JointId jointId,
    	Vec2 velocity
    ) {
    	setLinearVelocity(
    		jointId.memorySegment(),
    		velocity.memorySegment()
    	);
    }
    
    /// ```
    /// Get the desired relative linear velocity in meters per second
    /// ```
    public static MemorySegment getLinearVelocity(
    	SegmentAllocator allocator,
    	MemorySegment jointId
    ) {
    	MethodHandle method = B2_MOTOR_JOINT_GET_LINEAR_VELOCITY.get();
    	try {
    		return (MemorySegment) method.invokeExact(
    			allocator,
    			jointId
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#getLinearVelocity].
    public static @Nullable Vec2 getLinearVelocity(
    	SegmentAllocator allocator,
    	JointId jointId
    ) {
    	MemorySegment segment = getLinearVelocity(
    		allocator,
    		jointId.memorySegment()
    	);
    
    	if (segment.equals(MemorySegment.NULL))
    		return null;
    	
    	return new Vec2(segment);
    }
    
    /// ```
    /// Set the desired relative angular velocity in radians per second
    /// ```
    public static void setAngularVelocity(
    	MemorySegment jointId,
    	float velocity
    ) {
    	MethodHandle method = B2_MOTOR_JOINT_SET_ANGULAR_VELOCITY.get();
    	try {
    		 method.invokeExact(
    			jointId,
    			velocity
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#setAngularVelocity].
    public static void setAngularVelocity(
    	JointId jointId,
    	float velocity
    ) {
    	setAngularVelocity(
    		jointId.memorySegment(),
    		velocity
    	);
    }
    
    /// ```
    /// Get the desired relative angular velocity in radians per second
    /// ```
    public static float getAngularVelocity(
    	MemorySegment jointId
    ) {
    	MethodHandle method = B2_MOTOR_JOINT_GET_ANGULAR_VELOCITY.get();
    	try {
    		return (float) method.invokeExact(
    			jointId
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#getAngularVelocity].
    public static float getAngularVelocity(
    	JointId jointId
    ) {
    	return getAngularVelocity(
    		jointId.memorySegment()
    	);
    }
    
    /// ```
    /// Set the motor joint maximum force, usually in newtons
    /// ```
    public static void setMaxVelocityForce(
    	MemorySegment jointId,
    	float maxForce
    ) {
    	MethodHandle method = B2_MOTOR_JOINT_SET_MAX_VELOCITY_FORCE.get();
    	try {
    		 method.invokeExact(
    			jointId,
    			maxForce
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#setMaxVelocityForce].
    public static void setMaxVelocityForce(
    	JointId jointId,
    	float maxForce
    ) {
    	setMaxVelocityForce(
    		jointId.memorySegment(),
    		maxForce
    	);
    }
    
    /// ```
    /// Get the motor joint maximum force, usually in newtons
    /// ```
    public static float getMaxVelocityForce(
    	MemorySegment jointId
    ) {
    	MethodHandle method = B2_MOTOR_JOINT_GET_MAX_VELOCITY_FORCE.get();
    	try {
    		return (float) method.invokeExact(
    			jointId
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#getMaxVelocityForce].
    public static float getMaxVelocityForce(
    	JointId jointId
    ) {
    	return getMaxVelocityForce(
    		jointId.memorySegment()
    	);
    }
    
    /// ```
    /// Set the motor joint maximum torque, usually in newton-meters
    /// ```
    public static void setMaxVelocityTorque(
    	MemorySegment jointId,
    	float maxTorque
    ) {
    	MethodHandle method = B2_MOTOR_JOINT_SET_MAX_VELOCITY_TORQUE.get();
    	try {
    		 method.invokeExact(
    			jointId,
    			maxTorque
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#setMaxVelocityTorque].
    public static void setMaxVelocityTorque(
    	JointId jointId,
    	float maxTorque
    ) {
    	setMaxVelocityTorque(
    		jointId.memorySegment(),
    		maxTorque
    	);
    }
    
    /// ```
    /// Get the motor joint maximum torque, usually in newton-meters
    /// ```
    public static float getMaxVelocityTorque(
    	MemorySegment jointId
    ) {
    	MethodHandle method = B2_MOTOR_JOINT_GET_MAX_VELOCITY_TORQUE.get();
    	try {
    		return (float) method.invokeExact(
    			jointId
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#getMaxVelocityTorque].
    public static float getMaxVelocityTorque(
    	JointId jointId
    ) {
    	return getMaxVelocityTorque(
    		jointId.memorySegment()
    	);
    }
    
    /// ```
    /// Set the spring linear hertz stiffness
    /// ```
    public static void setLinearHertz(
    	MemorySegment jointId,
    	float hertz
    ) {
    	MethodHandle method = B2_MOTOR_JOINT_SET_LINEAR_HERTZ.get();
    	try {
    		 method.invokeExact(
    			jointId,
    			hertz
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#setLinearHertz].
    public static void setLinearHertz(
    	JointId jointId,
    	float hertz
    ) {
    	setLinearHertz(
    		jointId.memorySegment(),
    		hertz
    	);
    }
    
    /// ```
    /// Get the spring linear hertz stiffness
    /// ```
    public static float getLinearHertz(
    	MemorySegment jointId
    ) {
    	MethodHandle method = B2_MOTOR_JOINT_GET_LINEAR_HERTZ.get();
    	try {
    		return (float) method.invokeExact(
    			jointId
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#getLinearHertz].
    public static float getLinearHertz(
    	JointId jointId
    ) {
    	return getLinearHertz(
    		jointId.memorySegment()
    	);
    }
    
    /// ```
    /// Set the spring linear damping ratio. Use 1.0 for critical damping.
    /// ```
    public static void setLinearDampingRatio(
    	MemorySegment jointId,
    	float damping
    ) {
    	MethodHandle method = B2_MOTOR_JOINT_SET_LINEAR_DAMPING_RATIO.get();
    	try {
    		 method.invokeExact(
    			jointId,
    			damping
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#setLinearDampingRatio].
    public static void setLinearDampingRatio(
    	JointId jointId,
    	float damping
    ) {
    	setLinearDampingRatio(
    		jointId.memorySegment(),
    		damping
    	);
    }
    
    /// ```
    /// Get the spring linear damping ratio.
    /// ```
    public static float getLinearDampingRatio(
    	MemorySegment jointId
    ) {
    	MethodHandle method = B2_MOTOR_JOINT_GET_LINEAR_DAMPING_RATIO.get();
    	try {
    		return (float) method.invokeExact(
    			jointId
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#getLinearDampingRatio].
    public static float getLinearDampingRatio(
    	JointId jointId
    ) {
    	return getLinearDampingRatio(
    		jointId.memorySegment()
    	);
    }
    
    /// ```
    /// Set the spring angular hertz stiffness
    /// ```
    public static void setAngularHertz(
    	MemorySegment jointId,
    	float hertz
    ) {
    	MethodHandle method = B2_MOTOR_JOINT_SET_ANGULAR_HERTZ.get();
    	try {
    		 method.invokeExact(
    			jointId,
    			hertz
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#setAngularHertz].
    public static void setAngularHertz(
    	JointId jointId,
    	float hertz
    ) {
    	setAngularHertz(
    		jointId.memorySegment(),
    		hertz
    	);
    }
    
    /// ```
    /// Get the spring angular hertz stiffness
    /// ```
    public static float getAngularHertz(
    	MemorySegment jointId
    ) {
    	MethodHandle method = B2_MOTOR_JOINT_GET_ANGULAR_HERTZ.get();
    	try {
    		return (float) method.invokeExact(
    			jointId
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#getAngularHertz].
    public static float getAngularHertz(
    	JointId jointId
    ) {
    	return getAngularHertz(
    		jointId.memorySegment()
    	);
    }
    
    /// ```
    /// Set the spring angular damping ratio. Use 1.0 for critical damping.
    /// ```
    public static void setAngularDampingRatio(
    	MemorySegment jointId,
    	float damping
    ) {
    	MethodHandle method = B2_MOTOR_JOINT_SET_ANGULAR_DAMPING_RATIO.get();
    	try {
    		 method.invokeExact(
    			jointId,
    			damping
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#setAngularDampingRatio].
    public static void setAngularDampingRatio(
    	JointId jointId,
    	float damping
    ) {
    	setAngularDampingRatio(
    		jointId.memorySegment(),
    		damping
    	);
    }
    
    /// ```
    /// Get the spring angular damping ratio.
    /// ```
    public static float getAngularDampingRatio(
    	MemorySegment jointId
    ) {
    	MethodHandle method = B2_MOTOR_JOINT_GET_ANGULAR_DAMPING_RATIO.get();
    	try {
    		return (float) method.invokeExact(
    			jointId
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#getAngularDampingRatio].
    public static float getAngularDampingRatio(
    	JointId jointId
    ) {
    	return getAngularDampingRatio(
    		jointId.memorySegment()
    	);
    }
    
    /// ```
    /// Set the maximum spring force in newtons.
    /// ```
    public static void setMaxSpringForce(
    	MemorySegment jointId,
    	float maxForce
    ) {
    	MethodHandle method = B2_MOTOR_JOINT_SET_MAX_SPRING_FORCE.get();
    	try {
    		 method.invokeExact(
    			jointId,
    			maxForce
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#setMaxSpringForce].
    public static void setMaxSpringForce(
    	JointId jointId,
    	float maxForce
    ) {
    	setMaxSpringForce(
    		jointId.memorySegment(),
    		maxForce
    	);
    }
    
    /// ```
    /// Get the maximum spring force in newtons.
    /// ```
    public static float getMaxSpringForce(
    	MemorySegment jointId
    ) {
    	MethodHandle method = B2_MOTOR_JOINT_GET_MAX_SPRING_FORCE.get();
    	try {
    		return (float) method.invokeExact(
    			jointId
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#getMaxSpringForce].
    public static float getMaxSpringForce(
    	JointId jointId
    ) {
    	return getMaxSpringForce(
    		jointId.memorySegment()
    	);
    }
    
    /// ```
    /// Set the maximum spring torque in newtons * meters
    /// ```
    public static void setMaxSpringTorque(
    	MemorySegment jointId,
    	float maxTorque
    ) {
    	MethodHandle method = B2_MOTOR_JOINT_SET_MAX_SPRING_TORQUE.get();
    	try {
    		 method.invokeExact(
    			jointId,
    			maxTorque
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#setMaxSpringTorque].
    public static void setMaxSpringTorque(
    	JointId jointId,
    	float maxTorque
    ) {
    	setMaxSpringTorque(
    		jointId.memorySegment(),
    		maxTorque
    	);
    }
    
    /// ```
    /// Get the maximum spring torque in newtons * meters
    /// ```
    public static float getMaxSpringTorque(
    	MemorySegment jointId
    ) {
    	MethodHandle method = B2_MOTOR_JOINT_GET_MAX_SPRING_TORQUE.get();
    	try {
    		return (float) method.invokeExact(
    			jointId
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#getMaxSpringTorque].
    public static float getMaxSpringTorque(
    	JointId jointId
    ) {
    	return getMaxSpringTorque(
    		jointId.memorySegment()
    	);
    }

}