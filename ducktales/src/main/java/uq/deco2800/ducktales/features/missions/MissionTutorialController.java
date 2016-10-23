package uq.deco2800.ducktales.features.missions;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

/**
 * Controller for the tutorial missions
 * 
 * @author Naehyung Kim
 *
 */
public class MissionTutorialController {

	/** title label */
	@FXML
	private Label labelTop;
	
	/** main window */
	@FXML
	private BorderPane mainWindow;
	
	/** inner grid for missions */
	@FXML
	private GridPane mainGrid;
	
	/** mission labels */
	@FXML
	private Label mission1;
	@FXML
	private Label mission2;
	@FXML
	private Label mission3;
	
	/** mission ticked or unticked box image */
	@FXML
	private ImageView box1;	
	@FXML
	private ImageView box2;
	@FXML
	private ImageView box3;
	
	/**
	 * Main constructor of {@link Missions} class
	 * 
	 */
	public MissionTutorialController() {
		
	}
	
	/**
	 * Get box1 in fxml
	 * @return box1
	 */
	public ImageView getBox1() {
		return this.box1;
	}
	
	/**
	 * Get box2 in fxml
	 * @return box2
	 */
	public ImageView getBox2() {
		return this.box2;
	}
	
	/**
	 * Get box3 in fxml
	 * @return box3
	 */
	public ImageView getBox3() {
		return this.box3;
	}
	
	/**
	 * Get Main window	
	 * @return mainWindow (BorderPane)
	 */
	public BorderPane getMainWindow() {
		return this.mainWindow;
	}
	
}
