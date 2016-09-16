package uq.deco2800.ducktales.util.events.handlers.mouse;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import uq.deco2800.ducktales.rendering.worlddisplay.CursorManager;

/**
 * This handler will handle UI logic when the mouse is moved in-game
 *
 * Created on 8/09/2016.
 * @author khoiphan21
 */
public class InGameMouseMovedHandler implements EventHandler<MouseEvent> {

    /** The secondary managers */
    private CursorManager cursorManager;

    /**
     *
     * @param cursorManager
     */
    public InGameMouseMovedHandler(CursorManager cursorManager) {
        this.cursorManager = cursorManager;
    }

    @Override
    public void handle(MouseEvent event) {
        // Move the cursor image to the mouse
        cursorManager.moveCursorImage(event.getSceneX(), event.getSceneY());
    }
}
