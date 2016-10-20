package uq.deco2800.ducktales.features.tutorials;

import java.io.IOException;
import java.net.URL;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

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
	
	@FXML
	private BorderPane rightPane;
	
	@FXML
	private Label labelTop;
	
	@FXML
	private Button next;
	@FXML
	private Button previous;
	
	@FXML
	private ImageView tutorialImage;
	@FXML
	private Label tutorialLabel;
	
	@FXML
	private Label tutorialDescription;
	
	@FXML
	private Button basicInterface;
	@FXML
	private Button buildings;
	@FXML
	private Button marketPlace;
	@FXML
	private Button aboutDuck;
	
	
	private Image tutorialImage1 = new Image("/tutorials/basicInterface1.png");
	private Image tutorialImage2 = new Image("/tutorials/basicInterface2.png");
	private Image tutorialImage3 = new Image("/tutorials/basicInterface3.png");
	private Image tutorialImage4 = new Image("/tutorials/basicInterface4.png");
	
	private int basicInterfaceTutorialNumber = 0;
	
	public void loadMain() {
		this.hideButtons();
		this.tutorialImage.setVisible(false);
		this.tutorialLabel.setVisible(false);
		this.tutorialDescription.setVisible(true);
	}
	
	@FXML
	private void loadBasicInterface1() {
		this.loadTutorial(this.tutorialImage1, "Basic Interface 1");
		previous.setOnAction((event) -> 
		loadBasicInterface1()
		);
		next.setOnAction((event) -> 
		loadBasicInterface2()
		);
	}
	
	@FXML
	private void loadBasicInterface2() {
		this.loadTutorial(this.tutorialImage2, "Basic Interface 2");
		previous.setOnAction((event) -> 
		loadBasicInterface1()
		);
		next.setOnAction((event) -> 
		loadBasicInterface3()
		);
	}
	
	@FXML
	private void loadBasicInterface3() {
		this.loadTutorial(this.tutorialImage3, "Basic Interface 3");
		previous.setOnAction((event) -> 
		loadBasicInterface2()
		);
		next.setOnAction((event) -> 
		loadBasicInterface4()
		);
	}
	
	@FXML
	private void loadBasicInterface4() {
		this.loadTutorial(this.tutorialImage4, "Basic Interface 4");
		previous.setOnAction((event) -> 
		loadBasicInterface3()
		);
		next.setOnAction((event) -> 
		loadBasicInterface4()
		);
	}
	
	private void loadTutorial(Image image, String string) {
		this.showButtons();
		this.labelTop.setText("INTERFACE");
		this.tutorialDescription.setVisible(false);
		this.tutorialImage.setVisible(true);
		this.tutorialLabel.setVisible(true);
		this.tutorialImage.setImage(image);
		this.tutorialLabel.setText(string);
		this.tutorialLabel.setAlignment(Pos.CENTER);	
	}
	
	
	@FXML
	private void enlargeImage() {
		
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
