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
	
	/** right pane of main window */
	@FXML
	private AnchorPane rightPane;
	
	/** Buttons on leftpane of the main window */
	@FXML
	private Button tutorial;
	@FXML
	private Button main;
	@FXML
	private Button progress;
	@FXML
	private Button Secret;
	
	/** title label */
	@FXML
	private Label topLabel;
	
	// Logger for the class
	private static final Logger LOGGER = Logger.getLogger(MissionManager.class.getName());
			
	/** Initialize classes */
	private MissionHandler missionMain = MissionHandler.getInstance();
	private LevelHandler levelMain = LevelHandler.getInstance();	
	private MissionMainController missionMainController;
	private MissionTutorialController missionTutorialController;
	private MissionProgressController missionProgressConroller;
	private MissionGameController missionGameController;
	private MissionSecretController missionSecretController;
	
	/**
	 * Main constructor of {@link Missions} class
	 * 
	 */
	public MissionManager() {
		
		this.missionMainController = new MissionMainController();
		this.missionTutorialController = new MissionTutorialController();
		this.missionProgressConroller = new MissionProgressController();
		this.missionGameController = new MissionGameController();
		this.missionSecretController = new MissionSecretController();
	}
	
	/**
	 * Load main mission window.
	 */
	public void loadMain() {
		
		this.removeAllPane();
		
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
	
	/**
	 * Remove all pane
	 */
	private void removeAllPane() {
		rightPane.getChildren().removeAll(missionMainController.getMainWindow(), 
				this.missionTutorialController.getMainWindow(),
				this.missionProgressConroller.getMainWindow(),
				this.missionGameController.getMainWindow(),
				this.missionSecretController.getMainWindow());
	}
	
	/**
	 * Load the mission window with mission progress circle 
	 */
	@FXML
	private void loadProgress() {
				
		this.removeAllPane();
		
		URL location = getClass().getResource("/missions/missionProgress.fxml");
												
		FXMLLoader loader = new FXMLLoader(location);
		
		try {
			BorderPane root = loader.load();
			
			missionProgressConroller = loader.getController();
			
			this.missionProgressConroller.setProgressPercentage(missionMain.getNumberOfCompletedMissions()/6);
			root.setCenter(this.missionProgressConroller.getProgressIndicator());
			
			
			rightPane.getChildren().add(root);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			LOGGER.log(Level.SEVERE, e.toString(), e);
		}
	}
		
	/**
	 * Load tutorial missions window
	 */
	@FXML
	private void loadTutorial() {		
		
		this.removeAllPane();
		
		URL location = getClass().getResource("/missions/missionTutorial.fxml");
												
		FXMLLoader loader = new FXMLLoader(location);
		
		try {
			BorderPane root = loader.load();
			
			missionTutorialController = loader.getController();
			
			this.missionTutorialController.getBox1().setImage(
					missionMain.getmissionImageCompleted(0));
			this.missionTutorialController.getBox2().setImage(
					missionMain.getmissionImageCompleted(1));
			this.missionTutorialController.getBox3().setImage(
					missionMain.getmissionImageCompleted(2));
			
			rightPane.getChildren().add(root);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			LOGGER.log(Level.SEVERE, e.toString(), e);
		}
		
	}
	
	/**
	 * Load main game mission window
	 */
	@FXML
	private void loadGame() {		
		
		this.removeAllPane();
		
		URL location = getClass().getResource("/missions/missionGame.fxml");
												
		FXMLLoader loader = new FXMLLoader(location);
		
		try {
			BorderPane root = loader.load();
			
			missionGameController = loader.getController();
			
			this.missionGameController.getBox1().setImage(
					missionMain.getmissionImageCompleted(3));
			this.missionGameController.getBox2().setImage(
					missionMain.getmissionImageCompleted(4));
			this.missionGameController.getBox3().setImage(
					missionMain.getmissionImageCompleted(5));
			
			rightPane.getChildren().add(root);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			LOGGER.log(Level.SEVERE, e.toString(), e);
		}
		
	}
	
	/**
	 * load secret mission window.
	 */
	@FXML
	private void loadSecret() {
		
		this.removeAllPane();
		
		URL location = getClass().getResource("/missions/missionSecret.fxml");
												
		FXMLLoader loader = new FXMLLoader(location);
		
		try {
			BorderPane root = loader.load();
			
			missionSecretController = loader.getController();
			
			if (levelMain.getLevel() == 2) {
				missionSecretController.getMission1().setText(" 1. Secret Mission 1");
			} else if (levelMain.getLevel() == 3) {
				missionSecretController.getMission1().setText(" 1. Secret Mission 1");
				missionSecretController.getMission2().setText(" 2. Secret Mission 2");
			}
			
			this.missionSecretController.getBox1().setImage(
					missionMain.getmissionImageCompleted(6));
			this.missionSecretController.getBox2().setImage(
					missionMain.getmissionImageCompleted(7));
			
			
			rightPane.getChildren().add(root);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			LOGGER.log(Level.SEVERE, e.toString(), e);
		}
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
        
        this.missionProgressConroller.getProgressIndicator().setProgress(0.2);
        
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
