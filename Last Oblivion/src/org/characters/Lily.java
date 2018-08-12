package org.characters;

import java.util.Random;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Lily extends BasicGameState {
	
	static Animation lily;
	
	static Animation lilyUp;

	Animation lilyUp2;

	static Animation lilyDown;

	Animation lilyDown2;

	static Animation lilyLeft;

	Animation lilyLeft2;

	static Animation lilyRight;

	Animation lilyRight2;
	
	int[] duration = { 200, 200 };
	static long prevTurn = System.currentTimeMillis();
	
	float lilyPosX = -120;
	float lilyPosY = -110;

	float lilyShiftX = lilyPosX + 420;
	float lilyShiftY = lilyPosY + 350;

	public Lily(int state) {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		/* Lily character images */
		Image[] walkUpLily = { new Image("res/characters/lilyBack.png"), new Image("res/characters/lilyBack.png") };
		Image[] walkUpLily2 = { new Image("res/characters/lilyBack2.png"), new Image("res/characters/lilyBack2.png") };

		Image[] walkDownLily = { new Image("res/characters/lilyFront.png"), new Image("res/characters/lilyFront.png") };
		Image[] walkDownLily2 = { new Image("res/characters/lilyFront2.png"),
				new Image("res/characters/lilyFront2.png") };

		Image[] walkLeftLily = { new Image("res/characters/lilyLeft.png"), new Image("res/characters/lilyLeft.png") };
		Image[] walkLeftLily2 = { new Image("res/characters/lilyLeft2.png"),
				new Image("res/characters/lilyLeft2.png") };

		Image[] walkRightLily = { new Image("res/characters/lilyRight.png"),
				new Image("res/characters/lilyRight.png") };
		Image[] walkRightLily2 = { new Image("res/characters/lilyRight2.png"),
				new Image("res/characters/lilyRight2.png") };
		

		/* Lily animations */
		lilyUp = new Animation(walkUpLily, duration, false);
		lilyUp2 = new Animation(walkUpLily2, duration, false);

		lilyDown = new Animation(walkDownLily, duration, false);
		lilyDown2 = new Animation(walkDownLily2, duration, false);

		lilyLeft = new Animation(walkLeftLily, duration, false);
		lilyLeft2 = new Animation(walkLeftLily2, duration, false);

		lilyRight = new Animation(walkRightLily, duration, false);
		lilyRight2 = new Animation(walkRightLily2, duration, false);

		lily = lilyDown;
		
		
	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics arg2) throws SlickException {
		lily.draw(lilyShiftX, lilyShiftY);
		// lily.isStopped();
		
		Random r_lily = new Random();
		int lilyMove = r_lily.nextInt(4);
		System.out.println(lilyMove);
		
		switch(lilyMove) {
			
			case 0:
				if (System.currentTimeMillis() - prevTurn >= 3000) {
					lily = lilyRight;
					lily.draw(lilyShiftX, lilyShiftY);
					prevTurn = System.currentTimeMillis();
				}
				break;
			
			case 1:
				if (System.currentTimeMillis() - prevTurn >= 3000) {
					lily = lilyUp;
					lily.draw(lilyShiftX, lilyShiftY);
					prevTurn = System.currentTimeMillis();
				}
				break;
			
			case 2:
				if (System.currentTimeMillis() - prevTurn >= 3000) {
					lily = lilyLeft;
					lily.draw(lilyShiftX, lilyShiftY);
					prevTurn = System.currentTimeMillis();
				}
				break;
			
			case 3:
				if (System.currentTimeMillis() - prevTurn >= 3000) {
					lily = lilyDown;
					lily.draw(lilyShiftX, lilyShiftY);
					prevTurn = System.currentTimeMillis();
				}
				break;
			
			default:
				lily = lilyDown;
				break;
		}
		
	}

	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2) throws SlickException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 2;
	}
	
}
