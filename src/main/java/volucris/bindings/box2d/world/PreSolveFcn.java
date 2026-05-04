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
import volucris.bindings.box2d.collision.Manifold;
import volucris.bindings.box2d.shape.ShapeId;

import static java.lang.foreign.ValueLayout.*;
import static volucris.bindings.core.FFMUtils.*;

public abstract class PreSolveFcn {

    private static final HashMap<Long, WeakReference<PreSolveFcn>> CACHE;

    public static final FunctionDescriptor DESCRIPTION;
    public static final MethodHandle HANDLE;

    private final MemorySegment segment;

    static {
        CACHE = new HashMap<>();

        DESCRIPTION = FunctionDescriptor.of(
            JAVA_BOOLEAN, 
            ShapeId.LAYOUT, 
            ShapeId.LAYOUT, 
            UNBOUNDED_ADDRESS, 
            UNBOUNDED_ADDRESS
        );

        try {
            HANDLE = MethodHandles.lookup().findVirtual(PreSolveFcn.class, "invoke", DESCRIPTION.toMethodType());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public PreSolveFcn() {
        this(Arena.ofAuto());
    }

    public PreSolveFcn(Arena arena) {
        this.segment = Linker.nativeLinker().upcallStub(HANDLE.bindTo(this), DESCRIPTION, arena);

        CACHE.put(this.segment.address(), new WeakReference<>(this));
    }

    public boolean invoke(
        MemorySegment shapeIdA, 
        MemorySegment shapeIdB, 
        MemorySegment manifold, 
        MemorySegment context
    ) {
        return (boolean) invoke(
            new ShapeId(shapeIdA), 
            new ShapeId(shapeIdB), 
            new Manifold(manifold), 
            context
        );
    }

    public abstract boolean invoke(
        ShapeId shapeIdA, 
        ShapeId shapeIdB, 
        Manifold manifold, 
        MemorySegment context
    );


    public MemorySegment memorySegment() {
        return segment;
    }

    public static PreSolveFcn get(MemorySegment segment) {
        WeakReference<PreSolveFcn> reference = CACHE.get(segment.address());

        if (reference == null)
            return null;

        return reference.get();
    }

}