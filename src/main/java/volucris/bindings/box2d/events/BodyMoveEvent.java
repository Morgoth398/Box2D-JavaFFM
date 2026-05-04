/*
 * MACHINE GENERATED FILE, DO NOT EDIT.
 */
package volucris.bindings.box2d.events;

import edu.umd.cs.findbugs.annotations.Nullable;
import java.lang.foreign.Arena;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.StructLayout;
import java.lang.invoke.VarHandle;
import java.util.function.Consumer;
import volucris.bindings.box2d.body.BodyId;
import volucris.bindings.box2d.math.Transform;
import volucris.bindings.core.NativeStructArray;
import volucris.bindings.core.Struct;

import static java.lang.foreign.ValueLayout.*;
import static volucris.bindings.core.FFMUtils.*;

/**
 * Body move events triggered when a body moves. Triggered when a body moves due to simulation. Not reported for bodies moved by the user. This also has a flag to indicate that the body went to sleep so the application can also sleep that actor/entity/object associated with the body. On the other hand if the flag does not indicate the body went to sleep then the application can treat the actor/entity/object associated with the body as awake. This is an efficient way for an application to update game object transforms rather than calling functions such as b2Body_GetTransform() because this data is delivered as a contiguous array and it is only populated with bodies that have moved.
 */
public final class BodyMoveEvent
		implements Struct<BodyMoveEvent> {

    public static final StructLayout LAYOUT;

    public static final VarHandle USER_DATA;
    public static final VarHandle FELL_ASLEEP;

    public static final long TRANSFORM_OFFSET;
    public static final long BODY_ID_OFFSET;
    public static final long USER_DATA_OFFSET;
    public static final long FELL_ASLEEP_OFFSET;

    private final MemorySegment segment;

    private final Transform transform;
    private final BodyId bodyId;

    static {
        //@formatter:off
        LAYOUT = MemoryLayout.structLayout(
            Transform.LAYOUT.withName("transform"),
            BodyId.LAYOUT.withName("bodyId"),
            UNBOUNDED_ADDRESS.withName("userData"),
            JAVA_BOOLEAN.withName("fellAsleep"),
            MemoryLayout.paddingLayout(7)
        ).withName("b2BodyMoveEvent").withByteAlignment(8);
        
        USER_DATA = LAYOUT.varHandle(PathElement.groupElement("userData"));
        FELL_ASLEEP = LAYOUT.varHandle(PathElement.groupElement("fellAsleep"));
        
        TRANSFORM_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("transform"));
        BODY_ID_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("bodyId"));
        USER_DATA_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("userData"));
        FELL_ASLEEP_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("fellAsleep"));
        //@formatter:on
    }

    public BodyMoveEvent() {
        this(Arena.ofAuto());
    }
    
    public BodyMoveEvent(Arena arena) {
        this(arena.allocate(LAYOUT));
    }
    
    public BodyMoveEvent(MemorySegment segment) {
        this.segment = segment;
    
        transform = new Transform(segment.asSlice(TRANSFORM_OFFSET, Transform.LAYOUT));
        bodyId = new BodyId(segment.asSlice(BODY_ID_OFFSET, BodyId.LAYOUT));
    }

    public BodyMoveEvent userData(MemorySegment userData) {
        USER_DATA.set(segment, 0L, userData);
        return this;
    }
    
    public @Nullable MemorySegment userData() {
        MemorySegment segment = (MemorySegment) USER_DATA.get(this.segment, 0L);
    
        if (segment.equals(MemorySegment.NULL))
            return null;
    
        return segment;
    }
    
    public BodyMoveEvent fellAsleep(boolean fellAsleep) {
        FELL_ASLEEP.set(segment, 0L, fellAsleep);
        return this;
    }
    
    public boolean fellAsleep() {
        return (boolean) FELL_ASLEEP.get(segment, 0L);
    }
    
    public BodyMoveEvent transform(Consumer<Transform> consumer) {
        consumer.accept(transform);
        return this;
    }
    
    public BodyMoveEvent transform(Transform other) {
        transform.set(other);
        return this;
    }
    
    public Transform transform() {
        return transform;
    }
    
    public BodyMoveEvent bodyId(Consumer<BodyId> consumer) {
        consumer.accept(bodyId);
        return this;
    }
    
    public BodyMoveEvent bodyId(BodyId other) {
        bodyId.set(other);
        return this;
    }
    
    public BodyId bodyId() {
        return bodyId;
    }
    
    @Override
    public BodyMoveEvent set(BodyMoveEvent other) {
        return set(other.segment);
    }
    
    @Override
    public BodyMoveEvent set(MemorySegment src) {
        MemorySegment.copy(src, 0L, segment, 0L, LAYOUT.byteSize());
        return this;
    }
    
    @Override
    public MemorySegment memorySegment() {
        return segment;
    }
    
    public NativeStructArray<BodyMoveEvent> asArray() {
        return new NativeStructArray<>(this);
    }
    
    public static NativeStructArray<BodyMoveEvent> array(Arena arena, int count) {
        return new NativeStructArray<>(
            arena,
            LAYOUT,
            segment -> new BodyMoveEvent(segment),
            count
        );
    }
    
    public static NativeStructArray<BodyMoveEvent> array(Arena arena, BodyMoveEvent... structs) {
        NativeStructArray<BodyMoveEvent> array = new NativeStructArray<>(
            arena,
            LAYOUT,
            segment -> new BodyMoveEvent(segment),
            structs.length
        );
    
        for (int i = 0; i < structs.length; i++) {
            array.set(i, structs[i]);
        }
    
        return array;
    }
    
    public static NativeStructArray<BodyMoveEvent> array(MemorySegment array) {
        return new NativeStructArray<>(
            array,
            LAYOUT,
            segment -> new BodyMoveEvent(segment)
        );
    }
    
}