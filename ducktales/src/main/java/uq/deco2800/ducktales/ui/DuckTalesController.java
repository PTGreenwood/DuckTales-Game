package uq.deco2800.ducktales.ui;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

import uq.deco2800.ducktales.*;
import uq.deco2800.ducktales.tiles.*;
import uq.deco2800.ducktales.world.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.*;

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

	private TextureRegister tileRegister;
	private GameManager gameManager;

	private AtomicBoolean quit;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		tileRegister = TextureRegister.getInstance();
		gameManager = GameManager.getInstance();
	}

	@FXML
	/**
	 * This method will be called when the 'Launch Game' button is pressed
	 * The code that will call this method is defined in ducktales.fxml
	 */
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

			rightPane.setOnMousePressed(new MousePressedHandler());
			rightPane.setOnMouseReleased(new MouseReleasedHandler());
			rightPane.setOnMouseDragged(new MouseDraggedHandler());
			rightPane.setOnMouseMoved(new MouseMovedHandler());
			gameWindow.setOnKeyPressed(new KeyboardHandler());
			gameWindow.setOnKeyReleased(new KeyboardHandler());
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

	@FXML
	/**
	 * This method is called when "Build World" button is pressed
	 *
	 * @author khoiphan21
	 */
	public void buildWorld(ActionEvent event) throws Exception {
		if (worldBuilderCanvas == null) {
			// Initialize the gameCanvas
			// and set the canvas to resize as the rightPane is resized
			worldBuilderCanvas = new Canvas();
			worldBuilderCanvas.widthProperty().bind(rightPane.widthProperty());
			worldBuilderCanvas.heightProperty().bind(rightPane.heightProperty());

			showCanvas(worldBuilderCanvas);

			GraphicsContext gc = worldBuilderCanvas.getGraphicsContext2D();

			// Testing functions
			gc.setFill( Color.RED );
			gc.setStroke( Color.BLACK );
			gc.setLineWidth(2);
			Font theFont = Font.font( "Times New Roman", FontWeight.BOLD, 48 );
			gc.setFont( theFont );
			gc.fillText( "World Building!", 60, 50 );
			gc.strokeText( "World Building!", 60, 50 );

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
				.getTileType("grass_2")));

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
