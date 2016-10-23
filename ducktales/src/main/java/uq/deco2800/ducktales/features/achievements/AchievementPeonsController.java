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
	private Image peons1 = new Image("achievemnts/peon1.png");
	private Image peons2 = new Image("achievemnts/peon2.png");
	private Image peons3 = new Image("achievemnts/peon3.png");
	
	/** Initialize classes */	
	private World world;
	
	/**
	 * Changes Images with certain number of peons
	 * 
	 * @return Images for peon achievement
	 */
	public Image getAchievementOreImage() {
		Image achievementImage = null;
		
		if(world.getNumberOfPeons()<= 1) {
			
			achievementImage = peons1;
		} else if (world.getNumberOfPeons() >= 25) {
			
			achievementImage = peons2;
		}
	    else if (world.getNumberOfPeons() >= 100) {
		
		achievementImage = peons3;
	    }
		
		return achievementImage;
	}

}
