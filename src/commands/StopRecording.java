package commands;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StopRecording implements ActionListener {

	private static boolean stopAudio;
	private ReplayManager replayManager= new ReplayManager();
	@Override
	public void actionPerformed(ActionEvent e) {
		stopAudio = false;
		replayManager.endRecording();
	}
	
	public boolean getStopAudio() {
		
		return stopAudio;
	}
}
