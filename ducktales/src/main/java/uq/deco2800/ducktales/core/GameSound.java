package uq.deco2800.ducktales.core;

import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.Mixer;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * Handles all application audio.
 */
public class GameSound {
	private Mixer mixer;
	private Clip clip;

	/**
	 * Loads and plays audio file.
	 * 
	 * @param location Directory of audio file to be played.
	 */
	public void playThisSound(String location){
		Mixer.Info[] mixInfos	=AudioSystem.getMixerInfo();
		/**for(Mixer.Info info: mixInfos){
			System.out.println(  info.getName() +" - - - " + info.getDescription() );
		}
		**/
		mixer = AudioSystem.getMixer(mixInfos[0]);
		DataLine.Info dataInfo = new DataLine.Info(Clip.class, null);
		try { clip =(Clip)mixer.getLine(dataInfo);}
		catch(LineUnavailableException lue){ lue.printStackTrace();}
		
		try {
			URL soundURL = GameSound.class.getResource(location);
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundURL);
			clip.open(audioStream);			
		}
		
		catch(LineUnavailableException lue){lue.printStackTrace();}
		catch(UnsupportedAudioFileException uafe){uafe.printStackTrace();}
		catch(IOException ioe){ ioe.printStackTrace();}
		clip.start();
		
		{
			try{Thread.sleep(50);}
			catch(InterruptedException ie){ie.printStackTrace();}
			
		} while(clip.isActive());
	}
	
	/**
	 * Overlay sounds.
	 * 
	 * @param location Directory of audio file to be overlaid.
	 */
	public void overlayThisSound(String location){
		Mixer.Info[] mixInfos	=AudioSystem.getMixerInfo();
		/**for(Mixer.Info info: mixInfos){
			System.out.println(  info.getName() +" - - - " + info.getDescription() );
		}
		**/
		mixer = AudioSystem.getMixer(mixInfos[0]);
		DataLine.Info dataInfo = new DataLine.Info(Clip.class, null);
		try { clip =(Clip)mixer.getLine(dataInfo);}
		catch(LineUnavailableException lue){ lue.printStackTrace();}
		
		try{
			URL soundURL = GameSound.class.getResource(location);
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundURL);
			clip.open(audioStream);			
		}
		
		catch(LineUnavailableException lue){lue.printStackTrace();}
		catch(UnsupportedAudioFileException uafe){uafe.printStackTrace();}
		catch(IOException ioe){ ioe.printStackTrace();}
		clip.start();
		
		{
			try{Thread.sleep(50);}
			catch(InterruptedException ie){ie.printStackTrace();}
			
		} while(clip.isActive());

	}
	
	/**
	 * Ends playback of current sound.
	 * 
	 * 
	 */
	public void stopSound(){
		
	}
	
}
