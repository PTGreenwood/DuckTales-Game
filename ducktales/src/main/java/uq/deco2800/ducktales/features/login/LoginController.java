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
 *
 * @author wentingwang
 */
public class LoginController  {
	/** The logger */
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);
    
    @FXML
    private Text actiontarget;
    @FXML
    private TextField username;
    @FXML
    private PasswordField passwordField;
    
    private static Stage primaryStage;
    
    private static DucktalesClient client = null;
    
	public static void close()
	{
		if (primaryStage != null)
			primaryStage.close();
	}
    
	
    @FXML protected void handleSignUpButtonAction() throws IOException {
        
        LoginVistaNavigator.loadVista(LoginVistaNavigator.SIGNUP);

    }
    
    private void goToSignUpPage() throws IOException {
    	
		LoginVistaNavigator.loadVista(LoginVistaNavigator.SIGNUP);
    }
    
    
    
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
					LOGGER.debug("Unable to connecto to server");
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
    
    
    @FXML 
    protected void closeLoginFrame() {
    	primaryStage.close();
    }
    
    
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

