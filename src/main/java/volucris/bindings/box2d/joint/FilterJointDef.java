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
import volucris.bindings.core.NativeStructArray;
import volucris.bindings.core.Struct;

import static java.lang.foreign.ValueLayout.*;
import static volucris.bindings.core.FFMUtils.*;

/// ```
/// A filter joint is used to disable collision between two specific bodies.
/// 
/// @ingroup filter_joint
/// ```
public final class FilterJointDef
		implements Struct<FilterJointDef> {

	private static final LazyConstant<MethodHandle> B2_DEFAULT_FILTER_JOINT_DEF;

	public static final StructLayout LAYOUT;

	public static final VarHandle INTERNAL_VALUE_HANDLE;

	public static final long BASE_BYTE_OFFSET;
	public static final long INTERNAL_VALUE_BYTE_OFFSET;

	private final MemorySegment segment;

	private final JointDef base;

	static {
		//@formatter:off
		LAYOUT = MemoryLayout.structLayout(
		    JointDef.LAYOUT.withName("base"),
		    JAVA_INT.withName("internalValue"),
		    MemoryLayout.paddingLayout(4)
		).withName("b2FilterJointDef").withByteAlignment(8);
		
		B2_DEFAULT_FILTER_JOINT_DEF = downcallHandle("b2DefaultFilterJointDef", FilterJointDef.LAYOUT);
		
		INTERNAL_VALUE_HANDLE = LAYOUT.varHandle(PathElement.groupElement("internalValue"));
		
		BASE_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("base"));
		INTERNAL_VALUE_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("internalValue"));
		//@formatter:on
	}

	public FilterJointDef(MemorySegment segment) {
	    this.segment = segment;
	
	    base = new JointDef(segment.asSlice(BASE_BYTE_OFFSET, JointDef.LAYOUT));
	}

    /// ```
    /// Use this to initialize your joint definition
    /// @ingroup filter_joint
    /// ```
    public static MemorySegment ndefaultFilterJointDef(
    	SegmentAllocator allocator
    ) {
    	MethodHandle method = B2_DEFAULT_FILTER_JOINT_DEF.get();
    	try {
    		return (MemorySegment) method.invokeExact(
    			allocator
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#ndefaultFilterJointDef].
    public static @Nullable FilterJointDef defaultFilterJointDef(
    	SegmentAllocator allocator
    ) {
    	MemorySegment segment = ndefaultFilterJointDef(
    		allocator
    	);
    
    	if (segment.equals(MemorySegment.NULL))
    		return null;
    	
    	return new FilterJointDef(segment);
    }
    
    /// @see #base()
    public FilterJointDef base(Consumer<JointDef> consumer) {
    	consumer.accept(base);
    	return this;
    }
    
    /// @see #base()
    public FilterJointDef base(JointDef other) {
    	base.set(other);
    	return this;
    }
    
    /// ```
    /// Base joint definition
    /// ```
    public JointDef base() {
    	return base;
    }
    
    /// @see #internalValue()
    public FilterJointDef internalValue(int internalValue) {
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
    public FilterJointDef set(FilterJointDef other) {
        return set(other.segment);
    }
    
    @Override
    public FilterJointDef set(MemorySegment src) {
        MemorySegment.copy(src, 0L, segment, 0L, LAYOUT.byteSize());
        return this;
    }
    
    @Override
    public MemorySegment memorySegment() {
        return segment;
    }
    
    public NativeStructArray<FilterJointDef> asArray() {
        return new NativeStructArray<>(this);
    }
    
    public static NativeStructArray<FilterJointDef> array(Arena arena, int count) {
        return new NativeStructArray<>(
            arena,
            LAYOUT,
            segment -> new FilterJointDef(segment),
            count
        );
    }
    
    public static NativeStructArray<FilterJointDef> array(Arena arena, FilterJointDef... structs) {
        NativeStructArray<FilterJointDef> array = new NativeStructArray<>(
            arena,
            LAYOUT,
            segment -> new FilterJointDef(segment),
            structs.length
        );
    
        for (int i = 0; i < structs.length; i++) {
            array.set(i, structs[i]);
        }
    
        return array;
    }
    
    public static NativeStructArray<FilterJointDef> array(MemorySegment array) {
        return new NativeStructArray<>(
            array,
            LAYOUT,
            segment -> new FilterJointDef(segment)
        );
    }

}