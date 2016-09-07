package uq.deco2800.ducktales;

import org.junit.Assert;
import org.junit.Test;

import uq.deco2800.ducktales.features.market.MarketManager;
import uq.deco2800.ducktales.features.market.MarketVistaNavigator;

public class MarketTest {
	
	/**
	 * Tests whether the mainController field in the MarketVistaNavigator
	 * instance is assigned correctly.
	 */
	@Test
    public void testMainView() {
		
		MarketManager marketManager = new MarketManager();
		
		MarketVistaNavigator.setMainController(marketManager);
		
		Assert.assertTrue("The mainController in " + 
		"MarketVistaNavigator is not equal to the assigned instance", 
		MarketVistaNavigator.getMainController() 
		== marketManager);
		
	}

}
