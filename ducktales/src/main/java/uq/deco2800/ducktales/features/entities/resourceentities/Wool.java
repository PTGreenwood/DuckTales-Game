package uq.deco2800.ducktales.features.entities.resourceentities;

import uq.deco2800.ducktales.resources.ResourceType;

/**
 * A class which represent a droppable resource (wool) by sheep.
 * 
 * @author Jake Wood & Damian Maher
 */

public class Wool extends DroppableResourceEntity {

	// the resourceType of the wool
	private ResourceType type;

	// the x location of the wool
	private int x;

	// the y location of the wool
	private int y;

	/**
	 * The main constructor for the Feather class
	 * 
	 * @param x,
	 *            the x location of the wool
	 * @param y,
	 *            the y location of the wool
	 * @param type,
	 *            the resource type of the wool
	 */
	public Wool(ResourceType type, int x, int y) {
		super(x, y, type);
		this.type = type;
		this.x = x;
		this.y = y;
	}
}
