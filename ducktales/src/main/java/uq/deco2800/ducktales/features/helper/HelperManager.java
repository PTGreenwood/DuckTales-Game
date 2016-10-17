package uq.deco2800.ducktales.features.helper;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import uq.deco2800.ducktales.features.missions.MissionHandler;

public class HelperManager {
	
	@FXML
	private AnchorPane mainWindow;	
	@FXML
	private ImageView helperImageView;
	@FXML
	private Label helperLabel;
	
	private Image duckImage = new Image("/helper/helper.png");

	private boolean helperClose = false;
	
	private int helperLoadNumber = 0;
	
	private MissionHandler missionHandler = MissionHandler.getInstance();
	
	private String helperString1 = "Click I to open mission interface and finish helper missions";
	private String helperString2 = "All helper missions are completed";
	
	@FXML
	public void helperLoad() {
		
		switch(helperLoadNumber) {
			case 0: 
				setImageAndText(duckImage, helperString1);
				break;
			case 1:
				if(missionHandler.getNumberOfCompletedMissions() == 3.0) {
					setImageAndText(duckImage, helperString2);
				} else {					
					helperLoadNumber -= 1;
				}
				break;
			case 2:
				this.hideHelper();
				break;
		}
		
		helperLoadNumber += 1;
		
	}
	
	private void setImageAndText(Image image, String text) {
		helperImageView.setImage(image);
		helperLabel.setText(text);
	}
	
	
	
	
	
	
	public void showHelper() {
    	this.mainWindow.setVisible(true);
	}
	public void hideHelper() {
		this.mainWindow.setVisible(false);
	}
	
	
}
