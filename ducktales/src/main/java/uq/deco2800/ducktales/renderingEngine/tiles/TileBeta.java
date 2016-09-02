package uq.deco2800.ducktales.renderingEngine.tiles;

import javafx.scene.image.ImageView;
import uq.deco2800.ducktales.GameManagerBeta;
import uq.deco2800.ducktales.GameRendererBeta;
import uq.deco2800.ducktales.resources.ResourceType;
import uq.deco2800.ducktales.util.Events.TileEvents.TileClickedEvent;
import uq.deco2800.ducktales.util.Events.TileEvents.TileEnteredEvent;
import uq.deco2800.ducktales.util.Events.TileEvents.TileExitedEvent;

/**
 * A tile in the game. The tile will contain information on what entity is
 * currently on it, as well as whether an agent can pass over it
 *
 * Created by Khoi on 31/08/2016.
 */
public class TileBeta extends ImageView{
    // The position of this tile in the 2D array of the game world
    private int xPos;
    private int yPos;

    // The type of this tile
    private ResourceType type;

    // The manager and renderer of the game
    private GameManagerBeta manager;
    private GameRendererBeta renderer;

    /**
     * Initialize a tile with the given manager, renderer and its x and y positions
     * in the 2D array
     *
     * @param manager
     *          The manager of the game
     * @param renderer
     *          The renderer of the game
     * @param xPos
     *          The x-position in the 2D array
     * @param yPos
     *          The y-position in the 2D array
     */
    @Deprecated
    public TileBeta(ResourceType type, int xPos, int yPos,
                    GameManagerBeta manager, GameRendererBeta renderer) {
        // Setup the handles for the manager and renderer
        this.manager = manager;
        this.renderer = renderer;
        // Setup the index of the tile
        this.xPos = xPos;
        this.yPos = yPos;
        this.type = type;
    }

    public TileBeta(ResourceType type, int xPos, int yPos) {
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
            fireEvent(new TileClickedEvent(this.xPos, this.yPos));
        });
        this.setOnMouseEntered(event -> {
            fireEvent(new TileEnteredEvent(this.xPos, this.yPos));
        });
        this.setOnMouseExited(event -> {
            fireEvent(new TileExitedEvent(this.xPos, this.yPos));
        });
    }
}
