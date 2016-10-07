package uq.deco2800.ducktales.features.market;

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
	
	/**
	 * Constructor for the PlaceTradeController. Conducts tasks before the 
	 * view is initialized.
	 */
	public PlaceTradeController() {
		
		this.marketManager = MarketVistaNavigator.getMainController();
		
	}
	
	/**
	 * Conducts tasks once the view has been initialized.
	 */
	@FXML
	public void initialize() {
		
		updateView();
		
	}
	
	/**
	 * Updates the example labels when an item from the item name 
	 * combo box is selected.
	 */
	@FXML
	void itemSelected() {
		
		String selectedItemName = itemNameCombo.getValue();
		
		if (selectedItemName != null) {
			// Set the quantityLabel to the default
			quantityLabel.setText("Quantity");
			
			// Update the itemNameLabel
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
	
	/**
	 * Updates the example labels when an amount from the quantity 
	 * combo box is selected.
	 */
	@FXML
	void quantitySelected() {
		
		Integer quantity = quantityCombo.getValue();
		
		
		if (quantity != null) {
			// Update the quantity Label
			quantityLabel.setText("Amount: " + 
					quantityCombo.getValue().toString());
			
		} else {
			// Set the quantityLabel to the default
			quantityLabel.setText("Quantity");
		}
		
			
	}
	
	/**
	 * Places the new trade offer created by the user.
	 */
	@FXML
	void placeOffer() {
		
		// Get the values in item Name and quantity
		String itemName = itemNameCombo.getValue();
		
		Integer quantity = quantityCombo.getValue();
		
		if (itemName != null && quantity != null) {
			// place a new offer
			
		} else {
			// requirements not met
			
		}
		
		// Create a new trade
		marketManager.createNewTradeOffer(itemName, quantity);
		
		// Update the view
		updateView();
	
	}
	
	/** 
	 * Updates all the necessary views.
	 */
	void updateView() {
		
		clearView();
		
		// Get the list of item Name
		Set<String> inventoryItemNames = 
				this.marketManager.getUserInventoryItemNames();
		
		// Populate the item name combo box
		
		for (String itemName: inventoryItemNames) {
			itemNameCombo.getItems().add(itemName);
		}
		
		// Set the user name label to the current user text
		userLabel.setText("User: " + this.marketManager.getUserName());
		
	}
	
	/**
	 * Clears the current view.
	 */
	void clearView() {
		itemNameCombo.getSelectionModel().clearSelection();
		itemNameCombo.setValue(null);
		quantityCombo.getSelectionModel().clearSelection();
		quantityCombo.setValue(null);
		
		itemNameCombo.getItems().clear();
		quantityCombo.getItems().clear();
	}

}
