package volucris.bindings.box2d;

import java.lang.foreign.Arena;
import java.lang.invoke.MethodHandle;

import edu.umd.cs.findbugs.annotations.Nullable;
import volucris.bindings.box2d.body.BodyId;
import volucris.bindings.box2d.joint.JointId;
import volucris.bindings.box2d.shape.ChainId;
import volucris.bindings.box2d.shape.ShapeId;
import volucris.bindings.core.NativeLibraryLoader;

import static java.lang.foreign.ValueLayout.*;
import static volucris.bindings.core.FFMUtils.*;

public class Box2D {

	private static final LazyConstant<MethodHandle> B2_SET_ALLOCATOR;
	private static final LazyConstant<MethodHandle> B2_GET_BYTE_COUNT;
	private static final LazyConstant<MethodHandle> B2_SET_ASSERT_FCN;

	static {
		B2_SET_ALLOCATOR = downcallHandleVoid("b2SetAllocator", UNBOUNDED_ADDRESS, UNBOUNDED_ADDRESS);
		B2_GET_BYTE_COUNT = downcallHandle("b2GetByteCount", JAVA_INT);
		B2_SET_ASSERT_FCN = downcallHandleVoid("b2SetAssertFcn", UNBOUNDED_ADDRESS);
	}

	private Box2D() {

	}

	public static void loadNativeLibrary() {
		loadNativeLibrary(false);
	}

	public static void loadNativeLibrary(boolean debug) {
		NativeLibraryLoader.loadLibrary("natives/box2d", "box2d", debug);
	}

	/**
	 * This allows the user to override the allocation functions.
	 */
	public static void setAllocator(AllocFcn allocFcn, FreeFcn freeFcn) {
		try {
			MethodHandle method = B2_SET_ALLOCATOR.get();
			method.invokeExact(allocFcn.memorySegment(), freeFcn.memorySegment());
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Returns the total bytes allocated by Box2D
	 */
	public static int getByteCount() {
		try {
			MethodHandle method = B2_GET_BYTE_COUNT.get();
			return (int) method.invokeExact();
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Override the default assert callback.
	 */
	public static void setAssertFcn(AssertFcn assertFcn) {
		try {
			MethodHandle method = B2_SET_ASSERT_FCN.get();
			method.invokeExact(assertFcn.memorySegment());
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Store a body id into a uint64_t.
	 */
	public static long storeBodyId(BodyId id) {
		return (id.index1() << 32) | (id.world0() << 16) | id.generation();
	}

	/**
	 * Load a uint64_t into a body id.
	 */
	public static BodyId loadBodyId(Arena arena, long x) {
		BodyId id = new BodyId(arena);
		id.index1((int) (x >> 32));
		id.world0((short) (x >> 16));
		id.generation((short) (x));
		return id;
	}

	/**
	 * Store a shape id into a uint64_t.
	 */
	public static long storeShapeId(ShapeId id) {
		return (id.index1() << 32) | (id.world0() << 16) | id.generation();
	}

	/**
	 * Load a uint64_t into a shape id.
	 */
	public static @Nullable ShapeId loadShapeId(Arena arena, long x) {
		ShapeId id = new ShapeId(arena);
		id.index1((int) (x >> 32));
		id.world0((short) (x >> 16));
		id.generation((short) (x));
		return id;
	}

	/**
	 * Store a chain id into a uint64_t.
	 */
	public static long storeChainId(ChainId id) {
		return (id.index1() << 32) | (id.world0() << 16) | id.generation();
	}

	/**
	 * Load a uint64_t into a chain id.
	 */
	public static @Nullable ChainId loadChainId(Arena arena, long x) {
		ChainId id = new ChainId(arena);
		id.index1((int) (x >> 32));
		id.world0((short) (x >> 16));
		id.generation((short) (x));
		return id;
	}

	/**
	 * Store a joint id into a uint64_t.
	 */
	public static long storeJointId(JointId id) {
		return (id.index1() << 32) | (id.world0() << 16) | id.generation();
	}

	/**
	 * Load a uint64_t into a joint id.
	 */
	public static @Nullable JointId loadJointId(Arena arena, long x) {
		JointId id = new JointId(arena);
		id.index1((int) (x >> 32));
		id.world0((short) (x >> 16));
		id.generation((short) (x));
		return id;
	}

}
