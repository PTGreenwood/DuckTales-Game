package uq.deco2800.ducktales.deprecated.world;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class WorldBetaTest {
	
	@Test
	public void basicTest(){
		WorldBeta world = new WorldBeta("test", 4, 6);
		
		assertTrue("getWidth incorrect", world.getWidth() == 4);
		assertTrue("getHeight incorrect", world.getHeight() == 6);
		// Currently no way to check the tile 'type'
		assertTrue("tile is null", world.getTile(1,1) != null);
		assertTrue("tiles array is not empty", world.getTiles() != null);
	}
	
}
