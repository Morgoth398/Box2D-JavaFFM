/*
 * MACHINE GENERATED FILE, DO NOT EDIT.
 */
package volucris.bindings.box2d.geometry;

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
 * A distance proxy is used by the GJK algorithm. It encapsulates any shape. You can provide between 1 and B2_MAX_POLYGON_VERTICES and a radius.
 */
public final class ShapeProxy
		implements Struct<ShapeProxy> {

    public static final StructLayout LAYOUT;

    public static final VarHandle COUNT;
    public static final VarHandle RADIUS;

    public static final long POINTS_OFFSET;
    public static final long COUNT_OFFSET;
    public static final long RADIUS_OFFSET;

    private final MemorySegment segment;

    private final Vec2[] points;

    static {
        //@formatter:off
        LAYOUT = MemoryLayout.structLayout(
            MemoryLayout.sequenceLayout(8, Vec2.LAYOUT).withName("points"),
            JAVA_INT.withName("count"),
            JAVA_FLOAT.withName("radius")
        ).withName("b2ShapeProxy").withByteAlignment(4);
        
        COUNT = LAYOUT.varHandle(PathElement.groupElement("count"));
        RADIUS = LAYOUT.varHandle(PathElement.groupElement("radius"));
        
        POINTS_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("points"));
        COUNT_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("count"));
        RADIUS_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("radius"));
        //@formatter:on
    }

    public ShapeProxy() {
        this(Arena.ofAuto());
    }
    
    public ShapeProxy(Arena arena) {
        this(arena.allocate(LAYOUT));
    }
    
    public ShapeProxy(MemorySegment segment) {
        this.segment = segment;
    
    
        points = new Vec2[8];
        for (int i = 0; i < 8; i++) {
            long offset = POINTS_OFFSET + i * Vec2.LAYOUT.byteSize();
            points[i] = new Vec2(segment.asSlice(offset, Vec2.LAYOUT));
        }
    
    }

    public ShapeProxy count(int count) {
        COUNT.set(segment, 0L, count);
        return this;
    }
    
    public int count() {
        return (int) COUNT.get(segment, 0L);
    }
    
    public ShapeProxy radius(float radius) {
        RADIUS.set(segment, 0L, radius);
        return this;
    }
    
    public float radius() {
        return (float) RADIUS.get(segment, 0L);
    }
    
    public ShapeProxy points(Consumer<Vec2> consumer, int index) {
        consumer.accept(points[index]);
        return this;
    }
    
    public ShapeProxy points(Vec2 other, int index) {
        points[index].set(other);
        return this;
    }
    
    public Vec2 points(int index) {
        return points[index];
    }
    
    @Override
    public ShapeProxy set(ShapeProxy other) {
        return set(other.segment);
    }
    
    @Override
    public ShapeProxy set(MemorySegment src) {
        MemorySegment.copy(src, 0L, segment, 0L, LAYOUT.byteSize());
        return this;
    }
    
    @Override
    public MemorySegment memorySegment() {
        return segment;
    }
    
    public NativeStructArray<ShapeProxy> asArray() {
        return new NativeStructArray<>(this);
    }
    
    public static NativeStructArray<ShapeProxy> array(Arena arena, int count) {
        return new NativeStructArray<>(
            arena,
            LAYOUT,
            segment -> new ShapeProxy(segment),
            count
        );
    }
    
    public static NativeStructArray<ShapeProxy> array(Arena arena, ShapeProxy... structs) {
        NativeStructArray<ShapeProxy> array = new NativeStructArray<>(
            arena,
            LAYOUT,
            segment -> new ShapeProxy(segment),
            structs.length
        );
    
        for (int i = 0; i < structs.length; i++) {
            array.set(i, structs[i]);
        }
    
        return array;
    }
    
    public static NativeStructArray<ShapeProxy> array(MemorySegment array) {
        return new NativeStructArray<>(
            array,
            LAYOUT,
            segment -> new ShapeProxy(segment)
        );
    }
    
}