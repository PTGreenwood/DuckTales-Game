package uq.deco2800.ducktales.features.entities.worldentities;

import uq.deco2800.ducktales.resources.ResourceType;

/**
 * A Forge.
 * 
 * @author Gabrielle Hodge, 43590526 
 *
 */
public class Forge extends Building {
	
	// BuildingMenuSprite type
	private static final ResourceType TYPE = ResourceType.FORGE;

	private static final int X_LENGTH = 2;
	private static final int Y_LENGTH = 2;
	
	/**
	 * Initialise a new forge. Requires the location of the forge
	 *  to be passed.
	 * @param x, x location of the building
	 * @param y, y location of the building
	 */
	public Forge(double x, double y) {
		super(x, y, X_LENGTH, Y_LENGTH, TYPE);
	}
	
	/**
	 * Update the WorldEntity properties with those of a bakery.
	 */
	protected void specifications() {
		Building.STONERESOURCES = 10;
		Building.WOODRESOURCES = 6;
		Building.TIME = 3;
		Building.PRODUCTIONTYPE = production.NULL;
		Building.PRODUCTIONAMOUNT = 0;
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
