package uq.deco2800.ducktales.features.entities.worldentities;

import uq.deco2800.ducktales.features.entities.worldentities.Building.production;
import uq.deco2800.ducktales.resources.ResourceType;

/**
 * A Church.
 * 
 * @author Gabrielle Hodge, 43590526 
 *
 */
public class Church extends Building {

	// BuildingMenuSprite type
	private static final ResourceType TYPE = ResourceType.CHURCH;
	
	private static final int X_LENGTH = 2;
	private static final int Y_LENGTH = 2;
	
	/**
	 * Initialise a new barn. Requires the location of the church
	 *  to be passed.
	 * @param x, x location of the building
	 * @param y, y location of the building
	 */
	public Church(double x, double y) {
		super(x, y, X_LENGTH, Y_LENGTH, TYPE);
		
	}
	
	/**
	 * Update the WorldEntity properties with those of a church.
	 */
	protected void specifications() {
		Building.STONERESOURCES = 8;
		Building.WOODRESOURCES = 10;
		Building.TIME = 9;
		Building.PRODUCTIONTYPE = production.NULL;
		Building.PRODUCTIONAMOUNT = 0;
	}
	
	/**
	 * Method to update CHURCH at each discrete simulation step.
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
