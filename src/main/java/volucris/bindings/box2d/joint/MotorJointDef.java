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
 * A motor joint is used to control the relative motion between two bodies
 */
public final class MotorJointDef
		implements Struct<MotorJointDef> {

    private static final LazyConstant<MethodHandle> B2_DEFAULT_MOTOR_JOINT_DEF;

    public static final StructLayout LAYOUT;

    public static final VarHandle ANGULAR_OFFSET;
    public static final VarHandle MAX_FORCE;
    public static final VarHandle MAX_TORQUE;
    public static final VarHandle CORRECTION_FACTOR;
    public static final VarHandle COLLIDE_CONNECTED;
    public static final VarHandle USER_DATA;
    public static final VarHandle INTERNAL_VALUE;

    public static final long BODY_ID_A_OFFSET;
    public static final long BODY_ID_B_OFFSET;
    public static final long LINEAR_OFFSET_OFFSET;
    public static final long ANGULAR_OFFSET_OFFSET;
    public static final long MAX_FORCE_OFFSET;
    public static final long MAX_TORQUE_OFFSET;
    public static final long CORRECTION_FACTOR_OFFSET;
    public static final long COLLIDE_CONNECTED_OFFSET;
    public static final long USER_DATA_OFFSET;
    public static final long INTERNAL_VALUE_OFFSET;

    private final MemorySegment segment;

    private final BodyId bodyIdA;
    private final BodyId bodyIdB;
    private final Vec2 linearOffset;

    static {
        //@formatter:off
        LAYOUT = MemoryLayout.structLayout(
            BodyId.LAYOUT.withName("bodyIdA"),
            BodyId.LAYOUT.withName("bodyIdB"),
            Vec2.LAYOUT.withName("linearOffset"),
            JAVA_FLOAT.withName("angularOffset"),
            JAVA_FLOAT.withName("maxForce"),
            JAVA_FLOAT.withName("maxTorque"),
            JAVA_FLOAT.withName("correctionFactor"),
            JAVA_BOOLEAN.withName("collideConnected"),
            MemoryLayout.paddingLayout(7),
            UNBOUNDED_ADDRESS.withName("userData"),
            JAVA_INT.withName("internalValue"),
            MemoryLayout.paddingLayout(4)
        ).withName("b2MotorJointDef").withByteAlignment(8);
        
        B2_DEFAULT_MOTOR_JOINT_DEF = downcallHandle("b2DefaultMotorJointDef", MotorJointDef.LAYOUT);
        
        ANGULAR_OFFSET = LAYOUT.varHandle(PathElement.groupElement("angularOffset"));
        MAX_FORCE = LAYOUT.varHandle(PathElement.groupElement("maxForce"));
        MAX_TORQUE = LAYOUT.varHandle(PathElement.groupElement("maxTorque"));
        CORRECTION_FACTOR = LAYOUT.varHandle(PathElement.groupElement("correctionFactor"));
        COLLIDE_CONNECTED = LAYOUT.varHandle(PathElement.groupElement("collideConnected"));
        USER_DATA = LAYOUT.varHandle(PathElement.groupElement("userData"));
        INTERNAL_VALUE = LAYOUT.varHandle(PathElement.groupElement("internalValue"));
        
        BODY_ID_A_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("bodyIdA"));
        BODY_ID_B_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("bodyIdB"));
        LINEAR_OFFSET_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("linearOffset"));
        ANGULAR_OFFSET_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("angularOffset"));
        MAX_FORCE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("maxForce"));
        MAX_TORQUE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("maxTorque"));
        CORRECTION_FACTOR_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("correctionFactor"));
        COLLIDE_CONNECTED_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("collideConnected"));
        USER_DATA_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("userData"));
        INTERNAL_VALUE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("internalValue"));
        //@formatter:on
    }

    public MotorJointDef(MemorySegment segment) {
        this.segment = segment;
    
        bodyIdA = new BodyId(segment.asSlice(BODY_ID_A_OFFSET, BodyId.LAYOUT));
        bodyIdB = new BodyId(segment.asSlice(BODY_ID_B_OFFSET, BodyId.LAYOUT));
        linearOffset = new Vec2(segment.asSlice(LINEAR_OFFSET_OFFSET, Vec2.LAYOUT));
    }

    /**
     * Use this to initialize your joint definition
     */
    public static MemorySegment ndefaultMotorJointDef(
        SegmentAllocator allocator
    ) {
        MethodHandle method = B2_DEFAULT_MOTOR_JOINT_DEF.get();
        try {
            return (MemorySegment) method.invokeExact(
                allocator
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #ndefaultMotorJointDef}.
     */
    public static @Nullable MotorJointDef defaultMotorJointDef(
        SegmentAllocator allocator
    ) {
        MemorySegment segment = ndefaultMotorJointDef(allocator);
    
        if (segment.equals(MemorySegment.NULL))
            return null;
    
        return new MotorJointDef(segment);
    }
    
    public MotorJointDef angularOffset(float angularOffset) {
        ANGULAR_OFFSET.set(segment, 0L, angularOffset);
        return this;
    }
    
    public float angularOffset() {
        return (float) ANGULAR_OFFSET.get(segment, 0L);
    }
    
    public MotorJointDef maxForce(float maxForce) {
        MAX_FORCE.set(segment, 0L, maxForce);
        return this;
    }
    
    public float maxForce() {
        return (float) MAX_FORCE.get(segment, 0L);
    }
    
    public MotorJointDef maxTorque(float maxTorque) {
        MAX_TORQUE.set(segment, 0L, maxTorque);
        return this;
    }
    
    public float maxTorque() {
        return (float) MAX_TORQUE.get(segment, 0L);
    }
    
    public MotorJointDef correctionFactor(float correctionFactor) {
        CORRECTION_FACTOR.set(segment, 0L, correctionFactor);
        return this;
    }
    
    public float correctionFactor() {
        return (float) CORRECTION_FACTOR.get(segment, 0L);
    }
    
    public MotorJointDef collideConnected(boolean collideConnected) {
        COLLIDE_CONNECTED.set(segment, 0L, collideConnected);
        return this;
    }
    
    public boolean collideConnected() {
        return (boolean) COLLIDE_CONNECTED.get(segment, 0L);
    }
    
    public MotorJointDef userData(MemorySegment userData) {
        USER_DATA.set(segment, 0L, userData);
        return this;
    }
    
    public @Nullable MemorySegment userData() {
        MemorySegment segment = (MemorySegment) USER_DATA.get(this.segment, 0L);
    
        if (segment.equals(MemorySegment.NULL))
            return null;
    
        return segment;
    }
    
    public MotorJointDef internalValue(int internalValue) {
        INTERNAL_VALUE.set(segment, 0L, internalValue);
        return this;
    }
    
    public int internalValue() {
        return (int) INTERNAL_VALUE.get(segment, 0L);
    }
    
    public MotorJointDef bodyIdA(Consumer<BodyId> consumer) {
        consumer.accept(bodyIdA);
        return this;
    }
    
    public MotorJointDef bodyIdA(BodyId other) {
        bodyIdA.set(other);
        return this;
    }
    
    public BodyId bodyIdA() {
        return bodyIdA;
    }
    
    public MotorJointDef bodyIdB(Consumer<BodyId> consumer) {
        consumer.accept(bodyIdB);
        return this;
    }
    
    public MotorJointDef bodyIdB(BodyId other) {
        bodyIdB.set(other);
        return this;
    }
    
    public BodyId bodyIdB() {
        return bodyIdB;
    }
    
    public MotorJointDef linearOffset(Consumer<Vec2> consumer) {
        consumer.accept(linearOffset);
        return this;
    }
    
    public MotorJointDef linearOffset(Vec2 other) {
        linearOffset.set(other);
        return this;
    }
    
    public Vec2 linearOffset() {
        return linearOffset;
    }
    
    @Override
    public MotorJointDef set(MotorJointDef other) {
        return set(other.segment);
    }
    
    @Override
    public MotorJointDef set(MemorySegment src) {
        MemorySegment.copy(src, 0L, segment, 0L, LAYOUT.byteSize());
        return this;
    }
    
    @Override
    public MemorySegment memorySegment() {
        return segment;
    }
    
    public NativeStructArray<MotorJointDef> asArray() {
        return new NativeStructArray<>(this);
    }
    
    public static NativeStructArray<MotorJointDef> array(Arena arena, int count) {
        return new NativeStructArray<>(
            arena,
            LAYOUT,
            segment -> new MotorJointDef(segment),
            count
        );
    }
    
    public static NativeStructArray<MotorJointDef> array(Arena arena, MotorJointDef... structs) {
        NativeStructArray<MotorJointDef> array = new NativeStructArray<>(
            arena,
            LAYOUT,
            segment -> new MotorJointDef(segment),
            structs.length
        );
    
        for (int i = 0; i < structs.length; i++) {
            array.set(i, structs[i]);
        }
    
        return array;
    }
    
    public static NativeStructArray<MotorJointDef> array(MemorySegment array) {
        return new NativeStructArray<>(
            array,
            LAYOUT,
            segment -> new MotorJointDef(segment)
        );
    }
    
}