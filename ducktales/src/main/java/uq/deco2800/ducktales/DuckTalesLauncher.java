package uq.deco2800.ducktales;

import java.net.URL;

import javax.ws.rs.WebApplicationException;

import com.fasterxml.jackson.core.JsonProcessingException;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
//import uq.deco2800.ducktales.util.events.handlers.keyboard.MenuKeyboardHandler;
import uq.deco2800.singularity.clients.ducktales.DucktalesClient;
import uq.deco2800.singularity.common.representations.User;


/**
 * Launcher class for DuckTales.
 * 
 * @author Leggy
 */
public class DuckTalesLauncher extends Application {
	private String version = "0.1";

	@FXML
	private static AnchorPane contentPane;
	
	public static void main(String[] args) {
		launch(args);
	}
	

	@Override
	public void start(Stage primaryStage) throws Exception {
		URL location = getClass().getResource("/ducktales.fxml");
		FXMLLoader fxmlLoader = new FXMLLoader();
		fxmlLoader.setLocation(location);
				
		Parent root = fxmlLoader.load(location.openStream());
		
		Scene scene = new Scene(root, 1295, 737);	
		
		DuckTalesController ducktalesController = fxmlLoader.getController(); // link the controller to the FXML file
		primaryStage.setTitle("DuckTales v" + version);
		//primaryStage.setFullScreen(true);
		primaryStage.setScene(scene);		
		//scene.addEventHandler(KeyEvent.KEY_PRESSED, new InGameKeyboardHandler(ducktalesController));
		primaryStage.setMinWidth(1200);
		primaryStage.setMinHeight(700);
		//primaryStage.setOnCloseRequest(e -> ducktalesController.stopGame());
		primaryStage.setOnCloseRequest(e -> System.exit(0));
		primaryStage.show();
	}
	
}
