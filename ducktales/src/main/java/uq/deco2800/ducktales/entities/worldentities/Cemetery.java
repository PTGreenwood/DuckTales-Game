package uq.deco2800.ducktales.entities.worldentities;

/**
 * A Cemetery.
 * 
 * @author Gabrielle Hodge, 43590526 
 *
 */
public class Cemetery extends WorldEntity{
	
	// Building type, time to build, resources required to build
	private static final String TYPE = "cemetery";
	
	private static final int TIME = 2;
	
	private static final int BUILDRESOURCES = 7;

	public Cemetery(double x, double y) {
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
	 * resources required to construct the cemetery.
	 * 
	 * @return the number of resources required to construct a cemetery
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
