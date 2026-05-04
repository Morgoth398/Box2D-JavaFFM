package volucris.engine.physics.box2d.world.functions;

import java.lang.foreign.Arena;
import java.lang.foreign.FunctionDescriptor;
import java.lang.foreign.MemorySegment;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodHandles.Lookup;

import volucris.engine.physics.box2d.shape.Shape;
import volucris.engine.physics.box2d.utils.Box2DRuntimeException;

import static java.lang.foreign.ValueLayout.*;
import static volucris.engine.physics.box2d.utils.FFMUtils.*;

/**
 * 
 * 
 * Prototype for a contact filter callback.
 * <p>
 * This is called when a contact pair is considered for collision. This allows
 * you to perform custom logic to prevent collision between shapes. This is only
 * called if one of the two shapes has custom filtering enabled. Notes:
 * <ul>
 * <li>this function must be thread-safe
 * <li>this is only called if one of the two shapes has enabled custom filtering
 * <li>this is called only for awake dynamic bodies Return false if you want to
 * disable the collision
 * </ul>
 * Warning: Do not attempt to modify the world inside this callback
 */
public abstract class CustomFilterFunction {

	private static final Lookup LOOKUP;

	private static final FunctionDescriptor CUSTOM_FILTER_FCN_DESCR;

	private static final MethodHandle CUSTOM_FILTER_FCN_HANDLE;

	private final MemorySegment customFilterFcnAddress;

	static {
		//@formatter:off
		try {
			LOOKUP = MethodHandles.privateLookupIn(CustomFilterFunction.class, MethodHandles.lookup());
		} catch (IllegalAccessException e) {
			String className = e.getClass().getSimpleName();
			throw new Box2DRuntimeException("Cannot create private lookup: " + className);
		}
		
		CUSTOM_FILTER_FCN_DESCR = functionDescr(JAVA_BOOLEAN, Shape.LAYOUT(), Shape.LAYOUT(), ADDRESS);
		
		CUSTOM_FILTER_FCN_HANDLE = upcallHandle(LOOKUP, CustomFilterFunction.class, "customFilterFunction", CUSTOM_FILTER_FCN_DESCR);
		//@formatter:on
	}

	public CustomFilterFunction() {
		this(Arena.ofAuto());
	}

	public CustomFilterFunction(Arena arena) {
		customFilterFcnAddress = upcallStub(this, CUSTOM_FILTER_FCN_HANDLE, CUSTOM_FILTER_FCN_DESCR, arena);
	}

	protected abstract boolean customFilterFunction(MemorySegment shapeIdA, MemorySegment shapeIdB,
			MemorySegment context);

	public MemorySegment memorySegment() {
		return customFilterFcnAddress;
	}

}
