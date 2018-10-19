package javagame;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class TextBox {
	
	Image textBox;
	float offSetX;
	float offSetY;
	
	String spriteText;
	
	float textX;
	float textY;
	
	public TextBox() throws SlickException {
		textBox = new Image("res/textBoxv1.png");
		spriteText = "";
		
	}
	
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics g) throws SlickException {
		
		if(!spriteText.isEmpty()) {
			textBox.draw(offSetX, offSetY);
			
			g.setColor(Color.black);
			g.drawString(spriteText, offSetX + 10, offSetY + 10);
			
		}
	}
	
	public void setOffSetX(float textoffSetX) {
		offSetX = textoffSetX;
	}
	
	public void setOffSetY(float textoffSetY) {
		offSetY = textoffSetY;
	}
	
	
	public String getText() { return spriteText; }

    public void setText(String text) {
		// TODO Auto-generated method stub
		spriteText = (String) text;
		
	}




}
