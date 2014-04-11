
import javax.sound.sampled.*;

public class SaveRoom extends Thread

{

    public void run(){
        try{
        Clip clip = AudioSystem.getClip();
        AudioInputStream inputStream = AudioSystem.getAudioInputStream(this.getClass().getClassLoader().getResourceAsStream("alienworld.wav"));
        clip.open(inputStream);
                clip.loop(Clip.LOOP_CONTINUOUSLY);
        }
        catch(Exception e){System.err.println(e.getMessage());}
        
    }
}