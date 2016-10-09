package uq.deco2800.ducktales.util.events.handlers.keyboard;

import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import uq.deco2800.ducktales.DuckTalesController;
import uq.deco2800.ducktales.GameLoop;


/**
 * Need to reconsider how I made this? I don't think it should use the
 * controller but I can't think of another way of how to make it work without
 * it.
 * 
 * Note: Is old Keyboard Handler. Use InGameKeyboardHandler Instead - pgwood
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
		
        EventType<KeyEvent> eventType = event.getEventType();
        // Check if it's a key pressed or key released
        if (eventType == KeyEvent.KEY_PRESSED) {
            handleKeyPressed(event.getCode(), event);
        }
	}
	
	public void handleKeyPressed(KeyCode key, KeyEvent event) {
		switch (key) {
		case ESCAPE:
			this.controller.toggleMenuPane();
			System.out.println("Key" + key);
			break;
            
		//Changing Flow of Time
		case DIGIT1:
			if(event.isShiftDown()) {
				GameLoop.setSpeedModifier(1);
				System.out.println("Speed 1x"); //set time scale to default
			}
			
			break;

		case DIGIT2:
			if(event.isShiftDown()) {
				GameLoop.setSpeedModifier(1.5);
				System.out.println("Speed 1.5x");  //set time scale to 1.5151x
			}
			
			break;
			
			
		case DIGIT3:
			if(event.isShiftDown()) {
				GameLoop.setSpeedModifier(2.5);
				System.out.println("Speed 2.5x");  //set time scale to 2.5x 
			}
			
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
	