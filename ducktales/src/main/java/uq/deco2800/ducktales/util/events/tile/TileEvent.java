package uq.deco2800.ducktales.util.events.tile;

import javafx.beans.NamedArg;
import javafx.event.Event;
import javafx.event.EventTarget;
import javafx.event.EventType;

/**
 * Created by Khoi on 1/09/2016.
 */
public class TileEvent extends Event {

    // Setup the type of event for this event class
    public static final EventType<TileEvent> TILE_EVENT =
            new EventType<>("TILE_EVENT");

    /** The x and y index of the tile that triggered this event */
    protected int xPos;
    protected int yPos;

    public TileEvent(@NamedArg("eventType") EventType<? extends Event> eventType) {
        super(eventType);
    }

    public TileEvent(int xPos, int yPos) {
        super(TILE_EVENT);
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public int getxPos() {
        return this.xPos;
    }
    public int getyPos() {
        return this.yPos;
    }
}
