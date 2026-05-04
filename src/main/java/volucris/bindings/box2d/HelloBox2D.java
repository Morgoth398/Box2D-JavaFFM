package volucris.bindings.box2d;

import java.lang.foreign.Arena;
import volucris.bindings.box2d.body.Body;
import volucris.bindings.box2d.body.BodyDef;
import volucris.bindings.box2d.body.BodyId;
import volucris.bindings.box2d.enums.BodyType;
import volucris.bindings.box2d.geometry.Polygon;
import volucris.bindings.box2d.math.Box2DMath;
import volucris.bindings.box2d.math.Rot;
import volucris.bindings.box2d.math.Vec2;
import volucris.bindings.box2d.shape.Shape;
import volucris.bindings.box2d.shape.ShapeDef;
import volucris.bindings.box2d.world.World;
import volucris.bindings.box2d.world.WorldDef;
import volucris.bindings.box2d.world.WorldId;

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
