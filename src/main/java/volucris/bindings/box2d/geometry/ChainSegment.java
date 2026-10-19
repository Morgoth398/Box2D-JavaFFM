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

/// ```
/// A line segment with one-sided collision. Only collides on the right side. Several of these are
/// generated for a chain shape.
/// ghost1 -> point1 -> point2 -> ghost2
/// ```
public final class ChainSegment
		implements Struct<ChainSegment> {

	public static final StructLayout LAYOUT;

	public static final VarHandle CHAIN_ID_HANDLE;

	public static final long GHOST1_BYTE_OFFSET;
	public static final long SEGMENT_BYTE_OFFSET;
	public static final long GHOST2_BYTE_OFFSET;
	public static final long CHAIN_ID_BYTE_OFFSET;

	private final MemorySegment memorySegment;

	private final Vec2 ghost1;
	private final Segment segment;
	private final Vec2 ghost2;

	static {
		//@formatter:off
		LAYOUT = MemoryLayout.structLayout(
		    Vec2.LAYOUT.withName("ghost1"),
		    Segment.LAYOUT.withName("segment"),
		    Vec2.LAYOUT.withName("ghost2"),
		    JAVA_INT.withName("chainId")
		).withName("b2ChainSegment").withByteAlignment(4);
		
		CHAIN_ID_HANDLE = LAYOUT.varHandle(PathElement.groupElement("chainId"));
		
		GHOST1_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("ghost1"));
		SEGMENT_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("segment"));
		GHOST2_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("ghost2"));
		CHAIN_ID_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("chainId"));
		//@formatter:on
	}

	public ChainSegment() {
	    this(Arena.ofAuto());
	}
	
	public ChainSegment(Arena arena) {
	    this(arena.allocate(LAYOUT));
	}
	
	public ChainSegment(MemorySegment memorySegment) {
	    this.memorySegment = memorySegment;
	
	    ghost1 = new Vec2(memorySegment.asSlice(GHOST1_BYTE_OFFSET, Vec2.LAYOUT));
	    segment = new Segment(memorySegment.asSlice(SEGMENT_BYTE_OFFSET, Segment.LAYOUT));
	    ghost2 = new Vec2(memorySegment.asSlice(GHOST2_BYTE_OFFSET, Vec2.LAYOUT));
	}

    /// @see #ghost1()
    public ChainSegment ghost1(Consumer<Vec2> consumer) {
    	consumer.accept(ghost1);
    	return this;
    }
    
    /// @see #ghost1()
    public ChainSegment ghost1(Vec2 other) {
    	ghost1.set(other);
    	return this;
    }
    
    /// ```
    /// The tail ghost vertex
    /// ```
    public Vec2 ghost1() {
    	return ghost1;
    }
    
    /// @see #segment()
    public ChainSegment segment(Consumer<Segment> consumer) {
    	consumer.accept(segment);
    	return this;
    }
    
    /// @see #segment()
    public ChainSegment segment(Segment other) {
    	segment.set(other);
    	return this;
    }
    
    /// ```
    /// The line segment
    /// ```
    public Segment segment() {
    	return segment;
    }
    
    /// @see #ghost2()
    public ChainSegment ghost2(Consumer<Vec2> consumer) {
    	consumer.accept(ghost2);
    	return this;
    }
    
    /// @see #ghost2()
    public ChainSegment ghost2(Vec2 other) {
    	ghost2.set(other);
    	return this;
    }
    
    /// ```
    /// The head ghost vertex
    /// ```
    public Vec2 ghost2() {
    	return ghost2;
    }
    
    /// @see #chainId()
    public ChainSegment chainId(int chainId) {
    	CHAIN_ID_HANDLE.set(segment, 0L, chainId);
    	return this;
    }
    
    /// ```
    /// The owning chain shape index (internal usage only)
    /// ```
    public int chainId() {
    	return (int) CHAIN_ID_HANDLE.get(segment, 0L);
    }
    
    @Override
    public ChainSegment set(ChainSegment other) {
        return set(other.memorySegment);
    }
    
    @Override
    public ChainSegment set(MemorySegment src) {
        MemorySegment.copy(src, 0L, memorySegment, 0L, LAYOUT.byteSize());
        return this;
    }
    
    @Override
    public MemorySegment memorySegment() {
        return memorySegment;
    }
    
    public NativeStructArray<ChainSegment> asArray() {
        return new NativeStructArray<>(this);
    }
    
    public static NativeStructArray<ChainSegment> array(Arena arena, int count) {
        return new NativeStructArray<>(
            arena,
            LAYOUT,
            segment -> new ChainSegment(segment),
            count
        );
    }
    
    public static NativeStructArray<ChainSegment> array(Arena arena, ChainSegment... structs) {
        NativeStructArray<ChainSegment> array = new NativeStructArray<>(
            arena,
            LAYOUT,
            segment -> new ChainSegment(segment),
            structs.length
        );
    
        for (int i = 0; i < structs.length; i++) {
            array.set(i, structs[i]);
        }
    
        return array;
    }
    
    public static NativeStructArray<ChainSegment> array(MemorySegment array) {
        return new NativeStructArray<>(
            array,
            LAYOUT,
            segment -> new ChainSegment(segment)
        );
    }

}