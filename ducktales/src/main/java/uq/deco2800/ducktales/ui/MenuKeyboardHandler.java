package uq.deco2800.ducktales.ui;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 * Need to reconsider how I made this? I don't think it should use the
 * controller but I can't think of another way of how to make it work without
 * it.
 * 
 * @author mattyleggy
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
		default:
			System.out.println("Key" + key);
			break;
		}
	}
}