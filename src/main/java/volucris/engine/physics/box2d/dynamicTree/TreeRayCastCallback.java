package volucris.engine.physics.box2d.dynamicTree;

import java.lang.foreign.FunctionDescriptor;
import java.lang.foreign.MemorySegment;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodHandles.Lookup;

import volucris.engine.utils.VolucrisRuntimeException;

import static java.lang.foreign.ValueLayout.*;
import static volucris.engine.utils.FFMUtils.*;

/**
 * This function receives clipped ray cast input for a proxy.
 * 
 * The function returns the new ray fraction.
 * <ul>
 * <li>return a value of 0 to terminate the ray cast
 * <li>return a value less than input->maxFraction to clip the ray
 * <li>return a value of input->maxFraction to continue the ray cast without
 * clipping
 * </ul> 
 */
public abstract class TreeRayCastCallback {

	private static final Lookup LOOKUP;

	private static final FunctionDescriptor TREE_RAY_CAST_CALLBACK_DESCR;

	private static final MethodHandle TREE_RAY_CAST_CALLBACK_HANDLE;

	private final MemorySegment treeRayCastCallbackAddress;

	static {
		//@formatter:off
		try {
			LOOKUP = MethodHandles.privateLookupIn(TreeRayCastCallback.class, MethodHandles.lookup());
		} catch (IllegalAccessException e) {
			throw new VolucrisRuntimeException("Cannot create private lookup.");
		}
		
		TREE_RAY_CAST_CALLBACK_DESCR = functionDescr(ADDRESS, JAVA_INT, JAVA_LONG, ADDRESS);
		
		TREE_RAY_CAST_CALLBACK_HANDLE = upcallHandle(LOOKUP, TreeRayCastCallback.class, "treeRayCastCallback", TREE_RAY_CAST_CALLBACK_DESCR);
		//@formatter:on
	}

	public TreeRayCastCallback() {
		treeRayCastCallbackAddress = upcallStub(this, TREE_RAY_CAST_CALLBACK_HANDLE, TREE_RAY_CAST_CALLBACK_DESCR);
	}

	protected abstract boolean treeRayCastCallback(MemorySegment imput, int proxyId, long userData,
			MemorySegment context);

	public MemorySegment memorySegment() {
		return treeRayCastCallbackAddress;
	}

}
