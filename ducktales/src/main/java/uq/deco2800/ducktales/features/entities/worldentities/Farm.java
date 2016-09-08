package uq.deco2800.ducktales.features.entities.worldentities;

import uq.deco2800.ducktales.resources.ResourceType;

/**
 * A Farm.
 * 
 * @author Gabrielle Hodge, 43590526 
 *
 */
public class Farm extends Building {
	

	// BuildingMenuSprite type
	private static final ResourceType TYPE = ResourceType.FARM;

	/**
	 * Initialise a new farm. Requires the location of the farm 
	 *  to be passed.
	 * @param x, x location of the building
	 * @param y, y location of the building
	 */
	public Farm(double x, double y) {
		super(x, y, 5, 5, TYPE);
	}
	
	/**
	 * Update the WorldEntity properties with those of a farm.
	 */
	protected void specifications() {
		Building.STONERESOURCES = 8;
		Building.WOODRESOURCES = 10;
		Building.TIME = 9;
		Building.PRODUCTIONTYPE = production.FOOD;
		Building.PRODUCTIONAMOUNT = 5;
	}

	/**
	 * Method to update farm at each discrete simulation step.
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
