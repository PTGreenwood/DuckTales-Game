package uq.deco2800.ducktales.entities.worldentities;

import uq.deco2800.ducktales.resources.ResourceType;

/**
 * A Sawmill.
 * @author 
 *
 */
public class Sawmill extends WorldEntity{
	
	private final static ResourceType TYPE = ResourceType.SAWMILL;
	
	private final static int TIME = 3;
	
	private final static int resourcesToBuild = 10;

	public Sawmill(double x, double y) {
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
