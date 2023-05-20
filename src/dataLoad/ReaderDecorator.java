package dataLoad;

import java.util.ArrayList;

public class ReaderDecorator implements DocumentReader {

	DocumentReader documentReader;
	
	public ReaderDecorator(DocumentReader documentReader) {
		this.documentReader = documentReader;
	}

	@Override
	public ArrayList<String> read() {
		
		return documentReader.read();
	}

}
