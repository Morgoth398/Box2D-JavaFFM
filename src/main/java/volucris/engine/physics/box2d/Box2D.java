package volucris.engine.physics.box2d;

import java.util.HashMap;

import volucris.engine.physics.box2d.body.Body;
import volucris.engine.physics.box2d.body.Body.BodyId;
import volucris.engine.physics.box2d.joint.Joint;
import volucris.engine.physics.box2d.joint.Joint.JointId;
import volucris.engine.physics.box2d.shape.Chain;
import volucris.engine.physics.box2d.shape.Shape;
import volucris.engine.physics.box2d.shape.Chain.ChainId;
import volucris.engine.physics.box2d.shape.Shape.ShapeId;
import volucris.engine.physics.box2d.world.World;
import volucris.engine.physics.box2d.world.World.WorldId;
import volucris.engine.utils.NativeLibraryLoader;

/**
 * @see <a href="https://box2d.org/">https://box2d.org/</a>
 */
public final class Box2D {

	private static final HashMap<WorldId, World> WORLDS;

	private static final HashMap<World, HashMap<BodyId, Body>> BODIES;
	private static final HashMap<World, HashMap<ShapeId, Shape>> SHAPES;
	private static final HashMap<World, HashMap<ChainId, Chain>> CHAINS;
	private static final HashMap<World, HashMap<JointId, Joint>> JOINTS;

	private static Version VERSION;

	static {
		WORLDS = new HashMap<WorldId, World>();

		BODIES = new HashMap<World, HashMap<BodyId, Body>>();
		SHAPES = new HashMap<World, HashMap<ShapeId, Shape>>();
		CHAINS = new HashMap<World, HashMap<ChainId, Chain>>();
		JOINTS = new HashMap<World, HashMap<JointId, Joint>>();
	}

	private Box2D() {

	}

	public static void init() {
		NativeLibraryLoader.loadLibrary("natives/box2d", "box2d");
		
		VERSION = new Version();
	}

	/**
	 * DO NOT CALL. INTERNAL USE ONLY.
	 */
	public static void addWorld(World world, WorldId worldId) {
		WORLDS.put(worldId, world);

		BODIES.put(world, new HashMap<BodyId, Body>(100));
		SHAPES.put(world, new HashMap<ShapeId, Shape>(100));
		CHAINS.put(world, new HashMap<ChainId, Chain>());
		JOINTS.put(world, new HashMap<JointId, Joint>());
	}

	/**
	 * DO NOT CALL. INTERNAL USE ONLY.
	 */
	public static World getWorld(WorldId worldId) {
		return WORLDS.get(worldId);
	}

	/**
	 * DO NOT CALL. INTERNAL USE ONLY.
	 */
	public static void removeWorld(WorldId worldId) {
		World world = WORLDS.remove(worldId);

		BODIES.remove(world);
		SHAPES.remove(world);
		CHAINS.remove(world);
	}

	/**
	 * DO NOT CALL. INTERNAL USE ONLY.
	 */
	public static void addBody(Body body, BodyId bodyId, World world) {
		BODIES.get(world).put(bodyId, body);
	}

	/**
	 * DO NOT CALL. INTERNAL USE ONLY.
	 */
	public static Body getBody(BodyId bodyId, World world) {
		return BODIES.get(world).get(bodyId);
	}

	/**
	 * DO NOT CALL. INTERNAL USE ONLY.
	 */
	public static void removeBody(BodyId bodyId, World world) {
		BODIES.get(world).remove(bodyId);
	}

	/**
	 * DO NOT CALL. INTERNAL USE ONLY.
	 */
	public static void addShape(Shape shape, ShapeId shapeId, World world) {
		SHAPES.get(world).put(shapeId, shape);
	}

	/**
	 * DO NOT CALL. INTERNAL USE ONLY.
	 */
	public static Shape getShape(ShapeId shapeId, World world) {
		return SHAPES.get(world).get(shapeId);
	}

	/**
	 * DO NOT CALL. INTERNAL USE ONLY.
	 */
	public static void removeShape(ShapeId shapeId, World world) {
		SHAPES.get(world).remove(shapeId);
	}

	/**
	 * DO NOT CALL. INTERNAL USE ONLY.
	 */
	public static void addChain(Chain chain, ChainId chainId, World world) {
		CHAINS.get(world).put(chainId, chain);
	}

	/**
	 * DO NOT CALL. INTERNAL USE ONLY.
	 */
	public static Chain getChain(ChainId chainId, World world) {
		return CHAINS.get(world).get(chainId);
	}

	/**
	 * DO NOT CALL. INTERNAL USE ONLY.
	 */
	public static void removeChain(ChainId chainId, World world) {
		CHAINS.get(world).remove(chainId);
	}

	/**
	 * DO NOT CALL. INTERNAL USE ONLY.
	 */
	public static void addJoint(Joint joint, JointId jointId, World world) {
		JOINTS.get(world).put(jointId, joint);
	}

	/**
	 * DO NOT CALL. INTERNAL USE ONLY.
	 */
	public static Joint getJoint(JointId jointId, World world) {
		return JOINTS.get(world).get(jointId);
	}

	/**
	 * DO NOT CALL. INTERNAL USE ONLY.
	 */
	public static void removeJoint(JointId jointId, World world) {
		JOINTS.get(world).remove(jointId);
	}

	/**
	 * DO NOT CALL. INTERNAL USE ONLY.
	 */
	public static String getVersion() {
		return VERSION.getVersion();
	}

}
