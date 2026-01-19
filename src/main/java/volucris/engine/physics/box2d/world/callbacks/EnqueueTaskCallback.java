package volucris.engine.physics.box2d.world.callbacks;

import java.lang.foreign.Arena;
import java.lang.foreign.FunctionDescriptor;
import java.lang.foreign.MemorySegment;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodHandles.Lookup;

import volucris.engine.utils.Box2DRuntimeException;

import static java.lang.foreign.ValueLayout.*;
import static volucris.engine.utils.FFMUtils.*;

/**
 * These functions can be provided to Box2D to invoke a task system.
 * <p>
 * These are designed to work well with enkiTS. Returns a pointer to the user's
 * task object. May be nullptr. A nullptr indicates to Box2D that the work was
 * executed serially within the callback and there is no need to call
 * {@link FinishTaskCallback} The itemCount is the number of Box2D work items
 * that are to be partitioned among workers by the user's task system. This is
 * essentially a parallel-for. The minRange parameter is a suggestion of the
 * minimum number of items to assign per worker to reduce overhead. For example,
 * suppose the task is small and that itemCount is 16. A minRange of 8 suggests
 * that your task system should split the work items among just two workers,
 * even if you have more available. In general the range [startIndex, endIndex)
 * send to {@link TaskCallback} should obey: endIndex - startIndex >= minRange
 * The exception of course is when {@code itemCount < minRange}
 */
public abstract class EnqueueTaskCallback {

	private static final Lookup LOOKUP;

	private static final FunctionDescriptor ENQUEUE_TASK_CALLBACK_DESCR;

	private static final MethodHandle ENQUEUE_TASK_CALLBACK_HANDLE;

	private final MemorySegment enqueueTaskCallbackAddress;

	static {
		//@formatter:off
		try {
			LOOKUP = MethodHandles.privateLookupIn(EnqueueTaskCallback.class, MethodHandles.lookup());
		} catch (IllegalAccessException e) {
			String className = e.getClass().getSimpleName();
			throw new Box2DRuntimeException("Cannot create private lookup: " + className);
		}
		
		ENQUEUE_TASK_CALLBACK_DESCR = functionDescr(ADDRESS, ADDRESS, JAVA_INT, JAVA_INT, ADDRESS, ADDRESS);
		
		ENQUEUE_TASK_CALLBACK_HANDLE = upcallHandle(LOOKUP, EnqueueTaskCallback.class, "enqueueTaskCallback", ENQUEUE_TASK_CALLBACK_DESCR);
		//@formatter:on
	}

	public EnqueueTaskCallback() {
		this(Arena.ofAuto());
	}

	public EnqueueTaskCallback(Arena arena) {
		enqueueTaskCallbackAddress = upcallStub(this, ENQUEUE_TASK_CALLBACK_HANDLE, ENQUEUE_TASK_CALLBACK_DESCR, arena);
	}

	protected abstract MemorySegment enqueueTaskCallback(MemorySegment task, int itemCount, int minRange,
			MemorySegment taskContext, MemorySegment userContext);

	public MemorySegment memorySegment() {
		return enqueueTaskCallbackAddress;
	}

}
