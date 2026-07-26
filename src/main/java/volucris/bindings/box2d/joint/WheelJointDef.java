/*
 * MACHINE GENERATED FILE, DO NOT EDIT.
 */
package volucris.bindings.box2d.joint;

import edu.umd.cs.findbugs.annotations.Nullable;
import java.lang.foreign.Arena;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.SegmentAllocator;
import java.lang.foreign.StructLayout;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.util.function.Consumer;
import volucris.bindings.box2d.body.BodyId;
import volucris.bindings.box2d.math.Vec2;
import volucris.bindings.core.NativeStructArray;
import volucris.bindings.core.Struct;

import static java.lang.foreign.ValueLayout.*;
import static volucris.bindings.core.FFMUtils.*;

/// ```
/// Wheel joint definition
/// 
/// This requires defining a line of motion using an axis and an anchor point.
/// The definition uses local  anchor points and a local axis so that the initial
/// configuration can violate the constraint slightly. The joint translation is zero
/// when the local anchor points coincide in world space.
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
    public static final VarHandle COLLIDE_CONNECTED_HANDLE;
    public static final VarHandle USER_DATA_HANDLE;
    public static final VarHandle INTERNAL_VALUE_HANDLE;

    public static final long BODY_ID_A_BYTE_OFFSET;
    public static final long BODY_ID_B_BYTE_OFFSET;
    public static final long LOCAL_ANCHOR_A_BYTE_OFFSET;
    public static final long LOCAL_ANCHOR_B_BYTE_OFFSET;
    public static final long LOCAL_AXIS_A_BYTE_OFFSET;
    public static final long ENABLE_SPRING_BYTE_OFFSET;
    public static final long HERTZ_BYTE_OFFSET;
    public static final long DAMPING_RATIO_BYTE_OFFSET;
    public static final long ENABLE_LIMIT_BYTE_OFFSET;
    public static final long LOWER_TRANSLATION_BYTE_OFFSET;
    public static final long UPPER_TRANSLATION_BYTE_OFFSET;
    public static final long ENABLE_MOTOR_BYTE_OFFSET;
    public static final long MAX_MOTOR_TORQUE_BYTE_OFFSET;
    public static final long MOTOR_SPEED_BYTE_OFFSET;
    public static final long COLLIDE_CONNECTED_BYTE_OFFSET;
    public static final long USER_DATA_BYTE_OFFSET;
    public static final long INTERNAL_VALUE_BYTE_OFFSET;

    private final MemorySegment segment;

    private final BodyId bodyIdA;
    private final BodyId bodyIdB;
    private final Vec2 localAnchorA;
    private final Vec2 localAnchorB;
    private final Vec2 localAxisA;

    static {
        //@formatter:off
        LAYOUT = MemoryLayout.structLayout(
            BodyId.LAYOUT.withName("bodyIdA"),
            BodyId.LAYOUT.withName("bodyIdB"),
            Vec2.LAYOUT.withName("localAnchorA"),
            Vec2.LAYOUT.withName("localAnchorB"),
            Vec2.LAYOUT.withName("localAxisA"),
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
            JAVA_BOOLEAN.withName("collideConnected"),
            MemoryLayout.paddingLayout(3),
            UNBOUNDED_ADDRESS.withName("userData"),
            JAVA_INT.withName("internalValue"),
            MemoryLayout.paddingLayout(4)
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
        COLLIDE_CONNECTED_HANDLE = LAYOUT.varHandle(PathElement.groupElement("collideConnected"));
        USER_DATA_HANDLE = LAYOUT.varHandle(PathElement.groupElement("userData"));
        INTERNAL_VALUE_HANDLE = LAYOUT.varHandle(PathElement.groupElement("internalValue"));
        
        BODY_ID_A_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("bodyIdA"));
        BODY_ID_B_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("bodyIdB"));
        LOCAL_ANCHOR_A_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("localAnchorA"));
        LOCAL_ANCHOR_B_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("localAnchorB"));
        LOCAL_AXIS_A_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("localAxisA"));
        ENABLE_SPRING_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("enableSpring"));
        HERTZ_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("hertz"));
        DAMPING_RATIO_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("dampingRatio"));
        ENABLE_LIMIT_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("enableLimit"));
        LOWER_TRANSLATION_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("lowerTranslation"));
        UPPER_TRANSLATION_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("upperTranslation"));
        ENABLE_MOTOR_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("enableMotor"));
        MAX_MOTOR_TORQUE_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("maxMotorTorque"));
        MOTOR_SPEED_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("motorSpeed"));
        COLLIDE_CONNECTED_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("collideConnected"));
        USER_DATA_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("userData"));
        INTERNAL_VALUE_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("internalValue"));
        //@formatter:on
    }

    public WheelJointDef(MemorySegment segment) {
        this.segment = segment;
    
        bodyIdA = new BodyId(segment.asSlice(BODY_ID_A_BYTE_OFFSET, BodyId.LAYOUT));
        bodyIdB = new BodyId(segment.asSlice(BODY_ID_B_BYTE_OFFSET, BodyId.LAYOUT));
        localAnchorA = new Vec2(segment.asSlice(LOCAL_ANCHOR_A_BYTE_OFFSET, Vec2.LAYOUT));
        localAnchorB = new Vec2(segment.asSlice(LOCAL_ANCHOR_B_BYTE_OFFSET, Vec2.LAYOUT));
        localAxisA = new Vec2(segment.asSlice(LOCAL_AXIS_A_BYTE_OFFSET, Vec2.LAYOUT));
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
    		return (MemorySegment)  method.invokeExact(
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
    
    /// @see #collideConnected()
    public WheelJointDef collideConnected(boolean collideConnected) {
    	COLLIDE_CONNECTED_HANDLE.set(segment, 0L, collideConnected);
    	return this;
    }
    
    /// ```
    /// Set this flag to true if the attached bodies should collide
    /// ```
    public boolean collideConnected() {
    	return (boolean) COLLIDE_CONNECTED_HANDLE.get(segment, 0L);
    }
    
    /// @see #userData()
    public WheelJointDef userData(MemorySegment userData) {
    	USER_DATA_HANDLE.set(segment, 0L, userData);
    	return this;
    }
    
    /// ```
    /// User data pointer
    /// ```
    public @Nullable MemorySegment userData() {
    	MemorySegment segment = (MemorySegment) USER_DATA_HANDLE.get(this.segment, 0L);
    
    	if (segment.equals(MemorySegment.NULL))
    		return null;
    	
    	return segment;
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
    
    /// @see #bodyIdA()
    public WheelJointDef bodyIdA(Consumer<BodyId> consumer) {
    	consumer.accept(bodyIdA);
    	return this;
    }
    
    /// @see #bodyIdA()
    public WheelJointDef bodyIdA(BodyId other) {
    	bodyIdA.set(other);
    	return this;
    }
    
    /// ```
    /// The first attached body
    /// ```
    public BodyId bodyIdA() {
    	return bodyIdA;
    }
    
    /// @see #bodyIdB()
    public WheelJointDef bodyIdB(Consumer<BodyId> consumer) {
    	consumer.accept(bodyIdB);
    	return this;
    }
    
    /// @see #bodyIdB()
    public WheelJointDef bodyIdB(BodyId other) {
    	bodyIdB.set(other);
    	return this;
    }
    
    /// ```
    /// The second attached body
    /// ```
    public BodyId bodyIdB() {
    	return bodyIdB;
    }
    
    /// @see #localAnchorA()
    public WheelJointDef localAnchorA(Consumer<Vec2> consumer) {
    	consumer.accept(localAnchorA);
    	return this;
    }
    
    /// @see #localAnchorA()
    public WheelJointDef localAnchorA(Vec2 other) {
    	localAnchorA.set(other);
    	return this;
    }
    
    /// ```
    /// The local anchor point relative to bodyA's origin
    /// ```
    public Vec2 localAnchorA() {
    	return localAnchorA;
    }
    
    /// @see #localAnchorB()
    public WheelJointDef localAnchorB(Consumer<Vec2> consumer) {
    	consumer.accept(localAnchorB);
    	return this;
    }
    
    /// @see #localAnchorB()
    public WheelJointDef localAnchorB(Vec2 other) {
    	localAnchorB.set(other);
    	return this;
    }
    
    /// ```
    /// The local anchor point relative to bodyB's origin
    /// ```
    public Vec2 localAnchorB() {
    	return localAnchorB;
    }
    
    /// @see #localAxisA()
    public WheelJointDef localAxisA(Consumer<Vec2> consumer) {
    	consumer.accept(localAxisA);
    	return this;
    }
    
    /// @see #localAxisA()
    public WheelJointDef localAxisA(Vec2 other) {
    	localAxisA.set(other);
    	return this;
    }
    
    /// ```
    /// The local translation unit axis in bodyA
    /// ```
    public Vec2 localAxisA() {
    	return localAxisA;
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