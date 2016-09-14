package uq.deco2800.ducktales.features.market;

import java.io.IOException;

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
	
	/**
     * fxml layouts managed by the navigator.
     */
    public static final String MAIN = "/market/marketplace.fxml";
    public static final String CURRENT_TRADES = "/market/mpcurrenttradevista.fxml";
    public static final String YOUR_TRADES = "/market/mpyourtradesvista.fxml";
    public static final String YOUR_OFFERS = "/market/mpyouroffersvista.fxml";
    public static final String PLACE_A_TRADE = "/market/mpplacetradeoffervista.fxml";

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
    	
    	System.err.println("loadVista fxml input is " + fxml);
    		
		try {
            mainController.setVista(
                FXMLLoader.load(
                		MarketVistaNavigator.class.getResource(fxml)
                    )
                );
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }

}
