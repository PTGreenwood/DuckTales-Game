package uq.deco2800.ducktales.entities.worldentities;

import uq.deco2800.ducktales.resources.ResourceType;

/**
 * A Sawmill.
 * @author 
 *
 */
public class Cemetery extends WorldEntity{
	
	private final static ResourceType TYPE = ResourceType.CEMETERY;
	
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
