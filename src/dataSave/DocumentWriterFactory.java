package dataSave;

import java.util.ArrayList;

public class DocumentWriterFactory {

	public DocumentWriterFactory() {}
	
	public DocumentWriter createWriter(String fileName, String extension, String encryption, ArrayList<String> ar) {
		if(!encryption.equals("None")) 
		{
			
			if(encryption.equals("Atbash")) {
				if(extension.equals("xlsx")) 
					return new ExcelWriterDecorator(new AtbashWriter(fileName,ar));
				else if(extension.equals("docx")) 
					return new WordWriterDecorator(new AtbashWriter(fileName, ar));
				else
					return null;
			}
		
			else if(encryption.equals("Rot-13")) {
				if(extension.equals("xlsx"))
					return new ExcelWriterDecorator(new Rot13Writer(fileName,ar));
				
				else if(extension.equals("docx"))
					return new WordWriterDecorator(new Rot13Writer(fileName, ar));
				else
					return null;
			}else
				return null;
			
		}	
		else {
			if(extension.equals("xlsx"))
				return new ExcelWriterDecorator(new NoneWriter(fileName,ar));
			else if(extension.equals("docx"))	{
				return new WordWriterDecorator(new NoneWriter(fileName, ar));
			}else
				
				return null;
		}
	}
}
