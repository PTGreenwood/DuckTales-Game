package uq.deco2800.ducktales.features.entities.worldentities;

import uq.deco2800.ducktales.resources.ResourceType;

/**
 * A Pasture.
 * 
 * @author Gabrielle Hodge, 43590526 
 *
 */
public class Pasture extends Building {

	// BuildingMenuSprite type
	private static final ResourceType TYPE = ResourceType.PASTURE;
	
	
	/**
	 * Initialise a new barn. Requires the location of the pasture
	 *  to be passed.
	 * @param x, x location of the building
	 * @param y, y location of the building
	 */
	public Pasture(double x, double y) {
		super(x, y, 5, 5, TYPE);
		
	}
	
	/**
	 * Update the WorldEntity properties with those of a pasture.
	 */
	protected void specifications() {
		STONERESOURCES = 2;
		WOODRESOURCES = 10;
		TIME = 4;
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
