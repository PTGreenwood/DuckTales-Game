package uq.deco2800.ducktales.entities.worldentities;

import uq.deco2800.ducktales.resources.ResourceType;

/**
 * A Farmhouse.
 * 
 * @author Gabrielle Hodge, 43590526 
 *
 */
public class Farmhouse extends Building {
	

	// BuildingMenuSprite type
	private static final ResourceType TYPE = ResourceType.FARMHOUSE;

	/**
	 * Initialise a new farmhouse. Requires the location of the farmhouse 
	 *  to be passed.
	 * @param x, x location of the building
	 * @param y, y location of the building
	 */
	public Farmhouse(double x, double y) {
		super(x, y, 2, 2, TYPE);
	}
	
	/**
	 * Update the WorldEntity properties with those of a farmhouse.
	 */
	protected void specifications() {
		Building.STONERESOURCES = 8;
		Building.WOODRESOURCES = 10;
		Building.TIME = 9;
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
