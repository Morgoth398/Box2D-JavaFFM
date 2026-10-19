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
import volucris.bindings.box2d.math.AABB;
import volucris.bindings.core.NativeStructArray;
import volucris.bindings.core.Struct;

import static java.lang.foreign.ValueLayout.*;

/// ```
/// Static metadata describing a recording, resolved once when the player opens the file.
/// @ingroup replay
/// ```
public final class ReplayInfo
		implements Struct<ReplayInfo> {

	public static final StructLayout LAYOUT;

	public static final VarHandle FRAME_COUNT_HANDLE;
	public static final VarHandle WORKER_COUNT_HANDLE;
	public static final VarHandle TIME_STEP_HANDLE;
	public static final VarHandle SUB_STEP_COUNT_HANDLE;
	public static final VarHandle LENGTH_SCALE_HANDLE;

	public static final long FRAME_COUNT_BYTE_OFFSET;
	public static final long WORKER_COUNT_BYTE_OFFSET;
	public static final long TIME_STEP_BYTE_OFFSET;
	public static final long SUB_STEP_COUNT_BYTE_OFFSET;
	public static final long LENGTH_SCALE_BYTE_OFFSET;
	public static final long BOUNDS_BYTE_OFFSET;

	private final MemorySegment segment;

	private final AABB bounds;

	static {
		//@formatter:off
		LAYOUT = MemoryLayout.structLayout(
		    JAVA_INT.withName("frameCount"),
		    JAVA_INT.withName("workerCount"),
		    JAVA_FLOAT.withName("timeStep"),
		    JAVA_INT.withName("subStepCount"),
		    JAVA_FLOAT.withName("lengthScale"),
		    AABB.LAYOUT.withName("bounds")
		).withName("b2ReplayInfo").withByteAlignment(4);
		
		FRAME_COUNT_HANDLE = LAYOUT.varHandle(PathElement.groupElement("frameCount"));
		WORKER_COUNT_HANDLE = LAYOUT.varHandle(PathElement.groupElement("workerCount"));
		TIME_STEP_HANDLE = LAYOUT.varHandle(PathElement.groupElement("timeStep"));
		SUB_STEP_COUNT_HANDLE = LAYOUT.varHandle(PathElement.groupElement("subStepCount"));
		LENGTH_SCALE_HANDLE = LAYOUT.varHandle(PathElement.groupElement("lengthScale"));
		
		FRAME_COUNT_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("frameCount"));
		WORKER_COUNT_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("workerCount"));
		TIME_STEP_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("timeStep"));
		SUB_STEP_COUNT_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("subStepCount"));
		LENGTH_SCALE_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("lengthScale"));
		BOUNDS_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("bounds"));
		//@formatter:on
	}

	public ReplayInfo() {
	    this(Arena.ofAuto());
	}
	
	public ReplayInfo(Arena arena) {
	    this(arena.allocate(LAYOUT));
	}
	
	public ReplayInfo(MemorySegment segment) {
	    this.segment = segment;
	
	    bounds = new AABB(segment.asSlice(BOUNDS_BYTE_OFFSET, AABB.LAYOUT));
	}

    /// @see #frameCount()
    public ReplayInfo frameCount(int frameCount) {
    	FRAME_COUNT_HANDLE.set(segment, 0L, frameCount);
    	return this;
    }
    
    /// ```
    /// total recorded steps
    /// ```
    public int frameCount() {
    	return (int) FRAME_COUNT_HANDLE.get(segment, 0L);
    }
    
    /// @see #workerCount()
    public ReplayInfo workerCount(int workerCount) {
    	WORKER_COUNT_HANDLE.set(segment, 0L, workerCount);
    	return this;
    }
    
    /// ```
    /// worker count used for the replay world
    /// ```
    public int workerCount() {
    	return (int) WORKER_COUNT_HANDLE.get(segment, 0L);
    }
    
    /// @see #timeStep()
    public ReplayInfo timeStep(float timeStep) {
    	TIME_STEP_HANDLE.set(segment, 0L, timeStep);
    	return this;
    }
    
    /// ```
    /// dt of the recorded steps
    /// ```
    public float timeStep() {
    	return (float) TIME_STEP_HANDLE.get(segment, 0L);
    }
    
    /// @see #subStepCount()
    public ReplayInfo subStepCount(int subStepCount) {
    	SUB_STEP_COUNT_HANDLE.set(segment, 0L, subStepCount);
    	return this;
    }
    
    /// ```
    /// recorded sub-steps
    /// ```
    public int subStepCount() {
    	return (int) SUB_STEP_COUNT_HANDLE.get(segment, 0L);
    }
    
    /// @see #lengthScale()
    public ReplayInfo lengthScale(float lengthScale) {
    	LENGTH_SCALE_HANDLE.set(segment, 0L, lengthScale);
    	return this;
    }
    
    /// ```
    /// length units per meter in effect when recorded
    /// ```
    public float lengthScale() {
    	return (float) LENGTH_SCALE_HANDLE.get(segment, 0L);
    }
    
    /// @see #bounds()
    public ReplayInfo bounds(Consumer<AABB> consumer) {
    	consumer.accept(bounds);
    	return this;
    }
    
    /// @see #bounds()
    public ReplayInfo bounds(AABB other) {
    	bounds.set(other);
    	return this;
    }
    
    /// ```
    /// accumulated world bounds over the recording, zero-extent if unavailable
    /// ```
    public AABB bounds() {
    	return bounds;
    }
    
    @Override
    public ReplayInfo set(ReplayInfo other) {
        return set(other.segment);
    }
    
    @Override
    public ReplayInfo set(MemorySegment src) {
        MemorySegment.copy(src, 0L, segment, 0L, LAYOUT.byteSize());
        return this;
    }
    
    @Override
    public MemorySegment memorySegment() {
        return segment;
    }
    
    public NativeStructArray<ReplayInfo> asArray() {
        return new NativeStructArray<>(this);
    }
    
    public static NativeStructArray<ReplayInfo> array(Arena arena, int count) {
        return new NativeStructArray<>(
            arena,
            LAYOUT,
            segment -> new ReplayInfo(segment),
            count
        );
    }
    
    public static NativeStructArray<ReplayInfo> array(Arena arena, ReplayInfo... structs) {
        NativeStructArray<ReplayInfo> array = new NativeStructArray<>(
            arena,
            LAYOUT,
            segment -> new ReplayInfo(segment),
            structs.length
        );
    
        for (int i = 0; i < structs.length; i++) {
            array.set(i, structs[i]);
        }
    
        return array;
    }
    
    public static NativeStructArray<ReplayInfo> array(MemorySegment array) {
        return new NativeStructArray<>(
            array,
            LAYOUT,
            segment -> new ReplayInfo(segment)
        );
    }

}