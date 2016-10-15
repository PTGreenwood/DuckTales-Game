package uq.deco2800.ducktales.features.entities.worldentities;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.tuple.Triple;

import uq.deco2800.ducktales.features.entities.worldentities.Building.production;
import uq.deco2800.ducktales.resources.ResourceType;

/**
 * Abstract representation of all buildings
 * 
 * @author Gabrielle Hodge, 43590526
 *
 */
public abstract class Building extends WorldEntity {
	
	// Constants for building parameters
	protected static int time;
	
	protected static int woodResources;

	protected static int stoneResources;
	
	// Otherwise external classes cannot access type (even using method below)
	public enum production {
		NULL, WOOD, STONE, ORE, FOOD
	}
	
	protected static production productionType;
	
	protected static int productionAmount;
	
	protected static int health;
	
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
	protected Building(double x, double y, int lengthX, int lengthY, 
			ResourceType type) {
		super(x, y, lengthX, lengthY, type);
	}
		
	/**
	 * Returns the time to construct the building
	 * 
	 * @return int representing time to construct
	 */
	public int timeToBuild() {
		specifications();
		return time;
	}
	
	/**
	 * Returns the wood resources required to construct the 
	 * building
	 * 
	 * @return the int of wood required
	 */
	public int resourcesBuildWood() {
		specifications();
		return woodResources;
	}
	
	/**
	 * Returns the stone resources required to construct the 
	 * building
	 * 
	 * @return the int of stone required
	 */
	public int resourcesBuildStone() {
		specifications();
		return stoneResources;
	}
	
	/**
	 * Returns the wood resources returned when the 
	 * building is demolished
	 * 
	 * @return the int of wood returned
	 */
	public int resourcesReturnWood() {
		specifications();
		return (int) (0.5*woodResources);
	}
	
	/**
	 * Returns the stone resources returned when the 
	 * building is demolished
	 * 
	 * @return the int of stone returned
	 */
	public int resourcesReturnStone() {
		specifications();
		return (int) (0.5*stoneResources);
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
	 * Calls the above specification method which updates the variables 
	 * as required. Called by both building and constructor classes.
	 */
	protected abstract void specifications();
	
	/**
	 * Calls the changeHealthBuilding method which updates the 
	 * health of the building.
	 */
	protected abstract void changeHealthBuilding(int newHealth);
	
	/**
	 * Calls the upgradeBarnBarn method which upgrades the 
	 * amount of produce stored by the storage barn.
	 */
	protected abstract void upgradeBarnBarn(production upgradeType, 
			int newStore);
	
	/**
	 * Calls the addGoodsBarn method which updates the storage values 
	 * for the storage barn.
	 */
	protected abstract void addGoodsBarn(production storeType, 
			int newStore);
	
	/**
	 * Calls the upgradeProduceBuilding method which updates the 
	 * produce amount produced by the building.
	 */
	protected abstract void upgradeProduceBuilding(int newValue);
	
	/**
	 * Method to access the 'health' of the building. Returns the integer  
	 * value of the health.
	 * 
	 * @return the health of the building.
	 */
	public int getHealth() {
		specifications();
		return health;
	}
	
	/**
	 * Update the 'health' of a buildings. Requires an integer value of 
	 * the new health to be passed. Health will be greater than, or equal 
	 * to 0.
	 * 
	 * @param NewValue, new health of the building
	 */
	public void changeHealth(int newValue){
		if (newValue > 0){
			changeHealthBuilding(newValue);
		}
	}
	
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
	 * Update the amount of a good (store) in the storage barn. Requires the 
	 * type of produced material and the amount to be added to be passed. If 
	 * the amount to be added, means the capacity of the storage barn will be 
	 * exceeded the max will be added. 
	 * 
	 * @param store, the type of produced material to be stored
	 * @param amount, the amount to be stored
	 */
	public void addGoods(production store, Integer amount) {
		addGoodsBarn(store, amount);
	}
	
	/**
	 * Method to retrieve the current amount, type and storage barn capacity 
	 * for each production type.
	 * 
	 * @return the storage barn capacity, and current inventory.
	 */
	public List<Triple<production, Integer, Integer>> getStorage() {
		specifications();
		return storage;
	}
	
	/**
	 * Upgrade the barn, increase the storage capacity for a particular 
	 * produced material.
	 * 
	 * @param store, the type of produced material to be stored
	 * @param amount, the new capacity 
	 */
	public void upgradeBarn(production store, Integer amount) {
		specifications();
		upgradeBarnBarn(store, amount);
	}

	/**
	 * Method to update buildings at each discrete simulation step.
	 * 
	 * Note sure if any implementation will be used. To be determined later
	 * May implement for only some of the classes 
	 */
	@Override
	public void tick() {
		// Not required
	}
}
