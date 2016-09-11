package uq.deco2800.ducktales.util.events.ui;

import javafx.event.EventType;
import uq.deco2800.ducktales.resources.ResourceType;
import uq.deco2800.ducktales.features.hud.menu.MenuManager.MenuType;

/**
 * This event is fired whenever an animal in the animals menu is clicked
 * on. There is another event that will be fired when the animal is de-focused,
 * which is {@link HUDDeselectedEvent}
 *
 * Created by Khoi on 4/09/2016.
 */
public class MenuSelectedEvent extends HUDSelectedEvent {

    /**
     * The type of this event
     */
    public static final EventType<MenuSelectedEvent> MENU_SELECTED_EVENT =
            new EventType<>("MENU_SELECTED_EVENT");

    /** The type of menu sprite selected */
    private MenuType menuType;

    /**
     * Instantiate an event for when the animals sprite in the animals menu is
     * clicked upon
     *
     * @param type
     *          The type of the sprite
     * @param startingX
     *          The x-coordinate of the point when the event is started from
     * @param startingY
     *          The y-coordinate of the point when the event is started from
     */
    public MenuSelectedEvent(MenuType menuType, ResourceType type,
                             double startingX, double startingY) {
        super(type, startingX, startingY, MENU_SELECTED_EVENT);
        this.menuType = menuType;
    }

    /**
     * Get the type of menu selected - either BUILDING or ANIMAL
     *
     * @return the type of menu selected
     */
    public MenuType getMenuType() {
        return this.menuType;
    }
}
