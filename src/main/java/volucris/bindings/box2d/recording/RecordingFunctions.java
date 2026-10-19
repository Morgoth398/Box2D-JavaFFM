/*
 * MACHINE GENERATED FILE, DO NOT EDIT.
 */
package volucris.bindings.box2d.recording;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.lang.invoke.MethodHandle;
import org.jspecify.annotations.Nullable;
import volucris.bindings.core.MemoryStack;
import volucris.bindings.core.NativeByteArray;

import static java.lang.foreign.ValueLayout.*;
import static volucris.bindings.core.FFMUtils.*;

public final class RecordingFunctions {

	private static final LazyConstant<MethodHandle> B2_CREATE_RECORDING;
	private static final LazyConstant<MethodHandle> B2_DESTROY_RECORDING;
	private static final LazyConstant<MethodHandle> B2_RECORDING_GET_DATA;
	private static final LazyConstant<MethodHandle> B2_RECORDING_GET_SIZE;
	private static final LazyConstant<MethodHandle> B2_RECORDING_SAVE_TO_FILE;
	private static final LazyConstant<MethodHandle> B2_CREATE_RECORDING_FROM_FILE;

	static {
		//@formatter:off
		B2_CREATE_RECORDING = downcallHandle("b2CreateRecording", UNBOUNDED_ADDRESS, JAVA_INT);
		B2_DESTROY_RECORDING = downcallHandleVoid("b2DestroyRecording", UNBOUNDED_ADDRESS);
		B2_RECORDING_GET_DATA = downcallHandle("b2Recording_GetData", UNBOUNDED_ADDRESS, UNBOUNDED_ADDRESS);
		B2_RECORDING_GET_SIZE = downcallHandle("b2Recording_GetSize", JAVA_INT, UNBOUNDED_ADDRESS);
		B2_RECORDING_SAVE_TO_FILE = downcallHandle("b2Recording_SaveToFile", JAVA_BOOLEAN, UNBOUNDED_ADDRESS, UNBOUNDED_ADDRESS);
		B2_CREATE_RECORDING_FROM_FILE = downcallHandle("b2CreateRecordingFromFile", UNBOUNDED_ADDRESS, UNBOUNDED_ADDRESS);
		//@formatter:on
	}

	private RecordingFunctions() {
	}

    /// ```
    /// Create a recording buffer. The buffer grows on demand. @p byteCapacity pre-sizes it to avoid
    /// reallocations during a known-length session. Pass 0 for a small default.
    /// @return A recording handle, freed with b2DestroyRecording
    /// ```
    public static MemorySegment ncreateRecording(
    	int byteCapacity
    ) {
    	MethodHandle method = B2_CREATE_RECORDING.get();
    	try {
    		return (MemorySegment) method.invokeExact(
    			byteCapacity
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#ncreateRecording].
    public static @Nullable Recording createRecording(
    	int byteCapacity
    ) {
    	MemorySegment segment = ncreateRecording(
    		byteCapacity
    	);
    
    	if (segment.equals(MemorySegment.NULL))
    		return null;
    	
    	return new Recording(segment);
    }
    
    /// ```
    /// Destroy a recording buffer and free its memory.
    /// ```
    public static void destroyRecording(
    	MemorySegment recording
    ) {
    	MethodHandle method = B2_DESTROY_RECORDING.get();
    	try {
    		 method.invokeExact(
    			recording
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#destroyRecording].
    public static void destroyRecording(
    	Recording recording
    ) {
    	destroyRecording(
    		recording.memorySegment()
    	);
    }
    
    /// ```
    /// Get a pointer to the recorded bytes, for saving to a file or transmitting. Valid until the next
    /// recording call or b2DestroyRecording.
    /// ```
    public static MemorySegment getData(
    	MemorySegment recording
    ) {
    	MethodHandle method = B2_RECORDING_GET_DATA.get();
    	try {
    		return (MemorySegment) method.invokeExact(
    			recording
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#getData].
    public static @Nullable NativeByteArray getData(
    	Recording recording
    ) {
    	MemorySegment segment = getData(
    		recording.memorySegment()
    	);
    
    	if (segment.equals(MemorySegment.NULL))
    		return null;
    	
    	return new NativeByteArray(segment);
    }
    
    /// ```
    /// Get the number of recorded bytes.
    /// ```
    public static int getSize(
    	MemorySegment recording
    ) {
    	MethodHandle method = B2_RECORDING_GET_SIZE.get();
    	try {
    		return (int) method.invokeExact(
    			recording
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#getSize].
    public static int getSize(
    	Recording recording
    ) {
    	return getSize(
    		recording.memorySegment()
    	);
    }
    
    /// ```
    /// Save a recording buffer to a file. Convenience wrapper over your own file I/O.
    /// @return false if the file could not be written
    /// ```
    public static boolean saveToFile(
    	MemorySegment recording,
    	MemorySegment path
    ) {
    	MethodHandle method = B2_RECORDING_SAVE_TO_FILE.get();
    	try {
    		return (boolean) method.invokeExact(
    			recording,
    			path
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#saveToFile].
    public static boolean saveToFile(
    	Recording recording,
    	NativeByteArray path
    ) {
    	return saveToFile(
    		recording.memorySegment(),
    		path.memorySegment()
    	);
    }
    
    /// ```
    /// Load a recording from a file into a new recording buffer. Convenience wrapper over your own file
    /// I/O. Destroy the result with b2DestroyRecording.
    /// @return NULL if the file is missing or unreadable
    /// ```
    public static MemorySegment createRecordingFromFile(
    	MemorySegment path
    ) {
    	MethodHandle method = B2_CREATE_RECORDING_FROM_FILE.get();
    	try {
    		return (MemorySegment) method.invokeExact(
    			path
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#createRecordingFromFile].
    public static @Nullable Recording createRecordingFromFile(
    	String path
    ) {
    	try (Arena arena = MemoryStack.stackPush()) {
    		MemorySegment segment = createRecordingFromFile(
    			arena.allocateFrom(path)
    		);
    
    		if (segment.equals(MemorySegment.NULL))
    			return null;
    		
    		return new Recording(segment);
    	}
    }

}