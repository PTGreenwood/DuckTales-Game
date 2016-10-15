package uq.deco2800.ducktales.features.entities.worldentities;

import java.util.ArrayList;

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
	
	protected static int health;

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
			int healthSet) {
		woodResources = wood;
		stoneResources = stone;
		time = timeSet;
		health = healthSet;
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
	 * Method to update buildings at each discrete simulation step.
	 * 
	 * Note sure if any implementation will be used. To be determined later
	 * May implement for only some of the classes 
	 */
	@Override
	public void tick() {
		// Not required
	}
	
	public StorageProduceBuilding toStorageProduceBuilding(Building building) {
		ArrayList<ResourceType> produceStorageBuildings = new ArrayList<ResourceType>();
		produceStorageBuildings.add(ResourceType.SAWMILL);
		produceStorageBuildings.add(ResourceType.QUARRY);
		produceStorageBuildings.add(ResourceType.MINE);
		produceStorageBuildings.add(ResourceType.FARM);
		produceStorageBuildings.add(ResourceType.STORAGEBARN);
		if (produceStorageBuildings.contains(building.getType())) {
			return (StorageProduceBuilding) building;
		}
		return null;
	}
}
