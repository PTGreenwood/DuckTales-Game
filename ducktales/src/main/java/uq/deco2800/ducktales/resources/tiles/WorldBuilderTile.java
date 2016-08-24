package uq.deco2800.ducktales.resources.tiles;

import javafx.scene.image.ImageView;
import uq.deco2800.ducktales.resources.ResourceRegister;
import uq.deco2800.ducktales.resources.ResourceType;
import uq.deco2800.ducktales.worldBuilder.WorldBuilderManager;

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

    // Variable storing the current type of the tile
    private ResourceType currentType;

    // The controller for the World Builder
    private WorldBuilderManager manager = WorldBuilderManager.getInstance();

    public WorldBuilderTile(int xPos, int yPos) {
        super();
        this.xPos = xPos;
        this.yPos = yPos;

        addMouseEventHandling();
    }

    /**
     * Add mouse event handling for this class
     */
    private void addMouseEventHandling() {
        final ResourceRegister resource = ResourceRegister.getInstance();
        this.setOnMouseEntered(event -> {
            this.setImage(resource.getResourceImage(BLANK));
        });
        this.setOnMouseExited(event -> {
            this.setImage(resource.getResourceImage(GRASS_1));
        });
    }
}
