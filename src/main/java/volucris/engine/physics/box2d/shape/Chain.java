package volucris.engine.physics.box2d.shape;

import java.lang.foreign.Arena;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.SegmentAllocator;
import java.lang.foreign.StructLayout;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;

import volucris.engine.physics.box2d.Box2D;
import volucris.engine.physics.box2d.body.Body;
import volucris.engine.physics.box2d.world.World;
import volucris.engine.utils.VolucrisRuntimeException;

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

	private ChainId chainId;

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
	 * Create the chain Shape.
	 */
	public Chain(Body body, ChainDef chainDef) {
		try {
			SegmentAllocator allocator = Arena.ofAuto();

			MemorySegment bodyAddr = body.memorySegment();
			MemorySegment chainDefAddr = chainDef.memorySegment();

			b2ChainId = (MemorySegment) B2_CREATE_CHAIN.invokeExact(allocator, bodyAddr, chainDefAddr);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot create chain.");
		}

		this.chainId = getChainId(b2ChainId);
		this.body = body;

		Box2D.addChain(this, chainId, body.getWorld());
	}

	/**
	 * Destroy a chain shape.
	 */
	public void destroyChain() {
		try {
			B2_DESTROY_CHAIN.invokeExact(b2ChainId);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot destroy chain.");
		}

		Box2D.removeChain(chainId, body.getWorld());
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
			throw new VolucrisRuntimeException("Box2D: ");
		}
	}

	/**
	 * Fill a user array with chain segment shape ids up to the specified capacity.
	 */
	public int getSegments(Shape[] target) {
		try (Arena arena = Arena.ofConfined()) {
			MemorySegment array = arena.allocate(MemoryLayout.sequenceLayout(target.length, Shape.LAYOUT()));
			int count = (int) B2_CHAIN_GET_SEGMENTS.invokeExact(b2ChainId, array, target.length);

			for (int i = 0; i < count; i++) {
				long offset = i * Shape.LAYOUT().byteSize();
				MemorySegment arraySegment = array.asSlice(offset, Shape.LAYOUT());

				Shape shape = Box2D.getShape(Shape.getShapeId(arraySegment), body.getWorld());

				if (shape == null) {
					MemorySegment shapeSegment = Arena.ofAuto().allocate(Shape.LAYOUT());
					MemorySegment.copy(arraySegment, offset, shapeSegment, 0L, Shape.LAYOUT().byteSize());
					target[i] = new Shape(shapeSegment, body);
				} else {
					target[i] = shape;
				}
			}

			return count;

		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot get segments.");
		}
	}

	/**
	 * Set the chain friction.
	 */
	public void setFriction(float friction) {
		try {
			B2_CHAIN_SET_FRICTION.invokeExact(b2ChainId, friction);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot set friction.");
		}
	}

	/**
	 * Get the chain friction.
	 */
	public float getFriction() {
		try {
			return (float) B2_CHAIN_GET_FRICTION.invokeExact(b2ChainId);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot get friction.");
		}
	}

	/**
	 * Set the chain restitution (bounciness)
	 */
	public void setRestitution(float restitution) {
		try {
			B2_CHAIN_SET_RESTITUTION.invokeExact(b2ChainId, restitution);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot set restitution.");
		}
	}

	/**
	 * Get the chain restitution.
	 */
	public float getRestitution() {
		try {
			return (float) B2_CHAIN_GET_RESTITUTION.invokeExact(b2ChainId);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot get restitution.");
		}
	}

	/**
	 * Set the chain material.
	 */
	public void setMaterial(int material) {
		try {
			B2_CHAIN_SET_MATERIAL.invokeExact(b2ChainId, material);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot set material.");
		}
	}

	/**
	 * Get the chain material.
	 */
	public int getMaterial() {
		try {
			return (int) B2_CHAIN_GET_MATERIAL.invokeExact(b2ChainId);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot get material.");
		}
	}

	/**
	 * Chain identifier validation. Provides validation for up to 64K allocations.
	 */
	public boolean isValid() {
		try {
			return (boolean) B2_CHAIN_IS_VALID.invokeExact(b2ChainId);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot validate chain.");
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
