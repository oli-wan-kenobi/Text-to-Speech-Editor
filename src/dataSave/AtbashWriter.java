package dataSave;

import java.util.ArrayList;
import java.util.HashMap;


public class AtbashWriter implements DocumentWriter {
	
	private String path;
	private ArrayList<String> arraylist;
	
	public AtbashWriter(String path, ArrayList<String> contents) {
		this.path = path;
		this.arraylist = contents;
		
	}
	
	@SuppressWarnings("serial")
	HashMap<String, String> lookup_table = new HashMap<String, String>() {{
		put("A","Z");put("B","Y");put("C","X");put("D","W");put("E","V");put("F","U");put("G","T");
		put("H","S");put("I","R");put("J","Q");put("K","P");put("L","O");put("M","N");put("N","M");
		put("O","L");put("P","K");put("Q","J");put("R","I");put("S","H");put("T","G");put("U","F");
		put("V","E");put("W","D");put("X","C");put("Y","B");put("Z","A");
		
		put("a","z");put("b","y");put("c","x");put("d","w");put("e","v");put("f","u");put("g","t");
		put("h","s");put("i","r");put("j","q");put("k","p");put("l","o");put("m","n");put("n","m");
		put("o","l");put("p","k");put("q","j");put("r","i");put("s","h");put("t","g");put("u","f");
		put("v","e");put("w","d");put("x","c");put("y","b");put("z","a");
	}};
	
	
	@Override
	public ArrayList<String> write() {
		
		ArrayList<String> tmp = new ArrayList<String>();		
			
		for(String row: arraylist) {
			
			String[] words = row.split(" ");
			String roww = "";
			
			for(int i=0; i<words.length; i++)
			{
				char[] characters = words[i].toCharArray(); 
				String word = "";
				
				for(char ch: characters) {
					if( (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') ) {
						ch =  ( lookup_table.get(Character.toString(ch)) ).charAt(0);
						//return tmp;	
					}
					word += ""+ch;
				}
				roww += word + " ";
			}
			roww.trim();
			
			tmp.add(roww);
		}	
		
		tmp.add(path);
		return tmp;		
	}
}
