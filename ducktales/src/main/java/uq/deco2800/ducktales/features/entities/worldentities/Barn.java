package uq.deco2800.ducktales.features.entities.worldentities;

import uq.deco2800.ducktales.resources.ResourceType;

/**
 * A Barn. Class containing all properties and specifications of a 
 * barn.
 * 
 * @author Gabrielle Hodge, 43590526 
 *
 */
public class Barn extends Building {

	// BuildingMenuSprite type
	private static final ResourceType TYPE = ResourceType.BARN;
	
	// Building health - starting value
	private int health = 900;
	
	// Barn size
	public static final int X_LENGTH = 2;
	public static final int Y_LENGTH = 2;
	
	public static final boolean PASSABILITY = false;
	
	/**
	 * Initialise a new barn. Requires the location of the barn
	 *  to be passed. Location of the barn must fall within the world, 
	 *  and be unoccupied.
	 * @param x, x location of the building, must be within the bounds 
	 * of the world, and not have another building occupying the location.
	 * @param y, y location of the building. must be within the bounds 
	 * of the world, and not have another building occupying the location.
	 */
	public Barn(double x, double y) {
		super(x, y, X_LENGTH, Y_LENGTH, TYPE);
		health = 900;
	}
	
	/**
	 * Update the WorldEntity properties with those of a barn.
	 */
	protected void specifications() {
		specifications(4, 10, 9, health);
	}
	
	/**
	 * Update the 'health' of the barn. Requires an integer value of 
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
