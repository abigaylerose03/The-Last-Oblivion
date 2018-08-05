package org.kingdom.earth;

import java.util.Random;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Play extends BasicGameState {
	
	Animation hero, heroUp, heroUp2, 
	heroDown, heroDown2, 
	heroLeft, heroLeft2, 
	heroRight, heroRight2;
	
	Animation lily;

	boolean move, move2, move3, move4 = true; // the move variables define each movement of the sprite
										   	  // true: can move legs/arms 
											  // cannot move its legs/arms
	boolean quit = false;
	int[] duration = {200, 200};
	
	float heroPosX = -110;
	float heroPosY = -100;
	
	float shiftX = heroPosX + 320;
	float shiftY = heroPosY + 350;
	
	Image worldMap;
	
	int xDirection, yDirection;
	
	public Play(int state) {}
	
	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		worldMap = new Image("res/earthKingdom.png");
		
		Image[] walkUp = {new Image("res/characters/heroBack.png"), new Image("res/characters/heroBack.png")};
		Image[] walkUp2 = {new Image("res/characters/heroBack2.png"), new Image("res/characters/heroBack2.png")};
		
		Image[] walkDown = {new Image("res/characters/heroFront.png"), new Image("res/characters/heroFront.png")};
		Image[] walkDown2 = {new Image("res/characters/heroFront2.png"), new Image("res/characters/heroFront2.png")};
		
		Image[] walkLeft = {new Image("res/characters/heroLeft.png"), new Image("res/characters/heroLeft.png")};
		Image[] walkLeft2 = {new Image("res/characters/heroLeft2.png"), new Image("res/characters/heroLeft2.png")};
		
		Image[] walkRight = {new Image("res/characters/heroRight.png"), new Image("res/characters/heroRight.png")};
		Image[] walkRight2 = {new Image("res/characters/heroRight2.png"), new Image("res/characters/heroRight2.png")};
		
		Image[] walkingUp = {new Image("res/characters/lilyBack.png"), new Image("res/characters/lilyBack.png")};
		
		
		heroUp = new Animation(walkUp, duration, false);
		heroUp2 = new Animation(walkUp2, duration, false);
		
		heroDown = new Animation(walkDown, duration, false);
		heroDown2 = new Animation(walkDown2, duration, false);
		
		heroLeft = new Animation(walkLeft, duration, false);
		heroLeft2 = new Animation(walkLeft2, duration, false);
		
		heroRight = new Animation(walkRight, duration, false);
		heroRight2 = new Animation(walkRight2, duration, false);
		
		hero = heroDown;
		
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		worldMap.draw(heroPosX, heroPosY);
		hero.draw(shiftX, shiftY);
		
		g.drawString("Your x: "  + heroPosX + "\nYour y: " + heroPosY, 400, 20);
	
	}	
	

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		Input input = gc.getInput();
		
		/* left movement */
		if(input.isKeyDown(Input.KEY_LEFT)) {
			hero = heroLeft2;
			heroPosX += delta * .1f;
			move = false; 
			
			if(heroPosX > 206) {
				heroPosX -= delta * .1f;
			}
			
			
			/* tree collision */
			if(heroPosX > -30 && heroPosY < -198 && heroPosY > -278) {
				heroPosX -= delta * .1f;
			}
			
			if(heroPosX > -424 && heroPosY < -163 && heroPosY > -414) {
				heroPosX -= delta * .1f;
			}
			
			/* castle bushes */
			if(heroPosX > -78 && heroPosY < -93 && heroPosY > -113) {
				heroPosX -= delta * .1f;
			}
			
			/* cluster of trees */
			if(heroPosX > -293 && heroPosY < -684 && heroPosY > -714 ) {
				heroPosX -= delta * .1f;
			}
			
			if(heroPosX > -356 && heroPosY < -563 && heroPosY > -665) {
				heroPosX -= delta * .1f;
			}
			
			if(heroPosX > -4 && heroPosY < -483 && heroPosY > -559) {
				heroPosX -= delta * .1f;
			}
			
			/* tree with rock */
			if(heroPosX > -9 && heroPosY < -479 && heroPosY > -565) {
				heroPosX -= delta * .1f;
			}
			
			
		} else if(move == false) {
			hero = heroLeft;
			move = true;
		}
		
			
		/* up movement */
		if(input.isKeyDown(Input.KEY_UP)) {
			hero = heroUp2;
			heroPosY += delta * .1f;
			move2 = false;
			
			if(heroPosY > 260 ) {
				heroPosY -= delta * .1f;
			}
			
			/* tree collisions */
			if(heroPosX > 1 && heroPosX < 61) {
				heroPosY -= delta * .1f;
			}
			
			if(heroPosX > -398 && heroPosX < -323) {
				heroPosY -= delta * .1f;
			}
			
			/* castle bushes */
			if(heroPosY > -123 && heroPosX > -51 && heroPosX < 178) {
				heroPosY -= delta * .1f;
			}
			
			if(heroPosY > -120 && heroPosX > -438 && heroPosX < -202) {
				heroPosY -= delta * .1f;
			}
			
			/* castle entrance */
			if(heroPosY > -89 && heroPosX > -188 && heroPosX < -75) {
				heroPosY -= delta * .1f;
			}
			
			/* cluster of trees */
			if(heroPosY > -668 && heroPosX > -366 && heroPosX < -283) {
				heroPosY -= delta * .1f;
			}
			
			if(heroPosY > -556 && heroPosX > 112 && heroPosX < 133) {
				heroPosY -= delta * .1f;
			}
			
			/* tree with the rock */
			if(heroPosY > -577 && heroPosX > 29 && heroPosX < 110) {
				heroPosY -= delta * .1f;
			}
		
		} else if(move2 == false) {
			hero = heroUp;
			move2 = true;
		}
		
		/* down movement */
		if(input.isKeyDown(Input.KEY_DOWN)) {
			hero = heroDown2;
			heroPosY -= delta * .1f;
			move3 = false;
			
			if(heroPosY < -715) {
				heroPosY += delta * .1f;
			}
			
			/* tree collisions */
			if(heroPosY < -155 && heroPosX > -1 && heroPosX < 61) {
				heroPosY += delta * .1f;
			}
			
			if(heroPosY < -141 && heroPosX > -396 && heroPosX < -316) {
				heroPosY += delta * .1f;
			}
			
			/* cluster of trees */
			if(heroPosY < -534 && heroPosX > -329 && heroPosX < -131) {
				heroPosY += delta * .1f;
			}
			
			if(heroPosY < -603 && heroPosX > -109 && heroPosX < -27) {
				heroPosY += delta * .1f;
			}
			
			/* tree with rock */
			if(heroPosY < -441 && heroPosX > 46 && heroPosX < 101) {
				heroPosY += delta * .1f;
			}
			
			/* cluster of rocks */
			if(heroPosY < -663 && heroPosX > -780 && heroPosX < -641) {
				heroPosY += delta * .1f;
			}
			
			if(heroPosY < -667 && heroPosX > -718 && heroPosX < -678) {
				heroPosY += delta * .1f;
			}
			
		}  else if(move3 == false) {
			hero = heroDown;
			move3 = true;
		}
		
		/* right movement */
		if(input.isKeyDown(Input.KEY_RIGHT)) {
			hero = heroRight2;
			heroPosX -= delta * .1f;
			move4 = false;
			
			if(heroPosX < -781) {
				heroPosX += delta * .1f;
			}
			
			/* tree collisions */
			if(heroPosX < 80 && heroPosY < -178 && heroPosY > -268) {
				heroPosX += delta * .1f;
			}
			
			if(heroPosX < -300 && heroPosY < -159 && heroPosY > -235) {
				heroPosX += delta * .1f;
			}
			
			/* castle bushes */
			if(heroPosX < -182 & heroPosY < -85 && heroPosY > -113) {
				heroPosX += delta * .1f;
			}
			
			/* cluster of trees */
			if(heroPosX < -110 & heroPosY < -563 && heroPosY > -602) {
				heroPosX += delta * .1f;
			}
			
			if(heroPosX < -6 & heroPosY < -637 && heroPosY > -714) {
				heroPosX += delta * .1f;
			}
			
			/* tree with rock */
			if(heroPosX < 132 & heroPosY < -467 && heroPosY > -554) {
				heroPosX += delta * .1f;
			}
			
			/* cluster of rocks */
			if(heroPosX < -656 & heroPosY < -677 && heroPosY > -714) {
				heroPosX += delta * .1f;
			}
			
			
		}  else if(move4 == false) {
			hero = heroRight;
			move4 = true;
		}
		
		/* reset to default view: down movement */
		if(input.isKeyDown(Input.KEY_M)) {
			hero = heroDown;
		}
	}
	
	/* deals with AI movement */
	public int chooseRandomDirection() {
		Random r = new Random();
		int[] randDirections = new int[3];
		randDirections[0] = 0;
		randDirections[1] = 1;
		randDirections[2] = 2;

		int randChoice = r.nextInt(3);
		return randDirections[randChoice];

	}

	public void setXDirection(int dir) {
		xDirection = dir;
	}

	public void setYDirection(int dir) {
		yDirection = dir;
	}
	
	@Override
	public int getID() {
		return 1;
	}
	
	public static void main(String[] args) {
		
		
	}
}
