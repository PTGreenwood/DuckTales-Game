package uq.deco2800.ducktales.util.events.tile;

import static org.junit.Assert.*;

import org.junit.Test;

public class TileClickedEventTest {
	
	/**
	 * Test for the TileClicked class
	 */
	@Test
	public void basicTest() {
		TileClickedEvent test = new TileClickedEvent(10, 50);
		
		// Check that the exit event is updated correctly
		assertTrue("tile exit", TileClickedEvent.TILE_CLICKED == test.TILE_CLICKED);
		assertTrue("location x", test.xPos == 10);
		assertTrue("location y", test.yPos == 50);
	}
}