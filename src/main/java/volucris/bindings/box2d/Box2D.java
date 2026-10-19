package volucris.bindings.box2d;

import java.lang.foreign.Arena;

import org.jspecify.annotations.Nullable;

import volucris.bindings.box2d.body.BodyId;
import volucris.bindings.box2d.chain.ChainId;
import volucris.bindings.box2d.joint.JointId;
import volucris.bindings.box2d.shape.ShapeId;
import volucris.bindings.core.NativeLibraryLoader;

public class Box2D {

	private Box2D() {

	}

	public static void loadNativeLibrary() {
		loadNativeLibrary(false);
	}

	public static void loadNativeLibrary(boolean debug) {
		NativeLibraryLoader.loadLibrary("natives/box2d", "box2d", debug);
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
