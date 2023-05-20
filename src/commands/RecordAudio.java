package commands;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RecordAudio implements ActionListener {

	private ReplayManager replayManager;
	
	@Override
	public void actionPerformed(ActionEvent e) {

		replayManager = ReplayManager.getInstance();
		
		if(!replayManager.isActionRecording()) {
			//replayManager.recording = true;
			
			replayManager.startRecording();
		}else {
			//replayManager.recording = false;
			replayManager.endRecording();
		}
	}
}
