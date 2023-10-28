package Engine;
import java.io.File; 
import java.io.IOException; 
import java.util.Scanner; 
  
import javax.sound.sampled.AudioInputStream; 
import javax.sound.sampled.AudioSystem; 
import javax.sound.sampled.Clip; 
import javax.sound.sampled.LineUnavailableException; 
import javax.sound.sampled.UnsupportedAudioFileException;
public class Music {
    //to store current position
    Long currentFrame;
    Clip clip;

    //current status of clip
    String status;

    AudioInputStream audioInputStream;
    static String filePath;

    //constructor to initialize streams and clip
    public Music(String filePath)
        {
            try{
                //create audioinputstream object
                audioInputStream = AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile());

                //create clip reference
                clip = AudioSystem.getClip();

                //open audioinputstream to the clip
                clip.open(audioInputStream);

                clip.loop(Clip.LOOP_CONTINUOUSLY);
                clip.start();
            }
            catch(IOException e){
                e.printStackTrace();
            }
            catch(UnsupportedAudioFileException e){
                e.printStackTrace();
            }
            catch(LineUnavailableException e){
                e.printStackTrace();
            }
        
    }
    //adds a way to make it not loop Ex: for a blast
    public Music(String filePath,int key)
        {
            try{
                //create audioinputstream object
                audioInputStream = AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile());

                //create clip reference
                clip = AudioSystem.getClip();

                //open audioinputstream to the clip
                clip.open(audioInputStream);
                clip.start();
                //restart();
            }
            catch(IOException e){
                e.printStackTrace();
            }
            catch(UnsupportedAudioFileException e){
                e.printStackTrace();
            }
            catch(LineUnavailableException e){
                e.printStackTrace();
            }
        
    }
    //restarts clip
    public void restart() throws IOException, LineUnavailableException, 
                                            UnsupportedAudioFileException  
    { 
        clip.stop(); 
        clip.close(); 
        resetAudioStream(); 
        currentFrame = 0L; 
        clip.setMicrosecondPosition(0); 
        this.play(); 
    } 
    // Method to reset audio stream 
    public void resetAudioStream() throws UnsupportedAudioFileException, IOException, 
                                            LineUnavailableException  
    { 
        audioInputStream = AudioSystem.getAudioInputStream( 
        new File(filePath).getAbsoluteFile()); 
        clip.open(audioInputStream); 
        clip.loop(Clip.LOOP_CONTINUOUSLY); 
    } 
    public void play()  
    { 
        //start the clip 
        clip.start(); 
          
        status = "play"; 
    } 
}   
