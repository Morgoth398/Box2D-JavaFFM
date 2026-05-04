/*
 * MACHINE GENERATED FILE, DO NOT EDIT.
 */
package volucris.bindings.box2d.math;

import edu.umd.cs.findbugs.annotations.Nullable;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.SegmentAllocator;
import java.lang.invoke.MethodHandle;

import static java.lang.foreign.ValueLayout.*;
import static volucris.bindings.core.FFMUtils.*;;

/**
 * NOTE:
 * Most of the Box2D math functions (e.g. b2Dot, b2Add, b2Length, etc.) are defined as inline
 * in the original C code and therefore have no native symbol.
 *
 * These functions are NOT included in the generated bindings and must be
 * implemented manually in Java if needed.
 */
public final class Box2DMath {

    private static final LazyConstant<MethodHandle> B2_IS_VALID_FLOAT;
    private static final LazyConstant<MethodHandle> B2_IS_VALID_VEC2;
    private static final LazyConstant<MethodHandle> B2_IS_VALID_ROTATION;
    private static final LazyConstant<MethodHandle> B2_IS_VALID_AABB;
    private static final LazyConstant<MethodHandle> B2_IS_VALID_PLANE;
    private static final LazyConstant<MethodHandle> B2_ATAN2;
    private static final LazyConstant<MethodHandle> B2_COMPUTE_COS_SIN;
    private static final LazyConstant<MethodHandle> B2_COMPUTE_ROTATION_BETWEEN_UNIT_VECTORS;
    private static final LazyConstant<MethodHandle> B2_SET_LENGTH_UNITS_PER_METER;
    private static final LazyConstant<MethodHandle> B2_GET_LENGTH_UNITS_PER_METER;

    static {
        //@formatter:off
        B2_IS_VALID_FLOAT = downcallHandle("b2IsValidFloat", JAVA_BOOLEAN, JAVA_FLOAT);
        B2_IS_VALID_VEC2 = downcallHandle("b2IsValidVec2", JAVA_BOOLEAN, Vec2.LAYOUT);
        B2_IS_VALID_ROTATION = downcallHandle("b2IsValidRotation", JAVA_BOOLEAN, Rot.LAYOUT);
        B2_IS_VALID_AABB = downcallHandle("b2IsValidAABB", JAVA_BOOLEAN, AABB.LAYOUT);
        B2_IS_VALID_PLANE = downcallHandle("b2IsValidPlane", JAVA_BOOLEAN, Plane.LAYOUT);
        B2_ATAN2 = downcallHandle("b2Atan2", JAVA_FLOAT, JAVA_FLOAT, JAVA_FLOAT);
        B2_COMPUTE_COS_SIN = downcallHandle("b2ComputeCosSin", CosSin.LAYOUT, JAVA_FLOAT);
        B2_COMPUTE_ROTATION_BETWEEN_UNIT_VECTORS = downcallHandle("b2ComputeRotationBetweenUnitVectors", Rot.LAYOUT, Vec2.LAYOUT, Vec2.LAYOUT);
        B2_SET_LENGTH_UNITS_PER_METER = downcallHandleVoid("b2SetLengthUnitsPerMeter", JAVA_FLOAT);
        B2_GET_LENGTH_UNITS_PER_METER = downcallHandle("b2GetLengthUnitsPerMeter", JAVA_FLOAT);
        //@formatter:on
    }

    private Box2DMath() {
    }

    /**
     * Is this a valid number? Not NaN or infinity.
     */
    public static boolean isValidFloat(
        float a
    ) {
        MethodHandle method = B2_IS_VALID_FLOAT.get();
        try {
            return (boolean) method.invokeExact(
                a
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Is this a valid vector? Not NaN or infinity.
     */
    public static boolean isValidVec2(
        MemorySegment v
    ) {
        MethodHandle method = B2_IS_VALID_VEC2.get();
        try {
            return (boolean) method.invokeExact(
                v
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #isValidVec2}.
     */
    public static boolean isValidVec2(
        Vec2 v
    ) {
        return (boolean) isValidVec2(
            v.memorySegment()
        );
    }
    
    /**
     * Is this a valid rotation? Not NaN or infinity. Is normalized.
     */
    public static boolean isValidRotation(
        MemorySegment q
    ) {
        MethodHandle method = B2_IS_VALID_ROTATION.get();
        try {
            return (boolean) method.invokeExact(
                q
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #isValidRotation}.
     */
    public static boolean isValidRotation(
        Rot q
    ) {
        return (boolean) isValidRotation(
            q.memorySegment()
        );
    }
    
    /**
     * Is this a valid bounding box? Not Nan or infinity. Upper bound greater than or equal to lower bound.
     */
    public static boolean isValidAABB(
        MemorySegment aabb
    ) {
        MethodHandle method = B2_IS_VALID_AABB.get();
        try {
            return (boolean) method.invokeExact(
                aabb
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #isValidAABB}.
     */
    public static boolean isValidAABB(
        AABB aabb
    ) {
        return (boolean) isValidAABB(
            aabb.memorySegment()
        );
    }
    
    /**
     * Is this a valid plane? Normal is a unit vector. Not Nan or infinity.
     */
    public static boolean isValidPlane(
        MemorySegment a
    ) {
        MethodHandle method = B2_IS_VALID_PLANE.get();
        try {
            return (boolean) method.invokeExact(
                a
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #isValidPlane}.
     */
    public static boolean isValidPlane(
        Plane a
    ) {
        return (boolean) isValidPlane(
            a.memorySegment()
        );
    }
    
    /**
     * Compute an approximate arctangent in the range [-pi, pi] This is hand coded for cross-platform determinism. The atan2f function in the standard library is not cross-platform deterministic. Accurate to around 0.0023 degrees
     */
    public static float atan2(
        float y, 
        float x
    ) {
        MethodHandle method = B2_ATAN2.get();
        try {
            return (float) method.invokeExact(
                y, 
                x
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Compute the cosine and sine of an angle in radians. Implemented for cross-platform determinism.
     */
    public static MemorySegment ncomputeCosSin(
        SegmentAllocator allocator,
        float radians
    ) {
        MethodHandle method = B2_COMPUTE_COS_SIN.get();
        try {
            return (MemorySegment) method.invokeExact(
                allocator,
                radians
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #ncomputeCosSin}.
     */
    public static @Nullable CosSin computeCosSin(
        SegmentAllocator allocator,
        float radians
    ) {
        MemorySegment segment = ncomputeCosSin(
            allocator,
            radians
        );
    
        if (segment.equals(MemorySegment.NULL))
            return null;
    
        return new CosSin(segment);
    }
    
    /**
     * Compute the rotation between two unit vectors
     */
    public static MemorySegment computeRotationBetweenUnitVectors(
        SegmentAllocator allocator,
        MemorySegment v1, 
        MemorySegment v2
    ) {
        MethodHandle method = B2_COMPUTE_ROTATION_BETWEEN_UNIT_VECTORS.get();
        try {
            return (MemorySegment) method.invokeExact(
                allocator,
                v1, 
                v2
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #computeRotationBetweenUnitVectors}.
     */
    public static @Nullable Rot computeRotationBetweenUnitVectors(
        SegmentAllocator allocator,
        Vec2 v1, 
        Vec2 v2
    ) {
        MemorySegment segment = computeRotationBetweenUnitVectors(
            allocator,
            v1.memorySegment(), 
            v2.memorySegment()
        );
    
        if (segment.equals(MemorySegment.NULL))
            return null;
    
        return new Rot(segment);
    }
    
    /**
     * Box2D bases all length units on meters, but you may need different units for your game. You can set this value to use different units. This should be done at application startup and only modified once. Default value is 1. For example, if your game uses pixels for units you can use pixels for all length values sent to Box2D. There should be no extra cost. However, Box2D has some internal tolerances and thresholds that have been tuned for meters. By calling this function, Box2D is able to adjust those tolerances and thresholds to improve accuracy. A good rule of thumb is to pass the height of your player character to this function. So if your player character is 32 pixels high, then pass 32 to this function. Then you may confidently use pixels for all the length values sent to Box2D. All length values returned from Box2D will also be pixels because Box2D does not do any scaling internally. However, you are now on the hook for coming up with good values for gravity, density, and forces.
     */
    public static void setLengthUnitsPerMeter(
        float lengthUnits
    ) {
        MethodHandle method = B2_SET_LENGTH_UNITS_PER_METER.get();
        try {
            method.invokeExact(
                lengthUnits
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Get the current length units per meter.
     */
    public static float getLengthUnitsPerMeter() {
        MethodHandle method = B2_GET_LENGTH_UNITS_PER_METER.get();
        try {
            return (float) method.invokeExact();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
}