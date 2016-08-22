package uq.deco2800.ducktales.entities.worldentities;

/**
 * A Sawmill.
 * @author 
 *
 */
public class Observatory extends WorldEntity{
	
	private final static String TYPE = "observatory";
	
	private final static int TIME = 5;
	
	private final static int resourcesToBuild = 12;

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
	
	public int resourcesBuild() {
		return resourcesToBuild;

	}
	
	public int resourcesReturn() {
		return (int) (0.5*resourcesToBuild);
	}

}
