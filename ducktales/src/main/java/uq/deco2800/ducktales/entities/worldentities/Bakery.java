package uq.deco2800.ducktales.entities.worldentities;

import uq.deco2800.ducktales.resources.ResourceType;
import static uq.deco2800.ducktales.resources.ResourceType.*;

/**
 * A Bakery.
 * 
 * @author Gabrielle Hodge, 43590526
 *
 */
public class Bakery extends WorldEntity{
	
	// Building type, time to build, resources required to build

	private static final ResourceType TYPE = BAKERY;
	
	public Bakery(double x, double y) {
		super(x, y, 2, 2, TYPE);
		WorldEntity.STONERESOURCES = 4;
		WorldEntity.WOODRESOURCES = 6;
		WorldEntity.TIME = 4;
	}

	@Override
	public void tick() {
	}

	@Override
	public boolean isPassable() {
		return false;
	}
	
}
