package uq.deco2800.ducktales.features.builder;

import static org.junit.Assert.*;

import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import javafx.stage.Stage;
import uq.deco2800.ducktales.resources.ResourceType;

/**
 * Unit tests for WorldEntitySprite
 * 
 * @author Oliver Yule
 *
 */
public class WorldEntitySpriteTest extends ApplicationTest {

	/**
	 * Test constructor, setTileUnitSize(), getUnitSize().
	 */
	@Test
	public void basicTest() {
		WorldEntitySprite testWorldEntitySprite = new WorldEntitySprite(
				ResourceType.BAKERY);
		int[][] testSize1 = {{1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}}; // 3x4 typical
		int[][] testSize2 = {{1}}; // 1x1 boundary
		
		testWorldEntitySprite.setTileUnitSize(testSize1);
		assertTrue(testWorldEntitySprite.getTileUnitSize().equals(testSize1));
		assertFalse(testWorldEntitySprite.getTileUnitSize().equals(testSize2));

		testWorldEntitySprite.setTileUnitSize(testSize2);
		assertTrue(testWorldEntitySprite.getTileUnitSize().equals(testSize2));
		assertFalse(testWorldEntitySprite.getTileUnitSize().equals(testSize1));
	}

	@Override
	public void start(Stage stage) throws Exception {
		
	}

}
