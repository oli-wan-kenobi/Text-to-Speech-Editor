package dataSave;

import java.util.ArrayList;

public class NoneWriter implements DocumentWriter{

	private String path;
	private ArrayList<String> arraylist;
	
	public NoneWriter(String path, ArrayList<String> contents) {
		this.path = path;
		this.arraylist = contents;
	}

	@Override
	public ArrayList<String> write() {
		arraylist.add(path);
		return arraylist;
	}

}
