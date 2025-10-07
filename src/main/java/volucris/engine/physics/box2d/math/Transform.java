package volucris.engine.physics.box2d.math;

import java.lang.foreign.Arena;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemoryLayout.PathElement;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.StructLayout;

import org.joml.Vector2f;

import volucris.engine.utils.MathUtils;

public final class Transform {

	private static StructLayout LAYOUT;

	private static final long P_OFFSET;
	private static final long Q_OFFSET;

	private final MemorySegment b2Transform;

	private final CosSin cosSinTmp;
	private final Vec2 p;
	private final Rot q;

	static {
		//@formatter:off
		LAYOUT = MemoryLayout.structLayout(
				Vec2.LAYOUT().withName("p"),
				Rot.LAYOUT().withName("q")
			).withName("b2Transform");
		//@formatter:off
		
		P_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("p"));
		Q_OFFSET = LAYOUT.byteOffset(PathElement.groupElement("q"));
	}

	public Transform() {
		b2Transform = Arena.ofAuto().allocate(LAYOUT);
		
		p = new Vec2(b2Transform.asSlice(P_OFFSET, Vec2.LAYOUT()));
		q = new Rot(b2Transform.asSlice(Q_OFFSET, Rot.LAYOUT()));
		
		cosSinTmp = new CosSin();
	}

	public Transform(MemorySegment memorySegment) {
		this.b2Transform = memorySegment;
		
		p = new Vec2(b2Transform.asSlice(P_OFFSET, Vec2.LAYOUT()));
		q = new Rot(b2Transform.asSlice(Q_OFFSET, Rot.LAYOUT()));
		
		cosSinTmp = new CosSin();
	}
	
	public void set(MemorySegment memorySegment) {
		p.set(memorySegment.asSlice(P_OFFSET, Vec2.LAYOUT()));
		q.set(memorySegment.asSlice(Q_OFFSET, Rot.LAYOUT()));
	}
	
	@Override
	public String toString() {
		return "Transform (P: " + p.toString() + ", Q: " + q.toString() + ")";
	}
	
	public Vector2f getPosition(Vector2f target) {
		return p.get(target);
	}
	
	public Vector2f getPosition() {
		return getPosition(new Vector2f());
	}
	
	public void setPosition(float x, float y) {
		p.set(x, y);
	}
	
	public void setPosition(Vector2f position) {
		p.set(position);
	}
	
	public float getRotation() {
		return MathUtils.toDegrees(getRotationRadians());
	}
	
	public float getRotationRadians() {
		return q.getAngleRadians();
	}
	
	public void setRotation(float rotation) {
		setRotationRadians(MathUtils.toRadians(rotation));
	}
	
	public void setRotationRadians(float rotation) {
		q.set(CosSin.computeCosSin(cosSinTmp, rotation));
	}
	
	public MemorySegment memorySegment() {
		return b2Transform.asReadOnly();
	}
	
	public static StructLayout LAYOUT() {
		return LAYOUT;
	}
}
