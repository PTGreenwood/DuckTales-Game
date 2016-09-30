package uq.deco2800.ducktales.features.entities.worldentities;

import uq.deco2800.ducktales.resources.ResourceType;

/**
 * A Pasture. Class containing all properties and specifications of a 
 * pasture.
 * 
 * @author Gabrielle Hodge, 43590526 
 *
 */
public class Pasture extends Building {

	// BuildingMenuSprite type
	private static final ResourceType TYPE = ResourceType.PASTURE;
	
	// Building health - starting value
	private int health = 800;
	
	// Size of the pasture
	public static final int X_LENGTH = 5;
	public static final int Y_LENGTH = 5;
	public static final boolean PASSABILITY = true;
	
	/**
	 * Initialise a new pasture. Requires the location of the pasture
	 *  to be passed.
	 * @param x, x location of the building
	 * @param y, y location of the building
	 */
	public Pasture(double x, double y) {
		super(x, y, X_LENGTH, Y_LENGTH, TYPE);
		health = 800;
	}
	
	/**
	 * Update the WorldEntity properties with those of a pasture.
	 */
	protected void specifications() {
		specifications(2, 10, 4, production.NULL, 0, health);
	}
	
	/**
	 * Update the 'health' of the pasture. Requires an integer value of 
	 * the new health to be passed.
	 * 
	 * @param NewValue, new health of the building
	 */
	protected void changeHealthBuilding(int newValue){
		health = newValue;
	}
}
