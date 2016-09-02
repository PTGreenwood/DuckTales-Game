package uq.deco2800.ducktales.renderingengine.tiles;

import javafx.scene.image.ImageView;
import uq.deco2800.ducktales.resources.ResourceRegister;
import uq.deco2800.ducktales.resources.ResourceType;
import uq.deco2800.ducktales.util.Point;
import uq.deco2800.ducktales.world.builder.WorldBuilderManager;
import uq.deco2800.ducktales.world.builder.WorldBuilderRenderer;

import static uq.deco2800.ducktales.resources.ResourceType.*;

/**
 * This class represents a tile to be rendered on the world map
 * ImageView is used in order to save up on resources and allow easier
 * mouse-event handling
 *
 * Created by Khoi on 24/08/2016.
 */
public class WorldBuilderTile extends ImageView {
    // The position of this tile in the 2D array of the World
    private int xPos;
    private int yPos;

    final ResourceRegister resource = ResourceRegister.getInstance();

    // Variable storing the current type of the tile
    private ResourceType currentType = GRASS_1;

    // The type to be shown when the tile is hovered upon
    private ResourceType hoverType = BLANK;

    // The controller for the World Builder
    private WorldBuilderManager manager = WorldBuilderManager.getInstance();
    // The rendering engine
    private WorldBuilderRenderer renderer;

    public WorldBuilderTile(WorldBuilderRenderer renderer, int xPos, int yPos) {
        super();
        this.renderer = renderer;
        this.xPos = xPos;
        this.yPos = yPos;

        addMouseEventHandling();
    }

    /**
     * Set the type to be shown when this tile is hovered on
     * @param type
     *          The type to be shown upon mouse hover
     */
    public void setHoverType(ResourceType type) {
        this.hoverType = type;
    }

    public int getxPos() {
        return this.xPos;
    }
    public int getyPos() {
        return this.yPos;
    }

    /**
     * Add mouse event handling for this class
     */
    private void addMouseEventHandling() {
        /*
         * Handlers for mouse-click events
         */
        this.setOnMouseClicked(event -> {
            if (manager.getCurrentType() == manager.TILE) {
                this.currentType = hoverType;
                this.setImage(currentType);
            } else if (manager.getCurrentType() == manager.ENTITY) {
                renderer.notifyTileClicked(this.xPos, this.yPos);
            }

        });

        /*
         * Handlers for mouse hovering events
         */
        this.setOnMouseEntered(event -> {
            if (manager.getCurrentType() == manager.TILE) {
                // A tile is currently being managed
                this.setImage(hoverType);
            } else if (manager.getCurrentType() == manager.ENTITY) {
                // An entity is currently being managed
                renderer.notifyTileHovered(this.xPos, this.yPos);
            }

        });
        this.setOnMouseExited(event -> {
            if (manager.getCurrentType() == manager.TILE) {
                this.setImage(currentType);
            } else if (manager.getCurrentType() == manager.ENTITY) {
                renderer.notifyTileEndHovering();
            }

        });
    }

    private void setImage(ResourceType type) {
        this.setImage(resource.getResourceImage(type));
    }
}
