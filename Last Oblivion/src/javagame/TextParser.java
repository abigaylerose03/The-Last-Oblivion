package javagame;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

import org.characters.*;



public class TextParser {
	
	private static String line;

	public TextParser() throws IOException, SlickException {
		// CH 1 - Library 
		line = Files.readAllLines(Paths.get("/Users/abigaylepeterson/Documents/GitHub/The-Last-Oblivion/Last Oblivion/src/org/mainplot/library.txt")).get(2);
		
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta, TextBox tb, /* ArrayList<Collidable> collidables */ ArrayList<Scriptable> scriptables, PlayMenu pm) throws SlickException {
		// check if object (from the Collidable interface) is scriptable by
		// the problem im running into is HOW we can check if character is scriptable or not 
		// confusing: two interfaces to deal with 
		
		
		
		
		
		/* for large files:
		String line;
		try(Stream<String> lines = Files.lines(Paths.get("file.txt"))) {
			line32 = lines.skip(previous lines ex. 31).findFirst().get();
		
		}
		*/
	}
	
	public static void main(String[] args) throws IOException {
		line = Files.readAllLines(Paths.get("/Users/abigaylepeterson/Documents/GitHub/The-Last-Oblivion/Last Oblivion/src/org/mainplot/library.txt")).get(2);
		
		if(line.contains("Joy:")) {
			System.out.println(line);
		
		}
	}
		
	
	

}
