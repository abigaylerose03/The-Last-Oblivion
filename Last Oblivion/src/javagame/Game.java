package javagame;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.kingdom.earth.*;

public class Game extends StateBasedGame {
	
	public static final String gamename = "The Last Oblivion";
	/* the individual game states */
	public static final int mainMenu = 0;
	public static final int localMap = 1;
	// public static final int castle = 2;
	public static final int earthKingdomCity = 3;

	public Game(String gamename) {
		super(gamename);
		this.addState(new Menu(mainMenu));// add menu class
		this.addState(new EarthKingdom(localMap)); // remember to use enterState(id);
		this.addState(new EarthKingdomCity(earthKingdomCity));
		// all the names of the different kingdoms
		// a battle state
	}

	public void initStatesList(GameContainer gc) throws SlickException {
		this.getState(mainMenu).init(gc, this);
		this.getState(localMap).init(gc, this);
		// this.getState(castle).init(gc, this);
		this.getState(earthKingdomCity).init(gc, this);
		this.enterState(mainMenu);
	}

	public static void main(String[] args) {
		AppGameContainer appgc;
		try {
			appgc = new AppGameContainer(new Game(gamename));
			appgc.setDisplayMode(1000, 1000, false);
			appgc.start();

		} catch (SlickException e) {
			e.printStackTrace();

		}
	}
}
