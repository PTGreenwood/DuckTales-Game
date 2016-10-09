package uq.deco2800.ducktales.features.missions;

import java.net.URL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.control.ProgressIndicator;
import uq.deco2800.ducktales.features.achievements.AchievementHandler;
import uq.deco2800.ducktales.features.level.LevelHandler;

/**
 * Handles in-game mission methods.
 * 
 *@author Naehyung Kim
 *
 */
public class MissionManager {
	
	/** Main window */
	@FXML	
	private AnchorPane missionWindow;
	
	/** Right Pand of the window */
	@FXML
	private AnchorPane rightPane;
	
	/** Buttons on left Pane */
	@FXML
	private Button Missions, MissionProgress;
	
	private BorderPane gameMission1;
	private BorderPane achievement;
	
	private Label titleLabel;
	
	/** Initialize classes */
	AchievementHandler achievementMain = AchievementHandler.getInstance();
	MissionHandler missionMain = MissionHandler.getInstance();
	LevelHandler levelMain = LevelHandler.getInstance();
	MissionProgressIndicator piMain = MissionProgressIndicator.getInstance();	
		
	/**
	 * Starts gameMission1.
	 * 
	 * @param event
	 * @throws Exception
	 */	
	@FXML
	public void startMission1(ActionEvent event) throws Exception {
		
		removeAllPane();
		URL location = getClass().getResource("/missions/mission3.fxml");
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(location);
		gameMission1 = loader.load();
		
		GridPane missions = new GridPane();		
		
		missions.setVgap(10);
		missions.add(createMission("1.Press T to open Tutorial :  ", 0), 0, 1);
		missions.add(createMission("2.Press H to open Achievement :  ", 1), 0, 2);		
		missions.add(createMission("3.Press M to open Marketplace :  ", 2), 0, 3);
		
		ScrollPane scroll = new ScrollPane(missions);
		
		setTitleOnTop(gameMission1,"Missions");
		
		gameMission1.setCenter(scroll);		
		gameMission1.setPrefHeight(rightPane.getHeight());
		gameMission1.setPrefWidth(rightPane.getWidth());		
		
		rightPane.getChildren().add(gameMission1);		
	}
		
	/**
	 * Starts Mission Progress
	 * .
	 * @param event
	 * @throws Exception
	 */
	@FXML
	public void startMissionProgress(ActionEvent event) throws Exception {
		
		removeAllPane();
		URL location = getClass().getResource("/missions/achievement.fxml");
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(location);
		achievement = loader.load();
		
		ProgressIndicator  pi1 = new ProgressIndicator();
		pi1 = piMain.getProgressIndicator();
		setTitleOnTop(achievement,"Mission Progress");
		
		achievement.setCenter(pi1);		
		achievement.setPrefHeight(rightPane.getHeight());
		achievement.setPrefWidth(rightPane.getWidth());		
		
		rightPane.getChildren().add(achievement);
	}	
	
	/**
	 * Create mission with label with String and tick box
	 * 
	 * @param missionName
	 * @param missionNumber
	 * @return
	 */
	private HBox createMission(String missionName, int missionNumber) {
		Label mission = new Label(missionName);
		mission.setFont(new Font("Arial", 24));
		ImageView missionBox = new ImageView();
		missionBox = MissionHandler.getInstance().getMissionImageCompleted(missionNumber);
		HBox missionHBox = new HBox();
		missionHBox.getChildren().addAll(mission,missionBox);
		return missionHBox;
	}
	
	/**
	 * Set the title on the top of the borderPane
	 * 
	 * @param borderPane
	 * @param title
	 */
	private void setTitleOnTop(BorderPane borderPane, String title) {
		titleLabel = new Label(title);
		titleLabel.setId("titleLabel");
		titleLabel.setFont(new Font("Press Start 2P", 36));
		borderPane.setTop(titleLabel);
		borderPane.setAlignment(titleLabel, Pos.CENTER);
	}
	
	/**
	 * Remove all panes
	 * 
	 */
	private void removeAllPane() {
		rightPane.getChildren().removeAll(gameMission1,achievement);
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
		missionMain.MissionImageCompleted(missionNumber);
		
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
