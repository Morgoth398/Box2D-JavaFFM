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
import volucris.bindings.box2d.math.Transform;
import volucris.bindings.core.NativeStructArray;
import volucris.bindings.core.Struct;

import static java.lang.foreign.ValueLayout.*;

/**
 * Input for b2ShapeDistance
 */
public final class DistanceInput
		implements Struct<DistanceInput> {

    public static final StructLayout LAYOUT;

    public static final VarHandle USE_RADII_HANDLE;

    public static final long PROXY_A_BYTE_OFFSET;
    public static final long PROXY_B_BYTE_OFFSET;
    public static final long TRANSFORM_A_BYTE_OFFSET;
    public static final long TRANSFORM_B_BYTE_OFFSET;
    public static final long USE_RADII_BYTE_OFFSET;

    private final MemorySegment segment;

    private final ShapeProxy proxyA;
    private final ShapeProxy proxyB;
    private final Transform transformA;
    private final Transform transformB;

    static {
        //@formatter:off
        LAYOUT = MemoryLayout.structLayout(
            ShapeProxy.LAYOUT.withName("proxyA"),
            ShapeProxy.LAYOUT.withName("proxyB"),
            Transform.LAYOUT.withName("transformA"),
            Transform.LAYOUT.withName("transformB"),
            JAVA_BOOLEAN.withName("useRadii"),
            MemoryLayout.paddingLayout(3)
        ).withName("b2DistanceInput").withByteAlignment(4);
        
        USE_RADII_HANDLE = LAYOUT.varHandle(PathElement.groupElement("useRadii"));
        
        PROXY_A_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("proxyA"));
        PROXY_B_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("proxyB"));
        TRANSFORM_A_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("transformA"));
        TRANSFORM_B_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("transformB"));
        USE_RADII_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("useRadii"));
        //@formatter:on
    }

    public DistanceInput() {
        this(Arena.ofAuto());
    }
    
    public DistanceInput(Arena arena) {
        this(arena.allocate(LAYOUT));
    }
    
    public DistanceInput(MemorySegment segment) {
        this.segment = segment;
    
        proxyA = new ShapeProxy(segment.asSlice(PROXY_A_BYTE_OFFSET, ShapeProxy.LAYOUT));
        proxyB = new ShapeProxy(segment.asSlice(PROXY_B_BYTE_OFFSET, ShapeProxy.LAYOUT));
        transformA = new Transform(segment.asSlice(TRANSFORM_A_BYTE_OFFSET, Transform.LAYOUT));
        transformB = new Transform(segment.asSlice(TRANSFORM_B_BYTE_OFFSET, Transform.LAYOUT));
    }

    public DistanceInput useRadii(boolean useRadii) {
        USE_RADII_HANDLE.set(segment, 0L, useRadii);
        return this;
    }
    
    public boolean useRadii() {
        return (boolean) USE_RADII_HANDLE.get(segment, 0L);
    }
    
    public DistanceInput proxyA(Consumer<ShapeProxy> consumer) {
        consumer.accept(proxyA);
        return this;
    }
    
    public DistanceInput proxyA(ShapeProxy other) {
        proxyA.set(other);
        return this;
    }
    
    public ShapeProxy proxyA() {
        return proxyA;
    }
    
    public DistanceInput proxyB(Consumer<ShapeProxy> consumer) {
        consumer.accept(proxyB);
        return this;
    }
    
    public DistanceInput proxyB(ShapeProxy other) {
        proxyB.set(other);
        return this;
    }
    
    public ShapeProxy proxyB() {
        return proxyB;
    }
    
    public DistanceInput transformA(Consumer<Transform> consumer) {
        consumer.accept(transformA);
        return this;
    }
    
    public DistanceInput transformA(Transform other) {
        transformA.set(other);
        return this;
    }
    
    public Transform transformA() {
        return transformA;
    }
    
    public DistanceInput transformB(Consumer<Transform> consumer) {
        consumer.accept(transformB);
        return this;
    }
    
    public DistanceInput transformB(Transform other) {
        transformB.set(other);
        return this;
    }
    
    public Transform transformB() {
        return transformB;
    }
    
    @Override
    public DistanceInput set(DistanceInput other) {
        return set(other.segment);
    }
    
    @Override
    public DistanceInput set(MemorySegment src) {
        MemorySegment.copy(src, 0L, segment, 0L, LAYOUT.byteSize());
        return this;
    }
    
    @Override
    public MemorySegment memorySegment() {
        return segment;
    }
    
    public NativeStructArray<DistanceInput> asArray() {
        return new NativeStructArray<>(this);
    }
    
    public static NativeStructArray<DistanceInput> array(Arena arena, int count) {
        return new NativeStructArray<>(
            arena,
            LAYOUT,
            segment -> new DistanceInput(segment),
            count
        );
    }
    
    public static NativeStructArray<DistanceInput> array(Arena arena, DistanceInput... structs) {
        NativeStructArray<DistanceInput> array = new NativeStructArray<>(
            arena,
            LAYOUT,
            segment -> new DistanceInput(segment),
            structs.length
        );
    
        for (int i = 0; i < structs.length; i++) {
            array.set(i, structs[i]);
        }
    
        return array;
    }
    
    public static NativeStructArray<DistanceInput> array(MemorySegment array) {
        return new NativeStructArray<>(
            array,
            LAYOUT,
            segment -> new DistanceInput(segment)
        );
    }
    
}