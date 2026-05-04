/*
 * MACHINE GENERATED FILE, DO NOT EDIT.
 */
package volucris.bindings.box2d.joint;

import edu.umd.cs.findbugs.annotations.Nullable;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.SegmentAllocator;
import java.lang.invoke.MethodHandle;
import volucris.bindings.box2d.world.WorldId;

import static volucris.bindings.core.FFMUtils.*;

/**
 * 
 */
public final class FilterJoint {

    private static final LazyConstant<MethodHandle> B2_CREATE_FILTER_JOINT;

    static {
        //@formatter:off
        B2_CREATE_FILTER_JOINT = downcallHandle("b2CreateFilterJoint", JointId.LAYOUT, WorldId.LAYOUT, UNBOUNDED_ADDRESS);
        //@formatter:on
    }

    private FilterJoint() {
    }

    /**
     * Create a filter joint.
     */
    public static MemorySegment createFilterJoint(
        SegmentAllocator allocator,
        MemorySegment worldId, 
        MemorySegment def
    ) {
        MethodHandle method = B2_CREATE_FILTER_JOINT.get();
        try {
            return (MemorySegment) method.invokeExact(
                allocator,
                worldId, 
                def
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #createFilterJoint}.
     */
    public static @Nullable JointId createFilterJoint(
        SegmentAllocator allocator,
        WorldId worldId, 
        FilterJointDef def
    ) {
        MemorySegment segment = createFilterJoint(
            allocator,
            worldId.memorySegment(), 
            def.memorySegment()
        );
    
        if (segment.equals(MemorySegment.NULL))
            return null;
    
        return new JointId(segment);
    }
    
}