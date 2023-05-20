package model;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

public class TTSFacade {

	private static final String VOICENAME = "kevin16";
	private VoiceManager vm;
	private Voice voice;
	
	public TTSFacade() {
		System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
		vm = VoiceManager.getInstance();
		voice = vm.getVoice(VOICENAME);
	}
		
	public void play(String text, int a, int b) {
		
		
		if(voice != null)
			voice.allocate();
		
		try {
			
			if(a == -1 && b == -1) {
				
				String[] lines1 = text.split("\n");
				for(int i =0; i < lines1.length; i++) {
					voice.speak(lines1[i]);
					//voice.getAudioPlayer().begin(a);
				}
			}
			else {
				String[] lines = text.split("\n");
				for(int i = (a-1); i <= (b-a); i++) {
					voice.speak(lines[i]);
				}
			}	
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	
	public void pauseContents() {
		voice.speak("");
		//voice.getAudioPlayer().pause();
	}
	
	public void combineLog() {
		
	}
	
	public void combineReplay() {
		
	}
	
	public float[] getDefaultValues() {
		float[] default_values = new float[3];
		
		default_values[0] = voice.getVolume();
		default_values[1] = voice.getPitch();
		default_values[2] = voice.getRate();
		
		return default_values;
	}
	
	public void setVolume(float d) {
		voice.setVolume(d);
	}
	public void setRate(float d) {
		voice.setRate(d);
	}
	public void setPitch(float d) {
		voice.setPitch(d);
	}
}