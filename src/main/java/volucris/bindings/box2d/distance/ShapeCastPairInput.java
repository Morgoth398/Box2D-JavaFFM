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
import volucris.bindings.box2d.math.Vec2;
import volucris.bindings.core.NativeStructArray;
import volucris.bindings.core.Struct;

import static java.lang.foreign.ValueLayout.*;

/**
 * Input parameters for b2ShapeCast
 */
public final class ShapeCastPairInput
		implements Struct<ShapeCastPairInput> {

    public static final StructLayout LAYOUT;

    public static final VarHandle MAX_FRACTION_HANDLE;
    public static final VarHandle CAN_ENCROACH_HANDLE;

    public static final long PROXY_A_BYTE_OFFSET;
    public static final long PROXY_B_BYTE_OFFSET;
    public static final long TRANSFORM_A_BYTE_OFFSET;
    public static final long TRANSFORM_B_BYTE_OFFSET;
    public static final long TRANSLATION_B_BYTE_OFFSET;
    public static final long MAX_FRACTION_BYTE_OFFSET;
    public static final long CAN_ENCROACH_BYTE_OFFSET;

    private final MemorySegment segment;

    private final ShapeProxy proxyA;
    private final ShapeProxy proxyB;
    private final Transform transformA;
    private final Transform transformB;
    private final Vec2 translationB;

    static {
        //@formatter:off
        LAYOUT = MemoryLayout.structLayout(
            ShapeProxy.LAYOUT.withName("proxyA"),
            ShapeProxy.LAYOUT.withName("proxyB"),
            Transform.LAYOUT.withName("transformA"),
            Transform.LAYOUT.withName("transformB"),
            Vec2.LAYOUT.withName("translationB"),
            JAVA_FLOAT.withName("maxFraction"),
            JAVA_BOOLEAN.withName("canEncroach"),
            MemoryLayout.paddingLayout(3)
        ).withName("b2ShapeCastPairInput").withByteAlignment(4);
        
        MAX_FRACTION_HANDLE = LAYOUT.varHandle(PathElement.groupElement("maxFraction"));
        CAN_ENCROACH_HANDLE = LAYOUT.varHandle(PathElement.groupElement("canEncroach"));
        
        PROXY_A_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("proxyA"));
        PROXY_B_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("proxyB"));
        TRANSFORM_A_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("transformA"));
        TRANSFORM_B_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("transformB"));
        TRANSLATION_B_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("translationB"));
        MAX_FRACTION_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("maxFraction"));
        CAN_ENCROACH_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("canEncroach"));
        //@formatter:on
    }

    public ShapeCastPairInput() {
        this(Arena.ofAuto());
    }
    
    public ShapeCastPairInput(Arena arena) {
        this(arena.allocate(LAYOUT));
    }
    
    public ShapeCastPairInput(MemorySegment segment) {
        this.segment = segment;
    
        proxyA = new ShapeProxy(segment.asSlice(PROXY_A_BYTE_OFFSET, ShapeProxy.LAYOUT));
        proxyB = new ShapeProxy(segment.asSlice(PROXY_B_BYTE_OFFSET, ShapeProxy.LAYOUT));
        transformA = new Transform(segment.asSlice(TRANSFORM_A_BYTE_OFFSET, Transform.LAYOUT));
        transformB = new Transform(segment.asSlice(TRANSFORM_B_BYTE_OFFSET, Transform.LAYOUT));
        translationB = new Vec2(segment.asSlice(TRANSLATION_B_BYTE_OFFSET, Vec2.LAYOUT));
    }

    public ShapeCastPairInput maxFraction(float maxFraction) {
        MAX_FRACTION_HANDLE.set(segment, 0L, maxFraction);
        return this;
    }
    
    public float maxFraction() {
        return (float) MAX_FRACTION_HANDLE.get(segment, 0L);
    }
    
    public ShapeCastPairInput canEncroach(boolean canEncroach) {
        CAN_ENCROACH_HANDLE.set(segment, 0L, canEncroach);
        return this;
    }
    
    public boolean canEncroach() {
        return (boolean) CAN_ENCROACH_HANDLE.get(segment, 0L);
    }
    
    public ShapeCastPairInput proxyA(Consumer<ShapeProxy> consumer) {
        consumer.accept(proxyA);
        return this;
    }
    
    public ShapeCastPairInput proxyA(ShapeProxy other) {
        proxyA.set(other);
        return this;
    }
    
    public ShapeProxy proxyA() {
        return proxyA;
    }
    
    public ShapeCastPairInput proxyB(Consumer<ShapeProxy> consumer) {
        consumer.accept(proxyB);
        return this;
    }
    
    public ShapeCastPairInput proxyB(ShapeProxy other) {
        proxyB.set(other);
        return this;
    }
    
    public ShapeProxy proxyB() {
        return proxyB;
    }
    
    public ShapeCastPairInput transformA(Consumer<Transform> consumer) {
        consumer.accept(transformA);
        return this;
    }
    
    public ShapeCastPairInput transformA(Transform other) {
        transformA.set(other);
        return this;
    }
    
    public Transform transformA() {
        return transformA;
    }
    
    public ShapeCastPairInput transformB(Consumer<Transform> consumer) {
        consumer.accept(transformB);
        return this;
    }
    
    public ShapeCastPairInput transformB(Transform other) {
        transformB.set(other);
        return this;
    }
    
    public Transform transformB() {
        return transformB;
    }
    
    public ShapeCastPairInput translationB(Consumer<Vec2> consumer) {
        consumer.accept(translationB);
        return this;
    }
    
    public ShapeCastPairInput translationB(Vec2 other) {
        translationB.set(other);
        return this;
    }
    
    public Vec2 translationB() {
        return translationB;
    }
    
    @Override
    public ShapeCastPairInput set(ShapeCastPairInput other) {
        return set(other.segment);
    }
    
    @Override
    public ShapeCastPairInput set(MemorySegment src) {
        MemorySegment.copy(src, 0L, segment, 0L, LAYOUT.byteSize());
        return this;
    }
    
    @Override
    public MemorySegment memorySegment() {
        return segment;
    }
    
    public NativeStructArray<ShapeCastPairInput> asArray() {
        return new NativeStructArray<>(this);
    }
    
    public static NativeStructArray<ShapeCastPairInput> array(Arena arena, int count) {
        return new NativeStructArray<>(
            arena,
            LAYOUT,
            segment -> new ShapeCastPairInput(segment),
            count
        );
    }
    
    public static NativeStructArray<ShapeCastPairInput> array(Arena arena, ShapeCastPairInput... structs) {
        NativeStructArray<ShapeCastPairInput> array = new NativeStructArray<>(
            arena,
            LAYOUT,
            segment -> new ShapeCastPairInput(segment),
            structs.length
        );
    
        for (int i = 0; i < structs.length; i++) {
            array.set(i, structs[i]);
        }
    
        return array;
    }
    
    public static NativeStructArray<ShapeCastPairInput> array(MemorySegment array) {
        return new NativeStructArray<>(
            array,
            LAYOUT,
            segment -> new ShapeCastPairInput(segment)
        );
    }
    
}