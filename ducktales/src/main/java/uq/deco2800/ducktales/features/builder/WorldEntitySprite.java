package uq.deco2800.ducktales.features.builder;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import uq.deco2800.ducktales.resources.ResourceSpriteRegister;
import uq.deco2800.ducktales.resources.ResourceType;

/**
 * This class represents a sprite of a world entity, to be displayed in the UI in
 * World Builder. It will contain event handlers which will notify the
 * WorldBuilderManager when it is clicked on
 *
 * Created on 28/08/2016.
 *
 * @author khoiphan21
 */
public class WorldEntitySprite extends ImageView {

    /**
     * CONSTANTS
     */
	// static added to remove code smell
    private static final double SCALE = 0.25;

    /**
     * This is the size of this world entity in terms of tile units.
     * This variable will be used for the game manager to calculate and make
     * the corresponding tiles non-passable
     *
     * For example, a building taking up 4 tile units (2x2) will be rendered onto
     * the bottom most tile, and the other tiles will be made non-passable
     *
     * The current implementation is using a 2D matrix. For example
     * {@Code
     * int[][] size = {
     *     {1, 1, 1},
     *     {1, 1, 1}
     * } // Represent a 2x3 building.
     * }
     * The matrix will be 'tilted' 45 degree anti-clockwise when rendered
     */
    private int[][] sizeInTileUnit;

    private ResourceType entityType;
    private WorldBuilderModel manager;
    // remove code smell as being flagged as unused
    @SuppressWarnings("unused")
	private ResourceSpriteRegister register;
    private Image sprite;

    public WorldEntitySprite(ResourceType type) {
        this.manager = WorldBuilderModel.getInstance();
        this.entityType = type;
        this.register = ResourceSpriteRegister.getInstance();

        this.sprite = ResourceSpriteRegister.getInstance().getResourceImage(type);

        this.setFitHeight(this.sprite.getHeight() * SCALE);
        this.setFitWidth(this.sprite.getWidth() * SCALE);

        this.setImage(sprite);

        setMouseEventHandler();
    }


    public void setTileUnitSize(int[][] size) {
        this.sizeInTileUnit = size;
    }

    public int[][] getTileUnitSize() {
        return this.sizeInTileUnit;
    }

    private void setMouseEventHandler() {
        this.setOnMouseClicked(event ->
            WorldBuilderController.setCurrentResource(
                    this.entityType, manager.ENTITY)
        );
    }

}
