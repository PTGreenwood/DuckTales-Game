package uq.deco2800.ducktales.util.events.handlers;

import javafx.event.EventHandler;
import uq.deco2800.ducktales.GameManager;

/**
 * Created by Khoi on 8/09/2016.
 */
public class GameEventHandler {
    /** The manager of the game */
    protected GameManager gameManager;

    /**
     * Instantiate an event handler with a handle on the game manager
     *
     * @param gameManager
     *          The manager of the game
     */
    public GameEventHandler(GameManager gameManager) {
        this.gameManager = gameManager;
    }
}
