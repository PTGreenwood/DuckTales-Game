package uq.deco2800.ducktales.features.entities.worldentities;

import uq.deco2800.ducktales.resources.ResourceType;

/**
 * A Quarry. Class containing all properties and specifications of a 
 * quarry.
 * 
 * @author Gabrielle Hodge, 43590526 
 *
 */
public class Quarry extends Building {

	// BuildingMenuSprite type
	private static final ResourceType TYPE = ResourceType.QUARRY;
	
	// Building health - starting value
	private int health = 1300;
	
	// Building production - starting amount
	private int productionAmount = 5;
	
	// Size of the building
	public static final int X_LENGTH = 5;
	public static final int Y_LENGTH = 5;
	
	public static final boolean PASSABILITY = false;
	
	/**
	 * Initialise a new quarry. Requires the location of the quarry
	 *  to be passed. Location of the quarry must fall within the world, 
	 *  and be unoccupied.
	 * @param x, x location of the building, must be within the bounds 
	 * of the world, and not have another building occupying the location.
	 * @param y, y location of the building. must be within the bounds 
	 * of the world, and not have another building occupying the location.
	 */
	public Quarry(double x, double y) {
		super(x, y, X_LENGTH, Y_LENGTH, TYPE);
		health = 1300;
		productionAmount = 5;
	}
	
	/**
	 * Update the WorldEntity properties with those of a quarry.
	 */
	protected void specifications() {
		specifications(8, 6, 5, production.STONE, productionAmount, health, 
				null);
	}
	
	/**
	 * Update the 'health' of the quarry. Requires an integer value of 
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
	 * Method to update the production amount of a quarry. Feature of an 
	 * upgraded quarry. Requires an integer value of the produce to be passed.
	 * 
	 * @param newProduce, the new production amount
	 */
	protected void upgradeProduceBuilding(int newProduce) {
		productionAmount = newProduce;
	}
	
	/**
	 * Upgrade stored resources for building, required for all buildings, by 
	 * Building class. Possible use to extend/upgrade a quarry.
	 * 
	 * @throws UnsupportedOperationException, as this functionality is not 
	 * required for a quarry.
	 */
	protected void upgradeBarnBarn(production upgradeType, int newStore) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Add stored resources to the building, required for all buildings, by 
	 * Building class. Possible use to extend/upgrade a quarry.
	 * 
	 * @throws UnsupportedOperationException, as this functionality is not 
	 * required for a quarry.
	 */
	protected void addGoodsBarn(production storeType, int newStore) {
		throw new UnsupportedOperationException();
	}
}
