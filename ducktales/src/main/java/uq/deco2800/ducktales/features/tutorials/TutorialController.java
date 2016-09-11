package uq.deco2800.ducktales.features.tutorials;

import java.net.URL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class TutorialController {
	
	
	//private BorderPane tutorialPane;
	
	
	private BorderPane tutorial1;
	private BorderPane tutorial2;
	private BorderPane tutorial3;
	private BorderPane tutorial4;
	private BorderPane tutorial5;
	private BorderPane tutorial6;
	private BorderPane tutorial7;
	
	@FXML
	private AnchorPane anchorTutorial1;
	
	
	@FXML
	private AnchorPane tutorialWindow;
	private AnchorPane rightPane;
	
	
	
	@FXML
	public void startTutorial1(ActionEvent event) throws Exception {
		rightPane.getChildren().removeAll(tutorial1,tutorial2,tutorial3,tutorial4,tutorial5,tutorial6,tutorial7);
		URL location = getClass().getResource("/tutorials/tutorial1.fxml");
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(location);
		tutorial1 = loader.load();
		tutorial1.setPrefHeight(rightPane.getHeight());
		tutorial1.setPrefWidth(rightPane.getWidth());
		ScrollPane scroll = new ScrollPane(tutorial1.getCenter());
		rightPane.getChildren().add(tutorial1);
	}
	
	@FXML
	public void startTutorial2(ActionEvent event) throws Exception {
		rightPane.getChildren().removeAll(tutorial1,tutorial2,tutorial3,tutorial4,tutorial5,tutorial6,tutorial7);
		URL location = getClass().getResource("/tutorials/tutorial2.fxml");
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(location);
		tutorial2 = loader.load();
		tutorial2.setPrefHeight(rightPane.getHeight());
		tutorial2.setPrefWidth(rightPane.getWidth());
		
		rightPane.getChildren().add(tutorial2);
	}
	
	@FXML
	public void startTutorial3(ActionEvent event) throws Exception {
		rightPane.getChildren().removeAll(tutorial1,tutorial2,tutorial3,tutorial4,tutorial5,tutorial6,tutorial7);
		URL location = getClass().getResource("/tutorials/tutorial3.fxml");
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(location);
		tutorial3 = loader.load();
		tutorial3.setPrefHeight(rightPane.getHeight());
		tutorial3.setPrefWidth(rightPane.getWidth());
		
		rightPane.getChildren().add(tutorial3);
	}	
	
}
