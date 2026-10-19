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
import java.util.Map;
import org.jspecify.annotations.Nullable;
import volucris.bindings.box2d.collision.Manifold;
import volucris.bindings.box2d.shape.ShapeId;

import static volucris.bindings.core.FFMUtils.*;

/// ```
/// Prototype for a pre-solve callback. This is called after a contact manifold is updated. This
/// allows you to inspect a manifold before it goes to the solver. If you are careful, you can
/// modify the manifold (e.g. modify the normal). You can set the manifold point count to zero to
/// disable collision. Notes:
/// - this function must be thread-safe
/// - this is only called if the shape has enabled pre-solve events
/// - this is called only for awake dynamic bodies
/// - this is not called for sensors
/// - the supplied manifold impulses are not reliable
/// @warning Do not attempt to modify the world inside this callback
/// @ingroup world
/// ```
public abstract class PreSolveCallbackFcn {

    private static final Map<Long, WeakReference<PreSolveCallbackFcn>> CACHE;

    public static final FunctionDescriptor DESCRIPTION;
    public static final MethodHandle HANDLE;

    private final MemorySegment segment;

    static {
        CACHE = new HashMap<>();

        DESCRIPTION = FunctionDescriptor.ofVoid(
            ShapeId.LAYOUT, 
            ShapeId.LAYOUT, 
            UNBOUNDED_ADDRESS, 
            UNBOUNDED_ADDRESS
        );

        try {
            HANDLE = MethodHandles.lookup().findVirtual(PreSolveCallbackFcn.class, "invoke", DESCRIPTION.toMethodType());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public PreSolveCallbackFcn() {
        this(Arena.ofAuto());
    }

    public PreSolveCallbackFcn(Arena arena) {
        this.segment = Linker.nativeLinker().upcallStub(HANDLE.bindTo(this), DESCRIPTION, arena);

        CACHE.put(this.segment.address(), new WeakReference<>(this));
    }

    public void invoke(
        MemorySegment shapeIdA,
        MemorySegment shapeIdB,
        MemorySegment manifold,
        MemorySegment context
    ) {
        invoke(
            new ShapeId(shapeIdA),
            new ShapeId(shapeIdB),
            new Manifold(manifold),
            context
        );
    }

    public void invoke(
        ShapeId shapeIdA,
        ShapeId shapeIdB,
        Manifold manifold,
        MemorySegment context
    ) {
        throw new UnsupportedOperationException(
            "Override either the typed or raw callback method in PreSolveCallbackFcn."
        );
    };

    public MemorySegment memorySegment() {
        return segment;
    }

    public static @Nullable PreSolveCallbackFcn get(MemorySegment segment) {
        WeakReference<PreSolveCallbackFcn> reference = CACHE.get(segment.address());

        if (reference == null)
            return null;

        return reference.get();
    }

}