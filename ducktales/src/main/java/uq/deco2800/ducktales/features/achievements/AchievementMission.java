package uq.deco2800.ducktales.features.achievements;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import uq.deco2800.ducktales.features.missions.MissionHandler;
import uq.deco2800.ducktales.features.missions.MissionManager;

public class AchievementMission {
	
	
	MissionHandler missionHandler = MissionHandler.getInstance();
	
	private Image bronze = new Image("/achievements/bronzeMedal.png");
	private Image silver = new Image("/achievements/silverMedal.png");
	private Image gold = new Image("/achievements/goldMedal.png");
	
	private static AchievementMission INSTANCE = new AchievementMission();
	
	
	public static AchievementMission getInstance() {
		return INSTANCE;
	}
	public AchievementMission() {
		
	}
	public ImageView getAchievementMissionImage(){
		ImageView AchievementMissionImage = new ImageView();
		if(missionHandler.getNumberOfCompletedMissions() == 1){
			AchievementMissionImage.setImage(bronze);
		} else if (missionHandler.getNumberOfCompletedMissions() == 2){
			AchievementMissionImage.setImage(silver);
		} else if (missionHandler.getNumberOfCompletedMissions() == 3){
			AchievementMissionImage.setImage(gold);
		}
		return AchievementMissionImage;
	}
	
	
}
