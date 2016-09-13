package uq.deco2800.ducktales.features.entities.worldentities;

import uq.deco2800.ducktales.resources.ResourceType;

/**
 * An Observatory. Class containing all properties and specifications of an 
 * observatory.
 * 
 * @author Gabrielle Hodge, 43590526 
 *
 */
public class Observatory extends Building {

	// BuildingMenuSprite type
	private static final ResourceType TYPE = ResourceType.OBSERVATORY;
	
	// Building health - starting value
	private static int health = 900;
	
	// Size of the observatory
	private static final int X_LENGTH = 2;
	private static final int Y_LENGTH = 2;

	/**
	 * Initialise a new observatory. Requires the location of the observatory 
	 *  to be passed.
	 * @param x, x location of the building
	 * @param y, y location of the building
	 */
	public Observatory(double x, double y) {
		super(x, y, X_LENGTH, Y_LENGTH, TYPE);
		health = 900;
	}
	
	/**
	 * Update the WorldEntity properties with those of an observatory.
	 */
	protected void specifications() {
		specifications(4, 10, 5, production.NULL, 0, health);
	}
	
	/**
	 * Update the 'health' of the observatory. Requires an integer value of 
	 * the new health to be passed.
	 * 
	 * @param NewValue, new health of the building
	 */
	protected void changeHealthBuilding(int newValue){
		health = newValue;
	}

	/**
	 * Method to update the observatory at each discrete simulation step.
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
