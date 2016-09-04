package uq.deco2800.ducktales.market;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;

public class MarketController {
	
	/** Holder of a switchable vista. */
    @FXML
    private StackPane vistaHolder;

    /**
     * Replaces the vista displayed in the vista holder with a new vista.
     *
     * @param node the vista node to be swapped in.
     */
    public void setVista(Node node) {
        vistaHolder.getChildren().setAll(node);
    }
    
    @FXML
    void viewCurrentTrades(ActionEvent event) {
    	MarketVistaNavigator.loadVista(MarketVistaNavigator.CURRENT_TRADES);
    }
    
    @FXML
    void viewYourTrades(ActionEvent event) {
        MarketVistaNavigator.loadVista(MarketVistaNavigator.YOUR_TRADES);
    }
    
    @FXML
    void viewOffersTrades(ActionEvent event) {
    	//MarketVistaNavigator.loadVista(MarketVistaNavigator.VISTA_2);
    }
    
    @FXML
    void viewPlaceATrade(ActionEvent event) {
    	//MarketVistaNavigator.loadVista(MarketVistaNavigator.VISTA_2);
    }
    
    

}
