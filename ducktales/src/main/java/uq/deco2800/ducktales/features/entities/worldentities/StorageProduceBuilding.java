package uq.deco2800.ducktales.features.entities.worldentities;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.tuple.Triple;

import uq.deco2800.ducktales.features.entities.worldentities.StorageProduceBuilding.production;
import uq.deco2800.ducktales.resources.ResourceType;

/**
 * Abstract representation of all buildings
 * 
 * @author Gabrielle Hodge, 43590526
 *
 */
public abstract class StorageProduceBuilding extends Building {
		
	// Otherwise external classes cannot access type (even using method below)
	public enum production {
		NULL, TIMBER, STONE, ORE, FOOD, LUMBER
	}
	
	protected static production productionType;
	
	protected static int productionAmount;
	
	// Storage barn storage - starting
	protected static ArrayList<Triple<production, Integer, Integer>> storage = new 
			ArrayList<Triple<production, Integer, Integer>>();

	/**
	 * Main constructor of the class.
	 * @param x, x location of the building
	 * @param y, y location of the building
	 * @param lengthX, length of building (x direction)
	 * @param lengthY, length of building (y direction)
	 * @param type, building type
	 */
	protected StorageProduceBuilding(double x, double y, int lengthX, int lengthY, 
			ResourceType type) {
		super(x, y, lengthX, lengthY, type);
	}
			
	/**
	 * Returns the type of resource the building generates 
	 * or null if it does not
	 * 
	 * @return the enum of the resource type
	 */
	public production resourcesProductionType() {
		specifications();
		return productionType;
	}
	
	/**
	 * Returns the amount of resource the building generates over 
	 * time or 0 (cannot return null from an int method) if it does not
	 * 
	 * @return the int of the resource amount
	 */
	public int resourcesProductionAmount() {
		specifications();
		return productionAmount;
	}
	
	/**
	 * Update the variables with the building specifications, when the 
	 * building is called. Moved updating function to building class to 
	 * remove duplicated code errors throughout the building class.
	 * 
	 * @param stone, the amount of stone to build
	 * @param wood, the amount of wood to build
	 * @param time, the amount of time to build
	 * @param produce, the production type produced by the building
	 * @param amount, the amount of the resource produced
	 * @param health, the health of the building
	 *  
	 */
	protected static void specifications(int stone, int wood, int timeSet, 
			production produce, int amount, int healthSet, 
			ArrayList<Triple<production, Integer, Integer>> stored) {
		woodResources = wood;
		stoneResources = stone;
		time = timeSet;
		productionType = produce;
		productionAmount = amount;
		health = healthSet;
		storage = stored;
	}
	
	/**
	 * Calls the upgradeBarnBarn method which upgrades the 
	 * amount of produce stored by the building.
	 */
	protected abstract void upgradeStorageBuilding(ArrayList<Triple
			<production, Integer, Integer>> newStore);
	
	/**
	 * Calls the addGoodsBarn method which updates the storage values 
	 * for the building.
	 */
	protected abstract void addGoodsBuilding(ArrayList<Triple
			<production, Integer, Integer>> newStore);
	
	/**
	 * Calls the upgradeProduceBuilding method which updates the 
	 * produce amount produced by the building.
	 */
	protected abstract void upgradeProduceBuilding(int newValue);
	
	/**
	 * Produce 'refined'/'processed' materials from raw materials. Requires 
	 * the building to have some raw materials available to be processed, 
	 * and for the building to have room to store the new materials.
	 */
	protected abstract void produceMaterialBuilding();
	
	/**
	 * Method to update the production amount of a 'production' building. 
	 * Requires an integer value of the produce to be passed. Production 
	 * amounts are greater than, or equal to 0.
	 * 
	 * @param newProduce, the new production amount, greater than or equal to 
	 * 0.
	 */
	public void upgradeProduce(int newProduce) {
		specifications();
		if (newProduce >= 0) {
			upgradeProduceBuilding(newProduce);
		}
	}
	
	/**
	 * Update the amount of a good (store) in the building. Requires the 
	 * type of produced material and the amount to be added to be passed. If 
	 * the amount to be added, means the capacity of the building will be 
	 * exceeded the max will be added. 
	 * 
	 * @param store, the type of produced material to be stored
	 * @param amount, the amount to be stored
	 */
	public void addGoods(production store, Integer amount) {
		specifications();
		for (int i = 0; i < storage.size(); i++) {
			Triple<production, Integer, Integer> k = storage.get(i);
			if (k.getLeft() == store && k.getMiddle() > k.getRight() 
					+ amount) {
				Triple<production, Integer, Integer> m = Triple.of(store, 
						k.getMiddle(), k.getRight() + amount);
				storage.remove(k);
				storage.add(i, m);
			} else if (k.getLeft() == store && k.getMiddle() <= k.getRight() 
					+ amount) {
				Triple<production, Integer, Integer> m = Triple.of(store, 
						k.getMiddle(), k.getMiddle());
				storage.remove(k);
				storage.add(i, m);
			}
		}
		addGoodsBuilding(storage);
	}
	
	/**
	 * Method to retrieve the current amount, type and building capacity 
	 * for each production type.
	 * 
	 * @return the building capacity, and current inventory.
	 */
	public List<Triple<production, Integer, Integer>> getStorage() {
		specifications();
		return storage;
	}
	
	/**
	 * Upgrade the building, increase the storage capacity for a particular 
	 * produced material.
	 * 
	 * @param store, the type of produced material to be stored
	 * @param amount, the new capacity 
	 */
	public void upgradeBarn(production store, Integer amount) {
		specifications();
		for (int i = 0; i < storage.size(); i++) {
			Triple<production, Integer, Integer> k = storage.get(i);
			if (k.getLeft() == store) {
				Triple<production, Integer, Integer> m = Triple.of(store, 
						amount, k.getRight());
				storage.remove(k);
				storage.add(i, m);
				upgradeStorageBuilding(storage);
			}
		}
	}
	
	/**
	 * Call the produceMaterialBuilding() method for the specific building.
	 */
	public void produceMaterial() {
		produceMaterialBuilding();
	}
}
