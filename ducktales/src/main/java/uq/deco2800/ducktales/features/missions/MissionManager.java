package uq.deco2800.ducktales.features.missions;

import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import uq.deco2800.ducktales.features.achievements.AchievementHandler;
import uq.deco2800.ducktales.features.level.LevelHandler;

/**
 * Manages in-game mission methods.
 * 
 *@author Naehyung Kim
 *
 */
public class MissionManager {
	
	/** Main window */
	@FXML	
	private AnchorPane missionWindow;
	
	@FXML
	private AnchorPane rightPane;
	
	
	@FXML
	private Button tutorial;
	@FXML
	private Button main;
	@FXML
	private Button progress;
	
	@FXML
	private Label topLabel;
	
	// Logger for the class
	private static final Logger LOGGER = Logger.getLogger(MissionManager.class.getName());
			
	/** Initialize classes */
	private AchievementHandler achievementMain = AchievementHandler.getInstance();
	private MissionHandler missionMain = MissionHandler.getInstance();
	private LevelHandler levelMain = LevelHandler.getInstance();
	private MissionProgressIndicator piMain = MissionProgressIndicator.getInstance();	
	
	private MissionMainController missionMainController = MissionMainController.getInstance();
		
	public MissionManager() {
	}
	
	public void loadMain() {
		
		URL location = getClass().getResource("/missions/missionMain.fxml");
												
		FXMLLoader loader = new FXMLLoader(location);
		
		try {
			BorderPane root = loader.load();
			
			missionMainController = loader.getController();
			
			rightPane.getChildren().add(root);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			LOGGER.log(Level.SEVERE, e.toString(), e);
		}
	}
	
	@FXML
	private void loadTutorial() {
				
	}
		
	@FXML
	private void loadProgress() {		
		
	}
	
	/**
	 * Actions when the certain mission is completed
	 * 
	 * @param missionNumber
	 */
	public void missionCompletedAction(int missionNumber) {
		
		//Increment percentage of progress bar of level
		if(missionMain.getCountCompletedMissions()[missionNumber] == 0) {			
			levelMain.addProgressBar(0.5);
			System.out.println("Mission " + (missionNumber + 1) + " Completed!");
	    }
		
		//Untick mission2 box in Achievement window of Gamebeta when marketplace is clicked
		missionMain.missionImageCompleted(missionNumber);
		
        //Increment percentage of progress indicator in achievement
        missionMain.countNumberOfCompletedMissions();
        
        //If progress indicator is full then level up
        if(levelMain.getProgressBar().getProgress() >= 1.0) {
        	levelMain.levelUp();
        }        
        
    }
	
	/**
	 * Show and Hide mission main window
	 * 
	 */
	public void showMission() {
    	this.missionWindow.setVisible(true);
	}
	public void hideMission() {
		this.missionWindow.setVisible(false);
	}
	//@mattyleggy, added this is for in-game keyboard handler
	public void toggleMission() {
		if (this.missionWindow.isVisible())
			hideMission();
		else
			showMission();
	}
	public boolean isVisible() {
		return this.missionWindow.isVisible();
	}
}
