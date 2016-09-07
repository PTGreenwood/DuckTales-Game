package uq.deco2800.ducktales.features.market;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

/**
 * The main layout controller for the marketplace view.
 * 
 * Based off code from: https://gist.github.com/jewelsea/6460130
 * 
 * @author jewelsea, Mark Belonogoff
 *
 */
public class MarketController {
	
	/** Holder of a switchable vista. */
    @FXML
    private StackPane vistaHolder;
    
    /** Navigation Buttons**/
    @FXML
    private Button currentTradesBtn;
    @FXML
    private Button yourTradesBtn;
    @FXML
    private Button yourOffersBtn;
    @FXML
    private Button placeATradeBtn;
    
    /** Selected navigation button background colour **/ 
    private static String BTN_SELECTED = "#0C8F8F";
    
    /** Deselected navigation button background colour **/
    private static String BTN_NOT_SELECTED = "#73B06F";
    
    /** Enum corresponding to the navigation buttons**/
    public enum Vista {
    	CURRENTTRADES, YOURTRADES, YOUROFFERS, PLACEATRADE 
    }
    
    /** The enum of the currently selected navigation button.**/
    private Vista selectedVista = Vista.CURRENTTRADES;
    

    /**
     * Replaces the vista displayed in the vista holder with a new vista.
     *
     * @param node the vista node to be swapped in.
     */
    public void setVista(Node node) {
        vistaHolder.getChildren().setAll(node);
    }
    
    /**
     * Displays the "Current Trades" vista.
     * 
     * @param event The action event of the Current Trades Button. 
     */
    @FXML
    void viewCurrentTrades(ActionEvent event) {
    	MarketVistaNavigator.loadVista(MarketVistaNavigator.CURRENT_TRADES);
    	
    	deselectButton(selectedVista);
        selectButton(Vista.CURRENTTRADES);
    }
    
	/**
	 * Displays the "Your Trades" vista.
	 * 
	 * @param event The action event of the Your Trades Button.
	 */
    @FXML
    void viewYourTrades(ActionEvent event) {
        MarketVistaNavigator.loadVista(MarketVistaNavigator.YOUR_TRADES);
        
        
        deselectButton(selectedVista);
        selectButton(Vista.YOURTRADES);
        
    }
    
    /**
     * Displays the "Offer Trades" vista.
     * 
     * @param event The action event of the Offer Trades Button.
     */
    @FXML
    void viewOffersTrades(ActionEvent event) {
    	MarketVistaNavigator.loadVista(MarketVistaNavigator.YOUR_OFFERS);
    	
    	deselectButton(selectedVista);
        selectButton(Vista.YOUROFFERS);
    }
    
	/**
	 * Displays the "Place Trades" vista.
	 * @param event The action event of the Place Trades Button.
	 */
    @FXML
    void viewPlaceATrade(ActionEvent event) {
    	MarketVistaNavigator.loadVista(MarketVistaNavigator.PLACE_A_TRADE);
    	
    	deselectButton(selectedVista);
        selectButton(Vista.PLACEATRADE);
    }
    
    /**
     * Changes the background colour of the previously selected navigation
     * button.
     * 
     * @param button The previously selected button.
     */
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
    
    /**
     * 
     * Updates the selected button to the given button and updates 
     * the its background colour.
     * 
     * @param button The newly selected button.
     */
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
