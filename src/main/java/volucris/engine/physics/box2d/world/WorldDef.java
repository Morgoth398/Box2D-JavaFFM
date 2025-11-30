package volucris.engine.physics.box2d.world;

import java.lang.foreign.Arena;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.SegmentAllocator;
import java.lang.foreign.StructLayout;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;

import org.joml.Vector2f;

import volucris.engine.physics.box2d.math.Vec2;
import volucris.engine.physics.box2d.world.callbacks.EnqueueTaskCallback;
import volucris.engine.physics.box2d.world.callbacks.FinishTaskCallback;
import volucris.engine.physics.box2d.world.callbacks.FrictionCallback;
import volucris.engine.physics.box2d.world.callbacks.RestitutionCallback;
import volucris.engine.utils.VolucrisRuntimeException;

import static java.lang.foreign.ValueLayout.*;
import static volucris.engine.utils.FFMUtils.*;

public final class WorldDef {

	private final static StructLayout LAYOUT;

	private final static VarHandle GRAVITY_X;
	private final static VarHandle GRAVITY_Y;
	private final static VarHandle RESTITUTION_THRESHOLD;
	private final static VarHandle HIT_EVENT_THRESHOLD;
	private final static VarHandle CONTACT_HERTZ;
	private final static VarHandle CONTACT_DAMPING_RATIO;
	private final static VarHandle MAX_CONTACT_PUSH_SPEED;
	private final static VarHandle MAXIMUM_LINEAR_SPEED;
	private final static VarHandle FRICTION_CALLBACK;
	private final static VarHandle RESTITUTION_CALLBACK;
	private final static VarHandle ENABLE_SLEEP;
	private final static VarHandle ENABLE_CONTINUOUS;
	private final static VarHandle WORKER_COUNT;
	private final static VarHandle ENQUEUE_TASK;
	private final static VarHandle FINISH_TASK;

	private static final MethodHandle B2_DEFAULT_WORLD_DEF;

	private final MemorySegment b2WorldDef;

	static {
		//@formatter:off
		LAYOUT = MemoryLayout.structLayout(
				Vec2.LAYOUT().withName("gravity"),		
				JAVA_FLOAT.withName("restitutionThreshold"),
				JAVA_FLOAT.withName("hitEventThreshold"),			
				JAVA_FLOAT.withName("contactHertz"),
				JAVA_FLOAT.withName("contactDampingRatio"),		
				JAVA_FLOAT.withName("maxContactPushSpeed"),
				JAVA_FLOAT.withName("maximumLinearSpeed"),		
				ADDRESS.withName("frictionCallback"),	
				ADDRESS.withName("restitutionCallback"),			
				JAVA_BOOLEAN.withName("enableSleep"),
				JAVA_BOOLEAN.withName("enableContinuous"),
				MemoryLayout.paddingLayout(2),
				JAVA_INT.withName("workerCount"),		
				ADDRESS.withName("enqueueTask"),		
				ADDRESS.withName("finishTask"),	
				ADDRESS.withName("userTaskContext"),				
				ADDRESS.withName("userData"),
				JAVA_INT.withName("internalValue"),
				MemoryLayout.paddingLayout(4)
			).withName("b2WorldDef");
		//@formatter:on

		GRAVITY_X = varHandle(LAYOUT, "gravity", "x");
		GRAVITY_Y = varHandle(LAYOUT, "gravity", "y");
		RESTITUTION_THRESHOLD = varHandle(LAYOUT, "restitutionThreshold");
		HIT_EVENT_THRESHOLD = varHandle(LAYOUT, "hitEventThreshold");
		CONTACT_HERTZ = varHandle(LAYOUT, "contactHertz");
		CONTACT_DAMPING_RATIO = varHandle(LAYOUT, "contactDampingRatio");
		MAX_CONTACT_PUSH_SPEED = varHandle(LAYOUT, "maxContactPushSpeed");
		MAXIMUM_LINEAR_SPEED = varHandle(LAYOUT, "maximumLinearSpeed");
		FRICTION_CALLBACK = varHandle(LAYOUT, "frictionCallback");
		RESTITUTION_CALLBACK = varHandle(LAYOUT, "restitutionCallback");
		ENABLE_SLEEP = varHandle(LAYOUT, "enableSleep");
		ENABLE_CONTINUOUS = varHandle(LAYOUT, "enableContinuous");
		WORKER_COUNT = varHandle(LAYOUT, "workerCount");
		ENQUEUE_TASK = varHandle(LAYOUT, "enqueueTask");
		FINISH_TASK = varHandle(LAYOUT, "finishTask");

		B2_DEFAULT_WORLD_DEF = downcallHandle("b2DefaultWorldDef", LAYOUT);
	}

	public WorldDef() {
		try {
			SegmentAllocator allocator = Arena.ofAuto();
			b2WorldDef = (MemorySegment) B2_DEFAULT_WORLD_DEF.invokeExact(allocator);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot create world def.");
		}
	}

	/**
	 * Gravity vector. Box2D has no up-vector defined.
	 */
	public void setGravity(Vector2f gravity) {
		setGravity(gravity.x, gravity.y);
	}

	/**
	 * Gravity vector. Box2D has no up-vector defined.
	 */
	public void setGravity(float x, float y) {
		GRAVITY_X.set(b2WorldDef, x);
		GRAVITY_Y.set(b2WorldDef, y);
	}

	/**
	 * Restitution speed threshold, usually in m/s. Collisions above this speed have
	 * restitution applied (will bounce).
	 */
	public void setRestitutionThreshold(float restitutionThreshold) {
		RESTITUTION_THRESHOLD.set(b2WorldDef, restitutionThreshold);
	}

	/**
	 * Threshold speed for hit events. Usually meters per second.
	 */
	public void setHitEventThreshold(float hitEventThreshold) {
		HIT_EVENT_THRESHOLD.set(b2WorldDef, hitEventThreshold);
	}

	/**
	 * Contact stiffness. Cycles per second. Increasing this increases the speed of
	 * overlap recovery, but can introduce jitter.
	 */
	public void setContactHertz(float contactHertz) {
		CONTACT_HERTZ.set(b2WorldDef, contactHertz);
	}

	/**
	 * Contact bounciness.
	 * <p>
	 * Non-dimensional. You can speed up overlap recovery by decreasing this with
	 * the trade-off that overlap resolution becomes more energetic.
	 */
	public void setContactDampingRatio(float contactDampingRatio) {
		CONTACT_DAMPING_RATIO.set(b2WorldDef, contactDampingRatio);
	}

	/**
	 * This parameter controls how fast overlap is resolved and usually has units of
	 * meters per second.
	 * <p>
	 * This only puts a cap on the resolution speed. The resolution speed is
	 * increased by increasing the hertz and/or decreasing the damping ratio.
	 */
	public void setMaxContactPushSpeed(float maxContactPushSpeed) {
		MAX_CONTACT_PUSH_SPEED.set(b2WorldDef, maxContactPushSpeed);
	}

	/**
	 * Maximum linear speed. Usually meters per second.
	 */
	public void setMaximumLinearSpeed(float maximumLinearSpeed) {
		MAXIMUM_LINEAR_SPEED.set(b2WorldDef, maximumLinearSpeed);
	}

	/**
	 * Optional mixing callback for friction. The default uses sqrt(frictionA *
	 * frictionB).
	 */
	public void setFrictionCallback(FrictionCallback callback) {
		FRICTION_CALLBACK.set(b2WorldDef, callback.memorySegment());
	}

	/**
	 * Optional mixing callback for restitution. The default uses max(restitutionA,
	 * restitutionB).
	 */
	public void setRestitutionCallback(RestitutionCallback callback) {
		RESTITUTION_CALLBACK.set(b2WorldDef, callback.memorySegment());
	}

	/**
	 * Can bodies go to sleep to improve performance.
	 */
	public void enableSleep(boolean enableSleep) {
		ENABLE_SLEEP.set(b2WorldDef, enableSleep);
	}

	/**
	 * Enable continuous collision.
	 */
	public void enableContinuous(boolean enableContinuous) {
		ENABLE_CONTINUOUS.set(b2WorldDef, enableContinuous);
	}

	/**
	 * Number of workers to use with the provided task system.
	 * <p>
	 * Box2D performs best when using only performance cores and accessing a single
	 * L2 cache. Efficiency cores and hyper-threading provide little benefit and may
	 * even harm performance.
	 * <p>
	 * Note: Box2D does not create threads. This is the number of threads your
	 * applications has created that you are allocating to
	 * {@link World#step(float, int)}
	 * <p>
	 * Warning: Do not modify the default value unless you are also providing a task
	 * system and providing task callbacks (enqueueTask and finishTask).
	 */
	public void setWorkerCount(int workerCount) {
		WORKER_COUNT.set(b2WorldDef, workerCount);
	}

	/**
	 * Function to spawn tasks.
	 */
	public void setEnqueueTaskCallback(EnqueueTaskCallback callback) {
		ENQUEUE_TASK.set(b2WorldDef, callback.memorySegment());
	}

	/**
	 * Function to finish a task.
	 */
	public void setFinishTaskCallback(FinishTaskCallback callback) {
		FINISH_TASK.set(b2WorldDef, callback.memorySegment());
	}

	public MemorySegment memorySegment() {
		return b2WorldDef;
	}

	public static StructLayout LAYOUT() {
		return LAYOUT;
	}

}
