package uq.deco2800.ducktales.features.entities.worldentities;

/**
 * A Construction Interface to obtain BuildingMenuSprite information.
 * 
 * @author Gabrielle Hodge, 43590526
 *
 */

public class Constructor {
	
	
	/**
	 * Constructor method. Determines whether the selected building meets 
	 * requirements for its construction. Will check the required vs 
	 * available resources.
	 */
	public Constructor() {
	}
	
	
	/**
	 * Private accessor method to get the stone requirements to 
	 * construct the selected building.
	 * 
	 * @param building, selected building, passed from Constructor
	 * 
	 * @return the integer number of stone required to construct
	 */
	public int getStone(Building building) {
		building.specifications();
		return building.resourcesBuildStone();
	}
	
	/**
	 * Private accessor method to get the wood requirements to 
	 * construct the selected building.
	 * 
	 * @param building, selected building, passed from Constructor
	 * 
	 * @return the integer number of wood required for construction
	 */
	public int getWood(Building building) {
		building.specifications();
		return building.resourcesBuildWood();
	}
	
	/**
	 * Private accessor method to determine the required time for construction 
	 * of the selected building.
	 * 
	 * @param building, the selected building, passed from Constructor
	 * 
	 * @return the integer of time required to construct the selected 
	 * building.
	 */
	public int getTime(Building building) {
		building.specifications();
		return building.timeToBuild();
	}
}