/*
 * MACHINE GENERATED FILE, DO NOT EDIT.
 */
package volucris.bindings.box2d.world;

import java.lang.foreign.Arena;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.StructLayout;
import java.lang.invoke.VarHandle;
import java.util.function.Consumer;
import volucris.bindings.box2d.math.Vec2;
import volucris.bindings.box2d.shape.ShapeId;
import volucris.bindings.core.NativeStructArray;
import volucris.bindings.core.Struct;

import static java.lang.foreign.ValueLayout.*;

/**
 * Result from b2World_RayCastClosest If there is initial overlap the fraction and normal will be zero while the point is an arbitrary point in the overlap region.
 */
public final class RayResult
		implements Struct<RayResult> {

    public static final StructLayout LAYOUT;

    public static final VarHandle FRACTION_HANDLE;
    public static final VarHandle NODE_VISITS_HANDLE;
    public static final VarHandle LEAF_VISITS_HANDLE;
    public static final VarHandle HIT_HANDLE;

    public static final long SHAPE_ID_BYTE_OFFSET;
    public static final long POINT_BYTE_OFFSET;
    public static final long NORMAL_BYTE_OFFSET;
    public static final long FRACTION_BYTE_OFFSET;
    public static final long NODE_VISITS_BYTE_OFFSET;
    public static final long LEAF_VISITS_BYTE_OFFSET;
    public static final long HIT_BYTE_OFFSET;

    private final MemorySegment segment;

    private final ShapeId shapeId;
    private final Vec2 point;
    private final Vec2 normal;

    static {
        //@formatter:off
        LAYOUT = MemoryLayout.structLayout(
            ShapeId.LAYOUT.withName("shapeId"),
            Vec2.LAYOUT.withName("point"),
            Vec2.LAYOUT.withName("normal"),
            JAVA_FLOAT.withName("fraction"),
            JAVA_INT.withName("nodeVisits"),
            JAVA_INT.withName("leafVisits"),
            JAVA_BOOLEAN.withName("hit"),
            MemoryLayout.paddingLayout(3)
        ).withName("b2RayResult").withByteAlignment(4);
        
        FRACTION_HANDLE = LAYOUT.varHandle(PathElement.groupElement("fraction"));
        NODE_VISITS_HANDLE = LAYOUT.varHandle(PathElement.groupElement("nodeVisits"));
        LEAF_VISITS_HANDLE = LAYOUT.varHandle(PathElement.groupElement("leafVisits"));
        HIT_HANDLE = LAYOUT.varHandle(PathElement.groupElement("hit"));
        
        SHAPE_ID_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("shapeId"));
        POINT_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("point"));
        NORMAL_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("normal"));
        FRACTION_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("fraction"));
        NODE_VISITS_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("nodeVisits"));
        LEAF_VISITS_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("leafVisits"));
        HIT_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("hit"));
        //@formatter:on
    }

    public RayResult() {
        this(Arena.ofAuto());
    }
    
    public RayResult(Arena arena) {
        this(arena.allocate(LAYOUT));
    }
    
    public RayResult(MemorySegment segment) {
        this.segment = segment;
    
        shapeId = new ShapeId(segment.asSlice(SHAPE_ID_BYTE_OFFSET, ShapeId.LAYOUT));
        point = new Vec2(segment.asSlice(POINT_BYTE_OFFSET, Vec2.LAYOUT));
        normal = new Vec2(segment.asSlice(NORMAL_BYTE_OFFSET, Vec2.LAYOUT));
    }

    public RayResult fraction(float fraction) {
        FRACTION_HANDLE.set(segment, 0L, fraction);
        return this;
    }
    
    public float fraction() {
        return (float) FRACTION_HANDLE.get(segment, 0L);
    }
    
    public RayResult nodeVisits(int nodeVisits) {
        NODE_VISITS_HANDLE.set(segment, 0L, nodeVisits);
        return this;
    }
    
    public int nodeVisits() {
        return (int) NODE_VISITS_HANDLE.get(segment, 0L);
    }
    
    public RayResult leafVisits(int leafVisits) {
        LEAF_VISITS_HANDLE.set(segment, 0L, leafVisits);
        return this;
    }
    
    public int leafVisits() {
        return (int) LEAF_VISITS_HANDLE.get(segment, 0L);
    }
    
    public RayResult hit(boolean hit) {
        HIT_HANDLE.set(segment, 0L, hit);
        return this;
    }
    
    public boolean hit() {
        return (boolean) HIT_HANDLE.get(segment, 0L);
    }
    
    public RayResult shapeId(Consumer<ShapeId> consumer) {
        consumer.accept(shapeId);
        return this;
    }
    
    public RayResult shapeId(ShapeId other) {
        shapeId.set(other);
        return this;
    }
    
    public ShapeId shapeId() {
        return shapeId;
    }
    
    public RayResult point(Consumer<Vec2> consumer) {
        consumer.accept(point);
        return this;
    }
    
    public RayResult point(Vec2 other) {
        point.set(other);
        return this;
    }
    
    public Vec2 point() {
        return point;
    }
    
    public RayResult normal(Consumer<Vec2> consumer) {
        consumer.accept(normal);
        return this;
    }
    
    public RayResult normal(Vec2 other) {
        normal.set(other);
        return this;
    }
    
    public Vec2 normal() {
        return normal;
    }
    
    @Override
    public RayResult set(RayResult other) {
        return set(other.segment);
    }
    
    @Override
    public RayResult set(MemorySegment src) {
        MemorySegment.copy(src, 0L, segment, 0L, LAYOUT.byteSize());
        return this;
    }
    
    @Override
    public MemorySegment memorySegment() {
        return segment;
    }
    
    public NativeStructArray<RayResult> asArray() {
        return new NativeStructArray<>(this);
    }
    
    public static NativeStructArray<RayResult> array(Arena arena, int count) {
        return new NativeStructArray<>(
            arena,
            LAYOUT,
            segment -> new RayResult(segment),
            count
        );
    }
    
    public static NativeStructArray<RayResult> array(Arena arena, RayResult... structs) {
        NativeStructArray<RayResult> array = new NativeStructArray<>(
            arena,
            LAYOUT,
            segment -> new RayResult(segment),
            structs.length
        );
    
        for (int i = 0; i < structs.length; i++) {
            array.set(i, structs[i]);
        }
    
        return array;
    }
    
    public static NativeStructArray<RayResult> array(MemorySegment array) {
        return new NativeStructArray<>(
            array,
            LAYOUT,
            segment -> new RayResult(segment)
        );
    }
    
}