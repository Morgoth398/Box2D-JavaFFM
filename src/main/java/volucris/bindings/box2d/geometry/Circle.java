/*
 * MACHINE GENERATED FILE, DO NOT EDIT.
 */
package volucris.bindings.box2d.geometry;

import java.lang.foreign.Arena;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.SegmentAllocator;
import java.lang.foreign.StructLayout;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.util.function.Consumer;
import org.jspecify.annotations.Nullable;
import volucris.bindings.box2d.math.AABB;
import volucris.bindings.box2d.math.Transform;
import volucris.bindings.box2d.math.Vec2;
import volucris.bindings.core.NativeStructArray;
import volucris.bindings.core.Struct;

import static java.lang.foreign.ValueLayout.*;
import static volucris.bindings.core.FFMUtils.*;

/// ```
/// A solid circle
/// ```
public final class Circle
		implements Struct<Circle> {

	private static final LazyConstant<MethodHandle> B2_COMPUTE_CIRCLE_MASS;
	private static final LazyConstant<MethodHandle> B2_COMPUTE_CIRCLE_BOUNDS;
	private static final LazyConstant<MethodHandle> B2_POINT_IN_CIRCLE;
	private static final LazyConstant<MethodHandle> B2_CAST_RAY_CIRCLE;
	private static final LazyConstant<MethodHandle> B2_CAST_SHAPE_CIRCLE;

	public static final StructLayout LAYOUT;

	public static final VarHandle RADIUS_HANDLE;

	public static final long CENTER_BYTE_OFFSET;
	public static final long RADIUS_BYTE_OFFSET;

	private final MemorySegment segment;

	private final Vec2 center;

	static {
		//@formatter:off
		LAYOUT = MemoryLayout.structLayout(
		    Vec2.LAYOUT.withName("center"),
		    JAVA_FLOAT.withName("radius")
		).withName("b2Circle").withByteAlignment(4);
		
		B2_COMPUTE_CIRCLE_MASS = downcallHandle("b2ComputeCircleMass", MassData.LAYOUT, UNBOUNDED_ADDRESS, JAVA_FLOAT);
		B2_COMPUTE_CIRCLE_BOUNDS = downcallHandle("b2ComputeCircleBounds", AABB.LAYOUT, UNBOUNDED_ADDRESS, Transform.LAYOUT);
		B2_POINT_IN_CIRCLE = downcallHandle("b2PointInCircle", JAVA_BOOLEAN, UNBOUNDED_ADDRESS, Vec2.LAYOUT);
		B2_CAST_RAY_CIRCLE = downcallHandle("b2CastRayCircle", CastOutput.LAYOUT, UNBOUNDED_ADDRESS, UNBOUNDED_ADDRESS);
		B2_CAST_SHAPE_CIRCLE = downcallHandle("b2CastShapeCircle", CastOutput.LAYOUT, UNBOUNDED_ADDRESS, UNBOUNDED_ADDRESS);
		
		RADIUS_HANDLE = LAYOUT.varHandle(PathElement.groupElement("radius"));
		
		CENTER_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("center"));
		RADIUS_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("radius"));
		//@formatter:on
	}

	public Circle() {
	    this(Arena.ofAuto());
	}
	
	public Circle(Arena arena) {
	    this(arena.allocate(LAYOUT));
	}
	
	public Circle(MemorySegment segment) {
	    this.segment = segment;
	
	    center = new Vec2(segment.asSlice(CENTER_BYTE_OFFSET, Vec2.LAYOUT));
	}

    /// ```
    /// Compute mass properties of a circle
    /// ```
    public static MemorySegment computeCircleMass(
    	SegmentAllocator allocator,
    	MemorySegment shape,
    	float density
    ) {
    	MethodHandle method = B2_COMPUTE_CIRCLE_MASS.get();
    	try {
    		return (MemorySegment) method.invokeExact(
    			allocator,
    			shape,
    			density
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#computeCircleMass].
    public final @Nullable MassData computeCircleMass(
    	SegmentAllocator allocator,
    	float density
    ) {
    	MemorySegment segment = computeCircleMass(
    		allocator,
    		this.segment,
    		density
    	);
    
    	if (segment.equals(MemorySegment.NULL))
    		return null;
    	
    	return new MassData(segment);
    }
    
    /// ```
    /// Compute the bounding box of a transformed circle
    /// ```
    public static MemorySegment computeCircleBounds(
    	SegmentAllocator allocator,
    	MemorySegment shape,
    	MemorySegment transform
    ) {
    	MethodHandle method = B2_COMPUTE_CIRCLE_BOUNDS.get();
    	try {
    		return (MemorySegment) method.invokeExact(
    			allocator,
    			shape,
    			transform
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#computeCircleBounds].
    public final @Nullable AABB computeCircleBounds(
    	SegmentAllocator allocator,
    	Transform transform
    ) {
    	MemorySegment segment = computeCircleBounds(
    		allocator,
    		this.segment,
    		transform.memorySegment()
    	);
    
    	if (segment.equals(MemorySegment.NULL))
    		return null;
    	
    	return new AABB(segment);
    }
    
    /// ```
    /// Test a point for overlap with a circle in local space
    /// ```
    public static boolean pointInCircle(
    	MemorySegment shape,
    	MemorySegment point
    ) {
    	MethodHandle method = B2_POINT_IN_CIRCLE.get();
    	try {
    		return (boolean) method.invokeExact(
    			shape,
    			point
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#pointInCircle].
    public final boolean pointInCircle(
    	Vec2 point
    ) {
    	return pointInCircle(
    		this.segment,
    		point.memorySegment()
    	);
    }
    
    /// ```
    /// Ray cast versus circle shape in local space.
    /// ```
    public static MemorySegment castRayCircle(
    	SegmentAllocator allocator,
    	MemorySegment shape,
    	MemorySegment input
    ) {
    	MethodHandle method = B2_CAST_RAY_CIRCLE.get();
    	try {
    		return (MemorySegment) method.invokeExact(
    			allocator,
    			shape,
    			input
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#castRayCircle].
    public final @Nullable CastOutput castRayCircle(
    	SegmentAllocator allocator,
    	RayCastInput input
    ) {
    	MemorySegment segment = castRayCircle(
    		allocator,
    		this.segment,
    		input.memorySegment()
    	);
    
    	if (segment.equals(MemorySegment.NULL))
    		return null;
    	
    	return new CastOutput(segment);
    }
    
    /// ```
    /// Shape cast versus a circle.
    /// ```
    public static MemorySegment castShapeCircle(
    	SegmentAllocator allocator,
    	MemorySegment shape,
    	MemorySegment input
    ) {
    	MethodHandle method = B2_CAST_SHAPE_CIRCLE.get();
    	try {
    		return (MemorySegment) method.invokeExact(
    			allocator,
    			shape,
    			input
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#castShapeCircle].
    public final @Nullable CastOutput castShapeCircle(
    	SegmentAllocator allocator,
    	ShapeCastInput input
    ) {
    	MemorySegment segment = castShapeCircle(
    		allocator,
    		this.segment,
    		input.memorySegment()
    	);
    
    	if (segment.equals(MemorySegment.NULL))
    		return null;
    	
    	return new CastOutput(segment);
    }
    
    /// @see #center()
    public Circle center(Consumer<Vec2> consumer) {
    	consumer.accept(center);
    	return this;
    }
    
    /// @see #center()
    public Circle center(Vec2 other) {
    	center.set(other);
    	return this;
    }
    
    /// ```
    /// The local center
    /// ```
    public Vec2 center() {
    	return center;
    }
    
    /// @see #radius()
    public Circle radius(float radius) {
    	RADIUS_HANDLE.set(segment, 0L, radius);
    	return this;
    }
    
    /// ```
    /// The radius
    /// ```
    public float radius() {
    	return (float) RADIUS_HANDLE.get(segment, 0L);
    }
    
    @Override
    public Circle set(Circle other) {
        return set(other.segment);
    }
    
    @Override
    public Circle set(MemorySegment src) {
        MemorySegment.copy(src, 0L, segment, 0L, LAYOUT.byteSize());
        return this;
    }
    
    @Override
    public MemorySegment memorySegment() {
        return segment;
    }
    
    public NativeStructArray<Circle> asArray() {
        return new NativeStructArray<>(this);
    }
    
    public static NativeStructArray<Circle> array(Arena arena, int count) {
        return new NativeStructArray<>(
            arena,
            LAYOUT,
            segment -> new Circle(segment),
            count
        );
    }
    
    public static NativeStructArray<Circle> array(Arena arena, Circle... structs) {
        NativeStructArray<Circle> array = new NativeStructArray<>(
            arena,
            LAYOUT,
            segment -> new Circle(segment),
            structs.length
        );
    
        for (int i = 0; i < structs.length; i++) {
            array.set(i, structs[i]);
        }
    
        return array;
    }
    
    public static NativeStructArray<Circle> array(MemorySegment array) {
        return new NativeStructArray<>(
            array,
            LAYOUT,
            segment -> new Circle(segment)
        );
    }

}