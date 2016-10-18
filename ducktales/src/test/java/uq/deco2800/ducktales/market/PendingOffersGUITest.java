package uq.deco2800.ducktales.market;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;
import org.loadui.testfx.GuiTest;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.GridPane;
import uq.deco2800.ducktales.features.market.MarketManager;
import uq.deco2800.ducktales.features.market.MarketVistaNavigator;
import uq.deco2800.ducktales.features.market.PendingOffersController;

public class PendingOffersGUITest extends GuiTest {

	MarketManager marketManager;
	Parent parent = null;

	PendingOffersController pendingOffersController;

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
					 .getResource(MarketVistaNavigator.YOUR_OFFERS));

			parent = loader.load();

			// store a reference to the allTradesController instance
			this.pendingOffersController = loader.
					<PendingOffersController>getController();

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

		}

		return parent;
	}

	/**
	 * Checks that when a user loads the Pending Offers view that
	 * all the stored views appear.
	 */
    @Test
    public void testOffersInGrid() {

    	// Get the gridPane instance
    	GridPane grid = (GridPane)GuiTest.find("#yourOffersGridPane");

    	int offersInGrid = grid.getChildren().size();

    	int offersInModel =
    			this.marketManager.getUserOffers().size();

    	Assert.assertTrue("Number of current trades in market model does not " +
    	"equal the number of children in allTradesGridPane",
    	offersInGrid == offersInModel);

    }

}
