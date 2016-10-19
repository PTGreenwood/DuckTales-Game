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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
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
	private static Logger LOGGER = LoggerFactory.getLogger(
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

	private Image level1 = new Image("achievements/level1.png");
	
	private Image mission1 = new Image("achievements/medalBronze.png");
	
	private Image ore1 = new Image("achievements/ore100.png");
	
	private Image wood1 = new Image("achievements/wood100.png");
	
	private AchievementLevelController levelController = AchievementLevelController.getInstance();
	
	public AchievementManager() {
				
	}
	
	public void loadMain() {
		
		this.topLabel.setText("Achievement");
		this.achievementMainDescription.setVisible(true);
		this.achievementDescription.setVisible(false);
		this.achievementImageView.setVisible(false);
	}
	
	@FXML
	private void loadLevel() {
	
		this.topLabel.setText("LEVEL");
		this.achievementMainDescription.setVisible(false);
		this.achievementImageView.setVisible(true);
		this.achievementImageView.setImage(this.levelController.getAchievementLevelImage());
		this.achievementDescription.setVisible(true);
		this.achievementDescription.setText("Achievement Level Description");	
		this.achievementDescription.setAlignment(Pos.CENTER);
	}
	
	@FXML
	private void loadMission() {
		
		this.topLabel.setText("MISSION");
		this.achievementMainDescription.setVisible(false);
		this.achievementImageView.setVisible(true);
		this.achievementImageView.setImage(mission1);
		this.achievementDescription.setVisible(true);
		this.achievementDescription.setText("Achievement Mission Description");
		this.achievementDescription.setAlignment(Pos.CENTER);		
	}
	
	@FXML
	private void loadOre() {
		this.topLabel.setText("ORE");
		this.achievementMainDescription.setVisible(false);
		this.achievementImageView.setVisible(true);
		this.achievementImageView.setImage(ore1);
		this.achievementDescription.setVisible(true);
		this.achievementDescription.setText("Achievement Ore Description");
		this.achievementDescription.setAlignment(Pos.CENTER);		
	}
	
	@FXML
	private void loadWood() {
		this.topLabel.setText("WOOD");
		this.achievementMainDescription.setVisible(false);
		this.achievementImageView.setVisible(true);
		this.achievementImageView.setImage(wood1);
		this.achievementDescription.setVisible(true);
		this.achievementDescription.setText("Achievement Wood Description");
		this.achievementDescription.setAlignment(Pos.CENTER);		
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
