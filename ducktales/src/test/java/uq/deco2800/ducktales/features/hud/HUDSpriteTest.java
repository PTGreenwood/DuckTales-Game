package uq.deco2800.ducktales.features.hud;

import static org.junit.Assert.*;

import org.junit.Test;

import org.testfx.framework.junit.ApplicationTest;
import javafx.stage.Stage;

import uq.deco2800.ducktales.resources.ResourceSpriteRegister;
import uq.deco2800.ducktales.resources.ResourceType;

/**
 * Unit test class for HUDSprite.
 * 
 * @author Oliver Yule
 *
 */
public class HUDSpriteTest extends ApplicationTest {
	
	/**
	 * Test constructor and all public methods: getSpriteType(), setSpriteType(),
	 * getSpriteWidth(), getSpriteHeight().
	 */
	@Test
	public void basicTest() {
		HUDSprite testHUDSprite = new HUDSprite(ResourceType.DUCK);
		
		assertTrue(testHUDSprite.getSpriteType() == (ResourceType.DUCK));
		assertFalse(testHUDSprite.getSpriteType() == (ResourceType.COW));
		
		testHUDSprite.setSpriteType(ResourceType.COW);
		assertTrue(testHUDSprite.getSpriteType() == (ResourceType.COW));
		assertFalse(testHUDSprite.getSpriteType() == (ResourceType.DUCK));
		
		double testHeight = ResourceSpriteRegister.getInstance().getResourceImage(
				ResourceType.COW).getHeight();
		double testWidth = ResourceSpriteRegister.getInstance().getResourceImage(
				ResourceType.COW).getWidth();
		assertTrue(testHUDSprite.getSpriteHeight() == testHeight);
		assertTrue(testHUDSprite.getSpriteWidth() == testWidth);
	}

	@Override
	public void start(Stage stage) throws Exception {
		
	}

}
