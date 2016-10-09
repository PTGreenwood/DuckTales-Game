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
 */
public class WeatherManager
		implements SecondaryManager, Initializable, Tickable {
	private WeatherCanvas weatherCanvas;
	@FXML
	private Pane weatherDisplay;

	private Canvas weatherDisplayCanvas;

	private ArrayList<WeatherCanvasShape> shapes;

	private GraphicsContext context;

	private int canvasHeight;
	private int canvasWidth;
	
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
		for (int i = 0; i < 500; i++) {
			int randX = (int) Math.ceil(Math.random() * canvasWidth);
			int randY = (int) Math.ceil(Math.random() * canvasHeight);
			int randD = (int) Math.floor(Math.random() * 7) - 3;
			int randA = (int) (Math.random() * 5) + 10; // random acceleration
			WeatherCanvasShape shape = new WeatherCanvasShape(randX, randY,
					randD, randA);
			shapes.add(shape);
			drawPositions(randX, randY);
		}
		weatherDisplayCanvas.setMouseTransparent(true);
		weatherDisplay.getChildren().add(weatherDisplayCanvas);

	}

	private void drawPositions(int x, int y) {
		context.beginPath();
		context.setFill(Color.GREEN);
		context.setStroke(Color.BLUE);
		context.arc(x, y, 20, 20, 2 * Math.PI, 1);
		context.stroke();
		context.fill();
		context.setLineWidth(3);
		context.stroke();
	}

	@Override
	public void tick() {
		if (tickCount == 5) {		
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
					drawPositions(shape.getX(), shape.getY());
				}
			});	
			tickCount = 0;
		}
		tickCount++;
	}

}
