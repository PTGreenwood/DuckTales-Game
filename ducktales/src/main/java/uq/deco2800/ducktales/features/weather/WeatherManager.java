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
import java.util.ResourceBundle;

/**
 * Weather Manager
 */
public class WeatherManager implements SecondaryManager, Initializable, Tickable {
	private WeatherCanvas weatherCanvas;
	@FXML
	private Pane weatherDisplay;
    
	private Canvas weatherDisplayCanvas;
    @Override
    public void reload() {

    }
    
    @Override
	public void initialize(URL location, ResourceBundle resources) {
		weatherCanvas = new WeatherCanvas();	

		int canvasHeight = 737;
        int canvasWidth = 1295;   
        
        weatherDisplayCanvas = new Canvas(canvasWidth,canvasHeight);
                 
        AnchorPane.setLeftAnchor(weatherDisplayCanvas, 0.0);
        AnchorPane.setRightAnchor(weatherDisplayCanvas, 0.0);
        AnchorPane.setTopAnchor(weatherDisplayCanvas, 0.0);
        AnchorPane.setBottomAnchor(weatherDisplayCanvas, 0.0);
        GraphicsContext ctx = weatherDisplayCanvas.getGraphicsContext2D();
        //weatherManager.tick();
        Platform.runLater(() -> {            
    		for (int i=0; i < 1000; i++) {
    			
    			int randX = (int)Math.ceil(Math.random() * canvasWidth); 		
    			int randY = (int)Math.ceil(Math.random() * canvasHeight);		
    			int randD = (int)Math.floor(Math.random() * 7) - 3; //random direction between -3 && 3				
    			int randA = (int)(Math.random() * 5) + 10; //random acceleration
    			ctx.beginPath();            
                ctx.setFill(Color.GREEN);
                ctx.setStroke(Color.BLUE);
                ctx.arc(randX,randY,20,20,2*Math.PI,1);            
        		ctx.stroke();
        		ctx.fill();		
        		ctx.setLineWidth(2);
        		ctx.stroke();    
        		//ctx.clearRect(0, 0, canvasWidth, canvasHeight);
    		}    		
        });
        weatherDisplayCanvas.setMouseTransparent(true);
        weatherDisplay.getChildren().add(weatherDisplayCanvas);
	}

	@Override
	public void tick() {			
		weatherCanvas.tick();
		
	}

	
}
