package uq.deco2800.ducktales.util.events.handlers.job;

import javafx.event.EventHandler;
import uq.deco2800.ducktales.GameManager;
import uq.deco2800.ducktales.World;
import uq.deco2800.ducktales.features.entities.peons.Peon;
import uq.deco2800.ducktales.features.hud.informationdisplay.peon.PeonInformationDisplayManager;
import uq.deco2800.ducktales.util.events.handlers.GameEventHandler;
import uq.deco2800.ducktales.util.events.peon.PeonClickedEvent;
import uq.deco2800.ducktales.util.events.job.JobSpritePeonClickedEvent;

/**
 * This handler will do the following tasks:
 *      1. Grab the actual peon object from the game model
 *      2. Tell the peon display manager that a peon was clicked on and pass
 *         that peon to the manager
 *
 * Created on 16/10/2016.
 * @author khoiphan21
 */
public class PeonJobSpriteClickedEventHandler extends GameEventHandler
        implements EventHandler<JobSpritePeonClickedEvent> {

    public PeonJobSpriteClickedEventHandler(GameManager gameManager) {
        super(gameManager);
    }

    @Override
    public void handle(JobSpritePeonClickedEvent event) {
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
