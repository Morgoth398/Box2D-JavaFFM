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
/// Contact manifold point in local coordinates (frame A).
/// ```
public final class LocalManifoldPoint
		implements Struct<LocalManifoldPoint> {

	public static final StructLayout LAYOUT;

	public static final VarHandle SEPARATION_HANDLE;
	public static final VarHandle ID_HANDLE;

	public static final long POINT_BYTE_OFFSET;
	public static final long SEPARATION_BYTE_OFFSET;
	public static final long ID_BYTE_OFFSET;

	private final MemorySegment segment;

	private final Vec2 point;

	static {
		//@formatter:off
		LAYOUT = MemoryLayout.structLayout(
		    Vec2.LAYOUT.withName("point"),
		    JAVA_FLOAT.withName("separation"),
		    JAVA_SHORT.withName("id"),
		    MemoryLayout.paddingLayout(2)
		).withName("b2LocalManifoldPoint").withByteAlignment(4);
		
		SEPARATION_HANDLE = LAYOUT.varHandle(PathElement.groupElement("separation"));
		ID_HANDLE = LAYOUT.varHandle(PathElement.groupElement("id"));
		
		POINT_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("point"));
		SEPARATION_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("separation"));
		ID_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("id"));
		//@formatter:on
	}

	public LocalManifoldPoint() {
	    this(Arena.ofAuto());
	}
	
	public LocalManifoldPoint(Arena arena) {
	    this(arena.allocate(LAYOUT));
	}
	
	public LocalManifoldPoint(MemorySegment segment) {
	    this.segment = segment;
	
	    point = new Vec2(segment.asSlice(POINT_BYTE_OFFSET, Vec2.LAYOUT));
	}

    /// @see #point()
    public LocalManifoldPoint point(Consumer<Vec2> consumer) {
    	consumer.accept(point);
    	return this;
    }
    
    /// @see #point()
    public LocalManifoldPoint point(Vec2 other) {
    	point.set(other);
    	return this;
    }
    
    /// ```
    /// Contact point in frame A
    /// ```
    public Vec2 point() {
    	return point;
    }
    
    /// @see #separation()
    public LocalManifoldPoint separation(float separation) {
    	SEPARATION_HANDLE.set(segment, 0L, separation);
    	return this;
    }
    
    /// ```
    /// The separation of the contact point, negative if penetrating. May be positive or negative.
    /// ```
    public float separation() {
    	return (float) SEPARATION_HANDLE.get(segment, 0L);
    }
    
    /// @see #id()
    public LocalManifoldPoint id(short id) {
    	ID_HANDLE.set(segment, 0L, id);
    	return this;
    }
    
    /// ```
    /// Uniquely identifies a contact point between two shapes
    /// ```
    public short id() {
    	return (short) ID_HANDLE.get(segment, 0L);
    }
    
    @Override
    public LocalManifoldPoint set(LocalManifoldPoint other) {
        return set(other.segment);
    }
    
    @Override
    public LocalManifoldPoint set(MemorySegment src) {
        MemorySegment.copy(src, 0L, segment, 0L, LAYOUT.byteSize());
        return this;
    }
    
    @Override
    public MemorySegment memorySegment() {
        return segment;
    }
    
    public NativeStructArray<LocalManifoldPoint> asArray() {
        return new NativeStructArray<>(this);
    }
    
    public static NativeStructArray<LocalManifoldPoint> array(Arena arena, int count) {
        return new NativeStructArray<>(
            arena,
            LAYOUT,
            segment -> new LocalManifoldPoint(segment),
            count
        );
    }
    
    public static NativeStructArray<LocalManifoldPoint> array(Arena arena, LocalManifoldPoint... structs) {
        NativeStructArray<LocalManifoldPoint> array = new NativeStructArray<>(
            arena,
            LAYOUT,
            segment -> new LocalManifoldPoint(segment),
            structs.length
        );
    
        for (int i = 0; i < structs.length; i++) {
            array.set(i, structs[i]);
        }
    
        return array;
    }
    
    public static NativeStructArray<LocalManifoldPoint> array(MemorySegment array) {
        return new NativeStructArray<>(
            array,
            LAYOUT,
            segment -> new LocalManifoldPoint(segment)
        );
    }

}