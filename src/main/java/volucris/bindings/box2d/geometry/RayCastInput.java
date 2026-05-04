/*
 * MACHINE GENERATED FILE, DO NOT EDIT.
 */
package volucris.bindings.box2d.geometry;

import java.lang.foreign.Arena;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemorySegment;
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
 * Low level ray cast input data
 */
public final class RayCastInput
		implements Struct<RayCastInput> {

    private static final LazyConstant<MethodHandle> B2_IS_VALID_RAY;

    public static final StructLayout LAYOUT;

    public static final VarHandle MAX_FRACTION;

    public static final long ORIGIN_OFFSET;
    public static final long TRANSLATION_OFFSET;
    public static final long MAX_FRACTION_OFFSET;

    private final MemorySegment segment;

    private final Vec2 origin;
    private final Vec2 translation;

    static {
        //@formatter:off
        LAYOUT = MemoryLayout.structLayout(
            Vec2.LAYOUT.withName("origin"),
            Vec2.LAYOUT.withName("translation"),
            JAVA_FLOAT.withName("maxFraction")
        ).withName("b2RayCastInput").withByteAlignment(4);
        
        B2_IS_VALID_RAY = downcallHandle("b2IsValidRay", JAVA_BOOLEAN, UNBOUNDED_ADDRESS);
        
        MAX_FRACTION = LAYOUT.varHandle(PathElement.groupElement("maxFraction"));
        
        ORIGIN_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("origin"));
        TRANSLATION_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("translation"));
        MAX_FRACTION_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("maxFraction"));
        //@formatter:on
    }

    public RayCastInput() {
        this(Arena.ofAuto());
    }
    
    public RayCastInput(Arena arena) {
        this(arena.allocate(LAYOUT));
    }
    
    public RayCastInput(MemorySegment segment) {
        this.segment = segment;
    
        origin = new Vec2(segment.asSlice(ORIGIN_OFFSET, Vec2.LAYOUT));
        translation = new Vec2(segment.asSlice(TRANSLATION_OFFSET, Vec2.LAYOUT));
    }

    /**
     * Validate ray cast input data (NaN, etc)
     */
    public static boolean isValidRay(
        MemorySegment input
    ) {
        MethodHandle method = B2_IS_VALID_RAY.get();
        try {
            return (boolean) method.invokeExact(
                input
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #isValidRay}.
     */
    public final boolean isValidRay(
    ) {
        return (boolean) isValidRay(
            this.segment
        );
    }
    
    public RayCastInput maxFraction(float maxFraction) {
        MAX_FRACTION.set(segment, 0L, maxFraction);
        return this;
    }
    
    public float maxFraction() {
        return (float) MAX_FRACTION.get(segment, 0L);
    }
    
    public RayCastInput origin(Consumer<Vec2> consumer) {
        consumer.accept(origin);
        return this;
    }
    
    public RayCastInput origin(Vec2 other) {
        origin.set(other);
        return this;
    }
    
    public Vec2 origin() {
        return origin;
    }
    
    public RayCastInput translation(Consumer<Vec2> consumer) {
        consumer.accept(translation);
        return this;
    }
    
    public RayCastInput translation(Vec2 other) {
        translation.set(other);
        return this;
    }
    
    public Vec2 translation() {
        return translation;
    }
    
    @Override
    public RayCastInput set(RayCastInput other) {
        return set(other.segment);
    }
    
    @Override
    public RayCastInput set(MemorySegment src) {
        MemorySegment.copy(src, 0L, segment, 0L, LAYOUT.byteSize());
        return this;
    }
    
    @Override
    public MemorySegment memorySegment() {
        return segment;
    }
    
    public NativeStructArray<RayCastInput> asArray() {
        return new NativeStructArray<>(this);
    }
    
    public static NativeStructArray<RayCastInput> array(Arena arena, int count) {
        return new NativeStructArray<>(
            arena,
            LAYOUT,
            segment -> new RayCastInput(segment),
            count
        );
    }
    
    public static NativeStructArray<RayCastInput> array(Arena arena, RayCastInput... structs) {
        NativeStructArray<RayCastInput> array = new NativeStructArray<>(
            arena,
            LAYOUT,
            segment -> new RayCastInput(segment),
            structs.length
        );
    
        for (int i = 0; i < structs.length; i++) {
            array.set(i, structs[i]);
        }
    
        return array;
    }
    
    public static NativeStructArray<RayCastInput> array(MemorySegment array) {
        return new NativeStructArray<>(
            array,
            LAYOUT,
            segment -> new RayCastInput(segment)
        );
    }
    
}