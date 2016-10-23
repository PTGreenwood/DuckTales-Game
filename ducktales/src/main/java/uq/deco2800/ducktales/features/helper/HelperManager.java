package uq.deco2800.ducktales.features.helper;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import uq.deco2800.ducktales.features.entities.MainEntityManager;
import uq.deco2800.ducktales.features.missions.MissionHandler;
/** * 
 * Manage all fxml action of the Helper/NPC 
 * 
 * @author Naehyung Kim
 *
 */
public class HelperManager {
	
	
	private static final HelperManager INSTANCE = new HelperManager();	
	
	/** Main window of helper */
	@FXML
	private AnchorPane mainWindow;
	
	/** ImageView of helper */
	@FXML
	private ImageView helperImageView;
	
	/** Label on right side of the ImageView */
	@FXML
	private Label helperLabel;
	
	/** Image for helper/NPC */
	private Image duckImage = new Image("/helper/helper.png");
	
	/** number to change helper screen */
	private int helperLoadNumber;
	
	/** Initialize classes */	
	private MissionHandler missionHandler = MissionHandler.getInstance();	
	private MainEntityManager mainEntityManager = MainEntityManager.getInstance();
	
	/** Strings for helperLabel */
	private String helperString1 = "Click I to open mission interface and" + "\n"
			+ "finish tutorial missions." 
			+ "\n" + "And click me again";
	private String helperString2 = "Add any building onto the tiles"
			+ "\n" + "And click me again";
	private String helperString3 = "Add any animal in the game";
	private String helperString4 = "Add any peon in the game";
	private String helperString5 = "Congrats! All helper tutorial is done!";
	
	
	/**
	 * Main constructor of {@link Helper} class
	 */
	public HelperManager() {
		this.helperLoadNumber = 0;
	}
	
	/**
	 * Constructor of {@link Helper}
	 * 
	 * @return <CODE>INSTANCE</CODE>
	 */
	public static HelperManager getInstance() {
		return INSTANCE;
	}
	
	/** load helper and changes the label depending on helperLoadNumber */
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
	
	/** Set image and text for helper */
	private void setImageAndText(Image image, String text) {
		helperImageView.setImage(image);
		helperLabel.setText(text);
	}
	
	/**
	 * Show and hide main window
	 */
	public void showHelper() {
    	this.mainWindow.setVisible(true);
	}
	public void hideHelper() {
		this.mainWindow.setVisible(false);
	}
	
	
}
