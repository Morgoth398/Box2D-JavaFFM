/*
 * MACHINE GENERATED FILE, DO NOT EDIT.
 */
package volucris.bindings.box2d;

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
 * Version numbering scheme. See https://semver.org/
 */
public final class Version
		implements Struct<Version> {

    private static final LazyConstant<MethodHandle> B2_GET_VERSION;

    public static final StructLayout LAYOUT;

    public static final VarHandle MAJOR;
    public static final VarHandle MINOR;
    public static final VarHandle REVISION;

    public static final long MAJOR_OFFSET;
    public static final long MINOR_OFFSET;
    public static final long REVISION_OFFSET;

    private final MemorySegment segment;

    static {
        //@formatter:off
        LAYOUT = MemoryLayout.structLayout(
            JAVA_INT.withName("major"),
            JAVA_INT.withName("minor"),
            JAVA_INT.withName("revision")
        ).withName("b2Version").withByteAlignment(4);
        
        B2_GET_VERSION = downcallHandle("b2GetVersion", Version.LAYOUT);
        
        MAJOR = LAYOUT.varHandle(PathElement.groupElement("major"));
        MINOR = LAYOUT.varHandle(PathElement.groupElement("minor"));
        REVISION = LAYOUT.varHandle(PathElement.groupElement("revision"));
        
        MAJOR_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("major"));
        MINOR_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("minor"));
        REVISION_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("revision"));
        //@formatter:on
    }

    public Version() {
        this(Arena.ofAuto());
    }
    
    public Version(Arena arena) {
        this(arena.allocate(LAYOUT));
    }
    
    public Version(MemorySegment segment) {
        this.segment = segment;
    
    }

    /**
     * Get the current version of Box2D
     */
    public static MemorySegment ngetVersion(
        SegmentAllocator allocator
    ) {
        MethodHandle method = B2_GET_VERSION.get();
        try {
            return (MemorySegment) method.invokeExact(
                allocator
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #ngetVersion}.
     */
    public static @Nullable Version getVersion(
        SegmentAllocator allocator
    ) {
        MemorySegment segment = ngetVersion(allocator);
    
        if (segment.equals(MemorySegment.NULL))
            return null;
    
        return new Version(segment);
    }
    
    public Version major(int major) {
        MAJOR.set(segment, 0L, major);
        return this;
    }
    
    public int major() {
        return (int) MAJOR.get(segment, 0L);
    }
    
    public Version minor(int minor) {
        MINOR.set(segment, 0L, minor);
        return this;
    }
    
    public int minor() {
        return (int) MINOR.get(segment, 0L);
    }
    
    public Version revision(int revision) {
        REVISION.set(segment, 0L, revision);
        return this;
    }
    
    public int revision() {
        return (int) REVISION.get(segment, 0L);
    }
    
    @Override
    public Version set(Version other) {
        return set(other.segment);
    }
    
    @Override
    public Version set(MemorySegment src) {
        MemorySegment.copy(src, 0L, segment, 0L, LAYOUT.byteSize());
        return this;
    }
    
    @Override
    public MemorySegment memorySegment() {
        return segment;
    }
    
    public NativeStructArray<Version> asArray() {
        return new NativeStructArray<>(this);
    }
    
    public static NativeStructArray<Version> array(Arena arena, int count) {
        return new NativeStructArray<>(
            arena,
            LAYOUT,
            segment -> new Version(segment),
            count
        );
    }
    
    public static NativeStructArray<Version> array(Arena arena, Version... structs) {
        NativeStructArray<Version> array = new NativeStructArray<>(
            arena,
            LAYOUT,
            segment -> new Version(segment),
            structs.length
        );
    
        for (int i = 0; i < structs.length; i++) {
            array.set(i, structs[i]);
        }
    
        return array;
    }
    
    public static NativeStructArray<Version> array(MemorySegment array) {
        return new NativeStructArray<>(
            array,
            LAYOUT,
            segment -> new Version(segment)
        );
    }
    
}