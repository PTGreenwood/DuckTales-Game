package uq.deco2800.ducktales.features.entities.resourceentities;

import uq.deco2800.ducktales.resources.ResourceType;

/**
 * A class which represent a droppable resource (a feather) by the duck
 * 
 * @author Damian Maher
 */

public class Feather extends DroppableResourceEntity {
	/**
	 * The main constructor for the Feather class
	 * 
	 * @param x, the x location of the feather
	 * @param y, the y location of the feather
	 * @param type, the resource type of the feather
	 */
	public Feather(int x, int y, ResourceType type) {
		super(x, y, type);
	}
}
