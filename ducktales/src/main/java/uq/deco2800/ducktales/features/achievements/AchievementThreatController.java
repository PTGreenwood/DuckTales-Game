package uq.deco2800.ducktales.features.achievements;

import javafx.scene.image.Image;


import uq.deco2800.ducktales.features.entities.threats.ThreatManager;

/**
 * Controller for the Threat achievement. 
 * 
 * @author Joshua You and Justin Kuhnel
 *
 */
public class AchievementThreatController {
	
	/** Images for Threat achievement */
	private Image threat1 = new Image("achievements/threats1.png");
	private Image threat2 = new Image("achievements/threats2.png");
	private Image threat3 = new Image("achievements/threats3.png");
	
	
private static final AchievementThreatController INSTANCE = new AchievementThreatController();
	
	/**
	 * Constructor of {@link Achievements}
	 * 	
	 * @return <CODE>INSTANCE</CODE>
	 */
	
	public static AchievementThreatController getInstance() {
		return INSTANCE;
	}
	/**
	 * Changes images with certain number of returned enemy.
	 * 	
	 * @return image for threat achievement
	 */
	public Image getAchievementThreatImage() {
		Image achievementImage = null;
		
		if(ThreatManager.returnEnemies().equals(1)) {
			
			achievementImage = threat1;
		} else if (ThreatManager.returnEnemies().equals(5)){
			
			achievementImage = threat2;
		}
	    else if (ThreatManager.returnEnemies().equals(100)) {
		
		achievementImage = threat3;
	    }
		
		return achievementImage;
	}

}
