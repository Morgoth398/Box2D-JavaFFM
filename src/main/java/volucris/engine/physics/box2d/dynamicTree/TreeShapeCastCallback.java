package volucris.engine.physics.box2d.dynamicTree;

import java.lang.foreign.FunctionDescriptor;
import java.lang.foreign.MemorySegment;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodHandles.Lookup;

import volucris.engine.physics.box2d.utils.Box2DRuntimeException;

import static java.lang.foreign.ValueLayout.*;
import static volucris.engine.physics.box2d.utils.FFMUtils.*;

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
public abstract class TreeShapeCastCallback {

	private static final Lookup LOOKUP;

	private static final FunctionDescriptor TREE_SHAPE_CAST_CALLBACK_DESCR;

	private static final MethodHandle TREE_SHAPE_CAST_CALLBACK_HANDLE;

	private final MemorySegment treeShapeCastCallbackAddress;

	static {
		//@formatter:off
		try {
			LOOKUP = MethodHandles.privateLookupIn(TreeShapeCastCallback.class, MethodHandles.lookup());
		} catch (IllegalAccessException e) {
			String className = e.getClass().getSimpleName();
			throw new Box2DRuntimeException("Cannot create private lookup: " + className);
		}
		
		TREE_SHAPE_CAST_CALLBACK_DESCR = functionDescr(ADDRESS, JAVA_INT, JAVA_LONG, ADDRESS);
		
		TREE_SHAPE_CAST_CALLBACK_HANDLE = upcallHandle(LOOKUP, TreeShapeCastCallback.class, "treeShapeCastCallback", TREE_SHAPE_CAST_CALLBACK_DESCR);
	}

	public TreeShapeCastCallback() {
		treeShapeCastCallbackAddress = upcallStub(this, TREE_SHAPE_CAST_CALLBACK_HANDLE, TREE_SHAPE_CAST_CALLBACK_DESCR);
	}

	protected abstract boolean treeShapeCastCallback(MemorySegment imput, int proxyId, long userData, MemorySegment context);
	//@formatter:on

	public MemorySegment memorySegment() {
		return treeShapeCastCallbackAddress;
	}

}
