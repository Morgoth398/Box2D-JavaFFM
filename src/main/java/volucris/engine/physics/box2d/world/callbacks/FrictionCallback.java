package volucris.engine.physics.box2d.world.callbacks;

import java.lang.foreign.FunctionDescriptor;
import java.lang.foreign.MemorySegment;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodHandles.Lookup;

import volucris.engine.utils.VolucrisRuntimeException;

import static java.lang.foreign.ValueLayout.*;
import static volucris.engine.utils.FFMUtils.*;

/**
 * Optional friction mixing callback.
 * <p>
 * This intentionally provides no context objects because this is called from a
 * worker thread.
 * <p>
 * Warning: This function should not attempt to modify Box2D state or user
 * application state.
 * 
 * 
 */
public abstract class FrictionCallback {

	private static final Lookup LOOKUP;

	private static final FunctionDescriptor FRICTION_CALLBACK_DESCR;

	private static final MethodHandle FRICTION_CALLBACK_HANDLE;

	private final MemorySegment frictionCallbackAddress;

	static {
		//@formatter:off
		try {
			LOOKUP = MethodHandles.privateLookupIn(FrictionCallback.class, MethodHandles.lookup());
		} catch (IllegalAccessException e) {
			throw new VolucrisRuntimeException("Cannot create private lookup.");
		}
		
		FRICTION_CALLBACK_DESCR = functionDescr(JAVA_FLOAT, JAVA_FLOAT, JAVA_INT, JAVA_FLOAT, JAVA_INT);
		
		FRICTION_CALLBACK_HANDLE = upcallHandle(LOOKUP, FrictionCallback.class, "frictionCallback", FRICTION_CALLBACK_DESCR);
		//@formatter:on
	}

	public FrictionCallback() {
		frictionCallbackAddress = upcallStub(this, FRICTION_CALLBACK_HANDLE, FRICTION_CALLBACK_DESCR);
	}

	protected abstract float frictionCallback(float frictionA, int userMaterialIdA, float frictionB,
			int userMaterialIdB);

	public MemorySegment memorySegment() {
		return frictionCallbackAddress;
	}

}
