package uq.deco2800.ducktales.ui;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

import javafx.geometry.Insets;
import javafx.scene.layout.*;
import uq.deco2800.ducktales.*;
import uq.deco2800.ducktales.resources.ResourceRegister;
import uq.deco2800.ducktales.world.*;
import uq.deco2800.ducktales.world.builder.WorldBuilderManager;
import uq.deco2800.ducktales.world.builder.WorldBuilderRenderer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;

public class DuckTalesController implements Initializable {
	/*
	 * CONSTANTS
	 */
	private double BUILDING_SCENE_H_PORTION = 85.0/100.0;
	private double BUILDING_SCENE_V_PORTION = 80.0/100.0;
	private double TILE_MENU_H_PORTION = 100.0 - BUILDING_SCENE_H_PORTION;
	private double TILE_MENU_V_PORTION = BUILDING_SCENE_V_PORTION;
	private double RESOURCE_MENU_H_PORTION = 1.0;
	private double RESOURCE_MENU_V_PORTION = 100.0 - BUILDING_SCENE_V_PORTION;

	private Canvas gameCanvas;

	// The UI for world builder
	private BorderPane worldBuilderPane;
	private Pane buildingScene;
	private VBox tileMenu;
	private HBox resourceMenu;

	@FXML
	private AnchorPane gameWindow, rightPane; // rightPane is referenced in ducktales.fxml

	private ExecutorService executor;

	private boolean running = false;
	private ResourceRegister tileRegister;
	private GameManager gameManager;
	private WorldBuilderManager worldBuilderManager;

	private AtomicBoolean quit;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		tileRegister = ResourceRegister.getInstance();
		gameManager = GameManager.getInstance();
		worldBuilderManager = WorldBuilderManager.getInstance();

		// Set the handlers for the game panes
		rightPane.setOnMousePressed(new MousePressedHandler());
		rightPane.setOnMouseReleased(new MouseReleasedHandler());
		rightPane.setOnMouseDragged(new MouseDraggedHandler());
		rightPane.setOnMouseMoved(new MouseMovedHandler());
		gameWindow.setOnKeyPressed(new KeyboardHandler());
		gameWindow.setOnKeyReleased(new KeyboardHandler());
	}
	
	@FXML 
	private void tutorial(ActionEvent event) throws Exception {
				
		URL location = getClass().getResource("/tutorial.fxml");
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(location);
		Parent root = loader.load(location.openStream());
		Scene tutorialScene = new Scene(root, 400, 400);
		
		Stage tutorialStage = new Stage();
		tutorialStage.setTitle("Tutorial");
		tutorialStage.setScene(tutorialScene);
		tutorialStage.show();
	}

	/**
	 * This method will be called when the 'Launch Game' button is pressed
	 * The code that will call this method is defined in ducktales.fxml
	 */
	@FXML
	public void startGame(ActionEvent event) throws Exception {
		if (gameCanvas == null) { // the canvas has not been initialized
			// Initialize the gameCanvas
			// and set the canvas to resize as the rightPane is resized
			gameCanvas = new Canvas();
			gameCanvas.widthProperty().bind(rightPane.widthProperty());
			gameCanvas.heightProperty().bind(rightPane.heightProperty());

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
	 * This method is called when "Build World" button is pressed
	 *
	 * @author khoiphan21
	 */
	@FXML
	public void buildWorld(ActionEvent event) throws Exception {
		if (worldBuilderPane == null) {
			// Set up the UI for the world builder
			setupWorldBuilderUI();

			// Adding to right pane
			showPane(worldBuilderPane);

			// Set the world for the builder
			worldBuilderManager.setWorld(
					new World("World Builder", 20, 20));
			// Initiate the rendering engine for WorldBuilder
			worldBuilderManager.setRenderer(new WorldBuilderRenderer(
					buildingScene, tileMenu, resourceMenu));

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


	private void createWorld() {
		gameManager.setWorld(new World("DuckTales", 20, 20));

	}

	/**
	 * Show the given pane in the rightPane.
	 * @param pane
	 * 			The pane to be shown in the right pane
	 */
	private void showPane(Pane pane) {
		rightPane.getChildren().removeAll(gameCanvas, worldBuilderPane);
		rightPane.getChildren().add(pane);
	}

	/**
	 * Show the given canvas in the rightPane
	 * @param canvas
	 */
	private void showCanvas(Canvas canvas) {
		rightPane.getChildren().removeAll(gameCanvas, worldBuilderPane);
		rightPane.getChildren().add(canvas);
	}

	/**
	 * Set up the UI for WorldBuidler
	 */
	private void setupWorldBuilderUI() {
		// The border pane to put all the panes into
		worldBuilderPane = new BorderPane();
		worldBuilderPane.setMinWidth(rightPane.getWidth());
		worldBuilderPane.getStylesheets().add("/builderStyle.css");

		// The pane where the world is rendered onto
		buildingScene = new Pane();
		buildingScene.setPrefWidth(
				rightPane.getWidth() * BUILDING_SCENE_H_PORTION);
		buildingScene.setPrefHeight(
				rightPane.getHeight() * BUILDING_SCENE_V_PORTION);
		buildingScene.getStyleClass().add("buildingScene");

		// The pane containing the tiles
		tileMenu = new VBox();
		tileMenu.setPrefWidth(
				rightPane.getWidth() * TILE_MENU_H_PORTION);
		tileMenu.setPrefHeight(
				rightPane.getHeight() * TILE_MENU_V_PORTION
		);
		tileMenu.setMaxHeight(
				rightPane.getHeight() * TILE_MENU_V_PORTION
		);
		tileMenu.getStyleClass().add("tileMenu");
		tileMenu.setPadding(new Insets(25));
		tileMenu.setSpacing(20);

		// The pane containing the resources
		resourceMenu = new HBox();
		resourceMenu.setPrefWidth(
				rightPane.getWidth() * RESOURCE_MENU_H_PORTION
		);
		resourceMenu.setPrefHeight(
				rightPane.getHeight() * RESOURCE_MENU_V_PORTION
		);
		resourceMenu.getStyleClass().add("resourceMenu");

		// Add the child panes into the main pane
		worldBuilderPane.setCenter(buildingScene);
		worldBuilderPane.setRight(tileMenu);
		worldBuilderPane.setBottom(resourceMenu);
	}

}
