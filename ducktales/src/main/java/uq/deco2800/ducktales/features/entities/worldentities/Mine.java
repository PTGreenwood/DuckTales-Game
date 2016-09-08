package uq.deco2800.ducktales.features.entities.worldentities;

import uq.deco2800.ducktales.resources.ResourceType;

/**
 * A Mine. Creates Ore
 * 
 * @author Gabrielle Hodge, 43590526 
 *
 */
public class Mine extends Building {
	
	// BuildingMenuSprite type
	private static final ResourceType TYPE = ResourceType.MINE;

	/**
	 * Initialise a new mine. Requires the location of the mine
	 *  to be passed.
	 * @param x, x location of the building
	 * @param y, y location of the building
	 */
	public Mine(double x, double y) {
		super(x, y, 5, 5, TYPE);
	}
	
	/**
	 * Update the WorldEntity properties with those of a mine.
	 */
	protected void specifications() {
		Building.STONERESOURCES = 10;
		Building.WOODRESOURCES = 6;
		Building.TIME = 3;
		Building.PRODUCTIONTYPE = production.ORE;
		Building.PRODUCTIONAMOUNT = 5;
	}

	/**
	 * Method to update mine at each discrete simulation step.
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
