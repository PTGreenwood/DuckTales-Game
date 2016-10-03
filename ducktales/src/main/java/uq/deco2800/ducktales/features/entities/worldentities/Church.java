package uq.deco2800.ducktales.features.entities.worldentities;

import uq.deco2800.ducktales.resources.ResourceType;

/**
 * A Church. Class containing all properties and specifications of a 
 * church.
 * 
 * @author Gabrielle Hodge, 43590526 
 *
 */
public class Church extends Building {

	// BuildingMenuSprite type
	private static final ResourceType TYPE = ResourceType.CHURCH;
	
	// Building health - starting value
	private int health = 1900;
	
	// Size of a church
	public static final int X_LENGTH = 2;
	public static final int Y_LENGTH = 2;
	
	public static final boolean PASSABILITY = false;
	
	/**
	 * Initialise a new church. Requires the location of the church
	 *  to be passed.
	 * @param x, x location of the building
	 * @param y, y location of the building
	 */
	public Church(double x, double y) {
		super(x, y, X_LENGTH, Y_LENGTH, TYPE);
		health = 1900;
	}
	
	/**
	 * Update the WorldEntity properties with those of a church.
	 */
	protected void specifications() {
		specifications(8, 10, 9, production.NULL, 0, health);
	}
	
	/**
	 * Update the 'health' of the church. Requires an integer value of 
	 * the new health to be passed.
	 * 
	 * @param NewValue, new health of the building
	 */
	protected void changeHealthBuilding(int newValue){
		health = newValue;
	}
}
