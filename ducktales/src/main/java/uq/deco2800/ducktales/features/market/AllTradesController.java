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

/**
 * Handles the logic behind mpalltradesvista.fxml
 * 
 * @author Mark Belonogoff
 *
 */
public class AllTradesController {
	
	/** Logger for the class */
	private static final Logger LOGGER = Logger.getLogger(
			AllTradesController.class.getName());
	
	/** The overall managing controller */
	private MarketManager marketManager;
	
	/** The file path to the panes that will appear in the grid pane */
	private static final String TRADE_PANE = 
			"/market/mpalltradestradepane.fxml";
	
	/** The path to the dynamic resources */
	private URL path;
	
	/** The stack pane id */
	@FXML
	private StackPane currentTradeVistaPropId;
	
	/** THe grid pane id */ 
	@FXML
	private GridPane allTradesGridPane;
	
	/**
	 * Creates a new instance of the AllTradesController.
	 */
	public AllTradesController() {
		this.marketManager = MarketVistaNavigator.getMainController();
		
	}
	
	/**
	 * Continues set up once initial GUI elements have been created.
	 */
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
