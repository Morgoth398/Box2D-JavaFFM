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
 * Optional restitution mixing callback.
 * <p>
 * This intentionally provides no context objects because this is called from a
 * worker thread.
 * <p>
 * Warning: This function should not attempt to modify Box2D state or user
 * application state.
 */
public abstract class RestitutionCallback {

	private static final Lookup LOOKUP;

	private static final FunctionDescriptor RESTITUTION_CALLBACK_DESCR;

	private static final MethodHandle RESTITUTION_CALLBACK_HANDLE;

	private final MemorySegment restitutionCallbackAddress;

	static {
		//@formatter:off
		try {
			LOOKUP = MethodHandles.privateLookupIn(RestitutionCallback.class, MethodHandles.lookup());
		} catch (IllegalAccessException e) {
			String className = e.getClass().getSimpleName();
			throw new Box2DRuntimeException("Cannot create private lookup: " + className);
		}
		
		RESTITUTION_CALLBACK_DESCR = functionDescr(JAVA_FLOAT, JAVA_FLOAT, JAVA_INT, JAVA_FLOAT, JAVA_INT);
		
		RESTITUTION_CALLBACK_HANDLE = upcallHandle(LOOKUP, RestitutionCallback.class, "restitutionCallback", RESTITUTION_CALLBACK_DESCR);
		//@formatter:on
	}

	public RestitutionCallback() {
		this(Arena.ofAuto());
	}

	public RestitutionCallback(Arena arena) {
		restitutionCallbackAddress = upcallStub(this, RESTITUTION_CALLBACK_HANDLE, RESTITUTION_CALLBACK_DESCR, arena);
	}

	protected abstract float restitutionCallback(float frictionA, int userMaterialIdA, float frictionB,
			int userMaterialIdB);

	public MemorySegment memorySegment() {
		return restitutionCallbackAddress;
	}

}
