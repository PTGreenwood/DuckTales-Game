package uq.deco2800.ducktales.util.events.job;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;
import javafx.event.Event;
import javafx.event.EventType;
import uq.deco2800.ducktales.World;
import uq.deco2800.ducktales.features.entities.peons.Peon;
import uq.deco2800.ducktales.features.jobframework.Job;

/**
 * This event will be fired when a peon sprite is clicked on.
 *
 * It will contain the information about the id of the peon that was clicked on
 * Created on 16/10/2016.
 * @author khoiphan21
 */
public class JobSpritePeonClickedEvent extends Event {
    // Setup the type of event for this event class
    public static final EventType<JobSpritePeonClickedEvent> PEON_JOB_SPRITE_CLICKED_EVENT =
            new EventType<>("PEON_JOB_SPRITE_CLICKED_EVENT");

    /** The name of the peon that fired this event */
    private String peonName;
    private World world;
    /** The job that corresponds to this event */
    

    /**
     * Create an event storing the name of the peon whose sprite was clicked on
     *
     * This name is currently the unique ID used to retrieve the peon or its
     * sprite via the managers
     *
     * @param peonName
     *          The name of the peon that was clicked on
     */
    public JobSpritePeonClickedEvent(String peonName, Job job) {
        super(PEON_JOB_SPRITE_CLICKED_EVENT);

        this.peonName = peonName;
        Peon peon = world.getPeon(peonName);
        peon.applyForJob(job);
    }

    /**
     * Get the name of the peon that fired this event. This name is a unique
     * identifier used to retrieve either the peon or its sprite from the map
     *
     * @return the name of the peon that fired this event
     */
    public String getPeonName() {
        return peonName;
    }
    
}
