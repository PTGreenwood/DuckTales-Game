package uq.deco2800.ducktales.features.achievements;

import javafx.scene.image.Image;
import uq.deco2800.ducktales.features.inventory.InventoryManager;

/**
 * Controller for the Woods achievement. 
 * 
 * @author Joshua You and Naehyung Kim
 *
 */
public class AchievementWoodController {
	
	/** Images for Wood achievement */
	private Image wood1 = new Image("achievements/wood100.png");
	private Image wood2 = new Image("achievements/wood1000.png");
	
	/** Initialize classes */	
	private InventoryManager inventoryManager;
	
	/**
	 * Main constructor of {@link Achievements} class
	 * 
	 */
	public AchievementWoodController() {
		this.inventoryManager = new InventoryManager(0,0,0,0,0);
	}
	
	private static final AchievementWoodController INSTANCE = new AchievementWoodController();
	
	
	/**
	 * Constructor of {@link Achievements}
	 * 	
	 * @return <CODE>INSTANCE</CODE>
	 */
	public static AchievementWoodController getInstance() {
		return INSTANCE;
	}
	
	/**
	 * Changes wood image with certain amount of wood
	 * 
	 * @return image for wood achievement
	 */
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
