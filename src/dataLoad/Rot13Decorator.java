package dataLoad;

import java.util.ArrayList;

public class Rot13Decorator extends ReaderDecorator{

	public Rot13Decorator(DocumentReader documentReader) {
		super(documentReader);
	}
	
	public ArrayList<String> read() {
		ArrayList<String> ar = documentReader.read();
		
		return decorateRot13(ar);
	}
	
	public ArrayList<String> decorateRot13(ArrayList<String> ar){
			
			ArrayList<String> tmp = new ArrayList<String>();
			
			for(String row: ar) {
				
				String[] words = row.split(" ");
				String roww = "";
				
				for(int i=0; i<words.length; i++)
				{
					char[] characters = words[i].toCharArray(); 
					String word = "";
					
					for(char ch: characters) {
						if (ch >= 'a' && ch <= 'm') {
							ch += 13;
						}else if  (ch >= 'A' && ch <= 'M') {
							ch += 13;
						}else if  (ch >= 'n' && ch <= 'z') {
							ch -= 13;
						}else if  (ch >= 'N' && ch <= 'Z') {
							ch -= 13;
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
