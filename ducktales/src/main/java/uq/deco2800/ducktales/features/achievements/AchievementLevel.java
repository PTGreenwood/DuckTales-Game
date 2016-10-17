package uq.deco2800.ducktales.features.achievements;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import uq.deco2800.ducktales.features.level.LevelHandler;

/**
 * Contains all methods of level achievement
 * 
 * @author Naehyung Kim
 *
 */
public class AchievementLevel {
	
	private LevelHandler levelHandler = LevelHandler.getInstance();
	
	/**
	 * Load bronze, silver, gold medal images
	 */
	private Image bronze = new Image("/achievements/bronzeMedal.png");
	private Image silver = new Image("/achievements/silverMedal.png");
	private Image gold = new Image("/achievements/goldMedal.png");
	private Label missionAchievementLabel;
	
	private static final AchievementLevel INSTANCE = new AchievementLevel();
	
	/**
	 * Constructor of {@link Achievement}
	 * 
	 * @return <CODE>INSTANCE</CODE>
	 */
	public static AchievementLevel getInstance() {
		return INSTANCE;
	}	
	
	/**
	 * Main constructor of {@link Achievement} class
	 * 
	 */
	private AchievementLevel() {
		missionAchievementLabel = new Label();
	}
	
	/**
	 * Set proper medal image and label
	 * 
	 * @return Achievement Mission Medal Image;
	 */
	public ImageView getAchievementLevelImage() {
		ImageView achievementMissionImage = new ImageView();
		
		if(levelHandler.getLevel() == 1) {
			
			achievementMissionImage.setImage(bronze);
			setAchievementLevelText();
			
		} else if (levelHandler.getLevel() == 2) {
			
			achievementMissionImage.setImage(silver);
			setAchievementLevelText();
			
		} else if (levelHandler.getLevel() >= 3) {
			
			achievementMissionImage.setImage(gold);
			setAchievementLevelText();
		}
		
		return achievementMissionImage;
	}
	
	/**
	 * Get achievement level label
	 * 
	 * @return achievement level label
	 */
	public Label getAchievementLevelLabel(){
		return this.missionAchievementLabel;
	}
	
	/**
	 * Set achievement level label
	 * 
	 */
	private void setAchievementLevelText(){
		
		missionAchievementLabel.setText("Level : " + levelHandler.getLevel());
	}

}
