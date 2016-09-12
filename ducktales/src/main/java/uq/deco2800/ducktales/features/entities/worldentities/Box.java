package uq.deco2800.ducktales.features.entities.worldentities;

import uq.deco2800.ducktales.resources.ResourceType;

/**
 * Representation of a basic box. Class containing all properties and 
 * specifications of a box.
 * 
 * @author Leggy
 *
 */
public class Box extends Building {

	// BuildingMenuSprite type
	private static final ResourceType TYPE = ResourceType.BOX;

	// Size of a box
	public static final int X_LENGTH = 1;
	public static final int Y_LENGTH = 1;
	public static final boolean PASSABILITY = false;
	
	/**
	 * Initialise a new box. Requires the location of the box
	 *  to be passed.
	 * @param x, x location of the building
	 * @param y, y location of the building
	 */
	public Box(int x, int y) {
		super(x, y, X_LENGTH, Y_LENGTH, TYPE);
	}
	
	/**
	 * Update the WorldEntity properties with those of a box.
	 */
	protected void specifications() {
		specifications(2, 2, 4, production.NULL, 0);
	}

	/**
	 * Method to update a box at each discrete simulation step.
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
