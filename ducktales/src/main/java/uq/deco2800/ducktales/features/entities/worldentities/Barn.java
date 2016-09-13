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
	private static int health = 900;
	
	// Barn size
	public static final int X_LENGTH = 2;
	public static final int Y_LENGTH = 2;
	public static final boolean PASSABILITY = false;
	
	/**
	 * Initialise a new barn. Requires the location of the barn
	 *  to be passed.
	 * @param x, x location of the building
	 * @param y, y location of the building
	 */
	public Barn(double x, double y) {
		super(x, y, X_LENGTH, Y_LENGTH, TYPE);
		health = 900;
	}
	
	/**
	 * Update the WorldEntity properties with those of a barn.
	 */
	protected void specifications() {
		specifications(4, 10, 9, production.NULL, 0);
	}
	
	/**
	 * Update the 'health' of the barn. Requires an integer value of 
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
	 * Method to access the 'health' of the barn. Returns the integer 
	 * value of the health.
	 * 
	 * @return the health of the barn.
	 */
	public int GetHealth(){
		return health;
	}
	
	/**
	 * Method to update the barn at each discrete simulation step.
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
