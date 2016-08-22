package uq.deco2800.ducktales;

import uq.deco2800.ducktales.ui.DuckTalesController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;

/**
 * Launcher class for DuckTales.
 * 
 * @author Leggy
 *
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
<<<<<<< HEAD
		DuckTalesController ducktalesController = fxmlLoader.getController();
		
		Scene scene = new Scene(root, 1200, 950);
		
=======
		DuckTalesController ducktalesController = fxmlLoader.getController(); // link the controller to the FXML file

		//Add in title screen CSS file for JavaFX
		URL url = this.getClass().getResource("/title_screen.css");
		Scene scene = new Scene(root, 1200, 950);
		String css = url.toExternalForm(); 
		//Apply CSS file to current scene
	    scene.getStylesheets().add(css);
>>>>>>> 01d7d3f75ab452bf1d903c9527c084c1f7f6fdc4
		primaryStage.setTitle("DuckTales v" + version);
		primaryStage.setScene(scene);
		primaryStage.setMinWidth(1200);
		primaryStage.setMinHeight(950);
		primaryStage.setOnCloseRequest(e -> ducktalesController.stopGame());
		primaryStage.show();	
	}
	
	
	
}
