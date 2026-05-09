/*
 * MACHINE GENERATED FILE, DO NOT EDIT.
 */
package volucris.bindings.box2d.characterMover;

import java.lang.foreign.Arena;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.StructLayout;
import java.lang.invoke.VarHandle;
import java.util.function.Consumer;
import volucris.bindings.box2d.math.Vec2;
import volucris.bindings.core.NativeStructArray;
import volucris.bindings.core.Struct;

import static java.lang.foreign.ValueLayout.*;

/**
 * Result returned by b2SolvePlanes
 */
public final class PlaneSolverResult
		implements Struct<PlaneSolverResult> {

    public static final StructLayout LAYOUT;

    public static final VarHandle ITERATION_COUNT_HANDLE;

    public static final long TRANSLATION_BYTE_OFFSET;
    public static final long ITERATION_COUNT_BYTE_OFFSET;

    private final MemorySegment segment;

    private final Vec2 translation;

    static {
        //@formatter:off
        LAYOUT = MemoryLayout.structLayout(
            Vec2.LAYOUT.withName("translation"),
            JAVA_INT.withName("iterationCount")
        ).withName("b2PlaneSolverResult").withByteAlignment(4);
        
        ITERATION_COUNT_HANDLE = LAYOUT.varHandle(PathElement.groupElement("iterationCount"));
        
        TRANSLATION_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("translation"));
        ITERATION_COUNT_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("iterationCount"));
        //@formatter:on
    }

    public PlaneSolverResult() {
        this(Arena.ofAuto());
    }
    
    public PlaneSolverResult(Arena arena) {
        this(arena.allocate(LAYOUT));
    }
    
    public PlaneSolverResult(MemorySegment segment) {
        this.segment = segment;
    
        translation = new Vec2(segment.asSlice(TRANSLATION_BYTE_OFFSET, Vec2.LAYOUT));
    }

    public PlaneSolverResult iterationCount(int iterationCount) {
        ITERATION_COUNT_HANDLE.set(segment, 0L, iterationCount);
        return this;
    }
    
    public int iterationCount() {
        return (int) ITERATION_COUNT_HANDLE.get(segment, 0L);
    }
    
    public PlaneSolverResult translation(Consumer<Vec2> consumer) {
        consumer.accept(translation);
        return this;
    }
    
    public PlaneSolverResult translation(Vec2 other) {
        translation.set(other);
        return this;
    }
    
    public Vec2 translation() {
        return translation;
    }
    
    @Override
    public PlaneSolverResult set(PlaneSolverResult other) {
        return set(other.segment);
    }
    
    @Override
    public PlaneSolverResult set(MemorySegment src) {
        MemorySegment.copy(src, 0L, segment, 0L, LAYOUT.byteSize());
        return this;
    }
    
    @Override
    public MemorySegment memorySegment() {
        return segment;
    }
    
    public NativeStructArray<PlaneSolverResult> asArray() {
        return new NativeStructArray<>(this);
    }
    
    public static NativeStructArray<PlaneSolverResult> array(Arena arena, int count) {
        return new NativeStructArray<>(
            arena,
            LAYOUT,
            segment -> new PlaneSolverResult(segment),
            count
        );
    }
    
    public static NativeStructArray<PlaneSolverResult> array(Arena arena, PlaneSolverResult... structs) {
        NativeStructArray<PlaneSolverResult> array = new NativeStructArray<>(
            arena,
            LAYOUT,
            segment -> new PlaneSolverResult(segment),
            structs.length
        );
    
        for (int i = 0; i < structs.length; i++) {
            array.set(i, structs[i]);
        }
    
        return array;
    }
    
    public static NativeStructArray<PlaneSolverResult> array(MemorySegment array) {
        return new NativeStructArray<>(
            array,
            LAYOUT,
            segment -> new PlaneSolverResult(segment)
        );
    }
    
}