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

import static java.lang.foreign.ValueLayout.*;

/// ```
/// Optional restitution mixing callback. This intentionally provides no context objects because
/// this is called from a worker thread.
/// @warning This function should not attempt to modify Box2D state or user application state.
/// @ingroup world
/// ```
public abstract class RestitutionCallbackFcn {

    private static final Map<Long, WeakReference<RestitutionCallbackFcn>> CACHE;

    public static final FunctionDescriptor DESCRIPTION;
    public static final MethodHandle HANDLE;

    private final MemorySegment segment;

    static {
        CACHE = new HashMap<>();

        DESCRIPTION = FunctionDescriptor.of(
            JAVA_FLOAT, 
            JAVA_FLOAT, 
            JAVA_LONG, 
            JAVA_FLOAT, 
            JAVA_LONG
        );

        try {
            HANDLE = MethodHandles.lookup().findVirtual(RestitutionCallbackFcn.class, "invoke", DESCRIPTION.toMethodType());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public RestitutionCallbackFcn() {
        this(Arena.ofAuto());
    }

    public RestitutionCallbackFcn(Arena arena) {
        this.segment = Linker.nativeLinker().upcallStub(HANDLE.bindTo(this), DESCRIPTION, arena);

        CACHE.put(this.segment.address(), new WeakReference<>(this));
    }

    public float invoke(
        float restitutionA,
        long userMaterialIdA,
        float restitutionB,
        long userMaterialIdB
    ) {
        throw new UnsupportedOperationException(
            "Override either the typed or raw callback method in RestitutionCallbackFcn."
        );
    }

    public MemorySegment memorySegment() {
        return segment;
    }

    public static @Nullable RestitutionCallbackFcn get(MemorySegment segment) {
        WeakReference<RestitutionCallbackFcn> reference = CACHE.get(segment.address());

        if (reference == null)
            return null;

        return reference.get();
    }

}