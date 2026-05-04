# Box2D-JavaFFM
This project provides Java bindings for  [Box2D](https://box2d.org/) 3.1.1 using the Java FFM API. 
All implemented functions can be found in 'AllFunctions.txt'.

# Supported Platforms
Windows and Linux are directly supported. The Linux .so file was built on Linux Mint 22.2.
Nevertheless, you can use these bindings for Mac if you provide your own .dylib file and load it.

If you build your own dynamic library file for Box2D, make sure to additionally export the function 'b2Atan2' as the bindings make use of it.

# Usage
This project requires Java 25.

Before using the bindings (and even loading the bindings classes), you need to call 'Box2D.init()' or load the native library yourself.
My implementation of a native library loader makes use of some  [LWJGL](https://www.lwjgl.org/) configurations. To set the extract directory of
the native library, change 'Configuration.SHARED_LIBRARY_EXTRACT_PATH'. 

Due to the introduction of  [restricted methods](https://docs.oracle.com/en/java/javase/25/docs/api/java.base/java/lang/doc-files/RestrictedMethods.html), it is recommended (and in later versions required) to run the application with the VM argument '--enable-native-access=ALL-UNNAMED'.

# Memory Management
When creating an object, native memory will be allocated. An automatic arena will be used by default, but you can change that with one of the given constructors.

A confined arena may be preferred for short-lived objects like body or shape definitions.

For long-lived objects, such as a joint, a body, or a shape, however, it is crucial that both the memory and the objects remain alive until they are removed from the physics simulation. To guarantee that they are kept in an internal list, but this only ensures that the memory won't be released by an automatic arena. You have to take care of this yourself if you use any other arena.

# Example
This is a port of the  [Hello Box2D](https://box2d.org/documentation/hello.html) introduction.

```Java
Box2D.init();		

WorldDef worldDef = new WorldDef();
worldDef.setGravity(0, -10);

World world = new World(worldDef);

BodyDef groundBodyDef = new BodyDef();
groundBodyDef.setPosition(0, -10);

Body groundBody = new Body(world, groundBodyDef);	
Polygon groundBox = Polygon.makeBox(50, 10);
ShapeDef groundShapeDef = new ShapeDef();
new Shape(groundBody, groundShapeDef, groundBox);

BodyDef bodyDef = new BodyDef();
bodyDef.setType(BodyType.DYNAMIC_BODY);
bodyDef.setPosition(0, 4);

Body body = new Body(world, bodyDef);
Polygon dynamicBox = Polygon.makeBox(1, 1);
ShapeDef shapeDef = new ShapeDef();
shapeDef.setDensity(1);
shapeDef.getSurfaceMaterial().setFriction(0.4f);
new Shape(body, shapeDef, dynamicBox);

float timeStep = 1 / 60f;
int subStepCount = 4;

Vector2f position = new Vector2f();

for (int i = 0; i < 90; i++) {
	world.step(timeStep, subStepCount);
	body.getPosition(position);
	float rotation = body.getRotation();
	System.out.println(position.x + " " + position.y + " " + rotation);
}

world.destroyWorld();

```

# Implementation
I made these bindings as part of my own game engine (therefore the package naming). Because I use  [Joml](https://github.com/JOML-CI/JOML) as the math library of this engine, it is the math library used in these bindings. Even if the default Box2D math classes exist, they are only used internally to pass the values to the C code. Feel free to change the package name and the math library if it does not fit your project.