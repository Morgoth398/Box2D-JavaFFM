# Box2D-JavaFFM
This project provides Java bindings for  [Box2D](https://box2d.org/) using the Java FFM API.

# Supported Platforms
Windows and Linux are directly supported. The Linux .so file was built on Linux Mint 22.2.
Nevertheless, you can use these bindings for Mac if you provide your own .dylib file and load it.

# Usage
This project requires Java 26 and preview features enabled.

Before calling any method you need to load the native library. For Windows and Linux you can call `Box2D.loadNativeLibrary()`.

My implementation of a native library loader makes use of some  [LWJGL](https://www.lwjgl.org/) configurations. To set the extract directory of
the native library, change `Configuration.SHARED_LIBRARY_EXTRACT_PATH`. 

Due to the introduction of  [restricted methods](https://docs.oracle.com/en/java/javase/25/docs/api/java.base/java/lang/doc-files/RestrictedMethods.html), it is recommended (and in later versions required) to run the application with the VM argument `--enable-native-access=ALL-UNNAMED`.

# Memory Management
When creating an object, native memory will be allocated.

Structs are always allocated with an arena. By default an automatic arena is used, but you can use any arena you want (even a global arena, but this may not be desirable) by using the appropriate constructor.

When a struct is allocated through a native function call, the first parameter is always a `SegmentAllocator` (a parent type of an arena). This parameter is not part of the original C function signature and is added automatically in Java.

# Example
This is a port of the  [Hello Box2D](https://box2d.org/documentation/hello.html) introduction.

```Java
public class HelloBox2D {

	public static void main(String[] args) {

		HelloBox2D helloBox2D = new HelloBox2D();
		helloBox2D.run();
		helloBox2D.dispose();

	}

	private WorldId worldId;
	
	private BodyId groundBodyId;
	private BodyId dynamicBodyId;
	
	public HelloBox2D() {
		Box2D.loadNativeLibrary();
		
		try (Arena arena = Arena.ofConfined()) {
			WorldDef worldDef = WorldDef.defaultWorldDef(arena)
					.gravity(g -> g.x(0).y(-10));
			worldId = World.createWorld(Arena.ofAuto(), worldDef);
			
			BodyDef groundBodyDef = BodyDef.defaultBodyDef(arena)
					.position(p -> p.x(0).y(-10));
			groundBodyId = Body.createBody(Arena.ofAuto(), worldId, groundBodyDef);
			
			Polygon groundBox = Polygon.makeBox(arena, 50, 10);
			ShapeDef groundShapeDef = ShapeDef.defaultShapeDef(arena);	
			Shape.createPolygonShape(arena, groundBodyId, groundShapeDef, groundBox);
			
			BodyDef dynamicBodyDef = BodyDef.defaultBodyDef(arena)
					.type(BodyType.DYNAMIC_BODY)
					.position(p -> p.x(0).y(4));
			dynamicBodyId = Body.createBody(Arena.ofAuto(), worldId, dynamicBodyDef);
			
			Polygon dynamicBox = Polygon.makeBox(arena, 1, 1);
			ShapeDef dynamicShapeDef = ShapeDef.defaultShapeDef(arena)
					.density(1)
					.material(m -> m.friction(0.4f));
			Shape.createPolygonShape(arena, dynamicBodyId, dynamicShapeDef, dynamicBox);
		}
	}
	
	public void run() {
		float timeStep = 1 / 60f;
		int subStepCount = 4;

		for (int i = 0; i < 90; i++) {
			World.step(worldId, timeStep, subStepCount);
			
			try (Arena arena = Arena.ofConfined()) {
				Vec2 position = Body.getPosition(arena, dynamicBodyId);
				Rot rotation = Body.getRotation(arena, dynamicBodyId);
				
				double angle = Box2DMath.atan2(rotation.s(), rotation.c());
				System.out.println(position.x() + ", " + position.y() + ", " + angle);
			}
		}
	}
	
	public void dispose() {
		World.destroyWorld(worldId);
	}
	
}
```