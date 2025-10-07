package volucris.engine.physics.box2d.world;

import java.lang.foreign.Arena;
import java.lang.foreign.FunctionDescriptor;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.SegmentAllocator;
import java.lang.foreign.StructLayout;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodHandles.Lookup;
import java.lang.invoke.VarHandle;

import org.joml.Vector2f;

import volucris.engine.graphics.Color;
import volucris.engine.physics.box2d.math.AABB;
import volucris.engine.physics.box2d.math.Transform;
import volucris.engine.physics.box2d.math.Vec2;
import volucris.engine.utils.VolucrisRuntimeException;

import static java.lang.foreign.ValueLayout.*;
import static volucris.engine.utils.FFMUtils.*;

public abstract class DebugDraw {

	private static final StructLayout LAYOUT;

	private static final Lookup LOOKUP;

	private static final FunctionDescriptor DRAW_POLYGON_DESCR;
	private static final FunctionDescriptor DRAW_SOLID_POLYGON_DESCR;
	private static final FunctionDescriptor DRAW_CIRCLE_DESCR;
	private static final FunctionDescriptor DRAW_SOLID_CIRCLE_DESCR;
	private static final FunctionDescriptor DRAW_SOLID_CAPSULE_DESCR;
	private static final FunctionDescriptor DRAW_SEGMENT_DESCR;
	private static final FunctionDescriptor DRAW_TRANSFORM_DESCR;
	private static final FunctionDescriptor DRAW_POINT_DESCR;
	private static final FunctionDescriptor DRAW_STRING_DESCR;

	private static final VarHandle DRAW_POLYGON_FCN;
	private static final VarHandle DRAW_SOLID_POLYGON_FCN;
	private static final VarHandle DRAW_CIRCLE_FCN;
	private static final VarHandle DRAW_SOLID_CIRCLE_FCN;
	private static final VarHandle DRAW_SOLID_CAPSULE_FCN;
	private static final VarHandle DRAW_SEGMENT_FCN;
	private static final VarHandle DRAW_TRANSFORM_FCN;
	private static final VarHandle DRAW_POINT_FCN;
	private static final VarHandle DRAW_STRING_FCN;

	private static final VarHandle DRAW_SHAPES;
	private static final VarHandle DRAW_JOINTS;
	private static final VarHandle DRAW_JOINT_EXTRAS;
	private static final VarHandle DRAW_BOUNDS;
	private static final VarHandle DRAW_MASS;
	private static final VarHandle DRAW_BODY_NAMES;
	private static final VarHandle DRAW_CONTACTS;
	private static final VarHandle DRAW_GRAPH_COLORS;
	private static final VarHandle DRAW_CONTACT_NORMALS;
	private static final VarHandle DRAW_CONTACT_IMPULSES;
	private static final VarHandle DRAW_CONTACT_FEATURES;
	private static final VarHandle DRAW_FRICTION_IMPULSES;
	private static final VarHandle DRAW_ISLANDS;
	private static final VarHandle USE_DRAWING_BOUNDS;

	private static final MethodHandle B2_DEFAULT_DEBUG_DRAW;
	private static final MethodHandle DRAW_POLYGON_HANDLE;
	private static final MethodHandle DRAW_SOLID_POLYGON_HANDLE;
	private static final MethodHandle DRAW_CIRCLE_HANDLE;
	private static final MethodHandle DRAW_SOLID_CIRCLE_HANDLE;
	private static final MethodHandle DRAW_SOLID_CAPSULE_HANDLE;
	private static final MethodHandle DRAW_SEGMENT_HANDLE;
	private static final MethodHandle DRAW_TRANSFORM_HANDLE;
	private static final MethodHandle DRAW_POINT_HANDLE;
	private static final MethodHandle DRAW_STRING_HANDLE;

	private static final long DRAWING_BOUNDS_OFFSET;

	private final MemorySegment b2DebugDraw;

	private final MemorySegment drawPolygonAddress;
	private final MemorySegment drawSolidPolygonAddress;
	private final MemorySegment drawCircleAddress;
	private final MemorySegment drawSolidCircleAddress;
	private final MemorySegment drawSolidCapsuleAddress;
	private final MemorySegment drawSegmentAddress;
	private final MemorySegment drawTransformAddress;
	private final MemorySegment drawPointAddress;
	private final MemorySegment drawStringAddress;

	private final AABB drawingBounds;

	private Transform transformTmp;
	private Vec2 vec2Tmp;

	private Color color;
	private Vector2f vectorTmp;
	private Vector2f vectorTmp2;

	private float[] vertices;

	static {
		//@formatter:off
		LAYOUT = MemoryLayout.structLayout(
				ADDRESS.withName("DrawPolygonFcn"),
			    ADDRESS.withName("DrawSolidPolygonFcn"),
			    ADDRESS.withName("DrawCircleFcn"),
			    ADDRESS.withName("DrawSolidCircleFcn"),
			    ADDRESS.withName("DrawSolidCapsuleFcn"),
			    ADDRESS.withName("DrawSegmentFcn"),
			    ADDRESS.withName("DrawTransformFcn"),
			    ADDRESS.withName("DrawPointFcn"),
			    ADDRESS.withName("DrawStringFcn"),
			    AABB.LAYOUT().withName("drawingBounds"),
			    JAVA_BOOLEAN.withName("useDrawingBounds"),
			    JAVA_BOOLEAN.withName("drawShapes"),
			    JAVA_BOOLEAN.withName("drawJoints"),
			    JAVA_BOOLEAN.withName("drawJointExtras"),
			    JAVA_BOOLEAN.withName("drawBounds"),
			    JAVA_BOOLEAN.withName("drawMass"),
			    JAVA_BOOLEAN.withName("drawBodyNames"),
			    JAVA_BOOLEAN.withName("drawContacts"),
			    JAVA_BOOLEAN.withName("drawGraphColors"),
			    JAVA_BOOLEAN.withName("drawContactNormals"),
			    JAVA_BOOLEAN.withName("drawContactImpulses"),
			    JAVA_BOOLEAN.withName("drawContactFeatures"),
			    JAVA_BOOLEAN.withName("drawFrictionImpulses"),
			    JAVA_BOOLEAN.withName("drawIslands"),
			    MemoryLayout.paddingLayout(2),
			    ADDRESS.withName("context")
			);

		try {
			LOOKUP = MethodHandles.privateLookupIn(DebugDraw.class, MethodHandles.lookup());
		} catch (IllegalAccessException e) {
			throw new VolucrisRuntimeException("Cannot create private lookup.");
		}

		DRAW_POLYGON_DESCR = functionDescrVoid(ADDRESS, JAVA_INT, JAVA_INT, ADDRESS);
		DRAW_SOLID_POLYGON_DESCR = functionDescrVoid(Transform.LAYOUT(), ADDRESS, JAVA_INT, JAVA_FLOAT, JAVA_INT, ADDRESS);
		DRAW_CIRCLE_DESCR = functionDescrVoid(Vec2.LAYOUT(), JAVA_FLOAT, JAVA_INT, ADDRESS);
		DRAW_SOLID_CIRCLE_DESCR = functionDescrVoid(Transform.LAYOUT(), JAVA_FLOAT, JAVA_INT, ADDRESS);
		DRAW_SOLID_CAPSULE_DESCR = functionDescrVoid(Vec2.LAYOUT(), Vec2.LAYOUT(), JAVA_FLOAT, JAVA_INT, ADDRESS);
		DRAW_SEGMENT_DESCR = functionDescrVoid(Vec2.LAYOUT(), Vec2.LAYOUT(), JAVA_INT, ADDRESS);
		DRAW_TRANSFORM_DESCR = functionDescrVoid(Transform.LAYOUT(), ADDRESS);
		DRAW_POINT_DESCR = functionDescrVoid(Vec2.LAYOUT(), JAVA_FLOAT, JAVA_INT, ADDRESS);
		DRAW_STRING_DESCR = functionDescrVoid(Vec2.LAYOUT(), ADDRESS, JAVA_INT, ADDRESS);
		
		DRAW_POLYGON_FCN = varHandle(LAYOUT, "DrawPolygonFcn");
		DRAW_SOLID_POLYGON_FCN = varHandle(LAYOUT, "DrawSolidPolygonFcn");
		DRAW_CIRCLE_FCN = varHandle(LAYOUT, "DrawCircleFcn");
		DRAW_SOLID_CIRCLE_FCN = varHandle(LAYOUT, "DrawSolidCircleFcn");
		DRAW_SOLID_CAPSULE_FCN = varHandle(LAYOUT, "DrawSolidCapsuleFcn");
		DRAW_SEGMENT_FCN = varHandle(LAYOUT, "DrawSegmentFcn");
		DRAW_TRANSFORM_FCN = varHandle(LAYOUT, "DrawTransformFcn");
		DRAW_POINT_FCN = varHandle(LAYOUT, "DrawPointFcn");
		DRAW_STRING_FCN = varHandle(LAYOUT, "DrawStringFcn");
		
		DRAW_SHAPES = varHandle(LAYOUT, "drawShapes");
		DRAW_JOINTS = varHandle(LAYOUT, "drawJoints");
		DRAW_JOINT_EXTRAS = varHandle(LAYOUT, "drawJointExtras");
		DRAW_BOUNDS = varHandle(LAYOUT, "drawBounds");
		DRAW_MASS = varHandle(LAYOUT, "drawMass");
		DRAW_BODY_NAMES = varHandle(LAYOUT, "drawBodyNames");
		DRAW_CONTACTS = varHandle(LAYOUT, "drawContacts");
		DRAW_GRAPH_COLORS = varHandle(LAYOUT, "drawGraphColors");
		DRAW_CONTACT_NORMALS = varHandle(LAYOUT, "drawContactNormals");
		DRAW_CONTACT_IMPULSES = varHandle(LAYOUT, "drawContactImpulses");
		DRAW_CONTACT_FEATURES = varHandle(LAYOUT, "drawContactFeatures");
		DRAW_FRICTION_IMPULSES = varHandle(LAYOUT, "drawFrictionImpulses");
		DRAW_ISLANDS = varHandle(LAYOUT, "drawFrictionImpulses");
		USE_DRAWING_BOUNDS = varHandle(LAYOUT, "useDrawingBounds");
		
		B2_DEFAULT_DEBUG_DRAW = downcallHandle("b2DefaultDebugDraw", LAYOUT);

		DRAWING_BOUNDS_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("drawingBounds"));
		
		DRAW_POLYGON_HANDLE = upcallHandle(LOOKUP, DebugDraw.class, "drawPolygon", DRAW_POLYGON_DESCR);
		DRAW_SOLID_POLYGON_HANDLE = upcallHandle(LOOKUP, DebugDraw.class, "drawSolidPolygon", DRAW_SOLID_POLYGON_DESCR);
		DRAW_CIRCLE_HANDLE = upcallHandle(LOOKUP, DebugDraw.class, "drawCircle", DRAW_CIRCLE_DESCR);
		DRAW_SOLID_CIRCLE_HANDLE = upcallHandle(LOOKUP, DebugDraw.class, "drawSolidCircle", DRAW_SOLID_CIRCLE_DESCR);
		DRAW_SOLID_CAPSULE_HANDLE = upcallHandle(LOOKUP, DebugDraw.class, "drawSolidCapsule", DRAW_SOLID_CAPSULE_DESCR);
		DRAW_SEGMENT_HANDLE = upcallHandle(LOOKUP, DebugDraw.class, "drawSegment", DRAW_SEGMENT_DESCR);
		DRAW_TRANSFORM_HANDLE = upcallHandle(LOOKUP, DebugDraw.class, "drawTransform", DRAW_TRANSFORM_DESCR);
		DRAW_POINT_HANDLE = upcallHandle(LOOKUP, DebugDraw.class, "drawPoint", DRAW_POINT_DESCR);
		DRAW_STRING_HANDLE = upcallHandle(LOOKUP, DebugDraw.class, "drawString", DRAW_STRING_DESCR);		
		//@formatter:on
	}

	public DebugDraw() {
		try {
			SegmentAllocator allocator = Arena.ofAuto();
			b2DebugDraw = (MemorySegment) B2_DEFAULT_DEBUG_DRAW.invokeExact(allocator);
		} catch (Throwable e) {
			throw new VolucrisRuntimeException("Box2D: Cannot create debug draw.");
		}

		drawPolygonAddress = upcallStub(this, DRAW_POLYGON_HANDLE, DRAW_POLYGON_DESCR);
		drawSolidPolygonAddress = upcallStub(this, DRAW_SOLID_POLYGON_HANDLE, DRAW_SOLID_POLYGON_DESCR);
		drawCircleAddress = upcallStub(this, DRAW_CIRCLE_HANDLE, DRAW_CIRCLE_DESCR);
		drawSolidCircleAddress = upcallStub(this, DRAW_SOLID_CIRCLE_HANDLE, DRAW_SOLID_CIRCLE_DESCR);
		drawSolidCapsuleAddress = upcallStub(this, DRAW_SOLID_CAPSULE_HANDLE, DRAW_SOLID_CAPSULE_DESCR);
		drawSegmentAddress = upcallStub(this, DRAW_SEGMENT_HANDLE, DRAW_SEGMENT_DESCR);
		drawTransformAddress = upcallStub(this, DRAW_TRANSFORM_HANDLE, DRAW_TRANSFORM_DESCR);
		drawPointAddress = upcallStub(this, DRAW_POINT_HANDLE, DRAW_POINT_DESCR);
		drawStringAddress = upcallStub(this, DRAW_STRING_HANDLE, DRAW_STRING_DESCR);

		DRAW_POLYGON_FCN.set(b2DebugDraw, drawPolygonAddress);
		DRAW_SOLID_POLYGON_FCN.set(b2DebugDraw, drawSolidPolygonAddress);
		DRAW_CIRCLE_FCN.set(b2DebugDraw, drawCircleAddress);
		DRAW_SOLID_CIRCLE_FCN.set(b2DebugDraw, drawSolidCircleAddress);
		DRAW_SOLID_CAPSULE_FCN.set(b2DebugDraw, drawSolidCapsuleAddress);
		DRAW_SEGMENT_FCN.set(b2DebugDraw, drawSegmentAddress);
		DRAW_TRANSFORM_FCN.set(b2DebugDraw, drawTransformAddress);
		DRAW_POINT_FCN.set(b2DebugDraw, drawPointAddress);
		DRAW_STRING_FCN.set(b2DebugDraw, drawStringAddress);

		drawingBounds = new AABB(b2DebugDraw.asSlice(DRAWING_BOUNDS_OFFSET, AABB.LAYOUT()));

		transformTmp = new Transform();
		vec2Tmp = new Vec2();

		color = new Color();
		vectorTmp = new Vector2f();
		vectorTmp2 = new Vector2f();

		vertices = new float[250];
	}

	@SuppressWarnings("unused")
	private void drawPolygon(MemorySegment vertices, int vertexCount, int color, MemorySegment context) {
		MemorySegment verticesArray = vertices.reinterpret(vertexCount * Vec2.LAYOUT().byteSize());

		int counter = 0;
		for (int i = 0; i < vertexCount; i++) {
			long offset = i * Vec2.LAYOUT().byteSize();
			vec2Tmp.set(verticesArray.asSlice(offset, Vec2.LAYOUT()));
			this.vertices[counter++] = vec2Tmp.getX();
			this.vertices[counter++] = vec2Tmp.getY();
		}
		drawPolygon(this.vertices, vertexCount * 2, this.color.set(color, false));
	}

	@SuppressWarnings("unused")
	private void drawSolidPolygon(MemorySegment transform, MemorySegment vertices, int vertexCount, float radius,
			int color, MemorySegment context) {
		transformTmp.set(transform);

		MemorySegment verticesArray = vertices.reinterpret(vertexCount * Vec2.LAYOUT().byteSize());

		int counter = 0;
		for (int i = 0; i < vertexCount; i++) {
			long offset = i * Vec2.LAYOUT().byteSize();
			vec2Tmp.set(verticesArray.asSlice(offset, Vec2.LAYOUT()));
			this.vertices[counter++] = vec2Tmp.getX();
			this.vertices[counter++] = vec2Tmp.getY();
		}
		drawSolidPolygon(transformTmp, this.vertices, vertexCount * 2, radius, this.color.set(color, false));
	}

	@SuppressWarnings("unused")
	private void drawCircle(MemorySegment center, float radius, int color, MemorySegment context) {
		vec2Tmp.set(context);
		vec2Tmp.get(vectorTmp);
		drawCircle(vectorTmp, radius, this.color.set(color, false));
	}

	@SuppressWarnings("unused")
	private void drawSolidCircle(MemorySegment transform, float radius, int color, MemorySegment context) {
		transformTmp.set(transform);
		drawSolidCircle(transformTmp, radius, this.color.set(color, false));
	}

	@SuppressWarnings("unused")
	private void drawSolidCapsule(MemorySegment p1, MemorySegment p2, float radius, int color, MemorySegment context) {
		vec2Tmp.set(p1);
		vec2Tmp.get(vectorTmp);
		vec2Tmp.set(p2);
		vec2Tmp.get(vectorTmp2);
		drawSolidCapsule(vectorTmp, vectorTmp2, radius, this.color.set(color, false));
	}

	@SuppressWarnings("unused")
	private void drawSegment(MemorySegment p1, MemorySegment p2, int color, MemorySegment context) {
		vec2Tmp.set(p1);
		vec2Tmp.get(vectorTmp);
		vec2Tmp.set(p2);
		vec2Tmp.get(vectorTmp2);
		drawSegment(vectorTmp, vectorTmp2, this.color.set(color, false));
	}

	@SuppressWarnings("unused")
	private void drawTransform(MemorySegment transform, MemorySegment context) {
		transformTmp.set(transform);
		drawTransform(transformTmp);
	}

	@SuppressWarnings("unused")
	private void drawPoint(MemorySegment p, float size, int color, MemorySegment context) {
		vec2Tmp.set(p);
		vec2Tmp.get(vectorTmp);
		drawPoint(vectorTmp, size, this.color.set(color, false));
	}

	@SuppressWarnings("unused")
	private void drawString(MemorySegment p, MemorySegment string, int color, MemorySegment context) {
		vec2Tmp.set(p);
		vec2Tmp.get(vectorTmp);
		String name = string.reinterpret(Integer.MAX_VALUE).getString(0);
		drawString(vectorTmp, name, this.color.set(color, false));
	}

	//@formatter:off
	
	/**
	 * Draw a closed polygon provided in CCW order.
	 * <p>
	 * Do not keep a reference to the objects. They will be reused internally.
	 */
	protected abstract void drawPolygon(float[] vertices, int vertexCount, Color color);
	
	/**
	 * Draw a solid closed polygon provided in CCW order. 
	 * <p>
	 * Do not keep a reference to the objects. They will be reused internally.
	 */
	protected abstract void drawSolidPolygon(Transform transform, float[] vertices, int vertexCount, float radius, Color color);
	
	/**
	 * Draw a circle. 
	 * <p>
	 * Do not keep a reference to the objects. They will be reused internally.
	 */
	protected abstract void drawCircle(Vector2f center, float radius, Color color);
	
	/**
	 * Draw a solid circle.
	 * <p>
	 * Do not keep a reference to the objects. They will be reused internally.
	 */
	protected abstract void drawSolidCircle(Transform transform, float radius, Color color);
	
	/**
	 * Draw a solid capsule. 
	 * <p>
	 * Do not keep a reference to the objects. They will be reused internally.
	 */
	protected abstract void drawSolidCapsule(Vector2f p1, Vector2f p2, float radius, Color color);
	
	/**
	 * Draw a line segment. 
	 * <p>
	 * Do not keep a reference to the objects. They will be reused internally.
	 */
	protected abstract void drawSegment(Vector2f p1, Vector2f p2, Color color);
	
	/**
	 * Draw a point.
	 * <p>
	 * Do not keep a reference to the objects. They will be reused internally.
	 */
	protected abstract void drawPoint(Vector2f p, float size, Color color);
	
	/**
	 * Draw a transform. Choose your own length scale. 
	 * <p>
	 * Do not keep a reference to the objects. They will be reused internally.
	 */
	protected void drawTransform(Transform transform) {};
	
	/**
	 * Draw a string in world space. 
	 * <p>
	 * Do not keep a reference to the objects. They will be reused internally.
	 */
	protected void drawString(Vector2f p, String string, Color color) {};
	//@formatter:on

	/**
	 * Option to draw shapes.
	 */
	public void drawShapes(boolean drawShapes) {
		DRAW_SHAPES.set(b2DebugDraw, drawShapes);
	}

	/**
	 * Option to draw joints.
	 */
	public void drawJoints(boolean drawJoints) {
		DRAW_JOINTS.set(b2DebugDraw, drawJoints);
	}

	/**
	 * Option to draw additional information for joints.
	 */
	public void drawJointExtras(boolean drawJointExtras) {
		DRAW_JOINT_EXTRAS.set(b2DebugDraw, drawJointExtras);
	}

	/**
	 * Option to draw the bounding boxes for shapes.
	 */
	public void drawBounds(boolean drawBounds) {
		DRAW_BOUNDS.set(b2DebugDraw, drawBounds);
	}

	/**
	 * Option to draw the mass and center of mass of dynamic bodies.
	 */
	public void drawMass(boolean drawMass) {
		DRAW_MASS.set(b2DebugDraw, drawMass);
	}

	/**
	 * Option to draw body names.
	 */
	public void drawBodyNames(boolean drawBodyNames) {
		DRAW_BODY_NAMES.set(b2DebugDraw, drawBodyNames);
	}

	/**
	 * Option to draw contact points.
	 */
	public void drawContacts(boolean drawContacts) {
		DRAW_CONTACTS.set(b2DebugDraw, drawContacts);
	}

	/**
	 * Option to visualize the graph coloring used for contacts and joints.
	 */
	public void drawGraphColors(boolean drawGraphColors) {
		DRAW_GRAPH_COLORS.set(b2DebugDraw, drawGraphColors);
	}

	/**
	 * Option to draw contact normals.
	 */
	public void drawContactNormals(boolean drawContactNormals) {
		DRAW_CONTACT_NORMALS.set(b2DebugDraw, drawContactNormals);
	}

	/**
	 * Option to draw contact normal impulses.
	 */
	public void drawContactImpulses(boolean drawContactImpulses) {
		DRAW_CONTACT_IMPULSES.set(b2DebugDraw, drawContactImpulses);
	}

	/**
	 * Option to draw contact feature ids.
	 */
	public void drawContactFeatures(boolean drawContactFeatures) {
		DRAW_CONTACT_FEATURES.set(b2DebugDraw, drawContactFeatures);
	}

	/**
	 * 
	 */
	public void drawFrictionImpulses(boolean drawFrictionImpulses) {
		DRAW_FRICTION_IMPULSES.set(b2DebugDraw, drawFrictionImpulses);
	}

	/**
	 * Option to draw contact friction impulses.
	 */
	public void drawIslands(boolean drawIslands) {
		DRAW_ISLANDS.set(b2DebugDraw, drawIslands);
	}

	/**
	 * Option to restrict drawing to a rectangular region. May suffer from unstable
	 * depth sorting.
	 */
	public void useDrawingBounds(boolean useDrawingBounds) {
		USE_DRAWING_BOUNDS.set(b2DebugDraw, useDrawingBounds);
	}

	/**
	 * Bounds to use if restricting drawing to a rectangular region.
	 */
	public void setDrawingBounds(AABB drawingBounds) {
		this.drawingBounds.set(drawingBounds.memorySegment());
	}

	public MemorySegment memorySegment() {
		return b2DebugDraw.asReadOnly();
	}

	public static StructLayout LAYOUT() {
		return LAYOUT;
	}

}
