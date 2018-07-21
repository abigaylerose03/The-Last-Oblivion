package javagame;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;


public class Menu extends BasicGameState {
	Image playGame;
	Image exitGame;
	Image dragon; // background image
	
	public String mouse = "testing 123"; // for the mouse cors, future use
	
	public Menu(int state) {}
	
	@Override
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		dragon = new Image("res/dragon.jpg");
		playGame = new Image("res/playNow.png");
		exitGame = new Image("res/exitNow.png");
		
		
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		dragon.draw(0, 0);
		g.drawString("The Last Oblivion", 100, 50);
		/* g.drawString(mouse, 150, 50); */
		playGame.draw(80, 95);
		exitGame.draw(610, 10);
	
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		int posX = Mouse.getX();
		int posY = Mouse.getY();
		
		/* mouse = "Mouse position x: " + posX + "y: " + posY; */

		/* play now button */
		if((posX > 100 && posX < 311) && (posY > 109 && posY < 260)) {
			if(Mouse.isButtonDown(0)) {
				sbg.enterState(1); // play state
			}
		}
		
		/* exit now button */
		if((posX > 610 && posX < 650) && (posY > 200 && posY < 350)) {
			if(Mouse.isButtonDown(0)) {
				System.exit(0);
			}
		}
	}

	@Override
	public int getID() { return 0; }

}
