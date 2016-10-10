package uq.deco2800.ducktales.features.weather;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import uq.deco2800.ducktales.features.hud.menu.MenuManager;
import uq.deco2800.ducktales.util.SecondaryManager;
import uq.deco2800.ducktales.util.Tickable;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Weather Manager
 * 
 * Handles all of the in-game weather effects and draws/renders them onto a
 * canvas.
 * 
 * @author mattleggy
 */
public class WeatherManager
		implements SecondaryManager, Initializable, Tickable {
	// may not need this any more...
	private WeatherCanvas weatherCanvas;
	// main weather display pane
	@FXML
	private Pane weatherDisplay;
	// weather display
	private Canvas weatherDisplayCanvas;
	// list of shapes (weather effects)
	private ArrayList<WeatherCanvasShape> shapes;
	// main canvas context to draw on
	private GraphicsContext context;
	// height of the canvas
	private int canvasHeight;
	// width of the canvas
	private int canvasWidth;
	// counter to keep track of ticks
	private int tickCount;

	@Override
	public void reload() {

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		weatherCanvas = new WeatherCanvas();
		shapes = new ArrayList<WeatherCanvasShape>();

		canvasHeight = 737;
		canvasWidth = 1295;

		weatherDisplayCanvas = new Canvas(canvasWidth, canvasHeight);

		AnchorPane.setLeftAnchor(weatherDisplayCanvas, 0.0);
		AnchorPane.setRightAnchor(weatherDisplayCanvas, 0.0);
		AnchorPane.setTopAnchor(weatherDisplayCanvas, 0.0);
		AnchorPane.setBottomAnchor(weatherDisplayCanvas, 0.0);
		context = weatherDisplayCanvas.getGraphicsContext2D();
		// weatherManager.tick();
		for (int i = 0; i < 50; i++) {
			int randX = (int) Math.ceil(Math.random() * canvasWidth);
			int randY = (int) Math.ceil(Math.random() * canvasHeight);
			int randDirection = (int) Math.floor(Math.random() * 7) - 3;
			int randAcceleration = (int) (Math.random() * 5) + 10; // random
																	// acceleration
			WeatherCanvasShape shape = new WeatherCanvasShape(randX, randY,
					randDirection, randAcceleration);
			shapes.add(shape);
			drawPositions(randX, randY, randDirection);
		}
		weatherDisplayCanvas.setMouseTransparent(true);
		weatherDisplay.getChildren().add(weatherDisplayCanvas);
	}

	/**
	 * Draws the effects in the provided x and y coordinates and direction to
	 * draw the weather effects on the canvas
	 * 
	 * @param x
	 *            - X coordinate of the effect
	 * @param y
	 *            - Y coordinate of the effect
	 * @param direction
	 *            - which direction the effect will go
	 */
	private void drawPositions(int x, int y, int direction) {
		context.beginPath();
		context.setFill(Color.GREEN);
		context.setStroke(Color.BLUE);
		context.strokeLine(x, y, x + direction, y + 30);
		// context.arc(x, y, 20, 20, 2 * Math.PI, 1);
		context.stroke();
		context.fill();
		context.setLineWidth(1);
		context.stroke();
	}

	@Override
	public void tick() {
		if (tickCount == 1) {
			Platform.runLater(() -> {
				context.clearRect(0, 0, canvasWidth, canvasHeight);
				for (WeatherCanvasShape shape : shapes) {
					if (shape.getX() > canvasWidth) {
						shape.setX(-20);
					} else {
						shape.setX((shape.getX() + (shape.getDirection())));
					}
					if (shape.getY() > canvasHeight) {
						shape.setY(-20);
					} else {
						shape.setY((shape.getY() + shape.getAcceleration()));
					}
					drawPositions(shape.getX(), shape.getY(),
							shape.getDirection());
				}
			});
			tickCount = 0;
		}
		tickCount++;
	}

}
