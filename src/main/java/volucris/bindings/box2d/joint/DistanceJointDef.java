/*
 * MACHINE GENERATED FILE, DO NOT EDIT.
 */
package volucris.bindings.box2d.joint;

import java.lang.foreign.Arena;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.SegmentAllocator;
import java.lang.foreign.StructLayout;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.util.function.Consumer;
import org.jspecify.annotations.Nullable;
import volucris.bindings.core.NativeStructArray;
import volucris.bindings.core.Struct;

import static java.lang.foreign.ValueLayout.*;
import static volucris.bindings.core.FFMUtils.*;

/// ```
/// Distance joint definition Connects a point on body A with a point on body B by a segment. Useful
/// for ropes and springs.
/// @ingroup distance_joint
/// ```
public final class DistanceJointDef
		implements Struct<DistanceJointDef> {

	private static final LazyConstant<MethodHandle> B2_DEFAULT_DISTANCE_JOINT_DEF;

	public static final StructLayout LAYOUT;

	public static final VarHandle LENGTH_HANDLE;
	public static final VarHandle ENABLE_SPRING_HANDLE;
	public static final VarHandle LOWER_SPRING_FORCE_HANDLE;
	public static final VarHandle UPPER_SPRING_FORCE_HANDLE;
	public static final VarHandle HERTZ_HANDLE;
	public static final VarHandle DAMPING_RATIO_HANDLE;
	public static final VarHandle ENABLE_LIMIT_HANDLE;
	public static final VarHandle MIN_LENGTH_HANDLE;
	public static final VarHandle MAX_LENGTH_HANDLE;
	public static final VarHandle ENABLE_MOTOR_HANDLE;
	public static final VarHandle MAX_MOTOR_FORCE_HANDLE;
	public static final VarHandle MOTOR_SPEED_HANDLE;
	public static final VarHandle INTERNAL_VALUE_HANDLE;

	public static final long BASE_BYTE_OFFSET;
	public static final long LENGTH_BYTE_OFFSET;
	public static final long ENABLE_SPRING_BYTE_OFFSET;
	public static final long LOWER_SPRING_FORCE_BYTE_OFFSET;
	public static final long UPPER_SPRING_FORCE_BYTE_OFFSET;
	public static final long HERTZ_BYTE_OFFSET;
	public static final long DAMPING_RATIO_BYTE_OFFSET;
	public static final long ENABLE_LIMIT_BYTE_OFFSET;
	public static final long MIN_LENGTH_BYTE_OFFSET;
	public static final long MAX_LENGTH_BYTE_OFFSET;
	public static final long ENABLE_MOTOR_BYTE_OFFSET;
	public static final long MAX_MOTOR_FORCE_BYTE_OFFSET;
	public static final long MOTOR_SPEED_BYTE_OFFSET;
	public static final long INTERNAL_VALUE_BYTE_OFFSET;

	private final MemorySegment segment;

	private final JointDef base;

	static {
		//@formatter:off
		LAYOUT = MemoryLayout.structLayout(
		    JointDef.LAYOUT.withName("base"),
		    JAVA_FLOAT.withName("length"),
		    JAVA_BOOLEAN.withName("enableSpring"),
		    MemoryLayout.paddingLayout(3),
		    JAVA_FLOAT.withName("lowerSpringForce"),
		    JAVA_FLOAT.withName("upperSpringForce"),
		    JAVA_FLOAT.withName("hertz"),
		    JAVA_FLOAT.withName("dampingRatio"),
		    JAVA_BOOLEAN.withName("enableLimit"),
		    MemoryLayout.paddingLayout(3),
		    JAVA_FLOAT.withName("minLength"),
		    JAVA_FLOAT.withName("maxLength"),
		    JAVA_BOOLEAN.withName("enableMotor"),
		    MemoryLayout.paddingLayout(3),
		    JAVA_FLOAT.withName("maxMotorForce"),
		    JAVA_FLOAT.withName("motorSpeed"),
		    JAVA_INT.withName("internalValue"),
		    MemoryLayout.paddingLayout(4)
		).withName("b2DistanceJointDef").withByteAlignment(8);
		
		B2_DEFAULT_DISTANCE_JOINT_DEF = downcallHandle("b2DefaultDistanceJointDef", DistanceJointDef.LAYOUT);
		
		LENGTH_HANDLE = LAYOUT.varHandle(PathElement.groupElement("length"));
		ENABLE_SPRING_HANDLE = LAYOUT.varHandle(PathElement.groupElement("enableSpring"));
		LOWER_SPRING_FORCE_HANDLE = LAYOUT.varHandle(PathElement.groupElement("lowerSpringForce"));
		UPPER_SPRING_FORCE_HANDLE = LAYOUT.varHandle(PathElement.groupElement("upperSpringForce"));
		HERTZ_HANDLE = LAYOUT.varHandle(PathElement.groupElement("hertz"));
		DAMPING_RATIO_HANDLE = LAYOUT.varHandle(PathElement.groupElement("dampingRatio"));
		ENABLE_LIMIT_HANDLE = LAYOUT.varHandle(PathElement.groupElement("enableLimit"));
		MIN_LENGTH_HANDLE = LAYOUT.varHandle(PathElement.groupElement("minLength"));
		MAX_LENGTH_HANDLE = LAYOUT.varHandle(PathElement.groupElement("maxLength"));
		ENABLE_MOTOR_HANDLE = LAYOUT.varHandle(PathElement.groupElement("enableMotor"));
		MAX_MOTOR_FORCE_HANDLE = LAYOUT.varHandle(PathElement.groupElement("maxMotorForce"));
		MOTOR_SPEED_HANDLE = LAYOUT.varHandle(PathElement.groupElement("motorSpeed"));
		INTERNAL_VALUE_HANDLE = LAYOUT.varHandle(PathElement.groupElement("internalValue"));
		
		BASE_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("base"));
		LENGTH_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("length"));
		ENABLE_SPRING_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("enableSpring"));
		LOWER_SPRING_FORCE_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("lowerSpringForce"));
		UPPER_SPRING_FORCE_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("upperSpringForce"));
		HERTZ_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("hertz"));
		DAMPING_RATIO_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("dampingRatio"));
		ENABLE_LIMIT_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("enableLimit"));
		MIN_LENGTH_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("minLength"));
		MAX_LENGTH_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("maxLength"));
		ENABLE_MOTOR_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("enableMotor"));
		MAX_MOTOR_FORCE_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("maxMotorForce"));
		MOTOR_SPEED_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("motorSpeed"));
		INTERNAL_VALUE_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("internalValue"));
		//@formatter:on
	}

	public DistanceJointDef(MemorySegment segment) {
	    this.segment = segment;
	
	    base = new JointDef(segment.asSlice(BASE_BYTE_OFFSET, JointDef.LAYOUT));
	}

    /// ```
    /// Use this to initialize your joint definition
    /// @ingroup distance_joint
    /// ```
    public static MemorySegment ndefaultDistanceJointDef(
    	SegmentAllocator allocator
    ) {
    	MethodHandle method = B2_DEFAULT_DISTANCE_JOINT_DEF.get();
    	try {
    		return (MemorySegment) method.invokeExact(
    			allocator
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#ndefaultDistanceJointDef].
    public static @Nullable DistanceJointDef defaultDistanceJointDef(
    	SegmentAllocator allocator
    ) {
    	MemorySegment segment = ndefaultDistanceJointDef(
    		allocator
    	);
    
    	if (segment.equals(MemorySegment.NULL))
    		return null;
    	
    	return new DistanceJointDef(segment);
    }
    
    /// @see #base()
    public DistanceJointDef base(Consumer<JointDef> consumer) {
    	consumer.accept(base);
    	return this;
    }
    
    /// @see #base()
    public DistanceJointDef base(JointDef other) {
    	base.set(other);
    	return this;
    }
    
    /// ```
    /// Base joint definition
    /// ```
    public JointDef base() {
    	return base;
    }
    
    /// @see #length()
    public DistanceJointDef length(float length) {
    	LENGTH_HANDLE.set(segment, 0L, length);
    	return this;
    }
    
    /// ```
    /// The rest length of this joint. Clamped to a stable minimum value.
    /// ```
    public float length() {
    	return (float) LENGTH_HANDLE.get(segment, 0L);
    }
    
    /// @see #enableSpring()
    public DistanceJointDef enableSpring(boolean enableSpring) {
    	ENABLE_SPRING_HANDLE.set(segment, 0L, enableSpring);
    	return this;
    }
    
    /// ```
    /// Enable the distance constraint to behave like a spring. If false then the distance joint
    /// will be rigid, overriding the limit and motor.
    /// ```
    public boolean enableSpring() {
    	return (boolean) ENABLE_SPRING_HANDLE.get(segment, 0L);
    }
    
    /// @see #lowerSpringForce()
    public DistanceJointDef lowerSpringForce(float lowerSpringForce) {
    	LOWER_SPRING_FORCE_HANDLE.set(segment, 0L, lowerSpringForce);
    	return this;
    }
    
    /// ```
    /// The lower spring force controls how much tension it can sustain.
    /// ```
    public float lowerSpringForce() {
    	return (float) LOWER_SPRING_FORCE_HANDLE.get(segment, 0L);
    }
    
    /// @see #upperSpringForce()
    public DistanceJointDef upperSpringForce(float upperSpringForce) {
    	UPPER_SPRING_FORCE_HANDLE.set(segment, 0L, upperSpringForce);
    	return this;
    }
    
    /// ```
    /// The upper spring force controls how much compression it can sustain.
    /// ```
    public float upperSpringForce() {
    	return (float) UPPER_SPRING_FORCE_HANDLE.get(segment, 0L);
    }
    
    /// @see #hertz()
    public DistanceJointDef hertz(float hertz) {
    	HERTZ_HANDLE.set(segment, 0L, hertz);
    	return this;
    }
    
    /// ```
    /// The spring linear stiffness Hertz, cycles per second.
    /// ```
    public float hertz() {
    	return (float) HERTZ_HANDLE.get(segment, 0L);
    }
    
    /// @see #dampingRatio()
    public DistanceJointDef dampingRatio(float dampingRatio) {
    	DAMPING_RATIO_HANDLE.set(segment, 0L, dampingRatio);
    	return this;
    }
    
    /// ```
    /// The spring linear damping ratio, non-dimensional
    /// ```
    public float dampingRatio() {
    	return (float) DAMPING_RATIO_HANDLE.get(segment, 0L);
    }
    
    /// @see #enableLimit()
    public DistanceJointDef enableLimit(boolean enableLimit) {
    	ENABLE_LIMIT_HANDLE.set(segment, 0L, enableLimit);
    	return this;
    }
    
    /// ```
    /// Enable/disable the joint limit
    /// ```
    public boolean enableLimit() {
    	return (boolean) ENABLE_LIMIT_HANDLE.get(segment, 0L);
    }
    
    /// @see #minLength()
    public DistanceJointDef minLength(float minLength) {
    	MIN_LENGTH_HANDLE.set(segment, 0L, minLength);
    	return this;
    }
    
    /// ```
    /// Minimum length for limit. Clamped to a stable minimum value.
    /// ```
    public float minLength() {
    	return (float) MIN_LENGTH_HANDLE.get(segment, 0L);
    }
    
    /// @see #maxLength()
    public DistanceJointDef maxLength(float maxLength) {
    	MAX_LENGTH_HANDLE.set(segment, 0L, maxLength);
    	return this;
    }
    
    /// ```
    /// Maximum length for limit. Must be greater than or equal to the minimum length.
    /// ```
    public float maxLength() {
    	return (float) MAX_LENGTH_HANDLE.get(segment, 0L);
    }
    
    /// @see #enableMotor()
    public DistanceJointDef enableMotor(boolean enableMotor) {
    	ENABLE_MOTOR_HANDLE.set(segment, 0L, enableMotor);
    	return this;
    }
    
    /// ```
    /// Enable/disable the joint motor
    /// ```
    public boolean enableMotor() {
    	return (boolean) ENABLE_MOTOR_HANDLE.get(segment, 0L);
    }
    
    /// @see #maxMotorForce()
    public DistanceJointDef maxMotorForce(float maxMotorForce) {
    	MAX_MOTOR_FORCE_HANDLE.set(segment, 0L, maxMotorForce);
    	return this;
    }
    
    /// ```
    /// The maximum motor force, usually in newtons
    /// ```
    public float maxMotorForce() {
    	return (float) MAX_MOTOR_FORCE_HANDLE.get(segment, 0L);
    }
    
    /// @see #motorSpeed()
    public DistanceJointDef motorSpeed(float motorSpeed) {
    	MOTOR_SPEED_HANDLE.set(segment, 0L, motorSpeed);
    	return this;
    }
    
    /// ```
    /// The desired motor speed, usually in meters per second
    /// ```
    public float motorSpeed() {
    	return (float) MOTOR_SPEED_HANDLE.get(segment, 0L);
    }
    
    /// @see #internalValue()
    public DistanceJointDef internalValue(int internalValue) {
    	INTERNAL_VALUE_HANDLE.set(segment, 0L, internalValue);
    	return this;
    }
    
    /// ```
    /// Used internally to detect a valid definition. DO NOT SET.
    /// ```
    public int internalValue() {
    	return (int) INTERNAL_VALUE_HANDLE.get(segment, 0L);
    }
    
    @Override
    public DistanceJointDef set(DistanceJointDef other) {
        return set(other.segment);
    }
    
    @Override
    public DistanceJointDef set(MemorySegment src) {
        MemorySegment.copy(src, 0L, segment, 0L, LAYOUT.byteSize());
        return this;
    }
    
    @Override
    public MemorySegment memorySegment() {
        return segment;
    }
    
    public NativeStructArray<DistanceJointDef> asArray() {
        return new NativeStructArray<>(this);
    }
    
    public static NativeStructArray<DistanceJointDef> array(Arena arena, int count) {
        return new NativeStructArray<>(
            arena,
            LAYOUT,
            segment -> new DistanceJointDef(segment),
            count
        );
    }
    
    public static NativeStructArray<DistanceJointDef> array(Arena arena, DistanceJointDef... structs) {
        NativeStructArray<DistanceJointDef> array = new NativeStructArray<>(
            arena,
            LAYOUT,
            segment -> new DistanceJointDef(segment),
            structs.length
        );
    
        for (int i = 0; i < structs.length; i++) {
            array.set(i, structs[i]);
        }
    
        return array;
    }
    
    public static NativeStructArray<DistanceJointDef> array(MemorySegment array) {
        return new NativeStructArray<>(
            array,
            LAYOUT,
            segment -> new DistanceJointDef(segment)
        );
    }

}