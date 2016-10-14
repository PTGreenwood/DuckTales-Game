package uq.deco2800.ducktales.features.entities.worldentities;

import uq.deco2800.ducktales.resources.ResourceType;

/**
 * A Sawmill. Class containing all properties and specifications of a 
 * sawmill.
 * 
 * @author Gabrielle Hodge, 43590526 
 *
 */
public class Sawmill extends StorageProduceBuilding {
	
	// BuildingMenuSprite type
	private static final ResourceType TYPE = ResourceType.SAWMILL;
	
	// Building health - starting value
	private int health = 1400;
	
	// Building wood production - starting value
	private int productionAmount = 5;
	
	// Sawmill size
	public static final int X_LENGTH = 5;
	public static final int Y_LENGTH = 5;
	
	public static final boolean PASSABILITY = false;

	/**
	 * Initialise a new sawmill. Requires the location of the sawmill
	 *  to be passed. Location of the sawmill must fall within the world, 
	 *  and be unoccupied.
	 * @param x, x location of the building, must be within the bounds 
	 * of the world, and not have another building occupying the location.
	 * @param y, y location of the building. must be within the bounds 
	 * of the world, and not have another building occupying the location.
	 */
	public Sawmill(double x, double y) {
		super(x, y, X_LENGTH, Y_LENGTH, TYPE);
		health = 1400;
		productionAmount = 5;
	}

	/**
	 * Update the WorldEntity properties with those of a sawmill.
	 */
	protected void specifications() {
		specifications(4, 8, 3, production.WOOD, productionAmount, health, 
				null);
	}
	
	/**
	 * Update the 'health' of the sawmill. Requires an integer value of 
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
	 * Method to update the production amount of a sawmill. Feature of an 
	 * upgraded sawmill. Requires an integer value of the produce to be passed.
	 * 
	 * @param newProduce, the new production amount
	 */
	protected void upgradeProduceBuilding(int newProduce) {
		productionAmount = newProduce;
	}
	
	/**
	 * Upgrade stored resources for building, required for all buildings, by 
	 * Building class. Possible use to extend/upgrade a sawmill.
	 * 
	 * @throws UnsupportedOperationException, as this functionality is not 
	 * required for a sawmill.
	 */
	protected void upgradeBarnBarn(production upgradeType, int newStore) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Add stored resources to the building, required for all buildings, by 
	 * Building class. Possible use to extend/upgrade a sawmill.
	 * 
	 * @throws UnsupportedOperationException, as this functionality is not 
	 * required for a sawmill.
	 */
	protected void addGoodsBarn(production storeType, int newStore) {
		throw new UnsupportedOperationException();
	}
}
