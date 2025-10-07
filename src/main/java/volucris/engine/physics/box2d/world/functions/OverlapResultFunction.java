package volucris.engine.physics.box2d.world.functions;

import java.lang.foreign.FunctionDescriptor;
import java.lang.foreign.MemorySegment;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodHandles.Lookup;

import volucris.engine.physics.box2d.shape.Shape;
import volucris.engine.utils.VolucrisRuntimeException;

import static java.lang.foreign.ValueLayout.*;
import static volucris.engine.utils.FFMUtils.*;

/**
 * Prototype callback for overlap queries.
 * <p>
 * Called for each shape found in the query.
 * <p>
 * Returns: false to terminate the query.
 */
public abstract class OverlapResultFunction {

	private static final Lookup LOOKUP;

	private static final FunctionDescriptor OVERLAP_RESULT_FCN_DESCR;

	private static final MethodHandle OVERLAP_RESULT_FCN_HANDLE;

	private final MemorySegment overlapResultFcnAddress;

	static {
		//@formatter:off
		try {
			LOOKUP = MethodHandles.privateLookupIn(OverlapResultFunction.class, MethodHandles.lookup());
		} catch (IllegalAccessException e) {
			throw new VolucrisRuntimeException("Cannot create private lookup.");
		}
		
		OVERLAP_RESULT_FCN_DESCR = functionDescr(JAVA_BOOLEAN, Shape.LAYOUT(), ADDRESS);
		
		OVERLAP_RESULT_FCN_HANDLE = upcallHandle(LOOKUP, OverlapResultFunction.class, "overlapResultFunction", OVERLAP_RESULT_FCN_DESCR);
		//@formatter:on
	}

	public OverlapResultFunction() {
		overlapResultFcnAddress = upcallStub(this, OVERLAP_RESULT_FCN_HANDLE, OVERLAP_RESULT_FCN_DESCR);
	}

	protected abstract boolean overlapResultFunction(MemorySegment shapeIdA, MemorySegment context);

	public MemorySegment memorySegment() {
		return overlapResultFcnAddress;
	}

}
