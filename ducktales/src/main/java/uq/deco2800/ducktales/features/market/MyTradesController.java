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
	
	private static final Logger LOGGER = Logger.getLogger(
			MyTradesController.class.getName());
	
	private MarketManager marketManager;
	
	private static String MY_TRADE_PANE = "/market/mpmytradespane.fxml";
	
	private URL path;
	
	@FXML
	private GridPane yourTradesGridPane;
	
	public MyTradesController() {
		this.marketManager = MarketVistaNavigator.getMainController();
		
		System.out.println("MyTradesController called");
	}
	
	
	@FXML
	public void initialize() {
		
		System.out.println("MyTradesController initialize() called");
		
		List<MocTrade> yourTrades = 
				this.marketManager.getTradesForLoggedInUser();
		
		System.out.println("yourTrades.size() = " + yourTrades.size());
				
		path = getClass().getResource(MY_TRADE_PANE);
		
		System.out.println("path = " + path);
		
		int row = 0;
		int column = 0;
		for(int i=0; i < yourTrades.size(); i++) {
			
			FXMLLoader loader = new FXMLLoader();
			
			MocTrade trade = yourTrades.get(i);
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
			
			if (column % 2 == 0) {
				column = column % 2;
				row++;
			}
			
		}
	}

}
