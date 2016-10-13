package uq.deco2800.ducktales.features.entities.resourceentities;

import java.util.ArrayList;

import uq.deco2800.ducktales.features.entities.EntityManager;
import uq.deco2800.ducktales.resources.ResourceType;

/**
 * Manager for all the resource entities in the game.
 *
 * @author Damian Maher
 */
public class ResourceEntityManager extends EntityManager {
	
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
	public void dropResource(ResourceType type, int x, int y, ArrayList<ResourceType> registeredResources) {
		
	}
}
