package volucris.engine.physics.box2d.world.functions;

import java.lang.foreign.Arena;
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
 * Prototype for a pre-solve callback.
 * <p>
 * This is called after a contact is updated. This allows you to inspect a
 * contact before it goes to the solver. If you are careful, you can modify the
 * contact manifold (e.g. modify the normal). Notes:
 * <ul>
 * <li>this function must be thread-safe
 * <li>this is only called if the shape has enabled pre-solve events
 * <li>this is called only for awake dynamic bodies
 * <li>this is not called for sensors
 * <li>the supplied manifold has impulse values from the previous step Return
 * false if you want to disable the contact this step
 * </ul>
 * Warning: Do not attempt to modify the world inside this callback
 */
public abstract class PreSolveFunction {

	private static final Lookup LOOKUP;

	private static final FunctionDescriptor PRE_SOLVE_FCN_DESCR;

	private static final MethodHandle PRE_SOLVE_FCN_HANDLE;

	private final MemorySegment preSolveFcnAddress;

	static {
		//@formatter:off
		try {
			LOOKUP = MethodHandles.privateLookupIn(PreSolveFunction.class, MethodHandles.lookup());
		} catch (IllegalAccessException e) {
			throw new VolucrisRuntimeException("Cannot create private lookup.");
		}
		
		PRE_SOLVE_FCN_DESCR = functionDescr(JAVA_BOOLEAN, Shape.LAYOUT(), Shape.LAYOUT(), ADDRESS, ADDRESS);
		
		PRE_SOLVE_FCN_HANDLE = upcallHandle(LOOKUP, PreSolveFunction.class, "preSolveFunction", PRE_SOLVE_FCN_DESCR);
		//@formatter:on
	}

	public PreSolveFunction() {
		this(Arena.ofAuto());
	}
	
	public PreSolveFunction(Arena arena) {
		preSolveFcnAddress = upcallStub(this, PRE_SOLVE_FCN_HANDLE, PRE_SOLVE_FCN_DESCR, arena);
	}

	protected abstract boolean preSolveFunction(MemorySegment shapeIdA, MemorySegment shapeIdB, MemorySegment manifold,
			MemorySegment context);

	public MemorySegment memorySegment() {
		return preSolveFcnAddress;
	}

}
