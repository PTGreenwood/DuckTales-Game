package uq.deco2800.ducktales.features.market;

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
	private ComboBox itemNameCombo;
	
	@FXML
	private ComboBox quantityCombo;
	
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
		
		// Populate the item
		//itemNameCombo.getItems().add("Test");
		
	}

}
