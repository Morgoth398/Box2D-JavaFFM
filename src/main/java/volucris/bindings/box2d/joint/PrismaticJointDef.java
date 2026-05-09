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
 * Prismatic joint definition
 */
public final class PrismaticJointDef
		implements Struct<PrismaticJointDef> {

    private static final LazyConstant<MethodHandle> B2_DEFAULT_PRISMATIC_JOINT_DEF;

    public static final StructLayout LAYOUT;

    public static final VarHandle REFERENCE_ANGLE_HANDLE;
    public static final VarHandle TARGET_TRANSLATION_HANDLE;
    public static final VarHandle ENABLE_SPRING_HANDLE;
    public static final VarHandle HERTZ_HANDLE;
    public static final VarHandle DAMPING_RATIO_HANDLE;
    public static final VarHandle ENABLE_LIMIT_HANDLE;
    public static final VarHandle LOWER_TRANSLATION_HANDLE;
    public static final VarHandle UPPER_TRANSLATION_HANDLE;
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
    public static final long LOCAL_AXIS_A_BYTE_OFFSET;
    public static final long REFERENCE_ANGLE_BYTE_OFFSET;
    public static final long TARGET_TRANSLATION_BYTE_OFFSET;
    public static final long ENABLE_SPRING_BYTE_OFFSET;
    public static final long HERTZ_BYTE_OFFSET;
    public static final long DAMPING_RATIO_BYTE_OFFSET;
    public static final long ENABLE_LIMIT_BYTE_OFFSET;
    public static final long LOWER_TRANSLATION_BYTE_OFFSET;
    public static final long UPPER_TRANSLATION_BYTE_OFFSET;
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
    private final Vec2 localAxisA;

    static {
        //@formatter:off
        LAYOUT = MemoryLayout.structLayout(
            BodyId.LAYOUT.withName("bodyIdA"),
            BodyId.LAYOUT.withName("bodyIdB"),
            Vec2.LAYOUT.withName("localAnchorA"),
            Vec2.LAYOUT.withName("localAnchorB"),
            Vec2.LAYOUT.withName("localAxisA"),
            JAVA_FLOAT.withName("referenceAngle"),
            JAVA_FLOAT.withName("targetTranslation"),
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
            JAVA_FLOAT.withName("maxMotorForce"),
            JAVA_FLOAT.withName("motorSpeed"),
            JAVA_BOOLEAN.withName("collideConnected"),
            MemoryLayout.paddingLayout(3),
            UNBOUNDED_ADDRESS.withName("userData"),
            JAVA_INT.withName("internalValue"),
            MemoryLayout.paddingLayout(4)
        ).withName("b2PrismaticJointDef").withByteAlignment(8);
        
        B2_DEFAULT_PRISMATIC_JOINT_DEF = downcallHandle("b2DefaultPrismaticJointDef", PrismaticJointDef.LAYOUT);
        
        REFERENCE_ANGLE_HANDLE = LAYOUT.varHandle(PathElement.groupElement("referenceAngle"));
        TARGET_TRANSLATION_HANDLE = LAYOUT.varHandle(PathElement.groupElement("targetTranslation"));
        ENABLE_SPRING_HANDLE = LAYOUT.varHandle(PathElement.groupElement("enableSpring"));
        HERTZ_HANDLE = LAYOUT.varHandle(PathElement.groupElement("hertz"));
        DAMPING_RATIO_HANDLE = LAYOUT.varHandle(PathElement.groupElement("dampingRatio"));
        ENABLE_LIMIT_HANDLE = LAYOUT.varHandle(PathElement.groupElement("enableLimit"));
        LOWER_TRANSLATION_HANDLE = LAYOUT.varHandle(PathElement.groupElement("lowerTranslation"));
        UPPER_TRANSLATION_HANDLE = LAYOUT.varHandle(PathElement.groupElement("upperTranslation"));
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
        LOCAL_AXIS_A_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("localAxisA"));
        REFERENCE_ANGLE_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("referenceAngle"));
        TARGET_TRANSLATION_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("targetTranslation"));
        ENABLE_SPRING_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("enableSpring"));
        HERTZ_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("hertz"));
        DAMPING_RATIO_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("dampingRatio"));
        ENABLE_LIMIT_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("enableLimit"));
        LOWER_TRANSLATION_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("lowerTranslation"));
        UPPER_TRANSLATION_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("upperTranslation"));
        ENABLE_MOTOR_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("enableMotor"));
        MAX_MOTOR_FORCE_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("maxMotorForce"));
        MOTOR_SPEED_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("motorSpeed"));
        COLLIDE_CONNECTED_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("collideConnected"));
        USER_DATA_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("userData"));
        INTERNAL_VALUE_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("internalValue"));
        //@formatter:on
    }

    public PrismaticJointDef(MemorySegment segment) {
        this.segment = segment;
    
        bodyIdA = new BodyId(segment.asSlice(BODY_ID_A_BYTE_OFFSET, BodyId.LAYOUT));
        bodyIdB = new BodyId(segment.asSlice(BODY_ID_B_BYTE_OFFSET, BodyId.LAYOUT));
        localAnchorA = new Vec2(segment.asSlice(LOCAL_ANCHOR_A_BYTE_OFFSET, Vec2.LAYOUT));
        localAnchorB = new Vec2(segment.asSlice(LOCAL_ANCHOR_B_BYTE_OFFSET, Vec2.LAYOUT));
        localAxisA = new Vec2(segment.asSlice(LOCAL_AXIS_A_BYTE_OFFSET, Vec2.LAYOUT));
    }

    /**
     * Use this to initialize your joint definition
     */
    public static MemorySegment ndefaultPrismaticJointDef(
        SegmentAllocator allocator
    ) {
        MethodHandle method = B2_DEFAULT_PRISMATIC_JOINT_DEF.get();
        try {
            return (MemorySegment) method.invokeExact(
                allocator
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #ndefaultPrismaticJointDef}.
     */
    public static @Nullable PrismaticJointDef defaultPrismaticJointDef(
        SegmentAllocator allocator
    ) {
        MemorySegment segment = ndefaultPrismaticJointDef(allocator);
    
        if (segment.equals(MemorySegment.NULL))
            return null;
    
        return new PrismaticJointDef(segment);
    }
    
    public PrismaticJointDef referenceAngle(float referenceAngle) {
        REFERENCE_ANGLE_HANDLE.set(segment, 0L, referenceAngle);
        return this;
    }
    
    public float referenceAngle() {
        return (float) REFERENCE_ANGLE_HANDLE.get(segment, 0L);
    }
    
    public PrismaticJointDef targetTranslation(float targetTranslation) {
        TARGET_TRANSLATION_HANDLE.set(segment, 0L, targetTranslation);
        return this;
    }
    
    public float targetTranslation() {
        return (float) TARGET_TRANSLATION_HANDLE.get(segment, 0L);
    }
    
    public PrismaticJointDef enableSpring(boolean enableSpring) {
        ENABLE_SPRING_HANDLE.set(segment, 0L, enableSpring);
        return this;
    }
    
    public boolean enableSpring() {
        return (boolean) ENABLE_SPRING_HANDLE.get(segment, 0L);
    }
    
    public PrismaticJointDef hertz(float hertz) {
        HERTZ_HANDLE.set(segment, 0L, hertz);
        return this;
    }
    
    public float hertz() {
        return (float) HERTZ_HANDLE.get(segment, 0L);
    }
    
    public PrismaticJointDef dampingRatio(float dampingRatio) {
        DAMPING_RATIO_HANDLE.set(segment, 0L, dampingRatio);
        return this;
    }
    
    public float dampingRatio() {
        return (float) DAMPING_RATIO_HANDLE.get(segment, 0L);
    }
    
    public PrismaticJointDef enableLimit(boolean enableLimit) {
        ENABLE_LIMIT_HANDLE.set(segment, 0L, enableLimit);
        return this;
    }
    
    public boolean enableLimit() {
        return (boolean) ENABLE_LIMIT_HANDLE.get(segment, 0L);
    }
    
    public PrismaticJointDef lowerTranslation(float lowerTranslation) {
        LOWER_TRANSLATION_HANDLE.set(segment, 0L, lowerTranslation);
        return this;
    }
    
    public float lowerTranslation() {
        return (float) LOWER_TRANSLATION_HANDLE.get(segment, 0L);
    }
    
    public PrismaticJointDef upperTranslation(float upperTranslation) {
        UPPER_TRANSLATION_HANDLE.set(segment, 0L, upperTranslation);
        return this;
    }
    
    public float upperTranslation() {
        return (float) UPPER_TRANSLATION_HANDLE.get(segment, 0L);
    }
    
    public PrismaticJointDef enableMotor(boolean enableMotor) {
        ENABLE_MOTOR_HANDLE.set(segment, 0L, enableMotor);
        return this;
    }
    
    public boolean enableMotor() {
        return (boolean) ENABLE_MOTOR_HANDLE.get(segment, 0L);
    }
    
    public PrismaticJointDef maxMotorForce(float maxMotorForce) {
        MAX_MOTOR_FORCE_HANDLE.set(segment, 0L, maxMotorForce);
        return this;
    }
    
    public float maxMotorForce() {
        return (float) MAX_MOTOR_FORCE_HANDLE.get(segment, 0L);
    }
    
    public PrismaticJointDef motorSpeed(float motorSpeed) {
        MOTOR_SPEED_HANDLE.set(segment, 0L, motorSpeed);
        return this;
    }
    
    public float motorSpeed() {
        return (float) MOTOR_SPEED_HANDLE.get(segment, 0L);
    }
    
    public PrismaticJointDef collideConnected(boolean collideConnected) {
        COLLIDE_CONNECTED_HANDLE.set(segment, 0L, collideConnected);
        return this;
    }
    
    public boolean collideConnected() {
        return (boolean) COLLIDE_CONNECTED_HANDLE.get(segment, 0L);
    }
    
    public PrismaticJointDef userData(MemorySegment userData) {
        USER_DATA_HANDLE.set(segment, 0L, userData);
        return this;
    }
    
    public @Nullable MemorySegment userData() {
        MemorySegment segment = (MemorySegment) USER_DATA_HANDLE.get(this.segment, 0L);
    
        if (segment.equals(MemorySegment.NULL))
            return null;
    
        return segment;
    }
    
    public PrismaticJointDef internalValue(int internalValue) {
        INTERNAL_VALUE_HANDLE.set(segment, 0L, internalValue);
        return this;
    }
    
    public int internalValue() {
        return (int) INTERNAL_VALUE_HANDLE.get(segment, 0L);
    }
    
    public PrismaticJointDef bodyIdA(Consumer<BodyId> consumer) {
        consumer.accept(bodyIdA);
        return this;
    }
    
    public PrismaticJointDef bodyIdA(BodyId other) {
        bodyIdA.set(other);
        return this;
    }
    
    public BodyId bodyIdA() {
        return bodyIdA;
    }
    
    public PrismaticJointDef bodyIdB(Consumer<BodyId> consumer) {
        consumer.accept(bodyIdB);
        return this;
    }
    
    public PrismaticJointDef bodyIdB(BodyId other) {
        bodyIdB.set(other);
        return this;
    }
    
    public BodyId bodyIdB() {
        return bodyIdB;
    }
    
    public PrismaticJointDef localAnchorA(Consumer<Vec2> consumer) {
        consumer.accept(localAnchorA);
        return this;
    }
    
    public PrismaticJointDef localAnchorA(Vec2 other) {
        localAnchorA.set(other);
        return this;
    }
    
    public Vec2 localAnchorA() {
        return localAnchorA;
    }
    
    public PrismaticJointDef localAnchorB(Consumer<Vec2> consumer) {
        consumer.accept(localAnchorB);
        return this;
    }
    
    public PrismaticJointDef localAnchorB(Vec2 other) {
        localAnchorB.set(other);
        return this;
    }
    
    public Vec2 localAnchorB() {
        return localAnchorB;
    }
    
    public PrismaticJointDef localAxisA(Consumer<Vec2> consumer) {
        consumer.accept(localAxisA);
        return this;
    }
    
    public PrismaticJointDef localAxisA(Vec2 other) {
        localAxisA.set(other);
        return this;
    }
    
    public Vec2 localAxisA() {
        return localAxisA;
    }
    
    @Override
    public PrismaticJointDef set(PrismaticJointDef other) {
        return set(other.segment);
    }
    
    @Override
    public PrismaticJointDef set(MemorySegment src) {
        MemorySegment.copy(src, 0L, segment, 0L, LAYOUT.byteSize());
        return this;
    }
    
    @Override
    public MemorySegment memorySegment() {
        return segment;
    }
    
    public NativeStructArray<PrismaticJointDef> asArray() {
        return new NativeStructArray<>(this);
    }
    
    public static NativeStructArray<PrismaticJointDef> array(Arena arena, int count) {
        return new NativeStructArray<>(
            arena,
            LAYOUT,
            segment -> new PrismaticJointDef(segment),
            count
        );
    }
    
    public static NativeStructArray<PrismaticJointDef> array(Arena arena, PrismaticJointDef... structs) {
        NativeStructArray<PrismaticJointDef> array = new NativeStructArray<>(
            arena,
            LAYOUT,
            segment -> new PrismaticJointDef(segment),
            structs.length
        );
    
        for (int i = 0; i < structs.length; i++) {
            array.set(i, structs[i]);
        }
    
        return array;
    }
    
    public static NativeStructArray<PrismaticJointDef> array(MemorySegment array) {
        return new NativeStructArray<>(
            array,
            LAYOUT,
            segment -> new PrismaticJointDef(segment)
        );
    }
    
}