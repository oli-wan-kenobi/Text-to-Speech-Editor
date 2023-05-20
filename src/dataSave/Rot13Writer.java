package dataSave;

import java.util.ArrayList;

public class Rot13Writer implements DocumentWriter{

	private String path;
	private ArrayList<String> arraylist;
	
	public Rot13Writer(String path, ArrayList<String> contents) {
		this.path = path;
		this.arraylist = contents;
	}
	
	
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
					if       (ch >= 'a' && ch <= 'm') {ch += 13;}
		            else if  (ch >= 'A' && ch <= 'M') {ch += 13;}
		            else if  (ch >= 'n' && ch <= 'z') {ch -= 13;}
		            else if  (ch >= 'N' && ch <= 'Z') {ch -= 13;}
					word += ""+ch;
				}
				roww += word + " ";
			}
			//roww = roww.substring(0,roww.length());

			//roww = replace(roww,roww.length(),'');
			roww.trim();
			
			tmp.add(roww);
		}	
		tmp.add(path);
		return tmp;
	}
}