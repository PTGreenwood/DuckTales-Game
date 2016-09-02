package uq.deco2800.ducktales.util.events.tileevents;

import javafx.event.EventType;

/**
 * This event delivers information about the tile being clicked to any
 * interested node, when the mouse exited this tile
 *
 * Created by Khoi on 1/09/2016.
 */
public class TileExitedEvent extends TileEvent{

    // Setup the type of event for this event class
    public static final EventType<TileExitedEvent> TILE_EXITED =
            new EventType<>("TILE_EXITED");

    public TileExitedEvent(int xPos, int yPos) {
        super(TILE_EXITED);
        this.xPos = xPos;
        this.yPos = yPos;
    }
}
