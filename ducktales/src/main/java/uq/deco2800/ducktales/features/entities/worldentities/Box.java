package uq.deco2800.ducktales.features.entities.worldentities;

import uq.deco2800.ducktales.resources.ResourceType;

/**
 * Representation of a basic box. Class containing all properties and 
 * specifications of a box.
 * 
 * @author Leggy
 *
 */
public class Box extends Building {

	// BuildingMenuSprite type
	private static final ResourceType TYPE = ResourceType.BOX;

	// Building health - starting value
	private int health = 400;
	
	// Size of a box
	public static final int X_LENGTH = 1;
	public static final int Y_LENGTH = 1;
	
	public static final boolean PASSABILITY = false;
	
	/**
	 * Initialise a new box. Requires the location of the box
	 *  to be passed.
	 * @param x, x location of the building
	 * @param y, y location of the building
	 */
	public Box(int x, int y) {
		super(x, y, X_LENGTH, Y_LENGTH, TYPE);
		health = 400;
	}
	
	/**
	 * Update the WorldEntity properties with those of a box.
	 */
	protected void specifications() {
		specifications(2, 2, 4, production.NULL, 0, health);
	}
	
	/**
	 * Update the 'health' of the box. Requires an integer value of 
	 * the new health to be passed.
	 * 
	 * @param NewValue, new health of the building
	 */
	protected void changeHealthBuilding(int newValue){
		health = newValue;
	}
}
