package uq.deco2800.ducktales.util.events.handlers.job;

import javafx.event.EventHandler;
import uq.deco2800.ducktales.GameManager;
import uq.deco2800.ducktales.World;
import uq.deco2800.ducktales.features.entities.peons.Peon;
import uq.deco2800.ducktales.features.hud.informationdisplay.peon.PeonInformationDisplayManager;
import uq.deco2800.ducktales.features.jobframework.*;
import uq.deco2800.ducktales.util.events.handlers.GameEventHandler;
import uq.deco2800.ducktales.util.events.job.JobSpritePeonClickedEvent;

/**
 * This handler will do the following tasks:
 *      1. Grab the actual peon object from the game model
 *      2. Tell it to change its job
 *      3. Tell the peon info display manager to show the new peon
 *
 * Created on 24/10/2016.
 * @author khoiphan21
 */
public class JobSpritePeonClickedEventHandler extends GameEventHandler
        implements EventHandler<JobSpritePeonClickedEvent> {

    public JobSpritePeonClickedEventHandler(GameManager gameManager) {
        super(gameManager);
    }

    @Override
    public void handle(JobSpritePeonClickedEvent event) {
        // Task 1
        PeonInformationDisplayManager displayManager =
                gameManager.getPeonInformationDisplayManager();
        Peon peon = displayManager.getCurrentlyDisplayedPeon();

        // Task 2
        Job job;
        switch (event.getJobType()) {
            case LUMBERJACK:
                job = new Lumberjack();
                break;
            case MINER:
                job = new Miner();
                break;
            case BUILDER:
                job = new Builder();
                break;
            case DOCTOR:
                job = new Doctor();
                break;
            case FARMER:
                job = new Farmer();
                break;
            case PRIEST:
                job = new Priest();
                break;
            default:
                job = new Builder();
                break;
        }
        peon.applyForJob(job);

        // Task 3
        displayManager.setPeon(peon);
        displayManager.displayPeon();
    }
}
