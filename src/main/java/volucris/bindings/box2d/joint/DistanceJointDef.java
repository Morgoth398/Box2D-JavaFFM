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
import volucris.bindings.box2d.body.BodyId;
import volucris.bindings.box2d.math.Vec2;
import volucris.bindings.core.NativeStructArray;
import volucris.bindings.core.Struct;

import static java.lang.foreign.ValueLayout.*;
import static volucris.bindings.core.FFMUtils.*;

/// ```
/// Distance joint definition
/// 
/// This requires defining an anchor point on both
/// bodies and the non-zero distance of the distance joint. The definition uses
/// local anchor points so that the initial configuration can violate the
/// constraint slightly. This helps when saving and loading a game.
/// @ingroup distance_joint
/// ```
public final class DistanceJointDef
		implements Struct<DistanceJointDef> {

    private static final LazyConstant<MethodHandle> B2_DEFAULT_DISTANCE_JOINT_DEF;

    public static final StructLayout LAYOUT;

    public static final VarHandle LENGTH_HANDLE;
    public static final VarHandle ENABLE_SPRING_HANDLE;
    public static final VarHandle HERTZ_HANDLE;
    public static final VarHandle DAMPING_RATIO_HANDLE;
    public static final VarHandle ENABLE_LIMIT_HANDLE;
    public static final VarHandle MIN_LENGTH_HANDLE;
    public static final VarHandle MAX_LENGTH_HANDLE;
    public static final VarHandle ENABLE_MOTOR_HANDLE;
    public static final VarHandle MAX_MOTOR_FORCE_HANDLE;
    public static final VarHandle MOTOR_SPEED_HANDLE;
    public static final VarHandle COLLIDE_CONNECTED_HANDLE;
    public static final VarHandle USER_DATA_HANDLE;
    public static final VarHandle INTERNAL_VALUE_HANDLE;

    public static final long BODY_ID_A_BYTE_OFFSET;
    public static final long BODY_ID_B_BYTE_OFFSET;
    public static final long LOCAL_ANCHOR_A_BYTE_OFFSET;
    public static final long LOCAL_ANCHOR_B_BYTE_OFFSET;
    public static final long LENGTH_BYTE_OFFSET;
    public static final long ENABLE_SPRING_BYTE_OFFSET;
    public static final long HERTZ_BYTE_OFFSET;
    public static final long DAMPING_RATIO_BYTE_OFFSET;
    public static final long ENABLE_LIMIT_BYTE_OFFSET;
    public static final long MIN_LENGTH_BYTE_OFFSET;
    public static final long MAX_LENGTH_BYTE_OFFSET;
    public static final long ENABLE_MOTOR_BYTE_OFFSET;
    public static final long MAX_MOTOR_FORCE_BYTE_OFFSET;
    public static final long MOTOR_SPEED_BYTE_OFFSET;
    public static final long COLLIDE_CONNECTED_BYTE_OFFSET;
    public static final long USER_DATA_BYTE_OFFSET;
    public static final long INTERNAL_VALUE_BYTE_OFFSET;

    private final MemorySegment segment;

    private final BodyId bodyIdA;
    private final BodyId bodyIdB;
    private final Vec2 localAnchorA;
    private final Vec2 localAnchorB;

    static {
        //@formatter:off
        LAYOUT = MemoryLayout.structLayout(
            BodyId.LAYOUT.withName("bodyIdA"),
            BodyId.LAYOUT.withName("bodyIdB"),
            Vec2.LAYOUT.withName("localAnchorA"),
            Vec2.LAYOUT.withName("localAnchorB"),
            JAVA_FLOAT.withName("length"),
            JAVA_BOOLEAN.withName("enableSpring"),
            MemoryLayout.paddingLayout(3),
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
            JAVA_BOOLEAN.withName("collideConnected"),
            MemoryLayout.paddingLayout(7),
            UNBOUNDED_ADDRESS.withName("userData"),
            JAVA_INT.withName("internalValue"),
            MemoryLayout.paddingLayout(4)
        ).withName("b2DistanceJointDef").withByteAlignment(8);
        
        B2_DEFAULT_DISTANCE_JOINT_DEF = downcallHandle("b2DefaultDistanceJointDef", DistanceJointDef.LAYOUT);
        
        LENGTH_HANDLE = LAYOUT.varHandle(PathElement.groupElement("length"));
        ENABLE_SPRING_HANDLE = LAYOUT.varHandle(PathElement.groupElement("enableSpring"));
        HERTZ_HANDLE = LAYOUT.varHandle(PathElement.groupElement("hertz"));
        DAMPING_RATIO_HANDLE = LAYOUT.varHandle(PathElement.groupElement("dampingRatio"));
        ENABLE_LIMIT_HANDLE = LAYOUT.varHandle(PathElement.groupElement("enableLimit"));
        MIN_LENGTH_HANDLE = LAYOUT.varHandle(PathElement.groupElement("minLength"));
        MAX_LENGTH_HANDLE = LAYOUT.varHandle(PathElement.groupElement("maxLength"));
        ENABLE_MOTOR_HANDLE = LAYOUT.varHandle(PathElement.groupElement("enableMotor"));
        MAX_MOTOR_FORCE_HANDLE = LAYOUT.varHandle(PathElement.groupElement("maxMotorForce"));
        MOTOR_SPEED_HANDLE = LAYOUT.varHandle(PathElement.groupElement("motorSpeed"));
        COLLIDE_CONNECTED_HANDLE = LAYOUT.varHandle(PathElement.groupElement("collideConnected"));
        USER_DATA_HANDLE = LAYOUT.varHandle(PathElement.groupElement("userData"));
        INTERNAL_VALUE_HANDLE = LAYOUT.varHandle(PathElement.groupElement("internalValue"));
        
        BODY_ID_A_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("bodyIdA"));
        BODY_ID_B_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("bodyIdB"));
        LOCAL_ANCHOR_A_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("localAnchorA"));
        LOCAL_ANCHOR_B_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("localAnchorB"));
        LENGTH_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("length"));
        ENABLE_SPRING_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("enableSpring"));
        HERTZ_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("hertz"));
        DAMPING_RATIO_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("dampingRatio"));
        ENABLE_LIMIT_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("enableLimit"));
        MIN_LENGTH_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("minLength"));
        MAX_LENGTH_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("maxLength"));
        ENABLE_MOTOR_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("enableMotor"));
        MAX_MOTOR_FORCE_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("maxMotorForce"));
        MOTOR_SPEED_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("motorSpeed"));
        COLLIDE_CONNECTED_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("collideConnected"));
        USER_DATA_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("userData"));
        INTERNAL_VALUE_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("internalValue"));
        //@formatter:on
    }

    public DistanceJointDef(MemorySegment segment) {
        this.segment = segment;
    
        bodyIdA = new BodyId(segment.asSlice(BODY_ID_A_BYTE_OFFSET, BodyId.LAYOUT));
        bodyIdB = new BodyId(segment.asSlice(BODY_ID_B_BYTE_OFFSET, BodyId.LAYOUT));
        localAnchorA = new Vec2(segment.asSlice(LOCAL_ANCHOR_A_BYTE_OFFSET, Vec2.LAYOUT));
        localAnchorB = new Vec2(segment.asSlice(LOCAL_ANCHOR_B_BYTE_OFFSET, Vec2.LAYOUT));
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
    /// Enable the distance constraint to behave like a spring. If false
    /// then the distance joint will be rigid, overriding the limit and motor.
    /// ```
    public boolean enableSpring() {
    	return (boolean) ENABLE_SPRING_HANDLE.get(segment, 0L);
    }
    
    /// @see #hertz()
    public DistanceJointDef hertz(float hertz) {
    	HERTZ_HANDLE.set(segment, 0L, hertz);
    	return this;
    }
    
    /// ```
    /// The spring linear stiffness Hertz, cycles per second
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
    /// Minimum length. Clamped to a stable minimum value.
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
    /// Maximum length. Must be greater than or equal to the minimum length.
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
    
    /// @see #collideConnected()
    public DistanceJointDef collideConnected(boolean collideConnected) {
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
    public DistanceJointDef userData(MemorySegment userData) {
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
    
    /// @see #bodyIdA()
    public DistanceJointDef bodyIdA(Consumer<BodyId> consumer) {
    	consumer.accept(bodyIdA);
    	return this;
    }
    
    /// @see #bodyIdA()
    public DistanceJointDef bodyIdA(BodyId other) {
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
    public DistanceJointDef bodyIdB(Consumer<BodyId> consumer) {
    	consumer.accept(bodyIdB);
    	return this;
    }
    
    /// @see #bodyIdB()
    public DistanceJointDef bodyIdB(BodyId other) {
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
    public DistanceJointDef localAnchorA(Consumer<Vec2> consumer) {
    	consumer.accept(localAnchorA);
    	return this;
    }
    
    /// @see #localAnchorA()
    public DistanceJointDef localAnchorA(Vec2 other) {
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
    public DistanceJointDef localAnchorB(Consumer<Vec2> consumer) {
    	consumer.accept(localAnchorB);
    	return this;
    }
    
    /// @see #localAnchorB()
    public DistanceJointDef localAnchorB(Vec2 other) {
    	localAnchorB.set(other);
    	return this;
    }
    
    /// ```
    /// The local anchor point relative to bodyB's origin
    /// ```
    public Vec2 localAnchorB() {
    	return localAnchorB;
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