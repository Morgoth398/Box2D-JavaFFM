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
import volucris.bindings.core.NativeStructArray;
import volucris.bindings.core.Struct;

import static java.lang.foreign.ValueLayout.*;
import static volucris.bindings.core.FFMUtils.*;

/**
 * Surface materials allow chain shapes to have per segment surface properties.
 */
public final class SurfaceMaterial
		implements Struct<SurfaceMaterial> {

    private static final LazyConstant<MethodHandle> B2_DEFAULT_SURFACE_MATERIAL;

    public static final StructLayout LAYOUT;

    public static final VarHandle FRICTION;
    public static final VarHandle RESTITUTION;
    public static final VarHandle ROLLING_RESISTANCE;
    public static final VarHandle TANGENT_SPEED;
    public static final VarHandle USER_MATERIAL_ID;
    public static final VarHandle CUSTOM_COLOR;

    public static final long FRICTION_OFFSET;
    public static final long RESTITUTION_OFFSET;
    public static final long ROLLING_RESISTANCE_OFFSET;
    public static final long TANGENT_SPEED_OFFSET;
    public static final long USER_MATERIAL_ID_OFFSET;
    public static final long CUSTOM_COLOR_OFFSET;

    private final MemorySegment segment;

    static {
        //@formatter:off
        LAYOUT = MemoryLayout.structLayout(
            JAVA_FLOAT.withName("friction"),
            JAVA_FLOAT.withName("restitution"),
            JAVA_FLOAT.withName("rollingResistance"),
            JAVA_FLOAT.withName("tangentSpeed"),
            JAVA_INT.withName("userMaterialId"),
            JAVA_INT.withName("customColor")
        ).withName("b2SurfaceMaterial").withByteAlignment(4);
        
        B2_DEFAULT_SURFACE_MATERIAL = downcallHandle("b2DefaultSurfaceMaterial", SurfaceMaterial.LAYOUT);
        
        FRICTION = LAYOUT.varHandle(PathElement.groupElement("friction"));
        RESTITUTION = LAYOUT.varHandle(PathElement.groupElement("restitution"));
        ROLLING_RESISTANCE = LAYOUT.varHandle(PathElement.groupElement("rollingResistance"));
        TANGENT_SPEED = LAYOUT.varHandle(PathElement.groupElement("tangentSpeed"));
        USER_MATERIAL_ID = LAYOUT.varHandle(PathElement.groupElement("userMaterialId"));
        CUSTOM_COLOR = LAYOUT.varHandle(PathElement.groupElement("customColor"));
        
        FRICTION_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("friction"));
        RESTITUTION_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("restitution"));
        ROLLING_RESISTANCE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("rollingResistance"));
        TANGENT_SPEED_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("tangentSpeed"));
        USER_MATERIAL_ID_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("userMaterialId"));
        CUSTOM_COLOR_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("customColor"));
        //@formatter:on
    }

    public SurfaceMaterial(MemorySegment segment) {
        this.segment = segment;
    
    }

    /**
     * Use this to initialize your surface material
     */
    public static MemorySegment ndefaultSurfaceMaterial(
        SegmentAllocator allocator
    ) {
        MethodHandle method = B2_DEFAULT_SURFACE_MATERIAL.get();
        try {
            return (MemorySegment) method.invokeExact(
                allocator
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Typed method of {@link #ndefaultSurfaceMaterial}.
     */
    public static @Nullable SurfaceMaterial defaultSurfaceMaterial(
        SegmentAllocator allocator
    ) {
        MemorySegment segment = ndefaultSurfaceMaterial(allocator);
    
        if (segment.equals(MemorySegment.NULL))
            return null;
    
        return new SurfaceMaterial(segment);
    }
    
    public SurfaceMaterial friction(float friction) {
        FRICTION.set(segment, 0L, friction);
        return this;
    }
    
    public float friction() {
        return (float) FRICTION.get(segment, 0L);
    }
    
    public SurfaceMaterial restitution(float restitution) {
        RESTITUTION.set(segment, 0L, restitution);
        return this;
    }
    
    public float restitution() {
        return (float) RESTITUTION.get(segment, 0L);
    }
    
    public SurfaceMaterial rollingResistance(float rollingResistance) {
        ROLLING_RESISTANCE.set(segment, 0L, rollingResistance);
        return this;
    }
    
    public float rollingResistance() {
        return (float) ROLLING_RESISTANCE.get(segment, 0L);
    }
    
    public SurfaceMaterial tangentSpeed(float tangentSpeed) {
        TANGENT_SPEED.set(segment, 0L, tangentSpeed);
        return this;
    }
    
    public float tangentSpeed() {
        return (float) TANGENT_SPEED.get(segment, 0L);
    }
    
    public SurfaceMaterial userMaterialId(int userMaterialId) {
        USER_MATERIAL_ID.set(segment, 0L, userMaterialId);
        return this;
    }
    
    public int userMaterialId() {
        return (int) USER_MATERIAL_ID.get(segment, 0L);
    }
    
    public SurfaceMaterial customColor(int customColor) {
        CUSTOM_COLOR.set(segment, 0L, customColor);
        return this;
    }
    
    public int customColor() {
        return (int) CUSTOM_COLOR.get(segment, 0L);
    }
    
    @Override
    public SurfaceMaterial set(SurfaceMaterial other) {
        return set(other.segment);
    }
    
    @Override
    public SurfaceMaterial set(MemorySegment src) {
        MemorySegment.copy(src, 0L, segment, 0L, LAYOUT.byteSize());
        return this;
    }
    
    @Override
    public MemorySegment memorySegment() {
        return segment;
    }
    
    public NativeStructArray<SurfaceMaterial> asArray() {
        return new NativeStructArray<>(this);
    }
    
    public static NativeStructArray<SurfaceMaterial> array(Arena arena, int count) {
        return new NativeStructArray<>(
            arena,
            LAYOUT,
            segment -> new SurfaceMaterial(segment),
            count
        );
    }
    
    public static NativeStructArray<SurfaceMaterial> array(Arena arena, SurfaceMaterial... structs) {
        NativeStructArray<SurfaceMaterial> array = new NativeStructArray<>(
            arena,
            LAYOUT,
            segment -> new SurfaceMaterial(segment),
            structs.length
        );
    
        for (int i = 0; i < structs.length; i++) {
            array.set(i, structs[i]);
        }
    
        return array;
    }
    
    public static NativeStructArray<SurfaceMaterial> array(MemorySegment array) {
        return new NativeStructArray<>(
            array,
            LAYOUT,
            segment -> new SurfaceMaterial(segment)
        );
    }
    
}