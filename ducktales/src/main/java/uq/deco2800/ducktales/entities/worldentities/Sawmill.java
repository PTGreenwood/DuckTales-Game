package uq.deco2800.ducktales.entities.worldentities;

/**
 * A Sawmill.
 * @author 
 *
 */
public class Sawmill extends WorldEntity{
	
	private final static String TYPE = "sawmill";
	
	private final static int TIME = 3;
	
	private final static int resourcesToBuild = 10;

	public Sawmill(double x, double y) {
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
