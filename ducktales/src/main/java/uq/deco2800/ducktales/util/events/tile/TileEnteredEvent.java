package uq.deco2800.ducktales.util.events.tile;

import javafx.event.EventType;

/**
 * This event delivers information about the tile being clicked to any
 * interested node, when a tile is hovered upon
 *
 * Created by Khoi on 1/09/2016.
 */
public class TileEnteredEvent extends TileEvent {

    // Setup the type of event for this event class
    public static final EventType<TileEnteredEvent> TILE_ENTERED =
            new EventType<>("TILE_ENTERED");

    public TileEnteredEvent(int xPos, int yPos) {
        super(TILE_ENTERED);
        this.xPos = xPos;
        this.yPos = yPos;
    };

}
