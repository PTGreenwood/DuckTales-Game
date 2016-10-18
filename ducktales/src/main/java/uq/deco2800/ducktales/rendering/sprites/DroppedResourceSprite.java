package uq.deco2800.ducktales.rendering.sprites;

import uq.deco2800.ducktales.resources.ResourceType;

/**
 * This class represents the sprite of a resource that will be dropped
 * by an animal into the world
 * 
 * @author Damian Maher
 */
public class DroppedResourceSprite extends EntitySprite {
	
	// the resourceType of the dropped resource
	private ResourceType droppableResourceType;
	
    /**
     * Creates a sprite for a dropped resource.
     * @param index
     *         The unique ID of this sprite.
     * @param droppedResourceType
     *         The ResourceType of this dropped resource.
     */
	public DroppedResourceSprite (ResourceType droppedResourceType) {
		this.droppableResourceType = droppedResourceType;
	}
}
