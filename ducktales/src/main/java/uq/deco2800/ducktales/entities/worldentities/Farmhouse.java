package uq.deco2800.ducktales.entities.worldentities;

/**
 * A Farmhouse.
 * 
 * @author Gabrielle Hodge, 43590526 
 *
 */
public class Farmhouse extends WorldEntity{
	
	// Building type, time to build, resources required to build
	private static final String TYPE = "farmhouse";
	
	private static final int TIME = 9;
	
	private static final int BUILDRESOURCES = 18;

	public Farmhouse(double x, double y) {
		super(x, y, 4, 4, TYPE);
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
	 * resources required to construct the farmhouse.
	 * 
	 * @return the number of resources required to construct a farmhouse
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
