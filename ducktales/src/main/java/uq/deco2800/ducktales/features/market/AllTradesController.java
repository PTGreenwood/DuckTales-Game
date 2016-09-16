package uq.deco2800.ducktales.features.market;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class AllTradesController {
	
	private MarketManager marketManager;
	
	private static String TRADE_PANE = "/market/mpalltradestradepane.fxml";
	
	private URL path;
	
	@FXML
	private StackPane currentTradeVistaPropId;
	
	@FXML
	private GridPane allTradesGridPane;
	
	public AllTradesController() {
		this.marketManager = MarketVistaNavigator.getMainController();
		System.out.println("AllTradesController created");
		
	}
	
	@FXML
	public void initialize() {
		
		List<MocTrade> allTrades = this.marketManager.getAllTrades();
		
		
				
		path = getClass().getResource(TRADE_PANE);
		
		
		int row = 0;
		int column = 0;
		for(int i=0; i < allTrades.size(); i++) {
			
			FXMLLoader loader = new FXMLLoader();
			
			MocTrade trade = allTrades.get(i);
			try {
				
				loader.setLocation(path);
				
			Pane tradePane = (Pane) loader.load();
			
			if (tradePane == null) {
				System.err.println("tradePane is null ");
			}
			
			try {
				
				Label itemNameLabel = 
						(Label) tradePane.lookup("#itemNameLabel");
				
				itemNameLabel.setText(trade.getItemName());
				
			} catch(NullPointerException exception) {
				
				System.err.println("Unable to set the item name label text");
				
			}
			
			
			try {
				Label quantityLabel = 
						(Label) tradePane.lookup("#quantityLabel");
				
				quantityLabel.setText("Amount: " + 
						trade.getQuantity().toString());
				
			} catch(NullPointerException exception) {
				System.err.println("Unable to set the quantity label text");
			}
			
			
			try {
				Label userLabel = (Label) tradePane.lookup("#userLabel");
				userLabel.setText("User: " + trade.getUserName());
				
			} catch(NullPointerException exception) {
				System.err.println("Unable to set the user label text");
			}
			
			
			if (allTradesGridPane == null) {
				System.err.println("allTradesGridPane is null ");
			}
			
			GridPane.setRowIndex(tradePane, row);
            GridPane.setColumnIndex(tradePane, column);
			
            try {
            	allTradesGridPane.getChildren().add(tradePane);
            } catch(NullPointerException exception) {
            	System.err.println("Unable add tradePane " + 
            			"to All Trades grid pane");
            }
			
			
			} catch (IOException exception) {
				
			}
			
			column++;
			
			if (column % 2 == 0) {
				column = column % 2;
				row++;
			}
			
		}
	}

}
