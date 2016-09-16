package uq.deco2800.ducktales.features.achievements;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import uq.deco2800.ducktales.features.level.LevelHandler;

public class AchievementLevel {
	
	LevelHandler levelHandler = LevelHandler.getInstance();
	
	private Image bronze = new Image("/achievements/bronzeMedal.png");
	private Image silver = new Image("/achievements/silverMedal.png");
	private Image gold = new Image("/achievements/goldMedal.png");
	private Label missionAchievementLabel = new Label();
	
	private static AchievementLevel INSTANCE = new AchievementLevel();
	
	
	public static AchievementLevel getInstance() {
		return INSTANCE;
	}
	public AchievementLevel() {
		
	}
	public ImageView getAchievementLevelImage(){
		ImageView AchievementMissionImage = new ImageView();
		if(levelHandler.getLevel() == 1){
			AchievementMissionImage.setImage(bronze);
			setAchievementLevelText();
		} else if (levelHandler.getLevel() == 2){
			AchievementMissionImage.setImage(silver);
			setAchievementLevelText();
		} else if (levelHandler.getLevel() >= 3){
			AchievementMissionImage.setImage(gold);
			setAchievementLevelText();
		}
		return AchievementMissionImage;
	}
	
	public Label getAchievementLevelLabel(){
		return this.missionAchievementLabel;
	}
	
	private void setAchievementLevelText(){
		
		missionAchievementLabel.setText("Level : " + levelHandler.getLevel());
	}

}
