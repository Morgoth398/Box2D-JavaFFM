package volucris.engine.physics.box2d.math;

import java.lang.foreign.Arena;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.StructLayout;
import java.lang.invoke.VarHandle;

import org.joml.Vector2f;

import static java.lang.foreign.ValueLayout.*;
import static volucris.engine.physics.box2d.utils.FFMUtils.*;

public final class Plane {

	protected static StructLayout LAYOUT;

	private static final VarHandle OFFSET;

	private static final long NORMAL_OFFSET;

	private final MemorySegment b2Plane;

	private final Vec2 normal;

	static {
		//@formatter:off
		LAYOUT = MemoryLayout.structLayout(
				Vec2.LAYOUT().withName("normal"),
				JAVA_FLOAT.withName("offset")
			).withName("b2Plane");
		//@formatter:off
		
		OFFSET = varHandle(LAYOUT, "offset");
		
		NORMAL_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("normal"));
	}

	public Plane() {
		this(Arena.ofAuto());
	}
	
	public Plane(Arena arena) {
		b2Plane = arena.allocate(LAYOUT);
		
		normal = new Vec2(b2Plane.asSlice(NORMAL_OFFSET, Vec2.LAYOUT()));
	}

	public Plane(MemorySegment memorySegment) {
		this.b2Plane = memorySegment;
	
		normal = new Vec2(b2Plane.asSlice(NORMAL_OFFSET, Vec2.LAYOUT()));
	}
	
	@Override
	public String toString() {
		return "Plane (Normal: " + normal.toString() + ", Offset: " + getOffset() + ")";
	}
	
	public Vector2f getNormal(Vector2f target) {
		return normal.get(target);
	}
	
	public Vector2f getNormal() {
		return getNormal(new Vector2f());
	}
	
	public void setNormal(Vector2f normal) {
		this.normal.set(normal);
	}
	
	public float getOffset() {
		return (float) OFFSET.get(b2Plane);
	}
	
	public MemorySegment memorySegment() {
		return b2Plane;
	}
	
	public static StructLayout LAYOUT() {
		return LAYOUT;
	}
	
}
