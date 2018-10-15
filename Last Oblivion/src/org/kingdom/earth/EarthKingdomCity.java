package org.kingdom.earth;

import org.characters.Lily;
import org.characters.Ray;

import java.util.ArrayList;

import org.characters.Auston;

import javagame.Collidable;
import javagame.TextBox;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;


public class EarthKingdomCity extends BasicGameState {
	
	Image worldMap;
	
	Ray rayObject;
	Lily lilyObject;
	
	TextBox tb;
	
	ArrayList<Collidable> objectsColide;
	
	public EarthKingdomCity(int state) {}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		// TODO Auto-generated method stub
		worldMap = new Image("res/earthKingdomTown.bmp");
		rayObject = new Ray();
		lilyObject = new Lily();
		tb = new TextBox();
		
		objectsColide = new ArrayList<Collidable>();
		
		objectsColide.add(lilyObject);

	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {

		worldMap.draw(rayObject.bgOffSetX, rayObject.bgOffSetY);
		
		lilyObject.setMapOffset(rayObject.bgOffSetX, rayObject.bgOffSetY - 50);
		
		lilyObject.render(gc, sbg, g);
		rayObject.render(gc, sbg, g, null);
		
		tb.render(gc, sbg, g);
		
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		rayObject.update(gc, sbg, delta, objectsColide, tb);

		tb.setOffSetX(rayObject.heroPosX + 25);
	    tb.setOffSetY(rayObject.heroPosY + 50);
		
		
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 3;
	}

	

}
