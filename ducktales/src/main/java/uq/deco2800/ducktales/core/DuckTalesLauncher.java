package uq.deco2800.ducktales.core;

import uq.deco2800.ducktales.deprecated.ui.MenuKeyboardHandler;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.net.URL;

/**
 * Launcher class for DuckTales.
 * 
 * @author Leggy
 */
public class DuckTalesLauncher extends Application {
	private String version = "0.1";

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
		scene.addEventHandler(KeyEvent.KEY_PRESSED, new MenuKeyboardHandler(ducktalesController));
		primaryStage.setMinWidth(1200);
		primaryStage.setMinHeight(700);
		primaryStage.setOnCloseRequest(e -> ducktalesController.stopGame());
		primaryStage.show();	
	}
	
}
