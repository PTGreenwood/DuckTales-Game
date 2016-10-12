package uq.deco2800.ducktales.features.entities.worldentities;

import uq.deco2800.ducktales.resources.ResourceType;

/**
 * An Observatory. Class containing all properties and specifications of an 
 * observatory.
 * 
 * @author Gabrielle Hodge, 43590526 
 *
 */
public class Observatory extends Building {

	// BuildingMenuSprite type
	private static final ResourceType TYPE = ResourceType.OBSERVATORY;
	
	// Building health - starting value
	private int health = 900;
	
	// Size of the observatory
	public static final int X_LENGTH = 2;
	public static final int Y_LENGTH = 2;
	
	public static final boolean PASSABILITY = false;

	/**
	 * Initialise a new observatory. Requires the location of the observatory 
	 *  to be passed.Location of the observatory must fall within the world, 
	 *  and be unoccupied.
	 * @param x, x location of the building, must be within the bounds 
	 * of the world, and not have another building occupying the location.
	 * @param y, y location of the building. must be within the bounds 
	 * of the world, and not have another building occupying the location.
	 */
	public Observatory(double x, double y) {
		super(x, y, X_LENGTH, Y_LENGTH, TYPE);
		health = 900;
	}
	
	/**
	 * Update the WorldEntity properties with those of an observatory.
	 */
	protected void specifications() {
		specifications(4, 10, 5, production.NULL, 0, health);
	}
	
	/**
	 * Update the 'health' of the observatory. Requires an integer value of 
	 * the new health to be passed. The health of the building will be 
	 * greater than or equal to 0.
	 * 
	 * @param NewValue, new health of the building, will update the 
	 *  health to newValue, or 0 if newValue is <0
	 */
	protected void changeHealthBuilding(int newValue){
		health = newValue;
	}
	
	/**
	 * Upgrade produce for building, required for all buildings, by Building 
	 * class. Possible use to extand/upgrade observatories.
	 * 
	 * @throws UnsupportedOperationException, as this functionality is not 
	 * needed for an observatory.
	 */
	protected void upgradeProduceBuilding(int newValue) {
		throw new UnsupportedOperationException();
	}
}
