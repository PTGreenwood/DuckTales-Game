package uq.deco2800.ducktales.tutorials;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import uq.deco2800.ducktales.GameLoop;
import uq.deco2800.ducktales.GameManager;
import uq.deco2800.ducktales.GameRenderer;
import uq.deco2800.ducktales.resources.ResourceRegister;
import uq.deco2800.ducktales.ui.KeyboardHandler;
import uq.deco2800.ducktales.ui.MouseDraggedHandler;
import uq.deco2800.ducktales.ui.MouseMovedHandler;
import uq.deco2800.ducktales.ui.MousePressedHandler;
import uq.deco2800.ducktales.ui.MouseReleasedHandler;
import uq.deco2800.ducktales.world.builder.WorldBuilderManager;

public class TutorialController implements Initializable {
	
	
	private BorderPane tutorialPane;
	
	@FXML
	private Pane tutorial1;
	
	@FXML
	private AnchorPane tutorialWindow, rightPane;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		

		// Set the handlers for the game panes
		rightPane.setOnMousePressed(new MousePressedHandler());
		rightPane.setOnMouseReleased(new MouseReleasedHandler());
		rightPane.setOnMouseDragged(new MouseDraggedHandler());
		rightPane.setOnMouseMoved(new MouseMovedHandler());
		tutorialWindow.setOnKeyPressed(new KeyboardHandler());
		tutorialWindow.setOnKeyReleased(new KeyboardHandler());
	}
	
	@FXML
	public void startTutorial1(ActionEvent event) throws Exception {
		if (tutorial1 == null) { // the canvas has not been initialized
			// Initialize the gameCanvas
			// and set the canvas to resize as the rightPane is resized
			
			
			
			//showPane(tutorial1);



			
			
		} else {
			// just show the canvas
			//showPane(tutorial1);
		}
	}
	
	
	private void showPane(Pane pane) {
		rightPane.getChildren().removeAll();
		rightPane.getChildren().add(pane);
	}
	
}
