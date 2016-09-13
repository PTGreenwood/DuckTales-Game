package uq.deco2800.ducktales.features.entities.worldentities;

import uq.deco2800.ducktales.resources.ResourceType;

/**
 * Abstract representation of all buildings
 * 
 * @author Gabrielle Hodge, 43590526
 *
 */
public abstract class Building extends WorldEntity {
	
	// Constants for building parameters
	protected static int TIME;
	
	protected static int WOODRESOURCES;

	protected static int STONERESOURCES;
	
	// Otherwise external classes cannot access type (even using method below)
	public enum production {
		NULL, WOOD, STONE, ORE, FOOD
	}
	
	protected static production PRODUCTIONTYPE;
	
	protected static int PRODUCTIONAMOUNT;
	
	protected static int HEALTH;

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
		return TIME;
	}
	
	/**
	 * Returns the wood resources required to construct the 
	 * building
	 * 
	 * @return the int of wood required
	 */
	public int resourcesBuildWood() {
		return WOODRESOURCES;
	}
	
	/**
	 * Returns the stone resources required to construct the 
	 * building
	 * 
	 * @return the int of stone required
	 */
	public int resourcesBuildStone() {
		return STONERESOURCES;
	}
	
	/**
	 * Returns the wood resources returned when the 
	 * building is demolished
	 * 
	 * @return the int of wood returned
	 */
	public int resourcesReturnWood() {
		specifications();
		return (int) (0.5*WOODRESOURCES);
	}
	
	/**
	 * Returns the stone resources returned when the 
	 * building is demolished
	 * 
	 * @return the int of stone returned
	 */
	public int resourcesReturnStone() {
		specifications();
		return (int) (0.5*STONERESOURCES);
	}
	
	/**
	 * Returns the type of resource the building generates 
	 * or null if it does not
	 * 
	 * @return the enum of the resource type
	 */
	public production resourcesProductionType() {
		specifications();
		return PRODUCTIONTYPE;
	}
	
	/**
	 * Returns the amount of resource the building generates over 
	 * time or 0 (cannot return null from an int method) if it does not
	 * 
	 * @return the int of the resource amount
	 */
	public int resourcesProductionAmount() {
		specifications();
		return PRODUCTIONAMOUNT;
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
	 * 
	 *  
	 */
	protected void specifications(int stone, int wood, int time, 
			production produce, int amount, int health) {
		WOODRESOURCES = wood;
		STONERESOURCES = stone;
		TIME = time;
		PRODUCTIONTYPE = produce;
		PRODUCTIONAMOUNT = amount;
		HEALTH = health;
	}

	/**
	 * Calls the above specification method which updates the variables 
	 * as required. Called by both building and constructor classes.
	 */
	protected abstract void specifications();
	
	/**
	 * Method to access the 'health' of the bakery. Returns the integer 
	 * value of the health.
	 * 
	 * @return the health of the bakery.
	 */
	public int GetHealth() {
		specifications();
		return HEALTH;
	}
}
