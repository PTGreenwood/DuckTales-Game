package uq.deco2800.ducktales.features.entities.worldentities;

import uq.deco2800.ducktales.resources.ResourceType;

/**
 * Abstract representation of all buildings
 * 
 * @author Gabrielle Hodge, 43590526
 *
 */
public abstract class Building extends WorldEntity {
	
	protected static int TIME;
	
	protected static int WOODRESOURCES;

	protected static int STONERESOURCES;
	
	protected static enum production {
		WOOD, STONE, ORE, FOOD, NULL
	}
	
	protected static production PRODUCTIONTYPE;
	
	protected static int PRODUCTIONAMOUNT;

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
		specifications();
	}
		
	/**
	 * Returns the time to construct the building
	 * 
	 * @return int representing time to construct
	 */
	public int timeToBuild() {
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
		return (int) (0.5*WOODRESOURCES);
	}
	
	/**
	 * Returns the stone resources returned when the 
	 * building is demolished
	 * 
	 * @return the int of stone returned
	 */
	public int resourcesReturnStone() {
		return (int) (0.5*STONERESOURCES);
	}
	
	/**
	 * Returns the type of resource the building generates 
	 * or null if it does not
	 * 
	 * @return the enum of the resource type
	 */
	public production resourcesProductionType() {
		return PRODUCTIONTYPE;
	}
	
	/**
	 * Returns the amount of resource the building generates over 
	 * time or null if it does not
	 * 
	 * @return the int of the resource amount
	 */
	public int resourcesProductionAmount() {
		return PRODUCTIONAMOUNT;
	}
	
	/**
	 * Update the variables with the building specifications, when the 
	 * building is called.
	 */
	protected abstract void specifications();
}
