/*
 * MACHINE GENERATED FILE, DO NOT EDIT.
 */
package volucris.bindings.box2d.distance;

import java.lang.foreign.Arena;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.StructLayout;
import java.lang.invoke.VarHandle;
import java.util.function.Consumer;
import volucris.bindings.box2d.geometry.ShapeProxy;
import volucris.bindings.core.NativeStructArray;
import volucris.bindings.core.Struct;

import static java.lang.foreign.ValueLayout.*;

/**
 * Input parameters for b2TimeOfImpact
 */
public final class TOIInput
		implements Struct<TOIInput> {

    public static final StructLayout LAYOUT;

    public static final VarHandle MAX_FRACTION;

    public static final long PROXY_A_OFFSET;
    public static final long PROXY_B_OFFSET;
    public static final long SWEEP_A_OFFSET;
    public static final long SWEEP_B_OFFSET;
    public static final long MAX_FRACTION_OFFSET;

    private final MemorySegment segment;

    private final ShapeProxy proxyA;
    private final ShapeProxy proxyB;
    private final Sweep sweepA;
    private final Sweep sweepB;

    static {
        //@formatter:off
        LAYOUT = MemoryLayout.structLayout(
            ShapeProxy.LAYOUT.withName("proxyA"),
            ShapeProxy.LAYOUT.withName("proxyB"),
            Sweep.LAYOUT.withName("sweepA"),
            Sweep.LAYOUT.withName("sweepB"),
            JAVA_FLOAT.withName("maxFraction")
        ).withName("b2TOIInput").withByteAlignment(4);
        
        MAX_FRACTION = LAYOUT.varHandle(PathElement.groupElement("maxFraction"));
        
        PROXY_A_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("proxyA"));
        PROXY_B_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("proxyB"));
        SWEEP_A_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("sweepA"));
        SWEEP_B_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("sweepB"));
        MAX_FRACTION_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("maxFraction"));
        //@formatter:on
    }

    public TOIInput() {
        this(Arena.ofAuto());
    }
    
    public TOIInput(Arena arena) {
        this(arena.allocate(LAYOUT));
    }
    
    public TOIInput(MemorySegment segment) {
        this.segment = segment;
    
        proxyA = new ShapeProxy(segment.asSlice(PROXY_A_OFFSET, ShapeProxy.LAYOUT));
        proxyB = new ShapeProxy(segment.asSlice(PROXY_B_OFFSET, ShapeProxy.LAYOUT));
        sweepA = new Sweep(segment.asSlice(SWEEP_A_OFFSET, Sweep.LAYOUT));
        sweepB = new Sweep(segment.asSlice(SWEEP_B_OFFSET, Sweep.LAYOUT));
    }

    public TOIInput maxFraction(float maxFraction) {
        MAX_FRACTION.set(segment, 0L, maxFraction);
        return this;
    }
    
    public float maxFraction() {
        return (float) MAX_FRACTION.get(segment, 0L);
    }
    
    public TOIInput proxyA(Consumer<ShapeProxy> consumer) {
        consumer.accept(proxyA);
        return this;
    }
    
    public TOIInput proxyA(ShapeProxy other) {
        proxyA.set(other);
        return this;
    }
    
    public ShapeProxy proxyA() {
        return proxyA;
    }
    
    public TOIInput proxyB(Consumer<ShapeProxy> consumer) {
        consumer.accept(proxyB);
        return this;
    }
    
    public TOIInput proxyB(ShapeProxy other) {
        proxyB.set(other);
        return this;
    }
    
    public ShapeProxy proxyB() {
        return proxyB;
    }
    
    public TOIInput sweepA(Consumer<Sweep> consumer) {
        consumer.accept(sweepA);
        return this;
    }
    
    public TOIInput sweepA(Sweep other) {
        sweepA.set(other);
        return this;
    }
    
    public Sweep sweepA() {
        return sweepA;
    }
    
    public TOIInput sweepB(Consumer<Sweep> consumer) {
        consumer.accept(sweepB);
        return this;
    }
    
    public TOIInput sweepB(Sweep other) {
        sweepB.set(other);
        return this;
    }
    
    public Sweep sweepB() {
        return sweepB;
    }
    
    @Override
    public TOIInput set(TOIInput other) {
        return set(other.segment);
    }
    
    @Override
    public TOIInput set(MemorySegment src) {
        MemorySegment.copy(src, 0L, segment, 0L, LAYOUT.byteSize());
        return this;
    }
    
    @Override
    public MemorySegment memorySegment() {
        return segment;
    }
    
    public NativeStructArray<TOIInput> asArray() {
        return new NativeStructArray<>(this);
    }
    
    public static NativeStructArray<TOIInput> array(Arena arena, int count) {
        return new NativeStructArray<>(
            arena,
            LAYOUT,
            segment -> new TOIInput(segment),
            count
        );
    }
    
    public static NativeStructArray<TOIInput> array(Arena arena, TOIInput... structs) {
        NativeStructArray<TOIInput> array = new NativeStructArray<>(
            arena,
            LAYOUT,
            segment -> new TOIInput(segment),
            structs.length
        );
    
        for (int i = 0; i < structs.length; i++) {
            array.set(i, structs[i]);
        }
    
        return array;
    }
    
    public static NativeStructArray<TOIInput> array(MemorySegment array) {
        return new NativeStructArray<>(
            array,
            LAYOUT,
            segment -> new TOIInput(segment)
        );
    }
    
}