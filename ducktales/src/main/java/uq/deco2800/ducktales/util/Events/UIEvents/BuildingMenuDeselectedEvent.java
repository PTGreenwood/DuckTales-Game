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

    public BuildingMenuDeselectedEvent(ResourceType type) {
        super(BUILDING_MENU_DESELECTED_EVENT);
        this.type = type;
    }
}
