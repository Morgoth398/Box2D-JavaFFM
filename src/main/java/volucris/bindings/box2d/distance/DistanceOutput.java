/*
 * MACHINE GENERATED FILE, DO NOT EDIT.
 */
package volucris.bindings.box2d.distance;

import java.lang.foreign.Arena;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.StructLayout;
import java.lang.invoke.VarHandle;
import java.util.function.Consumer;
import volucris.bindings.box2d.math.Vec2;
import volucris.bindings.core.NativeStructArray;
import volucris.bindings.core.Struct;

import static java.lang.foreign.ValueLayout.*;

/**
 * Output for b2ShapeDistance
 */
public final class DistanceOutput
		implements Struct<DistanceOutput> {

    public static final StructLayout LAYOUT;

    public static final VarHandle DISTANCE;
    public static final VarHandle ITERATIONS;
    public static final VarHandle SIMPLEX_COUNT;

    public static final long POINT_A_OFFSET;
    public static final long POINT_B_OFFSET;
    public static final long NORMAL_OFFSET;
    public static final long DISTANCE_OFFSET;
    public static final long ITERATIONS_OFFSET;
    public static final long SIMPLEX_COUNT_OFFSET;

    private final MemorySegment segment;

    private final Vec2 pointA;
    private final Vec2 pointB;
    private final Vec2 normal;

    static {
        //@formatter:off
        LAYOUT = MemoryLayout.structLayout(
            Vec2.LAYOUT.withName("pointA"),
            Vec2.LAYOUT.withName("pointB"),
            Vec2.LAYOUT.withName("normal"),
            JAVA_FLOAT.withName("distance"),
            JAVA_INT.withName("iterations"),
            JAVA_INT.withName("simplexCount")
        ).withName("b2DistanceOutput").withByteAlignment(4);
        
        DISTANCE = LAYOUT.varHandle(PathElement.groupElement("distance"));
        ITERATIONS = LAYOUT.varHandle(PathElement.groupElement("iterations"));
        SIMPLEX_COUNT = LAYOUT.varHandle(PathElement.groupElement("simplexCount"));
        
        POINT_A_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("pointA"));
        POINT_B_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("pointB"));
        NORMAL_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("normal"));
        DISTANCE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("distance"));
        ITERATIONS_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("iterations"));
        SIMPLEX_COUNT_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("simplexCount"));
        //@formatter:on
    }

    public DistanceOutput() {
        this(Arena.ofAuto());
    }
    
    public DistanceOutput(Arena arena) {
        this(arena.allocate(LAYOUT));
    }
    
    public DistanceOutput(MemorySegment segment) {
        this.segment = segment;
    
        pointA = new Vec2(segment.asSlice(POINT_A_OFFSET, Vec2.LAYOUT));
        pointB = new Vec2(segment.asSlice(POINT_B_OFFSET, Vec2.LAYOUT));
        normal = new Vec2(segment.asSlice(NORMAL_OFFSET, Vec2.LAYOUT));
    }

    public DistanceOutput distance(float distance) {
        DISTANCE.set(segment, 0L, distance);
        return this;
    }
    
    public float distance() {
        return (float) DISTANCE.get(segment, 0L);
    }
    
    public DistanceOutput iterations(int iterations) {
        ITERATIONS.set(segment, 0L, iterations);
        return this;
    }
    
    public int iterations() {
        return (int) ITERATIONS.get(segment, 0L);
    }
    
    public DistanceOutput simplexCount(int simplexCount) {
        SIMPLEX_COUNT.set(segment, 0L, simplexCount);
        return this;
    }
    
    public int simplexCount() {
        return (int) SIMPLEX_COUNT.get(segment, 0L);
    }
    
    public DistanceOutput pointA(Consumer<Vec2> consumer) {
        consumer.accept(pointA);
        return this;
    }
    
    public DistanceOutput pointA(Vec2 other) {
        pointA.set(other);
        return this;
    }
    
    public Vec2 pointA() {
        return pointA;
    }
    
    public DistanceOutput pointB(Consumer<Vec2> consumer) {
        consumer.accept(pointB);
        return this;
    }
    
    public DistanceOutput pointB(Vec2 other) {
        pointB.set(other);
        return this;
    }
    
    public Vec2 pointB() {
        return pointB;
    }
    
    public DistanceOutput normal(Consumer<Vec2> consumer) {
        consumer.accept(normal);
        return this;
    }
    
    public DistanceOutput normal(Vec2 other) {
        normal.set(other);
        return this;
    }
    
    public Vec2 normal() {
        return normal;
    }
    
    @Override
    public DistanceOutput set(DistanceOutput other) {
        return set(other.segment);
    }
    
    @Override
    public DistanceOutput set(MemorySegment src) {
        MemorySegment.copy(src, 0L, segment, 0L, LAYOUT.byteSize());
        return this;
    }
    
    @Override
    public MemorySegment memorySegment() {
        return segment;
    }
    
    public NativeStructArray<DistanceOutput> asArray() {
        return new NativeStructArray<>(this);
    }
    
    public static NativeStructArray<DistanceOutput> array(Arena arena, int count) {
        return new NativeStructArray<>(
            arena,
            LAYOUT,
            segment -> new DistanceOutput(segment),
            count
        );
    }
    
    public static NativeStructArray<DistanceOutput> array(Arena arena, DistanceOutput... structs) {
        NativeStructArray<DistanceOutput> array = new NativeStructArray<>(
            arena,
            LAYOUT,
            segment -> new DistanceOutput(segment),
            structs.length
        );
    
        for (int i = 0; i < structs.length; i++) {
            array.set(i, structs[i]);
        }
    
        return array;
    }
    
    public static NativeStructArray<DistanceOutput> array(MemorySegment array) {
        return new NativeStructArray<>(
            array,
            LAYOUT,
            segment -> new DistanceOutput(segment)
        );
    }
    
}