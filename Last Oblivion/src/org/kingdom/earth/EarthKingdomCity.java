package org.kingdom.earth;

import org.characters.Lily;
import org.characters.Auston;
import org.characters.Ray;
import org.characters.WeaponsDealer;

import java.util.ArrayList;

import javagame.Collidable;
import javagame.TextBox;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;


public class EarthKingdomCity extends BasicGameState {
	
	Image worldMap;
	
	Ray rayObject;
	Lily lilyObject;
	WeaponsDealer wdObject;
	
	TextBox tb;
	
	ArrayList<Collidable> objectsColide;
	
	public EarthKingdomCity(int state) {}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		// TODO Auto-generated method stub
		worldMap = new Image("res/earthKingdomTown.bmp");
		
		rayObject = new Ray();
		lilyObject = new Lily();
		wdObject = new WeaponsDealer();
		
		tb = new TextBox();
		
		objectsColide = new ArrayList<Collidable>();
		
		objectsColide.add(lilyObject);
		objectsColide.add(wdObject);

	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {

		worldMap.draw(rayObject.bgOffSetX + 10, rayObject.bgOffSetY - 10);
		
		lilyObject.setMapOffset(rayObject.bgOffSetX, rayObject.bgOffSetY - 50);
		wdObject.setMapOffset(rayObject.bgOffSetX, rayObject.bgOffSetY);
		
		lilyObject.render(gc, sbg, g);
		rayObject.render(gc, sbg, g, null);
		wdObject.render(gc, sbg, g);
		
		tb.render(gc, sbg, g);
		
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		Input input = gc.getInput();
		
		rayObject.update(gc, sbg, delta, objectsColide, tb);
		
		rayObject.heroPosX = 233;
		rayObject.heroPosY = 10;

		tb.setOffSetX(rayObject.heroPosX + 25);
	    tb.setOffSetY(rayObject.heroPosY + 50);
	    
	    
	    if(rayObject.bgOffSetY >= 10 && rayObject.bgOffSetX <= 10) {
	    	rayObject.bgOffSetY -= delta * .1f;
	    	
	    	if(input.isKeyPressed(Input.KEY_RETURN)) {
	    		sbg.enterState(1); // enter the elif kingdom castle grounds 
	    	}
	    }
	    
	    if (rayObject.bgOffSetY <= -1200) {
				rayObject.bgOffSetY += delta * .1f;
		    }
	    }
	  
		
	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 3;
	}

	

}
