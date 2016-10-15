package uq.deco2800.ducktales.features.entities.resourceentities;

import java.util.ArrayList;
import java.util.List;

import uq.deco2800.ducktales.rendering.sprites.Sprite;
import uq.deco2800.ducktales.resources.ResourceType;

/**
 * Manager for all the resource entities in the game.
 *
 * @author Damian Maher
 */
public class ResourceEntityManager {
    /** The list of resource sprites */
    private List<Sprite> resourceSprites;

    /**
     * Instantiate an empty resource manager
     */
    public ResourceEntityManager() {
        resourceSprites = new ArrayList<>(50);
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
		// TO BE COMPLETED
	}
}
