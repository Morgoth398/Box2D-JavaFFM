/*
 * MACHINE GENERATED FILE, DO NOT EDIT.
 */
package volucris.bindings.box2d.geometry;

import edu.umd.cs.findbugs.annotations.Nullable;
import java.lang.foreign.Arena;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.SegmentAllocator;
import java.lang.foreign.StructLayout;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.util.function.Consumer;
import volucris.bindings.box2d.math.AABB;
import volucris.bindings.box2d.math.Transform;
import volucris.bindings.box2d.math.Vec2;
import volucris.bindings.core.NativeStructArray;
import volucris.bindings.core.Struct;

import static java.lang.foreign.ValueLayout.*;
import static volucris.bindings.core.FFMUtils.*;

/**
 * A solid capsule can be viewed as two semicircles connected by a rectangle.
 */
public final class Capsule
		implements Struct<Capsule> {

    private static final LazyConstant<MethodHandle> B2_COMPUTE_CAPSULE_MASS;
    private static final LazyConstant<MethodHandle> B2_COMPUTE_CAPSULE_AABB;
    private static final LazyConstant<MethodHandle> B2_POINT_IN_CAPSULE;
    private static final LazyConstant<MethodHandle> B2_RAY_CAST_CAPSULE;
    private static final LazyConstant<MethodHandle> B2_SHAPE_CAST_CAPSULE;

    public static final StructLayout LAYOUT;

    public static final VarHandle RADIUS;

    public static final long CENTER1_OFFSET;
    public static final long CENTER2_OFFSET;
    public static final long RADIUS_OFFSET;

    private final MemorySegment segment;

    private final Vec2 center1;
    private final Vec2 center2;

    static {
        //@formatter:off
        LAYOUT = MemoryLayout.structLayout(
            Vec2.LAYOUT.withName("center1"),
            Vec2.LAYOUT.withName("center2"),
            JAVA_FLOAT.withName("radius")
        ).withName("b2Capsule").withByteAlignment(4);
        
        B2_COMPUTE_CAPSULE_MASS = downcallHandle("b2ComputeCapsuleMass", MassData.LAYOUT, UNBOUNDED_ADDRESS, JAVA_FLOAT);
        B2_COMPUTE_CAPSULE_AABB = downcallHandle("b2ComputeCapsuleAABB", AABB.LAYOUT, UNBOUNDED_ADDRESS, Transform.LAYOUT);
        B2_POINT_IN_CAPSULE = downcallHandle("b2PointInCapsule", JAVA_BOOLEAN, Vec2.LAYOUT, UNBOUNDED_ADDRESS);
        B2_RAY_CAST_CAPSULE = downcallHandle("b2RayCastCapsule", CastOutput.LAYOUT, UNBOUNDED_ADDRESS, UNBOUNDED_ADDRESS);
        B2_SHAPE_CAST_CAPSULE = downcallHandle("b2ShapeCastCapsule", CastOutput.LAYOUT, UNBOUNDED_ADDRESS, UNBOUNDED_ADDRESS);
        
        RADIUS = LAYOUT.varHandle(PathElement.groupElement("radius"));
        
        CENTER1_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("center1"));
        CENTER2_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("center2"));
        RADIUS_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("radius"));
        //@formatter:on
    }

    public Capsule() {
        this(Arena.ofAuto());
    }
    
    public Capsule(Arena arena) {
        this(arena.allocate(LAYOUT));
    }
    
    public Capsule(MemorySegment segment) {
        this.segment = segment;
    
        center1 = new Vec2(segment.asSlice(CENTER1_OFFSET, Vec2.LAYOUT));
        center2 = new Vec2(segment.asSlice(CENTER2_OFFSET, Vec2.LAYOUT));
    }

    /**
     * Compute mass properties of a capsule
     */
    public static MemorySegment computeCapsuleMass(
        SegmentAllocator allocator,
        MemorySegment shape, 
        float density
    ) {
        MethodHandle method = B2_COMPUTE_CAPSULE_MASS.get();
        try {
            return (MemorySegment) method.invokeExact(
                allocator,
                shape, 
                density
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #computeCapsuleMass}.
     */
    public final @Nullable MassData computeCapsuleMass(
        SegmentAllocator allocator,
        float density
    ) {
        MemorySegment segment = computeCapsuleMass(
            allocator,
            this.segment, 
            density
        );
    
        if (segment.equals(MemorySegment.NULL))
            return null;
    
        return new MassData(segment);
    }
    
    /**
     * Compute the bounding box of a transformed capsule
     */
    public static MemorySegment computeCapsuleAABB(
        SegmentAllocator allocator,
        MemorySegment shape, 
        MemorySegment transform
    ) {
        MethodHandle method = B2_COMPUTE_CAPSULE_AABB.get();
        try {
            return (MemorySegment) method.invokeExact(
                allocator,
                shape, 
                transform
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #computeCapsuleAABB}.
     */
    public final @Nullable AABB computeCapsuleAABB(
        SegmentAllocator allocator,
        Transform transform
    ) {
        MemorySegment segment = computeCapsuleAABB(
            allocator,
            this.segment, 
            transform.memorySegment()
        );
    
        if (segment.equals(MemorySegment.NULL))
            return null;
    
        return new AABB(segment);
    }
    
    /**
     * Test a point for overlap with a capsule in local space
     */
    public static boolean pointInCapsule(
        MemorySegment point, 
        MemorySegment shape
    ) {
        MethodHandle method = B2_POINT_IN_CAPSULE.get();
        try {
            return (boolean) method.invokeExact(
                point, 
                shape
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #pointInCapsule}.
     */
    public final boolean pointInCapsule(
        Vec2 point
    ) {
        return (boolean) pointInCapsule(
            point.memorySegment(), 
            this.segment
        );
    }
    
    /**
     * Ray cast versus capsule shape in local space. Initial overlap is treated as a miss.
     */
    public static MemorySegment rayCastCapsule(
        SegmentAllocator allocator,
        MemorySegment input, 
        MemorySegment shape
    ) {
        MethodHandle method = B2_RAY_CAST_CAPSULE.get();
        try {
            return (MemorySegment) method.invokeExact(
                allocator,
                input, 
                shape
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #rayCastCapsule}.
     */
    public final @Nullable CastOutput rayCastCapsule(
        SegmentAllocator allocator,
        RayCastInput input
    ) {
        MemorySegment segment = rayCastCapsule(
            allocator,
            input.memorySegment(), 
            this.segment
        );
    
        if (segment.equals(MemorySegment.NULL))
            return null;
    
        return new CastOutput(segment);
    }
    
    /**
     * Shape cast versus a capsule. Initial overlap is treated as a miss.
     */
    public static MemorySegment shapeCastCapsule(
        SegmentAllocator allocator,
        MemorySegment input, 
        MemorySegment shape
    ) {
        MethodHandle method = B2_SHAPE_CAST_CAPSULE.get();
        try {
            return (MemorySegment) method.invokeExact(
                allocator,
                input, 
                shape
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #shapeCastCapsule}.
     */
    public final @Nullable CastOutput shapeCastCapsule(
        SegmentAllocator allocator,
        ShapeCastInput input
    ) {
        MemorySegment segment = shapeCastCapsule(
            allocator,
            input.memorySegment(), 
            this.segment
        );
    
        if (segment.equals(MemorySegment.NULL))
            return null;
    
        return new CastOutput(segment);
    }
    
    public Capsule radius(float radius) {
        RADIUS.set(segment, 0L, radius);
        return this;
    }
    
    public float radius() {
        return (float) RADIUS.get(segment, 0L);
    }
    
    public Capsule center1(Consumer<Vec2> consumer) {
        consumer.accept(center1);
        return this;
    }
    
    public Capsule center1(Vec2 other) {
        center1.set(other);
        return this;
    }
    
    public Vec2 center1() {
        return center1;
    }
    
    public Capsule center2(Consumer<Vec2> consumer) {
        consumer.accept(center2);
        return this;
    }
    
    public Capsule center2(Vec2 other) {
        center2.set(other);
        return this;
    }
    
    public Vec2 center2() {
        return center2;
    }
    
    @Override
    public Capsule set(Capsule other) {
        return set(other.segment);
    }
    
    @Override
    public Capsule set(MemorySegment src) {
        MemorySegment.copy(src, 0L, segment, 0L, LAYOUT.byteSize());
        return this;
    }
    
    @Override
    public MemorySegment memorySegment() {
        return segment;
    }
    
    public NativeStructArray<Capsule> asArray() {
        return new NativeStructArray<>(this);
    }
    
    public static NativeStructArray<Capsule> array(Arena arena, int count) {
        return new NativeStructArray<>(
            arena,
            LAYOUT,
            segment -> new Capsule(segment),
            count
        );
    }
    
    public static NativeStructArray<Capsule> array(Arena arena, Capsule... structs) {
        NativeStructArray<Capsule> array = new NativeStructArray<>(
            arena,
            LAYOUT,
            segment -> new Capsule(segment),
            structs.length
        );
    
        for (int i = 0; i < structs.length; i++) {
            array.set(i, structs[i]);
        }
    
        return array;
    }
    
    public static NativeStructArray<Capsule> array(MemorySegment array) {
        return new NativeStructArray<>(
            array,
            LAYOUT,
            segment -> new Capsule(segment)
        );
    }
    
}