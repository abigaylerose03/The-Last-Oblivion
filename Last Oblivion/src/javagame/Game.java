package javagame;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

import org.kingdom.earth.Play;


public class Game extends StateBasedGame {
	
	public static final String gamename = "The Last Oblivion";
	/* the individual game states */
	public static final int mainMenu = 0;
	public static final int localMap = 1;
	
	public Game(String gamename) {
		super(gamename);
		this.addState(new Menu(mainMenu));// add menu class 
		this.addState(new Play(localMap)); // remember to use enterState(id);
		// all the names of the different kingdoms
		// a battle state
	}


	
	public void initStatesList(GameContainer gc) throws SlickException {
		this.getState(mainMenu).init(gc, this);
		this.getState(localMap).init(gc, this);
		this.enterState(mainMenu);
	}
	
	public static void main(String[] args) {
		AppGameContainer appgc;
		try {
			appgc = new AppGameContainer(new Game(gamename));
			appgc.setDisplayMode(640, 340, false);
			appgc.start();
		
		} catch(SlickException e) {
			e.printStackTrace();

		}
	}
}
