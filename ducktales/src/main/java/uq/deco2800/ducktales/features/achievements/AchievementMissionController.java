package uq.deco2800.ducktales.features.achievements;

import javafx.scene.image.Image;
import uq.deco2800.ducktales.features.missions.MissionHandler;

public class AchievementMissionController {

	
	private Image mission1 = new Image("achievements/medalBronze.png");
	private Image mission2 = new Image("achievements/medalSilver.png");
	private Image mission3 = new Image("achievements/medalGold.png");
	
	private MissionHandler missionHandler = MissionHandler.getInstance();
	
	private static final AchievementMissionController INSTANCE = new AchievementMissionController();
	
	public static AchievementMissionController getInstance() {
		return INSTANCE;
	}
	
	public AchievementMissionController() {
		
	}
	
	public Image getAchievementMissionImage() {
		Image achievementImage = null;
		
		if(missionHandler.getNumberOfCompletedMissions() <= 1.0) {
			
			achievementImage = mission1;
			
		} else if (missionHandler.getNumberOfCompletedMissions() == 2.0) {
			
			achievementImage = mission2;
			
		} else if (missionHandler.getNumberOfCompletedMissions() >= 3.0) {
			
			achievementImage = mission3;
		}
		
		return achievementImage;
	}
}
