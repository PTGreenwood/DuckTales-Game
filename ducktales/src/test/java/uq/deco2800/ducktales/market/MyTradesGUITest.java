//package uq.deco2800.ducktales.market;
//
//import java.io.IOException;
//
//import org.junit.Assert;
//import org.junit.Test;
//import org.loadui.testfx.GuiTest;
//
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Parent;
//import javafx.scene.layout.GridPane;
//import uq.deco2800.ducktales.features.market.MarketManager;
//import uq.deco2800.ducktales.features.market.MarketVistaNavigator;
//import uq.deco2800.ducktales.features.market.MyTradesController;
//
//public class MyTradesGUITest extends GuiTest {
//
//	MarketManager marketManager;
//	Parent parent = null;
//
//	MyTradesController myTradesController;
//
//	/**
//	 * Set up for TestFX.
//	 */
//	@Override
//	public Parent getRootNode() {
//
//		// Create a new Market Manager Instance
//		this.marketManager = new MarketManager();
//
//		try {
//			// Load the all trades instance
//			FXMLLoader loader = new FXMLLoader(getClass()
//					 .getResource(MarketVistaNavigator.YOUR_TRADES));
//
//			parent = loader.load();
//
//			// store a reference to the allTradesController instance
//			this.myTradesController = loader.
//					<MyTradesController>getController();
//
//		} catch (IOException e) {
//
//			e.printStackTrace();
//
//		} finally {
//
//		}
//
//		return parent;
//
//	}
//
////	/**
////	 * Checks that when a user loads the All Trades view that
////	 * all the stored views appear.
////	 */
////    @Test
////    public void testTradesInGrid() {
////
////    	// Get the gridPane instance
////    	GridPane grid = (GridPane)GuiTest.find("#yourTradesGridPane");
////
////    	int tradesInGrid = grid.getChildren().size();
////
////    	int tradesInModel =
////    			this.marketManager.getTradesForLoggedInUser().size();
////
////    	Assert.assertTrue("Number of current trades in market model does not " +
////    	"equal the number of children in allTradesGridPane",
////    	tradesInGrid == tradesInModel);
////
////    }
//
//
//}
