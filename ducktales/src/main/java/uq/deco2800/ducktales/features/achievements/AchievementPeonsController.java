package uq.deco2800.ducktales.features.achievements;

import javafx.scene.image.Image;
import uq.deco2800.ducktales.World;


public class AchievementPeonsController {
	
	
	private Image peons1 = new Image("peon/basic_peon.png");
	private World world;
	
	
	public Image getAchievementOreImage() {
		Image achievementImage = null;
		
		if(world.getNumberOfPeons()<= 1) {
			
			achievementImage = peons1;
		} else if (world.getNumberOfPeons() >= 25) {
			
			achievementImage = peons1;
		}
	    else if (world.getNumberOfPeons() >= 100) {
		
		achievementImage = peons1;
	    }
		
		return achievementImage;
	}

}
