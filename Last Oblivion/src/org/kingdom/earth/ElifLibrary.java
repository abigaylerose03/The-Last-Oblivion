package org.kingdom.earth;

import java.io.IOException;
import java.util.ArrayList;

import org.characters.Lily;
import org.characters.Ray;
import org.characters.Auston;
import org.characters.Joy;

import javagame.Collidable;
import javagame.TextBox;
import javagame.TextParser;
import javagame.PlayMenu;
import javagame.RayTalk;
import javagame.Scriptable;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class ElifLibrary extends BasicGameState {
	
	Ray rayObject;
	Joy joyObject;
	
	TextParser tp;
	
	Image map;
	
	TextBox tb;
	
	PlayMenu playMenu;
	
	ArrayList<Collidable> objectsColide;
	ArrayList<Scriptable> scriptables2;
	
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
		
		try {
			tp = new TextParser();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		objectsColide = new ArrayList<Collidable>();
		objectsColide.add(joyObject);
		
		scriptables2 = new ArrayList<Scriptable>();
		scriptables2.add(joyObject);
	
		
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
		playMenu.render(gc, sbg, g); // renders the play menu
		
		
		joyObject.setMapOffset(rayObject.bgOffSetX, rayObject.bgOffSetY);
		// joyObject.move(200, 200, "down", 0.87f, deltaVal);
		
		g.drawString(Float.toString(rayObject.bgOffSetX), 10, 10);
		g.drawString(Float.toString(rayObject.bgOffSetY), 100, 10);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		deltaVal = delta;
		
		rayObject.update(gc, sbg, delta, objectsColide, tb, playMenu);
	
		joyObject.update(gc, sbg, delta);
		
		
		try {
			tp.update(gc, sbg, delta, tb, playMenu, scriptables2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		rayObject.heroPosX = 860;
		rayObject.heroPosY = 100;
		

		tb.setOffSetX(rayObject.heroPosX - 210);
	    tb.setOffSetY(rayObject.heroPosY + 80);
	    
		
	}

	@Override
	public int getID() {
		
		return 4;
	}
	
}
	