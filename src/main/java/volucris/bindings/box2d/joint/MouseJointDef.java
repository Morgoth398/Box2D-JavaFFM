/*
 * MACHINE GENERATED FILE, DO NOT EDIT.
 */
package volucris.bindings.box2d.joint;

import edu.umd.cs.findbugs.annotations.Nullable;
import java.lang.foreign.Arena;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.SegmentAllocator;
import java.lang.foreign.StructLayout;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import java.util.function.Consumer;
import volucris.bindings.box2d.body.BodyId;
import volucris.bindings.box2d.math.Vec2;
import volucris.bindings.core.NativeStructArray;
import volucris.bindings.core.Struct;

import static java.lang.foreign.ValueLayout.*;
import static volucris.bindings.core.FFMUtils.*;

/// ```
/// A mouse joint is used to make a point on a body track a specified world point.
/// 
/// This a soft constraint and allows the constraint to stretch without
/// applying huge forces. This also applies rotation constraint heuristic to improve control.
/// @ingroup mouse_joint
/// ```
public final class MouseJointDef
		implements Struct<MouseJointDef> {

    private static final LazyConstant<MethodHandle> B2_DEFAULT_MOUSE_JOINT_DEF;

    public static final StructLayout LAYOUT;

    public static final VarHandle HERTZ_HANDLE;
    public static final VarHandle DAMPING_RATIO_HANDLE;
    public static final VarHandle MAX_FORCE_HANDLE;
    public static final VarHandle COLLIDE_CONNECTED_HANDLE;
    public static final VarHandle USER_DATA_HANDLE;
    public static final VarHandle INTERNAL_VALUE_HANDLE;

    public static final long BODY_ID_A_BYTE_OFFSET;
    public static final long BODY_ID_B_BYTE_OFFSET;
    public static final long TARGET_BYTE_OFFSET;
    public static final long HERTZ_BYTE_OFFSET;
    public static final long DAMPING_RATIO_BYTE_OFFSET;
    public static final long MAX_FORCE_BYTE_OFFSET;
    public static final long COLLIDE_CONNECTED_BYTE_OFFSET;
    public static final long USER_DATA_BYTE_OFFSET;
    public static final long INTERNAL_VALUE_BYTE_OFFSET;

    private final MemorySegment segment;

    private final BodyId bodyIdA;
    private final BodyId bodyIdB;
    private final Vec2 target;

    static {
        //@formatter:off
        LAYOUT = MemoryLayout.structLayout(
            BodyId.LAYOUT.withName("bodyIdA"),
            BodyId.LAYOUT.withName("bodyIdB"),
            Vec2.LAYOUT.withName("target"),
            JAVA_FLOAT.withName("hertz"),
            JAVA_FLOAT.withName("dampingRatio"),
            JAVA_FLOAT.withName("maxForce"),
            JAVA_BOOLEAN.withName("collideConnected"),
            MemoryLayout.paddingLayout(3),
            UNBOUNDED_ADDRESS.withName("userData"),
            JAVA_INT.withName("internalValue"),
            MemoryLayout.paddingLayout(4)
        ).withName("b2MouseJointDef").withByteAlignment(8);
        
        B2_DEFAULT_MOUSE_JOINT_DEF = downcallHandle("b2DefaultMouseJointDef", MouseJointDef.LAYOUT);
        
        HERTZ_HANDLE = LAYOUT.varHandle(PathElement.groupElement("hertz"));
        DAMPING_RATIO_HANDLE = LAYOUT.varHandle(PathElement.groupElement("dampingRatio"));
        MAX_FORCE_HANDLE = LAYOUT.varHandle(PathElement.groupElement("maxForce"));
        COLLIDE_CONNECTED_HANDLE = LAYOUT.varHandle(PathElement.groupElement("collideConnected"));
        USER_DATA_HANDLE = LAYOUT.varHandle(PathElement.groupElement("userData"));
        INTERNAL_VALUE_HANDLE = LAYOUT.varHandle(PathElement.groupElement("internalValue"));
        
        BODY_ID_A_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("bodyIdA"));
        BODY_ID_B_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("bodyIdB"));
        TARGET_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("target"));
        HERTZ_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("hertz"));
        DAMPING_RATIO_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("dampingRatio"));
        MAX_FORCE_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("maxForce"));
        COLLIDE_CONNECTED_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("collideConnected"));
        USER_DATA_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("userData"));
        INTERNAL_VALUE_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("internalValue"));
        //@formatter:on
    }

    public MouseJointDef(MemorySegment segment) {
        this.segment = segment;
    
        bodyIdA = new BodyId(segment.asSlice(BODY_ID_A_BYTE_OFFSET, BodyId.LAYOUT));
        bodyIdB = new BodyId(segment.asSlice(BODY_ID_B_BYTE_OFFSET, BodyId.LAYOUT));
        target = new Vec2(segment.asSlice(TARGET_BYTE_OFFSET, Vec2.LAYOUT));
    }

    /// ```
    /// Use this to initialize your joint definition
    /// @ingroup mouse_joint
    /// ```
    public static MemorySegment ndefaultMouseJointDef(
    	SegmentAllocator allocator
    ) {
    	MethodHandle method = B2_DEFAULT_MOUSE_JOINT_DEF.get();
    	try {
    		return (MemorySegment)  method.invokeExact(
    			allocator
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#ndefaultMouseJointDef].
    public static @Nullable MouseJointDef defaultMouseJointDef(
    	SegmentAllocator allocator
    ) {
    	MemorySegment segment = ndefaultMouseJointDef(
    		allocator
    	);
    
    	if (segment.equals(MemorySegment.NULL))
    		return null;
    	
    	return new MouseJointDef(segment);
    }
    
    /// @see #hertz()
    public MouseJointDef hertz(float hertz) {
    	HERTZ_HANDLE.set(segment, 0L, hertz);
    	return this;
    }
    
    /// ```
    /// Stiffness in hertz
    /// ```
    public float hertz() {
    	return (float) HERTZ_HANDLE.get(segment, 0L);
    }
    
    /// @see #dampingRatio()
    public MouseJointDef dampingRatio(float dampingRatio) {
    	DAMPING_RATIO_HANDLE.set(segment, 0L, dampingRatio);
    	return this;
    }
    
    /// ```
    /// Damping ratio, non-dimensional
    /// ```
    public float dampingRatio() {
    	return (float) DAMPING_RATIO_HANDLE.get(segment, 0L);
    }
    
    /// @see #maxForce()
    public MouseJointDef maxForce(float maxForce) {
    	MAX_FORCE_HANDLE.set(segment, 0L, maxForce);
    	return this;
    }
    
    /// ```
    /// Maximum force, typically in newtons
    /// ```
    public float maxForce() {
    	return (float) MAX_FORCE_HANDLE.get(segment, 0L);
    }
    
    /// @see #collideConnected()
    public MouseJointDef collideConnected(boolean collideConnected) {
    	COLLIDE_CONNECTED_HANDLE.set(segment, 0L, collideConnected);
    	return this;
    }
    
    /// ```
    /// Set this flag to true if the attached bodies should collide.
    /// ```
    public boolean collideConnected() {
    	return (boolean) COLLIDE_CONNECTED_HANDLE.get(segment, 0L);
    }
    
    /// @see #userData()
    public MouseJointDef userData(MemorySegment userData) {
    	USER_DATA_HANDLE.set(segment, 0L, userData);
    	return this;
    }
    
    /// ```
    /// User data pointer
    /// ```
    public @Nullable MemorySegment userData() {
    	MemorySegment segment = (MemorySegment) USER_DATA_HANDLE.get(this.segment, 0L);
    
    	if (segment.equals(MemorySegment.NULL))
    		return null;
    	
    	return segment;
    }
    
    /// @see #internalValue()
    public MouseJointDef internalValue(int internalValue) {
    	INTERNAL_VALUE_HANDLE.set(segment, 0L, internalValue);
    	return this;
    }
    
    /// ```
    /// Used internally to detect a valid definition. DO NOT SET.
    /// ```
    public int internalValue() {
    	return (int) INTERNAL_VALUE_HANDLE.get(segment, 0L);
    }
    
    /// @see #bodyIdA()
    public MouseJointDef bodyIdA(Consumer<BodyId> consumer) {
    	consumer.accept(bodyIdA);
    	return this;
    }
    
    /// @see #bodyIdA()
    public MouseJointDef bodyIdA(BodyId other) {
    	bodyIdA.set(other);
    	return this;
    }
    
    /// ```
    /// The first attached body. This is assumed to be static.
    /// ```
    public BodyId bodyIdA() {
    	return bodyIdA;
    }
    
    /// @see #bodyIdB()
    public MouseJointDef bodyIdB(Consumer<BodyId> consumer) {
    	consumer.accept(bodyIdB);
    	return this;
    }
    
    /// @see #bodyIdB()
    public MouseJointDef bodyIdB(BodyId other) {
    	bodyIdB.set(other);
    	return this;
    }
    
    /// ```
    /// The second attached body.
    /// ```
    public BodyId bodyIdB() {
    	return bodyIdB;
    }
    
    /// @see #target()
    public MouseJointDef target(Consumer<Vec2> consumer) {
    	consumer.accept(target);
    	return this;
    }
    
    /// @see #target()
    public MouseJointDef target(Vec2 other) {
    	target.set(other);
    	return this;
    }
    
    /// ```
    /// The initial target point in world space
    /// ```
    public Vec2 target() {
    	return target;
    }
    
    @Override
    public MouseJointDef set(MouseJointDef other) {
        return set(other.segment);
    }
    
    @Override
    public MouseJointDef set(MemorySegment src) {
        MemorySegment.copy(src, 0L, segment, 0L, LAYOUT.byteSize());
        return this;
    }
    
    @Override
    public MemorySegment memorySegment() {
        return segment;
    }
    
    public NativeStructArray<MouseJointDef> asArray() {
        return new NativeStructArray<>(this);
    }
    
    public static NativeStructArray<MouseJointDef> array(Arena arena, int count) {
        return new NativeStructArray<>(
            arena,
            LAYOUT,
            segment -> new MouseJointDef(segment),
            count
        );
    }
    
    public static NativeStructArray<MouseJointDef> array(Arena arena, MouseJointDef... structs) {
        NativeStructArray<MouseJointDef> array = new NativeStructArray<>(
            arena,
            LAYOUT,
            segment -> new MouseJointDef(segment),
            structs.length
        );
    
        for (int i = 0; i < structs.length; i++) {
            array.set(i, structs[i]);
        }
    
        return array;
    }
    
    public static NativeStructArray<MouseJointDef> array(MemorySegment array) {
        return new NativeStructArray<>(
            array,
            LAYOUT,
            segment -> new MouseJointDef(segment)
        );
    }
    
}