package org.kingdom.earth;

import org.characters.Lily;
import org.characters.Ray;
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
		worldMap = new Image("res/earthKingdom.png");
		
		lilyObject = new Lily();
		rayObject = new Ray();

	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		/* the fields of heroPosX and heroPosY are public */
		worldMap.draw(rayObject.heroPosX, rayObject.heroPosY);
		
		lilyObject.setMapOffset(rayObject.heroPosX, rayObject.heroPosY);
		lilyObject.render(gc, sbg, g);
		
		rayObject.render(gc, sbg, g);
		rayObject.update(gc, sbg, 2);
		
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		
	}
	
	@Override
	public int getID() {
		return 1;
	}

	public static void main(String[] args) {
	}
}
