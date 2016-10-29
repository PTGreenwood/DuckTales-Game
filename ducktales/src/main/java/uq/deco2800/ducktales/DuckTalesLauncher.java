package uq.deco2800.ducktales;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.net.URL;


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
		//method to get the movie player showed up
		Scene scene = new Scene(root, 1295, 737);
		Parent root2 = FXMLLoader.load(getClass().getResource("/ui/main/MoviePlayer.fxml"));
		Scene scene2 = new Scene(root2);
		Stage s = new Stage();
		s.setScene(scene2);
		s.showAndWait();
		
		// call the function here to avoid the audio to keep playing
		MoviePlayerController.closeAudio();
		s.close();
		s = null;
		
		primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent t) {
            
                Platform.exit();
                System.exit(0);
            }
        });
		
		primaryStage.setTitle("DuckTales v" + version);
		primaryStage.setScene(scene);
		primaryStage.setMinWidth(1200);
		primaryStage.setMinHeight(700);
		primaryStage.show();
		

	}
	
}
