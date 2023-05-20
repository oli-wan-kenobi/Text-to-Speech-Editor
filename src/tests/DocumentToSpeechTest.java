package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import javax.swing.JTextArea;

import org.junit.Test;

import commands.CloseDocument;
import commands.OpenDocument;
import model.FakeTTSFacade;

public class DocumentToSpeechTest {

	@Test
	public void test() {
		JTextArea textArea = new JTextArea();
		textArea.setText("");
		String text = "";
		String fakePlay;
		OpenDocument openDocument = new OpenDocument("None", textArea);
		openDocument.actionPerformed(null);
		ArrayList<String> contents = openDocument.document.contents;
		
		//System.out.println("Contents: " +contents);
		for (String s : contents)
		{
			text += s + "\n";
		}
		
		FakeTTSFacade fake = new FakeTTSFacade();
		fake.fakePlay(text, -1, -1);
		fakePlay = fake.getPlayedContents();
		System.out.println("Fake Play: "+fakePlay);
		
		assertEquals(text, fakePlay);
		CloseDocument close = new CloseDocument(textArea);
		close.actionPerformed(null);
		
		//------------------------------------------------------------------
		
		openDocument = new OpenDocument("None", textArea);
		openDocument.actionPerformed(null);
		contents = openDocument.document.contents;
		text = "";
		for (String s : contents)
		{
			text += s + "\n";
		}
		

		fake = new FakeTTSFacade();
		fake.fakePlay(text, 1, 3);
		fakePlay = fake.getPlayedContents();
		System.out.println("Fake Play: "+fakePlay);
		
		assertEquals(text, fakePlay);
		close.actionPerformed(null);
		
		//------------------------------------------------------------------
		
		text = "";
		text = "Hello World";
		
		
		
		fake = new FakeTTSFacade();
		fake.fakePlay(text, -1, -1);
		fakePlay = fake.getPlayedContents();
		System.out.println("Fake Play: "+fakePlay);
		
		assertEquals(text, fakePlay);
		close.actionPerformed(null);
		
		//------------------------------------------------------------------
		text += "\nhello again";
		
		
		fake = new FakeTTSFacade();
		fake.fakePlay(text, 1, 2);
		fakePlay = fake.getPlayedContents();
		System.out.println("Fake Play: "+fakePlay);
		
		assertEquals(text, fakePlay);
		close.actionPerformed(null);
	}

}
