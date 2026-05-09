/*
 * MACHINE GENERATED FILE, DO NOT EDIT.
 */
package volucris.bindings.box2d.distance;

import java.lang.foreign.Arena;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.StructLayout;
import java.lang.invoke.VarHandle;
import volucris.bindings.core.NativeStructArray;
import volucris.bindings.core.Struct;

import static java.lang.foreign.ValueLayout.*;

/**
 * Output parameters for b2TimeOfImpact.
 */
public final class TOIOutput
		implements Struct<TOIOutput> {

    public static final StructLayout LAYOUT;

    public static final VarHandle STATE_HANDLE;
    public static final VarHandle FRACTION_HANDLE;

    public static final long STATE_BYTE_OFFSET;
    public static final long FRACTION_BYTE_OFFSET;

    private final MemorySegment segment;

    static {
        //@formatter:off
        LAYOUT = MemoryLayout.structLayout(
            JAVA_INT.withName("state"),
            JAVA_FLOAT.withName("fraction")
        ).withName("b2TOIOutput").withByteAlignment(4);
        
        STATE_HANDLE = LAYOUT.varHandle(PathElement.groupElement("state"));
        FRACTION_HANDLE = LAYOUT.varHandle(PathElement.groupElement("fraction"));
        
        STATE_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("state"));
        FRACTION_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("fraction"));
        //@formatter:on
    }

    public TOIOutput() {
        this(Arena.ofAuto());
    }
    
    public TOIOutput(Arena arena) {
        this(arena.allocate(LAYOUT));
    }
    
    public TOIOutput(MemorySegment segment) {
        this.segment = segment;
    
    }

    public TOIOutput state(int state) {
        STATE_HANDLE.set(segment, 0L, state);
        return this;
    }
    
    public int state() {
        return (int) STATE_HANDLE.get(segment, 0L);
    }
    
    public TOIOutput fraction(float fraction) {
        FRACTION_HANDLE.set(segment, 0L, fraction);
        return this;
    }
    
    public float fraction() {
        return (float) FRACTION_HANDLE.get(segment, 0L);
    }
    
    @Override
    public TOIOutput set(TOIOutput other) {
        return set(other.segment);
    }
    
    @Override
    public TOIOutput set(MemorySegment src) {
        MemorySegment.copy(src, 0L, segment, 0L, LAYOUT.byteSize());
        return this;
    }
    
    @Override
    public MemorySegment memorySegment() {
        return segment;
    }
    
    public NativeStructArray<TOIOutput> asArray() {
        return new NativeStructArray<>(this);
    }
    
    public static NativeStructArray<TOIOutput> array(Arena arena, int count) {
        return new NativeStructArray<>(
            arena,
            LAYOUT,
            segment -> new TOIOutput(segment),
            count
        );
    }
    
    public static NativeStructArray<TOIOutput> array(Arena arena, TOIOutput... structs) {
        NativeStructArray<TOIOutput> array = new NativeStructArray<>(
            arena,
            LAYOUT,
            segment -> new TOIOutput(segment),
            structs.length
        );
    
        for (int i = 0; i < structs.length; i++) {
            array.set(i, structs[i]);
        }
    
        return array;
    }
    
    public static NativeStructArray<TOIOutput> array(MemorySegment array) {
        return new NativeStructArray<>(
            array,
            LAYOUT,
            segment -> new TOIOutput(segment)
        );
    }
    
}