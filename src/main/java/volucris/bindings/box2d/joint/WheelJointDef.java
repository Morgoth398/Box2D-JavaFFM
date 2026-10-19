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
/// Wheel joint definition Body B is a wheel that may rotate freely and slide along the local x-axis
/// in frame A. The joint translation is zero when the local frame origins coincide in world space.
/// @ingroup wheel_joint
/// ```
public final class WheelJointDef
		implements Struct<WheelJointDef> {

	private static final LazyConstant<MethodHandle> B2_DEFAULT_WHEEL_JOINT_DEF;

	public static final StructLayout LAYOUT;

	public static final VarHandle ENABLE_SPRING_HANDLE;
	public static final VarHandle HERTZ_HANDLE;
	public static final VarHandle DAMPING_RATIO_HANDLE;
	public static final VarHandle ENABLE_LIMIT_HANDLE;
	public static final VarHandle LOWER_TRANSLATION_HANDLE;
	public static final VarHandle UPPER_TRANSLATION_HANDLE;
	public static final VarHandle ENABLE_MOTOR_HANDLE;
	public static final VarHandle MAX_MOTOR_TORQUE_HANDLE;
	public static final VarHandle MOTOR_SPEED_HANDLE;
	public static final VarHandle INTERNAL_VALUE_HANDLE;

	public static final long BASE_BYTE_OFFSET;
	public static final long ENABLE_SPRING_BYTE_OFFSET;
	public static final long HERTZ_BYTE_OFFSET;
	public static final long DAMPING_RATIO_BYTE_OFFSET;
	public static final long ENABLE_LIMIT_BYTE_OFFSET;
	public static final long LOWER_TRANSLATION_BYTE_OFFSET;
	public static final long UPPER_TRANSLATION_BYTE_OFFSET;
	public static final long ENABLE_MOTOR_BYTE_OFFSET;
	public static final long MAX_MOTOR_TORQUE_BYTE_OFFSET;
	public static final long MOTOR_SPEED_BYTE_OFFSET;
	public static final long INTERNAL_VALUE_BYTE_OFFSET;

	private final MemorySegment segment;

	private final JointDef base;

	static {
		//@formatter:off
		LAYOUT = MemoryLayout.structLayout(
		    JointDef.LAYOUT.withName("base"),
		    JAVA_BOOLEAN.withName("enableSpring"),
		    MemoryLayout.paddingLayout(3),
		    JAVA_FLOAT.withName("hertz"),
		    JAVA_FLOAT.withName("dampingRatio"),
		    JAVA_BOOLEAN.withName("enableLimit"),
		    MemoryLayout.paddingLayout(3),
		    JAVA_FLOAT.withName("lowerTranslation"),
		    JAVA_FLOAT.withName("upperTranslation"),
		    JAVA_BOOLEAN.withName("enableMotor"),
		    MemoryLayout.paddingLayout(3),
		    JAVA_FLOAT.withName("maxMotorTorque"),
		    JAVA_FLOAT.withName("motorSpeed"),
		    JAVA_INT.withName("internalValue")
		).withName("b2WheelJointDef").withByteAlignment(8);
		
		B2_DEFAULT_WHEEL_JOINT_DEF = downcallHandle("b2DefaultWheelJointDef", WheelJointDef.LAYOUT);
		
		ENABLE_SPRING_HANDLE = LAYOUT.varHandle(PathElement.groupElement("enableSpring"));
		HERTZ_HANDLE = LAYOUT.varHandle(PathElement.groupElement("hertz"));
		DAMPING_RATIO_HANDLE = LAYOUT.varHandle(PathElement.groupElement("dampingRatio"));
		ENABLE_LIMIT_HANDLE = LAYOUT.varHandle(PathElement.groupElement("enableLimit"));
		LOWER_TRANSLATION_HANDLE = LAYOUT.varHandle(PathElement.groupElement("lowerTranslation"));
		UPPER_TRANSLATION_HANDLE = LAYOUT.varHandle(PathElement.groupElement("upperTranslation"));
		ENABLE_MOTOR_HANDLE = LAYOUT.varHandle(PathElement.groupElement("enableMotor"));
		MAX_MOTOR_TORQUE_HANDLE = LAYOUT.varHandle(PathElement.groupElement("maxMotorTorque"));
		MOTOR_SPEED_HANDLE = LAYOUT.varHandle(PathElement.groupElement("motorSpeed"));
		INTERNAL_VALUE_HANDLE = LAYOUT.varHandle(PathElement.groupElement("internalValue"));
		
		BASE_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("base"));
		ENABLE_SPRING_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("enableSpring"));
		HERTZ_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("hertz"));
		DAMPING_RATIO_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("dampingRatio"));
		ENABLE_LIMIT_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("enableLimit"));
		LOWER_TRANSLATION_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("lowerTranslation"));
		UPPER_TRANSLATION_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("upperTranslation"));
		ENABLE_MOTOR_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("enableMotor"));
		MAX_MOTOR_TORQUE_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("maxMotorTorque"));
		MOTOR_SPEED_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("motorSpeed"));
		INTERNAL_VALUE_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("internalValue"));
		//@formatter:on
	}

	public WheelJointDef(MemorySegment segment) {
	    this.segment = segment;
	
	    base = new JointDef(segment.asSlice(BASE_BYTE_OFFSET, JointDef.LAYOUT));
	}

    /// ```
    /// Use this to initialize your joint definition
    /// @ingroup wheel_joint
    /// ```
    public static MemorySegment ndefaultWheelJointDef(
    	SegmentAllocator allocator
    ) {
    	MethodHandle method = B2_DEFAULT_WHEEL_JOINT_DEF.get();
    	try {
    		return (MemorySegment) method.invokeExact(
    			allocator
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#ndefaultWheelJointDef].
    public static @Nullable WheelJointDef defaultWheelJointDef(
    	SegmentAllocator allocator
    ) {
    	MemorySegment segment = ndefaultWheelJointDef(
    		allocator
    	);
    
    	if (segment.equals(MemorySegment.NULL))
    		return null;
    	
    	return new WheelJointDef(segment);
    }
    
    /// @see #base()
    public WheelJointDef base(Consumer<JointDef> consumer) {
    	consumer.accept(base);
    	return this;
    }
    
    /// @see #base()
    public WheelJointDef base(JointDef other) {
    	base.set(other);
    	return this;
    }
    
    /// ```
    /// Base joint definition
    /// ```
    public JointDef base() {
    	return base;
    }
    
    /// @see #enableSpring()
    public WheelJointDef enableSpring(boolean enableSpring) {
    	ENABLE_SPRING_HANDLE.set(segment, 0L, enableSpring);
    	return this;
    }
    
    /// ```
    /// Enable a linear spring along the local axis
    /// ```
    public boolean enableSpring() {
    	return (boolean) ENABLE_SPRING_HANDLE.get(segment, 0L);
    }
    
    /// @see #hertz()
    public WheelJointDef hertz(float hertz) {
    	HERTZ_HANDLE.set(segment, 0L, hertz);
    	return this;
    }
    
    /// ```
    /// Spring stiffness in Hertz
    /// ```
    public float hertz() {
    	return (float) HERTZ_HANDLE.get(segment, 0L);
    }
    
    /// @see #dampingRatio()
    public WheelJointDef dampingRatio(float dampingRatio) {
    	DAMPING_RATIO_HANDLE.set(segment, 0L, dampingRatio);
    	return this;
    }
    
    /// ```
    /// Spring damping ratio, non-dimensional
    /// ```
    public float dampingRatio() {
    	return (float) DAMPING_RATIO_HANDLE.get(segment, 0L);
    }
    
    /// @see #enableLimit()
    public WheelJointDef enableLimit(boolean enableLimit) {
    	ENABLE_LIMIT_HANDLE.set(segment, 0L, enableLimit);
    	return this;
    }
    
    /// ```
    /// Enable/disable the joint linear limit
    /// ```
    public boolean enableLimit() {
    	return (boolean) ENABLE_LIMIT_HANDLE.get(segment, 0L);
    }
    
    /// @see #lowerTranslation()
    public WheelJointDef lowerTranslation(float lowerTranslation) {
    	LOWER_TRANSLATION_HANDLE.set(segment, 0L, lowerTranslation);
    	return this;
    }
    
    /// ```
    /// The lower translation limit
    /// ```
    public float lowerTranslation() {
    	return (float) LOWER_TRANSLATION_HANDLE.get(segment, 0L);
    }
    
    /// @see #upperTranslation()
    public WheelJointDef upperTranslation(float upperTranslation) {
    	UPPER_TRANSLATION_HANDLE.set(segment, 0L, upperTranslation);
    	return this;
    }
    
    /// ```
    /// The upper translation limit
    /// ```
    public float upperTranslation() {
    	return (float) UPPER_TRANSLATION_HANDLE.get(segment, 0L);
    }
    
    /// @see #enableMotor()
    public WheelJointDef enableMotor(boolean enableMotor) {
    	ENABLE_MOTOR_HANDLE.set(segment, 0L, enableMotor);
    	return this;
    }
    
    /// ```
    /// Enable/disable the joint rotational motor
    /// ```
    public boolean enableMotor() {
    	return (boolean) ENABLE_MOTOR_HANDLE.get(segment, 0L);
    }
    
    /// @see #maxMotorTorque()
    public WheelJointDef maxMotorTorque(float maxMotorTorque) {
    	MAX_MOTOR_TORQUE_HANDLE.set(segment, 0L, maxMotorTorque);
    	return this;
    }
    
    /// ```
    /// The maximum motor torque, typically in newton-meters
    /// ```
    public float maxMotorTorque() {
    	return (float) MAX_MOTOR_TORQUE_HANDLE.get(segment, 0L);
    }
    
    /// @see #motorSpeed()
    public WheelJointDef motorSpeed(float motorSpeed) {
    	MOTOR_SPEED_HANDLE.set(segment, 0L, motorSpeed);
    	return this;
    }
    
    /// ```
    /// The desired motor speed in radians per second
    /// ```
    public float motorSpeed() {
    	return (float) MOTOR_SPEED_HANDLE.get(segment, 0L);
    }
    
    /// @see #internalValue()
    public WheelJointDef internalValue(int internalValue) {
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
    public WheelJointDef set(WheelJointDef other) {
        return set(other.segment);
    }
    
    @Override
    public WheelJointDef set(MemorySegment src) {
        MemorySegment.copy(src, 0L, segment, 0L, LAYOUT.byteSize());
        return this;
    }
    
    @Override
    public MemorySegment memorySegment() {
        return segment;
    }
    
    public NativeStructArray<WheelJointDef> asArray() {
        return new NativeStructArray<>(this);
    }
    
    public static NativeStructArray<WheelJointDef> array(Arena arena, int count) {
        return new NativeStructArray<>(
            arena,
            LAYOUT,
            segment -> new WheelJointDef(segment),
            count
        );
    }
    
    public static NativeStructArray<WheelJointDef> array(Arena arena, WheelJointDef... structs) {
        NativeStructArray<WheelJointDef> array = new NativeStructArray<>(
            arena,
            LAYOUT,
            segment -> new WheelJointDef(segment),
            structs.length
        );
    
        for (int i = 0; i < structs.length; i++) {
            array.set(i, structs[i]);
        }
    
        return array;
    }
    
    public static NativeStructArray<WheelJointDef> array(MemorySegment array) {
        return new NativeStructArray<>(
            array,
            LAYOUT,
            segment -> new WheelJointDef(segment)
        );
    }

}