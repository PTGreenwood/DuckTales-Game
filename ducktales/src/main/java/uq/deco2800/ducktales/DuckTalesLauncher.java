package uq.deco2800.ducktales;

import java.net.URL;


import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


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
		
		primaryStage.setTitle("DuckTales v" + version);
		primaryStage.setScene(scene);
		primaryStage.setMinWidth(1200);
		primaryStage.setMinHeight(700);
		primaryStage.setOnCloseRequest(e -> System.exit(0));
		primaryStage.show();
		Parent root2 = FXMLLoader.load(getClass().getResource("/ui/main/MoviePlayer.fxml"));
		Scene scene2 = new Scene(root2);
		Stage s = new Stage();
		s.setScene(scene2);
		s.show();

	}
	
}
