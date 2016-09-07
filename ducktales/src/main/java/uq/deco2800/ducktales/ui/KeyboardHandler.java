package uq.deco2800.ducktales.ui;

import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import uq.deco2800.ducktales.OldGameManager;

public class KeyboardHandler implements EventHandler<KeyEvent> {

	@Override
	public void handle(KeyEvent event) {
		EventType<KeyEvent> eventType = event.getEventType();
		if (eventType == KeyEvent.KEY_PRESSED) {
			keyPressed(event.getCode());
		} 
		
		else if (eventType == KeyEvent.KEY_RELEASED) {
			keyReleased(event.getCode());
		}
		
		
	}

	private void keyPressed(KeyCode code) {
		OldGameManager oldGameManager = OldGameManager.getInstance();
		switch (code) {
		case A:
			oldGameManager.pan(OldGameManager.Direction.LEFT);
			break;

		case D:
			oldGameManager.pan(OldGameManager.Direction.RIGHT);
			break;

		case W:
			oldGameManager.pan(OldGameManager.Direction.UP);
			break;

		case S:
			oldGameManager.pan(OldGameManager.Direction.DOWN);
			break;

		default:
			break;
		}
	}

	private void keyReleased(KeyCode code) {
		OldGameManager oldGameManager = OldGameManager.getInstance();
		switch (code) {
		case A:
			oldGameManager.stopPan(OldGameManager.Direction.LEFT);
			break;

		case D:
			oldGameManager.stopPan(OldGameManager.Direction.RIGHT);
			break;

		case W:
			oldGameManager.stopPan(OldGameManager.Direction.UP);
			break;

		case S:
			oldGameManager.stopPan(OldGameManager.Direction.DOWN);
			break;

		default:
			break;
		}
	}
	
}