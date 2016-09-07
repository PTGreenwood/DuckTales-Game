package uq.deco2800.ducktales.features.entities.worldentities;

import uq.deco2800.ducktales.resources.ResourceType;

/**
 * Representation of a basic box.
 * 
 * @author Leggy
 *
 */
public class Box extends Building {

	// BuildingMenuSprite type
	private final static ResourceType TYPE = ResourceType.BOX;

	/**
	 * Initialise a new box. Requires the location of the box
	 *  to be passed.
	 * @param x, x location of the building
	 * @param y, y location of the building
	 */
	public Box(int x, int y) {
		super(x, y, 1, 1, TYPE);
	}
	
	/**
	 * Update the WorldEntity properties with those of a box.
	 */
	protected void specifications() {
		Building.STONERESOURCES = 2;
		Building.WOODRESOURCES = 2;
		Building.TIME = 4;
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
