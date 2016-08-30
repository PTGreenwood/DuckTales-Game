package uq.deco2800.ducktales.entities.worldentities;

import uq.deco2800.ducktales.resources.ResourceType;

/**
 * A Cemetery.
 * 
 * @author Gabrielle Hodge, 43590526 
 *
 */
public class Cemetery extends WorldEntity {
	

	// Building type, time to build, resources required to build

	private static final ResourceType TYPE = ResourceType.CEMETERY;

	public Cemetery(double x, double y) {
		super(x, y, 2, 2, TYPE);
		WorldEntity.STONERESOURCES = 2;
		WorldEntity.WOODRESOURCES = 4;
		WorldEntity.TIME = 2;
	}

	@Override
	public void tick() {
	}

}
