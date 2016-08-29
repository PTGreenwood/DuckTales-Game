package uq.deco2800.ducktales.entities.worldentities;

import uq.deco2800.ducktales.resources.ResourceType;

/**
 * A Forge.
 * 
 * @author Gabrielle Hodge, 43590526 
 *
 */
public class Forge extends Building{
	

	// Building type, time to build, resources required to build

	private static final ResourceType TYPE = ResourceType.FORGE;

	public Forge(double x, double y) {
		super(x, y, 2, 2, TYPE);
		Building.STONERESOURCES = 10;
		Building.WOODRESOURCES = 6;
		Building.TIME = 3;
	}

	@Override
	public void tick() {
	}
}
