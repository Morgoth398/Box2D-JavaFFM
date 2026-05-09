/*
 * MACHINE GENERATED FILE, DO NOT EDIT.
 */
package volucris.bindings.box2d.body;

import edu.umd.cs.findbugs.annotations.Nullable;
import java.lang.foreign.Arena;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.SegmentAllocator;
import java.lang.foreign.StructLayout;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.util.function.Consumer;
import volucris.bindings.box2d.math.Rot;
import volucris.bindings.box2d.math.Vec2;
import volucris.bindings.core.NativeByteArray;
import volucris.bindings.core.NativeStructArray;
import volucris.bindings.core.Struct;

import static java.lang.foreign.ValueLayout.*;
import static volucris.bindings.core.FFMUtils.*;

/**
 * A body definition holds all the data needed to construct a rigid body. You can safely re-use body definitions. Shapes are added to a body after construction. Body definitions are temporary objects used to bundle creation parameters. Must be initialized using b2DefaultBodyDef().
 */
public final class BodyDef
		implements Struct<BodyDef> {

    private static final LazyConstant<MethodHandle> B2_DEFAULT_BODY_DEF;

    public static final StructLayout LAYOUT;

    public static final VarHandle TYPE_HANDLE;
    public static final VarHandle ANGULAR_VELOCITY_HANDLE;
    public static final VarHandle LINEAR_DAMPING_HANDLE;
    public static final VarHandle ANGULAR_DAMPING_HANDLE;
    public static final VarHandle GRAVITY_SCALE_HANDLE;
    public static final VarHandle SLEEP_THRESHOLD_HANDLE;
    public static final VarHandle NAME_HANDLE;
    public static final VarHandle USER_DATA_HANDLE;
    public static final VarHandle ENABLE_SLEEP_HANDLE;
    public static final VarHandle IS_AWAKE_HANDLE;
    public static final VarHandle FIXED_ROTATION_HANDLE;
    public static final VarHandle IS_BULLET_HANDLE;
    public static final VarHandle IS_ENABLED_HANDLE;
    public static final VarHandle ALLOW_FAST_ROTATION_HANDLE;
    public static final VarHandle INTERNAL_VALUE_HANDLE;

    public static final long TYPE_BYTE_OFFSET;
    public static final long POSITION_BYTE_OFFSET;
    public static final long ROTATION_BYTE_OFFSET;
    public static final long LINEAR_VELOCITY_BYTE_OFFSET;
    public static final long ANGULAR_VELOCITY_BYTE_OFFSET;
    public static final long LINEAR_DAMPING_BYTE_OFFSET;
    public static final long ANGULAR_DAMPING_BYTE_OFFSET;
    public static final long GRAVITY_SCALE_BYTE_OFFSET;
    public static final long SLEEP_THRESHOLD_BYTE_OFFSET;
    public static final long NAME_BYTE_OFFSET;
    public static final long USER_DATA_BYTE_OFFSET;
    public static final long ENABLE_SLEEP_BYTE_OFFSET;
    public static final long IS_AWAKE_BYTE_OFFSET;
    public static final long FIXED_ROTATION_BYTE_OFFSET;
    public static final long IS_BULLET_BYTE_OFFSET;
    public static final long IS_ENABLED_BYTE_OFFSET;
    public static final long ALLOW_FAST_ROTATION_BYTE_OFFSET;
    public static final long INTERNAL_VALUE_BYTE_OFFSET;

    private final MemorySegment segment;

    private final Vec2 position;
    private final Rot rotation;
    private final Vec2 linearVelocity;

    static {
        //@formatter:off
        LAYOUT = MemoryLayout.structLayout(
            JAVA_INT.withName("type"),
            Vec2.LAYOUT.withName("position"),
            Rot.LAYOUT.withName("rotation"),
            Vec2.LAYOUT.withName("linearVelocity"),
            JAVA_FLOAT.withName("angularVelocity"),
            JAVA_FLOAT.withName("linearDamping"),
            JAVA_FLOAT.withName("angularDamping"),
            JAVA_FLOAT.withName("gravityScale"),
            JAVA_FLOAT.withName("sleepThreshold"),
            UNBOUNDED_ADDRESS.withName("name"),
            UNBOUNDED_ADDRESS.withName("userData"),
            JAVA_BOOLEAN.withName("enableSleep"),
            JAVA_BOOLEAN.withName("isAwake"),
            JAVA_BOOLEAN.withName("fixedRotation"),
            JAVA_BOOLEAN.withName("isBullet"),
            JAVA_BOOLEAN.withName("isEnabled"),
            JAVA_BOOLEAN.withName("allowFastRotation"),
            MemoryLayout.paddingLayout(2),
            JAVA_INT.withName("internalValue"),
            MemoryLayout.paddingLayout(4)
        ).withName("b2BodyDef").withByteAlignment(8);
        
        B2_DEFAULT_BODY_DEF = downcallHandle("b2DefaultBodyDef", BodyDef.LAYOUT);
        
        TYPE_HANDLE = LAYOUT.varHandle(PathElement.groupElement("type"));
        ANGULAR_VELOCITY_HANDLE = LAYOUT.varHandle(PathElement.groupElement("angularVelocity"));
        LINEAR_DAMPING_HANDLE = LAYOUT.varHandle(PathElement.groupElement("linearDamping"));
        ANGULAR_DAMPING_HANDLE = LAYOUT.varHandle(PathElement.groupElement("angularDamping"));
        GRAVITY_SCALE_HANDLE = LAYOUT.varHandle(PathElement.groupElement("gravityScale"));
        SLEEP_THRESHOLD_HANDLE = LAYOUT.varHandle(PathElement.groupElement("sleepThreshold"));
        NAME_HANDLE = LAYOUT.varHandle(PathElement.groupElement("name"));
        USER_DATA_HANDLE = LAYOUT.varHandle(PathElement.groupElement("userData"));
        ENABLE_SLEEP_HANDLE = LAYOUT.varHandle(PathElement.groupElement("enableSleep"));
        IS_AWAKE_HANDLE = LAYOUT.varHandle(PathElement.groupElement("isAwake"));
        FIXED_ROTATION_HANDLE = LAYOUT.varHandle(PathElement.groupElement("fixedRotation"));
        IS_BULLET_HANDLE = LAYOUT.varHandle(PathElement.groupElement("isBullet"));
        IS_ENABLED_HANDLE = LAYOUT.varHandle(PathElement.groupElement("isEnabled"));
        ALLOW_FAST_ROTATION_HANDLE = LAYOUT.varHandle(PathElement.groupElement("allowFastRotation"));
        INTERNAL_VALUE_HANDLE = LAYOUT.varHandle(PathElement.groupElement("internalValue"));
        
        TYPE_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("type"));
        POSITION_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("position"));
        ROTATION_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("rotation"));
        LINEAR_VELOCITY_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("linearVelocity"));
        ANGULAR_VELOCITY_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("angularVelocity"));
        LINEAR_DAMPING_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("linearDamping"));
        ANGULAR_DAMPING_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("angularDamping"));
        GRAVITY_SCALE_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("gravityScale"));
        SLEEP_THRESHOLD_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("sleepThreshold"));
        NAME_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("name"));
        USER_DATA_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("userData"));
        ENABLE_SLEEP_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("enableSleep"));
        IS_AWAKE_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("isAwake"));
        FIXED_ROTATION_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("fixedRotation"));
        IS_BULLET_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("isBullet"));
        IS_ENABLED_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("isEnabled"));
        ALLOW_FAST_ROTATION_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("allowFastRotation"));
        INTERNAL_VALUE_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("internalValue"));
        //@formatter:on
    }

    public BodyDef(MemorySegment segment) {
        this.segment = segment;
    
        position = new Vec2(segment.asSlice(POSITION_BYTE_OFFSET, Vec2.LAYOUT));
        rotation = new Rot(segment.asSlice(ROTATION_BYTE_OFFSET, Rot.LAYOUT));
        linearVelocity = new Vec2(segment.asSlice(LINEAR_VELOCITY_BYTE_OFFSET, Vec2.LAYOUT));
    }

    /**
     * Use this to initialize your body definition
     */
    public static MemorySegment ndefaultBodyDef(
        SegmentAllocator allocator
    ) {
        MethodHandle method = B2_DEFAULT_BODY_DEF.get();
        try {
            return (MemorySegment) method.invokeExact(
                allocator
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #ndefaultBodyDef}.
     */
    public static @Nullable BodyDef defaultBodyDef(
        SegmentAllocator allocator
    ) {
        MemorySegment segment = ndefaultBodyDef(allocator);
    
        if (segment.equals(MemorySegment.NULL))
            return null;
    
        return new BodyDef(segment);
    }
    
    public BodyDef type(int type) {
        TYPE_HANDLE.set(segment, 0L, type);
        return this;
    }
    
    public int type() {
        return (int) TYPE_HANDLE.get(segment, 0L);
    }
    
    public BodyDef angularVelocity(float angularVelocity) {
        ANGULAR_VELOCITY_HANDLE.set(segment, 0L, angularVelocity);
        return this;
    }
    
    public float angularVelocity() {
        return (float) ANGULAR_VELOCITY_HANDLE.get(segment, 0L);
    }
    
    public BodyDef linearDamping(float linearDamping) {
        LINEAR_DAMPING_HANDLE.set(segment, 0L, linearDamping);
        return this;
    }
    
    public float linearDamping() {
        return (float) LINEAR_DAMPING_HANDLE.get(segment, 0L);
    }
    
    public BodyDef angularDamping(float angularDamping) {
        ANGULAR_DAMPING_HANDLE.set(segment, 0L, angularDamping);
        return this;
    }
    
    public float angularDamping() {
        return (float) ANGULAR_DAMPING_HANDLE.get(segment, 0L);
    }
    
    public BodyDef gravityScale(float gravityScale) {
        GRAVITY_SCALE_HANDLE.set(segment, 0L, gravityScale);
        return this;
    }
    
    public float gravityScale() {
        return (float) GRAVITY_SCALE_HANDLE.get(segment, 0L);
    }
    
    public BodyDef sleepThreshold(float sleepThreshold) {
        SLEEP_THRESHOLD_HANDLE.set(segment, 0L, sleepThreshold);
        return this;
    }
    
    public float sleepThreshold() {
        return (float) SLEEP_THRESHOLD_HANDLE.get(segment, 0L);
    }
    
    public BodyDef name(NativeByteArray name) {
        NAME_HANDLE.set(segment, 0L, name.memorySegment());
        return this;
    }
    
    public @Nullable NativeByteArray name() {
        MemorySegment segment = (MemorySegment) NAME_HANDLE.get(this.segment, 0L);
    
        if (segment.equals(MemorySegment.NULL))
            return null;
    
        return new NativeByteArray(segment);
    }
    
    public BodyDef userData(MemorySegment userData) {
        USER_DATA_HANDLE.set(segment, 0L, userData);
        return this;
    }
    
    public @Nullable MemorySegment userData() {
        MemorySegment segment = (MemorySegment) USER_DATA_HANDLE.get(this.segment, 0L);
    
        if (segment.equals(MemorySegment.NULL))
            return null;
    
        return segment;
    }
    
    public BodyDef enableSleep(boolean enableSleep) {
        ENABLE_SLEEP_HANDLE.set(segment, 0L, enableSleep);
        return this;
    }
    
    public boolean enableSleep() {
        return (boolean) ENABLE_SLEEP_HANDLE.get(segment, 0L);
    }
    
    public BodyDef isAwake(boolean isAwake) {
        IS_AWAKE_HANDLE.set(segment, 0L, isAwake);
        return this;
    }
    
    public boolean isAwake() {
        return (boolean) IS_AWAKE_HANDLE.get(segment, 0L);
    }
    
    public BodyDef fixedRotation(boolean fixedRotation) {
        FIXED_ROTATION_HANDLE.set(segment, 0L, fixedRotation);
        return this;
    }
    
    public boolean fixedRotation() {
        return (boolean) FIXED_ROTATION_HANDLE.get(segment, 0L);
    }
    
    public BodyDef isBullet(boolean isBullet) {
        IS_BULLET_HANDLE.set(segment, 0L, isBullet);
        return this;
    }
    
    public boolean isBullet() {
        return (boolean) IS_BULLET_HANDLE.get(segment, 0L);
    }
    
    public BodyDef isEnabled(boolean isEnabled) {
        IS_ENABLED_HANDLE.set(segment, 0L, isEnabled);
        return this;
    }
    
    public boolean isEnabled() {
        return (boolean) IS_ENABLED_HANDLE.get(segment, 0L);
    }
    
    public BodyDef allowFastRotation(boolean allowFastRotation) {
        ALLOW_FAST_ROTATION_HANDLE.set(segment, 0L, allowFastRotation);
        return this;
    }
    
    public boolean allowFastRotation() {
        return (boolean) ALLOW_FAST_ROTATION_HANDLE.get(segment, 0L);
    }
    
    public BodyDef internalValue(int internalValue) {
        INTERNAL_VALUE_HANDLE.set(segment, 0L, internalValue);
        return this;
    }
    
    public int internalValue() {
        return (int) INTERNAL_VALUE_HANDLE.get(segment, 0L);
    }
    
    public BodyDef position(Consumer<Vec2> consumer) {
        consumer.accept(position);
        return this;
    }
    
    public BodyDef position(Vec2 other) {
        position.set(other);
        return this;
    }
    
    public Vec2 position() {
        return position;
    }
    
    public BodyDef rotation(Consumer<Rot> consumer) {
        consumer.accept(rotation);
        return this;
    }
    
    public BodyDef rotation(Rot other) {
        rotation.set(other);
        return this;
    }
    
    public Rot rotation() {
        return rotation;
    }
    
    public BodyDef linearVelocity(Consumer<Vec2> consumer) {
        consumer.accept(linearVelocity);
        return this;
    }
    
    public BodyDef linearVelocity(Vec2 other) {
        linearVelocity.set(other);
        return this;
    }
    
    public Vec2 linearVelocity() {
        return linearVelocity;
    }
    
    @Override
    public BodyDef set(BodyDef other) {
        return set(other.segment);
    }
    
    @Override
    public BodyDef set(MemorySegment src) {
        MemorySegment.copy(src, 0L, segment, 0L, LAYOUT.byteSize());
        return this;
    }
    
    @Override
    public MemorySegment memorySegment() {
        return segment;
    }
    
    public NativeStructArray<BodyDef> asArray() {
        return new NativeStructArray<>(this);
    }
    
    public static NativeStructArray<BodyDef> array(Arena arena, int count) {
        return new NativeStructArray<>(
            arena,
            LAYOUT,
            segment -> new BodyDef(segment),
            count
        );
    }
    
    public static NativeStructArray<BodyDef> array(Arena arena, BodyDef... structs) {
        NativeStructArray<BodyDef> array = new NativeStructArray<>(
            arena,
            LAYOUT,
            segment -> new BodyDef(segment),
            structs.length
        );
    
        for (int i = 0; i < structs.length; i++) {
            array.set(i, structs[i]);
        }
    
        return array;
    }
    
    public static NativeStructArray<BodyDef> array(MemorySegment array) {
        return new NativeStructArray<>(
            array,
            LAYOUT,
            segment -> new BodyDef(segment)
        );
    }
    
}