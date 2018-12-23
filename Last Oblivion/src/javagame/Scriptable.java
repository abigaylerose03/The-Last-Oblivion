package javagame;

public interface Scriptable {
	
	public String talk(String text);

	public void move(float x, float y, String direction, double speed, int pDelta);

}
