package uq.deco2800.ducktales.features.landscape.tiles;

import uq.deco2800.ducktales.resources.ResourceType;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Tests for the TileSprite class.
 * 
 * @author Oliver Yule
 *
 */
public class TileSpriteTest {

	@Test
	public void basicTest() {
		TileSprite testTileSprite = new TileSprite(ResourceType.DIRT_1, 1, 1);
		assertTrue("getTileType() returns unexpected tile type",
				testTileSprite.getTileType().equals(ResourceType.DIRT_1));
		assertFalse("getTileType() returns unexpected tile type",
				testTileSprite.getTileType().equals(ResourceType.DIRT_2));
		
		// TODO: test setMouseEventHandlers()
	}
}
