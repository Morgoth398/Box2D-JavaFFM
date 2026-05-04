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

/**
 * Wheel joint definition
 */
public final class WheelJointDef
		implements Struct<WheelJointDef> {

    private static final LazyConstant<MethodHandle> B2_DEFAULT_WHEEL_JOINT_DEF;

    public static final StructLayout LAYOUT;

    public static final VarHandle ENABLE_SPRING;
    public static final VarHandle HERTZ;
    public static final VarHandle DAMPING_RATIO;
    public static final VarHandle ENABLE_LIMIT;
    public static final VarHandle LOWER_TRANSLATION;
    public static final VarHandle UPPER_TRANSLATION;
    public static final VarHandle ENABLE_MOTOR;
    public static final VarHandle MAX_MOTOR_TORQUE;
    public static final VarHandle MOTOR_SPEED;
    public static final VarHandle COLLIDE_CONNECTED;
    public static final VarHandle USER_DATA;
    public static final VarHandle INTERNAL_VALUE;

    public static final long BODY_ID_A_OFFSET;
    public static final long BODY_ID_B_OFFSET;
    public static final long LOCAL_ANCHOR_A_OFFSET;
    public static final long LOCAL_ANCHOR_B_OFFSET;
    public static final long LOCAL_AXIS_A_OFFSET;
    public static final long ENABLE_SPRING_OFFSET;
    public static final long HERTZ_OFFSET;
    public static final long DAMPING_RATIO_OFFSET;
    public static final long ENABLE_LIMIT_OFFSET;
    public static final long LOWER_TRANSLATION_OFFSET;
    public static final long UPPER_TRANSLATION_OFFSET;
    public static final long ENABLE_MOTOR_OFFSET;
    public static final long MAX_MOTOR_TORQUE_OFFSET;
    public static final long MOTOR_SPEED_OFFSET;
    public static final long COLLIDE_CONNECTED_OFFSET;
    public static final long USER_DATA_OFFSET;
    public static final long INTERNAL_VALUE_OFFSET;

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
        
        ENABLE_SPRING = LAYOUT.varHandle(PathElement.groupElement("enableSpring"));
        HERTZ = LAYOUT.varHandle(PathElement.groupElement("hertz"));
        DAMPING_RATIO = LAYOUT.varHandle(PathElement.groupElement("dampingRatio"));
        ENABLE_LIMIT = LAYOUT.varHandle(PathElement.groupElement("enableLimit"));
        LOWER_TRANSLATION = LAYOUT.varHandle(PathElement.groupElement("lowerTranslation"));
        UPPER_TRANSLATION = LAYOUT.varHandle(PathElement.groupElement("upperTranslation"));
        ENABLE_MOTOR = LAYOUT.varHandle(PathElement.groupElement("enableMotor"));
        MAX_MOTOR_TORQUE = LAYOUT.varHandle(PathElement.groupElement("maxMotorTorque"));
        MOTOR_SPEED = LAYOUT.varHandle(PathElement.groupElement("motorSpeed"));
        COLLIDE_CONNECTED = LAYOUT.varHandle(PathElement.groupElement("collideConnected"));
        USER_DATA = LAYOUT.varHandle(PathElement.groupElement("userData"));
        INTERNAL_VALUE = LAYOUT.varHandle(PathElement.groupElement("internalValue"));
        
        BODY_ID_A_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("bodyIdA"));
        BODY_ID_B_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("bodyIdB"));
        LOCAL_ANCHOR_A_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("localAnchorA"));
        LOCAL_ANCHOR_B_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("localAnchorB"));
        LOCAL_AXIS_A_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("localAxisA"));
        ENABLE_SPRING_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("enableSpring"));
        HERTZ_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("hertz"));
        DAMPING_RATIO_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("dampingRatio"));
        ENABLE_LIMIT_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("enableLimit"));
        LOWER_TRANSLATION_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("lowerTranslation"));
        UPPER_TRANSLATION_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("upperTranslation"));
        ENABLE_MOTOR_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("enableMotor"));
        MAX_MOTOR_TORQUE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("maxMotorTorque"));
        MOTOR_SPEED_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("motorSpeed"));
        COLLIDE_CONNECTED_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("collideConnected"));
        USER_DATA_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("userData"));
        INTERNAL_VALUE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("internalValue"));
        //@formatter:on
    }

    public WheelJointDef(MemorySegment segment) {
        this.segment = segment;
    
        bodyIdA = new BodyId(segment.asSlice(BODY_ID_A_OFFSET, BodyId.LAYOUT));
        bodyIdB = new BodyId(segment.asSlice(BODY_ID_B_OFFSET, BodyId.LAYOUT));
        localAnchorA = new Vec2(segment.asSlice(LOCAL_ANCHOR_A_OFFSET, Vec2.LAYOUT));
        localAnchorB = new Vec2(segment.asSlice(LOCAL_ANCHOR_B_OFFSET, Vec2.LAYOUT));
        localAxisA = new Vec2(segment.asSlice(LOCAL_AXIS_A_OFFSET, Vec2.LAYOUT));
    }

    /**
     * Use this to initialize your joint definition
     */
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
    
    /**
     * Typed method of {@link #ndefaultWheelJointDef}.
     */
    public static @Nullable WheelJointDef defaultWheelJointDef(
        SegmentAllocator allocator
    ) {
        MemorySegment segment = ndefaultWheelJointDef(allocator);
    
        if (segment.equals(MemorySegment.NULL))
            return null;
    
        return new WheelJointDef(segment);
    }
    
    public WheelJointDef enableSpring(boolean enableSpring) {
        ENABLE_SPRING.set(segment, 0L, enableSpring);
        return this;
    }
    
    public boolean enableSpring() {
        return (boolean) ENABLE_SPRING.get(segment, 0L);
    }
    
    public WheelJointDef hertz(float hertz) {
        HERTZ.set(segment, 0L, hertz);
        return this;
    }
    
    public float hertz() {
        return (float) HERTZ.get(segment, 0L);
    }
    
    public WheelJointDef dampingRatio(float dampingRatio) {
        DAMPING_RATIO.set(segment, 0L, dampingRatio);
        return this;
    }
    
    public float dampingRatio() {
        return (float) DAMPING_RATIO.get(segment, 0L);
    }
    
    public WheelJointDef enableLimit(boolean enableLimit) {
        ENABLE_LIMIT.set(segment, 0L, enableLimit);
        return this;
    }
    
    public boolean enableLimit() {
        return (boolean) ENABLE_LIMIT.get(segment, 0L);
    }
    
    public WheelJointDef lowerTranslation(float lowerTranslation) {
        LOWER_TRANSLATION.set(segment, 0L, lowerTranslation);
        return this;
    }
    
    public float lowerTranslation() {
        return (float) LOWER_TRANSLATION.get(segment, 0L);
    }
    
    public WheelJointDef upperTranslation(float upperTranslation) {
        UPPER_TRANSLATION.set(segment, 0L, upperTranslation);
        return this;
    }
    
    public float upperTranslation() {
        return (float) UPPER_TRANSLATION.get(segment, 0L);
    }
    
    public WheelJointDef enableMotor(boolean enableMotor) {
        ENABLE_MOTOR.set(segment, 0L, enableMotor);
        return this;
    }
    
    public boolean enableMotor() {
        return (boolean) ENABLE_MOTOR.get(segment, 0L);
    }
    
    public WheelJointDef maxMotorTorque(float maxMotorTorque) {
        MAX_MOTOR_TORQUE.set(segment, 0L, maxMotorTorque);
        return this;
    }
    
    public float maxMotorTorque() {
        return (float) MAX_MOTOR_TORQUE.get(segment, 0L);
    }
    
    public WheelJointDef motorSpeed(float motorSpeed) {
        MOTOR_SPEED.set(segment, 0L, motorSpeed);
        return this;
    }
    
    public float motorSpeed() {
        return (float) MOTOR_SPEED.get(segment, 0L);
    }
    
    public WheelJointDef collideConnected(boolean collideConnected) {
        COLLIDE_CONNECTED.set(segment, 0L, collideConnected);
        return this;
    }
    
    public boolean collideConnected() {
        return (boolean) COLLIDE_CONNECTED.get(segment, 0L);
    }
    
    public WheelJointDef userData(MemorySegment userData) {
        USER_DATA.set(segment, 0L, userData);
        return this;
    }
    
    public @Nullable MemorySegment userData() {
        MemorySegment segment = (MemorySegment) USER_DATA.get(this.segment, 0L);
    
        if (segment.equals(MemorySegment.NULL))
            return null;
    
        return segment;
    }
    
    public WheelJointDef internalValue(int internalValue) {
        INTERNAL_VALUE.set(segment, 0L, internalValue);
        return this;
    }
    
    public int internalValue() {
        return (int) INTERNAL_VALUE.get(segment, 0L);
    }
    
    public WheelJointDef bodyIdA(Consumer<BodyId> consumer) {
        consumer.accept(bodyIdA);
        return this;
    }
    
    public WheelJointDef bodyIdA(BodyId other) {
        bodyIdA.set(other);
        return this;
    }
    
    public BodyId bodyIdA() {
        return bodyIdA;
    }
    
    public WheelJointDef bodyIdB(Consumer<BodyId> consumer) {
        consumer.accept(bodyIdB);
        return this;
    }
    
    public WheelJointDef bodyIdB(BodyId other) {
        bodyIdB.set(other);
        return this;
    }
    
    public BodyId bodyIdB() {
        return bodyIdB;
    }
    
    public WheelJointDef localAnchorA(Consumer<Vec2> consumer) {
        consumer.accept(localAnchorA);
        return this;
    }
    
    public WheelJointDef localAnchorA(Vec2 other) {
        localAnchorA.set(other);
        return this;
    }
    
    public Vec2 localAnchorA() {
        return localAnchorA;
    }
    
    public WheelJointDef localAnchorB(Consumer<Vec2> consumer) {
        consumer.accept(localAnchorB);
        return this;
    }
    
    public WheelJointDef localAnchorB(Vec2 other) {
        localAnchorB.set(other);
        return this;
    }
    
    public Vec2 localAnchorB() {
        return localAnchorB;
    }
    
    public WheelJointDef localAxisA(Consumer<Vec2> consumer) {
        consumer.accept(localAxisA);
        return this;
    }
    
    public WheelJointDef localAxisA(Vec2 other) {
        localAxisA.set(other);
        return this;
    }
    
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