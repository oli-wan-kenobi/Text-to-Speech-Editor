package tests;

import java.util.ArrayList;
import javax.swing.JTextArea;
import org.junit.Test;
import commands.OpenDocument;
import junit.framework.TestCase;
import model.FakeTTSFacade;

public class FakeTTSFacadeTest extends TestCase {

	@Test
	public void test() {

		JTextArea textArea = new JTextArea();
		textArea.setText("");
		String converted = "";
		String fakePlay;
		OpenDocument openDocument = new OpenDocument("None", textArea);
		openDocument.actionPerformed(null);
		ArrayList<String> contents = openDocument.document.contents;
		//Document doc = new Document();
		//doc.playContnents(textArea);
		System.out.println("Contents: " +contents);
		for (String s : contents)
		{
			converted += s + "\n";
		}
		
		System.out.println("Converted: "+converted);
		FakeTTSFacade fake = new FakeTTSFacade();
		fakePlay = fake.getPlayedContents();
		System.out.println("Fake Play: "+fakePlay);
		
		assertEquals(converted, fakePlay);
	}
}

