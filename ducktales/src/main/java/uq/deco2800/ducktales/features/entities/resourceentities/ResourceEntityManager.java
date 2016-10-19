package uq.deco2800.ducktales.features.entities.resourceentities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import uq.deco2800.ducktales.features.entities.agententities.Animal;
import uq.deco2800.ducktales.features.entities.agententities.AnimalManager;
import uq.deco2800.ducktales.rendering.sprites.AnimalSprite;
import uq.deco2800.ducktales.rendering.sprites.DroppedResourceSprite;
import uq.deco2800.ducktales.rendering.sprites.Sprite;
import uq.deco2800.ducktales.rendering.sprites.SpritesFactory;
import uq.deco2800.ducktales.resources.ResourceInfoRegister;
import uq.deco2800.ducktales.resources.ResourceType;
import uq.deco2800.ducktales.util.SecondaryManager;
import uq.deco2800.ducktales.util.exceptions.AnimalNotRegisteredException;
import uq.deco2800.ducktales.util.exceptions.DroppableResourceNotRegisteredException;
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
    private List<DroppedResourceSprite> resourceSprites;
    
    /** The animal manager */
    private AnimalManager animalManager;

    /**
     * Instantiate an empty resource manager
     */
    public ResourceEntityManager() {
        resourceSprites = new ArrayList<DroppedResourceSprite>();
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
        // Construct a new droppable resource from the given type
        DroppableResourceEntity resource = ResourceInfoRegister.createDroppableResource(type, x, y);

        // check if the droppable resource has been registered
        if (resource != null) {
            if (this.gameManager != null){
                resource.setGameManager(this.gameManager);
            } else {
                throw new GameSetupException("Droppable resource class does not have" +
                        "a reference of Game Manager yet");
            }

            // Add that droppable resource to the droppable resource list
            world.addDroppedResoure(resource); 

            // Add the sprite of the resource to the sprites list, and set
            // the position of that sprite
            DroppedResourceSprite sprite = SpritesFactory.createDroppableResourceSprite(type);	
                    
            if (sprite == null) {
                throw new GameSetupException("Sprite of type " + type +
                        " is not yet registered in SpritesFactory");
            }

            // Setup the sprite
            Sprite.setupEntitySprite(sprite, x, y,
                    gameManager.getWorldDisplayManager().getTilesManager());

            // Add the sprite to the array list
            resourceSprites.add(sprite);

            // Add the sprite to the world display
            gameManager.getWorldDisplayManager().getWorldDisplay()
                    .getChildren().add(sprite);

        } else {
            throw new DroppableResourceNotRegisteredException("The droppable resource requested" +
                    " is not yet registered in ResourceInfoRegister");
        }
	}
}
