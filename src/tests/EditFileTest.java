package tests;

import static org.junit.Assert.*;
import java.util.ArrayList;
import javax.swing.JTextArea;
import org.junit.Test;
import commands.OpenDocument;
import model.Document;

public class EditFileTest {

	@Test
	public void test() {
		
		//AppInterface app = new AppInterface();
		
		JTextArea textArea = new JTextArea();
		textArea.setText("");

		OpenDocument openDocument = new OpenDocument("None", textArea);
		openDocument.actionPerformed(null);
		//ArrayList<String> contents = openDocument.document.contents;
		 
		
		textArea.append("hello");
		
		System.out.println("---------");
		System.out.println(textArea.getText());
		String textAreaToString = textArea.getText();
		
		Document doc = Document.getInstance();
		ArrayList<String> contents_new = doc.contents;
		
		String contents_neww = "";
		for(String s: contents_new)
			contents_neww += s + "\n";
		
		System.out.println(contents_neww);
		
		
		assertNotEquals(textAreaToString,contents_neww);
	}
}

			//EPEIDH DEN EXOUME EDITDOCUMENT... TIS ALAGES TIS ELEGXOUME ME 
			// VASH TO TEXTAREA. ARA ELEGXOUME TEXTAREA ME DOC.CONTENTS