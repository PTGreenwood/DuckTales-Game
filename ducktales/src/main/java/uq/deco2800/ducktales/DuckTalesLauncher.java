package uq.deco2800.ducktales;

import uq.deco2800.ducktales.ui.DuckTalesController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.awt.Toolkit;
import java.awt.Dimension;

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
		
		Toolkit awtToolKit = Toolkit.getDefaultToolkit();
	    Dimension screenDimensions = awtToolKit.getScreenSize(); 
	    
	    double screenWidth = screenDimensions.getWidth();
	    double screenHeight = screenDimensions.getHeight(); 
		
		Scene scene = new Scene(root, screenWidth, screenHeight);
		
		DuckTalesController ducktalesController = fxmlLoader.getController(); // link the controller to the FXML file

		//Add in title screen CSS file for JavaFX
		URL url = this.getClass().getResource("/title_screen.css");
		String css = url.toExternalForm(); 
		//Apply CSS file to current scene
	    scene.getStylesheets().add(css);
		primaryStage.setTitle("DuckTales v" + version);
		primaryStage.setScene(scene);
		primaryStage.setMinWidth(screenWidth*0.5);
		primaryStage.setMinHeight(screenHeight*0.5);
		primaryStage.setOnCloseRequest(e -> ducktalesController.stopGame());
		primaryStage.show();	
	}
	
	
	
}
