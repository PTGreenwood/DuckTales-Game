package uq.deco2800.ducktales.features.entities.worldentities;

import uq.deco2800.ducktales.resources.ResourceType;

/**
 * Representation of a longer box.
 * @author Leggy
 *
 */
public class LongBox extends Building {
	
	// BuildingMenuSprite type
	private static final ResourceType TYPE = ResourceType.LONG_BOX;
	
	// Building health - starting value
	private int health = 600;
	
	// Long Box size
	public static final int X_LENGTH = 2;
	public static final int Y_LENGTH = 1;
	
	public static final boolean PASSABILITY = false;

	/**
	 * Initialise a new long box. Requires the location of the long box
	 *  to be passed. Location of the longbox must fall within the world, 
	 *  and be unoccupied.
	 * @param x, x location of the building, must be within the bounds 
	 * of the world, and not have another building occupying the location.
	 * @param y, y location of the building. must be within the bounds 
	 * of the world, and not have another building occupying the location.
	 */
	public LongBox(int x, int y) {
		super(x, y, X_LENGTH, Y_LENGTH, TYPE);
		health = 600;
	}

	/**
	 * Update the WorldEntity properties with those of a long box.
	 */
	protected void specifications() {
		specifications(2, 2, 2, health);
	}
	
	/**
	 * Update the 'health' of the long box. Requires an integer value of 
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
