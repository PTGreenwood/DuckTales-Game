package uq.deco2800.ducktales.market;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

public class MarketController {
	
	/** Holder of a switchable vista. */
    @FXML
    private StackPane vistaHolder;
    
    @FXML
    private Button currentTradesBtn;
    
    @FXML
    private Button yourTradesBtn;
    
    @FXML
    private Button yourOffersBtn;
    
    @FXML
    private Button placeATradeBtn;
    
    private static String BTN_SELECTED = "#0C8F8F";
    
    private static String BTN_NOT_SELECTED = "#73B06F";
    
    public enum Vista {
    	CURRENTTRADES, YOURTRADES, YOUROFFERS, PLACEATRADE 
    }
    
    private Vista selectedVista = Vista.CURRENTTRADES;
    

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
    	
    	deselectButton(selectedVista);
        selectButton(Vista.CURRENTTRADES);
    }
    
    @FXML
    void viewYourTrades(ActionEvent event) {
        MarketVistaNavigator.loadVista(MarketVistaNavigator.YOUR_TRADES);
        
        
        deselectButton(selectedVista);
        selectButton(Vista.YOURTRADES);
        
    }
    
    @FXML
    void viewOffersTrades(ActionEvent event) {
    	MarketVistaNavigator.loadVista(MarketVistaNavigator.YOUR_OFFERS);
    	
    	deselectButton(selectedVista);
        selectButton(Vista.YOUROFFERS);
    }
    
    @FXML
    void viewPlaceATrade(ActionEvent event) {
    	MarketVistaNavigator.loadVista(MarketVistaNavigator.PLACE_A_TRADE);
    	
    	deselectButton(selectedVista);
        selectButton(Vista.PLACEATRADE);
    }
    
    
    public void deselectButton(Vista button) {
    	
    	switch (button) {
    		case CURRENTTRADES: currentTradesBtn.setStyle(
    				"-fx-background-color:"+BTN_NOT_SELECTED);
    			break;
    			
    		case YOURTRADES: yourTradesBtn.setStyle(
    				"-fx-background-color:"+BTN_NOT_SELECTED);
    			break;
    			
    		case YOUROFFERS: yourOffersBtn.setStyle(
    				"-fx-background-color:"+BTN_NOT_SELECTED);
    			break;
    			
    		case PLACEATRADE: placeATradeBtn.setStyle(
    				"-fx-background-color:"+BTN_NOT_SELECTED);
    			break;
    			
    		default: break;
    			
    	}
    	
    }
    
    
	public void selectButton(Vista button) {
    	
		switch (button) {
    		case CURRENTTRADES: currentTradesBtn.setStyle(
    				"-fx-background-color:"+BTN_SELECTED);
    			selectedVista = Vista.CURRENTTRADES;
    			break;
    			
    		case YOURTRADES: yourTradesBtn.setStyle(
    				"-fx-background-color:"+BTN_SELECTED);
    			selectedVista = Vista.YOURTRADES;
    			break;
    			
    		case YOUROFFERS: yourOffersBtn.setStyle(
    				"-fx-background-color:"+BTN_SELECTED);
    			selectedVista = Vista.YOUROFFERS;
    			break;
    			
    		case PLACEATRADE: placeATradeBtn.setStyle(
    				"-fx-background-color:"+BTN_SELECTED);
    			selectedVista = Vista.PLACEATRADE;
    			break;
    			
    		default: break;
    			
    	}
    	
    }
    
    

}
