/*
 * MACHINE GENERATED FILE, DO NOT EDIT.
 */
package volucris.bindings.box2d.world;

import java.lang.foreign.Arena;
import java.lang.foreign.FunctionDescriptor;
import java.lang.foreign.Linker;
import java.lang.foreign.MemorySegment;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import volucris.bindings.box2d.math.Vec2;
import volucris.bindings.box2d.shape.ShapeId;

import static java.lang.foreign.ValueLayout.*;
import static volucris.bindings.core.FFMUtils.*;

public abstract class CastResultFcn {

    private static final HashMap<Long, WeakReference<CastResultFcn>> CACHE;

    public static final FunctionDescriptor DESCRIPTION;
    public static final MethodHandle HANDLE;

    private final MemorySegment segment;

    static {
        CACHE = new HashMap<>();

        DESCRIPTION = FunctionDescriptor.of(
            JAVA_FLOAT, 
            ShapeId.LAYOUT, 
            Vec2.LAYOUT, 
            Vec2.LAYOUT, 
            JAVA_FLOAT, 
            UNBOUNDED_ADDRESS
        );

        try {
            HANDLE = MethodHandles.lookup().findVirtual(CastResultFcn.class, "invoke", DESCRIPTION.toMethodType());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public CastResultFcn() {
        this(Arena.ofAuto());
    }

    public CastResultFcn(Arena arena) {
        this.segment = Linker.nativeLinker().upcallStub(HANDLE.bindTo(this), DESCRIPTION, arena);

        CACHE.put(this.segment.address(), new WeakReference<>(this));
    }

    public float invoke(
        MemorySegment shapeId, 
        MemorySegment point, 
        MemorySegment normal, 
        float fraction, 
        MemorySegment context
    ) {
        return (float) invoke(
            new ShapeId(shapeId), 
            new Vec2(point), 
            new Vec2(normal), 
            fraction, 
            context
        );
    }

    public abstract float invoke(
        ShapeId shapeId, 
        Vec2 point, 
        Vec2 normal, 
        float fraction, 
        MemorySegment context
    );


    public MemorySegment memorySegment() {
        return segment;
    }

    public static CastResultFcn get(MemorySegment segment) {
        WeakReference<CastResultFcn> reference = CACHE.get(segment.address());

        if (reference == null)
            return null;

        return reference.get();
    }

}