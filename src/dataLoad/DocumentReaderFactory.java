package dataLoad;

public class DocumentReaderFactory {

	public DocumentReaderFactory() {}
	
	public DocumentReader createReader(String fileName, String extension, String encryption) {
		if(!encryption.equals("None")) {
			
			if(extension.equals("xlsx")) {
				if(encryption.equals("Atbash"))
					return new AtbashDecorator( new ExcelReader(fileName));
				
				else if(encryption.equals("Rot-13"))
					return new Rot13Decorator( new ExcelReader(fileName));
				else
					return null;
			
			}
			else if(extension.equals("docx")) {
				if(encryption.equals("Atbash"))
					return new AtbashDecorator( new WordReader(fileName));
				
				else if(encryption.equals("Rot-13"))
					return new Rot13Decorator( new WordReader(fileName));
				else
					return null;
			}
			else
				return null;
		}else {
			if(extension.equals("xlsx"))
				return new ExcelReader(fileName);
			else if(extension.equals("docx"))
				return new WordReader(fileName);
			else
				return null;
		
		}
	}
}
