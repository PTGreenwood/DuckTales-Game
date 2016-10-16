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
public class WeatherManager extends SecondaryManager
		implements Initializable, Tickable {
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
	// possible weather events
	private WeatherEvents weatherEvents;
	// current weather event
	private Weather currentWeather;

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

		weatherEvents = new WeatherEvents();
		try {
			weatherEvents.add(new WeatherChance(new Rain(), 90));
			weatherEvents.add(new WeatherChance(new Snow(), 10));
			// weatherEvents.add(new WeatherChance(new
			// Storm(StormType.LIGHTNING), 30));
		} catch (InvalidWeatherChanceException exception) {

		}

		currentWeather = getWeatherPossibility();

		weatherDisplayCanvas.setMouseTransparent(true);
		weatherDisplay.getChildren().add(weatherDisplayCanvas);
	}

	/**
	 * Set the weather events
	 * 
	 * @param events
	 */
	private void setWeatherEvents(WeatherEvents events) {
		this.weatherEvents = events;
	}

	/**
	 * Get a weather event based on chance
	 * 
	 * @return
	 */
	private Weather getWeatherPossibility() {
		Weather weather = this.weatherEvents.getWeatherPossibility();
		System.out.println("Weather: " + weather);
		return weather;
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
		if (currentWeather instanceof Rain) {
			drawRain(x, y, direction);
		} else if (currentWeather instanceof Fire) {
			drawFire(x, y, direction);
		} else if (currentWeather instanceof Snow) {
			drawSnow(x, y, direction);
		}
	}

	/**
	 * 
	 * Draw rain onto the canvas
	 * 
	 * @param x
	 * @param y
	 * @param direction
	 */
	private void drawRain(int x, int y, int direction) {
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

	/**
	 * 
	 * Draw fire onto the canvas
	 * 
	 * @param x
	 * @param y
	 * @param direction
	 */
	private void drawFire(int x, int y, int direction) {
		context.beginPath();
		context.setStroke(Color.RED);
		context.arc(x, y, 20, 20, 2 * Math.PI, 1);
		context.stroke();
		context.fill();
		context.setLineWidth(20);
		context.stroke();
	}

	/**
	 * 
	 * Draw snow onto the canvas
	 * 
	 * @param x
	 * @param y
	 * @param direction
	 */
	private void drawSnow(int x, int y, int direction) {
		context.beginPath();
		context.setStroke(Color.WHITE);
		context.arc(x, y, 20, 20, 2 * Math.PI, 1);
		context.stroke();
		context.fill();
		context.setLineWidth(10);
		context.stroke();
	}

	@Override
	public void tick() {
		if (tickCount == 1) {
			Platform.runLater(() -> {
				context.clearRect(0, 0, canvasWidth, canvasHeight);
				if (weatherEvents.size() > 0 && currentWeather != null) {
					for (WeatherCanvasShape shape : shapes) {
						if (shape.getX() > canvasWidth) {
							//shape.setX((int) Math.ceil(Math.random() * canvasWidth));
							shape.setX(-20);
						} else {
							shape.setX((shape.getX() + (shape.getDirection())));
						}
						if (shape.getY() > canvasHeight) {
							shape.setY(-20);
						} else {
							shape.setY(
									(shape.getY() + shape.getAcceleration()));
						}
						drawPositions(shape.getX(), shape.getY(),
								shape.getDirection());
					}
				}
			});
			tickCount = 0;
		}
		tickCount++;
	}

}
