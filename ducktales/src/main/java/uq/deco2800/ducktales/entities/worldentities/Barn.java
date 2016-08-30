package uq.deco2800.ducktales.entities.worldentities;

import uq.deco2800.ducktales.resources.ResourceType;

/**
 * A Barn.
 * 
 * @author Gabrielle Hodge, 43590526 
 *
 */
public class Barn extends WorldEntity {
	

	// Building type

	private static final ResourceType TYPE = ResourceType.BARN;
	
	
	// Initiates a new Barn, and sets the required instance variables
	// for a barn
	public Barn(double x, double y) {
		super(x, y, 2, 2, TYPE);
		WorldEntity.STONERESOURCES = 4;
		WorldEntity.WOODRESOURCES = 10;
		WorldEntity.TIME = 9;
	}

	@Override
	public void tick() {
	}

	@Override
	public boolean isPassable() {
		return false;
	}
}
