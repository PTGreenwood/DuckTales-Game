package uq.deco2800.ducktales.entities.features.duckgods;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import uq.deco2800.ducktales.features.duckgods.DuckGods;

public class DuckGodTest {
	
	private DuckGods god1 = new DuckGods("RainGod", null, null);
	

	@Test
	// * Tests the get and update function of inventoryManager class */
	public void getDuckNameTest() {
		god1.getDuckName();
		assertEquals("RainGod", god1.getDuckName());
	}
	
	
	
	
}
