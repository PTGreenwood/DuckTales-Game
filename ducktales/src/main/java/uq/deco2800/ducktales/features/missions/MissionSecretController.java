package uq.deco2800.ducktales.features.missions;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class MissionSecretController {
	
	@FXML
	private Label labelTop;
	
	@FXML
	private BorderPane mainWindow;
	
	@FXML
	private GridPane mainGrid;
	
	@FXML
	private Label mission1;
	@FXML
	private Label mission2;
	@FXML
	private Label mission3;
	
	@FXML
	private ImageView box1;	
	@FXML
	private ImageView box2;
	@FXML
	private ImageView box3;
	
	public MissionSecretController() {
		
	}

	public Label getMission1() {
		return this.mission1;
	}
	
	public Label getMission2() {
		return this.mission2;
	}
	
	public Label getMission3() {
		return this.mission3;
	}
	
	public ImageView getBox1() {
		return this.box1;
	}
	public ImageView getBox2() {
		return this.box2;
	}
	public ImageView getBox3() {
		return this.box3;
	}
	
	public BorderPane getMainWindow() {
		return this.mainWindow;
	}
}
