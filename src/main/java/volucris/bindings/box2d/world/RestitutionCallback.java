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

public abstract class RestitutionCallback {

    private static final HashMap<Long, WeakReference<RestitutionCallback>> CACHE;

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
            HANDLE = MethodHandles.lookup().findVirtual(RestitutionCallback.class, "invoke", DESCRIPTION.toMethodType());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public RestitutionCallback() {
        this(Arena.ofAuto());
    }

    public RestitutionCallback(Arena arena) {
        this.segment = Linker.nativeLinker().upcallStub(HANDLE.bindTo(this), DESCRIPTION, arena);

        CACHE.put(this.segment.address(), new WeakReference<>(this));
    }

    public abstract float invoke(
        float restitutionA, 
        int userMaterialIdA, 
        float restitutionB, 
        int userMaterialIdB
    );

    public MemorySegment memorySegment() {
        return segment;
    }

    public static RestitutionCallback get(MemorySegment segment) {
        WeakReference<RestitutionCallback> reference = CACHE.get(segment.address());

        if (reference == null)
            return null;

        return reference.get();
    }

}