package uq.deco2800.ducktales.features.entities.worldentities;

import uq.deco2800.ducktales.features.entities.worldentities.Building.production;
import uq.deco2800.ducktales.resources.ResourceType;

/**
 * An Observatory.
 * 
 * @author Gabrielle Hodge, 43590526 
 *
 */
public class Observatory extends Building {

	// BuildingMenuSprite type
	private static final ResourceType TYPE = ResourceType.OBSERVATORY;
	
	private static final int X_LENGTH = 2;
	private static final int Y_LENGTH = 2;

	/**
	 * Initialise a new observatory. Requires the location of the observatory 
	 *  to be passed.
	 * @param x, x location of the building
	 * @param y, y location of the building
	 */
	public Observatory(double x, double y) {
		super(x, y, X_LENGTH, Y_LENGTH, TYPE);
	}
	
	/**
	 * Update the WorldEntity properties with those of a bakery.
	 */
	protected void specifications() {
		Building.STONERESOURCES = 4;
		Building.WOODRESOURCES = 10;
		Building.TIME = 5;
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
