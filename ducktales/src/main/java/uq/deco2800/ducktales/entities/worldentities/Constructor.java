package uq.deco2800.ducktales.entities.worldentities;

import uq.deco2800.ducktales.entities.worldentities.*;

/**
 * A Construction Interface to select Buildings.
 * 
 * @author Gabrielle Hodge, 43590526
 *
 */

public class Constructor {
	
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
	
	private int getStone(WorldEntity building) {
		return building.resourcesBuildStone();
	}
	
	private int getWood(WorldEntity building) {
		return building.resourcesBuildWood();
	}
	
	private int getTime(WorldEntity building) {
		return building.timeToBuild();
	}
	
	public String errorBuild(String material, WorldEntity building) {
		return "Not enough " + material + " to build a " + building.toString();
	}
	
	
}