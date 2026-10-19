/*
 * MACHINE GENERATED FILE, DO NOT EDIT.
 */
package volucris.bindings.box2d.world.debug;

import java.lang.foreign.Arena;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.StructLayout;
import java.lang.invoke.VarHandle;
import java.util.function.Consumer;
import org.jspecify.annotations.Nullable;
import volucris.bindings.box2d.math.AABB;
import volucris.bindings.core.NativeStructArray;
import volucris.bindings.core.Struct;

import static java.lang.foreign.ValueLayout.*;
import static volucris.bindings.core.FFMUtils.*;

/// ```
/// This struct holds callbacks you can implement to draw a Box2D world. Callbacks receive world
/// coordinates. In large world mode the translation is double precision so it stays accurate far
/// from the origin. Shift into your own camera frame inside the callbacks. Initialize with
/// b2DefaultDebugDraw.
/// @ingroup debug
/// ```
public final class DebugDraw
		implements Struct<DebugDraw> {

	public static final StructLayout LAYOUT;

	public static final VarHandle DRAW_POLYGON_FCN_HANDLE;
	public static final VarHandle DRAW_SOLID_POLYGON_FCN_HANDLE;
	public static final VarHandle DRAW_CIRCLE_FCN_HANDLE;
	public static final VarHandle DRAW_SOLID_CIRCLE_FCN_HANDLE;
	public static final VarHandle DRAW_SOLID_CAPSULE_FCN_HANDLE;
	public static final VarHandle DRAW_LINE_FCN_HANDLE;
	public static final VarHandle DRAW_TRANSFORM_FCN_HANDLE;
	public static final VarHandle DRAW_POINT_FCN_HANDLE;
	public static final VarHandle DRAW_STRING_FCN_HANDLE;
	public static final VarHandle DRAW_BOUNDS_FCN_HANDLE;
	public static final VarHandle FORCE_SCALE_HANDLE;
	public static final VarHandle JOINT_SCALE_HANDLE;
	public static final VarHandle DRAW_CONTACTS_HANDLE;
	public static final VarHandle DRAW_ANCHOR_A_HANDLE;
	public static final VarHandle DRAW_SHAPES_HANDLE;
	public static final VarHandle DRAW_CHAIN_NORMALS_HANDLE;
	public static final VarHandle DRAW_JOINTS_HANDLE;
	public static final VarHandle DRAW_JOINT_EXTRAS_HANDLE;
	public static final VarHandle DRAW_BOUNDS_HANDLE;
	public static final VarHandle DRAW_MASS_HANDLE;
	public static final VarHandle DRAW_BODY_NAMES_HANDLE;
	public static final VarHandle DRAW_GRAPH_COLORS_HANDLE;
	public static final VarHandle DRAW_CONTACT_FEATURES_HANDLE;
	public static final VarHandle DRAW_CONTACT_NORMALS_HANDLE;
	public static final VarHandle DRAW_CONTACT_FORCES_HANDLE;
	public static final VarHandle DRAW_FRICTION_FORCES_HANDLE;
	public static final VarHandle DRAW_ISLANDS_HANDLE;
	public static final VarHandle CONTEXT_HANDLE;

	public static final long DRAW_POLYGON_FCN_BYTE_OFFSET;
	public static final long DRAW_SOLID_POLYGON_FCN_BYTE_OFFSET;
	public static final long DRAW_CIRCLE_FCN_BYTE_OFFSET;
	public static final long DRAW_SOLID_CIRCLE_FCN_BYTE_OFFSET;
	public static final long DRAW_SOLID_CAPSULE_FCN_BYTE_OFFSET;
	public static final long DRAW_LINE_FCN_BYTE_OFFSET;
	public static final long DRAW_TRANSFORM_FCN_BYTE_OFFSET;
	public static final long DRAW_POINT_FCN_BYTE_OFFSET;
	public static final long DRAW_STRING_FCN_BYTE_OFFSET;
	public static final long DRAW_BOUNDS_FCN_BYTE_OFFSET;
	public static final long DRAWING_BOUNDS_BYTE_OFFSET;
	public static final long FORCE_SCALE_BYTE_OFFSET;
	public static final long JOINT_SCALE_BYTE_OFFSET;
	public static final long DRAW_CONTACTS_BYTE_OFFSET;
	public static final long DRAW_ANCHOR_A_BYTE_OFFSET;
	public static final long DRAW_SHAPES_BYTE_OFFSET;
	public static final long DRAW_CHAIN_NORMALS_BYTE_OFFSET;
	public static final long DRAW_JOINTS_BYTE_OFFSET;
	public static final long DRAW_JOINT_EXTRAS_BYTE_OFFSET;
	public static final long DRAW_BOUNDS_BYTE_OFFSET;
	public static final long DRAW_MASS_BYTE_OFFSET;
	public static final long DRAW_BODY_NAMES_BYTE_OFFSET;
	public static final long DRAW_GRAPH_COLORS_BYTE_OFFSET;
	public static final long DRAW_CONTACT_FEATURES_BYTE_OFFSET;
	public static final long DRAW_CONTACT_NORMALS_BYTE_OFFSET;
	public static final long DRAW_CONTACT_FORCES_BYTE_OFFSET;
	public static final long DRAW_FRICTION_FORCES_BYTE_OFFSET;
	public static final long DRAW_ISLANDS_BYTE_OFFSET;
	public static final long CONTEXT_BYTE_OFFSET;

	private final MemorySegment segment;

	private final AABB drawingBounds;

	static {
		//@formatter:off
		LAYOUT = MemoryLayout.structLayout(
		    UNBOUNDED_ADDRESS.withName("DrawPolygonFcn"),
		    UNBOUNDED_ADDRESS.withName("DrawSolidPolygonFcn"),
		    UNBOUNDED_ADDRESS.withName("DrawCircleFcn"),
		    UNBOUNDED_ADDRESS.withName("DrawSolidCircleFcn"),
		    UNBOUNDED_ADDRESS.withName("DrawSolidCapsuleFcn"),
		    UNBOUNDED_ADDRESS.withName("DrawLineFcn"),
		    UNBOUNDED_ADDRESS.withName("DrawTransformFcn"),
		    UNBOUNDED_ADDRESS.withName("DrawPointFcn"),
		    UNBOUNDED_ADDRESS.withName("DrawStringFcn"),
		    UNBOUNDED_ADDRESS.withName("DrawBoundsFcn"),
		    AABB.LAYOUT.withName("drawingBounds"),
		    JAVA_FLOAT.withName("forceScale"),
		    JAVA_FLOAT.withName("jointScale"),
		    JAVA_BOOLEAN.withName("drawContacts"),
		    JAVA_BOOLEAN.withName("drawAnchorA"),
		    JAVA_BOOLEAN.withName("drawShapes"),
		    JAVA_BOOLEAN.withName("drawChainNormals"),
		    JAVA_BOOLEAN.withName("drawJoints"),
		    JAVA_BOOLEAN.withName("drawJointExtras"),
		    JAVA_BOOLEAN.withName("drawBounds"),
		    JAVA_BOOLEAN.withName("drawMass"),
		    JAVA_BOOLEAN.withName("drawBodyNames"),
		    JAVA_BOOLEAN.withName("drawGraphColors"),
		    JAVA_BOOLEAN.withName("drawContactFeatures"),
		    JAVA_BOOLEAN.withName("drawContactNormals"),
		    JAVA_BOOLEAN.withName("drawContactForces"),
		    JAVA_BOOLEAN.withName("drawFrictionForces"),
		    JAVA_BOOLEAN.withName("drawIslands"),
		    MemoryLayout.paddingLayout(1),
		    UNBOUNDED_ADDRESS.withName("context")
		).withName("b2DebugDraw").withByteAlignment(8);
		
		DRAW_POLYGON_FCN_HANDLE = LAYOUT.varHandle(PathElement.groupElement("DrawPolygonFcn"));
		DRAW_SOLID_POLYGON_FCN_HANDLE = LAYOUT.varHandle(PathElement.groupElement("DrawSolidPolygonFcn"));
		DRAW_CIRCLE_FCN_HANDLE = LAYOUT.varHandle(PathElement.groupElement("DrawCircleFcn"));
		DRAW_SOLID_CIRCLE_FCN_HANDLE = LAYOUT.varHandle(PathElement.groupElement("DrawSolidCircleFcn"));
		DRAW_SOLID_CAPSULE_FCN_HANDLE = LAYOUT.varHandle(PathElement.groupElement("DrawSolidCapsuleFcn"));
		DRAW_LINE_FCN_HANDLE = LAYOUT.varHandle(PathElement.groupElement("DrawLineFcn"));
		DRAW_TRANSFORM_FCN_HANDLE = LAYOUT.varHandle(PathElement.groupElement("DrawTransformFcn"));
		DRAW_POINT_FCN_HANDLE = LAYOUT.varHandle(PathElement.groupElement("DrawPointFcn"));
		DRAW_STRING_FCN_HANDLE = LAYOUT.varHandle(PathElement.groupElement("DrawStringFcn"));
		DRAW_BOUNDS_FCN_HANDLE = LAYOUT.varHandle(PathElement.groupElement("DrawBoundsFcn"));
		FORCE_SCALE_HANDLE = LAYOUT.varHandle(PathElement.groupElement("forceScale"));
		JOINT_SCALE_HANDLE = LAYOUT.varHandle(PathElement.groupElement("jointScale"));
		DRAW_CONTACTS_HANDLE = LAYOUT.varHandle(PathElement.groupElement("drawContacts"));
		DRAW_ANCHOR_A_HANDLE = LAYOUT.varHandle(PathElement.groupElement("drawAnchorA"));
		DRAW_SHAPES_HANDLE = LAYOUT.varHandle(PathElement.groupElement("drawShapes"));
		DRAW_CHAIN_NORMALS_HANDLE = LAYOUT.varHandle(PathElement.groupElement("drawChainNormals"));
		DRAW_JOINTS_HANDLE = LAYOUT.varHandle(PathElement.groupElement("drawJoints"));
		DRAW_JOINT_EXTRAS_HANDLE = LAYOUT.varHandle(PathElement.groupElement("drawJointExtras"));
		DRAW_BOUNDS_HANDLE = LAYOUT.varHandle(PathElement.groupElement("drawBounds"));
		DRAW_MASS_HANDLE = LAYOUT.varHandle(PathElement.groupElement("drawMass"));
		DRAW_BODY_NAMES_HANDLE = LAYOUT.varHandle(PathElement.groupElement("drawBodyNames"));
		DRAW_GRAPH_COLORS_HANDLE = LAYOUT.varHandle(PathElement.groupElement("drawGraphColors"));
		DRAW_CONTACT_FEATURES_HANDLE = LAYOUT.varHandle(PathElement.groupElement("drawContactFeatures"));
		DRAW_CONTACT_NORMALS_HANDLE = LAYOUT.varHandle(PathElement.groupElement("drawContactNormals"));
		DRAW_CONTACT_FORCES_HANDLE = LAYOUT.varHandle(PathElement.groupElement("drawContactForces"));
		DRAW_FRICTION_FORCES_HANDLE = LAYOUT.varHandle(PathElement.groupElement("drawFrictionForces"));
		DRAW_ISLANDS_HANDLE = LAYOUT.varHandle(PathElement.groupElement("drawIslands"));
		CONTEXT_HANDLE = LAYOUT.varHandle(PathElement.groupElement("context"));
		
		DRAW_POLYGON_FCN_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("DrawPolygonFcn"));
		DRAW_SOLID_POLYGON_FCN_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("DrawSolidPolygonFcn"));
		DRAW_CIRCLE_FCN_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("DrawCircleFcn"));
		DRAW_SOLID_CIRCLE_FCN_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("DrawSolidCircleFcn"));
		DRAW_SOLID_CAPSULE_FCN_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("DrawSolidCapsuleFcn"));
		DRAW_LINE_FCN_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("DrawLineFcn"));
		DRAW_TRANSFORM_FCN_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("DrawTransformFcn"));
		DRAW_POINT_FCN_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("DrawPointFcn"));
		DRAW_STRING_FCN_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("DrawStringFcn"));
		DRAW_BOUNDS_FCN_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("DrawBoundsFcn"));
		DRAWING_BOUNDS_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("drawingBounds"));
		FORCE_SCALE_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("forceScale"));
		JOINT_SCALE_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("jointScale"));
		DRAW_CONTACTS_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("drawContacts"));
		DRAW_ANCHOR_A_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("drawAnchorA"));
		DRAW_SHAPES_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("drawShapes"));
		DRAW_CHAIN_NORMALS_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("drawChainNormals"));
		DRAW_JOINTS_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("drawJoints"));
		DRAW_JOINT_EXTRAS_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("drawJointExtras"));
		DRAW_BOUNDS_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("drawBounds"));
		DRAW_MASS_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("drawMass"));
		DRAW_BODY_NAMES_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("drawBodyNames"));
		DRAW_GRAPH_COLORS_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("drawGraphColors"));
		DRAW_CONTACT_FEATURES_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("drawContactFeatures"));
		DRAW_CONTACT_NORMALS_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("drawContactNormals"));
		DRAW_CONTACT_FORCES_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("drawContactForces"));
		DRAW_FRICTION_FORCES_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("drawFrictionForces"));
		DRAW_ISLANDS_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("drawIslands"));
		CONTEXT_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("context"));
		//@formatter:on
	}

	public DebugDraw() {
	    this(Arena.ofAuto());
	}
	
	public DebugDraw(Arena arena) {
	    this(arena.allocate(LAYOUT));
	}
	
	public DebugDraw(MemorySegment segment) {
	    this.segment = segment;
	
	    drawingBounds = new AABB(segment.asSlice(DRAWING_BOUNDS_BYTE_OFFSET, AABB.LAYOUT));
	}

    /// @see #drawPolygonFcn()
    public DebugDraw drawPolygonFcn(DrawPolygonFcn drawPolygonFcn) {
    	DRAW_POLYGON_FCN_HANDLE.set(segment, 0L, drawPolygonFcn.memorySegment());
    	return this;
    }
    
    /// ```
    /// Draw a closed polygon provided in CCW order.
    /// ```
    public @Nullable DrawPolygonFcn drawPolygonFcn() {
    	MemorySegment segment = (MemorySegment) DRAW_POLYGON_FCN_HANDLE.get(this.segment, 0L);
    
    	if (segment.equals(MemorySegment.NULL))
    		return null;
    	
    	return DrawPolygonFcn.get(segment);
    }
    
    /// @see #drawSolidPolygonFcn()
    public DebugDraw drawSolidPolygonFcn(DrawSolidPolygonFcn drawSolidPolygonFcn) {
    	DRAW_SOLID_POLYGON_FCN_HANDLE.set(segment, 0L, drawSolidPolygonFcn.memorySegment());
    	return this;
    }
    
    /// ```
    /// Draw a solid closed polygon provided in CCW order.
    /// ```
    public @Nullable DrawSolidPolygonFcn drawSolidPolygonFcn() {
    	MemorySegment segment = (MemorySegment) DRAW_SOLID_POLYGON_FCN_HANDLE.get(this.segment, 0L);
    
    	if (segment.equals(MemorySegment.NULL))
    		return null;
    	
    	return DrawSolidPolygonFcn.get(segment);
    }
    
    /// @see #drawCircleFcn()
    public DebugDraw drawCircleFcn(DrawCircleFcn drawCircleFcn) {
    	DRAW_CIRCLE_FCN_HANDLE.set(segment, 0L, drawCircleFcn.memorySegment());
    	return this;
    }
    
    /// ```
    /// Draw a circle.
    /// ```
    public @Nullable DrawCircleFcn drawCircleFcn() {
    	MemorySegment segment = (MemorySegment) DRAW_CIRCLE_FCN_HANDLE.get(this.segment, 0L);
    
    	if (segment.equals(MemorySegment.NULL))
    		return null;
    	
    	return DrawCircleFcn.get(segment);
    }
    
    /// @see #drawSolidCircleFcn()
    public DebugDraw drawSolidCircleFcn(DrawSolidCircleFcn drawSolidCircleFcn) {
    	DRAW_SOLID_CIRCLE_FCN_HANDLE.set(segment, 0L, drawSolidCircleFcn.memorySegment());
    	return this;
    }
    
    /// ```
    /// Draw a solid circle.
    /// ```
    public @Nullable DrawSolidCircleFcn drawSolidCircleFcn() {
    	MemorySegment segment = (MemorySegment) DRAW_SOLID_CIRCLE_FCN_HANDLE.get(this.segment, 0L);
    
    	if (segment.equals(MemorySegment.NULL))
    		return null;
    	
    	return DrawSolidCircleFcn.get(segment);
    }
    
    /// @see #drawSolidCapsuleFcn()
    public DebugDraw drawSolidCapsuleFcn(DrawSolidCapsuleFcn drawSolidCapsuleFcn) {
    	DRAW_SOLID_CAPSULE_FCN_HANDLE.set(segment, 0L, drawSolidCapsuleFcn.memorySegment());
    	return this;
    }
    
    /// ```
    /// Draw a solid capsule.
    /// ```
    public @Nullable DrawSolidCapsuleFcn drawSolidCapsuleFcn() {
    	MemorySegment segment = (MemorySegment) DRAW_SOLID_CAPSULE_FCN_HANDLE.get(this.segment, 0L);
    
    	if (segment.equals(MemorySegment.NULL))
    		return null;
    	
    	return DrawSolidCapsuleFcn.get(segment);
    }
    
    /// @see #drawLineFcn()
    public DebugDraw drawLineFcn(DrawLineFcn drawLineFcn) {
    	DRAW_LINE_FCN_HANDLE.set(segment, 0L, drawLineFcn.memorySegment());
    	return this;
    }
    
    /// ```
    /// Draw a line segment.
    /// ```
    public @Nullable DrawLineFcn drawLineFcn() {
    	MemorySegment segment = (MemorySegment) DRAW_LINE_FCN_HANDLE.get(this.segment, 0L);
    
    	if (segment.equals(MemorySegment.NULL))
    		return null;
    	
    	return DrawLineFcn.get(segment);
    }
    
    /// @see #drawTransformFcn()
    public DebugDraw drawTransformFcn(DrawTransformFcn drawTransformFcn) {
    	DRAW_TRANSFORM_FCN_HANDLE.set(segment, 0L, drawTransformFcn.memorySegment());
    	return this;
    }
    
    /// ```
    /// Draw a transform. Choose your own length scale.
    /// ```
    public @Nullable DrawTransformFcn drawTransformFcn() {
    	MemorySegment segment = (MemorySegment) DRAW_TRANSFORM_FCN_HANDLE.get(this.segment, 0L);
    
    	if (segment.equals(MemorySegment.NULL))
    		return null;
    	
    	return DrawTransformFcn.get(segment);
    }
    
    /// @see #drawPointFcn()
    public DebugDraw drawPointFcn(DrawPointFcn drawPointFcn) {
    	DRAW_POINT_FCN_HANDLE.set(segment, 0L, drawPointFcn.memorySegment());
    	return this;
    }
    
    /// ```
    /// Draw a point.
    /// ```
    public @Nullable DrawPointFcn drawPointFcn() {
    	MemorySegment segment = (MemorySegment) DRAW_POINT_FCN_HANDLE.get(this.segment, 0L);
    
    	if (segment.equals(MemorySegment.NULL))
    		return null;
    	
    	return DrawPointFcn.get(segment);
    }
    
    /// @see #drawStringFcn()
    public DebugDraw drawStringFcn(DrawStringFcn drawStringFcn) {
    	DRAW_STRING_FCN_HANDLE.set(segment, 0L, drawStringFcn.memorySegment());
    	return this;
    }
    
    /// ```
    /// Draw a string in world space
    /// ```
    public @Nullable DrawStringFcn drawStringFcn() {
    	MemorySegment segment = (MemorySegment) DRAW_STRING_FCN_HANDLE.get(this.segment, 0L);
    
    	if (segment.equals(MemorySegment.NULL))
    		return null;
    	
    	return DrawStringFcn.get(segment);
    }
    
    /// @see #drawBoundsFcn()
    public DebugDraw drawBoundsFcn(DrawBoundsFcn drawBoundsFcn) {
    	DRAW_BOUNDS_FCN_HANDLE.set(segment, 0L, drawBoundsFcn.memorySegment());
    	return this;
    }
    
    /// ```
    /// Draw a bounding box. With double precision enabled, the single precision bounding box gets
    /// increasing padding when moving far from the origin.
    /// ```
    public @Nullable DrawBoundsFcn drawBoundsFcn() {
    	MemorySegment segment = (MemorySegment) DRAW_BOUNDS_FCN_HANDLE.get(this.segment, 0L);
    
    	if (segment.equals(MemorySegment.NULL))
    		return null;
    	
    	return DrawBoundsFcn.get(segment);
    }
    
    /// @see #drawingBounds()
    public DebugDraw drawingBounds(Consumer<AABB> consumer) {
    	consumer.accept(drawingBounds);
    	return this;
    }
    
    /// @see #drawingBounds()
    public DebugDraw drawingBounds(AABB other) {
    	drawingBounds.set(other);
    	return this;
    }
    
    /// ```
    /// World bounds used for debug draw. An empty box draws nothing.
    /// ```
    public AABB drawingBounds() {
    	return drawingBounds;
    }
    
    /// @see #forceScale()
    public DebugDraw forceScale(float forceScale) {
    	FORCE_SCALE_HANDLE.set(segment, 0L, forceScale);
    	return this;
    }
    
    /// ```
    /// Scale to use when drawing forces
    /// ```
    public float forceScale() {
    	return (float) FORCE_SCALE_HANDLE.get(segment, 0L);
    }
    
    /// @see #jointScale()
    public DebugDraw jointScale(float jointScale) {
    	JOINT_SCALE_HANDLE.set(segment, 0L, jointScale);
    	return this;
    }
    
    /// ```
    /// Global scaling for joint drawing
    /// ```
    public float jointScale() {
    	return (float) JOINT_SCALE_HANDLE.get(segment, 0L);
    }
    
    /// @see #drawContacts()
    public DebugDraw drawContacts(boolean drawContacts) {
    	DRAW_CONTACTS_HANDLE.set(segment, 0L, drawContacts);
    	return this;
    }
    
    /// ```
    /// Option to draw contact points
    /// ```
    public boolean drawContacts() {
    	return (boolean) DRAW_CONTACTS_HANDLE.get(segment, 0L);
    }
    
    /// @see #drawAnchorA()
    public DebugDraw drawAnchorA(boolean drawAnchorA) {
    	DRAW_ANCHOR_A_HANDLE.set(segment, 0L, drawAnchorA);
    	return this;
    }
    
    /// ```
    /// Draw anchor A for contact points (instead of anchorB)
    /// ```
    public boolean drawAnchorA() {
    	return (boolean) DRAW_ANCHOR_A_HANDLE.get(segment, 0L);
    }
    
    /// @see #drawShapes()
    public DebugDraw drawShapes(boolean drawShapes) {
    	DRAW_SHAPES_HANDLE.set(segment, 0L, drawShapes);
    	return this;
    }
    
    /// ```
    /// Option to draw shapes
    /// ```
    public boolean drawShapes() {
    	return (boolean) DRAW_SHAPES_HANDLE.get(segment, 0L);
    }
    
    /// @see #drawChainNormals()
    public DebugDraw drawChainNormals(boolean drawChainNormals) {
    	DRAW_CHAIN_NORMALS_HANDLE.set(segment, 0L, drawChainNormals);
    	return this;
    }
    
    /// ```
    /// Option to draw chain shape normals
    /// ```
    public boolean drawChainNormals() {
    	return (boolean) DRAW_CHAIN_NORMALS_HANDLE.get(segment, 0L);
    }
    
    /// @see #drawJoints()
    public DebugDraw drawJoints(boolean drawJoints) {
    	DRAW_JOINTS_HANDLE.set(segment, 0L, drawJoints);
    	return this;
    }
    
    /// ```
    /// Option to draw joints
    /// ```
    public boolean drawJoints() {
    	return (boolean) DRAW_JOINTS_HANDLE.get(segment, 0L);
    }
    
    /// @see #drawJointExtras()
    public DebugDraw drawJointExtras(boolean drawJointExtras) {
    	DRAW_JOINT_EXTRAS_HANDLE.set(segment, 0L, drawJointExtras);
    	return this;
    }
    
    /// ```
    /// Option to draw additional information for joints
    /// ```
    public boolean drawJointExtras() {
    	return (boolean) DRAW_JOINT_EXTRAS_HANDLE.get(segment, 0L);
    }
    
    /// @see #drawBounds()
    public DebugDraw drawBounds(boolean drawBounds) {
    	DRAW_BOUNDS_HANDLE.set(segment, 0L, drawBounds);
    	return this;
    }
    
    /// ```
    /// Option to draw the bounding boxes for shapes
    /// ```
    public boolean drawBounds() {
    	return (boolean) DRAW_BOUNDS_HANDLE.get(segment, 0L);
    }
    
    /// @see #drawMass()
    public DebugDraw drawMass(boolean drawMass) {
    	DRAW_MASS_HANDLE.set(segment, 0L, drawMass);
    	return this;
    }
    
    /// ```
    /// Option to draw the mass and center of mass of dynamic bodies
    /// ```
    public boolean drawMass() {
    	return (boolean) DRAW_MASS_HANDLE.get(segment, 0L);
    }
    
    /// @see #drawBodyNames()
    public DebugDraw drawBodyNames(boolean drawBodyNames) {
    	DRAW_BODY_NAMES_HANDLE.set(segment, 0L, drawBodyNames);
    	return this;
    }
    
    /// ```
    /// Option to draw body names
    /// ```
    public boolean drawBodyNames() {
    	return (boolean) DRAW_BODY_NAMES_HANDLE.get(segment, 0L);
    }
    
    /// @see #drawGraphColors()
    public DebugDraw drawGraphColors(boolean drawGraphColors) {
    	DRAW_GRAPH_COLORS_HANDLE.set(segment, 0L, drawGraphColors);
    	return this;
    }
    
    /// ```
    /// Option to visualize the graph coloring used for contacts and joints
    /// ```
    public boolean drawGraphColors() {
    	return (boolean) DRAW_GRAPH_COLORS_HANDLE.get(segment, 0L);
    }
    
    /// @see #drawContactFeatures()
    public DebugDraw drawContactFeatures(boolean drawContactFeatures) {
    	DRAW_CONTACT_FEATURES_HANDLE.set(segment, 0L, drawContactFeatures);
    	return this;
    }
    
    /// ```
    /// Option to draw contact feature ids
    /// ```
    public boolean drawContactFeatures() {
    	return (boolean) DRAW_CONTACT_FEATURES_HANDLE.get(segment, 0L);
    }
    
    /// @see #drawContactNormals()
    public DebugDraw drawContactNormals(boolean drawContactNormals) {
    	DRAW_CONTACT_NORMALS_HANDLE.set(segment, 0L, drawContactNormals);
    	return this;
    }
    
    /// ```
    /// Option to draw contact normals
    /// ```
    public boolean drawContactNormals() {
    	return (boolean) DRAW_CONTACT_NORMALS_HANDLE.get(segment, 0L);
    }
    
    /// @see #drawContactForces()
    public DebugDraw drawContactForces(boolean drawContactForces) {
    	DRAW_CONTACT_FORCES_HANDLE.set(segment, 0L, drawContactForces);
    	return this;
    }
    
    /// ```
    /// Option to draw contact normal forces
    /// ```
    public boolean drawContactForces() {
    	return (boolean) DRAW_CONTACT_FORCES_HANDLE.get(segment, 0L);
    }
    
    /// @see #drawFrictionForces()
    public DebugDraw drawFrictionForces(boolean drawFrictionForces) {
    	DRAW_FRICTION_FORCES_HANDLE.set(segment, 0L, drawFrictionForces);
    	return this;
    }
    
    /// ```
    /// Option to draw contact friction forces
    /// ```
    public boolean drawFrictionForces() {
    	return (boolean) DRAW_FRICTION_FORCES_HANDLE.get(segment, 0L);
    }
    
    /// @see #drawIslands()
    public DebugDraw drawIslands(boolean drawIslands) {
    	DRAW_ISLANDS_HANDLE.set(segment, 0L, drawIslands);
    	return this;
    }
    
    /// ```
    /// Option to draw islands as bounding boxes
    /// ```
    public boolean drawIslands() {
    	return (boolean) DRAW_ISLANDS_HANDLE.get(segment, 0L);
    }
    
    /// @see #context()
    public DebugDraw context(MemorySegment context) {
    	CONTEXT_HANDLE.set(segment, 0L, context);
    	return this;
    }
    
    /// ```
    /// User context that is passed as an argument to drawing callback functions
    /// ```
    public @Nullable MemorySegment context() {
    	MemorySegment segment = (MemorySegment) CONTEXT_HANDLE.get(this.segment, 0L);
    
    	if (segment.equals(MemorySegment.NULL))
    		return null;
    	
    	return segment;
    }
    
    @Override
    public DebugDraw set(DebugDraw other) {
        return set(other.segment);
    }
    
    @Override
    public DebugDraw set(MemorySegment src) {
        MemorySegment.copy(src, 0L, segment, 0L, LAYOUT.byteSize());
        return this;
    }
    
    @Override
    public MemorySegment memorySegment() {
        return segment;
    }
    
    public NativeStructArray<DebugDraw> asArray() {
        return new NativeStructArray<>(this);
    }
    
    public static NativeStructArray<DebugDraw> array(Arena arena, int count) {
        return new NativeStructArray<>(
            arena,
            LAYOUT,
            segment -> new DebugDraw(segment),
            count
        );
    }
    
    public static NativeStructArray<DebugDraw> array(Arena arena, DebugDraw... structs) {
        NativeStructArray<DebugDraw> array = new NativeStructArray<>(
            arena,
            LAYOUT,
            segment -> new DebugDraw(segment),
            structs.length
        );
    
        for (int i = 0; i < structs.length; i++) {
            array.set(i, structs[i]);
        }
    
        return array;
    }
    
    public static NativeStructArray<DebugDraw> array(MemorySegment array) {
        return new NativeStructArray<>(
            array,
            LAYOUT,
            segment -> new DebugDraw(segment)
        );
    }

}