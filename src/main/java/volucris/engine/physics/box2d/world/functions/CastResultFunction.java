package volucris.engine.physics.box2d.world.functions;

import java.lang.foreign.Arena;
import java.lang.foreign.FunctionDescriptor;
import java.lang.foreign.MemorySegment;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodHandles.Lookup;

import volucris.engine.physics.box2d.math.Vec2;
import volucris.engine.physics.box2d.shape.Shape;
import volucris.engine.utils.Box2DRuntimeException;

import static java.lang.foreign.ValueLayout.*;
import static volucris.engine.utils.FFMUtils.*;

/**
 * Prototype callback for ray casts.
 * <p>
 * Called for each shape found in the query. You control how the ray cast
 * proceeds by returning a float: return -1: ignore this shape and continue
 * return 0: terminate the ray cast return fraction: clip the ray to this point
 * return 1: don't clip the ray and continue.
 * <p>
 * Parameters
 * <ul>
 * <li>shapeId the shape hit by the ray
 * <li>point the point of initial intersection
 * <li>normal the normal vector at the point of intersection
 * <li>fraction the fraction along the ray at the point of intersection
 * <li>context the user context
 * </ul>
 * > Returns -1 to filter, 0 to terminate, fraction to clip the ray for closest
 * hit, 1 to continue
 */
public abstract class CastResultFunction {

	private static final Lookup LOOKUP;

	private static final FunctionDescriptor CUSTOM_FILTER_FCN_DESCR;

	private static final MethodHandle CUSTOM_FILTER_FCN_HANDLE;

	private final MemorySegment customFilterFcnAddress;

	static {
		//@formatter:off
		try {
			LOOKUP = MethodHandles.privateLookupIn(CastResultFunction.class, MethodHandles.lookup());
		} catch (IllegalAccessException e) {
			String className = e.getClass().getSimpleName();
			throw new Box2DRuntimeException("Cannot create private lookup: " + className);
		}
		
		CUSTOM_FILTER_FCN_DESCR = functionDescr(JAVA_FLOAT, Shape.LAYOUT(), Vec2.LAYOUT(), Vec2.LAYOUT(), JAVA_FLOAT, ADDRESS);
		
		CUSTOM_FILTER_FCN_HANDLE = upcallHandle(LOOKUP, CastResultFunction.class, "customFilterFunction", CUSTOM_FILTER_FCN_DESCR);
		//@formatter:on
	}

	public CastResultFunction() {
		this(Arena.ofAuto());
	}

	public CastResultFunction(Arena arena) {
		customFilterFcnAddress = upcallStub(this, CUSTOM_FILTER_FCN_HANDLE, CUSTOM_FILTER_FCN_DESCR, arena);
	}

	protected abstract float castResultFunction(MemorySegment shapeId, MemorySegment point, MemorySegment normal,
			float fraction, MemorySegment context);

	public MemorySegment memorySegment() {
		return customFilterFcnAddress;
	}

}
