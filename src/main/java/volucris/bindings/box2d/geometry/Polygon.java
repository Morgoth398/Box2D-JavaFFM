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
import volucris.bindings.box2d.math.Rot;
import volucris.bindings.box2d.math.Transform;
import volucris.bindings.box2d.math.Vec2;
import volucris.bindings.core.NativeStructArray;
import volucris.bindings.core.Struct;

import static java.lang.foreign.ValueLayout.*;
import static volucris.bindings.core.FFMUtils.*;

/**
 * A solid convex polygon. It is assumed that the interior of the polygon is to the left of each edge. Polygons have a maximum number of vertices equal to B2_MAX_POLYGON_VERTICES. In most cases you should not need many vertices for a convex polygon.
 */
public final class Polygon
		implements Struct<Polygon> {

    public static final int MAX_POLYGON_VERTICES = 8;

    private static final LazyConstant<MethodHandle> B2_MAKE_POLYGON;
    private static final LazyConstant<MethodHandle> B2_MAKE_OFFSET_POLYGON;
    private static final LazyConstant<MethodHandle> B2_MAKE_OFFSET_ROUNDED_POLYGON;
    private static final LazyConstant<MethodHandle> B2_MAKE_SQUARE;
    private static final LazyConstant<MethodHandle> B2_MAKE_BOX;
    private static final LazyConstant<MethodHandle> B2_MAKE_ROUNDED_BOX;
    private static final LazyConstant<MethodHandle> B2_MAKE_OFFSET_BOX;
    private static final LazyConstant<MethodHandle> B2_MAKE_OFFSET_ROUNDED_BOX;
    private static final LazyConstant<MethodHandle> B2_TRANSFORM_POLYGON;
    private static final LazyConstant<MethodHandle> B2_POINT_IN_POLYGON;
    private static final LazyConstant<MethodHandle> B2_RAY_CAST_POLYGON;
    private static final LazyConstant<MethodHandle> B2_SHAPE_CAST_POLYGON;

    public static final StructLayout LAYOUT;

    public static final VarHandle RADIUS_HANDLE;
    public static final VarHandle COUNT_HANDLE;

    public static final long VERTICES_BYTE_OFFSET;
    public static final long NORMALS_BYTE_OFFSET;
    public static final long CENTROID_BYTE_OFFSET;
    public static final long RADIUS_BYTE_OFFSET;
    public static final long COUNT_BYTE_OFFSET;

    private final MemorySegment segment;

    private final Vec2[] vertices;
    private final Vec2[] normals;
    private final Vec2 centroid;

    static {
        //@formatter:off
        LAYOUT = MemoryLayout.structLayout(
            MemoryLayout.sequenceLayout(8, Vec2.LAYOUT).withName("vertices"),
            MemoryLayout.sequenceLayout(8, Vec2.LAYOUT).withName("normals"),
            Vec2.LAYOUT.withName("centroid"),
            JAVA_FLOAT.withName("radius"),
            JAVA_INT.withName("count")
        ).withName("b2Polygon").withByteAlignment(4);
        
        B2_MAKE_POLYGON = downcallHandle("b2MakePolygon", Polygon.LAYOUT, UNBOUNDED_ADDRESS, JAVA_FLOAT);
        B2_MAKE_OFFSET_POLYGON = downcallHandle("b2MakeOffsetPolygon", Polygon.LAYOUT, UNBOUNDED_ADDRESS, Vec2.LAYOUT, Rot.LAYOUT);
        B2_MAKE_OFFSET_ROUNDED_POLYGON = downcallHandle("b2MakeOffsetRoundedPolygon", Polygon.LAYOUT, UNBOUNDED_ADDRESS, Vec2.LAYOUT, Rot.LAYOUT, JAVA_FLOAT);
        B2_MAKE_SQUARE = downcallHandle("b2MakeSquare", Polygon.LAYOUT, JAVA_FLOAT);
        B2_MAKE_BOX = downcallHandle("b2MakeBox", Polygon.LAYOUT, JAVA_FLOAT, JAVA_FLOAT);
        B2_MAKE_ROUNDED_BOX = downcallHandle("b2MakeRoundedBox", Polygon.LAYOUT, JAVA_FLOAT, JAVA_FLOAT, JAVA_FLOAT);
        B2_MAKE_OFFSET_BOX = downcallHandle("b2MakeOffsetBox", Polygon.LAYOUT, JAVA_FLOAT, JAVA_FLOAT, Vec2.LAYOUT, Rot.LAYOUT);
        B2_MAKE_OFFSET_ROUNDED_BOX = downcallHandle("b2MakeOffsetRoundedBox", Polygon.LAYOUT, JAVA_FLOAT, JAVA_FLOAT, Vec2.LAYOUT, Rot.LAYOUT, JAVA_FLOAT);
        B2_TRANSFORM_POLYGON = downcallHandle("b2TransformPolygon", Polygon.LAYOUT, Transform.LAYOUT, UNBOUNDED_ADDRESS);
        B2_POINT_IN_POLYGON = downcallHandle("b2PointInPolygon", JAVA_BOOLEAN, Vec2.LAYOUT, UNBOUNDED_ADDRESS);
        B2_RAY_CAST_POLYGON = downcallHandle("b2RayCastPolygon", CastOutput.LAYOUT, UNBOUNDED_ADDRESS, UNBOUNDED_ADDRESS);
        B2_SHAPE_CAST_POLYGON = downcallHandle("b2ShapeCastPolygon", CastOutput.LAYOUT, UNBOUNDED_ADDRESS, UNBOUNDED_ADDRESS);
        
        RADIUS_HANDLE = LAYOUT.varHandle(PathElement.groupElement("radius"));
        COUNT_HANDLE = LAYOUT.varHandle(PathElement.groupElement("count"));
        
        VERTICES_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("vertices"));
        NORMALS_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("normals"));
        CENTROID_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("centroid"));
        RADIUS_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("radius"));
        COUNT_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("count"));
        //@formatter:on
    }

    public Polygon() {
        this(Arena.ofAuto());
    }
    
    public Polygon(Arena arena) {
        this(arena.allocate(LAYOUT));
    }
    
    public Polygon(MemorySegment segment) {
        this.segment = segment;
    
    
        vertices = new Vec2[8];
        for (int i = 0; i < 8; i++) {
            long offset = VERTICES_BYTE_OFFSET + i * Vec2.LAYOUT.byteSize();
            vertices[i] = new Vec2(segment.asSlice(offset, Vec2.LAYOUT));
        }
    
    
        normals = new Vec2[8];
        for (int i = 0; i < 8; i++) {
            long offset = NORMALS_BYTE_OFFSET + i * Vec2.LAYOUT.byteSize();
            normals[i] = new Vec2(segment.asSlice(offset, Vec2.LAYOUT));
        }
    
        centroid = new Vec2(segment.asSlice(CENTROID_BYTE_OFFSET, Vec2.LAYOUT));
    }

    /**
     * Make a convex polygon from a convex hull. This will assert if the hull is not valid.
     */
    public static MemorySegment makePolygon(
        SegmentAllocator allocator,
        MemorySegment hull, 
        float radius
    ) {
        MethodHandle method = B2_MAKE_POLYGON.get();
        try {
            return (MemorySegment) method.invokeExact(
                allocator,
                hull, 
                radius
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #makePolygon}.
     */
    public static @Nullable Polygon makePolygon(
        SegmentAllocator allocator,
        Hull hull, 
        float radius
    ) {
        MemorySegment segment = makePolygon(
            allocator,
            hull.memorySegment(), 
            radius
        );
    
        if (segment.equals(MemorySegment.NULL))
            return null;
    
        return new Polygon(segment);
    }
    
    /**
     * Make an offset convex polygon from a convex hull. This will assert if the hull is not valid.
     */
    public static MemorySegment makeOffsetPolygon(
        SegmentAllocator allocator,
        MemorySegment hull, 
        MemorySegment position, 
        MemorySegment rotation
    ) {
        MethodHandle method = B2_MAKE_OFFSET_POLYGON.get();
        try {
            return (MemorySegment) method.invokeExact(
                allocator,
                hull, 
                position, 
                rotation
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #makeOffsetPolygon}.
     */
    public static @Nullable Polygon makeOffsetPolygon(
        SegmentAllocator allocator,
        Hull hull, 
        Vec2 position, 
        Rot rotation
    ) {
        MemorySegment segment = makeOffsetPolygon(
            allocator,
            hull.memorySegment(), 
            position.memorySegment(), 
            rotation.memorySegment()
        );
    
        if (segment.equals(MemorySegment.NULL))
            return null;
    
        return new Polygon(segment);
    }
    
    /**
     * Make an offset convex polygon from a convex hull. This will assert if the hull is not valid.
     */
    public static MemorySegment makeOffsetRoundedPolygon(
        SegmentAllocator allocator,
        MemorySegment hull, 
        MemorySegment position, 
        MemorySegment rotation, 
        float radius
    ) {
        MethodHandle method = B2_MAKE_OFFSET_ROUNDED_POLYGON.get();
        try {
            return (MemorySegment) method.invokeExact(
                allocator,
                hull, 
                position, 
                rotation, 
                radius
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #makeOffsetRoundedPolygon}.
     */
    public static @Nullable Polygon makeOffsetRoundedPolygon(
        SegmentAllocator allocator,
        Hull hull, 
        Vec2 position, 
        Rot rotation, 
        float radius
    ) {
        MemorySegment segment = makeOffsetRoundedPolygon(
            allocator,
            hull.memorySegment(), 
            position.memorySegment(), 
            rotation.memorySegment(), 
            radius
        );
    
        if (segment.equals(MemorySegment.NULL))
            return null;
    
        return new Polygon(segment);
    }
    
    /**
     * Make a square polygon, bypassing the need for a convex hull.
     */
    public static MemorySegment nmakeSquare(
        SegmentAllocator allocator,
        float halfWidth
    ) {
        MethodHandle method = B2_MAKE_SQUARE.get();
        try {
            return (MemorySegment) method.invokeExact(
                allocator,
                halfWidth
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #nmakeSquare}.
     */
    public static @Nullable Polygon makeSquare(
        SegmentAllocator allocator,
        float halfWidth
    ) {
        MemorySegment segment = nmakeSquare(
            allocator,
            halfWidth
        );
    
        if (segment.equals(MemorySegment.NULL))
            return null;
    
        return new Polygon(segment);
    }
    
    /**
     * Make a box (rectangle) polygon, bypassing the need for a convex hull.
     */
    public static MemorySegment nmakeBox(
        SegmentAllocator allocator,
        float halfWidth, 
        float halfHeight
    ) {
        MethodHandle method = B2_MAKE_BOX.get();
        try {
            return (MemorySegment) method.invokeExact(
                allocator,
                halfWidth, 
                halfHeight
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #nmakeBox}.
     */
    public static @Nullable Polygon makeBox(
        SegmentAllocator allocator,
        float halfWidth, 
        float halfHeight
    ) {
        MemorySegment segment = nmakeBox(
            allocator,
            halfWidth, 
            halfHeight
        );
    
        if (segment.equals(MemorySegment.NULL))
            return null;
    
        return new Polygon(segment);
    }
    
    /**
     * Make a rounded box, bypassing the need for a convex hull.
     */
    public static MemorySegment nmakeRoundedBox(
        SegmentAllocator allocator,
        float halfWidth, 
        float halfHeight, 
        float radius
    ) {
        MethodHandle method = B2_MAKE_ROUNDED_BOX.get();
        try {
            return (MemorySegment) method.invokeExact(
                allocator,
                halfWidth, 
                halfHeight, 
                radius
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #nmakeRoundedBox}.
     */
    public static @Nullable Polygon makeRoundedBox(
        SegmentAllocator allocator,
        float halfWidth, 
        float halfHeight, 
        float radius
    ) {
        MemorySegment segment = nmakeRoundedBox(
            allocator,
            halfWidth, 
            halfHeight, 
            radius
        );
    
        if (segment.equals(MemorySegment.NULL))
            return null;
    
        return new Polygon(segment);
    }
    
    /**
     * Make an offset box, bypassing the need for a convex hull.
     */
    public static MemorySegment makeOffsetBox(
        SegmentAllocator allocator,
        float halfWidth, 
        float halfHeight, 
        MemorySegment center, 
        MemorySegment rotation
    ) {
        MethodHandle method = B2_MAKE_OFFSET_BOX.get();
        try {
            return (MemorySegment) method.invokeExact(
                allocator,
                halfWidth, 
                halfHeight, 
                center, 
                rotation
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #makeOffsetBox}.
     */
    public static @Nullable Polygon makeOffsetBox(
        SegmentAllocator allocator,
        float halfWidth, 
        float halfHeight, 
        Vec2 center, 
        Rot rotation
    ) {
        MemorySegment segment = makeOffsetBox(
            allocator,
            halfWidth, 
            halfHeight, 
            center.memorySegment(), 
            rotation.memorySegment()
        );
    
        if (segment.equals(MemorySegment.NULL))
            return null;
    
        return new Polygon(segment);
    }
    
    /**
     * Make an offset rounded box, bypassing the need for a convex hull.
     */
    public static MemorySegment makeOffsetRoundedBox(
        SegmentAllocator allocator,
        float halfWidth, 
        float halfHeight, 
        MemorySegment center, 
        MemorySegment rotation, 
        float radius
    ) {
        MethodHandle method = B2_MAKE_OFFSET_ROUNDED_BOX.get();
        try {
            return (MemorySegment) method.invokeExact(
                allocator,
                halfWidth, 
                halfHeight, 
                center, 
                rotation, 
                radius
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #makeOffsetRoundedBox}.
     */
    public static @Nullable Polygon makeOffsetRoundedBox(
        SegmentAllocator allocator,
        float halfWidth, 
        float halfHeight, 
        Vec2 center, 
        Rot rotation, 
        float radius
    ) {
        MemorySegment segment = makeOffsetRoundedBox(
            allocator,
            halfWidth, 
            halfHeight, 
            center.memorySegment(), 
            rotation.memorySegment(), 
            radius
        );
    
        if (segment.equals(MemorySegment.NULL))
            return null;
    
        return new Polygon(segment);
    }
    
    /**
     * Transform a polygon. This is useful for transferring a shape from one body to another.
     */
    public static MemorySegment transformPolygon(
        SegmentAllocator allocator,
        MemorySegment transform, 
        MemorySegment polygon
    ) {
        MethodHandle method = B2_TRANSFORM_POLYGON.get();
        try {
            return (MemorySegment) method.invokeExact(
                allocator,
                transform, 
                polygon
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #transformPolygon}.
     */
    public static @Nullable Polygon transformPolygon(
        SegmentAllocator allocator,
        Transform transform, 
        Polygon polygon
    ) {
        MemorySegment segment = transformPolygon(
            allocator,
            transform.memorySegment(), 
            polygon.memorySegment()
        );
    
        if (segment.equals(MemorySegment.NULL))
            return null;
    
        return new Polygon(segment);
    }
    
    /**
     * Test a point for overlap with a convex polygon in local space
     */
    public static boolean pointInPolygon(
        MemorySegment point, 
        MemorySegment shape
    ) {
        MethodHandle method = B2_POINT_IN_POLYGON.get();
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
     * Typed method of {@link #pointInPolygon}.
     */
    public final boolean pointInPolygon(
        Vec2 point
    ) {
        return (boolean) pointInPolygon(
            point.memorySegment(), 
            this.segment
        );
    }
    
    /**
     * Ray cast versus polygon shape in local space. Initial overlap is treated as a miss.
     */
    public static MemorySegment rayCastPolygon(
        SegmentAllocator allocator,
        MemorySegment input, 
        MemorySegment shape
    ) {
        MethodHandle method = B2_RAY_CAST_POLYGON.get();
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
     * Typed method of {@link #rayCastPolygon}.
     */
    public final @Nullable CastOutput rayCastPolygon(
        SegmentAllocator allocator,
        RayCastInput input
    ) {
        MemorySegment segment = rayCastPolygon(
            allocator,
            input.memorySegment(), 
            this.segment
        );
    
        if (segment.equals(MemorySegment.NULL))
            return null;
    
        return new CastOutput(segment);
    }
    
    /**
     * Shape cast versus a convex polygon. Initial overlap is treated as a miss.
     */
    public static MemorySegment shapeCastPolygon(
        SegmentAllocator allocator,
        MemorySegment input, 
        MemorySegment shape
    ) {
        MethodHandle method = B2_SHAPE_CAST_POLYGON.get();
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
     * Typed method of {@link #shapeCastPolygon}.
     */
    public final @Nullable CastOutput shapeCastPolygon(
        SegmentAllocator allocator,
        ShapeCastInput input
    ) {
        MemorySegment segment = shapeCastPolygon(
            allocator,
            input.memorySegment(), 
            this.segment
        );
    
        if (segment.equals(MemorySegment.NULL))
            return null;
    
        return new CastOutput(segment);
    }
    
    public Polygon radius(float radius) {
        RADIUS_HANDLE.set(segment, 0L, radius);
        return this;
    }
    
    public float radius() {
        return (float) RADIUS_HANDLE.get(segment, 0L);
    }
    
    public Polygon count(int count) {
        COUNT_HANDLE.set(segment, 0L, count);
        return this;
    }
    
    public int count() {
        return (int) COUNT_HANDLE.get(segment, 0L);
    }
    
    public Polygon vertices(Consumer<Vec2> consumer, int index) {
        consumer.accept(vertices[index]);
        return this;
    }
    
    public Polygon vertices(Vec2 other, int index) {
        vertices[index].set(other);
        return this;
    }
    
    public Vec2 vertices(int index) {
        return vertices[index];
    }
    
    public Polygon normals(Consumer<Vec2> consumer, int index) {
        consumer.accept(normals[index]);
        return this;
    }
    
    public Polygon normals(Vec2 other, int index) {
        normals[index].set(other);
        return this;
    }
    
    public Vec2 normals(int index) {
        return normals[index];
    }
    
    public Polygon centroid(Consumer<Vec2> consumer) {
        consumer.accept(centroid);
        return this;
    }
    
    public Polygon centroid(Vec2 other) {
        centroid.set(other);
        return this;
    }
    
    public Vec2 centroid() {
        return centroid;
    }
    
    @Override
    public Polygon set(Polygon other) {
        return set(other.segment);
    }
    
    @Override
    public Polygon set(MemorySegment src) {
        MemorySegment.copy(src, 0L, segment, 0L, LAYOUT.byteSize());
        return this;
    }
    
    @Override
    public MemorySegment memorySegment() {
        return segment;
    }
    
    public NativeStructArray<Polygon> asArray() {
        return new NativeStructArray<>(this);
    }
    
    public static NativeStructArray<Polygon> array(Arena arena, int count) {
        return new NativeStructArray<>(
            arena,
            LAYOUT,
            segment -> new Polygon(segment),
            count
        );
    }
    
    public static NativeStructArray<Polygon> array(Arena arena, Polygon... structs) {
        NativeStructArray<Polygon> array = new NativeStructArray<>(
            arena,
            LAYOUT,
            segment -> new Polygon(segment),
            structs.length
        );
    
        for (int i = 0; i < structs.length; i++) {
            array.set(i, structs[i]);
        }
    
        return array;
    }
    
    public static NativeStructArray<Polygon> array(MemorySegment array) {
        return new NativeStructArray<>(
            array,
            LAYOUT,
            segment -> new Polygon(segment)
        );
    }
    
}