package uq.deco2800.ducktales.features.entities.worldentities;

import uq.deco2800.ducktales.resources.ResourceType;

/**
 * A Farm. Class containing all properties and specifications of a 
 * farm.
 * 
 * @author Gabrielle Hodge, 43590526 
 *
 */
public class Farm extends Building {
	

	// BuildingMenuSprite type
	private static final ResourceType TYPE = ResourceType.FARM;

	// Size of the building
	private static final int X_LENGTH = 5;
	private static final int Y_LENGTH = 5;
	
	/**
	 * Initialise a new farm. Requires the location of the farm 
	 *  to be passed.
	 * @param x, x location of the building
	 * @param y, y location of the building
	 */
	public Farm(double x, double y) {
		super(x, y, X_LENGTH, Y_LENGTH, TYPE);
	}
	
	/**
	 * Update the WorldEntity properties with those of a farm.
	 */
	protected void specifications() {
		specifications(8, 10, 9, production.FOOD, 5);
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
