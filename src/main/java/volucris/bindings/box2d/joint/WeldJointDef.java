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
 * Weld joint definition
 */
public final class WeldJointDef
		implements Struct<WeldJointDef> {

    private static final LazyConstant<MethodHandle> B2_DEFAULT_WELD_JOINT_DEF;

    public static final StructLayout LAYOUT;

    public static final VarHandle REFERENCE_ANGLE_HANDLE;
    public static final VarHandle LINEAR_HERTZ_HANDLE;
    public static final VarHandle ANGULAR_HERTZ_HANDLE;
    public static final VarHandle LINEAR_DAMPING_RATIO_HANDLE;
    public static final VarHandle ANGULAR_DAMPING_RATIO_HANDLE;
    public static final VarHandle COLLIDE_CONNECTED_HANDLE;
    public static final VarHandle USER_DATA_HANDLE;
    public static final VarHandle INTERNAL_VALUE_HANDLE;

    public static final long BODY_ID_A_BYTE_OFFSET;
    public static final long BODY_ID_B_BYTE_OFFSET;
    public static final long LOCAL_ANCHOR_A_BYTE_OFFSET;
    public static final long LOCAL_ANCHOR_B_BYTE_OFFSET;
    public static final long REFERENCE_ANGLE_BYTE_OFFSET;
    public static final long LINEAR_HERTZ_BYTE_OFFSET;
    public static final long ANGULAR_HERTZ_BYTE_OFFSET;
    public static final long LINEAR_DAMPING_RATIO_BYTE_OFFSET;
    public static final long ANGULAR_DAMPING_RATIO_BYTE_OFFSET;
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
            JAVA_FLOAT.withName("linearHertz"),
            JAVA_FLOAT.withName("angularHertz"),
            JAVA_FLOAT.withName("linearDampingRatio"),
            JAVA_FLOAT.withName("angularDampingRatio"),
            JAVA_BOOLEAN.withName("collideConnected"),
            MemoryLayout.paddingLayout(3),
            UNBOUNDED_ADDRESS.withName("userData"),
            JAVA_INT.withName("internalValue"),
            MemoryLayout.paddingLayout(4)
        ).withName("b2WeldJointDef").withByteAlignment(8);
        
        B2_DEFAULT_WELD_JOINT_DEF = downcallHandle("b2DefaultWeldJointDef", WeldJointDef.LAYOUT);
        
        REFERENCE_ANGLE_HANDLE = LAYOUT.varHandle(PathElement.groupElement("referenceAngle"));
        LINEAR_HERTZ_HANDLE = LAYOUT.varHandle(PathElement.groupElement("linearHertz"));
        ANGULAR_HERTZ_HANDLE = LAYOUT.varHandle(PathElement.groupElement("angularHertz"));
        LINEAR_DAMPING_RATIO_HANDLE = LAYOUT.varHandle(PathElement.groupElement("linearDampingRatio"));
        ANGULAR_DAMPING_RATIO_HANDLE = LAYOUT.varHandle(PathElement.groupElement("angularDampingRatio"));
        COLLIDE_CONNECTED_HANDLE = LAYOUT.varHandle(PathElement.groupElement("collideConnected"));
        USER_DATA_HANDLE = LAYOUT.varHandle(PathElement.groupElement("userData"));
        INTERNAL_VALUE_HANDLE = LAYOUT.varHandle(PathElement.groupElement("internalValue"));
        
        BODY_ID_A_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("bodyIdA"));
        BODY_ID_B_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("bodyIdB"));
        LOCAL_ANCHOR_A_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("localAnchorA"));
        LOCAL_ANCHOR_B_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("localAnchorB"));
        REFERENCE_ANGLE_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("referenceAngle"));
        LINEAR_HERTZ_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("linearHertz"));
        ANGULAR_HERTZ_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("angularHertz"));
        LINEAR_DAMPING_RATIO_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("linearDampingRatio"));
        ANGULAR_DAMPING_RATIO_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("angularDampingRatio"));
        COLLIDE_CONNECTED_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("collideConnected"));
        USER_DATA_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("userData"));
        INTERNAL_VALUE_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("internalValue"));
        //@formatter:on
    }

    public WeldJointDef(MemorySegment segment) {
        this.segment = segment;
    
        bodyIdA = new BodyId(segment.asSlice(BODY_ID_A_BYTE_OFFSET, BodyId.LAYOUT));
        bodyIdB = new BodyId(segment.asSlice(BODY_ID_B_BYTE_OFFSET, BodyId.LAYOUT));
        localAnchorA = new Vec2(segment.asSlice(LOCAL_ANCHOR_A_BYTE_OFFSET, Vec2.LAYOUT));
        localAnchorB = new Vec2(segment.asSlice(LOCAL_ANCHOR_B_BYTE_OFFSET, Vec2.LAYOUT));
    }

    /**
     * Use this to initialize your joint definition
     */
    public static MemorySegment ndefaultWeldJointDef(
        SegmentAllocator allocator
    ) {
        MethodHandle method = B2_DEFAULT_WELD_JOINT_DEF.get();
        try {
            return (MemorySegment) method.invokeExact(
                allocator
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #ndefaultWeldJointDef}.
     */
    public static @Nullable WeldJointDef defaultWeldJointDef(
        SegmentAllocator allocator
    ) {
        MemorySegment segment = ndefaultWeldJointDef(allocator);
    
        if (segment.equals(MemorySegment.NULL))
            return null;
    
        return new WeldJointDef(segment);
    }
    
    public WeldJointDef referenceAngle(float referenceAngle) {
        REFERENCE_ANGLE_HANDLE.set(segment, 0L, referenceAngle);
        return this;
    }
    
    public float referenceAngle() {
        return (float) REFERENCE_ANGLE_HANDLE.get(segment, 0L);
    }
    
    public WeldJointDef linearHertz(float linearHertz) {
        LINEAR_HERTZ_HANDLE.set(segment, 0L, linearHertz);
        return this;
    }
    
    public float linearHertz() {
        return (float) LINEAR_HERTZ_HANDLE.get(segment, 0L);
    }
    
    public WeldJointDef angularHertz(float angularHertz) {
        ANGULAR_HERTZ_HANDLE.set(segment, 0L, angularHertz);
        return this;
    }
    
    public float angularHertz() {
        return (float) ANGULAR_HERTZ_HANDLE.get(segment, 0L);
    }
    
    public WeldJointDef linearDampingRatio(float linearDampingRatio) {
        LINEAR_DAMPING_RATIO_HANDLE.set(segment, 0L, linearDampingRatio);
        return this;
    }
    
    public float linearDampingRatio() {
        return (float) LINEAR_DAMPING_RATIO_HANDLE.get(segment, 0L);
    }
    
    public WeldJointDef angularDampingRatio(float angularDampingRatio) {
        ANGULAR_DAMPING_RATIO_HANDLE.set(segment, 0L, angularDampingRatio);
        return this;
    }
    
    public float angularDampingRatio() {
        return (float) ANGULAR_DAMPING_RATIO_HANDLE.get(segment, 0L);
    }
    
    public WeldJointDef collideConnected(boolean collideConnected) {
        COLLIDE_CONNECTED_HANDLE.set(segment, 0L, collideConnected);
        return this;
    }
    
    public boolean collideConnected() {
        return (boolean) COLLIDE_CONNECTED_HANDLE.get(segment, 0L);
    }
    
    public WeldJointDef userData(MemorySegment userData) {
        USER_DATA_HANDLE.set(segment, 0L, userData);
        return this;
    }
    
    public @Nullable MemorySegment userData() {
        MemorySegment segment = (MemorySegment) USER_DATA_HANDLE.get(this.segment, 0L);
    
        if (segment.equals(MemorySegment.NULL))
            return null;
    
        return segment;
    }
    
    public WeldJointDef internalValue(int internalValue) {
        INTERNAL_VALUE_HANDLE.set(segment, 0L, internalValue);
        return this;
    }
    
    public int internalValue() {
        return (int) INTERNAL_VALUE_HANDLE.get(segment, 0L);
    }
    
    public WeldJointDef bodyIdA(Consumer<BodyId> consumer) {
        consumer.accept(bodyIdA);
        return this;
    }
    
    public WeldJointDef bodyIdA(BodyId other) {
        bodyIdA.set(other);
        return this;
    }
    
    public BodyId bodyIdA() {
        return bodyIdA;
    }
    
    public WeldJointDef bodyIdB(Consumer<BodyId> consumer) {
        consumer.accept(bodyIdB);
        return this;
    }
    
    public WeldJointDef bodyIdB(BodyId other) {
        bodyIdB.set(other);
        return this;
    }
    
    public BodyId bodyIdB() {
        return bodyIdB;
    }
    
    public WeldJointDef localAnchorA(Consumer<Vec2> consumer) {
        consumer.accept(localAnchorA);
        return this;
    }
    
    public WeldJointDef localAnchorA(Vec2 other) {
        localAnchorA.set(other);
        return this;
    }
    
    public Vec2 localAnchorA() {
        return localAnchorA;
    }
    
    public WeldJointDef localAnchorB(Consumer<Vec2> consumer) {
        consumer.accept(localAnchorB);
        return this;
    }
    
    public WeldJointDef localAnchorB(Vec2 other) {
        localAnchorB.set(other);
        return this;
    }
    
    public Vec2 localAnchorB() {
        return localAnchorB;
    }
    
    @Override
    public WeldJointDef set(WeldJointDef other) {
        return set(other.segment);
    }
    
    @Override
    public WeldJointDef set(MemorySegment src) {
        MemorySegment.copy(src, 0L, segment, 0L, LAYOUT.byteSize());
        return this;
    }
    
    @Override
    public MemorySegment memorySegment() {
        return segment;
    }
    
    public NativeStructArray<WeldJointDef> asArray() {
        return new NativeStructArray<>(this);
    }
    
    public static NativeStructArray<WeldJointDef> array(Arena arena, int count) {
        return new NativeStructArray<>(
            arena,
            LAYOUT,
            segment -> new WeldJointDef(segment),
            count
        );
    }
    
    public static NativeStructArray<WeldJointDef> array(Arena arena, WeldJointDef... structs) {
        NativeStructArray<WeldJointDef> array = new NativeStructArray<>(
            arena,
            LAYOUT,
            segment -> new WeldJointDef(segment),
            structs.length
        );
    
        for (int i = 0; i < structs.length; i++) {
            array.set(i, structs[i]);
        }
    
        return array;
    }
    
    public static NativeStructArray<WeldJointDef> array(MemorySegment array) {
        return new NativeStructArray<>(
            array,
            LAYOUT,
            segment -> new WeldJointDef(segment)
        );
    }
    
}