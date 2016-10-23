package uq.deco2800.ducktales.features.achievements;

import javafx.scene.image.Image;
import uq.deco2800.ducktales.World;

/**
 * Controller for the Peons achievement. 
 * 
 * @author Joshua You
 *
 */
public class AchievementPeonsController {
	
	/** Images for peon achievement */
	private Image peons1 = new Image("achievements/peon1.png");
	private Image peons2 = new Image("achievements/peon2.png");
	private Image peons3 = new Image("achievements/peon3.png");
	
	/** Initialize classes */	
	private World world;
	
	private int getNumberOfPeons;
	
	private static final AchievementPeonsController INSTANCE = new AchievementPeonsController();
	
	/**
	 * Constructor of {@link Achievements}
	 * 	
	 * @return <CODE>INSTANCE</CODE>
	 */
	public static AchievementPeonsController getInstance() {
		return INSTANCE;
	}
	
	/**
	 * Main constructor of {@link Achievement} class
	 * 
	 */
	public AchievementPeonsController() {
		
		this.getNumberOfPeons = 0;
	}
	
	/**
	 * Changes Images with certain number of peons
	 * 
	 * @return Images for peon achievement
	 */
	public Image getAchievementPeonsImage() {
		Image achievementImage = peons1;
		
		if(this.getNumberOfPeons()<= 1) {
			
			achievementImage = peons1;
		} else if (this.getNumberOfPeons() >= 25) {
			
			achievementImage = peons2;
		}
	    else if (this.getNumberOfPeons() >= 100) {
		
		achievementImage = peons3;
	    }
		
		return achievementImage;
	}

	private int getNumberOfPeons() {
		return this.getNumberOfPeons;
	}
}
