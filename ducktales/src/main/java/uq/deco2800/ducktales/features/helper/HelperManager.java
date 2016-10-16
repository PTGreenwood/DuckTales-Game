package uq.deco2800.ducktales.features.helper;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class HelperManager {
	
	@FXML
	private AnchorPane mainWindow;	
	@FXML
	private ImageView helperImageView;
	@FXML
	private Label helperLabel;
	
	private Image duckImage = new Image("/helper/helper.png");

	private boolean helperClose = false;
	
	@FXML
	public void helperLoad1() {
		helperImageView.setImage(duckImage);
		helperLabel.setText("quack quack quack...");

		if (helperClose == false) {
			helperClose = true;
		} else {
			this.hideHelper();
		}
		
	}
	
	
	
	public void showHelper() {
    	this.mainWindow.setVisible(true);
	}
	public void hideHelper() {
		this.mainWindow.setVisible(false);
	}
	
	
}
