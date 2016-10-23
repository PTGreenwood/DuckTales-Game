package uq.deco2800.ducktales.features.achievements;

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
 * @author Naehyung Kim and Joshua You
 * 
 */
public class AchievementManager {
	
	/** Main window */
	@FXML
	private AnchorPane achievementWindow;	
	
	/** Right pane of the main window */
	@FXML
	private BorderPane rightPane;
	
	/** Inner pane of the rightPane */
	@FXML
	private AnchorPane innerPane;
	
	/** Buttons on left Pane of the main window */
	@FXML
	private Button level;
	@FXML
	private Button mission;
	@FXML
	private Button wood;
	@FXML
	private Button ore;
	@FXML
	private Button peons;
	@FXML
	private Button threats;
	@FXML
	private Button food;
	
	/** Title label in rightPane */
	@FXML
	private Label topLabel;
	
	/** Label at the bottom in rightPane */
	@FXML
	private Label bottomLabel;
	
	/** Label for Achievement Description */
	@FXML
	private Label achievementMainDescription;
	
	/** ImageView for achievement */
	@FXML
	private ImageView achievementImageView;
	
	/** Description of each achievement */
	@FXML
	private Label achievementDescription;
	
	private Image peons1 = new Image("peon/basic_peon.png");
	
	/** Initialize classes */
	private AchievementLevelController levelController = AchievementLevelController.getInstance();
	private AchievementMissionController missionController = AchievementMissionController.getInstance();
	private AchievementScoreController scoreController = AchievementScoreController.getInstance();
	private AchievementOreController oreController = AchievementOreController.getInstance();
	private AchievementWoodController woodController = AchievementWoodController.getInstance();
	
	/**
	 * Main constructor of {@link Achievement} class
	 * 
	 */
	public AchievementManager() {
				
	}
	
	/**
	 *  Load Main window for achievement. It contains Achievement Title and description of Achievement.
	 */
	public void loadMain() {
		
		this.topLabel.setText("ACHIEVEMENT");
		this.bottomLabel.setText("Achievement Score : " + this.scoreController.achievementHolder());
		this.achievementMainDescription.setVisible(true);
		this.achievementDescription.setVisible(false);
		this.achievementImageView.setVisible(false);

	}
	
	/**
	 * This method set the basic design of the achievement with its title, image and description.
	 * @param title Title of the Achievement such as Ore, Wood, Peons...
	 * @param description Description of the Achievement
	 * @param achievementImage Image of the Achievement
	 */
	private void loadAchievement(String title, String description, Image achievementImage) {
		
		this.topLabel.setText(title);
		this.achievementMainDescription.setVisible(false);
		this.achievementImageView.setVisible(true);
		this.achievementImageView.setImage(achievementImage);
		this.achievementDescription.setVisible(true);
		this.achievementDescription.setText(description);	
		this.achievementDescription.setAlignment(Pos.CENTER);
		
	}
	
	/**
	 * Load level achievement in the Achievement GUI.
	 */
	@FXML
	private void loadLevel() {
		
		this.loadAchievement("LEVEL", "Your achievement level of level is the same level as your level.", 
				this.levelController.getAchievementLevelImage());
		
	}
	
	/**
	 * Load Misison Achievement in the Achievement GUI.
	 */
	@FXML
	private void loadMission() {
		
		this.loadAchievement("MISSION", "Your missions completion level.",
				this.missionController.getAchievementMissionImage());;
			
	}
	
	/**
	 * Load Ore Achievement in the Achievement GUI.
	 */
	@FXML
	private void loadOre() {
		
		this.loadAchievement("ORE", "You have collected many ores and that is good. Good job.",
			this.oreController.getAchievementOreImage());;
			
	}
	
	/**
	 * Load Wood Achievement in the Achievement GUI.
	 */
	@FXML
	private void loadWood() {
		
		this.loadAchievement("WOOD", "You're a true lumberjack. This is your wood gathering level.",
				this.woodController.getAchievementWoodImage());;
		
	}
	
	/**
	 * Load Peon Achievement in the Achievement GUI.
	 */
	@FXML
	private void loadPeons() {
		
		this.loadAchievement("PEONS", "You have many peons to live for eons.", peons1);
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
