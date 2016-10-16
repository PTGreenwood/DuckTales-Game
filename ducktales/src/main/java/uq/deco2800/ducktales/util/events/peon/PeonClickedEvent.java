package uq.deco2800.ducktales.util.events.peon;

import javafx.event.Event;
import javafx.event.EventType;

/**
 * This event will be fired when a peon sprite is clicked on.
 *
 * It will contain the information about the id of the peon that was clicked on
 * Created on 16/10/2016.
 * @author khoiphan21
 */
public class PeonClickedEvent extends Event {
    // Setup the type of event for this event class
    public static final EventType<PeonClickedEvent> PEON_CLICKED_EVENT =
            new EventType<>("PEON_CLICKED_EVENT");

    /** The name of the peon that fired this event */
    private String peonName;

    /**
     * Create an event storing the name of the peon whose sprite was clicked on
     *
     * This name is currently the unique ID used to retrieve the peon or its
     * sprite via the managers
     *
     * @param peonName
     *          The name of the peon that was clicked on
     */
    public PeonClickedEvent(String peonName) {
        super(PEON_CLICKED_EVENT);

        this.peonName = peonName;
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
