package org.kingdom.earth;

import java.util.ArrayList;

import org.characters.Lily;
import org.characters.Ray;

import javagame.Collidable;
import javagame.CollisionDetector;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class EarthKingdom extends BasicGameState {

	Image worldMap;
	
	/* external game entities */
	Lily lilyObject;
	Ray rayObject;

	public EarthKingdom(int state) {
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		lilyObject = new Lily();
		rayObject = new Ray();
		
		ArrayList<Collidable> objectsColide = new ArrayList<Collidable>();
		objectsColide.add(lilyObject);
		
		worldMap = new Image("res/earthKingdom.png");
		
		ArrayList<Collidable> collisions = CollisionDetector.detectCols(rayObject, objectsColide);
			
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		/* the fields of heroPosX and heroPosY are public */
		worldMap.draw(rayObject.heroPosX, rayObject.heroPosY);
		
		lilyObject.setMapOffset(rayObject.heroPosX, rayObject.heroPosY);
		lilyObject.render(gc, sbg, g);
		
		rayObject.render(gc, sbg, g);

		
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		rayObject.update(gc, sbg, delta);
	}
	
	@Override
	public int getID() {
		return 1;
	}

	public static void main(String[] args) {
	}
}
