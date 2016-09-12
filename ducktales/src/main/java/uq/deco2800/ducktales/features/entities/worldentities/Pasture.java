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
	}
	
	/**
	 * Update the WorldEntity properties with those of a pasture.
	 */
	protected void specifications() {
		specifications(2, 10, 4, production.NULL, 0);
	}
	
	/**
	 * Method to update pasture at each discrete simulation step.
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
