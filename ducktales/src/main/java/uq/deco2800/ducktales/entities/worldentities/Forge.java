package uq.deco2800.ducktales.entities.worldentities;

import uq.deco2800.ducktales.resources.ResourceType;

/**
 * A Forge.
 * 
 * @author Gabrielle Hodge, 43590526 
 *
 */
public class Forge extends WorldEntity {
	

	// Building type, time to build, resources required to build

	private static final ResourceType TYPE = ResourceType.FORGE;

	public Forge(double x, double y) {
		super(x, y, 2, 2, TYPE);
	}
	
	protected void specifications() {
		WorldEntity.STONERESOURCES = 10;
		WorldEntity.WOODRESOURCES = 6;
		WorldEntity.TIME = 3;
	}

	@Override
	public void tick() {
	}
}
