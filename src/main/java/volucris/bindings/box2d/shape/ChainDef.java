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
import java.util.function.Consumer;
import volucris.bindings.box2d.math.Vec2;
import volucris.bindings.core.NativeStructArray;
import volucris.bindings.core.Struct;

import static java.lang.foreign.ValueLayout.*;
import static volucris.bindings.core.FFMUtils.*;

/**
 * Used to create a chain of line segments. This is designed to eliminate ghost collisions with some limitations. - chains are one-sided - chains have no mass and should be used on static bodies - chains have a counter-clockwise winding order (normal points right of segment direction) - chains are either a loop or open - a chain must have at least 4 points - the distance between any two points must be greater than B2_LINEAR_SLOP - a chain shape should not self intersect (this is not validated) - an open chain shape has NO COLLISION on the first and final edge - you may overlap two open chains on their first three and/or last three points to get smooth collision - a chain shape creates multiple line segment shapes on the body https://en.wikipedia.org/wiki/Polygonal_chain Must be initialized using b2DefaultChainDef().
 */
public final class ChainDef
		implements Struct<ChainDef> {

    private static final LazyConstant<MethodHandle> B2_DEFAULT_CHAIN_DEF;

    public static final StructLayout LAYOUT;

    public static final VarHandle USER_DATA_HANDLE;
    public static final VarHandle POINTS_HANDLE;
    public static final VarHandle COUNT_HANDLE;
    public static final VarHandle MATERIALS_HANDLE;
    public static final VarHandle MATERIAL_COUNT_HANDLE;
    public static final VarHandle IS_LOOP_HANDLE;
    public static final VarHandle ENABLE_SENSOR_EVENTS_HANDLE;
    public static final VarHandle INTERNAL_VALUE_HANDLE;

    public static final long USER_DATA_BYTE_OFFSET;
    public static final long POINTS_BYTE_OFFSET;
    public static final long COUNT_BYTE_OFFSET;
    public static final long MATERIALS_BYTE_OFFSET;
    public static final long MATERIAL_COUNT_BYTE_OFFSET;
    public static final long FILTER_BYTE_OFFSET;
    public static final long IS_LOOP_BYTE_OFFSET;
    public static final long ENABLE_SENSOR_EVENTS_BYTE_OFFSET;
    public static final long INTERNAL_VALUE_BYTE_OFFSET;

    private final MemorySegment segment;

    private final Filter filter;

    static {
        //@formatter:off
        LAYOUT = MemoryLayout.structLayout(
            UNBOUNDED_ADDRESS.withName("userData"),
            UNBOUNDED_ADDRESS.withName("points"),
            JAVA_INT.withName("count"),
            MemoryLayout.paddingLayout(4),
            UNBOUNDED_ADDRESS.withName("materials"),
            JAVA_INT.withName("materialCount"),
            MemoryLayout.paddingLayout(4),
            Filter.LAYOUT.withName("filter"),
            JAVA_BOOLEAN.withName("isLoop"),
            JAVA_BOOLEAN.withName("enableSensorEvents"),
            MemoryLayout.paddingLayout(2),
            JAVA_INT.withName("internalValue")
        ).withName("b2ChainDef").withByteAlignment(8);
        
        B2_DEFAULT_CHAIN_DEF = downcallHandle("b2DefaultChainDef", ChainDef.LAYOUT);
        
        USER_DATA_HANDLE = LAYOUT.varHandle(PathElement.groupElement("userData"));
        POINTS_HANDLE = LAYOUT.varHandle(PathElement.groupElement("points"));
        COUNT_HANDLE = LAYOUT.varHandle(PathElement.groupElement("count"));
        MATERIALS_HANDLE = LAYOUT.varHandle(PathElement.groupElement("materials"));
        MATERIAL_COUNT_HANDLE = LAYOUT.varHandle(PathElement.groupElement("materialCount"));
        IS_LOOP_HANDLE = LAYOUT.varHandle(PathElement.groupElement("isLoop"));
        ENABLE_SENSOR_EVENTS_HANDLE = LAYOUT.varHandle(PathElement.groupElement("enableSensorEvents"));
        INTERNAL_VALUE_HANDLE = LAYOUT.varHandle(PathElement.groupElement("internalValue"));
        
        USER_DATA_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("userData"));
        POINTS_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("points"));
        COUNT_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("count"));
        MATERIALS_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("materials"));
        MATERIAL_COUNT_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("materialCount"));
        FILTER_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("filter"));
        IS_LOOP_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("isLoop"));
        ENABLE_SENSOR_EVENTS_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("enableSensorEvents"));
        INTERNAL_VALUE_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("internalValue"));
        //@formatter:on
    }

    public ChainDef(MemorySegment segment) {
        this.segment = segment;
    
        filter = new Filter(segment.asSlice(FILTER_BYTE_OFFSET, Filter.LAYOUT));
    }

    /**
     * Use this to initialize your chain definition
     */
    public static MemorySegment ndefaultChainDef(
        SegmentAllocator allocator
    ) {
        MethodHandle method = B2_DEFAULT_CHAIN_DEF.get();
        try {
            return (MemorySegment) method.invokeExact(
                allocator
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #ndefaultChainDef}.
     */
    public static @Nullable ChainDef defaultChainDef(
        SegmentAllocator allocator
    ) {
        MemorySegment segment = ndefaultChainDef(allocator);
    
        if (segment.equals(MemorySegment.NULL))
            return null;
    
        return new ChainDef(segment);
    }
    
    public ChainDef userData(MemorySegment userData) {
        USER_DATA_HANDLE.set(segment, 0L, userData);
        return this;
    }
    
    public @Nullable MemorySegment userData() {
        MemorySegment segment = (MemorySegment) USER_DATA_HANDLE.get(this.segment, 0L);
    
        if (segment.equals(MemorySegment.NULL))
            return null;
    
        return segment;
    }
    
    public ChainDef points(Vec2 points) {
        POINTS_HANDLE.set(segment, 0L, points.memorySegment());
        return this;
    }
    
    public @Nullable Vec2 points() {
        MemorySegment segment = (MemorySegment) POINTS_HANDLE.get(this.segment, 0L);
    
        if (segment.equals(MemorySegment.NULL))
            return null;
    
        return new Vec2(segment);
    }
    
    public ChainDef count(int count) {
        COUNT_HANDLE.set(segment, 0L, count);
        return this;
    }
    
    public int count() {
        return (int) COUNT_HANDLE.get(segment, 0L);
    }
    
    public ChainDef materials(SurfaceMaterial materials) {
        MATERIALS_HANDLE.set(segment, 0L, materials.memorySegment());
        return this;
    }
    
    public @Nullable SurfaceMaterial materials() {
        MemorySegment segment = (MemorySegment) MATERIALS_HANDLE.get(this.segment, 0L);
    
        if (segment.equals(MemorySegment.NULL))
            return null;
    
        return new SurfaceMaterial(segment);
    }
    
    public ChainDef materialCount(int materialCount) {
        MATERIAL_COUNT_HANDLE.set(segment, 0L, materialCount);
        return this;
    }
    
    public int materialCount() {
        return (int) MATERIAL_COUNT_HANDLE.get(segment, 0L);
    }
    
    public ChainDef isLoop(boolean isLoop) {
        IS_LOOP_HANDLE.set(segment, 0L, isLoop);
        return this;
    }
    
    public boolean isLoop() {
        return (boolean) IS_LOOP_HANDLE.get(segment, 0L);
    }
    
    public ChainDef enableSensorEvents(boolean enableSensorEvents) {
        ENABLE_SENSOR_EVENTS_HANDLE.set(segment, 0L, enableSensorEvents);
        return this;
    }
    
    public boolean enableSensorEvents() {
        return (boolean) ENABLE_SENSOR_EVENTS_HANDLE.get(segment, 0L);
    }
    
    public ChainDef internalValue(int internalValue) {
        INTERNAL_VALUE_HANDLE.set(segment, 0L, internalValue);
        return this;
    }
    
    public int internalValue() {
        return (int) INTERNAL_VALUE_HANDLE.get(segment, 0L);
    }
    
    public ChainDef filter(Consumer<Filter> consumer) {
        consumer.accept(filter);
        return this;
    }
    
    public ChainDef filter(Filter other) {
        filter.set(other);
        return this;
    }
    
    public Filter filter() {
        return filter;
    }
    
    @Override
    public ChainDef set(ChainDef other) {
        return set(other.segment);
    }
    
    @Override
    public ChainDef set(MemorySegment src) {
        MemorySegment.copy(src, 0L, segment, 0L, LAYOUT.byteSize());
        return this;
    }
    
    @Override
    public MemorySegment memorySegment() {
        return segment;
    }
    
    public NativeStructArray<ChainDef> asArray() {
        return new NativeStructArray<>(this);
    }
    
    public static NativeStructArray<ChainDef> array(Arena arena, int count) {
        return new NativeStructArray<>(
            arena,
            LAYOUT,
            segment -> new ChainDef(segment),
            count
        );
    }
    
    public static NativeStructArray<ChainDef> array(Arena arena, ChainDef... structs) {
        NativeStructArray<ChainDef> array = new NativeStructArray<>(
            arena,
            LAYOUT,
            segment -> new ChainDef(segment),
            structs.length
        );
    
        for (int i = 0; i < structs.length; i++) {
            array.set(i, structs[i]);
        }
    
        return array;
    }
    
    public static NativeStructArray<ChainDef> array(MemorySegment array) {
        return new NativeStructArray<>(
            array,
            LAYOUT,
            segment -> new ChainDef(segment)
        );
    }
    
}