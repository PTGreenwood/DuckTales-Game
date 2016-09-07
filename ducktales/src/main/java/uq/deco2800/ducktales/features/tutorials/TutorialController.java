package uq.deco2800.ducktales.features.tutorials;

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
	private BorderPane tutorial4;
	private BorderPane tutorial5;
	private BorderPane tutorial6;
	private BorderPane tutorial7;
	
	
	
	@FXML
	private AnchorPane tutorialWindow, rightPane;
	
	
	
	@FXML
	public void startTutorial1(ActionEvent event) throws Exception {
		rightPane.getChildren().removeAll(tutorial1,tutorial2,tutorial3,tutorial4,tutorial5,tutorial6,tutorial7);
		URL location = getClass().getResource("resourcetut.fxml");
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(location);
		tutorial1 = loader.load();
		tutorial1.setPrefHeight(rightPane.getHeight());
		tutorial1.setPrefWidth(rightPane.getWidth());
		
		rightPane.getChildren().add(tutorial1);
	}
	
	@FXML
	public void startTutorial2(ActionEvent event) throws Exception {
		rightPane.getChildren().removeAll(tutorial1,tutorial2,tutorial3,tutorial4,tutorial5,tutorial6,tutorial7);
		URL location = getClass().getResource("weathertut.fxml");
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
		URL location = getClass().getResource("animaltut.fxml");
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(location);
		tutorial3 = loader.load();
		tutorial3.setPrefHeight(rightPane.getHeight());
		tutorial3.setPrefWidth(rightPane.getWidth());
		
		rightPane.getChildren().add(tutorial3);
	}
	
	@FXML
	public void startTutorial4(ActionEvent event) throws Exception {
		rightPane.getChildren().removeAll(tutorial1,tutorial2,tutorial3,tutorial4,tutorial5,tutorial6,tutorial7);
		URL location = getClass().getResource("tradetut.fxml");
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(location);
		tutorial4 = loader.load();
		tutorial4.setPrefHeight(rightPane.getHeight());
		tutorial4.setPrefWidth(rightPane.getWidth());
		
		rightPane.getChildren().add(tutorial4);
	}
	
	@FXML
	public void startTutorial5(ActionEvent event) throws Exception {
		rightPane.getChildren().removeAll(tutorial1,tutorial2,tutorial3,tutorial4,tutorial5,tutorial6,tutorial7);
		URL location = getClass().getResource("godtut.fxml");
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(location);
		tutorial5 = loader.load();
		tutorial5.setPrefHeight(rightPane.getHeight());
		tutorial5.setPrefWidth(rightPane.getWidth());
		
		rightPane.getChildren().add(tutorial5);
	}
	
	@FXML
	public void startTutorial6(ActionEvent event) throws Exception {
		rightPane.getChildren().removeAll(tutorial1,tutorial2,tutorial3,tutorial4,tutorial5,tutorial6,tutorial7);
		URL location = getClass().getResource("enemytut.fxml");
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(location);
		tutorial6 = loader.load();
		tutorial6.setPrefHeight(rightPane.getHeight());
		tutorial6.setPrefWidth(rightPane.getWidth());
		
		rightPane.getChildren().add(tutorial6);
	}
	
	@FXML
	public void startTutorial7(ActionEvent event) throws Exception {
		rightPane.getChildren().removeAll(tutorial1,tutorial2,tutorial3,tutorial4,tutorial5,tutorial6,tutorial7);
		URL location = getClass().getResource("jobtut.fxml");
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(location);
		tutorial7 = loader.load();
		tutorial7.setPrefHeight(rightPane.getHeight());
		tutorial7.setPrefWidth(rightPane.getWidth());
		
		rightPane.getChildren().add(tutorial7);
	}
	
	
	
	
}
