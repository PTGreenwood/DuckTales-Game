package uq.deco2800.ducktales.features.level;

import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import uq.deco2800.ducktales.util.SecondaryManager;

/**
 * Manage all fxml action of the level
 * 
 * @author Naehyung Kim
 *
 */
public class LevelManager implements SecondaryManager {
	
	@FXML 
	private AnchorPane level;
	@FXML
	private Label levelDisplay;
	@FXML
	private Label levelText;
	@FXML
	private ProgressBar pb1;
	
	
	/** Initialize classes */	
	LevelHandler levelMain = LevelHandler.getInstance();
	
	/**
	 * Start level
	 * 
	 */
	public void startLevel() {		
		levelText.setText("Level : ");
		levelDisplay.textProperty().bind(Bindings.convert(levelMain.valueProperty()));
		pb1 = levelMain.getProgressIndicator();		
		HBox levelHBox = new HBox(5);
		VBox levelVBox = new VBox(5);
		levelHBox.getChildren().addAll(levelText, levelDisplay);
		levelVBox.getChildren().addAll(levelHBox, pb1);		
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
	
	@Override
    public void reload() {

    }
}
