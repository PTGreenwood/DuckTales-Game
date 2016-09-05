package uq.deco2800.ducktales.entities.worldentities;

import uq.deco2800.ducktales.resources.ResourceType;
import static uq.deco2800.ducktales.resources.ResourceType.*;

/**
 * A Bakery.
 * 
 * @author Gabrielle Hodge, 43590526
 *
 */
public class Bakery extends WorldEntity{
	
	// BuildingMenuSprite type
	private static final ResourceType TYPE = BAKERY;
	
	/**
	 * Initialise a new bakery. Requires the location of the bakery
	 *  to be passed.
	 * @param x, x location of the building
	 * @param y, y location of the building
	 */
	public Bakery(double x, double y) {
		super(x, y, 2, 2, TYPE);	
	}
	
	/**
	 * Update the WorldEntity properties with those of a bakery.
	 */
	protected void specifications() {
		WorldEntity.STONERESOURCES = 4;
		WorldEntity.WOODRESOURCES = 6;
		WorldEntity.TIME = 4;
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
