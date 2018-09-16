package org.characters;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

import javagame.Collidable;

public class Auston implements Collidable {
	
	static Animation auston, austonDown;
	int duration[] = {200, 200};
	
	float austonPosX = -400;
	float austonPosY = 270;
	
	public Auston() throws SlickException {
		Image[] walkDownAuston = { new Image("res/characters/Auston.png"), new Image("res/characters/Auston.png") };
		
		austonDown = new Animation(walkDownAuston, duration, false);
		auston = austonDown;
	}
	
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics arg2) throws SlickException {
		auston.draw(austonPosX, austonPosY);
	
	}
	
	public void setMapOffset(float offsetx, float offsety) {
		austonPosX = offsetx + 740;
		austonPosY = offsety + 100;
		
	}

	@Override
	public float getX() { return austonPosX; }

	@Override
	public float getY() { return austonPosY; }

	@Override
	public float getWidth() { return 26; }

	@Override
	public float getHeight() { return 26; }
	
	
	
	
	
	
}
