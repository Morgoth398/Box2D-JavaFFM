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
import volucris.bindings.box2d.math.Vec2;

import static java.lang.foreign.ValueLayout.*;
import static volucris.bindings.core.FFMUtils.*;

public abstract class DrawSolidCapsuleFcn {

    private static final HashMap<Long, WeakReference<DrawSolidCapsuleFcn>> CACHE;

    public static final FunctionDescriptor DESCRIPTION;
    public static final MethodHandle HANDLE;

    private final MemorySegment segment;

    static {
        CACHE = new HashMap<>();

        DESCRIPTION = FunctionDescriptor.ofVoid(
            Vec2.LAYOUT, 
            Vec2.LAYOUT, 
            JAVA_FLOAT, 
            JAVA_INT, 
            UNBOUNDED_ADDRESS
        );

        try {
            HANDLE = MethodHandles.lookup().findVirtual(DrawSolidCapsuleFcn.class, "invoke", DESCRIPTION.toMethodType());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public DrawSolidCapsuleFcn() {
        this(Arena.ofAuto());
    }

    public DrawSolidCapsuleFcn(Arena arena) {
        this.segment = Linker.nativeLinker().upcallStub(HANDLE.bindTo(this), DESCRIPTION, arena);

        CACHE.put(this.segment.address(), new WeakReference<>(this));
    }

    public void invoke(
        MemorySegment p1, 
        MemorySegment p2, 
        float radius, 
        int color, 
        MemorySegment context
    ) {
        invoke(
            new Vec2(p1), 
            new Vec2(p2), 
            radius, 
            color, 
            context
        );
    }

    public void invoke(
        Vec2 p1, 
        Vec2 p2, 
        float radius, 
        int color, 
        MemorySegment context
    ) {
        throw new UnsupportedOperationException(
            "Override either the typed or raw callback method in DrawSolidCapsuleFcn."
        );
    };


    public MemorySegment memorySegment() {
        return segment;
    }

    public static DrawSolidCapsuleFcn get(MemorySegment segment) {
        WeakReference<DrawSolidCapsuleFcn> reference = CACHE.get(segment.address());

        if (reference == null)
            return null;

        return reference.get();
    }

}