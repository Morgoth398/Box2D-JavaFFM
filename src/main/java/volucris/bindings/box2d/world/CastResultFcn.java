/*
 * MACHINE GENERATED FILE, DO NOT EDIT.
 */
package volucris.bindings.box2d.world;

import edu.umd.cs.findbugs.annotations.Nullable;
import java.lang.foreign.Arena;
import java.lang.foreign.FunctionDescriptor;
import java.lang.foreign.Linker;
import java.lang.foreign.MemorySegment;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import volucris.bindings.box2d.math.Vec2;
import volucris.bindings.box2d.shape.ShapeId;

import static java.lang.foreign.ValueLayout.*;
import static volucris.bindings.core.FFMUtils.*;

/// ```
/// Prototype callback for ray and shape casts.
/// Called for each shape found in the query. You control how the ray cast
/// proceeds by returning a float:
/// return -1: ignore this shape and continue
/// return 0: terminate the ray cast
/// return fraction: clip the ray to this point
/// return 1: don't clip the ray and continue
/// A cast with initial overlap will return a zero fraction and a zero normal.
/// @param shapeId the shape hit by the ray
/// @param point the point of initial intersection
/// @param normal the normal vector at the point of intersection, zero for a shape cast with initial overlap
/// @param fraction the fraction along the ray at the point of intersection, zero for a shape cast with initial overlap
/// @param context the user context
/// @return -1 to filter, 0 to terminate, fraction to clip the ray for closest hit, 1 to continue
/// @see b2World_CastRay
/// @ingroup world
/// ```
public abstract class CastResultFcn {

    private static final Map<Long, WeakReference<CastResultFcn>> CACHE;

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
        return invoke(
            new ShapeId(shapeId),
            new Vec2(point),
            new Vec2(normal),
            fraction,
            context
        );
    }

    public float invoke(
        ShapeId shapeId,
        Vec2 point,
        Vec2 normal,
        float fraction,
        MemorySegment context
    ) {
        throw new UnsupportedOperationException(
            "Override either the typed or raw callback method in CastResultFcn."
        );
    };

    public MemorySegment memorySegment() {
        return segment;
    }

    public static @Nullable CastResultFcn get(MemorySegment segment) {
        WeakReference<CastResultFcn> reference = CACHE.get(segment.address());

        if (reference == null)
            return null;

        return reference.get();
    }

}