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
 * A mouse joint is used to make a point on a body track a specified world point.
 */
public final class MouseJointDef
		implements Struct<MouseJointDef> {

    private static final LazyConstant<MethodHandle> B2_DEFAULT_MOUSE_JOINT_DEF;

    public static final StructLayout LAYOUT;

    public static final VarHandle HERTZ;
    public static final VarHandle DAMPING_RATIO;
    public static final VarHandle MAX_FORCE;
    public static final VarHandle COLLIDE_CONNECTED;
    public static final VarHandle USER_DATA;
    public static final VarHandle INTERNAL_VALUE;

    public static final long BODY_ID_A_OFFSET;
    public static final long BODY_ID_B_OFFSET;
    public static final long TARGET_OFFSET;
    public static final long HERTZ_OFFSET;
    public static final long DAMPING_RATIO_OFFSET;
    public static final long MAX_FORCE_OFFSET;
    public static final long COLLIDE_CONNECTED_OFFSET;
    public static final long USER_DATA_OFFSET;
    public static final long INTERNAL_VALUE_OFFSET;

    private final MemorySegment segment;

    private final BodyId bodyIdA;
    private final BodyId bodyIdB;
    private final Vec2 target;

    static {
        //@formatter:off
        LAYOUT = MemoryLayout.structLayout(
            BodyId.LAYOUT.withName("bodyIdA"),
            BodyId.LAYOUT.withName("bodyIdB"),
            Vec2.LAYOUT.withName("target"),
            JAVA_FLOAT.withName("hertz"),
            JAVA_FLOAT.withName("dampingRatio"),
            JAVA_FLOAT.withName("maxForce"),
            JAVA_BOOLEAN.withName("collideConnected"),
            MemoryLayout.paddingLayout(3),
            UNBOUNDED_ADDRESS.withName("userData"),
            JAVA_INT.withName("internalValue"),
            MemoryLayout.paddingLayout(4)
        ).withName("b2MouseJointDef").withByteAlignment(8);
        
        B2_DEFAULT_MOUSE_JOINT_DEF = downcallHandle("b2DefaultMouseJointDef", MouseJointDef.LAYOUT);
        
        HERTZ = LAYOUT.varHandle(PathElement.groupElement("hertz"));
        DAMPING_RATIO = LAYOUT.varHandle(PathElement.groupElement("dampingRatio"));
        MAX_FORCE = LAYOUT.varHandle(PathElement.groupElement("maxForce"));
        COLLIDE_CONNECTED = LAYOUT.varHandle(PathElement.groupElement("collideConnected"));
        USER_DATA = LAYOUT.varHandle(PathElement.groupElement("userData"));
        INTERNAL_VALUE = LAYOUT.varHandle(PathElement.groupElement("internalValue"));
        
        BODY_ID_A_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("bodyIdA"));
        BODY_ID_B_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("bodyIdB"));
        TARGET_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("target"));
        HERTZ_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("hertz"));
        DAMPING_RATIO_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("dampingRatio"));
        MAX_FORCE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("maxForce"));
        COLLIDE_CONNECTED_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("collideConnected"));
        USER_DATA_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("userData"));
        INTERNAL_VALUE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("internalValue"));
        //@formatter:on
    }

    public MouseJointDef(MemorySegment segment) {
        this.segment = segment;
    
        bodyIdA = new BodyId(segment.asSlice(BODY_ID_A_OFFSET, BodyId.LAYOUT));
        bodyIdB = new BodyId(segment.asSlice(BODY_ID_B_OFFSET, BodyId.LAYOUT));
        target = new Vec2(segment.asSlice(TARGET_OFFSET, Vec2.LAYOUT));
    }

    /**
     * Use this to initialize your joint definition
     */
    public static MemorySegment ndefaultMouseJointDef(
        SegmentAllocator allocator
    ) {
        MethodHandle method = B2_DEFAULT_MOUSE_JOINT_DEF.get();
        try {
            return (MemorySegment) method.invokeExact(
                allocator
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #ndefaultMouseJointDef}.
     */
    public static @Nullable MouseJointDef defaultMouseJointDef(
        SegmentAllocator allocator
    ) {
        MemorySegment segment = ndefaultMouseJointDef(allocator);
    
        if (segment.equals(MemorySegment.NULL))
            return null;
    
        return new MouseJointDef(segment);
    }
    
    public MouseJointDef hertz(float hertz) {
        HERTZ.set(segment, 0L, hertz);
        return this;
    }
    
    public float hertz() {
        return (float) HERTZ.get(segment, 0L);
    }
    
    public MouseJointDef dampingRatio(float dampingRatio) {
        DAMPING_RATIO.set(segment, 0L, dampingRatio);
        return this;
    }
    
    public float dampingRatio() {
        return (float) DAMPING_RATIO.get(segment, 0L);
    }
    
    public MouseJointDef maxForce(float maxForce) {
        MAX_FORCE.set(segment, 0L, maxForce);
        return this;
    }
    
    public float maxForce() {
        return (float) MAX_FORCE.get(segment, 0L);
    }
    
    public MouseJointDef collideConnected(boolean collideConnected) {
        COLLIDE_CONNECTED.set(segment, 0L, collideConnected);
        return this;
    }
    
    public boolean collideConnected() {
        return (boolean) COLLIDE_CONNECTED.get(segment, 0L);
    }
    
    public MouseJointDef userData(MemorySegment userData) {
        USER_DATA.set(segment, 0L, userData);
        return this;
    }
    
    public @Nullable MemorySegment userData() {
        MemorySegment segment = (MemorySegment) USER_DATA.get(this.segment, 0L);
    
        if (segment.equals(MemorySegment.NULL))
            return null;
    
        return segment;
    }
    
    public MouseJointDef internalValue(int internalValue) {
        INTERNAL_VALUE.set(segment, 0L, internalValue);
        return this;
    }
    
    public int internalValue() {
        return (int) INTERNAL_VALUE.get(segment, 0L);
    }
    
    public MouseJointDef bodyIdA(Consumer<BodyId> consumer) {
        consumer.accept(bodyIdA);
        return this;
    }
    
    public MouseJointDef bodyIdA(BodyId other) {
        bodyIdA.set(other);
        return this;
    }
    
    public BodyId bodyIdA() {
        return bodyIdA;
    }
    
    public MouseJointDef bodyIdB(Consumer<BodyId> consumer) {
        consumer.accept(bodyIdB);
        return this;
    }
    
    public MouseJointDef bodyIdB(BodyId other) {
        bodyIdB.set(other);
        return this;
    }
    
    public BodyId bodyIdB() {
        return bodyIdB;
    }
    
    public MouseJointDef target(Consumer<Vec2> consumer) {
        consumer.accept(target);
        return this;
    }
    
    public MouseJointDef target(Vec2 other) {
        target.set(other);
        return this;
    }
    
    public Vec2 target() {
        return target;
    }
    
    @Override
    public MouseJointDef set(MouseJointDef other) {
        return set(other.segment);
    }
    
    @Override
    public MouseJointDef set(MemorySegment src) {
        MemorySegment.copy(src, 0L, segment, 0L, LAYOUT.byteSize());
        return this;
    }
    
    @Override
    public MemorySegment memorySegment() {
        return segment;
    }
    
    public NativeStructArray<MouseJointDef> asArray() {
        return new NativeStructArray<>(this);
    }
    
    public static NativeStructArray<MouseJointDef> array(Arena arena, int count) {
        return new NativeStructArray<>(
            arena,
            LAYOUT,
            segment -> new MouseJointDef(segment),
            count
        );
    }
    
    public static NativeStructArray<MouseJointDef> array(Arena arena, MouseJointDef... structs) {
        NativeStructArray<MouseJointDef> array = new NativeStructArray<>(
            arena,
            LAYOUT,
            segment -> new MouseJointDef(segment),
            structs.length
        );
    
        for (int i = 0; i < structs.length; i++) {
            array.set(i, structs[i]);
        }
    
        return array;
    }
    
    public static NativeStructArray<MouseJointDef> array(MemorySegment array) {
        return new NativeStructArray<>(
            array,
            LAYOUT,
            segment -> new MouseJointDef(segment)
        );
    }
    
}