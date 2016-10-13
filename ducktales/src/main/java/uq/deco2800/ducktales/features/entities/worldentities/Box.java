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

	// Building health - starting value
	private int health = 400;
	
	// Size of a box
	public static final int X_LENGTH = 1;
	public static final int Y_LENGTH = 1;
	
	public static final boolean PASSABILITY = false;
	
	/**
	 * Initialise a new box. Requires the location of the box
	 *  to be passed. Location of the box must fall within the world, 
	 *  and be unoccupied.
	 * @param x, x location of the building, must be within the bounds 
	 * of the world, and not have another building occupying the location.
	 * @param y, y location of the building. must be within the bounds 
	 * of the world, and not have another building occupying the location.
	 */
	public Box(int x, int y) {
		super(x, y, X_LENGTH, Y_LENGTH, TYPE);
		health = 400;
	}
	
	/**
	 * Update the WorldEntity properties with those of a box.
	 */
	protected void specifications() {
		specifications(2, 2, 4, production.NULL, 0, health, null);
	}
	
	/**
	 * Update the 'health' of the box. Requires an integer value of 
	 * the new health to be passed. The health of the building will be 
	 * greater than or equal to 0.
	 * 
	 * @param NewValue, new health of the building, will update the 
	 *  health to newValue, or 0 if newValue is <0
	 */
	protected void changeHealthBuilding(int newValue){
		health = newValue;
	}
	
	/**
	 * Upgrade produce for building, required for all buildings, by Building 
	 * class. Possible use to extand/upgrade a box.
	 * 
	 * @throws UnsupportedOperationException, as this functionality is not 
	 * required for a box.
	 */
	protected void upgradeProduceBuilding(int newValue) {
		throw new UnsupportedOperationException();
	}
	
	/**
	 * Upgrade stored resources for building, required for all buildings, by 
	 * Building class. Possible use to extend/upgrade a box.
	 * 
	 * @throws UnsupportedOperationException, as this functionality is not 
	 * required for a box.
	 */
	protected void upgradeBarnBarn(production upgradeType, int newStore) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Add stored resources to the building, required for all buildings, by 
	 * Building class. Possible use to extend/upgrade a box.
	 * 
	 * @throws UnsupportedOperationException, as this functionality is not 
	 * required for a box.
	 */
	protected void addGoodsBarn(production storeType, int newStore) {
		throw new UnsupportedOperationException();
	}
}
