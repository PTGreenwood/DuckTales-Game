package uq.deco2800.ducktales.features.achievements;

import javafx.scene.image.Image;


import uq.deco2800.ducktales.features.level.LevelHandler;
/**
 * Controller for the Levels achievement. 
 * 
 * @author Joshua You and Naehyung Kim
 *
 */
public class AchievementLevelController {
	
	/** Images for level achievement */
	private Image level1 = new Image("/achievements/level1.png");
	private Image level2 = new Image("/achievements/level2.png");
	private Image level3 = new Image("/achievements/level3.png");
	
	private LevelHandler levelHandler = LevelHandler.getInstance();
	
	private static final AchievementLevelController INSTANCE = new AchievementLevelController();
	
	/**
	 * Constructor of {@link Achievements}
	 * 	
	 * @return <CODE>INSTANCE</CODE>
	 */
	public static AchievementLevelController getInstance() {
		return INSTANCE;
	}
	
	/**
	 * Main constructor of {@link Achievements} class
	 * 
	 */
	public AchievementLevelController() {
		
	}
	
	/**
	 * Changes image when level is up. (max level 3)
	 * 
	 * @return Image for level achievement
	 */
	public Image getAchievementLevelImage() {
		Image achievementImage = null;
		
		if(levelHandler.getLevel() == 1) {
			
			achievementImage = level1;
			
		} else if (levelHandler.getLevel() == 2) {
			
			achievementImage = level2;
			
		} else if (levelHandler.getLevel() >= 3) {
			
			achievementImage = level3;
		}
		
		return achievementImage;
	}
}
