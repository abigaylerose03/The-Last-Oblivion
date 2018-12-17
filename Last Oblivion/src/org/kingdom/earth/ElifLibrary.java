package org.kingdom.earth;

import java.util.ArrayList;

import org.characters.Lily;
import org.characters.Ray;
import org.characters.Auston;
import org.characters.Joy;

import javagame.Collidable;
import javagame.TextBox;
import javagame.PlayMenu;
import javagame.RayTalk;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class ElifLibrary extends BasicGameState {
	
	Ray rayObject;
	Joy joyObject;
	Image map;
	
	TextBox tb;
	
	PlayMenu playMenu;
	
	ArrayList<Collidable> objectsColide;
	
	RayTalk rayTalk;
	
	private int deltaVal;
	

	public ElifLibrary(int state) {
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		rayObject = new Ray();
		joyObject = new Joy();
		tb = new TextBox();
		playMenu = new PlayMenu();
		objectsColide = new ArrayList<Collidable>();
		
		map = new Image("res/elifLibrary.bmp");
		
		rayObject.hero = rayObject.heroRight;
		
		
		
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		map.draw(rayObject.bgOffSetX + 20, rayObject.bgOffSetY);
		
		rayObject.render(gc, sbg, g, null);
		joyObject.render(gc, sbg, g);
		// rayObject.hero = rayObject.heroRight;
		tb.render(gc, sbg, g);
		
		
		joyObject.setMapOffset(rayObject.bgOffSetX, rayObject.bgOffSetY);
		// joyObject.move(200, 200, "down", 0.87f, deltaVal);
		
		g.drawString(Float.toString(rayObject.bgOffSetX), 10, 10);
		g.drawString(Float.toString(rayObject.bgOffSetY), 100, 10);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		deltaVal = delta;
		
		rayObject.update(gc, sbg, delta, objectsColide, tb, playMenu);
		// joyObject.move(200, 200, "down", 0.87f, delta);
		joyObject.update(gc, sbg, delta);
		

		rayObject.heroPosX = 860;
		rayObject.heroPosY = 100;
		

		tb.setOffSetX(rayObject.heroPosX + 25);
	    tb.setOffSetY(rayObject.heroPosY + 50);
	    
		
	}

	@Override
	public int getID() {
		
		return 4;
	}
	
}
	