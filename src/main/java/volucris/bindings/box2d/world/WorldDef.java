/*
 * MACHINE GENERATED FILE, DO NOT EDIT.
 */
package volucris.bindings.box2d.world;

import edu.umd.cs.findbugs.annotations.Nullable;
import java.lang.foreign.Arena;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.SegmentAllocator;
import java.lang.foreign.StructLayout;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.util.function.Consumer;
import volucris.bindings.box2d.math.Vec2;
import volucris.bindings.core.NativeStructArray;
import volucris.bindings.core.Struct;

import static java.lang.foreign.ValueLayout.*;
import static volucris.bindings.core.FFMUtils.*;

/**
 * World definition used to create a simulation world. Must be initialized using b2DefaultWorldDef().
 */
public final class WorldDef
		implements Struct<WorldDef> {

    private static final LazyConstant<MethodHandle> B2_DEFAULT_WORLD_DEF;

    public static final StructLayout LAYOUT;

    public static final VarHandle RESTITUTION_THRESHOLD;
    public static final VarHandle HIT_EVENT_THRESHOLD;
    public static final VarHandle CONTACT_HERTZ;
    public static final VarHandle CONTACT_DAMPING_RATIO;
    public static final VarHandle MAX_CONTACT_PUSH_SPEED;
    public static final VarHandle MAXIMUM_LINEAR_SPEED;
    public static final VarHandle FRICTION_CALLBACK;
    public static final VarHandle RESTITUTION_CALLBACK;
    public static final VarHandle ENABLE_SLEEP;
    public static final VarHandle ENABLE_CONTINUOUS;
    public static final VarHandle WORKER_COUNT;
    public static final VarHandle ENQUEUE_TASK;
    public static final VarHandle FINISH_TASK;
    public static final VarHandle USER_TASK_CONTEXT;
    public static final VarHandle USER_DATA;
    public static final VarHandle INTERNAL_VALUE;

    public static final long GRAVITY_OFFSET;
    public static final long RESTITUTION_THRESHOLD_OFFSET;
    public static final long HIT_EVENT_THRESHOLD_OFFSET;
    public static final long CONTACT_HERTZ_OFFSET;
    public static final long CONTACT_DAMPING_RATIO_OFFSET;
    public static final long MAX_CONTACT_PUSH_SPEED_OFFSET;
    public static final long MAXIMUM_LINEAR_SPEED_OFFSET;
    public static final long FRICTION_CALLBACK_OFFSET;
    public static final long RESTITUTION_CALLBACK_OFFSET;
    public static final long ENABLE_SLEEP_OFFSET;
    public static final long ENABLE_CONTINUOUS_OFFSET;
    public static final long WORKER_COUNT_OFFSET;
    public static final long ENQUEUE_TASK_OFFSET;
    public static final long FINISH_TASK_OFFSET;
    public static final long USER_TASK_CONTEXT_OFFSET;
    public static final long USER_DATA_OFFSET;
    public static final long INTERNAL_VALUE_OFFSET;

    private final MemorySegment segment;

    private final Vec2 gravity;

    static {
        //@formatter:off
        LAYOUT = MemoryLayout.structLayout(
            Vec2.LAYOUT.withName("gravity"),
            JAVA_FLOAT.withName("restitutionThreshold"),
            JAVA_FLOAT.withName("hitEventThreshold"),
            JAVA_FLOAT.withName("contactHertz"),
            JAVA_FLOAT.withName("contactDampingRatio"),
            JAVA_FLOAT.withName("maxContactPushSpeed"),
            JAVA_FLOAT.withName("maximumLinearSpeed"),
            UNBOUNDED_ADDRESS.withName("frictionCallback"),
            UNBOUNDED_ADDRESS.withName("restitutionCallback"),
            JAVA_BOOLEAN.withName("enableSleep"),
            JAVA_BOOLEAN.withName("enableContinuous"),
            MemoryLayout.paddingLayout(2),
            JAVA_INT.withName("workerCount"),
            UNBOUNDED_ADDRESS.withName("enqueueTask"),
            UNBOUNDED_ADDRESS.withName("finishTask"),
            UNBOUNDED_ADDRESS.withName("userTaskContext"),
            UNBOUNDED_ADDRESS.withName("userData"),
            JAVA_INT.withName("internalValue"),
            MemoryLayout.paddingLayout(4)
        ).withName("b2WorldDef").withByteAlignment(8);
        
        B2_DEFAULT_WORLD_DEF = downcallHandle("b2DefaultWorldDef", WorldDef.LAYOUT);
        
        RESTITUTION_THRESHOLD = LAYOUT.varHandle(PathElement.groupElement("restitutionThreshold"));
        HIT_EVENT_THRESHOLD = LAYOUT.varHandle(PathElement.groupElement("hitEventThreshold"));
        CONTACT_HERTZ = LAYOUT.varHandle(PathElement.groupElement("contactHertz"));
        CONTACT_DAMPING_RATIO = LAYOUT.varHandle(PathElement.groupElement("contactDampingRatio"));
        MAX_CONTACT_PUSH_SPEED = LAYOUT.varHandle(PathElement.groupElement("maxContactPushSpeed"));
        MAXIMUM_LINEAR_SPEED = LAYOUT.varHandle(PathElement.groupElement("maximumLinearSpeed"));
        FRICTION_CALLBACK = LAYOUT.varHandle(PathElement.groupElement("frictionCallback"));
        RESTITUTION_CALLBACK = LAYOUT.varHandle(PathElement.groupElement("restitutionCallback"));
        ENABLE_SLEEP = LAYOUT.varHandle(PathElement.groupElement("enableSleep"));
        ENABLE_CONTINUOUS = LAYOUT.varHandle(PathElement.groupElement("enableContinuous"));
        WORKER_COUNT = LAYOUT.varHandle(PathElement.groupElement("workerCount"));
        ENQUEUE_TASK = LAYOUT.varHandle(PathElement.groupElement("enqueueTask"));
        FINISH_TASK = LAYOUT.varHandle(PathElement.groupElement("finishTask"));
        USER_TASK_CONTEXT = LAYOUT.varHandle(PathElement.groupElement("userTaskContext"));
        USER_DATA = LAYOUT.varHandle(PathElement.groupElement("userData"));
        INTERNAL_VALUE = LAYOUT.varHandle(PathElement.groupElement("internalValue"));
        
        GRAVITY_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("gravity"));
        RESTITUTION_THRESHOLD_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("restitutionThreshold"));
        HIT_EVENT_THRESHOLD_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("hitEventThreshold"));
        CONTACT_HERTZ_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("contactHertz"));
        CONTACT_DAMPING_RATIO_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("contactDampingRatio"));
        MAX_CONTACT_PUSH_SPEED_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("maxContactPushSpeed"));
        MAXIMUM_LINEAR_SPEED_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("maximumLinearSpeed"));
        FRICTION_CALLBACK_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("frictionCallback"));
        RESTITUTION_CALLBACK_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("restitutionCallback"));
        ENABLE_SLEEP_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("enableSleep"));
        ENABLE_CONTINUOUS_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("enableContinuous"));
        WORKER_COUNT_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("workerCount"));
        ENQUEUE_TASK_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("enqueueTask"));
        FINISH_TASK_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("finishTask"));
        USER_TASK_CONTEXT_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("userTaskContext"));
        USER_DATA_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("userData"));
        INTERNAL_VALUE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("internalValue"));
        //@formatter:on
    }

    public WorldDef(MemorySegment segment) {
        this.segment = segment;
    
        gravity = new Vec2(segment.asSlice(GRAVITY_OFFSET, Vec2.LAYOUT));
    }

    /**
     * Use this to initialize your world definition
     */
    public static MemorySegment ndefaultWorldDef(
        SegmentAllocator allocator
    ) {
        MethodHandle method = B2_DEFAULT_WORLD_DEF.get();
        try {
            return (MemorySegment) method.invokeExact(
                allocator
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #ndefaultWorldDef}.
     */
    public static @Nullable WorldDef defaultWorldDef(
        SegmentAllocator allocator
    ) {
        MemorySegment segment = ndefaultWorldDef(allocator);
    
        if (segment.equals(MemorySegment.NULL))
            return null;
    
        return new WorldDef(segment);
    }
    
    public WorldDef restitutionThreshold(float restitutionThreshold) {
        RESTITUTION_THRESHOLD.set(segment, 0L, restitutionThreshold);
        return this;
    }
    
    public float restitutionThreshold() {
        return (float) RESTITUTION_THRESHOLD.get(segment, 0L);
    }
    
    public WorldDef hitEventThreshold(float hitEventThreshold) {
        HIT_EVENT_THRESHOLD.set(segment, 0L, hitEventThreshold);
        return this;
    }
    
    public float hitEventThreshold() {
        return (float) HIT_EVENT_THRESHOLD.get(segment, 0L);
    }
    
    public WorldDef contactHertz(float contactHertz) {
        CONTACT_HERTZ.set(segment, 0L, contactHertz);
        return this;
    }
    
    public float contactHertz() {
        return (float) CONTACT_HERTZ.get(segment, 0L);
    }
    
    public WorldDef contactDampingRatio(float contactDampingRatio) {
        CONTACT_DAMPING_RATIO.set(segment, 0L, contactDampingRatio);
        return this;
    }
    
    public float contactDampingRatio() {
        return (float) CONTACT_DAMPING_RATIO.get(segment, 0L);
    }
    
    public WorldDef maxContactPushSpeed(float maxContactPushSpeed) {
        MAX_CONTACT_PUSH_SPEED.set(segment, 0L, maxContactPushSpeed);
        return this;
    }
    
    public float maxContactPushSpeed() {
        return (float) MAX_CONTACT_PUSH_SPEED.get(segment, 0L);
    }
    
    public WorldDef maximumLinearSpeed(float maximumLinearSpeed) {
        MAXIMUM_LINEAR_SPEED.set(segment, 0L, maximumLinearSpeed);
        return this;
    }
    
    public float maximumLinearSpeed() {
        return (float) MAXIMUM_LINEAR_SPEED.get(segment, 0L);
    }
    
    public WorldDef frictionCallback(FrictionCallback frictionCallback) {
        FRICTION_CALLBACK.set(segment, 0L, frictionCallback.memorySegment());
        return this;
    }
    
    public @Nullable FrictionCallback frictionCallback() {
        MemorySegment segment = (MemorySegment) FRICTION_CALLBACK.get(this.segment, 0L);
    
        if (segment.equals(MemorySegment.NULL))
            return null;
    
        return FrictionCallback.get(segment);
    }
    
    public WorldDef restitutionCallback(RestitutionCallback restitutionCallback) {
        RESTITUTION_CALLBACK.set(segment, 0L, restitutionCallback.memorySegment());
        return this;
    }
    
    public @Nullable RestitutionCallback restitutionCallback() {
        MemorySegment segment = (MemorySegment) RESTITUTION_CALLBACK.get(this.segment, 0L);
    
        if (segment.equals(MemorySegment.NULL))
            return null;
    
        return RestitutionCallback.get(segment);
    }
    
    public WorldDef enableSleep(boolean enableSleep) {
        ENABLE_SLEEP.set(segment, 0L, enableSleep);
        return this;
    }
    
    public boolean enableSleep() {
        return (boolean) ENABLE_SLEEP.get(segment, 0L);
    }
    
    public WorldDef enableContinuous(boolean enableContinuous) {
        ENABLE_CONTINUOUS.set(segment, 0L, enableContinuous);
        return this;
    }
    
    public boolean enableContinuous() {
        return (boolean) ENABLE_CONTINUOUS.get(segment, 0L);
    }
    
    public WorldDef workerCount(int workerCount) {
        WORKER_COUNT.set(segment, 0L, workerCount);
        return this;
    }
    
    public int workerCount() {
        return (int) WORKER_COUNT.get(segment, 0L);
    }
    
    public WorldDef enqueueTask(EnqueueTaskCallback enqueueTask) {
        ENQUEUE_TASK.set(segment, 0L, enqueueTask.memorySegment());
        return this;
    }
    
    public @Nullable EnqueueTaskCallback enqueueTask() {
        MemorySegment segment = (MemorySegment) ENQUEUE_TASK.get(this.segment, 0L);
    
        if (segment.equals(MemorySegment.NULL))
            return null;
    
        return EnqueueTaskCallback.get(segment);
    }
    
    public WorldDef finishTask(FinishTaskCallback finishTask) {
        FINISH_TASK.set(segment, 0L, finishTask.memorySegment());
        return this;
    }
    
    public @Nullable FinishTaskCallback finishTask() {
        MemorySegment segment = (MemorySegment) FINISH_TASK.get(this.segment, 0L);
    
        if (segment.equals(MemorySegment.NULL))
            return null;
    
        return FinishTaskCallback.get(segment);
    }
    
    public WorldDef userTaskContext(MemorySegment userTaskContext) {
        USER_TASK_CONTEXT.set(segment, 0L, userTaskContext);
        return this;
    }
    
    public @Nullable MemorySegment userTaskContext() {
        MemorySegment segment = (MemorySegment) USER_TASK_CONTEXT.get(this.segment, 0L);
    
        if (segment.equals(MemorySegment.NULL))
            return null;
    
        return segment;
    }
    
    public WorldDef userData(MemorySegment userData) {
        USER_DATA.set(segment, 0L, userData);
        return this;
    }
    
    public @Nullable MemorySegment userData() {
        MemorySegment segment = (MemorySegment) USER_DATA.get(this.segment, 0L);
    
        if (segment.equals(MemorySegment.NULL))
            return null;
    
        return segment;
    }
    
    public WorldDef internalValue(int internalValue) {
        INTERNAL_VALUE.set(segment, 0L, internalValue);
        return this;
    }
    
    public int internalValue() {
        return (int) INTERNAL_VALUE.get(segment, 0L);
    }
    
    public WorldDef gravity(Consumer<Vec2> consumer) {
        consumer.accept(gravity);
        return this;
    }
    
    public WorldDef gravity(Vec2 other) {
        gravity.set(other);
        return this;
    }
    
    public Vec2 gravity() {
        return gravity;
    }
    
    @Override
    public WorldDef set(WorldDef other) {
        return set(other.segment);
    }
    
    @Override
    public WorldDef set(MemorySegment src) {
        MemorySegment.copy(src, 0L, segment, 0L, LAYOUT.byteSize());
        return this;
    }
    
    @Override
    public MemorySegment memorySegment() {
        return segment;
    }
    
    public NativeStructArray<WorldDef> asArray() {
        return new NativeStructArray<>(this);
    }
    
    public static NativeStructArray<WorldDef> array(Arena arena, int count) {
        return new NativeStructArray<>(
            arena,
            LAYOUT,
            segment -> new WorldDef(segment),
            count
        );
    }
    
    public static NativeStructArray<WorldDef> array(Arena arena, WorldDef... structs) {
        NativeStructArray<WorldDef> array = new NativeStructArray<>(
            arena,
            LAYOUT,
            segment -> new WorldDef(segment),
            structs.length
        );
    
        for (int i = 0; i < structs.length; i++) {
            array.set(i, structs[i]);
        }
    
        return array;
    }
    
    public static NativeStructArray<WorldDef> array(MemorySegment array) {
        return new NativeStructArray<>(
            array,
            LAYOUT,
            segment -> new WorldDef(segment)
        );
    }
    
}