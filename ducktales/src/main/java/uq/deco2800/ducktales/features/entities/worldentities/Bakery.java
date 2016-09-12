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

	/** The length of this building */
	public static final int X_LENGTH = 2;
	public static final int Y_LENGTH = 2;

	/** The passability of this building */
	public static final boolean PASSABLILITY = false;

	/**
	 * Initialise a new bakery. Requires the location of the bakery
	 *  to be passed.
	 * @param x, x location of the building
	 * @param y, y location of the building
	 */
	public Bakery(double x, double y) {
		super(x, y, X_LENGTH, Y_LENGTH, TYPE);
		specifications();
	}
	
	/**
	 * Update the WorldEntity properties with those of a bakery.
	 */
	protected void specifications() {
		specifications(4, 6, 4, production.NULL, 0);
	}

	/**
	 * Method to update bakery at each discrete simulation step.
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
