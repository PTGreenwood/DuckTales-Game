package uq.deco2800.ducktales.features.entities.worldentities;

import uq.deco2800.ducktales.resources.ResourceType;

/**
 * A School. Class containing all properties and specifications of a 
 * school.
 * 
 * @author Gabrielle Hodge, 43590526 
 *
 */
public class School extends Building {

	// BuildingMenuSprite type
	private static final ResourceType TYPE = ResourceType.SCHOOL;
	
	// Building health - starting value
	private int health = 1000;
	
	// Size of the pasture
	public static final int X_LENGTH = 5;
	public static final int Y_LENGTH = 5;
	public static final boolean PASSABILITY = true;
	
	/**
	 * Initialise a new school. Requires the location of the school
	 *  to be passed. Location of the school must fall within the world, 
	 *  and be unoccupied.
	 * @param x, x location of the building, must be within the bounds 
	 * of the world, and not have another building occupying the location.
	 * @param y, y location of the building. must be within the bounds 
	 * of the world, and not have another building occupying the location.
	 */
	public School(double x, double y) {
		super(x, y, X_LENGTH, Y_LENGTH, TYPE);
		health = 1000;
	}
	
	/**
	 * Update the WorldEntity properties with those of a school.
	 */
	protected void specifications() {
		specifications(6, 8, 8, health);
	}
	
	/**
	 * Update the 'health' of the school. Requires an integer value of 
	 * the new health to be passed. The health of the building will be 
	 * greater than or equal to 0.
	 * 
	 * @param NewValue, new health of the building, will update the 
	 *  health to newValue, or 0 if newValue is <0
	 */
	protected void changeHealthBuilding(int newValue){
		health = newValue;
	}
}
