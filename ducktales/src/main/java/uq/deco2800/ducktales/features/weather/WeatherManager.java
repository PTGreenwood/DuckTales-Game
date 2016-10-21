package uq.deco2800.ducktales.features.weather;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import uq.deco2800.ducktales.features.seasons.SeasonManager;
import uq.deco2800.ducktales.features.time.TimeManager;
import uq.deco2800.ducktales.util.SecondaryManager;
import uq.deco2800.ducktales.util.Tickable;

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
	private int currentHour;
	private int currentDay;

	private TimeManager timeManager;
	private SeasonManager seasonManager;

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

		weatherEvents = new WeatherEvents();
		currentHour = -1;
		
		this.createShapes(50,this.isFalling());

		weatherDisplayCanvas.setMouseTransparent(true);
		weatherDisplay.getChildren().add(weatherDisplayCanvas);		
	}

	/**
	 * Create the shapes at random position to be drawn onto the canvas. Must be
	 * greater than 0.
	 * 
	 * @param amount
	 *            the amount of shapes to be drawn onto the canvas, must be
	 *            greater than 0.
	 */
	private void createShapes(int amount, boolean falling) {
		shapes.clear();
		for (int i = 0; i < amount; i++) {
			int randX = (int) Math.ceil(Math.random() * canvasWidth);
			int randY = (int) Math.ceil(Math.random() * canvasHeight);
			int randDirection = (int) Math.floor(Math.random() * 7) - 3;
			int randAcceleration = (int) (Math.random() * 5) + 10;
			/*if (!falling)
				randAcceleration = randAcceleration*-1;*/
			WeatherCanvasShape shape = new WeatherCanvasShape(randX, randY,
					randDirection, randAcceleration);
			shapes.add(shape);
			drawPositions(randX, randY, randDirection);
		}
	}

	public void setTimeManager(TimeManager timeManager) {
		this.timeManager = timeManager;
		this.seasonManager = timeManager.getSeasonManager();
	}

	public TimeManager getTimeManager() {
		return this.timeManager;
	}

	public SeasonManager getSeasonManager() {
		return this.seasonManager;
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
		context.setLineWidth(5);
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
				this.setCurrentWeather();
				this.drawShapes();
			});
			tickCount = 0;
		}
		tickCount++;
	}

	private void drawShapes() {
		if (weatherEvents.size() > 0 && currentWeather != null) {
			for (WeatherCanvasShape shape : shapes) {
				this.shiftPositions(shape);
			}
		}
	}

	/**
	 * If the shape falls outside of the bounds of the canvas, reset it to be in
	 * a new position where it can reappear onto the canvas.
	 * 
	 * @param shape
	 *            the shape to shift positions of
	 */
	private void shiftPositions(WeatherCanvasShape shape) {
		if (shape.getX() > canvasWidth) {
			// shape.setX((int) Math.ceil(Math.random() *
			// canvasWidth));
			shape.setX(-20);
		} else {
			shape.setX((shape.getX() + (shape.getDirection())));
		}
		if (shape.getY() > canvasHeight) {
			shape.setY(-20);
		} else {
			shape.setY((shape.getY() + shape.getAcceleration()));
		}
		drawPositions(shape.getX(), shape.getY(), shape.getDirection());
	}

	private void setCurrentWeather() {
		if (this.getTimeManager() != null) {
			int hour = this.getTimeManager().getGameTimeObject().getHour();
			int day = this.getTimeManager().getGameTimeObject().getCurrentDay();
			if (currentHour != hour) {
				currentHour = hour;
				currentDay = day;
				WeatherEvents seasonEvents = this.getSeasonManager()
						.getCurrentSeason().getSeasonalWeatherEvents();
				setWeatherEvents(seasonEvents);
				System.out.println(
						this.getSeasonManager().getCurrentSeason().getName()
								+ ": " + seasonEvents);
				currentWeather = getWeatherPossibility();				
				this.setLighting();
			}
		}
	}

	private boolean isFalling() {
		if (currentWeather instanceof Rain || currentWeather instanceof Snow)
			return true;
		return false;
	}

	private void setLighting() {
		if(this.getTimeManager().isNight()) {
			setNight();
		} else {
			setDay();
		}
	}

	private void setDay() {
		this.removeClasses();
		weatherDisplay.getStyleClass().add("day");
	}

	private void setNight() {
		this.removeClasses();
		weatherDisplay.getStyleClass().add("night");
	}

	private void removeClasses() {
		for (int i = 0; i < weatherDisplay.getStyleClass().size(); i++) {
			weatherDisplay.getStyleClass().remove(0);
		}
	}

}
