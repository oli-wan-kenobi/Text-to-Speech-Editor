package dataLoad;

import java.util.ArrayList;
import java.util.HashMap;

public class AtbashDecorator extends ReaderDecorator{
	
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

	public AtbashDecorator(DocumentReader documentReader) {
		super(documentReader);
	}
	
	public ArrayList<String> read() {
		ArrayList<String> ar = documentReader.read();
		
		return decorateAtbash(ar);
	}
	
	public ArrayList<String> decorateAtbash(ArrayList<String> ar){
		
		ArrayList<String> tmp = new ArrayList<String>();
		
		for(String row: ar) {
			
			String[] words = row.split(" ");
			String roww = "";
			
			for(int i=0; i<words.length; i++)
			{
				char[] characters = words[i].toCharArray(); 
				String word = "";
				
				for(char ch: characters) {
					if( (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') ) {
						ch =  ( lookup_table.get(Character.toString(ch)) ).charAt(0);
					}
					word += ""+ch;
				}
				roww += word + " ";
			}
			//roww = roww.substring(0,roww.length()+1);
			
			roww.trim();
			tmp.add(roww);
		}		
		return tmp;		
	}
}
