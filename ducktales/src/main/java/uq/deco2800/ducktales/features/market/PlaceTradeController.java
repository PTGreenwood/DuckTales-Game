package uq.deco2800.ducktales.features.market;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

/**
 * Class that handle the view for /mpplacetradeoffervista.fxml
 * 
 * @author Mark Belonogoff
 *
 */
public class PlaceTradeController {
	
	@FXML
	private ComboBox<String> itemNameCombo;
	
	@FXML
	private ComboBox<Integer> quantityCombo;
	
	@FXML
	private Button placeOfferBtn;
	
	
	@FXML
	private Label itemNameLabel;
	
	@FXML
	private Label quantityLabel;
	
	@FXML
	private Label userLabel;
	
	private MarketManager marketManager;
	
	public PlaceTradeController() {
		
		this.marketManager = MarketVistaNavigator.getMainController();
		System.out.println("PlaceTradeController created");
		
	}
	
	@FXML
	public void initialize() {
		
		// Get the list of item Name
		Set<String> inventoryItemNames = 
				this.marketManager.getUserInventoryItemNames();
		
		// Get the quantity of each the user has
		
		
		// Populate the item name combo box
		
		for (String itemName: inventoryItemNames) {
			itemNameCombo.getItems().add(itemName);
		}
		
	}
	
	@FXML
	void itemSelected() {
		
		// Update the itemNameLabel
		String selectedItemName = itemNameCombo.getValue();
		//
		itemNameLabel.setText(selectedItemName);
		
		// Load the required possible quantities in the quantity combobox.
		int maxAmount = marketManager.getInventoryAmountForItem(
				selectedItemName);
		
		// Clear the contents of the quantity combobox.
		quantityCombo.getItems().clear();
		
		for (int i = 1; i <= maxAmount; i++) {
			quantityCombo.getItems().add(i);
		}
		
	}

}
