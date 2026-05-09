/*
 * MACHINE GENERATED FILE, DO NOT EDIT.
 */
package volucris.bindings.box2d.collision;

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
 * A contact manifold describes the contact points between colliding shapes.
 */
public final class Manifold
		implements Struct<Manifold> {

    public static final StructLayout LAYOUT;

    public static final VarHandle ROLLING_IMPULSE_HANDLE;
    public static final VarHandle POINT_COUNT_HANDLE;

    public static final long NORMAL_BYTE_OFFSET;
    public static final long ROLLING_IMPULSE_BYTE_OFFSET;
    public static final long POINTS_BYTE_OFFSET;
    public static final long POINT_COUNT_BYTE_OFFSET;

    private final MemorySegment segment;

    private final Vec2 normal;
    private final ManifoldPoint[] points;

    static {
        //@formatter:off
        LAYOUT = MemoryLayout.structLayout(
            Vec2.LAYOUT.withName("normal"),
            JAVA_FLOAT.withName("rollingImpulse"),
            MemoryLayout.sequenceLayout(2, ManifoldPoint.LAYOUT).withName("points"),
            JAVA_INT.withName("pointCount")
        ).withName("b2Manifold").withByteAlignment(4);
        
        ROLLING_IMPULSE_HANDLE = LAYOUT.varHandle(PathElement.groupElement("rollingImpulse"));
        POINT_COUNT_HANDLE = LAYOUT.varHandle(PathElement.groupElement("pointCount"));
        
        NORMAL_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("normal"));
        ROLLING_IMPULSE_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("rollingImpulse"));
        POINTS_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("points"));
        POINT_COUNT_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("pointCount"));
        //@formatter:on
    }

    public Manifold() {
        this(Arena.ofAuto());
    }
    
    public Manifold(Arena arena) {
        this(arena.allocate(LAYOUT));
    }
    
    public Manifold(MemorySegment segment) {
        this.segment = segment;
    
        normal = new Vec2(segment.asSlice(NORMAL_BYTE_OFFSET, Vec2.LAYOUT));
    
        points = new ManifoldPoint[2];
        for (int i = 0; i < 2; i++) {
            long offset = POINTS_BYTE_OFFSET + i * ManifoldPoint.LAYOUT.byteSize();
            points[i] = new ManifoldPoint(segment.asSlice(offset, ManifoldPoint.LAYOUT));
        }
    
    }

    public Manifold rollingImpulse(float rollingImpulse) {
        ROLLING_IMPULSE_HANDLE.set(segment, 0L, rollingImpulse);
        return this;
    }
    
    public float rollingImpulse() {
        return (float) ROLLING_IMPULSE_HANDLE.get(segment, 0L);
    }
    
    public Manifold pointCount(int pointCount) {
        POINT_COUNT_HANDLE.set(segment, 0L, pointCount);
        return this;
    }
    
    public int pointCount() {
        return (int) POINT_COUNT_HANDLE.get(segment, 0L);
    }
    
    public Manifold normal(Consumer<Vec2> consumer) {
        consumer.accept(normal);
        return this;
    }
    
    public Manifold normal(Vec2 other) {
        normal.set(other);
        return this;
    }
    
    public Vec2 normal() {
        return normal;
    }
    
    public Manifold points(Consumer<ManifoldPoint> consumer, int index) {
        consumer.accept(points[index]);
        return this;
    }
    
    public Manifold points(ManifoldPoint other, int index) {
        points[index].set(other);
        return this;
    }
    
    public ManifoldPoint points(int index) {
        return points[index];
    }
    
    @Override
    public Manifold set(Manifold other) {
        return set(other.segment);
    }
    
    @Override
    public Manifold set(MemorySegment src) {
        MemorySegment.copy(src, 0L, segment, 0L, LAYOUT.byteSize());
        return this;
    }
    
    @Override
    public MemorySegment memorySegment() {
        return segment;
    }
    
    public NativeStructArray<Manifold> asArray() {
        return new NativeStructArray<>(this);
    }
    
    public static NativeStructArray<Manifold> array(Arena arena, int count) {
        return new NativeStructArray<>(
            arena,
            LAYOUT,
            segment -> new Manifold(segment),
            count
        );
    }
    
    public static NativeStructArray<Manifold> array(Arena arena, Manifold... structs) {
        NativeStructArray<Manifold> array = new NativeStructArray<>(
            arena,
            LAYOUT,
            segment -> new Manifold(segment),
            structs.length
        );
    
        for (int i = 0; i < structs.length; i++) {
            array.set(i, structs[i]);
        }
    
        return array;
    }
    
    public static NativeStructArray<Manifold> array(MemorySegment array) {
        return new NativeStructArray<>(
            array,
            LAYOUT,
            segment -> new Manifold(segment)
        );
    }
    
}