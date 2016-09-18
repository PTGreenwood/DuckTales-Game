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
	
	LevelHandler levelHandler = LevelHandler.getInstance();
	
	/**
	 * Load bronze, silver, gold medal images
	 */
	private Image bronze = new Image("/achievements/bronzeMedal.png");
	private Image silver = new Image("/achievements/silverMedal.png");
	private Image gold = new Image("/achievements/goldMedal.png");
	private Label missionAchievementLabel = new Label();
	
	private static AchievementLevel INSTANCE = new AchievementLevel();	
	
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
	public AchievementLevel() {
		
	}
	
	/**
	 * Set proper medal image and label
	 * 
	 * @return Achievement Mission Medal Image;
	 */
	public ImageView getAchievementLevelImage() {
		ImageView AchievementMissionImage = new ImageView();
		
		if(levelHandler.getLevel() == 1) {
			
			AchievementMissionImage.setImage(bronze);
			setAchievementLevelText();
			
		} else if (levelHandler.getLevel() == 2) {
			
			AchievementMissionImage.setImage(silver);
			setAchievementLevelText();
			
		} else if (levelHandler.getLevel() >= 3) {
			
			AchievementMissionImage.setImage(gold);
			setAchievementLevelText();
		}
		
		return AchievementMissionImage;
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
