package uq.deco2800.ducktales.util.events.ui;

import javafx.event.EventType;
import uq.deco2800.ducktales.resources.ResourceType;

/**
 * This class is a super class for all 'Selected' events to be fired by HUD
 * elements such as the building sprites or animal sprites
 *
 * Created on 4/09/2016.
 * @author khoiphan21
 */
class HUDSelectedEvent extends UIEvent {

    /** The starting point of this event */
    private double startingX;
    private double startingY;

    /**
     * Constructs a general HUD event, which contains the type of the sprite
     * clicked upon and the position of the mouse when the event is fired
     *
     * @param type
     *          The type of the sprite
     * @param startingX
     *          The x-coordinate of the point when the event is started from
     * @param startingY
     *          The y-coordinate of the point when the event is started from
     * @param eventType
     *          The type of the event to be fired
     */
    public HUDSelectedEvent(ResourceType type, double startingX, double startingY, EventType eventType) {
        super(eventType);
        this.startingX = startingX;
        this.startingY = startingY;
        this.type = type;
    }

    public double getStartingX() {
        return startingX;
    }

    public void setStartingX(double startingX) {
        this.startingX = startingX;
    }

    public double getStartingY() {
        return startingY;
    }

    public void setStartingY(double startingY) {
        this.startingY = startingY;
    }
}
