package uq.deco2800.ducktales.ui;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import uq.deco2800.ducktales.GameLoop; 

/**
 * Need to reconsider how I made this? I don't think it should use the
 * controller but I can't think of another way of how to make it work without
 * it.
 * 
 * @author mattyleggy
 * 
 * tagged on time control functionality begins at ///////////
 * 
 * @author danl256
 *
 */
public class MenuKeyboardHandler implements EventHandler<KeyEvent> {
	private DuckTalesController controller;

	// must be a better way to do this without referencing the controller?
	public MenuKeyboardHandler(DuckTalesController controller) {
		this.controller = controller;
	}

	@Override
	public void handle(KeyEvent event) {
		KeyCode key = event.getCode();
		
		switch (key) {
		case ESCAPE:
			this.controller.toggleMenuPane();
			System.out.println("Key" + key);
			break;
		/////////////////////////////////
			//key presses alters the flow of time.	
		case DIGIT1:
			GameLoop.SpeedControl("mallard");
			System.out.println("speed 1x"); //set time scale to default
			break;

		case DIGIT2:
			GameLoop.SpeedControl("canvasback");
			System.out.println("speed 1.5x");  //set time scale to 1.5151x
			break;
			
		case DIGIT3:
			GameLoop.SpeedControl("merganser");
			System.out.println("speed 2.5x");  //set time scale to 2.5x 
			break;
			
		default:
			System.out.println("Key" + key);
			break;
		}
	}
	
	
}