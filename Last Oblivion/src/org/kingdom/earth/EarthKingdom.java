package org.kingdom.earth;

import java.util.ArrayList;

import org.characters.Lily;
import org.characters.Ray;
import org.characters.Auston;

import javagame.Collidable;
import javagame.CollisionDetector;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class EarthKingdom extends BasicGameState {

	Image worldMap;
	
	/* external game character entities */
	Lily lilyObject;
	Ray rayObject;
	Auston austonObject;
	
	ArrayList<Collidable> objectsColide;

	public EarthKingdom(int state) {
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		lilyObject = new Lily();
		rayObject = new Ray();
		austonObject = new Auston();
		
		
		objectsColide = new ArrayList<Collidable>();
		objectsColide.add(lilyObject);
		objectsColide.add(austonObject);
		
		worldMap = new Image("res/earthKingdom.png");

		
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		/* the fields of heroPosX and heroPosY are public */
		worldMap.draw(rayObject.bgOffSetX, rayObject.bgOffSetY);
		
		lilyObject.setMapOffset(rayObject.bgOffSetX, rayObject.bgOffSetY);
		austonObject.setMapOffset(rayObject.bgOffSetX, rayObject.bgOffSetY);
		
		lilyObject.render(gc, sbg, g);
		rayObject.render(gc, sbg, g);
		austonObject.render(gc,  sbg, g);

		
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		rayObject.update(gc, sbg, delta, objectsColide);

		
		
	}
	
	@Override
	public int getID() {
		return 1;
	}

	public static void main(String[] args) {
	}
}
