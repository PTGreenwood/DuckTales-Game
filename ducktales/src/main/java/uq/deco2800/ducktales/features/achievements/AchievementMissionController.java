package uq.deco2800.ducktales.features.achievements;

import javafx.scene.image.Image;
import uq.deco2800.ducktales.features.missions.MissionHandler;
/**
 * Controller for the Missions achievement. 
 * 
 * @author Naehyung Kim
 *
 */
public class AchievementMissionController {

	/** Images for Mission achievement */
	private Image mission1 = new Image("achievements/medalBronze.png");
	private Image mission2 = new Image("achievements/medalSilver.png");
	private Image mission3 = new Image("achievements/medalGold.png");
	
	private MissionHandler missionHandler = MissionHandler.getInstance();
	
	private static final AchievementMissionController INSTANCE = new AchievementMissionController();
	
	/**
	 * Constructor of {@link Achievements}
	 * 	
	 * @return <CODE>INSTANCE</CODE>
	 */
	public static AchievementMissionController getInstance() {
		return INSTANCE;
	}
	
	/**
	 * Main constructor of {@link Achievements} class
	 * 
	 */
	public AchievementMissionController() {
		
	}
	
	/**
	 * Chanes image when certain number of missions are completed
	 * 
	 * @return Image for Mission achievement
	 */
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
