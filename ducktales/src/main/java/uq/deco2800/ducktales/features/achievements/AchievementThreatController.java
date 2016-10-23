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
	private Image threat1 = new Image("achievements/threat1.png");
	private Image threat2 = new Image("achievements/threat2.png");
	private Image threat3 = new Image("achievements/threat3.png");
		
	private int numberOfEnemies;
	
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
	 * Main constructor of {@link Achievements} class
	 * 
	 */
	public AchievementThreatController() {
		this.numberOfEnemies = 0;
	}
	
	/**
	 * Changes images with certain number of returned enemy.
	 * 	
	 * @return image for threat achievement
	 */
	public Image getAchievementThreatImage() {
		Image achievementImage = null;
		
		if(numberOfEnemies == 1) {
			
			achievementImage = threat1;
		} else if (numberOfEnemies == 10){
			
			achievementImage = threat2;
		}
	    else if (numberOfEnemies == 100) {
		
		achievementImage = threat3;
	    }
		
		return achievementImage;
	}

	private int numberOfEnemies() {
		return this.numberOfEnemies;
	}
}
