package uq.deco2800.ducktales.features.entities.worldentities;

import uq.deco2800.ducktales.resources.ResourceType;

/**
 * A Quarry.
 * 
 * @author Gabrielle Hodge, 43590526 
 *
 */
public class Quarry extends Building {

	// BuildingMenuSprite type
	private static final ResourceType TYPE = ResourceType.QUARRY;
	
	
	/**
	 * Initialise a new quarry. Requires the location of the quarry
	 *  to be passed.
	 * @param x, x location of the building
	 * @param y, y location of the building
	 */
	public Quarry(double x, double y) {
		super(x, y, 5, 5, TYPE);
		
	}
	
	/**
	 * Update the WorldEntity properties with those of a quarry.
	 */
	protected void specifications() {
		Building.STONERESOURCES = 8;
		Building.WOODRESOURCES = 6;
		Building.TIME = 5;
		Building.PRODUCTIONTYPE = production.STONE;
		Building.PRODUCTIONAMOUNT = 5;
	}
	
	/**
	 * Method to update quarry at each discrete simulation step.
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
