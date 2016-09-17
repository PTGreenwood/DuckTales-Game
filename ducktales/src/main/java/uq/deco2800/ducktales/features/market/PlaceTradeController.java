package uq.deco2800.ducktales.features.market;

import javafx.fxml.FXML;

/**
 * Class that handle the view for /mpplacetradeoffervista.fxml
 * 
 * @author Mark Belonogoff
 *
 */
public class PlaceTradeController {
	
	private MarketManager marketManager;
	
	public PlaceTradeController() {
		
		this.marketManager = MarketVistaNavigator.getMainController();
		System.out.println("PlaceTradeController created");
		
	}
	
	@FXML
	public void initialize() {
		
	}

}
