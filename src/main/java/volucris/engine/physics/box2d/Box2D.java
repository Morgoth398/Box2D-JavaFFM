package volucris.engine.physics.box2d;

import java.lang.ref.WeakReference;
import java.util.HashMap;

import volucris.engine.physics.box2d.body.Body;
import volucris.engine.physics.box2d.body.Body.BodyId;
import volucris.engine.physics.box2d.joint.Joint;
import volucris.engine.physics.box2d.joint.Joint.JointId;
import volucris.engine.physics.box2d.shape.Chain;
import volucris.engine.physics.box2d.shape.Shape;
import volucris.engine.physics.box2d.shape.Chain.ChainId;
import volucris.engine.physics.box2d.shape.Shape.ShapeId;
import volucris.engine.physics.box2d.utils.NativeLibraryLoader;
import volucris.engine.physics.box2d.world.World;
import volucris.engine.physics.box2d.world.World.WorldId;

/**
 * @see <a href="https://box2d.org/">https://box2d.org/</a>
 */
public final class Box2D {

	private static final HashMap<WorldId, WeakReference<World>> WORLDS;

	private static final HashMap<WorldId, HashMap<BodyId, WeakReference<Body>>> BODIES;
	private static final HashMap<WorldId, HashMap<ShapeId, WeakReference<Shape>>> SHAPES;
	private static final HashMap<WorldId, HashMap<ChainId, WeakReference<Chain>>> CHAINS;
	private static final HashMap<WorldId, HashMap<JointId, WeakReference<Joint>>> JOINTS;

	private static final HashMap<WorldId, Object> WORLD_USER_DATA;
	private static final HashMap<WorldId, HashMap<BodyId, Object>> BODY_USER_DATA;
	private static final HashMap<WorldId, HashMap<ShapeId, Object>> SHAPE_USER_DATA;
	private static final HashMap<WorldId, HashMap<JointId, Object>> JOINT_USER_DATA;

	private static final HashMap<WorldId, Object> WORLD_INTERNAL_USER_DATA;
	private static final HashMap<WorldId, HashMap<BodyId, Object>> BODY_INTERNAL_USER_DATA;
	private static final HashMap<WorldId, HashMap<ShapeId, Object>> SHAPE_INTERNAL_USER_DATA;
	private static final HashMap<WorldId, HashMap<JointId, Object>> JOINT_INTERNAL_USER_DATA;

	private static Version VERSION;

	static {
		WORLDS = new HashMap<WorldId, WeakReference<World>>();

		BODIES = new HashMap<WorldId, HashMap<BodyId, WeakReference<Body>>>();
		SHAPES = new HashMap<WorldId, HashMap<ShapeId, WeakReference<Shape>>>();
		CHAINS = new HashMap<WorldId, HashMap<ChainId, WeakReference<Chain>>>();
		JOINTS = new HashMap<WorldId, HashMap<JointId, WeakReference<Joint>>>();

		BODY_USER_DATA = new HashMap<WorldId, HashMap<BodyId, Object>>();
		SHAPE_USER_DATA = new HashMap<WorldId, HashMap<ShapeId, Object>>();
		JOINT_USER_DATA = new HashMap<WorldId, HashMap<JointId, Object>>();

		BODY_INTERNAL_USER_DATA = new HashMap<WorldId, HashMap<BodyId, Object>>();
		SHAPE_INTERNAL_USER_DATA = new HashMap<WorldId, HashMap<ShapeId, Object>>();
		JOINT_INTERNAL_USER_DATA = new HashMap<WorldId, HashMap<JointId, Object>>();
		
		WORLD_USER_DATA = new HashMap<World.WorldId, Object>();
		WORLD_INTERNAL_USER_DATA = new HashMap<World.WorldId, Object>();
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
	public static  void setUserData(WorldId worldId, Object userData) {
		WORLD_USER_DATA.put(worldId, userData);
	}
	
	/**
	 * DO NOT CALL. INTERNAL USE ONLY.
	 */
	public static  Object getUserData(WorldId worldId) {
		return WORLD_USER_DATA.get(worldId);
	}
	
	/**
	 * DO NOT CALL. INTERNAL USE ONLY.
	 */
	public static  void setInternalUserData(WorldId worldId, Object userData) {
		WORLD_INTERNAL_USER_DATA.put(worldId, userData);
	}
	
	/**
	 * DO NOT CALL. INTERNAL USE ONLY.
	 */
	public static  Object getInternalUserData(WorldId worldId) {
		return WORLD_INTERNAL_USER_DATA.get(worldId);
	}
	
	/**
	 * DO NOT CALL. INTERNAL USE ONLY.
	 */
	public static void addWorld(World world, WorldId worldId) {
		WORLDS.put(worldId, new WeakReference<World>(world));

		if (!BODIES.containsKey(worldId))
			BODIES.put(worldId, new HashMap<BodyId, WeakReference<Body>>(100));
		if (!SHAPES.containsKey(worldId))
			SHAPES.put(worldId, new HashMap<ShapeId, WeakReference<Shape>>(100));
		if (!CHAINS.containsKey(worldId))
			CHAINS.put(worldId, new HashMap<ChainId, WeakReference<Chain>>());
		if (!JOINTS.containsKey(worldId))
			JOINTS.put(worldId, new HashMap<JointId, WeakReference<Joint>>());

		if (!BODY_USER_DATA.containsKey(worldId))
			BODY_USER_DATA.put(worldId, new HashMap<BodyId, Object>());
		if (!SHAPE_USER_DATA.containsKey(worldId))
			SHAPE_USER_DATA.put(worldId, new HashMap<ShapeId, Object>());
		if (!JOINT_USER_DATA.containsKey(worldId))
			JOINT_USER_DATA.put(worldId, new HashMap<JointId, Object>());

		if (!BODY_INTERNAL_USER_DATA.containsKey(worldId))
			BODY_INTERNAL_USER_DATA.put(worldId, new HashMap<BodyId, Object>());
		if (!SHAPE_INTERNAL_USER_DATA.containsKey(worldId))
			SHAPE_INTERNAL_USER_DATA.put(worldId, new HashMap<ShapeId, Object>());
		if (!JOINT_INTERNAL_USER_DATA.containsKey(worldId))
			JOINT_INTERNAL_USER_DATA.put(worldId, new HashMap<JointId, Object>());
	}

	/**
	 * DO NOT CALL. INTERNAL USE ONLY.
	 */
	public static World getWorld(WorldId worldId) {
		return WORLDS.get(worldId).get();
	}

	/**
	 * DO NOT CALL. INTERNAL USE ONLY.
	 */
	public static void removeWorld(WorldId worldId) {
		WORLDS.remove(worldId);

		BODIES.remove(worldId);
		SHAPES.remove(worldId);
		CHAINS.remove(worldId);

		BODY_USER_DATA.remove(worldId);
		SHAPE_USER_DATA.remove(worldId);
		JOINT_USER_DATA.remove(worldId);

		BODY_INTERNAL_USER_DATA.remove(worldId);
		SHAPE_INTERNAL_USER_DATA.remove(worldId);
		JOINT_INTERNAL_USER_DATA.remove(worldId);
	}

	/**
	 * DO NOT CALL. INTERNAL USE ONLY.
	 */
	public static void setUserData(BodyId bodyId, WorldId worldId, Object userData) {
		BODY_USER_DATA.get(worldId).put(bodyId, userData);
	}

	/**
	 * DO NOT CALL. INTERNAL USE ONLY.
	 */
	public static Object getUserData(BodyId bodyId, WorldId worldId) {
		return BODY_USER_DATA.get(worldId).get(bodyId);
	}

	/**
	 * DO NOT CALL. INTERNAL USE ONLY.
	 */
	public static void setInternalUserData(BodyId bodyId, WorldId worldId, Object userData) {
		BODY_INTERNAL_USER_DATA.get(worldId).put(bodyId, userData);
	}

	/**
	 * DO NOT CALL. INTERNAL USE ONLY.
	 */
	public static Object getInternalUserData(BodyId bodyId, WorldId worldId) {
		return BODY_INTERNAL_USER_DATA.get(worldId).get(bodyId);
	}

	/**
	 * DO NOT CALL. INTERNAL USE ONLY.
	 */
	public static void addBody(Body body, BodyId bodyId, WorldId worldId) {
		BODIES.get(worldId).put(bodyId, new WeakReference<Body>(body));
	}

	/**
	 * DO NOT CALL. INTERNAL USE ONLY.
	 */
	public static Body getBody(BodyId bodyId, WorldId worldId) {
		return BODIES.get(worldId).get(bodyId).get();
	}

	/**
	 * DO NOT CALL. INTERNAL USE ONLY.
	 */
	public static void removeBody(BodyId bodyId, WorldId worldId) {
		BODIES.get(worldId).remove(bodyId);
	}

	/**
	 * DO NOT CALL. INTERNAL USE ONLY.
	 */
	public static void setUserData(ShapeId bodyId, WorldId worldId, Object userData) {
		SHAPE_USER_DATA.get(worldId).put(bodyId, userData);
	}

	/**
	 * DO NOT CALL. INTERNAL USE ONLY.
	 */
	public static Object getUserData(ShapeId bodyId, WorldId worldId) {
		return SHAPE_USER_DATA.get(worldId).get(bodyId);
	}

	/**
	 * DO NOT CALL. INTERNAL USE ONLY.
	 */
	public static void setInternalUserData(ShapeId bodyId, WorldId worldId, Object userData) {
		SHAPE_INTERNAL_USER_DATA.get(worldId).put(bodyId, userData);
	}

	/**
	 * DO NOT CALL. INTERNAL USE ONLY.
	 */
	public static Object getInternalUserData(ShapeId bodyId, WorldId worldId) {
		return SHAPE_INTERNAL_USER_DATA.get(worldId).get(bodyId);
	}

	/**
	 * DO NOT CALL. INTERNAL USE ONLY.
	 */
	public static void addShape(Shape shape, ShapeId shapeId, WorldId worldId) {
		SHAPES.get(worldId).put(shapeId, new WeakReference<Shape>(shape));
	}

	/**
	 * DO NOT CALL. INTERNAL USE ONLY.
	 */
	public static Shape getShape(ShapeId shapeId, WorldId worldId) {
		return SHAPES.get(worldId).get(shapeId).get();
	}

	/**
	 * DO NOT CALL. INTERNAL USE ONLY.
	 */
	public static void removeShape(ShapeId shapeId, WorldId worldId) {
		SHAPES.get(worldId).remove(shapeId);
	}

	/**
	 * DO NOT CALL. INTERNAL USE ONLY.
	 */
	public static void addChain(Chain chain, ChainId chainId, WorldId worldId) {
		CHAINS.get(worldId).put(chainId, new WeakReference<Chain>(chain));
	}

	/**
	 * DO NOT CALL. INTERNAL USE ONLY.
	 */
	public static Chain getChain(ChainId chainId, WorldId worldId) {
		return CHAINS.get(worldId).get(chainId).get();
	}

	/**
	 * DO NOT CALL. INTERNAL USE ONLY.
	 */
	public static void removeChain(ChainId chainId, WorldId worldId) {
		CHAINS.get(worldId).remove(chainId);
	}

	/**
	 * DO NOT CALL. INTERNAL USE ONLY.
	 */
	public static void setUserData(JointId bodyId, WorldId worldId, Object userData) {
		JOINT_USER_DATA.get(worldId).put(bodyId, userData);
	}

	/**
	 * DO NOT CALL. INTERNAL USE ONLY.
	 */
	public static Object getUserData(JointId bodyId, WorldId worldId) {
		return JOINT_USER_DATA.get(worldId).get(bodyId);
	}

	/**
	 * DO NOT CALL. INTERNAL USE ONLY.
	 */
	public static void setInternalUserData(JointId bodyId, WorldId worldId, Object userData) {
		JOINT_INTERNAL_USER_DATA.get(worldId).put(bodyId, userData);
	}

	/**
	 * DO NOT CALL. INTERNAL USE ONLY.
	 */
	public static Object getInternalUserData(JointId bodyId, WorldId worldId) {
		return JOINT_INTERNAL_USER_DATA.get(worldId).get(bodyId);
	}

	/**
	 * DO NOT CALL. INTERNAL USE ONLY.
	 */
	public static void addJoint(Joint joint, JointId jointId, WorldId worldId) {
		JOINTS.get(worldId).put(jointId, new WeakReference<Joint>(joint));
	}

	/**
	 * DO NOT CALL. INTERNAL USE ONLY.
	 */
	public static Joint getJoint(JointId jointId, WorldId worldId) {
		return JOINTS.get(worldId).get(jointId).get();
	}

	/**
	 * DO NOT CALL. INTERNAL USE ONLY.
	 */
	public static void removeJoint(JointId jointId, WorldId worldId) {
		JOINTS.get(worldId).remove(jointId);
	}

	public static String getVersion() {
		return VERSION.getVersion();
	}

}
