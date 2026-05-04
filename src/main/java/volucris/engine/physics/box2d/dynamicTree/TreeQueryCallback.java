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
 * This function receives proxies found in the AABB query.
 * <p>
 * Returns true if the query should continue.
 */
public abstract class TreeQueryCallback {

	private static final Lookup LOOKUP;

	private static final FunctionDescriptor TREE_QUERY_CALLBACK_DESCR;

	private static final MethodHandle TREE_QUERY_CALLBACK_HANDLE;

	private final MemorySegment treeQueryCallbackAddress;

	static {
		//@formatter:off
		try {
			LOOKUP = MethodHandles.privateLookupIn(TreeQueryCallback.class, MethodHandles.lookup());
		} catch (IllegalAccessException e) {
			throw new VolucrisRuntimeException("Cannot create private lookup.");
		}
		
		TREE_QUERY_CALLBACK_DESCR = functionDescr(JAVA_BOOLEAN, JAVA_INT, JAVA_LONG, ADDRESS);
		
		TREE_QUERY_CALLBACK_HANDLE = upcallHandle(LOOKUP, TreeQueryCallback.class, "treeQueryCallback", TREE_QUERY_CALLBACK_DESCR);
		//@formatter:on
	}

	public TreeQueryCallback() {
		treeQueryCallbackAddress = upcallStub(this, TREE_QUERY_CALLBACK_HANDLE, TREE_QUERY_CALLBACK_DESCR);
	}

	protected abstract boolean treeQueryCallback(int proxyId, long userData, MemorySegment context);

	public MemorySegment memorySegment() {
		return treeQueryCallbackAddress;
	}

}
