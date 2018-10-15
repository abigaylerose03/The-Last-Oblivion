package org.characters;

import java.util.ArrayList;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

import javagame.Collidable;
import javagame.CollisionDetector;
import javagame.Talkable;
import javagame.TextBox;

public class Auston implements Collidable, Talkable {
	
	static Animation auston, austonDown;
	int duration[] = {200, 200};
	
	float austonPosX = -400;
	float austonPosY = 270;
	
	float textX;
	float textY;
	
	TextBox tb;
	
	int dialogIndex;
	
	public String austonText[] = {"Hello I am Auston.", "hi"};
	
	public Auston() throws SlickException {
		Image[] walkDownAuston = { new Image("res/characters/Auston.png"), new Image("res/characters/Auston.png") };
		
		austonDown = new Animation(walkDownAuston, duration, false);
		auston = austonDown;
		
	}
	
	public void render(GameContainer gc, StateBasedGame arg1, Graphics arg2) throws SlickException {
		auston.draw(austonPosX, austonPosY);
	
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, ArrayList<Collidable> collidables, TextBox tb) {
		Input input = gc.getInput();
		
		if(input.isKeyPressed(Input.KEY_A)) {
			austonText[2] = "hi";
		}
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

	@Override
	public String getDialogueWithCollidable(Collidable actor) {
		
		return austonText[0];
	}

	
}
