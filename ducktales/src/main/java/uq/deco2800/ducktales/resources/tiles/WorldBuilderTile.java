package uq.deco2800.ducktales.resources.tiles;

import javafx.scene.image.ImageView;
import uq.deco2800.ducktales.resources.ResourceRegister;
import uq.deco2800.ducktales.resources.ResourceType;
import uq.deco2800.ducktales.world.builder.WorldBuilderManager;

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

    public WorldBuilderTile(int xPos, int yPos) {
        super();
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
    /**
     * Add mouse event handling for this class
     */
    private void addMouseEventHandling() {
        /*
         * Handlers for mouse-click events
         */
        this.setOnMouseClicked(event -> {
            this.currentType = hoverType;
            this.setImage(currentType);
        });

        /*
         * Handlers for mouse hovering events
         */
        this.setOnMouseEntered(event -> {
            this.setImage(hoverType);
        });
        this.setOnMouseExited(event -> {
            this.setImage(currentType);
        });
    }

    private void setImage(ResourceType type) {
        this.setImage(resource.getResourceImage(type));
    }
}
