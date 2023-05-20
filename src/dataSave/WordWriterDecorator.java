package dataSave;

import java.io.File;

import java.io.FileOutputStream;
import java.util.ArrayList;

import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

public class WordWriterDecorator extends WriterDecorator{

	public WordWriterDecorator(DocumentWriter documentWriter) {
		super(documentWriter);
	}
	
	public ArrayList<String> write() {
		ArrayList<String> ar = documentWriter.write();
		
		return wordDecorator(ar);
	}
	
	public ArrayList<String> wordDecorator(ArrayList<String> ar) {
		
		try {
			String path = ar.get(ar.size() -1);
			ar.remove(ar.size()-1);
			
			
			File f = new File(path);
			
			if(!f.exists() ) 
			{
				XWPFDocument doc = new XWPFDocument();
				
				// create a paragraph
	            XWPFParagraph p1 = doc.createParagraph();
	            p1.setAlignment(ParagraphAlignment.CENTER);

	            // set font
	            XWPFRun r1 = p1.createRun();
	            r1.setBold(true);
	            r1.setItalic(true);
	            r1.setFontSize(14);
	            r1.setFontFamily("New Roman");
	            
	            
	            for(int i=0; i< ar.size(); i++) {
	            	System.out.println(ar.get(i)+"\n");
	            	r1.setText(ar.get(i)+"\n");
	            }
	            

	            // save it to .docx file
	            FileOutputStream out = new FileOutputStream(path);		//path = ar.get(0)
                doc.write(out);
                out.close();	            
	            doc.close();
			}
			else if(f.exists() && f.canWrite() && f.canRead()) 
			{				
				XWPFDocument  doc = new XWPFDocument();
				FileOutputStream out = new FileOutputStream(path);
				// create a paragraph
	            XWPFParagraph p1 = doc.createParagraph();
	            p1.setAlignment(ParagraphAlignment.CENTER);

	            // set font
	            XWPFRun r1 = p1.createRun();
	            r1.setBold(true);
	            r1.setItalic(true);
	            r1.setFontSize(14);
	            r1.setFontFamily("New Roman");
	            
	            
	            for(int i=0; i< ar.size(); i++) {
	            	System.out.println(ar.get(i)+"\n");
	            	r1.setText(ar.get(i)+"\n");
	            }
	            

	            // save it to .docx file
	            try  {	//path = ar.get(0)
	                doc.write(out);
	                out.close();
	            }
	            catch(Exception e){
	    			System.out.println("Exception: "+e);
	    			doc.close();
	    			return null;
	            }
	            doc.close();
			}
		}
		catch(Exception e){
			System.out.println("Exception: "+e);
			return null;
		}	
		
		System.out.println("Writesheet.docx written successfully");
		
		return ar;
	}
}
