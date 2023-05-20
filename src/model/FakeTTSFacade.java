package model;

public class FakeTTSFacade extends TTSFacade {

	private static String playedContents;
	private static float volume, rate, pitch;

	public FakeTTSFacade() {}

	public void fakePlay(String text, int a, int b) {
		FakeTTSFacade.playedContents = text;
		super.play(text, -1, -1);
	}

	public String getPlayedContents() {
		System.out.println("Played Contents: " + FakeTTSFacade.playedContents);
		return FakeTTSFacade.playedContents;
	}	
	
	public void setVolume(float volume) {
		FakeTTSFacade.volume = volume;
		super.setVolume(volume);
	}
	public void setRate(float rate) {
		FakeTTSFacade.rate = rate;
		super.setRate(rate);
	}
	public void setPitch(float pitch) {
		FakeTTSFacade.pitch = pitch;
		super.setPitch(pitch);
	}

	public float getVolume() {
		return FakeTTSFacade.volume;
	}

	public float getRate() {
		return FakeTTSFacade.rate;
	}

	public float getPitch() {
		return FakeTTSFacade.pitch;
	}

}
