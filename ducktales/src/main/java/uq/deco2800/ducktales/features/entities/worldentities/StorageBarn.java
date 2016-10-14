package uq.deco2800.ducktales.features.entities.worldentities;

import java.util.ArrayList;

import org.apache.commons.lang3.tuple.Triple;

import uq.deco2800.ducktales.resources.ResourceType;

/**
 * A Storage Barn. Class containing all properties and specifications of a 
 * storage barn.
 * 
 * @author Gabrielle Hodge, 43590526 
 *
 */
public class StorageBarn extends StorageProduceBuilding {

	// BuildingMenuSprite type
	private static final ResourceType TYPE = ResourceType.STORAGEBARN;
	
	// Building health - starting value
	private int health = 950;
			
	// Building storage - starting
	private ArrayList<Triple<production, Integer, Integer>> storage = new 
			ArrayList<Triple<production, Integer, Integer>>();
	
	// Building size
	public static final int X_LENGTH = 5;
	public static final int Y_LENGTH = 5;
	
	public static final boolean PASSABILITY = false;
	
	/**
	 * Initialise a new storage barn. Requires the location of the storage 
	 * barn to be passed. Location of the house must fall within the world, 
	 *  and be unoccupied.
	 * @param x, x location of the building, must be within the bounds 
	 * of the world, and not have another building occupying the location.
	 * @param y, y location of the building. must be within the bounds 
	 * of the world, and not have another building occupying the location.
	 */
	public StorageBarn(double x, double y) {
		super(x, y, X_LENGTH, Y_LENGTH, TYPE);
		health = 950;
		storage.add(0, Triple.of(production.WOOD, 20, 0));
		storage.add(1, Triple.of(production.STONE, 15, 0));
		storage.add(2, Triple.of(production.ORE, 10, 0));
		storage.add(3, Triple.of(production.FOOD, 25, 0));
		
	}
	
	/**
	 * Update the WorldEntity properties with those of a storage barn.
	 */
	protected void specifications() {
		specifications(4, 4, 7, production.NULL, 0, health, storage);
	}
	
	/**
	 * Update the 'health' of the storage barn. The health of the building 
	 * will be greater than or equal to 0.
	 * 
	 * @param NewValue, new health of the building, will update the 
	 *  health to newValue, or 0 if newValue is <0
	 */
	protected void changeHealthBuilding(int newValue){
		health = newValue;
	}
	
	/**
	 * Update the amount of a good (store) in the storage barn. Requires the 
	 * type of produced material and the amount to be added to be passed. If 
	 * the amount to be added, means the capacity of the storage barn will be 
	 * exceeded the max will be added. 
	 * 
	 * @param store, the type of produced material to be stored
	 * @param amount, the amount to be stored
	 */
	protected void addGoodsBarn(production storeType, int newStore) {
		for (int i = 0; i < storage.size(); i++) {
			Triple<production, Integer, Integer> k = storage.get(i);
			if (k.getLeft() == storeType && k.getMiddle() > k.getRight() 
					+ newStore) {
				Triple<production, Integer, Integer> m = Triple.of(storeType, 
						k.getMiddle(), k.getRight() + newStore);
				storage.remove(k);
				storage.add(i, m);
			} else if (k.getLeft() == storeType && k.getMiddle() <= k.getRight() 
					+ newStore) {
				Triple<production, Integer, Integer> m = Triple.of(storeType, 
						k.getMiddle(), k.getMiddle());
				storage.remove(k);
				storage.add(i, m);
			}
		}
		
	}
		
	/**
	 * Upgrade the barn, increase the storage capacity for a particular 
	 * produced material.
	 * 
	 * @param store, the type of produced material to be stored
	 * @param amount, the new capacity 
	 */
	protected void upgradeBarnBarn(production upgradeType, int newStore) {
		for (int i = 0; i < storage.size(); i++) {
			Triple<production, Integer, Integer> k = storage.get(i);
			if (k.getLeft() == upgradeType) {
				Triple<production, Integer, Integer> m = Triple.of(upgradeType, 
						newStore, k.getRight());
				storage.remove(k);
				storage.add(i, m);
			}
		}
	}
	
	/**
	 * Upgrade produce for building, required for all buildings, by Building 
	 * class. Possible use to extend/upgrade a storage barn.
	 * 
	 * @throws UnsupportedOperationException, as this functionality is not 
	 * required for a storage barn.
	 */
	protected void upgradeProduceBuilding(int newValue) {
		throw new UnsupportedOperationException();
	}		
}
