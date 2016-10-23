package uq.deco2800.ducktales.features.entities.resourceentities;

import uq.deco2800.ducktales.resources.ResourceType;

/**
 * A class which represent the general food class. Created by Ben on 21/10/16.
 * 
 * @author Benson
 * 
 */
public class Food extends ResourceEntity {

	/**
	 * Initialise a new food. Requires the location of the food to be passed.
	 *
	 * @param x,
	 *            x location of the food
	 * @param y,
	 *            y location of the food
	 */
	public Food(int x, int y, ResourceType type) {
		super(x, y, 1, 1, type, defaultValue);
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
