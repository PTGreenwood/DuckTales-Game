package uq.deco2800.ducktales.features.entities.resourceentities;

import java.util.HashMap;

import uq.deco2800.ducktales.features.entities.agententities.Animal;
import uq.deco2800.ducktales.features.entities.agententities.AnimalManager;
import uq.deco2800.ducktales.rendering.sprites.AnimalSprite;
import uq.deco2800.ducktales.rendering.sprites.ResourceEntitySprite;
import uq.deco2800.ducktales.rendering.sprites.Sprite;
import uq.deco2800.ducktales.rendering.sprites.SpritesFactory;
import uq.deco2800.ducktales.resources.ResourceInfoRegister;
import uq.deco2800.ducktales.resources.ResourceType;
import uq.deco2800.ducktales.util.SecondaryManager;
import uq.deco2800.ducktales.util.exceptions.AnimalNotRegisteredException;
import uq.deco2800.ducktales.util.exceptions.GameSetupException;

/**
 * Manager for all the resource entities in the game.
 *
 * @author Damian Maher
 */

public class ResourceEntityManager extends SecondaryManager{

    /** 
     * The list of resource sprites 
     * Using a HashMap to store the sprites 
     */
    private HashMap<Integer, Sprite> resourceSprites;
    
    /** The animal manager */
    private AnimalManager animalManager;

    /**
     * Instantiate an empty resource manager
     */
    public ResourceEntityManager() {
        resourceSprites = new HashMap<Integer, Sprite>();
    }
    
    /**
     * Add a resource entity to the given location in the game. This method also
     * instantiates a sprite for that entity, based on its type and render
     * that sprite onto the game
     *
     * @param type
     *          The type of resource entity to be added
     * @param x
     *          The x-coordinate of the resource entity in regards to the world size
     * @param y
     *          The y-coordinate of the resource entity in regards to the world size
     */
    public void addAnimal(ResourceType type, int x, int y) {
        // Construct a new animal from the given type
        ResourceEntity resource = ResourceInfoRegister.createResourceEntity(type, x, y);

        // check if the resource has been registered
        if (resource != null) {
            if (this.gameManager != null){
                resource.setGameManager(this.gameManager);
            } else {
                throw new GameSetupException("A resource entity class does not have" +
                        "a reference of Game Manager yet");
            }

            // Add that animal to the animals list
            world.addResourceEntity(resource.hashCode(), resource);

            // Add the sprite of the resource to the sprites list, and set
            // the position of that sprite
            ResourceEntitySprite sprite = SpritesFactory.createResourceEntitySprite(
            		resourceSprites.size(), type
            );
            if (sprite == null) {
                throw new GameSetupException("Sprite of type " + type +
                        " is not yet registered in SpritesFactory");
            }

            // Setup the sprite
            Sprite.setupEntitySprite(sprite, x, y,
                    gameManager.getWorldDisplayManager().getTilesManager());

            // Add the sprite to the array list
            resourceSprites.put(type.hashCode(), sprite);

            // Add the sprite to the world display
            gameManager.getWorldDisplayManager().getWorldDisplay()
                    .getChildren().add(sprite);

        } else {
            throw new AnimalNotRegisteredException("The animal requested" +
                    " is not yet registered in ResourceInfoRegister");
        }
    }
	
    /**
     * Add a resource drop at the location specified, this method mainly is used
     * to drop an animal related resource when an animal dies (e.g. drop beef resource
     * when a cow dies, etc)
     *
     * @param type
     *          The type of resource to be added
     * @param x
     *          The x-coordinate of the resource in regards to the world size
     * @param y
     *          The y-coordinate of the resource in regards to the world size
     */
	public void dropResource(ResourceType type, int x, int y) {
		animalManager.addAnimal(type, x, y);
	}
}
