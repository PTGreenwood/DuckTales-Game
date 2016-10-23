package uq.deco2800.ducktales;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException; 
import javax.sound.sampled.AudioFormat; 
import javax.sound.sampled.AudioInputStream; 
import javax.sound.sampled.AudioSystem; 
import javax.sound.sampled.DataLine; 
import javax.sound.sampled.FloatControl; 
import javax.sound.sampled.LineUnavailableException; 
import javax.sound.sampled.SourceDataLine; 
import javax.sound.sampled.UnsupportedAudioFileException; 
 
/**
 *Sound of the game, Extends Thread thus giving functionality to play Asynchronously.
 * 
 * Only Plays Wav files.
 *  
 * @author Wian
 *
 */
public class GameSound extends Thread {
    /** The logger */
    private static final Logger LOGGER = LoggerFactory.getLogger(GameSound.class);

    private Thread thread;
    
    String threadName = "Game Sound";

    private String filename;
 
    private Position curPosition;
 
    
    private static final int externalBufferSize = 524288; // 128Kb 
 
    enum Position { 
        LEFT, RIGHT, NORMAL
    };
 
    /**Constructor takes string as source of the wav file to be played
     * 
     * @param wavfile(String) - Location of the wav sound file to be play
     */
    public GameSound(String wavfile) { 
        filename = wavfile;
        curPosition = Position.NORMAL;
    } 
 
    public GameSound(String wavfile, Position p) { 
        filename = wavfile;
        curPosition = p;
    } 
 
    public void run() { 
 
    	//Creates File with given file name
        File soundFile = new File(filename);
        if (!soundFile.exists()) { 
            //File at location "filename" doesn't exist print File not found
        	LOGGER.info("Wave file is not found: " + filename);
            return;
        } 
 
        //Opens the Audio Stream
        AudioInputStream audioInputStream = null;
        try { 
        	//Try opening audioInputStream with given sound file
            audioInputStream = AudioSystem.getAudioInputStream(soundFile);
        } 
        
        //Catch Exceptions
        catch (UnsupportedAudioFileException e) {
            LOGGER.debug("Audio file unsupported", e);
            return;
        } catch (IOException e) {
            LOGGER.debug("Unable to open audio file", e);
            try {
				audioInputStream.close();
			} catch (IOException exception) {
				exception.printStackTrace();
			}
            return;
        }
 
        //Get audio format
        AudioFormat format = audioInputStream.getFormat();
        SourceDataLine auline = null;
        DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);
 
        try { 
            auline = (SourceDataLine) AudioSystem.getLine(info);
            auline.open(format);
        } catch (LineUnavailableException e) { 
            LOGGER.debug("line unavailable", e);
            return;
        } catch (Exception e) { 
            LOGGER.debug("not sure what happened here", e);
            auline.close();
            return;
        }
 
        if (auline.isControlSupported(FloatControl.Type.PAN)) { 
            FloatControl pan = (FloatControl) auline
                    .getControl(FloatControl.Type.PAN);
            if (curPosition == Position.RIGHT) 
                pan.setValue(1.0f);
            else if (curPosition == Position.LEFT) 
                pan.setValue(-1.0f);
        } 
 
        auline.start();
        int nBytesRead = 0;
        byte[] abData = new byte[externalBufferSize];
 
        try { 
            while (nBytesRead != -1) { 
                nBytesRead = audioInputStream.read(abData, 0, abData.length);
                if (nBytesRead >= 0) 
                    auline.write(abData, 0, nBytesRead);
            } 
        } catch (IOException e) { 
            LOGGER.debug("unable to open file", e);
            return;
        } finally { 
            auline.drain();
            auline.close();
        } 
 
    }
    
    public void start() {
    	LOGGER.debug("Attempting to start a new thread for the game sound");
    	if (thread == null) {
    		thread = new Thread(this, threadName);
    		thread.start();
    	}
    	
    }
} 