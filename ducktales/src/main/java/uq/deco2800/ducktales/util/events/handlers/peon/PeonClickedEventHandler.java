package uq.deco2800.ducktales.util.events.handlers.peon;

import javafx.event.EventHandler;
import uq.deco2800.ducktales.GameManager;
import uq.deco2800.ducktales.World;
import uq.deco2800.ducktales.features.entities.peons.Peon;
import uq.deco2800.ducktales.features.hud.informationdisplay.peon.PeonInformationDisplayManager;
import uq.deco2800.ducktales.util.events.handlers.GameEventHandler;
import uq.deco2800.ducktales.util.events.peon.PeonClickedEvent;

/**
 * This handler will do the following tasks:
 *      1. Grab the actual peon object from the game model
 *      2. Tell the peon display manager that a peon was clicked on and pass
 *         that peon to the manager
 *
 * Created on 16/10/2016.
 * @author khoiphan21
 */
public class PeonClickedEventHandler extends GameEventHandler
        implements EventHandler<PeonClickedEvent> {

    public PeonClickedEventHandler(GameManager gameManager) {
        super(gameManager);
    }

    @Override
    public void handle(PeonClickedEvent event) {
        // Task 1
        World world = gameManager.getWorld();
        Peon peon = world.getPeon(event.getPeonName());

        // Task 2
        PeonInformationDisplayManager manager =
                this.gameManager.getPeonInformationDisplayManager();
        manager.setPeon(peon);
        manager.displayPeon();
    }
}
