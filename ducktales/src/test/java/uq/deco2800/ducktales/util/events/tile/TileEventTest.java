package uq.deco2800.ducktales.util.events.tile;

import static org.junit.Assert.*;

import org.junit.Test;

public class TileEventTest {
	
	/**
	 * Test for the TileEvent class. Check all public methods.
	 */
	@Test
	public void basicTest() {
		TileEvent test = new TileEvent(10, 50);
		
		// Check that the exit event is updated correctly
		assertTrue("tile exit", TileEvent.TILE_EVENT == test.TILE_EVENT);
		assertTrue("location x", test.xPos == 10);
		assertTrue("location y", test.yPos == 50);
		
		assertTrue("location x", test.xPos == test.getxPos());
		assertTrue("location y", test.yPos == test.getyPos());
	}
}