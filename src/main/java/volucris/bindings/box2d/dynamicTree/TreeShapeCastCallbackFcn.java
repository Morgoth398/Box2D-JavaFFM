/*
 * MACHINE GENERATED FILE, DO NOT EDIT.
 */
package volucris.bindings.box2d.dynamicTree;

import java.lang.foreign.Arena;
import java.lang.foreign.FunctionDescriptor;
import java.lang.foreign.Linker;
import java.lang.foreign.MemorySegment;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import volucris.bindings.box2d.geometry.ShapeCastInput;

import static java.lang.foreign.ValueLayout.*;
import static volucris.bindings.core.FFMUtils.*;

public abstract class TreeShapeCastCallbackFcn {

    private static final HashMap<Long, WeakReference<TreeShapeCastCallbackFcn>> CACHE;

    public static final FunctionDescriptor DESCRIPTION;
    public static final MethodHandle HANDLE;

    private final MemorySegment segment;

    static {
        CACHE = new HashMap<>();

        DESCRIPTION = FunctionDescriptor.of(
            JAVA_FLOAT, 
            UNBOUNDED_ADDRESS, 
            JAVA_INT, 
            JAVA_LONG, 
            UNBOUNDED_ADDRESS
        );

        try {
            HANDLE = MethodHandles.lookup().findVirtual(TreeShapeCastCallbackFcn.class, "invoke", DESCRIPTION.toMethodType());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public TreeShapeCastCallbackFcn() {
        this(Arena.ofAuto());
    }

    public TreeShapeCastCallbackFcn(Arena arena) {
        this.segment = Linker.nativeLinker().upcallStub(HANDLE.bindTo(this), DESCRIPTION, arena);

        CACHE.put(this.segment.address(), new WeakReference<>(this));
    }

    public float invoke(
        MemorySegment input, 
        int proxyId, 
        long userData, 
        MemorySegment context
    ) {
        return (float) invoke(
            new ShapeCastInput(input), 
            proxyId, 
            userData, 
            context
        );
    }

    public abstract float invoke(
        ShapeCastInput input, 
        int proxyId, 
        long userData, 
        MemorySegment context
    );


    public MemorySegment memorySegment() {
        return segment;
    }

    public static TreeShapeCastCallbackFcn get(MemorySegment segment) {
        WeakReference<TreeShapeCastCallbackFcn> reference = CACHE.get(segment.address());

        if (reference == null)
            return null;

        return reference.get();
    }

}