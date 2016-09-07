package uq.deco2800.ducktales.util.events.handlers;

import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import uq.deco2800.ducktales.GameManager;
import uq.deco2800.ducktales.util.events.ui.HUDDeselectedEvent;

/**
 * Handles all mouse click events for the highest level of mouse events. Tasks:
 *      1. Fire "HUD_DESELECTED_EVENT" if a right mouse button is clicked
 *
 * Created on 8/09/2016.
 * @author khoiphan21
 */
public class InGameMouseClickedHandler implements EventHandler<MouseEvent> {

    /** The manager of the game */
    private GameManager gameManager;

    /**
     * Instantiate a handler for high level mouse click events
     *
     * @param gameManager
     *          The manager of the game
     */
    public InGameMouseClickedHandler(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    @Override
    public void handle(MouseEvent event) {
        // do task 1
        if (event.getButton() == MouseButton.SECONDARY) {
            System.err.println("firing HUDDeselected Event");
            gameManager.getRoot().fireEvent(new HUDDeselectedEvent());
        }

    }
}
