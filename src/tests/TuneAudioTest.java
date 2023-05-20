package tests;

import javax.swing.JTextArea;
import org.junit.Test;
import commands.OpenDocument;
import junit.framework.TestCase;
import model.FakeTTSFacade;

public class TuneAudioTest extends TestCase {

	@Test
	public void test() {

		float v = 40;
		float r = 200;
		float p = 200;
		JTextArea textArea = new JTextArea();
		textArea.setText("");
		//String converted = "";
		//String fakePlay;
		OpenDocument openDocument = new OpenDocument("None", textArea);
		openDocument.actionPerformed(null);
		//ArrayList<String> contents = openDocument.document.contents;
		//Document doc = new Document();
		//doc.playContnents(textArea, v, r, p);
		FakeTTSFacade fake = new FakeTTSFacade();
		float volume = fake.getVolume();
		float rate = fake.getRate();
		float pitch = fake.getPitch();
		System.out.println("Volume: "+volume);
		System.out.println("Rate: "+rate);
		System.out.println("pitch: "+pitch);
		assertEquals(v, volume);
		assertEquals(r, rate);
		assertEquals(p, pitch);
	}
}
