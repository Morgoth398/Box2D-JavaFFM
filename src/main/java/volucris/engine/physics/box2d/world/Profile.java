package volucris.engine.physics.box2d.world;

import java.lang.foreign.Arena;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.StructLayout;
import java.lang.invoke.VarHandle;

import static java.lang.foreign.ValueLayout.*;
import static volucris.engine.utils.FFMUtils.*;

public final class Profile {

	private static final StructLayout LAYOUT;

	private static final VarHandle STEP;
	private static final VarHandle PAIRS;
	private static final VarHandle COLLIDE;
	private static final VarHandle SOLVE;
	private static final VarHandle MERGE_ISLANDS;
	private static final VarHandle PREPARE_STAGES;
	private static final VarHandle SOLVE_CONSTRAINTS;
	private static final VarHandle PREPARE_CONSTRAINTS;
	private static final VarHandle INTEGRATE_VELOCITIES;
	private static final VarHandle WARM_START;
	private static final VarHandle SOLVE_IMPULSES;
	private static final VarHandle INTEGRATE_POSITIONS;
	private static final VarHandle RELAX_IMPULSES;
	private static final VarHandle APPLY_RESTITUTION;
	private static final VarHandle STORE_IMPULSES;
	private static final VarHandle SPLIT_ISLANDS;
	private static final VarHandle TRANFORMS;
	private static final VarHandle HIT_EVENTS;
	private static final VarHandle REFIT;
	private static final VarHandle BULLETS;
	private static final VarHandle SLEEP_ISLANDS;
	private static final VarHandle SENSORS;

	private final MemorySegment b2Profile;

	static {
		//@formatter:off
		LAYOUT = MemoryLayout.structLayout(
		        JAVA_FLOAT.withName("step"),
		        JAVA_FLOAT.withName("pairs"),
		        JAVA_FLOAT.withName("collide"),
		        JAVA_FLOAT.withName("solve"),
		        JAVA_FLOAT.withName("mergeIslands"),
		        JAVA_FLOAT.withName("prepareStages"),
		        JAVA_FLOAT.withName("solveConstraints"),
		        JAVA_FLOAT.withName("prepareConstraints"),
		        JAVA_FLOAT.withName("integrateVelocities"),
		        JAVA_FLOAT.withName("warmStart"),
		        JAVA_FLOAT.withName("solveImpulses"),
		        JAVA_FLOAT.withName("integratePositions"),
		        JAVA_FLOAT.withName("relaxImpulses"),
		        JAVA_FLOAT.withName("applyRestitution"),
		        JAVA_FLOAT.withName("storeImpulses"),
		        JAVA_FLOAT.withName("splitIslands"),
		        JAVA_FLOAT.withName("transforms"),
		        JAVA_FLOAT.withName("hitEvents"),
		        JAVA_FLOAT.withName("refit"),
		        JAVA_FLOAT.withName("bullets"),
		        JAVA_FLOAT.withName("sleepIslands"),
		        JAVA_FLOAT.withName("sensors")
			).withName("b2Profile");
		//@formatter:on

		STEP = varHandle(LAYOUT, "step");
		PAIRS = varHandle(LAYOUT, "pairs");
		COLLIDE = varHandle(LAYOUT, "collide");
		SOLVE = varHandle(LAYOUT, "solve");
		MERGE_ISLANDS = varHandle(LAYOUT, "mergeIslands");
		PREPARE_STAGES = varHandle(LAYOUT, "prepareStages");
		SOLVE_CONSTRAINTS = varHandle(LAYOUT, "solveConstraints");
		PREPARE_CONSTRAINTS = varHandle(LAYOUT, "prepareConstraints");
		INTEGRATE_VELOCITIES = varHandle(LAYOUT, "integrateVelocities");
		WARM_START = varHandle(LAYOUT, "warmStart");
		SOLVE_IMPULSES = varHandle(LAYOUT, "solveImpulses");
		INTEGRATE_POSITIONS = varHandle(LAYOUT, "integratePositions");
		RELAX_IMPULSES = varHandle(LAYOUT, "relaxImpulses");
		APPLY_RESTITUTION = varHandle(LAYOUT, "applyRestitution");
		STORE_IMPULSES = varHandle(LAYOUT, "storeImpulses");
		SPLIT_ISLANDS = varHandle(LAYOUT, "splitIslands");
		TRANFORMS = varHandle(LAYOUT, "transforms");
		HIT_EVENTS = varHandle(LAYOUT, "hitEvents");
		REFIT = varHandle(LAYOUT, "refit");
		BULLETS = varHandle(LAYOUT, "bullets");
		SLEEP_ISLANDS = varHandle(LAYOUT, "sleepIslands");
		SENSORS = varHandle(LAYOUT, "sensors");
	}

	public Profile() {
		this(Arena.ofAuto());
	}
	
	public Profile(Arena arena) {
		b2Profile = arena.allocate(LAYOUT);
	}

	public Profile(MemorySegment memorySegment) {
		b2Profile = memorySegment;
	}

	public void set(MemorySegment memorySegment) {
		MemorySegment.copy(memorySegment, 0L, b2Profile, 0L, LAYOUT.byteSize());
	}

	public float getStep() {
		return (float) STEP.get(b2Profile);
	}

	public float getPairs() {
		return (float) PAIRS.get(b2Profile);
	}

	public float getCollide() {
		return (float) COLLIDE.get(b2Profile);
	}

	public float getSolve() {
		return (float) SOLVE.get(b2Profile);
	}

	public float getMergeIslands() {
		return (float) MERGE_ISLANDS.get(b2Profile);
	}

	public float getPrepareStages() {
		return (float) PREPARE_STAGES.get(b2Profile);
	}

	public float getSolveConstraints() {
		return (float) SOLVE_CONSTRAINTS.get(b2Profile);
	}

	public float getPrepareConstraints() {
		return (float) PREPARE_CONSTRAINTS.get(b2Profile);
	}

	public float getIntegrateVelocities() {
		return (float) INTEGRATE_VELOCITIES.get(b2Profile);
	}

	public float getWarmStart() {
		return (float) WARM_START.get(b2Profile);
	}

	public float getSolveInpulses() {
		return (float) SOLVE_IMPULSES.get(b2Profile);
	}

	public float getIntegratePositions() {
		return (float) INTEGRATE_POSITIONS.get(b2Profile);
	}

	public float getRelaxImpulses() {
		return (float) RELAX_IMPULSES.get(b2Profile);
	}

	public float getApplyRestitution() {
		return (float) APPLY_RESTITUTION.get(b2Profile);
	}

	public float getStoreImpulses() {
		return (float) STORE_IMPULSES.get(b2Profile);
	}

	public float getSplitIslands() {
		return (float) SPLIT_ISLANDS.get(b2Profile);
	}

	public float getTransforms() {
		return (float) TRANFORMS.get(b2Profile);
	}

	public float getHitEvents() {
		return (float) HIT_EVENTS.get(b2Profile);
	}

	public float getRefit() {
		return (float) REFIT.get(b2Profile);
	}

	public float getBullets() {
		return (float) BULLETS.get(b2Profile);
	}

	public float getSleepIslands() {
		return (float) SLEEP_ISLANDS.get(b2Profile);
	}

	public float getSensors() {
		return (float) SENSORS.get(b2Profile);
	}

	public MemorySegment memorySegment() {
		return b2Profile;
	}

	public static StructLayout LAYOUT() {
		return LAYOUT;
	}

}
