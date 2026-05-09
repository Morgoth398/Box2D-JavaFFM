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
 * The query filter is used to filter collisions between queries and shapes. For example, you may want a ray-cast representing a projectile to hit players and the static environment but not debris.
 */
public final class QueryFilter
		implements Struct<QueryFilter> {

    private static final LazyConstant<MethodHandle> B2_DEFAULT_QUERY_FILTER;

    public static final StructLayout LAYOUT;

    public static final VarHandle CATEGORY_BITS_HANDLE;
    public static final VarHandle MASK_BITS_HANDLE;

    public static final long CATEGORY_BITS_BYTE_OFFSET;
    public static final long MASK_BITS_BYTE_OFFSET;

    private final MemorySegment segment;

    static {
        //@formatter:off
        LAYOUT = MemoryLayout.structLayout(
            JAVA_LONG.withName("categoryBits"),
            JAVA_LONG.withName("maskBits")
        ).withName("b2QueryFilter").withByteAlignment(8);
        
        B2_DEFAULT_QUERY_FILTER = downcallHandle("b2DefaultQueryFilter", QueryFilter.LAYOUT);
        
        CATEGORY_BITS_HANDLE = LAYOUT.varHandle(PathElement.groupElement("categoryBits"));
        MASK_BITS_HANDLE = LAYOUT.varHandle(PathElement.groupElement("maskBits"));
        
        CATEGORY_BITS_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("categoryBits"));
        MASK_BITS_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("maskBits"));
        //@formatter:on
    }

    public QueryFilter(MemorySegment segment) {
        this.segment = segment;
    
    }

    /**
     * Use this to initialize your query filter
     */
    public static MemorySegment ndefaultQueryFilter(
        SegmentAllocator allocator
    ) {
        MethodHandle method = B2_DEFAULT_QUERY_FILTER.get();
        try {
            return (MemorySegment) method.invokeExact(
                allocator
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #ndefaultQueryFilter}.
     */
    public static @Nullable QueryFilter defaultQueryFilter(
        SegmentAllocator allocator
    ) {
        MemorySegment segment = ndefaultQueryFilter(allocator);
    
        if (segment.equals(MemorySegment.NULL))
            return null;
    
        return new QueryFilter(segment);
    }
    
    public QueryFilter categoryBits(long categoryBits) {
        CATEGORY_BITS_HANDLE.set(segment, 0L, categoryBits);
        return this;
    }
    
    public long categoryBits() {
        return (long) CATEGORY_BITS_HANDLE.get(segment, 0L);
    }
    
    public QueryFilter maskBits(long maskBits) {
        MASK_BITS_HANDLE.set(segment, 0L, maskBits);
        return this;
    }
    
    public long maskBits() {
        return (long) MASK_BITS_HANDLE.get(segment, 0L);
    }
    
    @Override
    public QueryFilter set(QueryFilter other) {
        return set(other.segment);
    }
    
    @Override
    public QueryFilter set(MemorySegment src) {
        MemorySegment.copy(src, 0L, segment, 0L, LAYOUT.byteSize());
        return this;
    }
    
    @Override
    public MemorySegment memorySegment() {
        return segment;
    }
    
    public NativeStructArray<QueryFilter> asArray() {
        return new NativeStructArray<>(this);
    }
    
    public static NativeStructArray<QueryFilter> array(Arena arena, int count) {
        return new NativeStructArray<>(
            arena,
            LAYOUT,
            segment -> new QueryFilter(segment),
            count
        );
    }
    
    public static NativeStructArray<QueryFilter> array(Arena arena, QueryFilter... structs) {
        NativeStructArray<QueryFilter> array = new NativeStructArray<>(
            arena,
            LAYOUT,
            segment -> new QueryFilter(segment),
            structs.length
        );
    
        for (int i = 0; i < structs.length; i++) {
            array.set(i, structs[i]);
        }
    
        return array;
    }
    
    public static NativeStructArray<QueryFilter> array(MemorySegment array) {
        return new NativeStructArray<>(
            array,
            LAYOUT,
            segment -> new QueryFilter(segment)
        );
    }
    
}