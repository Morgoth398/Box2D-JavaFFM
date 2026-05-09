/*
 * MACHINE GENERATED FILE, DO NOT EDIT.
 */
package volucris.bindings.box2d.shape;

import edu.umd.cs.findbugs.annotations.Nullable;
import java.lang.foreign.Arena;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.SegmentAllocator;
import java.lang.foreign.StructLayout;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;
import volucris.bindings.core.NativeStructArray;
import volucris.bindings.core.Struct;

import static java.lang.foreign.ValueLayout.*;
import static volucris.bindings.core.FFMUtils.*;

/**
 * This is used to filter collision on shapes. It affects shape-vs-shape collision and shape-versus-query collision (such as b2World_CastRay).
 */
public final class Filter
		implements Struct<Filter> {

    private static final LazyConstant<MethodHandle> B2_DEFAULT_FILTER;

    public static final StructLayout LAYOUT;

    public static final VarHandle CATEGORY_BITS_HANDLE;
    public static final VarHandle MASK_BITS_HANDLE;
    public static final VarHandle GROUP_INDEX_HANDLE;

    public static final long CATEGORY_BITS_BYTE_OFFSET;
    public static final long MASK_BITS_BYTE_OFFSET;
    public static final long GROUP_INDEX_BYTE_OFFSET;

    private final MemorySegment segment;

    static {
        //@formatter:off
        LAYOUT = MemoryLayout.structLayout(
            JAVA_LONG.withName("categoryBits"),
            JAVA_LONG.withName("maskBits"),
            JAVA_INT.withName("groupIndex"),
            MemoryLayout.paddingLayout(4)
        ).withName("b2Filter").withByteAlignment(8);
        
        B2_DEFAULT_FILTER = downcallHandle("b2DefaultFilter", Filter.LAYOUT);
        
        CATEGORY_BITS_HANDLE = LAYOUT.varHandle(PathElement.groupElement("categoryBits"));
        MASK_BITS_HANDLE = LAYOUT.varHandle(PathElement.groupElement("maskBits"));
        GROUP_INDEX_HANDLE = LAYOUT.varHandle(PathElement.groupElement("groupIndex"));
        
        CATEGORY_BITS_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("categoryBits"));
        MASK_BITS_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("maskBits"));
        GROUP_INDEX_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("groupIndex"));
        //@formatter:on
    }

    public Filter(MemorySegment segment) {
        this.segment = segment;
    
    }

    /**
     * Use this to initialize your filter
     */
    public static MemorySegment ndefaultFilter(
        SegmentAllocator allocator
    ) {
        MethodHandle method = B2_DEFAULT_FILTER.get();
        try {
            return (MemorySegment) method.invokeExact(
                allocator
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #ndefaultFilter}.
     */
    public static @Nullable Filter defaultFilter(
        SegmentAllocator allocator
    ) {
        MemorySegment segment = ndefaultFilter(allocator);
    
        if (segment.equals(MemorySegment.NULL))
            return null;
    
        return new Filter(segment);
    }
    
    public Filter categoryBits(long categoryBits) {
        CATEGORY_BITS_HANDLE.set(segment, 0L, categoryBits);
        return this;
    }
    
    public long categoryBits() {
        return (long) CATEGORY_BITS_HANDLE.get(segment, 0L);
    }
    
    public Filter maskBits(long maskBits) {
        MASK_BITS_HANDLE.set(segment, 0L, maskBits);
        return this;
    }
    
    public long maskBits() {
        return (long) MASK_BITS_HANDLE.get(segment, 0L);
    }
    
    public Filter groupIndex(int groupIndex) {
        GROUP_INDEX_HANDLE.set(segment, 0L, groupIndex);
        return this;
    }
    
    public int groupIndex() {
        return (int) GROUP_INDEX_HANDLE.get(segment, 0L);
    }
    
    @Override
    public Filter set(Filter other) {
        return set(other.segment);
    }
    
    @Override
    public Filter set(MemorySegment src) {
        MemorySegment.copy(src, 0L, segment, 0L, LAYOUT.byteSize());
        return this;
    }
    
    @Override
    public MemorySegment memorySegment() {
        return segment;
    }
    
    public NativeStructArray<Filter> asArray() {
        return new NativeStructArray<>(this);
    }
    
    public static NativeStructArray<Filter> array(Arena arena, int count) {
        return new NativeStructArray<>(
            arena,
            LAYOUT,
            segment -> new Filter(segment),
            count
        );
    }
    
    public static NativeStructArray<Filter> array(Arena arena, Filter... structs) {
        NativeStructArray<Filter> array = new NativeStructArray<>(
            arena,
            LAYOUT,
            segment -> new Filter(segment),
            structs.length
        );
    
        for (int i = 0; i < structs.length; i++) {
            array.set(i, structs[i]);
        }
    
        return array;
    }
    
    public static NativeStructArray<Filter> array(MemorySegment array) {
        return new NativeStructArray<>(
            array,
            LAYOUT,
            segment -> new Filter(segment)
        );
    }
    
}