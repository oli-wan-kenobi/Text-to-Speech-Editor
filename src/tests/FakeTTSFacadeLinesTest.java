package tests;

import java.util.ArrayList;

import javax.swing.JTextArea;

import org.junit.Test;

import commands.OpenDocument;
import junit.framework.TestCase;
import model.Document;
import model.FakeTTSFacade;

public class FakeTTSFacadeLinesTest extends TestCase {

	@Test
	public void test() {

		int a = 3;
		int b = 6;
		JTextArea textArea = new JTextArea();
		textArea.setText("");
		String converted = "";
		String fakePlay;
		OpenDocument openDocument = new OpenDocument("None", textArea);
		openDocument.actionPerformed(null);
		ArrayList<String> contents = openDocument.document.contents;
		Document doc = new Document();
		doc.playLine(textArea, a, b);
		//for (String s : contents)
			//System.out.println("Contents: " +s);
		for(int i = (a-1); i <= (b-a)+1;i++) {
			
			converted += contents.get(i) + "\n";
		}
		//converted = contents.toArray(new String[contents.size()]);
		
		
		System.out.println("\nConverted: "+ converted);
		FakeTTSFacade fake = new FakeTTSFacade();
		fakePlay = fake.getPlayedContents();
		System.out.println("\nFake Play: "+fakePlay);
		
		assertEquals(converted, fakePlay);
	}
}


