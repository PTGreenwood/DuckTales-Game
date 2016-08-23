package uq.deco2800.ducktales.ui;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

import uq.deco2800.ducktales.*;
import uq.deco2800.ducktales.world.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import uq.deco2800.ducktales.worldBuilder.WorldBuilderManager;
import uq.deco2800.ducktales.worldBuilder.WorldBuilderRenderer;

public class DuckTalesController implements Initializable {

	/*
	 * The two canvases corresponding to the two buttons in the FXML
	 */
	private Canvas gameCanvas;
	private Canvas worldBuilderCanvas;

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
				
		URL location = getClass().getResource("Tutorial.fxml");
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
		if (worldBuilderCanvas == null) {
			// Initialize the gameCanvas
			// and set the canvas to resize as the rightPane is resized
			worldBuilderCanvas = new Canvas();
			worldBuilderCanvas.widthProperty().bind(rightPane.widthProperty());
			worldBuilderCanvas.heightProperty().bind(rightPane.heightProperty());

			showCanvas(worldBuilderCanvas);

			GraphicsContext gc = worldBuilderCanvas.getGraphicsContext2D();

			worldBuilderManager.setWorld(new World("World Builder", 20, 20));

			try {
				new WorldBuilderRenderer(gc).start();
			} catch(Exception e) {
				System.out.println("failed to start renderer completely");
			}

			running = true;
		} else {
			showCanvas(worldBuilderCanvas);
		}
	}



	public void stopGame() {
		if (executor != null && quit != null) {
			quit.set(true);
			executor.shutdown();
		}
	}


	private void createWorld() {
		gameManager.setWorld(new World("DuckTales", 20, 20, tileRegister
				.getResourceType("grass_2")));

	}

	/**
	 * Show the given canvas in the rightPane.
	 * @param canvas
	 */
	private void showCanvas(Canvas canvas) {
		rightPane.getChildren().removeAll(gameCanvas, worldBuilderCanvas);
		rightPane.getChildren().add(canvas);
	}

}
