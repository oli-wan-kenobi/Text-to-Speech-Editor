package dataSave;

import java.util.ArrayList;

public class WriterDecorator implements DocumentWriter{

	DocumentWriter documentWriter;
	
	public WriterDecorator(DocumentWriter documentWriter) {
		this.documentWriter = documentWriter;
	}
	
	@Override
	public ArrayList<String> write() {
		return documentWriter.write();
	}
}
