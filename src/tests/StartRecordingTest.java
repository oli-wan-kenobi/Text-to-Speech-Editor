package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import commands.RecordAudio;
import commands.ReplayManager;

class StartRecordingTest {

	@Test
	void test() {
		
		RecordAudio recordAudio = new RecordAudio();
		
		ReplayManager replayManager = new ReplayManager();
		
		Boolean before = replayManager.isActionRecording();
		System.out.println("Recording: "+before);
		recordAudio.actionPerformed(null);
		
		Boolean after = replayManager.isActionRecording();
		System.out.println("Recording: "+after);
		
		assertNotEquals(before,after);
	}

}


/* de sysxetizoume to record ths ka8e prakshs me ena document opote, gi afto den yparxei sto test */