package uq.deco2800.ducktales.missions;

import java.net.URL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class MissionController {
	
	
	private BorderPane mission1;
	private BorderPane mission2;
	private BorderPane achievement;
	@FXML	
	private AnchorPane missionWindow, rightPane;
	
	
	
	@FXML
	public void startmission1(ActionEvent event) throws Exception {
		rightPane.getChildren().removeAll(mission1,mission2,achievement);
		URL location = getClass().getResource("mission1.fxml");
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(location);
		mission1 = loader.load();
		mission1.setPrefHeight(rightPane.getHeight());
		mission1.setPrefWidth(rightPane.getWidth());		
		rightPane.getChildren().add(mission1);
	}
	
	@FXML
	public void startmission2(ActionEvent event) throws Exception {
		rightPane.getChildren().removeAll(mission1,mission2,achievement);
		URL location = getClass().getResource("mission2.fxml");
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(location);
		mission2 = loader.load();
		mission2.setPrefHeight(rightPane.getHeight());
		mission2.setPrefWidth(rightPane.getWidth());		
		rightPane.getChildren().add(mission2);
	}
	
	@FXML
	public void startachievement(ActionEvent event) throws Exception {
		rightPane.getChildren().removeAll(mission1,mission2,achievement);
		URL location = getClass().getResource("achievement.fxml");
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(location);
		achievement = loader.load();
		achievement.setPrefHeight(rightPane.getHeight());
		achievement.setPrefWidth(rightPane.getWidth());		
		rightPane.getChildren().add(achievement);
	}
	
}
