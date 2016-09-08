package uq.deco2800.ducktales.features.level;

import java.io.IOException;
import java.net.URL;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class LevelManager {
	
	@FXML 
	private AnchorPane level;
	
	LevelHandler levelMain = LevelHandler.getInstance();
	
	public void startLevel() {
		
		
		Label levelDisplay = new Label("Level : " + levelMain.getLevel());	
		ProgressBar  pb1 = new ProgressBar();
		pb1 = levelMain.getProgressIndicator();		
		VBox levelVBox = new VBox(5);
		
		levelVBox.getChildren().addAll(levelDisplay,pb1);
		
		level.getChildren().add(levelVBox);
		
	}
		
	public void showLevel() {
    	this.level.setVisible(true);
	}
	public void hideLevel() {
		this.level.setVisible(false);
	}
}