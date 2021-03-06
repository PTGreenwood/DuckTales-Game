package uq.deco2800.ducktales.features.builder;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import uq.deco2800.ducktales.resources.ResourceSpriteRegister;
import uq.deco2800.ducktales.resources.ResourceType;

/**
 * This class represents a sprite of a tile, to be displayed in the UI in
 * World builder. It will contain event handlers which will notify the
 * WorldBuilderManager when it is clicked on
 * 
 * Part of the view implementation of the Builder package
 *
 * Created on 28/08/2016.
 *
 * @author khoiphan21
 */
public class TileSprite extends ImageView {
    /**
     * CONSTANTS
     */
    private static final double SCALE = 0.5;
    private static final double SPRITE_HEIGHT = 100 * SCALE;
    private static final double SPRITE_WIDTH = 174 * SCALE;

    private ResourceType tileType;
    private WorldBuilderModel manager; // The manager that this sprite reports to
    private Image sprite; // The image of the tile

    /**
     * Creates a tile sprite with the given type
     * @param type
     *          The type of this tile
     */
    public TileSprite(ResourceType type) {
        this.manager = WorldBuilderModel.getInstance();
        this.tileType = type;

        this.sprite = ResourceSpriteRegister.getInstance().getResourceImage(tileType);
        this.setImage(sprite);
        this.setFitHeight(SPRITE_HEIGHT);
        this.setFitWidth(SPRITE_WIDTH);

        setupMouseEventHandlers();
    }

    /**
     * Add an action/event 
     * 
     */
    private void setupMouseEventHandlers() {
        this.setOnMouseClicked(event ->
            WorldBuilderController.setCurrentResource(tileType, manager.TILE)
        );
    }

}
