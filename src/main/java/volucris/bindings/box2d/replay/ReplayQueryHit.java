/*
 * MACHINE GENERATED FILE, DO NOT EDIT.
 */
package volucris.bindings.box2d.replay;

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

/// ```
/// One result of a recorded spatial query.
/// @ingroup replay
/// ```
public final class ReplayQueryHit
		implements Struct<ReplayQueryHit> {

	public static final StructLayout LAYOUT;

	public static final VarHandle FRACTION_HANDLE;

	public static final long SHAPE_ID_BYTE_OFFSET;
	public static final long POINT_BYTE_OFFSET;
	public static final long NORMAL_BYTE_OFFSET;
	public static final long FRACTION_BYTE_OFFSET;

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
		    JAVA_FLOAT.withName("fraction")
		).withName("b2ReplayQueryHit").withByteAlignment(4);
		
		FRACTION_HANDLE = LAYOUT.varHandle(PathElement.groupElement("fraction"));
		
		SHAPE_ID_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("shapeId"));
		POINT_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("point"));
		NORMAL_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("normal"));
		FRACTION_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("fraction"));
		//@formatter:on
	}

	public ReplayQueryHit() {
	    this(Arena.ofAuto());
	}
	
	public ReplayQueryHit(Arena arena) {
	    this(arena.allocate(LAYOUT));
	}
	
	public ReplayQueryHit(MemorySegment segment) {
	    this.segment = segment;
	
	    shapeId = new ShapeId(segment.asSlice(SHAPE_ID_BYTE_OFFSET, ShapeId.LAYOUT));
	    point = new Vec2(segment.asSlice(POINT_BYTE_OFFSET, Vec2.LAYOUT));
	    normal = new Vec2(segment.asSlice(NORMAL_BYTE_OFFSET, Vec2.LAYOUT));
	}

    /// @see #shapeId()
    public ReplayQueryHit shapeId(Consumer<ShapeId> consumer) {
    	consumer.accept(shapeId);
    	return this;
    }
    
    /// @see #shapeId()
    public ReplayQueryHit shapeId(ShapeId other) {
    	shapeId.set(other);
    	return this;
    }
    
    /// ```
    /// the shape hit
    /// ```
    public ShapeId shapeId() {
    	return shapeId;
    }
    
    /// @see #point()
    public ReplayQueryHit point(Consumer<Vec2> consumer) {
    	consumer.accept(point);
    	return this;
    }
    
    /// @see #point()
    public ReplayQueryHit point(Vec2 other) {
    	point.set(other);
    	return this;
    }
    
    /// ```
    /// the hit point on the shape surface
    /// ```
    public Vec2 point() {
    	return point;
    }
    
    /// @see #normal()
    public ReplayQueryHit normal(Consumer<Vec2> consumer) {
    	consumer.accept(normal);
    	return this;
    }
    
    /// @see #normal()
    public ReplayQueryHit normal(Vec2 other) {
    	normal.set(other);
    	return this;
    }
    
    /// ```
    /// the unit normal vector at the hit point
    /// ```
    public Vec2 normal() {
    	return normal;
    }
    
    /// @see #fraction()
    public ReplayQueryHit fraction(float fraction) {
    	FRACTION_HANDLE.set(segment, 0L, fraction);
    	return this;
    }
    
    /// ```
    /// the query translation fraction
    /// ```
    public float fraction() {
    	return (float) FRACTION_HANDLE.get(segment, 0L);
    }
    
    @Override
    public ReplayQueryHit set(ReplayQueryHit other) {
        return set(other.segment);
    }
    
    @Override
    public ReplayQueryHit set(MemorySegment src) {
        MemorySegment.copy(src, 0L, segment, 0L, LAYOUT.byteSize());
        return this;
    }
    
    @Override
    public MemorySegment memorySegment() {
        return segment;
    }
    
    public NativeStructArray<ReplayQueryHit> asArray() {
        return new NativeStructArray<>(this);
    }
    
    public static NativeStructArray<ReplayQueryHit> array(Arena arena, int count) {
        return new NativeStructArray<>(
            arena,
            LAYOUT,
            segment -> new ReplayQueryHit(segment),
            count
        );
    }
    
    public static NativeStructArray<ReplayQueryHit> array(Arena arena, ReplayQueryHit... structs) {
        NativeStructArray<ReplayQueryHit> array = new NativeStructArray<>(
            arena,
            LAYOUT,
            segment -> new ReplayQueryHit(segment),
            structs.length
        );
    
        for (int i = 0; i < structs.length; i++) {
            array.set(i, structs[i]);
        }
    
        return array;
    }
    
    public static NativeStructArray<ReplayQueryHit> array(MemorySegment array) {
        return new NativeStructArray<>(
            array,
            LAYOUT,
            segment -> new ReplayQueryHit(segment)
        );
    }

}