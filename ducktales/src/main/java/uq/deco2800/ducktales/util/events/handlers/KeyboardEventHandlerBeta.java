package uq.deco2800.ducktales.util.events.handlers;

import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import uq.deco2800.ducktales.GameManagerBeta;
import uq.deco2800.ducktales.GameRendererBeta;

/**
 * Created by Khoi on 4/09/2016.
 */
public class KeyboardEventHandlerBeta implements EventHandler<KeyEvent> {

    /**
     * The main game's rendering engine
     */
    private GameRendererBeta renderer;

    /**
     * Create a keyboard event handler, with access to the rendering engine
     * @param renderer
     */
    public KeyboardEventHandlerBeta(GameRendererBeta renderer) {
        this.renderer = renderer;
    }

    @Override
    public void handle(KeyEvent event) {
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
                renderer.moveWorld(GameRendererBeta.Direction.LEFT);
                break;
            case S:
                renderer.moveWorld(GameRendererBeta.Direction.DOWN);
                break;
            case D:
                renderer.moveWorld(GameRendererBeta.Direction.RIGHT);
                break;
            case W:
                renderer.moveWorld(GameRendererBeta.Direction.UP);
                System.err.println("moving UP in Handler");
                break;
        }
    }

    private void handleKeyReleased(KeyCode code) {
        switch (code) {
            case A:case D:case S:case W:
                renderer.stopMoveWorld();
                break;
        }

    }
}
