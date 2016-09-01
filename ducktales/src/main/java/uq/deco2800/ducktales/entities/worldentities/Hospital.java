package uq.deco2800.ducktales.entities.worldentities;

import uq.deco2800.ducktales.resources.ResourceType;

/**
 * A Hospital.
 * 
 * @author Gabrielle Hodge, 43590526 
 *
 */
public class Hospital extends WorldEntity {
	

	// Building type, time to build, resources required to build

	private static final ResourceType TYPE = ResourceType.HOSPITAL;

	public Hospital(double x, double y) {
		super(x, y, 2, 2, TYPE);
	}
	
	protected void specifications() {
		WorldEntity.STONERESOURCES = 12;
		WorldEntity.WOODRESOURCES = 8;
		WorldEntity.TIME = 5;
	}

	@Override
	public void tick() {
	}

}
