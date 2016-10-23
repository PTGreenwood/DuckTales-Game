package uq.deco2800.ducktales.features.missions;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.BorderPane;

/**
 * Controller for the missions progress circle and mission progress window
 * 
 * @author Naehyung Kim
 *
 */
public class MissionProgressController {

	/** main window */
	@FXML
	private BorderPane mainWindow;
	
	/** Progress circle of missions */
	private ProgressIndicator pi;
	
	/** Title label */
	@FXML
	private Label labelTop;
	
	private static MissionProgressController INSTANCE = new MissionProgressController();
	
	/**
	 * Constructor of {@link Missions}
	 * 	
	 * @return <CODE>INSTANCE</CODE>
	 */
	public static MissionProgressController getInstance() {
		return INSTANCE;
	}
	
	/**
	 * Main constructor of {@link Missions} class
	 * 
	 */
	public MissionProgressController() {
		this.pi = new ProgressIndicator();	
		this.pi.setProgress(0.0);
		this.pi.setPrefSize(100.0, 100.0);
	}
	
	/**
	 * Get Main window	
	 * @return mainWindow (BorderPane)
	 */
	public BorderPane getMainWindow() {
		return this.mainWindow;
	}
	
	/**
	 * Set progress percentage
	 * 
	 * @param percentage
	 */
	public void setProgressPercentage(double percentage) {
		this.pi.setProgress(percentage);
		
	}
	
	/**
	 * get progress indicator
	 * 
	 * @return progress indicator
	 */
	public ProgressIndicator getProgressIndicator() {
		return this.pi;
	}
}
