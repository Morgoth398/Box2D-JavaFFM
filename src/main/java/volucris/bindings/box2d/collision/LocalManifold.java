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

/// ```
/// Contact manifold in local coordinates (frame A).
/// ```
public final class LocalManifold
		implements Struct<LocalManifold> {

	public static final StructLayout LAYOUT;

	public static final VarHandle POINT_COUNT_HANDLE;

	public static final long NORMAL_BYTE_OFFSET;
	public static final long POINTS_BYTE_OFFSET;
	public static final long POINT_COUNT_BYTE_OFFSET;

	private final MemorySegment segment;

	private final Vec2 normal;
	private final LocalManifoldPoint[] points;

	static {
		//@formatter:off
		LAYOUT = MemoryLayout.structLayout(
		    Vec2.LAYOUT.withName("normal"),
		    MemoryLayout.sequenceLayout(2, LocalManifoldPoint.LAYOUT).withName("points"),
		    JAVA_INT.withName("pointCount")
		).withName("b2LocalManifold").withByteAlignment(4);
		
		POINT_COUNT_HANDLE = LAYOUT.varHandle(PathElement.groupElement("pointCount"));
		
		NORMAL_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("normal"));
		POINTS_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("points"));
		POINT_COUNT_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("pointCount"));
		//@formatter:on
	}

	public LocalManifold() {
	    this(Arena.ofAuto());
	}
	
	public LocalManifold(Arena arena) {
	    this(arena.allocate(LAYOUT));
	}
	
	public LocalManifold(MemorySegment segment) {
	    this.segment = segment;
	
	    normal = new Vec2(segment.asSlice(NORMAL_BYTE_OFFSET, Vec2.LAYOUT));
	    points = new LocalManifoldPoint[2];
	    for (int i = 0; i < 2; i++) {
	        long offset = POINTS_BYTE_OFFSET + i * LocalManifoldPoint.LAYOUT.byteSize();
	        points[i] = new LocalManifoldPoint(segment.asSlice(offset, LocalManifoldPoint.LAYOUT));
	    }
	}

    /// @see #normal()
    public LocalManifold normal(Consumer<Vec2> consumer) {
    	consumer.accept(normal);
    	return this;
    }
    
    /// @see #normal()
    public LocalManifold normal(Vec2 other) {
    	normal.set(other);
    	return this;
    }
    
    /// ```
    /// The unit normal vector in frame A, points from shape A to shape B
    /// ```
    public Vec2 normal() {
    	return normal;
    }
    
    /// @see #points(int)
    public LocalManifold points(Consumer<LocalManifoldPoint> consumer, int index) {
    	consumer.accept(points[index]);
    	return this;
    }
    
    /// @see #points(int)
    public LocalManifold points(LocalManifoldPoint other, int index) {
    	points[index].set(other);
    	return this;
    }
    
    /// ```
    /// The manifold points, up to two are possible in 2D
    /// ```
    public LocalManifoldPoint points(int index) {
    	return points[index];
    }
    
    /// @see #pointCount()
    public LocalManifold pointCount(int pointCount) {
    	POINT_COUNT_HANDLE.set(segment, 0L, pointCount);
    	return this;
    }
    
    /// ```
    /// The number of contact points, will be 0, 1, or 2
    /// ```
    public int pointCount() {
    	return (int) POINT_COUNT_HANDLE.get(segment, 0L);
    }
    
    @Override
    public LocalManifold set(LocalManifold other) {
        return set(other.segment);
    }
    
    @Override
    public LocalManifold set(MemorySegment src) {
        MemorySegment.copy(src, 0L, segment, 0L, LAYOUT.byteSize());
        return this;
    }
    
    @Override
    public MemorySegment memorySegment() {
        return segment;
    }
    
    public NativeStructArray<LocalManifold> asArray() {
        return new NativeStructArray<>(this);
    }
    
    public static NativeStructArray<LocalManifold> array(Arena arena, int count) {
        return new NativeStructArray<>(
            arena,
            LAYOUT,
            segment -> new LocalManifold(segment),
            count
        );
    }
    
    public static NativeStructArray<LocalManifold> array(Arena arena, LocalManifold... structs) {
        NativeStructArray<LocalManifold> array = new NativeStructArray<>(
            arena,
            LAYOUT,
            segment -> new LocalManifold(segment),
            structs.length
        );
    
        for (int i = 0; i < structs.length; i++) {
            array.set(i, structs[i]);
        }
    
        return array;
    }
    
    public static NativeStructArray<LocalManifold> array(MemorySegment array) {
        return new NativeStructArray<>(
            array,
            LAYOUT,
            segment -> new LocalManifold(segment)
        );
    }

}