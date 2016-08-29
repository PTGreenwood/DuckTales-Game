package uq.deco2800.ducktales.entities.worldentities;

import uq.deco2800.ducktales.entities.worldentities.*;

/**
 * A Construction Interface to select Buildings. 
 * 
 * @author Gabrielle Hodge, 43590526
 *
 */

public class Constructor {
	
	
	/**
	 * Constructor method. Determines whether the selected building meets 
	 * requirements for its construction. Will check the required vs 
	 * available resources.
	 * 
	 * @param x, the x location of the building
	 * 
	 * @param y, the y location of the building
	 */
	public Constructor(double x, double y) {
		// Change the following lines:
		// Change to building clicked from constructor panel
		WorldEntity toCreate = new Bakery(x, y);
		// Change to resources available - wood, stone
		if (getStone(toCreate) <= 10) {
			if (getWood(toCreate) <= 10) {
				// Something along the lines of World.add(toCreate) ...
				getTime(toCreate);
			}
			errorBuild("wood", toCreate);
		}
		errorBuild("stone", toCreate);
	}
	
	
	/**
	 * Private accessor method to get the stone requirements to 
	 * construct the selected building.
	 * 
	 * @param building, selected building, passed from Constructor
	 * 
	 * @return the integer number of stone required to construct
	 */
	private int getStone(WorldEntity building) {
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
	private int getWood(WorldEntity building) {
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
	private int getTime(WorldEntity building) {
		return building.timeToBuild();
	}
	
	/**
	 * Public method to return an error message that details which material 
	 * requirement is not fulfilled for construction to proceed.
	 * 
	 * @param material, the material where the requirements are not satisfied.
	 * 
	 * @param building, building selected by the user for construction
	 * 
	 * @return A string detailing the error with constructing the selected 
	 * building.
	 */
	public String errorBuild(String material, WorldEntity building) {
		return "Not enough " + material + " to build a " + building.toString();
	}
	
	
}