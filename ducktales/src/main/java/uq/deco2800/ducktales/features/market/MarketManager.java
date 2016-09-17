package uq.deco2800.ducktales.features.market;

import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

/**
 * The main layout controller for the marketplace view.
 * 
 * Based off code from: https://gist.github.com/jewelsea/6460130
 * 
 * @author jewelsea, Mark Belonogoff
 *
 */
public class MarketManager {
	
	private MarketModel marketModel;

	/** The root pane where everything else is added onto */
	@FXML
	private VBox marketplacePane;

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
    private static final String BTN_SELECTED = "#1b1464";
    
    private static final String BTN_BORDER_COLOUR = "white";
    
    /** Deselected navigation button background colour **/
    private static final String BTN_NOT_SELECTED = "#1a1935";
    
    /** Enum corresponding to the navigation buttons**/
    public enum Vista {
    	ALLTRADES, YOURTRADES, YOUROFFERS, PLACEATRADE 
    }
    
    /**String for the background color**/
    String backgroundColorString = "-fx-background-color: ";
    
    String btnColorString = "-fx-border-color: ";
    
    /** The enum of the currently selected navigation button.**/
    private Vista selectedVista = Vista.ALLTRADES;
    
    /**
     * Constructor for the MarketManager. Sets the Main Controller for the
     * MarketVistaNavigator and the initial vista to display.
     */
    public MarketManager() {
    	
    	// Set the controller that displays the vistas as child elements.
        MarketVistaNavigator.setMainController(this);
        
        // Create a new instance of the MarketModel
        marketModel = new MarketModel();
    	
    }
    
    @FXML
	public void initialize() {
    	MarketVistaNavigator.loadVista(MarketVistaNavigator.ALL_TRADES);
    }
    
    public List<MocTrade> getAllTrades() {
    	return this.marketModel.getAllTrades();
    }

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
    	MarketVistaNavigator.loadVista(MarketVistaNavigator.ALL_TRADES);
    	
    	deselectButton(selectedVista);
        selectButton(Vista.ALLTRADES);
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
    		case ALLTRADES: currentTradesBtn.setStyle(
    				backgroundColorString+BTN_NOT_SELECTED + "; " 
    		+ btnColorString+BTN_BORDER_COLOUR);
    			break;
    			
    		case YOURTRADES: yourTradesBtn.setStyle(
    				backgroundColorString+BTN_NOT_SELECTED + "; " 
    			    		+ btnColorString+BTN_BORDER_COLOUR);
    			break;
    			
    		case YOUROFFERS: yourOffersBtn.setStyle(
    				backgroundColorString+BTN_NOT_SELECTED + "; " 
    			    		+ btnColorString+BTN_BORDER_COLOUR);
    			break;
    			
    		case PLACEATRADE: placeATradeBtn.setStyle(
    				backgroundColorString+BTN_NOT_SELECTED + "; " 
    			    		+ btnColorString+BTN_BORDER_COLOUR);
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
    		case ALLTRADES: currentTradesBtn.setStyle(
    				backgroundColorString+BTN_SELECTED + "; " 
    			    		+ btnColorString+BTN_BORDER_COLOUR);
    			selectedVista = Vista.ALLTRADES;
    			break;
    			
    		case YOURTRADES: yourTradesBtn.setStyle(
    				backgroundColorString+BTN_SELECTED + "; " 
    			    		+ btnColorString+BTN_BORDER_COLOUR);
    			selectedVista = Vista.YOURTRADES;
    			break;
    			
    		case YOUROFFERS: yourOffersBtn.setStyle(
    				backgroundColorString+BTN_SELECTED + "; " 
    			    		+ btnColorString+BTN_BORDER_COLOUR);
    			selectedVista = Vista.YOUROFFERS;
    			break;
    			
    		case PLACEATRADE: placeATradeBtn.setStyle(
    				backgroundColorString+BTN_SELECTED + "; " 
    			    		+ btnColorString+BTN_BORDER_COLOUR);
    			selectedVista = Vista.PLACEATRADE;
    			break;
    			
    		default: break;
    			
    	}
    	
    }

	/**
	 * Show and hide the marketplace pane
	 */
	public void showMarketPlace() {
    	this.marketplacePane.setVisible(true);
	}
	public void hideMarketPlace() {
		this.marketplacePane.setVisible(false);
	}
	//@mattyleggy, added this in for keyboard handlers
	public void toggleMarketPlace() {
		if (this.marketplacePane.isVisible())
			hideMarketPlace();
		else
			showMarketPlace();
	}
	public boolean isVisible() {
		return this.marketplacePane.isVisible();
	}
}
