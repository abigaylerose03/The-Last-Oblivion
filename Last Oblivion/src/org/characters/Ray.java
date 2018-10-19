package org.characters;

import java.util.ArrayList;
import java.util.Random;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

import javagame.Collidable;
import javagame.CollisionDetector;

import javagame.TextBox;
import javagame.Talkable;


public class Ray implements Collidable {

	Animation hero, heroUp, 
	heroUp2, heroUp3, 
	heroDown, heroDown2, heroDown3, 
	heroLeft, heroLeft2, heroRight, heroRight2, 
	heroBlink, heroBlink2,
	heroSwordRight;

	boolean move, move2, move3, move4 = true; // the move variables define each movement of the sprite
												// true: can move legs/arms
												// cannot move its legs/arms
	boolean quit = false;
	int[] duration = { 200, 200 };
	static long prevTurn = System.currentTimeMillis();

	public float bgOffSetX = -110;
	public float bgOffSetY = -100;
	
	public float heroPosX = 210;
	public float heroPosY = 250;
	
	public int heroIntPosX = 210;
	public int heroIntPosY = 250;
	
	public float spriteTextX = 0;
	public float spriteTextY = 0;
	
	public float textX;
	public float textY;
	
	public float currentTextX;
	public float currentTextY;
	
	public ArrayList<Collidable> oldCollisions;

	public Ray() throws SlickException {
		
		Image[] walkUp = { new Image("res/characters/heroBack.png"), new Image("res/characters/heroBack.png") };
		Image[] walkUp2 = { new Image("res/characters/heroBack2.png"), new Image("res/characters/heroBack2.png") };
		Image[] walkUp3 = { new Image("res/characters/heroBack3.png"), new Image("res/characters/heroBack3.png") };

		Image[] walkDown = { new Image("res/characters/heroFront.png"), new Image("res/characters/heroFront.png") };
		Image[] walkDown2 = { new Image("res/characters/heroFront2.png"), new Image("res/characters/heroFront2.png") };
		Image[] walkDown3 = { new Image("res/characters/heroFront3.png"), new Image("res/characters/heroFront3.png") };

		Image[] walkLeft = { new Image("res/characters/heroLeft.png"), new Image("res/characters/heroLeft.png") };
		Image[] walkLeft2 = { new Image("res/characters/heroLeft2.png"), new Image("res/characters/heroLeft2.png") };

		Image[] walkRight = { new Image("res/characters/heroRight.png"), new Image("res/characters/heroRight.png") };
		Image[] walkRight2 = { new Image("res/characters/heroRight2.png"), new Image("res/characters/heroRight2.png") };
		

		Image[] blink1 = { new Image("res/characters/rayv2_22.png"), new Image("res/characters/rayv2_22.png") };
		Image[] blink2 = { new Image("res/characters/rayv2_23.png"), new Image("res/characters/rayv2_23.png") };
		
		Image[] swordRight = { new Image("res/characters/heroSwordRight.png"), new Image("res/characters/heroSwordRight.png") };
		
		
		
		
		
		heroUp = new Animation(walkUp, duration, false);
		heroUp2 = new Animation(walkUp2, duration, false);
		heroUp3 = new Animation(walkUp3, duration, false);

		heroDown = new Animation(walkDown, duration, false);
		heroDown2 = new Animation(walkDown2, duration, false);
		heroDown3 = new Animation(walkDown3, duration, false);

		heroLeft = new Animation(walkLeft, duration, false);
		heroLeft2 = new Animation(walkLeft2, duration, false);

		heroRight = new Animation(walkRight, duration, false);
		heroRight2 = new Animation(walkRight2, duration, false);
		
		heroBlink = new Animation(blink1, duration, false);
		heroBlink2 = new Animation(blink2, duration, false);
		
		heroSwordRight = new Animation(swordRight, duration, false);
	
		hero = heroDown;
	
		
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g, ArrayList<Collidable> collidables) throws SlickException {
		hero.draw(heroPosX, heroPosY);
		// g.drawString("Your x: " + heroPosX + "\nYour y: " + heroPosY, 400, 20);
		Random rayBlink = new Random();
		int r_rayBlink = rayBlink.nextInt(2);
		
		Random rayUp = new Random();
		int r_rayUp = rayUp.nextInt(2);
		
		Random rayDown = new Random();
		int r_rayDown = rayDown.nextInt(2);
		
		
		switch(r_rayBlink) {
			
			case 0:
				if (System.currentTimeMillis() - prevTurn >= 1000 && hero == heroRight) {
					hero = heroBlink;
					hero.draw(heroPosX, heroPosY);
					prevTurn = System.currentTimeMillis();
				}
				break;
			
			case 1:
				if (System.currentTimeMillis() - prevTurn >= 1000 && hero == heroRight) {
					hero = heroBlink2;
					hero.draw(heroPosX, heroPosY);
					prevTurn = System.currentTimeMillis();
				}
				break;
			default:
				hero = heroUp2;
				break;
				
		}
		
		switch(r_rayUp) {
			
			case 0:
				if (System.currentTimeMillis() - prevTurn >= 30 && hero == heroUp) {
					hero = heroUp2;
					hero.draw(heroPosX, heroPosY);
					prevTurn = System.currentTimeMillis();
				}
				break;
			
			case 1:
				if (System.currentTimeMillis() - prevTurn >= 30 && hero == heroUp) {
					hero = heroUp3;
					hero.draw(heroPosX, heroPosY);
					prevTurn = System.currentTimeMillis();
				}
				break;
				
			default:
				hero = heroUp;
		}
		
		// equals the heroFront pictures
		switch(r_rayDown) {
		
			case 0:
				if (System.currentTimeMillis() - prevTurn >= 720 && hero == heroDown3) { 
					hero = heroDown2;
					hero.draw(heroPosX, heroPosY);
					prevTurn = System.currentTimeMillis();
				}
				break;
			
			case 1:
				if (System.currentTimeMillis() - prevTurn >= 720 && hero == heroDown2) {
					hero = heroDown3;
					hero.draw(heroPosX, heroPosY);
					prevTurn = System.currentTimeMillis();
				}
			break;
			
			/* case 3:
				if (System.currentTimeMillis() - prevTurn >= 1000 && hero == heroDown3) {
					hero = heroDown;
					hero.draw(heroPosX, heroPosY);
					prevTurn = System.currentTimeMillis();
				}
			break; */
		default:
			hero = heroDown2;
			break;
			
		}
		
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta, ArrayList<Collidable> collidables, TextBox tb) throws SlickException {
		Input input = gc.getInput();
		
		float currentX = bgOffSetX;
		float currentY = bgOffSetY;
		
		float currentHeroX = heroPosX;
		float currentHeroY = heroPosY;

		/* left movement */
		if (input.isKeyDown(Input.KEY_LEFT)) {
			hero = heroLeft2;
			bgOffSetX += delta * .1f;
			heroPosX -= delta * .1f;
			move = false;
			
		} else if (move == false) {
			hero = heroLeft;
			move = true;
		}


		if (bgOffSetX > 206) {
			bgOffSetX -= delta * .1f;
		} 

			/* tree collision 
			if (bgOffSetX > -30 && bgOffSetY < -198 && bgOffSetY > -278) {
				bgOffSetX -= delta * .1f;
			}

			if (bgOffSetX > -424 && bgOffSetY < -163 && bgOffSetY > -414) {
				bgOffSetX -= delta * .1f;
			}

			/* castle bushes 
			if (bgOffSetX > -78 && bgOffSetY < -93 && bgOffSetY > -113) {
				bgOffSetX -= delta * .1f;
			}

			/* cluster of trees 
			if (bgOffSetX > -293 && bgOffSetY < -684 && bgOffSetY > -714) {
				bgOffSetX -= delta * .1f;
			}

			if (bgOffSetX > -356 && bgOffSetY < -563 && bgOffSetY > -665) {
				bgOffSetX -= delta * .1f;
			}

			if (bgOffSetX > -4 && bgOffSetY < -483 && bgOffSetY > -559) {
				bgOffSetX -= delta * .1f;
			}

			/* tree with rock 
			if (bgOffSetX > -9 && bgOffSetY < -479 && bgOffSetY > -565) {
				bgOffSetX -= delta * .1f;
			}

		} else if (move == false) {
			hero = heroLeft;
			move = true;
		} */

		/* up movement */
		if (input.isKeyDown(Input.KEY_UP)) {
			hero = heroUp2;
			bgOffSetY += delta * .1f;
			heroPosY -= delta * .1f;
			move2 = false;
			
		} else if (move2 == false) {
			hero = heroUp;
			move2 = true;
		}

		 if (bgOffSetY > 260) {
			bgOffSetY -= delta * .1f;
		} 

			/* tree collisions 
			if (bgOffSetX > 1 && bgOffSetX < 61) {
				bgOffSetY -= delta * .1f;
			}

			if (bgOffSetX > -398 && bgOffSetX < -323) {
				bgOffSetY -= delta * .1f;
			}

			/* castle bushes 
			if (bgOffSetY > -123 && bgOffSetX > -51 && bgOffSetX < 178) {
				bgOffSetY -= delta * .1f;
			}

			if (bgOffSetY > -120 && bgOffSetX > -438 && bgOffSetX < -202) {
				bgOffSetY -= delta * .1f;
			}

			/* castle entrance 
			if (bgOffSetY > -89 && bgOffSetX > -188 && bgOffSetX < -75) {
				bgOffSetY -= delta * .1f;
			}

			/* cluster of trees 
			if (bgOffSetY > -668 && bgOffSetX > -366 && bgOffSetX < -283) {
				bgOffSetY -= delta * .1f;
			}

			if (bgOffSetY > -556 && bgOffSetX > 112 && bgOffSetX < 133) {
				bgOffSetY -= delta * .1f;
			}

			/* tree with the rock 
			if (bgOffSetY > -577 && bgOffSetX > 29 && bgOffSetX < 110) {
				bgOffSetY -= delta * .1f;
			}

		} else if (move2 == false) {
			hero = heroUp;
			move2 = true;
		} */

		/* down movement */
		if (input.isKeyDown(Input.KEY_DOWN)) {
			hero = heroDown3;
			bgOffSetY -= delta * .1f;
			heroPosY += delta * .1f;
			move3 = false;
			
		} else if (move3 == false) {
			hero = heroDown2;
			move3 = true;
		} 
	

		if (sbg.getCurrentStateID() == 1 && bgOffSetY < -715) {
			bgOffSetY += delta * .1f;
			
			if(input.isKeyPressed(Input.KEY_RETURN)) {
				sbg.enterState(3);
			}
			
			
		} 
		
		if(input.isKeyPressed(Input.KEY_S)) {
			hero = heroSwordRight;
		}
	

			/* tree collisions 
			if (bgOffSetY < -155 && bgOffSetX > -1 && bgOffSetX < 61) {
				bgOffSetY += delta * .1f;
			}

			if (bgOffSetY < -141 && bgOffSetX > -396 && bgOffSetX < -316) {
				bgOffSetY += delta * .1f;
			}

			/* cluster of trees 
			if (bgOffSetY < -534 && bgOffSetX > -329 && bgOffSetX < -131) {
				bgOffSetY += delta * .1f;
			}

			if (bgOffSetY < -603 && bgOffSetX > -109 && bgOffSetX < -27) {
				bgOffSetY += delta * .1f;
			}

			/* tree with rock 
			if (bgOffSetY < -441 && bgOffSetX > 46 && bgOffSetX < 101) {
				bgOffSetY += delta * .1f;
			}

			/* cluster of rocks 
			if (bgOffSetY < -663 && bgOffSetX > -780 && bgOffSetX < -641) {
				bgOffSetY += delta * .1f;
			}

			if (bgOffSetY < -667 && bgOffSetX > -718 && bgOffSetX < -678) {
				bgOffSetY += delta * .1f;
			}

		} 
		} */

		/* right movement */
		if (input.isKeyDown(Input.KEY_RIGHT)) {
			hero = heroRight2;
			bgOffSetX -= delta * .1f;
			heroPosX += delta * .1f;
			
			move4 = false;
			
		} else if (move4 == false) {
			hero = heroRight;
			move4 = true;
			
		} 
		

		 if (bgOffSetX < -781) {
			 bgOffSetX += delta * .1f;
		}

			/* tree collisions 
			if (bgOffSetX < 80 && bgOffSetY < -178 && bgOffSetY > -268) {
				bgOffSetX += delta * .1f;
			}

			if (bgOffSetX < -300 && bgOffSetY < -159 && bgOffSetY > -235) {
				bgOffSetX += delta * .1f;
			}

			/* castle bushes 
			if (bgOffSetX < -182 & bgOffSetY < -85 && bgOffSetY > -113) {
				bgOffSetX += delta * .1f;
			}

			/* cluster of trees 
			if (bgOffSetX < -110 & bgOffSetY < -563 && bgOffSetY > -602) {
				bgOffSetX += delta * .1f;
			}

			if (bgOffSetX < -6 & bgOffSetY < -637 && bgOffSetY > -714) {
				bgOffSetX += delta * .1f;
			}

			/* tree with rock 
			if (bgOffSetX < 132 & bgOffSetY < -467 && bgOffSetY > -554) {
				bgOffSetX += delta * .1f;
			}

			/* cluster of rocks 
			if (bgOffSetX < -656 & bgOffSetY < -677 && bgOffSetY > -714) {
				bgOffSetX += delta * .1f;
			}

		} else if (move4 == false) {
			hero = heroRight;
			move4 = true;
		} */

		/* reset to default view: down movement */ 
		if (input.isKeyDown(Input.KEY_M)) {
			hero = heroDown; 
		} 
		
		ArrayList<Collidable> collisions = CollisionDetector.detectCols(this, collidables);
		
		if(!collisions.isEmpty()) {
			bgOffSetX = currentX;
			bgOffSetY = currentY;
			
		}
		heroPosX = currentHeroX;
		heroPosY = currentHeroY;
		
		if(input.isKeyPressed(Input.KEY_SPACE)) {
			ArrayList<Collidable> collisionsInter = CollisionDetector.detectColsWithMargin(this, collidables, 5);
			
			// if tb -> textbox isn't already up and there's a collision 
			if(tb.getText().isEmpty() && !collisionsInter.isEmpty()) {
				
				// is it safe to treat the object, anything, we collided with as Talkable interface
				if(Talkable.class.isAssignableFrom(collisionsInter.get(0).getClass())) {
					Talkable character = (Talkable)collisionsInter.get(0);
					tb.setText(character.getDialogueWithCollidable(this));
				}
				
				
			
			} else {
				tb.setText("");
				
			}
		
			
		}
		
		
	}
	

	@Override
	public float getX() {
		
		return heroPosX;
	}

	@Override
	public float getY() {
		
		return heroPosY;
	}

	@Override
	public float getWidth() {
		
		return 26;
	}

	@Override
	public float getHeight() {

		return 26;
	}
	

}
