package uq.deco2800.ducktales.features.time;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import uq.deco2800.ducktales.util.SecondaryManager;
import uq.deco2800.ducktales.util.Tickable;
import uq.deco2800.ducktales.GameManager;
import uq.deco2800.ducktales.rendering.worlddisplay.WorldDisplayManager;

import java.net.URL;
import java.util.ResourceBundle;


/**
 * This manager controls the time display by retrieving time info from GameTime
 *
 * Created on 9/09/2016.
 */
public class TimeManager implements SecondaryManager, Initializable, Tickable {

    /** The root pane for all the time display elements */
    @FXML
    private AnchorPane timeDisplay;
    @FXML
    private Text timeDisplayText;
    @FXML
    private Text dayDisplayText;

    /** The model for the game time */
    private GameTime gameTime;

    /**
     * This method is called when GameController initializes the time display using
     * FXMLLoader, and so FXMLLoader will make an instance of this class and call
     * initialized()
     *
     * @param location
     *          The location of this class
     * @param resources
     *          The resources passed to FXMLLoader
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Start the game time
        gameTime = new GameTime();
    }


    @Override
    public void reload() {

    }


    @Override
    public void tick() {

        gameTime.tick();

//        System.err.println("hour and minute: " + gameTime.getHour() + ", " + gameTime.getMinute());

        if (gameTime != null) {
            // Display the new time\
        	final int year = gameTime.getCurrentYear();
            final int day = gameTime.getCurrentDay();
            final int hour = gameTime.getHour();
            final String minute = String.format("%02d", gameTime.getMinute());
            final String timeText = "Current Time is: " + hour + ":" + minute + ", Day " + day + " Year " + year;
            
            // this is needed, since this UI update is called from another thread
            // (GameLoop runs on another thread and not the main FXApplication thread)
            // IN REGARDS TO TIME ALL CALL TO UI CHANGES MUST GO INSIDE THIS METHOD CALL

            Platform.runLater(() -> {
                timeDisplayText.setText(hour + ":" + minute);
                dayDisplayText.setText("DAY "+day);
            });
            
        }
    }
    
	/** 
	 * Is it night time or day time?
	 * 
	 * @return true if night time. False if day time
	 */
	public boolean isNight() {
		if((gameTime.getHour() >= 5)) { //||
				//(gameTime.getHour() <= gameTime.season.getTimeDayBreak())) {
			return true;
		} else {
			return false;
		}
		
	}
	
	public void setTime(int hour) {
		gameTime.setHour(hour);
	}
	
	/**
	 * Gets the current gameTime Object
	 * This was added in for a test. Will probably remove later.
	 * @return gameTime
	 * 			- The GameTime object being managed done
	 */
    public GameTime getGameTimeObject() {
    	return this.gameTime;
    }

}
