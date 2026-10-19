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

import static volucris.bindings.core.FFMUtils.*;

/// ```
/// Task interface This is the prototype for a Box2D task. Your task system is expected to run this
/// callback on a worker thread, exactly once per enqueue, passing back the same taskContext pointer
/// supplied to b2EnqueueTaskCallbackFcn.
/// @ingroup world
/// ```
public abstract class TaskCallbackFcn {

    private static final Map<Long, WeakReference<TaskCallbackFcn>> CACHE;

    public static final FunctionDescriptor DESCRIPTION;
    public static final MethodHandle HANDLE;

    private final MemorySegment segment;

    static {
        CACHE = new HashMap<>();

        DESCRIPTION = FunctionDescriptor.ofVoid(
            UNBOUNDED_ADDRESS
        );

        try {
            HANDLE = MethodHandles.lookup().findVirtual(TaskCallbackFcn.class, "invoke", DESCRIPTION.toMethodType());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public TaskCallbackFcn() {
        this(Arena.ofAuto());
    }

    public TaskCallbackFcn(Arena arena) {
        this.segment = Linker.nativeLinker().upcallStub(HANDLE.bindTo(this), DESCRIPTION, arena);

        CACHE.put(this.segment.address(), new WeakReference<>(this));
    }

    public void invoke(
        MemorySegment taskContext
    ) {
        throw new UnsupportedOperationException(
            "Override either the typed or raw callback method in TaskCallbackFcn."
        );
    }

    public MemorySegment memorySegment() {
        return segment;
    }

    public static @Nullable TaskCallbackFcn get(MemorySegment segment) {
        WeakReference<TaskCallbackFcn> reference = CACHE.get(segment.address());

        if (reference == null)
            return null;

        return reference.get();
    }

}