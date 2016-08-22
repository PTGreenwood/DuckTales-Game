package uq.deco2800.ducktales.entities;

/**
 * A House.
 * @author Leggy
 *
 */
public class House extends WorldEntity{
	
	private final static String TYPE = "house";
	
	private final static int TIME = 2;
	
	private final static int resourcesToBuild = 5;

	public House(double x, double y) {
		super(x, y, 3, 3, TYPE);
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
