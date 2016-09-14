package uq.deco2800.ducktales.features.entities.worldentities;

import uq.deco2800.ducktales.resources.ResourceType;

/**
 * A Butcher. Class containing all properties and specifications of a 
 * butcher.
 * 
 * @author Gabrielle Hodge, 43590526 
 *
 */
public class Butcher extends Building {

	// BuildingMenuSprite type
	private static final ResourceType TYPE = ResourceType.BUTCHER;
	
	// Building health - starting value
	private int health = 750;
	
	// Building size
	public static final int X_LENGTH = 2;
	public static final int Y_LENGTH = 2;
	public static final boolean PASSABILITY = false;
	
	/**
	 * Initialise a new butcher. Requires the location of the butcher 
	 *  to be passed.
	 * @param x, x location of the building
	 * @param y, y location of the building
	 */
	public Butcher(double x, double y) {
		super(x, y, X_LENGTH, Y_LENGTH, TYPE);
		health = 750;
	}
	
	/**
	 * Update the WorldEntity properties with those of a butcher.
	 */
	protected void specifications() {
		specifications(4, 8, 7, production.NULL, 0, health);
	}
	
	/**
	 * Update the 'health' of the butcher. Requires an integer value of 
	 * the new health to be passed.
	 * 
	 * @param NewValue, new health of the building
	 */
	protected void changeHealthBuilding(int newValue){
		health = newValue;
	}
	
	/**
	 * Method to update butcher at each discrete simulation step.
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
