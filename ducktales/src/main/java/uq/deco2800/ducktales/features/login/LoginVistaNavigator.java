package uq.deco2800.ducktales.features.login;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.fxml.FXMLLoader;
import uq.deco2800.ducktales.features.market.MarketVistaNavigator;

public class LoginVistaNavigator {
	
	/** Logger for the class */
	private static final Logger LOGGER = Logger.getLogger(
			MarketVistaNavigator.class.getName());
	
	public static final String MAIN = "/ui/login/loginFrame.fxml";
	public static final String LOGIN = "/ui/login/login.fxml";
	public static final String SIGNUP = "/ui/login/SignUp.fxml";
	
	/** The current Vista  selected. */
    private static String currentVista = null;
	
	/** The main application layout controller. */
	private static LoginManager mainController;
    
    /**
     * Private constructor.
     */
    private LoginVistaNavigator() {
    	
    }
    
    /**
     * Returns the mainController.
     * 
     * @return
     */
    public static LoginManager getMainController() {
    	return mainController;
    }
    
    /**
     * Stores the main market controller for later use in navigation tasks.
     *
     * @param marketManager the main market layout controller.
     */
    public static void setMainController(LoginManager loginManager) {
    	LoginVistaNavigator.mainController = loginManager;
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
                    		LoginVistaNavigator.class.getResource(fxml)
                        )
                    );
                
                currentVista = fxml;
                
            } catch (IOException exception) {
            	
            	LOGGER.log(Level.SEVERE, exception.toString(), exception);
            }
    		
    	}
    	
    }
    
    
    
}