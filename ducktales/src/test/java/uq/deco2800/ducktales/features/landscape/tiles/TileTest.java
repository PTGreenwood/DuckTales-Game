package uq.deco2800.ducktales.features.landscape.tiles;

import uq.deco2800.ducktales.resources.ResourceType;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Tests for the Tile class.
 * 
 * @author Oliver Yule
 *
 */
public class TileTest {

	@Test
	public void basicTest() {
		Tile testTile = new Tile(ResourceType.GRASS_2);
		
		// Test passabilty
		assertTrue(testTile.isPassable() == true);
		assertFalse(testTile.isPassable() == false);
		testTile.setPassable(false);
		assertTrue(testTile.isPassable() == false);
		
		// Test initial tileType and getTileType().
		// Note: getTileType() should return CYAN_CROSSED if not passable.
		assertTrue("getTileType() returns unexpected tileType",
				testTile.getTileType().equals(ResourceType.CYAN_CROSSED));
		testTile.setPassable(true);
		assertTrue("getTileType() returns unexpected tileType",
				testTile.getTileType().equals(ResourceType.GRASS_2));
		assertFalse("getTileType() returns unexpected tileType",
				testTile.getTileType().equals(ResourceType.GRASS_4));
		
		// Test initial worldEntityType and getWorldEntityType().		
		assertTrue("getWorldEntityType() returns unexpected worldEntityType",
				testTile.getWorldEntityType().equals(ResourceType.NONE));
		assertFalse("getWorldEntityType() returns unexpected worldEntityType",
				testTile.getWorldEntityType().equals(ResourceType.TREE_1));
		
		// Test setTileType() and setWorldEntityType().
		testTile.setTileType(ResourceType.WATER);
		assertTrue("setTileType() sets unexpected tileType",
				testTile.getTileType().equals(ResourceType.WATER));
		testTile.setWorldEntityType(ResourceType.TREE_1);
		assertTrue("setWorldEntityType() sets unexpected worldEntityType",
				testTile.getWorldEntityType().equals(ResourceType.TREE_1));
		
	}
}
