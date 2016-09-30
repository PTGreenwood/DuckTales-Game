package uq.deco2800.ducktales.features.market;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class MyTradesController {
	
	/** Logger for the class */
	private static final Logger LOGGER = Logger.getLogger(
			MyTradesController.class.getName());
	
	/** The overall managing controller */
	private MarketManager marketManager;
	
	/** The file path to the panes that will appear in the grid pane */
	private static String MY_TRADE_PANE = "/market/mpmytradespane.fxml";
	
	/** The path to the dynamic resources */
	private URL path;
	
	/** The grid that stores the user's trades */
	@FXML
	private GridPane yourTradesGridPane;
	
	/**
	 * Creates a new instance of the MyTradesController.
	 */
	public MyTradesController() {
		this.marketManager = MarketVistaNavigator.getMainController();
		
		System.out.println("MyTradesController called");
	}
	
	/**
	 * Continues set up once initial GUI elements have been created.
	 */
	@FXML
	public void initialize() {
		
		System.out.println("MyTradesController initialize() called");
		
		List<MocTrade> userTrades = 
				this.marketManager.getTradesForLoggedInUser();
		
		System.out.println("yourTrades.size() = " + userTrades.size());
				
		path = getClass().getResource(MY_TRADE_PANE);
		
		System.out.println("path = " + path);
		
		int row = 0;
		int column = 0;
		
		// Loop through the trades that the user has already made offers on.
		for(int i=0; i < userTrades.size(); i++) {
			
			FXMLLoader loader = new FXMLLoader();
			
			MocTrade trade = userTrades.get(i);
			try {
				
				loader.setLocation(path);
				
				Pane tradePane = (Pane) loader.load();
			
				Label itemNameLabel = 
					(Label) tradePane.lookup("#itemNameLabel");
				
				itemNameLabel.setText(trade.getItemName());
				
				Label quantityLabel = 
						(Label) tradePane.lookup("#quantityLabel");
				
				quantityLabel.setText("Amount: " + 
					trade.getQuantity().toString());
			
				GridPane.setRowIndex(tradePane, row);
				GridPane.setColumnIndex(tradePane, column);
			
				yourTradesGridPane.getChildren().add(tradePane);
	       
	
			} catch (IOException exception) {
				LOGGER.log(Level.SEVERE, exception.toString(), exception);
			
			} catch(NullPointerException exception) {
				
				LOGGER.log(Level.SEVERE, exception.toString(), exception);
				
			}
			
			column++;
			
			/*
			 * Ensure that the row only increments after all column positions
			 * have been filled.
			 */
			if (column % 2 == 0) {
				column = column % 2;
				row++;
			}
			
		}
	}

}
