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
import volucris.bindings.box2d.math.Vec2;
import volucris.bindings.core.NativeStructArray;
import volucris.bindings.core.Struct;

import static java.lang.foreign.ValueLayout.*;
import static volucris.bindings.core.FFMUtils.*;

/**
 * A solid circle
 */
public final class Hull
		implements Struct<Hull> {

    private static final LazyConstant<MethodHandle> B2_COMPUTE_HULL;
    private static final LazyConstant<MethodHandle> B2_VALIDATE_HULL;

    public static final StructLayout LAYOUT;

    public static final VarHandle RADIUS;

    public static final long CENTER_OFFSET;
    public static final long RADIUS_OFFSET;

    private final MemorySegment segment;

    private final Vec2 center;

    static {
        //@formatter:off
        LAYOUT = MemoryLayout.structLayout(
            Vec2.LAYOUT.withName("center"),
            JAVA_FLOAT.withName("radius")
        ).withName("b2Circle").withByteAlignment(4);
        
        B2_COMPUTE_HULL = downcallHandle("b2ComputeHull", Hull.LAYOUT, UNBOUNDED_ADDRESS, JAVA_INT);
        B2_VALIDATE_HULL = downcallHandle("b2ValidateHull", JAVA_BOOLEAN, UNBOUNDED_ADDRESS);
        
        RADIUS = LAYOUT.varHandle(PathElement.groupElement("radius"));
        
        CENTER_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("center"));
        RADIUS_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("radius"));
        //@formatter:on
    }

    public Hull() {
        this(Arena.ofAuto());
    }
    
    public Hull(Arena arena) {
        this(arena.allocate(LAYOUT));
    }
    
    public Hull(MemorySegment segment) {
        this.segment = segment;
    
        center = new Vec2(segment.asSlice(CENTER_OFFSET, Vec2.LAYOUT));
    }

    /**
     * Compute the convex hull of a set of points. Returns an empty hull if it fails. Some failure cases: - all points very close together - all points on a line - less than 3 points - more than B2_MAX_POLYGON_VERTICES points This welds close points and removes collinear points.
     */
    public static MemorySegment computeHull(
        SegmentAllocator allocator,
        MemorySegment points, 
        int count
    ) {
        MethodHandle method = B2_COMPUTE_HULL.get();
        try {
            return (MemorySegment) method.invokeExact(
                allocator,
                points, 
                count
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #computeHull}.
     */
    public static @Nullable Hull computeHull(
        SegmentAllocator allocator,
        NativeStructArray<Vec2> points, 
        int count
    ) {
        MemorySegment segment = computeHull(
            allocator,
            points.memorySegment(), 
            count
        );
    
        if (segment.equals(MemorySegment.NULL))
            return null;
    
        return new Hull(segment);
    }
    
    /**
     * This determines if a hull is valid. Checks for: - convexity - collinear points This is expensive and should not be called at runtime.
     */
    public static boolean validateHull(
        MemorySegment hull
    ) {
        MethodHandle method = B2_VALIDATE_HULL.get();
        try {
            return (boolean) method.invokeExact(
                hull
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #validateHull}.
     */
    public final boolean validateHull(
    ) {
        return (boolean) validateHull(
            this.segment
        );
    }
    
    public Hull radius(float radius) {
        RADIUS.set(segment, 0L, radius);
        return this;
    }
    
    public float radius() {
        return (float) RADIUS.get(segment, 0L);
    }
    
    public Hull center(Consumer<Vec2> consumer) {
        consumer.accept(center);
        return this;
    }
    
    public Hull center(Vec2 other) {
        center.set(other);
        return this;
    }
    
    public Vec2 center() {
        return center;
    }
    
    @Override
    public Hull set(Hull other) {
        return set(other.segment);
    }
    
    @Override
    public Hull set(MemorySegment src) {
        MemorySegment.copy(src, 0L, segment, 0L, LAYOUT.byteSize());
        return this;
    }
    
    @Override
    public MemorySegment memorySegment() {
        return segment;
    }
    
    public NativeStructArray<Hull> asArray() {
        return new NativeStructArray<>(this);
    }
    
    public static NativeStructArray<Hull> array(Arena arena, int count) {
        return new NativeStructArray<>(
            arena,
            LAYOUT,
            segment -> new Hull(segment),
            count
        );
    }
    
    public static NativeStructArray<Hull> array(Arena arena, Hull... structs) {
        NativeStructArray<Hull> array = new NativeStructArray<>(
            arena,
            LAYOUT,
            segment -> new Hull(segment),
            structs.length
        );
    
        for (int i = 0; i < structs.length; i++) {
            array.set(i, structs[i]);
        }
    
        return array;
    }
    
    public static NativeStructArray<Hull> array(MemorySegment array) {
        return new NativeStructArray<>(
            array,
            LAYOUT,
            segment -> new Hull(segment)
        );
    }
    
}