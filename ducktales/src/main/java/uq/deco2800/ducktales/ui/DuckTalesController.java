package uq.deco2800.ducktales.ui;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

import javafx.scene.layout.*;
import uq.deco2800.ducktales.*;
import uq.deco2800.ducktales.achievements.Achievements;
import uq.deco2800.ducktales.missions.Missions;
import uq.deco2800.ducktales.resources.ResourceRegister;
import uq.deco2800.ducktales.world.*;
import uq.deco2800.ducktales.world.builder.WorldBuilderManager;
import uq.deco2800.ducktales.world.builder.WorldBuilderRenderer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class DuckTalesController implements Initializable {

	private Canvas gameCanvas;

	@FXML
	// gameWindow, rightPane & mainMenuPane are referenced in ducktales.fxml
	//gameWindow, contentPane & mainMenuPane are referenced in ducktales.fxml
	private AnchorPane gameWindow, contentPane, mainMenuPane;

	private ExecutorService executor;

	private boolean running = false;
	private ResourceRegister tileRegister;
	private GameManager gameManager;
	private WorldBuilderManager worldBuilderManager;

	// UI for World Builder
	private BorderPane worldBuilderPane, gamePane;

	private AtomicBoolean quit;

	private Achievements achievementScore;
	private Missions missions;

	public Stage tutorialStage;
	public Stage marketplaceStage;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		tileRegister = ResourceRegister.getInstance();
		gameManager = GameManager.getInstance();
		worldBuilderManager = WorldBuilderManager.getInstance();
		
		// Set the handlers for the game panes
		contentPane.setOnMousePressed(new MousePressedHandler());
		contentPane.setOnMouseReleased(new MouseReleasedHandler());
		contentPane.setOnMouseDragged(new MouseDraggedHandler());
		contentPane.setOnMouseMoved(new MouseMovedHandler());
		gameWindow.setOnKeyPressed(new KeyboardHandler());
		gameWindow.setOnKeyReleased(new KeyboardHandler());
	}

	@FXML
	private void tutorial(ActionEvent event) throws Exception {
		URL location = getClass().getResource("/tutorial.fxml");
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(location);
		Parent root = loader.load(location.openStream());
		Scene tutorialScene = new Scene(root, 800, 400);

		
		
		Stage tutorialStage = new Stage();
		tutorialStage.setTitle("Tutorial");
		tutorialStage.setScene(tutorialScene);
		tutorialStage.show();

	}

	@FXML
	private void missionAndAchievement(ActionEvent event) throws Exception {

		URL location = getClass().getResource("/missionAndAchievement.fxml");
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(location);
		Parent root = loader.load(location.openStream());
		Scene missionAndAchievementScene = new Scene(root, 800, 400);

		Stage missionAndAchievementStage = new Stage();
		missionAndAchievementStage.setTitle("Mission and Achievement");
		missionAndAchievementStage.setScene(missionAndAchievementScene);
		missionAndAchievementStage.show();
	}

	/**
	 * 
	 * Displays the Marketplace main pop up window.
	 * 
	 * @param event
	 * @throws Exception
	 */
	@FXML
	private void showMarketplace(ActionEvent event) throws Exception {

		// Load in the marketplace fxml
		URL location = getClass().getResource("/marketplace.fxml");
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(location);
		Parent root = loader.load(location.openStream());
		Scene marketplaceScene = new Scene(root);

		this.marketplaceStage = new Stage();
		// To get the window to appear in front of the right pane
		marketplaceStage.initOwner(contentPane.getScene().getWindow());
		marketplaceStage.setTitle("Marketplace");
		marketplaceStage.setScene(marketplaceScene);
		marketplaceStage.show();
	}

	/**
	 * This method will be called when the 'Launch Game' button is pressed The
	 * code that will call this method is defined in ducktales.fxml
	 */
	@FXML
	public void startGame(ActionEvent event) throws Exception {
		toggleMenuPane();
		if (gameCanvas == null) { // the canvas has not been initialized
			// Initialize the gameCanvas
			// and set the canvas to resize as the rightPane is resized			
			gameCanvas = new Canvas();
			gameCanvas.widthProperty().bind(contentPane.widthProperty());
			gameCanvas.heightProperty().bind(contentPane.heightProperty());

			showCanvas(gameCanvas);

			GraphicsContext graphicsContext = gameCanvas.getGraphicsContext2D();

			createWorld();

			executor = Executors.newCachedThreadPool();

			quit = new AtomicBoolean(false);
			executor.execute(new GameLoop(quit, 50));
			new GameRenderer(graphicsContext).start();
			running = true;
		} else {
			// just show the canvas
			showCanvas(gameCanvas);
		}
	}

	/**
	 * This will launch the game with the new rendering engine - beta version
	 * @param event
	 * @throws Exception
	 */
	@FXML
	public void startGameBeta(ActionEvent event) throws Exception {
		System.err.println("BETA RENDERER");
		if (gamePane == null) {
			toggleMenuPane();

            // First implementation of using FXML for styling
			URL location = getClass().getResource("/game.fxml");
            FXMLLoader loader = new FXMLLoader(location);

			// Load the FXML and set the size of the root Node
			try {
				gamePane = loader.load();

			} catch (Exception e) {
				System.err.println("exception in loading fxml");
			}
			gamePane.setPrefSize(
					contentPane.getWidth(),
					contentPane.getHeight()
			);
			showPane(gamePane);

			// Set up the controller
			GameController gameController = loader.getController();

			// Set up the renderer and give the controller its handle
			gameController.setupGame();

		} else {
			showPane(gamePane);
		}

	}

	/**
	 * This method is called when "Build World" button is pressed
	 *
	 * @author khoiphan21
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
			worldBuilderManager.setWorld(new World("World Builder", 20, 20));
			// Initiate the rendering engine for WorldBuilder
			worldBuilderManager.setRenderer(new WorldBuilderRenderer(
					contentPane, worldBuilderPane));

			// Adding to right pane
			showPane(worldBuilderPane);

		} else {
			showPane(worldBuilderPane);
		}
	}

	public void stopGame() {
		if (executor != null && quit != null) {
			quit.set(true);
			executor.shutdown();
		}
	}

	/**
	 * Close the application
	 */
	public void quitApplication() {
		System.exit(0);
	}

	private void createWorld() {
		gameManager.setWorld(new World("DuckTales", 20, 20));

	}

	/**
	 * Show the given pane in the rightPane.
	 * 
	 * @param pane
	 *            The pane to be shown in the right pane
	 */
	private void showPane(Pane pane) {
		contentPane.getChildren().removeAll(gameCanvas, worldBuilderPane, gamePane);
		contentPane.getChildren().add(pane);
	}

	/**
	 * Show the given canvas in the rightPane
	 * 
	 * @param canvas
	 */
	private void showCanvas(Canvas canvas) {
		contentPane.getChildren().removeAll(gameCanvas, worldBuilderPane, gamePane);
		contentPane.getChildren().add(canvas);
	}

	public void toggleMenuPane() {
		System.out.println(mainMenuPane.isVisible());
		if (mainMenuPane.isVisible()) {
			contentPane.setVisible(true);
			mainMenuPane.setVisible(false);
		} else {
			contentPane.setVisible(false);
			mainMenuPane.setVisible(true);
		}
	}
	

}
