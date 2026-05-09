/*
 * MACHINE GENERATED FILE, DO NOT EDIT.
 */
package volucris.bindings.box2d.world;

import java.lang.foreign.Arena;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.StructLayout;
import java.lang.invoke.VarHandle;
import volucris.bindings.core.NativeStructArray;
import volucris.bindings.core.Struct;

import static java.lang.foreign.ValueLayout.*;

/**
 * Counters that give details of the simulation size.
 */
public final class Counters
		implements Struct<Counters> {

    public static final StructLayout LAYOUT;

    public static final VarHandle BODY_COUNT_HANDLE;
    public static final VarHandle SHAPE_COUNT_HANDLE;
    public static final VarHandle CONTACT_COUNT_HANDLE;
    public static final VarHandle JOINT_COUNT_HANDLE;
    public static final VarHandle ISLAND_COUNT_HANDLE;
    public static final VarHandle STACK_USED_HANDLE;
    public static final VarHandle STATIC_TREE_HEIGHT_HANDLE;
    public static final VarHandle TREE_HEIGHT_HANDLE;
    public static final VarHandle BYTE_COUNT_HANDLE;
    public static final VarHandle TASK_COUNT_HANDLE;
    public static final VarHandle COLOR_COUNTS_HANDLE;

    public static final long BODY_COUNT_BYTE_OFFSET;
    public static final long SHAPE_COUNT_BYTE_OFFSET;
    public static final long CONTACT_COUNT_BYTE_OFFSET;
    public static final long JOINT_COUNT_BYTE_OFFSET;
    public static final long ISLAND_COUNT_BYTE_OFFSET;
    public static final long STACK_USED_BYTE_OFFSET;
    public static final long STATIC_TREE_HEIGHT_BYTE_OFFSET;
    public static final long TREE_HEIGHT_BYTE_OFFSET;
    public static final long BYTE_COUNT_BYTE_OFFSET;
    public static final long TASK_COUNT_BYTE_OFFSET;
    public static final long COLOR_COUNTS_BYTE_OFFSET;

    private final MemorySegment segment;

    static {
        //@formatter:off
        LAYOUT = MemoryLayout.structLayout(
            JAVA_INT.withName("bodyCount"),
            JAVA_INT.withName("shapeCount"),
            JAVA_INT.withName("contactCount"),
            JAVA_INT.withName("jointCount"),
            JAVA_INT.withName("islandCount"),
            JAVA_INT.withName("stackUsed"),
            JAVA_INT.withName("staticTreeHeight"),
            JAVA_INT.withName("treeHeight"),
            JAVA_INT.withName("byteCount"),
            JAVA_INT.withName("taskCount"),
            MemoryLayout.sequenceLayout(12, JAVA_INT).withName("colorCounts")
        ).withName("b2Counters").withByteAlignment(4);
        
        BODY_COUNT_HANDLE = LAYOUT.varHandle(PathElement.groupElement("bodyCount"));
        SHAPE_COUNT_HANDLE = LAYOUT.varHandle(PathElement.groupElement("shapeCount"));
        CONTACT_COUNT_HANDLE = LAYOUT.varHandle(PathElement.groupElement("contactCount"));
        JOINT_COUNT_HANDLE = LAYOUT.varHandle(PathElement.groupElement("jointCount"));
        ISLAND_COUNT_HANDLE = LAYOUT.varHandle(PathElement.groupElement("islandCount"));
        STACK_USED_HANDLE = LAYOUT.varHandle(PathElement.groupElement("stackUsed"));
        STATIC_TREE_HEIGHT_HANDLE = LAYOUT.varHandle(PathElement.groupElement("staticTreeHeight"));
        TREE_HEIGHT_HANDLE = LAYOUT.varHandle(PathElement.groupElement("treeHeight"));
        BYTE_COUNT_HANDLE = LAYOUT.varHandle(PathElement.groupElement("byteCount"));
        TASK_COUNT_HANDLE = LAYOUT.varHandle(PathElement.groupElement("taskCount"));
        COLOR_COUNTS_HANDLE = LAYOUT.varHandle(PathElement.groupElement("colorCounts"), PathElement.sequenceElement());
        
        BODY_COUNT_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("bodyCount"));
        SHAPE_COUNT_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("shapeCount"));
        CONTACT_COUNT_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("contactCount"));
        JOINT_COUNT_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("jointCount"));
        ISLAND_COUNT_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("islandCount"));
        STACK_USED_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("stackUsed"));
        STATIC_TREE_HEIGHT_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("staticTreeHeight"));
        TREE_HEIGHT_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("treeHeight"));
        BYTE_COUNT_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("byteCount"));
        TASK_COUNT_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("taskCount"));
        COLOR_COUNTS_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("colorCounts"));
        //@formatter:on
    }

    public Counters() {
        this(Arena.ofAuto());
    }
    
    public Counters(Arena arena) {
        this(arena.allocate(LAYOUT));
    }
    
    public Counters(MemorySegment segment) {
        this.segment = segment;
    
    }

    public Counters bodyCount(int bodyCount) {
        BODY_COUNT_HANDLE.set(segment, 0L, bodyCount);
        return this;
    }
    
    public int bodyCount() {
        return (int) BODY_COUNT_HANDLE.get(segment, 0L);
    }
    
    public Counters shapeCount(int shapeCount) {
        SHAPE_COUNT_HANDLE.set(segment, 0L, shapeCount);
        return this;
    }
    
    public int shapeCount() {
        return (int) SHAPE_COUNT_HANDLE.get(segment, 0L);
    }
    
    public Counters contactCount(int contactCount) {
        CONTACT_COUNT_HANDLE.set(segment, 0L, contactCount);
        return this;
    }
    
    public int contactCount() {
        return (int) CONTACT_COUNT_HANDLE.get(segment, 0L);
    }
    
    public Counters jointCount(int jointCount) {
        JOINT_COUNT_HANDLE.set(segment, 0L, jointCount);
        return this;
    }
    
    public int jointCount() {
        return (int) JOINT_COUNT_HANDLE.get(segment, 0L);
    }
    
    public Counters islandCount(int islandCount) {
        ISLAND_COUNT_HANDLE.set(segment, 0L, islandCount);
        return this;
    }
    
    public int islandCount() {
        return (int) ISLAND_COUNT_HANDLE.get(segment, 0L);
    }
    
    public Counters stackUsed(int stackUsed) {
        STACK_USED_HANDLE.set(segment, 0L, stackUsed);
        return this;
    }
    
    public int stackUsed() {
        return (int) STACK_USED_HANDLE.get(segment, 0L);
    }
    
    public Counters staticTreeHeight(int staticTreeHeight) {
        STATIC_TREE_HEIGHT_HANDLE.set(segment, 0L, staticTreeHeight);
        return this;
    }
    
    public int staticTreeHeight() {
        return (int) STATIC_TREE_HEIGHT_HANDLE.get(segment, 0L);
    }
    
    public Counters treeHeight(int treeHeight) {
        TREE_HEIGHT_HANDLE.set(segment, 0L, treeHeight);
        return this;
    }
    
    public int treeHeight() {
        return (int) TREE_HEIGHT_HANDLE.get(segment, 0L);
    }
    
    public Counters byteCount(int byteCount) {
        BYTE_COUNT_HANDLE.set(segment, 0L, byteCount);
        return this;
    }
    
    public int byteCount() {
        return (int) BYTE_COUNT_HANDLE.get(segment, 0L);
    }
    
    public Counters taskCount(int taskCount) {
        TASK_COUNT_HANDLE.set(segment, 0L, taskCount);
        return this;
    }
    
    public int taskCount() {
        return (int) TASK_COUNT_HANDLE.get(segment, 0L);
    }
    
    public Counters colorCounts(int colorCounts, long index) {
        COLOR_COUNTS_HANDLE.set(segment, 0L, index, colorCounts);
        return this;
    }
    
    public int colorCounts(long index) {
        return (int) COLOR_COUNTS_HANDLE.get(segment, 0L, index);
    }
    
    @Override
    public Counters set(Counters other) {
        return set(other.segment);
    }
    
    @Override
    public Counters set(MemorySegment src) {
        MemorySegment.copy(src, 0L, segment, 0L, LAYOUT.byteSize());
        return this;
    }
    
    @Override
    public MemorySegment memorySegment() {
        return segment;
    }
    
    public NativeStructArray<Counters> asArray() {
        return new NativeStructArray<>(this);
    }
    
    public static NativeStructArray<Counters> array(Arena arena, int count) {
        return new NativeStructArray<>(
            arena,
            LAYOUT,
            segment -> new Counters(segment),
            count
        );
    }
    
    public static NativeStructArray<Counters> array(Arena arena, Counters... structs) {
        NativeStructArray<Counters> array = new NativeStructArray<>(
            arena,
            LAYOUT,
            segment -> new Counters(segment),
            structs.length
        );
    
        for (int i = 0; i < structs.length; i++) {
            array.set(i, structs[i]);
        }
    
        return array;
    }
    
    public static NativeStructArray<Counters> array(MemorySegment array) {
        return new NativeStructArray<>(
            array,
            LAYOUT,
            segment -> new Counters(segment)
        );
    }
    
}