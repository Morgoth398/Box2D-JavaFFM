/*
 * MACHINE GENERATED FILE, DO NOT EDIT.
 */
package volucris.bindings.box2d.events;

import java.lang.foreign.Arena;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.SegmentAllocator;
import java.lang.foreign.StructLayout;
import java.lang.invoke.MethodHandle;
import java.util.function.Consumer;
import org.jspecify.annotations.Nullable;
import volucris.bindings.box2d.collision.Manifold;
import volucris.bindings.box2d.shape.ShapeId;
import volucris.bindings.core.NativeStructArray;
import volucris.bindings.core.Struct;

import static java.lang.foreign.ValueLayout.*;
import static volucris.bindings.core.FFMUtils.*;

/// ```
/// The contact data for two shapes. By convention the manifold normal points from shape A to shape
/// B.
/// @see b2Shape_GetContactData() and b2Body_GetContactData()
/// @ingroup contact
/// ```
public final class ContactData
		implements Struct<ContactData> {

	private static final LazyConstant<MethodHandle> B2_CONTACT_IS_VALID;
	private static final LazyConstant<MethodHandle> B2_CONTACT_GET_DATA;

	public static final StructLayout LAYOUT;

	public static final long CONTACT_ID_BYTE_OFFSET;
	public static final long SHAPE_ID_A_BYTE_OFFSET;
	public static final long SHAPE_ID_B_BYTE_OFFSET;
	public static final long MANIFOLD_BYTE_OFFSET;

	private final MemorySegment segment;

	private final ContactId contactId;
	private final ShapeId shapeIdA;
	private final ShapeId shapeIdB;
	private final Manifold manifold;

	static {
		//@formatter:off
		LAYOUT = MemoryLayout.structLayout(
		    ContactId.LAYOUT.withName("contactId"),
		    ShapeId.LAYOUT.withName("shapeIdA"),
		    ShapeId.LAYOUT.withName("shapeIdB"),
		    Manifold.LAYOUT.withName("manifold")
		).withName("b2ContactData").withByteAlignment(4);
		
		B2_CONTACT_IS_VALID = downcallHandle("b2Contact_IsValid", JAVA_BOOLEAN, ContactId.LAYOUT);
		B2_CONTACT_GET_DATA = downcallHandle("b2Contact_GetData", ContactData.LAYOUT, ContactId.LAYOUT);
		
		CONTACT_ID_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("contactId"));
		SHAPE_ID_A_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("shapeIdA"));
		SHAPE_ID_B_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("shapeIdB"));
		MANIFOLD_BYTE_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("manifold"));
		//@formatter:on
	}

	public ContactData() {
	    this(Arena.ofAuto());
	}
	
	public ContactData(Arena arena) {
	    this(arena.allocate(LAYOUT));
	}
	
	public ContactData(MemorySegment segment) {
	    this.segment = segment;
	
	    contactId = new ContactId(segment.asSlice(CONTACT_ID_BYTE_OFFSET, ContactId.LAYOUT));
	    shapeIdA = new ShapeId(segment.asSlice(SHAPE_ID_A_BYTE_OFFSET, ShapeId.LAYOUT));
	    shapeIdB = new ShapeId(segment.asSlice(SHAPE_ID_B_BYTE_OFFSET, ShapeId.LAYOUT));
	    manifold = new Manifold(segment.asSlice(MANIFOLD_BYTE_OFFSET, Manifold.LAYOUT));
	}

    /// ```
    /// Contact identifier validation. Provides validation for up to 2^32 allocations.
    /// ```
    public static boolean contact_IsValid(
    	MemorySegment id
    ) {
    	MethodHandle method = B2_CONTACT_IS_VALID.get();
    	try {
    		return (boolean) method.invokeExact(
    			id
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#contact_IsValid].
    public static boolean contact_IsValid(
    	ContactId id
    ) {
    	return contact_IsValid(
    		id.memorySegment()
    	);
    }
    
    /// ```
    /// Get the data for a contact. The manifold may have no points if the contact is not touching.
    /// ```
    public static MemorySegment contact_GetData(
    	SegmentAllocator allocator,
    	MemorySegment contactId
    ) {
    	MethodHandle method = B2_CONTACT_GET_DATA.get();
    	try {
    		return (MemorySegment) method.invokeExact(
    			allocator,
    			contactId
    		);
    	} catch (Throwable e) {
    		throw new RuntimeException(e);
    	}
    }
    
    /// Typed method of [#contact_GetData].
    public static @Nullable ContactData contact_GetData(
    	SegmentAllocator allocator,
    	ContactId contactId
    ) {
    	MemorySegment segment = contact_GetData(
    		allocator,
    		contactId.memorySegment()
    	);
    
    	if (segment.equals(MemorySegment.NULL))
    		return null;
    	
    	return new ContactData(segment);
    }
    
    /// @see #contactId()
    public ContactData contactId(Consumer<ContactId> consumer) {
    	consumer.accept(contactId);
    	return this;
    }
    
    /// @see #contactId()
    public ContactData contactId(ContactId other) {
    	contactId.set(other);
    	return this;
    }
    
    /// ```
    /// The contact id. You may hold onto this to track a contact across time steps. This id may
    /// become orphaned. Use b2Contact_IsValid before using it for other functions.
    /// ```
    public ContactId contactId() {
    	return contactId;
    }
    
    /// @see #shapeIdA()
    public ContactData shapeIdA(Consumer<ShapeId> consumer) {
    	consumer.accept(shapeIdA);
    	return this;
    }
    
    /// @see #shapeIdA()
    public ContactData shapeIdA(ShapeId other) {
    	shapeIdA.set(other);
    	return this;
    }
    
    /// ```
    /// The first shape id.
    /// ```
    public ShapeId shapeIdA() {
    	return shapeIdA;
    }
    
    /// @see #shapeIdB()
    public ContactData shapeIdB(Consumer<ShapeId> consumer) {
    	consumer.accept(shapeIdB);
    	return this;
    }
    
    /// @see #shapeIdB()
    public ContactData shapeIdB(ShapeId other) {
    	shapeIdB.set(other);
    	return this;
    }
    
    /// ```
    /// The second shape id.
    /// ```
    public ShapeId shapeIdB() {
    	return shapeIdB;
    }
    
    /// @see #manifold()
    public ContactData manifold(Consumer<Manifold> consumer) {
    	consumer.accept(manifold);
    	return this;
    }
    
    /// @see #manifold()
    public ContactData manifold(Manifold other) {
    	manifold.set(other);
    	return this;
    }
    
    /// ```
    /// The manifold copied from the contact.
    /// ```
    public Manifold manifold() {
    	return manifold;
    }
    
    @Override
    public ContactData set(ContactData other) {
        return set(other.segment);
    }
    
    @Override
    public ContactData set(MemorySegment src) {
        MemorySegment.copy(src, 0L, segment, 0L, LAYOUT.byteSize());
        return this;
    }
    
    @Override
    public MemorySegment memorySegment() {
        return segment;
    }
    
    public NativeStructArray<ContactData> asArray() {
        return new NativeStructArray<>(this);
    }
    
    public static NativeStructArray<ContactData> array(Arena arena, int count) {
        return new NativeStructArray<>(
            arena,
            LAYOUT,
            segment -> new ContactData(segment),
            count
        );
    }
    
    public static NativeStructArray<ContactData> array(Arena arena, ContactData... structs) {
        NativeStructArray<ContactData> array = new NativeStructArray<>(
            arena,
            LAYOUT,
            segment -> new ContactData(segment),
            structs.length
        );
    
        for (int i = 0; i < structs.length; i++) {
            array.set(i, structs[i]);
        }
    
        return array;
    }
    
    public static NativeStructArray<ContactData> array(MemorySegment array) {
        return new NativeStructArray<>(
            array,
            LAYOUT,
            segment -> new ContactData(segment)
        );
    }

}