package volucris.engine.physics.box2d.shape;

import java.lang.foreign.Arena;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.StructLayout;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;

import volucris.engine.physics.box2d.Box2D;
import volucris.engine.physics.box2d.body.Body;
import volucris.engine.physics.box2d.world.World;
import volucris.engine.utils.Box2DRuntimeException;

import static java.lang.foreign.ValueLayout.*;
import static volucris.engine.utils.FFMUtils.*;

public final class Chain {

	private static final StructLayout CHAIN_ID_LAYOUT;

	private static final VarHandle INDEX_1;
	private static final VarHandle WORLD_0;
	private static final VarHandle GENERATION;

	private static final MethodHandle B2_CREATE_CHAIN;
	private static final MethodHandle B2_DESTROY_CHAIN;
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

	private Body body;

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

			MemorySegment segment = (MemorySegment) B2_CREATE_CHAIN.invoke(arena, bodyAddr, chainDefAddr);
			b2ChainId = segment.reinterpret(arena, s -> destroyChain(s, body.getWorld()));
		} catch (Throwable e) {
			String className = e.getClass().getSimpleName();
			throw new Box2DRuntimeException("Box2D: Cannot create chain: " + className);
		}

		this.body = body;

		Box2D.addChain(this, getChainId(b2ChainId), body.getWorld());
	}

	/**
	 * Destroy a chain shape.
	 */
	private static void destroyChain(MemorySegment segment, World world) {
		Box2D.removeChain(getChainId(segment), world);
		try {
			B2_DESTROY_CHAIN.invokeExact(segment);
		} catch (Throwable e) {
			String className = e.getClass().getSimpleName();
			throw new Box2DRuntimeException("Box2D: Cannot destroy chain: " + className);
		}
	}

	/**
	 * Get the world that owns this chain shape.
	 */
	public World getWorld() {
		return body.getWorld();
	}

	/**
	 * Get the number of segments on this chain.
	 */
	public int getSegmentCount() {
		try {
			return (int) B2_CHAIN_GET_SEGMENT_COUNT.invokeExact(b2ChainId);
		} catch (Throwable e) {
			String className = e.getClass().getSimpleName();
			throw new Box2DRuntimeException("Box2D: : " + className);
		}
	}

	/**
	 * Fill a user array with chain segment shape ids up to the specified capacity.
	 */
	public int getSegments(Shape[] target) {
		return getSegments(target, Arena.ofAuto());
	}

	/**
	 * Fill a user array with chain segment shape ids up to the specified capacity.
	 */
	public int getSegments(Shape[] target, Arena shapeArena) {
		try (Arena arena = Arena.ofConfined()) {
			MemorySegment array = arena.allocate(MemoryLayout.sequenceLayout(target.length, Shape.LAYOUT()));
			int count = (int) B2_CHAIN_GET_SEGMENTS.invokeExact(b2ChainId, array, target.length);

			for (int i = 0; i < count; i++) {
				long offset = i * Shape.LAYOUT().byteSize();

				Shape shape = Box2D.getShape(Shape.getShapeId(array, offset), body.getWorld());

				if (shape == null) {
					MemorySegment shapeSegment = shapeArena.allocate(Shape.LAYOUT());
					MemorySegment.copy(array, offset, shapeSegment, 0L, Shape.LAYOUT().byteSize());
					target[i] = new Shape(shapeSegment, body);
				} else {
					target[i] = shape;
				}
			}

			return count;

		} catch (Throwable e) {
			String className = e.getClass().getSimpleName();
			throw new Box2DRuntimeException("Box2D: Cannot get segments: " + className);
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
			throw new Box2DRuntimeException("Box2D: Cannot set friction: " + className);
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
			throw new Box2DRuntimeException("Box2D: Cannot get friction: " + className);
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
			throw new Box2DRuntimeException("Box2D: Cannot set restitution: " + className);
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
			throw new Box2DRuntimeException("Box2D: Cannot get restitution: " + className);
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
			throw new Box2DRuntimeException("Box2D: Cannot set material: " + className);
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
			throw new Box2DRuntimeException("Box2D: Cannot get material: " + className);
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
			throw new Box2DRuntimeException("Box2D: Cannot validate chain: " + className);
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
