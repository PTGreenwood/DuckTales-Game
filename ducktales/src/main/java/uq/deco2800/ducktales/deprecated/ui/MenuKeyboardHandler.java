package uq.deco2800.ducktales.deprecated.ui;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import uq.deco2800.ducktales.DuckTalesController;
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
			GameLoop.setSpeedModifier(1);
			System.out.println("Speed 1x"); //set time scale to default
			break;

		case DIGIT2:
			GameLoop.setSpeedModifier(1.5);
			System.out.println("Speed 1.5x");  //set time scale to 1.5151x
			break;
			
		case DIGIT3:
			GameLoop.setSpeedModifier(2.5);
			System.out.println("Speed 2.5x");  //set time scale to 2.5x 
			break;
		
		case P:
			GameLoop.pauseWorld();
			System.out.println("Pause/UnPause");
			break;
			
		default:
			System.out.println("Key " + key);
			break;
		}
	}
	
	
}