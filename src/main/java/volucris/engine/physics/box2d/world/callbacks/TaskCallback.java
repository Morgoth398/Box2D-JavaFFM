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
 * Task interface This is prototype for a Box2D task.
 * <p>
 * Your task system is expected to invoke the Box2D task with these arguments.
 * The task spans a range of the parallel-for: [startIndex, endIndex) The worker
 * index must correctly identify each worker in the user thread pool, expected
 * in [0, workerCount). A worker must only exist on only one thread at a time
 * and is analogous to the thread index. The task context is the context pointer
 * sent from Box2D when it is enqueued. The startIndex and endIndex are expected
 * in the range [0, itemCount) where itemCount is the argument to
 * b2EnqueueTaskCallback below. Box2D expects {@code startIndex < endIndex} and
 * will execute a loop like this: {@code 
 * 	for (int i = startIndex; i < endIndex; ++i) { DoWork(); } }
 */
public abstract class TaskCallback {

	private static final Lookup LOOKUP;

	private static final FunctionDescriptor TASK_CALLBACK_DESCR;

	private static final MethodHandle TASK_CALLBACK_HANDLE;

	private final MemorySegment taskCallbackAddress;

	static {
		//@formatter:off
		try {
			LOOKUP = MethodHandles.privateLookupIn(TaskCallback.class, MethodHandles.lookup());
		} catch (IllegalAccessException e) {
			String className = e.getClass().getSimpleName();
			throw new Box2DRuntimeException("Cannot create private lookup: " + className);
		}
		
		TASK_CALLBACK_DESCR = functionDescrVoid(JAVA_INT, JAVA_INT, JAVA_INT, ADDRESS);
		
		TASK_CALLBACK_HANDLE = upcallHandle(LOOKUP, TaskCallback.class, "taskCallback", TASK_CALLBACK_DESCR);
		//@formatter:on
	}

	public TaskCallback() {
		this(Arena.ofAuto());
	}

	public TaskCallback(Arena arena) {
		taskCallbackAddress = upcallStub(this, TASK_CALLBACK_HANDLE, TASK_CALLBACK_DESCR, arena);
	}

	protected abstract void taskCallback(int startIndex, int endIndex, int workerIndex, MemorySegment taskContext);

	public MemorySegment memorySegment() {
		return taskCallbackAddress;
	}

}
