package uq.deco2800.ducktales.entities;

/**
 * A Sawmill.
 * 
 * @author Gabrielle Hodge, 43590526 
 *
 */
public class Hospital extends WorldEntity{
	
	private final static String TYPE = "hospital";
	
	private final static int TIME = 5;
	
	private final static int resourcesToBuild = 17;

	public Hospital(double x, double y) {
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
	
	public int resourcesBuild() {
		return resourcesToBuild;

	}
	
	public int resourcesReturn() {
		return (int) (0.5*resourcesToBuild);
	}

}
