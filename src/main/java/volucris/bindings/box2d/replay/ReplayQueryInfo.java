/*
 * MACHINE GENERATED FILE, DO NOT EDIT.
 */
package volucris.bindings.box2d.replay;

import java.lang.foreign.Arena;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.StructLayout;
import java.lang.invoke.VarHandle;
import java.util.function.Consumer;
import volucris.bindings.box2d.math.AABB;
import volucris.bindings.box2d.math.Vec2;
import volucris.bindings.box2d.shape.QueryFilter;
import volucris.bindings.core.NativeStructArray;
import volucris.bindings.core.Struct;

import static java.lang.foreign.ValueLayout.*;

/// ```
/// A spatial query recorded during a replayed frame, exposed for inspection.
/// @ingroup replay
/// ```
public final class ReplayQueryInfo
		implements Struct<ReplayQueryInfo> {

	public static final StructLayout LAYOUT;

	public static final VarHandle TYPE_HANDLE;
	public static final VarHandle HIT_COUNT_HANDLE;

	public static final long TYPE_BYTE_OFFSET;
	public static final long FILTER_BYTE_OFFSET;
	public static final long AABB_BYTE_OFFSET;
	public static final long ORIGIN_BYTE_OFFSET;
	public static final long TRANSLATION_BYTE_OFFSET;
	public static final long HIT_COUNT_BYTE_OFFSET;

	private final MemorySegment segment;

	private final QueryFilter filter;
	private final AABB aabb;
	private final Vec2 origin;
	private final Vec2 translation;

	static {
		//@formatter:off
		LAYOUT = MemoryLayout.structLayout(
		    JAVA_INT.withName("type"),
		    MemoryLayout.paddingLayout(4),
		    QueryFilter.LAYOUT.withName("filter"),
		    AABB.LAYOUT.withName("aabb"),
		    Vec2.LAYOUT.withName("origin"),
		    Vec2.LAYOUT.withName("translation"),
		    JAVA_INT.withName("hitCount"),
		    MemoryLayout.paddingLayout(4)
		).withName("b2ReplayQueryInfo").withByteAlignment(8);
		
		TYPE_HANDLE = LAYOUT.varHandle(PathElement.groupElement("type"));
		HIT_COUNT_HANDLE = LAYOUT.varHandle(PathElement.groupElement("hitCount"));
		
		TYPE_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("type"));
		FILTER_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("filter"));
		AABB_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("aabb"));
		ORIGIN_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("origin"));
		TRANSLATION_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("translation"));
		HIT_COUNT_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("hitCount"));
		//@formatter:on
	}

	public ReplayQueryInfo() {
	    this(Arena.ofAuto());
	}
	
	public ReplayQueryInfo(Arena arena) {
	    this(arena.allocate(LAYOUT));
	}
	
	public ReplayQueryInfo(MemorySegment segment) {
	    this.segment = segment;
	
	    filter = new QueryFilter(segment.asSlice(FILTER_BYTE_OFFSET, QueryFilter.LAYOUT));
	    aabb = new AABB(segment.asSlice(AABB_BYTE_OFFSET, AABB.LAYOUT));
	    origin = new Vec2(segment.asSlice(ORIGIN_BYTE_OFFSET, Vec2.LAYOUT));
	    translation = new Vec2(segment.asSlice(TRANSLATION_BYTE_OFFSET, Vec2.LAYOUT));
	}

    /// @see #type()
    public ReplayQueryInfo type(int type) {
    	TYPE_HANDLE.set(segment, 0L, type);
    	return this;
    }
    
    /// ```
    /// the query type
    /// ```
    public int type() {
    	return (int) TYPE_HANDLE.get(segment, 0L);
    }
    
    /// @see #filter()
    public ReplayQueryInfo filter(Consumer<QueryFilter> consumer) {
    	consumer.accept(filter);
    	return this;
    }
    
    /// @see #filter()
    public ReplayQueryInfo filter(QueryFilter other) {
    	filter.set(other);
    	return this;
    }
    
    /// ```
    /// the query filter
    /// ```
    public QueryFilter filter() {
    	return filter;
    }
    
    /// @see #aabb()
    public ReplayQueryInfo aabb(Consumer<AABB> consumer) {
    	consumer.accept(aabb);
    	return this;
    }
    
    /// @see #aabb()
    public ReplayQueryInfo aabb(AABB other) {
    	aabb.set(other);
    	return this;
    }
    
    /// ```
    /// overlap AABB, relative to origin
    /// ```
    public AABB aabb() {
    	return aabb;
    }
    
    /// @see #origin()
    public ReplayQueryInfo origin(Consumer<Vec2> consumer) {
    	consumer.accept(origin);
    	return this;
    }
    
    /// @see #origin()
    public ReplayQueryInfo origin(Vec2 other) {
    	origin.set(other);
    	return this;
    }
    
    /// ```
    /// query origin
    /// ```
    public Vec2 origin() {
    	return origin;
    }
    
    /// @see #translation()
    public ReplayQueryInfo translation(Consumer<Vec2> consumer) {
    	consumer.accept(translation);
    	return this;
    }
    
    /// @see #translation()
    public ReplayQueryInfo translation(Vec2 other) {
    	translation.set(other);
    	return this;
    }
    
    /// ```
    /// ray and cast translation
    /// ```
    public Vec2 translation() {
    	return translation;
    }
    
    /// @see #hitCount()
    public ReplayQueryInfo hitCount(int hitCount) {
    	HIT_COUNT_HANDLE.set(segment, 0L, hitCount);
    	return this;
    }
    
    /// ```
    /// number of recorded results
    /// ```
    public int hitCount() {
    	return (int) HIT_COUNT_HANDLE.get(segment, 0L);
    }
    
    @Override
    public ReplayQueryInfo set(ReplayQueryInfo other) {
        return set(other.segment);
    }
    
    @Override
    public ReplayQueryInfo set(MemorySegment src) {
        MemorySegment.copy(src, 0L, segment, 0L, LAYOUT.byteSize());
        return this;
    }
    
    @Override
    public MemorySegment memorySegment() {
        return segment;
    }
    
    public NativeStructArray<ReplayQueryInfo> asArray() {
        return new NativeStructArray<>(this);
    }
    
    public static NativeStructArray<ReplayQueryInfo> array(Arena arena, int count) {
        return new NativeStructArray<>(
            arena,
            LAYOUT,
            segment -> new ReplayQueryInfo(segment),
            count
        );
    }
    
    public static NativeStructArray<ReplayQueryInfo> array(Arena arena, ReplayQueryInfo... structs) {
        NativeStructArray<ReplayQueryInfo> array = new NativeStructArray<>(
            arena,
            LAYOUT,
            segment -> new ReplayQueryInfo(segment),
            structs.length
        );
    
        for (int i = 0; i < structs.length; i++) {
            array.set(i, structs[i]);
        }
    
        return array;
    }
    
    public static NativeStructArray<ReplayQueryInfo> array(MemorySegment array) {
        return new NativeStructArray<>(
            array,
            LAYOUT,
            segment -> new ReplayQueryInfo(segment)
        );
    }

}