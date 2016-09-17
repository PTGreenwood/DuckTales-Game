package uq.deco2800.ducktales.features.level;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

/**
 * Manage all fxml action of the level
 * 
 * @author Naehyung Kim
 *
 */
public class LevelManager {
	
	@FXML 
	private AnchorPane level;
	
	/** Initialize classes */	
	LevelHandler levelMain = LevelHandler.getInstance();
	
	/**
	 * Start level
	 * 
	 */
	public void startLevel() {		
		
		Label levelDisplay = new Label("Level : " + levelMain.getLevel());	
		ProgressBar  pb1 = new ProgressBar();
		pb1 = levelMain.getProgressIndicator();		
		VBox levelVBox = new VBox(5);
		System.out.println("Current level = " + levelMain.getLevel());
		levelVBox.getChildren().addAll(levelDisplay,pb1);		
		level.getChildren().add(levelVBox);				
	}
	
	/**
	 * Show and hide main window
	 */
	public void showLevel() {
    	this.level.setVisible(true);
	}
	public void hideLevel() {
		this.level.setVisible(false);
	}
	//@mattyleggy, added this is for in-game keyboard handler
	public void toggleLevel() {
		if (this.level.isVisible())
			hideLevel();
		else
			showLevel();
	}
	public boolean isVisible() {
		return this.level.isVisible();
	}
}
