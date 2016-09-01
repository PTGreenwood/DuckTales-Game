package uq.deco2800.ducktales.entities.worldentities;

import uq.deco2800.ducktales.resources.ResourceType;

/**
 * A Sawmill.
 * 
 * @author Gabrielle Hodge, 43590526 
 *
 */
public class Sawmill extends WorldEntity {
	
	// Building type, time to build, resources required to build

	private static final ResourceType TYPE = ResourceType.SAWMILL;

	public Sawmill(double x, double y) {
		super(x, y, 2, 2, TYPE);
	}

	protected void specifications() {
		WorldEntity.STONERESOURCES = 4;
		WorldEntity.WOODRESOURCES = 8;
		WorldEntity.TIME = 3;
	}
	
	@Override
	public void tick() {
	}

}
