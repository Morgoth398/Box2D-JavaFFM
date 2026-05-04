package volucris.engine.physics.box2d.math;

import java.lang.foreign.Arena;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemoryLayout.PathElement;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.StructLayout;

import org.joml.Matrix2f;

public final class Mat22 {

	private static StructLayout LAYOUT;

	private static final long CX_OFFSET;
	private static final long CY_OFFSET;

	private final Vec2 cx;
	private final Vec2 cy;

	private final MemorySegment b2Mat22;

	static {
		//@formatter:off
		LAYOUT = MemoryLayout.structLayout(
				Vec2.LAYOUT().withName("cx"),
				Vec2.LAYOUT().withName("cy")
			).withName("b2Mat22");
		//@formatter:on

		CX_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("cx"));
		CY_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("cy"));
	}

	public Mat22() {
		this(Arena.ofAuto());
	}

	public Mat22(Arena arena) {
		b2Mat22 = arena.allocate(LAYOUT);

		cx = new Vec2(b2Mat22.asSlice(CX_OFFSET, Vec2.LAYOUT()));
		cy = new Vec2(b2Mat22.asSlice(CY_OFFSET, Vec2.LAYOUT()));
	}

	public Mat22(MemorySegment memorySegment) {
		this.b2Mat22 = memorySegment;

		cx = new Vec2(b2Mat22.asSlice(CX_OFFSET, Vec2.LAYOUT()));
		cy = new Vec2(b2Mat22.asSlice(CY_OFFSET, Vec2.LAYOUT()));
	}

	public void set(MemorySegment memorySegment) {
		cx.set(memorySegment.asSlice(CX_OFFSET, Vec2.LAYOUT()));
		cy.set(memorySegment.asSlice(CY_OFFSET, Vec2.LAYOUT()));
	}

	@Override
	public String toString() {
		return "Mat22 (CX: " + cx.toString() + ", CY: " + cy.toString() + ")";
	}

	public void set(Matrix2f matrix) {
		cx.setX(matrix.m00());
		cx.setY(matrix.m01());
		cy.setX(matrix.m10());
		cy.setY(matrix.m11());
	}

	public Matrix2f get(Matrix2f target) {
		target.m00(cx.getX());
		target.m01(cx.getY());
		target.m10(cy.getX());
		target.m11(cy.getY());
		return target;
	}

	public Matrix2f get() {
		return get(new Matrix2f());
	}

	public MemorySegment memorySegment() {
		return b2Mat22;
	}

	public static StructLayout LAYOUT() {
		return LAYOUT;
	}

}
