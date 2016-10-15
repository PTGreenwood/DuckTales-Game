package uq.deco2800.ducktales.features.entities.worldentities;

import uq.deco2800.ducktales.resources.ResourceType;

/**
 * A Cemetery. Class containing all properties and specifications of a 
 * cemetery.
 * 
 * @author Gabrielle Hodge, 43590526 
 *
 */
public class Cemetery extends Building {
	
	// BuildingMenuSprite type
	private static final ResourceType TYPE = ResourceType.CEMETERY;

	// Building health - starting value
	private int health = 500;
	
	// Size of a cemetery
	public static final int X_LENGTH = 2;
	public static final int Y_LENGTH = 2;
	
	public static final boolean PASSABILITY = false;
	
	/**
	 * Initialise a new cemetery. Requires the location of the cemetery
	 *  to be passed. Location of the cemetery must fall within the world, 
	 *  and be unoccupied.
	 * @param x, x location of the building, must be within the bounds 
	 * of the world, and not have another building occupying the location.
	 * @param y, y location of the building. must be within the bounds 
	 * of the world, and not have another building occupying the location.
	 */
	public Cemetery(double x, double y) {
		super(x, y, X_LENGTH, Y_LENGTH, TYPE);
		health = 500;
	}
	
	/**
	 * Update the WorldEntity properties with those of a cemetery.
	 */
	protected void specifications() {
		specifications(2, 4, 2, production.NULL, 0, health, null);
	}
	
	/**
	 * Update the 'health' of the cemetery. Requires an integer value of 
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
	 * class. Possible use to extend/upgrade cemetery.
	 * 
	 * @throws UnsupportedOperationException, as this functionality is not 
	 * required for a cemetery.
	 */
	protected void upgradeProduceBuilding(int newValue) {
		throw new UnsupportedOperationException();
	}
	
	/**
	 * Upgrade stored resources for building, required for all buildings, by 
	 * Building class. Possible use to extend/upgrade a cemetery.
	 * 
	 * @throws UnsupportedOperationException, as this functionality is not 
	 * required for a cemetery.
	 */
	protected void upgradeBarnBarn(production upgradeType, int newStore) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Add stored resources to the building, required for all buildings, by 
	 * Building class. Possible use to extend/upgrade a cemetery.
	 * 
	 * @throws UnsupportedOperationException, as this functionality is not 
	 * required for a cemetery.
	 */
	protected void addGoodsBarn(production storeType, int newStore) {
		throw new UnsupportedOperationException();
	}
}
