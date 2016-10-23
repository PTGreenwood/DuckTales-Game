package uq.deco2800.ducktales;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
/**
 * MoviePlayer class for DuckTales.
 * 
 * @author Wenting Wang
 */


public class MoviePlayerController implements Initializable{
    @FXML private  MediaView mv;
    private static MediaPlayer mp;
    private  Media me;
  
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// the method to get the location of mp4 file.
		
		String path = new File("src/main/resources/media/ducktalesdrums.mp4").getAbsolutePath();
		me = new Media(new File(path).toURI().toString());
		mp = new MediaPlayer(me);
		mv.setMediaPlayer(mp);
		// set the video to play automatically 
		mp.setAutoPlay(true);
		/*mp.setOnEndOfMedia(new Runnable() {
		
		    
		    public void run() {
		        // actions here e.g.:
		    	//Platform.exit();
		    }
		});*/
		// set the window automatically to satisfy with the size of video.
		DoubleProperty width = mv.fitWidthProperty();
		DoubleProperty height = mv.fitHeightProperty();
		width.bind(Bindings.selectDouble(mv.sceneProperty(), "width"));
		height.bind(Bindings.selectDouble(mv.sceneProperty(), "height"));
	} 
	
	// function to make the video paused when exiting the window
	public static void closeAudio()
	{
		mp.pause();
	}

}
