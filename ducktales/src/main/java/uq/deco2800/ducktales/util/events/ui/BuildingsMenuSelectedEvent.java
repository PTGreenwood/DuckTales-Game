package uq.deco2800.ducktales.util.events.ui;

import javafx.event.EventType;
import uq.deco2800.ducktales.resources.ResourceType;

/**
 * This event is fired whenever a building in the buildings menu is clicked
 * on. There is another event that will be fired when the building is de-focused,
 * which is {@link HUDDeselectedEvent}
 *
 * Created on 1/09/2016.
 * @author khoiphan21
 */
public class BuildingsMenuSelectedEvent extends HUDSelectedEvent {

    /**
     * The type of this event
     */
    public static final EventType<BuildingsMenuSelectedEvent> BUILDING_MENU_SELECTED_EVENT =
            new EventType<>("BUILDING_MENU_SELECTED_EVENT");

    /**
     * Instantiate an event for when a building sprite in the buildings menu is
     * clicked upon
     *
     * @param type
     *          The type of the sprite
     * @param startingX
     *          The x-coordinate of the point when the event is started from
     * @param startingY
     *          The y-coordinate of the point when the event is started from
     */
    public BuildingsMenuSelectedEvent(ResourceType type, double startingX, double startingY) {
        super(type, startingX, startingY, BUILDING_MENU_SELECTED_EVENT);
    }
}
