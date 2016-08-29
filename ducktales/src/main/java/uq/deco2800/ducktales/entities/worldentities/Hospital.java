package uq.deco2800.ducktales.entities.worldentities;

import uq.deco2800.ducktales.resources.ResourceType;

/**
 * A Hospital.
 * 
 * @author Gabrielle Hodge, 43590526 
 *
 */
public class Hospital extends Building{
	

	// Building type, time to build, resources required to build

	private static final ResourceType TYPE = ResourceType.HOSPITAL;

	public Hospital(double x, double y) {
		super(x, y, 2, 2, TYPE);
		Building.STONERESOURCES = 12;
		Building.WOODRESOURCES = 8;
		Building.TIME = 5;
	}

	@Override
	public void tick() {
	}

}
