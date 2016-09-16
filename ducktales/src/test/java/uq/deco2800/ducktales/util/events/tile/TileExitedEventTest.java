package uq.deco2800.ducktales.util.events.tile;

import static org.junit.Assert.*;

import org.junit.Test;

public class TileExitedEventTest {
	
	/**
	 * Test for the TileExited class
	 */
	@Test
	public void basicTest() {
		TileExitedEvent test = new TileExitedEvent(10, 50);
		
		// Check that the exit event is updated correctly
		assertTrue("tile exit", TileExitedEvent.TILE_EXITED == test.TILE_EXITED);
		assertTrue("location x", test.xPos == 10);
		assertTrue("location y", test.yPos == 50);
	}
}