package uq.deco2800.ducktales.features.entities.worldentities;

import java.util.ArrayList;

import org.apache.commons.lang3.tuple.Triple;

import uq.deco2800.ducktales.resources.ResourceType;

/**
 * A Farm. Class containing all properties and specifications of a 
 * farm.
 * 
 * @author Gabrielle Hodge, 43590526 
 *
 */
public class Farm extends StorageProduceBuilding {
	
	// BuildingMenuSprite type
	private static final ResourceType TYPE = ResourceType.FARM;

	// Building health - starting value
	private int health = 900;
	
	//Building produce - starting value
	private int productionAmount = 5;
	
	// Farm storage - starting
	private ArrayList<Triple<production, Integer, Integer>> storage = new 
		ArrayList<Triple<production, Integer, Integer>>();
	
	// Size of the building
	public static final int X_LENGTH = 5;
	public static final int Y_LENGTH = 5;
	
	public static final boolean PASSABILITY = false;
	
	/**
	 * Initialise a new farm. Requires the location of the farm 
	 *  to be passed. Location of the farm must fall within the world, 
	 *  and be unoccupied.
	 * @param x, x location of the building, must be within the bounds 
	 * of the world, and not have another building occupying the location.
	 * @param y, y location of the building. must be within the bounds 
	 * of the world, and not have another building occupying the location.
	 */
	public Farm(double x, double y) {
		super(x, y, X_LENGTH, Y_LENGTH, TYPE);
		health = 900;
		productionAmount = 5;
		storage.add(0, Triple.of(production.FOOD, 50, 0));
	}
	
	/**
	 * Update the WorldEntity properties with those of a farm.
	 */
	protected void specifications() {
		specifications(8, 10, 9, production.FOOD, productionAmount, health, 
				storage);
	}
	
	/**
	 * Update the 'health' of the farm. Requires an integer value of 
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
	 * Method to update the production amount of a farm. Feature of an 
	 * upgraded farm. Requires an integer value of the produce to be passed.
	 * 
	 * @param newProduce, the new production amount, greater than or equal ro 
	 * 0.
	 */
	protected void upgradeProduceBuilding(int newProduce) {
		productionAmount = newProduce;
	}
	
	/**
	 * Upgrade stored resources for building, required for all buildings, by 
	 * Building class. Possible use to extend/upgrade a farm.
	 * 
	 * @throws UnsupportedOperationException, as this functionality is not 
	 * required for a farm.
	 */
	protected void upgradeStorageBuilding(ArrayList<Triple<production, Integer, 
			Integer>> newStore) {
		if (newStore.contains(production.FOOD)) {
			storage = newStore;
		}
	}

	/**
	 * Add stored resources to the building, required for all buildings, by 
	 * Building class. Possible use to extend/upgrade a farm.
	 * 
	 * @throws UnsupportedOperationException, as this functionality is not 
	 * required for a farm.
	 */
	protected void addGoodsBuilding(ArrayList<Triple<production, Integer, 
			Integer>> newStore) {
		storage = newStore;
	}
	
	/**
	 * Produce 'refined'/'processed' materials from raw materials. Requires 
	 * the building to have some raw materials available to be processed, 
	 * and for the building to have room to store the new materials.
	 * 
	 * Currently unimplemented for Farm
	 */
	protected void produceMaterialBuilding() {
		if (storage.get(0).getRight()<storage.get(0).getMiddle()) {
			this.addGoods(production.FOOD, 1);
		}
		System.out.println(storage);
	}
}
