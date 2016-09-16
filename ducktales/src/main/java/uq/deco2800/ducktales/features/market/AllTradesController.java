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
		for(int i=0; i < 6; i++) {
			
			FXMLLoader loader = new FXMLLoader();
			
			MocTrade trade = allTrades.get(i);
			try {
				
				loader.setLocation(path);
				
			Pane tradePane = (Pane) loader.load();
			
			if (tradePane == null) {
				System.err.println("tradePane is null ");
			}
			
			Label itemNameLabel = 
					(Label) tradePane.lookup("#itemNameLabel");
			
			itemNameLabel.setText(trade.getItemName());
			
			Label quantityLabel = (Label) tradePane.lookup("#quantityLabel");
			
			if (quantityLabel == null) {
				System.err.println("quantityLabel is null ");
			}
			
			quantityLabel.setText("Amount: " + trade.getQuantity().toString());
			
			Label userLabel = (Label) tradePane.lookup("#userLabel");
			
			if (userLabel == null) {
				System.err.println("userLabel is null ");
			}
			
			userLabel.setText("User: " + trade.getUserName());
			
			if (allTradesGridPane == null) {
				System.err.println("allTradesGridPane is null ");
			}
			
			GridPane.setRowIndex(tradePane, row);
            GridPane.setColumnIndex(tradePane, column);
			
			allTradesGridPane.getChildren().add(tradePane);
			
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
