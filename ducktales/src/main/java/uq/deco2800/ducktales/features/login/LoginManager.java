package uq.deco2800.ducktales.features.login;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;
import uq.deco2800.ducktales.features.market.MarketModel;
import uq.deco2800.ducktales.features.market.MarketVistaNavigator;
import uq.deco2800.singularity.clients.ducktales.DucktalesClient;

/**
 * Based off code from: https://gist.github.com/jewelsea/6460130
 * 
 * @author jewelsea, Mark Belonogoff
 */
public class LoginManager {
	
	/** Holder of a switchable vista. */
    @FXML
    private StackPane vistaHolder;
    
    private static DucktalesClient client = null;
    
    /**
     * Constructor for the LoginManager. Sets the Main Controller for the
     * Login/Sign up Feature and the initial vista to display.
     */
    public LoginManager() {
    	
    	// Set the controller that displays the vistas as child elements.
        LoginController.setClient(client);
    	LoginVistaNavigator.setMainController(this);
    	
    }
    
    /**
	 * Continues set up once initial GUI elements have been created.
	 */
    @FXML
	public void initialize() {
    	LoginVistaNavigator.loadVista(LoginVistaNavigator.LOGIN);
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
     * Sets the instance of the Ducktales client that will be used to sign up
     * users and sign them in to the game.
     * 
     * @param client
     */
    public static void setClient(DucktalesClient clientInstance) {
    	client = clientInstance;
    }
}
