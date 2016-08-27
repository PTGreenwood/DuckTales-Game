package uq.deco2800.ducktales.entities.worldentities;

import uq.deco2800.ducktales.resources.ResourceType;

/**
 * An Observatory.
 * 
 * @author Gabrielle Hodge, 43590526 
 *
 */
public class Observatory extends WorldEntity{
	

	// Building type, time to build, resources required to build
	//private static final String TYPE = "observatory";

	private final static ResourceType TYPE = ResourceType.OBSERVATORY;
	
	private static final int TIME = 5;
	
	private static final int BUILDRESOURCES = 12;

	public Observatory(double x, double y) {
		super(x, y, 2, 2, TYPE);
	}

	@Override
	public void tick() {
	}

	@Override
	public boolean isPassable() {
		return false;
	}
	
	public int timeToBuild() {
		return TIME;
	}
	
	/**
	 * Public method to access and return the integer representation of the 
	 * resources required to construct the observatory.
	 * 
	 * @return the number of resources required to construct an observatory
	 */
	public int resourcesBuild() {
		return BUILDRESOURCES;

	}
	
	/**
	 * Public method to access and return the integer representation of the 
	 * resources returned when a building is selected to be destroyed by the 
	 * user. Will return half of the resources required to construct.
	 * 
	 * @return the number of resources refunded when demolished
	 */
	public int resourcesReturn() {
		return (int) (0.5*BUILDRESOURCES);
	}

}
