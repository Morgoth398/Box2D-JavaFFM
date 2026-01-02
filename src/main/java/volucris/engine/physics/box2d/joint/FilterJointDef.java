package volucris.engine.physics.box2d.joint;

import java.lang.foreign.Arena;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.StructLayout;
import java.lang.invoke.MethodHandle;

import volucris.engine.physics.box2d.body.Body;
import volucris.engine.utils.VolucrisRuntimeException;

import java.lang.foreign.MemoryLayout.PathElement;

import static java.lang.foreign.ValueLayout.*;
import static volucris.engine.utils.FFMUtils.*;

/**
 * A filter joint is used to disable collision between two specific bodies.
 */
public final class FilterJointDef {

	private static final StructLayout LAYOUT;

	private static final MethodHandle B2_DEFAULT_FILTER_JOINT_DEF;

	private static final long BODY_ID_A_OFFSET;
	private static final long BODY_ID_B_OFFSET;

	private final MemorySegment b2FilterJointDef;

	static {
		//@formatter:off
		LAYOUT = MemoryLayout.structLayout(
		        Body.LAYOUT().withName("bodyIdA"),
		        Body.LAYOUT().withName("bodyIdB"),
		        ADDRESS.withName("userData"),
		        JAVA_INT.withName("internalValue"),
		        MemoryLayout.paddingLayout(4)
			);
		//@formatter:on

		B2_DEFAULT_FILTER_JOINT_DEF = downcallHandle("b2DefaultFilterJointDef", LAYOUT);

		BODY_ID_A_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("bodyIdA"));
		BODY_ID_B_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("bodyIdB"));
	}

	public FilterJointDef() {
		this(Arena.ofAuto());
	}
	
	public FilterJointDef(Arena arena) {
		try {
			b2FilterJointDef = (MemorySegment) B2_DEFAULT_FILTER_JOINT_DEF.invoke(arena);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot create filter joint def.");
		}
	}

	/**
	 * The first attached body.
	 */
	public void setBodyA(Body body) {
		MemorySegment.copy(body.memorySegment(), 0L, b2FilterJointDef, BODY_ID_A_OFFSET, Body.LAYOUT().byteSize());
	}

	/**
	 * The second attached body.
	 */
	public void setBodyB(Body body) {
		MemorySegment.copy(body.memorySegment(), 0L, b2FilterJointDef, BODY_ID_B_OFFSET, Body.LAYOUT().byteSize());
	}

	public MemorySegment memorySegment() {
		return b2FilterJointDef;
	}

	public static StructLayout LAYOUT() {
		return LAYOUT;
	}

}
