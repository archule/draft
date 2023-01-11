import java.io.File;
import javax.sound.sampled.*;


public class Sounds {

	public static void playMusic(String file, boolean loop) {

		try {
			File path = new File(file);

			if(path.exists()) {
				AudioInputStream audioInput = AudioSystem.getAudioInputStream(path);
				Clip clip = AudioSystem.getClip();
				clip.open(audioInput);

				if(loop) {
					clip.loop(Clip.LOOP_CONTINUOUSLY);
				} else {
					clip.start();
				}
				

			} else{
				System.out.println("Can't find file");
			}
		} catch(Exception e) {
			System.out.println(e);
		}
	}
}