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

import static java.lang.foreign.ValueLayout.*;
import static volucris.bindings.core.FFMUtils.*;

public abstract class FrictionCallback {

    private static final HashMap<Long, WeakReference<FrictionCallback>> CACHE;

    public static final FunctionDescriptor DESCRIPTION;
    public static final MethodHandle HANDLE;

    private final MemorySegment segment;

    static {
        CACHE = new HashMap<>();

        DESCRIPTION = FunctionDescriptor.of(
            JAVA_FLOAT, 
            JAVA_FLOAT, 
            JAVA_INT, 
            JAVA_FLOAT, 
            JAVA_INT
        );

        try {
            HANDLE = MethodHandles.lookup().findVirtual(FrictionCallback.class, "invoke", DESCRIPTION.toMethodType());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public FrictionCallback() {
        this(Arena.ofAuto());
    }

    public FrictionCallback(Arena arena) {
        this.segment = Linker.nativeLinker().upcallStub(HANDLE.bindTo(this), DESCRIPTION, arena);

        CACHE.put(this.segment.address(), new WeakReference<>(this));
    }

    public float invoke(
        float frictionA, 
        int userMaterialIdA, 
        float frictionB, 
        int userMaterialIdB
    ) {
        throw new UnsupportedOperationException(
            "Override either the typed or raw callback method in FrictionCallback."
        );
    }

    public MemorySegment memorySegment() {
        return segment;
    }

    public static FrictionCallback get(MemorySegment segment) {
        WeakReference<FrictionCallback> reference = CACHE.get(segment.address());

        if (reference == null)
            return null;

        return reference.get();
    }

}