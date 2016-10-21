package uq.deco2800.ducktales.features.missions;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.BorderPane;

public class MissionProgressController {

	
	@FXML
	private BorderPane mainWindow;
	
	private ProgressIndicator pi;
	
	@FXML
	private Label labelTop;
	
	private static MissionProgressController INSTANCE = new MissionProgressController();
	
	public static MissionProgressController getInstance() {
		return INSTANCE;
	}
	
	public MissionProgressController() {
		this.pi = new ProgressIndicator();	
		this.pi.setProgress(0.0);
		this.pi.setPrefSize(100.0, 100.0);
	}
	
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
