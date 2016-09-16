package uq.deco2800.ducktales.features.tutorials;

import java.net.URL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class Tutorial1Controller {
	
	
	@FXML
	private BorderPane mainBorder;
	@FXML
	private Button next;
	@FXML
	private Button previous;
	
	private AnchorPane pane1, pane2;
		
	@FXML
	private void tutorial1Next(ActionEvent event) throws Exception {
		
		URL location = getClass().getResource("/tutorials/tutorial1Pane1.fxml");
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(location);
		pane1 = loader.load();
		
		pane1.setPrefHeight(mainBorder.getHeight());
		pane1.setPrefWidth(mainBorder.getWidth());
		mainBorder.setCenter(pane1);		
	}
	
	@FXML
	private void tutorial1Previous(ActionEvent event) throws Exception {
		
		
		URL location = getClass().getResource("/tutorials/tutorial1Pane0.fxml");
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(location);
		pane2 = loader.load();
		
		pane2.setPrefHeight(mainBorder.getHeight());
		pane2.setPrefWidth(mainBorder.getWidth());
		mainBorder.setCenter(pane2);	
	}
	
}
