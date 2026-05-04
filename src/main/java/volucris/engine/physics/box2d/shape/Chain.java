package volucris.engine.physics.box2d.shape;

import java.lang.foreign.Arena;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.StructLayout;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;

import volucris.engine.physics.box2d.Box2D;
import volucris.engine.physics.box2d.body.Body;
import volucris.engine.physics.box2d.utils.Box2DRuntimeException;
import volucris.engine.physics.box2d.world.World;
import volucris.engine.physics.box2d.world.World.WorldId;

import static java.lang.foreign.ValueLayout.*;
import static volucris.engine.physics.box2d.utils.FFMUtils.*;

public final class Chain {

	private static final StructLayout CHAIN_ID_LAYOUT;

	private static final VarHandle INDEX_1;
	private static final VarHandle WORLD_0;
	private static final VarHandle GENERATION;

	private static final MethodHandle B2_CREATE_CHAIN;
	private static final MethodHandle B2_DESTROY_CHAIN;
	private static final MethodHandle B2_CHAIN_GET_WORLD;
	private static final MethodHandle B2_CHAIN_GET_SEGMENT_COUNT;
	private static final MethodHandle B2_CHAIN_GET_SEGMENTS;
	private static final MethodHandle B2_CHAIN_SET_FRICTION;
	private static final MethodHandle B2_CHAIN_GET_FRICTION;
	private static final MethodHandle B2_CHAIN_SET_RESTITUTION;
	private static final MethodHandle B2_CHAIN_GET_RESTITUTION;
	private static final MethodHandle B2_CHAIN_SET_MATERIAL;
	private static final MethodHandle B2_CHAIN_GET_MATERIAL;
	private static final MethodHandle B2_CHAIN_IS_VALID;

	private final MemorySegment b2ChainId;

	static {
		//@formatter:off
		CHAIN_ID_LAYOUT = MemoryLayout.structLayout(
				JAVA_INT.withName("index1"),
		        JAVA_SHORT.withName("world0"),
		        JAVA_SHORT.withName("generation")
			).withName("b2ChainId");
		//@formatter:on

		INDEX_1 = varHandle(CHAIN_ID_LAYOUT, "index1");
		WORLD_0 = varHandle(CHAIN_ID_LAYOUT, "world0");
		GENERATION = varHandle(CHAIN_ID_LAYOUT, "generation");

		B2_CREATE_CHAIN = downcallHandle("b2CreateChain", CHAIN_ID_LAYOUT, Body.LAYOUT(), ADDRESS);
		B2_DESTROY_CHAIN = downcallHandleVoid("b2DestroyChain", CHAIN_ID_LAYOUT);
		B2_CHAIN_GET_WORLD = downcallHandle("b2Chain_GetWorld", World.LAYOUT(), CHAIN_ID_LAYOUT);
		B2_CHAIN_GET_SEGMENT_COUNT = downcallHandle("b2Chain_GetSegmentCount", JAVA_INT, CHAIN_ID_LAYOUT);
		B2_CHAIN_GET_SEGMENTS = downcallHandle("b2Chain_GetSegments", JAVA_INT, CHAIN_ID_LAYOUT, ADDRESS, JAVA_INT);
		B2_CHAIN_SET_FRICTION = downcallHandleVoid("b2Chain_SetFriction", CHAIN_ID_LAYOUT, JAVA_FLOAT);
		B2_CHAIN_GET_FRICTION = downcallHandle("b2Chain_GetFriction", JAVA_FLOAT, CHAIN_ID_LAYOUT);
		B2_CHAIN_SET_RESTITUTION = downcallHandleVoid("b2Chain_SetRestitution", CHAIN_ID_LAYOUT, JAVA_FLOAT);
		B2_CHAIN_GET_RESTITUTION = downcallHandle("b2Chain_GetRestitution", JAVA_FLOAT, CHAIN_ID_LAYOUT);
		B2_CHAIN_SET_MATERIAL = downcallHandleVoid("b2Chain_SetMaterial", CHAIN_ID_LAYOUT, JAVA_INT);
		B2_CHAIN_GET_MATERIAL = downcallHandle("b2Chain_GetMaterial", JAVA_INT, CHAIN_ID_LAYOUT);
		B2_CHAIN_IS_VALID = downcallHandle("b2Chain_IsValid", JAVA_BOOLEAN, CHAIN_ID_LAYOUT);
	}

	/**
	 * Create the chain shape.
	 */
	public Chain(Body body, ChainDef chainDef) {
		this(body, chainDef, Arena.ofAuto());
	}

	/**
	 * Create the chain shape.
	 */
	public Chain(Body body, ChainDef chainDef, Arena arena) {
		try {
			MemorySegment bodyAddr = body.memorySegment();
			MemorySegment chainDefAddr = chainDef.memorySegment();

			b2ChainId = (MemorySegment) B2_CREATE_CHAIN.invoke(arena, bodyAddr, chainDefAddr);
		} catch (Throwable e) {
			String className = e.getClass().getSimpleName();
			throw new Box2DRuntimeException("Cannot create chain: " + className);
		}

		Box2D.addChain(this, getChainId(b2ChainId), body.getWorld().getWorldId());
	}
	
	public Chain(MemorySegment segment, long offset, WorldId worldId) {
		this(segment, Arena.ofAuto(), offset, worldId);
	}
	
	public Chain(MemorySegment segment, Arena arena, long offset, WorldId worldId) {
		b2ChainId = arena.allocate(CHAIN_ID_LAYOUT);
		MemorySegment.copy(segment, offset, b2ChainId, 0, CHAIN_ID_LAYOUT.byteSize());
	}
	
	/**
	 * Destroy a chain shape.
	 */
	public void destroyChain(MemorySegment segment) {
		Box2D.removeChain(getChainId(segment), getWorld().getWorldId());
		try {
			B2_DESTROY_CHAIN.invokeExact(segment);
		} catch (Throwable e) {
			String className = e.getClass().getSimpleName();
			throw new Box2DRuntimeException("Cannot destroy chain: " + className);
		}
	}

	/**
	 * Get the world that owns this chain shape.
	 */
	public World getWorld() {
		try (Arena arena = Arena.ofConfined()) {
			MethodHandle method = B2_CHAIN_GET_WORLD;
			MemorySegment b2WorldId = (MemorySegment) method.invoke(arena, b2ChainId);

			World world = Box2D.getWorld(World.getWorldId(b2WorldId));

			if (world != null)
				return world;

			return new World(b2WorldId, 0L);
		} catch (Throwable e) {
			String className = e.getClass().getSimpleName();
			throw new Box2DRuntimeException("Cannot get world: " + className);
		}
	}

	/**
	 * Get the number of segments on this chain.
	 */
	public int getSegmentCount() {
		try {
			return (int) B2_CHAIN_GET_SEGMENT_COUNT.invokeExact(b2ChainId);
		} catch (Throwable e) {
			String className = e.getClass().getSimpleName();
			throw new Box2DRuntimeException("Cannot get Segment count: " + className);
		}
	}

	/**
	 * Fill a user array with chain segment shape ids up to the specified capacity.
	 */
	public int getSegments(Shape[] target) {
		try (Arena arena = Arena.ofConfined()) {
			WorldId worldId = getWorld().getWorldId();

			MemorySegment array = arena.allocate(MemoryLayout.sequenceLayout(target.length, Shape.LAYOUT()));
			int count = (int) B2_CHAIN_GET_SEGMENTS.invokeExact(b2ChainId, array, target.length);

			for (int i = 0; i < count; i++) {
				long offset = i * Shape.LAYOUT().byteSize();

				Shape shape = Box2D.getShape(Shape.getShapeId(array, offset), worldId);

				if (shape == null) {
					target[i] = new Shape(array, offset, worldId);
				} else {
					target[i] = shape;
				}
			}

			return count;

		} catch (Throwable e) {
			String className = e.getClass().getSimpleName();
			throw new Box2DRuntimeException("Cannot get segments: " + className);
		}
	}

	/**
	 * Set the chain friction.
	 */
	public void setFriction(float friction) {
		try {
			B2_CHAIN_SET_FRICTION.invokeExact(b2ChainId, friction);
		} catch (Throwable e) {
			String className = e.getClass().getSimpleName();
			throw new Box2DRuntimeException("Cannot set friction: " + className);
		}
	}

	/**
	 * Get the chain friction.
	 */
	public float getFriction() {
		try {
			return (float) B2_CHAIN_GET_FRICTION.invokeExact(b2ChainId);
		} catch (Throwable e) {
			String className = e.getClass().getSimpleName();
			throw new Box2DRuntimeException("Cannot get friction: " + className);
		}
	}

	/**
	 * Set the chain restitution (bounciness)
	 */
	public void setRestitution(float restitution) {
		try {
			B2_CHAIN_SET_RESTITUTION.invokeExact(b2ChainId, restitution);
		} catch (Throwable e) {
			String className = e.getClass().getSimpleName();
			throw new Box2DRuntimeException("Cannot set restitution: " + className);
		}
	}

	/**
	 * Get the chain restitution.
	 */
	public float getRestitution() {
		try {
			return (float) B2_CHAIN_GET_RESTITUTION.invokeExact(b2ChainId);
		} catch (Throwable e) {
			String className = e.getClass().getSimpleName();
			throw new Box2DRuntimeException("Cannot get restitution: " + className);
		}
	}

	/**
	 * Set the chain material.
	 */
	public void setMaterial(int material) {
		try {
			B2_CHAIN_SET_MATERIAL.invokeExact(b2ChainId, material);
		} catch (Throwable e) {
			String className = e.getClass().getSimpleName();
			throw new Box2DRuntimeException("Cannot set material: " + className);
		}
	}

	/**
	 * Get the chain material.
	 */
	public int getMaterial() {
		try {
			return (int) B2_CHAIN_GET_MATERIAL.invokeExact(b2ChainId);
		} catch (Throwable e) {
			String className = e.getClass().getSimpleName();
			throw new Box2DRuntimeException("Cannot get material: " + className);
		}
	}

	/**
	 * Chain identifier validation. Provides validation for up to 64K allocations.
	 */
	public boolean isValid() {
		try {
			return (boolean) B2_CHAIN_IS_VALID.invokeExact(b2ChainId);
		} catch (Throwable e) {
			String className = e.getClass().getSimpleName();
			throw new Box2DRuntimeException("Cannot validate chain: " + className);
		}
	}

	public MemorySegment memorySegment() {
		return b2ChainId;
	}

	public static StructLayout LAYOUT() {
		return CHAIN_ID_LAYOUT;
	}

	public static ChainId getChainId(MemorySegment memorySegment) {
		int index1 = (int) INDEX_1.get(memorySegment);
		short world0 = (short) WORLD_0.get(memorySegment);
		short generation = (short) GENERATION.get(memorySegment);
		return new ChainId(index1, world0, generation);
	}

	public static record ChainId(int index1, short world0, short generation) {
	};
}
