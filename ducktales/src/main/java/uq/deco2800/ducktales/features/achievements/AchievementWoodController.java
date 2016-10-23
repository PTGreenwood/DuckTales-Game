package uq.deco2800.ducktales.features.achievements;

import javafx.scene.image.Image;
import uq.deco2800.ducktales.features.inventory.InventoryManager;

public class AchievementWoodController {
	
	private Image wood1 = new Image("achievements/wood100.png");
	private Image wood2 = new Image("achievements/wood1000.png");
	
	private InventoryManager inventoryManager;
	
	public AchievementWoodController() {
		this.inventoryManager = new InventoryManager(0,0,0,0,0);
	}
	
	private static final AchievementWoodController INSTANCE = new AchievementWoodController();
	
	public static AchievementWoodController getInstance() {
		return INSTANCE;
	}
	
	public Image getAchievementWoodImage() {
		Image achievementImage = null;
		
		if (inventoryManager.getTimberAmount() <= 100) {
			achievementImage = wood1;
		} else if (inventoryManager.getTimberAmount() >= 1000) {
			achievementImage = wood2;
		}
		
		return achievementImage;
	}
	
}
