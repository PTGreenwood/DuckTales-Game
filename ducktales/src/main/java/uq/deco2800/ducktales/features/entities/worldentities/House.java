package uq.deco2800.ducktales.features.entities.worldentities;

import uq.deco2800.ducktales.resources.ResourceType;

/**
 * A House.
 * 
 * @author Leggy
 *
 */
public class House extends Building {
	
	// BuildingMenuSprite type
	private static final ResourceType TYPE = ResourceType.HOUSE;

	// Building health - starting value
	private int health = 1000;
	
	// Building size
	public static final int X_LENGTH = 2;
	public static final int Y_LENGTH = 2;
	
	public static final boolean PASSABILITY = true;

	/**
	 * Initialise a new house. Requires the location of the house
	 *  to be passed.
	 * @param x, x location of the building
	 * @param y, y location of the building
	 */
	public House(double x, double y) {
		super(x, y, X_LENGTH, Y_LENGTH, TYPE);
		health = 1000;
	}
		
	/**
	 * Update the WorldEntity properties with those of a house.
	 */
	protected void specifications() {
		specifications(2, 4, 2, production.NULL, 0, health);
	}
	
	/**
	 * Update the 'health' of the house. Requires an integer value of 
	 * the new health to be passed.
	 * 
	 * @param NewValue, new health of the building
	 */
	protected void changeHealthBuilding(int newValue){
		health = newValue;
	}

	/**
	 * Method to update a house at each discrete simulation step.
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
