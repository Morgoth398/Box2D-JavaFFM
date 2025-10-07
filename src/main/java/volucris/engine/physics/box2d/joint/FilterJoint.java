package volucris.engine.physics.box2d.joint;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.SegmentAllocator;
import java.lang.invoke.MethodHandle;

import volucris.engine.physics.box2d.world.World;
import volucris.engine.utils.VolucrisRuntimeException;

import static java.lang.foreign.ValueLayout.*;
import static volucris.engine.utils.FFMUtils.*;

public final class FilterJoint extends Joint {

	private static final MethodHandle B2_CREATE_FILTER_JOINT;

	static {
		B2_CREATE_FILTER_JOINT = downcallHandle("b2CreateFilterJoint", JOINT_ID_LAYOUT, World.LAYOUT(), ADDRESS);
	}

	/**
	 * Create a filter joint.
	 */
	public FilterJoint(World world, FilterJointDef filterJointDef) {
		MemorySegment filterJoint;
		try {
			SegmentAllocator allocator = Arena.ofAuto();

			MemorySegment worldAddr = world.memorySegment();
			MemorySegment defAddr = filterJointDef.memorySegment();

			filterJoint = (MemorySegment) B2_CREATE_FILTER_JOINT.invokeExact(allocator, worldAddr, defAddr);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot create mouse joint.");
		}
		super(filterJoint, world);
	}

}
