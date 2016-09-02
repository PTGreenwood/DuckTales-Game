package uq.deco2800.ducktales.util.Events.UIEvents;

import javafx.event.EventType;
import uq.deco2800.ducktales.resources.ResourceType;

/**
 * This event is fired when the mouse is released after clicking on a building
 * in the buildings menu.
 *
 * The event fired when the building is clicked on is {@link BuildingMenuSelectedEvent}
 *
 * Created on 1/09/2016.
 *
 * @author khoiphan21
 */
public class BuildingMenuDeselectedEvent extends UIEvent{

    public static final EventType<BuildingMenuDeselectedEvent> BUILDING_MENU_DESELECTED_EVENT =
            new EventType<>("BUILDING_MENU_DESELECTED_EVENT");

    /**
     * Construct a building menu deselected event, and pass the type of
     * building being deselected into the event object
     *
     * @param type
     *          The type of the building being deselected
     */
    public BuildingMenuDeselectedEvent(ResourceType type) {
        super(BUILDING_MENU_DESELECTED_EVENT);
        this.type = type;
    }

    /**
     * Construct an empty deselected event just to notify the managers
     */
    public BuildingMenuDeselectedEvent() {
        super(BUILDING_MENU_DESELECTED_EVENT);
    }
}
