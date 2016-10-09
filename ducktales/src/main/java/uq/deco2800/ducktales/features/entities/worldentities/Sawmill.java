package uq.deco2800.ducktales.features.entities.worldentities;

import uq.deco2800.ducktales.resources.ResourceType;

/**
 * A Sawmill. Class containing all properties and specifications of a 
 * sawmill.
 * 
 * @author Gabrielle Hodge, 43590526 
 *
 */
public class Sawmill extends Building {
	
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
	 *  to be passed.
	 * @param x, x location of the building
	 * @param y, y location of the building
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
		specifications(4, 8, 3, production.WOOD, productionAmount, health);
	}
	
	/**
	 * Update the 'health' of the sawmill. Requires an integer value of 
	 * the new health to be passed.
	 * 
	 * @param NewValue, new health of the building
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
	public void upgradeProduce(int newProduce) {
		if (newProduce >= 0) {
			productionAmount = newProduce;
		}
	}
}
