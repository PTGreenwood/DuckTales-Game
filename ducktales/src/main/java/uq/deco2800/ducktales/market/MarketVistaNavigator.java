package uq.deco2800.ducktales.market;

import java.io.IOException;

import javafx.fxml.FXMLLoader;

public class MarketVistaNavigator {
	
	
	/**
     * Convenience constants for fxml layouts managed by the navigator.
     */
    public static final String MAIN = "/marketplace.fxml";
    public static final String CURRENT_TRADES = "/mpcurrenttradevista.fxml";
    public static final String VISTA_2 = "vista2.fxml";

    /** The main application layout controller. */
    private static MarketController mainController;

    /**
     * Stores the main controller for later use in navigation tasks.
     *
     * @param mainController the main application layout controller.
     */
    public static void setMainController(MarketController marketController) {
    	MarketVistaNavigator.mainController = marketController;
    }

    /**
     * Loads the vista specified by the fxml file into the
     * vistaHolder pane of the main application layout.
     *
     * Previously loaded vista for the same fxml file are not cached.
     * The fxml is loaded anew and a new vista node hierarchy generated
     * every time this method is invoked.
     *
     * A more sophisticated load function could potentially add some
     * enhancements or optimizations, for example:
     *   cache FXMLLoaders
     *   cache loaded vista nodes, so they can be recalled or reused
     *   allow a user to specify vista node reuse or new creation
     *   allow back and forward history like a browser
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
