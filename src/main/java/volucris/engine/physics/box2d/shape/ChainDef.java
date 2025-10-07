package volucris.engine.physics.box2d.shape;

import java.lang.foreign.Arena;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.SegmentAllocator;
import java.lang.foreign.StructLayout;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;

import org.joml.Vector2f;

import volucris.engine.physics.box2d.math.Vec2;
import volucris.engine.utils.VolucrisRuntimeException;

import static java.lang.foreign.ValueLayout.*;
import static volucris.engine.utils.FFMUtils.*;

/**
 * Used to create a chain of line segments.
 * <p>
 * This is designed to eliminate ghost collisions with some limitations.
 * <ul>
 * <li>chains are one-sided
 * <li>chains have no mass and should be used on static bodies
 * <li>chains have a counter-clockwise winding order (normal points right of
 * segment direction)
 * <li>chains are either a loop or open
 * <li>a chain must have at least 4 points
 * <li>the distance between any two points must be greater than B2_LINEAR_SLOP
 * <li>a chain shape should not self intersect (this is not validated)
 * <li>an open chain shape has NO COLLISION on the first and final edge
 * <li>you may overlap two open chains on their first three and/or last three
 * points to get smooth collision
 * <li>a chain shape creates multiple line segment shapes on the body
 * https://en.wikipedia.org/wiki/Polygonal_chain.
 * </ul>
 * Warning: Do not use chain shapes unless you understand the limitations. This
 * is an advanced feature.
 */
public final class ChainDef {

	private static final StructLayout LAYOUT;

	private static final VarHandle POINTS;
	private static final VarHandle COUNT;
	private static final VarHandle MATERIALS;
	private static final VarHandle MATERIAL_COUNT;
	private static final VarHandle IS_LOOP;
	private static final VarHandle ENABLE_SENSOR_EVENTS;

	private static final MethodHandle B2_DEFAULT_CHAIN_DEF;

	private static final long FILTER_OFFSET;

	private final MemorySegment b2ChainDef;

	private final Filter filter;

	private MemorySegment pointArray;
	private MemorySegment materialArray;

	private Vec2 vecTmp;

	static {
		//@formatter:off
		LAYOUT = MemoryLayout.structLayout(
		        ADDRESS.withName("userData"),
		        ADDRESS.withName("points"),
		        JAVA_INT.withName("count"),
		        MemoryLayout.paddingLayout(4),
		        ADDRESS.withName("materials"),
		        JAVA_INT.withName("materialCount"),
		        MemoryLayout.paddingLayout(4),
		        Filter.LAYOUT().withName("filter"),
		        JAVA_BOOLEAN.withName("isLoop"),
		        JAVA_BOOLEAN.withName("enableSensorEvents"),
		        MemoryLayout.paddingLayout(2),
		        JAVA_INT.withName("internalValue")
			).withName("b2ChainDef");
		//@formatter:on

		B2_DEFAULT_CHAIN_DEF = downcallHandle("b2DefaultChainDef", LAYOUT);

		POINTS = varHandle(LAYOUT, "points");
		COUNT = varHandle(LAYOUT, "count");
		MATERIALS = varHandle(LAYOUT, "metrials");
		MATERIAL_COUNT = varHandle(LAYOUT, "materialCount");
		IS_LOOP = varHandle(LAYOUT, "isLoop");
		ENABLE_SENSOR_EVENTS = varHandle(LAYOUT, "enableSensorEvents");

		FILTER_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("filter"));
	}

	public ChainDef() {
		try {
			SegmentAllocator allocator = Arena.ofAuto();
			b2ChainDef = (MemorySegment) B2_DEFAULT_CHAIN_DEF.invokeExact(allocator);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot create chain def.");
		}

		filter = new Filter(b2ChainDef.asSlice(FILTER_OFFSET, Filter.LAYOUT()));

		vecTmp = new Vec2();
	}

	/**
	 * Contact filtering data.
	 */
	public Filter getFilter() {
		return filter;
	}

	/**
	 * An array of at least 4 points.
	 */
	public void setPoints(Vector2f[] points) {

		if (pointArray == null || pointArray.byteSize() < points.length * Vec2.LAYOUT().byteSize())
			pointArray = Arena.ofAuto().allocate(MemoryLayout.sequenceLayout(points.length, Vec2.LAYOUT()));

		for (int i = 0; i < points.length; i++) {
			vecTmp.set(points[i]);

			long offset = i * Vec2.LAYOUT().byteSize();
			MemorySegment.copy(vecTmp.memorySegment(), 0L, pointArray, offset, Vec2.LAYOUT().byteSize());
		}

		POINTS.set(b2ChainDef, pointArray);
		COUNT.set(b2ChainDef, points.length);
	}

	/**
	 * Surface materials for each segment. These are cloned.
	 */
	public void setSurfaceMaterials(SurfaceMaterial[] materials) {
		StructLayout layout = SurfaceMaterial.LAYOUT();

		if (materialArray == null || materialArray.byteSize() < materials.length * layout.byteSize())
			materialArray = Arena.ofAuto().allocate(MemoryLayout.sequenceLayout(materials.length, layout));

		for (int i = 0; i < materials.length; i++) {
			long offset = i * layout.byteSize();
			MemorySegment.copy(materials[i].memorySegment(), 0L, materialArray, offset, layout.byteSize());
		}

		MATERIALS.set(b2ChainDef, materialArray);
		MATERIAL_COUNT.set(b2ChainDef, materials.length);
	}

	/**
	 * Enable sensors to detect this chain. False by default.
	 */
	public void enableSensorevents(boolean enableSensorEvents) {
		ENABLE_SENSOR_EVENTS.set(b2ChainDef, enableSensorEvents);
	}

	/**
	 * Indicates a closed chain formed by connecting the first and last points.
	 */
	public void isLoop(boolean isLoop) {
		IS_LOOP.set(b2ChainDef, isLoop);
	}

	public MemorySegment memorySegment() {
		return b2ChainDef.asReadOnly();
	}

	public static StructLayout LAYOUT() {
		return LAYOUT;
	}
}
