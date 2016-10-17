package uq.deco2800.ducktales;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintStream;

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
 *
 * @author wentingwang
 */
public class SignUpController  {
    
    @FXML
    private Text actiontarget;
    @FXML
    private TextField username;
    @FXML
    private PasswordField passwordField;
    @FXML
    private PasswordField passwordField2;
    
    private static DucktalesClient client = null;
    
    boolean IsExitUser(String s)
    {
    	
    	return false;
    }

    @FXML protected void handleSignUpButtonAction(ActionEvent event) throws Exception {
    	boolean bexit = false;
    	if(passwordField.getText().equals(passwordField2.getText()))
    	{
    		
    		String signUpUsername = username.getText();
    		String signUpPassword = passwordField.getText();
    		
            if(username.getText().toString().length() >= 6 && passwordField.getText().toString().length() >= 6)
            {
            	if(!bexit)
        		{
            		User user = new User(signUpUsername, "Unknown", null, "Unknown", signUpPassword);
            		
            		try {
        				user = client.createUser(user);
            		
            		} catch (WebApplicationException e) {
            			switch (e.getResponse().getStatus()) {
        				case 409:
        					actiontarget.setText("Sign up error: Username already exists");
        				default:
        					// Other exception occurred
            			}
            		} catch (JsonProcessingException i) {
        				// Error processing json

        			} catch (Exception i) {
        				// Other error logging in
        			}
            		LoginController.close();
        		}
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

