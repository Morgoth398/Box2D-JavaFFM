/*
 * MACHINE GENERATED FILE, DO NOT EDIT.
 */
package volucris.bindings.box2d.characterMover;

import java.lang.foreign.Arena;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.StructLayout;
import java.lang.invoke.VarHandle;
import java.util.function.Consumer;
import volucris.bindings.box2d.math.Plane;
import volucris.bindings.core.NativeStructArray;
import volucris.bindings.core.Struct;

import static java.lang.foreign.ValueLayout.*;

/**
 * These are collision planes that can be fed to b2SolvePlanes. Normally this is assembled by the user from plane results in b2PlaneResult
 */
public final class CollisionPlane
		implements Struct<CollisionPlane> {

    public static final StructLayout LAYOUT;

    public static final VarHandle PUSH_LIMIT;
    public static final VarHandle PUSH;
    public static final VarHandle CLIP_VELOCITY;

    public static final long PLANE_OFFSET;
    public static final long PUSH_LIMIT_OFFSET;
    public static final long PUSH_OFFSET;
    public static final long CLIP_VELOCITY_OFFSET;

    private final MemorySegment segment;

    private final Plane plane;

    static {
        //@formatter:off
        LAYOUT = MemoryLayout.structLayout(
            Plane.LAYOUT.withName("plane"),
            JAVA_FLOAT.withName("pushLimit"),
            JAVA_FLOAT.withName("push"),
            JAVA_BOOLEAN.withName("clipVelocity"),
            MemoryLayout.paddingLayout(3)
        ).withName("b2CollisionPlane").withByteAlignment(4);
        
        PUSH_LIMIT = LAYOUT.varHandle(PathElement.groupElement("pushLimit"));
        PUSH = LAYOUT.varHandle(PathElement.groupElement("push"));
        CLIP_VELOCITY = LAYOUT.varHandle(PathElement.groupElement("clipVelocity"));
        
        PLANE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("plane"));
        PUSH_LIMIT_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("pushLimit"));
        PUSH_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("push"));
        CLIP_VELOCITY_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("clipVelocity"));
        //@formatter:on
    }

    public CollisionPlane() {
        this(Arena.ofAuto());
    }
    
    public CollisionPlane(Arena arena) {
        this(arena.allocate(LAYOUT));
    }
    
    public CollisionPlane(MemorySegment segment) {
        this.segment = segment;
    
        plane = new Plane(segment.asSlice(PLANE_OFFSET, Plane.LAYOUT));
    }

    public CollisionPlane pushLimit(float pushLimit) {
        PUSH_LIMIT.set(segment, 0L, pushLimit);
        return this;
    }
    
    public float pushLimit() {
        return (float) PUSH_LIMIT.get(segment, 0L);
    }
    
    public CollisionPlane push(float push) {
        PUSH.set(segment, 0L, push);
        return this;
    }
    
    public float push() {
        return (float) PUSH.get(segment, 0L);
    }
    
    public CollisionPlane clipVelocity(boolean clipVelocity) {
        CLIP_VELOCITY.set(segment, 0L, clipVelocity);
        return this;
    }
    
    public boolean clipVelocity() {
        return (boolean) CLIP_VELOCITY.get(segment, 0L);
    }
    
    public CollisionPlane plane(Consumer<Plane> consumer) {
        consumer.accept(plane);
        return this;
    }
    
    public CollisionPlane plane(Plane other) {
        plane.set(other);
        return this;
    }
    
    public Plane plane() {
        return plane;
    }
    
    @Override
    public CollisionPlane set(CollisionPlane other) {
        return set(other.segment);
    }
    
    @Override
    public CollisionPlane set(MemorySegment src) {
        MemorySegment.copy(src, 0L, segment, 0L, LAYOUT.byteSize());
        return this;
    }
    
    @Override
    public MemorySegment memorySegment() {
        return segment;
    }
    
    public NativeStructArray<CollisionPlane> asArray() {
        return new NativeStructArray<>(this);
    }
    
    public static NativeStructArray<CollisionPlane> array(Arena arena, int count) {
        return new NativeStructArray<>(
            arena,
            LAYOUT,
            segment -> new CollisionPlane(segment),
            count
        );
    }
    
    public static NativeStructArray<CollisionPlane> array(Arena arena, CollisionPlane... structs) {
        NativeStructArray<CollisionPlane> array = new NativeStructArray<>(
            arena,
            LAYOUT,
            segment -> new CollisionPlane(segment),
            structs.length
        );
    
        for (int i = 0; i < structs.length; i++) {
            array.set(i, structs[i]);
        }
    
        return array;
    }
    
    public static NativeStructArray<CollisionPlane> array(MemorySegment array) {
        return new NativeStructArray<>(
            array,
            LAYOUT,
            segment -> new CollisionPlane(segment)
        );
    }
    
}