package tests;

import static org.junit.Assert.*;
import java.util.ArrayList;
import javax.swing.JTextArea;
import org.junit.Test;
import GUI.AppInterface;
import commands.AudioCommand;
import commands.OpenDocument;
import commands.RecordAudio;
import commands.ReplayManager;
import model.FakeTTSFacade;

public class ReplayActionTest {

	@Test
	public void test() {

		AppInterface app =new AppInterface();
		
		AudioCommand audioCommand = new AudioCommand(app.toolBar,app.buttons);
		audioCommand.actionPerformed(null);
		RecordAudio recordAudio = new RecordAudio();
		recordAudio.actionPerformed(null);
		
		
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
		
		System.out.println("here");
		
		
		ReplayManager replayManager = new ReplayManager();
		replayManager.actionPerformed(null);
		
		String playedContents = fake.getPlayedContents();
		String replaydContents = replayManager.replay();
		
		
		System.out.println(playedContents);
		System.out.println(replaydContents);
		assertEquals(playedContents,replaydContents);
		
	}
}

/* gia kapoio logo den anoigei ksana to para8yro ths replayManager, opote to test apotygxanei
 * giati to deftero test einai iso me ""
 */
