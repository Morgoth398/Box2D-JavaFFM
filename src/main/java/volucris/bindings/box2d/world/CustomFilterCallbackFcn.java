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
import volucris.bindings.box2d.shape.ShapeId;

import static java.lang.foreign.ValueLayout.*;
import static volucris.bindings.core.FFMUtils.*;

/// ```
/// Prototype for a contact filter callback. This is called when a contact pair is considered for
/// collision. This allows you to perform custom logic to prevent collision between shapes. This is
/// only called if one of the two shapes has custom filtering enabled. Notes:
/// - this function must be thread-safe
/// - this is only called if one of the two shapes has enabled custom filtering
/// - this may be called for awake dynamic bodies and sensors Return false if you want to disable
/// the collision
/// @see b2ShapeDef
/// @warning Do not attempt to modify the world inside this callback
/// @ingroup world
/// ```
public abstract class CustomFilterCallbackFcn {

    private static final Map<Long, WeakReference<CustomFilterCallbackFcn>> CACHE;

    public static final FunctionDescriptor DESCRIPTION;
    public static final MethodHandle HANDLE;

    private final MemorySegment segment;

    static {
        CACHE = new HashMap<>();

        DESCRIPTION = FunctionDescriptor.of(
            JAVA_BOOLEAN, 
            ShapeId.LAYOUT, 
            ShapeId.LAYOUT, 
            UNBOUNDED_ADDRESS
        );

        try {
            HANDLE = MethodHandles.lookup().findVirtual(CustomFilterCallbackFcn.class, "invoke", DESCRIPTION.toMethodType());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public CustomFilterCallbackFcn() {
        this(Arena.ofAuto());
    }

    public CustomFilterCallbackFcn(Arena arena) {
        this.segment = Linker.nativeLinker().upcallStub(HANDLE.bindTo(this), DESCRIPTION, arena);

        CACHE.put(this.segment.address(), new WeakReference<>(this));
    }

    public boolean invoke(
        MemorySegment shapeIdA,
        MemorySegment shapeIdB,
        MemorySegment context
    ) {
        return invoke(
            new ShapeId(shapeIdA),
            new ShapeId(shapeIdB),
            context
        );
    }

    public boolean invoke(
        ShapeId shapeIdA,
        ShapeId shapeIdB,
        MemorySegment context
    ) {
        throw new UnsupportedOperationException(
            "Override either the typed or raw callback method in CustomFilterCallbackFcn."
        );
    };

    public MemorySegment memorySegment() {
        return segment;
    }

    public static @Nullable CustomFilterCallbackFcn get(MemorySegment segment) {
        WeakReference<CustomFilterCallbackFcn> reference = CACHE.get(segment.address());

        if (reference == null)
            return null;

        return reference.get();
    }

}