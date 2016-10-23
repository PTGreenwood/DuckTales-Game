package uq.deco2800.ducktales.features.achievements;

import javafx.scene.image.Image;
import uq.deco2800.ducktales.features.inventory.InventoryManager;
/**
 * Controller for the Ores achievement. 
 * 
 * @author Naehyung Kim
 *
 */
public class AchievementOreController {
	
	/** Images for ore achievement */
	private Image ore1 = new Image("achievements/ore100.png");
	private Image ore2 = new Image("achievements/ore1000.png");
	
	/** Initialize classes */	
	private InventoryManager inventoryManager;
	
	/**
	 * Main constructor of {@link Achievements} class
	 * 
	 */
	public AchievementOreController() {
		this.inventoryManager = new InventoryManager(0,0,0,0,0);
	}
	
	private static final AchievementOreController INSTANCE = new AchievementOreController();
	
	/**
	 * Constructor of {@link Achievements}
	 * 	
	 * @return <CODE>INSTANCE</CODE>
	 */
	public static AchievementOreController getInstance() {
		return INSTANCE;
	}
	
	/**
	 * Changes image with certain amount of ore 
	 * 
	 * @return Image for Ore Achievement
	 */
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
