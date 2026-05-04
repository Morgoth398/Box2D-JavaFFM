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
import volucris.bindings.core.NativeStructArray;
import volucris.bindings.core.Struct;

import static java.lang.foreign.ValueLayout.*;
import static volucris.bindings.core.FFMUtils.*;

/**
 * A filter joint is used to disable collision between two specific bodies.
 */
public final class FilterJointDef
		implements Struct<FilterJointDef> {

    private static final LazyConstant<MethodHandle> B2_DEFAULT_FILTER_JOINT_DEF;

    public static final StructLayout LAYOUT;

    public static final VarHandle USER_DATA;
    public static final VarHandle INTERNAL_VALUE;

    public static final long BODY_ID_A_OFFSET;
    public static final long BODY_ID_B_OFFSET;
    public static final long USER_DATA_OFFSET;
    public static final long INTERNAL_VALUE_OFFSET;

    private final MemorySegment segment;

    private final BodyId bodyIdA;
    private final BodyId bodyIdB;

    static {
        //@formatter:off
        LAYOUT = MemoryLayout.structLayout(
            BodyId.LAYOUT.withName("bodyIdA"),
            BodyId.LAYOUT.withName("bodyIdB"),
            UNBOUNDED_ADDRESS.withName("userData"),
            JAVA_INT.withName("internalValue"),
            MemoryLayout.paddingLayout(4)
        ).withName("b2FilterJointDef").withByteAlignment(8);
        
        B2_DEFAULT_FILTER_JOINT_DEF = downcallHandle("b2DefaultFilterJointDef", FilterJointDef.LAYOUT);
        
        USER_DATA = LAYOUT.varHandle(PathElement.groupElement("userData"));
        INTERNAL_VALUE = LAYOUT.varHandle(PathElement.groupElement("internalValue"));
        
        BODY_ID_A_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("bodyIdA"));
        BODY_ID_B_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("bodyIdB"));
        USER_DATA_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("userData"));
        INTERNAL_VALUE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("internalValue"));
        //@formatter:on
    }

    public FilterJointDef(MemorySegment segment) {
        this.segment = segment;
    
        bodyIdA = new BodyId(segment.asSlice(BODY_ID_A_OFFSET, BodyId.LAYOUT));
        bodyIdB = new BodyId(segment.asSlice(BODY_ID_B_OFFSET, BodyId.LAYOUT));
    }

    /**
     * Use this to initialize your joint definition
     */
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
    
    /**
     * Typed method of {@link #ndefaultFilterJointDef}.
     */
    public static @Nullable FilterJointDef defaultFilterJointDef(
        SegmentAllocator allocator
    ) {
        MemorySegment segment = ndefaultFilterJointDef(allocator);
    
        if (segment.equals(MemorySegment.NULL))
            return null;
    
        return new FilterJointDef(segment);
    }
    
    public FilterJointDef userData(MemorySegment userData) {
        USER_DATA.set(segment, 0L, userData);
        return this;
    }
    
    public @Nullable MemorySegment userData() {
        MemorySegment segment = (MemorySegment) USER_DATA.get(this.segment, 0L);
    
        if (segment.equals(MemorySegment.NULL))
            return null;
    
        return segment;
    }
    
    public FilterJointDef internalValue(int internalValue) {
        INTERNAL_VALUE.set(segment, 0L, internalValue);
        return this;
    }
    
    public int internalValue() {
        return (int) INTERNAL_VALUE.get(segment, 0L);
    }
    
    public FilterJointDef bodyIdA(Consumer<BodyId> consumer) {
        consumer.accept(bodyIdA);
        return this;
    }
    
    public FilterJointDef bodyIdA(BodyId other) {
        bodyIdA.set(other);
        return this;
    }
    
    public BodyId bodyIdA() {
        return bodyIdA;
    }
    
    public FilterJointDef bodyIdB(Consumer<BodyId> consumer) {
        consumer.accept(bodyIdB);
        return this;
    }
    
    public FilterJointDef bodyIdB(BodyId other) {
        bodyIdB.set(other);
        return this;
    }
    
    public BodyId bodyIdB() {
        return bodyIdB;
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