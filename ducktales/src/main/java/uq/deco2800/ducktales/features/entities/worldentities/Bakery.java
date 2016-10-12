package uq.deco2800.ducktales.features.entities.worldentities;

import uq.deco2800.ducktales.resources.ResourceType;
import static uq.deco2800.ducktales.resources.ResourceType.*;

/**
 * A Bakery. Class containing all properties and specifications of a 
 * bakery.
 * 
 * @author Gabrielle Hodge, 43590526
 *
 */
public class Bakery extends Building {
	
	/** The type of this building */
	private static final ResourceType TYPE = BAKERY;

	// Building health - starting value
	private int health = 850;
	
	/** The length of this building */
	public static final int X_LENGTH = 2;
	public static final int Y_LENGTH = 2;

	/** The passability of this building */
	public static final boolean PASSABLILITY = false;

	/**
	 * Initialise a new bakery. Requires the location of the bakery
	 *  to be passed. Location of the bakery must fall within the world, 
	 *  and be unoccupied.
	 * @param x, x location of the building, must be within the bounds 
	 * of the world, and not have another building occupying the location.
	 * @param y, y location of the building. must be within the bounds 
	 * of the world, and not have another building occupying the location.
	 */
	public Bakery(double x, double y) {
		super(x, y, X_LENGTH, Y_LENGTH, TYPE);
		health = 850;
	}
	
	/**
	 * Update the WorldEntity properties with those of a bakery.
	 */
	protected void specifications() {
		specifications(4, 6, 4, production.NULL, 0, health);
	}
	
	/**
	 * Update the 'health' of the bakery. Requires an integer value of 
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
	 * class. Possible use to extand/upgrade a bakery.
	 * 
	 * @throws UnsupportedOperationException, as this functionality is not 
	 * required for a bakery.
	 */
	protected void upgradeProduceBuilding(int newValue) {
		throw new UnsupportedOperationException();
	}
}
