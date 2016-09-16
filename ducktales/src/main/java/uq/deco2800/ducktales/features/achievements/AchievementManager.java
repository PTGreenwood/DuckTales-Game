package uq.deco2800.ducktales.features.achievements;

import java.net.URL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import uq.deco2800.ducktales.features.level.LevelHandler;
import uq.deco2800.ducktales.features.missions.MissionHandler;

public class AchievementManager {

	@FXML
	private AnchorPane achievementWindow;
	
	@FXML
	private AnchorPane rightPane;
	
	private BorderPane achievementsMission;
	private BorderPane achievementsLevel;
	private BorderPane achievementProgress;
	
	AchievementHandler achievementMain = AchievementHandler.getInstance();
	AchievementMission achievementMission = AchievementMission.getInstance();
	AchievementLevel achievementLevel = AchievementLevel.getInstance();
	MissionHandler missionMain = MissionHandler.getInstance();
	LevelHandler levelMain = LevelHandler.getInstance();
	AchievementProgressIndicator piMain = AchievementProgressIndicator.getInstance();
	
	@FXML
	private void startAchievementMission(ActionEvent event) throws Exception {
		removeAllPane();
		URL location = getClass().getResource("/achievements/achievement.fxml");
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(location);
		achievementsMission = loader.load();
		
		ImageView achievementMissionImage = new ImageView();
		achievementMissionImage = achievementMission.getAchievementMissionImage();
		Label achievementMissionLabel = new Label();
		achievementMissionLabel = achievementMission.getAchievementMissionLabel();		
		achievementMissionLabel.setFont(new Font("Arial", 24));
		
		setTitleOnTop(achievementsMission,"Mission Achievements");
		achievementsMission.setCenter(achievementMissionImage);
		achievementsMission.setBottom(achievementMissionLabel);
		achievementsMission.setAlignment(achievementMissionLabel, Pos.CENTER);
		achievementsMission.setPrefHeight(rightPane.getHeight());
		achievementsMission.setPrefWidth(rightPane.getWidth());		
		rightPane.getChildren().add(achievementsMission);				
	}	
	
	@FXML
	private void startAchievementLevel(ActionEvent event) throws Exception {
		removeAllPane();
		URL location = getClass().getResource("/achievements/achievementLevel.fxml");
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(location);
		achievementsLevel = loader.load();
		
		ImageView achievementLevelImage = new ImageView();
		achievementLevelImage = achievementLevel.getAchievementLevelImage();
		Label achievementLevelLabel = new Label();
		achievementLevelLabel = achievementLevel.getAchievementLevelLabel();		
		achievementLevelLabel.setFont(new Font("Arial", 24));
		
		setTitleOnTop(achievementsLevel,"Level Achievements");
		achievementsLevel.setCenter(achievementLevelImage);
		achievementsLevel.setBottom(achievementLevelLabel);
		achievementsLevel.setAlignment(achievementLevelLabel, Pos.CENTER);
		achievementsLevel.setPrefHeight(rightPane.getHeight());
		achievementsLevel.setPrefWidth(rightPane.getWidth());		
		rightPane.getChildren().add(achievementsLevel);				
	}
	
	@FXML
	private void startAchievementProgress(ActionEvent event) throws Exception {
		removeAllPane();
		URL location = getClass().getResource("/achievements/achievementProgress.fxml");
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(location);
		achievementProgress = loader.load();
		
		ProgressIndicator  pi1 = new ProgressIndicator();
		pi1 = piMain.getProgressIndicator();
		
		setTitleOnTop(achievementProgress,"Achievement Progress");
		
		achievementProgress.setCenter(pi1);
		achievementProgress.setPrefHeight(rightPane.getHeight());
		achievementProgress.setPrefWidth(rightPane.getWidth());		
		rightPane.getChildren().add(achievementProgress);	
	}
	
	private void setTitleOnTop(BorderPane borderPane, String title){
		Label titleLabel = new Label(title);
		titleLabel.setFont(new Font("Arial", 36));
		borderPane.setTop(titleLabel);
		borderPane.setAlignment(titleLabel, Pos.CENTER);
	}
	
	private void removeAllPane(){
		rightPane.getChildren().removeAll(achievementsLevel,achievementsMission,achievementProgress);
	}
	
	public void showAchievement() {
    	this.achievementWindow.setVisible(true);
	}
	public void hideAchievement() {
		this.achievementWindow.setVisible(false);
	}
}
