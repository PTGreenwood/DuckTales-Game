package uq.deco2800.ducktales.features.entities.resourceentities;

import uq.deco2800.ducktales.resources.ResourceType;

/**
 * This class will represent a resource entity that can be dropped by an animal
 *
 * @author Damian Maher
 */
public class DroppableResourceEntity extends ResourceEntity {
	/**
	 * main constructor of the DroppableResourceEntity class
	 * 
	 * @param x, the x location of the entity
	 * @param y, the y location of the entity
	 * @param type, the ResourceType of the entity
	 */
	public DroppableResourceEntity(int x, int y, ResourceType type) {
		super(x, y, 1, 1, type, DEFVALUE);
	}
	
	/**
	 * required implementation of the tick method
	 */
	@Override
	public void tick() {		
	}

	/**
	 * required implementation of the ispassable method
	 */
	@Override
	public boolean isPassable() {
		return false;
	}
}
