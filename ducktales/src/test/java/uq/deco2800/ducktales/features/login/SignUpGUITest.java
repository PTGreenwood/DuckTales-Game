package uq.deco2800.ducktales.features.login;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Test;
import org.loadui.testfx.GuiTest;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import uq.deco2800.singularity.clients.ducktales.DucktalesClient;

public class SignUpGUITest extends GuiTest {
	
	Parent parent = null;

	LoginManager loginManager;
	
	SignUpController signUpController;
	
	DucktalesClient client;

	/**
	 * Set up for TestFX.
	 */
	@Override
	public Parent getRootNode() {

		try {
			// Load the all trades instance
			FXMLLoader loader = new FXMLLoader(getClass().getResource(LoginVistaNavigator.SIGNUP));

			parent = loader.load();

			// store a reference to the allTradesController instance
			this.signUpController = loader.<SignUpController> getController();
			
			this.client = new DucktalesClient();
			
			this.loginManager.setClient(this.client);
			
			LoginVistaNavigator.setMainController(loginManager);

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

		}

		return parent;
	}
	/**
	 * Test for adding a new user to the client
	 * 
	 */
	@Test
	public void testSuccesfulSignUp() {

		String validUser = "validUser";
		String validPassword = "password";

		TextField usernameField = (TextField) GuiTest.find("#username");
		usernameField.setText("validUser");

		TextField passwordField = (TextField) GuiTest.find("#passwordField");
		passwordField.setText(validPassword);
		
		TextField passwordTwoField = (TextField) GuiTest.find("#passwordField2");
		passwordTwoField.setText(validPassword);

		assertTrue(((TextField) GuiTest.find("#username")).getText().equals(validUser));
		assertTrue(((TextField) GuiTest.find("#passwordField")).
				getText().equals(validPassword));
		assertTrue(((TextField) GuiTest.find("#passwordField2")).
				getText().equals(validPassword));
	}
	/**
	 * test to check if the  ducktales client is connected
	 * 
	 */
	@Test
	public void clientTest() {
		this.signUpController.setClient(this.client);
		
		assertTrue(this.client.equals(this.signUpController.getClient()));
	}

}
