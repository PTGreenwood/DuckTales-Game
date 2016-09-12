package uq.deco2800.ducktales.features.entities.worldentities;

import uq.deco2800.ducktales.features.entities.worldentities.Building.production;
import uq.deco2800.ducktales.resources.ResourceType;

/**
 * Representation of a longer box.
 * @author Leggy
 *
 */
public class LongBox extends Building {
	
	// BuildingMenuSprite type
	private static final ResourceType TYPE = ResourceType.LONG_BOX;
	
	private static final int X_LENGTH = 2;
	private static final int Y_LENGTH = 1;

	/**
	 * Initialise a new long box. Requires the location of the long box
	 *  to be passed.
	 * @param x, x location of the building
	 * @param y, y location of the building
	 */
	public LongBox(int x, int y) {
		super(x, y, X_LENGTH, Y_LENGTH, TYPE);
	}

	/**
	 * Update the WorldEntity properties with those of a bakery.
	 */
	protected void specifications() {
		Building.STONERESOURCES = 2;
		Building.WOODRESOURCES = 2;
		Building.TIME = 2;
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
