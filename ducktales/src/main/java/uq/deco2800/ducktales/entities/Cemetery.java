package uq.deco2800.ducktales.entities;

/**
 * A Sawmill.
 * @author 
 *
 */
public class Cemetery extends WorldEntity{
	
	private final static String TYPE = "cemetery";
	
	private final static int TIME = 2;
	
	private final static int resourcesToBuild = 7;

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
	
	public int resourcesBuild() {
		return resourcesToBuild;

	}
	
	public int resourcesReturn() {
		return (int) (0.5*resourcesToBuild);
	}

}
