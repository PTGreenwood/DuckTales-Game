package uq.deco2800.ducktales.features.entities.worldentities;

import uq.deco2800.ducktales.resources.ResourceType;

/**
 * A Mine. Creates Ore, Class containing all properties and specifications of a 
 * mine.
 * 
 * @author Gabrielle Hodge, 43590526 
 *
 */
public class Mine extends Building {
	
	// BuildingMenuSprite type
	private static final ResourceType TYPE = ResourceType.MINE;

	// Mine size
	private static final int X_LENGTH = 5;
	private static final int Y_LENGTH = 5;
	
	/**
	 * Initialise a new mine. Requires the location of the mine
	 *  to be passed.
	 * @param x, x location of the building
	 * @param y, y location of the building
	 */
	public Mine(double x, double y) {
		super(x, y, X_LENGTH, Y_LENGTH, TYPE);
	}
	
	/**
	 * Update the WorldEntity properties with those of a mine.
	 */
	protected void specifications() {
		specifications(10, 6, 3, production.ORE, 5);
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
