package uq.deco2800.ducktales.features.missions;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

/**
 * Controller for the main mission window
 * 
 * @author Naehyung Kim
 *
 */
public class MissionMainController {

	/** title label */
	@FXML
	private Label labelTop;
	
	/** mission Description */
	@FXML
	private Label missionDescription;
	
	/** Main window */
	@FXML
	private BorderPane mainWindow;
	
	public static final MissionMainController INSTANCE = new MissionMainController();
	
	/**
	 * Constructor of {@link Missions}
	 * 	
	 * @return <CODE>INSTANCE</CODE>
	 */
	public static MissionMainController getInstance() {
		
		return INSTANCE;
	}
	
	/**
	 * Main constructor of {@link Missions} class
	 * 
	 */
	public MissionMainController() {
		
	}
	
	/**
	 * Get Main Window in fxml
	 * @return mainWindow (BorderPane)
	 */
	public BorderPane getMainWindow() {
		return this.mainWindow;
	}
	
	
}
