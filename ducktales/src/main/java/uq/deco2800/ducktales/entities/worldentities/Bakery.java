package uq.deco2800.ducktales.entities.worldentities;

import uq.deco2800.ducktales.resources.ResourceType;
import static uq.deco2800.ducktales.resources.ResourceType.*;

/**
 * A Sawmill.
 * @author 
 *
 */
public class Bakery extends WorldEntity{
	
	private final static ResourceType TYPE = BAKERY;
	
	private final static int TIME = 4;
	
	private final static int resourcesToBuild = 14;

	public Bakery(double x, double y) {
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
