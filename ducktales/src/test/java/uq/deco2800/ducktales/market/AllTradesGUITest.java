package uq.deco2800.ducktales.market;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.GridPane;

import org.junit.Assert;
import org.junit.Test;
import org.loadui.testfx.GuiTest;
import uq.deco2800.ducktales.features.market.MarketManager;
import uq.deco2800.ducktales.features.market.MarketVistaNavigator;
import uq.deco2800.ducktales.features.market.AllTradesController;

/**
 * Tests the GUI Elements in the All Trades View in the Marketplace.
 *
 * @author Mark Belonogoff
 *
 */
public class AllTradesGUITest extends GuiTest {

	MarketManager marketManager;
	Parent parent = null;

	AllTradesController allTradesController;

	/**
	 * Set up for TestFX.
	 */
	@Override
	public Parent getRootNode() {

		// Create a new Market Manager Instance
		this.marketManager = new MarketManager();

		try {
			// Load the all trades instance
			FXMLLoader loader = new FXMLLoader(getClass()
					 .getResource(MarketVistaNavigator.ALL_TRADES));

			parent = loader.load();

			// store a reference to the allTradesController instance
			this.allTradesController = loader.
					<AllTradesController>getController();

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

		}

		return parent;

	}

	/**
	 * Checks that when a user loads the All Trades view that
	 * all the stored views appear.
	 */
    @Test
    public void testTradesInGrid() {

    	// Get the gridPane instance
    	GridPane grid = (GridPane)GuiTest.find("#allTradesGridPane");

    	int tradesInGrid = grid.getChildren().size();

    	int tradesInModel = this.marketManager.getAllTrades().size();

    	Assert.assertTrue("Number of current trades in market model does not " +
    	"equal the number of children in allTradesGridPane",
    	tradesInGrid == tradesInModel);

    }

}
