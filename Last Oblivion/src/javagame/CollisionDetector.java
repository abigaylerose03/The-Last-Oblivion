package javagame;

import java.util.ArrayList;
import javagame.Collidable;

public class CollisionDetector {
	
	public static ArrayList<Collidable> detectCols(Collidable actor, ArrayList<Collidable> others) {
		ArrayList<Collidable> collisions = new ArrayList<Collidable>();
		for(Collidable collision : others) { // iterate through the ArrayList of collidable objects
			if(pointInX(actor, collision.getX(), collision.getY()) 
			   || pointInX(actor, collision.getX() + collision.getWidth(), collision.getY()) 
			   || pointInX(actor, collision.getX(), collision.getY() + collision.getHeight()) 
			   || pointInX(actor, collision.getX() + collision.getWidth(), collision.getY() + collision.getHeight())) {
				
					collisions.add(collision);
				
			}
			
			
		} return collisions;
		
	}
	
	public static boolean pointInX(Collidable otherStuff, float x, float y) {
		if(x >= otherStuff.getX() && x <= otherStuff.getX() + otherStuff.getWidth()
		&& y >= otherStuff.getY() && y <= otherStuff.getY() + otherStuff.getHeight()) {
			return true;
		}
		return false;
		
	}

}
