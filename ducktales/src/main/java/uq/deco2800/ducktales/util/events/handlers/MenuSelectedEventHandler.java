package uq.deco2800.ducktales.util.events.handlers;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import uq.deco2800.ducktales.GameManager;
import uq.deco2800.ducktales.rendering.RenderingInformation;
import uq.deco2800.ducktales.rendering.worlddisplay.CursorManager;
import uq.deco2800.ducktales.util.events.ui.MenuSelectedEvent;

/**
 * This handler will deal with the event when a sprite in the menu is selected
 *
 * The operations performed:
 *      1. Update the cursor image
 * Created by Khoi on 5/09/2016.
 */
public class MenuSelectedEventHandler implements EventHandler<MenuSelectedEvent> {

    /** The managers of the game */
    private GameManager gameManager;
    private CursorManager cursorManager;

    public MenuSelectedEventHandler(GameManager gameManager, CursorManager cursorManager) {
        this.gameManager = gameManager;
        this.cursorManager = cursorManager;
    }

    @Override
    public void handle(MenuSelectedEvent event) {
        System.err.println("cursor image should be changed");
        // Change the image of the cursor and move it to where the cursor is
        cursorManager.changeImage(event.getType());
        cursorManager.moveCursorImage(event.getStartingX(), event.getStartingY());

        // Adjust the image accordingly and adjust the offset
        cursorManager.resizeImage(RenderingInformation.UI_SCALE);
        cursorManager.adjustOffset();
    }
}
