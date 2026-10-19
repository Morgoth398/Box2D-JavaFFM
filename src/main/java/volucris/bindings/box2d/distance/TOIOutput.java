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

/// ```
/// Time of impact output
/// ```
public final class TOIOutput
		implements Struct<TOIOutput> {

	public static final StructLayout LAYOUT;

	public static final VarHandle STATE_HANDLE;
	public static final VarHandle FRACTION_HANDLE;

	public static final long STATE_BYTE_OFFSET;
	public static final long POINT_BYTE_OFFSET;
	public static final long NORMAL_BYTE_OFFSET;
	public static final long FRACTION_BYTE_OFFSET;

	private final MemorySegment segment;

	private final Vec2 point;
	private final Vec2 normal;

	static {
		//@formatter:off
		LAYOUT = MemoryLayout.structLayout(
		    JAVA_INT.withName("state"),
		    Vec2.LAYOUT.withName("point"),
		    Vec2.LAYOUT.withName("normal"),
		    JAVA_FLOAT.withName("fraction")
		).withName("b2TOIOutput").withByteAlignment(4);
		
		STATE_HANDLE = LAYOUT.varHandle(PathElement.groupElement("state"));
		FRACTION_HANDLE = LAYOUT.varHandle(PathElement.groupElement("fraction"));
		
		STATE_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("state"));
		POINT_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("point"));
		NORMAL_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("normal"));
		FRACTION_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("fraction"));
		//@formatter:on
	}

	public TOIOutput() {
	    this(Arena.ofAuto());
	}
	
	public TOIOutput(Arena arena) {
	    this(arena.allocate(LAYOUT));
	}
	
	public TOIOutput(MemorySegment segment) {
	    this.segment = segment;
	
	    point = new Vec2(segment.asSlice(POINT_BYTE_OFFSET, Vec2.LAYOUT));
	    normal = new Vec2(segment.asSlice(NORMAL_BYTE_OFFSET, Vec2.LAYOUT));
	}

    /// @see #state()
    public TOIOutput state(int state) {
    	STATE_HANDLE.set(segment, 0L, state);
    	return this;
    }
    
    /// ```
    /// The type of result
    /// ```
    public int state() {
    	return (int) STATE_HANDLE.get(segment, 0L);
    }
    
    /// @see #point()
    public TOIOutput point(Consumer<Vec2> consumer) {
    	consumer.accept(point);
    	return this;
    }
    
    /// @see #point()
    public TOIOutput point(Vec2 other) {
    	point.set(other);
    	return this;
    }
    
    /// ```
    /// The hit point
    /// ```
    public Vec2 point() {
    	return point;
    }
    
    /// @see #normal()
    public TOIOutput normal(Consumer<Vec2> consumer) {
    	consumer.accept(normal);
    	return this;
    }
    
    /// @see #normal()
    public TOIOutput normal(Vec2 other) {
    	normal.set(other);
    	return this;
    }
    
    /// ```
    /// The hit normal
    /// ```
    public Vec2 normal() {
    	return normal;
    }
    
    /// @see #fraction()
    public TOIOutput fraction(float fraction) {
    	FRACTION_HANDLE.set(segment, 0L, fraction);
    	return this;
    }
    
    /// ```
    /// The sweep time of the collision
    /// ```
    public float fraction() {
    	return (float) FRACTION_HANDLE.get(segment, 0L);
    }
    
    @Override
    public TOIOutput set(TOIOutput other) {
        return set(other.segment);
    }
    
    @Override
    public TOIOutput set(MemorySegment src) {
        MemorySegment.copy(src, 0L, segment, 0L, LAYOUT.byteSize());
        return this;
    }
    
    @Override
    public MemorySegment memorySegment() {
        return segment;
    }
    
    public NativeStructArray<TOIOutput> asArray() {
        return new NativeStructArray<>(this);
    }
    
    public static NativeStructArray<TOIOutput> array(Arena arena, int count) {
        return new NativeStructArray<>(
            arena,
            LAYOUT,
            segment -> new TOIOutput(segment),
            count
        );
    }
    
    public static NativeStructArray<TOIOutput> array(Arena arena, TOIOutput... structs) {
        NativeStructArray<TOIOutput> array = new NativeStructArray<>(
            arena,
            LAYOUT,
            segment -> new TOIOutput(segment),
            structs.length
        );
    
        for (int i = 0; i < structs.length; i++) {
            array.set(i, structs[i]);
        }
    
        return array;
    }
    
    public static NativeStructArray<TOIOutput> array(MemorySegment array) {
        return new NativeStructArray<>(
            array,
            LAYOUT,
            segment -> new TOIOutput(segment)
        );
    }

}