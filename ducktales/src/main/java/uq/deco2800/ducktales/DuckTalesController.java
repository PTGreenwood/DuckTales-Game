package uq.deco2800.ducktales;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import uq.deco2800.singularity.clients.ducktales.DucktalesClient;
import uq.deco2800.singularity.common.representations.User;
import uq.deco2800.ducktales.features.builder.WorldBuilderController;
import uq.deco2800.ducktales.features.builder.WorldBuilderRenderer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

/**
 * This class handles the title screen and main menu.
 */
public class DuckTalesController implements Initializable {

	@FXML
	//gameWindow, contentPane & mainMenuPane are referenced in ducktales.fxml
	private AnchorPane gameWindow;
	@FXML
	private AnchorPane contentPane;
	@FXML
	private AnchorPane mainMenuPane;



	private WorldBuilderController worldBuilderController;

	// UI for World Builder
	private BorderPane worldBuilderPane;
	private AnchorPane gamePane;

	private DucktalesClient client;

	/**
	 * Main constructor of the {@link DuckTalesController} class.
	 *
	 * @param location
	 * 			The location of the FXML passed in
	 * @param resources
	 * 			The resources passed in via FXML loader
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		worldBuilderController = new WorldBuilderController();

		// Create an instance of the duckTales Restful Client
		client = new DucktalesClient();
		
	}
	static Stage primaryStage;
	public static void close()
	{
		if (primaryStage != null)
			primaryStage.close();
	}

	/**
	 * This is the method that will launch the game from the main menu
	 * @param event
	 * 			The event that called this method
	 * @throws Exception
	 * 			Exception for when attempting to load the game
	 */
	
	
	@FXML
	public void startGame(ActionEvent event) throws Exception {
		
		Parent root1 = FXMLLoader.load(getClass().getResource("/ui/main/login.fxml"));
        
		Scene scene = new Scene(root1,300,275);
		primaryStage= new Stage();
		primaryStage.setTitle("FXML Welcome");  
		primaryStage.setScene(scene);
		primaryStage.showAndWait();
		// Change between the mainMenuPane and the contentPane
		toggleMenuPane();

		// Use FXML Loader to load the FXML file as well as instantiate the controller
		// for the main UI
		URL location = getClass().getResource("/ui/main/mainUI.fxml");
		FXMLLoader mainUILoader = new FXMLLoader(location);
		// Setup the main UI
		setupMainUI(mainUILoader);
		// Show the main UI
		showPane(gamePane);

	}

	/**
	 * This is a helper method that helps set
	 */
	private void setupMainUI(FXMLLoader loader) throws Exception {
		// Load the FXML
		try {
			gamePane = loader.load();
		} catch(Exception e) {
			System.err.println("Exception in trying to load main UI");
		}

		// Set the layout for the gamePane
		AnchorPane.setLeftAnchor(gamePane, 0.0);
		AnchorPane.setRightAnchor(gamePane, 0.0);
		AnchorPane.setTopAnchor(gamePane, 0.0);
		AnchorPane.setBottomAnchor(gamePane, 0.0);
	}

	/**
	 * This method is called when "Build World" button is pressed
	 *
	 * @param event
	 * 			Event that called this method
	 * @throws Exception
	 * 			Exception when loading the Build World feature
	 */
	@FXML
	public void buildWorld(ActionEvent event) throws Exception {
		toggleMenuPane();
		if (worldBuilderPane == null) {
			// Setup the root pane for World Builder
			worldBuilderPane = new BorderPane();
			worldBuilderPane.setMinSize(contentPane.getWidth(),
					contentPane.getHeight());

			System.err.println("worldbuilderPane's width and height: "
					+ worldBuilderPane.getWidth() + ", " + worldBuilderPane.getHeight());

			// Set the world for the builder
			worldBuilderController.setWorld(new World("World Builder", 20, 20));
			// Initiate the rendering engine for WorldBuilder
			worldBuilderController.setRenderer(new WorldBuilderRenderer(
					contentPane, worldBuilderPane));

			// Adding to right pane
			showPane(worldBuilderPane);

		} else {
			showPane(worldBuilderPane);
		}
	}

	/**
	 * Close the application
	 */
	public void quitApplication() {
		System.exit(0);
	}

	/**
	 * Show the given pane in the contentPane.
	 *
	 * @param pane
	 *            The pane to be shown in the right pane
	 */
	private void showPane(Pane pane) {
		if (mainMenuPane.isVisible()) {
			toggleMenuPane();
		}
		contentPane.getChildren().removeAll(worldBuilderPane, gamePane);
		contentPane.getChildren().add(pane);
	}

	/**
	 * Toggles the menu visibility on game pause.
	 */
	public void toggleMenuPane() {
		if (mainMenuPane.isVisible()) {
			contentPane.setVisible(true);
			mainMenuPane.setVisible(false);
		} else {
			contentPane.setVisible(false);
			mainMenuPane.setVisible(true);
		}
	}

}
