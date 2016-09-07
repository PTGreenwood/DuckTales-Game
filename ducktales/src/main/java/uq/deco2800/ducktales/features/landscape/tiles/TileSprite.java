package uq.deco2800.ducktales.features.landscape.tiles;

import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import uq.deco2800.ducktales.deprecated.GameManagerBeta;
import uq.deco2800.ducktales.deprecated.GameRendererBeta;
import uq.deco2800.ducktales.resources.ResourceType;
import uq.deco2800.ducktales.util.events.tile.TileClickedEvent;
import uq.deco2800.ducktales.util.events.tile.TileEnteredEvent;
import uq.deco2800.ducktales.util.events.tile.TileExitedEvent;
import uq.deco2800.ducktales.util.events.ui.HUDDeselectedEvent;

/**
 * A tile seen by the player in the game. It is purely a sprite to be rendered onto
 * the screen and contains no game logic
 *
 * Created on 31/08/2016.
 */
public class TileSprite extends ImageView{
    // The position of this tile in the 2D array of the game world
    private int xPos;
    private int yPos;

    /** The type of this tile */
    private ResourceType type;

    /**
     * Create a sprite for a tile with the given tile info
     *
     * @param type
     *          The type of this tile sprite
     * @param xPos
     *          The x-position in the 2D array
     * @param yPos
     *          The y-position in the 2D array
     */
    public TileSprite(ResourceType type, int xPos, int yPos) {
        // Setup the index of the tile
        this.xPos = xPos;
        this.yPos = yPos;
        this.type = type;

        // BETA VERSION OF EVENT FIRING
        setMouseEventHandlers();
    }

    /**
     * Get the type of this tile
     *
     * @return the type of this tile
     */
    public ResourceType getTileType() {
        return this.type;
    }


    /**
     * This is a new implementation of mouse event handlers - instead of
     * calling methods from manager or renderer directly, the tile will broadcast
     * new types of event for the parent nodes to handle
     */
    private void setMouseEventHandlers() {
        this.setOnMouseClicked(event -> {
            if (event.getButton() == MouseButton.PRIMARY) {
                // Left mouse clicked on tile
                fireEvent(new TileClickedEvent(this.xPos, this.yPos));

                // This additional event is handled by OldGameRenderer when
                // a building is currently being managed
                fireEvent(new HUDDeselectedEvent());
            } else if (event.getButton() == MouseButton.SECONDARY) {
                // Right mouse clicked - deselect the HUD
                fireEvent(new HUDDeselectedEvent());
            }

        });
        this.setOnMouseEntered(event -> {
            fireEvent(new TileEnteredEvent(this.xPos, this.yPos));

            // prevent the worldPane from handling this event
            event.consume();
        });
        this.setOnMouseExited(event -> {
            fireEvent(new TileExitedEvent(this.xPos, this.yPos));
        });
    }
}
