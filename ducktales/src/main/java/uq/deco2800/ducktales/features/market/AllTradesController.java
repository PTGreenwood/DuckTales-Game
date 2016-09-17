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
import javafx.scene.layout.StackPane;

public class AllTradesController {
	
	private static final Logger LOGGER = Logger.getLogger(
			AllTradesController.class.getName() );

	
	private MarketManager marketManager;
	
	private static final String TRADE_PANE = 
			"/market/mpalltradestradepane.fxml";
	
	private URL path;
	
	@FXML
	private StackPane currentTradeVistaPropId;
	
	@FXML
	private GridPane allTradesGridPane;
	
	public AllTradesController() {
		this.marketManager = MarketVistaNavigator.getMainController();
		
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
			
				Label itemNameLabel = 
					(Label) tradePane.lookup("#itemNameLabel");
				
				itemNameLabel.setText(trade.getItemName());
				
			
			
				Label quantityLabel = 
						(Label) tradePane.lookup("#quantityLabel");
				
				quantityLabel.setText("Amount: " + 
					trade.getQuantity().toString());
			
			
				Label userLabel = (Label) tradePane.lookup("#userLabel");
				userLabel.setText("User: " + trade.getUserName());
			
			
				GridPane.setRowIndex(tradePane, row);
				GridPane.setColumnIndex(tradePane, column);
			
				allTradesGridPane.getChildren().add(tradePane);
           
			} catch (IOException | NullPointerException exception) {
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
