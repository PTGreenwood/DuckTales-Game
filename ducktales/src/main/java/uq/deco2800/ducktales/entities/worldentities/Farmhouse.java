package uq.deco2800.ducktales.entities.worldentities;

/**
 * A Sawmill.
 * @author 
 *
 */
public class Farmhouse extends WorldEntity{
	
	private final static String TYPE = "farmhouse";
	
	private final static int TIME = 9;
	
	private final static int resourcesToBuild = 18;

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
	
	public int resourcesBuild() {
		return resourcesToBuild;

	}
	
	public int resourcesReturn() {
		return (int) (0.5*resourcesToBuild);
	}

}
