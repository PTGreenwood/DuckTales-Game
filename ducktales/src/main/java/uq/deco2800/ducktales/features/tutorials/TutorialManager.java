package uq.deco2800.ducktales.features.tutorials;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;

/**
 * Manage all fxml action of main tutorial window
 * 
 * @author Naehyung Kim
 *
 */
public class TutorialManager {
	
	/** Main window */
	@FXML
	private AnchorPane tutorialWindow;
	
	/** Right Pane of the window */
	@FXML
	private AnchorPane rightPane;	
	
	@FXML
	private ImageView tutorialImage;
	
	@FXML
	private Label tutorialLabel;
	
	@FXML
	private Label tutorialTitleLabel;
	
	@FXML
	private Button next;
	
	@FXML
	private Button previous;
	
	private String tutorialImage1 = "/tutorials/basicInterface1.png";
	private String tutorialImage2 = "/tutorials/basicInterface2.png";
	private String tutorialImage3 = "/tutorials/basicInterface3.png";
	private String tutorialImage4 = "/tutorials/basicInterface4.png";
	
	private int basicInterfaceTutorialNumber = 0;
	
	@FXML
	private void loadTutorial1(){
		loadTutorial(tutorialImage1, "Basic Interface 1");
		previous.setOnAction((event) -> 
			loadTutorial1()
		);
		next.setOnAction((event) -> 
		    loadTutorial2()
		);
	}
	@FXML
	private void loadTutorial2(){
		loadTutorial(tutorialImage2, "Basic Interface 2");
		previous.setOnAction((event) -> 
			loadTutorial1()
		);
		next.setOnAction((event) -> 
		    loadTutorial3()
		);
	}
	
	@FXML
	private void loadTutorial3() {
		loadTutorial(tutorialImage3, "Basic Interface 3");
		previous.setOnAction((event) -> 
			loadTutorial2()
		);
		next.setOnAction((event) -> 
		    loadTutorial4()
		);
	}
	
	@FXML
	private void loadTutorial4() {
		loadTutorial(tutorialImage4, "Basic Interface 4");
		previous.setOnAction((event) -> 
			loadTutorial3()
		);
		next.setOnAction((event) -> 
		    loadTutorial4()
		);		
	}
	
	private void loadTutorial(String imageAddress, String text) {
		
		Image image = new Image(imageAddress);
						
		tutorialImage.setImage(image);
		tutorialLabel.setText(text);
		tutorialLabel.setFont(new Font("Press Start 2P", 12));
		showButtons();
		
	}
	
	public void showButtons() {
		this.next.setVisible(true);
		this.previous.setVisible(true);
	}
	
	public void hideButtons() {
		this.next.setVisible(false);
		this.previous.setVisible(false);
	}
	
	/**
	 * Show and hide main window
	 */
	public void showTutorial() {
    	this.tutorialWindow.setVisible(true);
	}
	public void hideTutorial() {
		this.tutorialWindow.setVisible(false);
	}
	//@mattyleggy, added this is for in-game keyboard handler
	/**
	 * Toggle between visible and invisible for achievement window. 
	 */
	public void toggleAchievement() {
		if (this.tutorialWindow.isVisible())
			showTutorial();
		else
			hideTutorial();
	}
	public boolean isVisible() {
		return this.tutorialWindow.isVisible();
	}
}
