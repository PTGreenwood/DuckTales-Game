package uq.deco2800.ducktales.features.entities.resourceentities;

import uq.deco2800.ducktales.resources.ResourceType;

/**
 * This class represents meat which is the subclass of Food. Created by Ben on
 * 22/10/16.
 * 
 * @author Benson
 */
public class Meat extends Food {
	/**
	 * The main constructor of the meat class.
	 *
	 * @param x,
	 *            the x location of the meat
	 * @param y,
	 *            the y location of the meat
	 * @param type,
	 *            the resource type of the meat
	 */
	public Meat(int x, int y, ResourceType type) {
		super(x, y, type);

	}
}
