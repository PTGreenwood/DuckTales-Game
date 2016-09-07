package uq.deco2800.ducktales.rendering.tiles;

import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import uq.deco2800.ducktales.core.GameManagerBeta;
import uq.deco2800.ducktales.core.GameRendererBeta;
import uq.deco2800.ducktales.resources.ResourceType;
import uq.deco2800.ducktales.util.events.tile.TileClickedEvent;
import uq.deco2800.ducktales.util.events.tile.TileEnteredEvent;
import uq.deco2800.ducktales.util.events.tile.TileExitedEvent;
import uq.deco2800.ducktales.util.events.ui.HUDDeselectedEvent;

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
    private ResourceType worldEntity;

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

    /**
     * Get the type of the static entity currently on this tile
     *
     * @return the type of the static entity on this tile
     */
    public ResourceType getWorldEntity() {
        return worldEntity;
    }

    /**
     * Set the type of the static entity on this tile
     * @param worldEntity
     *          The type of the static entity on this tile
     */
    public void setWorldEntity(ResourceType worldEntity) {
        this.worldEntity = worldEntity;
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
