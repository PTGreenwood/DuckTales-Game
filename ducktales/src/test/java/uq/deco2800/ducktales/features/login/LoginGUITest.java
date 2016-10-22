package uq.deco2800.ducktales.features.login;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;
import org.loadui.testfx.GuiTest;
import org.testfx.framework.junit.ApplicationTest;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import uq.deco2800.ducktales.DuckTalesController;
import uq.deco2800.ducktales.features.market.AllTradesController;
import uq.deco2800.ducktales.features.login.LoginVistaNavigator;;

public class LoginGUITest extends GuiTest {

	Parent parent = null;

	LoginManager loginManager;
	
	LoginController loginController;

	/**
	 * Set up for TestFX.
	 */
	@Override
	public Parent getRootNode() {

		try {
			// Load the all trades instance
			FXMLLoader loader = new FXMLLoader(getClass().getResource(LoginVistaNavigator.MAIN));

			parent = loader.load();

			// store a reference to the allTradesController instance
			this.loginManager = loader.<LoginManager> getController();
			
			LoginVistaNavigator.setMainController(loginManager);

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

		}

		return parent;
	}

	@Test
	public void testSuccesfulLogin() {

		String validUser = "validUser";
		String validPassword = "password";

		TextField usernameField = (TextField) GuiTest.find("#username");
		usernameField.setText("validUser");

		TextField passwordField = (TextField) GuiTest.find("#passwordField");
		passwordField.setText(validPassword);

		assertTrue(((TextField) GuiTest.find("#username")).getText().equals(validUser));
		assertTrue(((TextField) GuiTest.find("#passwordField")).getText().equals(validPassword));
	}
	
}
