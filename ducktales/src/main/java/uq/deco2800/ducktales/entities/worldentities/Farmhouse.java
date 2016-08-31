package uq.deco2800.ducktales.entities.worldentities;

import uq.deco2800.ducktales.resources.ResourceType;

/**
 * A Farmhouse.
 * 
 * @author Gabrielle Hodge, 43590526 
 *
 */
public class Farmhouse extends WorldEntity {
	

	// Building type, time to build, resources required to build

	private static final ResourceType TYPE = ResourceType.FARMHOUSE;

	public Farmhouse(double x, double y) {
		super(x, y, 2, 2, TYPE);
	}
	
	protected void specifications() {
		WorldEntity.STONERESOURCES = 8;
		WorldEntity.WOODRESOURCES = 10;
		WorldEntity.TIME = 9;
	}

	@Override
	public void tick() {
	}
}
