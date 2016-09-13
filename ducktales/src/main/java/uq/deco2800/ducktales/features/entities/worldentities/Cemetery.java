package uq.deco2800.ducktales.features.entities.worldentities;

import uq.deco2800.ducktales.resources.ResourceType;

/**
 * A Cemetery. Class containing all properties and specifications of a 
 * cemetery.
 * 
 * @author Gabrielle Hodge, 43590526 
 *
 */
public class Cemetery extends Building {
	

	// BuildingMenuSprite type
	private static final ResourceType TYPE = ResourceType.CEMETERY;

	// Building health - starting value
	private static int health = 500;
	
	// Size of a cemetery
	public static final int X_LENGTH = 2;
	public static final int Y_LENGTH = 2;
	public static final boolean PASSABILITY = false;
	
	/**
	 * Initialise a new cemetery. Requires the location of the cemetery
	 *  to be passed.
	 * @param x, x location of the building
	 * @param y, y location of the building
	 */
	public Cemetery(double x, double y) {
		super(x, y, X_LENGTH, Y_LENGTH, TYPE);
		health = 500;
	}
	
	/**
	 * Update the WorldEntity properties with those of a cemetery.
	 */
	protected void specifications() {
		specifications(2, 4, 2, production.NULL, 0, health);
	}
	
	/**
	 * Update the 'health' of the cemetery. Requires an integer value of 
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
	 * Method to update cemetery at each discrete simulation step.
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
