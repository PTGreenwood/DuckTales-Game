package uq.deco2800.ducktales.util.events.handlers.job;

import javafx.event.EventHandler;
import javafx.scene.image.Image;
import uq.deco2800.ducktales.GameManager;
import uq.deco2800.ducktales.features.entities.peons.Peon;
import uq.deco2800.ducktales.features.hud.informationdisplay.peon.PeonInformationDisplayManager;
import uq.deco2800.ducktales.features.jobframework.Builder;
import uq.deco2800.ducktales.features.jobframework.Doctor;
import uq.deco2800.ducktales.features.jobframework.Farmer;
import uq.deco2800.ducktales.features.jobframework.Job;
import uq.deco2800.ducktales.features.jobframework.Lumberjack;
import uq.deco2800.ducktales.features.jobframework.Miner;
import uq.deco2800.ducktales.features.jobframework.Priest;
import uq.deco2800.ducktales.resources.ResourceSpriteRegister;
import uq.deco2800.ducktales.resources.ResourceType;
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


	ResourceSpriteRegister rsr;
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
            case LUMBERJACK_LV1_1:
                job = new Lumberjack();

                break;
            case MINER_LV1_1:
                job = new Miner();

                break;
            case BUILDER_LV1_1:
                job = new Builder();

                break;
            case DOCTOR_LV1_1:
                job = new Doctor();

                break;
            case FARMER_LV1_1:
                job = new Farmer();

                break;
            case PRIEST_LV1_1:
                job = new Priest();
                break;
            //case BLACKSMITH_LV1_1:
            //	job = new Blacksmith();
                //break;
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
