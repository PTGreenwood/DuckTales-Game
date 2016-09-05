package uq.deco2800.ducktales.util.events.ui;

import javafx.event.EventType;
import uq.deco2800.ducktales.resources.ResourceType;

/**
 * This event is fired when the right mouse is clicked while handling a UI Element
 * such as a building or animal sprite to be added to the world. The current purpose,
 * is for the right click to de-select the sprite
 *
 * Created on 1/09/2016.
 * @author khoiphan21
 */
public class HUDDeselectedEvent extends UIEvent{

    public static final EventType<HUDDeselectedEvent> HUDDeselectedEvent =
            new EventType<>("HUDDeselectedEvent");

    /**
     * Construct a building menu deselected event, and pass the type of
     * building being deselected into the event object
     *
     * @param type
     *          The type of the building being deselected
     */
    public HUDDeselectedEvent(ResourceType type) {
        super(HUDDeselectedEvent);
        this.type = type;
    }

    /**
     * Construct an empty deselected event just to notify the managers
     */
    public HUDDeselectedEvent() {
        super(HUDDeselectedEvent);
    }
}
