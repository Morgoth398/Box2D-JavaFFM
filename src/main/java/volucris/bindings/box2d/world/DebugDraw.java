/*
 * MACHINE GENERATED FILE, DO NOT EDIT.
 */
package volucris.bindings.box2d.world;

import edu.umd.cs.findbugs.annotations.Nullable;
import java.lang.foreign.Arena;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.StructLayout;
import java.lang.invoke.VarHandle;
import java.util.function.Consumer;
import volucris.bindings.box2d.math.AABB;
import volucris.bindings.core.NativeStructArray;
import volucris.bindings.core.Struct;

import static java.lang.foreign.ValueLayout.*;
import static volucris.bindings.core.FFMUtils.*;

/**
 * This struct holds callbacks you can implement to draw a Box2D world. This structure should be zero initialized.
 */
public final class DebugDraw
		implements Struct<DebugDraw> {

    public static final StructLayout LAYOUT;

    public static final VarHandle DRAW_POLYGON_FCN;
    public static final VarHandle DRAW_SOLID_POLYGON_FCN;
    public static final VarHandle DRAW_CIRCLE_FCN;
    public static final VarHandle DRAW_SOLID_CIRCLE_FCN;
    public static final VarHandle DRAW_SOLID_CAPSULE_FCN;
    public static final VarHandle DRAW_SEGMENT_FCN;
    public static final VarHandle DRAW_TRANSFORM_FCN;
    public static final VarHandle DRAW_POINT_FCN;
    public static final VarHandle DRAW_STRING_FCN;
    public static final VarHandle USE_DRAWING_BOUNDS;
    public static final VarHandle DRAW_SHAPES;
    public static final VarHandle DRAW_JOINTS;
    public static final VarHandle DRAW_JOINT_EXTRAS;
    public static final VarHandle DRAW_BOUNDS;
    public static final VarHandle DRAW_MASS;
    public static final VarHandle DRAW_BODY_NAMES;
    public static final VarHandle DRAW_CONTACTS;
    public static final VarHandle DRAW_GRAPH_COLORS;
    public static final VarHandle DRAW_CONTACT_NORMALS;
    public static final VarHandle DRAW_CONTACT_IMPULSES;
    public static final VarHandle DRAW_CONTACT_FEATURES;
    public static final VarHandle DRAW_FRICTION_IMPULSES;
    public static final VarHandle DRAW_ISLANDS;
    public static final VarHandle CONTEXT;

    public static final long DRAW_POLYGON_FCN_OFFSET;
    public static final long DRAW_SOLID_POLYGON_FCN_OFFSET;
    public static final long DRAW_CIRCLE_FCN_OFFSET;
    public static final long DRAW_SOLID_CIRCLE_FCN_OFFSET;
    public static final long DRAW_SOLID_CAPSULE_FCN_OFFSET;
    public static final long DRAW_SEGMENT_FCN_OFFSET;
    public static final long DRAW_TRANSFORM_FCN_OFFSET;
    public static final long DRAW_POINT_FCN_OFFSET;
    public static final long DRAW_STRING_FCN_OFFSET;
    public static final long DRAWING_BOUNDS_OFFSET;
    public static final long USE_DRAWING_BOUNDS_OFFSET;
    public static final long DRAW_SHAPES_OFFSET;
    public static final long DRAW_JOINTS_OFFSET;
    public static final long DRAW_JOINT_EXTRAS_OFFSET;
    public static final long DRAW_BOUNDS_OFFSET;
    public static final long DRAW_MASS_OFFSET;
    public static final long DRAW_BODY_NAMES_OFFSET;
    public static final long DRAW_CONTACTS_OFFSET;
    public static final long DRAW_GRAPH_COLORS_OFFSET;
    public static final long DRAW_CONTACT_NORMALS_OFFSET;
    public static final long DRAW_CONTACT_IMPULSES_OFFSET;
    public static final long DRAW_CONTACT_FEATURES_OFFSET;
    public static final long DRAW_FRICTION_IMPULSES_OFFSET;
    public static final long DRAW_ISLANDS_OFFSET;
    public static final long CONTEXT_OFFSET;

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
            UNBOUNDED_ADDRESS.withName("DrawSegmentFcn"),
            UNBOUNDED_ADDRESS.withName("DrawTransformFcn"),
            UNBOUNDED_ADDRESS.withName("DrawPointFcn"),
            UNBOUNDED_ADDRESS.withName("DrawStringFcn"),
            AABB.LAYOUT.withName("drawingBounds"),
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
            UNBOUNDED_ADDRESS.withName("context")
        ).withName("b2DebugDraw").withByteAlignment(8);
        
        DRAW_POLYGON_FCN = LAYOUT.varHandle(PathElement.groupElement("DrawPolygonFcn"));
        DRAW_SOLID_POLYGON_FCN = LAYOUT.varHandle(PathElement.groupElement("DrawSolidPolygonFcn"));
        DRAW_CIRCLE_FCN = LAYOUT.varHandle(PathElement.groupElement("DrawCircleFcn"));
        DRAW_SOLID_CIRCLE_FCN = LAYOUT.varHandle(PathElement.groupElement("DrawSolidCircleFcn"));
        DRAW_SOLID_CAPSULE_FCN = LAYOUT.varHandle(PathElement.groupElement("DrawSolidCapsuleFcn"));
        DRAW_SEGMENT_FCN = LAYOUT.varHandle(PathElement.groupElement("DrawSegmentFcn"));
        DRAW_TRANSFORM_FCN = LAYOUT.varHandle(PathElement.groupElement("DrawTransformFcn"));
        DRAW_POINT_FCN = LAYOUT.varHandle(PathElement.groupElement("DrawPointFcn"));
        DRAW_STRING_FCN = LAYOUT.varHandle(PathElement.groupElement("DrawStringFcn"));
        USE_DRAWING_BOUNDS = LAYOUT.varHandle(PathElement.groupElement("useDrawingBounds"));
        DRAW_SHAPES = LAYOUT.varHandle(PathElement.groupElement("drawShapes"));
        DRAW_JOINTS = LAYOUT.varHandle(PathElement.groupElement("drawJoints"));
        DRAW_JOINT_EXTRAS = LAYOUT.varHandle(PathElement.groupElement("drawJointExtras"));
        DRAW_BOUNDS = LAYOUT.varHandle(PathElement.groupElement("drawBounds"));
        DRAW_MASS = LAYOUT.varHandle(PathElement.groupElement("drawMass"));
        DRAW_BODY_NAMES = LAYOUT.varHandle(PathElement.groupElement("drawBodyNames"));
        DRAW_CONTACTS = LAYOUT.varHandle(PathElement.groupElement("drawContacts"));
        DRAW_GRAPH_COLORS = LAYOUT.varHandle(PathElement.groupElement("drawGraphColors"));
        DRAW_CONTACT_NORMALS = LAYOUT.varHandle(PathElement.groupElement("drawContactNormals"));
        DRAW_CONTACT_IMPULSES = LAYOUT.varHandle(PathElement.groupElement("drawContactImpulses"));
        DRAW_CONTACT_FEATURES = LAYOUT.varHandle(PathElement.groupElement("drawContactFeatures"));
        DRAW_FRICTION_IMPULSES = LAYOUT.varHandle(PathElement.groupElement("drawFrictionImpulses"));
        DRAW_ISLANDS = LAYOUT.varHandle(PathElement.groupElement("drawIslands"));
        CONTEXT = LAYOUT.varHandle(PathElement.groupElement("context"));
        
        DRAW_POLYGON_FCN_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("DrawPolygonFcn"));
        DRAW_SOLID_POLYGON_FCN_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("DrawSolidPolygonFcn"));
        DRAW_CIRCLE_FCN_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("DrawCircleFcn"));
        DRAW_SOLID_CIRCLE_FCN_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("DrawSolidCircleFcn"));
        DRAW_SOLID_CAPSULE_FCN_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("DrawSolidCapsuleFcn"));
        DRAW_SEGMENT_FCN_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("DrawSegmentFcn"));
        DRAW_TRANSFORM_FCN_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("DrawTransformFcn"));
        DRAW_POINT_FCN_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("DrawPointFcn"));
        DRAW_STRING_FCN_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("DrawStringFcn"));
        DRAWING_BOUNDS_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("drawingBounds"));
        USE_DRAWING_BOUNDS_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("useDrawingBounds"));
        DRAW_SHAPES_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("drawShapes"));
        DRAW_JOINTS_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("drawJoints"));
        DRAW_JOINT_EXTRAS_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("drawJointExtras"));
        DRAW_BOUNDS_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("drawBounds"));
        DRAW_MASS_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("drawMass"));
        DRAW_BODY_NAMES_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("drawBodyNames"));
        DRAW_CONTACTS_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("drawContacts"));
        DRAW_GRAPH_COLORS_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("drawGraphColors"));
        DRAW_CONTACT_NORMALS_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("drawContactNormals"));
        DRAW_CONTACT_IMPULSES_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("drawContactImpulses"));
        DRAW_CONTACT_FEATURES_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("drawContactFeatures"));
        DRAW_FRICTION_IMPULSES_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("drawFrictionImpulses"));
        DRAW_ISLANDS_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("drawIslands"));
        CONTEXT_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("context"));
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
    
        drawingBounds = new AABB(segment.asSlice(DRAWING_BOUNDS_OFFSET, AABB.LAYOUT));
    }

    public DebugDraw drawPolygonFcn(DrawPolygonFcn drawPolygonFcn) {
        DRAW_POLYGON_FCN.set(segment, 0L, drawPolygonFcn.memorySegment());
        return this;
    }
    
    public @Nullable DrawPolygonFcn drawPolygonFcn() {
        MemorySegment segment = (MemorySegment) DRAW_POLYGON_FCN.get(this.segment, 0L);
    
        if (segment.equals(MemorySegment.NULL))
            return null;
    
        return DrawPolygonFcn.get(segment);
    }
    
    public DebugDraw drawSolidPolygonFcn(DrawSolidPolygonFcn drawSolidPolygonFcn) {
        DRAW_SOLID_POLYGON_FCN.set(segment, 0L, drawSolidPolygonFcn.memorySegment());
        return this;
    }
    
    public @Nullable DrawSolidPolygonFcn drawSolidPolygonFcn() {
        MemorySegment segment = (MemorySegment) DRAW_SOLID_POLYGON_FCN.get(this.segment, 0L);
    
        if (segment.equals(MemorySegment.NULL))
            return null;
    
        return DrawSolidPolygonFcn.get(segment);
    }
    
    public DebugDraw drawCircleFcn(DrawCircleFcn drawCircleFcn) {
        DRAW_CIRCLE_FCN.set(segment, 0L, drawCircleFcn.memorySegment());
        return this;
    }
    
    public @Nullable DrawCircleFcn drawCircleFcn() {
        MemorySegment segment = (MemorySegment) DRAW_CIRCLE_FCN.get(this.segment, 0L);
    
        if (segment.equals(MemorySegment.NULL))
            return null;
    
        return DrawCircleFcn.get(segment);
    }
    
    public DebugDraw drawSolidCircleFcn(DrawSolidCircleFcn drawSolidCircleFcn) {
        DRAW_SOLID_CIRCLE_FCN.set(segment, 0L, drawSolidCircleFcn.memorySegment());
        return this;
    }
    
    public @Nullable DrawSolidCircleFcn drawSolidCircleFcn() {
        MemorySegment segment = (MemorySegment) DRAW_SOLID_CIRCLE_FCN.get(this.segment, 0L);
    
        if (segment.equals(MemorySegment.NULL))
            return null;
    
        return DrawSolidCircleFcn.get(segment);
    }
    
    public DebugDraw drawSolidCapsuleFcn(DrawSolidCapsuleFcn drawSolidCapsuleFcn) {
        DRAW_SOLID_CAPSULE_FCN.set(segment, 0L, drawSolidCapsuleFcn.memorySegment());
        return this;
    }
    
    public @Nullable DrawSolidCapsuleFcn drawSolidCapsuleFcn() {
        MemorySegment segment = (MemorySegment) DRAW_SOLID_CAPSULE_FCN.get(this.segment, 0L);
    
        if (segment.equals(MemorySegment.NULL))
            return null;
    
        return DrawSolidCapsuleFcn.get(segment);
    }
    
    public DebugDraw drawSegmentFcn(DrawSegmentFcn drawSegmentFcn) {
        DRAW_SEGMENT_FCN.set(segment, 0L, drawSegmentFcn.memorySegment());
        return this;
    }
    
    public @Nullable DrawSegmentFcn drawSegmentFcn() {
        MemorySegment segment = (MemorySegment) DRAW_SEGMENT_FCN.get(this.segment, 0L);
    
        if (segment.equals(MemorySegment.NULL))
            return null;
    
        return DrawSegmentFcn.get(segment);
    }
    
    public DebugDraw drawTransformFcn(DrawTransformFcn drawTransformFcn) {
        DRAW_TRANSFORM_FCN.set(segment, 0L, drawTransformFcn.memorySegment());
        return this;
    }
    
    public @Nullable DrawTransformFcn drawTransformFcn() {
        MemorySegment segment = (MemorySegment) DRAW_TRANSFORM_FCN.get(this.segment, 0L);
    
        if (segment.equals(MemorySegment.NULL))
            return null;
    
        return DrawTransformFcn.get(segment);
    }
    
    public DebugDraw drawPointFcn(DrawPointFcn drawPointFcn) {
        DRAW_POINT_FCN.set(segment, 0L, drawPointFcn.memorySegment());
        return this;
    }
    
    public @Nullable DrawPointFcn drawPointFcn() {
        MemorySegment segment = (MemorySegment) DRAW_POINT_FCN.get(this.segment, 0L);
    
        if (segment.equals(MemorySegment.NULL))
            return null;
    
        return DrawPointFcn.get(segment);
    }
    
    public DebugDraw drawStringFcn(DrawStringFcn drawStringFcn) {
        DRAW_STRING_FCN.set(segment, 0L, drawStringFcn.memorySegment());
        return this;
    }
    
    public @Nullable DrawStringFcn drawStringFcn() {
        MemorySegment segment = (MemorySegment) DRAW_STRING_FCN.get(this.segment, 0L);
    
        if (segment.equals(MemorySegment.NULL))
            return null;
    
        return DrawStringFcn.get(segment);
    }
    
    public DebugDraw useDrawingBounds(boolean useDrawingBounds) {
        USE_DRAWING_BOUNDS.set(segment, 0L, useDrawingBounds);
        return this;
    }
    
    public boolean useDrawingBounds() {
        return (boolean) USE_DRAWING_BOUNDS.get(segment, 0L);
    }
    
    public DebugDraw drawShapes(boolean drawShapes) {
        DRAW_SHAPES.set(segment, 0L, drawShapes);
        return this;
    }
    
    public boolean drawShapes() {
        return (boolean) DRAW_SHAPES.get(segment, 0L);
    }
    
    public DebugDraw drawJoints(boolean drawJoints) {
        DRAW_JOINTS.set(segment, 0L, drawJoints);
        return this;
    }
    
    public boolean drawJoints() {
        return (boolean) DRAW_JOINTS.get(segment, 0L);
    }
    
    public DebugDraw drawJointExtras(boolean drawJointExtras) {
        DRAW_JOINT_EXTRAS.set(segment, 0L, drawJointExtras);
        return this;
    }
    
    public boolean drawJointExtras() {
        return (boolean) DRAW_JOINT_EXTRAS.get(segment, 0L);
    }
    
    public DebugDraw drawBounds(boolean drawBounds) {
        DRAW_BOUNDS.set(segment, 0L, drawBounds);
        return this;
    }
    
    public boolean drawBounds() {
        return (boolean) DRAW_BOUNDS.get(segment, 0L);
    }
    
    public DebugDraw drawMass(boolean drawMass) {
        DRAW_MASS.set(segment, 0L, drawMass);
        return this;
    }
    
    public boolean drawMass() {
        return (boolean) DRAW_MASS.get(segment, 0L);
    }
    
    public DebugDraw drawBodyNames(boolean drawBodyNames) {
        DRAW_BODY_NAMES.set(segment, 0L, drawBodyNames);
        return this;
    }
    
    public boolean drawBodyNames() {
        return (boolean) DRAW_BODY_NAMES.get(segment, 0L);
    }
    
    public DebugDraw drawContacts(boolean drawContacts) {
        DRAW_CONTACTS.set(segment, 0L, drawContacts);
        return this;
    }
    
    public boolean drawContacts() {
        return (boolean) DRAW_CONTACTS.get(segment, 0L);
    }
    
    public DebugDraw drawGraphColors(boolean drawGraphColors) {
        DRAW_GRAPH_COLORS.set(segment, 0L, drawGraphColors);
        return this;
    }
    
    public boolean drawGraphColors() {
        return (boolean) DRAW_GRAPH_COLORS.get(segment, 0L);
    }
    
    public DebugDraw drawContactNormals(boolean drawContactNormals) {
        DRAW_CONTACT_NORMALS.set(segment, 0L, drawContactNormals);
        return this;
    }
    
    public boolean drawContactNormals() {
        return (boolean) DRAW_CONTACT_NORMALS.get(segment, 0L);
    }
    
    public DebugDraw drawContactImpulses(boolean drawContactImpulses) {
        DRAW_CONTACT_IMPULSES.set(segment, 0L, drawContactImpulses);
        return this;
    }
    
    public boolean drawContactImpulses() {
        return (boolean) DRAW_CONTACT_IMPULSES.get(segment, 0L);
    }
    
    public DebugDraw drawContactFeatures(boolean drawContactFeatures) {
        DRAW_CONTACT_FEATURES.set(segment, 0L, drawContactFeatures);
        return this;
    }
    
    public boolean drawContactFeatures() {
        return (boolean) DRAW_CONTACT_FEATURES.get(segment, 0L);
    }
    
    public DebugDraw drawFrictionImpulses(boolean drawFrictionImpulses) {
        DRAW_FRICTION_IMPULSES.set(segment, 0L, drawFrictionImpulses);
        return this;
    }
    
    public boolean drawFrictionImpulses() {
        return (boolean) DRAW_FRICTION_IMPULSES.get(segment, 0L);
    }
    
    public DebugDraw drawIslands(boolean drawIslands) {
        DRAW_ISLANDS.set(segment, 0L, drawIslands);
        return this;
    }
    
    public boolean drawIslands() {
        return (boolean) DRAW_ISLANDS.get(segment, 0L);
    }
    
    public DebugDraw context(MemorySegment context) {
        CONTEXT.set(segment, 0L, context);
        return this;
    }
    
    public @Nullable MemorySegment context() {
        MemorySegment segment = (MemorySegment) CONTEXT.get(this.segment, 0L);
    
        if (segment.equals(MemorySegment.NULL))
            return null;
    
        return segment;
    }
    
    public DebugDraw drawingBounds(Consumer<AABB> consumer) {
        consumer.accept(drawingBounds);
        return this;
    }
    
    public DebugDraw drawingBounds(AABB other) {
        drawingBounds.set(other);
        return this;
    }
    
    public AABB drawingBounds() {
        return drawingBounds;
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