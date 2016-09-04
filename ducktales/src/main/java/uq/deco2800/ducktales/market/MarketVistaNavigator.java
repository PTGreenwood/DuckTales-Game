package uq.deco2800.ducktales.market;

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
    public static final String MAIN = "/marketplace.fxml";
    public static final String CURRENT_TRADES = "/mpcurrenttradevista.fxml";
    public static final String YOUR_TRADES = "/mpyourtradesvista.fxml";
    public static final String YOUR_OFFERS = "/mpyouroffersvista.fxml";
    public static final String PLACE_A_TRADE = "/mpplacetradeoffervista.fxml";

    /** The main market layout controller. */
    private static MarketController mainController;

    /**
     * Stores the main market controller for later use in navigation tasks.
     *
     * @param mainController the main market layout controller.
     */
    public static void setMainController(MarketController marketController) {
    	MarketVistaNavigator.mainController = marketController;
    }
    
    /**
     * Returns the mainController.
     * 
     * @return
     */
    public static MarketController getMainController() {
    	return mainController;
    }

    /**
     * Loads the vista with the given fxml file into the vistaHolder pane.
     * 
     * @param fxml the fxml file to be loaded.
     */
    public static void loadVista(String fxml) {
        try {
            mainController.setVista(
                FXMLLoader.load(
                	MarketVistaNavigator.class.getResource(
                        fxml
                    )
                )
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
