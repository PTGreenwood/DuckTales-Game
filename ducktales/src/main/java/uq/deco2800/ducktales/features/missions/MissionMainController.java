package uq.deco2800.ducktales.features.missions;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class MissionMainController {

	@FXML
	private Label labelTop;
	
	@FXML
	private Label missionDescription;
	
	@FXML
	private BorderPane mainWindow;
	
	public static final MissionMainController INSTANCE = new MissionMainController();
	
	public static MissionMainController getInstance() {
		
		return INSTANCE;
	}
	
	public MissionMainController() {
		
	}
	
	public BorderPane getMainWindow() {
		return this.mainWindow;
	}
	
	
}
