/*
 * MACHINE GENERATED FILE, DO NOT EDIT.
 */
package volucris.bindings.box2d.characterMover;

import edu.umd.cs.findbugs.annotations.Nullable;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.SegmentAllocator;
import java.lang.invoke.MethodHandle;
import volucris.bindings.box2d.math.Vec2;

import static java.lang.foreign.ValueLayout.*;
import static volucris.bindings.core.FFMUtils.*;;

/**
 * 
 */
public final class CharacterMover {

    private static final LazyConstant<MethodHandle> B2_SOLVE_PLANES;
    private static final LazyConstant<MethodHandle> B2_CLIP_VECTOR;

    static {
        //@formatter:off
        B2_SOLVE_PLANES = downcallHandle("b2SolvePlanes", PlaneSolverResult.LAYOUT, Vec2.LAYOUT, UNBOUNDED_ADDRESS, JAVA_INT);
        B2_CLIP_VECTOR = downcallHandle("b2ClipVector", Vec2.LAYOUT, Vec2.LAYOUT, UNBOUNDED_ADDRESS, JAVA_INT);
        //@formatter:on
    }

    private CharacterMover() {
    }

    /**
     * Solves the position of a mover that satisfies the given collision planes.
     */
    public static MemorySegment solvePlanes(
        SegmentAllocator allocator,
        MemorySegment targetDelta, 
        MemorySegment planes, 
        int count
    ) {
        MethodHandle method = B2_SOLVE_PLANES.get();
        try {
            return (MemorySegment) method.invokeExact(
                allocator,
                targetDelta, 
                planes, 
                count
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #solvePlanes}.
     */
    public static @Nullable PlaneSolverResult solvePlanes(
        SegmentAllocator allocator,
        Vec2 targetDelta, 
        CollisionPlane planes, 
        int count
    ) {
        MemorySegment segment = solvePlanes(
            allocator,
            targetDelta.memorySegment(), 
            planes.memorySegment(), 
            count
        );
    
        if (segment.equals(MemorySegment.NULL))
            return null;
    
        return new PlaneSolverResult(segment);
    }
    
    /**
     * Clips the velocity against the given collision planes. Planes with zero push or clipVelocity set to false are skipped.
     */
    public static MemorySegment clipVector(
        SegmentAllocator allocator,
        MemorySegment vector, 
        MemorySegment planes, 
        int count
    ) {
        MethodHandle method = B2_CLIP_VECTOR.get();
        try {
            return (MemorySegment) method.invokeExact(
                allocator,
                vector, 
                planes, 
                count
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #clipVector}.
     */
    public static @Nullable Vec2 clipVector(
        SegmentAllocator allocator,
        Vec2 vector, 
        CollisionPlane planes, 
        int count
    ) {
        MemorySegment segment = clipVector(
            allocator,
            vector.memorySegment(), 
            planes.memorySegment(), 
            count
        );
    
        if (segment.equals(MemorySegment.NULL))
            return null;
    
        return new Vec2(segment);
    }
    
}