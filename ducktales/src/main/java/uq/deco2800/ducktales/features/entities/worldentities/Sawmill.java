package uq.deco2800.ducktales.features.entities.worldentities;

import uq.deco2800.ducktales.resources.ResourceType;

/**
 * A Sawmill. Class containing all properties and specifications of a 
 * sawmill.
 * 
 * @author Gabrielle Hodge, 43590526 
 *
 */
public class Sawmill extends Building {
	
	// BuildingMenuSprite type
	private static final ResourceType TYPE = ResourceType.SAWMILL;
	
	// Building health - starting value
	private static int health = 1400;
	
	// Sawmill size
	private static final int X_LENGTH = 5;
	private static final int Y_LENGTH = 5;

	/**
	 * Initialise a new sawmill. Requires the location of the sawmill
	 *  to be passed.
	 * @param x, x location of the building
	 * @param y, y location of the building
	 */
	public Sawmill(double x, double y) {
		super(x, y, X_LENGTH, Y_LENGTH, TYPE);
		health = 1400;
	}

	/**
	 * Update the WorldEntity properties with those of a sawmill.
	 */
	protected void specifications() {
		specifications(4, 8, 3, production.WOOD, 5, health);
	}
	
	/**
	 * Update the 'health' of the sawmill. Requires an integer value of 
	 * the new health to be passed.
	 * 
	 * @param NewValue, new health of the building
	 */
	public void ChangeHealth(int newValue){
		if (newValue > 0){
			health = newValue;
		}
	}
	
	/**
	 * Method to update a sawmill at each discrete simulation step.
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
