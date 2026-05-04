package volucris.engine.physics.box2d.world.callbacks;

import java.lang.foreign.Arena;
import java.lang.foreign.FunctionDescriptor;
import java.lang.foreign.MemorySegment;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodHandles.Lookup;

import volucris.engine.utils.VolucrisRuntimeException;

import static java.lang.foreign.ValueLayout.*;
import static volucris.engine.utils.FFMUtils.*;

public abstract class FinishTaskCallback {

	private static final Lookup LOOKUP;

	private static final FunctionDescriptor FINISH_TASK_CALLBACK_DESCR;

	private static final MethodHandle FINISH_TASK_CALLBACK_HANDLE;

	private final MemorySegment finishTaskCallbackAddress;

	static {
		//@formatter:off
		try {
			LOOKUP = MethodHandles.privateLookupIn(FinishTaskCallback.class, MethodHandles.lookup());
		} catch (IllegalAccessException e) {
			throw new VolucrisRuntimeException("Cannot create private lookup.");
		}
		
		FINISH_TASK_CALLBACK_DESCR = functionDescrVoid(ADDRESS, ADDRESS);
		
		FINISH_TASK_CALLBACK_HANDLE = upcallHandle(LOOKUP, FinishTaskCallback.class, "finishTaskCallback", FINISH_TASK_CALLBACK_DESCR);
		//@formatter:on
	}

	public FinishTaskCallback() {
		this(Arena.ofAuto());
	}

	public FinishTaskCallback(Arena arena) {
		finishTaskCallbackAddress = upcallStub(this, FINISH_TASK_CALLBACK_HANDLE, FINISH_TASK_CALLBACK_DESCR, arena);
	}

	protected abstract void finishTaskCallback(MemorySegment userTask, MemorySegment userContext);

	public MemorySegment memorySegment() {
		return finishTaskCallbackAddress;
	}

}
