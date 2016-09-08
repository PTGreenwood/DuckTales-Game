package uq.deco2800.ducktales.util.events.handlers.custom;

import javafx.event.EventHandler;
import uq.deco2800.ducktales.GameManager;
import uq.deco2800.ducktales.rendering.worlddisplay.CursorManager;
import uq.deco2800.ducktales.resources.ResourceType;
import uq.deco2800.ducktales.util.events.handlers.GameEventHandler;
import uq.deco2800.ducktales.util.events.ui.HUDDeselectedEvent;

/**
 * This handler will do the following task:
 *      1. Set visibility of cursor image to false
 *      2. Set current resource managing to NONE
 *
 * Created on 8/09/2016.
 * @author khoiphan21
 */
public class HUDDeselectedHandler extends GameEventHandler
        implements EventHandler<HUDDeselectedEvent> {

    /** The secondary managers */
    private CursorManager cursorManager;

    /**
     * Create a handler for the HUDDeselected event
     *
     * @param gameManager
     *          The game manager
     */
    public HUDDeselectedHandler(GameManager gameManager) {
        super(gameManager);
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
