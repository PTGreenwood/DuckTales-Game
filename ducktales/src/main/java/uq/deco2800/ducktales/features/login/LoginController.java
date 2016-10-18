package uq.deco2800.ducktales.features.login;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.ws.rs.WebApplicationException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import uq.deco2800.ducktales.DuckTalesController;
import uq.deco2800.ducktales.features.market.MarketVistaNavigator;
import uq.deco2800.singularity.clients.ducktales.DucktalesClient;
import uq.deco2800.singularity.common.representations.User;  


/**
 *
 * @author wentingwang
 */
public class LoginController  {
    
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
    
	
    @FXML protected void handleSignUpButtonAction(ActionEvent event) throws IOException {
        
        LoginVistaNavigator.loadVista(LoginVistaNavigator.SIGNUP);

    }
    
    private void goToSignUpPage() throws IOException {
    	
    	/*
    	Parent root1 = FXMLLoader.load(getClass().getResource("/ui/main/SignUp.fxml"));
    	
		Scene scene = new Scene(root1,300,275);
		primaryStage.setTitle("FXML Welcome");
		primaryStage.setScene(scene);
		primaryStage.showAndWait();
		 */
		
		LoginVistaNavigator.loadVista(LoginVistaNavigator.SIGNUP);
    }
    
    
    
    @FXML protected void handleSubmitButtonAction(ActionEvent event) throws Exception {
    	//event.fireEvent(this,new WindowEvent(this,WindowEvent.WINDOW_CLOSED));
    //if(username.getText().equals("123") && passwordField.getText().equals("456"))
    		//DuckTalesController.close();
    	//else
    	boolean bexit = false;
    	
    	String loginUserName = username.getText();
    	String loginPassword = passwordField.getText();
    	
    	// Code based off of CoasterRegoController.java
    	
    	User user = null;
    	
    	try {
    		// Attempt to log in
    		client.setupCredentials(loginUserName, loginPassword);
    		user = client.getUserInformationByUserName(loginUserName);
    	} catch (WebApplicationException e) {
    		switch (e.getResponse().getStatus()) {
				case 404:
					System.err.print("Unable to connecto to server");
					break;
				case 403:
					// User does not exist, redirect to sign up
					
					// Set the Ducktales client in Signup
					
					if (SignUpController.getClient() == null) {
						SignUpController.setClient(client);
					}
					
					goToSignUpPage();
					
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
    protected void closeLoginFrame(ActionEvent event) {
    	primaryStage.close();
    }
    
    
    public static void setPrimaryStage(Stage stage) {
    	primaryStage = stage;
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

