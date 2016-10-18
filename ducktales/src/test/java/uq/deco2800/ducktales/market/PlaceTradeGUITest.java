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
//import javafx.scene.control.Label;
//import javafx.scene.layout.GridPane;
//import uq.deco2800.ducktales.features.market.MarketManager;
//import uq.deco2800.ducktales.features.market.MarketVistaNavigator;
//import uq.deco2800.ducktales.features.market.PlaceTradeController;
//
///**
// * Tests the GUI for the "Place a Trade" section of the marketplace.
// *
// * @author mark Belonogoff
// *
// */
//public class PlaceTradeGUITest extends GuiTest {
//
//	MarketManager marketManager;
//	Parent parent = null;
//
//	PlaceTradeController placeTradeController;
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
//					 .getResource(MarketVistaNavigator.PLACE_A_TRADE));
//
//			parent = loader.load();
//
//			// store a reference to the allTradesController instance
//			this.placeTradeController = loader.
//					<PlaceTradeController>getController();
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
//	}
//
////	/**
////	 * Tests that selecting an item and quantity updates the associated labels.
////	 */
////	@Test
////    public void testSelectItem() {
////
////		String item = "stone";
////
////		Integer amount = 1;
////
////		clickOn("#itemNameCombo").clickOn(item);
////
////		clickOn("#quantityCombo").clickOn(amount.toString());
////
////		Label itemNameLabel = (Label)GuiTest.find("#itemNameLabel");
////
////		Label quantityLabel = (Label)GuiTest.find("#quantityLabel");
////
////		Assert.assertTrue("itemNameLabel does not equal the selected item",
////				itemNameLabel.getText().equals(item));
////
////		Assert.assertTrue("quantityLabel does not equal the selected quantity",
////				quantityLabel.getText().
////				equals("Amount: " + amount.toString()));
////	}
//
//}
