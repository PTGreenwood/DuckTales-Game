package uq.deco2800.ducktales.entities.worldentities;

import uq.deco2800.ducktales.resources.ResourceType;
import static uq.deco2800.ducktales.resources.ResourceType.*;

/**
 * A Bakery.
 * 
 * @author Gabrielle Hodge, 43590526
 *
 */
public class Bakery extends Building{
	
	// Building type, time to build, resources required to build

	private static final ResourceType TYPE = BAKERY;
	
	public Bakery(double x, double y) {
		super(x, y, 2, 2, TYPE);
		Building.STONERESOURCES = 4;
		Building.WOODRESOURCES = 6;
		Building.TIME = 4;
	}

	@Override
	public void tick() {
	}

	@Override
	public boolean isPassable() {
		return false;
	}
	
}
