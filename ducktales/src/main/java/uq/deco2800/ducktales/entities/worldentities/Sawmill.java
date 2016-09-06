package uq.deco2800.ducktales.entities.worldentities;

import uq.deco2800.ducktales.resources.ResourceType;

/**
 * A Sawmill.
 * 
 * @author Gabrielle Hodge, 43590526 
 *
 */
public class Sawmill extends Building {
	
	// BuildingMenuSprite type
	private static final ResourceType TYPE = ResourceType.SAWMILL;

	/**
	 * Initialise a new sawmill. Requires the location of the sawmill
	 *  to be passed.
	 * @param x, x location of the building
	 * @param y, y location of the building
	 */
	public Sawmill(double x, double y) {
		super(x, y, 2, 2, TYPE);
	}

	/**
	 * Update the WorldEntity properties with those of a bakery.
	 */
	protected void specifications() {
		Building.STONERESOURCES = 4;
		Building.WOODRESOURCES = 8;
		Building.TIME = 3;
	}
	
	/**
	 * Method to update bakery at each discrete simulation step.
	 * 
	 * Note sure if any implementation will be used. To be determined later
	 * May implement for only some of the classes (hence left in the individual 
	 * buildings class files).
	 */
	@Override
	public void tick() {
		// To be implemented if there is to be animation of construction
	}

}
