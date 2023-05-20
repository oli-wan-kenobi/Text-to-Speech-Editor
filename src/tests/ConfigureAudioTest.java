package tests;

import static org.junit.Assert.*;

import org.junit.Test;
import model.FakeTTSFacade;

public class ConfigureAudioTest {

	@Test
	public void test() {
		float v = 40;
		float r = 200;
		float p = 200;
		String text = "Hello World 1 2 3";
		
		
		FakeTTSFacade fake = new FakeTTSFacade();
		fake.play(text, -1, -1);
		float volume = fake.getVolume();
		float rate = fake.getRate();
		float pitch = fake.getPitch();
		System.out.println("Volume: "+volume);
		System.out.println("Rate: "+rate);
		System.out.println("pitch: "+pitch);
		
		System.out.println("After Tuning\n");
		fake.setVolume(v);
		fake.setRate(r);
		fake.setPitch(p);
		float volume2 = fake.getVolume();
		float rate2 = fake.getRate();
		float pitch2 = fake.getPitch();
		System.out.println("Volume: "+volume);
		System.out.println("Rate: "+rate);
		System.out.println("pitch: "+pitch);
		fake.play(text, -1, -1);
		assertNotEquals(volume2, volume);
		assertNotEquals(rate2, rate);
		assertNotEquals(pitch2, pitch);
	}

}
