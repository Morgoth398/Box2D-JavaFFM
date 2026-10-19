/*
 * MACHINE GENERATED FILE, DO NOT EDIT.
 */
package volucris.bindings.box2d.dynamicTree;

import java.lang.foreign.Arena;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.StructLayout;
import java.lang.invoke.VarHandle;
import java.util.function.Consumer;
import volucris.bindings.box2d.math.AABB;
import volucris.bindings.box2d.math.Vec2;
import volucris.bindings.core.NativeStructArray;
import volucris.bindings.core.Struct;

import static java.lang.foreign.ValueLayout.*;

/// ```
/// Input for casting an AABB through a dynamic tree
/// ```
public final class BoxCastInput
		implements Struct<BoxCastInput> {

	public static final StructLayout LAYOUT;

	public static final VarHandle MAX_FRACTION_HANDLE;

	public static final long BOX_BYTE_OFFSET;
	public static final long TRANSLATION_BYTE_OFFSET;
	public static final long MAX_FRACTION_BYTE_OFFSET;

	private final MemorySegment segment;

	private final AABB box;
	private final Vec2 translation;

	static {
		//@formatter:off
		LAYOUT = MemoryLayout.structLayout(
		    AABB.LAYOUT.withName("box"),
		    Vec2.LAYOUT.withName("translation"),
		    JAVA_FLOAT.withName("maxFraction")
		).withName("b2BoxCastInput").withByteAlignment(4);
		
		MAX_FRACTION_HANDLE = LAYOUT.varHandle(PathElement.groupElement("maxFraction"));
		
		BOX_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("box"));
		TRANSLATION_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("translation"));
		MAX_FRACTION_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("maxFraction"));
		//@formatter:on
	}

	public BoxCastInput() {
	    this(Arena.ofAuto());
	}
	
	public BoxCastInput(Arena arena) {
	    this(arena.allocate(LAYOUT));
	}
	
	public BoxCastInput(MemorySegment segment) {
	    this.segment = segment;
	
	    box = new AABB(segment.asSlice(BOX_BYTE_OFFSET, AABB.LAYOUT));
	    translation = new Vec2(segment.asSlice(TRANSLATION_BYTE_OFFSET, Vec2.LAYOUT));
	}

    /// @see #box()
    public BoxCastInput box(Consumer<AABB> consumer) {
    	consumer.accept(box);
    	return this;
    }
    
    /// @see #box()
    public BoxCastInput box(AABB other) {
    	box.set(other);
    	return this;
    }
    
    /// ```
    /// The AABB to cast, in the tree's frame.
    /// ```
    public AABB box() {
    	return box;
    }
    
    /// @see #translation()
    public BoxCastInput translation(Consumer<Vec2> consumer) {
    	consumer.accept(translation);
    	return this;
    }
    
    /// @see #translation()
    public BoxCastInput translation(Vec2 other) {
    	translation.set(other);
    	return this;
    }
    
    /// ```
    /// The sweep translation.
    /// ```
    public Vec2 translation() {
    	return translation;
    }
    
    /// @see #maxFraction()
    public BoxCastInput maxFraction(float maxFraction) {
    	MAX_FRACTION_HANDLE.set(segment, 0L, maxFraction);
    	return this;
    }
    
    /// ```
    /// The maximum fraction of the translation to consider, typically 1.
    /// ```
    public float maxFraction() {
    	return (float) MAX_FRACTION_HANDLE.get(segment, 0L);
    }
    
    @Override
    public BoxCastInput set(BoxCastInput other) {
        return set(other.segment);
    }
    
    @Override
    public BoxCastInput set(MemorySegment src) {
        MemorySegment.copy(src, 0L, segment, 0L, LAYOUT.byteSize());
        return this;
    }
    
    @Override
    public MemorySegment memorySegment() {
        return segment;
    }
    
    public NativeStructArray<BoxCastInput> asArray() {
        return new NativeStructArray<>(this);
    }
    
    public static NativeStructArray<BoxCastInput> array(Arena arena, int count) {
        return new NativeStructArray<>(
            arena,
            LAYOUT,
            segment -> new BoxCastInput(segment),
            count
        );
    }
    
    public static NativeStructArray<BoxCastInput> array(Arena arena, BoxCastInput... structs) {
        NativeStructArray<BoxCastInput> array = new NativeStructArray<>(
            arena,
            LAYOUT,
            segment -> new BoxCastInput(segment),
            structs.length
        );
    
        for (int i = 0; i < structs.length; i++) {
            array.set(i, structs[i]);
        }
    
        return array;
    }
    
    public static NativeStructArray<BoxCastInput> array(MemorySegment array) {
        return new NativeStructArray<>(
            array,
            LAYOUT,
            segment -> new BoxCastInput(segment)
        );
    }

}