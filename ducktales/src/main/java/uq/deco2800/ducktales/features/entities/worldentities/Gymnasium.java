package uq.deco2800.ducktales.features.entities.worldentities;

import uq.deco2800.ducktales.resources.ResourceType;

/**
 * A Gymnasium. Class containing all properties and specifications of a 
 * Gymnasium.
 * 
 * @author Gabrielle Hodge, 43590526 
 *
 */
public class Gymnasium extends Building {

	// BuildingMenuSprite type
	private static final ResourceType TYPE = ResourceType.GYMNASIUM;
	
	// Building health - starting value
	private int health = 900;
	
	// Size of a church
	public static final int X_LENGTH = 2;
	public static final int Y_LENGTH = 2;
	
	public static final boolean PASSABILITY = false;
	
	/**
	 * Initialise a new gymnasium. Requires the location of the gymnasium
	 *  to be passed. Location of the gymnasium must fall within the world, 
	 *  and be unoccupied.
	 * @param x, x location of the building, must be within the bounds 
	 * of the world, and not have another building occupying the location.
	 * @param y, y location of the building. must be within the bounds 
	 * of the world, and not have another building occupying the location.
	 */
	public Gymnasium(double x, double y) {
		super(x, y, X_LENGTH, Y_LENGTH, TYPE);
		health = 900;
	}
	
	/**
	 * Update the WorldEntity properties with those of a gymnasium.
	 */
	protected void specifications() {
		specifications(8, 6, 6, health);
	}
	
	/**
	 * Update the 'health' of the gymnasium. Requires an integer value of 
	 * the new health to be passed. Requires an integer value of 
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
