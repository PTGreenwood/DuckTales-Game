package uq.deco2800.ducktales.entities;

/**
 * A Sawmill.
 * @author 
 *
 */
public class Forge extends WorldEntity{
	
	private final static String TYPE = "forge";
	
	private final static int TIME = 3;
	
	private final static int resourcesToBuild = 16;

	public Forge(double x, double y) {
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
