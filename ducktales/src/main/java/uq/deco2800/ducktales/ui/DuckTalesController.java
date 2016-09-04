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
import uq.deco2800.ducktales.resources.ResourceSpriteRegister;
import uq.deco2800.ducktales.world.*;
import uq.deco2800.ducktales.world.builder.WorldBuilderManager;
import uq.deco2800.ducktales.world.builder.WorldBuilderRenderer;
import uq.deco2800.ducktales.weather.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;
import uq.deco2800.ducktales.market.*;

/**
 * This class handles the title screen and main menu.
 * 
 * 
 */
public class DuckTalesController implements Initializable {

	private Canvas gameCanvas;

	@FXML
	//gameWindow, contentPane & mainMenuPane are referenced in ducktales.fxml
	private AnchorPane gameWindow, contentPane, mainMenuPane;
	
	//weatherEffectPane referenced in ducktales.fxml
	@FXML
	private Pane weatherEffectPane;
	
	private ExecutorService executor;

	private boolean running = false;
	private ResourceSpriteRegister tileRegister;
	private GameManager gameManager;
	private WorldBuilderManager worldBuilderManager;

	// UI for World Builder
	private BorderPane worldBuilderPane;
	private AnchorPane gamePane;

	private AtomicBoolean quit;

	private Achievements achievementScore;
	private Missions missions;

	public Stage tutorialStage;
	public Stage marketplaceStage;

	/**
	 * Main constructor of the {@link DuckTalesController} class.
	 * 
	 * @param location
	 * @param resources
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		tileRegister = ResourceSpriteRegister.getInstance();
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

	/**
	 * Displays the tutorial popup window.
	 * 
	 * @param event
	 * @throws Exception
	 */
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

	/**
	 * Displays the achievement and progress popup window.
	 * 
	 * @param event
	 * @throws Exception
	 */
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
	 * Displays the Marketplace main pop up window.
	 * 
	 * @param event
	 * @throws Exception
	 */
	@FXML
	private void showMarketplace(ActionEvent event) throws Exception {

		// Load in the marketplace fxml
		// URL location = getClass().getResource("/marketplace.fxml");
		URL location = getClass().getResource(MarketVistaNavigator.MAIN);
		
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
	 * 
	 * @param event
	 * @throws Exception
	 */
	@FXML
	public void startGame(ActionEvent event) throws Exception {
		toggleMenuPane();		
		changeWeather(new Rain());
		if (gameCanvas == null) { // the canvas has not been initialized
			// Initialize the gameCanvas
			// and set the canvas to resize as the rightPane is resized			
			gameCanvas = new Canvas();
			gameCanvas.widthProperty().bind(contentPane.widthProperty());
			gameCanvas.heightProperty().bind(contentPane.heightProperty());			
			
			showCanvas(gameCanvas);	
			
			//addWeather(weatherImageView);

			GraphicsContext graphicsContext = gameCanvas.getGraphicsContext2D();

			gameManager.setWorld(new World("DuckTales", 20, 20));

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
	 * 
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

			// Set the game pane to resize with the window
			contentPane.setLeftAnchor(gamePane, 0.0);
			contentPane.setRightAnchor(gamePane, 0.0);
			contentPane.setTopAnchor(gamePane, 0.0);
			contentPane.setBottomAnchor(gamePane, 0.0);

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
	 * @param event
	 * @throws Exception
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

	/**
	 * Set the {@code quit} variable to true and stop the game.
	 */
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
		contentPane.getChildren().removeAll(gameCanvas, worldBuilderPane, gamePane);
		contentPane.getChildren().add(pane);
	}
	
	/**
	 * Change the current weather of the scene to given weather.
	 * 
	 * @param weather
	 * 			weather to change current scene to
	 */
	private void changeWeather(Weather weather) {		
		WeatherEffect weatherEffect = weather.getWeatherEffect();
		String sprite = weatherEffect.getSprite();
		String weatherName = weatherEffect.toString();
		weatherEffectPane.setStyle("-fx-background-image: url('"+sprite+"')");
		System.out.println("Weather set to: "+weather.toString().toUpperCase());
	}

	/**
	 * Show the given canvas in the rightPane
	 * 
	 * @param canvas
	 * 			Canvas to show.
	 */
	private void showCanvas(Canvas canvas) {
		contentPane.getChildren().removeAll(gameCanvas, worldBuilderPane, gamePane);
		/* 
		 * @mattyleggy
		 * adding the content pane to the 0-th index to ensure the 
		 * weatherEffectPane is on top of the main canvas so that the animation
		 * is always visible.  		
		 */
		contentPane.getChildren().add(0,canvas);
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
