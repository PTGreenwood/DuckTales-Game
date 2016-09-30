package uq.deco2800.ducktales.features.achievements;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import uq.deco2800.ducktales.features.missions.MissionHandler;
import uq.deco2800.ducktales.features.missions.MissionManager;

/**
 * Contains all methods of mission achievement
 * 
 * @author Naehyung Kim
 *
 */
public class AchievementMission {
	
	
	MissionHandler missionHandler = MissionHandler.getInstance();
	
	/**
	 * Load bronze, silver, gold medal images
	 */
	private Image bronze = new Image("/achievements/bronzeMedal.png");
	private Image silver = new Image("/achievements/silverMedal.png");
	private Image gold = new Image("/achievements/goldMedal.png");
	private Label missionAchievementLabel = new Label();
	
	private static AchievementMission INSTANCE = new AchievementMission();
	
	/**
	 * Constructor of {@link Achievement}
	 * 
	 * @return <CODE>INSTANCE</CODE>
	 */
	public static AchievementMission getInstance() {
		return INSTANCE;
	}
	
	/**
	 * Main constructor of {@link Achievement} class
	 * 
	 */
	public AchievementMission() {
		
	}
	
	/**
	 * Set proper medal image and label
	 * 
	 * @return Achievement Level Medal Image;
	 */
	public ImageView getAchievementMissionImage() {
		ImageView AchievementMissionImage = new ImageView();
		
		if(missionHandler.getNumberOfCompletedMissions() < 2){
			
			AchievementMissionImage.setImage(bronze);
			setAchievementMissionText();
			
		} else if (missionHandler.getNumberOfCompletedMissions() == 2){
			
			AchievementMissionImage.setImage(silver);
			setAchievementMissionText();
			
		} else if (missionHandler.getNumberOfCompletedMissions() > 2){
			
			AchievementMissionImage.setImage(gold);
			setAchievementMissionText();
			
		}
		
		return AchievementMissionImage;
	}
	
	/**
	 * Get achievement Mission Label
	 * 
	 * @return get achievement mission label 
	 */
	public Label getAchievementMissionLabel() {
		return this.missionAchievementLabel;
	}
	
	/**
	 * Set achievement Mission label
	 * 
	 */
	private void setAchievementMissionText() {
		int numberOfCompletedMission = (int)missionHandler.getNumberOfCompletedMissions();
		missionAchievementLabel.setText(numberOfCompletedMission + " out of 3 missions completed");
	}
	
	
}
