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
import volucris.bindings.box2d.math.Transform;
import volucris.bindings.box2d.math.Vec2;

import static java.lang.foreign.ValueLayout.*;
import static volucris.bindings.core.FFMUtils.*;

public abstract class DrawSolidPolygonFcn {

    private static final HashMap<Long, WeakReference<DrawSolidPolygonFcn>> CACHE;

    public static final FunctionDescriptor DESCRIPTION;
    public static final MethodHandle HANDLE;

    private final MemorySegment segment;

    static {
        CACHE = new HashMap<>();

        DESCRIPTION = FunctionDescriptor.ofVoid(
            Transform.LAYOUT, 
            UNBOUNDED_ADDRESS, 
            JAVA_INT, 
            JAVA_FLOAT, 
            JAVA_INT, 
            UNBOUNDED_ADDRESS
        );

        try {
            HANDLE = MethodHandles.lookup().findVirtual(DrawSolidPolygonFcn.class, "invoke", DESCRIPTION.toMethodType());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public DrawSolidPolygonFcn() {
        this(Arena.ofAuto());
    }

    public DrawSolidPolygonFcn(Arena arena) {
        this.segment = Linker.nativeLinker().upcallStub(HANDLE.bindTo(this), DESCRIPTION, arena);

        CACHE.put(this.segment.address(), new WeakReference<>(this));
    }

    public void invoke(
        MemorySegment transform, 
        MemorySegment vertices, 
        int vertexCount, 
        float radius, 
        int color, 
        MemorySegment context
    ) {
        invoke(
            new Transform(transform), 
            new Vec2(vertices), 
            vertexCount, 
            radius, 
            color, 
            context
        );
    }

    public void invoke(
        Transform transform, 
        Vec2 vertices, 
        int vertexCount, 
        float radius, 
        int color, 
        MemorySegment context
    ) {
        throw new UnsupportedOperationException(
            "Override either the typed or raw callback method in DrawSolidPolygonFcn."
        );
    };


    public MemorySegment memorySegment() {
        return segment;
    }

    public static DrawSolidPolygonFcn get(MemorySegment segment) {
        WeakReference<DrawSolidPolygonFcn> reference = CACHE.get(segment.address());

        if (reference == null)
            return null;

        return reference.get();
    }

}