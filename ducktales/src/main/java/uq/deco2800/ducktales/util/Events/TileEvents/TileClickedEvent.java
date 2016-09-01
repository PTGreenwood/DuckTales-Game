package uq.deco2800.ducktales.util.Events.TileEvents;

import javafx.event.EventType;

/**
 * This simple event is to send information about the clicked tile to other nodes
 * without having to store a reference of those nodes
 *
 * Created by Khoi on 1/09/2016.
 */
public class TileClickedEvent extends TileEvent {

    // Setup the type of event for this event class
    public static final EventType<TileClickedEvent> TILE_CLICKED =
            new EventType<>("TILE_CLICKED");

    public TileClickedEvent(int xPos, int yPos) {
        super(TILE_CLICKED);
        this.xPos = xPos;
        this.yPos = yPos;
    };
}
