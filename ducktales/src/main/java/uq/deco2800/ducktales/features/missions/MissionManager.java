package uq.deco2800.ducktales.features.missions;

import java.net.URL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.control.ProgressIndicator;
import uq.deco2800.ducktales.features.achievements.AchievementHandler;
import uq.deco2800.ducktales.features.level.LevelHandler;

/**
 * Handles in-game mission methods.
 * 
 *
 */
public class MissionManager {
	
	@FXML	
	private AnchorPane missionWindow;
	
	@FXML
	private AnchorPane rightPane;
	
	private BorderPane gameMission1;
	private BorderPane achievement;
	
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
		missions.add(createMission("1.Click level button :  ", 0), 0, 1);
		missions.add(createMission("2.Click achievement button :  ", 1), 0, 2);		
		missions.add(createMission("3.Click marketplace button :  ", 2), 0, 3);
		
		ScrollPane scroll = new ScrollPane(missions);
		
		setTitleOnTop(gameMission1,"Missions");
		
		gameMission1.setCenter(scroll);		
		gameMission1.setPrefHeight(rightPane.getHeight());
		gameMission1.setPrefWidth(rightPane.getWidth());		
		
		rightPane.getChildren().add(gameMission1);		
	}
		
	/**
	 * Starts achievement.
	 * @param event
	 * @throws Exception
	 */
	@FXML
	public void startachievement(ActionEvent event) throws Exception {
		
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
	
	private HBox createMission(String missionName, int missionNumber){
		Label mission = new Label(missionName);
		mission.setFont(new Font("Arial", 24));
		ImageView missionBox = new ImageView();
		missionBox = MissionHandler.getInstance().getMissionImageCompleted(missionNumber);
		HBox missionHBox = new HBox();
		missionHBox.getChildren().addAll(mission,missionBox);
		return missionHBox;
	}
	
	private void setTitleOnTop(BorderPane borderPane, String title){
		Label titleLabel = new Label(title);
		titleLabel.setFont(new Font("Arial", 36));
		borderPane.setTop(titleLabel);
		borderPane.setAlignment(titleLabel, Pos.CENTER);
	}
	
	private void removeAllPane(){
		rightPane.getChildren().removeAll(gameMission1,achievement);
	}
	
	public void missionCompletedAction(int missionNumber){
    	
    	//Untick mission2 box in Achievement window of Gamebeta when marketplace is clicked
		missionMain.MissionImageCompleted(missionNumber);
        //Increment percentage of progress indicator in achievement
        missionMain.countNumberOfCompletedMissions();
        if(levelMain.getProgressIndicator().getProgress() == 1.0) {
        	levelMain.levelUp();
        }
            
        
    }
	
	public void showMission() {
    	this.missionWindow.setVisible(true);
	}
	public void hideMission() {
		this.missionWindow.setVisible(false);
	}
}
