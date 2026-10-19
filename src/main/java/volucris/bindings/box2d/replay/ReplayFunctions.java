/*
 * MACHINE GENERATED FILE, DO NOT EDIT.
 */
package volucris.bindings.box2d.replay;

import java.lang.foreign.MemorySegment;
import java.lang.foreign.SegmentAllocator;
import java.lang.invoke.MethodHandle;
import org.jspecify.annotations.Nullable;
import volucris.bindings.box2d.body.BodyId;
import volucris.bindings.box2d.world.WorldId;
import volucris.bindings.box2d.world.debug.DebugDraw;

import static java.lang.foreign.ValueLayout.*;
import static volucris.bindings.core.FFMUtils.*;

public final class ReplayFunctions {

	private static final LazyConstant<MethodHandle> B2_VALIDATE_RECORDING;
	private static final LazyConstant<MethodHandle> B2_CREATE_REPLAY;
	private static final LazyConstant<MethodHandle> B2_DESTROY_REPLAY;
	private static final LazyConstant<MethodHandle> B2_REPLAY_STEP_FRAME;
	private static final LazyConstant<MethodHandle> B2_REPLAY_GET_WORLD_ID;
	private static final LazyConstant<MethodHandle> B2_REPLAY_RESTART;
	private static final LazyConstant<MethodHandle> B2_REPLAY_SEEK_FRAME;
	private static final LazyConstant<MethodHandle> B2_REPLAY_GET_FRAME;
	private static final LazyConstant<MethodHandle> B2_REPLAY_GET_INFO;
	private static final LazyConstant<MethodHandle> B2_REPLAY_IS_AT_END;
	private static final LazyConstant<MethodHandle> B2_REPLAY_HAS_DIVERGED;
	private static final LazyConstant<MethodHandle> B2_REPLAY_GET_DIVERGE_FRAME;
	private static final LazyConstant<MethodHandle> B2_REPLAY_SET_KEYFRAME_POLICY;
	private static final LazyConstant<MethodHandle> B2_REPLAY_GET_KEYFRAME_BUDGET;
	private static final LazyConstant<MethodHandle> B2_REPLAY_GET_KEYFRAME_MIN_INTERVAL;
	private static final LazyConstant<MethodHandle> B2_REPLAY_GET_KEYFRAME_INTERVAL;
	private static final LazyConstant<MethodHandle> B2_REPLAY_GET_KEYFRAME_BYTES;
	private static final LazyConstant<MethodHandle> B2_REPLAY_DRAW_FRAME_QUERIES;
	private static final LazyConstant<MethodHandle> B2_REPLAY_GET_FRAME_QUERY_COUNT;
	private static final LazyConstant<MethodHandle> B2_REPLAY_GET_FRAME_QUERY;
	private static final LazyConstant<MethodHandle> B2_REPLAY_GET_FRAME_QUERY_HIT;
	private static final LazyConstant<MethodHandle> B2_REPLAY_GET_BODY_COUNT;
	private static final LazyConstant<MethodHandle> B2_REPLAY_GET_BODY_ID;

	static {
		//@formatter:off
		B2_VALIDATE_RECORDING = downcallHandle("b2ValidateRecording", JAVA_BOOLEAN, UNBOUNDED_ADDRESS, JAVA_INT, JAVA_INT);
		B2_CREATE_REPLAY = downcallHandle("b2CreateReplay", UNBOUNDED_ADDRESS, UNBOUNDED_ADDRESS, JAVA_INT, JAVA_INT);
		B2_DESTROY_REPLAY = downcallHandleVoid("b2DestroyReplay", UNBOUNDED_ADDRESS);
		B2_REPLAY_STEP_FRAME = downcallHandle("b2Replay_StepFrame", JAVA_BOOLEAN, UNBOUNDED_ADDRESS);
		B2_REPLAY_GET_WORLD_ID = downcallHandle("b2Replay_GetWorldId", WorldId.LAYOUT, UNBOUNDED_ADDRESS);
		B2_REPLAY_RESTART = downcallHandleVoid("b2Replay_Restart", UNBOUNDED_ADDRESS);
		B2_REPLAY_SEEK_FRAME = downcallHandleVoid("b2Replay_SeekFrame", UNBOUNDED_ADDRESS, JAVA_INT);
		B2_REPLAY_GET_FRAME = downcallHandle("b2Replay_GetFrame", JAVA_INT, UNBOUNDED_ADDRESS);
		B2_REPLAY_GET_INFO = downcallHandle("b2Replay_GetInfo", ReplayInfo.LAYOUT, UNBOUNDED_ADDRESS);
		B2_REPLAY_IS_AT_END = downcallHandle("b2Replay_IsAtEnd", JAVA_BOOLEAN, UNBOUNDED_ADDRESS);
		B2_REPLAY_HAS_DIVERGED = downcallHandle("b2Replay_HasDiverged", JAVA_BOOLEAN, UNBOUNDED_ADDRESS);
		B2_REPLAY_GET_DIVERGE_FRAME = downcallHandle("b2Replay_GetDivergeFrame", JAVA_INT, UNBOUNDED_ADDRESS);
		B2_REPLAY_SET_KEYFRAME_POLICY = downcallHandleVoid("b2Replay_SetKeyframePolicy", UNBOUNDED_ADDRESS, JAVA_LONG, JAVA_INT);
		B2_REPLAY_GET_KEYFRAME_BUDGET = downcallHandle("b2Replay_GetKeyframeBudget", JAVA_LONG, UNBOUNDED_ADDRESS);
		B2_REPLAY_GET_KEYFRAME_MIN_INTERVAL = downcallHandle("b2Replay_GetKeyframeMinInterval", JAVA_INT, UNBOUNDED_ADDRESS);
		B2_REPLAY_GET_KEYFRAME_INTERVAL = downcallHandle("b2Replay_GetKeyframeInterval", JAVA_INT, UNBOUNDED_ADDRESS);
		B2_REPLAY_GET_KEYFRAME_BYTES = downcallHandle("b2Replay_GetKeyframeBytes", JAVA_LONG, UNBOUNDED_ADDRESS);
		B2_REPLAY_DRAW_FRAME_QUERIES = downcallHandleVoid("b2Replay_DrawFrameQueries", UNBOUNDED_ADDRESS, UNBOUNDED_ADDRESS, JAVA_INT);
		B2_REPLAY_GET_FRAME_QUERY_COUNT = downcallHandle("b2Replay_GetFrameQueryCount", JAVA_INT, UNBOUNDED_ADDRESS);
		B2_REPLAY_GET_FRAME_QUERY = downcallHandle("b2Replay_GetFrameQuery", ReplayQueryInfo.LAYOUT, UNBOUNDED_ADDRESS, JAVA_INT);
		B2_REPLAY_GET_FRAME_QUERY_HIT = downcallHandle("b2Replay_GetFrameQueryHit", ReplayQueryHit.LAYOUT, UNBOUNDED_ADDRESS, JAVA_INT, JAVA_INT);
		B2_REPLAY_GET_BODY_COUNT = downcallHandle("b2Replay_GetBodyCount", JAVA_INT, UNBOUNDED_ADDRESS);
		B2_REPLAY_GET_BODY_ID = downcallHandle("b2Replay_GetBodyId", BodyId.LAYOUT, UNBOUNDED_ADDRESS, JAVA_INT);
		//@formatter:on
	}

	private ReplayFunctions() {
	}

    /// ```
    /// Replay a recording by re-running the engine and asserting recorded ids and state match.
    /// @param data Recorded bytes.
    /// @param size Number of recorded bytes
    /// @param workerCount Worker count to use for replay. 0 uses the serial single-worker fallback.
    /// @return true if replay completed without divergence, false on any mismatch
    /// ```
    public static boolean validateRecording(
    	MemorySegment data,
    	int size,
    	int workerCount
    ) {
    	MethodHandle method = B2_VALIDATE_RECORDING.get();
    	try {
    		return (boolean) method.invokeExact(
    			data,
    			size,
    			workerCount
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// ```
    /// Open a recording for incremental playback and replay up to the first step. The player copies the
    /// bytes, so you may free or destroy the source buffer immediately after this call.
    /// @param data Recorded bytes
    /// @param size Number of recorded bytes
    /// @param workerCount Worker count for the replay world. 0 uses the serial single-worker fallback.
    /// @return A player handle, or NULL if the recording is malformed
    /// ```
    public static MemorySegment ncreateReplay(
    	MemorySegment data,
    	int size,
    	int workerCount
    ) {
    	MethodHandle method = B2_CREATE_REPLAY.get();
    	try {
    		return (MemorySegment) method.invokeExact(
    			data,
    			size,
    			workerCount
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#ncreateReplay].
    public static @Nullable Replay createReplay(
    	MemorySegment data,
    	int size,
    	int workerCount
    ) {
    	MemorySegment segment = ncreateReplay(
    		data,
    		size,
    		workerCount
    	);
    
    	if (segment.equals(MemorySegment.NULL))
    		return null;
    	
    	return new Replay(segment);
    }
    
    /// ```
    /// Close a player and free its replay world and file buffer.
    /// ```
    public static void destroyReplay(
    	MemorySegment player
    ) {
    	MethodHandle method = B2_DESTROY_REPLAY.get();
    	try {
    		 method.invokeExact(
    			player
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#destroyReplay].
    public static void destroyReplay(
    	Replay player
    ) {
    	destroyReplay(
    		player.memorySegment()
    	);
    }
    
    /// ```
    /// Advance the replay by one recorded step.
    /// @return true if a step executed, false once the end of the recording is reached
    /// ```
    public static boolean stepFrame(
    	MemorySegment player
    ) {
    	MethodHandle method = B2_REPLAY_STEP_FRAME.get();
    	try {
    		return (boolean) method.invokeExact(
    			player
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#stepFrame].
    public static boolean stepFrame(
    	Replay player
    ) {
    	return stepFrame(
    		player.memorySegment()
    	);
    }
    
    /// ```
    /// Get the id of the replayed world.
    /// ```
    public static MemorySegment getWorldId(
    	SegmentAllocator allocator,
    	MemorySegment player
    ) {
    	MethodHandle method = B2_REPLAY_GET_WORLD_ID.get();
    	try {
    		return (MemorySegment) method.invokeExact(
    			allocator,
    			player
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#getWorldId].
    public static @Nullable WorldId getWorldId(
    	SegmentAllocator allocator,
    	Replay player
    ) {
    	MemorySegment segment = getWorldId(
    		allocator,
    		player.memorySegment()
    	);
    
    	if (segment.equals(MemorySegment.NULL))
    		return null;
    	
    	return new WorldId(segment);
    }
    
    /// ```
    /// Rewind the player to the first step, recreating the replay world from the file.
    /// ```
    public static void restart(
    	MemorySegment player
    ) {
    	MethodHandle method = B2_REPLAY_RESTART.get();
    	try {
    		 method.invokeExact(
    			player
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#restart].
    public static void restart(
    	Replay player
    ) {
    	restart(
    		player.memorySegment()
    	);
    }
    
    /// ```
    /// Seek to a recorded step. Seeking backward rewinds and re-runs from the nearest keyframe. Clamps
    /// to the recording bounds.
    /// ```
    public static void seekFrame(
    	MemorySegment player,
    	int targetFrame
    ) {
    	MethodHandle method = B2_REPLAY_SEEK_FRAME.get();
    	try {
    		 method.invokeExact(
    			player,
    			targetFrame
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#seekFrame].
    public static void seekFrame(
    	Replay player,
    	int targetFrame
    ) {
    	seekFrame(
    		player.memorySegment(),
    		targetFrame
    	);
    }
    
    /// ```
    /// Get the number of steps replayed so far.
    /// ```
    public static int getFrame(
    	MemorySegment player
    ) {
    	MethodHandle method = B2_REPLAY_GET_FRAME.get();
    	try {
    		return (int) method.invokeExact(
    			player
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#getFrame].
    public static int getFrame(
    	Replay player
    ) {
    	return getFrame(
    		player.memorySegment()
    	);
    }
    
    /// ```
    /// Get static metadata for the recording (frame count, recorded tuning, time).
    /// ```
    public static MemorySegment getInfo(
    	SegmentAllocator allocator,
    	MemorySegment player
    ) {
    	MethodHandle method = B2_REPLAY_GET_INFO.get();
    	try {
    		return (MemorySegment) method.invokeExact(
    			allocator,
    			player
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#getInfo].
    public static @Nullable ReplayInfo getInfo(
    	SegmentAllocator allocator,
    	Replay player
    ) {
    	MemorySegment segment = getInfo(
    		allocator,
    		player.memorySegment()
    	);
    
    	if (segment.equals(MemorySegment.NULL))
    		return null;
    	
    	return new ReplayInfo(segment);
    }
    
    /// ```
    /// Returns true once the end of the recording has been reached.
    /// ```
    public static boolean isAtEnd(
    	MemorySegment player
    ) {
    	MethodHandle method = B2_REPLAY_IS_AT_END.get();
    	try {
    		return (boolean) method.invokeExact(
    			player
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#isAtEnd].
    public static boolean isAtEnd(
    	Replay player
    ) {
    	return isAtEnd(
    		player.memorySegment()
    	);
    }
    
    /// ```
    /// Returns true if a recorded state hash failed to reproduce, meaning replay diverged.
    /// ```
    public static boolean hasDiverged(
    	MemorySegment player
    ) {
    	MethodHandle method = B2_REPLAY_HAS_DIVERGED.get();
    	try {
    		return (boolean) method.invokeExact(
    			player
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#hasDiverged].
    public static boolean hasDiverged(
    	Replay player
    ) {
    	return hasDiverged(
    		player.memorySegment()
    	);
    }
    
    /// ```
    /// Get the first step at which replay diverged, or -1 if it has not diverged.
    /// ```
    public static int getDivergeFrame(
    	MemorySegment player
    ) {
    	MethodHandle method = B2_REPLAY_GET_DIVERGE_FRAME.get();
    	try {
    		return (int) method.invokeExact(
    			player
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#getDivergeFrame].
    public static int getDivergeFrame(
    	Replay player
    ) {
    	return getDivergeFrame(
    		player.memorySegment()
    	);
    }
    
    /// ```
    /// Tune the keyframe ring used to speed up backward seeking. A keyframe is a periodic snapshot the
    /// player restores from instead of replaying from the start, trading memory for seek speed.
    /// @param player the recording player
    /// @param budgetBytes Memory cap for the kept snapshots. The spacing widens to stay under it.
    /// @param minIntervalFrames Finest spacing between keyframes, in frames.
    /// ```
    public static void setKeyframePolicy(
    	MemorySegment player,
    	long budgetBytes,
    	int minIntervalFrames
    ) {
    	MethodHandle method = B2_REPLAY_SET_KEYFRAME_POLICY.get();
    	try {
    		 method.invokeExact(
    			player,
    			budgetBytes,
    			minIntervalFrames
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#setKeyframePolicy].
    public static void setKeyframePolicy(
    	Replay player,
    	long budgetBytes,
    	int minIntervalFrames
    ) {
    	setKeyframePolicy(
    		player.memorySegment(),
    		budgetBytes,
    		minIntervalFrames
    	);
    }
    
    /// ```
    /// Get the keyframe memory budget in bytes.
    /// ```
    public static long getKeyframeBudget(
    	MemorySegment player
    ) {
    	MethodHandle method = B2_REPLAY_GET_KEYFRAME_BUDGET.get();
    	try {
    		return (long) method.invokeExact(
    			player
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#getKeyframeBudget].
    public static long getKeyframeBudget(
    	Replay player
    ) {
    	return getKeyframeBudget(
    		player.memorySegment()
    	);
    }
    
    /// ```
    /// Get the finest keyframe spacing in frames.
    /// ```
    public static int getKeyframeMinInterval(
    	MemorySegment player
    ) {
    	MethodHandle method = B2_REPLAY_GET_KEYFRAME_MIN_INTERVAL.get();
    	try {
    		return (int) method.invokeExact(
    			player
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#getKeyframeMinInterval].
    public static int getKeyframeMinInterval(
    	Replay player
    ) {
    	return getKeyframeMinInterval(
    		player.memorySegment()
    	);
    }
    
    /// ```
    /// Get the current keyframe spacing in frames. Starts at the min interval and doubles as the ring
    /// evicts to stay under budget, so it reflects the effective backward-seek granularity right now.
    /// ```
    public static int getKeyframeInterval(
    	MemorySegment player
    ) {
    	MethodHandle method = B2_REPLAY_GET_KEYFRAME_INTERVAL.get();
    	try {
    		return (int) method.invokeExact(
    			player
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#getKeyframeInterval].
    public static int getKeyframeInterval(
    	Replay player
    ) {
    	return getKeyframeInterval(
    		player.memorySegment()
    	);
    }
    
    /// ```
    /// Get the memory currently held by keyframe snapshots, in bytes.
    /// ```
    public static long getKeyframeBytes(
    	MemorySegment player
    ) {
    	MethodHandle method = B2_REPLAY_GET_KEYFRAME_BYTES.get();
    	try {
    		return (long) method.invokeExact(
    			player
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#getKeyframeBytes].
    public static long getKeyframeBytes(
    	Replay player
    ) {
    	return getKeyframeBytes(
    		player.memorySegment()
    	);
    }
    
    /// ```
    /// Draw spatial queries recorded during the most recently replayed frame. Call after b2World_Draw
    /// so queries are layered on top of the world.
    /// @param player A valid player handle
    /// @param draw Debug draw callbacks. NULL draw function pointers are skipped.
    /// @param queryIndex Index into the frame's queries to draw, or -1 to draw all of them.
    /// ```
    public static void drawFrameQueries(
    	MemorySegment player,
    	MemorySegment draw,
    	int queryIndex
    ) {
    	MethodHandle method = B2_REPLAY_DRAW_FRAME_QUERIES.get();
    	try {
    		 method.invokeExact(
    			player,
    			draw,
    			queryIndex
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#drawFrameQueries].
    public static void drawFrameQueries(
    	Replay player,
    	DebugDraw draw,
    	int queryIndex
    ) {
    	drawFrameQueries(
    		player.memorySegment(),
    		draw.memorySegment(),
    		queryIndex
    	);
    }
    
    /// ```
    /// Get the number of spatial queries recorded for the most recently replayed frame.
    /// ```
    public static int getFrameQueryCount(
    	MemorySegment player
    ) {
    	MethodHandle method = B2_REPLAY_GET_FRAME_QUERY_COUNT.get();
    	try {
    		return (int) method.invokeExact(
    			player
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#getFrameQueryCount].
    public static int getFrameQueryCount(
    	Replay player
    ) {
    	return getFrameQueryCount(
    		player.memorySegment()
    	);
    }
    
    /// ```
    /// Get a recorded query from the most recently replayed frame by index.
    /// ```
    public static MemorySegment getFrameQuery(
    	SegmentAllocator allocator,
    	MemorySegment player,
    	int index
    ) {
    	MethodHandle method = B2_REPLAY_GET_FRAME_QUERY.get();
    	try {
    		return (MemorySegment) method.invokeExact(
    			allocator,
    			player,
    			index
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#getFrameQuery].
    public static @Nullable ReplayQueryInfo getFrameQuery(
    	SegmentAllocator allocator,
    	Replay player,
    	int index
    ) {
    	MemorySegment segment = getFrameQuery(
    		allocator,
    		player.memorySegment(),
    		index
    	);
    
    	if (segment.equals(MemorySegment.NULL))
    		return null;
    	
    	return new ReplayQueryInfo(segment);
    }
    
    /// ```
    /// Get one result of a recorded query from the most recently replayed frame.
    /// ```
    public static MemorySegment getFrameQueryHit(
    	SegmentAllocator allocator,
    	MemorySegment player,
    	int queryIndex,
    	int hitIndex
    ) {
    	MethodHandle method = B2_REPLAY_GET_FRAME_QUERY_HIT.get();
    	try {
    		return (MemorySegment) method.invokeExact(
    			allocator,
    			player,
    			queryIndex,
    			hitIndex
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#getFrameQueryHit].
    public static @Nullable ReplayQueryHit getFrameQueryHit(
    	SegmentAllocator allocator,
    	Replay player,
    	int queryIndex,
    	int hitIndex
    ) {
    	MemorySegment segment = getFrameQueryHit(
    		allocator,
    		player.memorySegment(),
    		queryIndex,
    		hitIndex
    	);
    
    	if (segment.equals(MemorySegment.NULL))
    		return null;
    	
    	return new ReplayQueryHit(segment);
    }
    
    /// ```
    /// Get the number of body slots tracked for the outliner. This is the creation-order span and
    /// includes holes for destroyed bodies, so it only grows as the replay advances.
    /// ```
    public static int getBodyCount(
    	MemorySegment player
    ) {
    	MethodHandle method = B2_REPLAY_GET_BODY_COUNT.get();
    	try {
    		return (int) method.invokeExact(
    			player
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#getBodyCount].
    public static int getBodyCount(
    	Replay player
    ) {
    	return getBodyCount(
    		player.memorySegment()
    	);
    }
    
    /// ```
    /// Get a tracked body by creation ordinal. Returns b2_nullBodyId for a destroyed slot, an ordinal
    /// not yet reached at the current frame, or an out-of-range index. Validate with b2Body_IsValid.
    /// ```
    public static MemorySegment getBodyId(
    	SegmentAllocator allocator,
    	MemorySegment player,
    	int index
    ) {
    	MethodHandle method = B2_REPLAY_GET_BODY_ID.get();
    	try {
    		return (MemorySegment) method.invokeExact(
    			allocator,
    			player,
    			index
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#getBodyId].
    public static @Nullable BodyId getBodyId(
    	SegmentAllocator allocator,
    	Replay player,
    	int index
    ) {
    	MemorySegment segment = getBodyId(
    		allocator,
    		player.memorySegment(),
    		index
    	);
    
    	if (segment.equals(MemorySegment.NULL))
    		return null;
    	
    	return new BodyId(segment);
    }

}