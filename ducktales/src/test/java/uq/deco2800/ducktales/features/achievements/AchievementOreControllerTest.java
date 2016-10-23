package uq.deco2800.ducktales.features.achievements;

import static org.junit.Assert.*;

import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import javafx.stage.Stage;
import uq.deco2800.ducktales.features.inventory.InventoryManager;

public class AchievementOreControllerTest extends ApplicationTest {
	
	/**
	 * Check Image from AchievementOreController contains actual URL from the image
	 */
	@Test
	public void imageTest() {
		AchievementOreController oreController = new AchievementOreController();
		InventoryManager inventoryManager = new InventoryManager(0, 0, 0, 0, 0);
		
		inventoryManager.setStoneAmount(100);		
		String expectedImageString = oreController.getAchievementOreImage().impl_getUrl();
		String actualImageString = "achievements/ore100.png";
		assertTrue(expectedImageString.contains(actualImageString));		
	}
	
	
	@Override
	public void start(Stage stage) throws Exception {
		
	}
}
