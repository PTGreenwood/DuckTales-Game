package uq.deco2800.ducktales.util.events.handlers.keyboard;

import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import uq.deco2800.ducktales.GameManager;
import uq.deco2800.ducktales.rendering.worlddisplay.WorldDisplayManager;
import uq.deco2800.ducktales.util.events.handlers.GameEventHandler;

import uq.deco2800.ducktales.rendering.worlddisplay.WorldDisplayManager.Direction;

/**
 * Handle keyboard events happening in-game.
 *
 * Created on 8/09/2016.
 * @author khoiphan21
 */
public class InGameKeyboardHandler extends GameEventHandler implements EventHandler<KeyEvent> {

    /** The secondary managers */
    private WorldDisplayManager displayManager;

    /**
     * Create a handler for in-game keyboard events
     *
     * @param gameManager
     *          The manager of the game
     */
    public InGameKeyboardHandler(GameManager gameManager) {
        super(gameManager);
        displayManager = gameManager.getWorldDisplayManager();
    }

    @Override
    public void handle(KeyEvent event) {
        // Get the type of the key event
        EventType<KeyEvent> eventType = event.getEventType();

        // Check if it's a key pressed or key released
        if (eventType == KeyEvent.KEY_PRESSED) {
            handleKeyPressed(event.getCode());
        } else if (eventType == KeyEvent.KEY_RELEASED) {
            handleKeyReleased(event.getCode());
        }
    }

    private void handleKeyPressed(KeyCode code) {
        switch (code) {
            case A:
                displayManager.moveWorld(Direction.LEFT);
                break;
            case S:
                displayManager.moveWorld(Direction.DOWN);
                break;
            case D:
                displayManager.moveWorld(Direction.RIGHT);
                break;
            case W:
                displayManager.moveWorld(Direction.UP);
                System.err.println("moving UP in Handler");
                break;
        }
    }

    private void handleKeyReleased(KeyCode code) {
        switch (code) {
            case A:
                displayManager.stopMoveWorld(Direction.LEFT);
                break;
            case S:
                displayManager.stopMoveWorld(Direction.DOWN);
                break;
            case D:
                displayManager.stopMoveWorld(Direction.RIGHT);
                break;
            case W:
                displayManager.stopMoveWorld(Direction.UP);
                break;
        }

    }
}
