package uq.deco2800.ducktales.features.market;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.fxml.FXMLLoader;


/**
 * Handles the loading of vistas for each of the main marketplace navigation
 * buttons.
 * 
 * Navigator based off code from: https://gist.github.com/jewelsea/6460130
 * 
 * @author jewelsea, Mark Belonogoff
 *
 */
public class MarketVistaNavigator {
	
	/** Logger for the class */
	private static final Logger LOGGER = Logger.getLogger(
			MarketVistaNavigator.class.getName());
	
	/**
     * fxml layouts managed by the navigator.
     */
    public static final String MAIN = "/market/marketplace.fxml";
    public static final String ALL_TRADES = "/market/mpalltradesvista.fxml";
    public static final String YOUR_TRADES = "/market/mpyourtradesvista.fxml";
    public static final String YOUR_OFFERS = "/market/mpyouroffersvista.fxml";
    public static final String PLACE_A_TRADE = 
    		"/market/mpplacetradeoffervista.fxml";
    
    /** The current Vista  selected. */
    private static String currentVista = null;

    /** The main market layout controller. */
    private static MarketManager mainController;

    /**
     * Stores the main market controller for later use in navigation tasks.
     *
     * @param marketManager the main market layout controller.
     */
    public static void setMainController(MarketManager marketManager) {
    	MarketVistaNavigator.mainController = marketManager;
    }
    
    /**
     * Private constructor.
     */
    private MarketVistaNavigator() {
    	
    }
    
    /**
     * Returns the mainController.
     * 
     * @return
     */
    public static MarketManager getMainController() {
    	return mainController;
    }

    /**
     * Loads the vista with the given fxml file into the vistaHolder pane.
     * 
     * @param fxml the fxml file to be loaded.
     */
    public static void loadVista(String fxml) {
    	
    	// Prevent necessarily reloading the vista
    	if (currentVista == null || !currentVista.equals(fxml)) {
    		
    		try {
                mainController.setVista(
                    FXMLLoader.load(
                    		MarketVistaNavigator.class.getResource(fxml)
                        )
                    );
                
                currentVista = fxml;
                
            } catch (IOException exception) {
            	
            	LOGGER.log(Level.SEVERE, exception.toString(), exception);
            }
    		
    	}
    	
    }
    
}
