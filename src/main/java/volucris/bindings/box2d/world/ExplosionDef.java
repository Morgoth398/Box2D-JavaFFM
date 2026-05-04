/*
 * MACHINE GENERATED FILE, DO NOT EDIT.
 */
package volucris.bindings.box2d.world;

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
 * The explosion definition is used to configure options for explosions. Explosions consider shape geometry when computing the impulse.
 */
public final class ExplosionDef
		implements Struct<ExplosionDef> {

    private static final LazyConstant<MethodHandle> B2_DEFAULT_EXPLOSION_DEF;

    public static final StructLayout LAYOUT;

    public static final VarHandle MASK_BITS;
    public static final VarHandle RADIUS;
    public static final VarHandle FALLOFF;
    public static final VarHandle IMPULSE_PER_LENGTH;

    public static final long MASK_BITS_OFFSET;
    public static final long POSITION_OFFSET;
    public static final long RADIUS_OFFSET;
    public static final long FALLOFF_OFFSET;
    public static final long IMPULSE_PER_LENGTH_OFFSET;

    private final MemorySegment segment;

    private final Vec2 position;

    static {
        //@formatter:off
        LAYOUT = MemoryLayout.structLayout(
            JAVA_LONG.withName("maskBits"),
            Vec2.LAYOUT.withName("position"),
            JAVA_FLOAT.withName("radius"),
            JAVA_FLOAT.withName("falloff"),
            JAVA_FLOAT.withName("impulsePerLength"),
            MemoryLayout.paddingLayout(4)
        ).withName("b2ExplosionDef").withByteAlignment(8);
        
        B2_DEFAULT_EXPLOSION_DEF = downcallHandle("b2DefaultExplosionDef", ExplosionDef.LAYOUT);
        
        MASK_BITS = LAYOUT.varHandle(PathElement.groupElement("maskBits"));
        RADIUS = LAYOUT.varHandle(PathElement.groupElement("radius"));
        FALLOFF = LAYOUT.varHandle(PathElement.groupElement("falloff"));
        IMPULSE_PER_LENGTH = LAYOUT.varHandle(PathElement.groupElement("impulsePerLength"));
        
        MASK_BITS_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("maskBits"));
        POSITION_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("position"));
        RADIUS_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("radius"));
        FALLOFF_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("falloff"));
        IMPULSE_PER_LENGTH_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("impulsePerLength"));
        //@formatter:on
    }

    public ExplosionDef(MemorySegment segment) {
        this.segment = segment;
    
        position = new Vec2(segment.asSlice(POSITION_OFFSET, Vec2.LAYOUT));
    }

    /**
     * Use this to initialize your explosion definition
     */
    public static MemorySegment ndefaultExplosionDef(
        SegmentAllocator allocator
    ) {
        MethodHandle method = B2_DEFAULT_EXPLOSION_DEF.get();
        try {
            return (MemorySegment) method.invokeExact(
                allocator
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #ndefaultExplosionDef}.
     */
    public static @Nullable ExplosionDef defaultExplosionDef(
        SegmentAllocator allocator
    ) {
        MemorySegment segment = ndefaultExplosionDef(allocator);
    
        if (segment.equals(MemorySegment.NULL))
            return null;
    
        return new ExplosionDef(segment);
    }
    
    public ExplosionDef maskBits(long maskBits) {
        MASK_BITS.set(segment, 0L, maskBits);
        return this;
    }
    
    public long maskBits() {
        return (long) MASK_BITS.get(segment, 0L);
    }
    
    public ExplosionDef radius(float radius) {
        RADIUS.set(segment, 0L, radius);
        return this;
    }
    
    public float radius() {
        return (float) RADIUS.get(segment, 0L);
    }
    
    public ExplosionDef falloff(float falloff) {
        FALLOFF.set(segment, 0L, falloff);
        return this;
    }
    
    public float falloff() {
        return (float) FALLOFF.get(segment, 0L);
    }
    
    public ExplosionDef impulsePerLength(float impulsePerLength) {
        IMPULSE_PER_LENGTH.set(segment, 0L, impulsePerLength);
        return this;
    }
    
    public float impulsePerLength() {
        return (float) IMPULSE_PER_LENGTH.get(segment, 0L);
    }
    
    public ExplosionDef position(Consumer<Vec2> consumer) {
        consumer.accept(position);
        return this;
    }
    
    public ExplosionDef position(Vec2 other) {
        position.set(other);
        return this;
    }
    
    public Vec2 position() {
        return position;
    }
    
    @Override
    public ExplosionDef set(ExplosionDef other) {
        return set(other.segment);
    }
    
    @Override
    public ExplosionDef set(MemorySegment src) {
        MemorySegment.copy(src, 0L, segment, 0L, LAYOUT.byteSize());
        return this;
    }
    
    @Override
    public MemorySegment memorySegment() {
        return segment;
    }
    
    public NativeStructArray<ExplosionDef> asArray() {
        return new NativeStructArray<>(this);
    }
    
    public static NativeStructArray<ExplosionDef> array(Arena arena, int count) {
        return new NativeStructArray<>(
            arena,
            LAYOUT,
            segment -> new ExplosionDef(segment),
            count
        );
    }
    
    public static NativeStructArray<ExplosionDef> array(Arena arena, ExplosionDef... structs) {
        NativeStructArray<ExplosionDef> array = new NativeStructArray<>(
            arena,
            LAYOUT,
            segment -> new ExplosionDef(segment),
            structs.length
        );
    
        for (int i = 0; i < structs.length; i++) {
            array.set(i, structs[i]);
        }
    
        return array;
    }
    
    public static NativeStructArray<ExplosionDef> array(MemorySegment array) {
        return new NativeStructArray<>(
            array,
            LAYOUT,
            segment -> new ExplosionDef(segment)
        );
    }
    
}