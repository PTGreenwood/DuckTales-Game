package uq.deco2800.ducktales.util.events.uievents;

import javafx.event.EventType;
import uq.deco2800.ducktales.resources.ResourceType;

/**
 * This event is fired whenever a building in the buildings menu is clicked
 * on. There is another event that will be fired when the mouse is released,
 * which is {@link BuildingMenuDeselectedEvent}
 *
 * Created on 1/09/2016.
 *
 * @author khoiphan21
 */
public class BuildingMenuSelectedEvent extends UIEvent {

    // The starting point of this event
    private double startingX;
    private double startingY;

    public static final EventType<BuildingMenuSelectedEvent> BUILDING_MENU_SELECTED_EVENT =
            new EventType<>("BUILDING_MENU_SELECTED_EVENT");

    public BuildingMenuSelectedEvent(ResourceType type, double startingX, double startingY) {
        super(BUILDING_MENU_SELECTED_EVENT);
        this.type = type;
        this.startingX = startingX;
        this.startingY = startingY;
    }

    public double getStartingX() {
        return startingX;
    }

    public double getStartingY() {
        return startingY;
    }
}
