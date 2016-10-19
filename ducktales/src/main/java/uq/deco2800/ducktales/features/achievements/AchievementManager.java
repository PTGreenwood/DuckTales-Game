package uq.deco2800.ducktales.features.achievements;

import java.io.IOException;
import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import uq.deco2800.ducktales.features.level.LevelHandler;
import uq.deco2800.ducktales.features.missions.MissionHandler;

/**
 * Manage all fxml action of the achievement 
 * 
 * @author Naehyung Kim
 * 
 */
public class AchievementManager {
	/** The logger for all messages and exceptions */
	private static Logger logger = LoggerFactory.getLogger(
			AchievementManager.class);
	
	/** Main window */
	@FXML
	private AnchorPane achievementWindow;	
	
	/** Right Pane of the window */
	@FXML
	private AnchorPane rightPane;
	
	/** Buttons on left Pane */
	@FXML
	private Button achievementMissionBtn;
	@FXML
	private Button achievementLevelBtn;
	
	private BorderPane achievementsMission;
	private BorderPane achievementsLevel;
	
	private Label titleLabel;
	
	/** Initialize classes */	
	AchievementHandler achievementMain = AchievementHandler.getInstance();
	AchievementMission achievementMission = AchievementMission.getInstance();
	AchievementLevel achievementLevel = AchievementLevel.getInstance();
	MissionHandler missionMain = MissionHandler.getInstance();
	LevelHandler levelMain = LevelHandler.getInstance();
	
	/**
	 * Start mission achievement
	 * 
	 * @param event
	 * @throws Exception
	 */
	@FXML
	private void startAchievementMission() {
		
		removeAllPane();
		URL location = getClass().getResource("/achievements/achievement.fxml");
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(location);
		try {
			achievementsMission = loader.load();
			ImageView achievementMissionImage = achievementMission
					.getAchievementMissionImage();
			Label achievementMissionLabel = achievementMission.getAchievementMissionLabel();
			achievementMissionLabel.setFont(new Font("Arial", 24));
			
			setTitleOnTop(achievementsMission,"Mission");
			achievementsMission.setCenter(achievementMissionImage);
			achievementsMission.setBottom(achievementMissionLabel);
			achievementsMission.setAlignment(achievementMissionLabel, Pos.CENTER);
			achievementsMission.setPrefHeight(rightPane.getHeight());
			achievementsMission.setPrefWidth(rightPane.getWidth());		
			rightPane.getChildren().add(achievementsMission);		
		} catch (IOException e) {
			logger.info("Unable to start Achievement GUI", e);
		}
		
				
	}	
	
	/**
	 * Start level achievement
	 * 
	 * @param event
	 * @throws Exception
	 */
	@FXML
	private void startAchievementLevel() {
		
		removeAllPane();
		URL location = getClass().getResource("/achievements/achievementLevel.fxml");
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(location);
		try {
			achievementsLevel = loader.load();
			ImageView achievementLevelImage = achievementLevel.getAchievementLevelImage();
			Label achievementLevelLabel = achievementLevel.getAchievementLevelLabel();
			achievementLevelLabel.setFont(new Font("Arial", 24));
			
			setTitleOnTop(achievementsLevel,"Level");
			achievementsLevel.setCenter(achievementLevelImage);
			achievementsLevel.setBottom(achievementLevelLabel);
			achievementsLevel.setAlignment(achievementLevelLabel, Pos.CENTER);
			achievementsLevel.setPrefHeight(rightPane.getHeight());
			achievementsLevel.setPrefWidth(rightPane.getWidth());		
			rightPane.getChildren().add(achievementsLevel);
		} catch (IOException e) {
			logger.info("Unable to start Achievement GUI", e);
		}
		
						
	}
		
	/**
	 * Set the title on the top of the borderPane
	 * 	
	 * @param borderPane
	 * @param title
	 */
	private void setTitleOnTop(BorderPane borderPane, String title){
		
		titleLabel = new Label(title);
		titleLabel.setId("titleLabel");
		titleLabel.setFont(new Font("Press Start 2P", 36));
		borderPane.setTop(titleLabel);
		borderPane.setAlignment(titleLabel, Pos.CENTER);
	}
	
	/**
	 * Remove all panes
	 */
	private void removeAllPane() {
		rightPane.getChildren().removeAll(achievementsLevel, achievementsMission);
	}
	
	/**
	 * Show and hide main window
	 */
	public void showAchievement() {
    	this.achievementWindow.setVisible(true);
	}
	public void hideAchievement() {
		this.achievementWindow.setVisible(false);
	}
	//@mattyleggy, added this is for in-game keyboard handler
	/**
	 * Toggle between visible and invisible for achievement window. 
	 */
	public void toggleAchievement() {
		if (this.achievementWindow.isVisible())
			hideAchievement();
		else
			showAchievement();
	}
	public boolean isVisible() {
		return this.achievementWindow.isVisible();
	}
}
