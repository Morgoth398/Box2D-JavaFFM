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
import volucris.bindings.box2d.math.Vec2;
import volucris.bindings.box2d.shape.ShapeId;

import static java.lang.foreign.ValueLayout.*;
import static volucris.bindings.core.FFMUtils.*;

/// ```
/// Prototype for a pre-continuous callback. This is called when a time of impact event is computed
/// in continuous collision. This function can be used to skip the event. Unlike the pre-solve
/// callback, this only supplies the point and normal. At this stage of the solver the manifold may
/// not exist or may be stale. Notes:
/// - this function must be thread-safe
/// - this is only called if the shape has enabled pre-solve events
/// - this is called only for awake dynamic bodies
/// - this is not called for sensors Return false if you want to disable the time of impact event.
/// @warning Do not attempt to modify the world inside this callback
/// @ingroup world
/// ```
public abstract class PreContinuousCallbackFcn {

    private static final Map<Long, WeakReference<PreContinuousCallbackFcn>> CACHE;

    public static final FunctionDescriptor DESCRIPTION;
    public static final MethodHandle HANDLE;

    private final MemorySegment segment;

    static {
        CACHE = new HashMap<>();

        DESCRIPTION = FunctionDescriptor.of(
            JAVA_BOOLEAN, 
            ShapeId.LAYOUT, 
            ShapeId.LAYOUT, 
            Vec2.LAYOUT, 
            Vec2.LAYOUT, 
            UNBOUNDED_ADDRESS
        );

        try {
            HANDLE = MethodHandles.lookup().findVirtual(PreContinuousCallbackFcn.class, "invoke", DESCRIPTION.toMethodType());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public PreContinuousCallbackFcn() {
        this(Arena.ofAuto());
    }

    public PreContinuousCallbackFcn(Arena arena) {
        this.segment = Linker.nativeLinker().upcallStub(HANDLE.bindTo(this), DESCRIPTION, arena);

        CACHE.put(this.segment.address(), new WeakReference<>(this));
    }

    public boolean invoke(
        MemorySegment shapeIdA,
        MemorySegment shapeIdB,
        MemorySegment point,
        MemorySegment normal,
        MemorySegment context
    ) {
        return invoke(
            new ShapeId(shapeIdA),
            new ShapeId(shapeIdB),
            new Vec2(point),
            new Vec2(normal),
            context
        );
    }

    public boolean invoke(
        ShapeId shapeIdA,
        ShapeId shapeIdB,
        Vec2 point,
        Vec2 normal,
        MemorySegment context
    ) {
        throw new UnsupportedOperationException(
            "Override either the typed or raw callback method in PreContinuousCallbackFcn."
        );
    };

    public MemorySegment memorySegment() {
        return segment;
    }

    public static @Nullable PreContinuousCallbackFcn get(MemorySegment segment) {
        WeakReference<PreContinuousCallbackFcn> reference = CACHE.get(segment.address());

        if (reference == null)
            return null;

        return reference.get();
    }

}