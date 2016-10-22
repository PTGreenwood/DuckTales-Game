package uq.deco2800.ducktales.features.achievements;

import javafx.scene.image.Image;
import uq.deco2800.ducktales.features.inventory.InventoryManager;

public class AchievementOreController {
	
	private Image ore1 = new Image("achievements/ore100.png");
	private Image ore2 = new Image("achievements/ore100.png");
	
	private InventoryManager inventoryManager;
	
	public AchievementOreController() {
		this.inventoryManager = new InventoryManager(0,0,0,0,0);
	}
	
	private static final AchievementOreController INSTANCE = new AchievementOreController();
	
	public static AchievementOreController getInstance() {
		return INSTANCE;
	}
	
	public Image getAchievementOreImage() {
		Image achievementImage = null;
		
		if(inventoryManager.getStoneAmount() <= 100) {
			
			achievementImage = ore1;
		} else if (inventoryManager.getStoneAmount() >= 1000) {
			
			achievementImage = ore2;
		}
		
		return achievementImage;
	}

}
