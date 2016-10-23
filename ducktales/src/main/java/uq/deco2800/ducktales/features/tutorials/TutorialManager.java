package uq.deco2800.ducktales.features.tutorials;


import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

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
	
	/** right pane of main window */
	@FXML
	private BorderPane rightPane;
	
	/** title label */
	@FXML
	private Label labelTop;
	
	/** buttons for next and previous page */
	@FXML
	private Button next;
	@FXML
	private Button previous;
	
	/** Image for tutorial */
	@FXML
	private ImageView tutorialImage;
	
	/** description of the image */
	@FXML
	private Label tutorialLabel;
	
	/** simple description of tutorial */
	@FXML
	private Label tutorialDescription;
	
	/** Buttons on the leftPane of the window */
	@FXML
	private Button basicInterface;
	@FXML
	private Button buildings;
	@FXML
	private Button marketPlace;
	@FXML
	private Button NPC;
	
	/** images used for basic interface */
	private Image tutorialImage1 = new Image("/tutorials/basicInterface1.png");
	private Image tutorialImage2 = new Image("/tutorials/basicInterface2.png");
	private Image tutorialImage3 = new Image("/tutorials/basicInterface3.png");
	private Image tutorialImage4 = new Image("/tutorials/basicInterface4.png");
	
	/** images used for buildings tutorial */
	private Image buildingsImage1 = new Image("/tutorials/buildings1.png");
	private Image buildingsImage2 = new Image("/tutorials/buildings2.png");
	private Image buildingsImage3 = new Image("/tutorials/buildings3.png");
	
	/** images used for marketPlace tutorial */
	private Image marketPlaceImage1 = new Image("/tutorials/marketPlace1.png");
	private Image marketPlaceImage2 = new Image("/tutorials/marketPlace2.png");
	private Image marketPlaceImage3 = new Image("/tutorials/marketPlace3.png");
	private Image marketPlaceImage4 = new Image("/tutorials/marketPlace4.png");
	
	/** images used for npc tutorial */
	private Image npcImage = new Image("/tutorials/Helper.png");
	
	/** titles for each tutorial */
	private String basicInterfaceString = "Interface";
	private String buildingsString = "Buildings";
	private String marketPlaceString = "Market Place";
	
	/**
	 * Load main window of the tutorial
	 */
	public void loadMain() {
		this.hideButtons();
		this.tutorialImage.setVisible(false);
		this.tutorialLabel.setVisible(false);
		this.tutorialDescription.setVisible(true);
	}
	
	/** 
	 * load first page of basic interface
	 * with its proper action on next and previous buttons
	 * 
	 */
	@FXML
	private void loadBasicInterface1() {
		this.loadTutorial(basicInterfaceString, this.tutorialImage1, "Basic Interface 1");
		previous.setOnAction(event -> 
		loadBasicInterface1()
		);
		next.setOnAction(event -> 
		loadBasicInterface2()
		);
	}
	
	/** 
	 * load second page of basic interface
	 * with its proper action on next and previous buttons
	 * 
	 */
	@FXML
	private void loadBasicInterface2() {
		this.loadTutorial(basicInterfaceString, this.tutorialImage2, "Basic Interface 2");
		previous.setOnAction(event -> 
		loadBasicInterface1()
		);
		next.setOnAction(event -> 
		loadBasicInterface3()
		);
	}
	
	/** 
	 * load third page of basic interface
	 * with its proper action on next and previous buttons
	 * 
	 */
	@FXML
	private void loadBasicInterface3() {
		this.loadTutorial(basicInterfaceString, this.tutorialImage3, "Basic Interface 3");
		previous.setOnAction(event -> 
		loadBasicInterface2()
		);
		next.setOnAction(event -> 
		loadBasicInterface4()
		);
	}
	
	/** 
	 * load fourth page of basic interface
	 * with its proper action on next and previous buttons
	 * 
	 */
	@FXML
	private void loadBasicInterface4() {
		this.loadTutorial(basicInterfaceString, this.tutorialImage4, "Basic Interface 4");
		previous.setOnAction(event -> 
		loadBasicInterface3()
		);
		next.setOnAction(event -> 
		loadBasicInterface4()
		);
	}
	
	/**
	 * Set basic design for all tutorial pages with its title, image and description. 
	 * @param title
	 * @param image
	 * @param string
	 */
	private void loadTutorial(String title, Image image, String description) {
		this.showButtons();
		this.labelTop.setText(title);
		this.tutorialDescription.setVisible(false);
		this.tutorialImage.setVisible(true);
		this.tutorialLabel.setVisible(true);
		this.tutorialImage.setImage(image);
		this.tutorialLabel.setText(description);
		this.tutorialLabel.setAlignment(Pos.CENTER);	
	}
	
	/** 
	 * load first page of buildings
	 * with its proper action on next and previous buttons
	 * 
	 */	
	@FXML
	private void loadBuildings1() {
		this.loadTutorial(buildingsString, this.buildingsImage1, "Buildings 1");
		previous.setOnAction(event -> 
		loadBuildings1()
		);
		next.setOnAction(event -> 
		loadBuildings2()
		);
	}
	
	/** 
	 * load second page of buildings
	 * with its proper action on next and previous buttons
	 * 
	 */	
	@FXML
	private void loadBuildings2() {
		this.loadTutorial(buildingsString, this.buildingsImage2, "Buildings 2");
		previous.setOnAction(event -> 
		loadBuildings1()
		);
		next.setOnAction(event -> 
		loadBuildings3()
		);
	}
	
	/** 
	 * load third page of buildings
	 * with its proper action on next and previous buttons
	 * 
	 */	
	@FXML
	private void loadBuildings3() {
		this.loadTutorial(buildingsString, this.buildingsImage3, "Buildings 3");
		previous.setOnAction(event -> 
		loadBuildings2()
		);
		next.setOnAction(event -> 
		loadBuildings3()
		);
	}
	
	/** 
	 * load first page of market place
	 * with its proper action on next and previous buttons
	 * 
	 */	
	@FXML
	private void loadMarketPlace1() {
		this.loadTutorial(marketPlaceString, this.marketPlaceImage1, "Market Place 1");
		previous.setOnAction(event -> 
		loadMarketPlace1()
		);
		next.setOnAction(event -> 
		loadMarketPlace2()
		);
	}
	
	/** 
	 * load second page of market place
	 * with its proper action on next and previous buttons
	 * 
	 */	
	@FXML
	private void loadMarketPlace2() {
		this.loadTutorial(marketPlaceString, this.marketPlaceImage2, "Market Place 2");
		previous.setOnAction(event -> 
		loadMarketPlace1()
		);
		next.setOnAction(event -> 
		loadMarketPlace3()
		);
		
	}
	
	/** 
	 * load third page of market place
	 * with its proper action on next and previous buttons
	 * 
	 */	
	@FXML
	private void loadMarketPlace3() {
		this.loadTutorial(marketPlaceString, this.marketPlaceImage3, "Market Place 3");
		previous.setOnAction(event -> 
		loadMarketPlace2()
		);
		next.setOnAction(event -> 
		loadMarketPlace4()
		);
	}
	
	/** 
	 * load fourth page of market place
	 * with its proper action on next and previous buttons
	 * 
	 */	
	@FXML
	private void loadMarketPlace4() {
		this.loadTutorial(marketPlaceString, this.marketPlaceImage4, "Market Place 4");
		previous.setOnAction(event -> 
		loadMarketPlace3()
		);
		next.setOnAction(event -> 
		loadMarketPlace4()
		);
		
	}
	
	/** 
	 * load NPC tutorial
	 * 
	 */	
	@FXML
	private void loadNPC() {
		this.hideButtons();
		this.labelTop.setText("NPC");
		this.tutorialDescription.setVisible(false);
		this.tutorialImage.setVisible(true);
		this.tutorialLabel.setVisible(true);
		this.tutorialImage.setImage(this.npcImage);
		this.tutorialLabel.setText("Description of NPC");
		this.tutorialLabel.setAlignment(Pos.CENTER);
	}
	
	@FXML
	private void enlargeImage() {
		
	}
	
	/**
	 * Show and hide buttons
	 */
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
