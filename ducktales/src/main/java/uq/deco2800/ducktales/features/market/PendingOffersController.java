package uq.deco2800.ducktales.features.market;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class PendingOffersController {
	
	/** The overall managing controller */
	private MarketManager marketManager;
	
	/** The file path to the panes that will appear in the grid pane */
	private static String OFFER_PANE = "/market/mppendingofferpane.fxml";
	
	/** The path to the dynamic resources */
	private URL path;
	
	/** Logger for the class */
	private static final Logger LOGGER = Logger.getLogger(
			PendingOffersController.class.getName());
	
	/** Stores the UI elements user's offer */
	@FXML
	private GridPane yourOffersGridPane;
	
	/**
	 * Creates a new instance of the AllTradesController.
	 */
	public PendingOffersController() {
		this.marketManager = MarketVistaNavigator.getMainController();
	}
	
	/**
	 * Continues set up once initial GUI elements have been created.
	 */
	@FXML
	public void initialize() {
		HashMap<MocTrade, MocTrade> userOffers 
			= this.marketManager.getUserOffers();
		
		path = getClass().getResource(OFFER_PANE);
		
		int row = 0;
		int column = 0;
		for(MocTrade targetTrade: userOffers.keySet()) {
			
			MocTrade userOffer = userOffers.get(targetTrade);
			
			FXMLLoader loader = new FXMLLoader();
			
			try {
				
				loader.setLocation(path);
				
				Pane tradePane = (Pane) loader.load();
			
				Label itemNameLabel = 
					(Label) tradePane.lookup("#itemNameLabel");
				
				itemNameLabel.setText(targetTrade.getItemName());
				
				Label quantityLabel = 
						(Label) tradePane.lookup("#quantityLabel");
				
				quantityLabel.setText("Amount: " + 
						targetTrade.getQuantity().toString());
			
				Label userLabel = (Label) tradePane.lookup("#userLabel");
				userLabel.setText("User: " + targetTrade.getUserName());
			
			
				GridPane.setRowIndex(tradePane, row);
				GridPane.setColumnIndex(tradePane, column);
			
				yourOffersGridPane.getChildren().add(tradePane);
           
			} catch (IOException exception) {
				LOGGER.log(Level.SEVERE, exception.toString(), exception);
			
			} catch(NullPointerException exception) {
				
				LOGGER.log(Level.SEVERE, exception.toString(), exception);
				
			}
			
			column++;
			
			if (column % 2 == 0) {
				column = column % 2;
				row++;
			}
			
		}
	}

}
