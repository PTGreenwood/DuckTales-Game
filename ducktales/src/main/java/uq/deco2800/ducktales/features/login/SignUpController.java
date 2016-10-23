package uq.deco2800.ducktales.features.login;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.WebApplicationException;

import com.fasterxml.jackson.core.JsonProcessingException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import uq.deco2800.singularity.clients.ducktales.DucktalesClient;
import uq.deco2800.singularity.common.representations.User;


/**
 * Handles the sign up view created in signUp.fxml
 *
 * @author wentingwang
 */
public class SignUpController  {
    
    @FXML
    /** The text field that displays sign up error hints */
    private Text actiontarget;
    
    @FXML
    /** The user name input field. */
    private TextField username;
    
    @FXML
    /** The password input field for the password the user wants. */
    private PasswordField passwordField;
    
    @FXML
    /** 
     * Another password input field in order to confirm the user's intended
     * password
     * */
    private PasswordField passwordField2;
    
    /** Logger for the class */
 	private static final Logger LOGGER = Logger.getLogger(SignUpController.class.getName());
    
 	/** 
     * The DuckTales version of the Singularity client that is used for 
     * login and trade information communication.
     */
    private static DucktalesClient client = null;
    
    /**
     * Attempts to create a user account with the given user name and password
     * if they are valid.
     */
    @FXML protected void handleSignUpButtonAction() {
    	boolean bexit = false;
    	if(passwordField.getText().equals(passwordField2.getText()))
    	{
    		
    		String signUpUsername = username.getText();
    		String signUpPassword = passwordField.getText();
    		
            if(username.getText().toString().length() >= 6 && passwordField.getText().toString().length() >= 6)
            {
	    		User user = new User(signUpUsername, "Unknown", null, "Unknown", signUpPassword);
	    		
	    		try {
					user = client.createUser(user);
	    		
	    		} catch (WebApplicationException e) {
	    			LOGGER.log(Level.SEVERE, e.toString(), e);
	    			if (e.getResponse().getStatus() == 409) {
	    				actiontarget.setText("Sign up error: Username already exists");
	    			} else {
	    				
	    			}
	    			
	    		} catch (JsonProcessingException e) {
	    			LOGGER.log(Level.SEVERE, e.toString(), e);
	
				} catch (Exception e) {
					LOGGER.log(Level.SEVERE, e.toString(), e);
				}
	    		
	    		// Go back to Login view
	    		
	    		LoginVistaNavigator.loadVista(LoginVistaNavigator.LOGIN);
            }
            else
            {
            	actiontarget.setText("username/password \nlength must be 6 number");
            }
    	}
    	else
    	{
    		actiontarget.setText("password not consistent.");
    	}
    }
    
    /**
     * Changes the view to the login page.
     */
    @FXML
    protected void viewLoginPage() {
    	LoginVistaNavigator.loadVista(LoginVistaNavigator.LOGIN);
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
    
    /**
     * Gets the instance of the Ducktales client that will be used to sign up
     * users and sign them in to the game.
     * 
     * @param client
     * @return assigned DucktalesClient instance
     */
    public static DucktalesClient getClient() {
    	return client;
    }
    
}

