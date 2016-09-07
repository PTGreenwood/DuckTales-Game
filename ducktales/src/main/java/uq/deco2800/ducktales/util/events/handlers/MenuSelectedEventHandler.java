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
 *      2. Set the resource currently managed in the manager to the item type
 *
 * Created on 5/09/2016.
 * @author khoiphan21
 */
public class MenuSelectedEventHandler implements EventHandler<MenuSelectedEvent> {

    /** The managers of the game */
    private GameManager gameManager;
    private CursorManager cursorManager;

    /**
     * Creates a handler for the event fired when a menu item is selected
     *
     * @param gameManager
     *          The manager of the game
     */
    public MenuSelectedEventHandler(GameManager gameManager) {
        this.gameManager = gameManager;
        this.cursorManager = gameManager.getCursorManager();
    }

    /**
     * This method is called when an event is captured by this handler
     *
     * @param event
     *          The event captured by the handler
     */
    @Override
    public void handle(MenuSelectedEvent event) {
        doTask1(event);
        doTask2(event);
    }

    /**
     * Carry out task 1 as described in the class description
     *
     * @param event
     *          The event fired
     */
    private void doTask1(MenuSelectedEvent event) {
        // Change the image of the cursor and move it to where the cursor is
        cursorManager.changeImage(event.getType());
        cursorManager.moveCursorImage(event.getStartingX(), event.getStartingY());

        // Adjust the image accordingly and adjust the offset
        cursorManager.resizeImage(RenderingInformation.UI_SCALE);
        cursorManager.adjustOffset();

        cursorManager.showCursorImage();
    }

    /**
     * Carry out task 2 as described in the class description
     *
     * @param event
     *          The event fired
     */
    private void doTask2(MenuSelectedEvent event) {
        gameManager.setCurrentResourceManaging(event.getType());
    }
}
