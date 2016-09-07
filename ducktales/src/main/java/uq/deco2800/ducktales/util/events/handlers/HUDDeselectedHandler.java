package uq.deco2800.ducktales.util.events.handlers;

import javafx.event.EventHandler;
import uq.deco2800.ducktales.GameManager;
import uq.deco2800.ducktales.rendering.worlddisplay.CursorManager;
import uq.deco2800.ducktales.resources.ResourceType;
import uq.deco2800.ducktales.util.events.ui.HUDDeselectedEvent;

/**
 * This handler will do the following task:
 *      1. Set visibility of cursor image to false
 *      2. Set current resource managing to NONE
 *
 * Created on 8/09/2016.
 * @author khoiphan21
 */
public class HUDDeselectedHandler implements EventHandler<HUDDeselectedEvent> {

    /** The game manager */
    private GameManager gameManager;

    /** The secondary managers */
    private CursorManager cursorManager;

    /**
     * Create a handler for the HUDDeselected event
     *
     * @param gameManager
     *          The game manager
     */
    public HUDDeselectedHandler(GameManager gameManager) {
        this.gameManager = gameManager;
        cursorManager = gameManager.getCursorManager();
    }

    @Override
    public void handle(HUDDeselectedEvent event) {
        // do task 1
        cursorManager.hideCursorImage();

        // do task 2
        gameManager.setCurrentResourceManaging(ResourceType.NONE);

    }
}
