/*
 * MACHINE GENERATED FILE, DO NOT EDIT.
 */
package volucris.bindings.box2d.events;

import edu.umd.cs.findbugs.annotations.Nullable;
import java.lang.foreign.Arena;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.StructLayout;
import java.lang.invoke.VarHandle;
import volucris.bindings.core.NativeStructArray;
import volucris.bindings.core.Struct;

import static java.lang.foreign.ValueLayout.*;
import static volucris.bindings.core.FFMUtils.*;

/**
 * Sensor events are buffered in the Box2D world and are available as begin/end overlap event arrays after the time step is complete. Note: these may become invalid if bodies and/or shapes are destroyed
 */
public final class SensorEvents
		implements Struct<SensorEvents> {

    public static final StructLayout LAYOUT;

    public static final VarHandle BEGIN_EVENTS_HANDLE;
    public static final VarHandle END_EVENTS_HANDLE;
    public static final VarHandle BEGIN_COUNT_HANDLE;
    public static final VarHandle END_COUNT_HANDLE;

    public static final long BEGIN_EVENTS_BYTE_OFFSET;
    public static final long END_EVENTS_BYTE_OFFSET;
    public static final long BEGIN_COUNT_BYTE_OFFSET;
    public static final long END_COUNT_BYTE_OFFSET;

    private final MemorySegment segment;

    static {
        //@formatter:off
        LAYOUT = MemoryLayout.structLayout(
            UNBOUNDED_ADDRESS.withName("beginEvents"),
            UNBOUNDED_ADDRESS.withName("endEvents"),
            JAVA_INT.withName("beginCount"),
            JAVA_INT.withName("endCount")
        ).withName("b2SensorEvents").withByteAlignment(8);
        
        BEGIN_EVENTS_HANDLE = LAYOUT.varHandle(PathElement.groupElement("beginEvents"));
        END_EVENTS_HANDLE = LAYOUT.varHandle(PathElement.groupElement("endEvents"));
        BEGIN_COUNT_HANDLE = LAYOUT.varHandle(PathElement.groupElement("beginCount"));
        END_COUNT_HANDLE = LAYOUT.varHandle(PathElement.groupElement("endCount"));
        
        BEGIN_EVENTS_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("beginEvents"));
        END_EVENTS_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("endEvents"));
        BEGIN_COUNT_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("beginCount"));
        END_COUNT_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("endCount"));
        //@formatter:on
    }

    public SensorEvents() {
        this(Arena.ofAuto());
    }
    
    public SensorEvents(Arena arena) {
        this(arena.allocate(LAYOUT));
    }
    
    public SensorEvents(MemorySegment segment) {
        this.segment = segment;
    
    }

    public SensorEvents beginEvents(SensorBeginTouchEvent beginEvents) {
        BEGIN_EVENTS_HANDLE.set(segment, 0L, beginEvents.memorySegment());
        return this;
    }
    
    public @Nullable SensorBeginTouchEvent beginEvents() {
        MemorySegment segment = (MemorySegment) BEGIN_EVENTS_HANDLE.get(this.segment, 0L);
    
        if (segment.equals(MemorySegment.NULL))
            return null;
    
        return new SensorBeginTouchEvent(segment);
    }
    
    public SensorEvents endEvents(SensorEndTouchEvent endEvents) {
        END_EVENTS_HANDLE.set(segment, 0L, endEvents.memorySegment());
        return this;
    }
    
    public @Nullable SensorEndTouchEvent endEvents() {
        MemorySegment segment = (MemorySegment) END_EVENTS_HANDLE.get(this.segment, 0L);
    
        if (segment.equals(MemorySegment.NULL))
            return null;
    
        return new SensorEndTouchEvent(segment);
    }
    
    public SensorEvents beginCount(int beginCount) {
        BEGIN_COUNT_HANDLE.set(segment, 0L, beginCount);
        return this;
    }
    
    public int beginCount() {
        return (int) BEGIN_COUNT_HANDLE.get(segment, 0L);
    }
    
    public SensorEvents endCount(int endCount) {
        END_COUNT_HANDLE.set(segment, 0L, endCount);
        return this;
    }
    
    public int endCount() {
        return (int) END_COUNT_HANDLE.get(segment, 0L);
    }
    
    @Override
    public SensorEvents set(SensorEvents other) {
        return set(other.segment);
    }
    
    @Override
    public SensorEvents set(MemorySegment src) {
        MemorySegment.copy(src, 0L, segment, 0L, LAYOUT.byteSize());
        return this;
    }
    
    @Override
    public MemorySegment memorySegment() {
        return segment;
    }
    
    public NativeStructArray<SensorEvents> asArray() {
        return new NativeStructArray<>(this);
    }
    
    public static NativeStructArray<SensorEvents> array(Arena arena, int count) {
        return new NativeStructArray<>(
            arena,
            LAYOUT,
            segment -> new SensorEvents(segment),
            count
        );
    }
    
    public static NativeStructArray<SensorEvents> array(Arena arena, SensorEvents... structs) {
        NativeStructArray<SensorEvents> array = new NativeStructArray<>(
            arena,
            LAYOUT,
            segment -> new SensorEvents(segment),
            structs.length
        );
    
        for (int i = 0; i < structs.length; i++) {
            array.set(i, structs[i]);
        }
    
        return array;
    }
    
    public static NativeStructArray<SensorEvents> array(MemorySegment array) {
        return new NativeStructArray<>(
            array,
            LAYOUT,
            segment -> new SensorEvents(segment)
        );
    }
    
}