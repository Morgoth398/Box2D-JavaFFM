package volucris.engine.physics.box2d;

import java.lang.foreign.Arena;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.StructLayout;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.VarHandle;

import volucris.engine.utils.Box2DRuntimeException;

import static java.lang.foreign.ValueLayout.*;
import static volucris.engine.utils.FFMUtils.*;

public final class Version {

	private static final StructLayout LAYOUT;

	private static final VarHandle MAJOR;
	private static final VarHandle MINOR;
	private static final VarHandle REVISION;

	private static final MethodHandle B2_GET_VERSION;

	private final MemorySegment b2Version;

	private String version;

	static {
		//@formatter:off
		LAYOUT = MemoryLayout.structLayout(
				JAVA_INT.withName("major"),
				JAVA_INT.withName("minor"),
				JAVA_INT.withName("revision")
			).withName("b2Version");
		//@formatter:on

		MAJOR = varHandle(LAYOUT, "major");
		MINOR = varHandle(LAYOUT, "minor");
		REVISION = varHandle(LAYOUT, "revision");

		B2_GET_VERSION = downcallHandle("b2GetVersion", LAYOUT);
	}

	public Version() {
		try {
			b2Version = (MemorySegment) B2_GET_VERSION.invoke(Arena.ofAuto());
		} catch (Throwable e) {
			String className = e.getClass().getSimpleName();
			throw new Box2DRuntimeException("Cannot create version: " + className);
		}

		int major = (int) MAJOR.get(b2Version);
		int minor = (int) MINOR.get(b2Version);
		int revision = (int) REVISION.get(b2Version);

		version = major + "." + minor + "." + revision;
	}

	public String getVersion() {
		return version;
	}

}
