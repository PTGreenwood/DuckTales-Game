package uq.deco2800.ducktales.tutorials;

import java.net.URL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class TutorialController {
	
	
	//private BorderPane tutorialPane;
	
	
	private BorderPane tutorial1;
	private BorderPane tutorial2;
	private BorderPane tutorial3;
	
	@FXML
	private AnchorPane tutorialWindow, rightPane;
	
	
	
	@FXML
	public void startTutorial1(ActionEvent event) throws Exception {
		rightPane.getChildren().removeAll(tutorial1,tutorial2,tutorial3);
		URL location = getClass().getResource("tutorial1.fxml");
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(location);
		tutorial1 = loader.load();
		tutorial1.setPrefHeight(rightPane.getHeight());
		tutorial1.setPrefWidth(rightPane.getWidth());
		
		rightPane.getChildren().add(tutorial1);
	}
	
	@FXML
	public void startTutorial2(ActionEvent event) throws Exception {
		rightPane.getChildren().removeAll(tutorial1,tutorial2,tutorial3);
		URL location = getClass().getResource("tutorial2.fxml");
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(location);
		tutorial2 = loader.load();
		tutorial2.setPrefHeight(rightPane.getHeight());
		tutorial2.setPrefWidth(rightPane.getWidth());
		
		rightPane.getChildren().add(tutorial2);
	}
	
	@FXML
	public void startTutorial3(ActionEvent event) throws Exception {
		rightPane.getChildren().removeAll(tutorial1,tutorial2,tutorial3);
		URL location = getClass().getResource("tutorial3.fxml");
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(location);
		tutorial3 = loader.load();
		tutorial3.setPrefHeight(rightPane.getHeight());
		tutorial3.setPrefWidth(rightPane.getWidth());
		
		rightPane.getChildren().add(tutorial3);
	}
	
}
