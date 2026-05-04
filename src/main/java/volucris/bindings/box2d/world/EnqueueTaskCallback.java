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

public abstract class EnqueueTaskCallback {

    private static final HashMap<Long, WeakReference<EnqueueTaskCallback>> CACHE;

    public static final FunctionDescriptor DESCRIPTION;
    public static final MethodHandle HANDLE;

    private final MemorySegment segment;

    static {
        CACHE = new HashMap<>();

        DESCRIPTION = FunctionDescriptor.of(
            UNBOUNDED_ADDRESS, 
            UNBOUNDED_ADDRESS, 
            JAVA_INT, 
            JAVA_INT, 
            UNBOUNDED_ADDRESS, 
            UNBOUNDED_ADDRESS
        );

        try {
            HANDLE = MethodHandles.lookup().findVirtual(EnqueueTaskCallback.class, "invoke", DESCRIPTION.toMethodType());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public EnqueueTaskCallback() {
        this(Arena.ofAuto());
    }

    public EnqueueTaskCallback(Arena arena) {
        this.segment = Linker.nativeLinker().upcallStub(HANDLE.bindTo(this), DESCRIPTION, arena);

        CACHE.put(this.segment.address(), new WeakReference<>(this));
    }

    public MemorySegment invoke(
        MemorySegment task, 
        int itemCount, 
        int minRange, 
        MemorySegment taskContext, 
        MemorySegment userContext
    ) {
        MemorySegment segment = invoke(
            TaskCallback.get(task), 
            itemCount, 
            minRange, 
            taskContext, 
            userContext
        );

        if (segment.equals(MemorySegment.NULL))
            return null;

        return segment;
    }

    public MemorySegment invoke(
        TaskCallback task, 
        int itemCount, 
        int minRange, 
        MemorySegment taskContext, 
        MemorySegment userContext
    ) {
        throw new UnsupportedOperationException(
            "Override either the typed or raw callback method in EnqueueTaskCallback."
        );
    };


    public MemorySegment memorySegment() {
        return segment;
    }

    public static EnqueueTaskCallback get(MemorySegment segment) {
        WeakReference<EnqueueTaskCallback> reference = CACHE.get(segment.address());

        if (reference == null)
            return null;

        return reference.get();
    }

}