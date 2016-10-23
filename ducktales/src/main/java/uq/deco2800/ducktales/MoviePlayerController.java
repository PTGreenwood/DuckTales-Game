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
 * Controller for the introduction video as defined in MoviePlayer.fxml.
 * 
 * @author Wenting Wang
 */
public class MoviePlayerController implements Initializable{
    @FXML private  MediaView mediaView;
    private static MediaPlayer mediaPlayer;
    private  Media media;
  
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// the method to get the location of mp4 file.
		
		String path = new File("src/main/resources/media/ducktalesdrums.mp4").getAbsolutePath();
		media = new Media(new File(path).toURI().toString());
		mediaPlayer = new MediaPlayer(media);
		mediaView.setMediaPlayer(mediaPlayer);
		// set the video to play automatically 
		mediaPlayer.setAutoPlay(true);
		/*mp.setOnEndOfMedia(new Runnable() {
		
		    
		    public void run() {
		        // actions here e.g.:
		    	//Platform.exit();
		    }
		});*/
		// set the window automatically to satisfy with the size of video.
		DoubleProperty width = mediaView.fitWidthProperty();
		DoubleProperty height = mediaView.fitHeightProperty();
		width.bind(Bindings.selectDouble(mediaView.sceneProperty(), "width"));
		height.bind(Bindings.selectDouble(mediaView.sceneProperty(), "height"));
	} 
	
	// function to make the video paused when exiting the window
	public static void closeAudio()
	{
		mediaPlayer.stop();
		mediaPlayer.dispose();
	}

}
