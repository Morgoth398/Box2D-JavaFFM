/*
 * MACHINE GENERATED FILE, DO NOT EDIT.
 */
package volucris.bindings.box2d;

import java.lang.foreign.MemorySegment;
import java.lang.foreign.SegmentAllocator;
import java.lang.invoke.MethodHandle;
import org.jspecify.annotations.Nullable;

import static java.lang.foreign.ValueLayout.*;
import static volucris.bindings.core.FFMUtils.*;

public class Box2DBase {

	public static final int MAX_WORKERS = 32;
	public static final int MAX_TASKS = 256;
	public static final int GRAPH_COLOR_COUNT = 24;
	public static final int MAX_WORLDS = 128;
	public static final int NAME_LENGTH = 10;
	public static final float CONTACT_RECYCLE_COS_ANGLE = (0.98f);
	public static final float AABB_MARGIN_FRACTION = 0.125f;
	public static final float TIME_TO_SLEEP = 0.5f;
	public static final int MAX_RESTITUTION_ITERATIONS = 63;

	private static final LazyConstant<MethodHandle> B2_SET_ALLOCATOR;
	private static final LazyConstant<MethodHandle> B2_GET_BYTE_COUNT;
	private static final LazyConstant<MethodHandle> B2_SET_ASSERT_CALLBACK;
	private static final LazyConstant<MethodHandle> B2_SET_LOG_CALLBACK;
	private static final LazyConstant<MethodHandle> B2_GET_VERSION;
	private static final LazyConstant<MethodHandle> B2_IS_DOUBLE_PRECISION;
	private static final LazyConstant<MethodHandle> B2_IS_AVX2_AVAILABLE;

	static {
		//@formatter:off
		B2_SET_ALLOCATOR = downcallHandleVoid("b2SetAllocator", UNBOUNDED_ADDRESS, UNBOUNDED_ADDRESS);
		B2_GET_BYTE_COUNT = downcallHandle("b2GetByteCount", JAVA_LONG);
		B2_SET_ASSERT_CALLBACK = downcallHandleVoid("b2SetAssertCallback", UNBOUNDED_ADDRESS);
		B2_SET_LOG_CALLBACK = downcallHandleVoid("b2SetLogCallback", UNBOUNDED_ADDRESS);
		B2_GET_VERSION = downcallHandle("b2GetVersion", Version.LAYOUT);
		B2_IS_DOUBLE_PRECISION = downcallHandle("b2IsDoublePrecision", JAVA_BOOLEAN);
		B2_IS_AVX2_AVAILABLE = downcallHandle("b2IsAVX2Available", JAVA_BOOLEAN);
		//@formatter:on
	}

	private Box2DBase() {
	}

    /// ```
    /// This allows the user to override the allocation functions. These should be set during
    /// application startup.
    /// ```
    public static void setAllocator(
    	MemorySegment allocFcn,
    	MemorySegment freeFcn
    ) {
    	MethodHandle method = B2_SET_ALLOCATOR.get();
    	try {
    		 method.invokeExact(
    			allocFcn,
    			freeFcn
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#setAllocator].
    public static void setAllocator(
    	AllocFcn allocFcn,
    	FreeFcn freeFcn
    ) {
    	setAllocator(
    		allocFcn.memorySegment(),
    		freeFcn.memorySegment()
    	);
    }
    
    /// ```
    /// @return the total bytes allocated by Box2D
    /// ```
    public static long getByteCount() {
    	MethodHandle method = B2_GET_BYTE_COUNT.get();
    	try {
    		return (long) method.invokeExact();
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// ```
    /// Override the default assert function
    /// @param assertFcn a non-null assert callback
    /// ```
    public static void setAssertCallback(
    	MemorySegment assertFcn
    ) {
    	MethodHandle method = B2_SET_ASSERT_CALLBACK.get();
    	try {
    		 method.invokeExact(
    			assertFcn
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#setAssertCallback].
    public static void setAssertCallback(
    	AssertFcn assertFcn
    ) {
    	setAssertCallback(
    		assertFcn.memorySegment()
    	);
    }
    
    /// ```
    /// Override the default log function
    /// @param logFcn a non-null log callback
    /// ```
    public static void setLogCallback(
    	MemorySegment logFcn
    ) {
    	MethodHandle method = B2_SET_LOG_CALLBACK.get();
    	try {
    		 method.invokeExact(
    			logFcn
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#setLogCallback].
    public static void setLogCallback(
    	LogCallbackFcn logFcn
    ) {
    	setLogCallback(
    		logFcn.memorySegment()
    	);
    }
    
    /// ```
    /// Get the current version of Box2D
    /// ```
    public static MemorySegment ngetVersion(
    	SegmentAllocator allocator
    ) {
    	MethodHandle method = B2_GET_VERSION.get();
    	try {
    		return (MemorySegment) method.invokeExact(
    			allocator
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#ngetVersion].
    public static @Nullable Version getVersion(
    	SegmentAllocator allocator
    ) {
    	MemorySegment segment = ngetVersion(
    		allocator
    	);
    
    	if (segment.equals(MemorySegment.NULL))
    		return null;
    	
    	return new Version(segment);
    }
    
    /// ```
    /// @return true if the library was built with BOX2D_DOUBLE_PRECISION (large world mode)
    /// ```
    public static boolean isDoublePrecision() {
    	MethodHandle method = B2_IS_DOUBLE_PRECISION.get();
    	try {
    		return (boolean) method.invokeExact();
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// ```
    /// @return true if the current CPU has the AVX2 instruction set.
    /// ```
    public static boolean isAVX2Available() {
    	MethodHandle method = B2_IS_AVX2_AVAILABLE.get();
    	try {
    		return (boolean) method.invokeExact();
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }

}