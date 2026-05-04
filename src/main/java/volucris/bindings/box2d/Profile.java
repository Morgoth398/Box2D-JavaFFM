/*
 * MACHINE GENERATED FILE, DO NOT EDIT.
 */
package volucris.bindings.box2d;

import java.lang.foreign.Arena;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.StructLayout;
import java.lang.invoke.VarHandle;
import volucris.bindings.core.NativeStructArray;
import volucris.bindings.core.Struct;

import static java.lang.foreign.ValueLayout.*;

/**
 * Profiling data. Times are in milliseconds.
 */
public final class Profile
		implements Struct<Profile> {

    public static final StructLayout LAYOUT;

    public static final VarHandle STEP;
    public static final VarHandle PAIRS;
    public static final VarHandle COLLIDE;
    public static final VarHandle SOLVE;
    public static final VarHandle MERGE_ISLANDS;
    public static final VarHandle PREPARE_STAGES;
    public static final VarHandle SOLVE_CONSTRAINTS;
    public static final VarHandle PREPARE_CONSTRAINTS;
    public static final VarHandle INTEGRATE_VELOCITIES;
    public static final VarHandle WARM_START;
    public static final VarHandle SOLVE_IMPULSES;
    public static final VarHandle INTEGRATE_POSITIONS;
    public static final VarHandle RELAX_IMPULSES;
    public static final VarHandle APPLY_RESTITUTION;
    public static final VarHandle STORE_IMPULSES;
    public static final VarHandle SPLIT_ISLANDS;
    public static final VarHandle TRANSFORMS;
    public static final VarHandle HIT_EVENTS;
    public static final VarHandle REFIT;
    public static final VarHandle BULLETS;
    public static final VarHandle SLEEP_ISLANDS;
    public static final VarHandle SENSORS;

    public static final long STEP_OFFSET;
    public static final long PAIRS_OFFSET;
    public static final long COLLIDE_OFFSET;
    public static final long SOLVE_OFFSET;
    public static final long MERGE_ISLANDS_OFFSET;
    public static final long PREPARE_STAGES_OFFSET;
    public static final long SOLVE_CONSTRAINTS_OFFSET;
    public static final long PREPARE_CONSTRAINTS_OFFSET;
    public static final long INTEGRATE_VELOCITIES_OFFSET;
    public static final long WARM_START_OFFSET;
    public static final long SOLVE_IMPULSES_OFFSET;
    public static final long INTEGRATE_POSITIONS_OFFSET;
    public static final long RELAX_IMPULSES_OFFSET;
    public static final long APPLY_RESTITUTION_OFFSET;
    public static final long STORE_IMPULSES_OFFSET;
    public static final long SPLIT_ISLANDS_OFFSET;
    public static final long TRANSFORMS_OFFSET;
    public static final long HIT_EVENTS_OFFSET;
    public static final long REFIT_OFFSET;
    public static final long BULLETS_OFFSET;
    public static final long SLEEP_ISLANDS_OFFSET;
    public static final long SENSORS_OFFSET;

    private final MemorySegment segment;

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
        ).withName("b2Profile").withByteAlignment(4);
        
        STEP = LAYOUT.varHandle(PathElement.groupElement("step"));
        PAIRS = LAYOUT.varHandle(PathElement.groupElement("pairs"));
        COLLIDE = LAYOUT.varHandle(PathElement.groupElement("collide"));
        SOLVE = LAYOUT.varHandle(PathElement.groupElement("solve"));
        MERGE_ISLANDS = LAYOUT.varHandle(PathElement.groupElement("mergeIslands"));
        PREPARE_STAGES = LAYOUT.varHandle(PathElement.groupElement("prepareStages"));
        SOLVE_CONSTRAINTS = LAYOUT.varHandle(PathElement.groupElement("solveConstraints"));
        PREPARE_CONSTRAINTS = LAYOUT.varHandle(PathElement.groupElement("prepareConstraints"));
        INTEGRATE_VELOCITIES = LAYOUT.varHandle(PathElement.groupElement("integrateVelocities"));
        WARM_START = LAYOUT.varHandle(PathElement.groupElement("warmStart"));
        SOLVE_IMPULSES = LAYOUT.varHandle(PathElement.groupElement("solveImpulses"));
        INTEGRATE_POSITIONS = LAYOUT.varHandle(PathElement.groupElement("integratePositions"));
        RELAX_IMPULSES = LAYOUT.varHandle(PathElement.groupElement("relaxImpulses"));
        APPLY_RESTITUTION = LAYOUT.varHandle(PathElement.groupElement("applyRestitution"));
        STORE_IMPULSES = LAYOUT.varHandle(PathElement.groupElement("storeImpulses"));
        SPLIT_ISLANDS = LAYOUT.varHandle(PathElement.groupElement("splitIslands"));
        TRANSFORMS = LAYOUT.varHandle(PathElement.groupElement("transforms"));
        HIT_EVENTS = LAYOUT.varHandle(PathElement.groupElement("hitEvents"));
        REFIT = LAYOUT.varHandle(PathElement.groupElement("refit"));
        BULLETS = LAYOUT.varHandle(PathElement.groupElement("bullets"));
        SLEEP_ISLANDS = LAYOUT.varHandle(PathElement.groupElement("sleepIslands"));
        SENSORS = LAYOUT.varHandle(PathElement.groupElement("sensors"));
        
        STEP_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("step"));
        PAIRS_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("pairs"));
        COLLIDE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("collide"));
        SOLVE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("solve"));
        MERGE_ISLANDS_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("mergeIslands"));
        PREPARE_STAGES_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("prepareStages"));
        SOLVE_CONSTRAINTS_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("solveConstraints"));
        PREPARE_CONSTRAINTS_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("prepareConstraints"));
        INTEGRATE_VELOCITIES_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("integrateVelocities"));
        WARM_START_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("warmStart"));
        SOLVE_IMPULSES_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("solveImpulses"));
        INTEGRATE_POSITIONS_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("integratePositions"));
        RELAX_IMPULSES_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("relaxImpulses"));
        APPLY_RESTITUTION_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("applyRestitution"));
        STORE_IMPULSES_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("storeImpulses"));
        SPLIT_ISLANDS_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("splitIslands"));
        TRANSFORMS_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("transforms"));
        HIT_EVENTS_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("hitEvents"));
        REFIT_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("refit"));
        BULLETS_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("bullets"));
        SLEEP_ISLANDS_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("sleepIslands"));
        SENSORS_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("sensors"));
        //@formatter:on
    }

    public Profile() {
        this(Arena.ofAuto());
    }
    
    public Profile(Arena arena) {
        this(arena.allocate(LAYOUT));
    }
    
    public Profile(MemorySegment segment) {
        this.segment = segment;
    
    }

    public Profile step(float step) {
        STEP.set(segment, 0L, step);
        return this;
    }
    
    public float step() {
        return (float) STEP.get(segment, 0L);
    }
    
    public Profile pairs(float pairs) {
        PAIRS.set(segment, 0L, pairs);
        return this;
    }
    
    public float pairs() {
        return (float) PAIRS.get(segment, 0L);
    }
    
    public Profile collide(float collide) {
        COLLIDE.set(segment, 0L, collide);
        return this;
    }
    
    public float collide() {
        return (float) COLLIDE.get(segment, 0L);
    }
    
    public Profile solve(float solve) {
        SOLVE.set(segment, 0L, solve);
        return this;
    }
    
    public float solve() {
        return (float) SOLVE.get(segment, 0L);
    }
    
    public Profile mergeIslands(float mergeIslands) {
        MERGE_ISLANDS.set(segment, 0L, mergeIslands);
        return this;
    }
    
    public float mergeIslands() {
        return (float) MERGE_ISLANDS.get(segment, 0L);
    }
    
    public Profile prepareStages(float prepareStages) {
        PREPARE_STAGES.set(segment, 0L, prepareStages);
        return this;
    }
    
    public float prepareStages() {
        return (float) PREPARE_STAGES.get(segment, 0L);
    }
    
    public Profile solveConstraints(float solveConstraints) {
        SOLVE_CONSTRAINTS.set(segment, 0L, solveConstraints);
        return this;
    }
    
    public float solveConstraints() {
        return (float) SOLVE_CONSTRAINTS.get(segment, 0L);
    }
    
    public Profile prepareConstraints(float prepareConstraints) {
        PREPARE_CONSTRAINTS.set(segment, 0L, prepareConstraints);
        return this;
    }
    
    public float prepareConstraints() {
        return (float) PREPARE_CONSTRAINTS.get(segment, 0L);
    }
    
    public Profile integrateVelocities(float integrateVelocities) {
        INTEGRATE_VELOCITIES.set(segment, 0L, integrateVelocities);
        return this;
    }
    
    public float integrateVelocities() {
        return (float) INTEGRATE_VELOCITIES.get(segment, 0L);
    }
    
    public Profile warmStart(float warmStart) {
        WARM_START.set(segment, 0L, warmStart);
        return this;
    }
    
    public float warmStart() {
        return (float) WARM_START.get(segment, 0L);
    }
    
    public Profile solveImpulses(float solveImpulses) {
        SOLVE_IMPULSES.set(segment, 0L, solveImpulses);
        return this;
    }
    
    public float solveImpulses() {
        return (float) SOLVE_IMPULSES.get(segment, 0L);
    }
    
    public Profile integratePositions(float integratePositions) {
        INTEGRATE_POSITIONS.set(segment, 0L, integratePositions);
        return this;
    }
    
    public float integratePositions() {
        return (float) INTEGRATE_POSITIONS.get(segment, 0L);
    }
    
    public Profile relaxImpulses(float relaxImpulses) {
        RELAX_IMPULSES.set(segment, 0L, relaxImpulses);
        return this;
    }
    
    public float relaxImpulses() {
        return (float) RELAX_IMPULSES.get(segment, 0L);
    }
    
    public Profile applyRestitution(float applyRestitution) {
        APPLY_RESTITUTION.set(segment, 0L, applyRestitution);
        return this;
    }
    
    public float applyRestitution() {
        return (float) APPLY_RESTITUTION.get(segment, 0L);
    }
    
    public Profile storeImpulses(float storeImpulses) {
        STORE_IMPULSES.set(segment, 0L, storeImpulses);
        return this;
    }
    
    public float storeImpulses() {
        return (float) STORE_IMPULSES.get(segment, 0L);
    }
    
    public Profile splitIslands(float splitIslands) {
        SPLIT_ISLANDS.set(segment, 0L, splitIslands);
        return this;
    }
    
    public float splitIslands() {
        return (float) SPLIT_ISLANDS.get(segment, 0L);
    }
    
    public Profile transforms(float transforms) {
        TRANSFORMS.set(segment, 0L, transforms);
        return this;
    }
    
    public float transforms() {
        return (float) TRANSFORMS.get(segment, 0L);
    }
    
    public Profile hitEvents(float hitEvents) {
        HIT_EVENTS.set(segment, 0L, hitEvents);
        return this;
    }
    
    public float hitEvents() {
        return (float) HIT_EVENTS.get(segment, 0L);
    }
    
    public Profile refit(float refit) {
        REFIT.set(segment, 0L, refit);
        return this;
    }
    
    public float refit() {
        return (float) REFIT.get(segment, 0L);
    }
    
    public Profile bullets(float bullets) {
        BULLETS.set(segment, 0L, bullets);
        return this;
    }
    
    public float bullets() {
        return (float) BULLETS.get(segment, 0L);
    }
    
    public Profile sleepIslands(float sleepIslands) {
        SLEEP_ISLANDS.set(segment, 0L, sleepIslands);
        return this;
    }
    
    public float sleepIslands() {
        return (float) SLEEP_ISLANDS.get(segment, 0L);
    }
    
    public Profile sensors(float sensors) {
        SENSORS.set(segment, 0L, sensors);
        return this;
    }
    
    public float sensors() {
        return (float) SENSORS.get(segment, 0L);
    }
    
    @Override
    public Profile set(Profile other) {
        return set(other.segment);
    }
    
    @Override
    public Profile set(MemorySegment src) {
        MemorySegment.copy(src, 0L, segment, 0L, LAYOUT.byteSize());
        return this;
    }
    
    @Override
    public MemorySegment memorySegment() {
        return segment;
    }
    
    public NativeStructArray<Profile> asArray() {
        return new NativeStructArray<>(this);
    }
    
    public static NativeStructArray<Profile> array(Arena arena, int count) {
        return new NativeStructArray<>(
            arena,
            LAYOUT,
            segment -> new Profile(segment),
            count
        );
    }
    
    public static NativeStructArray<Profile> array(Arena arena, Profile... structs) {
        NativeStructArray<Profile> array = new NativeStructArray<>(
            arena,
            LAYOUT,
            segment -> new Profile(segment),
            structs.length
        );
    
        for (int i = 0; i < structs.length; i++) {
            array.set(i, structs[i]);
        }
    
        return array;
    }
    
    public static NativeStructArray<Profile> array(MemorySegment array) {
        return new NativeStructArray<>(
            array,
            LAYOUT,
            segment -> new Profile(segment)
        );
    }
    
}