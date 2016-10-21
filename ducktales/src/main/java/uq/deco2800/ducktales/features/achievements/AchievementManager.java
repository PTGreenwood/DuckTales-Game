package uq.deco2800.ducktales.features.achievements;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

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
	
	@FXML
	private BorderPane rightPane;
	
	@FXML
	private AnchorPane innerPane;
	
	@FXML
	private Button level;
	@FXML
	private Button mission;
	@FXML
	private Button wood;
	@FXML
	private Button ore;
	
	@FXML
	private Label topLabel;
	@FXML
	private Label bottomLabel;
	@FXML
	private Label achievementMainDescription;
	
	@FXML
	private ImageView achievementImageView;
	@FXML
	private Label achievementDescription;

	private Image ore1 = new Image("achievements/ore100.png");
	
	private Image wood1 = new Image("achievements/wood100.png");
	
	private AchievementLevelController levelController = AchievementLevelController.getInstance();
	private AchievementMissionController missionController = AchievementMissionController.getInstance();
	
	
	public AchievementManager() {
				
	}
	
	public void loadMain() {
		
		this.topLabel.setText("ACHIEVEMENT");
		this.achievementMainDescription.setVisible(true);
		this.achievementDescription.setVisible(false);
		this.achievementImageView.setVisible(false);

	}
	
	private void loadAchievement(String title, String description, Image achievementImage) {
		
		this.topLabel.setText(title);
		this.achievementMainDescription.setVisible(false);
		this.achievementImageView.setVisible(true);
		this.achievementImageView.setImage(achievementImage);
		this.achievementDescription.setVisible(true);
		this.achievementDescription.setText(description);	
		this.achievementDescription.setAlignment(Pos.CENTER);
		
	}
	
	@FXML
	private void loadLevel() {
		
		this.loadAchievement("LEVEL", "Achievement Level Description", 
				this.levelController.getAchievementLevelImage());
		
	}
	
	@FXML
	private void loadMission() {
		
		this.loadAchievement("MISSION", "Achievement Mission Description",
				this.missionController.getAchievementMissionImage());;
			
	}
	
	@FXML
	private void loadOre() {
		
		this.loadAchievement("ORE", "Achievement Ore Description", ore1);
		
	}
	
	@FXML
	private void loadWood() {
		
		this.loadAchievement("WOOD", "Achievement Wood Description", wood1);
		
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
