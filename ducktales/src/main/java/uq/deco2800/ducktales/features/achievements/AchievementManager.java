package uq.deco2800.ducktales.features.achievements;

import java.net.URL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import uq.deco2800.ducktales.features.level.LevelHandler;
import uq.deco2800.ducktales.features.missions.MissionHandler;

public class AchievementManager {

	@FXML
	private AnchorPane achievementWindow;
	
	@FXML
	private AnchorPane rightPane;
	
	private BorderPane achievements;
	private BorderPane achievementProgress;
	
	AchievementHandler achievementMain = AchievementHandler.getInstance();
	AchievementMission achievementMission = AchievementMission.getInstance();
	MissionHandler missionMain = MissionHandler.getInstance();
	LevelHandler levelMain = LevelHandler.getInstance();
	AchievementProgressIndicator piMain = AchievementProgressIndicator.getInstance();
	
	@FXML
	private void startAchievements(ActionEvent event) throws Exception {
		removeAllPane();
		URL location = getClass().getResource("/achievements/achievement.fxml");
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(location);
		achievements = loader.load();
		
		ImageView achievementMissionImage = new ImageView();
		achievementMissionImage = achievementMission.getAchievementMissionImage();
		
		setTitleOnTop(achievements,"Mission Achievements");
		achievements.setCenter(achievementMissionImage);
		achievements.setPrefHeight(rightPane.getHeight());
		achievements.setPrefWidth(rightPane.getWidth());		
		rightPane.getChildren().add(achievements);				
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
		rightPane.getChildren().removeAll(achievements,achievementProgress);
	}
	
	public void showAchievement() {
    	this.achievementWindow.setVisible(true);
	}
	public void hideAchievement() {
		this.achievementWindow.setVisible(false);
	}
}
