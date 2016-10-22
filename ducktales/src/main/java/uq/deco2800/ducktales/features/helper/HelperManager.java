package uq.deco2800.ducktales.features.helper;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import uq.deco2800.ducktales.features.entities.MainEntityManager;
import uq.deco2800.ducktales.features.missions.MissionHandler;

public class HelperManager {
	
	private static final HelperManager INSTANCE = new HelperManager();	
	
	@FXML
	private AnchorPane mainWindow;	
	@FXML
	private ImageView helperImageView;
	@FXML
	private Label helperLabel;
	
	private Image duckImage = new Image("/helper/helper.png");
	
	private int helperLoadNumber;
	
	private MissionHandler missionHandler = MissionHandler.getInstance();
	
	private MainEntityManager mainEntityManager = MainEntityManager.getInstance();
	
	private String helperString1 = "Click I to open mission interface and finish tutorial missions." 
			+ "\n" + "And click me again";
	private String helperString2 = "Add any building onto the tiles"
			+ "\n" + "And click me again";
	private String helperString3 = "Add any animal in the game";
	private String helperString4 = "Add any peon in the game";
	private String helperString5 = "Congrats! All helper tutorial is done!";
	
	
	
	public HelperManager() {
		this.helperLoadNumber = 0;
	}
	
	public static HelperManager getInstance() {
		return INSTANCE;
	}
	
	
	@FXML
	public void helperLoad() {
		
		
		
		switch(this.helperLoadNumber) {
		
		
			
			case 0: 
				setImageAndText(duckImage, helperString1);
				break;
			case 1:
				if(this.missionHandler.getNumberOfCompletedMissions() == 3.0) {
					setImageAndText(duckImage, helperString2);
				} else {					
					helperLoadNumber -= 1;
				}
				break;
			case 2:
				if(this.mainEntityManager.getIsBuildingBuilt()) {
					setImageAndText(duckImage, helperString5);
				} else {
					helperLoadNumber -= 1;
				}
				break;
			case 3:
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
