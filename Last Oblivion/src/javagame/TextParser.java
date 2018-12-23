package javagame;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

import org.characters.*;



public class TextParser {
	
	String currentLine;
	
	Joy joyObject;

	public TextParser() throws IOException, SlickException {
	
		joyObject = new Joy();
		
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		
	}
	
	public void update(GameContainer gc, StateBasedGame sbg, int delta, TextBox tb, PlayMenu pm, ArrayList<Scriptable> scriptables) throws SlickException, IOException {
		List<String> line = Files.readAllLines(Paths.get("/Users/abigaylepeterson/Documents/GitHub/The-Last-Oblivion/Last Oblivion/src/org/mainplot/library.txt"));
		Collidable characterScript = (Collidable)scriptables.get(0);
		
		if(characterScript.isScriptable()) {
			scriptables.add((Scriptable)characterScript);
			
			
			((Scriptable) characterScript).move(200, 200, "down", .1f, delta);
			((Scriptable) characterScript).move(800, 200, "right", .1f, delta);
			
			// use that for talking if not move
			// tb.setText(((Scriptable)characterScript.talk(line.get(i)));
				
			}
			
		}
	
		
	
			
		
		
		/* for large files:
		String line;
		try(Stream<String> lines = Files.lines(Paths.get("file.txt"))) {
			line32 = lines.skip(previous lines ex. 31).findFirst().get();
		
		}
		*/
	
	
	public static void main(String[] args) throws IOException {
		List<String> line = Files.readAllLines(Paths.get("/Users/abigaylepeterson/Documents/GitHub/The-Last-Oblivion/Last Oblivion/src/org/mainplot/library.txt"));
		
		for(int i = 0; i < line.size(); i++) {
			
			if(line.get(i).contains("move")) {
				// move the character
			} else if(!line.get(i).contains("move")) {
				// output the string
				
			}
			System.out.println(line.get(i));
		}
	}
		
	
	

}
