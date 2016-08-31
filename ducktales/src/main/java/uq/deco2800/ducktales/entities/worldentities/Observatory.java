package uq.deco2800.ducktales.entities.worldentities;

import uq.deco2800.ducktales.resources.ResourceType;

/**
 * An Observatory.
 * 
 * @author Gabrielle Hodge, 43590526 
 *
 */
public class Observatory extends WorldEntity {

	// Building type, time to build, resources required to build

	private static final ResourceType TYPE = ResourceType.OBSERVATORY;

	public Observatory(double x, double y) {
		super(x, y, 2, 2, TYPE);
	}
	
	protected void specifications() {
		WorldEntity.STONERESOURCES = 4;
		WorldEntity.WOODRESOURCES = 10;
		WorldEntity.TIME = 5;
	}

	@Override
	public void tick() {
	}
}
