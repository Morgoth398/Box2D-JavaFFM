/*
 * MACHINE GENERATED FILE, DO NOT EDIT.
 */
package volucris.bindings.box2d.joint;

import java.lang.foreign.Arena;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.SegmentAllocator;
import java.lang.foreign.StructLayout;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.util.function.Consumer;
import org.jspecify.annotations.Nullable;
import volucris.bindings.box2d.math.Vec2;
import volucris.bindings.core.NativeStructArray;
import volucris.bindings.core.Struct;

import static java.lang.foreign.ValueLayout.*;
import static volucris.bindings.core.FFMUtils.*;

/// ```
/// Pogo joint definition
/// @ingroup pogo_joint
/// ```
public final class PogoJointDef
		implements Struct<PogoJointDef> {

	private static final LazyConstant<MethodHandle> B2_DEFAULT_POGO_JOINT_DEF;

	public static final StructLayout LAYOUT;

	public static final VarHandle HERTZ_HANDLE;
	public static final VarHandle DAMPING_RATIO_HANDLE;
	public static final VarHandle REST_LENGTH_HANDLE;
	public static final VarHandle MAX_TENSION_FORCE_HANDLE;
	public static final VarHandle MAX_COMPRESSION_FORCE_HANDLE;
	public static final VarHandle IMPULSE_HANDLE;
	public static final VarHandle VELOCITY_HANDLE;
	public static final VarHandle INTERNAL_VALUE_HANDLE;

	public static final long BASE_BYTE_OFFSET;
	public static final long NORMAL_BYTE_OFFSET;
	public static final long HERTZ_BYTE_OFFSET;
	public static final long DAMPING_RATIO_BYTE_OFFSET;
	public static final long REST_LENGTH_BYTE_OFFSET;
	public static final long MAX_TENSION_FORCE_BYTE_OFFSET;
	public static final long MAX_COMPRESSION_FORCE_BYTE_OFFSET;
	public static final long IMPULSE_BYTE_OFFSET;
	public static final long VELOCITY_BYTE_OFFSET;
	public static final long INTERNAL_VALUE_BYTE_OFFSET;

	private final MemorySegment segment;

	private final JointDef base;
	private final Vec2 normal;

	static {
		//@formatter:off
		LAYOUT = MemoryLayout.structLayout(
		    JointDef.LAYOUT.withName("base"),
		    Vec2.LAYOUT.withName("normal"),
		    JAVA_FLOAT.withName("hertz"),
		    JAVA_FLOAT.withName("dampingRatio"),
		    JAVA_FLOAT.withName("restLength"),
		    JAVA_FLOAT.withName("maxTensionForce"),
		    JAVA_FLOAT.withName("maxCompressionForce"),
		    JAVA_FLOAT.withName("impulse"),
		    JAVA_FLOAT.withName("velocity"),
		    JAVA_INT.withName("internalValue")
		).withName("b2PogoJointDef").withByteAlignment(8);
		
		B2_DEFAULT_POGO_JOINT_DEF = downcallHandle("b2DefaultPogoJointDef", PogoJointDef.LAYOUT);
		
		HERTZ_HANDLE = LAYOUT.varHandle(PathElement.groupElement("hertz"));
		DAMPING_RATIO_HANDLE = LAYOUT.varHandle(PathElement.groupElement("dampingRatio"));
		REST_LENGTH_HANDLE = LAYOUT.varHandle(PathElement.groupElement("restLength"));
		MAX_TENSION_FORCE_HANDLE = LAYOUT.varHandle(PathElement.groupElement("maxTensionForce"));
		MAX_COMPRESSION_FORCE_HANDLE = LAYOUT.varHandle(PathElement.groupElement("maxCompressionForce"));
		IMPULSE_HANDLE = LAYOUT.varHandle(PathElement.groupElement("impulse"));
		VELOCITY_HANDLE = LAYOUT.varHandle(PathElement.groupElement("velocity"));
		INTERNAL_VALUE_HANDLE = LAYOUT.varHandle(PathElement.groupElement("internalValue"));
		
		BASE_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("base"));
		NORMAL_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("normal"));
		HERTZ_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("hertz"));
		DAMPING_RATIO_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("dampingRatio"));
		REST_LENGTH_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("restLength"));
		MAX_TENSION_FORCE_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("maxTensionForce"));
		MAX_COMPRESSION_FORCE_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("maxCompressionForce"));
		IMPULSE_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("impulse"));
		VELOCITY_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("velocity"));
		INTERNAL_VALUE_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("internalValue"));
		//@formatter:on
	}

	public PogoJointDef(MemorySegment segment) {
	    this.segment = segment;
	
	    base = new JointDef(segment.asSlice(BASE_BYTE_OFFSET, JointDef.LAYOUT));
	    normal = new Vec2(segment.asSlice(NORMAL_BYTE_OFFSET, Vec2.LAYOUT));
	}

    /// ```
    /// Use this to initialize your joint definition
    /// @ingroup pogo_joint
    /// ```
    public static MemorySegment ndefaultPogoJointDef(
    	SegmentAllocator allocator
    ) {
    	MethodHandle method = B2_DEFAULT_POGO_JOINT_DEF.get();
    	try {
    		return (MemorySegment) method.invokeExact(
    			allocator
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#ndefaultPogoJointDef].
    public static @Nullable PogoJointDef defaultPogoJointDef(
    	SegmentAllocator allocator
    ) {
    	MemorySegment segment = ndefaultPogoJointDef(
    		allocator
    	);
    
    	if (segment.equals(MemorySegment.NULL))
    		return null;
    	
    	return new PogoJointDef(segment);
    }
    
    /// @see #base()
    public PogoJointDef base(Consumer<JointDef> consumer) {
    	consumer.accept(base);
    	return this;
    }
    
    /// @see #base()
    public PogoJointDef base(JointDef other) {
    	base.set(other);
    	return this;
    }
    
    /// ```
    /// Base joint definition
    /// ```
    public JointDef base() {
    	return base;
    }
    
    /// @see #normal()
    public PogoJointDef normal(Consumer<Vec2> consumer) {
    	consumer.accept(normal);
    	return this;
    }
    
    /// @see #normal()
    public PogoJointDef normal(Vec2 other) {
    	normal.set(other);
    	return this;
    }
    
    /// ```
    /// Normal vector at the contact
    /// ```
    public Vec2 normal() {
    	return normal;
    }
    
    /// @see #hertz()
    public PogoJointDef hertz(float hertz) {
    	HERTZ_HANDLE.set(segment, 0L, hertz);
    	return this;
    }
    
    /// ```
    /// The spring stiffness Hertz, cycles per second
    /// ```
    public float hertz() {
    	return (float) HERTZ_HANDLE.get(segment, 0L);
    }
    
    /// @see #dampingRatio()
    public PogoJointDef dampingRatio(float dampingRatio) {
    	DAMPING_RATIO_HANDLE.set(segment, 0L, dampingRatio);
    	return this;
    }
    
    /// ```
    /// The spring damping ratio, non-dimensional
    /// ```
    public float dampingRatio() {
    	return (float) DAMPING_RATIO_HANDLE.get(segment, 0L);
    }
    
    /// @see #restLength()
    public PogoJointDef restLength(float restLength) {
    	REST_LENGTH_HANDLE.set(segment, 0L, restLength);
    	return this;
    }
    
    /// ```
    /// Spring length.
    /// ```
    public float restLength() {
    	return (float) REST_LENGTH_HANDLE.get(segment, 0L);
    }
    
    /// @see #maxTensionForce()
    public PogoJointDef maxTensionForce(float maxTensionForce) {
    	MAX_TENSION_FORCE_HANDLE.set(segment, 0L, maxTensionForce);
    	return this;
    }
    
    /// ```
    /// Maximum tension force. Controls how sticky the mover is to ground.
    /// ```
    public float maxTensionForce() {
    	return (float) MAX_TENSION_FORCE_HANDLE.get(segment, 0L);
    }
    
    /// @see #maxCompressionForce()
    public PogoJointDef maxCompressionForce(float maxCompressionForce) {
    	MAX_COMPRESSION_FORCE_HANDLE.set(segment, 0L, maxCompressionForce);
    	return this;
    }
    
    /// ```
    /// Maximum compression force. How hard the pogo pushes the mover up from the ground.
    /// ```
    public float maxCompressionForce() {
    	return (float) MAX_COMPRESSION_FORCE_HANDLE.get(segment, 0L);
    }
    
    /// @see #impulse()
    public PogoJointDef impulse(float impulse) {
    	IMPULSE_HANDLE.set(segment, 0L, impulse);
    	return this;
    }
    
    /// ```
    /// The initial pogo internal impulse. The pogo is typically recreated every frame. This gives a
    /// way to move the internal state forward for smoother spring behavior.
    /// ```
    public float impulse() {
    	return (float) IMPULSE_HANDLE.get(segment, 0L);
    }
    
    /// @see #velocity()
    public PogoJointDef velocity(float velocity) {
    	VELOCITY_HANDLE.set(segment, 0L, velocity);
    	return this;
    }
    
    /// ```
    /// The initial pogo internal velocity. The pogo is typically recreated every frame. This gives
    /// a way to move the internal state forward for smoother spring behavior.
    /// ```
    public float velocity() {
    	return (float) VELOCITY_HANDLE.get(segment, 0L);
    }
    
    /// @see #internalValue()
    public PogoJointDef internalValue(int internalValue) {
    	INTERNAL_VALUE_HANDLE.set(segment, 0L, internalValue);
    	return this;
    }
    
    /// ```
    /// Used internally to detect a valid definition. DO NOT SET.
    /// ```
    public int internalValue() {
    	return (int) INTERNAL_VALUE_HANDLE.get(segment, 0L);
    }
    
    @Override
    public PogoJointDef set(PogoJointDef other) {
        return set(other.segment);
    }
    
    @Override
    public PogoJointDef set(MemorySegment src) {
        MemorySegment.copy(src, 0L, segment, 0L, LAYOUT.byteSize());
        return this;
    }
    
    @Override
    public MemorySegment memorySegment() {
        return segment;
    }
    
    public NativeStructArray<PogoJointDef> asArray() {
        return new NativeStructArray<>(this);
    }
    
    public static NativeStructArray<PogoJointDef> array(Arena arena, int count) {
        return new NativeStructArray<>(
            arena,
            LAYOUT,
            segment -> new PogoJointDef(segment),
            count
        );
    }
    
    public static NativeStructArray<PogoJointDef> array(Arena arena, PogoJointDef... structs) {
        NativeStructArray<PogoJointDef> array = new NativeStructArray<>(
            arena,
            LAYOUT,
            segment -> new PogoJointDef(segment),
            structs.length
        );
    
        for (int i = 0; i < structs.length; i++) {
            array.set(i, structs[i]);
        }
    
        return array;
    }
    
    public static NativeStructArray<PogoJointDef> array(MemorySegment array) {
        return new NativeStructArray<>(
            array,
            LAYOUT,
            segment -> new PogoJointDef(segment)
        );
    }

}