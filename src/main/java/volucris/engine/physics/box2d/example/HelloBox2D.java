package volucris.engine.physics.box2d.example;

import org.joml.Vector2f;

import volucris.engine.physics.box2d.Box2D;
import volucris.engine.physics.box2d.body.Body;
import volucris.engine.physics.box2d.body.BodyDef;
import volucris.engine.physics.box2d.body.BodyType;
import volucris.engine.physics.box2d.geometry.Polygon;
import volucris.engine.physics.box2d.shape.Shape;
import volucris.engine.physics.box2d.shape.ShapeDef;
import volucris.engine.physics.box2d.utils.NativeLibraryLoader;
import volucris.engine.physics.box2d.world.World;
import volucris.engine.physics.box2d.world.WorldDef;

public class HelloBox2D {

	public static void main(String[] args) {
		
		NativeLibraryLoader.DEBUG = true;
		NativeLibraryLoader.REPLACE_EXISTING = true;
		
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

	}

}
