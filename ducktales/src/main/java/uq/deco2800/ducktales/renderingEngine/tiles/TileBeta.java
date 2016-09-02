package uq.deco2800.ducktales.renderingengine.tiles;

import javafx.scene.image.ImageView;
import uq.deco2800.ducktales.GameManagerBeta;
import uq.deco2800.ducktales.GameRendererBeta;
import uq.deco2800.ducktales.resources.ResourceRegister;
import uq.deco2800.ducktales.resources.ResourceType;
import uq.deco2800.ducktales.util.events.tileevents.TileClickedEvent;
import uq.deco2800.ducktales.util.events.tileevents.TileEnteredEvent;
import uq.deco2800.ducktales.util.events.tileevents.TileExitedEvent;
import uq.deco2800.ducktales.util.events.uievents.BuildingMenuDeselectedEvent;

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

    /** The type of this tile */
    private ResourceType type;

    /**
     * The type of the static entity currently on this tile
     *
     * NOTE: there can only be one type of static entity on any tile
     */
    private ResourceType staticEntityType;

    /** A boolean value determining whether this tile is passable */
    private boolean isPassable;

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

            // This additional event is handled by GameRenderer when
            // a building is currently being managed
            fireEvent(new BuildingMenuDeselectedEvent());
        });
        this.setOnMouseEntered(event -> {
            fireEvent(new TileEnteredEvent(this.xPos, this.yPos));
        });
        this.setOnMouseExited(event -> {
            fireEvent(new TileExitedEvent(this.xPos, this.yPos));
        });
    }

    /**
     * Get the type of the static entity currently on this tile
     *
     * @return the type of the static entity on this tile
     */
    public ResourceType getStaticEntityType() {
        return staticEntityType;
    }

    /**
     * Set the type of the static entity on this tile
     * @param staticEntityType
     *          The type of the static entity on this tile
     */
    public void setStaticEntityType(ResourceType staticEntityType) {
        this.staticEntityType = staticEntityType;
    }

    /**
     * Check if this tile is passable
     *
     * @return {@code true} if this tile is passable
     */
    public boolean isPassable() {
        return isPassable;
    }

    /**
     * Set this tile's passability
     *
     * @param passable
     *          the boolean value to determine whether the tiles is passable
     */
    public void setPassable(boolean passable) {
        isPassable = passable;
    }
}
