package uq.deco2800.ducktales.features.entities.worldentities;

import uq.deco2800.ducktales.rendering.sprites.BuildingSprite;
import uq.deco2800.ducktales.rendering.sprites.Sprite;
import uq.deco2800.ducktales.rendering.sprites.SpritesFactory;
import uq.deco2800.ducktales.resources.ResourceInfoRegister;
import uq.deco2800.ducktales.resources.ResourceType;
import uq.deco2800.ducktales.util.SecondaryManager;
import uq.deco2800.ducktales.util.exceptions.GameSetupException;

import java.util.ArrayList;
import java.util.List;

/**
 * Handles everything related to buildings:
 *      1. Adding new buildings into the game
 *      2. Updating buildings and their sprites' statuses
 *
 * Created on 12/10/2016.
 * @author khoiphan21
 */
public class BuildingManager extends SecondaryManager {
    /** The list of building sprites */
    private List<BuildingSprite> buildingSprites;

    /** The register holding information of game objects */
    ResourceInfoRegister infoRegister = ResourceInfoRegister.getInstance();

    /**
     * Construct a building manager with an empty list of building sprites
     */
    public BuildingManager() {
        buildingSprites = new ArrayList<>();
    }

    /**
     * Add a building of a given type to the given location.
     * This code will also check whether that location is valid before addition
     * If the location is not valid (for example, not all the 3 tiles around
     * a location are available for a 2x2 building), it will return false.
     * Otherwise, return true
     *
     * @param type
     *          The type of building to be added
     * @param x
     *          The x-coordinate of the location to add the building to
     * @param y
     *          The y-coordinate of the location to add the building to
     */
    public boolean addBuilding(ResourceType type, int x, int y) {
        Building building = ResourceInfoRegister.createBuilding(type, x, y);

        // Check if the building has been registered
        if (building != null) {
            // Check if the building manager is set up properly
            if (this.world == null || this.gameManager == null) {
                throw new GameSetupException("World and Game Manager not set up" +
                        " for Building Manager");
            }

            // Get the size of the given building
            int xLength = infoRegister.getEntitySize(type, ResourceInfoRegister.X);
            int yLength = infoRegister.getEntitySize(type, ResourceInfoRegister.Y);

            // Check validity of that building
            if (world.checkTileAvailability(x, y, xLength, yLength)) {
                // It is valid to add this tile

                // Add that buidling to the buildings list
                world.addBuilding(building, x, y, xLength, yLength);

                // Add the sprite of that building to the list
                BuildingSprite sprite = SpritesFactory.createBuildingSprite(
                        buildingSprites.size(), type);
                if (sprite == null) {
                    throw new GameSetupException("BuildingSprite of type " + type +
                            " is not yet registered in Sprites Factory");
                }

                // Setup the sprite
                Sprite.setupEntitySprite(sprite, x, y,
                        gameManager.getWorldDisplayManager().getTilesManager());

                // Add the sprite to the list and then to the world
                buildingSprites.add(sprite);
                gameManager.getWorldDisplayManager().getWorldDisplay()
                        .getChildren().add(sprite);

                return true;
            } else {
                return false;
            }
        } else {
            throw new GameSetupException("Building of type " + type +
                    " is not yet registered in ResourceInfoRegister");
        }
    }

    /**
     * Move all the building sprites by the given x- and y-amount
     *
     * @param xAmount
     *          The amount to move in x-direction
     * @param yAmount
     *          The amount to move in y-direction
     */
    public void moveAllBuildingSprites(double xAmount, double yAmount) {
        for (BuildingSprite sprite: buildingSprites) {
            if (sprite != null) {
                sprite.setLayoutX(sprite.getLayoutX() + xAmount);
                sprite.setLayoutY(sprite.getLayoutY() + yAmount);
            } else {
                throw new GameSetupException("A sprite is not yet " +
                        "instantiated");
            }
        }
    }
    
    /**
     * Method to access all the building sprites currently within the 
     * game. If no building sprites exist an empty list is returned.
     * 
     * @return the list of all buildingsprites within the world.
     */
    public List<BuildingSprite> getBuildingSprites() {
    	return buildingSprites;
    }
}
