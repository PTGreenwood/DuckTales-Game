package uq.deco2800.ducktales.features.login;
import java.io.IOException;

import javax.ws.rs.WebApplicationException;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import uq.deco2800.ducktales.DuckTalesController;
import uq.deco2800.singularity.clients.ducktales.DucktalesClient;
import uq.deco2800.singularity.common.representations.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * The controller for the login.fxml view.
 * Allows the user to log in using the singularity server.
 * 
 * @author wentingwang
 */
public class LoginController  {
	/** The logger */
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);
    
    @FXML
    /** The text field that displays log in error hints */
    private Text actiontarget;
    
    @FXML
    /** The user name input field. */
    private TextField username;
    
    @FXML
    /** The password input field for the corresponding user name. */
    private PasswordField passwordField;
    
    /** The stage that will contains the Login view.*/
    private static Stage primaryStage;
    
    /** 
     * The DuckTales version of the Singularity client that is used for 
     * login and trade information communication.
     */
    private static DucktalesClient client = null;
    
    /**
     * Closes the login pop up.
     */
	public static void close()
	{
		if (primaryStage != null)
			primaryStage.close();
	}
    
	/**
	 * Goes to the sign up page when the sign up button was pressed.
	 * 
	 * @throws IOException Error when trying to load the sign up view.
	 */
    @FXML protected void handleSignUpButtonAction() throws IOException {
        
        LoginVistaNavigator.loadVista(LoginVistaNavigator.SIGNUP);

    }
    
    /**
	 * Changes the view to the sign up view when clicked.
	 * 
	 * @throws IOException Error when trying to load the sign up view.
	 */
    private void goToSignUpPage() throws IOException {
    	
		LoginVistaNavigator.loadVista(LoginVistaNavigator.SIGNUP);
    }
    
    /**
     * Attempts to log using the given user name and password.
     * 
     * @throws WebApplicationException Error when attempting to log in.
     */
    @FXML protected void handleSubmitButtonAction() throws WebApplicationException {

    	String loginUserName = username.getText();
    	String loginPassword = passwordField.getText();
    	
    	// Code based off of CoasterRegoController.java
    	
    	User user = null;
    	
    	try {
    		// Attempt to log in
    		client.setupCredentials(loginUserName, loginPassword);
    		user = client.getUserInformationByUserName(loginUserName);
    	} catch (WebApplicationException e) {
			LOGGER.info("Exception when logging in", e);
    		switch (e.getResponse().getStatus()) {
				case 404:
					LOGGER.debug("Unable to connect to server");
					break;
				case 403:
					// User does not exist, redirect to sign up
					
					// Set the Ducktales client in Signup
					
					if (SignUpController.getClient() == null) {
						SignUpController.setClient(client);
					}

					try {
						goToSignUpPage();
					} catch (IOException e1) {
						LOGGER.info("Unable to find signup page", e1);
					}
					break;
				default:
					// Handle other errors
    		}
    		
    	}
        
        // Successful login
        if(user != null)
        {
        	DuckTalesController.setLoggedInStatus(true);
        	DuckTalesController.close();
        }
        else
        {
        	actiontarget.setText("password error!");
        }
    }
    
    /**
     * Closes the login view when the close button is pressed.
     */
    @FXML 
    protected void closeLoginFrame() {
    	primaryStage.close();
    }
    
    /**
     * Sets a reference to the pop up frame that contains the log in views.
     * 
     * @param stage The log in frame.
     */
    public static void setPrimaryStage(Stage stage) {
    	primaryStage = stage;
    }
    
    /**
     * Sets the instance of the Ducktales client that will be used to sign up
     * users and sign them in to the game.
     * 
     * @param clientInstance
     */
    public static void setClient(DucktalesClient clientInstance) {
    	if (client == null || !client.equals(clientInstance)) {
    		client = clientInstance;
    	}
    }
    
}

