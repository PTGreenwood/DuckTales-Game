package uq.deco2800.ducktales.features.achievements;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import uq.deco2800.ducktales.features.level.LevelHandler;

public class AchievementLevelController {
	
	
	private Image level1 = new Image("/achievements/level1.png");
	private Image level2 = new Image("/achievements/level2.png");
	private Image level3 = new Image("/achievements/level3.png");
	
	private LevelHandler levelHandler = LevelHandler.getInstance();
	
	private static final AchievementLevelController INSTANCE = new AchievementLevelController();
	
	public static AchievementLevelController getInstance() {
		return INSTANCE;
	}
	
	public AchievementLevelController() {
		
	}
	
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
