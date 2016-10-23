package uq.deco2800.ducktales.features.achievements;

import javafx.scene.image.Image;


import uq.deco2800.ducktales.features.entities.threats.ThreatManager;

/**
 * Controller for the Threat achievement. 
 * 
 * @author Joshua You
 *
 */
public class AchievementThreatController {
	
	/** Images for Threat achievement */
	private Image threat1 = new Image("achievemnts/threat1.png");
	private Image threat2 = new Image("achievemnts/threat2.png");
	private Image threat3 = new Image("achievemnts/threat3.png");
	
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
