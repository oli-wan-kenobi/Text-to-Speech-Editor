package dataLoad;

import java.io.FileInputStream;
import java.util.ArrayList;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

public class WordReader implements DocumentReader {

	String path;
	ArrayList<String> arraylist;
	
	public WordReader(String path) {
		this.path = path;
		arraylist = null;
	}

	@Override
	public ArrayList<String> read() 
	{
		arraylist = new ArrayList<String>();
		
		try {
			FileInputStream fileToRead = new FileInputStream(path);
			XWPFDocument xdoc = new XWPFDocument(OPCPackage.open(fileToRead));
	
			
			XWPFWordExtractor ext = new XWPFWordExtractor(xdoc);
			String text = ext.getText();
			String[] splitted_text = text.split("\n");
			
		
			for(int i=0; i<splitted_text.length; i++) {
				arraylist.add(splitted_text[i]);
			}
		
		fileToRead.close();
		xdoc.close();
		ext.close();
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}		
		return arraylist;
	}

}
