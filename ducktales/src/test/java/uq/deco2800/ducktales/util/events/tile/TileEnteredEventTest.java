package uq.deco2800.ducktales.util.events.tile;

import static org.junit.Assert.*;

import org.junit.Test;

public class TileEnteredEventTest {
	
	/**
	 * Test for the TileEntered class
	 */
	@Test
	public void basicTest() {
		TileEnteredEvent test = new TileEnteredEvent(10, 50);
		
		// Check that the exit event is updated correctly
		assertTrue("tile exit", TileEnteredEvent.TILE_ENTERED == test.TILE_ENTERED);
		assertTrue("location x", test.xPos == 10);
		assertTrue("location y", test.yPos == 50);
	}
}