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
 * Revolute joint definition
 */
public final class RevoluteJointDef
		implements Struct<RevoluteJointDef> {

    private static final LazyConstant<MethodHandle> B2_DEFAULT_REVOLUTE_JOINT_DEF;

    public static final StructLayout LAYOUT;

    public static final VarHandle REFERENCE_ANGLE_HANDLE;
    public static final VarHandle TARGET_ANGLE_HANDLE;
    public static final VarHandle ENABLE_SPRING_HANDLE;
    public static final VarHandle HERTZ_HANDLE;
    public static final VarHandle DAMPING_RATIO_HANDLE;
    public static final VarHandle ENABLE_LIMIT_HANDLE;
    public static final VarHandle LOWER_ANGLE_HANDLE;
    public static final VarHandle UPPER_ANGLE_HANDLE;
    public static final VarHandle ENABLE_MOTOR_HANDLE;
    public static final VarHandle MAX_MOTOR_TORQUE_HANDLE;
    public static final VarHandle MOTOR_SPEED_HANDLE;
    public static final VarHandle DRAW_SIZE_HANDLE;
    public static final VarHandle COLLIDE_CONNECTED_HANDLE;
    public static final VarHandle USER_DATA_HANDLE;
    public static final VarHandle INTERNAL_VALUE_HANDLE;

    public static final long BODY_ID_A_BYTE_OFFSET;
    public static final long BODY_ID_B_BYTE_OFFSET;
    public static final long LOCAL_ANCHOR_A_BYTE_OFFSET;
    public static final long LOCAL_ANCHOR_B_BYTE_OFFSET;
    public static final long REFERENCE_ANGLE_BYTE_OFFSET;
    public static final long TARGET_ANGLE_BYTE_OFFSET;
    public static final long ENABLE_SPRING_BYTE_OFFSET;
    public static final long HERTZ_BYTE_OFFSET;
    public static final long DAMPING_RATIO_BYTE_OFFSET;
    public static final long ENABLE_LIMIT_BYTE_OFFSET;
    public static final long LOWER_ANGLE_BYTE_OFFSET;
    public static final long UPPER_ANGLE_BYTE_OFFSET;
    public static final long ENABLE_MOTOR_BYTE_OFFSET;
    public static final long MAX_MOTOR_TORQUE_BYTE_OFFSET;
    public static final long MOTOR_SPEED_BYTE_OFFSET;
    public static final long DRAW_SIZE_BYTE_OFFSET;
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
            JAVA_FLOAT.withName("referenceAngle"),
            JAVA_FLOAT.withName("targetAngle"),
            JAVA_BOOLEAN.withName("enableSpring"),
            MemoryLayout.paddingLayout(3),
            JAVA_FLOAT.withName("hertz"),
            JAVA_FLOAT.withName("dampingRatio"),
            JAVA_BOOLEAN.withName("enableLimit"),
            MemoryLayout.paddingLayout(3),
            JAVA_FLOAT.withName("lowerAngle"),
            JAVA_FLOAT.withName("upperAngle"),
            JAVA_BOOLEAN.withName("enableMotor"),
            MemoryLayout.paddingLayout(3),
            JAVA_FLOAT.withName("maxMotorTorque"),
            JAVA_FLOAT.withName("motorSpeed"),
            JAVA_FLOAT.withName("drawSize"),
            JAVA_BOOLEAN.withName("collideConnected"),
            MemoryLayout.paddingLayout(7),
            UNBOUNDED_ADDRESS.withName("userData"),
            JAVA_INT.withName("internalValue"),
            MemoryLayout.paddingLayout(4)
        ).withName("b2RevoluteJointDef").withByteAlignment(8);
        
        B2_DEFAULT_REVOLUTE_JOINT_DEF = downcallHandle("b2DefaultRevoluteJointDef", RevoluteJointDef.LAYOUT);
        
        REFERENCE_ANGLE_HANDLE = LAYOUT.varHandle(PathElement.groupElement("referenceAngle"));
        TARGET_ANGLE_HANDLE = LAYOUT.varHandle(PathElement.groupElement("targetAngle"));
        ENABLE_SPRING_HANDLE = LAYOUT.varHandle(PathElement.groupElement("enableSpring"));
        HERTZ_HANDLE = LAYOUT.varHandle(PathElement.groupElement("hertz"));
        DAMPING_RATIO_HANDLE = LAYOUT.varHandle(PathElement.groupElement("dampingRatio"));
        ENABLE_LIMIT_HANDLE = LAYOUT.varHandle(PathElement.groupElement("enableLimit"));
        LOWER_ANGLE_HANDLE = LAYOUT.varHandle(PathElement.groupElement("lowerAngle"));
        UPPER_ANGLE_HANDLE = LAYOUT.varHandle(PathElement.groupElement("upperAngle"));
        ENABLE_MOTOR_HANDLE = LAYOUT.varHandle(PathElement.groupElement("enableMotor"));
        MAX_MOTOR_TORQUE_HANDLE = LAYOUT.varHandle(PathElement.groupElement("maxMotorTorque"));
        MOTOR_SPEED_HANDLE = LAYOUT.varHandle(PathElement.groupElement("motorSpeed"));
        DRAW_SIZE_HANDLE = LAYOUT.varHandle(PathElement.groupElement("drawSize"));
        COLLIDE_CONNECTED_HANDLE = LAYOUT.varHandle(PathElement.groupElement("collideConnected"));
        USER_DATA_HANDLE = LAYOUT.varHandle(PathElement.groupElement("userData"));
        INTERNAL_VALUE_HANDLE = LAYOUT.varHandle(PathElement.groupElement("internalValue"));
        
        BODY_ID_A_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("bodyIdA"));
        BODY_ID_B_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("bodyIdB"));
        LOCAL_ANCHOR_A_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("localAnchorA"));
        LOCAL_ANCHOR_B_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("localAnchorB"));
        REFERENCE_ANGLE_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("referenceAngle"));
        TARGET_ANGLE_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("targetAngle"));
        ENABLE_SPRING_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("enableSpring"));
        HERTZ_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("hertz"));
        DAMPING_RATIO_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("dampingRatio"));
        ENABLE_LIMIT_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("enableLimit"));
        LOWER_ANGLE_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("lowerAngle"));
        UPPER_ANGLE_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("upperAngle"));
        ENABLE_MOTOR_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("enableMotor"));
        MAX_MOTOR_TORQUE_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("maxMotorTorque"));
        MOTOR_SPEED_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("motorSpeed"));
        DRAW_SIZE_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("drawSize"));
        COLLIDE_CONNECTED_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("collideConnected"));
        USER_DATA_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("userData"));
        INTERNAL_VALUE_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("internalValue"));
        //@formatter:on
    }

    public RevoluteJointDef(MemorySegment segment) {
        this.segment = segment;
    
        bodyIdA = new BodyId(segment.asSlice(BODY_ID_A_BYTE_OFFSET, BodyId.LAYOUT));
        bodyIdB = new BodyId(segment.asSlice(BODY_ID_B_BYTE_OFFSET, BodyId.LAYOUT));
        localAnchorA = new Vec2(segment.asSlice(LOCAL_ANCHOR_A_BYTE_OFFSET, Vec2.LAYOUT));
        localAnchorB = new Vec2(segment.asSlice(LOCAL_ANCHOR_B_BYTE_OFFSET, Vec2.LAYOUT));
    }

    /**
     * Use this to initialize your joint definition.
     */
    public static MemorySegment ndefaultRevoluteJointDef(
        SegmentAllocator allocator
    ) {
        MethodHandle method = B2_DEFAULT_REVOLUTE_JOINT_DEF.get();
        try {
            return (MemorySegment) method.invokeExact(
                allocator
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #ndefaultRevoluteJointDef}.
     */
    public static @Nullable RevoluteJointDef defaultRevoluteJointDef(
        SegmentAllocator allocator
    ) {
        MemorySegment segment = ndefaultRevoluteJointDef(allocator);
    
        if (segment.equals(MemorySegment.NULL))
            return null;
    
        return new RevoluteJointDef(segment);
    }
    
    public RevoluteJointDef referenceAngle(float referenceAngle) {
        REFERENCE_ANGLE_HANDLE.set(segment, 0L, referenceAngle);
        return this;
    }
    
    public float referenceAngle() {
        return (float) REFERENCE_ANGLE_HANDLE.get(segment, 0L);
    }
    
    public RevoluteJointDef targetAngle(float targetAngle) {
        TARGET_ANGLE_HANDLE.set(segment, 0L, targetAngle);
        return this;
    }
    
    public float targetAngle() {
        return (float) TARGET_ANGLE_HANDLE.get(segment, 0L);
    }
    
    public RevoluteJointDef enableSpring(boolean enableSpring) {
        ENABLE_SPRING_HANDLE.set(segment, 0L, enableSpring);
        return this;
    }
    
    public boolean enableSpring() {
        return (boolean) ENABLE_SPRING_HANDLE.get(segment, 0L);
    }
    
    public RevoluteJointDef hertz(float hertz) {
        HERTZ_HANDLE.set(segment, 0L, hertz);
        return this;
    }
    
    public float hertz() {
        return (float) HERTZ_HANDLE.get(segment, 0L);
    }
    
    public RevoluteJointDef dampingRatio(float dampingRatio) {
        DAMPING_RATIO_HANDLE.set(segment, 0L, dampingRatio);
        return this;
    }
    
    public float dampingRatio() {
        return (float) DAMPING_RATIO_HANDLE.get(segment, 0L);
    }
    
    public RevoluteJointDef enableLimit(boolean enableLimit) {
        ENABLE_LIMIT_HANDLE.set(segment, 0L, enableLimit);
        return this;
    }
    
    public boolean enableLimit() {
        return (boolean) ENABLE_LIMIT_HANDLE.get(segment, 0L);
    }
    
    public RevoluteJointDef lowerAngle(float lowerAngle) {
        LOWER_ANGLE_HANDLE.set(segment, 0L, lowerAngle);
        return this;
    }
    
    public float lowerAngle() {
        return (float) LOWER_ANGLE_HANDLE.get(segment, 0L);
    }
    
    public RevoluteJointDef upperAngle(float upperAngle) {
        UPPER_ANGLE_HANDLE.set(segment, 0L, upperAngle);
        return this;
    }
    
    public float upperAngle() {
        return (float) UPPER_ANGLE_HANDLE.get(segment, 0L);
    }
    
    public RevoluteJointDef enableMotor(boolean enableMotor) {
        ENABLE_MOTOR_HANDLE.set(segment, 0L, enableMotor);
        return this;
    }
    
    public boolean enableMotor() {
        return (boolean) ENABLE_MOTOR_HANDLE.get(segment, 0L);
    }
    
    public RevoluteJointDef maxMotorTorque(float maxMotorTorque) {
        MAX_MOTOR_TORQUE_HANDLE.set(segment, 0L, maxMotorTorque);
        return this;
    }
    
    public float maxMotorTorque() {
        return (float) MAX_MOTOR_TORQUE_HANDLE.get(segment, 0L);
    }
    
    public RevoluteJointDef motorSpeed(float motorSpeed) {
        MOTOR_SPEED_HANDLE.set(segment, 0L, motorSpeed);
        return this;
    }
    
    public float motorSpeed() {
        return (float) MOTOR_SPEED_HANDLE.get(segment, 0L);
    }
    
    public RevoluteJointDef drawSize(float drawSize) {
        DRAW_SIZE_HANDLE.set(segment, 0L, drawSize);
        return this;
    }
    
    public float drawSize() {
        return (float) DRAW_SIZE_HANDLE.get(segment, 0L);
    }
    
    public RevoluteJointDef collideConnected(boolean collideConnected) {
        COLLIDE_CONNECTED_HANDLE.set(segment, 0L, collideConnected);
        return this;
    }
    
    public boolean collideConnected() {
        return (boolean) COLLIDE_CONNECTED_HANDLE.get(segment, 0L);
    }
    
    public RevoluteJointDef userData(MemorySegment userData) {
        USER_DATA_HANDLE.set(segment, 0L, userData);
        return this;
    }
    
    public @Nullable MemorySegment userData() {
        MemorySegment segment = (MemorySegment) USER_DATA_HANDLE.get(this.segment, 0L);
    
        if (segment.equals(MemorySegment.NULL))
            return null;
    
        return segment;
    }
    
    public RevoluteJointDef internalValue(int internalValue) {
        INTERNAL_VALUE_HANDLE.set(segment, 0L, internalValue);
        return this;
    }
    
    public int internalValue() {
        return (int) INTERNAL_VALUE_HANDLE.get(segment, 0L);
    }
    
    public RevoluteJointDef bodyIdA(Consumer<BodyId> consumer) {
        consumer.accept(bodyIdA);
        return this;
    }
    
    public RevoluteJointDef bodyIdA(BodyId other) {
        bodyIdA.set(other);
        return this;
    }
    
    public BodyId bodyIdA() {
        return bodyIdA;
    }
    
    public RevoluteJointDef bodyIdB(Consumer<BodyId> consumer) {
        consumer.accept(bodyIdB);
        return this;
    }
    
    public RevoluteJointDef bodyIdB(BodyId other) {
        bodyIdB.set(other);
        return this;
    }
    
    public BodyId bodyIdB() {
        return bodyIdB;
    }
    
    public RevoluteJointDef localAnchorA(Consumer<Vec2> consumer) {
        consumer.accept(localAnchorA);
        return this;
    }
    
    public RevoluteJointDef localAnchorA(Vec2 other) {
        localAnchorA.set(other);
        return this;
    }
    
    public Vec2 localAnchorA() {
        return localAnchorA;
    }
    
    public RevoluteJointDef localAnchorB(Consumer<Vec2> consumer) {
        consumer.accept(localAnchorB);
        return this;
    }
    
    public RevoluteJointDef localAnchorB(Vec2 other) {
        localAnchorB.set(other);
        return this;
    }
    
    public Vec2 localAnchorB() {
        return localAnchorB;
    }
    
    @Override
    public RevoluteJointDef set(RevoluteJointDef other) {
        return set(other.segment);
    }
    
    @Override
    public RevoluteJointDef set(MemorySegment src) {
        MemorySegment.copy(src, 0L, segment, 0L, LAYOUT.byteSize());
        return this;
    }
    
    @Override
    public MemorySegment memorySegment() {
        return segment;
    }
    
    public NativeStructArray<RevoluteJointDef> asArray() {
        return new NativeStructArray<>(this);
    }
    
    public static NativeStructArray<RevoluteJointDef> array(Arena arena, int count) {
        return new NativeStructArray<>(
            arena,
            LAYOUT,
            segment -> new RevoluteJointDef(segment),
            count
        );
    }
    
    public static NativeStructArray<RevoluteJointDef> array(Arena arena, RevoluteJointDef... structs) {
        NativeStructArray<RevoluteJointDef> array = new NativeStructArray<>(
            arena,
            LAYOUT,
            segment -> new RevoluteJointDef(segment),
            structs.length
        );
    
        for (int i = 0; i < structs.length; i++) {
            array.set(i, structs[i]);
        }
    
        return array;
    }
    
    public static NativeStructArray<RevoluteJointDef> array(MemorySegment array) {
        return new NativeStructArray<>(
            array,
            LAYOUT,
            segment -> new RevoluteJointDef(segment)
        );
    }
    
}