package volucris.engine.physics.box2d.joint;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.lang.invoke.MethodHandle;

import volucris.engine.physics.box2d.world.World;
import volucris.engine.utils.Box2DRuntimeException;

import static java.lang.foreign.ValueLayout.*;
import static volucris.engine.utils.FFMUtils.*;

public final class FilterJoint extends Joint {

	private static final MethodHandle B2_CREATE_FILTER_JOINT;

	static {
		B2_CREATE_FILTER_JOINT = downcallHandle("b2CreateFilterJoint", JOINT_ID_LAYOUT, World.LAYOUT(), ADDRESS);
	}

	public FilterJoint(World world, FilterJointDef filterJointDef) {
		this(world, filterJointDef, Arena.ofAuto());
	}

	/**
	 * Create a filter joint.
	 */
	public FilterJoint(World world, FilterJointDef filterJointDef, Arena arena) {
		MemorySegment filterJoint;
		try {
			MemorySegment worldAddr = world.memorySegment();
			MemorySegment defAddr = filterJointDef.memorySegment();

			filterJoint = (MemorySegment) B2_CREATE_FILTER_JOINT.invoke(arena, worldAddr, defAddr);
		} catch (Throwable e) {
			String className = e.getClass().getSimpleName();
			throw new Box2DRuntimeException("Box2D: Cannot create mouse joint: " + className);
		}
		super(filterJoint, world, arena);
	}

}
