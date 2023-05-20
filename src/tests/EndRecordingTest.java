package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import javax.swing.JTextArea;

import org.junit.Test;

import commands.OpenDocument;
import commands.RecordAudio;
import commands.ReplayManager;
import model.FakeTTSFacade;

public class EndRecordingTest {

	@Test
	public void test() {
		
		
		ReplayManager replayManager = new ReplayManager();
		
		RecordAudio recordAudio = new RecordAudio();
		recordAudio.actionPerformed(null);
		Boolean before = replayManager.isActionRecording();
		System.out.println("Recording: "+before);
		
		JTextArea textArea = new JTextArea();
		textArea.setText("");
		OpenDocument openDocument = new OpenDocument("None",textArea);
		openDocument.actionPerformed(null);
		ArrayList<String> contents = openDocument.document.contents;
		
		String text = "";
		for (String s : contents)
		{
			text += s + "\n";
		}
		
		FakeTTSFacade fake = new FakeTTSFacade();
		fake.fakePlay(text, -1, -1);
	
		replayManager.actionPerformed(null);
		
		recordAudio.actionPerformed(null);
		Boolean after = replayManager.isActionRecording();
		System.out.println("Recording: "+after);
		
		assertNotEquals(before,after);
	}
}
/* gia kapoio logo den anoigei ksana to para8yro ths replayManager, opote de mporoume na
 * paiksoume ksana to audio. Pantws kanontas ksana recordAudio.actionPerformed(null);
 * to systhma allazei th metavlhth boolean se false kai de ksanakaleitai h replayManager
 */